package com.baidu.searchbox.dns.d.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.dns.d.c.a
    public void b(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) {
        }
    }

    public abstract String q();

    public b() {
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

    @Override // com.baidu.searchbox.dns.d.c.a
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String q = q();
            Map parameters = getParameters();
            String str = "?";
            if (q.contains("?")) {
                str = "&";
            }
            sb.append(str);
            String c = c(parameters);
            if (!TextUtils.isEmpty(c)) {
                sb.append(c);
            }
            String str2 = q + sb.toString();
            if (DnsUtil.DEBUG && !TextUtils.isEmpty(DnsUtil.httpDnsDebugExtraQueryParams)) {
                return str2 + "&" + DnsUtil.httpDnsDebugExtraQueryParams;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }
}
