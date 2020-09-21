package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns ady;
    private BDNetworkStateChangeReceiver adD;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i adz = i.tb();
    private final f adA = f.ta();
    private final h adB = new h("DNS", true);
    private final h adC = new h("HTTPDNS", false);
    private CachePolicy adE = CachePolicy.POLICY_TOLERANT;

    /* loaded from: classes18.dex */
    public enum CachePolicy {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    /* loaded from: classes18.dex */
    public interface a {
        void a(BDHttpDnsResult bDHttpDnsResult);
    }

    private BDHttpDns(Context context) {
        this.g = context;
        f();
        this.adD.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns P(Context context) {
        if (ady == null) {
            synchronized (BDHttpDns.class) {
                if (ady == null) {
                    ady = new BDHttpDns(context);
                }
            }
        }
        return ady;
    }

    private boolean a(long j) {
        return this.adz.f() || (j - this.i > 1000 && !this.adD.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > 60000) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.adD = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.adD, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.adE = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.adC.a(true);
        } else {
            this.adC.a(false);
        }
        l.a("Set cache policy to %s", cachePolicy.name());
    }

    public void a(String str, a aVar) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m.td().b().execute(new com.baidu.bdhttpdns.a(this, aVar, arrayList));
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            m.td().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a dh = this.adC.dh(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (dh == null) {
                    arrayList3.add(str);
                } else if (dh.a()) {
                    this.adz.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.adz.c());
                }
                this.adz.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (dh != null) {
                BDHttpDnsResult.ResolveType resolveType = dh.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, dh.b().toString(), resolveType.toString());
                m.td().b().execute(new c(this, aVar, resolveType, dh));
                return;
            }
            h.a dh2 = this.adB.dh(str);
            if (dh2 == null) {
                this.adA.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = dh2.b() != null ? dh2.b().toString() : null;
            objArr[2] = dh2.c() != null ? dh2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.td().b().execute(new d(this, aVar, resolveType2, dh2));
        }
    }

    public void aC(boolean z) {
        this.adz.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void aD(boolean z) {
        l.a(z);
        l.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void d(boolean z, boolean z2) {
        this.adD.a(z);
        this.adD.b(z2);
        l.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void dc(String str) {
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
        this.adz.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void dd(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.adz.c(str);
        l.a("Set account id to %s", str);
    }

    public void de(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.adz.d(str);
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
            h.a dh = this.adC.dh(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (dh == null) {
                    arrayList3.add(str);
                } else if (dh.a()) {
                    this.adz.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.adz.c());
                }
                this.adz.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (dh != null) {
                BDHttpDnsResult.ResolveType resolveType2 = dh.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, dh.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, dh.b(), dh.c());
            } else if (dh == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a dh2 = this.adB.dh(str);
                if (dh2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = dh2.b() != null ? dh2.b().toString() : null;
                    objArr[2] = dh2.c() != null ? dh2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, dh2.b(), dh2.c());
                }
                BDHttpDnsResult dg = this.adA.dg(str);
                if (dg.sX() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(dg.sY());
                    aVar.b(dg.sZ());
                    this.adB.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = dg.sW().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return dg;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sS() {
        return this.adC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sT() {
        return this.adB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy sU() {
        return this.adE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i sV() {
        return this.adz;
    }
}
