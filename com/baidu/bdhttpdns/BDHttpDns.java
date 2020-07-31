package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns abw;
    private BDNetworkStateChangeReceiver abB;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i abx = i.rk();
    private final f aby = f.rj();
    private final h abz = new h("DNS", true);
    private final h abA = new h("HTTPDNS", false);
    private CachePolicy abC = CachePolicy.POLICY_TOLERANT;

    /* loaded from: classes9.dex */
    public enum CachePolicy {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    /* loaded from: classes9.dex */
    public interface a {
        void a(BDHttpDnsResult bDHttpDnsResult);
    }

    private BDHttpDns(Context context) {
        this.g = context;
        f();
        this.abB.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns L(Context context) {
        if (abw == null) {
            synchronized (BDHttpDns.class) {
                if (abw == null) {
                    abw = new BDHttpDns(context);
                }
            }
        }
        return abw;
    }

    private boolean a(long j) {
        return this.abx.f() || (j - this.i > 1000 && !this.abB.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > 60000) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.abB = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.abB, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.abC = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.abA.a(true);
        } else {
            this.abA.a(false);
        }
        l.a("Set cache policy to %s", cachePolicy.name());
    }

    public void a(String str, a aVar) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m.rm().b().execute(new com.baidu.bdhttpdns.a(this, aVar, arrayList));
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            m.rm().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a cU = this.abA.cU(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (cU == null) {
                    arrayList3.add(str);
                } else if (cU.a()) {
                    this.abx.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.abx.c());
                }
                this.abx.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (cU != null) {
                BDHttpDnsResult.ResolveType resolveType = cU.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, cU.b().toString(), resolveType.toString());
                m.rm().b().execute(new c(this, aVar, resolveType, cU));
                return;
            }
            h.a cU2 = this.abz.cU(str);
            if (cU2 == null) {
                this.aby.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = cU2.b() != null ? cU2.b().toString() : null;
            objArr[2] = cU2.c() != null ? cU2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.rm().b().execute(new d(this, aVar, resolveType2, cU2));
        }
    }

    public void aB(boolean z) {
        this.abx.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void aC(boolean z) {
        l.a(z);
        l.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void cP(String str) {
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
        this.abx.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void cQ(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.abx.c(str);
        l.a("Set account id to %s", str);
    }

    public void cR(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.abx.d(str);
        String substring = str.substring(0, 3);
        for (int i = 0; i < length - 6; i++) {
            substring = substring + String.valueOf('*');
        }
        l.a("Set secret to %s", substring + str.substring(length - 3));
    }

    public void d(boolean z, boolean z2) {
        this.abB.a(z);
        this.abB.b(z2);
        l.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
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
            h.a cU = this.abA.cU(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (cU == null) {
                    arrayList3.add(str);
                } else if (cU.a()) {
                    this.abx.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.abx.c());
                }
                this.abx.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (cU != null) {
                BDHttpDnsResult.ResolveType resolveType2 = cU.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, cU.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, cU.b(), cU.c());
            } else if (cU == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a cU2 = this.abz.cU(str);
                if (cU2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = cU2.b() != null ? cU2.b().toString() : null;
                    objArr[2] = cU2.c() != null ? cU2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, cU2.b(), cU2.c());
                }
                BDHttpDnsResult cT = this.aby.cT(str);
                if (cT.rg() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(cT.rh());
                    aVar.b(cT.ri());
                    this.abz.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = cT.rf().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return cT;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h rb() {
        return this.abA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h rc() {
        return this.abz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy rd() {
        return this.abC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i re() {
        return this.abx;
    }
}
