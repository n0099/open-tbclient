package com.baidu.minivideo.arface;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.ARType;
import com.baidu.ar.DefinedLuaListener;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixController;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixInput2;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixOutput2;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.capture.ICaptureAbilityListener;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.ar.face.FaceListener;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.arface.bean.Makeup;
import com.baidu.minivideo.arface.bean.SharpnessFilter;
import com.baidu.minivideo.arface.c.a;
import com.baidu.minivideo.arface.utils.i;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static a ciP;
    private static long cjm;
    private static String cjn;
    private EGLContext ciR;
    private InterfaceC0258a ciS;
    private DuMixController ciU;
    private DuMixInput ciW;
    private DuMixOutput ciX;
    private SurfaceTexture.OnFrameAvailableListener ciY;
    private SurfaceTexture.OnFrameAvailableListener ciZ;
    private FaceListener cja;
    private LuaMsgListener cjb;
    FilterStateListener cjc;
    private DefinedLuaListener cjd;
    private Texture cjg;
    private Texture cjh;
    private long cjj;
    private long cjk;
    private long cjl;
    private long cjo;
    private com.baidu.minivideo.arface.c.c cjp;
    private Makeup cjt;
    private Handler cju;
    private final com.baidu.minivideo.arface.c.d cjv;
    private Context mContext;
    private HandlerThread mHandlerThread;
    public static final String ciO = c.abU();
    private static boolean ciQ = false;
    private static final InterfaceC0258a cje = null;
    private static boolean cji = false;
    private boolean mPaused = false;
    private boolean ciT = false;
    private List<DuMixCallback> ciV = new ArrayList();
    private int mInputWidth = 1280;
    private int mInputHeight = 720;
    private boolean cjf = false;
    private HashMap<BeautyType, String> cjq = new HashMap<>();
    private JSONObject cjr = new JSONObject();
    private JSONObject cjs = new JSONObject();
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private boolean mArReportOriginalValue = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.8
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            a.this.cjk = System.currentTimeMillis() - a.this.cjj;
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + a.this.cjk);
            }
            a.this.eb(z);
            a.this.cjq.clear();
            if (z && a.this.ciU != null && b.abI() != null) {
                a aVar = a.this;
                b.abI();
                aVar.ja(c.ed(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.abI();
                aVar2.setBeautyValue(beautyType, c.abV());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.ciV.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ciV.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onSetup(z, duMixInput, duMixOutput);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onCaseCreate: b = " + z + " , id = " + str2 + " , path = " + str);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.ciV.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ciV.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onCaseCreate(z, str, str2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onCaseDestroy");
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.ciV.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ciV.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onCaseDestroy();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onRelease");
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.ciV.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ciV.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.ciV.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.ciV) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0258a {
        void onHolderChanged(InterfaceC0258a interfaceC0258a);
    }

    public static boolean abz() {
        if (ciQ) {
            return ciQ;
        }
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("ardatabasic2");
            System.loadLibrary("opencv_java3");
            System.loadLibrary("anakin_lite");
            System.loadLibrary("FaceAttributes");
            System.loadLibrary("EglCore2");
            System.loadLibrary("AREngineCpp2");
            System.loadLibrary("FaceAlgoSDK2");
            System.loadLibrary("ARMdlSDK2");
            if (isDebug()) {
                i.d("DuAr_UGC_SO", "so loaded!");
            }
            ciQ = true;
        } catch (Throwable th) {
            i.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            ciQ = false;
        }
        return ciQ;
    }

    private a(Context context, InterfaceC0258a interfaceC0258a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0258a + ", eglCxt=" + eGLContext);
        }
        this.mHandlerThread = new HandlerThread("ARControllerProxy");
        this.mHandlerThread.start();
        this.mContext = context.getApplicationContext();
        this.ciR = eGLContext;
        this.ciS = interfaceC0258a;
        this.ciU = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            ay(this.ciU.checkAuth(bArr, null, null));
        } else {
            ay(null);
        }
        ec(false);
        this.ciU.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.cja != null) {
                    a.this.cja.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.cja != null) {
                    a.this.cja.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.cja != null) {
                    a.this.cja.onTriggerFired(str);
                }
            }
        });
        this.ciU.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.cjb != null ? a.this.cjb.getMsgKeyListened() : null;
                if (a.isDebug()) {
                    if (msgKeyListened == null) {
                        a.d("DuAr_DuController", "getMsgKeyListened: " + ((Object) null));
                    } else {
                        Iterator<String> it = msgKeyListened.iterator();
                        while (it.hasNext()) {
                            a.d("DuAr_DuController", "getMsgKeyListened: " + it.next());
                        }
                    }
                }
                return msgKeyListened;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    if (hashMap == null) {
                        a.d("DuAr_DuController", "onLuaMessage: " + ((Object) null));
                    } else {
                        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                            a.d("DuAr_DuController", "onLuaMessage: " + entry.getKey() + " : " + entry.getValue());
                        }
                    }
                }
                if (a.this.cjb != null) {
                    a.this.cjb.onLuaMessage(hashMap);
                }
            }
        });
        this.ciU.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.cjd != null) {
                    a.this.cjd.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.i(hashMap));
                }
                if (a.this.cjd != null) {
                    a.this.cjd.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.ciU.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.i(hashMap) + "\n" + str);
                }
                if (a.this.cjc != null) {
                    a.this.cjc.onFilterStateChanged(hashMap, str);
                }
            }
        });
        this.ciZ = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.minivideo.arface.a.5
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                a.this.cjp.acx();
                if (a.this.cjv != null) {
                    a.this.cjv.onFrameAvailable();
                }
                if (a.this.ciY != null) {
                    a.this.ciY.onFrameAvailable(surfaceTexture);
                }
            }
        };
        this.ciU.setARRenderFpsCallback(new ARRenderFpsCallback() { // from class: com.baidu.minivideo.arface.a.6
            @Override // com.baidu.ar.arrender.ARRenderFpsCallback
            public void onRenderStarted() {
                if (a.this.cjv != null) {
                    a.this.cjv.onRenderStarted();
                }
            }

            @Override // com.baidu.ar.arrender.ARRenderFpsCallback
            public void onRenderFinished() {
                if (a.this.cjv != null) {
                    a.this.cjv.onRenderFinished();
                }
            }

            @Override // com.baidu.ar.arrender.ARRenderFpsCallback
            public void renderFps(int i) {
            }

            @Override // com.baidu.ar.arrender.ARRenderFpsCallback
            public int listenType() {
                return 3;
            }
        });
        this.cjp = new com.baidu.minivideo.arface.c.c(AlaRecorderLog.KEY_CANERA_START_FPS, "ar");
        this.cjp.bM(1000L);
        this.cjv = new com.baidu.minivideo.arface.c.d();
    }

    private Handler abA() {
        if (this.cju != null) {
            return this.cju;
        }
        this.cju = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.minivideo.arface.a.7
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.abF();
                        return;
                    case 2:
                        a.this.abE();
                        return;
                    case 3:
                        a.C0260a c0260a = new a.C0260a();
                        c0260a.cle = (int) com.baidu.minivideo.arface.c.b.acs().acu();
                        ActivityManager.MemoryInfo act = com.baidu.minivideo.arface.c.b.acs().act();
                        if (act != null) {
                            c0260a.clf = ((act.totalMem / 1024) / 1024) - ((act.availMem / 1024) / 1024);
                        }
                        if (a.this.cjv != null) {
                            if (a.this.mArReportOriginalValue) {
                                c0260a.clg = a.this.cjv.ei(true);
                                c0260a.clh = a.this.cjv.ej(true);
                            } else {
                                c0260a.cli = a.this.cjv.ei(false);
                                c0260a.clj = a.this.cjv.ej(false);
                            }
                            c0260a.fps = a.this.cjv.getFps();
                            a.this.cjv.resetData();
                        }
                        a.this.a(c0260a, a.this.mArReportOriginalValue);
                        sendMessageDelayed(obtainMessage(3), 5000L);
                        return;
                    default:
                        return;
                }
            }
        };
        return this.cju;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(Map map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            sb.append("null");
        } else {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    sb.append(entry.getKey().toString());
                    if (entry.getValue() != null) {
                        sb.append(',').append(entry.getValue().toString());
                    }
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public static a a(Context context, InterfaceC0258a interfaceC0258a, byte[] bArr) {
        return a(context, interfaceC0258a, null, bArr);
    }

    public static a a(Context context, InterfaceC0258a interfaceC0258a, EGLContext eGLContext, byte[] bArr) {
        if (ciP == null || ciP.ciS != interfaceC0258a || ciP.ciR != eGLContext) {
            synchronized (a.class) {
                if (ciP == null || ciP.ciS != interfaceC0258a || ciP.ciR != eGLContext) {
                    if (ciP != null) {
                        InterfaceC0258a interfaceC0258a2 = ciP.ciS;
                        ciP.release();
                        if (interfaceC0258a2 != null) {
                            interfaceC0258a2.onHolderChanged(interfaceC0258a);
                        }
                    }
                    ciP = new a(context, interfaceC0258a, eGLContext, bArr);
                }
            }
        }
        return ciP;
    }

    public InterfaceC0258a abB() {
        return this.ciS;
    }

    public void resume() {
        if (ciP == this) {
            if (this.ciU != null) {
                d("DuAr_DuController", "resume");
                this.ciU.resume();
                this.mPaused = false;
            }
            this.cjp.reset();
        }
    }

    public void pause() {
        if (ciP == this) {
            if (this.ciU != null) {
                d("DuAr_DuController", "pause");
                this.ciU.pause();
                this.mPaused = true;
            }
            this.cjp.reset();
        }
    }

    public void release() {
        if (ciP == this) {
            this.mPaused = false;
            this.ciT = true;
            this.ciS = cje;
            DuMixController duMixController = this.ciU;
            this.ciU = null;
            cjn = this.cjp.acz();
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.cjl = System.currentTimeMillis();
                duMixController.release();
                cjm = System.currentTimeMillis() - this.cjl;
                if (isDebug()) {
                    d("DuAr_DuController", Build.MODEL + ", release spendTime: " + cjm);
                }
            }
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            ciP = null;
            this.ciR = null;
            if (this.cjv != null) {
                this.cjv.resetData();
            }
        }
    }

    public boolean abC() {
        return this.cjf;
    }

    private boolean abD() {
        return (this.ciU == null || !abC() || isPaused()) ? false : true;
    }

    public boolean isReleased() {
        return this.ciT;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.ciR != null) {
            this.ciW = new DuMixInput2(this.cjg, i, i2);
            ((DuMixInput2) this.ciW).setSyncInputContent(cji);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + cji);
            this.ciW.setInputDegree(0);
            return;
        }
        this.ciW = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated frontCamera: " + z + ", surfaceTexture: " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.ciU != null) {
            this.ciY = onFrameAvailableListener;
            this.cjj = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(this.ciZ);
            }
            a(duMixCallback);
            if (!this.cjf) {
                this.ciW.setFrontCamera(z);
                if (this.ciR != null) {
                    this.cjh = U(i, i2);
                    this.ciX = new DuMixOutput2(this.cjh, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.ciX = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.ciX.setScreenOrientation(0);
                    } else {
                        this.ciX = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    if (isDebug()) {
                        d("DuAr_DuController", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                    }
                }
                if (this.mOutputFPS != 0) {
                    this.ciX.setOutputFPS(this.mOutputFPS);
                }
                this.cjo = System.currentTimeMillis();
                this.ciU.setup(this.ciW, this.ciX, this.mDuMixCallback);
                this.cjf = true;
                ea(true);
                k("output", this.ciX.getOutputWidth(), this.ciX.getOutputHeight());
                abA().obtainMessage(3).sendToTarget();
                return;
            }
            this.ciU.changeOutputSize(i, i2);
            ea(false);
            k("output", i, i2);
        }
    }

    private void ea(boolean z) {
        File file = null;
        int i = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.cjo);
            if (this.ciW != null) {
                jSONObject.put("beauty_width", this.ciW.getInputWidth());
                jSONObject.put("beauty_height", this.ciW.getInputHeight());
                jSONObject.put("beauty_is_front_camera", this.ciW.isFrontCamera() ? 1 : 0);
                jSONObject.put("beauty_is_landscape", this.mIsLandscape ? 1 : 0);
                jSONObject.put("beauty_is_sync", cji ? 1 : 0);
            }
            if (this.ciX != null) {
                jSONObject.put("beauty_out_width", this.ciX.getOutputWidth());
                jSONObject.put("beauty_out_height", this.ciX.getOutputHeight());
                jSONObject.put("beauty_out_fps", this.ciX.getOutputFPS());
            }
            jSONObject.put("beauty_is_resume", z ? 1 : 0);
            String abQ = b.abI() != null ? c.abQ() : null;
            if (!TextUtils.isEmpty(abQ)) {
                b.abI();
                file = new File(c.abQ());
            }
            if (abQ == null) {
                abQ = "null";
            }
            jSONObject.put("beauty_ar_path", abQ);
            if (file == null || !file.exists()) {
                i = 0;
            }
            jSONObject.put("beauty_ar_path_exist", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_start", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.cjo);
            jSONObject.put("beauty_onsetup", z ? 1 : 0);
            jSONObject.put("beauty_onsetup_time", this.cjk);
            if (cjm != 0) {
                jSONObject.put("beauty_onsetup_release_time", cjm);
                cjm = 0L;
            }
            if (cjn != null) {
                jSONObject.put("beauty_release_frame_info", cjn);
                cjn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_start", jSONObject);
    }

    private void bb(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operating", TextUtils.isEmpty(str) ? "unload" : TrackLoadSettingsAtom.TYPE);
            jSONObject.put(AlaLiveStickerInfo.STICKER_ID, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_sticker", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abE() {
        JSONObject jSONObject = new JSONObject();
        try {
            Makeup makeup = this.cjt;
            jSONObject.put("makeup_parameters", makeup == null ? "null" : makeup.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_makeup", jSONObject);
    }

    private void a(Makeup makeup) {
        this.cjt = makeup;
        abA().removeMessages(2);
        abA().sendMessageDelayed(abA().obtainMessage(2), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abF() {
        JSONObject jSONObject = this.cjs;
        try {
            jSONObject.put("beauty_parameters", this.cjr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_face", jSONObject);
    }

    public void a(a.C0260a c0260a, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CANERA_START_FPS, c0260a.fps);
            jSONObject.put("cpu", c0260a.cle);
            jSONObject.put("mem", c0260a.clf);
            if (z) {
                jSONObject.put("bft", c0260a.clg);
                jSONObject.put("sft", c0260a.clh);
            } else {
                jSONObject.put("bft_val", c0260a.cli);
                jSONObject.put("sft_val", c0260a.clj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report(AlaRecorderLog.NAME_BEAUTY_PERFORMANCE, jSONObject);
    }

    private void a(BeautyType beautyType, Object obj) {
        if (beautyType != null) {
            try {
                this.cjr.put(beautyType.name(), obj);
                if (beautyType == BeautyType.beautyJsonPath) {
                    if (obj == null) {
                        this.cjs.remove("feature_name");
                        this.cjs.remove("feature_file_exist");
                    } else if (obj instanceof String) {
                        this.cjs.put("feature_file_exist", new File((String) obj).exists() ? 1 : 0);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            abA().removeMessages(1);
            abA().sendMessageDelayed(abA().obtainMessage(1), 500L);
        }
    }

    private void ay(List<Integer> list) {
        JSONObject jSONObject = this.cjr;
        if (list != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : list) {
                    jSONArray.put(num.intValue());
                }
                jSONObject.put("features", jSONArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        com.baidu.minivideo.arface.c.a.report("beauty_auth", jSONObject);
    }

    private void k(String str, int i, int i2) {
        JSONObject jSONObject = this.cjr;
        try {
            jSONObject.put("stream_direction", str);
            jSONObject.put("stream_width", i);
            jSONObject.put("stream_height", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_resolution", jSONObject);
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.ciU != null && hashMap != null) {
            if (isDebug()) {
                i.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.ciU.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.ciU != null && str != null) {
            this.ciU.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.ciV.contains(duMixCallback)) {
            this.ciV.add(duMixCallback);
        }
        i.d("DuAr_DuController", "addDuMixCallback size " + this.ciV.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.ciU != null && beautyType != null) {
            this.ciU.updateFilter(beautyType.type, i);
            a(beautyType, Integer.valueOf(i));
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        String str;
        if (makeup != null) {
            DuMixController duMixController = this.ciU;
            if (duMixController == null) {
                str = "";
            } else {
                if (beautyType != null) {
                    if (TextUtils.equals(this.cjq.get(beautyType), makeup.getResPath())) {
                        str = "";
                    } else {
                        str = duMixController.updateFilterCase(makeup.getResPath());
                        if (str != null) {
                            this.cjq.put(beautyType, makeup.getResPath());
                        }
                    }
                    duMixController.updateFilter(beautyType.type, makeup.getValue());
                } else {
                    this.cjq.clear();
                    str = duMixController.updateFilterCase(makeup.getResPath());
                }
                a(makeup);
            }
            if (isDebug()) {
                i.d("DuAr_DuController", " updateMakeup: " + beautyType + " = " + makeup.getInfo() + ", resResult: " + str);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + f);
        }
        if (this.ciU != null && beautyType != null) {
            this.ciU.updateFilter(beautyType.type, f);
            a(beautyType, Float.valueOf(f));
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.ciU;
        if (duMixController != null && list != null) {
            duMixController.updateFilter(FilterParam.TuneColorFilter.rgbPoints, list.get(0));
            duMixController.updateFilter(FilterParam.TuneColorFilter.redPoints, list.get(1));
            duMixController.updateFilter(FilterParam.TuneColorFilter.greenPoints, list.get(2));
            duMixController.updateFilter(FilterParam.TuneColorFilter.bluePoints, list.get(3));
            duMixController.updateFilter((FilterParam) FilterParam.TuneColorFilter.curve, 0.9f);
        }
    }

    public void setQulaityParm(com.baidu.minivideo.arface.bean.b bVar) {
        if (bVar != null) {
            a(SharpnessFilter.sharpness, bVar.aBR);
            a(FilterParam.TuneColorFilter.brightness, bVar.aBS);
            a(FilterParam.TuneColorFilter.contrast, bVar.aBT);
            a(FilterParam.TuneColorFilter.saturation, bVar.aBU);
            a(FilterParam.TuneColorFilter.curve, bVar.aBV);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aBW);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aBX);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aBY);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aBZ);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aBD);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aBE);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aBF);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aBG);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aBH);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aBI);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aBJ);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aBK);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aBL);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (abD() && filterParam != null) {
            this.ciU.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            i.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (abD() && filterParam != null && list != null) {
            this.ciU.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.ciU != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.ciU.updateFilterCase(str);
                return;
            }
            this.ciU.updateFilter(beautyType.type, str);
            a(beautyType, str);
        }
    }

    public void ja(String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.ciU != null) {
            this.ciU.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.B(fArr));
        }
        if (this.ciU != null && beautyType != null) {
            this.ciU.updateFilter(beautyType.type, fArr);
        }
    }

    public void setBeautyValue(BeautyType beautyType, Object obj) {
        if (obj instanceof Integer) {
            setBeautyValue(beautyType, ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            setBeautyValue(beautyType, ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            setBeautyValue(beautyType, (String) obj);
        } else if (obj instanceof float[]) {
            setBeautyValue(beautyType, (float[]) obj);
        } else if (obj instanceof Double) {
            setBeautyValue(beautyType, (float) ((Double) obj).doubleValue());
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size();
            float[] fArr = new float[size];
            for (int i = 0; i < size; i++) {
                Object obj2 = arrayList.get(i);
                if (obj2 instanceof Double) {
                    fArr[i] = new Float(((Double) obj2).doubleValue()).floatValue();
                }
            }
            setBeautyValue(beautyType, fArr);
        } else if (obj instanceof Makeup) {
            a(beautyType, (Makeup) obj);
        }
    }

    public void j(Map<BeautyType, Object> map) {
        Map.Entry<BeautyType, Object> next;
        if (map != null) {
            Iterator<Map.Entry<BeautyType, Object>> it = map.entrySet().iterator();
            while (it.hasNext() && (next = it.next()) != null && next.getKey() != null) {
                setBeautyValue(next.getKey(), next.getValue());
            }
        }
    }

    public static String bB(Context context) {
        String soDownLoadDir = DuMixController.getSoDownLoadDir(context);
        if (isDebug()) {
            i.d("DuAr_DuController", " getSoDownloadDir: " + soDownLoadDir);
        }
        return soDownLoadDir;
    }

    public static int getVersion() {
        int versionCode = DuMixController.getVersionCode();
        if (isDebug()) {
            i.d("DuAr_DuController", " getSdkVersion: " + versionCode);
        }
        return versionCode;
    }

    public static String getVersionName() {
        String versionName = DuMixController.getVersionName();
        if (isDebug()) {
            i.d("DuAr_DuController", " getVersionName:" + versionName);
        }
        return versionName;
    }

    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.cjc != null && TextUtils.isEmpty(str)) {
            this.cjc.onFilterStateChanged(null, null);
        }
        if (abD()) {
            if (isDebug()) {
                i.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.ciU.loadCase(aRType, str, str2);
            bb(str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.ciU != null && this.ciU.getARProxyManager() != null && this.ciU.getARProxyManager().getCaptureAR() != null) {
            this.ciU.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.ciU != null && this.ciU.getARProxyManager() != null && this.ciU.getARProxyManager().getCaptureAR() != null) {
            this.ciU.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void k(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.ciU != null && this.ciU.getARProxyManager() != null && this.ciU.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.ciU.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
                        return;
                    }
                }
            } else if (objArr[0] instanceof String) {
                String[] strArr = new String[objArr.length];
                while (true) {
                    int i3 = i;
                    if (i3 < objArr.length) {
                        strArr[i3] = (String) objArr[i3];
                        i = i3 + 1;
                    } else {
                        this.ciU.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean jb(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.cja = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (ciP == null ? "" : " by: " + ciP.ciS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void ec(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.cjb = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.cjd = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.cjc = filterStateListener;
    }

    public void clearCase() {
        if (this.cjc != null) {
            this.cjc.onFilterStateChanged(null, null);
        }
        if (this.ciU != null) {
            this.ciU.clearCase();
        }
    }

    private Texture U(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.ciU == null || (gLRenderer = this.ciU.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public void setLandscape(boolean z) {
        this.mIsLandscape = z;
    }

    public void setArReportOriginalValue(boolean z) {
        this.mArReportOriginalValue = z;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.isReleased() || aVar.abB() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.ciU != null) {
            this.ciU.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.ciU != null) {
            this.ciU.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.ciU != null) {
            this.ciU.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
