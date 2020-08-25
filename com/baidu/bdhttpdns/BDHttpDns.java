package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns ade;
    private BDNetworkStateChangeReceiver adj;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i adf = i.sW();
    private final f adg = f.sV();
    private final h adh = new h("DNS", true);
    private final h adi = new h("HTTPDNS", false);
    private CachePolicy adk = CachePolicy.POLICY_TOLERANT;

    /* loaded from: classes6.dex */
    public enum CachePolicy {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    /* loaded from: classes6.dex */
    public interface a {
        void a(BDHttpDnsResult bDHttpDnsResult);
    }

    private BDHttpDns(Context context) {
        this.g = context;
        f();
        this.adj.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns P(Context context) {
        if (ade == null) {
            synchronized (BDHttpDns.class) {
                if (ade == null) {
                    ade = new BDHttpDns(context);
                }
            }
        }
        return ade;
    }

    private boolean a(long j) {
        return this.adf.f() || (j - this.i > 1000 && !this.adj.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > 60000) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.adj = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.adj, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.adk = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.adi.a(true);
        } else {
            this.adi.a(false);
        }
        l.a("Set cache policy to %s", cachePolicy.name());
    }

    public void a(String str, a aVar) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m.sY().b().execute(new com.baidu.bdhttpdns.a(this, aVar, arrayList));
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            m.sY().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a de2 = this.adi.de(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (de2 == null) {
                    arrayList3.add(str);
                } else if (de2.a()) {
                    this.adf.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.adf.c());
                }
                this.adf.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (de2 != null) {
                BDHttpDnsResult.ResolveType resolveType = de2.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, de2.b().toString(), resolveType.toString());
                m.sY().b().execute(new c(this, aVar, resolveType, de2));
                return;
            }
            h.a de3 = this.adh.de(str);
            if (de3 == null) {
                this.adg.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = de3.b() != null ? de3.b().toString() : null;
            objArr[2] = de3.c() != null ? de3.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.sY().b().execute(new d(this, aVar, resolveType2, de3));
        }
    }

    public void aC(boolean z) {
        this.adf.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void aD(boolean z) {
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
        this.adf.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void d(boolean z, boolean z2) {
        this.adj.a(z);
        this.adj.b(z2);
        l.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void da(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.adf.c(str);
        l.a("Set account id to %s", str);
    }

    public void db(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.adf.d(str);
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
            h.a de2 = this.adi.de(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (de2 == null) {
                    arrayList3.add(str);
                } else if (de2.a()) {
                    this.adf.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.adf.c());
                }
                this.adf.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (de2 != null) {
                BDHttpDnsResult.ResolveType resolveType2 = de2.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, de2.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, de2.b(), de2.c());
            } else if (de2 == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a de3 = this.adh.de(str);
                if (de3 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = de3.b() != null ? de3.b().toString() : null;
                    objArr[2] = de3.c() != null ? de3.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, de3.b(), de3.c());
                }
                BDHttpDnsResult dd = this.adg.dd(str);
                if (dd.sS() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(dd.sT());
                    aVar.b(dd.sU());
                    this.adh.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = dd.sR().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return dd;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sN() {
        return this.adi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sO() {
        return this.adh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy sP() {
        return this.adk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i sQ() {
        return this.adf;
    }
}
