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
/* loaded from: classes5.dex */
public class a {
    private static long ckM;
    private static String ckN;
    private static a ckp;
    private FaceListener ckA;
    private LuaMsgListener ckB;
    FilterStateListener ckC;
    private DefinedLuaListener ckD;
    private Texture ckG;
    private Texture ckH;
    private long ckJ;
    private long ckK;
    private long ckL;
    private long ckO;
    private com.baidu.minivideo.arface.c.c ckP;
    private Makeup ckT;
    private Handler ckU;
    private final com.baidu.minivideo.arface.c.d ckV;
    private EGLContext ckr;
    private InterfaceC0264a cks;
    private DuMixController cku;
    private DuMixInput ckw;
    private DuMixOutput ckx;
    private SurfaceTexture.OnFrameAvailableListener cky;
    private SurfaceTexture.OnFrameAvailableListener ckz;
    private Context mContext;
    private HandlerThread mHandlerThread;
    public static final String cko = c.abX();
    private static boolean ckq = false;
    private static final InterfaceC0264a ckE = null;
    private static boolean ckI = false;
    private boolean mPaused = false;
    private boolean ckt = false;
    private List<DuMixCallback> ckv = new ArrayList();
    private int mInputWidth = 1280;
    private int mInputHeight = 720;
    private boolean ckF = false;
    private HashMap<BeautyType, String> ckQ = new HashMap<>();
    private JSONObject ckR = new JSONObject();
    private JSONObject ckS = new JSONObject();
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private boolean mArReportOriginalValue = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.8
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            a.this.ckK = System.currentTimeMillis() - a.this.ckJ;
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + a.this.ckK);
            }
            a.this.eb(z);
            a.this.ckQ.clear();
            if (z && a.this.cku != null && b.abL() != null) {
                a aVar = a.this;
                b.abL();
                aVar.jg(c.ed(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.abL();
                aVar2.setBeautyValue(beautyType, c.abY());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.ckv.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ckv.get(i2);
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
                if (i2 < a.this.ckv.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ckv.get(i2);
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
                if (i2 < a.this.ckv.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ckv.get(i2);
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
                if (i2 < a.this.ckv.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ckv.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.ckv.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.ckv) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0264a {
        void onHolderChanged(InterfaceC0264a interfaceC0264a);
    }

    public static boolean abC() {
        if (ckq) {
            return ckq;
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
            ckq = true;
        } catch (Throwable th) {
            i.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            ckq = false;
        }
        return ckq;
    }

    private a(Context context, InterfaceC0264a interfaceC0264a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0264a + ", eglCxt=" + eGLContext);
        }
        this.mHandlerThread = new HandlerThread("ARControllerProxy");
        this.mHandlerThread.start();
        this.mContext = context.getApplicationContext();
        this.ckr = eGLContext;
        this.cks = interfaceC0264a;
        this.cku = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            ay(this.cku.checkAuth(bArr, null, null));
        } else {
            ay(null);
        }
        ec(false);
        this.cku.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.ckA != null) {
                    a.this.ckA.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.ckA != null) {
                    a.this.ckA.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.ckA != null) {
                    a.this.ckA.onTriggerFired(str);
                }
            }
        });
        this.cku.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.ckB != null ? a.this.ckB.getMsgKeyListened() : null;
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
                if (a.this.ckB != null) {
                    a.this.ckB.onLuaMessage(hashMap);
                }
            }
        });
        this.cku.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.ckD != null) {
                    a.this.ckD.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.i(hashMap));
                }
                if (a.this.ckD != null) {
                    a.this.ckD.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.cku.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.i(hashMap) + "\n" + str);
                }
                if (a.this.ckC != null) {
                    a.this.ckC.onFilterStateChanged(hashMap, str);
                }
            }
        });
        this.ckz = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.minivideo.arface.a.5
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                a.this.ckP.acA();
                if (a.this.ckV != null) {
                    a.this.ckV.onFrameAvailable();
                }
                if (a.this.cky != null) {
                    a.this.cky.onFrameAvailable(surfaceTexture);
                }
            }
        };
        this.cku.setARRenderFpsCallback(new ARRenderFpsCallback() { // from class: com.baidu.minivideo.arface.a.6
            @Override // com.baidu.ar.arrender.ARRenderFpsCallback
            public void onRenderStarted() {
                if (a.this.ckV != null) {
                    a.this.ckV.onRenderStarted();
                }
            }

            @Override // com.baidu.ar.arrender.ARRenderFpsCallback
            public void onRenderFinished() {
                if (a.this.ckV != null) {
                    a.this.ckV.onRenderFinished();
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
        this.ckP = new com.baidu.minivideo.arface.c.c(AlaRecorderLog.KEY_CANERA_START_FPS, "ar");
        this.ckP.bM(1000L);
        this.ckV = new com.baidu.minivideo.arface.c.d();
    }

    private Handler abD() {
        if (this.ckU != null) {
            return this.ckU;
        }
        this.ckU = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.minivideo.arface.a.7
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.abI();
                        return;
                    case 2:
                        a.this.abH();
                        return;
                    case 3:
                        a.C0266a c0266a = new a.C0266a();
                        c0266a.cmF = (int) com.baidu.minivideo.arface.c.b.acv().acx();
                        ActivityManager.MemoryInfo acw = com.baidu.minivideo.arface.c.b.acv().acw();
                        if (acw != null) {
                            c0266a.cmG = ((acw.totalMem / 1024) / 1024) - ((acw.availMem / 1024) / 1024);
                        }
                        if (a.this.ckV != null) {
                            if (a.this.mArReportOriginalValue) {
                                c0266a.cmH = a.this.ckV.ei(true);
                                c0266a.cmI = a.this.ckV.ej(true);
                            } else {
                                c0266a.cmJ = a.this.ckV.ei(false);
                                c0266a.cmK = a.this.ckV.ej(false);
                            }
                            c0266a.fps = a.this.ckV.getFps();
                            a.this.ckV.resetData();
                        }
                        a.this.a(c0266a, a.this.mArReportOriginalValue);
                        sendMessageDelayed(obtainMessage(3), 5000L);
                        return;
                    default:
                        return;
                }
            }
        };
        return this.ckU;
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

    public static a a(Context context, InterfaceC0264a interfaceC0264a, byte[] bArr) {
        return a(context, interfaceC0264a, null, bArr);
    }

    public static a a(Context context, InterfaceC0264a interfaceC0264a, EGLContext eGLContext, byte[] bArr) {
        if (ckp == null || ckp.cks != interfaceC0264a || ckp.ckr != eGLContext) {
            synchronized (a.class) {
                if (ckp == null || ckp.cks != interfaceC0264a || ckp.ckr != eGLContext) {
                    if (ckp != null) {
                        InterfaceC0264a interfaceC0264a2 = ckp.cks;
                        ckp.release();
                        if (interfaceC0264a2 != null) {
                            interfaceC0264a2.onHolderChanged(interfaceC0264a);
                        }
                    }
                    ckp = new a(context, interfaceC0264a, eGLContext, bArr);
                }
            }
        }
        return ckp;
    }

    public InterfaceC0264a abE() {
        return this.cks;
    }

    public void resume() {
        if (ckp == this) {
            if (this.cku != null) {
                d("DuAr_DuController", "resume");
                this.cku.resume();
                this.mPaused = false;
            }
            this.ckP.reset();
        }
    }

    public void pause() {
        if (ckp == this) {
            if (this.cku != null) {
                d("DuAr_DuController", "pause");
                this.cku.pause();
                this.mPaused = true;
            }
            this.ckP.reset();
        }
    }

    public void release() {
        if (ckp == this) {
            this.mPaused = false;
            this.ckt = true;
            this.cks = ckE;
            DuMixController duMixController = this.cku;
            this.cku = null;
            ckN = this.ckP.acC();
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.ckL = System.currentTimeMillis();
                duMixController.release();
                ckM = System.currentTimeMillis() - this.ckL;
                if (isDebug()) {
                    d("DuAr_DuController", Build.MODEL + ", release spendTime: " + ckM);
                }
            }
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            ckp = null;
            this.ckr = null;
            if (this.ckV != null) {
                this.ckV.resetData();
            }
        }
    }

    public boolean abF() {
        return this.ckF;
    }

    private boolean abG() {
        return (this.cku == null || !abF() || isPaused()) ? false : true;
    }

    public boolean isReleased() {
        return this.ckt;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.ckr != null) {
            this.ckw = new DuMixInput2(this.ckG, i, i2);
            ((DuMixInput2) this.ckw).setSyncInputContent(ckI);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + ckI);
            this.ckw.setInputDegree(0);
            return;
        }
        this.ckw = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated frontCamera: " + z + ", surfaceTexture: " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.cku != null) {
            this.cky = onFrameAvailableListener;
            this.ckJ = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(this.ckz);
            }
            a(duMixCallback);
            if (!this.ckF) {
                this.ckw.setFrontCamera(z);
                if (this.ckr != null) {
                    this.ckH = U(i, i2);
                    this.ckx = new DuMixOutput2(this.ckH, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.ckx = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.ckx.setScreenOrientation(0);
                    } else {
                        this.ckx = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    if (isDebug()) {
                        d("DuAr_DuController", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                    }
                }
                if (this.mOutputFPS != 0) {
                    this.ckx.setOutputFPS(this.mOutputFPS);
                }
                this.ckO = System.currentTimeMillis();
                this.cku.setup(this.ckw, this.ckx, this.mDuMixCallback);
                this.ckF = true;
                ea(true);
                k("output", this.ckx.getOutputWidth(), this.ckx.getOutputHeight());
                abD().obtainMessage(3).sendToTarget();
                return;
            }
            this.cku.changeOutputSize(i, i2);
            ea(false);
            k("output", i, i2);
        }
    }

    private void ea(boolean z) {
        File file = null;
        int i = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.ckO);
            if (this.ckw != null) {
                jSONObject.put("beauty_width", this.ckw.getInputWidth());
                jSONObject.put("beauty_height", this.ckw.getInputHeight());
                jSONObject.put("beauty_is_front_camera", this.ckw.isFrontCamera() ? 1 : 0);
                jSONObject.put("beauty_is_landscape", this.mIsLandscape ? 1 : 0);
                jSONObject.put("beauty_is_sync", ckI ? 1 : 0);
            }
            if (this.ckx != null) {
                jSONObject.put("beauty_out_width", this.ckx.getOutputWidth());
                jSONObject.put("beauty_out_height", this.ckx.getOutputHeight());
                jSONObject.put("beauty_out_fps", this.ckx.getOutputFPS());
            }
            jSONObject.put("beauty_is_resume", z ? 1 : 0);
            String abT = b.abL() != null ? c.abT() : null;
            if (!TextUtils.isEmpty(abT)) {
                b.abL();
                file = new File(c.abT());
            }
            if (abT == null) {
                abT = "null";
            }
            jSONObject.put("beauty_ar_path", abT);
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
            jSONObject.put("beauty_onsetup_ID", this.ckO);
            jSONObject.put("beauty_onsetup", z ? 1 : 0);
            jSONObject.put("beauty_onsetup_time", this.ckK);
            if (ckM != 0) {
                jSONObject.put("beauty_onsetup_release_time", ckM);
                ckM = 0L;
            }
            if (ckN != null) {
                jSONObject.put("beauty_release_frame_info", ckN);
                ckN = null;
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
    public void abH() {
        JSONObject jSONObject = new JSONObject();
        try {
            Makeup makeup = this.ckT;
            jSONObject.put("makeup_parameters", makeup == null ? "null" : makeup.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_makeup", jSONObject);
    }

    private void a(Makeup makeup) {
        this.ckT = makeup;
        abD().removeMessages(2);
        abD().sendMessageDelayed(abD().obtainMessage(2), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abI() {
        JSONObject jSONObject = this.ckS;
        try {
            jSONObject.put("beauty_parameters", this.ckR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_face", jSONObject);
    }

    public void a(a.C0266a c0266a, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CANERA_START_FPS, c0266a.fps);
            jSONObject.put("cpu", c0266a.cmF);
            jSONObject.put("mem", c0266a.cmG);
            if (z) {
                jSONObject.put("bft", c0266a.cmH);
                jSONObject.put("sft", c0266a.cmI);
            } else {
                jSONObject.put("bft_val", c0266a.cmJ);
                jSONObject.put("sft_val", c0266a.cmK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report(AlaRecorderLog.NAME_BEAUTY_PERFORMANCE, jSONObject);
    }

    private void a(BeautyType beautyType, Object obj) {
        if (beautyType != null) {
            try {
                this.ckR.put(beautyType.name(), obj);
                if (beautyType == BeautyType.beautyJsonPath) {
                    if (obj == null) {
                        this.ckS.remove("feature_name");
                        this.ckS.remove("feature_file_exist");
                    } else if (obj instanceof String) {
                        this.ckS.put("feature_file_exist", new File((String) obj).exists() ? 1 : 0);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            abD().removeMessages(1);
            abD().sendMessageDelayed(abD().obtainMessage(1), 500L);
        }
    }

    private void ay(List<Integer> list) {
        JSONObject jSONObject = this.ckR;
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
        JSONObject jSONObject = this.ckR;
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
        if (this.cku != null && hashMap != null) {
            if (isDebug()) {
                i.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.cku.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.cku != null && str != null) {
            this.cku.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.ckv.contains(duMixCallback)) {
            this.ckv.add(duMixCallback);
        }
        i.d("DuAr_DuController", "addDuMixCallback size " + this.ckv.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.cku != null && beautyType != null) {
            this.cku.updateFilter(beautyType.type, i);
            a(beautyType, Integer.valueOf(i));
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        String str;
        if (makeup != null) {
            DuMixController duMixController = this.cku;
            if (duMixController == null) {
                str = "";
            } else {
                if (beautyType != null) {
                    if (TextUtils.equals(this.ckQ.get(beautyType), makeup.getResPath())) {
                        str = "";
                    } else {
                        str = duMixController.updateFilterCase(makeup.getResPath());
                        if (str != null) {
                            this.ckQ.put(beautyType, makeup.getResPath());
                        }
                    }
                    duMixController.updateFilter(beautyType.type, makeup.getValue());
                } else {
                    this.ckQ.clear();
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
        if (this.cku != null && beautyType != null) {
            this.cku.updateFilter(beautyType.type, f);
            a(beautyType, Float.valueOf(f));
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.cku;
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
            a(SharpnessFilter.sharpness, bVar.aDr);
            a(FilterParam.TuneColorFilter.brightness, bVar.aDs);
            a(FilterParam.TuneColorFilter.contrast, bVar.aDt);
            a(FilterParam.TuneColorFilter.saturation, bVar.aDu);
            a(FilterParam.TuneColorFilter.curve, bVar.aDv);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aDw);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aDx);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aDy);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aDz);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aDd);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aDe);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aDf);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aDg);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aDh);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aDi);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aDj);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aDk);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aDl);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (abG() && filterParam != null) {
            this.cku.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            i.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (abG() && filterParam != null && list != null) {
            this.cku.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.cku != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.cku.updateFilterCase(str);
                return;
            }
            this.cku.updateFilter(beautyType.type, str);
            a(beautyType, str);
        }
    }

    public void jg(String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.cku != null) {
            this.cku.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.D(fArr));
        }
        if (this.cku != null && beautyType != null) {
            this.cku.updateFilter(beautyType.type, fArr);
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

    public static String bA(Context context) {
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
        if (this.ckC != null && TextUtils.isEmpty(str)) {
            this.ckC.onFilterStateChanged(null, null);
        }
        if (abG()) {
            if (isDebug()) {
                i.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.cku.loadCase(aRType, str, str2);
            bb(str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.cku != null && this.cku.getARProxyManager() != null && this.cku.getARProxyManager().getCaptureAR() != null) {
            this.cku.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.cku != null && this.cku.getARProxyManager() != null && this.cku.getARProxyManager().getCaptureAR() != null) {
            this.cku.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.cku != null && this.cku.getARProxyManager() != null && this.cku.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.cku.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.cku.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean jh(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.ckA = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (ckp == null ? "" : " by: " + ckp.cks));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void ec(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.ckB = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.ckD = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.ckC = filterStateListener;
    }

    public void clearCase() {
        if (this.ckC != null) {
            this.ckC.onFilterStateChanged(null, null);
        }
        if (this.cku != null) {
            this.cku.clearCase();
        }
    }

    private Texture U(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.cku == null || (gLRenderer = this.cku.getGLRenderer()) == null) {
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
        return (aVar == null || aVar.isReleased() || aVar.abE() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.cku != null) {
            this.cku.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.cku != null) {
            this.cku.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.cku != null) {
            this.cku.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
