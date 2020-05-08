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
    private static a biF;
    private EGLContext biH;
    private InterfaceC0172a biI;
    private DuMixController biK;
    private DuMixInput biM;
    private DuMixOutput biN;
    private FaceListener biO;
    private LuaMsgListener biP;
    FilterStateListener biQ;
    private DefinedLuaListener biR;
    private Texture biU;
    private Texture biV;
    private long biX;
    private long biY;
    private Context mContext;
    public static final String biE = c.Ke();
    private static boolean biG = false;
    private static final InterfaceC0172a biS = null;
    private static boolean biW = false;
    private boolean mPaused = false;
    private boolean biJ = false;
    private List<DuMixCallback> biL = new ArrayList();
    private int mInputWidth = 1280;
    private int mInputHeight = 720;
    private boolean biT = false;
    private volatile boolean biZ = false;
    private volatile boolean bja = false;
    private volatile boolean mIsOverrideParm = false;
    private int mOutputFPS = 0;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(final boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (z && a.this.biK != null) {
                ThreadPool.Kj().execute(new Runnable() { // from class: com.baidu.minivideo.arface.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z && a.this.biK != null && b.JX() != null) {
                            a aVar = a.this;
                            b.JX();
                            aVar.fx(c.cv(a.this.biZ));
                            a aVar2 = a.this;
                            BeautyType beautyType = BeautyType.beautyJsonPath;
                            b.JX();
                            aVar2.setBeautyValue(beautyType, c.Kf());
                        }
                        if (z && a.this.biK != null) {
                            a.this.ct(a.this.biZ);
                        }
                        a.this.bja = true;
                        if (a.this.mIsOverrideParm) {
                            a.this.JV();
                        }
                    }
                });
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.biL.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.biL.get(i2);
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
                if (i2 < a.this.biL.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.biL.get(i2);
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
                if (i2 < a.this.biL.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.biL.get(i2);
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
                if (i2 < a.this.biL.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.biL.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.biL.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            for (DuMixCallback duMixCallback : a.this.biL) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0172a {
        void onHolderChanged(InterfaceC0172a interfaceC0172a);
    }

    public static boolean JO() {
        if (biG) {
            return biG;
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
            biG = true;
        } catch (Throwable th) {
            g.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            biG = false;
        }
        return biG;
    }

    private a(Context context, InterfaceC0172a interfaceC0172a, EGLContext eGLContext, byte[] bArr) {
        this.mContext = context.getApplicationContext();
        this.biH = eGLContext;
        this.biI = interfaceC0172a;
        this.biK = new DuMixController(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.biK.checkAuth(bArr, null, null);
        }
        cu(false);
        this.biK.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.biO != null) {
                    a.this.biO.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.biO != null) {
                    a.this.biO.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.biO != null) {
                    a.this.biO.onTriggerFired(str);
                }
            }
        });
        this.biK.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                if (a.this.biP != null) {
                    return a.this.biP.getMsgKeyListened();
                }
                return null;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.this.biP != null) {
                    a.this.biP.onLuaMessage(hashMap);
                }
            }
        });
        this.biK.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.this.biR != null) {
                    a.this.biR.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.this.biR != null) {
                    a.this.biR.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.biK.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.this.biQ != null) {
                    a.this.biQ.onFilterStateChanged(hashMap, str);
                }
            }
        });
    }

    public static a a(Context context, InterfaceC0172a interfaceC0172a, byte[] bArr) {
        return a(context, interfaceC0172a, null, bArr);
    }

    public static a a(Context context, InterfaceC0172a interfaceC0172a, EGLContext eGLContext, byte[] bArr) {
        if (biF == null || biF.biI != interfaceC0172a || biF.biH != eGLContext) {
            synchronized (a.class) {
                if (biF == null || biF.biI != interfaceC0172a || biF.biH != eGLContext) {
                    if (biF != null) {
                        InterfaceC0172a interfaceC0172a2 = biF.biI;
                        biF.release();
                        if (interfaceC0172a2 != null) {
                            interfaceC0172a2.onHolderChanged(interfaceC0172a);
                        }
                    }
                    biF = new a(context, interfaceC0172a, eGLContext, bArr);
                }
            }
        }
        return biF;
    }

    public InterfaceC0172a JP() {
        return this.biI;
    }

    public void resume() {
        if (biF == this && this.biK != null) {
            d("DuAr_DuController", "resume");
            this.biK.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (biF == this && this.biK != null) {
            d("DuAr_DuController", "pause");
            this.biK.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (biF == this) {
            this.mPaused = false;
            this.biJ = true;
            this.biI = biS;
            DuMixController duMixController = this.biK;
            this.biK = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.biY = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.biY));
            }
            biF = null;
            this.biH = null;
        }
    }

    public boolean JQ() {
        return this.biT;
    }

    private boolean JR() {
        return (this.biK == null || !JQ() || isPaused()) ? false : true;
    }

    public boolean JS() {
        return this.biJ;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.biH != null) {
            this.biM = new DuMixInput2(this.biU, i, i2);
            ((DuMixInput2) this.biM).setSyncInputContent(biW);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + biW);
            this.biM.setInputDegree(0);
            return;
        }
        this.biM = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (this.biK != null) {
            this.biZ = z;
            this.biX = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.biT) {
                if (this.biH != null) {
                    this.biV = J(i, i2);
                    this.biN = new DuMixOutput2(this.biV, i, i2);
                } else {
                    this.biN = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.biN.setOutputFPS(this.mOutputFPS);
                }
                this.biK.setup(this.biM, this.biN, this.mDuMixCallback);
                this.biT = true;
                return;
            }
            this.biK.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.biK != null && hashMap != null) {
            this.biK.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (this.biK != null && str != null) {
            this.biK.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.biL.contains(duMixCallback)) {
            this.biL.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.biL.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (this.biK != null && beautyType != null) {
            this.biK.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null && this.biK != null && beautyType != null) {
            this.biK.updateFilter(beautyType.type, 1);
            this.biK.updateFilterCase(makeup.getResPath());
            this.biK.updateFilter(beautyType.type, makeup.getValue());
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (this.biK != null && beautyType != null) {
            this.biK.updateFilter(beautyType.type, f);
        }
    }

    public void setOverrideDefaultParm(boolean z) {
        this.mIsOverrideParm = z;
        if (this.bja) {
            JV();
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.biK;
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
        JT();
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (this.biK != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.biK.updateFilterCase(str);
            } else {
                this.biK.updateFilter(beautyType.type, str);
            }
        }
    }

    public void fx(String str) {
        if (this.biK != null) {
            this.biK.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (this.biK != null && beautyType != null) {
            this.biK.updateFilter(beautyType.type, fArr);
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

    public static String aq(Context context) {
        return DuMixController.getSoDownLoadDir(context);
    }

    public static int getVersion() {
        return DuMixController.getVersionCode();
    }

    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.biQ != null && TextUtils.isEmpty(str)) {
            this.biQ.onFilterStateChanged(null, null);
        }
        if (JR()) {
            this.biK.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.biK != null && this.biK.getARProxyManager() != null && this.biK.getARProxyManager().getCaptureAR() != null) {
            this.biK.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void d(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.biK != null && this.biK.getARProxyManager() != null && this.biK.getARProxyManager().getCaptureAR() != null) {
            this.biK.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void h(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.biK != null && this.biK.getARProxyManager() != null && this.biK.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.biK.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.biK.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
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
        this.biO = faceListener;
    }

    private static void d(String str, String str2) {
    }

    public void cu(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.biP = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.biR = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.biQ = filterStateListener;
    }

    public void clearCase() {
        if (this.biQ != null) {
            this.biQ.onFilterStateChanged(null, null);
        }
        if (this.biK != null) {
            this.biK.clearCase();
        }
    }

    private Texture J(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.biK == null || (gLRenderer = this.biK.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.JS() || aVar.JP() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.biK != null) {
            this.biK.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.biK != null) {
            this.biK.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.biK != null) {
            this.biK.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }

    private void JT() {
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

    private void JU() {
        if (this.biK != null) {
            this.biK.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, 0.03f);
            this.biK.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.biK.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }

    public void resetAllQualityParm() {
        if (this.biK != null && this.biZ) {
            JT();
            JU();
        }
    }

    public void JV() {
        if (this.biK != null && this.biZ) {
            JT();
            this.biK.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, -0.01f);
            this.biK.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.biK.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }
}
