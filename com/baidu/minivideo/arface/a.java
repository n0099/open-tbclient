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
    private static a bqa;
    private EGLContext bqc;
    private InterfaceC0205a bqd;
    private DuMixController bqf;
    private DuMixInput bqh;
    private DuMixOutput bqi;
    private FaceListener bqj;
    private LuaMsgListener bqk;
    FilterStateListener bql;
    private DefinedLuaListener bqm;
    private Texture bqp;
    private Texture bqq;
    private long bqs;
    private long bqt;
    private Context mContext;
    public static final String bpZ = c.LX();
    private static boolean bqb = false;
    private static final InterfaceC0205a bqn = null;
    private static boolean bqr = false;
    private boolean mPaused = false;
    private boolean bqe = false;
    private List<DuMixCallback> bqg = new ArrayList();
    private int mInputWidth = 1280;
    private int mInputHeight = 720;
    private boolean bqo = false;
    private volatile boolean bqu = false;
    private volatile boolean bqv = false;
    private volatile boolean mIsOverrideParm = false;
    private int mOutputFPS = 0;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(final boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (z && a.this.bqf != null) {
                ThreadPool.Mc().execute(new Runnable() { // from class: com.baidu.minivideo.arface.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z && a.this.bqf != null && b.LQ() != null) {
                            a aVar = a.this;
                            b.LQ();
                            aVar.gj(c.cH(a.this.bqu));
                            a aVar2 = a.this;
                            BeautyType beautyType = BeautyType.beautyJsonPath;
                            b.LQ();
                            aVar2.setBeautyValue(beautyType, c.LY());
                        }
                        if (z && a.this.bqf != null) {
                            a.this.cF(a.this.bqu);
                        }
                        a.this.bqv = true;
                        if (a.this.mIsOverrideParm) {
                            a.this.LO();
                        }
                    }
                });
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bqg.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bqg.get(i2);
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
                if (i2 < a.this.bqg.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bqg.get(i2);
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
                if (i2 < a.this.bqg.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bqg.get(i2);
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
                if (i2 < a.this.bqg.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bqg.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bqg.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            for (DuMixCallback duMixCallback : a.this.bqg) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0205a {
        void onHolderChanged(InterfaceC0205a interfaceC0205a);
    }

    public static boolean LH() {
        if (bqb) {
            return bqb;
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
            bqb = true;
        } catch (Throwable th) {
            g.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            bqb = false;
        }
        return bqb;
    }

    private a(Context context, InterfaceC0205a interfaceC0205a, EGLContext eGLContext, byte[] bArr) {
        this.mContext = context.getApplicationContext();
        this.bqc = eGLContext;
        this.bqd = interfaceC0205a;
        this.bqf = new DuMixController(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bqf.checkAuth(bArr, null, null);
        }
        cG(false);
        this.bqf.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bqj != null) {
                    a.this.bqj.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bqj != null) {
                    a.this.bqj.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bqj != null) {
                    a.this.bqj.onTriggerFired(str);
                }
            }
        });
        this.bqf.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                if (a.this.bqk != null) {
                    return a.this.bqk.getMsgKeyListened();
                }
                return null;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.this.bqk != null) {
                    a.this.bqk.onLuaMessage(hashMap);
                }
            }
        });
        this.bqf.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.this.bqm != null) {
                    a.this.bqm.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.this.bqm != null) {
                    a.this.bqm.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bqf.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.this.bql != null) {
                    a.this.bql.onFilterStateChanged(hashMap, str);
                }
            }
        });
    }

    public static a a(Context context, InterfaceC0205a interfaceC0205a, byte[] bArr) {
        return a(context, interfaceC0205a, null, bArr);
    }

    public static a a(Context context, InterfaceC0205a interfaceC0205a, EGLContext eGLContext, byte[] bArr) {
        if (bqa == null || bqa.bqd != interfaceC0205a || bqa.bqc != eGLContext) {
            synchronized (a.class) {
                if (bqa == null || bqa.bqd != interfaceC0205a || bqa.bqc != eGLContext) {
                    if (bqa != null) {
                        InterfaceC0205a interfaceC0205a2 = bqa.bqd;
                        bqa.release();
                        if (interfaceC0205a2 != null) {
                            interfaceC0205a2.onHolderChanged(interfaceC0205a);
                        }
                    }
                    bqa = new a(context, interfaceC0205a, eGLContext, bArr);
                }
            }
        }
        return bqa;
    }

    public InterfaceC0205a LI() {
        return this.bqd;
    }

    public void resume() {
        if (bqa == this && this.bqf != null) {
            d("DuAr_DuController", "resume");
            this.bqf.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bqa == this && this.bqf != null) {
            d("DuAr_DuController", "pause");
            this.bqf.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bqa == this) {
            this.mPaused = false;
            this.bqe = true;
            this.bqd = bqn;
            DuMixController duMixController = this.bqf;
            this.bqf = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bqt = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bqt));
            }
            bqa = null;
            this.bqc = null;
        }
    }

    public boolean LJ() {
        return this.bqo;
    }

    private boolean LK() {
        return (this.bqf == null || !LJ() || isPaused()) ? false : true;
    }

    public boolean LL() {
        return this.bqe;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.bqc != null) {
            this.bqh = new DuMixInput2(this.bqp, i, i2);
            ((DuMixInput2) this.bqh).setSyncInputContent(bqr);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bqr);
            this.bqh.setInputDegree(0);
            return;
        }
        this.bqh = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (this.bqf != null) {
            this.bqu = z;
            this.bqs = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bqo) {
                if (this.bqc != null) {
                    this.bqq = M(i, i2);
                    this.bqi = new DuMixOutput2(this.bqq, i, i2);
                } else {
                    this.bqi = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bqi.setOutputFPS(this.mOutputFPS);
                }
                this.bqf.setup(this.bqh, this.bqi, this.mDuMixCallback);
                this.bqo = true;
                return;
            }
            this.bqf.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bqf != null && hashMap != null) {
            this.bqf.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (this.bqf != null && str != null) {
            this.bqf.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bqg.contains(duMixCallback)) {
            this.bqg.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.bqg.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (this.bqf != null && beautyType != null) {
            this.bqf.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null && this.bqf != null && beautyType != null) {
            this.bqf.updateFilter(beautyType.type, 1);
            this.bqf.updateFilterCase(makeup.getResPath());
            this.bqf.updateFilter(beautyType.type, makeup.getValue());
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (this.bqf != null && beautyType != null) {
            this.bqf.updateFilter(beautyType.type, f);
        }
    }

    public void setOverrideDefaultParm(boolean z) {
        this.mIsOverrideParm = z;
        if (this.bqv) {
            LO();
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bqf;
        if (duMixController != null && list != null) {
            duMixController.updateFilter(FilterParam.TuneColorFilter.rgbPoints, list.get(0));
            duMixController.updateFilter(FilterParam.TuneColorFilter.redPoints, list.get(1));
            duMixController.updateFilter(FilterParam.TuneColorFilter.greenPoints, list.get(2));
            duMixController.updateFilter(FilterParam.TuneColorFilter.bluePoints, list.get(3));
            duMixController.updateFilter((FilterParam) FilterParam.TuneColorFilter.curve, 0.9f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(boolean z) {
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
        LM();
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (this.bqf != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bqf.updateFilterCase(str);
            } else {
                this.bqf.updateFilter(beautyType.type, str);
            }
        }
    }

    public void gj(String str) {
        if (this.bqf != null) {
            this.bqf.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (this.bqf != null && beautyType != null) {
            this.bqf.updateFilter(beautyType.type, fArr);
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

    public static String aA(Context context) {
        return DuMixController.getSoDownLoadDir(context);
    }

    public static int getVersion() {
        return DuMixController.getVersionCode();
    }

    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.bql != null && TextUtils.isEmpty(str)) {
            this.bql.onFilterStateChanged(null, null);
        }
        if (LK()) {
            this.bqf.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bqf != null && this.bqf.getARProxyManager() != null && this.bqf.getARProxyManager().getCaptureAR() != null) {
            this.bqf.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void d(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bqf != null && this.bqf.getARProxyManager() != null && this.bqf.getARProxyManager().getCaptureAR() != null) {
            this.bqf.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void h(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bqf != null && this.bqf.getARProxyManager() != null && this.bqf.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bqf.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bqf.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean gk(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bqj = faceListener;
    }

    private static void d(String str, String str2) {
    }

    public void cG(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bqk = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bqm = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bql = filterStateListener;
    }

    public void clearCase() {
        if (this.bql != null) {
            this.bql.onFilterStateChanged(null, null);
        }
        if (this.bqf != null) {
            this.bqf.clearCase();
        }
    }

    private Texture M(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bqf == null || (gLRenderer = this.bqf.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.LL() || aVar.LI() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bqf != null) {
            this.bqf.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bqf != null) {
            this.bqf.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bqf != null) {
            this.bqf.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }

    private void LM() {
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

    private void LN() {
        if (this.bqf != null) {
            this.bqf.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, 0.03f);
            this.bqf.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.bqf.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }

    public void resetAllQualityParm() {
        if (this.bqf != null && this.bqu) {
            LM();
            LN();
        }
    }

    public void LO() {
        if (this.bqf != null && this.bqu) {
            LM();
            this.bqf.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, -0.01f);
            this.bqf.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.bqf.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }
}
