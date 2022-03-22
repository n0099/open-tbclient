package com.baidu.pass.main.facesdk;

import android.content.Context;
import android.util.Log;
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
/* loaded from: classes4.dex */
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

    public FaceFeature() {
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
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }

    public FaceFeature(BDFaceInstance bDFaceInstance) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDFaceInstance};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    private native float nativeFeature(long j, int i, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr);

    private native float nativeFeatureCompare(long j, int i, byte[] bArr, byte[] bArr2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeFeatureModelInit(long j, byte[] bArr, int i);

    private native ArrayList<Feature> nativeFeatureSearch(long j, byte[] bArr, int i, int i2, int i3);

    private native float nativeRGBDFeature(long j, int i, BDFaceImageInstance bDFaceImageInstance, BDFaceImageInstance bDFaceImageInstance2, float[] fArr, byte[] bArr);

    private native int nativeUninitModel(long j);

    private native int nativefeaturePush(List<? extends Feature> list);

    public float feature(BDFaceSDKCommon.FeatureType featureType, BDFaceImageInstance bDFaceImageInstance, float[] fArr, byte[] bArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, featureType, bDFaceImageInstance, fArr, bArr)) == null) {
            if (featureType == null || fArr == null || bArr == null || bDFaceImageInstance == null || fArr.length < 0) {
                Log.v(TAG, "Parameter is null");
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
                Log.v(TAG, "Parameter is null");
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
                Log.v(TAG, "Parameter is null");
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

    public ArrayList<Feature> featureSearch(byte[] bArr, BDFaceSDKCommon.FeatureType featureType, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bArr, featureType, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                    int i;
                    Callback callback2;
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int i2 = 1;
                        if (this.val$context == null) {
                            this.val$callback.onResponse(1, "没有初始化上下文");
                            return;
                        }
                        long index = this.this$0.bdFaceInstance.getIndex();
                        if (index == 0) {
                            return;
                        }
                        byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$idPhotoModel);
                        int i3 = -1;
                        if (modelContent.length != 0) {
                            i = this.this$0.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                            if (i != 0) {
                                this.val$callback.onResponse(i, "证件照识别模型加载失败");
                                return;
                            }
                        } else {
                            i = -1;
                        }
                        byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$visModel);
                        if (modelContent2.length != 0 && (i3 = this.this$0.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal())) != 0) {
                            this.val$callback.onResponse(i3, "Vis 识别模型加载失败");
                            return;
                        }
                        if (i == 0 || i3 == 0) {
                            callback2 = this.val$callback;
                            i2 = 0;
                            str4 = "识别模型加载成功";
                        } else {
                            callback2 = this.val$callback;
                            str4 = "识别模型加载失败";
                        }
                        callback2.onResponse(i2, str4);
                        Log.v(FaceFeature.TAG, "FaceFeature initModel");
                    }
                }
            });
        }
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                            Log.v(FaceFeature.TAG, "FaceFeature未设置模型路径");
                            this.val$callback.onResponse(1, "FaceFeature未设置模型路径");
                        } else if (this.val$context == null) {
                            this.val$callback.onResponse(1, "没有初始化上下文");
                        } else {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            if (this.val$idPhotoModel.length() != 0) {
                                byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$idPhotoModel);
                                if (modelContent.length == 0) {
                                    Log.v(FaceFeature.TAG, "证件照识别模型读取失败");
                                    this.val$callback.onResponse(-1, "证件照识别模型读取失败");
                                    return;
                                }
                                int nativeFeatureModelInit = this.this$0.nativeFeatureModelInit(index, modelContent, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_ID_PHOTO.ordinal());
                                if (nativeFeatureModelInit != 0) {
                                    String str5 = FaceFeature.TAG;
                                    Log.v(str5, "证件照识别模型加载失败: " + nativeFeatureModelInit);
                                    this.val$callback.onResponse(nativeFeatureModelInit, "证件照识别模型加载失败");
                                    return;
                                }
                            }
                            if (this.val$visModel.length() != 0) {
                                byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$visModel);
                                if (modelContent2.length == 0) {
                                    Log.v(FaceFeature.TAG, "生活照识别模型读取失败");
                                    this.val$callback.onResponse(-1, "生活照识别模型读取失败");
                                    return;
                                }
                                int nativeFeatureModelInit2 = this.this$0.nativeFeatureModelInit(index, modelContent2, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_LIVE_PHOTO.ordinal());
                                if (nativeFeatureModelInit2 != 0) {
                                    String str6 = FaceFeature.TAG;
                                    Log.v(str6, "生活照识别模型加载失败: " + nativeFeatureModelInit2);
                                    this.val$callback.onResponse(nativeFeatureModelInit2, "生活照识别模型加载失败");
                                    return;
                                }
                            }
                            if (this.val$nirModel.length() != 0) {
                                byte[] modelContent3 = FileUitls.getModelContent(this.val$context, this.val$nirModel);
                                if (modelContent3.length == 0) {
                                    Log.v(FaceFeature.TAG, "Nir识别模型读取失败");
                                    this.val$callback.onResponse(-1, "Nir识别模型读取失败");
                                    return;
                                }
                                int nativeFeatureModelInit3 = this.this$0.nativeFeatureModelInit(index, modelContent3, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_NIR.ordinal());
                                if (nativeFeatureModelInit3 != 0) {
                                    String str7 = FaceFeature.TAG;
                                    Log.v(str7, "Nir识别模型加载失败: " + nativeFeatureModelInit3);
                                    this.val$callback.onResponse(nativeFeatureModelInit3, "Nir识别模型加载失败");
                                    return;
                                }
                            }
                            if (this.val$rgbdModel.length() != 0) {
                                byte[] modelContent4 = FileUitls.getModelContent(this.val$context, this.val$rgbdModel);
                                if (modelContent4.length == 0) {
                                    Log.v(FaceFeature.TAG, "rgbd识别模型读取失败");
                                    this.val$callback.onResponse(-1, "rgbd识别模型读取失败");
                                    return;
                                }
                                int nativeFeatureModelInit4 = this.this$0.nativeFeatureModelInit(index, modelContent4, BDFaceSDKCommon.FeatureType.BDFACE_FEATURE_TYPE_RGBD.ordinal());
                                if (nativeFeatureModelInit4 != 0) {
                                    String str8 = FaceFeature.TAG;
                                    Log.v(str8, "rgbd识别模型加载失败: " + nativeFeatureModelInit4);
                                    this.val$callback.onResponse(nativeFeatureModelInit4, "rgbd识别模型加载失败");
                                    return;
                                }
                            }
                            Log.v(FaceFeature.TAG, "FaceFeature initModel");
                            this.val$callback.onResponse(0, "识别模型加载成功");
                        }
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
}
