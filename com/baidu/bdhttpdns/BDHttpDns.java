package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns aeQ;
    private BDNetworkStateChangeReceiver aeV;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i aeR = i.te();
    private final f aeS = f.td();
    private final h aeT = new h("DNS", true);
    private final h aeU = new h("HTTPDNS", false);
    private CachePolicy aeW = CachePolicy.POLICY_TOLERANT;

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
        this.aeV.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    public static BDHttpDns Q(Context context) {
        if (aeQ == null) {
            synchronized (BDHttpDns.class) {
                if (aeQ == null) {
                    aeQ = new BDHttpDns(context);
                }
            }
        }
        return aeQ;
    }

    private boolean a(long j) {
        return this.aeR.f() || (j - this.i > 1000 && !this.aeV.isIPv6Only());
    }

    private boolean b(long j) {
        if (j - this.j > 60000) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.aeV = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.aeV, intentFilter);
    }

    public void a(CachePolicy cachePolicy) {
        this.aeW = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.aeU.a(true);
        } else {
            this.aeU.a(false);
        }
        l.a("Set cache policy to %s", cachePolicy.name());
    }

    public void a(String str, a aVar) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m.tg().b().execute(new com.baidu.bdhttpdns.a(this, aVar, arrayList));
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            m.tg().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a dm = this.aeU.dm(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (dm == null) {
                    arrayList3.add(str);
                } else if (dm.a()) {
                    this.aeR.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.aeR.c());
                }
                this.aeR.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (dm != null) {
                BDHttpDnsResult.ResolveType resolveType = dm.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, dm.b().toString(), resolveType.toString());
                m.tg().b().execute(new c(this, aVar, resolveType, dm));
                return;
            }
            h.a dm2 = this.aeT.dm(str);
            if (dm2 == null) {
                this.aeS.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = dm2.b() != null ? dm2.b().toString() : null;
            objArr[2] = dm2.c() != null ? dm2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.tg().b().execute(new d(this, aVar, resolveType2, dm2));
        }
    }

    public void aB(boolean z) {
        this.aeR.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void aC(boolean z) {
        l.a(z);
        l.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void d(boolean z, boolean z2) {
        this.aeV.a(z);
        this.aeV.b(z2);
        l.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void dh(String str) {
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
        this.aeR.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void di(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.aeR.c(str);
        l.a("Set account id to %s", str);
    }

    public void dj(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.aeR.d(str);
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
            h.a dm = this.aeU.dm(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (dm == null) {
                    arrayList3.add(str);
                } else if (dm.a()) {
                    this.aeR.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.aeR.c());
                }
                this.aeR.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (dm != null) {
                BDHttpDnsResult.ResolveType resolveType2 = dm.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, dm.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, dm.b(), dm.c());
            } else if (dm == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a dm2 = this.aeT.dm(str);
                if (dm2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = dm2.b() != null ? dm2.b().toString() : null;
                    objArr[2] = dm2.c() != null ? dm2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, dm2.b(), dm2.c());
                }
                BDHttpDnsResult dl = this.aeS.dl(str);
                if (dl.ta() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(dl.tb());
                    aVar.b(dl.tc());
                    this.aeT.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = dl.sZ().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return dl;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sV() {
        return this.aeU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h sW() {
        return this.aeT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy sX() {
        return this.aeW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i sY() {
        return this.aeR;
    }
}
