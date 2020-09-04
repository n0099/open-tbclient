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
/* loaded from: classes6.dex */
public class a {
    private static a bBe;
    private EGLContext bBg;
    private InterfaceC0221a bBh;
    private DuMixController bBj;
    private DuMixInput bBl;
    private DuMixOutput bBm;
    private FaceListener bBn;
    private LuaMsgListener bBo;
    FilterStateListener bBp;
    private DefinedLuaListener bBq;
    private Texture bBt;
    private Texture bBu;
    private long bBw;
    private long bBx;
    private Context mContext;
    public static final String bBd = c.Th();
    private static boolean bBf = false;
    private static final InterfaceC0221a bBr = null;
    private static boolean bBv = false;
    private boolean mPaused = false;
    private boolean bBi = false;
    private List<DuMixCallback> bBk = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean bBs = false;
    private int mOutputFPS = 0;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (z && a.this.bBj != null && b.SY() != null) {
                a aVar = a.this;
                b.SY();
                aVar.hM(c.cX(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.SY();
                aVar2.setBeautyValue(beautyType, c.Ti());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bBk.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bBk.get(i2);
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
                if (i2 < a.this.bBk.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bBk.get(i2);
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
                if (i2 < a.this.bBk.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bBk.get(i2);
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
                if (i2 < a.this.bBk.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bBk.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bBk.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            for (DuMixCallback duMixCallback : a.this.bBk) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0221a {
        void onHolderChanged(InterfaceC0221a interfaceC0221a);
    }

    private a(Context context, InterfaceC0221a interfaceC0221a, EGLContext eGLContext, byte[] bArr) {
        this.mContext = context.getApplicationContext();
        this.bBg = eGLContext;
        this.bBh = interfaceC0221a;
        this.bBj = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bBj.checkAuth(bArr, null, null);
        }
        cW(false);
        this.bBj.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bBn != null) {
                    a.this.bBn.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bBn != null) {
                    a.this.bBn.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bBn != null) {
                    a.this.bBn.onTriggerFired(str);
                }
            }
        });
        this.bBj.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                if (a.this.bBo != null) {
                    return a.this.bBo.getMsgKeyListened();
                }
                return null;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.this.bBo != null) {
                    a.this.bBo.onLuaMessage(hashMap);
                }
            }
        });
        this.bBj.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.this.bBq != null) {
                    a.this.bBq.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.this.bBq != null) {
                    a.this.bBq.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bBj.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.this.bBp != null) {
                    a.this.bBp.onFilterStateChanged(hashMap, str);
                }
            }
        });
    }

    public static a a(Context context, InterfaceC0221a interfaceC0221a, byte[] bArr) {
        return a(context, interfaceC0221a, null, bArr);
    }

    public static a a(Context context, InterfaceC0221a interfaceC0221a, EGLContext eGLContext, byte[] bArr) {
        if (bBe == null || bBe.bBh != interfaceC0221a || bBe.bBg != eGLContext) {
            synchronized (a.class) {
                if (bBe == null || bBe.bBh != interfaceC0221a || bBe.bBg != eGLContext) {
                    if (bBe != null) {
                        InterfaceC0221a interfaceC0221a2 = bBe.bBh;
                        bBe.release();
                        if (interfaceC0221a2 != null) {
                            interfaceC0221a2.onHolderChanged(interfaceC0221a);
                        }
                    }
                    bBe = new a(context, interfaceC0221a, eGLContext, bArr);
                }
            }
        }
        return bBe;
    }

    public InterfaceC0221a ST() {
        return this.bBh;
    }

    public void resume() {
        if (bBe == this && this.bBj != null) {
            d("DuAr_DuController", "resume");
            this.bBj.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bBe == this && this.bBj != null) {
            d("DuAr_DuController", "pause");
            this.bBj.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bBe == this) {
            this.mPaused = false;
            this.bBi = true;
            this.bBh = bBr;
            DuMixController duMixController = this.bBj;
            this.bBj = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bBx = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bBx));
            }
            bBe = null;
            this.bBg = null;
        }
    }

    public boolean SU() {
        return this.bBs;
    }

    private boolean SV() {
        return (this.bBj == null || !SU() || isPaused()) ? false : true;
    }

    public boolean SW() {
        return this.bBi;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.bBg != null) {
            this.bBl = new DuMixInput2(this.bBt, i, i2);
            ((DuMixInput2) this.bBl).setSyncInputContent(bBv);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bBv);
            this.bBl.setInputDegree(0);
            return;
        }
        this.bBl = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (this.bBj != null) {
            this.bBw = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bBs) {
                this.bBl.setFrontCamera(z);
                if (this.bBg != null) {
                    this.bBu = S(i, i2);
                    this.bBm = new DuMixOutput2(this.bBu, i, i2);
                } else {
                    this.bBm = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bBm.setOutputFPS(this.mOutputFPS);
                }
                this.bBj.setup(this.bBl, this.bBm, this.mDuMixCallback);
                this.bBs = true;
                return;
            }
            this.bBj.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bBj != null && hashMap != null) {
            this.bBj.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (this.bBj != null && str != null) {
            this.bBj.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bBk.contains(duMixCallback)) {
            this.bBk.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.bBk.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (this.bBj != null && beautyType != null) {
            this.bBj.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null && this.bBj != null && beautyType != null) {
            this.bBj.updateFilter(beautyType.type, 1);
            this.bBj.updateFilterCase(makeup.getResPath());
            this.bBj.updateFilter(beautyType.type, makeup.getValue());
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (this.bBj != null && beautyType != null) {
            this.bBj.updateFilter(beautyType.type, f);
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bBj;
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
            a(SharpnessFilter.sharpness, bVar.azr);
            a(FilterParam.TuneColorFilter.brightness, bVar.azs);
            a(FilterParam.TuneColorFilter.contrast, bVar.azt);
            a(FilterParam.TuneColorFilter.saturation, bVar.azu);
            a(FilterParam.TuneColorFilter.curve, bVar.azv);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.azw);
            a(FilterParam.TuneColorFilter.redPoints, bVar.azx);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.azy);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.azz);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.azd);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aze);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.azf);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.azg);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.azh);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.azi);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.azj);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.azk);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.azl);
    }

    public void a(FilterParam filterParam, float f) {
        if (SV() && filterParam != null) {
            this.bBj.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (SV() && filterParam != null && list != null) {
            this.bBj.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (this.bBj != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bBj.updateFilterCase(str);
            } else {
                this.bBj.updateFilter(beautyType.type, str);
            }
        }
    }

    public void hM(String str) {
        if (this.bBj != null) {
            this.bBj.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (this.bBj != null && beautyType != null) {
            this.bBj.updateFilter(beautyType.type, fArr);
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
        if (this.bBp != null && TextUtils.isEmpty(str)) {
            this.bBp.onFilterStateChanged(null, null);
        }
        if (SV()) {
            this.bBj.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bBj != null && this.bBj.getARProxyManager() != null && this.bBj.getARProxyManager().getCaptureAR() != null) {
            this.bBj.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bBj != null && this.bBj.getARProxyManager() != null && this.bBj.getARProxyManager().getCaptureAR() != null) {
            this.bBj.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bBj != null && this.bBj.getARProxyManager() != null && this.bBj.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bBj.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bBj.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean hN(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bBn = faceListener;
    }

    private static void d(String str, String str2) {
    }

    public void cW(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bBo = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bBq = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bBp = filterStateListener;
    }

    public void clearCase() {
        if (this.bBp != null) {
            this.bBp.onFilterStateChanged(null, null);
        }
        if (this.bBj != null) {
            this.bBj.clearCase();
        }
    }

    private Texture S(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bBj == null || (gLRenderer = this.bBj.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.SW() || aVar.ST() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bBj != null) {
            this.bBj.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bBj != null) {
            this.bBj.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bBj != null) {
            this.bBj.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
