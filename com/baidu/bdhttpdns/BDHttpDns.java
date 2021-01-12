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
    private static volatile BDHttpDns aeE;
    private BDNetworkStateChangeReceiver aeJ;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i aeF = i.st();
    private final f aeG = f.ss();
    private final h aeH = new h("DNS", true);
    private final h aeI = new h("HTTPDNS", false);
    private CachePolicy aeK = CachePolicy.POLICY_TOLERANT;

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
        this.aeJ.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns P(Context context) {
        if (aeE == null) {
            synchronized (BDHttpDns.class) {
                if (aeE == null) {
                    aeE = new BDHttpDns(context);
                }
            }
        }
        return aeE;
    }

    private boolean a(long j) {
        return this.aeF.f() || (j - this.i > 1000 && !this.aeJ.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > AppStatusRules.DEFAULT_GRANULARITY) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.aeJ = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.aeJ, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.aeK = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.aeI.a(true);
        } else {
            this.aeI.a(false);
        }
        l.a("Set cache policy to %s", cachePolicy.name());
    }

    public void a(String str, a aVar) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m.sv().b().execute(new com.baidu.bdhttpdns.a(this, aVar, arrayList));
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            m.sv().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a da = this.aeI.da(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (da == null) {
                    arrayList3.add(str);
                } else if (da.a()) {
                    this.aeF.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.aeF.c());
                }
                this.aeF.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (da != null) {
                BDHttpDnsResult.ResolveType resolveType = da.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, da.b().toString(), resolveType.toString());
                m.sv().b().execute(new c(this, aVar, resolveType, da));
                return;
            }
            h.a da2 = this.aeH.da(str);
            if (da2 == null) {
                this.aeG.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = da2.b() != null ? da2.b().toString() : null;
            objArr[2] = da2.c() != null ? da2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.sv().b().execute(new d(this, aVar, resolveType2, da2));
        }
    }

    public void aA(boolean z) {
        this.aeF.a(z);
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
        this.aeF.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void cW(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.aeF.c(str);
        l.a("Set account id to %s", str);
    }

    public void cX(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.aeF.d(str);
        String substring = str.substring(0, 3);
        for (int i = 0; i < length - 6; i++) {
            substring = substring + String.valueOf('*');
        }
        l.a("Set secret to %s", substring + str.substring(length - 3));
    }

    public void d(boolean z, boolean z2) {
        this.aeJ.a(z);
        this.aeJ.b(z2);
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
            h.a da = this.aeI.da(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (da == null) {
                    arrayList3.add(str);
                } else if (da.a()) {
                    this.aeF.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.aeF.c());
                }
                this.aeF.a(arrayList3, new k(this.g));
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
                h.a da2 = this.aeH.da(str);
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
                BDHttpDnsResult cZ = this.aeG.cZ(str);
                if (cZ.sp() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(cZ.sq());
                    aVar.b(cZ.sr());
                    this.aeH.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = cZ.so().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return cZ;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sk() {
        return this.aeI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sl() {
        return this.aeH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy sm() {
        return this.aeK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i sn() {
        return this.aeF;
    }
}
