package com.baidu.searchbox.logsystem.basic.upload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.LokiIdentityManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public abstract class BaseContentUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_TYPE = "Content-type";
    public static final String CONTENT_TYPE_VALUE = "application/octet-stream";
    public static final String DEBUG_PARA = "debug";
    public static final String NB = "nb";
    public static final String NB_VALUE = "1";
    public static final String OFFLINE_UPLOAD_URL_PATH = "/ztbox?action=crash";
    public static final String OFFLINE_URL = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080";
    public static final String ONLINE_UPLOAD_URL_PATH = "/ztbox?action=crash";
    public static final String ONLINE_URL = "https://tcbox.baidu.com";
    public static final String TAG_ERRNO = "error";
    public static final int TAG_ERRNO_INVALID = -1;
    public static final int TAG_ERRNO_NO_ERROR = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseContentUploader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String getUploadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String processUrl = LokiIdentityManager.getInstance().processUrl(AppConfig.isDebug() ? "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=crash" : "https://tcbox.baidu.com/ztbox?action=crash");
            return (!AppConfig.isDebug() || TextUtils.isEmpty(processUrl)) ? processUrl : UrlUtil.addParam(processUrl, "debug", "1");
        }
        return (String) invokeV.objValue;
    }

    public abstract ResponseEntity uploadDataRequestSync(@NonNull String str, @NonNull File file, @Nullable Map<String, String> map);

    public ResponseEntity uploadSync(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            String uploadUrl = getUploadUrl();
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put("Content-type", "application/octet-stream");
            linkedHashMap.put(NB, "1");
            return uploadDataRequestSync(uploadUrl, file, linkedHashMap);
        }
        return (ResponseEntity) invokeL.objValue;
    }
}
