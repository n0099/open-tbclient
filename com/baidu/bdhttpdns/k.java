package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes19.dex */
public class k implements i.a {
    private final BDHttpDns aem;
    private final h aeu;
    private final BDHttpDns.CachePolicy aev;
    private final i aew;

    public k(Context context) {
        this.aem = BDHttpDns.P(context);
        this.aeu = this.aem.sS();
        this.aev = this.aem.sU();
        this.aew = this.aem.sV();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.aev == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        this.aeu.b(str2);
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
                        this.aeu.a(key, aVar);
                    } else if (this.aev == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.aeu.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.aem.e() <= 0 || this.aew.f()) {
            return;
        }
        this.aew.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
