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
    private static a bBb;
    private EGLContext bBd;
    private InterfaceC0221a bBe;
    private DuMixController bBg;
    private DuMixInput bBi;
    private DuMixOutput bBj;
    private FaceListener bBk;
    private LuaMsgListener bBl;
    FilterStateListener bBm;
    private DefinedLuaListener bBn;
    private Texture bBq;
    private Texture bBr;
    private long bBt;
    private long bBu;
    private Context mContext;
    public static final String bBa = c.Th();
    private static boolean bBc = false;
    private static final InterfaceC0221a bBo = null;
    private static boolean bBs = false;
    private boolean mPaused = false;
    private boolean bBf = false;
    private List<DuMixCallback> bBh = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean bBp = false;
    private int mOutputFPS = 0;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (z && a.this.bBg != null && b.SY() != null) {
                a aVar = a.this;
                b.SY();
                aVar.hL(c.cW(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.SY();
                aVar2.setBeautyValue(beautyType, c.Ti());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bBh.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bBh.get(i2);
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
                if (i2 < a.this.bBh.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bBh.get(i2);
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
                if (i2 < a.this.bBh.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bBh.get(i2);
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
                if (i2 < a.this.bBh.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bBh.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bBh.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            for (DuMixCallback duMixCallback : a.this.bBh) {
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
        this.bBd = eGLContext;
        this.bBe = interfaceC0221a;
        this.bBg = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bBg.checkAuth(bArr, null, null);
        }
        cV(false);
        this.bBg.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bBk != null) {
                    a.this.bBk.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bBk != null) {
                    a.this.bBk.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bBk != null) {
                    a.this.bBk.onTriggerFired(str);
                }
            }
        });
        this.bBg.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                if (a.this.bBl != null) {
                    return a.this.bBl.getMsgKeyListened();
                }
                return null;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.this.bBl != null) {
                    a.this.bBl.onLuaMessage(hashMap);
                }
            }
        });
        this.bBg.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.this.bBn != null) {
                    a.this.bBn.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.this.bBn != null) {
                    a.this.bBn.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bBg.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.this.bBm != null) {
                    a.this.bBm.onFilterStateChanged(hashMap, str);
                }
            }
        });
    }

    public static a a(Context context, InterfaceC0221a interfaceC0221a, byte[] bArr) {
        return a(context, interfaceC0221a, null, bArr);
    }

    public static a a(Context context, InterfaceC0221a interfaceC0221a, EGLContext eGLContext, byte[] bArr) {
        if (bBb == null || bBb.bBe != interfaceC0221a || bBb.bBd != eGLContext) {
            synchronized (a.class) {
                if (bBb == null || bBb.bBe != interfaceC0221a || bBb.bBd != eGLContext) {
                    if (bBb != null) {
                        InterfaceC0221a interfaceC0221a2 = bBb.bBe;
                        bBb.release();
                        if (interfaceC0221a2 != null) {
                            interfaceC0221a2.onHolderChanged(interfaceC0221a);
                        }
                    }
                    bBb = new a(context, interfaceC0221a, eGLContext, bArr);
                }
            }
        }
        return bBb;
    }

    public InterfaceC0221a ST() {
        return this.bBe;
    }

    public void resume() {
        if (bBb == this && this.bBg != null) {
            d("DuAr_DuController", "resume");
            this.bBg.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bBb == this && this.bBg != null) {
            d("DuAr_DuController", "pause");
            this.bBg.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bBb == this) {
            this.mPaused = false;
            this.bBf = true;
            this.bBe = bBo;
            DuMixController duMixController = this.bBg;
            this.bBg = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bBu = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bBu));
            }
            bBb = null;
            this.bBd = null;
        }
    }

    public boolean SU() {
        return this.bBp;
    }

    private boolean SV() {
        return (this.bBg == null || !SU() || isPaused()) ? false : true;
    }

    public boolean SW() {
        return this.bBf;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.bBd != null) {
            this.bBi = new DuMixInput2(this.bBq, i, i2);
            ((DuMixInput2) this.bBi).setSyncInputContent(bBs);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bBs);
            this.bBi.setInputDegree(0);
            return;
        }
        this.bBi = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (this.bBg != null) {
            this.bBt = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bBp) {
                this.bBi.setFrontCamera(z);
                if (this.bBd != null) {
                    this.bBr = S(i, i2);
                    this.bBj = new DuMixOutput2(this.bBr, i, i2);
                } else {
                    this.bBj = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bBj.setOutputFPS(this.mOutputFPS);
                }
                this.bBg.setup(this.bBi, this.bBj, this.mDuMixCallback);
                this.bBp = true;
                return;
            }
            this.bBg.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bBg != null && hashMap != null) {
            this.bBg.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (this.bBg != null && str != null) {
            this.bBg.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bBh.contains(duMixCallback)) {
            this.bBh.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.bBh.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (this.bBg != null && beautyType != null) {
            this.bBg.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null && this.bBg != null && beautyType != null) {
            this.bBg.updateFilter(beautyType.type, 1);
            this.bBg.updateFilterCase(makeup.getResPath());
            this.bBg.updateFilter(beautyType.type, makeup.getValue());
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (this.bBg != null && beautyType != null) {
            this.bBg.updateFilter(beautyType.type, f);
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bBg;
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
            a(SharpnessFilter.sharpness, bVar.azp);
            a(FilterParam.TuneColorFilter.brightness, bVar.azq);
            a(FilterParam.TuneColorFilter.contrast, bVar.azr);
            a(FilterParam.TuneColorFilter.saturation, bVar.azs);
            a(FilterParam.TuneColorFilter.curve, bVar.azt);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.azu);
            a(FilterParam.TuneColorFilter.redPoints, bVar.azv);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.azw);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.azx);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.azb);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.azc);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.azd);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aze);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.azf);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.azg);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.azh);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.azi);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.azj);
    }

    public void a(FilterParam filterParam, float f) {
        if (SV() && filterParam != null) {
            this.bBg.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (SV() && filterParam != null && list != null) {
            this.bBg.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (this.bBg != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bBg.updateFilterCase(str);
            } else {
                this.bBg.updateFilter(beautyType.type, str);
            }
        }
    }

    public void hL(String str) {
        if (this.bBg != null) {
            this.bBg.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (this.bBg != null && beautyType != null) {
            this.bBg.updateFilter(beautyType.type, fArr);
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
        if (this.bBm != null && TextUtils.isEmpty(str)) {
            this.bBm.onFilterStateChanged(null, null);
        }
        if (SV()) {
            this.bBg.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bBg != null && this.bBg.getARProxyManager() != null && this.bBg.getARProxyManager().getCaptureAR() != null) {
            this.bBg.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bBg != null && this.bBg.getARProxyManager() != null && this.bBg.getARProxyManager().getCaptureAR() != null) {
            this.bBg.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bBg != null && this.bBg.getARProxyManager() != null && this.bBg.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bBg.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bBg.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean hM(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bBk = faceListener;
    }

    private static void d(String str, String str2) {
    }

    public void cV(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bBl = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bBn = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bBm = filterStateListener;
    }

    public void clearCase() {
        if (this.bBm != null) {
            this.bBm.onFilterStateChanged(null, null);
        }
        if (this.bBg != null) {
            this.bBg.clearCase();
        }
    }

    private Texture S(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bBg == null || (gLRenderer = this.bBg.getGLRenderer()) == null) {
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
        if (this.bBg != null) {
            this.bBg.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bBg != null) {
            this.bBg.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bBg != null) {
            this.bBg.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
