package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.HttpDnsClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.so;
import com.repackage.to;
import com.repackage.uo;
import com.repackage.vo;
import com.repackage.wo;
import com.repackage.xo;
import com.repackage.yo;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BDHttpDns {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BDHttpDns k;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpDnsClient a;
    public final to b;
    public final vo c;
    public final vo d;
    public BDNetworkStateChangeReceiver e;
    public final Context f;
    public CachePolicy g;
    public long h;
    public long i;
    public int j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CachePolicy) Enum.valueOf(CachePolicy.class, str) : (CachePolicy) invokeL.objValue;
        }

        public static CachePolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CachePolicy[]) $VALUES.clone() : (CachePolicy[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ BDHttpDnsResult.ResolveType b;
        public final /* synthetic */ vo.a c;

        public c(BDHttpDns bDHttpDns, e eVar, BDHttpDnsResult.ResolveType resolveType, vo.a aVar) {
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

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ BDHttpDnsResult.ResolveType b;
        public final /* synthetic */ vo.a c;

        public d(BDHttpDns bDHttpDns, e eVar, BDHttpDnsResult.ResolveType resolveType, vo.a aVar) {
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

    /* loaded from: classes.dex */
    public interface e {
        void a(BDHttpDnsResult bDHttpDnsResult);
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
        this.a = HttpDnsClient.z();
        this.b = to.c();
        this.c = new vo("DNS", true);
        this.d = new vo("HTTPDNS", false);
        this.g = CachePolicy.POLICY_TOLERANT;
        this.f = context;
        i();
        this.e.refreshIpReachable();
        this.i = System.currentTimeMillis();
    }

    public static BDHttpDns h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (k == null) {
                synchronized (BDHttpDns.class) {
                    if (k == null) {
                        k = new BDHttpDns(context);
                    }
                }
            }
            return k;
        }
        return (BDHttpDns) invokeL.objValue;
    }

    public final boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.a.C() || j - this.h > 1000 : invokeJ.booleanValue;
    }

    public void b(String str, e eVar) {
        BDHttpDnsResult.ResolveType resolveType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, eVar) == null) {
            if (so.l(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                yo.b().a().execute(new a(this, eVar, arrayList));
            } else if (so.m(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str.replaceAll("[\\[\\]]", ""));
                yo.b().a().execute(new b(this, eVar, arrayList2));
            } else {
                vo.a c2 = this.d.c(str);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (a(currentTimeMillis)) {
                    if (c2 == null) {
                        arrayList3.add(str);
                    } else if (c2.e()) {
                        this.a.t(str);
                    }
                    if (q(currentTimeMillis)) {
                        arrayList3.addAll(this.a.y());
                    }
                    this.a.O(arrayList3, new wo(this.f));
                } else {
                    xo.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
                }
                if (c2 != null) {
                    if (c2.e()) {
                        resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE;
                    } else {
                        resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                    }
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = c2.a() != null ? c2.a().toString() : null;
                    objArr[2] = c2.b() != null ? c2.b().toString() : null;
                    objArr[3] = resolveType.toString();
                    xo.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    yo.b().a().execute(new c(this, eVar, resolveType, c2));
                    return;
                }
                vo.a c3 = this.c.c(str);
                if (c3 != null) {
                    BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = c3.a() != null ? c3.a().toString() : null;
                    objArr2[2] = c3.b() != null ? c3.b().toString() : null;
                    objArr2[3] = resolveType2.toString();
                    xo.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr2);
                    yo.b().a().execute(new d(this, eVar, resolveType2, c3));
                    return;
                }
                this.b.b(str, new uo(this.f, eVar));
            }
        }
    }

    public CachePolicy c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (CachePolicy) invokeV.objValue;
    }

    public vo d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (vo) invokeV.objValue;
    }

    public vo e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (vo) invokeV.objValue;
    }

    public HttpDnsClient f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (HttpDnsClient) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e = new BDNetworkStateChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f.registerReceiver(this.e, intentFilter);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (str.length() <= 64) {
                this.a.K(str);
                xo.a("Set account id to %s", str);
                return;
            }
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
    }

    public void k(CachePolicy cachePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cachePolicy) == null) {
            this.g = cachePolicy;
            if (cachePolicy == CachePolicy.POLICY_STRICT) {
                this.d.f(true);
            } else {
                this.d.f(false);
            }
            xo.a("Set cache policy to %s", cachePolicy.name());
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a.L(z);
            xo.a("Set https enabled to %b", Boolean.valueOf(z));
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            xo.b(z);
            xo.a("Set debug log enabled to %b", Boolean.valueOf(z));
        }
    }

    public void n(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.e.setClearCache(z);
            this.e.setHttpDnsPrefetch(z2);
            xo.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (str != null && !str.isEmpty()) {
                int i = this.j + 1;
                this.j = i;
                if (i > 1) {
                    xo.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
                }
                xo.a(" Set preResolve tag : %s", str.toString());
                wo woVar = new wo(this.f);
                this.h = System.currentTimeMillis();
                this.a.u(str, HttpDnsClient.RequestParamType.TAG_OF_HOSTS, woVar);
                return;
            }
            xo.a("Set pre resolve hosts error, get empty tag", new Object[0]);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            int length = str.length();
            if (length <= 64 && length >= 8) {
                this.a.N(str);
                String substring = str.substring(0, 3);
                for (int i = 0; i < length - 6; i++) {
                    substring = substring + String.valueOf('*');
                }
                xo.a("Set secret to %s", substring + str.substring(length - 3));
                return;
            }
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
    }

    public final boolean q(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
            if (j - this.i > 60000) {
                this.i = j;
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public BDHttpDnsResult r(String str, boolean z) {
        InterceptResult invokeLZ;
        BDHttpDnsResult.ResolveType resolveType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            if (so.l(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, null);
            } else if (so.m(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str.replaceAll("[\\[\\]]", ""));
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, arrayList2);
            } else {
                BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_NONE;
                vo.a c2 = this.d.c(str);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (a(currentTimeMillis)) {
                    if (c2 == null) {
                        arrayList3.add(str);
                    } else if (c2.e()) {
                        this.a.t(str);
                    }
                    if (q(currentTimeMillis)) {
                        arrayList3.addAll(this.a.y());
                    }
                    this.a.O(arrayList3, new wo(this.f));
                } else {
                    xo.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
                }
                if (c2 != null) {
                    if (c2.e()) {
                        resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE;
                    } else {
                        resolveType = BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                    }
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = c2.a() != null ? c2.a().toString() : null;
                    objArr[2] = c2.b() != null ? c2.b().toString() : null;
                    objArr[3] = resolveType.toString();
                    xo.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, c2.a(), c2.b());
                } else if (c2 == null && z) {
                    xo.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                    return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
                } else {
                    vo.a c3 = this.c.c(str);
                    if (c3 != null) {
                        BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = str;
                        objArr2[1] = c3.a() != null ? c3.a().toString() : null;
                        objArr2[2] = c3.b() != null ? c3.b().toString() : null;
                        objArr2[3] = resolveType3.toString();
                        xo.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr2);
                        return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, c3.a(), c3.b());
                    }
                    BDHttpDnsResult e2 = this.b.e(str);
                    if (e2.c() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                        vo.a aVar = new vo.a();
                        aVar.i(60L);
                        aVar.h(System.currentTimeMillis() / 1000);
                        aVar.f(e2.a());
                        aVar.g(e2.b());
                        this.c.e(str, aVar);
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = str;
                        objArr3[1] = aVar.a() != null ? aVar.a().toString() : null;
                        objArr3[2] = aVar.b() != null ? aVar.b().toString() : null;
                        objArr3[3] = e2.d().toString();
                        xo.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr3);
                    } else {
                        xo.a("Sync resolve failed, host(%s), dns resolve failed", str);
                    }
                    return e2;
                }
            }
        }
        return (BDHttpDnsResult) invokeLZ.objValue;
    }
}
