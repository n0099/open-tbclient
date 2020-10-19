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
    private static a bLd;
    private EGLContext bLf;
    private InterfaceC0235a bLg;
    private DuMixController bLi;
    private DuMixInput bLk;
    private DuMixOutput bLl;
    private FaceListener bLm;
    private LuaMsgListener bLn;
    FilterStateListener bLo;
    private DefinedLuaListener bLp;
    private Texture bLs;
    private Texture bLt;
    private long bLv;
    private long bLw;
    private Context mContext;
    public static final String bLc = c.VR();
    private static boolean bLe = false;
    private static final InterfaceC0235a bLq = null;
    private static boolean bLu = false;
    private boolean mPaused = false;
    private boolean bLh = false;
    private List<DuMixCallback> bLj = new ArrayList();
    private int mInputWidth = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private int mInputHeight = 720;
    private boolean bLr = false;
    private int mOutputFPS = 0;
    private boolean mIsLandscape = false;
    private DuMixCallback mDuMixCallback = new DuMixCallback() { // from class: com.baidu.minivideo.arface.a.5
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", Build.MODEL + ", onSetup: " + z + ", spendTime:" + (System.currentTimeMillis() - a.this.bLv));
            }
            if (z && a.this.bLi != null && b.VI() != null) {
                a aVar = a.this;
                b.VI();
                aVar.iJ(c.df(true));
                a aVar2 = a.this;
                BeautyType beautyType = BeautyType.beautyJsonPath;
                b.VI();
                aVar2.setBeautyValue(beautyType, c.VS());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < a.this.bLj.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bLj.get(i2);
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
                if (i2 < a.this.bLj.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bLj.get(i2);
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
                if (i2 < a.this.bLj.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bLj.get(i2);
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
                if (i2 < a.this.bLj.size()) {
                    DuMixCallback duMixCallback = (DuMixCallback) a.this.bLj.get(i2);
                    if (duMixCallback != null) {
                        duMixCallback.onRelease();
                    }
                    i = i2 + 1;
                } else {
                    a.this.bLj.clear();
                    return;
                }
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            if (a.isDebug()) {
                a.d("DuAr_DuController", "onError Type: " + duMixErrorType.name() + ", msg: " + str + ", ext: " + str2);
            }
            for (DuMixCallback duMixCallback : a.this.bLj) {
                duMixCallback.onError(duMixErrorType, str, str2);
            }
        }
    };

    /* renamed from: com.baidu.minivideo.arface.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0235a {
        void onHolderChanged(InterfaceC0235a interfaceC0235a);
    }

    private a(Context context, InterfaceC0235a interfaceC0235a, EGLContext eGLContext, byte[] bArr) {
        if (isDebug()) {
            d("DuAr_DuController", "create ARControllerProxy holder=" + interfaceC0235a + ", eglCxt=" + eGLContext);
        }
        this.mContext = context.getApplicationContext();
        this.bLf = eGLContext;
        this.bLg = interfaceC0235a;
        this.bLi = DuMixController.getInstance(this.mContext, b.b(eGLContext));
        if (bArr != null && bArr.length > 0) {
            this.bLi.checkAuth(bArr, null, null);
        }
        de(false);
        this.bLi.getARProxyManager().getFaceAR().setFaceListener(new FaceListener() { // from class: com.baidu.minivideo.arface.a.1
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (a.this.bLm != null) {
                    a.this.bLm.onFaceResult(obj);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
                if (a.this.bLm != null) {
                    a.this.bLm.onStickerLoadingFinished(list);
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
                if (a.this.bLm != null) {
                    a.this.bLm.onTriggerFired(str);
                }
            }
        });
        this.bLi.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.minivideo.arface.a.2
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                List<String> msgKeyListened = a.this.bLn != null ? a.this.bLn.getMsgKeyListened() : null;
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
                if (a.this.bLn != null) {
                    a.this.bLn.onLuaMessage(hashMap);
                }
            }
        });
        this.bLi.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.minivideo.arface.a.3
            @Override // com.baidu.ar.DefinedLuaListener
            public void onRequireSwitchCamera(int i) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onRequireSwitchCamera: " + i);
                }
                if (a.this.bLp != null) {
                    a.this.bLp.onRequireSwitchCamera(i);
                }
            }

            @Override // com.baidu.ar.DefinedLuaListener
            public void onOpenUrl(String str, int i, HashMap<String, Object> hashMap) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onOpenUrl: " + str + ", " + i + ", " + a.h(hashMap));
                }
                if (a.this.bLp != null) {
                    a.this.bLp.onOpenUrl(str, i, hashMap);
                }
            }
        });
        this.bLi.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.minivideo.arface.a.4
            @Override // com.baidu.ar.filter.FilterStateListener
            public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                if (a.isDebug()) {
                    a.d("DuAr_DuController", "onFilterStateChanged: " + a.h(hashMap) + "\n" + str);
                }
                if (a.this.bLo != null) {
                    a.this.bLo.onFilterStateChanged(hashMap, str);
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

    public static a a(Context context, InterfaceC0235a interfaceC0235a, byte[] bArr) {
        return a(context, interfaceC0235a, null, bArr);
    }

    public static a a(Context context, InterfaceC0235a interfaceC0235a, EGLContext eGLContext, byte[] bArr) {
        if (bLd == null || bLd.bLg != interfaceC0235a || bLd.bLf != eGLContext) {
            synchronized (a.class) {
                if (bLd == null || bLd.bLg != interfaceC0235a || bLd.bLf != eGLContext) {
                    if (bLd != null) {
                        InterfaceC0235a interfaceC0235a2 = bLd.bLg;
                        bLd.release();
                        if (interfaceC0235a2 != null) {
                            interfaceC0235a2.onHolderChanged(interfaceC0235a);
                        }
                    }
                    bLd = new a(context, interfaceC0235a, eGLContext, bArr);
                }
            }
        }
        return bLd;
    }

    public InterfaceC0235a VD() {
        return this.bLg;
    }

    public void resume() {
        if (bLd == this && this.bLi != null) {
            d("DuAr_DuController", "resume");
            this.bLi.resume();
            this.mPaused = false;
        }
    }

    public void pause() {
        if (bLd == this && this.bLi != null) {
            d("DuAr_DuController", "pause");
            this.bLi.pause();
            this.mPaused = true;
        }
    }

    public void release() {
        if (bLd == this) {
            this.mPaused = false;
            this.bLh = true;
            this.bLg = bLq;
            DuMixController duMixController = this.bLi;
            this.bLi = null;
            if (duMixController != null) {
                d("DuAr_DuController", "release");
                this.bLw = System.currentTimeMillis();
                duMixController.release();
                d("DuAr_DuController", Build.MODEL + ", release spendTime: " + (System.currentTimeMillis() - this.bLw));
            }
            bLd = null;
            this.bLf = null;
        }
    }

    public boolean VE() {
        return this.bLr;
    }

    private boolean VF() {
        return (this.bLi == null || !VE() || isPaused()) ? false : true;
    }

    public boolean VG() {
        return this.bLh;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        if (isDebug()) {
            d("DuAr_DuController", "onCameraDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2);
        }
        if (this.bLf != null) {
            this.bLk = new DuMixInput2(this.bLs, i, i2);
            ((DuMixInput2) this.bLk).setSyncInputContent(bLu);
            d("DuAr_DuController", "onCameraDrawerCreated : sSyncInputContent = " + bLu);
            this.bLk.setInputDegree(0);
            return;
        }
        this.bLk = new DuMixInput(surfaceTexture, this.mInputWidth, this.mInputHeight);
    }

    public void a(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z, DuMixCallback duMixCallback) {
        if (isDebug()) {
            d("DuAr_DuController", "onARDrawerCreated " + surfaceTexture + "size[" + i + ", " + i2 + " duMixCallback =" + duMixCallback);
        }
        if (this.bLi != null) {
            this.bLv = System.currentTimeMillis();
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
            a(duMixCallback);
            if (!this.bLr) {
                this.bLk.setFrontCamera(z);
                if (this.bLf != null) {
                    this.bLt = S(i, i2);
                    this.bLl = new DuMixOutput2(this.bLt, i, i2);
                } else {
                    if (this.mIsLandscape) {
                        this.bLl = new DuMixOutput(surfaceTexture, this.mInputWidth, this.mInputHeight);
                        this.bLl.setScreenOrientation(0);
                    } else {
                        this.bLl = new DuMixOutput(surfaceTexture, this.mInputHeight, this.mInputWidth);
                    }
                    Log.e("qlc", " ARControllerProxy mIsLandscape = " + this.mIsLandscape + " mInputHeight = " + this.mInputHeight + " mInputWidth = " + this.mInputWidth);
                }
                if (this.mOutputFPS != 0) {
                    this.bLl.setOutputFPS(this.mOutputFPS);
                }
                this.bLi.setup(this.bLk, this.bLl, this.mDuMixCallback);
                this.bLr = true;
                return;
            }
            this.bLi.changeOutputSize(i, i2);
        }
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.bLi != null && hashMap != null) {
            if (isDebug()) {
                h.d("DuAr_DuController", "sendMessage2Lua " + hashMap);
            }
            this.bLi.sendMsg2Lua(hashMap);
        }
    }

    public void setMdlModelPath(String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", "setMdlModelPath " + str);
        }
        if (this.bLi != null && str != null) {
            this.bLi.setMdlModelPath(str);
        }
    }

    public void a(DuMixCallback duMixCallback) {
        if (duMixCallback != null && !this.bLj.contains(duMixCallback)) {
            this.bLj.add(duMixCallback);
        }
        h.d("DuAr_DuController", "addDuMixCallback size " + this.bLj.size());
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + i);
        }
        if (this.bLi != null && beautyType != null) {
            this.bLi.updateFilter(beautyType.type, i);
        }
    }

    public void a(BeautyType beautyType, Makeup makeup) {
        if (makeup != null) {
            if (isDebug()) {
                h.d("DuAr_DuController", " updateMakeup: " + beautyType + " = " + makeup.getInfo());
            }
            DuMixController duMixController = this.bLi;
            if (duMixController != null) {
                if (beautyType != null) {
                    duMixController.updateFilter(beautyType.type, 1);
                    duMixController.updateFilterCase(makeup.getResPath());
                    duMixController.updateFilter(beautyType.type, makeup.getValue());
                    return;
                }
                duMixController.updateFilterCase(makeup.getResPath());
            }
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + f);
        }
        if (this.bLi != null && beautyType != null) {
            this.bLi.updateFilter(beautyType.type, f);
        }
    }

    public void setCurve(List<List<Point>> list) {
        DuMixController duMixController = this.bLi;
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
            a(SharpnessFilter.sharpness, bVar.aDc);
            a(FilterParam.TuneColorFilter.brightness, bVar.aDd);
            a(FilterParam.TuneColorFilter.contrast, bVar.aDe);
            a(FilterParam.TuneColorFilter.saturation, bVar.aDf);
            a(FilterParam.TuneColorFilter.curve, bVar.aDg);
            a(FilterParam.TuneColorFilter.rgbPoints, bVar.aDh);
            a(FilterParam.TuneColorFilter.redPoints, bVar.aDi);
            a(FilterParam.TuneColorFilter.greenPoints, bVar.aDj);
            a(FilterParam.TuneColorFilter.bluePoints, bVar.aDk);
            return;
        }
        a(SharpnessFilter.sharpness, com.baidu.minivideo.arface.bean.b.aCO);
        a(FilterParam.TuneColorFilter.brightness, com.baidu.minivideo.arface.bean.b.aCP);
        a(FilterParam.TuneColorFilter.contrast, com.baidu.minivideo.arface.bean.b.aCQ);
        a(FilterParam.TuneColorFilter.saturation, com.baidu.minivideo.arface.bean.b.aCR);
        a(FilterParam.TuneColorFilter.curve, com.baidu.minivideo.arface.bean.b.aCS);
        a(FilterParam.TuneColorFilter.rgbPoints, com.baidu.minivideo.arface.bean.b.aCT);
        a(FilterParam.TuneColorFilter.redPoints, com.baidu.minivideo.arface.bean.b.aCU);
        a(FilterParam.TuneColorFilter.greenPoints, com.baidu.minivideo.arface.bean.b.aCV);
        a(FilterParam.TuneColorFilter.bluePoints, com.baidu.minivideo.arface.bean.b.aCW);
    }

    public void a(FilterParam filterParam, float f) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + filterParam + " = " + f);
        }
        if (VF() && filterParam != null) {
            this.bLi.updateFilter(filterParam, f);
        }
    }

    public void a(FilterParam filterParam, List<Point> list) {
        if (isDebug()) {
            h.d("DuAr_DuController", new StringBuilder().append(" updateFilter :").append(filterParam).append(" = ").append(list).toString() != null ? list.toString() : "");
        }
        if (VF() && filterParam != null && list != null) {
            this.bLi.updateFilter(filterParam, list);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + str);
        }
        if (this.bLi != null && beautyType != null) {
            if (beautyType == BeautyType.cheeks || beautyType == BeautyType.lips || beautyType == BeautyType.highlight || beautyType == BeautyType.eyeshadow || beautyType == BeautyType.eyeliner || beautyType == BeautyType.eyebrow || beautyType == BeautyType.eyeball) {
                this.bLi.updateFilterCase(str);
            } else {
                this.bLi.updateFilter(beautyType.type, str);
            }
        }
    }

    public void iJ(String str) {
        if (isDebug()) {
            h.d("DuAr_DuController", " setInitBeautyPath :  " + str);
        }
        if (this.bLi != null) {
            this.bLi.updateFilterCase(str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        if (isDebug()) {
            h.d("DuAr_DuController", " updateFilter :" + beautyType + " = " + com.baidu.arface.a.a.F(fArr));
        }
        if (this.bLi != null && beautyType != null) {
            this.bLi.updateFilter(beautyType.type, fArr);
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
        if (this.bLo != null && TextUtils.isEmpty(str)) {
            this.bLo.onFilterStateChanged(null, null);
        }
        if (VF()) {
            if (isDebug()) {
                h.d("DuAr_DuController", "loadcase Path = " + str + ", arType = " + str2 + ", casePath = " + str2);
            }
            this.bLi.loadCase(aRType, str, str2);
        }
    }

    public void a(ICaptureAbilityListener iCaptureAbilityListener) {
        if (this.bLi != null && this.bLi.getARProxyManager() != null && this.bLi.getARProxyManager().getCaptureAR() != null) {
            this.bLi.getARProxyManager().getCaptureAR().setAbilityListener(iCaptureAbilityListener);
        }
    }

    public void e(ICallbackWith<ICaptureResult> iCallbackWith) {
        if (this.bLi != null && this.bLi.getARProxyManager() != null && this.bLi.getARProxyManager().getCaptureAR() != null) {
            this.bLi.getARProxyManager().getCaptureAR().setCaptureCallback(iCallbackWith);
        }
    }

    public void j(Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && this.bLi != null && this.bLi.getARProxyManager() != null && this.bLi.getARProxyManager().getCaptureAR() != null) {
            if (objArr[0] instanceof Bitmap) {
                Bitmap[] bitmapArr = new Bitmap[objArr.length];
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        bitmapArr[i2] = (Bitmap) objArr[i2];
                        i = i2 + 1;
                    } else {
                        this.bLi.getARProxyManager().getCaptureAR().sendImageToLua(bitmapArr);
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
                        this.bLi.getARProxyManager().getCaptureAR().sendBase64ImageToLua(strArr);
                        return;
                    }
                }
            }
        }
    }

    public static boolean iK(String str) {
        return !TextUtils.isEmpty(str);
    }

    public void setFaceListener(FaceListener faceListener) {
        this.bLm = faceListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (isDebug()) {
            Log.e(str, "ar->" + str2 + (bLd == null ? "" : " by: " + bLd.bLg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isDebug() {
        return b.isDebug();
    }

    public void de(boolean z) {
    }

    public void c(LuaMsgListener luaMsgListener) {
        this.bLn = luaMsgListener;
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        this.bLp = definedLuaListener;
    }

    public void setFilterStateListener(FilterStateListener filterStateListener) {
        this.bLo = filterStateListener;
    }

    public void clearCase() {
        if (this.bLo != null) {
            this.bLo.onFilterStateChanged(null, null);
        }
        if (this.bLi != null) {
            this.bLi.clearCase();
        }
    }

    private Texture S(int i, int i2) {
        IGLRenderer gLRenderer;
        if (this.bLi == null || (gLRenderer = this.bLi.getGLRenderer()) == null) {
            return null;
        }
        return gLRenderer.createTexture(3553, i, i2);
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    public static boolean a(a aVar, Object obj) {
        return (aVar == null || aVar.VG() || aVar.VD() != obj) ? false : true;
    }

    public void updateFilterBrightness(float f) {
        if (this.bLi != null) {
            this.bLi.updateFilter(FilterParam.TuneColorFilter.brightness, f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.bLi != null) {
            this.bLi.updateFilter(FilterParam.TuneColorFilter.contrast, f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.bLi != null) {
            this.bLi.updateFilter(FilterParam.TuneColorFilter.saturation, f);
        }
    }
}
