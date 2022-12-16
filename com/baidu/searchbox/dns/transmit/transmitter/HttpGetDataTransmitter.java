package com.baidu.searchbox.dns.transmit.transmitter;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.transmitter.exception.RetryException;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class HttpGetDataTransmitter<T> extends HttpDataTransmitter<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpGetDataTransmitter";
    public transient /* synthetic */ FieldHolder $fh;

    public abstract String getHttpUrl();

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void postHandleConnection(HttpURLConnection httpURLConnection) throws RetryException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection) == null) {
        }
    }

    public HttpGetDataTransmitter() {
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

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String httpUrl = getHttpUrl();
            Map<String, Object> parameters = getParameters();
            String str = "?";
            if (httpUrl.contains("?")) {
                str = "&";
            }
            sb.append(str);
            String buildParametersString = buildParametersString(parameters);
            if (!TextUtils.isEmpty(buildParametersString)) {
                sb.append(buildParametersString);
            }
            String str2 = httpUrl + sb.toString();
            if (DnsUtil.DEBUG && !TextUtils.isEmpty(DnsUtil.httpDnsDebugExtraQueryParams)) {
                return str2 + "&" + DnsUtil.httpDnsDebugExtraQueryParams;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }
}
