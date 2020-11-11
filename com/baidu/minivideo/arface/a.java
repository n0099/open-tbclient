package com.baidu.minivideo.arface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.minivideo.arface.utils.h;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes15.dex */
public class a {
    private static a bZj;
    private long bZB;
    private long bZC;
    private EGLContext bZl;
    private InterfaceC0261a bZm;
    private DuMixController bZo;
    private DuMixInput bZq;
    private DuMixOutput bZr;
    private FaceListener bZs;
    private LuaMsgListener bZt;
    FilterStateListener bZu;
    private DefinedLuaListener bZv;
    private Texture bZy;
    private Texture bZz;
    private Context mContext;
    public static final String bZi = c.aak();
    private static boolean bZk = false;
    private static final InterfaceC0261a bZw = null;
    private static boolean bZA = false;
    private boolean mPaused = false;
    private boolean bZn = false;
    private List<DuMixCallback> bZp = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean bZx = false;
    private HashMap<BeautyType, String> bZD = new HashMap<>();
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + (System.currentTimeMillis() - a.this.bZB));
            }
            a.this.bZD.clear();
            if (z && a.this.bZo != null && b.aab() != null) {
                a aVar = a.this;
                b.aab();
                aVar.jp(c.dA(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.aab();
                aVar2.setBeautyValue(beautyType, c.aal());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bZp.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bZp.get(i2);
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
                if (i2 < a.this.bZp.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bZp.get(i2);
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
                if (i2 < a.this.bZp.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bZp.get(i2);
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
                if (i2 < a.this.bZp.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bZp.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bZp.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.bZp) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0261a {
        void onHolderChanged(InterfaceC0261a interfaceC0261a);
    }

    private a(Context context, InterfaceC0261a interfaceC0261a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0261a + ", eglCxt=" + eGLContext);
        }
        this.mContext = context.getApplicationContext();
        this.bZl = eGLContext;
        this.bZm = interfaceC0261a;
        this.bZo = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bZo.checkAuth(bArr, null, null);
        }
        dz(false);
        this.bZo.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bZs != null) {
                    a.this.bZs.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bZs != null) {
                    a.this.bZs.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bZs != null) {
                    a.this.bZs.onTriggerFired(str);
                }
            }
        });
        this.bZo.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.bZt != null ? a.this.bZt.getMsgKeyListened() : null;
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
                if (a.this.bZt != null) {
                    a.this.bZt.onLuaMessage(hashMap);
                }
            }
        });
        this.bZo.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.bZv != null) {
                    a.this.bZv.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.h(hashMap));
                }
                if (a.this.bZv != null) {
                    a.this.bZv.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bZo.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.h(hashMap) + "\n" + str);
                }
                if (a.this.bZu != null) {
                    a.this.bZu.onFilterStateChanged(hashMap, str);
                }
            }
        });
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

    public static a a(Context context, InterfaceC0261a interfaceC0261a, byte[] bArr) {
        return a(context, interfaceC0261a, null, bArr);
    }

    public static a a(Context context, InterfaceC0261a interfaceC0261a, EGLContext eGLContext, byte[] bArr) {
        if (bZj == null || bZj.bZm != interfaceC0261a || bZj.bZl != eGLContext) {
            synchronized (a.class) {
                if (bZj == null || bZj.bZm != interfaceC0261a || bZj.bZl != eGLContext) {
                    if (bZj != null) {
                        InterfaceC0261a interfaceC0261a2 = bZj.bZm;
                        bZj.release();
                        if (interfaceC0261a2 != null) {
                            interfaceC0261a2.onHolderChanged(interfaceC0261a);
                        }
                    }
                    bZj = new a(context, interfaceC0261a, eGLContext, bArr);
                }
            }
        }
        return bZj;
    }

    public InterfaceC0261a ZW() {
        return this.bZm;
    }

    public void resume() {
        if (bZj == this && this.bZo != null) {
            d("DuAr_DuController", "resume");
            this.bZo.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bZj == this && this.bZo != null) {
            d("DuAr_DuController", "pause");
            this.bZo.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bZj == this) {
            this.mPaused = false;
            this.bZn = true;
            this.bZm = bZw;
            DuMixController duMixController = this.bZo;
            this.bZo = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bZC = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bZC));
            }
            bZj = null;
            this.bZl = null;
        }
    }

    public boolean ZX() {
        return this.bZx;
    }

    private boolean ZY() {
        return (this.bZo == null || !ZX() || isPaused()) ? false : true;
    }

    public boolean ZZ() {
        return this.bZn;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.bZl != null) {
            this.bZq = new DuMixInput2(this.bZy, i, i2);
            ((DuMixInput2) this.bZq).setSyncInputContent(bZA);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bZA);
            this.bZq.setInputDegree(0);
            return;
        }
        this.bZq = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.bZo != null) {
            this.bZB = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bZx) {
                this.bZq.setFrontCamera(z);
                if (this.bZl != null) {
                    this.bZz = T(i, i2);
                    this.bZr = new DuMixOutput2(this.bZz, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.bZr = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.bZr.setScreenOrientation(0);
                    } else {
                        this.bZr = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    Log.e("qlc", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bZr.setOutputFPS(this.mOutputFPS);
                }
                this.bZo.setup(this.bZq, this.bZr, this.mDuMixCallback);
                this.bZx = true;
                return;
            }
            this.bZo.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bZo != null && hashMap != null) {
            if (isDebug()) {
                h.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.bZo.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.bZo != null && str != null) {
            this.bZo.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bZp.contains(duMixCallback)) {
            this.bZp.add(duMixCallback);
        }
        h.d("DuAr_DuController", "addDuMixCallback size " + this.bZp.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.bZo != null && beautyType != null) {
            this.bZo.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        String str;
        if (makeup != null) {
            DuMixController duMixController = this.bZo;
            if (duMixController == null) {
                str = "";
            } else if (beautyType != null) {
                if (TextUtils.equals(this.bZD.get(beautyType), makeup.getResPath())) {
                    str = "";
                } else {
                    str = duMixController.updateFilterCase(makeup.getResPath());
                    if (str != null) {
                        this.bZD.put(beautyType, makeup.getResPath());
                    }
                }
                duMixController.updateFilter(beautyType.type, makeup.getValue());
            } else {
                this.bZD.clear();
                str = duMixController.updateFilterCase(makeup.getResPath());
            }
            if (isDebug()) {
                h.d("DuAr_DuController", " updateMakeup: " + beautyType + " = " + makeup.getInfo() + ", resResult: " + str);
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + f);
        }
        if (this.bZo != null && beautyType != null) {
            this.bZo.updateFilter(beautyType.type, f);
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bZo;
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
            a(SharpnessFilter.sharpness, bVar.aDN);
            a(FilterParam.TuneColorFilter.brightness, bVar.aDO);
            a(FilterParam.TuneColorFilter.contrast, bVar.aDP);
            a(FilterParam.TuneColorFilter.saturation, bVar.aDQ);
            a(FilterParam.TuneColorFilter.curve, bVar.aDR);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aDS);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aDT);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aDU);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aDV);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aDz);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aDA);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aDB);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aDC);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aDD);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aDE);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aDF);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aDG);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aDH);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (ZY() && filterParam != null) {
            this.bZo.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            h.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (ZY() && filterParam != null && list != null) {
            this.bZo.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.bZo != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bZo.updateFilterCase(str);
            } else {
                this.bZo.updateFilter(beautyType.type, str);
            }
        }
    }

    public void jp(String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.bZo != null) {
            this.bZo.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.F(fArr));
        }
        if (this.bZo != null && beautyType != null) {
            this.bZo.updateFilter(beautyType.type, fArr);
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

    public static String aK(Context context) {
        String soDownLoadDir = DuMixController.getSoDownLoadDir(context);
        if (isDebug()) {
            h.d("DuAr_DuController", " getSoDownloadDir: " + soDownLoadDir);
        }
        return soDownLoadDir;
    }

    public static int getVersion() {
        int versionCode = DuMixController.getVersionCode();
        if (isDebug()) {
            h.d("DuAr_DuController", " getSdkVersion: " + versionCode);
        }
        return versionCode;
    }

    public static String getVersionName() {
        String versionName = DuMixController.getVersionName();
        if (isDebug()) {
            h.d("DuAr_DuController", " getVersionName:" + versionName);
        }
        return versionName;
    }

    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.bZu != null && TextUtils.isEmpty(str)) {
            this.bZu.onFilterStateChanged(null, null);
        }
        if (ZY()) {
            if (isDebug()) {
                h.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.bZo.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bZo != null && this.bZo.getARProxyManager() != null && this.bZo.getARProxyManager().getCaptureAR() != null) {
            this.bZo.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bZo != null && this.bZo.getARProxyManager() != null && this.bZo.getARProxyManager().getCaptureAR() != null) {
            this.bZo.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bZo != null && this.bZo.getARProxyManager() != null && this.bZo.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bZo.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bZo.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean jq(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bZs = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (bZj == null ? "" : " by: " + bZj.bZm));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void dz(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bZt = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bZv = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bZu = filterStateListener;
    }

    public void clearCase() {
        if (this.bZu != null) {
            this.bZu.onFilterStateChanged(null, null);
        }
        if (this.bZo != null) {
            this.bZo.clearCase();
        }
    }

    private Texture T(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bZo == null || (gLRenderer = this.bZo.getGLRenderer()) == null) {
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
        return (aVar == null || aVar.ZZ() || aVar.ZW() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bZo != null) {
            this.bZo.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bZo != null) {
            this.bZo.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bZo != null) {
            this.bZo.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
