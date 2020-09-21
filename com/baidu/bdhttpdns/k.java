package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes18.dex */
public class k implements i.a {
    private final BDHttpDns adP;
    private final h adX;
    private final BDHttpDns.CachePolicy adY;
    private final i adZ;

    public k(Context context) {
        this.adP = BDHttpDns.P(context);
        this.adX = this.adP.sS();
        this.adY = this.adP.sU();
        this.adZ = this.adP.sV();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.adY == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        this.adX.b(str2);
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
                        this.adX.a(key, aVar);
                    } else if (this.adY == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.adX.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.adP.e() <= 0 || this.adZ.f()) {
            return;
        }
        this.adZ.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
