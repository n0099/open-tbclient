package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements i.a {
    private final BDHttpDns afM;
    private final h afS;
    private final BDHttpDns.CachePolicy afT;
    private final i afU;

    public k(Context context) {
        this.afM = BDHttpDns.Q(context);
        this.afS = this.afM.sv();
        this.afT = this.afM.sx();
        this.afU = this.afM.sy();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.afT == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(",")) {
                        this.afS.b(str2);
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
                        this.afS.a(key, aVar);
                    } else if (this.afT == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.afS.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.afM.e() <= 0 || this.afU.f()) {
            return;
        }
        this.afU.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
