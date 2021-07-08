package com.baidu.pass.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.utils.FileUitls;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FaceMouthMask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceMouthMask";
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceInstance bdFaceInstance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1077816483, "Lcom/baidu/pass/main/facesdk/FaceMouthMask;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1077816483, "Lcom/baidu/pass/main/facesdk/FaceMouthMask;");
        }
    }

    public FaceMouthMask(BDFaceInstance bDFaceInstance) {
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

    private native float[] nativeCheckMask(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeInitModel(long j, byte[] bArr);

    private native int nativeUninitModel(long j);

    public float[] checkMask(BDFaceImageInstance bDFaceImageInstance, FaceInfo[] faceInfoArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bDFaceImageInstance, faceInfoArr)) == null) {
            if (bDFaceImageInstance != null && faceInfoArr != null) {
                long index = this.bdFaceInstance.getIndex();
                if (index == 0) {
                    return null;
                }
                return nativeCheckMask(index, bDFaceImageInstance, faceInfoArr);
            }
            Log.v(TAG, "Parameter is null");
            return null;
        }
        return (float[]) invokeLL.objValue;
    }

    public void initModel(Context context, String str, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str) { // from class: com.baidu.pass.main.facesdk.FaceMouthMask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceMouthMask this$0;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$mouthMaskModel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, callback, str};
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
                    this.val$mouthMaskModel = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            int i2 = -1;
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$mouthMaskModel);
                            if (modelContent.length != 0 && (i2 = this.this$0.nativeInitModel(index, modelContent)) != 0) {
                                this.val$callback.onResponse(i2, "口罩检测模型加载失败");
                                return;
                            }
                            if (i2 == 0) {
                                this.val$callback.onResponse(0, "口罩检测模型加载成功");
                            } else {
                                this.val$callback.onResponse(1, "口罩检测模型加载失败");
                            }
                            Log.e("bdface", "FaceMouthMask initModel");
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.bdFaceInstance.getIndex() == 0) {
                return -1;
            }
            return nativeUninitModel(this.bdFaceInstance.getIndex());
        }
        return invokeV.intValue;
    }

    public FaceMouthMask() {
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
}
