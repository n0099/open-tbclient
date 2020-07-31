package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes9.dex */
public class k implements i.a {
    private final BDHttpDns abN;
    private final h abV;
    private final BDHttpDns.CachePolicy abW;
    private final i abX;

    public k(Context context) {
        this.abN = BDHttpDns.L(context);
        this.abV = this.abN.rb();
        this.abW = this.abN.rd();
        this.abX = this.abN.re();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.abW == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        this.abV.b(str2);
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
                        this.abV.a(key, aVar);
                    } else if (this.abW == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.abV.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.abN.e() <= 0 || this.abX.f()) {
            return;
        }
        this.abX.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
