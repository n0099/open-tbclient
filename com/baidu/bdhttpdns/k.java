package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes12.dex */
public class k implements i.a {
    private final BDHttpDns aeh;
    private final h aep;
    private final BDHttpDns.CachePolicy aeq;
    private final i aer;

    public k(Context context) {
        this.aeh = BDHttpDns.P(context);
        this.aep = this.aeh.sS();
        this.aeq = this.aeh.sU();
        this.aer = this.aeh.sV();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.aeq == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        this.aep.b(str2);
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
                        this.aep.a(key, aVar);
                    } else if (this.aeq == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.aep.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.aeh.e() <= 0 || this.aer.f()) {
            return;
        }
        this.aer.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
