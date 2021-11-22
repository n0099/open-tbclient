package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import androidx.core.view.InputDeviceCompat;
import b.a.j.b;
import b.a.j.c;
import b.a.j.d;
import b.a.j.e;
import b.a.j.f;
import b.a.j.g;
import b.a.j.h;
import b.a.j.j;
import b.a.j.k;
import b.a.j.l;
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
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class BDHttpDns {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BDHttpDns k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final i f37344a;

    /* renamed from: b  reason: collision with root package name */
    public final f f37345b;

    /* renamed from: c  reason: collision with root package name */
    public final h f37346c;

    /* renamed from: d  reason: collision with root package name */
    public final h f37347d;

    /* renamed from: e  reason: collision with root package name */
    public BDNetworkStateChangeReceiver f37348e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f37349f;

    /* renamed from: g  reason: collision with root package name */
    public CachePolicy f37350g;

    /* renamed from: h  reason: collision with root package name */
    public long f37351h;

    /* renamed from: i  reason: collision with root package name */
    public long f37352i;
    public int j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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

        public CachePolicy(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37344a = i.b();
        this.f37345b = f.b();
        this.f37346c = new h("DNS", true);
        this.f37347d = new h("HTTPDNS", false);
        this.f37350g = CachePolicy.POLICY_TOLERANT;
        this.f37349f = context;
        i();
        this.f37348e.refreshIpReachable();
        this.f37352i = System.currentTimeMillis();
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

    public h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37347d : (h) invokeV.objValue;
    }

    public final boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.f37344a.C() || (j - this.f37351h > 1000 && !this.f37348e.isIPv6Only()) : invokeJ.booleanValue;
    }

    public void c(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            if (e.e(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                l.a().b().execute(new b.a.j.a(this, aVar, arrayList));
            } else if (e.g(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str.replaceAll("[\\[\\]]", ""));
                l.a().b().execute(new b(this, aVar, arrayList2));
            } else {
                h.a a2 = this.f37347d.a(str);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (b(currentTimeMillis)) {
                    if (a2 == null) {
                        arrayList3.add(str);
                    } else if (a2.c()) {
                        this.f37344a.m(str);
                    }
                    if (e(currentTimeMillis)) {
                        arrayList3.addAll(this.f37344a.v());
                    }
                    this.f37344a.o(arrayList3, new j(this.f37349f));
                } else {
                    k.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
                }
                if (a2 != null) {
                    BDHttpDnsResult.ResolveType resolveType = a2.c() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                    k.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, a2.d().toString(), resolveType.toString());
                    l.a().b().execute(new c(this, aVar, resolveType, a2));
                    return;
                }
                h.a a3 = this.f37346c.a(str);
                if (a3 == null) {
                    this.f37345b.d(str, new g(this.f37349f, aVar));
                    return;
                }
                BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = a3.d() != null ? a3.d().toString() : null;
                objArr[2] = a3.g() != null ? a3.g().toString() : null;
                objArr[3] = resolveType2.toString();
                k.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                l.a().b().execute(new d(this, aVar, resolveType2, a3));
            }
        }
    }

    public h d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37346c : (h) invokeV.objValue;
    }

    public final boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            if (j - this.f37352i > 60000) {
                this.f37352i = j;
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public CachePolicy f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37350g : (CachePolicy) invokeV.objValue;
    }

    public i g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37344a : (i) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f37348e = new BDNetworkStateChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f37349f.registerReceiver(this.f37348e, intentFilter);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (str.length() <= 64) {
                this.f37344a.w(str);
                k.a("Set account id to %s", str);
                return;
            }
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
    }

    public void l(CachePolicy cachePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cachePolicy) == null) {
            this.f37350g = cachePolicy;
            if (cachePolicy == CachePolicy.POLICY_STRICT) {
                this.f37347d.d(true);
            } else {
                this.f37347d.d(false);
            }
            k.a("Set cache policy to %s", cachePolicy.name());
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f37344a.p(z);
            k.a("Set https enabled to %b", Boolean.valueOf(z));
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            k.b(z);
            k.a("Set debug log enabled to %b", Boolean.valueOf(z));
        }
    }

    public void o(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f37348e.a(z);
            this.f37348e.b(z2);
            k.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (str == null || str.isEmpty()) {
                k.a("Set pre resolve hosts error, get empty tag", new Object[0]);
                return;
            }
            int i2 = this.j + 1;
            this.j = i2;
            if (i2 > 1) {
                k.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
            }
            k.a(" Set preResolve tag : %s", str.toString());
            j jVar = new j(this.f37349f);
            this.f37351h = System.currentTimeMillis();
            this.f37344a.n(str, i.d.f37379b, jVar);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            int length = str.length();
            if (length > 64 || length < 8) {
                throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
            }
            this.f37344a.y(str);
            String substring = str.substring(0, 3);
            for (int i2 = 0; i2 < length - 6; i2++) {
                substring = substring + String.valueOf('*');
            }
            k.a("Set secret to %s", substring + str.substring(length - 3));
        }
    }

    public BDHttpDnsResult r(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            if (e.e(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, null);
            } else if (e.g(str)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str.replaceAll("[\\[\\]]", ""));
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, arrayList2);
            } else {
                BDHttpDnsResult.ResolveType resolveType = BDHttpDnsResult.ResolveType.RESOLVE_NONE;
                h.a a2 = this.f37347d.a(str);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (b(currentTimeMillis)) {
                    if (a2 == null) {
                        arrayList3.add(str);
                    } else if (a2.c()) {
                        this.f37344a.m(str);
                    }
                    if (e(currentTimeMillis)) {
                        arrayList3.addAll(this.f37344a.v());
                    }
                    this.f37344a.o(arrayList3, new j(this.f37349f));
                } else {
                    k.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
                }
                if (a2 != null) {
                    BDHttpDnsResult.ResolveType resolveType2 = a2.c() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                    k.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, a2.d().toString(), resolveType2.toString());
                    return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, a2.d(), a2.g());
                } else if (a2 == null && z) {
                    k.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                    return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
                } else {
                    h.a a3 = this.f37346c.a(str);
                    if (a3 != null) {
                        BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                        Object[] objArr = new Object[4];
                        objArr[0] = str;
                        objArr[1] = a3.d() != null ? a3.d().toString() : null;
                        objArr[2] = a3.g() != null ? a3.g().toString() : null;
                        objArr[3] = resolveType3.toString();
                        k.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                        return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, a3.d(), a3.g());
                    }
                    BDHttpDnsResult a4 = this.f37345b.a(str);
                    if (a4.c() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                        h.a aVar = new h.a();
                        aVar.a(60L);
                        aVar.e(System.currentTimeMillis() / 1000);
                        aVar.b(a4.a());
                        aVar.f(a4.b());
                        this.f37346c.c(str, aVar);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = str;
                        objArr2[1] = aVar.d() != null ? aVar.d().toString() : null;
                        objArr2[2] = aVar.g() != null ? aVar.g().toString() : null;
                        objArr2[3] = a4.d().toString();
                        k.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                    } else {
                        k.a("Sync resolve failed, host(%s), dns resolve failed", str);
                    }
                    return a4;
                }
            }
        }
        return (BDHttpDnsResult) invokeLZ.objValue;
    }
}
