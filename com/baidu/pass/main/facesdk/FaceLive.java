package com.baidu.pass.main.facesdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.pass.main.facesdk.utils.FileUitls;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FaceLive {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceLive";
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceInstance bdFaceInstance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-542732646, "Lcom/baidu/pass/main/facesdk/FaceLive;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-542732646, "Lcom/baidu/pass/main/facesdk/FaceLive;");
        }
    }

    public FaceLive() {
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

    public FaceLive(BDFaceInstance bDFaceInstance) {
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

    private native float nativeSilentLive(long j, int i, BDFaceImageInstance bDFaceImageInstance, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeSilentLiveModelInit(long j, byte[] bArr, int i);

    private native int nativeUninitModel(long j);

    public void initModel(Context context, String str, String str2, String str3, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, str, str2, str3, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, context, callback, str, str2, str3) { // from class: com.baidu.pass.main.facesdk.FaceLive.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceLive this$0;
                public final /* synthetic */ Callback val$callback;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$depthModel;
                public final /* synthetic */ String val$nirModel;
                public final /* synthetic */ String val$visModel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, callback, str, str2, str3};
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
                    this.val$visModel = str;
                    this.val$nirModel = str2;
                    this.val$depthModel = str3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    int i2;
                    Callback callback2;
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int i3 = 1;
                        if (this.val$context == null) {
                            this.val$callback.onResponse(1, "没有初始化上下文");
                            return;
                        }
                        long index = this.this$0.bdFaceInstance.getIndex();
                        if (index == 0) {
                            return;
                        }
                        byte[] modelContent = FileUitls.getModelContent(this.val$context, this.val$visModel);
                        int i4 = -1;
                        if (modelContent.length != 0) {
                            i = this.this$0.nativeSilentLiveModelInit(index, modelContent, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_RGB.ordinal());
                            if (i != 0) {
                                this.val$callback.onResponse(i, "Vis 活体模型加载失败");
                                return;
                            }
                        } else {
                            i = -1;
                        }
                        byte[] modelContent2 = FileUitls.getModelContent(this.val$context, this.val$nirModel);
                        if (modelContent2.length != 0) {
                            i2 = this.this$0.nativeSilentLiveModelInit(index, modelContent2, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_NIR.ordinal());
                            if (i2 != 0) {
                                this.val$callback.onResponse(i2, "Nir 活体模型加载失败");
                                return;
                            }
                        } else {
                            i2 = -1;
                        }
                        byte[] modelContent3 = FileUitls.getModelContent(this.val$context, this.val$depthModel);
                        if (modelContent3.length != 0 && (i4 = this.this$0.nativeSilentLiveModelInit(index, modelContent3, BDFaceSDKCommon.LiveType.BDFACE_SILENT_LIVE_TYPE_DEPTH.ordinal())) != 0) {
                            this.val$callback.onResponse(i4, "Deep 活体模型加载失败");
                            return;
                        }
                        if (i == 0 || i2 == 0 || i4 == 0) {
                            callback2 = this.val$callback;
                            i3 = 0;
                            str4 = "活体模型加载成功";
                        } else {
                            callback2 = this.val$callback;
                            str4 = "活体模型加载失败";
                        }
                        callback2.onResponse(i3, str4);
                        Log.e("bdface", "FaceLive initModel");
                    }
                }
            });
        }
    }

    public float silentLive(BDFaceSDKCommon.LiveType liveType, BDFaceImageInstance bDFaceImageInstance, float[] fArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveType, bDFaceImageInstance, fArr)) == null) {
            if (liveType == null || bDFaceImageInstance == null || fArr == null) {
                Log.v(TAG, "Parameter is null");
                return -1.0f;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1.0f;
            }
            return nativeSilentLive(index, liveType.ordinal(), bDFaceImageInstance, fArr);
        }
        return invokeLLL.floatValue;
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
}
