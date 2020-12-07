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
import com.baidu.minivideo.arface.utils.g;
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
/* loaded from: classes8.dex */
public class a {
    private static a ccP;
    private static long cdm;
    private static String cdn;
    private EGLContext ccR;
    private InterfaceC0268a ccS;
    private DuMixController ccU;
    private DuMixInput ccW;
    private DuMixOutput ccX;
    private SurfaceTexture.OnFrameAvailableListener ccY;
    private SurfaceTexture.OnFrameAvailableListener ccZ;
    private FaceListener cda;
    private LuaMsgListener cdb;
    FilterStateListener cdc;
    private DefinedLuaListener cdd;
    private Texture cdg;
    private Texture cdh;
    private long cdj;
    private long cdk;
    private long cdl;
    private long cdo;
    private com.baidu.minivideo.arface.c.c cdp;
    private Makeup cdt;
    private Context mContext;
    private HandlerThread mHandlerThread;
    private Handler mThreadHandler;
    public static final String ccO = c.ack();
    private static boolean ccQ = false;
    private static final InterfaceC0268a cde = null;
    private static boolean cdi = false;
    private boolean mPaused = false;
    private boolean ccT = false;
    private List<DuMixCallback> ccV = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean cdf = false;
    private HashMap<BeautyType, String> cdq = new HashMap<>();
    private JSONObject cdr = new JSONObject();
    private JSONObject cds = new JSONObject();
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.7
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            a.this.cdk = System.currentTimeMillis() - a.this.cdj;
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + a.this.cdk);
            }
            a.this.dQ(z);
            a.this.cdq.clear();
            if (z && a.this.ccU != null && b.abY() != null) {
                a aVar = a.this;
                b.abY();
                aVar.jN(c.dS(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.abY();
                aVar2.setBeautyValue(beautyType, c.acl());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.ccV.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ccV.get(i2);
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
                if (i2 < a.this.ccV.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ccV.get(i2);
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
                if (i2 < a.this.ccV.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ccV.get(i2);
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
                if (i2 < a.this.ccV.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.ccV.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.ccV.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.ccV) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0268a {
        void onHolderChanged(InterfaceC0268a interfaceC0268a);
    }

    private a(Context context, InterfaceC0268a interfaceC0268a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0268a + ", eglCxt=" + eGLContext);
        }
        this.mHandlerThread = new HandlerThread("ARControllerProxy");
        this.mHandlerThread.start();
        this.mContext = context.getApplicationContext();
        this.ccR = eGLContext;
        this.ccS = interfaceC0268a;
        this.ccU = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            aw(this.ccU.checkAuth(bArr, null, null));
        } else {
            aw(null);
        }
        dR(false);
        this.ccU.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.cda != null) {
                    a.this.cda.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.cda != null) {
                    a.this.cda.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.cda != null) {
                    a.this.cda.onTriggerFired(str);
                }
            }
        });
        this.ccU.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.cdb != null ? a.this.cdb.getMsgKeyListened() : null;
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
                if (a.this.cdb != null) {
                    a.this.cdb.onLuaMessage(hashMap);
                }
            }
        });
        this.ccU.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.cdd != null) {
                    a.this.cdd.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.h(hashMap));
                }
                if (a.this.cdd != null) {
                    a.this.cdd.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.ccU.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.h(hashMap) + "\n" + str);
                }
                if (a.this.cdc != null) {
                    a.this.cdc.onFilterStateChanged(hashMap, str);
                }
            }
        });
        this.ccZ = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.minivideo.arface.a.5
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                a.this.cdp.acI();
                if (a.this.ccY != null) {
                    a.this.ccY.onFrameAvailable(surfaceTexture);
                }
            }
        };
        this.cdp = new com.baidu.minivideo.arface.c.c(AlaRecorderLog.KEY_CANERA_START_FPS, "ar");
        this.cdp.bI(5000L);
    }

    private Handler abQ() {
        if (this.mThreadHandler != null) {
            return this.mThreadHandler;
        }
        this.mThreadHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.minivideo.arface.a.6
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.abW();
                        return;
                    case 2:
                        a.this.abV();
                        return;
                    case 3:
                        a.C0269a c0269a = new a.C0269a();
                        c0269a.ceK = (int) com.baidu.minivideo.arface.c.b.acD().acF();
                        ActivityManager.MemoryInfo acE = com.baidu.minivideo.arface.c.b.acD().acE();
                        if (acE != null) {
                            c0269a.ceM = (acE.availMem / 1024) / 1024;
                            c0269a.ceL = (acE.totalMem / 1024) / 1024;
                        }
                        c0269a.fps = 0;
                        c0269a.ceN = 0L;
                        if (a.this.cdp.cfb > 0) {
                            c0269a.fps = (int) ((a.this.cdp.cfb * 1000) / a.this.cdp.cfa);
                            c0269a.ceN = a.this.cdp.cfa / a.this.cdp.cfb;
                        }
                        a.this.a(c0269a);
                        sendMessageDelayed(obtainMessage(3), 5000L);
                        return;
                    default:
                        return;
                }
            }
        };
        return this.mThreadHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(Map map) {
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
        if (ccP == null || ccP.ccS != interfaceC0268a || ccP.ccR != eGLContext) {
            synchronized (a.class) {
                if (ccP == null || ccP.ccS != interfaceC0268a || ccP.ccR != eGLContext) {
                    if (ccP != null) {
                        InterfaceC0268a interfaceC0268a2 = ccP.ccS;
                        ccP.release();
                        if (interfaceC0268a2 != null) {
                            interfaceC0268a2.onHolderChanged(interfaceC0268a);
                        }
                    }
                    ccP = new a(context, interfaceC0268a, eGLContext, bArr);
                }
            }
        }
        return ccP;
    }

    public InterfaceC0268a abR() {
        return this.ccS;
    }

    public void resume() {
        if (ccP == this) {
            if (this.ccU != null) {
                d("DuAr_DuController", "resume");
                this.ccU.resume();
                this.mPaused = false;
            }
            this.cdp.reset();
        }
    }

    public void pause() {
        if (ccP == this) {
            if (this.ccU != null) {
                d("DuAr_DuController", "pause");
                this.ccU.pause();
                this.mPaused = true;
            }
            this.cdp.reset();
        }
    }

    public void release() {
        if (ccP == this) {
            this.mPaused = false;
            this.ccT = true;
            this.ccS = cde;
            DuMixController duMixController = this.ccU;
            this.ccU = null;
            cdn = this.cdp.acK();
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.cdl = System.currentTimeMillis();
                duMixController.release();
                cdm = System.currentTimeMillis() - this.cdl;
                if (isDebug()) {
                    d("DuAr_DuController", Build.MODEL + ", release spendTime: " + cdm);
                }
            }
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            ccP = null;
            this.ccR = null;
        }
    }

    public boolean abS() {
        return this.cdf;
    }

    private boolean abT() {
        return (this.ccU == null || !abS() || isPaused()) ? false : true;
    }

    public boolean abU() {
        return this.ccT;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.ccR != null) {
            this.ccW = new DuMixInput2(this.cdg, i, i2);
            ((DuMixInput2) this.ccW).setSyncInputContent(cdi);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + cdi);
            this.ccW.setInputDegree(0);
            return;
        }
        this.ccW = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated frontCamera: " + z + ", surfaceTexture: " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.ccU != null) {
            this.ccY = onFrameAvailableListener;
            this.cdj = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(this.ccZ);
            }
            a(duMixCallback);
            if (!this.cdf) {
                this.ccW.setFrontCamera(z);
                if (this.ccR != null) {
                    this.cdh = V(i, i2);
                    this.ccX = new DuMixOutput2(this.cdh, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.ccX = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.ccX.setScreenOrientation(0);
                    } else {
                        this.ccX = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    if (isDebug()) {
                        d("DuAr_DuController", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                    }
                }
                if (this.mOutputFPS != 0) {
                    this.ccX.setOutputFPS(this.mOutputFPS);
                }
                this.cdo = System.currentTimeMillis();
                this.ccU.setup(this.ccW, this.ccX, this.mDuMixCallback);
                this.cdf = true;
                dP(true);
                k("output", this.ccX.getOutputWidth(), this.ccX.getOutputWidth());
                abQ().obtainMessage(3).sendToTarget();
                return;
            }
            this.ccU.changeOutputSize(i, i2);
            dP(false);
            k("output", i, i2);
        }
    }

    private void dP(boolean z) {
        File file = null;
        int i = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.cdo);
            if (this.ccW != null) {
                jSONObject.put("beauty_width", this.ccW.getInputWidth());
                jSONObject.put("beauty_height", this.ccW.getInputWidth());
                jSONObject.put("beauty_is_front_camera", this.ccW.isFrontCamera() ? 1 : 0);
                jSONObject.put("beauty_is_landscape", this.mIsLandscape ? 1 : 0);
                jSONObject.put("beauty_is_sync", cdi ? 1 : 0);
            }
            if (this.ccX != null) {
                jSONObject.put("beauty_out_width", this.ccX.getOutputWidth());
                jSONObject.put("beauty_out_height", this.ccX.getOutputHeight());
                jSONObject.put("beauty_out_fps", this.ccX.getOutputFPS());
            }
            jSONObject.put("beauty_is_resume", z ? 1 : 0);
            String acg = b.abY() != null ? c.acg() : null;
            if (!TextUtils.isEmpty(acg)) {
                b.abY();
                file = new File(c.acg());
            }
            if (acg == null) {
                acg = "null";
            }
            jSONObject.put("beauty_ar_path", acg);
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
    public void dQ(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("beauty_onsetup_ID", this.cdo);
            jSONObject.put("beauty_onsetup", z ? 1 : 0);
            jSONObject.put("beauty_onsetup_time", this.cdk);
            if (cdm != 0) {
                jSONObject.put("beauty_onsetup_release_time", cdm);
                cdm = 0L;
            }
            if (cdn != null) {
                jSONObject.put("beauty_release_frame_info", cdn);
                cdn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_start", jSONObject);
    }

    private void bd(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operating", TextUtils.isEmpty(str) ? TrackLoadSettingsAtom.TYPE : "unload");
            jSONObject.put(AlaLiveStickerInfo.STICKER_ID, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_sticker", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abV() {
        JSONObject jSONObject = new JSONObject();
        try {
            Makeup makeup = this.cdt;
            jSONObject.put("makeup_parameters", makeup == null ? "null" : makeup.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_makeup", jSONObject);
    }

    private void a(Makeup makeup) {
        this.cdt = makeup;
        abQ().removeMessages(2);
        abQ().sendMessageDelayed(abQ().obtainMessage(2), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abW() {
        JSONObject jSONObject = this.cds;
        try {
            jSONObject.put("beauty_parameters", this.cdr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report("beauty_face", jSONObject);
    }

    public void a(a.C0269a c0269a) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaRecorderLog.KEY_CANERA_START_FPS, c0269a.fps);
            jSONObject.put("cup", c0269a.ceK);
            jSONObject.put("memory_avalable", c0269a.ceM);
            jSONObject.put("memory_total", c0269a.ceL);
            jSONObject.put("frame_time", c0269a.ceN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.minivideo.arface.c.a.report(AlaRecorderLog.NAME_BEAUTY_PERFORMANCE, jSONObject);
    }

    private void a(BeautyType beautyType, Object obj) {
        if (beautyType != null) {
            try {
                this.cdr.put(beautyType.name(), obj);
                if (beautyType == BeautyType.beautyJsonPath) {
                    if (obj == null) {
                        this.cds.remove("feature_name");
                        this.cds.remove("feature_file_exist");
                    } else if (obj instanceof String) {
                        this.cds.put("feature_file_exist", new File((String) obj).exists() ? 1 : 0);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            abQ().removeMessages(1);
            abQ().sendMessageDelayed(abQ().obtainMessage(1), 500L);
        }
    }

    private void aw(List<Integer> list) {
        JSONObject jSONObject = this.cdr;
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
        JSONObject jSONObject = this.cdr;
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
        if (this.ccU != null && hashMap != null) {
            if (isDebug()) {
                g.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.ccU.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            g.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.ccU != null && str != null) {
            this.ccU.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.ccV.contains(duMixCallback)) {
            this.ccV.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.ccV.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            g.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.ccU != null && beautyType != null) {
            this.ccU.updateFilter(beautyType.type, i);
            a(beautyType, Integer.valueOf(i));
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        String str;
        if (makeup != null) {
            DuMixController duMixController = this.ccU;
            if (duMixController == null) {
                str = "";
            } else {
                if (beautyType != null) {
                    if (TextUtils.equals(this.cdq.get(beautyType), makeup.getResPath())) {
                        str = "";
                    } else {
                        str = duMixController.updateFilterCase(makeup.getResPath());
                        if (str != null) {
                            this.cdq.put(beautyType, makeup.getResPath());
                        }
                    }
                    duMixController.updateFilter(beautyType.type, makeup.getValue());
                } else {
                    this.cdq.clear();
                    str = duMixController.updateFilterCase(makeup.getResPath());
                }
                a(makeup);
            }
            if (isDebug()) {
                g.d("DuAr_DuController", " updateMakeup: " + beautyType + " = " + makeup.getInfo() + ", resResult: " + str);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (isDebug()) {
            g.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + f);
        }
        if (this.ccU != null && beautyType != null) {
            this.ccU.updateFilter(beautyType.type, f);
            a(beautyType, Float.valueOf(f));
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.ccU;
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
            a(SharpnessFilter.sharpness, bVar.aEI);
            a(FilterParam.TuneColorFilter.brightness, bVar.aEJ);
            a(FilterParam.TuneColorFilter.contrast, bVar.aEK);
            a(FilterParam.TuneColorFilter.saturation, bVar.aEL);
            a(FilterParam.TuneColorFilter.curve, bVar.aEM);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aEN);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aEO);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aEP);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aEQ);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aEu);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aEv);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aEw);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aEx);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aEy);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aEz);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aEA);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aEB);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aEC);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            g.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (abT() && filterParam != null) {
            this.ccU.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            g.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (abT() && filterParam != null && list != null) {
            this.ccU.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            g.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.ccU != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.ccU.updateFilterCase(str);
                return;
            }
            this.ccU.updateFilter(beautyType.type, str);
            a(beautyType, str);
        }
    }

    public void jN(String str) {
        if (isDebug()) {
            g.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.ccU != null) {
            this.ccU.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            g.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.F(fArr));
        }
        if (this.ccU != null && beautyType != null) {
            this.ccU.updateFilter(beautyType.type, fArr);
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

    public void i(Map<BeautyType, Object> map) {
        Map.Entry<BeautyType, Object> next;
        if (map != null) {
            Iterator<Map.Entry<BeautyType, Object>> it = map.entrySet().iterator();
            while (it.hasNext() && (next = it.next()) != null && next.getKey() != null) {
                setBeautyValue(next.getKey(), next.getValue());
            }
        }
    }

    public static String bo(Context context) {
        String soDownLoadDir = DuMixController.getSoDownLoadDir(context);
        if (isDebug()) {
            g.d("DuAr_DuController", " getSoDownloadDir: " + soDownLoadDir);
        }
        return soDownLoadDir;
    }

    public static int getVersion() {
        int versionCode = DuMixController.getVersionCode();
        if (isDebug()) {
            g.d("DuAr_DuController", " getSdkVersion: " + versionCode);
        }
        return versionCode;
    }

    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.cdc != null && TextUtils.isEmpty(str)) {
            this.cdc.onFilterStateChanged(null, null);
        }
        if (abT()) {
            if (isDebug()) {
                g.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.ccU.loadCase(aRType, str, str2);
            bd(str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.ccU != null && this.ccU.getARProxyManager() != null && this.ccU.getARProxyManager().getCaptureAR() != null) {
            this.ccU.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.ccU != null && this.ccU.getARProxyManager() != null && this.ccU.getARProxyManager().getCaptureAR() != null) {
            this.ccU.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.ccU != null && this.ccU.getARProxyManager() != null && this.ccU.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.ccU.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.ccU.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean jO(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.cda = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (ccP == null ? "" : " by: " + ccP.ccS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void dR(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.cdb = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.cdd = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.cdc = filterStateListener;
    }

    public void clearCase() {
        if (this.cdc != null) {
            this.cdc.onFilterStateChanged(null, null);
        }
        if (this.ccU != null) {
            this.ccU.clearCase();
        }
    }

    private Texture V(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.ccU == null || (gLRenderer = this.ccU.getGLRenderer()) == null) {
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
        return (aVar == null || aVar.abU() || aVar.abR() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.ccU != null) {
            this.ccU.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.ccU != null) {
            this.ccU.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.ccU != null) {
            this.ccU.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
