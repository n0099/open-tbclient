package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CloudControlUrlConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_RUN_TYPE = "runtype";
    public static final String KEY_TYPE_ID = "type_id";
    public static final String OEM_NAME_SPACE = "OEMConfig";
    public static final String OEM_TYPE_ID = "OEM_TYPE_ID";
    public static String mDebugHost = "";
    public static String mOEMTypeId = "0";
    public static final String mUrl = "%s/ccs/v1/start/confsync";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(67088637, "Lcom/baidu/searchbox/cloudcontrol/utils/CloudControlUrlConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(67088637, "Lcom/baidu/searchbox/cloudcontrol/utils/CloudControlUrlConfig;");
        }
    }

    public CloudControlUrlConfig() {
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

    public static String getCloudControlUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String searchboxHostForHttps = HostConfig.getSearchboxHostForHttps();
            if (AppConfig.isDebug() && !TextUtils.isEmpty(mDebugHost)) {
                searchboxHostForHttps = mDebugHost;
            }
            String processUrl = CommonUrlParamManager.getInstance().processUrl(String.format(mUrl, searchboxHostForHttps));
            if (!TextUtils.isEmpty(str)) {
                processUrl = UrlUtil.addParam(processUrl, KEY_RUN_TYPE, str);
            }
            String valueOf = String.valueOf(mOEMTypeId);
            return !TextUtils.isEmpty(valueOf) ? UrlUtil.addParam(processUrl, KEY_TYPE_ID, valueOf) : processUrl;
        }
        return (String) invokeL.objValue;
    }

    public static void setDebugHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            mDebugHost = str;
        }
    }

    public static void setOemTypeId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            mOEMTypeId = str;
        }
    }
}
