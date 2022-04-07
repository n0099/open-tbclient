package com.baidu.pass.main.facesdk;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FaceAuth {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceSDK";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isLoadSucess;

    public FaceAuth() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isLoadSucess = false;
        try {
            System.loadLibrary("bd_pass_face_sdk");
            this.isLoadSucess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCreatInstance();

    private native void nativeSetActiveLog(int i, int i2);

    private native void nativeSetCoreConfigure(int i, int i2);

    public void initLicense(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, callback) { // from class: com.baidu.pass.main.facesdk.FaceAuth.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceAuth this$0;
                public final /* synthetic */ Callback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callback};
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
                    this.val$callback = callback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int i = -1;
                        try {
                            i = this.this$0.nativeCreatInstance();
                        } catch (Throwable th) {
                            th.printStackTrace();
                            Log.e(FaceAuth.TAG, "bdface_create_instance status -1");
                        }
                        this.val$callback.onResponse(i, "OK");
                    }
                }
            });
        }
    }

    public boolean isLoadSucess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isLoadSucess : invokeV.booleanValue;
    }

    public void setActiveLog(BDFaceSDKCommon.BDFaceLogInfo bDFaceLogInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bDFaceLogInfo, i) == null) {
            try {
                nativeSetActiveLog(bDFaceLogInfo.ordinal(), i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode bDFaceCoreRunMode, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, bDFaceCoreRunMode, i) == null) {
            try {
                nativeSetCoreConfigure(bDFaceCoreRunMode.ordinal(), i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
