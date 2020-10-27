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
    private static a bTz;
    private EGLContext bTB;
    private InterfaceC0249a bTC;
    private DuMixController bTE;
    private DuMixInput bTG;
    private DuMixOutput bTH;
    private FaceListener bTI;
    private LuaMsgListener bTJ;
    FilterStateListener bTK;
    private DefinedLuaListener bTL;
    private Texture bTO;
    private Texture bTP;
    private long bTR;
    private long bTS;
    private Context mContext;
    public static final String bTy = c.XL();
    private static boolean bTA = false;
    private static final InterfaceC0249a bTM = null;
    private static boolean bTQ = false;
    private boolean mPaused = false;
    private boolean bTD = false;
    private List<DuMixCallback> bTF = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean bTN = false;
    private HashMap<BeautyType, String> bTT = new HashMap<>();
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + (System.currentTimeMillis() - a.this.bTR));
            }
            a.this.bTT.clear();
            if (z && a.this.bTE != null && b.XC() != null) {
                a aVar = a.this;
                b.XC();
                aVar.jc(c.dt(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.XC();
                aVar2.setBeautyValue(beautyType, c.XM());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bTF.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bTF.get(i2);
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
                if (i2 < a.this.bTF.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bTF.get(i2);
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
                if (i2 < a.this.bTF.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bTF.get(i2);
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
                if (i2 < a.this.bTF.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bTF.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bTF.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.bTF) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0249a {
        void onHolderChanged(InterfaceC0249a interfaceC0249a);
    }

    private a(Context context, InterfaceC0249a interfaceC0249a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0249a + ", eglCxt=" + eGLContext);
        }
        this.mContext = context.getApplicationContext();
        this.bTB = eGLContext;
        this.bTC = interfaceC0249a;
        this.bTE = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bTE.checkAuth(bArr, null, null);
        }
        ds(false);
        this.bTE.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bTI != null) {
                    a.this.bTI.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bTI != null) {
                    a.this.bTI.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bTI != null) {
                    a.this.bTI.onTriggerFired(str);
                }
            }
        });
        this.bTE.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.bTJ != null ? a.this.bTJ.getMsgKeyListened() : null;
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
                if (a.this.bTJ != null) {
                    a.this.bTJ.onLuaMessage(hashMap);
                }
            }
        });
        this.bTE.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.bTL != null) {
                    a.this.bTL.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.h(hashMap));
                }
                if (a.this.bTL != null) {
                    a.this.bTL.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bTE.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.h(hashMap) + "\n" + str);
                }
                if (a.this.bTK != null) {
                    a.this.bTK.onFilterStateChanged(hashMap, str);
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

    public static a a(Context context, InterfaceC0249a interfaceC0249a, byte[] bArr) {
        return a(context, interfaceC0249a, null, bArr);
    }

    public static a a(Context context, InterfaceC0249a interfaceC0249a, EGLContext eGLContext, byte[] bArr) {
        if (bTz == null || bTz.bTC != interfaceC0249a || bTz.bTB != eGLContext) {
            synchronized (a.class) {
                if (bTz == null || bTz.bTC != interfaceC0249a || bTz.bTB != eGLContext) {
                    if (bTz != null) {
                        InterfaceC0249a interfaceC0249a2 = bTz.bTC;
                        bTz.release();
                        if (interfaceC0249a2 != null) {
                            interfaceC0249a2.onHolderChanged(interfaceC0249a);
                        }
                    }
                    bTz = new a(context, interfaceC0249a, eGLContext, bArr);
                }
            }
        }
        return bTz;
    }

    public InterfaceC0249a Xx() {
        return this.bTC;
    }

    public void resume() {
        if (bTz == this && this.bTE != null) {
            d("DuAr_DuController", "resume");
            this.bTE.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bTz == this && this.bTE != null) {
            d("DuAr_DuController", "pause");
            this.bTE.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bTz == this) {
            this.mPaused = false;
            this.bTD = true;
            this.bTC = bTM;
            DuMixController duMixController = this.bTE;
            this.bTE = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bTS = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bTS));
            }
            bTz = null;
            this.bTB = null;
        }
    }

    public boolean Xy() {
        return this.bTN;
    }

    private boolean Xz() {
        return (this.bTE == null || !Xy() || isPaused()) ? false : true;
    }

    public boolean XA() {
        return this.bTD;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.bTB != null) {
            this.bTG = new DuMixInput2(this.bTO, i, i2);
            ((DuMixInput2) this.bTG).setSyncInputContent(bTQ);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bTQ);
            this.bTG.setInputDegree(0);
            return;
        }
        this.bTG = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.bTE != null) {
            this.bTR = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bTN) {
                this.bTG.setFrontCamera(z);
                if (this.bTB != null) {
                    this.bTP = T(i, i2);
                    this.bTH = new DuMixOutput2(this.bTP, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.bTH = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.bTH.setScreenOrientation(0);
                    } else {
                        this.bTH = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    Log.e("qlc", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bTH.setOutputFPS(this.mOutputFPS);
                }
                this.bTE.setup(this.bTG, this.bTH, this.mDuMixCallback);
                this.bTN = true;
                return;
            }
            this.bTE.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bTE != null && hashMap != null) {
            if (isDebug()) {
                h.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.bTE.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.bTE != null && str != null) {
            this.bTE.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bTF.contains(duMixCallback)) {
            this.bTF.add(duMixCallback);
        }
        h.d("DuAr_DuController", "addDuMixCallback size " + this.bTF.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.bTE != null && beautyType != null) {
            this.bTE.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        String str;
        if (makeup != null) {
            DuMixController duMixController = this.bTE;
            if (duMixController == null) {
                str = "";
            } else if (beautyType != null) {
                if (TextUtils.equals(this.bTT.get(beautyType), makeup.getResPath())) {
                    str = "";
                } else {
                    str = duMixController.updateFilterCase(makeup.getResPath());
                    if (str != null) {
                        this.bTT.put(beautyType, makeup.getResPath());
                    }
                }
                duMixController.updateFilter(beautyType.type, makeup.getValue());
            } else {
                this.bTT.clear();
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
        if (this.bTE != null && beautyType != null) {
            this.bTE.updateFilter(beautyType.type, f);
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bTE;
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
            a(SharpnessFilter.sharpness, bVar.aDg);
            a(FilterParam.TuneColorFilter.brightness, bVar.aDh);
            a(FilterParam.TuneColorFilter.contrast, bVar.aDi);
            a(FilterParam.TuneColorFilter.saturation, bVar.aDj);
            a(FilterParam.TuneColorFilter.curve, bVar.aDk);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aDl);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aDm);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aDn);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aDo);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aCS);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aCT);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aCU);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aCV);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aCW);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aCX);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aCY);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aCZ);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aDa);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (Xz() && filterParam != null) {
            this.bTE.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            h.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (Xz() && filterParam != null && list != null) {
            this.bTE.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.bTE != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bTE.updateFilterCase(str);
            } else {
                this.bTE.updateFilter(beautyType.type, str);
            }
        }
    }

    public void jc(String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.bTE != null) {
            this.bTE.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.F(fArr));
        }
        if (this.bTE != null && beautyType != null) {
            this.bTE.updateFilter(beautyType.type, fArr);
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
        if (this.bTK != null && TextUtils.isEmpty(str)) {
            this.bTK.onFilterStateChanged(null, null);
        }
        if (Xz()) {
            if (isDebug()) {
                h.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.bTE.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bTE != null && this.bTE.getARProxyManager() != null && this.bTE.getARProxyManager().getCaptureAR() != null) {
            this.bTE.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bTE != null && this.bTE.getARProxyManager() != null && this.bTE.getARProxyManager().getCaptureAR() != null) {
            this.bTE.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bTE != null && this.bTE.getARProxyManager() != null && this.bTE.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bTE.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bTE.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean jd(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bTI = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (bTz == null ? "" : " by: " + bTz.bTC));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void ds(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bTJ = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bTL = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bTK = filterStateListener;
    }

    public void clearCase() {
        if (this.bTK != null) {
            this.bTK.onFilterStateChanged(null, null);
        }
        if (this.bTE != null) {
            this.bTE.clearCase();
        }
    }

    private Texture T(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bTE == null || (gLRenderer = this.bTE.getGLRenderer()) == null) {
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
        return (aVar == null || aVar.XA() || aVar.Xx() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bTE != null) {
            this.bTE.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bTE != null) {
            this.bTE.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bTE != null) {
            this.bTE.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
