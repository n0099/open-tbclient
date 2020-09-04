package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements i.a {
    private final h adF;
    private final BDHttpDns.CachePolicy adG;
    private final i adH;
    private final BDHttpDns adx;

    public k(Context context) {
        this.adx = BDHttpDns.P(context);
        this.adF = this.adx.sN();
        this.adG = this.adx.sP();
        this.adH = this.adx.sQ();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.adG == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        this.adF.b(str2);
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
                        this.adF.a(key, aVar);
                    } else if (this.adG == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.adF.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.adx.e() <= 0 || this.adH.f()) {
            return;
        }
        this.adH.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
