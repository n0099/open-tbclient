package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import java.util.Map;
/* loaded from: classes5.dex */
public class k implements i.a {
    private final BDHttpDns agh;
    private final h agn;
    private final BDHttpDns.CachePolicy ago;
    private final i agp;

    public k(Context context) {
        this.agh = BDHttpDns.O(context);
        this.agn = this.agh.sh();
        this.ago = this.agh.sj();
        this.agp = this.agh.sk();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.ago == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(",")) {
                        this.agn.b(str2);
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
                        this.agn.a(key, aVar);
                    } else if (this.ago == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.agn.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.agh.e() <= 0 || this.agp.f()) {
            return;
        }
        this.agp.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
