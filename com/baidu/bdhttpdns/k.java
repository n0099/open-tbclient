package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.h;
import com.baidu.bdhttpdns.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes.dex */
public class k implements i.a {
    private final BDHttpDns aaT;
    private final h abb;
    private final BDHttpDns.CachePolicy abd;
    private final i abe;

    public k(Context context) {
        this.aaT = BDHttpDns.X(context);
        this.abb = this.aaT.qC();
        this.abd = this.aaT.qE();
        this.abe = this.aaT.qF();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.abd == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        this.abb.b(str2);
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
                        this.abb.a(key, aVar);
                    } else if (this.abd == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.abb.b(key);
                    }
                }
                break;
            default:
                l.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.aaT.e() <= 0 || this.abe.f()) {
            return;
        }
        this.abe.b(true);
        l.a("preResolve has finished", new Object[0]);
    }
}
