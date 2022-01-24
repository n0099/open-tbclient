package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes11.dex */
public class ContentUploader extends BaseContentUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "FetchContentUploader";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1260100695, "Lcom/baidu/searchbox/retrieve/upload/ContentUploader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1260100695, "Lcom/baidu/searchbox/retrieve/upload/ContentUploader;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public ContentUploader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.retrieve.upload.BaseContentUploader
    public void uploadDataRequestASync(String str, String str2, Map<String, String> map, ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, map, responseCallback) == null) {
            PostFormRequest.PostFormRequestBuilder postFormRequest = HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest();
            postFormRequest.url(getUploadUrl(str));
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    postFormRequest.addHeader(entry.getKey(), entry.getValue());
                }
            }
            postFormRequest.addParam("req", str2);
            postFormRequest.cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, true));
            postFormRequest.build().executeAsync(responseCallback);
        }
    }
}
