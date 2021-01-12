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
import io.flutter.plugin.platform.PlatformPlugin;
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
    private static a ceG;
    private static long cfd;
    private static String cfe;
    private EGLContext ceI;
    private InterfaceC0257a ceJ;
    private DuMixController ceL;
    private DuMixInput ceN;
    private DuMixOutput ceO;
    private SurfaceTexture.OnFrameAvailableListener ceP;
    private SurfaceTexture.OnFrameAvailableListener ceQ;
    private FaceListener ceR;
    private LuaMsgListener ceS;
    FilterStateListener ceT;
    private DefinedLuaListener ceU;
    private Texture ceX;
    private Texture ceY;
    private long cfa;
    private long cfb;
    private long cfc;
    private long cff;
    private com.baidu.minivideo.arface.c.c cfg;
    private Makeup cfk;
    private Handler cfl;
    private Context mContext;
    private HandlerThread mHandlerThread;
    public static final String ceF = c.aag();
    private static boolean ceH = false;
    private static final InterfaceC0257a ceV = null;
    private static boolean ceZ = false;
    private boolean mPaused = false;
    private boolean ceK = false;
    private List<DuMixCallback> ceM = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean ceW = false;
    private HashMap<BeautyType, String> cfh = new HashMap<>();
    private JSONObject cfi = new JSONObject();
    private JSONObject cfj = new JSONObject();
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.7
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            a.this.cfb = System.currentTimeMillis() - a.this.cfa;
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + a.this.cfb);
            }
            a.this.dT(z);
            a.this.cfh.clear();
            if (z && a.this.ceL != null && b.ZU() != null) {
                a aVar = a.this;
                b.ZU();
                aVar.iu(c.dV(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.ZU();
                aVar2.setBeautyValue(beautyType, c.aah());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.ceM.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ceM.get(i2);
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
                if (i2 < a.this.ceM.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ceM.get(i2);
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
                if (i2 < a.this.ceM.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ceM.get(i2);
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
                if (i2 < a.this.ceM.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ceM.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.ceM.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.ceM) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0257a {
        void onHolderChanged(InterfaceC0257a interfaceC0257a);
    }

    public static boolean ZK() {
        if (ceH) {
            return ceH;
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
            ceH = true;
        } catch (Throwable th) {
            i.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            ceH = false;
        }
        return ceH;
    }

    private a(Context context, InterfaceC0257a interfaceC0257a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0257a + ", eglCxt=" + eGLContext);
        }
        this.mHandlerThread = new HandlerThread("ARControllerProxy");
        this.mHandlerThread.start();
        this.mContext = context.getApplicationContext();
        this.ceI = eGLContext;
        this.ceJ = interfaceC0257a;
        this.ceL = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            aB(this.ceL.checkAuth(bArr, null, null));
        } else {
            aB(null);
        }
        dU(false);
        this.ceL.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.ceR != null) {
                    a.this.ceR.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.ceR != null) {
                    a.this.ceR.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.ceR != null) {
                    a.this.ceR.onTriggerFired(str);
                }
            }
        });
        this.ceL.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.ceS != null ? a.this.ceS.getMsgKeyListened() : null;
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
                if (a.this.ceS != null) {
                    a.this.ceS.onLuaMessage(hashMap);
                }
            }
        });
        this.ceL.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.ceU != null) {
                    a.this.ceU.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.i(hashMap));
                }
                if (a.this.ceU != null) {
                    a.this.ceU.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.ceL.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.i(hashMap) + "\n" + str);
                }
                if (a.this.ceT != null) {
                    a.this.ceT.onFilterStateChanged(hashMap, str);
                }
            }
        });
        this.ceQ = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.minivideo.arface.a.5
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                a.this.cfg.aaJ();
                if (a.this.ceP != null) {
                    a.this.ceP.onFrameAvailable(surfaceTexture);
                }
            }
        };
        this.cfg = new com.baidu.minivideo.arface.c.c(AlaRecorderLog.KEY_CANERA_START_FPS, "ar");
        this.cfg.bI(5000L);
    }

    private Handler ZL() {
        if (this.cfl != null) {
            return this.cfl;
        }
        this.cfl = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.minivideo.arface.a.6
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.ZR();
                        return;
                    case 2:
                        a.this.ZQ();
                        return;
                    case 3:
                        a.C0259a c0259a = new a.C0259a();
                        c0259a.cgU = (int) com.baidu.minivideo.arface.c.b.aaE().aaG();
                        ActivityManager.MemoryInfo aaF = com.baidu.minivideo.arface.c.b.aaE().aaF();
                        if (aaF != null) {
                            c0259a.cgW = (aaF.availMem / 1024) / 1024;
                            c0259a.cgV = (aaF.totalMem / 1024) / 1024;
                        }
                        c0259a.fps = 0;
                        c0259a.cgX = 0L;
                        if (a.this.cfg.chl > 0) {
                            c0259a.fps = (int) ((a.this.cfg.chl * 1000) / a.this.cfg.chk);
                            c0259a.cgX = a.this.cfg.chk / a.this.cfg.chl;
                        }
                        a.this.a(c0259a);
                        sendMessageDelayed(obtainMessage(3), 5000L);
                        return;
                    default:
                        return;
                }
            }
        };
        return this.cfl;
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

    public static a a(Context context, InterfaceC0257a interfaceC0257a, byte[] bArr) {
        return a(context, interfaceC0257a, null, bArr);
    }

    public static a a(Context context, InterfaceC0257a interfaceC0257a, EGLContext eGLContext, byte[] bArr) {
        if (ceG == null || ceG.ceJ != interfaceC0257a || ceG.ceI != eGLContext) {
            synchronized (a.class) {
                if (ceG == null || ceG.ceJ != interfaceC0257a || ceG.ceI != eGLContext) {
                    if (ceG != null) {
                        InterfaceC0257a interfaceC0257a2 = ceG.ceJ;
                        ceG.release();
                        if (interfaceC0257a2 != null) {
                            interfaceC0257a2.onHolderChanged(interfaceC0257a);
                        }
                    }
                    ceG = new a(context, interfaceC0257a, eGLContext, bArr);
                }
            }
        }
        return ceG;
    }

    public InterfaceC0257a ZM() {
        return this.ceJ;
    }

    public void resume() {
        if (ceG == this) {
            if (this.ceL != null) {
                d("DuAr_DuController", "resume");
                this.ceL.resume();
                this.mPaused = false;
            }
            this.cfg.reset();
        }
    }

    public void pause() {
        if (ceG == this) {
            if (this.ceL != null) {
                d("DuAr_DuController", "pause");
                this.ceL.pause();
                this.mPaused = true;
            }
            this.cfg.reset();
        }
    }

    public void release() {
        if (ceG == this) {
            this.mPaused = false;
            this.ceK = true;
            this.ceJ = ceV;
            DuMixController duMixController = this.ceL;
            this.ceL = null;
            cfe = this.cfg.aaL();
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.cfc = System.currentTimeMillis();
                duMixController.release();
                cfd = System.currentTimeMillis() - this.cfc;
                if (isDebug()) {
                    d("DuAr_DuController", Build.MODEL + ", release spendTime: " + cfd);
                }
            }
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            ceG = null;
            this.ceI = null;
        }
    }

    public boolean ZN() {
        return this.ceW;
    }

    private boolean ZO() {
        return (this.ceL == null || !ZN() || isPaused()) ? false : true;
    }

    public boolean ZP() {
        return this.ceK;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.ceI != null) {
            this.ceN = new DuMixInput2(this.ceX, i, i2);
            ((DuMixInput2) this.ceN).setSyncInputContent(ceZ);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + ceZ);
            this.ceN.setInputDegree(0);
            return;
        }
        this.ceN = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated frontCamera: " + z + ", surfaceTexture: " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.ceL != null) {
            this.ceP = onFrameAvailableListener;
            this.cfa = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(this.ceQ);
            }
            a(duMixCallback);
            if (!this.ceW) {
                this.ceN.setFrontCamera(z);
                if (this.ceI != null) {
                    this.ceY = V(i, i2);
                    this.ceO = new DuMixOutput2(this.ceY, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.ceO = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.ceO.setScreenOrientation(0);
                    } else {
                        this.ceO = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    if (isDebug()) {
                        d("DuAr_DuController", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                    }
                }
                if (this.mOutputFPS != 0) {
                    this.ceO.setOutputFPS(this.mOutputFPS);
                }
                this.cff = System.currentTimeMillis();
                this.ceL.setup(this.ceN, this.ceO, this.mDuMixCallback);
                this.ceW = true;
                dS(true);
                k("output", this.ceO.getOutputWidth(), this.ceO.getOutputHeight());
                ZL().obtainMessage(3).sendToTarget();
                return;
            }
            this.ceL.changeOutputSize(i, i2);
            dS(false);
            k("output", i, i2);
        }
    }

    private void dS(boolean z) {
        File file = null;
        int i = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.cff);
            if (this.ceN != null) {
                jSONObject.put("beauty_width", this.ceN.getInputWidth());
                jSONObject.put("beauty_height", this.ceN.getInputHeight());
                jSONObject.put("beauty_is_front_camera", this.ceN.isFrontCamera() ? 1 : 0);
                jSONObject.put("beauty_is_landscape", this.mIsLandscape ? 1 : 0);
                jSONObject.put("beauty_is_sync", ceZ ? 1 : 0);
            }
            if (this.ceO != null) {
                jSONObject.put("beauty_out_width", this.ceO.getOutputWidth());
                jSONObject.put("beauty_out_height", this.ceO.getOutputHeight());
                jSONObject.put("beauty_out_fps", this.ceO.getOutputFPS());
            }
            jSONObject.put("beauty_is_resume", z ? 1 : 0);
            String aac = b.ZU() != null ? c.aac() : null;
            if (!TextUtils.isEmpty(aac)) {
                b.ZU();
                file = new File(c.aac());
            }
            if (aac == null) {
                aac = "null";
            }
            jSONObject.put("beauty_ar_path", aac);
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
    public void dT(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.cff);
            jSONObject.put("beauty_onsetup", z ? 1 : 0);
            jSONObject.put("beauty_onsetup_time", this.cfb);
            if (cfd != 0) {
                jSONObject.put("beauty_onsetup_release_time", cfd);
                cfd = 0L;
            }
            if (cfe != null) {
                jSONObject.put("beauty_release_frame_info", cfe);
                cfe = null;
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
    public void ZQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            Makeup makeup = this.cfk;
            jSONObject.put("makeup_parameters", makeup == null ? "null" : makeup.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_makeup", jSONObject);
    }

    private void a(Makeup makeup) {
        this.cfk = makeup;
        ZL().removeMessages(2);
        ZL().sendMessageDelayed(ZL().obtainMessage(2), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZR() {
        JSONObject jSONObject = this.cfj;
        try {
            jSONObject.put("beauty_parameters", this.cfi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_face", jSONObject);
    }

    public void a(a.C0259a c0259a) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CANERA_START_FPS, c0259a.fps);
            jSONObject.put("cup", c0259a.cgU);
            jSONObject.put("memory_avalable", c0259a.cgW);
            jSONObject.put("memory_total", c0259a.cgV);
            jSONObject.put("frame_time", c0259a.cgX);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report(AlaRecorderLog.NAME_BEAUTY_PERFORMANCE, jSONObject);
    }

    private void a(BeautyType beautyType, Object obj) {
        if (beautyType != null) {
            try {
                this.cfi.put(beautyType.name(), obj);
                if (beautyType == BeautyType.beautyJsonPath) {
                    if (obj == null) {
                        this.cfj.remove("feature_name");
                        this.cfj.remove("feature_file_exist");
                    } else if (obj instanceof String) {
                        this.cfj.put("feature_file_exist", new File((String) obj).exists() ? 1 : 0);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ZL().removeMessages(1);
            ZL().sendMessageDelayed(ZL().obtainMessage(1), 500L);
        }
    }

    private void aB(List<Integer> list) {
        JSONObject jSONObject = this.cfi;
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
        JSONObject jSONObject = this.cfi;
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
        if (this.ceL != null && hashMap != null) {
            if (isDebug()) {
                i.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.ceL.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.ceL != null && str != null) {
            this.ceL.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.ceM.contains(duMixCallback)) {
            this.ceM.add(duMixCallback);
        }
        i.d("DuAr_DuController", "addDuMixCallback size " + this.ceM.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.ceL != null && beautyType != null) {
            this.ceL.updateFilter(beautyType.type, i);
            a(beautyType, Integer.valueOf(i));
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        String str;
        if (makeup != null) {
            DuMixController duMixController = this.ceL;
            if (duMixController == null) {
                str = "";
            } else {
                if (beautyType != null) {
                    if (TextUtils.equals(this.cfh.get(beautyType), makeup.getResPath())) {
                        str = "";
                    } else {
                        str = duMixController.updateFilterCase(makeup.getResPath());
                        if (str != null) {
                            this.cfh.put(beautyType, makeup.getResPath());
                        }
                    }
                    duMixController.updateFilter(beautyType.type, makeup.getValue());
                } else {
                    this.cfh.clear();
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
        if (this.ceL != null && beautyType != null) {
            this.ceL.updateFilter(beautyType.type, f);
            a(beautyType, Float.valueOf(f));
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.ceL;
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
            a(SharpnessFilter.sharpness, bVar.aAm);
            a(FilterParam.TuneColorFilter.brightness, bVar.aAn);
            a(FilterParam.TuneColorFilter.contrast, bVar.aAo);
            a(FilterParam.TuneColorFilter.saturation, bVar.aAp);
            a(FilterParam.TuneColorFilter.curve, bVar.aAq);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aAr);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aAs);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aAt);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aAu);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.azY);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.azZ);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aAa);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aAb);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aAc);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aAd);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aAe);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aAf);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aAg);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (ZO() && filterParam != null) {
            this.ceL.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            i.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (ZO() && filterParam != null && list != null) {
            this.ceL.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.ceL != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.ceL.updateFilterCase(str);
                return;
            }
            this.ceL.updateFilter(beautyType.type, str);
            a(beautyType, str);
        }
    }

    public void iu(String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.ceL != null) {
            this.ceL.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.B(fArr));
        }
        if (this.ceL != null && beautyType != null) {
            this.ceL.updateFilter(beautyType.type, fArr);
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

    public static String by(Context context) {
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
        if (this.ceT != null && TextUtils.isEmpty(str)) {
            this.ceT.onFilterStateChanged(null, null);
        }
        if (ZO()) {
            if (isDebug()) {
                i.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.ceL.loadCase(aRType, str, str2);
            bb(str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.ceL != null && this.ceL.getARProxyManager() != null && this.ceL.getARProxyManager().getCaptureAR() != null) {
            this.ceL.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.ceL != null && this.ceL.getARProxyManager() != null && this.ceL.getARProxyManager().getCaptureAR() != null) {
            this.ceL.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void k(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.ceL != null && this.ceL.getARProxyManager() != null && this.ceL.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.ceL.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.ceL.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean iv(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.ceR = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (ceG == null ? "" : " by: " + ceG.ceJ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void dU(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.ceS = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.ceU = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.ceT = filterStateListener;
    }

    public void clearCase() {
        if (this.ceT != null) {
            this.ceT.onFilterStateChanged(null, null);
        }
        if (this.ceL != null) {
            this.ceL.clearCase();
        }
    }

    private Texture V(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.ceL == null || (gLRenderer = this.ceL.getGLRenderer()) == null) {
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

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.ZP() || aVar.ZM() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.ceL != null) {
            this.ceL.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.ceL != null) {
            this.ceL.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.ceL != null) {
            this.ceL.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
