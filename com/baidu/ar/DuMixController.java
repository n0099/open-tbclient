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
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IDuMixAuthCallback;
import com.baidu.ar.auth.IOfflineAuthenticator;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.content.IContentPlatform;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.filter.IFilter;
import com.baidu.ar.g.n;
import com.baidu.ar.libloader.ILibLoaderPlugin;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.photo.IPhoto;
import com.baidu.ar.photo.PhotoCallback;
import com.baidu.ar.record.IRecord;
import com.baidu.ar.record.RecordCallback;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.steploading.IStepLoading;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class DuMixController implements IDuMix, IFilter, IPhoto, IRecord {
    private static volatile DuMixController aJ = null;
    private static volatile int aT = 0;
    private static volatile Object sLock = new Object();
    private com.baidu.ar.filter.a A;
    private DuMixInput W;
    private HandlerThread aK;
    private Handler aL;
    private Handler aM;
    private DuMixCallback aN;
    private e aO;
    private com.baidu.ar.lua.e aP;
    private OrientationManager aQ;
    private com.baidu.ar.record.a aR;
    private IContentPlatform aS;
    private DuMixOutput aa;
    protected DuMixCallback ab;
    private b ae;
    private DefaultParams d;
    private com.baidu.ar.lua.b f;
    private com.baidu.ar.arrender.c g;
    private Context mContext;
    private com.baidu.ar.a.b v;

    /* loaded from: classes12.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 3000:
                    DuMixController.this.P();
                    return;
                case 3001:
                    DuMixController.this.R();
                    return;
                case 3002:
                    DuMixController.this.S();
                    return;
                case CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL /* 3003 */:
                    DuMixController.this.T();
                    return;
                case CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL /* 3004 */:
                    DuMixController.this.a((CaseModel) message.obj);
                    return;
                case 3005:
                    DuMixController.this.U();
                    return;
                case 3006:
                    if (DuMixController.this.g != null) {
                        DuMixController.this.g.changeOutputSize(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 3007:
                    DuMixController.this.aa = (DuMixOutput) message.obj;
                    if (DuMixController.this.g != null) {
                        DuMixController.this.g.changeOutput(DuMixController.this.aa);
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
                        DuMixController.this.g.changeInputSize((SurfaceTexture) message.obj, message.arg1, message.arg2);
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
        com.baidu.ar.g.b.c("DuMixController", "create DuMixController sState = " + aT);
        if (aT == 3) {
            synchronized (sLock) {
                try {
                    com.baidu.ar.g.b.c("DuMixController", "create DuMixController wait for release!");
                    sLock.wait(IMConnection.RETRY_DELAY_TIMES);
                } catch (Exception e) {
                    com.baidu.ar.g.b.b("DuMixController", "create DuMixController wait error!!!");
                }
            }
        }
        this.aK = new HandlerThread("DuMixController");
        this.aK.start();
        this.aL = new a(this.aK.getLooper());
        com.baidu.ar.c.c.ce().a(this.aK.getLooper());
        a(this.mContext, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        com.baidu.ar.g.b.c("DuMixController", "handleSetup() sState = " + aT);
        if (aT != 0 || this.aO == null || this.g == null || this.A == null || this.ae == null || this.v == null) {
            return;
        }
        aT = 1;
        this.aN = Q();
        this.aO.a(this.g, this.ae, this.A, this.f);
        this.aO.setup(this.W, this.aa, this.aN);
        StatisticApi.setPubParam(StatisticConstants.FRAME_DATA_FROM, this.W.isCameraInput() ? PixelReadParams.DEFAULT_FILTER_ID : "video");
        StatisticApi.onEventStart(StatisticConstants.EVENT_SDK_START);
        this.aQ.addOrientationListener(this.g);
        this.aQ.enable();
        this.A.a(this.g);
        if (this.v != null) {
            JSONObject ad = this.v.ad();
            if (ad != null) {
                this.g.a(ad);
            } else {
                this.g.setLocalDeviceGrade(this.v.ae());
            }
        }
        this.ae.a(this.f, this.g);
        this.g.a(this.W, this.aa);
        this.aO.a(this.v);
        this.aO.E();
    }

    private DuMixCallback Q() {
        return new DuMixCallback() { // from class: com.baidu.ar.DuMixController.1
            @Override // com.baidu.ar.DuMixCallback
            public void onCaseCreate(final boolean z, final String str, final String str2) {
                if (DuMixController.this.aM != null) {
                    DuMixController.this.aM.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.ab != null) {
                                DuMixController.this.ab.onCaseCreate(z, str, str2);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseDestroy() {
                if (DuMixController.this.aM != null) {
                    DuMixController.this.aM.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.ab != null) {
                                DuMixController.this.ab.onCaseDestroy();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onError(final DuMixErrorType duMixErrorType, final String str, final String str2) {
                if (DuMixController.this.aM != null) {
                    DuMixController.this.aM.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.ab != null) {
                                DuMixController.this.ab.onError(duMixErrorType, str, str2);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onRelease() {
                com.baidu.ar.g.b.c("DuMixController", "getDuMixCallbackProxy onRelease sState = " + DuMixController.aT);
                int unused = DuMixController.aT = 0;
                synchronized (DuMixController.sLock) {
                    try {
                        DuMixController.sLock.notifyAll();
                    } catch (Exception e) {
                        com.baidu.ar.g.b.c("DuMixController", "onRelease normal!!!");
                    }
                }
                if (DuMixController.this.aM != null) {
                    DuMixController.this.aM.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.ab != null) {
                                DuMixController.this.ab.onRelease();
                                DuMixController.this.ab = null;
                            }
                        }
                    });
                    DuMixController.this.aM = null;
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onSetup(final boolean z, final DuMixInput duMixInput, final DuMixOutput duMixOutput) {
                com.baidu.ar.g.b.c("DuMixController", "getDuMixCallbackProxy onSetup sState = " + DuMixController.aT);
                if (z) {
                    int unused = DuMixController.aT = 2;
                }
                if (DuMixController.this.aM != null) {
                    DuMixController.this.aM.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.ab != null) {
                                com.baidu.ar.g.b.c("DuMixController", "mDuMixCallback.onSetup()");
                                DuMixController.this.ab.onSetup(z, duMixInput, duMixOutput);
                            }
                        }
                    });
                }
                synchronized (DuMixController.sLock) {
                    try {
                        DuMixController.sLock.notifyAll();
                    } catch (Exception e) {
                        com.baidu.ar.g.b.c("DuMixController", "onSetup normal!!!");
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (aT != 2) {
            return;
        }
        if (this.ae != null) {
            this.ae.pause();
        }
        if (this.g != null) {
            this.g.pause();
        }
        if (this.aQ != null) {
            this.aQ.disable();
        }
        StatisticApi.pause();
        if (this.aO != null) {
            this.aO.k("pause");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (aT != 2) {
            return;
        }
        if (this.aO != null) {
            this.aO.k("resume");
        }
        StatisticApi.resume();
        if (this.aQ != null) {
            this.aQ.enable();
        }
        if (this.g != null) {
            this.g.resume();
        }
        if (this.ae != null) {
            this.ae.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        com.baidu.ar.g.b.c("DuMixController", "handleRelease() sState = " + aT);
        if (this.aL != null) {
            this.aL.removeCallbacksAndMessages(null);
            this.aL = null;
        }
        this.aS = null;
        if (this.aO != null) {
            this.aO.A();
        }
        if (this.aP != null) {
            this.aP.release();
            this.aP = null;
        }
        if (this.A != null) {
            this.A.clearAllFilter();
            this.A.release();
            this.A = null;
        }
        if (this.ae != null) {
            this.ae.release();
            this.ae = null;
        }
        if (this.g != null) {
            this.g.release();
            this.g = null;
        }
        if (this.aQ != null) {
            this.aQ.destroy();
            this.aQ = null;
        }
        if (this.v != null) {
            this.v.release();
            this.v = null;
        }
        com.baidu.ar.libloader.b.release();
        com.baidu.ar.auth.a.release();
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        StatisticApi.onEventEnd(StatisticConstants.EVENT_SDK_END);
        StatisticApi.release();
        if (this.f != null) {
            this.f.destroy();
            this.f = null;
        }
        if (this.aO != null) {
            this.aO.release();
            this.aO = null;
        }
        this.W = null;
        this.aa = null;
        this.d = null;
        this.aN = null;
        this.mContext = null;
        com.baidu.ar.g.b.c("DuMixController", "handleRelease() end");
        if (this.aK != null) {
            this.aK.quitSafely();
            this.aK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.aO == null || aT != 2) {
            com.baidu.ar.g.b.b("DuMixController", "handleClearCase DuMix has not setup!!!!!!");
        } else {
            this.aO.clearCase();
        }
    }

    private void a(Context context, DefaultParams defaultParams) {
        com.baidu.ar.g.b.c("DuMixController", "createManagers start!!!");
        if (this.aM == null) {
            this.aM = new Handler(context.getMainLooper());
        }
        com.baidu.ar.g.b.V(defaultParams.isLogEnable());
        com.baidu.ar.g.a.setPackageName(context.getPackageName());
        if (this.aQ == null) {
            this.aQ = new OrientationManager(context);
        }
        StatisticApi.init(context);
        if (this.aO == null) {
            this.aO = new e(context, defaultParams, this.aK);
            this.aO.a(this);
        }
        if (this.v == null) {
            this.v = new com.baidu.ar.a.b(context);
            this.v.c(defaultParams.getGradingConfig());
        }
        if (this.A == null) {
            this.A = new com.baidu.ar.filter.a(defaultParams);
            this.ae = new b(context, this.aK.getLooper(), defaultParams, this.v, this.A);
        }
        if (this.f == null) {
            this.f = new com.baidu.ar.lua.b(context);
            this.f.setUserPlayAudio(defaultParams.isUserPlayAudio());
        }
        if (this.g == null) {
            if (defaultParams.isUseTextureIO()) {
                this.g = new com.baidu.ar.arrender.d(context, this.aK.getLooper(), this.f, defaultParams.getShareContext());
            } else {
                this.g = new com.baidu.ar.arrender.c(context, this.aK.getLooper(), this.f);
            }
            if (!TextUtils.isEmpty(defaultParams.getRenderPipeline())) {
                this.g.setDefaultPipeLine(defaultParams.getRenderPipeline());
            }
        }
        com.baidu.ar.g.b.c("DuMixController", "createManagers end!!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CaseModel caseModel) {
        if (this.aO != null && aT == 2) {
            this.aO.loadCase(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
            return;
        }
        com.baidu.ar.g.b.b("DuMixController", "handleLoadCase DuMix has not setup!!!!!!");
        if (this.aN != null) {
            this.aN.onCaseCreate(false, caseModel.mCasePath, caseModel.mCaseId);
        }
    }

    public static IAuthenticator getAsyncAuthenticator(String str, String str2, String str3) {
        return com.baidu.ar.auth.b.getAsyncAuthenticator(str, str2, str3);
    }

    public static IAuthenticator getAuthenticator() {
        return com.baidu.ar.auth.b.getAuthenticator();
    }

    public static DuMixController getInstance(Context context, DefaultParams defaultParams) {
        if (context == null) {
            com.baidu.ar.g.b.b("DuMixController", "getInstance() context must be set!!!");
            return null;
        }
        if (aJ == null) {
            synchronized (DuMixController.class) {
                if (aJ == null) {
                    aJ = new DuMixController(context, defaultParams);
                }
            }
        }
        return aJ;
    }

    public static IOfflineAuthenticator getOfflineAuthenticator() {
        return com.baidu.ar.auth.b.getOfflineAuthenticator();
    }

    public static String getSoDownLoadDir(Context context) {
        return e.getSoDownLoadDir(context);
    }

    public static int getVersionCode() {
        return com.baidu.ar.g.c.getVersionCode();
    }

    public static String getVersionName() {
        return com.baidu.ar.g.c.getVersionName();
    }

    public boolean addAbility(String str, String str2) {
        return addAbility(str, str2, null);
    }

    public boolean addAbility(String str, String str2, String str3) {
        if (this.ae != null) {
            return this.ae.a(str, Arrays.asList(str2), str3);
        }
        return false;
    }

    public boolean addAbility(String str, List<String> list) {
        if (this.ae != null) {
            return this.ae.a(str, list, (String) null);
        }
        return false;
    }

    public boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        if (this.f == null || this.f.fl() == null) {
            return false;
        }
        return this.f.fl().addLuaMsgListener(luaMsgListener);
    }

    public boolean adjustAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.ae == null || abilityType == null || aT != 2) {
            return false;
        }
        return this.ae.adjustAbility(abilityType.getTypeValue(), hashMap);
    }

    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        if (this.ae == null || TextUtils.isEmpty(str) || aT != 2) {
            return false;
        }
        return this.ae.adjustAbility(str, hashMap);
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(int i, int i2) {
        com.baidu.ar.g.b.c("DuMixController", "changeInputSize width * height = " + i + " * " + i2);
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3010, i, i2, null));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(SurfaceTexture surfaceTexture, int i, int i2) {
        com.baidu.ar.g.b.c("DuMixController", "changeInputSize width * height = " + i + " * " + i2 + " && texture = " + surfaceTexture);
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3010, i, i2, surfaceTexture));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutput(DuMixOutput duMixOutput) {
        if (duMixOutput == null || this.aL == null) {
            return;
        }
        this.aL.sendMessage(this.aL.obtainMessage(3007, duMixOutput));
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutputSize(int i, int i2) {
        com.baidu.ar.g.b.c("DuMixController", "changeOutputSize width * height = " + i + " * " + i2);
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3006, i, i2));
        }
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        return com.baidu.ar.auth.a.checkAuth(this.mContext, bArr, iDuMixAuthCallback);
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        return com.baidu.ar.auth.a.checkAuth(this.mContext, bArr, iCallbackWith, iCallbackWith2);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void clearAllFilter() {
        if (this.A == null || aT != 2) {
            return;
        }
        this.A.clearAllFilter();
    }

    @Override // com.baidu.ar.IDuMix
    public void clearCase() {
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3005));
        }
    }

    public ARProxyManager getARProxyManager() {
        if (this.ae != null) {
            return this.ae.getARProxyManager();
        }
        return null;
    }

    public List<String> getActiveAbilities() {
        if (this.ae == null || aT != 2) {
            return null;
        }
        return this.ae.getActiveAbilities();
    }

    public IContentPlatform getContentPlatform() {
        if (this.aS == null) {
            this.aS = (IContentPlatform) n.a("com.baidu.ar.content.ContentCloud", new Class[]{Context.class}, new Object[]{this.mContext});
        }
        return this.aS;
    }

    public IGLRenderer getGLRenderer() {
        if (this.g == null || !(this.g instanceof IGLRenderer)) {
            return null;
        }
        return (IGLRenderer) this.g;
    }

    public IStepLoading getStepLoading() {
        if (this.g != null) {
            return this.g.bH();
        }
        return null;
    }

    public List<String> getSupportedAbilities() {
        if (this.ae == null || aT != 2) {
            return null;
        }
        return this.ae.getSupportedAbilities();
    }

    public boolean isAbilityActive(AbilityType abilityType) {
        if (this.ae == null || abilityType == null || aT != 2) {
            return false;
        }
        return this.ae.isAbilityActive(abilityType.getTypeValue());
    }

    public boolean isAbilityActive(String str) {
        if (this.ae == null || TextUtils.isEmpty(str) || aT != 2) {
            return false;
        }
        return this.ae.isAbilityActive(str);
    }

    public boolean isAbilitySupported(String str) {
        if (this.ae == null || aT != 2) {
            return false;
        }
        return this.ae.isAbilitySupported(str);
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(ARType aRType, String str, String str2) {
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL, new CaseModel(aRType, str, str2)));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.g == null || aT != 2) {
            return false;
        }
        return this.g.onTouch(view, motionEvent);
    }

    @Override // com.baidu.ar.IDuMix
    public void pause() {
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3001));
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (this.aR == null || aT != 2) {
            return;
        }
        this.aR.pauseRecord();
    }

    @Override // com.baidu.ar.IDuMix
    public void pauseScene() {
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3008));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void release() {
        com.baidu.ar.g.b.c("DuMixController", "release() sState = " + aT);
        if (aT == 1) {
            if (this.g == null || !this.g.bG()) {
                synchronized (sLock) {
                    try {
                        com.baidu.ar.g.b.c("DuMixController", "release DuMixController wait for setup!");
                        sLock.wait(IMConnection.RETRY_DELAY_TIMES);
                    } catch (Exception e) {
                        com.baidu.ar.g.b.b("DuMixController", "release DuMixController wait error!!!");
                    }
                }
            } else {
                this.g.s(true);
                aT = 0;
                aJ = null;
            }
        }
        if (aT == 0) {
            aJ = null;
        } else if (aT != 3) {
            if (aT != 2) {
                com.baidu.ar.g.b.b("DuMixController", "release error!!!");
                return;
            }
            aT = 3;
            if (this.aL != null) {
                this.aL.removeCallbacksAndMessages(null);
                this.aL.sendMessage(this.aL.obtainMessage(CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL));
            }
            aJ = null;
        }
    }

    public boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        if (this.f == null || this.f.fl() == null) {
            return false;
        }
        return this.f.fl().removeLuaMsgListener(luaMsgListener);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void resetAllFilter() {
        if (this.A == null || aT != 2) {
            return;
        }
        this.A.resetAllFilter();
    }

    @Override // com.baidu.ar.IDuMix
    public void resume() {
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3002));
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.aR == null || aT != 2) {
            return;
        }
        this.aR.resumeRecord();
    }

    @Override // com.baidu.ar.IDuMix
    public void resumeScene() {
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3009));
        }
    }

    public boolean sendMsg2Lua(HashMap<String, Object> hashMap) {
        if (this.f == null || aT != 2) {
            return false;
        }
        this.f.b(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
        return true;
    }

    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        com.baidu.ar.auth.a.setAuthLicense(bArr, str, str2, str3);
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        if (this.aP == null) {
            this.aP = new com.baidu.ar.lua.e(this.f);
        }
        this.aP.setDefinedLuaListener(definedLuaListener);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void setFilterStateListener(FilterStateListener filterStateListener) {
        if (this.A != null) {
            this.A.setFilterStateListener(filterStateListener);
        }
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.g != null) {
            this.g.setGLWebViewUseable(context, viewGroup);
        }
    }

    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        com.baidu.ar.libloader.b.setLibLoadPlugin(iLibLoaderPlugin);
    }

    public void setMdlModelPath(String str) {
        if (this.ae != null) {
            this.ae.setMdlModelPath(str);
        }
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        if (this.g != null) {
            this.g.setNativeWebViewUseable(context, viewGroup);
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
        com.baidu.ar.g.b.c("DuMixController", "setup() sState = " + aT);
        if (duMixInput == null || duMixOutput == null) {
            com.baidu.ar.g.b.b("DuMixController", "setup error!!! params maybe null!!!");
            if (duMixCallback != null) {
                duMixCallback.onSetup(false, duMixInput, duMixOutput);
                return;
            }
            return;
        }
        this.W = duMixInput;
        this.aa = duMixOutput;
        this.ab = duMixCallback;
        if (this.aL != null) {
            this.aL.sendMessage(this.aL.obtainMessage(3000));
        }
    }

    public boolean startAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.ae == null || abilityType == null || aT != 2) {
            return false;
        }
        return this.ae.startAbility(abilityType.getTypeValue(), hashMap);
    }

    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        if (this.ae == null || TextUtils.isEmpty(str) || aT != 2) {
            return false;
        }
        return this.ae.startAbility(str, hashMap);
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        if (aT == 2) {
            if (this.aR == null && this.g != null) {
                this.aR = new com.baidu.ar.record.a(this.mContext, this.g);
            }
            if (this.aO != null) {
                this.aO.j("start");
            }
            if (this.aR != null) {
                this.aR.startRecord(str, j, recordCallback);
            }
        }
    }

    public boolean stopAbility(AbilityType abilityType) {
        if (this.ae == null || abilityType == null || aT != 2) {
            return false;
        }
        return this.ae.stopAbility(abilityType.getTypeValue());
    }

    public boolean stopAbility(String str) {
        if (this.ae == null || TextUtils.isEmpty(str) || aT != 2) {
            return false;
        }
        return this.ae.stopAbility(str);
    }

    @Override // com.baidu.ar.record.IRecord
    public void stopRecord() {
        if (aT == 2) {
            if (this.aR != null) {
                this.aR.stopRecord();
                this.aR = null;
            }
            if (this.aO != null) {
                this.aO.j("stop");
            }
        }
    }

    @Override // com.baidu.ar.photo.IPhoto
    public void takePicture(String str, PhotoCallback photoCallback) {
        if (this.g == null || aT != 2) {
            return;
        }
        new com.baidu.ar.photo.a().a(this.g, str, photoCallback);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float f) {
        if (this.A == null || aT != 2) {
            return;
        }
        this.A.a(filterParam, Float.valueOf(f));
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, int i) {
        if (this.A == null || aT != 2) {
            return;
        }
        this.A.a(filterParam, Integer.valueOf(i));
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, String str) {
        if (this.A == null || aT != 2) {
            return;
        }
        this.A.a(filterParam, str);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, List<Point> list) {
        if (list == null || aT != 2) {
            return;
        }
        float[] fArr = new float[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            fArr[i * 2] = list.get(i).x;
            fArr[(i * 2) + 1] = list.get(i).y;
        }
        if (this.A != null) {
            this.A.a(filterParam, Integer.valueOf(list.size()), "_count", false);
            this.A.a(filterParam, fArr);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float[] fArr) {
        if (this.A == null || aT != 2) {
            return;
        }
        this.A.a(filterParam, fArr);
    }

    @Override // com.baidu.ar.filter.IFilter
    public String updateFilterCase(String str) {
        if (this.A == null || aT != 2) {
            return null;
        }
        return this.A.updateFilterCase(str);
    }
}
