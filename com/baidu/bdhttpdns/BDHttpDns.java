package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aq;
import com.repackage.bq;
import com.repackage.cq;
import com.repackage.dq;
import com.repackage.fq;
import com.repackage.gq;
import com.repackage.hq;
import com.repackage.wp;
import com.repackage.xp;
import com.repackage.yp;
import com.repackage.zp;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BDHttpDns {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BDHttpDns k;
    public transient /* synthetic */ FieldHolder $fh;
    public final i a;
    public final bq b;
    public final dq c;
    public final dq d;
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
    public interface a {
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
        this.a = i.b();
        this.b = bq.b();
        this.c = new dq("DNS", true);
        this.d = new dq("HTTPDNS", false);
        this.g = CachePolicy.POLICY_TOLERANT;
        this.f = context;
        i();
        this.e.refreshIpReachable();
        this.i = System.currentTimeMillis();
    }

    public static BDHttpDns j(Context context) {
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

    public dq a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (dq) invokeV.objValue;
    }

    public final boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.a.C() || (j - this.h > 1000 && !this.e.isIPv6Only()) : invokeJ.booleanValue;
    }

    public void c(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            if (aq.e(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                hq.a().b().execute(new wp(this, aVar, arrayList));
            } else if (aq.g(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str.replaceAll("[\\[\\]]", ""));
                hq.a().b().execute(new xp(this, aVar, arrayList2));
            } else {
                dq.a a2 = this.d.a(str);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (b(currentTimeMillis)) {
                    if (a2 == null) {
                        arrayList3.add(str);
                    } else if (a2.c()) {
                        this.a.m(str);
                    }
                    if (e(currentTimeMillis)) {
                        arrayList3.addAll(this.a.v());
                    }
                    this.a.o(arrayList3, new fq(this.f));
                } else {
                    gq.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
                }
                if (a2 != null) {
                    BDHttpDnsResult.ResolveType resolveType = a2.c() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                    gq.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, a2.d().toString(), resolveType.toString());
                    hq.a().b().execute(new yp(this, aVar, resolveType, a2));
                    return;
                }
                dq.a a3 = this.c.a(str);
                if (a3 == null) {
                    this.b.d(str, new cq(this.f, aVar));
                    return;
                }
                BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = a3.d() != null ? a3.d().toString() : null;
                objArr[2] = a3.g() != null ? a3.g().toString() : null;
                objArr[3] = resolveType2.toString();
                gq.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                hq.a().b().execute(new zp(this, aVar, resolveType2, a3));
            }
        }
    }

    public dq d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (dq) invokeV.objValue;
    }

    public final boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            if (j - this.i > 60000) {
                this.i = j;
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public CachePolicy f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g : (CachePolicy) invokeV.objValue;
    }

    public i g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (i) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e = new BDNetworkStateChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f.registerReceiver(this.e, intentFilter);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (str.length() <= 64) {
                this.a.w(str);
                gq.a("Set account id to %s", str);
                return;
            }
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
    }

    public void l(CachePolicy cachePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cachePolicy) == null) {
            this.g = cachePolicy;
            if (cachePolicy == CachePolicy.POLICY_STRICT) {
                this.d.d(true);
            } else {
                this.d.d(false);
            }
            gq.a("Set cache policy to %s", cachePolicy.name());
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.a.p(z);
            gq.a("Set https enabled to %b", Boolean.valueOf(z));
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            gq.b(z);
            gq.a("Set debug log enabled to %b", Boolean.valueOf(z));
        }
    }

    public void o(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.e.a(z);
            this.e.b(z2);
            gq.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (str == null || str.isEmpty()) {
                gq.a("Set pre resolve hosts error, get empty tag", new Object[0]);
                return;
            }
            int i = this.j + 1;
            this.j = i;
            if (i > 1) {
                gq.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
            }
            gq.a(" Set preResolve tag : %s", str.toString());
            fq fqVar = new fq(this.f);
            this.h = System.currentTimeMillis();
            this.a.n(str, i.d.b, fqVar);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            int length = str.length();
            if (length > 64 || length < 8) {
                throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
            }
            this.a.y(str);
            String substring = str.substring(0, 3);
            for (int i = 0; i < length - 6; i++) {
                substring = substring + String.valueOf('*');
            }
            gq.a("Set secret to %s", substring + str.substring(length - 3));
        }
    }

    public BDHttpDnsResult r(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            if (aq.e(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, null);
            } else if (aq.g(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str.replaceAll("[\\[\\]]", ""));
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, arrayList2);
            } else {
                BDHttpDnsResult.ResolveType resolveType = BDHttpDnsResult.ResolveType.RESOLVE_NONE;
                dq.a a2 = this.d.a(str);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (b(currentTimeMillis)) {
                    if (a2 == null) {
                        arrayList3.add(str);
                    } else if (a2.c()) {
                        this.a.m(str);
                    }
                    if (e(currentTimeMillis)) {
                        arrayList3.addAll(this.a.v());
                    }
                    this.a.o(arrayList3, new fq(this.f));
                } else {
                    gq.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
                }
                if (a2 != null) {
                    BDHttpDnsResult.ResolveType resolveType2 = a2.c() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                    gq.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, a2.d().toString(), resolveType2.toString());
                    return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, a2.d(), a2.g());
                } else if (a2 == null && z) {
                    gq.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                    return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
                } else {
                    dq.a a3 = this.c.a(str);
                    if (a3 != null) {
                        BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                        Object[] objArr = new Object[4];
                        objArr[0] = str;
                        objArr[1] = a3.d() != null ? a3.d().toString() : null;
                        objArr[2] = a3.g() != null ? a3.g().toString() : null;
                        objArr[3] = resolveType3.toString();
                        gq.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                        return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, a3.d(), a3.g());
                    }
                    BDHttpDnsResult a4 = this.b.a(str);
                    if (a4.c() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                        dq.a aVar = new dq.a();
                        aVar.a(60L);
                        aVar.e(System.currentTimeMillis() / 1000);
                        aVar.b(a4.a());
                        aVar.f(a4.b());
                        this.c.c(str, aVar);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = str;
                        objArr2[1] = aVar.d() != null ? aVar.d().toString() : null;
                        objArr2[2] = aVar.g() != null ? aVar.g().toString() : null;
                        objArr2[3] = a4.d().toString();
                        gq.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                    } else {
                        gq.a("Sync resolve failed, host(%s), dns resolve failed", str);
                    }
                    return a4;
                }
            }
        }
        return (BDHttpDnsResult) invokeLZ.objValue;
    }
}
