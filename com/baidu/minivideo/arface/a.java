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
/* loaded from: classes14.dex */
public class a {
    private static a bXy;
    private EGLContext bXA;
    private InterfaceC0259a bXB;
    private DuMixController bXD;
    private DuMixInput bXF;
    private DuMixOutput bXG;
    private FaceListener bXH;
    private LuaMsgListener bXI;
    FilterStateListener bXJ;
    private DefinedLuaListener bXK;
    private Texture bXN;
    private Texture bXO;
    private long bXQ;
    private long bXR;
    private Context mContext;
    public static final String bXx = c.ZB();
    private static boolean bXz = false;
    private static final InterfaceC0259a bXL = null;
    private static boolean bXP = false;
    private boolean mPaused = false;
    private boolean bXC = false;
    private List<DuMixCallback> bXE = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean bXM = false;
    private HashMap<BeautyType, String> bXS = new HashMap<>();
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + (System.currentTimeMillis() - a.this.bXQ));
            }
            a.this.bXS.clear();
            if (z && a.this.bXD != null && b.Zs() != null) {
                a aVar = a.this;
                b.Zs();
                aVar.jj(c.dC(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.Zs();
                aVar2.setBeautyValue(beautyType, c.ZC());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bXE.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bXE.get(i2);
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
                if (i2 < a.this.bXE.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bXE.get(i2);
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
                if (i2 < a.this.bXE.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bXE.get(i2);
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
                if (i2 < a.this.bXE.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bXE.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bXE.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.bXE) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0259a {
        void onHolderChanged(InterfaceC0259a interfaceC0259a);
    }

    private a(Context context, InterfaceC0259a interfaceC0259a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0259a + ", eglCxt=" + eGLContext);
        }
        this.mContext = context.getApplicationContext();
        this.bXA = eGLContext;
        this.bXB = interfaceC0259a;
        this.bXD = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bXD.checkAuth(bArr, null, null);
        }
        dB(false);
        this.bXD.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bXH != null) {
                    a.this.bXH.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bXH != null) {
                    a.this.bXH.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bXH != null) {
                    a.this.bXH.onTriggerFired(str);
                }
            }
        });
        this.bXD.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.bXI != null ? a.this.bXI.getMsgKeyListened() : null;
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
                if (a.this.bXI != null) {
                    a.this.bXI.onLuaMessage(hashMap);
                }
            }
        });
        this.bXD.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.bXK != null) {
                    a.this.bXK.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.h(hashMap));
                }
                if (a.this.bXK != null) {
                    a.this.bXK.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bXD.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.h(hashMap) + "\n" + str);
                }
                if (a.this.bXJ != null) {
                    a.this.bXJ.onFilterStateChanged(hashMap, str);
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

    public static a a(Context context, InterfaceC0259a interfaceC0259a, byte[] bArr) {
        return a(context, interfaceC0259a, null, bArr);
    }

    public static a a(Context context, InterfaceC0259a interfaceC0259a, EGLContext eGLContext, byte[] bArr) {
        if (bXy == null || bXy.bXB != interfaceC0259a || bXy.bXA != eGLContext) {
            synchronized (a.class) {
                if (bXy == null || bXy.bXB != interfaceC0259a || bXy.bXA != eGLContext) {
                    if (bXy != null) {
                        InterfaceC0259a interfaceC0259a2 = bXy.bXB;
                        bXy.release();
                        if (interfaceC0259a2 != null) {
                            interfaceC0259a2.onHolderChanged(interfaceC0259a);
                        }
                    }
                    bXy = new a(context, interfaceC0259a, eGLContext, bArr);
                }
            }
        }
        return bXy;
    }

    public InterfaceC0259a Zn() {
        return this.bXB;
    }

    public void resume() {
        if (bXy == this && this.bXD != null) {
            d("DuAr_DuController", "resume");
            this.bXD.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bXy == this && this.bXD != null) {
            d("DuAr_DuController", "pause");
            this.bXD.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bXy == this) {
            this.mPaused = false;
            this.bXC = true;
            this.bXB = bXL;
            DuMixController duMixController = this.bXD;
            this.bXD = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bXR = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bXR));
            }
            bXy = null;
            this.bXA = null;
        }
    }

    public boolean Zo() {
        return this.bXM;
    }

    private boolean Zp() {
        return (this.bXD == null || !Zo() || isPaused()) ? false : true;
    }

    public boolean Zq() {
        return this.bXC;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.bXA != null) {
            this.bXF = new DuMixInput2(this.bXN, i, i2);
            ((DuMixInput2) this.bXF).setSyncInputContent(bXP);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bXP);
            this.bXF.setInputDegree(0);
            return;
        }
        this.bXF = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.bXD != null) {
            this.bXQ = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bXM) {
                this.bXF.setFrontCamera(z);
                if (this.bXA != null) {
                    this.bXO = T(i, i2);
                    this.bXG = new DuMixOutput2(this.bXO, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.bXG = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.bXG.setScreenOrientation(0);
                    } else {
                        this.bXG = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    Log.e("qlc", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bXG.setOutputFPS(this.mOutputFPS);
                }
                this.bXD.setup(this.bXF, this.bXG, this.mDuMixCallback);
                this.bXM = true;
                return;
            }
            this.bXD.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bXD != null && hashMap != null) {
            if (isDebug()) {
                h.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.bXD.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.bXD != null && str != null) {
            this.bXD.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bXE.contains(duMixCallback)) {
            this.bXE.add(duMixCallback);
        }
        h.d("DuAr_DuController", "addDuMixCallback size " + this.bXE.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.bXD != null && beautyType != null) {
            this.bXD.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        String str;
        if (makeup != null) {
            DuMixController duMixController = this.bXD;
            if (duMixController == null) {
                str = "";
            } else if (beautyType != null) {
                if (TextUtils.equals(this.bXS.get(beautyType), makeup.getResPath())) {
                    str = "";
                } else {
                    str = duMixController.updateFilterCase(makeup.getResPath());
                    if (str != null) {
                        this.bXS.put(beautyType, makeup.getResPath());
                    }
                }
                duMixController.updateFilter(beautyType.type, makeup.getValue());
            } else {
                this.bXS.clear();
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
        if (this.bXD != null && beautyType != null) {
            this.bXD.updateFilter(beautyType.type, f);
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bXD;
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
            a(SharpnessFilter.sharpness, bVar.aCc);
            a(FilterParam.TuneColorFilter.brightness, bVar.aCd);
            a(FilterParam.TuneColorFilter.contrast, bVar.aCe);
            a(FilterParam.TuneColorFilter.saturation, bVar.aCf);
            a(FilterParam.TuneColorFilter.curve, bVar.aCg);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aCh);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aCi);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aCj);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aCk);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aBO);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aBP);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aBQ);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aBR);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aBS);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aBT);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aBU);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aBV);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aBW);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (Zp() && filterParam != null) {
            this.bXD.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            h.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (Zp() && filterParam != null && list != null) {
            this.bXD.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.bXD != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bXD.updateFilterCase(str);
            } else {
                this.bXD.updateFilter(beautyType.type, str);
            }
        }
    }

    public void jj(String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.bXD != null) {
            this.bXD.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.F(fArr));
        }
        if (this.bXD != null && beautyType != null) {
            this.bXD.updateFilter(beautyType.type, fArr);
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
        if (this.bXJ != null && TextUtils.isEmpty(str)) {
            this.bXJ.onFilterStateChanged(null, null);
        }
        if (Zp()) {
            if (isDebug()) {
                h.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.bXD.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bXD != null && this.bXD.getARProxyManager() != null && this.bXD.getARProxyManager().getCaptureAR() != null) {
            this.bXD.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bXD != null && this.bXD.getARProxyManager() != null && this.bXD.getARProxyManager().getCaptureAR() != null) {
            this.bXD.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bXD != null && this.bXD.getARProxyManager() != null && this.bXD.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bXD.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bXD.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean jk(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bXH = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (bXy == null ? "" : " by: " + bXy.bXB));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void dB(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bXI = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bXK = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bXJ = filterStateListener;
    }

    public void clearCase() {
        if (this.bXJ != null) {
            this.bXJ.onFilterStateChanged(null, null);
        }
        if (this.bXD != null) {
            this.bXD.clearCase();
        }
    }

    private Texture T(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bXD == null || (gLRenderer = this.bXD.getGLRenderer()) == null) {
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
        return (aVar == null || aVar.Zq() || aVar.Zn() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bXD != null) {
            this.bXD.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bXD != null) {
            this.bXD.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bXD != null) {
            this.bXD.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
