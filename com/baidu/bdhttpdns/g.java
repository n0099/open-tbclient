package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.f;
import com.baidu.bdhttpdns.h;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class g implements f.a {
    private final BDHttpDns.a adZ;
    private final BDHttpDns aeh;
    private final h aei;

    public g(Context context, BDHttpDns.a aVar) {
        this.adZ = aVar;
        this.aeh = BDHttpDns.P(context);
        this.aei = this.aeh.sT();
    }

    @Override // com.baidu.bdhttpdns.f.a
    public void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str) {
        switch (i) {
            case -1:
                l.a("Async resolve failed, host(%s), dns resolve failed", str);
                if (this.adZ != null) {
                    this.adZ.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONE, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve, arrayList, arrayList2));
                    return;
                }
                return;
            case 0:
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = arrayList != null ? arrayList.toString() : null;
                objArr[2] = arrayList2 != null ? arrayList2.toString() : null;
                objArr[3] = BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS.toString();
                l.a("Async resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
                h.a aVar = new h.a();
                aVar.a(60L);
                aVar.b(System.currentTimeMillis() / 1000);
                aVar.a(arrayList);
                aVar.b(arrayList2);
                this.aei.a(str, aVar);
                if (this.adZ != null) {
                    this.adZ.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2));
                    return;
                }
                return;
            default:
                l.a("Internal error: async dns resolve completion get error ret(%d)", Integer.valueOf(i));
                return;
        }
    }
}
