package com.baidu.searchbox.retrieve.upload;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class BaseContentUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVE_UPLOAD_URL_PATH = "/fetchlog/activeupload";
    public static final boolean DEBUG;
    public static final String DEBUG_PARA = "debug";
    public static final String ONLINE_URL = "https://mbd.baidu.com";
    public static final String TEST_URL = "http://10.26.139.34:8092";
    public static final String UPLOAD_URL_PATH = "/fetchlog/appupstream";
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void uploadDataRequestASync(String str, String str2, Map<String, String> map, ResponseCallback<JSONObject> responseCallback);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(96770586, "Lcom/baidu/searchbox/retrieve/upload/BaseContentUploader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(96770586, "Lcom/baidu/searchbox/retrieve/upload/BaseContentUploader;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public BaseContentUploader() {
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

    public String getUploadUrl(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.equals(str, "1")) {
                str2 = ACTIVE_UPLOAD_URL_PATH;
            } else {
                str2 = UPLOAD_URL_PATH;
            }
            boolean isDebug = FetchTaskManager.getInstance().isDebug();
            if (DEBUG && isDebug) {
                str3 = TEST_URL + str2;
            } else {
                str3 = "https://mbd.baidu.com" + str2;
            }
            String processUrl = CommonUrlParamManager.getInstance().processUrl(str3);
            if (DEBUG && !TextUtils.isEmpty(processUrl)) {
                return UrlUtil.addParam(processUrl, "debug", "1");
            }
            return processUrl;
        }
        return (String) invokeL.objValue;
    }
}
