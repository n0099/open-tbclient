package com.baidu.minivideo.arface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Build;
import android.text.TextUtils;
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
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.arface.bean.Makeup;
import com.baidu.minivideo.arface.bean.SharpnessFilter;
import com.baidu.minivideo.arface.utils.g;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static a bEB;
    private EGLContext bED;
    private InterfaceC0220a bEE;
    private DuMixController bEG;
    private DuMixInput bEI;
    private DuMixOutput bEJ;
    private FaceListener bEK;
    private LuaMsgListener bEL;
    FilterStateListener bEM;
    private DefinedLuaListener bEN;
    private Texture bEQ;
    private Texture bER;
    private long bET;
    private long bEU;
    private Context mContext;
    public static final String bEA = c.TY();
    private static boolean bEC = false;
    private static final InterfaceC0220a bEO = null;
    private static boolean bES = false;
    private boolean mPaused = false;
    private boolean bEF = false;
    private List<DuMixCallback> bEH = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean bEP = false;
    private int mOutputFPS = 0;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (z && a.this.bEG != null && b.TP() != null) {
                a aVar = a.this;
                b.TP();
                aVar.ii(c.cY(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.TP();
                aVar2.setBeautyValue(beautyType, c.TZ());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bEH.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bEH.get(i2);
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
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bEH.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bEH.get(i2);
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
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bEH.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bEH.get(i2);
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
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bEH.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bEH.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bEH.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            for (DuMixCallback duMixCallback : a.this.bEH) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0220a {
        void onHolderChanged(InterfaceC0220a interfaceC0220a);
    }

    private a(Context context, InterfaceC0220a interfaceC0220a, EGLContext eGLContext, byte[] bArr) {
        this.mContext = context.getApplicationContext();
        this.bED = eGLContext;
        this.bEE = interfaceC0220a;
        this.bEG = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bEG.checkAuth(bArr, null, null);
        }
        cX(false);
        this.bEG.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bEK != null) {
                    a.this.bEK.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bEK != null) {
                    a.this.bEK.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bEK != null) {
                    a.this.bEK.onTriggerFired(str);
                }
            }
        });
        this.bEG.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                if (a.this.bEL != null) {
                    return a.this.bEL.getMsgKeyListened();
                }
                return null;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.this.bEL != null) {
                    a.this.bEL.onLuaMessage(hashMap);
                }
            }
        });
        this.bEG.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.this.bEN != null) {
                    a.this.bEN.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.this.bEN != null) {
                    a.this.bEN.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bEG.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.this.bEM != null) {
                    a.this.bEM.onFilterStateChanged(hashMap, str);
                }
            }
        });
    }

    public static a a(Context context, InterfaceC0220a interfaceC0220a, byte[] bArr) {
        return a(context, interfaceC0220a, null, bArr);
    }

    public static a a(Context context, InterfaceC0220a interfaceC0220a, EGLContext eGLContext, byte[] bArr) {
        if (bEB == null || bEB.bEE != interfaceC0220a || bEB.bED != eGLContext) {
            synchronized (a.class) {
                if (bEB == null || bEB.bEE != interfaceC0220a || bEB.bED != eGLContext) {
                    if (bEB != null) {
                        InterfaceC0220a interfaceC0220a2 = bEB.bEE;
                        bEB.release();
                        if (interfaceC0220a2 != null) {
                            interfaceC0220a2.onHolderChanged(interfaceC0220a);
                        }
                    }
                    bEB = new a(context, interfaceC0220a, eGLContext, bArr);
                }
            }
        }
        return bEB;
    }

    public InterfaceC0220a TK() {
        return this.bEE;
    }

    public void resume() {
        if (bEB == this && this.bEG != null) {
            d("DuAr_DuController", "resume");
            this.bEG.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bEB == this && this.bEG != null) {
            d("DuAr_DuController", "pause");
            this.bEG.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bEB == this) {
            this.mPaused = false;
            this.bEF = true;
            this.bEE = bEO;
            DuMixController duMixController = this.bEG;
            this.bEG = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bEU = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bEU));
            }
            bEB = null;
            this.bED = null;
        }
    }

    public boolean TL() {
        return this.bEP;
    }

    private boolean TM() {
        return (this.bEG == null || !TL() || isPaused()) ? false : true;
    }

    public boolean TN() {
        return this.bEF;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.bED != null) {
            this.bEI = new DuMixInput2(this.bEQ, i, i2);
            ((DuMixInput2) this.bEI).setSyncInputContent(bES);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bES);
            this.bEI.setInputDegree(0);
            return;
        }
        this.bEI = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (this.bEG != null) {
            this.bET = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bEP) {
                this.bEI.setFrontCamera(z);
                if (this.bED != null) {
                    this.bER = S(i, i2);
                    this.bEJ = new DuMixOutput2(this.bER, i, i2);
                } else {
                    this.bEJ = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bEJ.setOutputFPS(this.mOutputFPS);
                }
                this.bEG.setup(this.bEI, this.bEJ, this.mDuMixCallback);
                this.bEP = true;
                return;
            }
            this.bEG.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bEG != null && hashMap != null) {
            this.bEG.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (this.bEG != null && str != null) {
            this.bEG.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bEH.contains(duMixCallback)) {
            this.bEH.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.bEH.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (this.bEG != null && beautyType != null) {
            this.bEG.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null && this.bEG != null && beautyType != null) {
            this.bEG.updateFilter(beautyType.type, 1);
            this.bEG.updateFilterCase(makeup.getResPath());
            this.bEG.updateFilter(beautyType.type, makeup.getValue());
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (this.bEG != null && beautyType != null) {
            this.bEG.updateFilter(beautyType.type, f);
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bEG;
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
            a(SharpnessFilter.sharpness, bVar.azX);
            a(FilterParam.TuneColorFilter.brightness, bVar.azY);
            a(FilterParam.TuneColorFilter.contrast, bVar.azZ);
            a(FilterParam.TuneColorFilter.saturation, bVar.aAa);
            a(FilterParam.TuneColorFilter.curve, bVar.aAb);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aAc);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aAd);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aAe);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aAf);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.azJ);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.azK);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.azL);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.azM);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.azN);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.azO);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.azP);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.azQ);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.azR);
    }

    public void a(FilterParam filterParam, float f) {
        if (TM() && filterParam != null) {
            this.bEG.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (TM() && filterParam != null && list != null) {
            this.bEG.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (this.bEG != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bEG.updateFilterCase(str);
            } else {
                this.bEG.updateFilter(beautyType.type, str);
            }
        }
    }

    public void ii(String str) {
        if (this.bEG != null) {
            this.bEG.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (this.bEG != null && beautyType != null) {
            this.bEG.updateFilter(beautyType.type, fArr);
        }
    }

    public void h(Map<BeautyType, Object> map) {
        Map.Entry<BeautyType, Object> next;
        if (map != null) {
            Iterator<Map.Entry<BeautyType, Object>> it = map.entrySet().iterator();
            while (it.hasNext() && (next = it.next()) != null && next.getKey() != null) {
                Object value = next.getValue();
                if (value instanceof Integer) {
                    setBeautyValue(next.getKey(), ((Integer) value).intValue());
                } else if (value instanceof Float) {
                    setBeautyValue(next.getKey(), ((Float) value).floatValue());
                } else if (value instanceof String) {
                    setBeautyValue(next.getKey(), (String) value);
                } else if (value instanceof float[]) {
                    setBeautyValue(next.getKey(), (float[]) value);
                } else if (value instanceof Double) {
                    setBeautyValue(next.getKey(), new Float(((Double) value).doubleValue()).floatValue());
                } else if (value instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) value;
                    int size = arrayList.size();
                    float[] fArr = new float[size];
                    for (int i = 0; i < size; i++) {
                        if (arrayList.get(i) instanceof Double) {
                            fArr[i] = new Float(((Double) arrayList.get(i)).doubleValue()).floatValue();
                        }
                    }
                    setBeautyValue(next.getKey(), fArr);
                } else if (value instanceof Makeup) {
                    a(next.getKey(), (Makeup) value);
                }
            }
        }
    }

    public static String aG(Context context) {
        return DuMixController.getSoDownLoadDir(context);
    }

    public static int getVersion() {
        return DuMixController.getVersionCode();
    }

    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.bEM != null && TextUtils.isEmpty(str)) {
            this.bEM.onFilterStateChanged(null, null);
        }
        if (TM()) {
            this.bEG.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bEG != null && this.bEG.getARProxyManager() != null && this.bEG.getARProxyManager().getCaptureAR() != null) {
            this.bEG.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bEG != null && this.bEG.getARProxyManager() != null && this.bEG.getARProxyManager().getCaptureAR() != null) {
            this.bEG.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bEG != null && this.bEG.getARProxyManager() != null && this.bEG.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bEG.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bEG.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean ij(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bEK = faceListener;
    }

    private static void d(String str, String str2) {
    }

    public void cX(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bEL = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bEN = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bEM = filterStateListener;
    }

    public void clearCase() {
        if (this.bEM != null) {
            this.bEM.onFilterStateChanged(null, null);
        }
        if (this.bEG != null) {
            this.bEG.clearCase();
        }
    }

    private Texture S(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bEG == null || (gLRenderer = this.bEG.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.TN() || aVar.TK() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bEG != null) {
            this.bEG.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bEG != null) {
            this.bEG.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bEG != null) {
            this.bEG.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
