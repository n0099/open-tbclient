package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.i;
import d.a.g.b;
import d.a.g.c;
import d.a.g.d;
import d.a.g.e;
import d.a.g.f;
import d.a.g.g;
import d.a.g.h;
import d.a.g.j;
import d.a.g.k;
import d.a.g.l;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BDHttpDns {
    public static volatile BDHttpDns k;

    /* renamed from: e  reason: collision with root package name */
    public BDNetworkStateChangeReceiver f4226e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f4227f;

    /* renamed from: h  reason: collision with root package name */
    public long f4229h;

    /* renamed from: i  reason: collision with root package name */
    public long f4230i;
    public int j;

    /* renamed from: a  reason: collision with root package name */
    public final i f4222a = i.b();

    /* renamed from: b  reason: collision with root package name */
    public final f f4223b = f.b();

    /* renamed from: c  reason: collision with root package name */
    public final h f4224c = new h("DNS", true);

    /* renamed from: d  reason: collision with root package name */
    public final h f4225d = new h("HTTPDNS", false);

    /* renamed from: g  reason: collision with root package name */
    public CachePolicy f4228g = CachePolicy.POLICY_TOLERANT;

    /* loaded from: classes.dex */
    public enum CachePolicy {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(BDHttpDnsResult bDHttpDnsResult);
    }

    public BDHttpDns(Context context) {
        this.f4227f = context;
        i();
        this.f4226e.refreshIpReachable();
        this.f4230i = System.currentTimeMillis();
    }

    public static BDHttpDns j(Context context) {
        if (k == null) {
            synchronized (BDHttpDns.class) {
                if (k == null) {
                    k = new BDHttpDns(context);
                }
            }
        }
        return k;
    }

    public h a() {
        return this.f4225d;
    }

    public final boolean b(long j) {
        return this.f4222a.C() || (j - this.f4229h > 1000 && !this.f4226e.isIPv6Only());
    }

    public void c(String str, a aVar) {
        if (e.e(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            l.a().b().execute(new d.a.g.a(this, aVar, arrayList));
        } else if (e.g(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            l.a().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a a2 = this.f4225d.a(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (b(currentTimeMillis)) {
                if (a2 == null) {
                    arrayList3.add(str);
                } else if (a2.c()) {
                    this.f4222a.m(str);
                }
                if (e(currentTimeMillis)) {
                    arrayList3.addAll(this.f4222a.v());
                }
                this.f4222a.o(arrayList3, new j(this.f4227f));
            } else {
                k.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (a2 != null) {
                BDHttpDnsResult.ResolveType resolveType = a2.c() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                k.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, a2.d().toString(), resolveType.toString());
                l.a().b().execute(new c(this, aVar, resolveType, a2));
                return;
            }
            h.a a3 = this.f4224c.a(str);
            if (a3 == null) {
                this.f4223b.d(str, new g(this.f4227f, aVar));
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

    public h d() {
        return this.f4224c;
    }

    public final boolean e(long j) {
        if (j - this.f4230i > 60000) {
            this.f4230i = j;
            return true;
        }
        return false;
    }

    public CachePolicy f() {
        return this.f4228g;
    }

    public i g() {
        return this.f4222a;
    }

    public int h() {
        return this.j;
    }

    public final void i() {
        this.f4226e = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f4227f.registerReceiver(this.f4226e, intentFilter);
    }

    public void k(String str) {
        if (str.length() <= 64) {
            this.f4222a.w(str);
            k.a("Set account id to %s", str);
            return;
        }
        throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
    }

    public void l(CachePolicy cachePolicy) {
        this.f4228g = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.f4225d.d(true);
        } else {
            this.f4225d.d(false);
        }
        k.a("Set cache policy to %s", cachePolicy.name());
    }

    public void m(boolean z) {
        this.f4222a.p(z);
        k.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void n(boolean z) {
        k.b(z);
        k.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void o(boolean z, boolean z2) {
        this.f4226e.a(z);
        this.f4226e.b(z2);
        k.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void p(String str) {
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
        j jVar = new j(this.f4227f);
        this.f4229h = System.currentTimeMillis();
        this.f4222a.n(str, i.d.TAG_OF_HOSTS, jVar);
    }

    public void q(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.f4222a.y(str);
        String substring = str.substring(0, 3);
        for (int i2 = 0; i2 < length - 6; i2++) {
            substring = substring + String.valueOf('*');
        }
        k.a("Set secret to %s", substring + str.substring(length - 3));
    }

    public BDHttpDnsResult r(String str, boolean z) {
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
            h.a a2 = this.f4225d.a(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (b(currentTimeMillis)) {
                if (a2 == null) {
                    arrayList3.add(str);
                } else if (a2.c()) {
                    this.f4222a.m(str);
                }
                if (e(currentTimeMillis)) {
                    arrayList3.addAll(this.f4222a.v());
                }
                this.f4222a.o(arrayList3, new j(this.f4227f));
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
                h.a a3 = this.f4224c.a(str);
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
                BDHttpDnsResult a4 = this.f4223b.a(str);
                if (a4.c() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.e(System.currentTimeMillis() / 1000);
                    aVar.b(a4.a());
                    aVar.f(a4.b());
                    this.f4224c.c(str, aVar);
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
}
