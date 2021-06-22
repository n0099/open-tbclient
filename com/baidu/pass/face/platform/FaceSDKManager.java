package com.baidu.pass.face.platform;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.stat.Ast;
import com.baidu.pass.face.platform.strategy.FaceDetectStrategyExtModule;
import com.baidu.pass.face.platform.strategy.FaceLivenessStrategyExtModule;
import com.baidu.pass.face.platform.utils.Base64Utils;
import com.baidu.pass.face.platform.utils.BitmapUtils;
import com.baidu.pass.main.facesdk.FaceActionLive;
import com.baidu.pass.main.facesdk.FaceAuth;
import com.baidu.pass.main.facesdk.FaceCrop;
import com.baidu.pass.main.facesdk.FaceDetect;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceCropParam;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.model.BDFaceSDKConfig;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class FaceSDKManager {
    public static FaceSDKManager instance;
    public Context mContext;
    public FaceActionLive mFaceActionLive;
    public FaceAuth mFaceAuth;
    public FaceConfig mFaceConfig = new FaceConfig();
    public FaceCrop mFaceCrop;
    public FaceDetect mFaceDetect;
    public boolean mInitFlag;

    public static FaceSDKManager getInstance() {
        if (instance == null) {
            synchronized (FaceSDKManager.class) {
                if (instance == null) {
                    instance = new FaceSDKManager();
                }
            }
        }
        return instance;
    }

    public static String getVersion() {
        return FaceEnvironment.SDK_VERSION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initModel(Context context, final IInitCallback iInitCallback) {
        this.mFaceDetect = new FaceDetect();
        this.mFaceCrop = new FaceCrop();
        this.mFaceActionLive = new FaceActionLive();
        BDFaceSDKConfig bDFaceSDKConfig = new BDFaceSDKConfig();
        bDFaceSDKConfig.minFaceSize = this.mFaceConfig.getMinFaceSize();
        bDFaceSDKConfig.notRGBFaceThreshold = this.mFaceConfig.getNotFaceValue();
        bDFaceSDKConfig.isMouthClose = true;
        bDFaceSDKConfig.isEyeClose = true;
        bDFaceSDKConfig.isCropFace = true;
        bDFaceSDKConfig.isCheckBlur = true;
        bDFaceSDKConfig.isIllumination = true;
        bDFaceSDKConfig.isOcclusion = true;
        bDFaceSDKConfig.isHeadPose = true;
        bDFaceSDKConfig.maxDetectNum = 1;
        this.mFaceDetect.loadConfig(bDFaceSDKConfig);
        this.mFaceDetect.initModel(context, "detect/detect_rgb-customized-pa-faceid4_0.model.int8.0.0.6.1.pass.mml", "align/align-customized-pa-offlineCapture_withScore_quant_20200909.model.int8.6.4.7.1.pass.mml", BDFaceSDKCommon.DetectType.DETECT_VIS, BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE, new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.2
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public final void onResponse(int i2, String str) {
                IInitCallback iInitCallback2;
                if (i2 == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i2, str);
            }
        });
        this.mFaceDetect.initQuality(context, "blur/blur-customized-pa-blurnet_9768.model.int8-3.0.9.1.pass.mml", "occlusion/occlusion-customized-pa-occ.model.float32.2.0.6.1.pass.mml", new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.3
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public final void onResponse(int i2, String str) {
                IInitCallback iInitCallback2;
                if (i2 == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i2, str);
            }
        });
        this.mFaceCrop.initFaceCrop(new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.4
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public final void onResponse(int i2, String str) {
                IInitCallback iInitCallback2;
                if (i2 == 0 || (iInitCallback2 = iInitCallback) == null) {
                    return;
                }
                iInitCallback2.initFailure(i2, str);
            }
        });
        this.mFaceActionLive.initActionLiveModel(context, "eyes_close/eyes-customized-pa-caiji.model.float32.1.0.3.1.pass.mml", "mouth_close/mouth-customized-pa-caiji.model.float32.1.0.3.1.pass.mml", new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.5
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public final void onResponse(int i2, String str) {
                IInitCallback iInitCallback2;
                if (i2 != 0 && (iInitCallback2 = iInitCallback) != null) {
                    iInitCallback2.initFailure(i2, str);
                }
                if (i2 != 0 || iInitCallback == null) {
                    return;
                }
                FaceSDKManager.this.mInitFlag = true;
                iInitCallback.initSuccess();
            }
        });
    }

    private void releaseModel() {
        FaceDetect faceDetect = this.mFaceDetect;
        if (faceDetect != null) {
            faceDetect.uninitModel();
        }
        FaceCrop faceCrop = this.mFaceCrop;
        if (faceCrop != null) {
            faceCrop.uninitFaceCrop();
        }
        FaceActionLive faceActionLive = this.mFaceActionLive;
        if (faceActionLive != null) {
            faceActionLive.uninitActionLiveModel();
        }
        if (this.mFaceConfig != null) {
            this.mFaceConfig = null;
        }
        if (this.mFaceAuth != null) {
            this.mFaceAuth = null;
        }
    }

    public String bitmapToBase64(byte[] bArr) {
        return Base64Utils.encodeToString(bArr, 2);
    }

    public void clearActionHistory() {
        FaceActionLive faceActionLive = this.mFaceActionLive;
        if (faceActionLive != null) {
            faceActionLive.clearHistory();
        }
    }

    public byte[] compressImage(Bitmap bitmap, int i2) {
        return BitmapUtils.bitmapCompress(bitmap, i2);
    }

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr, int i2, int i3) {
        BDFaceCropParam bDFaceCropParam = new BDFaceCropParam();
        bDFaceCropParam.foreheadExtend = 0.22222222f;
        bDFaceCropParam.chinExtend = 0.11111111f;
        bDFaceCropParam.enlargeRatio = getFaceConfig().getEnlargeRatio();
        bDFaceCropParam.height = i2;
        bDFaceCropParam.width = i3;
        if (this.mFaceCrop.cropFaceByLandmarkIsOutofBoundary(bDFaceImageInstance, fArr, bDFaceCropParam) == null) {
            return null;
        }
        return this.mFaceCrop.cropFaceByLandmarkParamInstance(bDFaceImageInstance, fArr, bDFaceCropParam);
    }

    public FaceInfo[] detect(BDFaceImageInstance bDFaceImageInstance) {
        FaceDetect faceDetect = this.mFaceDetect;
        if (faceDetect == null) {
            return null;
        }
        return faceDetect.track(BDFaceSDKCommon.DetectType.DETECT_VIS, bDFaceImageInstance);
    }

    public a getDetectStrategyModule() {
        FaceDetectStrategyExtModule faceDetectStrategyExtModule = new FaceDetectStrategyExtModule(this.mContext);
        faceDetectStrategyExtModule.setConfigValue(this.mFaceConfig);
        return faceDetectStrategyExtModule;
    }

    public FaceConfig getFaceConfig() {
        return this.mFaceConfig;
    }

    public boolean getInitFlag() {
        return this.mInitFlag;
    }

    public c getLivenessStrategyModule(e eVar) {
        FaceLivenessStrategyExtModule faceLivenessStrategyExtModule = new FaceLivenessStrategyExtModule(this.mContext);
        faceLivenessStrategyExtModule.setILivenessViewCallback(eVar);
        faceLivenessStrategyExtModule.setConfig(this.mFaceConfig);
        return faceLivenessStrategyExtModule;
    }

    public String getZid(Context context) {
        return "";
    }

    public String imageSec(BDFaceImageInstance bDFaceImageInstance) {
        try {
            if (this.mContext == null) {
                return "";
            }
            this.mContext.getClassLoader().loadClass("com.baidu.sofire.utility.WbEncryptUtil");
            return bDFaceImageInstance.getSec(this.mContext);
        } catch (ClassNotFoundException unused) {
            Log.e("sec-error", "no sec");
            return "";
        } catch (Exception e2) {
            Log.e("sec-error", e2.getMessage());
            return "";
        }
    }

    public void initialize(Context context, String str, IInitCallback iInitCallback) {
        initialize(context, str, "", iInitCallback);
    }

    public int processLiveness(BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType, BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, AtomicInteger atomicInteger) {
        return this.mFaceActionLive.actionLive(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo.getmLandmarks(), atomicInteger);
    }

    public void release() {
        synchronized (FaceSDKManager.class) {
            if (instance != null) {
                instance.mInitFlag = false;
                instance.mContext = null;
                instance.releaseModel();
                instance = null;
            }
            Ast.getInstance().immediatelyUpload();
        }
    }

    public Bitmap scaleImage(Bitmap bitmap, int i2, int i3) {
        return BitmapUtils.scale(bitmap, i2, i3);
    }

    public void setFaceConfig(FaceConfig faceConfig) {
        this.mFaceConfig = faceConfig;
    }

    public void initialize(final Context context, String str, String str2, final IInitCallback iInitCallback) {
        if (this.mInitFlag) {
            return;
        }
        FaceAuth faceAuth = new FaceAuth();
        this.mFaceAuth = faceAuth;
        if (!faceAuth.isLoadSucess()) {
            iInitCallback.initFailure(-1, "缺少动态库");
            this.mFaceAuth = null;
            return;
        }
        this.mContext = context.getApplicationContext();
        this.mFaceAuth.setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode.BDFACE_LITE_POWER_NO_BIND, 2);
        this.mFaceAuth.initLicense(new Callback() { // from class: com.baidu.pass.face.platform.FaceSDKManager.1
            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public final void onResponse(int i2, String str3) {
                if (i2 == 0) {
                    Ast.getInstance().init(context, "4.1.0.0", "facenormal");
                    FaceSDKManager.this.initModel(context, iInitCallback);
                    return;
                }
                IInitCallback iInitCallback2 = iInitCallback;
                if (iInitCallback2 != null) {
                    iInitCallback2.initFailure(i2, str3);
                }
            }
        });
    }

    public Bitmap scaleImage(Bitmap bitmap, float f2) {
        return BitmapUtils.scale(bitmap, f2);
    }
}
