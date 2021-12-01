package com.baidu.sapi2.httpwrap;

import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
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

    public static Map<String, String> buildCommonParams() {
        InterceptResult invokeV;
        SapiConfiguration confignation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("client", "android");
            ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
            if (isAccountManager != null && (confignation = isAccountManager.getConfignation()) != null) {
                String clientId = SapiUtils.getClientId(confignation.context);
                hashMap.put("cuid", clientId);
                hashMap.put("clientid", clientId);
                hashMap.put("zid", isAccountManager.getCurrentZid(confignation.context));
                hashMap.put("clientip", confignation.clientIp);
                hashMap.put("appid", confignation.appId);
                hashMap.put("tpl", confignation.tpl);
                hashMap.put("app_version", SapiUtils.getVersionName(confignation.context));
                hashMap.put("sdk_version", isAccountManager.getVersionName());
                hashMap.put("sdkversion", isAccountManager.getVersionName());
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
