package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements i.a {
    private final BDHttpDns Hm;
    private final h Hu;
    private final BDHttpDns.CachePolicy Hv;
    private final i Hw;

    public k(Context context) {
        this.Hm = BDHttpDns.ag(context);
        this.Hu = this.Hm.lL();
        this.Hv = this.Hm.lN();
        this.Hw = this.Hm.lO();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.Hv == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        this.Hu.b(str2);
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
                        this.Hu.a(key, aVar);
                    } else if (this.Hv == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.Hu.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.Hm.e() <= 0 || this.Hw.f()) {
            return;
        }
        this.Hw.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
