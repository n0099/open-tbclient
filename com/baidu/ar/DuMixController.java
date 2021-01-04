package com.baidu.ar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.ar.ability.AbilityType;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.core.pixel.IPixelReader;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.arrender.l;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IDuMixAuthCallback;
import com.baidu.ar.auth.IOfflineAuthenticator;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.content.IContentPlatform;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.filter.IFilter;
import com.baidu.ar.h.n;
import com.baidu.ar.libloader.ILibLoaderPlugin;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.photo.IPhoto;
import com.baidu.ar.photo.PhotoCallback;
import com.baidu.ar.record.IRecord;
import com.baidu.ar.record.RecordCallback;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.steploading.IStepLoading;
import com.kwai.sodler.lib.ext.PluginError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class DuMixController implements IDuMix, IPixelReader, IFilter, IPhoto, IRecord {
    private static volatile DuMixController aM = null;
    private static volatile int aW = 0;
    private static volatile Object sLock = new Object();
    private com.baidu.ar.filter.a B;
    private DuMixInput V;
    private DuMixOutput W;
    private HandlerThread aN;
    private Handler aO;
    private Handler aP;
    private DuMixCallback aQ;
    private e aR;
    private com.baidu.ar.lua.e aS;
    private OrientationManager aT;
    private com.baidu.ar.record.a aU;
    private IContentPlatform aV;
    protected DuMixCallback aa;
    private b ad;
    private DefaultParams d;
    private com.baidu.ar.lua.b f;
    private com.baidu.ar.arrender.c g;
    private Context mContext;
    private com.baidu.ar.a.b w;

    /* loaded from: classes6.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 3000:
                    DuMixController.this.R();
                    return;
                case 3001:
                    DuMixController.this.T();
                    return;
                case 3002:
                    DuMixController.this.U();
                    return;
                case 3003:
                    DuMixController.this.V();
                    return;
                case 3004:
                    DuMixController.this.a((CaseModel) message.obj);
                    return;
                case PluginError.ERROR_INS_CAPACITY /* 3005 */:
                    DuMixController.this.W();
                    return;
                case PluginError.ERROR_INS_INSTALL_PATH /* 3006 */:
                    if (DuMixController.this.g != null) {
                        DuMixController.this.g.changeOutputSize(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 3007:
                    DuMixController.this.W = (DuMixOutput) message.obj;
                    if (DuMixController.this.g != null) {
                        DuMixController.this.g.changeOutput(DuMixController.this.W);
                        return;
                    }
                    return;
                case 3008:
                    if (DuMixController.this.g != null) {
                        DuMixController.this.g.pauseScene();
                        return;
                    }
                    return;
                case 3009:
                    if (DuMixController.this.g != null) {
                        DuMixController.this.g.resumeScene();
                        return;
                    }
                    return;
                case 3010:
                    if (DuMixController.this.g != null) {
                        DuMixController.this.g.a(message.obj, message.arg1, message.arg2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private DuMixController(Context context, DefaultParams defaultParams) {
        this.mContext = context;
        if (defaultParams != null) {
            this.d = defaultParams;
        } else {
            this.d = new DefaultParams();
        }
        com.baidu.ar.h.b.c("DuMixController", "create DuMixController sState = " + aW);
        if (aW == 3) {
            synchronized (sLock) {
                try {
                    com.baidu.ar.h.b.c("DuMixController", "create DuMixController wait for release!");
                    sLock.wait(IMConnection.RETRY_DELAY_TIMES);
                } catch (Exception e) {
                    com.baidu.ar.h.b.b("DuMixController", "create DuMixController wait error!!!");
                }
            }
        }
        this.aN = new HandlerThread("DuMixController");
        this.aN.start();
        this.aO = new a(this.aN.getLooper());
        com.baidu.ar.c.c.cd().a(this.aN.getLooper());
        a(this.mContext, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        com.baidu.ar.h.b.c("DuMixController", "handleSetup() sState = " + aW);
        if (aW != 0 || this.aR == null || this.g == null || this.B == null || this.ad == null || this.w == null) {
            return;
        }
        aW = 1;
        this.aQ = S();
        this.aR.a(this.g, this.ad, this.B, this.f);
        this.aR.setup(this.V, this.W, this.aQ);
        StatisticApi.setPubParam(StatisticConstants.FRAME_DATA_FROM, this.V.isCameraInput() ? PixelReadParams.DEFAULT_FILTER_ID : "video");
        StatisticApi.onEventStart(StatisticConstants.EVENT_SDK_START);
        this.aT.addOrientationListener(this.g);
        this.aT.enable();
        this.B.a(this.g);
        if (this.w != null) {
            JSONObject af = this.w.af();
            if (af != null) {
                this.g.a(af);
            } else {
                this.g.setLocalDeviceGrade(this.w.ag());
            }
        }
        this.ad.a(this.f, this.g);
        this.g.a(this.V, this.W);
        this.aR.a(this.w);
        this.aR.E();
    }

    private DuMixCallback S() {
        return new DuMixCallback() { // from class: com.baidu.ar.DuMixController.1
            @Override // com.baidu.ar.DuMixCallback
            public void onCaseCreate(final boolean z, final String str, final String str2) {
                if (DuMixController.this.aP != null) {
                    DuMixController.this.aP.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.aa != null) {
                                DuMixController.this.aa.onCaseCreate(z, str, str2);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseDestroy() {
                if (DuMixController.this.aP != null) {
                    DuMixController.this.aP.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.aa != null) {
                                DuMixController.this.aa.onCaseDestroy();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onError(final DuMixErrorType duMixErrorType, final String str, final String str2) {
                if (DuMixController.this.aP != null) {
                    DuMixController.this.aP.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.aa != null) {
                                DuMixController.this.aa.onError(duMixErrorType, str, str2);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onRelease() {
                com.baidu.ar.h.b.c("DuMixController", "getDuMixCallbackProxy onRelease sState = " + DuMixController.aW);
                int unused = DuMixController.aW = 0;
                synchronized (DuMixController.sLock) {
                    try {
                        DuMixController.sLock.notifyAll();
                    } catch (Exception e) {
                        com.baidu.ar.h.b.c("DuMixController", "onRelease normal!!!");
                    }
                }
                if (DuMixController.this.aP != null) {
                    DuMixController.this.aP.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.aa != null) {
                                DuMixController.this.aa.onRelease();
                                DuMixController.this.aa = null;
                            }
                        }
                    });
                    DuMixController.this.aP = null;
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onSetup(final boolean z, final DuMixInput duMixInput, final DuMixOutput duMixOutput) {
                com.baidu.ar.h.b.c("DuMixController", "getDuMixCallbackProxy onSetup sState = " + DuMixController.aW);
                if (z) {
                    int unused = DuMixController.aW = 2;
                }
                if (DuMixController.this.aR != null) {
                    DuMixController.this.aR.F();
                }
                if (DuMixController.this.aP != null) {
                    DuMixController.this.aP.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.aa != null) {
                                com.baidu.ar.h.b.c("DuMixController", "mDuMixCallback.onSetup()");
                                DuMixController.this.aa.onSetup(z, duMixInput, duMixOutput);
                            }
                        }
                    });
                }
                synchronized (DuMixController.sLock) {
                    try {
                        DuMixController.sLock.notifyAll();
                    } catch (Exception e) {
                        com.baidu.ar.h.b.c("DuMixController", "onSetup normal!!!");
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (aW != 2) {
            return;
        }
        if (this.ad != null) {
            this.ad.pause();
        }
        if (this.g != null) {
            this.g.pause();
        }
        if (this.aT != null) {
            this.aT.disable();
        }
        StatisticApi.pause();
        if (this.aR != null) {
            this.aR.l("pause");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (aW != 2) {
            return;
        }
        if (this.aR != null) {
            this.aR.l("resume");
        }
        StatisticApi.resume();
        if (this.aT != null) {
            this.aT.enable();
        }
        if (this.g != null) {
            this.g.resume();
        }
        if (this.ad != null) {
            this.ad.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        com.baidu.ar.h.b.c("DuMixController", "handleRelease() sState = " + aW);
        if (this.aO != null) {
            this.aO.removeCallbacksAndMessages(null);
            this.aO = null;
        }
        this.aV = null;
        if (this.aR != null) {
            this.aR.A();
        }
        if (this.aS != null) {
            this.aS.release();
            this.aS = null;
        }
        if (this.B != null) {
            this.B.clearAllFilter();
            this.B.release();
            this.B = null;
        }
        if (this.ad != null) {
            this.ad.release();
            this.ad = null;
        }
        if (this.g != null) {
            this.g.release();
            this.g = null;
        }
        if (this.aT != null) {
            this.aT.destroy();
            this.aT = null;
        }
        if (this.w != null) {
            this.w.release();
            this.w = null;
        }
        com.baidu.ar.libloader.a.release();
        ARAuth.release();
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        StatisticApi.onEventEnd(StatisticConstants.EVENT_SDK_END);
        StatisticApi.release();
        if (this.f != null) {
            this.f.destroy();
            this.f = null;
        }
        if (this.aR != null) {
            this.aR.release();
            this.aR = null;
        }
        this.V = null;
        this.W = null;
        this.d = null;
        this.aQ = null;
        this.mContext = null;
        com.baidu.ar.h.b.c("DuMixController", "handleRelease() end");
        if (this.aN != null) {
            this.aN.quitSafely();
            this.aN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (this.aR == null || aW != 2) {
            com.baidu.ar.h.b.b("DuMixController", "handleClearCase DuMix has not setup!!!!!!");
        } else {
            this.aR.clearCase();
        }
    }

    private void a(Context context, DefaultParams defaultParams) {
        com.baidu.ar.h.b.c("DuMixController", "createManagers start!!!");
        if (this.aP == null) {
            this.aP = new Handler(context.getMainLooper());
        }
        com.baidu.ar.h.b.T(defaultParams.isLogEnable());
        com.baidu.ar.h.a.setPackageName(context.getPackageName());
        if (this.aT == null) {
            this.aT = new OrientationManager(context);
        }
        StatisticApi.init(context);
        if (this.aR == null) {
            this.aR = new e(context, defaultParams, this.aN);
            this.aR.a(this);
        }
        if (this.w == null) {
            this.w = new com.baidu.ar.a.b(context);
            this.w.c(defaultParams.getGradingConfig());
        }
        if (this.B == null) {
            this.B = new com.baidu.ar.filter.a(defaultParams);
            this.ad = new b(context, this.aN.getLooper(), defaultParams, this.w, this.B);
        }
        if (this.f == null) {
            this.f = new com.baidu.ar.lua.b(context);
            this.f.setUserPlayAudio(defaultParams.isUserPlayAudio());
        }
        if (this.g == null) {
            if (defaultParams.isUseTextureIO()) {
                this.g = new com.baidu.ar.arrender.d(context, this.aN.getLooper(), this.f, defaultParams.getShareContext(), defaultParams.get3dShaderDBPath());
            } else {
                this.g = new com.baidu.ar.arrender.c(context, this.aN.getLooper(), this.f, defaultParams.get3dShaderDBPath());
            }
            if (!TextUtils.isEmpty(defaultParams.getRenderPipeline())) {
                this.g.setDefaultPipeLine(defaultParams.getRenderPipeline());
            }
        }
        com.baidu.ar.h.b.c("DuMixController", "createManagers end!!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CaseModel caseModel) {
        if (this.aR != null && aW == 2) {
            this.aR.loadCase(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
            return;
        }
        com.baidu.ar.h.b.b("DuMixController", "handleLoadCase DuMix has not setup!!!!!!");
        if (this.aQ != null) {
            this.aQ.onCaseCreate(false, caseModel.mCasePath, caseModel.mCaseId);
        }
    }

    public static IAuthenticator getAsyncAuthenticator(String str, String str2, String str3) {
        return com.baidu.ar.auth.a.getAsyncAuthenticator(str, str2, str3);
    }

    public static IAuthenticator getAuthenticator() {
        return com.baidu.ar.auth.a.getAuthenticator();
    }

    public static DuMixController getInstance(Context context, DefaultParams defaultParams) {
        if (context == null) {
            com.baidu.ar.h.b.b("DuMixController", "getInstance() context must be set!!!");
            return null;
        }
        if (aM == null) {
            synchronized (DuMixController.class) {
                if (aM == null) {
                    aM = new DuMixController(context, defaultParams);
                }
            }
        }
        return aM;
    }

    public static IOfflineAuthenticator getOfflineAuthenticator() {
        return com.baidu.ar.auth.a.getOfflineAuthenticator();
    }

    public static String getSoDownLoadDir(Context context) {
        return e.getSoDownLoadDir(context);
    }

    public static int getVersionCode() {
        return com.baidu.ar.h.c.getVersionCode();
    }

    public static String getVersionName() {
        return com.baidu.ar.h.c.getVersionName();
    }

    public boolean addAbility(String str, String str2) {
        return addAbility(str, str2, null);
    }

    public boolean addAbility(String str, String str2, String str3) {
        if (this.ad != null) {
            return this.ad.a(str, Arrays.asList(str2), str3);
        }
        return false;
    }

    public boolean addAbility(String str, List<String> list) {
        if (this.ad != null) {
            return this.ad.a(str, list, (String) null);
        }
        return false;
    }

    @Override // com.baidu.ar.IDuMix
    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        if (this.g != null) {
            this.g.addFrameRenderListener(frameRenderListener);
        }
    }

    public boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        if (this.f == null || this.f.fk() == null) {
            return false;
        }
        return this.f.fk().addLuaMsgListener(luaMsgListener);
    }

    @Override // com.baidu.ar.IDuMix
    public void addOutput(DuMixOutput duMixOutput) {
        if (this.g != null) {
            this.g.addOutputSurface(duMixOutput);
        }
    }

    public boolean adjustAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.ad == null || abilityType == null || aW != 2) {
            return false;
        }
        return this.ad.adjustAbility(abilityType.getTypeValue(), hashMap);
    }

    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        if (this.ad == null || TextUtils.isEmpty(str) || aW != 2) {
            return false;
        }
        return this.ad.adjustAbility(str, hashMap);
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(int i, int i2) {
        com.baidu.ar.h.b.c("DuMixController", "changeInputSize width * height = " + i + " * " + i2);
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(3010, i, i2, null));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(SurfaceTexture surfaceTexture, int i, int i2) {
        com.baidu.ar.h.b.c("DuMixController", "changeInputSize width * height = " + i + " * " + i2 + " && texture = " + surfaceTexture);
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(3010, i, i2, surfaceTexture));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutput(DuMixOutput duMixOutput) {
        if (duMixOutput == null || this.aO == null) {
            return;
        }
        this.aO.sendMessage(this.aO.obtainMessage(3007, duMixOutput));
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutputObject(Object obj, int i, int i2) {
        if (obj == null || this.g == null) {
            return;
        }
        this.g.b(obj, i, i2);
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutputSize(int i, int i2) {
        com.baidu.ar.h.b.c("DuMixController", "changeOutputSize width * height = " + i + " * " + i2);
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(PluginError.ERROR_INS_INSTALL_PATH, i, i2));
        }
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        return ARAuth.checkAuth(this.mContext, bArr, iDuMixAuthCallback);
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        return ARAuth.checkAuth(this.mContext, bArr, iCallbackWith, iCallbackWith2);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void clearAllFilter() {
        if (this.B == null || aW != 2) {
            return;
        }
        this.B.clearAllFilter();
    }

    @Override // com.baidu.ar.IDuMix
    public void clearCase() {
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(PluginError.ERROR_INS_CAPACITY));
        }
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if ((aW == 0 || aW == 1) && this.aR != null) {
            this.aR.a(pixelReadParams, pixelReadListener);
        } else if (aW != 2 || this.g == null) {
        } else {
            this.g.createPixelReader(pixelReadParams, pixelReadListener);
        }
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        if (this.g != null) {
            this.g.destroyPixelReader(pixelReadParams, pixelReadListener);
        }
    }

    public ARProxyManager getARProxyManager() {
        if (this.ad != null) {
            return this.ad.getARProxyManager();
        }
        return null;
    }

    public l getARRenderer() {
        if (this.g == null || !(this.g instanceof l)) {
            return null;
        }
        return this.g;
    }

    public List<String> getActiveAbilities() {
        if (this.ad == null || aW != 2) {
            return null;
        }
        return this.ad.getActiveAbilities();
    }

    public IContentPlatform getContentPlatform() {
        if (this.aV == null) {
            this.aV = (IContentPlatform) n.a("com.baidu.ar.content.ContentCloud", new Class[]{Context.class}, new Object[]{this.mContext});
        }
        return this.aV;
    }

    public IGLRenderer getGLRenderer() {
        if (this.g == null || !(this.g instanceof IGLRenderer)) {
            return null;
        }
        return (IGLRenderer) this.g;
    }

    public IStepLoading getStepLoading() {
        if (this.g != null) {
            return this.g.bA();
        }
        return null;
    }

    public List<String> getSupportedAbilities() {
        if (this.ad == null || aW != 2) {
            return null;
        }
        return this.ad.getSupportedAbilities();
    }

    public boolean isAbilityActive(AbilityType abilityType) {
        if (this.ad == null || abilityType == null || aW != 2) {
            return false;
        }
        return this.ad.isAbilityActive(abilityType.getTypeValue());
    }

    public boolean isAbilityActive(String str) {
        if (this.ad == null || TextUtils.isEmpty(str) || aW != 2) {
            return false;
        }
        return this.ad.isAbilityActive(str);
    }

    public boolean isAbilitySupported(String str) {
        if (this.ad == null || aW != 2) {
            return false;
        }
        return this.ad.isAbilitySupported(str);
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(ARType aRType, String str, String str2) {
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(3004, new CaseModel(aRType, str, str2)));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.g == null || aW != 2) {
            return false;
        }
        return this.g.onTouch(view, motionEvent);
    }

    @Override // com.baidu.ar.IDuMix
    public void pause() {
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(3001));
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (this.aU == null || aW != 2) {
            return;
        }
        this.aU.pauseRecord();
    }

    @Override // com.baidu.ar.IDuMix
    public void pauseScene() {
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(3008));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void release() {
        com.baidu.ar.h.b.c("DuMixController", "release() sState = " + aW);
        if (aW == 1) {
            if (this.g == null || !this.g.bE()) {
                synchronized (sLock) {
                    try {
                        com.baidu.ar.h.b.c("DuMixController", "release DuMixController wait for setup!");
                        sLock.wait(IMConnection.RETRY_DELAY_TIMES);
                    } catch (Exception e) {
                        com.baidu.ar.h.b.b("DuMixController", "release DuMixController wait error!!!");
                    }
                }
            } else {
                this.g.q(true);
                aW = 0;
                aM = null;
            }
        }
        if (aW == 0) {
            aM = null;
        } else if (aW != 3) {
            if (aW != 2) {
                com.baidu.ar.h.b.b("DuMixController", "release error!!!");
                return;
            }
            aW = 3;
            if (this.aO != null) {
                this.aO.removeCallbacksAndMessages(null);
                this.aO.sendMessage(this.aO.obtainMessage(3003));
            }
            aM = null;
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        if (this.g != null) {
            this.g.removeFrameRenderListener(frameRenderListener);
        }
    }

    public boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        if (this.f == null || this.f.fk() == null) {
            return false;
        }
        return this.f.fk().removeLuaMsgListener(luaMsgListener);
    }

    @Override // com.baidu.ar.IDuMix
    public void removeOutput(DuMixOutput duMixOutput) {
        if (this.g != null) {
            this.g.removeOutputSurface(duMixOutput);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void resetAllFilter() {
        if (this.B == null || aW != 2) {
            return;
        }
        this.B.resetAllFilter();
    }

    @Override // com.baidu.ar.IDuMix
    public void resume() {
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(3002));
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.aU == null || aW != 2) {
            return;
        }
        this.aU.resumeRecord();
    }

    @Override // com.baidu.ar.IDuMix
    public void resumeScene() {
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(3009));
        }
    }

    public boolean sendLuaScript2Engine(String str) {
        if (this.f == null || aW != 2) {
            return false;
        }
        this.f.aw(str);
        return true;
    }

    public boolean sendMsg2Lua(HashMap<String, Object> hashMap) {
        if (this.f == null || aW != 2) {
            return false;
        }
        this.f.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        return true;
    }

    public void setARRenderFpsCallback(ARRenderFpsCallback aRRenderFpsCallback) {
        if (this.g != null) {
            this.g.setARRenderFpsCallback(aRRenderFpsCallback);
        }
    }

    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        ARAuth.setAuthLicense(bArr, str, str2, str3);
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        if (this.aS == null) {
            this.aS = new com.baidu.ar.lua.e(this.f);
        }
        this.aS.setDefinedLuaListener(definedLuaListener);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void setFilterStateListener(FilterStateListener filterStateListener) {
        if (this.B != null) {
            this.B.setFilterStateListener(filterStateListener);
        }
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.g != null) {
            this.g.setGLWebViewUseable(context, viewGroup);
        }
    }

    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        com.baidu.ar.libloader.a.setLibLoadPlugin(iLibLoaderPlugin);
    }

    public void setMdlModelPath(String str) {
        if (this.ad != null) {
            this.ad.setMdlModelPath(str);
        }
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.g != null) {
            this.g.setNativeWebViewUseable(context, viewGroup);
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void setRecordWatermark(Watermark watermark) {
        if (aW == 2) {
            if (this.aU == null && this.g != null) {
                this.aU = new com.baidu.ar.record.a(this.mContext, this.g);
            }
            if (this.aU != null) {
                this.aU.setRecordWatermark(watermark);
            }
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void setStateListener(DuMixStateListener duMixStateListener) {
        if (this.g != null) {
            this.g.setStateListener(duMixStateListener);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        com.baidu.ar.h.b.c("DuMixController", "setup() sState = " + aW);
        if (duMixInput == null || duMixOutput == null) {
            com.baidu.ar.h.b.b("DuMixController", "setup error!!! params maybe null!!!");
            if (duMixCallback != null) {
                duMixCallback.onSetup(false, duMixInput, duMixOutput);
                return;
            }
            return;
        }
        this.V = duMixInput;
        this.W = duMixOutput;
        this.aa = duMixCallback;
        if (this.aO != null) {
            this.aO.sendMessage(this.aO.obtainMessage(3000));
        }
    }

    public boolean startAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.ad == null || abilityType == null || aW != 2) {
            return false;
        }
        return this.ad.a(abilityType.getTypeValue(), hashMap, true);
    }

    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        if (this.ad == null || TextUtils.isEmpty(str) || aW != 2) {
            return false;
        }
        return this.ad.a(str, hashMap, true);
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        if (aW == 2) {
            if (this.aU == null && this.g != null) {
                this.aU = new com.baidu.ar.record.a(this.mContext, this.g);
            }
            if (this.aR != null) {
                this.aR.k("start");
            }
            if (this.aU != null) {
                if (this.W != null && this.d != null && this.d.isRecordAutoCrop()) {
                    this.aU.j(this.W.getOutputWidth(), this.W.getOutputHeight());
                }
                this.aU.startRecord(str, j, recordCallback);
            }
        }
    }

    public boolean stopAbility(AbilityType abilityType) {
        if (this.ad == null || abilityType == null || aW != 2) {
            return false;
        }
        return this.ad.a(abilityType.getTypeValue(), true);
    }

    public boolean stopAbility(String str) {
        if (this.ad == null || TextUtils.isEmpty(str) || aW != 2) {
            return false;
        }
        return this.ad.a(str, true);
    }

    @Override // com.baidu.ar.record.IRecord
    public void stopRecord() {
        if (aW == 2) {
            if (this.aU != null) {
                this.aU.stopRecord();
                this.aU = null;
            }
            if (this.aR != null) {
                this.aR.k("stop");
            }
        }
    }

    @Override // com.baidu.ar.photo.IPhoto
    public void takePicture(String str, PhotoCallback photoCallback) {
        if (this.g == null || aW != 2) {
            return;
        }
        new com.baidu.ar.photo.a().a(this.g, str, photoCallback);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float f) {
        if (this.B == null || aW != 2) {
            return;
        }
        this.B.a(filterParam, Float.valueOf(f));
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, int i) {
        if (this.B == null || aW != 2) {
            return;
        }
        this.B.a(filterParam, Integer.valueOf(i));
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, String str) {
        if (this.B == null || aW != 2) {
            return;
        }
        this.B.a(filterParam, str);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, List<Point> list) {
        if (list == null || aW != 2) {
            return;
        }
        float[] fArr = new float[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            fArr[i * 2] = list.get(i).x;
            fArr[(i * 2) + 1] = list.get(i).y;
        }
        if (this.B != null) {
            this.B.a(filterParam, Integer.valueOf(list.size()), "_count", false);
            this.B.a(filterParam, fArr);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float[] fArr) {
        if (this.B == null || aW != 2) {
            return;
        }
        this.B.a(filterParam, fArr);
    }

    @Override // com.baidu.ar.filter.IFilter
    public String updateFilterCase(String str) {
        if (this.B == null || aW != 2) {
            return null;
        }
        return this.B.updateFilterCase(str);
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        if (this.g != null) {
            this.g.updatePixelReader(pixelReadParams, pixelRotation);
        }
    }
}
