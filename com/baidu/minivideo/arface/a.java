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
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.minivideo.arface.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static a biA;
    private EGLContext biC;
    private InterfaceC0151a biD;
    private DuMixController biF;
    private DuMixInput biH;
    private DuMixOutput biI;
    private FaceListener biJ;
    private LuaMsgListener biK;
    FilterStateListener biL;
    private DefinedLuaListener biM;
    private Texture biP;
    private Texture biQ;
    private long biS;
    private long biT;
    private Context mContext;
    public static final String biz = c.Kf();
    private static boolean biB = false;
    private static final InterfaceC0151a biN = null;
    private static boolean biR = false;
    private boolean mPaused = false;
    private boolean biE = false;
    private List<DuMixCallback> biG = new ArrayList();
    private int mInputWidth = 1280;
    private int mInputHeight = 720;
    private boolean biO = false;
    private volatile boolean biU = false;
    private volatile boolean biV = false;
    private volatile boolean mIsOverrideParm = false;
    private int mOutputFPS = 0;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(final boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (z && a.this.biF != null) {
                ThreadPool.Kk().execute(new Runnable() { // from class: com.baidu.minivideo.arface.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z && a.this.biF != null && b.JY() != null) {
                            a aVar = a.this;
                            b.JY();
                            aVar.fx(c.cv(a.this.biU));
                            a aVar2 = a.this;
                            BeautyType beautyType = BeautyType.beautyJsonPath;
                            b.JY();
                            aVar2.setBeautyValue(beautyType, c.Kg());
                        }
                        if (z && a.this.biF != null) {
                            a.this.ct(a.this.biU);
                        }
                        a.this.biV = true;
                        if (a.this.mIsOverrideParm) {
                            a.this.JW();
                        }
                    }
                });
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.biG.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.biG.get(i2);
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
                if (i2 < a.this.biG.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.biG.get(i2);
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
                if (i2 < a.this.biG.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.biG.get(i2);
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
                if (i2 < a.this.biG.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.biG.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.biG.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            for (DuMixCallback duMixCallback : a.this.biG) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0151a {
        void onHolderChanged(InterfaceC0151a interfaceC0151a);
    }

    public static boolean JP() {
        if (biB) {
            return biB;
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
            biB = true;
        } catch (Throwable th) {
            g.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            biB = false;
        }
        return biB;
    }

    private a(Context context, InterfaceC0151a interfaceC0151a, EGLContext eGLContext, byte[] bArr) {
        this.mContext = context.getApplicationContext();
        this.biC = eGLContext;
        this.biD = interfaceC0151a;
        this.biF = new DuMixController(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.biF.checkAuth(bArr, null, null);
        }
        cu(false);
        this.biF.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.biJ != null) {
                    a.this.biJ.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.biJ != null) {
                    a.this.biJ.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.biJ != null) {
                    a.this.biJ.onTriggerFired(str);
                }
            }
        });
        this.biF.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                if (a.this.biK != null) {
                    return a.this.biK.getMsgKeyListened();
                }
                return null;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.this.biK != null) {
                    a.this.biK.onLuaMessage(hashMap);
                }
            }
        });
        this.biF.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.this.biM != null) {
                    a.this.biM.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.this.biM != null) {
                    a.this.biM.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.biF.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.this.biL != null) {
                    a.this.biL.onFilterStateChanged(hashMap, str);
                }
            }
        });
    }

    public static a a(Context context, InterfaceC0151a interfaceC0151a, byte[] bArr) {
        return a(context, interfaceC0151a, null, bArr);
    }

    public static a a(Context context, InterfaceC0151a interfaceC0151a, EGLContext eGLContext, byte[] bArr) {
        if (biA == null || biA.biD != interfaceC0151a || biA.biC != eGLContext) {
            synchronized (a.class) {
                if (biA == null || biA.biD != interfaceC0151a || biA.biC != eGLContext) {
                    if (biA != null) {
                        InterfaceC0151a interfaceC0151a2 = biA.biD;
                        biA.release();
                        if (interfaceC0151a2 != null) {
                            interfaceC0151a2.onHolderChanged(interfaceC0151a);
                        }
                    }
                    biA = new a(context, interfaceC0151a, eGLContext, bArr);
                }
            }
        }
        return biA;
    }

    public InterfaceC0151a JQ() {
        return this.biD;
    }

    public void resume() {
        if (biA == this && this.biF != null) {
            d("DuAr_DuController", "resume");
            this.biF.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (biA == this && this.biF != null) {
            d("DuAr_DuController", "pause");
            this.biF.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (biA == this) {
            this.mPaused = false;
            this.biE = true;
            this.biD = biN;
            DuMixController duMixController = this.biF;
            this.biF = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.biT = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.biT));
            }
            biA = null;
            this.biC = null;
        }
    }

    public boolean JR() {
        return this.biO;
    }

    private boolean JS() {
        return (this.biF == null || !JR() || isPaused()) ? false : true;
    }

    public boolean JT() {
        return this.biE;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.biC != null) {
            this.biH = new DuMixInput2(this.biP, i, i2);
            ((DuMixInput2) this.biH).setSyncInputContent(biR);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + biR);
            this.biH.setInputDegree(0);
            return;
        }
        this.biH = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (this.biF != null) {
            this.biU = z;
            this.biS = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.biO) {
                if (this.biC != null) {
                    this.biQ = J(i, i2);
                    this.biI = new DuMixOutput2(this.biQ, i, i2);
                } else {
                    this.biI = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.biI.setOutputFPS(this.mOutputFPS);
                }
                this.biF.setup(this.biH, this.biI, this.mDuMixCallback);
                this.biO = true;
                return;
            }
            this.biF.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.biF != null && hashMap != null) {
            this.biF.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (this.biF != null && str != null) {
            this.biF.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.biG.contains(duMixCallback)) {
            this.biG.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.biG.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (this.biF != null && beautyType != null) {
            this.biF.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null && this.biF != null && beautyType != null) {
            this.biF.updateFilter(beautyType.type, 1);
            this.biF.updateFilterCase(makeup.getResPath());
            this.biF.updateFilter(beautyType.type, makeup.getValue());
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (this.biF != null && beautyType != null) {
            this.biF.updateFilter(beautyType.type, f);
        }
    }

    public void setOverrideDefaultParm(boolean z) {
        this.mIsOverrideParm = z;
        if (this.biV) {
            JW();
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.biF;
        if (duMixController != null && list != null) {
            duMixController.updateFilter(FilterParam.TuneColorFilter.rgbPoints, list.get(0));
            duMixController.updateFilter(FilterParam.TuneColorFilter.redPoints, list.get(1));
            duMixController.updateFilter(FilterParam.TuneColorFilter.greenPoints, list.get(2));
            duMixController.updateFilter(FilterParam.TuneColorFilter.bluePoints, list.get(3));
            duMixController.updateFilter((FilterParam) FilterParam.TuneColorFilter.curve, 0.9f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(boolean z) {
        if (!z) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Point(0, 0));
            arrayList2.add(new Point(255, 255));
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(new Point(0, 0));
            arrayList3.add(new Point(255, 255));
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(new Point(0, 0));
            arrayList4.add(new Point(255, 255));
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(new Point(0, 0));
            arrayList5.add(new Point(255, 255));
            arrayList.add(arrayList2);
            arrayList.add(arrayList3);
            arrayList.add(arrayList4);
            arrayList.add(arrayList5);
            setCurve(arrayList);
            return;
        }
        JU();
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (this.biF != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.biF.updateFilterCase(str);
            } else {
                this.biF.updateFilter(beautyType.type, str);
            }
        }
    }

    public void fx(String str) {
        if (this.biF != null) {
            this.biF.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (this.biF != null && beautyType != null) {
            this.biF.updateFilter(beautyType.type, fArr);
        }
    }

    public void g(Map<BeautyType, Object> map) {
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

    public static String aC(Context context) {
        return DuMixController.getSoDownLoadDir(context);
    }

    public static int getVersion() {
        return DuMixController.getVersionCode();
    }

    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.biL != null && TextUtils.isEmpty(str)) {
            this.biL.onFilterStateChanged(null, null);
        }
        if (JS()) {
            this.biF.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.biF != null && this.biF.getARProxyManager() != null && this.biF.getARProxyManager().getCaptureAR() != null) {
            this.biF.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void d(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.biF != null && this.biF.getARProxyManager() != null && this.biF.getARProxyManager().getCaptureAR() != null) {
            this.biF.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void h(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.biF != null && this.biF.getARProxyManager() != null && this.biF.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.biF.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.biF.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean fy(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.biJ = faceListener;
    }

    private static void d(String str, String str2) {
    }

    public void cu(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.biK = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.biM = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.biL = filterStateListener;
    }

    public void clearCase() {
        if (this.biL != null) {
            this.biL.onFilterStateChanged(null, null);
        }
        if (this.biF != null) {
            this.biF.clearCase();
        }
    }

    private Texture J(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.biF == null || (gLRenderer = this.biF.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.JT() || aVar.JQ() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.biF != null) {
            this.biF.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.biF != null) {
            this.biF.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.biF != null) {
            this.biF.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }

    private void JU() {
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

    private void JV() {
        if (this.biF != null) {
            this.biF.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, 0.03f);
            this.biF.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.biF.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }

    public void resetAllQualityParm() {
        if (this.biF != null && this.biU) {
            JU();
            JV();
        }
    }

    public void JW() {
        if (this.biF != null && this.biU) {
            JU();
            this.biF.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, -0.01f);
            this.biF.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.biF.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }
}
