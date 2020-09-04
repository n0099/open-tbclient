package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns adg;
    private BDNetworkStateChangeReceiver adl;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i adh = i.sW();
    private final f adi = f.sV();
    private final h adj = new h("DNS", true);
    private final h adk = new h("HTTPDNS", false);
    private CachePolicy adm = CachePolicy.POLICY_TOLERANT;

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
        this.adl.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns P(Context context) {
        if (adg == null) {
            synchronized (BDHttpDns.class) {
                if (adg == null) {
                    adg = new BDHttpDns(context);
                }
            }
        }
        return adg;
    }

    private boolean a(long j) {
        return this.adh.f() || (j - this.i > 1000 && !this.adl.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > 60000) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.adl = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.adl, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.adm = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.adk.a(true);
        } else {
            this.adk.a(false);
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
            h.a df = this.adk.df(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (df == null) {
                    arrayList3.add(str);
                } else if (df.a()) {
                    this.adh.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.adh.c());
                }
                this.adh.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (df != null) {
                BDHttpDnsResult.ResolveType resolveType = df.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, df.b().toString(), resolveType.toString());
                m.sY().b().execute(new c(this, aVar, resolveType, df));
                return;
            }
            h.a df2 = this.adj.df(str);
            if (df2 == null) {
                this.adi.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = df2.b() != null ? df2.b().toString() : null;
            objArr[2] = df2.c() != null ? df2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.sY().b().execute(new d(this, aVar, resolveType2, df2));
        }
    }

    public void aC(boolean z) {
        this.adh.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void aD(boolean z) {
        l.a(z);
        l.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void d(boolean z, boolean z2) {
        this.adl.a(z);
        this.adl.b(z2);
        l.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void da(String str) {
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
        this.adh.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void db(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.adh.c(str);
        l.a("Set account id to %s", str);
    }

    public void dc(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.adh.d(str);
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
            h.a df = this.adk.df(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (df == null) {
                    arrayList3.add(str);
                } else if (df.a()) {
                    this.adh.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.adh.c());
                }
                this.adh.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (df != null) {
                BDHttpDnsResult.ResolveType resolveType2 = df.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, df.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, df.b(), df.c());
            } else if (df == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a df2 = this.adj.df(str);
                if (df2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = df2.b() != null ? df2.b().toString() : null;
                    objArr[2] = df2.c() != null ? df2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, df2.b(), df2.c());
                }
                BDHttpDnsResult de2 = this.adi.de(str);
                if (de2.sS() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(de2.sT());
                    aVar.b(de2.sU());
                    this.adj.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = de2.sR().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return de2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sN() {
        return this.adk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sO() {
        return this.adj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy sP() {
        return this.adm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i sQ() {
        return this.adh;
    }
}
