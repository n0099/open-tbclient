package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements i.a {
    private final BDHttpDns aeV;
    private final h afb;
    private final BDHttpDns.CachePolicy afc;
    private final i afd;

    public k(Context context) {
        this.aeV = BDHttpDns.P(context);
        this.afb = this.aeV.sk();
        this.afc = this.aeV.sm();
        this.afd = this.aeV.sn();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.afc == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(",")) {
                        this.afb.b(str2);
                    }
                    break;
                }
                break;
            case 0:
                for (Map.Entry<String, i.e> entry : map.entrySet()) {
                    String key = entry.getKey();
                    i.e value = entry.getValue();
                    if (value != null) {
                        h.a aVar = new h.a();
                        aVar.a(value.b());
                        aVar.b(System.currentTimeMillis() / 1000);
                        aVar.a(value.a());
                        this.afb.a(key, aVar);
                    } else if (this.afc == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.afb.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.aeV.e() <= 0 || this.afd.f()) {
            return;
        }
        this.afd.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
