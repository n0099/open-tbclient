package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns aex;
    private BDNetworkStateChangeReceiver aeC;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i aey = i.sq();
    private final f aez = f.sp();
    private final h aeA = new h("DNS", true);
    private final h aeB = new h("HTTPDNS", false);
    private CachePolicy aeD = CachePolicy.POLICY_TOLERANT;

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
        this.aeC.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns P(Context context) {
        if (aex == null) {
            synchronized (BDHttpDns.class) {
                if (aex == null) {
                    aex = new BDHttpDns(context);
                }
            }
        }
        return aex;
    }

    private boolean a(long j) {
        return this.aey.f() || (j - this.i > 1000 && !this.aeC.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > AppStatusRules.DEFAULT_GRANULARITY) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.aeC = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.aeC, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.aeD = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.aeB.a(true);
        } else {
            this.aeB.a(false);
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
            h.a da = this.aeB.da(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (da == null) {
                    arrayList3.add(str);
                } else if (da.a()) {
                    this.aey.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.aey.c());
                }
                this.aey.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (da != null) {
                BDHttpDnsResult.ResolveType resolveType = da.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, da.b().toString(), resolveType.toString());
                m.ss().b().execute(new c(this, aVar, resolveType, da));
                return;
            }
            h.a da2 = this.aeA.da(str);
            if (da2 == null) {
                this.aez.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = da2.b() != null ? da2.b().toString() : null;
            objArr[2] = da2.c() != null ? da2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.ss().b().execute(new d(this, aVar, resolveType2, da2));
        }
    }

    public void aA(boolean z) {
        this.aey.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void aB(boolean z) {
        l.a(z);
        l.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void cV(String str) {
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
        this.aey.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void cW(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.aey.c(str);
        l.a("Set account id to %s", str);
    }

    public void cX(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.aey.d(str);
        String substring = str.substring(0, 3);
        for (int i = 0; i < length - 6; i++) {
            substring = substring + String.valueOf('*');
        }
        l.a("Set secret to %s", substring + str.substring(length - 3));
    }

    public void d(boolean z, boolean z2) {
        this.aeC.a(z);
        this.aeC.b(z2);
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
            h.a da = this.aeB.da(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (da == null) {
                    arrayList3.add(str);
                } else if (da.a()) {
                    this.aey.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.aey.c());
                }
                this.aey.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (da != null) {
                BDHttpDnsResult.ResolveType resolveType2 = da.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, da.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, da.b(), da.c());
            } else if (da == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a da2 = this.aeA.da(str);
                if (da2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = da2.b() != null ? da2.b().toString() : null;
                    objArr[2] = da2.c() != null ? da2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, da2.b(), da2.c());
                }
                BDHttpDnsResult cZ = this.aez.cZ(str);
                if (cZ.sm() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(cZ.sn());
                    aVar.b(cZ.so());
                    this.aeA.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = cZ.sl().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return cZ;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sh() {
        return this.aeB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h si() {
        return this.aeA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy sj() {
        return this.aeD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i sk() {
        return this.aey;
    }
}
