package com.baidu.pass.main.facesdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.model.Feature;
import com.baidu.pass.main.facesdk.utils.FileUitls;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FaceFeature {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceFeature";
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceInstance bdFaceInstance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(296118874, "Lcom/baidu/pass/main/facesdk/FaceFeature;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(296118874, "Lcom/baidu/pass/main/facesdk/FaceFeature;");
        }
    }

    public FaceFeature(BDFaceInstance bDFaceInstance) {
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
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native float nativeFeature(long j2, int i2, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr);

    private native float nativeFeatureCompare(long j2, int i2, byte[] bArr, byte[] bArr2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFeatureModelInit(long j2, byte[] bArr, int i2);

    private native ArrayList<Feature> nativeFeatureSearch(long j2, byte[] bArr, int i2, int i3, int i4);

    private native float nativeRGBDFeature(long j2, int i2, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr);

    private native int nativeUninitModel(long j2);

    private native int nativefeaturePush(List<? extends Feature> list);

    public float feature(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, featureType, bDFaceImageInstance, fArr, bArr)) == null) {
            if (featureType == null || fArr == null || bArr == null || bDFaceImageInstance == null || fArr.length < 0) {
                return -1.0f;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeFeature(index, featureType.ordinal(), bDFaceImageInstance, fArr, bArr);
        }
        return invokeLLLL.floatValue;
    }

    public float featureCompare(BDFaceSDKCommon.FeatureType featureType, byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{featureType, bArr, bArr2, Boolean.valueOf(z)})) == null) {
            if (featureType == null || bArr == null || bArr2 == null) {
                return -1.0f;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeFeatureCompare(index, featureType.ordinal(), bArr, bArr2, z ? 1 : 0);
        }
        return invokeCommon.floatValue;
    }

    public int featurePush(List<? extends Feature> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            return -1;
        }
        return invokeL.intValue;
    }

    public float featureRGBD(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, featureType, bDFaceImageInstance, bDFaceImageInstance2, fArr, bArr)) == null) {
            if (featureType == null || fArr == null || bArr == null || bDFaceImageInstance == null || bDFaceImageInstance2 == null || fArr.length < 0) {
                return -1.0f;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeRGBDFeature(index, featureType.ordinal(), bDFaceImageInstance, bDFaceImageInstance2, fArr, bArr);
        }
        return invokeLLLLL.floatValue;
    }

    public ArrayList<Feature> featureSearch(byte[] bArr, BDFaceSDKCommon.FeatureType featureType, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bArr, featureType, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            return null;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void initModel(Context context, String str, String str2, String str3, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, context, str, str2, str3, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str, str2) { // from class: com.baidu.pass.main.facesdk.FaceFeature.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceFeature this$0;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$idPhotoModel;
                public final /* synthetic */ String val$visModel;

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
                    this.val$idPhotoModel = str;
                    this.val$visModel = str2;
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
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$idPhotoModel);
                            int i3 = -1;
                            if (modelContent.length != 0) {
                                i2 = this.this$0.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                                if (i2 != 0) {
                                    this.val$callback.onResponse(i2, "证件照识别模型加载失败");
                                    return;
                                }
                            } else {
                                i2 = -1;
                            }
                            byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$visModel);
                            if (modelContent2.length == 0 || (i3 = this.this$0.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal())) == 0) {
                                if (i2 != 0 && i3 != 0) {
                                    this.val$callback.onResponse(1, "识别模型加载失败");
                                } else {
                                    this.val$callback.onResponse(0, "识别模型加载成功");
                                }
                                String unused = FaceFeature.TAG;
                                return;
                            }
                            this.val$callback.onResponse(i3, "Vis 识别模型加载失败");
                            return;
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public int uninitModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            return nativeUninitModel(index);
        }
        return invokeV.intValue;
    }

    public FaceFeature() {
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
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public void initModel(Context context, String str, String str2, String str3, String str4, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, str3, str4, callback}) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, str, str2, str3, str4, callback, context) { // from class: com.baidu.pass.main.facesdk.FaceFeature.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceFeature this$0;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$idPhotoModel;
                public final /* synthetic */ String val$nirModel;
                public final /* synthetic */ String val$rgbdModel;
                public final /* synthetic */ String val$visModel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, str3, str4, callback, context};
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
                    this.val$idPhotoModel = str;
                    this.val$visModel = str2;
                    this.val$nirModel = str3;
                    this.val$rgbdModel = str4;
                    this.val$callback = callback;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$idPhotoModel.length() == 0 && this.val$visModel.length() == 0 && this.val$nirModel.length() == 0 && this.val$rgbdModel.length() == 0) {
                            String unused = FaceFeature.TAG;
                            this.val$callback.onResponse(1, "FaceFeature未设置模型路径");
                        } else if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            if (this.val$idPhotoModel.length() != 0) {
                                byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$idPhotoModel);
                                if (modelContent.length == 0) {
                                    String unused2 = FaceFeature.TAG;
                                    this.val$callback.onResponse(-1, "证件照识别模型读取失败");
                                    return;
                                }
                                int nativeFeatureModelInit = this.this$0.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                                if (nativeFeatureModelInit != 0) {
                                    String unused3 = FaceFeature.TAG;
                                    String str5 = "证件照识别模型加载失败: " + nativeFeatureModelInit;
                                    this.val$callback.onResponse(nativeFeatureModelInit, "证件照识别模型加载失败");
                                    return;
                                }
                            }
                            if (this.val$visModel.length() != 0) {
                                byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$visModel);
                                if (modelContent2.length == 0) {
                                    String unused4 = FaceFeature.TAG;
                                    this.val$callback.onResponse(-1, "生活照识别模型读取失败");
                                    return;
                                }
                                int nativeFeatureModelInit2 = this.this$0.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal());
                                if (nativeFeatureModelInit2 != 0) {
                                    String unused5 = FaceFeature.TAG;
                                    String str6 = "生活照识别模型加载失败: " + nativeFeatureModelInit2;
                                    this.val$callback.onResponse(nativeFeatureModelInit2, "生活照识别模型加载失败");
                                    return;
                                }
                            }
                            if (this.val$nirModel.length() != 0) {
                                byte[] modelContent3 = FileUitls.getModelContent(this.val$context, this.val$nirModel);
                                if (modelContent3.length == 0) {
                                    String unused6 = FaceFeature.TAG;
                                    this.val$callback.onResponse(-1, "Nir识别模型读取失败");
                                    return;
                                }
                                int nativeFeatureModelInit3 = this.this$0.nativeFeatureModelInit(index, modelContent3, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_NIR.ordinal());
                                if (nativeFeatureModelInit3 != 0) {
                                    String unused7 = FaceFeature.TAG;
                                    String str7 = "Nir识别模型加载失败: " + nativeFeatureModelInit3;
                                    this.val$callback.onResponse(nativeFeatureModelInit3, "Nir识别模型加载失败");
                                    return;
                                }
                            }
                            if (this.val$rgbdModel.length() != 0) {
                                byte[] modelContent4 = FileUitls.getModelContent(this.val$context, this.val$rgbdModel);
                                if (modelContent4.length == 0) {
                                    String unused8 = FaceFeature.TAG;
                                    this.val$callback.onResponse(-1, "rgbd识别模型读取失败");
                                    return;
                                }
                                int nativeFeatureModelInit4 = this.this$0.nativeFeatureModelInit(index, modelContent4, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_RGBD.ordinal());
                                if (nativeFeatureModelInit4 != 0) {
                                    String unused9 = FaceFeature.TAG;
                                    String str8 = "rgbd识别模型加载失败: " + nativeFeatureModelInit4;
                                    this.val$callback.onResponse(nativeFeatureModelInit4, "rgbd识别模型加载失败");
                                    return;
                                }
                            }
                            String unused10 = FaceFeature.TAG;
                            this.val$callback.onResponse(0, "识别模型加载成功");
                        } else {
                            this.val$callback.onResponse(1, "没有初始化上下文");
                        }
                    }
                }
            });
        }
    }
}
