package com.baidu.pass.main.facesdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceGazeInfo;
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
/* loaded from: classes3.dex */
public class FaceGaze {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceGaze";
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceInstance bdFaceInstance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-547584735, "Lcom/baidu/pass/main/facesdk/FaceGaze;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-547584735, "Lcom/baidu/pass/main/facesdk/FaceGaze;");
        }
    }

    public FaceGaze(BDFaceInstance bDFaceInstance) {
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

    private native BDFaceGazeInfo nativeGaze(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGazeModelInit(long j, byte[] bArr);

    private native int nativeUninitGazeModel(long j);

    public BDFaceGazeInfo gaze(BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bDFaceImageInstance, fArr)) == null) {
            if (bDFaceImageInstance == null || fArr == null || fArr.length < 0) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeGaze(index, bDFaceImageInstance, fArr);
        }
        return (BDFaceGazeInfo) invokeLL.objValue;
    }

    public void initModel(Context context, String str, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str) { // from class: com.baidu.pass.main.facesdk.FaceGaze.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceGaze this$0;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$gazeModel;

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
                    this.val$gazeModel = str;
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
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$gazeModel);
                            if (modelContent.length != 0 && (i2 = this.this$0.nativeGazeModelInit(index, modelContent)) != 0) {
                                this.val$callback.onResponse(i2, "注意力检测模型加载失败");
                                return;
                            } else if (i2 == 0) {
                                this.val$callback.onResponse(0, "注意力检测模型加载成功");
                                return;
                            } else {
                                this.val$callback.onResponse(1, "注意力检测模型加载失败");
                                return;
                            }
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public int uninitGazeModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            return nativeUninitGazeModel(index);
        }
        return invokeV.intValue;
    }

    public FaceGaze() {
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
