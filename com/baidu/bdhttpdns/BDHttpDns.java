package com.baidu.bdhttpdns;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.c;
import com.baidu.bdhttpdns.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BDHttpDns {
    private static volatile BDHttpDns Er;
    private BDNetworkStateChangeReceiver Ew;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final i Es = i.lD();
    private final b Et = b.lC();
    private final c Eu = new c("DNS", true);
    private final c Ev = new c("HTTPDNS", false);
    private CachePolicy Ex = CachePolicy.POLICY_TOLERANT;

    /* loaded from: classes.dex */
    public enum CachePolicy {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    private BDHttpDns(Context context) {
        this.g = context;
        f();
        this.Ew.refreshIpReachable();
        this.j = System.currentTimeMillis();
    }

    private boolean a(long j) {
        return this.Es.f() || (j - this.i > 1000 && !this.Ew.isIPv6Only());
    }

    public static BDHttpDns ag(Context context) {
        if (Er == null) {
            synchronized (BDHttpDns.class) {
                if (Er == null) {
                    Er = new BDHttpDns(context);
                }
            }
        }
        return Er;
    }

    private boolean b(long j) {
        if (j - this.j > 60000) {
            this.j = j;
            return true;
        }
        return false;
    }

    private void f() {
        this.Ew = new BDNetworkStateChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.g.registerReceiver(this.Ew, intentFilter);
    }

    public void R(boolean z) {
        this.Es.a(z);
        f.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void S(boolean z) {
        f.a(z);
        f.a("Set debug log enabled to %b", Boolean.valueOf(z));
    }

    public void a(CachePolicy cachePolicy) {
        this.Ex = cachePolicy;
        if (cachePolicy == CachePolicy.POLICY_STRICT) {
            this.Ev.a(true);
        } else {
            this.Ev.a(false);
        }
        f.a("Set cache policy to %s", cachePolicy.name());
    }

    public void bn(String str) {
        if (str == null || str.isEmpty()) {
            f.a("Set pre resolve hosts error, get empty tag", new Object[0]);
            return;
        }
        this.k++;
        if (this.k > 1) {
            f.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
        }
        f.a(" Set preResolve tag : %s", str.toString());
        e eVar = new e(this.g);
        this.i = System.currentTimeMillis();
        this.Es.a(str, i.d.TAG_OF_HOSTS, eVar);
    }

    public void bo(String str) {
        if (str.length() > 64) {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
        this.Es.c(str);
        f.a("Set account id to %s", str);
    }

    public void bp(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.Es.d(str);
        String substring = str.substring(0, 3);
        for (int i = 0; i < length - 6; i++) {
            substring = substring + String.valueOf('*');
        }
        f.a("Set secret to %s", substring + str.substring(length - 3));
    }

    public void d(boolean z, boolean z2) {
        this.Ew.a(z);
        this.Ew.b(z2);
        f.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.k;
    }

    public BDHttpDnsResult e(String str, boolean z) {
        if (a.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, null);
        } else if (a.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, arrayList2);
        } else {
            BDHttpDnsResult.ResolveType resolveType = BDHttpDnsResult.ResolveType.RESOLVE_NONE;
            c.a bs = this.Ev.bs(str);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (a(currentTimeMillis)) {
                if (bs == null) {
                    arrayList3.add(str);
                } else if (bs.a()) {
                    this.Es.a(str);
                }
                if (b(currentTimeMillis)) {
                    arrayList3.addAll(this.Es.c());
                }
                this.Es.a(arrayList3, new e(this.g));
            } else {
                f.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
            }
            if (bs != null) {
                BDHttpDnsResult.ResolveType resolveType2 = bs.a() ? BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE;
                f.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(null) resolveType(%s)", str, bs.b().toString(), resolveType2.toString());
                return new BDHttpDnsResult(resolveType2, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, bs.b(), bs.c());
            } else if (bs == null && z) {
                f.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
                return new BDHttpDnsResult(resolveType, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss, null, null);
            } else {
                c.a bs2 = this.Eu.bs(str);
                if (bs2 != null) {
                    BDHttpDnsResult.ResolveType resolveType3 = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = bs2.b() != null ? bs2.b().toString() : null;
                    objArr[2] = bs2.c() != null ? bs2.c().toString() : null;
                    objArr[3] = resolveType3.toString();
                    f.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                    return new BDHttpDnsResult(resolveType3, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, bs2.b(), bs2.c());
                }
                BDHttpDnsResult br = this.Et.br(str);
                if (br.lz() == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
                    c.a aVar = new c.a();
                    aVar.a(60L);
                    aVar.b(System.currentTimeMillis() / 1000);
                    aVar.a(br.lA());
                    aVar.b(br.lB());
                    this.Eu.a(str, aVar);
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = str;
                    objArr2[1] = aVar.b() != null ? aVar.b().toString() : null;
                    objArr2[2] = aVar.c() != null ? aVar.c().toString() : null;
                    objArr2[3] = br.ly().toString();
                    f.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr2);
                } else {
                    f.a("Sync resolve failed, host(%s), dns resolve failed", str);
                }
                return br;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c lu() {
        return this.Ev;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c lv() {
        return this.Eu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachePolicy lw() {
        return this.Ex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i lx() {
        return this.Es;
    }
}
