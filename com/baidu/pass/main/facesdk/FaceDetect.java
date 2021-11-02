package com.baidu.pass.main.facesdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceDetectListConf;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.model.BDFaceSDKConfig;
import com.baidu.pass.main.facesdk.utils.FileUitls;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public class FaceDetect {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceDetect";
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceInstance bdFaceInstance;
    public ReentrantLock lock;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-501446397, "Lcom/baidu/pass/main/facesdk/FaceDetect;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-501446397, "Lcom/baidu/pass/main/facesdk/FaceDetect;");
        }
    }

    public FaceDetect(BDFaceInstance bDFaceInstance) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDFaceInstance};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.lock = null;
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
        this.lock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAlignModelInit(long j, int i2, int i3, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeAttributeModelInit(long j, byte[] bArr);

    private native BDFaceImageInstance nativeCropFace(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    private native FaceInfo[] nativeDetect(long j, int i2, int i3, BDFaceImageInstance bDFaceImageInstance);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeDetectModelInit(long j, byte[] bArr, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeEmotionsModelInit(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFaceCloseModelInit(long j, byte[] bArr, int i2);

    private native FaceInfo[] nativeFastTrack(long j, int i2, int i3, BDFaceImageInstance bDFaceImageInstance);

    private native FaceInfo[] nativeFlexibleDetect(long j, int i2, int i3, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf);

    private native void nativeLoadConfig(long j, BDFaceSDKConfig bDFaceSDKConfig);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeLoadTrack(long j, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeQualityModelInit(long j, byte[] bArr, int i2);

    private native FaceInfo[] nativeTrack(long j, int i2, BDFaceImageInstance bDFaceImageInstance);

    private native int nativeUninitModel(long j);

    public BDFaceImageInstance cropFace(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bDFaceImageInstance, fArr)) == null) {
            if (bDFaceImageInstance == null || fArr == null) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFace(index, bDFaceImageInstance, fArr);
        }
        return (BDFaceImageInstance) invokeLL.objValue;
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, detectType, bDFaceImageInstance)) == null) {
            if (detectType == null || bDFaceImageInstance == null) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeDetect = nativeDetect(index, detectType.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), bDFaceImageInstance);
                this.lock.unlock();
                return nativeDetect;
            }
            return null;
        }
        return (FaceInfo[]) invokeLL.objValue;
    }

    public void initAttrEmo(Context context, String str, String str2, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, str2, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str, str2) { // from class: com.baidu.pass.main.facesdk.FaceDetect.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceDetect this$0;
                public final /* synthetic */ String val$atttibuteModel;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$emotionModel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, callback, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$callback = callback;
                    this.val$atttibuteModel = str;
                    this.val$emotionModel = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$atttibuteModel);
                            int i3 = -1;
                            if (modelContent.length != 0) {
                                i2 = this.this$0.nativeAttributeModelInit(index, modelContent);
                                if (i2 != 0) {
                                    this.val$callback.onResponse(i2, "属性模型加载失败");
                                    return;
                                }
                            } else {
                                i2 = -1;
                            }
                            byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$emotionModel);
                            if (modelContent2.length != 0 && (i3 = this.this$0.nativeEmotionsModelInit(index, modelContent2)) != 0) {
                                this.val$callback.onResponse(i3, "情绪模型加载失败");
                                return;
                            } else if (i2 != 0 && i3 != 0) {
                                this.val$callback.onResponse(1, "属性模型加载失败");
                                return;
                            } else {
                                this.val$callback.onResponse(0, "属性模型加载成功");
                                return;
                            }
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public void initFaceClose(Context context, String str, String str2, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, str2, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str, str2) { // from class: com.baidu.pass.main.facesdk.FaceDetect.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceDetect this$0;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$eyecloseModel;
                public final /* synthetic */ String val$mouthcloseModel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, callback, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$callback = callback;
                    this.val$eyecloseModel = str;
                    this.val$mouthcloseModel = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$eyecloseModel);
                            int i3 = -1;
                            if (modelContent.length != 0) {
                                i2 = this.this$0.nativeFaceCloseModelInit(index, modelContent, 0);
                                if (i2 != 0) {
                                    this.val$callback.onResponse(i2, "眼睛闭合模型加载失败");
                                    return;
                                }
                            } else {
                                i2 = -1;
                            }
                            byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$mouthcloseModel);
                            if (modelContent2.length != 0 && (i3 = this.this$0.nativeFaceCloseModelInit(index, modelContent2, 1)) != 0) {
                                this.val$callback.onResponse(i3, "嘴巴闭合模型加载失败");
                                return;
                            } else if (i2 != 0 && i3 != 0) {
                                this.val$callback.onResponse(1, "闭眼闭嘴模型加载失败");
                                return;
                            } else {
                                this.val$callback.onResponse(0, "闭眼闭嘴模型加载成功");
                                return;
                            }
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public void initModel(Context context, String str, String str2, String str3, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, context, str, str2, str3, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str, str2, str3) { // from class: com.baidu.pass.main.facesdk.FaceDetect.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceDetect this$0;
                public final /* synthetic */ String val$alignModel;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$nirModel;
                public final /* synthetic */ String val$visModel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, callback, str, str2, str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$callback = callback;
                    this.val$visModel = str;
                    this.val$nirModel = str2;
                    this.val$alignModel = str3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    int i3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$visModel);
                            int i4 = -1;
                            if (modelContent.length != 0) {
                                i2 = this.this$0.nativeDetectModelInit(index, modelContent, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal());
                                if (i2 != 0) {
                                    this.val$callback.onResponse(i2, "Vis检测模型加载失败");
                                    return;
                                }
                            } else {
                                i2 = -1;
                            }
                            byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$nirModel);
                            if (modelContent2.length != 0) {
                                int nativeDetectModelInit = this.this$0.nativeDetectModelInit(index, modelContent2, BDFaceSDKCommon.DetectType.DETECT_NIR.ordinal());
                                if (nativeDetectModelInit != 0) {
                                    this.val$callback.onResponse(nativeDetectModelInit, "Nir检测模型加载失败");
                                    return;
                                }
                                i3 = nativeDetectModelInit;
                            } else {
                                i3 = -1;
                            }
                            byte[] modelContent3 = FileUitls.getModelContent(this.val$context, this.val$alignModel);
                            if (modelContent3.length == 0 || (i4 = this.this$0.nativeAlignModelInit(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal(), modelContent3)) == 0) {
                                int nativeLoadTrack = this.this$0.nativeLoadTrack(index, BDFaceSDKCommon.DetectType.DETECT_VIS.ordinal(), BDFaceSDKCommon.AlignType.BDFACE_ALIGN_TYPE_RGB_ACCURATE.ordinal());
                                if (nativeLoadTrack == 0) {
                                    if ((i2 == 0 || i3 == 0) && i4 == 0) {
                                        this.val$callback.onResponse(0, "检测对齐模型加载成功");
                                    } else {
                                        this.val$callback.onResponse(1, "检测对齐模型加载失败");
                                    }
                                    String unused = FaceDetect.TAG;
                                    return;
                                }
                                this.val$callback.onResponse(nativeLoadTrack, "跟踪能力加载失败");
                                return;
                            }
                            this.val$callback.onResponse(i4, "对齐模型加载失败");
                            return;
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public void initQuality(Context context, String str, String str2, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, context, str, str2, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str, str2) { // from class: com.baidu.pass.main.facesdk.FaceDetect.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceDetect this$0;
                public final /* synthetic */ String val$blurModel;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$occlurModel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, callback, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$callback = callback;
                    this.val$blurModel = str;
                    this.val$occlurModel = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$blurModel);
                            int i3 = -1;
                            if (modelContent.length != 0) {
                                i2 = this.this$0.nativeQualityModelInit(index, modelContent, BDFaceSDKCommon.FaceQualityType.BLUR.ordinal());
                                if (i2 != 0) {
                                    this.val$callback.onResponse(i2, "模糊模型加载失败");
                                    return;
                                }
                            } else {
                                i2 = -1;
                            }
                            byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$occlurModel);
                            if (modelContent2.length == 0 || (i3 = this.this$0.nativeQualityModelInit(index, modelContent2, BDFaceSDKCommon.FaceQualityType.OCCLUSION.ordinal())) == 0) {
                                if (i2 != 0 && i3 != 0) {
                                    this.val$callback.onResponse(1, "质量模型加载失败");
                                } else {
                                    this.val$callback.onResponse(0, "质量模型加载成功");
                                }
                                String unused = FaceDetect.TAG;
                                return;
                            }
                            this.val$callback.onResponse(i3, "遮挡模型加载失败");
                            return;
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public void loadConfig(BDFaceSDKConfig bDFaceSDKConfig) {
        BDFaceInstance bDFaceInstance;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDFaceSDKConfig) == null) || (bDFaceInstance = this.bdFaceInstance) == null) {
            return;
        }
        long index = bDFaceInstance.getIndex();
        if (index == 0) {
            return;
        }
        nativeLoadConfig(index, bDFaceSDKConfig);
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, detectType, bDFaceImageInstance)) == null) {
            if (detectType == null || bDFaceImageInstance == null) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeTrack = nativeTrack(index, detectType.ordinal(), bDFaceImageInstance);
                this.lock.unlock();
                return nativeTrack;
            }
            return null;
        }
        return (FaceInfo[]) invokeLL.objValue;
    }

    public int uninitModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            return nativeUninitModel(index);
        }
        return invokeV.intValue;
    }

    public void initModel(Context context, String str, String str2, BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, str2, detectType, alignType, callback}) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str, detectType, str2, alignType) { // from class: com.baidu.pass.main.facesdk.FaceDetect.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceDetect this$0;
                public final /* synthetic */ String val$alignModel;
                public final /* synthetic */ BDFaceSDKCommon.AlignType val$alignType;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$detectModel;
                public final /* synthetic */ BDFaceSDKCommon.DetectType val$detectType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, callback, str, detectType, str2, alignType};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$callback = callback;
                    this.val$detectModel = str;
                    this.val$detectType = detectType;
                    this.val$alignModel = str2;
                    this.val$alignType = alignType;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$detectModel);
                            int i3 = -1;
                            if (modelContent.length != 0) {
                                i2 = this.this$0.nativeDetectModelInit(index, modelContent, this.val$detectType.ordinal());
                                if (i2 != 0) {
                                    this.val$callback.onResponse(i2, "检测模型加载失败");
                                    return;
                                }
                            } else {
                                i2 = -1;
                            }
                            byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$alignModel);
                            if (modelContent2.length == 0 || (i3 = this.this$0.nativeAlignModelInit(index, this.val$detectType.ordinal(), this.val$alignType.ordinal(), modelContent2)) == 0) {
                                int nativeLoadTrack = this.this$0.nativeLoadTrack(index, this.val$detectType.ordinal(), this.val$alignType.ordinal());
                                if (nativeLoadTrack == 0) {
                                    if (i2 == 0 && i3 == 0) {
                                        this.val$callback.onResponse(0, "检测对齐模型加载成功");
                                    } else {
                                        this.val$callback.onResponse(1, "检测对齐模型加载失败");
                                    }
                                    String unused = FaceDetect.TAG;
                                    return;
                                }
                                this.val$callback.onResponse(nativeLoadTrack, "跟踪能力加载失败");
                                return;
                            }
                            this.val$callback.onResponse(i3, "对齐模型加载失败");
                            return;
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public FaceDetect() {
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
        this.lock = null;
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
        this.lock = new ReentrantLock();
    }

    public FaceInfo[] track(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, detectType, alignType, bDFaceImageInstance)) == null) {
            if (detectType == null || bDFaceImageInstance == null || alignType == null) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeFastTrack(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance);
        }
        return (FaceInfo[]) invokeLLL.objValue;
    }

    public FaceInfo[] detect(BDFaceSDKCommon.DetectType detectType, BDFaceSDKCommon.AlignType alignType, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr, BDFaceDetectListConf bDFaceDetectListConf) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, detectType, alignType, bDFaceImageInstance, faceInfoArr, bDFaceDetectListConf)) == null) {
            if (detectType == null || bDFaceImageInstance == null || alignType == null) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index != 0 && this.lock.tryLock()) {
                FaceInfo[] nativeFlexibleDetect = nativeFlexibleDetect(index, detectType.ordinal(), alignType.ordinal(), bDFaceImageInstance, faceInfoArr, bDFaceDetectListConf);
                this.lock.unlock();
                return nativeFlexibleDetect;
            }
            return null;
        }
        return (FaceInfo[]) invokeLLLLL.objValue;
    }
}
