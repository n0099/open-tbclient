package com.baidu.searchbox.retrieve.debug.provider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class DebugActiveUploadResult implements IActiveUploadResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String SOURCE = "test";
    public static final String TAG = "FetchLogDebug";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult
    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SOURCE : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-217195091, "Lcom/baidu/searchbox/retrieve/debug/provider/DebugActiveUploadResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-217195091, "Lcom/baidu/searchbox/retrieve/debug/provider/DebugActiveUploadResult;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public DebugActiveUploadResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult
    public void onFailure(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) && DEBUG) {
            Log.d(TAG, "msg: " + str);
            Log.d(TAG, "extInfo: " + jSONObject.toString());
            new Handler(Looper.getMainLooper()).post(new Runnable(this, str) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugActiveUploadResult this$0;
                public final /* synthetic */ String val$reason;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$reason = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Context appContext = AppRuntime.getAppContext();
                        Toast.makeText(appContext, "主动上传失败 " + this.val$reason, 1).show();
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult
    public void onSuccess(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            if (DEBUG) {
                Log.d(TAG, "msg: " + str);
                Log.d(TAG, "extInfo: " + jSONObject.toString());
            }
            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DebugActiveUploadResult this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Toast.makeText(AppRuntime.getAppContext(), "主动上传成功 ", 1).show();
                    }
                }
            });
        }
    }
}
