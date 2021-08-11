package com.baidu.pass.main.facesdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceDriverMonitorInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.utils.FileUitls;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FaceDriverMonitor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceInstance bdFaceInstance;

    public FaceDriverMonitor(BDFaceInstance bDFaceInstance) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDFaceInstance};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    public BDFaceDriverMonitorInfo driverMonitor(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bDFaceImageInstance, faceInfo)) == null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0 || bDFaceImageInstance == null || faceInfo == null) {
                return null;
            }
            return nativeDriverMonitor(index, bDFaceImageInstance, faceInfo);
        }
        return (BDFaceDriverMonitorInfo) invokeLL.objValue;
    }

    public void initDriverMonitor(Context context, String str, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str) { // from class: com.baidu.pass.main.facesdk.FaceDriverMonitor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceDriverMonitor this$0;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$driverMonitorModel;

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
                    this.val$driverMonitorModel = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            int i2 = -1;
                            if (index == 0) {
                                this.val$callback.onResponse(-1, "驾驶行为监测能力加载失败 instanceIndex=0");
                                return;
                            }
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$driverMonitorModel);
                            if (modelContent.length != 0 && (i2 = this.this$0.nativeDriverMonitorInit(index, modelContent)) != 0) {
                                this.val$callback.onResponse(i2, "驾驶行为监测模型加载失败");
                                return;
                            } else if (i2 == 0) {
                                this.val$callback.onResponse(0, "驾驶行为监测模型加载成功");
                                return;
                            } else {
                                this.val$callback.onResponse(1, "驾驶行为监测模型加载失败");
                                return;
                            }
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public native BDFaceDriverMonitorInfo nativeDriverMonitor(long j2, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo);

    public native int nativeDriverMonitorInit(long j2, byte[] bArr);

    public native int nativeUnInitDriverMonitor(long j2);

    public int uninitDriverMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            return nativeUnInitDriverMonitor(index);
        }
        return invokeV.intValue;
    }

    public FaceDriverMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
