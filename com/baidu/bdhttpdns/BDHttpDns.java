package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns afP;
    private BDNetworkStateChangeReceiver afU;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i afQ = i.sq();
    private final f afR = f.sp();
    private final h afS = new h("DNS", true);
    private final h afT = new h("HTTPDNS", false);
    private CachePolicy afV = CachePolicy.POLICY_TOLERANT;

    /* loaded from: classes5.dex */
    public enum CachePolicy {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(BDHttpDnsResult bDHttpDnsResult);
    }

    private BDHttpDns(Context context) {
        this.g = context;
        f();
        this.afU.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns O(Context context) {
        if (afP == null) {
            synchronized (BDHttpDns.class) {
                if (afP == null) {
                    afP = new BDHttpDns(context);
                }
            }
        }
        return afP;
    }

    private boolean a(long j) {
        return this.afQ.f() || (j - this.i > 1000 && !this.afU.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > AppStatusRules.DEFAULT_GRANULARITY) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.afU = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.afU, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.afV = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.afT.a(true);
        } else {
            this.afT.a(false);
        }
        l.a("Set cache policy to %s", cachePolicy.name());
    }

    public void a(String str, a aVar) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m.ss().b().execute(new com.baidu.bdhttpdns.a(this, aVar, arrayList));
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            m.ss().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a de = this.afT.de(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (de == null) {
                    arrayList3.add(str);
                } else if (de.a()) {
                    this.afQ.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.afQ.c());
                }
                this.afQ.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (de != null) {
                BDHttpDnsResult.ResolveType resolveType = de.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, de.b().toString(), resolveType.toString());
                m.ss().b().execute(new c(this, aVar, resolveType, de));
                return;
            }
            h.a de2 = this.afS.de(str);
            if (de2 == null) {
                this.afR.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = de2.b() != null ? de2.b().toString() : null;
            objArr[2] = de2.c() != null ? de2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.ss().b().execute(new d(this, aVar, resolveType2, de2));
        }
    }

    public void aA(boolean z) {
        this.afQ.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void aB(boolean z) {
        l.a(z);
        l.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void cZ(String str) {
        if (str == null || str.isEmpty()) {
            l.a("Set pre resolve hosts error, get empty tag", new Object[0]);
            return;
        }
        this.k++;
        if (this.k > 1) {
            l.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
        }
        l.a(" Set preResolve tag : %s", str.toString());
        k kVar = new k(this.g);
        this.i = System.currentTimeMillis();
        this.afQ.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void d(boolean z, boolean z2) {
        this.afU.a(z);
        this.afU.b(z2);
        l.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void da(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.afQ.c(str);
        l.a("Set account id to %s", str);
    }

    public void db(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.afQ.d(str);
        String substring = str.substring(0, 3);
        for (int i = 0; i < length - 6; i++) {
            substring = substring + String.valueOf('*');
        }
        l.a("Set secret to %s", substring + str.substring(length - 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.k;
    }

    public BDHttpDnsResult j(String str, boolean z) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, null);
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, arrayList2);
        } else {
            BDHttpDnsResult.ResolveType resolveType = BDHttpDnsResult.ResolveType.RESOLVE_NONE;
            h.a de = this.afT.de(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (de == null) {
                    arrayList3.add(str);
                } else if (de.a()) {
                    this.afQ.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.afQ.c());
                }
                this.afQ.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (de != null) {
                BDHttpDnsResult.ResolveType resolveType2 = de.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, de.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, de.b(), de.c());
            } else if (de == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a de2 = this.afS.de(str);
                if (de2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = de2.b() != null ? de2.b().toString() : null;
                    objArr[2] = de2.c() != null ? de2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, de2.b(), de2.c());
                }
                BDHttpDnsResult dd = this.afR.dd(str);
                if (dd.sm() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(dd.sn());
                    aVar.b(dd.so());
                    this.afS.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = dd.sl().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return dd;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sh() {
        return this.afT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h si() {
        return this.afS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy sj() {
        return this.afV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i sk() {
        return this.afQ;
    }
}
