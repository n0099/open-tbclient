package com.baidu.pass.face.platform;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.face.platform.listener.IInitCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
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
import com.baidu.pass.main.facesdk.model.BDFaceIsOutBoundary;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.model.BDFaceSDKConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class FaceSDKManager {
    public static /* synthetic */ Interceptable $ic;
    public static FaceSDKManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public FaceActionLive mFaceActionLive;
    public FaceAuth mFaceAuth;
    public FaceConfig mFaceConfig;
    public FaceCrop mFaceCrop;
    public FaceDetect mFaceDetect;
    public boolean mInitFlag;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-750512719, "Lcom/baidu/pass/face/platform/FaceSDKManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-750512719, "Lcom/baidu/pass/face/platform/FaceSDKManager;");
        }
    }

    public FaceSDKManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFaceConfig = new FaceConfig();
    }

    public static FaceSDKManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (instance == null) {
                synchronized (FaceSDKManager.class) {
                    if (instance == null) {
                        instance = new FaceSDKManager();
                    }
                }
            }
            return instance;
        }
        return (FaceSDKManager) invokeV.objValue;
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? FaceEnvironment.SDK_VERSION : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initModel(Context context, IInitCallback iInitCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, context, iInitCallback) == null) {
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
            this.mFaceDetect.initModel(context, "detect/detect_rgb-customized-pa-faceid4_0.model.int8.0.0.6.1.pass.mml", "align/align-customized-pa-offlineCapture_withScore_quant_20200909.model.int8.6.4.7.1.pass.mml", BDFaceSDKCommon.DetectType.DETECT_VIS, BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE, new Callback(this, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IInitCallback f41948a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FaceSDKManager f41949b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41949b = this;
                    this.f41948a = iInitCallback;
                }

                @Override // com.baidu.pass.main.facesdk.callback.Callback
                public final void onResponse(int i2, String str) {
                    IInitCallback iInitCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || i2 == 0 || (iInitCallback2 = this.f41948a) == null) {
                        return;
                    }
                    iInitCallback2.initFailure(i2, str);
                }
            });
            this.mFaceDetect.initQuality(context, "blur/blur-customized-pa-blurnet_9768.model.int8-3.0.9.1.pass.mml", "occlusion/occlusion-customized-pa-occ.model.float32.2.0.6.1.pass.mml", new Callback(this, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IInitCallback f41950a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FaceSDKManager f41951b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41951b = this;
                    this.f41950a = iInitCallback;
                }

                @Override // com.baidu.pass.main.facesdk.callback.Callback
                public final void onResponse(int i2, String str) {
                    IInitCallback iInitCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || i2 == 0 || (iInitCallback2 = this.f41950a) == null) {
                        return;
                    }
                    iInitCallback2.initFailure(i2, str);
                }
            });
            this.mFaceCrop.initFaceCrop(new Callback(this, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IInitCallback f41952a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FaceSDKManager f41953b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41953b = this;
                    this.f41952a = iInitCallback;
                }

                @Override // com.baidu.pass.main.facesdk.callback.Callback
                public final void onResponse(int i2, String str) {
                    IInitCallback iInitCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || i2 == 0 || (iInitCallback2 = this.f41952a) == null) {
                        return;
                    }
                    iInitCallback2.initFailure(i2, str);
                }
            });
            this.mFaceActionLive.initActionLiveModel(context, "eyes_close/eyes-customized-pa-caiji.model.float32.1.0.3.1.pass.mml", "mouth_close/mouth-customized-pa-caiji.model.float32.1.0.3.1.pass.mml", new Callback(this, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ IInitCallback f41954a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FaceSDKManager f41955b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f41955b = this;
                    this.f41954a = iInitCallback;
                }

                @Override // com.baidu.pass.main.facesdk.callback.Callback
                public final void onResponse(int i2, String str) {
                    IInitCallback iInitCallback2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 != 0 && (iInitCallback2 = this.f41954a) != null) {
                            iInitCallback2.initFailure(i2, str);
                        }
                        if (i2 != 0 || this.f41954a == null) {
                            return;
                        }
                        this.f41955b.mInitFlag = true;
                        this.f41954a.initSuccess();
                    }
                }
            });
        }
    }

    private void releaseModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                if (this.mFaceDetect != null) {
                    this.mFaceDetect.uninitModel();
                }
                if (this.mFaceCrop != null) {
                    this.mFaceCrop.uninitFaceCrop();
                }
                if (this.mFaceActionLive != null) {
                    this.mFaceActionLive.uninitActionLiveModel();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.mFaceConfig != null) {
                this.mFaceConfig = null;
            }
            if (this.mFaceAuth != null) {
                this.mFaceAuth = null;
            }
        }
    }

    public String bitmapToBase64(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) ? Base64Utils.encodeToString(bArr, 2) : (String) invokeL.objValue;
    }

    public void clearActionHistory() {
        FaceActionLive faceActionLive;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (faceActionLive = this.mFaceActionLive) == null) {
            return;
        }
        try {
            faceActionLive.clearHistory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public byte[] compressImage(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bitmap, i2)) == null) ? BitmapUtils.bitmapCompress(bitmap, i2) : (byte[]) invokeLI.objValue;
    }

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, bDFaceImageInstance, fArr, i2, i3)) == null) {
            BDFaceCropParam bDFaceCropParam = new BDFaceCropParam();
            bDFaceCropParam.foreheadExtend = 0.22222222f;
            bDFaceCropParam.chinExtend = 0.11111111f;
            bDFaceCropParam.enlargeRatio = getFaceConfig().getEnlargeRatio();
            bDFaceCropParam.height = i2;
            bDFaceCropParam.width = i3;
            try {
                return this.mFaceCrop.cropFaceByLandmarkParamInstance(bDFaceImageInstance, fArr, bDFaceCropParam);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (BDFaceImageInstance) invokeLLII.objValue;
    }

    public FaceStatusNewEnum cropIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, float[] fArr, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048580, this, bDFaceImageInstance, fArr, i2, i3)) == null) {
            BDFaceCropParam bDFaceCropParam = new BDFaceCropParam();
            bDFaceCropParam.foreheadExtend = 0.22222222f;
            bDFaceCropParam.chinExtend = 0.11111111f;
            bDFaceCropParam.enlargeRatio = getFaceConfig().getEnlargeRatio();
            bDFaceCropParam.height = i2;
            bDFaceCropParam.width = i3;
            try {
                BDFaceIsOutBoundary cropFaceByLandmarkIsOutofBoundary = this.mFaceCrop.cropFaceByLandmarkIsOutofBoundary(bDFaceImageInstance, fArr, bDFaceCropParam);
                if (cropFaceByLandmarkIsOutofBoundary != null && cropFaceByLandmarkIsOutofBoundary.top != 1 && cropFaceByLandmarkIsOutofBoundary.bottom != 1 && cropFaceByLandmarkIsOutofBoundary.left != 1 && cropFaceByLandmarkIsOutofBoundary.right != 1) {
                    return FaceStatusNewEnum.OK;
                }
                return FaceStatusNewEnum.DetectRemindCodeNoPreviewFrameCenter;
            } catch (Throwable th) {
                th.printStackTrace();
                return FaceStatusNewEnum.DetectRemindCodeNoPreviewFrameCenter;
            }
        }
        return (FaceStatusNewEnum) invokeLLII.objValue;
    }

    public FaceInfo[] detect(BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bDFaceImageInstance)) == null) {
            FaceDetect faceDetect = this.mFaceDetect;
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
        return (FaceInfo[]) invokeL.objValue;
    }

    public a getDetectStrategyModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FaceDetectStrategyExtModule faceDetectStrategyExtModule = new FaceDetectStrategyExtModule(this.mContext);
            faceDetectStrategyExtModule.setConfigValue(this.mFaceConfig);
            return faceDetectStrategyExtModule;
        }
        return (a) invokeV.objValue;
    }

    public FaceConfig getFaceConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mFaceConfig : (FaceConfig) invokeV.objValue;
    }

    public boolean getInitFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mInitFlag : invokeV.booleanValue;
    }

    public c getLivenessStrategyModule(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) {
            FaceLivenessStrategyExtModule faceLivenessStrategyExtModule = new FaceLivenessStrategyExtModule(this.mContext);
            faceLivenessStrategyExtModule.setILivenessViewCallback(eVar);
            faceLivenessStrategyExtModule.setConfig(this.mFaceConfig);
            return faceLivenessStrategyExtModule;
        }
        return (c) invokeL.objValue;
    }

    public String getZid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public String imageSec(BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bDFaceImageInstance)) == null) {
            try {
                if (this.mContext == null) {
                    return "";
                }
                this.mContext.getClassLoader().loadClass("com.baidu.sofire.utility.WbEncryptUtil");
                return bDFaceImageInstance.getSec(this.mContext);
            } catch (ClassNotFoundException unused) {
                return "";
            } catch (Exception e2) {
                e2.getMessage();
                return "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public void initialize(Context context, String str, IInitCallback iInitCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, context, str, iInitCallback) == null) {
            initialize(context, str, "", iInitCallback);
        }
    }

    public int processLiveness(BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType, BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, AtomicInteger atomicInteger) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger)) == null) {
            try {
                return this.mFaceActionLive.actionLive(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo.getmLandmarks(), atomicInteger);
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        return invokeLLLL.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (FaceSDKManager.class) {
                if (instance != null) {
                    instance.mInitFlag = false;
                    instance.mContext = null;
                    instance.releaseModel();
                    instance = null;
                }
            }
        }
    }

    public Bitmap scaleImage(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, bitmap, i2, i3)) == null) ? BitmapUtils.scale(bitmap, i2, i3) : (Bitmap) invokeLII.objValue;
    }

    public void setFaceConfig(FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, faceConfig) == null) {
            this.mFaceConfig = faceConfig;
        }
    }

    public void initialize(Context context, String str, String str2, IInitCallback iInitCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048589, this, context, str, str2, iInitCallback) == null) || this.mInitFlag) {
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
        this.mFaceAuth.initLicense(new Callback(this, context, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f41945a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ IInitCallback f41946b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ FaceSDKManager f41947c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, iInitCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41947c = this;
                this.f41945a = context;
                this.f41946b = iInitCallback;
            }

            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public final void onResponse(int i2, String str3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                    if (i2 == 0) {
                        this.f41947c.initModel(this.f41945a, this.f41946b);
                        return;
                    }
                    IInitCallback iInitCallback2 = this.f41946b;
                    if (iInitCallback2 != null) {
                        iInitCallback2.initFailure(i2, str3);
                    }
                }
            }
        });
    }

    public Bitmap scaleImage(Bitmap bitmap, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048592, this, bitmap, f2)) == null) ? BitmapUtils.scale(bitmap, f2) : (Bitmap) invokeLF.objValue;
    }
}
