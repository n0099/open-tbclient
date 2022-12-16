package com.baidu.searchbox.dns.policy;

import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class CacheDnsPolicy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CacheDnsPolicy() {
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

    public static List<String> getIpListByHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            DnsModel dnsModel = DnsCacheHelper.getCacheHelper().get(str);
            if (dnsModel != null) {
                return dnsModel.getIpList();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
