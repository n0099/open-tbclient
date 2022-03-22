package com.baidu.searchbox.dns;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.d.c;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class DnsHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DnsHelper(Context context) {
        this(context, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void enableIPv6Test(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            DnsUtil.iPv6TestEnable = true;
            DnsUtil.iPv6Perfer = z;
        }
    }

    public void forceUpdateDomain(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.j) {
            b.forceUpdateDomain(str);
        }
    }

    public List<String> getIpList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.j) {
                DnsParseResult parseResult = b.getParseResult(str);
                if (parseResult != null) {
                    return parseResult.getIpList();
                }
                throw new UnknownHostException(str);
            }
            return com.baidu.searchbox.dns.b.b.a(com.baidu.searchbox.dns.b.b.h(str));
        }
        return (List) invokeL.objValue;
    }

    public List<String> getIpListForceHttp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.j) {
                DnsParseResult b2 = b.b(str, true);
                if (b2 != null) {
                    return b2.getIpList();
                }
                throw new UnknownHostException(str);
            }
            return com.baidu.searchbox.dns.b.b.a(com.baidu.searchbox.dns.b.b.h(str));
        }
        return (List) invokeL.objValue;
    }

    public List<String> getIpListOnlyCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.j) {
                DnsParseResult a = b.a(str, true);
                if (a != null) {
                    return a.getIpList();
                }
                return new ArrayList();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public DnsParseResult getParseResult(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (this.j) {
                return b.getParseResult(str);
            }
            Map<String, List<String>> h2 = com.baidu.searchbox.dns.b.b.h(str);
            return new DnsParseResult(com.baidu.searchbox.dns.b.b.a(h2), 0, com.baidu.searchbox.dns.b.b.b(h2) ? 5 : 1, DnsUtil.stackType);
        }
        return (DnsParseResult) invokeL.objValue;
    }

    public DnsParseResult getParseResultForceHttp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.j) {
                return b.b(str, true);
            }
            Map<String, List<String>> h2 = com.baidu.searchbox.dns.b.b.h(str);
            return new DnsParseResult(com.baidu.searchbox.dns.b.b.a(h2), 0, com.baidu.searchbox.dns.b.b.b(h2) ? 5 : 1, DnsUtil.stackType);
        }
        return (DnsParseResult) invokeL.objValue;
    }

    public DnsParseResult getParseResultOnlyCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.j) {
                return b.a(str, true);
            }
            return new DnsParseResult(new ArrayList(), 0, 1, DnsUtil.stackType);
        }
        return (DnsParseResult) invokeL.objValue;
    }

    public boolean isHttpDnsEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void setHttpDnsEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.j = z;
            if (z) {
                a.b().a();
            } else {
                a.b().exit();
            }
        }
    }

    public void setHttpDnsState(boolean z, HttpDNSStat httpDNSStat, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), httpDNSStat, Boolean.valueOf(z2)}) == null) {
            c.b(z);
            c.a(httpDNSStat);
            com.baidu.searchbox.dns.b.b.v = z2;
        }
    }

    public DnsHelper(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = true;
        com.baidu.searchbox.dns.a.a.b(context);
        a.a(context);
        this.j = z;
    }
}
