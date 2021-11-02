package com.baidu.pass.main.facesdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKActionConfig;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.utils.FileUitls;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class FaceActionLive {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceActionLive";
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceInstance bdFaceInstance;
    public int[] isExist;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1758252484, "Lcom/baidu/pass/main/facesdk/FaceActionLive;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1758252484, "Lcom/baidu/pass/main/facesdk/FaceActionLive;");
        }
    }

    public FaceActionLive(BDFaceInstance bDFaceInstance) {
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
        this.isExist = new int[1];
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native int nativeActionLive(long j, int i2, BDFaceImageInstance bDFaceImageInstance, float[] fArr, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeActionLiveModelInit(long j, byte[] bArr, byte[] bArr2);

    private native void nativeActionLoadConfig(long j, BDFaceSDKActionConfig bDFaceSDKActionConfig);

    private native int nativeClearHistory(long j);

    private native int nativeUninitActionLiveModel(long j);

    public int actionLive(BDFaceSDKCommon.BDFaceActionLiveType bDFaceActionLiveType, BDFaceImageInstance bDFaceImageInstance, float[] fArr, AtomicInteger atomicInteger) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bDFaceActionLiveType, bDFaceImageInstance, fArr, atomicInteger)) == null) {
            if (bDFaceImageInstance == null || fArr == null || bDFaceActionLiveType == null || atomicInteger == null) {
                return -1;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            int nativeActionLive = nativeActionLive(index, bDFaceActionLiveType.ordinal(), bDFaceImageInstance, fArr, this.isExist);
            atomicInteger.set(this.isExist[0]);
            return nativeActionLive;
        }
        return invokeLLLL.intValue;
    }

    public int clearHistory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            return nativeClearHistory(index);
        }
        return invokeV.intValue;
    }

    public void initActionLiveModel(Context context, String str, String str2, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str, str2) { // from class: com.baidu.pass.main.facesdk.FaceActionLive.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceActionLive this$0;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$context != null) {
                            long index = this.this$0.bdFaceInstance.getIndex();
                            if (index == 0) {
                                return;
                            }
                            byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$eyecloseModel);
                            byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$mouthcloseModel);
                            if (modelContent.length == 0 || modelContent2.length == 0) {
                                return;
                            }
                            int nativeActionLiveModelInit = this.this$0.nativeActionLiveModelInit(index, modelContent, modelContent2);
                            if (nativeActionLiveModelInit == 0) {
                                this.val$callback.onResponse(nativeActionLiveModelInit, "动作活体模型加载成功");
                                return;
                            } else {
                                this.val$callback.onResponse(nativeActionLiveModelInit, "动作活体模型加载失败");
                                return;
                            }
                        }
                        this.val$callback.onResponse(1, "没有初始化上下文");
                    }
                }
            });
        }
    }

    public void loadActionConfig(BDFaceSDKActionConfig bDFaceSDKActionConfig) {
        BDFaceInstance bDFaceInstance;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bDFaceSDKActionConfig) == null) || (bDFaceInstance = this.bdFaceInstance) == null) {
            return;
        }
        long index = bDFaceInstance.getIndex();
        if (index == 0) {
            return;
        }
        nativeActionLoadConfig(index, bDFaceSDKActionConfig);
    }

    public int uninitActionLiveModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            return nativeUninitActionLiveModel(index);
        }
        return invokeV.intValue;
    }

    public FaceActionLive() {
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
        this.isExist = new int[1];
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
