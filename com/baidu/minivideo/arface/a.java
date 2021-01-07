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
/* loaded from: classes6.dex */
public class a {
    private static long cjQ;
    private static String cjR;
    private static a cjt;
    private DuMixInput cjA;
    private DuMixOutput cjB;
    private SurfaceTexture.OnFrameAvailableListener cjC;
    private SurfaceTexture.OnFrameAvailableListener cjD;
    private FaceListener cjE;
    private LuaMsgListener cjF;
    FilterStateListener cjG;
    private DefinedLuaListener cjH;
    private Texture cjK;
    private Texture cjL;
    private long cjN;
    private long cjO;
    private long cjP;
    private long cjS;
    private com.baidu.minivideo.arface.c.c cjT;
    private Makeup cjX;
    private Handler cjY;
    private EGLContext cjv;
    private InterfaceC0268a cjw;
    private DuMixController cjy;
    private Context mContext;
    private HandlerThread mHandlerThread;
    public static final String cjs = c.adZ();
    private static boolean cju = false;
    private static final InterfaceC0268a cjI = null;
    private static boolean cjM = false;
    private boolean mPaused = false;
    private boolean cjx = false;
    private List<DuMixCallback> cjz = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean cjJ = false;
    private HashMap<BeautyType, String> cjU = new HashMap<>();
    private JSONObject cjV = new JSONObject();
    private JSONObject cjW = new JSONObject();
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.7
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            a.this.cjO = System.currentTimeMillis() - a.this.cjN;
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + a.this.cjO);
            }
            a.this.dX(z);
            a.this.cjU.clear();
            if (z && a.this.cjy != null && b.adN() != null) {
                a aVar = a.this;
                b.adN();
                aVar.jF(c.dZ(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.adN();
                aVar2.setBeautyValue(beautyType, c.aea());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.cjz.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.cjz.get(i2);
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
                if (i2 < a.this.cjz.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.cjz.get(i2);
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
                if (i2 < a.this.cjz.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.cjz.get(i2);
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
                if (i2 < a.this.cjz.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.cjz.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.cjz.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.cjz) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0268a {
        void onHolderChanged(InterfaceC0268a interfaceC0268a);
    }

    public static boolean adD() {
        if (cju) {
            return cju;
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
            cju = true;
        } catch (Throwable th) {
            i.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            cju = false;
        }
        return cju;
    }

    private a(Context context, InterfaceC0268a interfaceC0268a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0268a + ", eglCxt=" + eGLContext);
        }
        this.mHandlerThread = new HandlerThread("ARControllerProxy");
        this.mHandlerThread.start();
        this.mContext = context.getApplicationContext();
        this.cjv = eGLContext;
        this.cjw = interfaceC0268a;
        this.cjy = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            aB(this.cjy.checkAuth(bArr, null, null));
        } else {
            aB(null);
        }
        dY(false);
        this.cjy.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.cjE != null) {
                    a.this.cjE.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.cjE != null) {
                    a.this.cjE.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.cjE != null) {
                    a.this.cjE.onTriggerFired(str);
                }
            }
        });
        this.cjy.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.cjF != null ? a.this.cjF.getMsgKeyListened() : null;
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
                if (a.this.cjF != null) {
                    a.this.cjF.onLuaMessage(hashMap);
                }
            }
        });
        this.cjy.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.cjH != null) {
                    a.this.cjH.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.i(hashMap));
                }
                if (a.this.cjH != null) {
                    a.this.cjH.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.cjy.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.i(hashMap) + "\n" + str);
                }
                if (a.this.cjG != null) {
                    a.this.cjG.onFilterStateChanged(hashMap, str);
                }
            }
        });
        this.cjD = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.minivideo.arface.a.5
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                a.this.cjT.aeC();
                if (a.this.cjC != null) {
                    a.this.cjC.onFrameAvailable(surfaceTexture);
                }
            }
        };
        this.cjT = new com.baidu.minivideo.arface.c.c(AlaRecorderLog.KEY_CANERA_START_FPS, "ar");
        this.cjT.bI(5000L);
    }

    private Handler adE() {
        if (this.cjY != null) {
            return this.cjY;
        }
        this.cjY = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.minivideo.arface.a.6
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.adK();
                        return;
                    case 2:
                        a.this.adJ();
                        return;
                    case 3:
                        a.C0270a c0270a = new a.C0270a();
                        c0270a.clH = (int) com.baidu.minivideo.arface.c.b.aex().aez();
                        ActivityManager.MemoryInfo aey = com.baidu.minivideo.arface.c.b.aex().aey();
                        if (aey != null) {
                            c0270a.clJ = (aey.availMem / 1024) / 1024;
                            c0270a.clI = (aey.totalMem / 1024) / 1024;
                        }
                        c0270a.fps = 0;
                        c0270a.clK = 0L;
                        if (a.this.cjT.clY > 0) {
                            c0270a.fps = (int) ((a.this.cjT.clY * 1000) / a.this.cjT.clX);
                            c0270a.clK = a.this.cjT.clX / a.this.cjT.clY;
                        }
                        a.this.a(c0270a);
                        sendMessageDelayed(obtainMessage(3), 5000L);
                        return;
                    default:
                        return;
                }
            }
        };
        return this.cjY;
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

    public static a a(Context context, InterfaceC0268a interfaceC0268a, byte[] bArr) {
        return a(context, interfaceC0268a, null, bArr);
    }

    public static a a(Context context, InterfaceC0268a interfaceC0268a, EGLContext eGLContext, byte[] bArr) {
        if (cjt == null || cjt.cjw != interfaceC0268a || cjt.cjv != eGLContext) {
            synchronized (a.class) {
                if (cjt == null || cjt.cjw != interfaceC0268a || cjt.cjv != eGLContext) {
                    if (cjt != null) {
                        InterfaceC0268a interfaceC0268a2 = cjt.cjw;
                        cjt.release();
                        if (interfaceC0268a2 != null) {
                            interfaceC0268a2.onHolderChanged(interfaceC0268a);
                        }
                    }
                    cjt = new a(context, interfaceC0268a, eGLContext, bArr);
                }
            }
        }
        return cjt;
    }

    public InterfaceC0268a adF() {
        return this.cjw;
    }

    public void resume() {
        if (cjt == this) {
            if (this.cjy != null) {
                d("DuAr_DuController", "resume");
                this.cjy.resume();
                this.mPaused = false;
            }
            this.cjT.reset();
        }
    }

    public void pause() {
        if (cjt == this) {
            if (this.cjy != null) {
                d("DuAr_DuController", "pause");
                this.cjy.pause();
                this.mPaused = true;
            }
            this.cjT.reset();
        }
    }

    public void release() {
        if (cjt == this) {
            this.mPaused = false;
            this.cjx = true;
            this.cjw = cjI;
            DuMixController duMixController = this.cjy;
            this.cjy = null;
            cjR = this.cjT.aeE();
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.cjP = System.currentTimeMillis();
                duMixController.release();
                cjQ = System.currentTimeMillis() - this.cjP;
                if (isDebug()) {
                    d("DuAr_DuController", Build.MODEL + ", release spendTime: " + cjQ);
                }
            }
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            cjt = null;
            this.cjv = null;
        }
    }

    public boolean adG() {
        return this.cjJ;
    }

    private boolean adH() {
        return (this.cjy == null || !adG() || isPaused()) ? false : true;
    }

    public boolean adI() {
        return this.cjx;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.cjv != null) {
            this.cjA = new DuMixInput2(this.cjK, i, i2);
            ((DuMixInput2) this.cjA).setSyncInputContent(cjM);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + cjM);
            this.cjA.setInputDegree(0);
            return;
        }
        this.cjA = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated frontCamera: " + z + ", surfaceTexture: " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.cjy != null) {
            this.cjC = onFrameAvailableListener;
            this.cjN = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(this.cjD);
            }
            a(duMixCallback);
            if (!this.cjJ) {
                this.cjA.setFrontCamera(z);
                if (this.cjv != null) {
                    this.cjL = V(i, i2);
                    this.cjB = new DuMixOutput2(this.cjL, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.cjB = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.cjB.setScreenOrientation(0);
                    } else {
                        this.cjB = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    if (isDebug()) {
                        d("DuAr_DuController", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                    }
                }
                if (this.mOutputFPS != 0) {
                    this.cjB.setOutputFPS(this.mOutputFPS);
                }
                this.cjS = System.currentTimeMillis();
                this.cjy.setup(this.cjA, this.cjB, this.mDuMixCallback);
                this.cjJ = true;
                dW(true);
                k("output", this.cjB.getOutputWidth(), this.cjB.getOutputHeight());
                adE().obtainMessage(3).sendToTarget();
                return;
            }
            this.cjy.changeOutputSize(i, i2);
            dW(false);
            k("output", i, i2);
        }
    }

    private void dW(boolean z) {
        File file = null;
        int i = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.cjS);
            if (this.cjA != null) {
                jSONObject.put("beauty_width", this.cjA.getInputWidth());
                jSONObject.put("beauty_height", this.cjA.getInputHeight());
                jSONObject.put("beauty_is_front_camera", this.cjA.isFrontCamera() ? 1 : 0);
                jSONObject.put("beauty_is_landscape", this.mIsLandscape ? 1 : 0);
                jSONObject.put("beauty_is_sync", cjM ? 1 : 0);
            }
            if (this.cjB != null) {
                jSONObject.put("beauty_out_width", this.cjB.getOutputWidth());
                jSONObject.put("beauty_out_height", this.cjB.getOutputHeight());
                jSONObject.put("beauty_out_fps", this.cjB.getOutputFPS());
            }
            jSONObject.put("beauty_is_resume", z ? 1 : 0);
            String adV = b.adN() != null ? c.adV() : null;
            if (!TextUtils.isEmpty(adV)) {
                b.adN();
                file = new File(c.adV());
            }
            if (adV == null) {
                adV = "null";
            }
            jSONObject.put("beauty_ar_path", adV);
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
    public void dX(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.cjS);
            jSONObject.put("beauty_onsetup", z ? 1 : 0);
            jSONObject.put("beauty_onsetup_time", this.cjO);
            if (cjQ != 0) {
                jSONObject.put("beauty_onsetup_release_time", cjQ);
                cjQ = 0L;
            }
            if (cjR != null) {
                jSONObject.put("beauty_release_frame_info", cjR);
                cjR = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_start", jSONObject);
    }

    private void bc(String str, String str2) {
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
    public void adJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            Makeup makeup = this.cjX;
            jSONObject.put("makeup_parameters", makeup == null ? "null" : makeup.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_makeup", jSONObject);
    }

    private void a(Makeup makeup) {
        this.cjX = makeup;
        adE().removeMessages(2);
        adE().sendMessageDelayed(adE().obtainMessage(2), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adK() {
        JSONObject jSONObject = this.cjW;
        try {
            jSONObject.put("beauty_parameters", this.cjV);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_face", jSONObject);
    }

    public void a(a.C0270a c0270a) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CANERA_START_FPS, c0270a.fps);
            jSONObject.put("cup", c0270a.clH);
            jSONObject.put("memory_avalable", c0270a.clJ);
            jSONObject.put("memory_total", c0270a.clI);
            jSONObject.put("frame_time", c0270a.clK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report(AlaRecorderLog.NAME_BEAUTY_PERFORMANCE, jSONObject);
    }

    private void a(BeautyType beautyType, Object obj) {
        if (beautyType != null) {
            try {
                this.cjV.put(beautyType.name(), obj);
                if (beautyType == BeautyType.beautyJsonPath) {
                    if (obj == null) {
                        this.cjW.remove("feature_name");
                        this.cjW.remove("feature_file_exist");
                    } else if (obj instanceof String) {
                        this.cjW.put("feature_file_exist", new File((String) obj).exists() ? 1 : 0);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            adE().removeMessages(1);
            adE().sendMessageDelayed(adE().obtainMessage(1), 500L);
        }
    }

    private void aB(List<Integer> list) {
        JSONObject jSONObject = this.cjV;
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
        JSONObject jSONObject = this.cjV;
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
        if (this.cjy != null && hashMap != null) {
            if (isDebug()) {
                i.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.cjy.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.cjy != null && str != null) {
            this.cjy.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.cjz.contains(duMixCallback)) {
            this.cjz.add(duMixCallback);
        }
        i.d("DuAr_DuController", "addDuMixCallback size " + this.cjz.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.cjy != null && beautyType != null) {
            this.cjy.updateFilter(beautyType.type, i);
            a(beautyType, Integer.valueOf(i));
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        String str;
        if (makeup != null) {
            DuMixController duMixController = this.cjy;
            if (duMixController == null) {
                str = "";
            } else {
                if (beautyType != null) {
                    if (TextUtils.equals(this.cjU.get(beautyType), makeup.getResPath())) {
                        str = "";
                    } else {
                        str = duMixController.updateFilterCase(makeup.getResPath());
                        if (str != null) {
                            this.cjU.put(beautyType, makeup.getResPath());
                        }
                    }
                    duMixController.updateFilter(beautyType.type, makeup.getValue());
                } else {
                    this.cjU.clear();
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
        if (this.cjy != null && beautyType != null) {
            this.cjy.updateFilter(beautyType.type, f);
            a(beautyType, Float.valueOf(f));
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.cjy;
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
            a(SharpnessFilter.sharpness, bVar.aEZ);
            a(FilterParam.TuneColorFilter.brightness, bVar.aFa);
            a(FilterParam.TuneColorFilter.contrast, bVar.aFb);
            a(FilterParam.TuneColorFilter.saturation, bVar.aFc);
            a(FilterParam.TuneColorFilter.curve, bVar.aFd);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aFe);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aFf);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aFg);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aFh);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aEL);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aEM);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aEN);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aEO);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aEP);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aEQ);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aER);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aES);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aET);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (adH() && filterParam != null) {
            this.cjy.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            i.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (adH() && filterParam != null && list != null) {
            this.cjy.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.cjy != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.cjy.updateFilterCase(str);
                return;
            }
            this.cjy.updateFilter(beautyType.type, str);
            a(beautyType, str);
        }
    }

    public void jF(String str) {
        if (isDebug()) {
            i.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.cjy != null) {
            this.cjy.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            i.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.B(fArr));
        }
        if (this.cjy != null && beautyType != null) {
            this.cjy.updateFilter(beautyType.type, fArr);
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

    public static String bz(Context context) {
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
        if (this.cjG != null && TextUtils.isEmpty(str)) {
            this.cjG.onFilterStateChanged(null, null);
        }
        if (adH()) {
            if (isDebug()) {
                i.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.cjy.loadCase(aRType, str, str2);
            bc(str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.cjy != null && this.cjy.getARProxyManager() != null && this.cjy.getARProxyManager().getCaptureAR() != null) {
            this.cjy.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.cjy != null && this.cjy.getARProxyManager() != null && this.cjy.getARProxyManager().getCaptureAR() != null) {
            this.cjy.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void k(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.cjy != null && this.cjy.getARProxyManager() != null && this.cjy.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.cjy.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.cjy.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean jG(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.cjE = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (cjt == null ? "" : " by: " + cjt.cjw));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void dY(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.cjF = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.cjH = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.cjG = filterStateListener;
    }

    public void clearCase() {
        if (this.cjG != null) {
            this.cjG.onFilterStateChanged(null, null);
        }
        if (this.cjy != null) {
            this.cjy.clearCase();
        }
    }

    private Texture V(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.cjy == null || (gLRenderer = this.cjy.getGLRenderer()) == null) {
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
        return (aVar == null || aVar.adI() || aVar.adF() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.cjy != null) {
            this.cjy.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.cjy != null) {
            this.cjy.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.cjy != null) {
            this.cjy.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
