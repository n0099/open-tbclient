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
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static a bvq;
    private LuaMsgListener bvA;
    FilterStateListener bvB;
    private DefinedLuaListener bvC;
    private Texture bvF;
    private Texture bvG;
    private long bvI;
    private long bvJ;
    private EGLContext bvs;
    private InterfaceC0212a bvt;
    private DuMixController bvv;
    private DuMixInput bvx;
    private DuMixOutput bvy;
    private FaceListener bvz;
    private Context mContext;
    public static final String bvp = c.Nn();
    private static boolean bvr = false;
    private static final InterfaceC0212a bvD = null;
    private static boolean bvH = false;
    private boolean mPaused = false;
    private boolean bvu = false;
    private List<DuMixCallback> bvw = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean bvE = false;
    private volatile boolean bvK = false;
    private volatile boolean bvL = false;
    private volatile boolean mIsOverrideParm = false;
    private int mOutputFPS = 0;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (z && a.this.bvv != null && b.Ne() != null) {
                a aVar = a.this;
                b.Ne();
                aVar.gq(c.cO(a.this.bvK));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.Ne();
                aVar2.setBeautyValue(beautyType, c.No());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bvw.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bvw.get(i2);
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
                if (i2 < a.this.bvw.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bvw.get(i2);
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
                if (i2 < a.this.bvw.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bvw.get(i2);
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
                if (i2 < a.this.bvw.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bvw.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bvw.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            for (DuMixCallback duMixCallback : a.this.bvw) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0212a {
        void onHolderChanged(InterfaceC0212a interfaceC0212a);
    }

    public static boolean MV() {
        if (bvr) {
            return bvr;
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
            bvr = true;
        } catch (Throwable th) {
            g.d("DuAr_UGC_SO", "so loaded: " + th.getMessage());
            bvr = false;
        }
        return bvr;
    }

    private a(Context context, InterfaceC0212a interfaceC0212a, EGLContext eGLContext, byte[] bArr) {
        this.mContext = context.getApplicationContext();
        this.bvs = eGLContext;
        this.bvt = interfaceC0212a;
        this.bvv = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bvv.checkAuth(bArr, null, null);
        }
        cN(false);
        this.bvv.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bvz != null) {
                    a.this.bvz.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bvz != null) {
                    a.this.bvz.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bvz != null) {
                    a.this.bvz.onTriggerFired(str);
                }
            }
        });
        this.bvv.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                if (a.this.bvA != null) {
                    return a.this.bvA.getMsgKeyListened();
                }
                return null;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                if (a.this.bvA != null) {
                    a.this.bvA.onLuaMessage(hashMap);
                }
            }
        });
        this.bvv.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.this.bvC != null) {
                    a.this.bvC.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.this.bvC != null) {
                    a.this.bvC.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bvv.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.this.bvB != null) {
                    a.this.bvB.onFilterStateChanged(hashMap, str);
                }
            }
        });
    }

    public static a a(Context context, InterfaceC0212a interfaceC0212a, byte[] bArr) {
        return a(context, interfaceC0212a, null, bArr);
    }

    public static a a(Context context, InterfaceC0212a interfaceC0212a, EGLContext eGLContext, byte[] bArr) {
        if (bvq == null || bvq.bvt != interfaceC0212a || bvq.bvs != eGLContext) {
            synchronized (a.class) {
                if (bvq == null || bvq.bvt != interfaceC0212a || bvq.bvs != eGLContext) {
                    if (bvq != null) {
                        InterfaceC0212a interfaceC0212a2 = bvq.bvt;
                        bvq.release();
                        if (interfaceC0212a2 != null) {
                            interfaceC0212a2.onHolderChanged(interfaceC0212a);
                        }
                    }
                    bvq = new a(context, interfaceC0212a, eGLContext, bArr);
                }
            }
        }
        return bvq;
    }

    public InterfaceC0212a MW() {
        return this.bvt;
    }

    public void resume() {
        if (bvq == this && this.bvv != null) {
            d("DuAr_DuController", "resume");
            this.bvv.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bvq == this && this.bvv != null) {
            d("DuAr_DuController", "pause");
            this.bvv.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bvq == this) {
            this.mPaused = false;
            this.bvu = true;
            this.bvt = bvD;
            DuMixController duMixController = this.bvv;
            this.bvv = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bvJ = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bvJ));
            }
            bvq = null;
            this.bvs = null;
        }
    }

    public boolean MX() {
        return this.bvE;
    }

    private boolean MY() {
        return (this.bvv == null || !MX() || isPaused()) ? false : true;
    }

    public boolean MZ() {
        return this.bvu;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.bvs != null) {
            this.bvx = new DuMixInput2(this.bvF, i, i2);
            ((DuMixInput2) this.bvx).setSyncInputContent(bvH);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bvH);
            this.bvx.setInputDegree(0);
            return;
        }
        this.bvx = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (this.bvv != null) {
            this.bvK = z;
            this.bvI = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bvE) {
                if (this.bvs != null) {
                    this.bvG = O(i, i2);
                    this.bvy = new DuMixOutput2(this.bvG, i, i2);
                } else {
                    this.bvy = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bvy.setOutputFPS(this.mOutputFPS);
                }
                this.bvv.setup(this.bvx, this.bvy, this.mDuMixCallback);
                this.bvE = true;
                return;
            }
            this.bvv.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bvv != null && hashMap != null) {
            this.bvv.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (this.bvv != null && str != null) {
            this.bvv.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bvw.contains(duMixCallback)) {
            this.bvw.add(duMixCallback);
        }
        g.d("DuAr_DuController", "addDuMixCallback size " + this.bvw.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (this.bvv != null && beautyType != null) {
            this.bvv.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null && this.bvv != null && beautyType != null) {
            this.bvv.updateFilter(beautyType.type, 1);
            this.bvv.updateFilterCase(makeup.getResPath());
            this.bvv.updateFilter(beautyType.type, makeup.getValue());
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (this.bvv != null && beautyType != null) {
            this.bvv.updateFilter(beautyType.type, f);
        }
    }

    public void setOverrideDefaultParm(boolean z) {
        this.mIsOverrideParm = z;
        if (this.bvL) {
            Nc();
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bvv;
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
            a(SharpnessFilter.sharpness, bVar.aun);
            a(FilterParam.TuneColorFilter.brightness, bVar.auo);
            a(FilterParam.TuneColorFilter.contrast, bVar.aup);
            a(FilterParam.TuneColorFilter.saturation, bVar.auq);
            a(FilterParam.TuneColorFilter.curve, bVar.aur);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aus);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aut);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.auu);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.auv);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.atZ);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aua);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aub);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.auc);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aud);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aue);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.auf);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aug);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.auh);
    }

    public void a(FilterParam filterParam, float f) {
        if (MY() && filterParam != null) {
            this.bvv.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (MY() && filterParam != null && list != null) {
            this.bvv.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (this.bvv != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bvv.updateFilterCase(str);
            } else {
                this.bvv.updateFilter(beautyType.type, str);
            }
        }
    }

    public void gq(String str) {
        if (this.bvv != null) {
            this.bvv.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (this.bvv != null && beautyType != null) {
            this.bvv.updateFilter(beautyType.type, fArr);
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
        if (this.bvB != null && TextUtils.isEmpty(str)) {
            this.bvB.onFilterStateChanged(null, null);
        }
        if (MY()) {
            this.bvv.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bvv != null && this.bvv.getARProxyManager() != null && this.bvv.getARProxyManager().getCaptureAR() != null) {
            this.bvv.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bvv != null && this.bvv.getARProxyManager() != null && this.bvv.getARProxyManager().getCaptureAR() != null) {
            this.bvv.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void h(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bvv != null && this.bvv.getARProxyManager() != null && this.bvv.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bvv.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bvv.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean gr(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bvz = faceListener;
    }

    private static void d(String str, String str2) {
    }

    public void cN(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bvA = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bvC = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bvB = filterStateListener;
    }

    public void clearCase() {
        if (this.bvB != null) {
            this.bvB.onFilterStateChanged(null, null);
        }
        if (this.bvv != null) {
            this.bvv.clearCase();
        }
    }

    private Texture O(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bvv == null || (gLRenderer = this.bvv.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.MZ() || aVar.MW() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bvv != null) {
            this.bvv.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bvv != null) {
            this.bvv.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bvv != null) {
            this.bvv.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }

    private void Na() {
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

    private void Nb() {
        if (this.bvv != null) {
            this.bvv.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, 0.03f);
            this.bvv.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.bvv.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }

    public void resetAllQualityParm() {
        if (this.bvv != null && this.bvK) {
            Na();
            Nb();
        }
    }

    public void Nc() {
        if (this.bvv != null && this.bvK) {
            Na();
            this.bvv.updateFilter((FilterParam) FilterParam.TuneColorFilter.brightness, -0.01f);
            this.bvv.updateFilter((FilterParam) FilterParam.TuneColorFilter.contrast, 0.86f);
            this.bvv.updateFilter((FilterParam) FilterParam.TuneColorFilter.saturation, 0.79f);
        }
    }
}
