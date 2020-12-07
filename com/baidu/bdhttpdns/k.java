package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.Map;
/* loaded from: classes5.dex */
public class k implements i.a {
    private final BDHttpDns afh;
    private final h afp;
    private final BDHttpDns.CachePolicy afq;
    private final i afr;

    public k(Context context) {
        this.afh = BDHttpDns.Q(context);
        this.afp = this.afh.sV();
        this.afq = this.afh.sX();
        this.afr = this.afh.sY();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.afq == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(",")) {
                        this.afp.b(str2);
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
                        this.afp.a(key, aVar);
                    } else if (this.afq == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.afp.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.afh.e() <= 0 || this.afr.f()) {
            return;
        }
        this.afr.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
