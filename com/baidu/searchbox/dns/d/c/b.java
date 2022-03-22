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
/* loaded from: classes4.dex */
public abstract class b<T> extends a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
    public void b(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) {
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String q = q();
            Map<String, Object> parameters = getParameters();
            sb.append(q.contains("?") ? "&" : "?");
            String c2 = c(parameters);
            if (!TextUtils.isEmpty(c2)) {
                sb.append(c2);
            }
            String str = q + sb.toString();
            if (!DnsUtil.DEBUG || TextUtils.isEmpty(DnsUtil.httpDnsDebugExtraQueryParams)) {
                return str;
            }
            return str + "&" + DnsUtil.httpDnsDebugExtraQueryParams;
        }
        return (String) invokeV.objValue;
    }

    public abstract String q();
}
