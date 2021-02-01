package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements i.a {
    private final BDHttpDns aeO;
    private final h aeU;
    private final BDHttpDns.CachePolicy aeV;
    private final i aeW;

    public k(Context context) {
        this.aeO = BDHttpDns.P(context);
        this.aeU = this.aeO.sh();
        this.aeV = this.aeO.sj();
        this.aeW = this.aeO.sk();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.aeV == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(",")) {
                        this.aeU.b(str2);
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
                        this.aeU.a(key, aVar);
                    } else if (this.aeV == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.aeU.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.aeO.e() <= 0 || this.aeW.f()) {
            return;
        }
        this.aeW.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
