package com.baidu.searchbox.dns.policy;

import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.dns.transmit.model.DnsResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class HttpDnsPolicy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpDnsPolicy() {
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

    public static DnsModel getIpListByHost(String str) {
        InterceptResult invokeL;
        Map<String, DnsModel> dnsMap;
        DnsModel dnsModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            DnsResponse sendRequest = new DnsTransmitter(false, str, 2).sendRequest();
            if (sendRequest != null && sendRequest.getDnsMap() != null && (dnsMap = sendRequest.getDnsMap()) != null && !dnsMap.isEmpty() && (dnsModel = dnsMap.get(str)) != null) {
                DnsCacheHelper.getCacheHelper().put(str, dnsModel);
                return dnsModel;
            }
            return null;
        }
        return (DnsModel) invokeL.objValue;
    }
}
