package com.baidu.pass.face.platform;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.pass.face.platform.c.b;
import com.baidu.pass.face.platform.c.c;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.utils.BitmapUtils;
import com.baidu.pass.main.facesdk.FaceActionLive;
import com.baidu.pass.main.facesdk.FaceAuth;
import com.baidu.pass.main.facesdk.FaceCrop;
import com.baidu.pass.main.facesdk.FaceDetect;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceCropParam;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceIsOutBoundary;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.model.BDFaceSDKConfig;
import com.baidu.sofire.utility.WbEncryptUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class FaceSDKManager {
    public static FaceSDKManager a;
    public Context b;
    public FaceAuth c;
    public FaceDetect d;
    public FaceCrop e;
    public FaceActionLive f;
    public FaceConfig g;
    public boolean h;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, final IInitCallback iInitCallback) {
        this.d = new FaceDetect();
        this.e = new FaceCrop();
        this.f = new FaceActionLive();
        BDFaceSDKConfig bDFaceSDKConfig = new BDFaceSDKConfig();
        bDFaceSDKConfig.minFaceSize = this.g.getMinFaceSize();
        bDFaceSDKConfig.notRGBFaceThreshold = this.g.getNotFaceValue();
        bDFaceSDKConfig.isMouthClose = true;
        bDFaceSDKConfig.isEyeClose = true;
        bDFaceSDKConfig.isCropFace = true;
        bDFaceSDKConfig.isCheckBlur = true;
        bDFaceSDKConfig.isIllumination = true;
        bDFaceSDKConfig.isOcclusion = true;
        bDFaceSDKConfig.isHeadPose = true;
        bDFaceSDKConfig.maxDetectNum = 1;
        this.d.loadConfig(bDFaceSDKConfig);
        if (this.g.getResPaths() == null || this.g.getResPaths().size() == 0) {
            this.g.setResPaths(b());
        }
        WbEncryptUtil.setKeyPath(this.g.getResPaths().get("key"));
        this.d.initModel(context, this.g.getResPaths().get(ConstPath.KEY_DETECT), this.g.getResPaths().get(ConstPath.KEY_ALIGN), BDFaceSDKCommon.DetectType.DETECT_VIS, BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE, new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.2
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public void onResponse(int i, String str) {
                IInitCallback iInitCallback2;
                if (i == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i, str);
            }
        });
        this.d.initQuality(context, this.g.getResPaths().get(ConstPath.KEY_BLUR), this.g.getResPaths().get(ConstPath.KEY_OCCLU), new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.3
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public void onResponse(int i, String str) {
                IInitCallback iInitCallback2;
                if (i == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i, str);
            }
        });
        this.e.initFaceCrop(new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.4
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public void onResponse(int i, String str) {
                IInitCallback iInitCallback2;
                if (i == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i, str);
            }
        });
        this.f.initActionLiveModel(context, this.g.getResPaths().get(ConstPath.KEY_EYES), this.g.getResPaths().get("mouth"), new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.5
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public void onResponse(int i, String str) {
                IInitCallback iInitCallback2;
                if (i != 0 && (iInitCallback2 = iInitCallback) != null) {
                    iInitCallback2.initFailure(i, str);
                }
                if (i != 0 || iInitCallback == null) {
                    return;
                }
                FaceSDKManager.this.h = true;
                iInitCallback.initSuccess();
            }
        });
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", "pass-key.face-android");
        hashMap.put(ConstPath.KEY_DETECT, "detect/detect_rgb-customized-pa-faceid4_0.model.int8.0.0.6.1.pass.mml");
        hashMap.put(ConstPath.KEY_ALIGN, "align/align-customized-pa-offlineCapture_withScore_quant_20200909.model.int8.6.4.7.1.pass.mml");
        hashMap.put(ConstPath.KEY_BLUR, "blur/blur-customized-pa-blurnet_9768.model.int8-3.0.9.1.pass.mml");
        hashMap.put(ConstPath.KEY_OCCLU, "occlusion/occlusion-customized-pa-occ.model.float32.2.0.6.1.pass.mml");
        hashMap.put(ConstPath.KEY_EYES, "eyes_close/eyes-customized-pa-caiji.model.float32.1.0.3.1.pass.mml");
        hashMap.put("mouth", "mouth_close/mouth-customized-pa-caiji.model.float32.1.0.3.1.pass.mml");
        return hashMap;
    }

    private void c() {
        try {
            if (this.d != null) {
                this.d.uninitModel();
            }
            if (this.e != null) {
                this.e.uninitFaceCrop();
            }
            if (this.f != null) {
                this.f.uninitActionLiveModel();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.g != null) {
            this.g = null;
        }
        if (this.c != null) {
            this.c = null;
        }
    }

    public static FaceSDKManager getInstance() {
        if (a == null) {
            synchronized (FaceSDKManager.class) {
                if (a == null) {
                    a = new FaceSDKManager();
                }
            }
        }
        return a;
    }

    public static String getSecDecouplingVersion() {
        return "4.1.1";
    }

    public static String getVersion() {
        return "4.1.1";
    }

    public int a(BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType, BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, AtomicInteger atomicInteger) {
        try {
            return this.f.actionLive(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo.getmLandmarks(), atomicInteger);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public FaceStatusNewEnum a(BDFaceImageInstance bDFaceImageInstance, float[] fArr, int i, int i2) {
        BDFaceCropParam bDFaceCropParam = new BDFaceCropParam();
        bDFaceCropParam.foreheadExtend = 0.22222222f;
        bDFaceCropParam.chinExtend = 0.11111111f;
        bDFaceCropParam.enlargeRatio = getFaceConfig().getEnlargeRatio();
        bDFaceCropParam.height = i;
        bDFaceCropParam.width = i2;
        try {
            BDFaceIsOutBoundary cropFaceByLandmarkIsOutofBoundary = this.e.cropFaceByLandmarkIsOutofBoundary(bDFaceImageInstance, fArr, bDFaceCropParam);
            if (cropFaceByLandmarkIsOutofBoundary != null && cropFaceByLandmarkIsOutofBoundary.top != 1 && cropFaceByLandmarkIsOutofBoundary.bottom != 1 && cropFaceByLandmarkIsOutofBoundary.left != 1 && cropFaceByLandmarkIsOutofBoundary.right != 1) {
                return FaceStatusNewEnum.OK;
            }
            return FaceStatusNewEnum.DetectRemindCodeNoPreviewFrameCenter;
        } catch (Throwable th) {
            th.printStackTrace();
            return FaceStatusNewEnum.DetectRemindCodeNoPreviewFrameCenter;
        }
    }

    public void a() {
        FaceActionLive faceActionLive = this.f;
        if (faceActionLive != null) {
            try {
                faceActionLive.clearHistory();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public FaceInfo[] a(BDFaceImageInstance bDFaceImageInstance) {
        FaceDetect faceDetect = this.d;
        if (faceDetect == null) {
            return null;
        }
        try {
            return faceDetect.track(BDFaceSDKCommon.DetectType.DETECT_VIS, bDFaceImageInstance);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public BDFaceImageInstance b(BDFaceImageInstance bDFaceImageInstance, float[] fArr, int i, int i2) {
        BDFaceCropParam bDFaceCropParam = new BDFaceCropParam();
        bDFaceCropParam.foreheadExtend = 0.22222222f;
        bDFaceCropParam.chinExtend = 0.11111111f;
        bDFaceCropParam.enlargeRatio = getFaceConfig().getEnlargeRatio();
        bDFaceCropParam.height = i;
        bDFaceCropParam.width = i2;
        try {
            return this.e.cropFaceByLandmarkParamInstance(bDFaceImageInstance, fArr, bDFaceCropParam);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public IDetectStrategy getDetectStrategyModule() {
        b bVar = new b(this.b);
        bVar.a(this.g);
        return bVar;
    }

    public FaceConfig getFaceConfig() {
        if (this.g == null) {
            this.g = new FaceConfig();
        }
        return this.g;
    }

    public boolean getInitFlag() {
        return this.h;
    }

    public ILivenessStrategy getLivenessStrategyModule(ILivenessViewCallback iLivenessViewCallback) {
        c cVar = new c(this.b);
        cVar.a(iLivenessViewCallback);
        cVar.a(this.g);
        return cVar;
    }

    public String getZid(Context context) {
        return "";
    }

    public String imageSec(BDFaceImageInstance bDFaceImageInstance, boolean z, int i) {
        String message;
        try {
            if (this.b == null) {
                return "";
            }
            this.b.getClassLoader().loadClass("com.baidu.sofire.utility.WbEncryptUtil");
            return bDFaceImageInstance.getSec(this.b, z, i);
        } catch (ClassNotFoundException unused) {
            message = "no sec";
            Log.e("sec-error", message);
            return "";
        } catch (Exception e) {
            message = e.getMessage();
            Log.e("sec-error", message);
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public void initialize(Context context, String str, IInitCallback iInitCallback) {
        initialize(context, str, "", iInitCallback);
    }

    public void initialize(final Context context, String str, String str2, final IInitCallback iInitCallback) {
        if (this.h) {
            return;
        }
        FaceAuth faceAuth = new FaceAuth();
        this.c = faceAuth;
        if (!faceAuth.isLoadSucess()) {
            iInitCallback.initFailure(-1, "缺少动态库");
            this.c = null;
            return;
        }
        this.b = context.getApplicationContext();
        this.c.setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode.BDFACE_LITE_POWER_NO_BIND, 2);
        this.c.initLicense(new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.1
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public void onResponse(int i, String str3) {
                if (i != 0) {
                    IInitCallback iInitCallback2 = iInitCallback;
                    if (iInitCallback2 != null) {
                        iInitCallback2.initFailure(i, str3);
                        return;
                    }
                    return;
                }
                try {
                    FaceSDKManager.this.a(context, iInitCallback);
                } catch (Throwable th) {
                    th.printStackTrace();
                    iInitCallback.initFailure(-1, "init fail");
                }
            }
        });
    }

    public void release() {
        synchronized (FaceSDKManager.class) {
            if (a != null) {
                a.h = false;
                a.b = null;
                a.c();
                a = null;
            }
        }
    }

    public Bitmap scaleImage(Bitmap bitmap, float f) {
        return BitmapUtils.scale(bitmap, f);
    }

    public Bitmap scaleImage(Bitmap bitmap, int i, int i2) {
        return BitmapUtils.scale(bitmap, i, i2);
    }

    public void setFaceConfig(FaceConfig faceConfig) {
        this.g = faceConfig;
    }
}
