package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns Ha;
    private BDNetworkStateChangeReceiver Hf;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i Hb = i.lU();
    private final f Hc = f.lT();
    private final h Hd = new h("DNS", true);
    private final h He = new h("HTTPDNS", false);
    private CachePolicy Hg = CachePolicy.POLICY_TOLERANT;

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
        this.Hf.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    private boolean a(long j) {
        return this.Hb.f() || (j - this.i > 1000 && !this.Hf.isIPv6Only());
    }

    public static BDHttpDns ag(Context context) {
        if (Ha == null) {
            synchronized (BDHttpDns.class) {
                if (Ha == null) {
                    Ha = new BDHttpDns(context);
                }
            }
        }
        return Ha;
    }

    private boolean b(long j) {
        if (j - this.j > 60000) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.Hf = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.Hf, intentFilter);
    }

    public void W(boolean z) {
        this.Hb.a(z);
        l.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void X(boolean z) {
        l.a(z);
        l.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void a(CachePolicy cachePolicy) {
        this.Hg = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.He.a(true);
        } else {
            this.He.a(false);
        }
        l.a("Set cache policy to %s", cachePolicy.name());
    }

    public void a(String str, a aVar) {
        if (e.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            m.lW().b().execute(new com.baidu.bdhttpdns.a(this, aVar, arrayList));
        } else if (e.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            m.lW().b().execute(new b(this, aVar, arrayList2));
        } else {
            h.a bD = this.He.bD(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (bD == null) {
                    arrayList3.add(str);
                } else if (bD.a()) {
                    this.Hb.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.Hb.c());
                }
                this.Hb.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (bD != null) {
                BDHttpDnsResult.ResolveType resolveType = bD.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Async resolve successful, host(%s) ipv4List(%s) resolveType(%s)", str, bD.b().toString(), resolveType.toString());
                m.lW().b().execute(new c(this, aVar, resolveType, bD));
                return;
            }
            h.a bD2 = this.Hd.bD(str);
            if (bD2 == null) {
                this.Hc.a(str, new g(this.g, aVar));
                return;
            }
            BDHttpDnsResult.ResolveType resolveType2 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = bD2.b() != null ? bD2.b().toString() : null;
            objArr[2] = bD2.c() != null ? bD2.c().toString() : null;
            objArr[3] = resolveType2.toString();
            l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            m.lW().b().execute(new d(this, aVar, resolveType2, bD2));
        }
    }

    public void bA(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.Hb.d(str);
        String substring = str.substring(0, 3);
        for (int i = 0; i < length - 6; i++) {
            substring = substring + String.valueOf('*');
        }
        l.a("Set secret to %s", substring + str.substring(length - 3));
    }

    public void by(String str) {
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
        this.Hb.a(str, i.d.TAG_OF_HOSTS, kVar);
    }

    public void bz(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.Hb.c(str);
        l.a("Set account id to %s", str);
    }

    public void d(boolean z, boolean z2) {
        this.Hf.a(z);
        this.Hf.b(z2);
        l.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.k;
    }

    public BDHttpDnsResult f(String str, boolean z) {
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
            h.a bD = this.He.bD(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (bD == null) {
                    arrayList3.add(str);
                } else if (bD.a()) {
                    this.Hb.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.Hb.c());
                }
                this.Hb.a(arrayList3, new k(this.g));
            } else {
                l.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (bD != null) {
                BDHttpDnsResult.ResolveType resolveType2 = bD.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, bD.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, bD.b(), bD.c());
            } else if (bD == null && z) {
                l.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                h.a bD2 = this.Hd.bD(str);
                if (bD2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = bD2.b() != null ? bD2.b().toString() : null;
                    objArr[2] = bD2.c() != null ? bD2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    l.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, bD2.b(), bD2.c());
                }
                BDHttpDnsResult bC = this.Hc.bC(str);
                if (bC.lQ() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    h.a aVar = new h.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(bC.lR());
                    aVar.b(bC.lS());
                    this.Hd.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = bC.lP().toString();
                    l.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    l.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return bC;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h lL() {
        return this.He;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h lM() {
        return this.Hd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy lN() {
        return this.Hg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i lO() {
        return this.Hb;
    }
}
