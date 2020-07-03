package com.baidu.minivideo.arface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static a bvb;
    private EGLContext bvd;
    private InterfaceC0211a bve;
    private DuMixController bvg;
    private DuMixInput bvi;
    private DuMixOutput bvj;
    private FaceListener bvk;
    private LuaMsgListener bvl;
    FilterStateListener bvm;
    private DefinedLuaListener bvn;
    private Texture bvq;
    private Texture bvr;
    private long bvt;
    private long bvu;
    private Context mContext;
    public static final String bva = c.Ni();
    private static boolean bvc = false;
    private static final InterfaceC0211a bvo = null;
    private static boolean bvs = false;
    private boolean mPaused = false;
    private boolean bvf = false;
    private List<DuMixCallback> bvh = new ArrayList();
    private int mInputWidth = 1280;
    private int mInputHeight = 720;
    private boolean bvp = false;
    private volatile boolean bvv = false;
    private volatile boolean bvw = false;
    private volatile boolean mIsOverrideParm = false;
    private int mOutputFPS = 0;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (z && a.this.bvg != null && b.MZ() != null) {
                a aVar = a.this;
                b.MZ();
                aVar.gr(c.cM(a.this.bvv));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.MZ();
                aVar2.setBeautyValue(beautyType, c.Nj());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bvh.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bvh.get(i2);
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
                if (i2 < a.this.bvh.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bvh.get(i2);
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
                if (i2 < a.this.bvh.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bvh.get(i2);
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
                if (i2 < a.this.bvh.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bvh.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bvh.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            for (DuMixCallback duMixCallback : a.this.bvh) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0211a {
        void onHolderChanged(InterfaceC0211a interfaceC0211a);
    }

    public static boolean MQ() {
        if (bvc) {
            return bvc;
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
            bvc = true;
        } catch (Throwable th) {
            g.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            bvc = false;
        }
        return bvc;
    }

    private a(Context context, InterfaceC0211a interfaceC0211a, EGLContext eGLContext, byte[] bArr) {
        this.mContext = context.getApplicationContext();
        this.bvd = eGLContext;
        this.bve = interfaceC0211a;
        this.bvg = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bvg.checkAuth(bArr, null, null);
        }
        cL(false);
        this.bvg.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bvk != null) {
                    a.this.bvk.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bvk != null) {
                    a.this.bvk.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bvk != null) {
                    a.this.bvk.onTriggerFired(str);
                }
            }
        });
        this.bvg.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                if (a.this.bvl != null) {
                    return a.this.bvl.getMsgKeyListened();
                }
                return null;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.this.bvl != null) {
                    a.this.bvl.onLuaMessage(hashMap);
                }
            }
        });
        this.bvg.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.this.bvn != null) {
                    a.this.bvn.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.this.bvn != null) {
                    a.this.bvn.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bvg.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.this.bvm != null) {
                    a.this.bvm.onFilterStateChanged(hashMap, str);
                }
            }
        });
    }

    public static a a(Context context, InterfaceC0211a interfaceC0211a, byte[] bArr) {
        return a(context, interfaceC0211a, null, bArr);
    }

    public static a a(Context context, InterfaceC0211a interfaceC0211a, EGLContext eGLContext, byte[] bArr) {
        if (bvb == null || bvb.bve != interfaceC0211a || bvb.bvd != eGLContext) {
            synchronized (a.class) {
                if (bvb == null || bvb.bve != interfaceC0211a || bvb.bvd != eGLContext) {
                    if (bvb != null) {
                        InterfaceC0211a interfaceC0211a2 = bvb.bve;
                        bvb.release();
                        if (interfaceC0211a2 != null) {
                            interfaceC0211a2.onHolderChanged(interfaceC0211a);
                        }
                    }
                    bvb = new a(context, interfaceC0211a, eGLContext, bArr);
                }
            }
        }
        return bvb;
    }

    public InterfaceC0211a MR() {
        return this.bve;
    }

    public void resume() {
        if (bvb == this && this.bvg != null) {
            d("DuAr_DuController", "resume");
            this.bvg.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bvb == this && this.bvg != null) {
            d("DuAr_DuController", "pause");
            this.bvg.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bvb == this) {
            this.mPaused = false;
            this.bvf = true;
            this.bve = bvo;
            DuMixController duMixController = this.bvg;
            this.bvg = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bvu = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bvu));
            }
            bvb = null;
            this.bvd = null;
        }
    }

    public boolean MS() {
        return this.bvp;
    }

    private boolean MT() {
        return (this.bvg == null || !MS() || isPaused()) ? false : true;
    }

    public boolean MU() {
        return this.bvf;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.bvd != null) {
            this.bvi = new DuMixInput2(this.bvq, i, i2);
            ((DuMixInput2) this.bvi).setSyncInputContent(bvs);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bvs);
            this.bvi.setInputDegree(0);
            return;
        }
        this.bvi = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (this.bvg != null) {
            this.bvv = z;
            this.bvt = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bvp) {
                if (this.bvd != null) {
                    this.bvr = O(i, i2);
                    this.bvj = new DuMixOutput2(this.bvr, i, i2);
                } else {
                    this.bvj = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bvj.setOutputFPS(this.mOutputFPS);
                }
                this.bvg.setup(this.bvi, this.bvj, this.mDuMixCallback);
                this.bvp = true;
                return;
            }
            this.bvg.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bvg != null && hashMap != null) {
            this.bvg.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (this.bvg != null && str != null) {
            this.bvg.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bvh.contains(duMixCallback)) {
            this.bvh.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.bvh.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (this.bvg != null && beautyType != null) {
            this.bvg.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null && this.bvg != null && beautyType != null) {
            this.bvg.updateFilter(beautyType.type, 1);
            this.bvg.updateFilterCase(makeup.getResPath());
            this.bvg.updateFilter(beautyType.type, makeup.getValue());
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (this.bvg != null && beautyType != null) {
            this.bvg.updateFilter(beautyType.type, f);
        }
    }

    public void setOverrideDefaultParm(boolean z) {
        this.mIsOverrideParm = z;
        if (this.bvw) {
            MX();
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bvg;
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
            a(SharpnessFilter.sharpness, bVar.aur);
            a(FilterParam.TuneColorFilter.brightness, bVar.aus);
            a(FilterParam.TuneColorFilter.contrast, bVar.aut);
            a(FilterParam.TuneColorFilter.saturation, bVar.auu);
            a(FilterParam.TuneColorFilter.curve, bVar.auv);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.auw);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aux);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.auy);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.auz);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aud);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aue);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.auf);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aug);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.auh);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aui);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.auj);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.auk);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aul);
    }

    public void a(FilterParam filterParam, float f) {
        if (MT() && filterParam != null) {
            this.bvg.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (MT() && filterParam != null && list != null) {
            this.bvg.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (this.bvg != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bvg.updateFilterCase(str);
            } else {
                this.bvg.updateFilter(beautyType.type, str);
            }
        }
    }

    public void gr(String str) {
        if (this.bvg != null) {
            this.bvg.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (this.bvg != null && beautyType != null) {
            this.bvg.updateFilter(beautyType.type, fArr);
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

    public static String aB(Context context) {
        return DuMixController.getSoDownLoadDir(context);
    }

    public static int getVersion() {
        return DuMixController.getVersionCode();
    }

    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.bvm != null && TextUtils.isEmpty(str)) {
            this.bvm.onFilterStateChanged(null, null);
        }
        if (MT()) {
            this.bvg.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bvg != null && this.bvg.getARProxyManager() != null && this.bvg.getARProxyManager().getCaptureAR() != null) {
            this.bvg.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bvg != null && this.bvg.getARProxyManager() != null && this.bvg.getARProxyManager().getCaptureAR() != null) {
            this.bvg.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void h(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bvg != null && this.bvg.getARProxyManager() != null && this.bvg.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bvg.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bvg.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean gt(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bvk = faceListener;
    }

    private static void d(String str, String str2) {
    }

    public void cL(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bvl = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bvn = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bvm = filterStateListener;
    }

    public void clearCase() {
        if (this.bvm != null) {
            this.bvm.onFilterStateChanged(null, null);
        }
        if (this.bvg != null) {
            this.bvg.clearCase();
        }
    }

    private Texture O(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bvg == null || (gLRenderer = this.bvg.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.MU() || aVar.MR() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bvg != null) {
            this.bvg.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bvg != null) {
            this.bvg.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bvg != null) {
            this.bvg.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }

    private void MV() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Point(0, 0));
        arrayList2.add(new Point(75, 61));
        arrayList2.add(new Point(175, 172));
        arrayList2.add(new Point(255, 255));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new Point(0, 0));
        arrayList3.add(new Point(121, 122));
        arrayList3.add(new Point(255, 255));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new Point(0, 0));
        arrayList4.add(new Point(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 117));
        arrayList4.add(new Point(255, 255));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new Point(0, 0));
        arrayList5.add(new Point(127, 111));
        arrayList5.add(new Point(255, 255));
        arrayList.add(arrayList2);
        arrayList.add(arrayList3);
        arrayList.add(arrayList4);
        arrayList.add(arrayList5);
        setCurve(arrayList);
    }

    private void MW() {
        if (this.bvg != null) {
            this.bvg.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, 0.03f);
            this.bvg.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.bvg.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }

    public void resetAllQualityParm() {
        if (this.bvg != null && this.bvv) {
            MV();
            MW();
        }
    }

    public void MX() {
        if (this.bvg != null && this.bvv) {
            MV();
            this.bvg.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, -0.01f);
            this.bvg.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.bvg.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }
}
