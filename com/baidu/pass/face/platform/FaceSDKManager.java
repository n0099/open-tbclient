package com.baidu.pass.face.platform;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class FaceSDKManager {
    public static /* synthetic */ Interceptable $ic;
    public static FaceSDKManager a;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public FaceAuth c;
    public FaceDetect d;
    public FaceCrop e;
    public FaceActionLive f;
    public FaceConfig g;
    public boolean h;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new FaceConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, IInitCallback iInitCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, iInitCallback) == null) {
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
            this.d.initModel(context, this.g.getResPaths().get(ConstPath.KEY_DETECT), this.g.getResPaths().get(ConstPath.KEY_ALIGN), BDFaceSDKCommon.DetectType.DETECT_VIS, BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE, new Callback(this, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IInitCallback a;
                public final /* synthetic */ FaceSDKManager b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = iInitCallback;
                }

                @Override // com.baidu.pass.main.facesdk.callback.Callback
                public void onResponse(int i, String str) {
                    IInitCallback iInitCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) || i == 0 || (iInitCallback2 = this.a) == null) {
                        return;
                    }
                    iInitCallback2.initFailure(i, str);
                }
            });
            this.d.initQuality(context, this.g.getResPaths().get(ConstPath.KEY_BLUR), this.g.getResPaths().get(ConstPath.KEY_OCCLU), new Callback(this, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IInitCallback a;
                public final /* synthetic */ FaceSDKManager b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = iInitCallback;
                }

                @Override // com.baidu.pass.main.facesdk.callback.Callback
                public void onResponse(int i, String str) {
                    IInitCallback iInitCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) || i == 0 || (iInitCallback2 = this.a) == null) {
                        return;
                    }
                    iInitCallback2.initFailure(i, str);
                }
            });
            this.e.initFaceCrop(new Callback(this, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IInitCallback a;
                public final /* synthetic */ FaceSDKManager b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = iInitCallback;
                }

                @Override // com.baidu.pass.main.facesdk.callback.Callback
                public void onResponse(int i, String str) {
                    IInitCallback iInitCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) || i == 0 || (iInitCallback2 = this.a) == null) {
                        return;
                    }
                    iInitCallback2.initFailure(i, str);
                }
            });
            this.f.initActionLiveModel(context, this.g.getResPaths().get(ConstPath.KEY_EYES), this.g.getResPaths().get("mouth"), new Callback(this, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IInitCallback a;
                public final /* synthetic */ FaceSDKManager b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInitCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = iInitCallback;
                }

                @Override // com.baidu.pass.main.facesdk.callback.Callback
                public void onResponse(int i, String str) {
                    IInitCallback iInitCallback2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        if (i != 0 && (iInitCallback2 = this.a) != null) {
                            iInitCallback2.initFailure(i, str);
                        }
                        if (i != 0 || this.a == null) {
                            return;
                        }
                        this.b.h = true;
                        this.a.initSuccess();
                    }
                }
            });
        }
    }

    private Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
        return (Map) invokeV.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
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
    }

    public static FaceSDKManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (a == null) {
                synchronized (FaceSDKManager.class) {
                    if (a == null) {
                        a = new FaceSDKManager();
                    }
                }
            }
            return a;
        }
        return (FaceSDKManager) invokeV.objValue;
    }

    public static String getSecDecouplingVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? "4.1.1" : (String) invokeV.objValue;
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? "4.1.1" : (String) invokeV.objValue;
    }

    public int a(BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType, BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, AtomicInteger atomicInteger) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo, atomicInteger)) == null) {
            try {
                return this.f.actionLive(bDFaceActionLiveType, bDFaceImageInstance, faceExtInfo.getmLandmarks(), atomicInteger);
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        return invokeLLLL.intValue;
    }

    public FaceStatusNewEnum a(BDFaceImageInstance bDFaceImageInstance, float[] fArr, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bDFaceImageInstance, fArr, i, i2)) == null) {
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
        return (FaceStatusNewEnum) invokeLLII.objValue;
    }

    public void a() {
        FaceActionLive faceActionLive;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (faceActionLive = this.f) == null) {
            return;
        }
        try {
            faceActionLive.clearHistory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public FaceInfo[] a(BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bDFaceImageInstance)) == null) {
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
        return (FaceInfo[]) invokeL.objValue;
    }

    public BDFaceImageInstance b(BDFaceImageInstance bDFaceImageInstance, float[] fArr, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048580, this, bDFaceImageInstance, fArr, i, i2)) == null) {
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
        return (BDFaceImageInstance) invokeLLII.objValue;
    }

    public IDetectStrategy getDetectStrategyModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b bVar = new b(this.b);
            bVar.a(this.g);
            return bVar;
        }
        return (IDetectStrategy) invokeV.objValue;
    }

    public FaceConfig getFaceConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : (FaceConfig) invokeV.objValue;
    }

    public boolean getInitFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public ILivenessStrategy getLivenessStrategyModule(ILivenessViewCallback iLivenessViewCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iLivenessViewCallback)) == null) {
            c cVar = new c(this.b);
            cVar.a(iLivenessViewCallback);
            cVar.a(this.g);
            return cVar;
        }
        return (ILivenessStrategy) invokeL.objValue;
    }

    public String getZid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public String imageSec(BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeL;
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bDFaceImageInstance)) == null) {
            try {
                if (this.b == null) {
                    return "";
                }
                this.b.getClassLoader().loadClass("com.baidu.sofire.utility.WbEncryptUtil");
                return bDFaceImageInstance.getSec(this.b);
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
        return (String) invokeL.objValue;
    }

    public void initialize(Context context, String str, IInitCallback iInitCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, context, str, iInitCallback) == null) {
            initialize(context, str, "", iInitCallback);
        }
    }

    public void initialize(Context context, String str, String str2, IInitCallback iInitCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048588, this, context, str, str2, iInitCallback) == null) || this.h) {
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
        this.c.initLicense(new Callback(this, context, iInitCallback) { // from class: com.baidu.pass.face.platform.FaceSDKManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ IInitCallback b;
            public final /* synthetic */ FaceSDKManager c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, context, iInitCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = this;
                this.a = context;
                this.b = iInitCallback;
            }

            @Override // com.baidu.pass.main.facesdk.callback.Callback
            public void onResponse(int i, String str3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str3) == null) {
                    if (i != 0) {
                        IInitCallback iInitCallback2 = this.b;
                        if (iInitCallback2 != null) {
                            iInitCallback2.initFailure(i, str3);
                            return;
                        }
                        return;
                    }
                    try {
                        this.c.a(this.a, this.b);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        this.b.initFailure(-1, "init fail");
                    }
                }
            }
        });
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (FaceSDKManager.class) {
                if (a != null) {
                    a.h = false;
                    a.b = null;
                    a.c();
                    a = null;
                }
            }
        }
    }

    public Bitmap scaleImage(Bitmap bitmap, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048590, this, bitmap, f)) == null) ? BitmapUtils.scale(bitmap, f) : (Bitmap) invokeLF.objValue;
    }

    public Bitmap scaleImage(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048591, this, bitmap, i, i2)) == null) ? BitmapUtils.scale(bitmap, i, i2) : (Bitmap) invokeLII.objValue;
    }

    public void setFaceConfig(FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, faceConfig) == null) {
            this.g = faceConfig;
        }
    }
}
