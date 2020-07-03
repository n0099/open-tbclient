package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns abB;
    private BDNetworkStateChangeReceiver abG;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i abC = i.ri();
    private final f abD = f.rh();
    private final h abE = new h("DNS", true);
    private final h abF = new h("HTTPDNS", false);
    private CachePolicy abH = CachePolicy.POLICY_TOLERANT;

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

    private BDHttpDns(Context context) {
        this.g = context;
        f();
        this.abG.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns L(Context context) {
        if (abB == null) {
            synchronized (BDHttpDns.class) {
                if (abB == null) {
                    abB = new BDHttpDns(context);
                }
            }
        }
        return abB;
    }

    private boolean a(long j) {
        return this.abC.f() || (j - this.i > 1000 && !this.abG.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > 60000) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.abG = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.abG, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.abH = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.abF.a(true);
        } else {
            this.abF.a(false);
        }
        l.a("Set cache policy to %s", cachePolicy.name());
    }

    public void a(String str, a aVar) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m.rk().b().execute(new com.baidu.bdhttpdns.a(this, aVar, arrayList));
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            m.rk().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a cV = this.abF.cV(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (cV == null) {
                    arrayList3.add(str);
                } else if (cV.a()) {
                    this.abC.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.abC.c());
                }
                this.abC.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (cV != null) {
                BDHttpDnsResult.ResolveType resolveType = cV.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, cV.b().toString(), resolveType.toString());
                m.rk().b().execute(new c(this, aVar, resolveType, cV));
                return;
            }
            h.a cV2 = this.abE.cV(str);
            if (cV2 == null) {
                this.abD.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = cV2.b() != null ? cV2.b().toString() : null;
            objArr[2] = cV2.c() != null ? cV2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.rk().b().execute(new d(this, aVar, resolveType2, cV2));
        }
    }

    public void aB(boolean z) {
        this.abC.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void aC(boolean z) {
        l.a(z);
        l.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void cQ(String str) {
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
        this.abC.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void cR(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.abC.c(str);
        l.a("Set account id to %s", str);
    }

    public void cS(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.abC.d(str);
        String substring = str.substring(0, 3);
        for (int i = 0; i < length - 6; i++) {
            substring = substring + String.valueOf('*');
        }
        l.a("Set secret to %s", substring + str.substring(length - 3));
    }

    public void d(boolean z, boolean z2) {
        this.abG.a(z);
        this.abG.b(z2);
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
            h.a cV = this.abF.cV(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (cV == null) {
                    arrayList3.add(str);
                } else if (cV.a()) {
                    this.abC.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.abC.c());
                }
                this.abC.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (cV != null) {
                BDHttpDnsResult.ResolveType resolveType2 = cV.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, cV.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, cV.b(), cV.c());
            } else if (cV == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a cV2 = this.abE.cV(str);
                if (cV2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = cV2.b() != null ? cV2.b().toString() : null;
                    objArr[2] = cV2.c() != null ? cV2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, cV2.b(), cV2.c());
                }
                BDHttpDnsResult cU = this.abD.cU(str);
                if (cU.re() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(cU.rf());
                    aVar.b(cU.rg());
                    this.abE.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = cU.rd().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return cU;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h qZ() {
        return this.abF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h ra() {
        return this.abE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy rb() {
        return this.abH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i rc() {
        return this.abC;
    }
}
