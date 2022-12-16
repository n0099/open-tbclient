package com.baidu.searchbox.dns;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.policy.LocalDnsPolicy;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
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
/* loaded from: classes2.dex */
public class DnsHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsEnable;

    /* loaded from: classes2.dex */
    public static class DnsConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean backUpIPEnable;
        public boolean idcEnable;
        public HttpDNSStat stat;
        public boolean useExpire;

        public DnsConfig(boolean z, boolean z2, boolean z3, HttpDNSStat httpDNSStat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), httpDNSStat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.idcEnable = false;
            this.backUpIPEnable = false;
            this.useExpire = false;
            this.idcEnable = z;
            this.backUpIPEnable = z2;
            this.useExpire = z3;
            this.stat = httpDNSStat;
        }
    }

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

    public DnsParseResult getParseResult(String str) throws UnknownHostException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.mIsEnable) {
                return DnsEngine.getParseResult(str);
            }
            Map<String, List<String>> ipListByHost = LocalDnsPolicy.getIpListByHost(str);
            List<String> ipListFromMapResult = LocalDnsPolicy.getIpListFromMapResult(ipListByHost);
            if (LocalDnsPolicy.isBackUpIpFromMapResult(ipListByHost)) {
                i = 5;
            } else {
                i = 1;
            }
            return new DnsParseResult(ipListFromMapResult, 0, i, DnsUtil.stackType);
        }
        return (DnsParseResult) invokeL.objValue;
    }

    public DnsParseResult getParseResultForceHttp(String str) throws UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            int i = 1;
            if (this.mIsEnable) {
                return DnsEngine.getParseResult(str, true);
            }
            Map<String, List<String>> ipListByHost = LocalDnsPolicy.getIpListByHost(str);
            List<String> ipListFromMapResult = LocalDnsPolicy.getIpListFromMapResult(ipListByHost);
            if (LocalDnsPolicy.isBackUpIpFromMapResult(ipListByHost)) {
                i = 5;
            }
            return new DnsParseResult(ipListFromMapResult, 0, i, DnsUtil.stackType);
        }
        return (DnsParseResult) invokeL.objValue;
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
        this.mIsEnable = true;
        DnsCacheHelper.initCacheHelper(context);
        ConnectManager.initInstance(context);
        this.mIsEnable = z;
        if (z) {
            ConnectManager.getInstance().init();
        }
    }

    public static String getAreaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            DnsCacheHelper cacheHelper = DnsCacheHelper.getCacheHelper();
            if (cacheHelper != null) {
                return cacheHelper.getAreaInfo();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getClientIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            DnsCacheHelper cacheHelper = DnsCacheHelper.getCacheHelper();
            if (cacheHelper != null) {
                return cacheHelper.getClientIp();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static long getLastAreaUpdateTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (DnsCacheHelper.getCacheHelper() != null) {
                return DnsCacheHelper.getCacheHelper().getLastAreaInfoUpdateTime();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean isHttpDnsEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mIsEnable;
        }
        return invokeV.booleanValue;
    }

    public void forceUpdateDomain(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.mIsEnable) {
            DnsEngine.forceUpdateDomain(str);
        }
    }

    public List<String> getIpList(String str) throws UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.mIsEnable) {
                DnsParseResult parseResult = DnsEngine.getParseResult(str);
                if (parseResult != null) {
                    return parseResult.getIpList();
                }
                throw new UnknownHostException(str);
            }
            return LocalDnsPolicy.getIpListFromMapResult(LocalDnsPolicy.getIpListByHost(str));
        }
        return (List) invokeL.objValue;
    }

    public List<String> getIpListForceHttp(String str) throws UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.mIsEnable) {
                DnsParseResult parseResult = DnsEngine.getParseResult(str, true);
                if (parseResult != null) {
                    return parseResult.getIpList();
                }
                throw new UnknownHostException(str);
            }
            return LocalDnsPolicy.getIpListFromMapResult(LocalDnsPolicy.getIpListByHost(str));
        }
        return (List) invokeL.objValue;
    }

    public List<String> getIpListOnlyCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.mIsEnable) {
                DnsParseResult cacheResult = DnsEngine.getCacheResult(str, true);
                if (cacheResult != null) {
                    return cacheResult.getIpList();
                }
                return new ArrayList();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public List<String> getIpListOnlyForceHttp(String str) throws UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (this.mIsEnable) {
                DnsParseResult onlyForceHttpResult = DnsEngine.getOnlyForceHttpResult(str);
                if (onlyForceHttpResult != null) {
                    return onlyForceHttpResult.getIpList();
                }
                throw new UnknownHostException(str);
            }
            return LocalDnsPolicy.getIpListFromMapResult(LocalDnsPolicy.getIpListByHost(str));
        }
        return (List) invokeL.objValue;
    }

    public DnsParseResult getParseResultOnlyCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.mIsEnable) {
                return DnsEngine.getCacheResult(str, true);
            }
            return new DnsParseResult(new ArrayList(), 0, 1, DnsUtil.stackType);
        }
        return (DnsParseResult) invokeL.objValue;
    }

    public void setHttpDnsConfig(DnsConfig dnsConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dnsConfig) == null) {
            DnsTransmitter.setIDCEable(dnsConfig.idcEnable);
            DnsTransmitter.setDnsStat(dnsConfig.stat);
            LocalDnsPolicy.backUpIPEnable = dnsConfig.backUpIPEnable;
            DnsUtil.useExpire = dnsConfig.useExpire;
        }
    }

    public void setHttpDnsEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mIsEnable = z;
            if (z) {
                ConnectManager.getInstance().init();
            } else {
                ConnectManager.getInstance().exit();
            }
        }
    }

    public List<String> getIpListOnlyCache(String str, boolean z) {
        InterceptResult invokeLZ;
        DnsParseResult cacheResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            if (this.mIsEnable && (cacheResult = DnsEngine.getCacheResult(str, true, z)) != null) {
                return cacheResult.getIpList();
            }
            return null;
        }
        return (List) invokeLZ.objValue;
    }

    @Deprecated
    public void setHttpDnsState(boolean z, HttpDNSStat httpDNSStat, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), httpDNSStat, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            DnsTransmitter.setIDCEable(z);
            DnsTransmitter.setDnsStat(httpDNSStat);
            LocalDnsPolicy.backUpIPEnable = z2;
        }
    }
}
