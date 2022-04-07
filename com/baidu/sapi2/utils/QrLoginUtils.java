package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes2.dex */
public class QrLoginUtils implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public QrLoginUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getJoinQrLoginPromptInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return SapiContext.getInstance().getCurrentAccount() == null ? "-1" : String.format(SapiContext.getInstance().getJoinQrLoginPrompt(), URLDecoder.decode(SapiUtils.urlParamsToMap(str).get("appName")));
        }
        return (String) invokeL.objValue;
    }

    public static boolean isJoinQrLoginSchema(String str) {
        InterceptResult invokeL;
        String url;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                URL url2 = new URL(str);
                url = ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment().getURL(true);
                sb = new StringBuilder();
                sb.append(url2.getProtocol());
                sb.append("://");
                sb.append(url2.getHost());
            } catch (MalformedURLException unused) {
            }
            return url.equals(sb.toString()) && !TextUtils.isEmpty(str) && str.contains("sign") && str.contains("/v2/api/qrcode") && str.contains("appName");
        }
        return invokeL.booleanValue;
    }
}
