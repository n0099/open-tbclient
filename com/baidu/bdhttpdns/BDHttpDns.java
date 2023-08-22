package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.HttpDnsClient;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tieba.ap;
import com.baidu.tieba.bp;
import com.baidu.tieba.cp;
import com.baidu.tieba.dp;
import com.baidu.tieba.ep;
import com.baidu.tieba.yo;
import com.baidu.tieba.zo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes3.dex */
public final class BDHttpDns {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCOUNT_ID_MAX_LEN = 64;
    public static final int SECRET_MAX_LEN = 64;
    public static final int SECRET_MIN_LEN = 8;
    public static volatile BDHttpDns httpDns;
    public transient /* synthetic */ FieldHolder $fh;
    public CachePolicy cachePolicy;
    public final Context context;
    public final bp dnsCache;
    public final zo dnsClient;
    public final bp httpDnsCache;
    public final HttpDnsClient httpDnsClient;
    public long lastReqTimeForExpiredHosts;
    public BDNetworkStateChangeReceiver networkStateChangeReceiver;
    public int preResolveNum;
    public long preResolveStartTime;

    /* loaded from: classes3.dex */
    public interface e {
        void a(BDHttpDnsResult bDHttpDnsResult);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class CachePolicy {
        public static final /* synthetic */ CachePolicy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CachePolicy POLICY_AGGRESSIVE;
        public static final CachePolicy POLICY_STRICT;
        public static final CachePolicy POLICY_TOLERANT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(4686122, "Lcom/baidu/bdhttpdns/BDHttpDns$CachePolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(4686122, "Lcom/baidu/bdhttpdns/BDHttpDns$CachePolicy;");
                    return;
                }
            }
            POLICY_AGGRESSIVE = new CachePolicy("POLICY_AGGRESSIVE", 0);
            POLICY_TOLERANT = new CachePolicy("POLICY_TOLERANT", 1);
            CachePolicy cachePolicy = new CachePolicy("POLICY_STRICT", 2);
            POLICY_STRICT = cachePolicy;
            $VALUES = new CachePolicy[]{POLICY_AGGRESSIVE, POLICY_TOLERANT, cachePolicy};
        }

        public CachePolicy(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CachePolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CachePolicy) Enum.valueOf(CachePolicy.class, str);
            }
            return (CachePolicy) invokeL.objValue;
        }

        public static CachePolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CachePolicy[]) $VALUES.clone();
            }
            return (CachePolicy[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ ArrayList b;

        public a(BDHttpDns bDHttpDns, e eVar, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDHttpDns, eVar, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.b, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ ArrayList b;

        public b(BDHttpDns bDHttpDns, e eVar, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDHttpDns, eVar, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ BDHttpDnsResult.ResolveType b;
        public final /* synthetic */ bp.a c;

        public c(BDHttpDns bDHttpDns, e eVar, BDHttpDnsResult.ResolveType resolveType, bp.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDHttpDns, eVar, resolveType, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = resolveType;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(new BDHttpDnsResult(this.b, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.c.a(), null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ BDHttpDnsResult.ResolveType b;
        public final /* synthetic */ bp.a c;

        public d(BDHttpDns bDHttpDns, e eVar, BDHttpDnsResult.ResolveType resolveType, bp.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDHttpDns, eVar, resolveType, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = resolveType;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(new BDHttpDnsResult(this.b, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.c.a(), this.c.b()));
            }
        }
    }

    public BDHttpDns(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.httpDnsClient = HttpDnsClient.z();
        this.dnsClient = zo.c();
        this.dnsCache = new bp("DNS", true);
        this.httpDnsCache = new bp("HTTPDNS", false);
        this.cachePolicy = CachePolicy.POLICY_TOLERANT;
        this.context = context;
        registerNetworkChangeReceiver();
        this.networkStateChangeReceiver.refreshIpReachable();
        this.lastReqTimeForExpiredHosts = System.currentTimeMillis();
    }

    public void setAccountID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (str.length() <= 64) {
                this.httpDnsClient.L(str);
                dp.a("Set account id to %s", str);
                return;
            }
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
    }

    public void setPreResolveTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (str != null && !str.isEmpty()) {
                int i = this.preResolveNum + 1;
                this.preResolveNum = i;
                if (i > 1) {
                    dp.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
                }
                dp.a(" Set preResolve tag : %s", str.toString());
                cp cpVar = new cp(this.context);
                this.preResolveStartTime = System.currentTimeMillis();
                this.httpDnsClient.u(str, HttpDnsClient.RequestParamType.TAG_OF_HOSTS, cpVar);
                return;
            }
            dp.a("Set pre resolve hosts error, get empty tag", new Object[0]);
        }
    }

    private boolean allowSendRequest(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j)) == null) {
            if (!this.httpDnsClient.D() && j - this.preResolveStartTime <= 1000) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public static BDHttpDns getService(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (httpDns == null) {
                synchronized (BDHttpDns.class) {
                    if (httpDns == null) {
                        httpDns = new BDHttpDns(context);
                    }
                }
            }
            return httpDns;
        }
        return (BDHttpDns) invokeL.objValue;
    }

    private boolean shouldSendExpiredHostsRequest(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j)) == null) {
            if (j - this.lastReqTimeForExpiredHosts > 60000) {
                this.lastReqTimeForExpiredHosts = j;
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public void setCachePolicy(CachePolicy cachePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cachePolicy) == null) {
            this.cachePolicy = cachePolicy;
            if (cachePolicy == CachePolicy.POLICY_STRICT) {
                this.httpDnsCache.f(true);
            } else {
                this.httpDnsCache.f(false);
            }
            dp.a("Set cache policy to %s", cachePolicy.name());
        }
    }

    public void setHttpsRequestEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.httpDnsClient.N(z);
            dp.a("Set https enabled to %b", Boolean.valueOf(z));
        }
    }

    public void setLogEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            dp.b(z);
            dp.a("Set debug log enabled to %b", Boolean.valueOf(z));
        }
    }

    public void setServerIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.httpDnsClient.M(str);
        }
    }

    private void registerNetworkChangeReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.networkStateChangeReceiver = new BDNetworkStateChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            this.context.registerReceiver(this.networkStateChangeReceiver, intentFilter);
        }
    }

    public CachePolicy getCachePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cachePolicy;
        }
        return (CachePolicy) invokeV.objValue;
    }

    public bp getDnsCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.dnsCache;
        }
        return (bp) invokeV.objValue;
    }

    public bp getHttpDnsCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.httpDnsCache;
        }
        return (bp) invokeV.objValue;
    }

    public HttpDnsClient getHttpDnsClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.httpDnsClient;
        }
        return (HttpDnsClient) invokeV.objValue;
    }

    public BDNetworkStateChangeReceiver getNetworkStateChangeReceiver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.networkStateChangeReceiver;
        }
        return (BDNetworkStateChangeReceiver) invokeV.objValue;
    }

    public int getPreResolveNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.preResolveNum;
        }
        return invokeV.intValue;
    }

    public void asyncResolve(String str, e eVar) {
        String str2;
        BDHttpDnsResult.ResolveType resolveType;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, eVar) == null) {
            if (yo.l(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                ep.b().a().execute(new a(this, eVar, arrayList));
            } else if (yo.m(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str.replaceAll("[\\[\\]]", ""));
                ep.b().a().execute(new b(this, eVar, arrayList2));
            } else {
                bp.a c2 = this.httpDnsCache.c(str);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (allowSendRequest(currentTimeMillis)) {
                    if (c2 == null) {
                        arrayList3.add(str);
                    } else if (c2.e()) {
                        this.httpDnsClient.t(str);
                    }
                    if (shouldSendExpiredHostsRequest(currentTimeMillis)) {
                        arrayList3.addAll(this.httpDnsClient.y());
                    }
                    this.httpDnsClient.Q(arrayList3, new cp(this.context));
                } else {
                    dp.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
                }
                String str4 = null;
                if (c2 != null) {
                    if (c2.e()) {
                        resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE;
                    } else {
                        resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                    }
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    if (c2.a() != null) {
                        str3 = c2.a().toString();
                    } else {
                        str3 = null;
                    }
                    objArr[1] = str3;
                    if (c2.b() != null) {
                        str4 = c2.b().toString();
                    }
                    objArr[2] = str4;
                    objArr[3] = resolveType.toString();
                    dp.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    ep.b().a().execute(new c(this, eVar, resolveType, c2));
                    return;
                }
                bp.a c3 = this.dnsCache.c(str);
                if (c3 != null) {
                    BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    if (c3.a() != null) {
                        str2 = c3.a().toString();
                    } else {
                        str2 = null;
                    }
                    objArr2[1] = str2;
                    if (c3.b() != null) {
                        str4 = c3.b().toString();
                    }
                    objArr2[2] = str4;
                    objArr2[3] = resolveType2.toString();
                    dp.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr2);
                    ep.b().a().execute(new d(this, eVar, resolveType2, c3));
                    return;
                }
                this.dnsClient.b(str, new ap(this.context, eVar));
            }
        }
    }

    public void setNetworkSwitchPolicy(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.networkStateChangeReceiver.setClearCache(z);
            this.networkStateChangeReceiver.setHttpDnsPrefetch(z2);
            dp.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void setPreResolveHosts(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            if (arrayList.size() <= 0) {
                dp.a("Set pre resolve hosts error, get empty hosts", new Object[0]);
                return;
            }
            ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
            int B = this.httpDnsClient.B();
            if (arrayList2.size() > B) {
                dp.a("The current number of hosts is %d, and the max supported size is %s.Please reduce it to %s or less.", Integer.valueOf(arrayList2.size()), Integer.valueOf(B), Integer.valueOf(B));
                return;
            }
            int i = this.preResolveNum + 1;
            this.preResolveNum = i;
            if (i > 1) {
                dp.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
            }
            this.preResolveStartTime = System.currentTimeMillis();
            String str = "";
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                str = str + ((String) arrayList2.get(i2)) + ",";
            }
            if (str != null && !str.isEmpty()) {
                String substring = str.substring(0, str.length() - 1);
                dp.a("Set pre resolve hosts: %s", substring);
                this.httpDnsClient.u(substring, HttpDnsClient.RequestParamType.DNLIST_HOSTS, new cp(this.context));
            }
        }
    }

    public void setSecret(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            int length = str.length();
            if (length <= 64 && length >= 8) {
                this.httpDnsClient.P(str);
                String substring = str.substring(0, 3);
                for (int i = 0; i < length - 6; i++) {
                    substring = substring + String.valueOf('*');
                }
                dp.a("Set secret to %s", substring + str.substring(length - 3));
                return;
            }
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
    }

    public BDHttpDnsResult syncResolve(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        String str3;
        BDHttpDnsResult.ResolveType resolveType;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            String str5 = null;
            if (yo.l(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, null);
            } else if (yo.m(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str.replaceAll("[\\[\\]]", ""));
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, arrayList2);
            } else {
                BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_NONE;
                bp.a c2 = this.httpDnsCache.c(str);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (allowSendRequest(currentTimeMillis)) {
                    if (c2 == null) {
                        arrayList3.add(str);
                    } else if (c2.e()) {
                        this.httpDnsClient.t(str);
                    }
                    if (shouldSendExpiredHostsRequest(currentTimeMillis)) {
                        arrayList3.addAll(this.httpDnsClient.y());
                    }
                    this.httpDnsClient.Q(arrayList3, new cp(this.context));
                } else {
                    dp.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
                }
                if (c2 != null) {
                    if (c2.e()) {
                        resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE;
                    } else {
                        resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                    }
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    if (c2.a() != null) {
                        str4 = c2.a().toString();
                    } else {
                        str4 = null;
                    }
                    objArr[1] = str4;
                    if (c2.b() != null) {
                        str5 = c2.b().toString();
                    }
                    objArr[2] = str5;
                    objArr[3] = resolveType.toString();
                    dp.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, c2.a(), c2.b());
                } else if (c2 == null && z) {
                    dp.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                    return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
                } else {
                    bp.a c3 = this.dnsCache.c(str);
                    if (c3 != null) {
                        BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = str;
                        if (c3.a() != null) {
                            str3 = c3.a().toString();
                        } else {
                            str3 = null;
                        }
                        objArr2[1] = str3;
                        if (c3.b() != null) {
                            str5 = c3.b().toString();
                        }
                        objArr2[2] = str5;
                        objArr2[3] = resolveType3.toString();
                        dp.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr2);
                        return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, c3.a(), c3.b());
                    }
                    BDHttpDnsResult e2 = this.dnsClient.e(str);
                    if (e2.getResolveStatus() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                        bp.a aVar = new bp.a();
                        aVar.i(60L);
                        aVar.h(System.currentTimeMillis() / 1000);
                        aVar.f(e2.getIpv4List());
                        aVar.g(e2.getIpv6List());
                        this.dnsCache.e(str, aVar);
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = str;
                        if (aVar.a() != null) {
                            str2 = aVar.a().toString();
                        } else {
                            str2 = null;
                        }
                        objArr3[1] = str2;
                        if (aVar.b() != null) {
                            str5 = aVar.b().toString();
                        }
                        objArr3[2] = str5;
                        objArr3[3] = e2.getResolveType().toString();
                        dp.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr3);
                    } else {
                        dp.a("Sync resolve failed, host(%s), dns resolve failed", str);
                    }
                    return e2;
                }
            }
        }
        return (BDHttpDnsResult) invokeLZ.objValue;
    }
}
