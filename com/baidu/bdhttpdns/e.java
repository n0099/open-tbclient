package com.baidu.bdhttpdns;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.c;
import com.baidu.bdhttpdns.i;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes.dex */
public class e implements i.a {
    private final c EI;
    private final BDHttpDns EJ;
    private final BDHttpDns.CachePolicy EK;
    private final i EL;

    public e(Context context) {
        this.EJ = BDHttpDns.ag(context);
        this.EI = this.EJ.lu();
        this.EK = this.EJ.lw();
        this.EL = this.EJ.lx();
    }

    @Override // com.baidu.bdhttpdns.i.a
    public void a(int i, i.d dVar, Map<String, i.e> map, String str) {
        switch (i) {
            case -1:
                if (dVar.equals(i.d.DNLIST_HOSTS) && this.EK == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                    for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        this.EI.b(str2);
                    }
                    break;
                }
                break;
            case 0:
                for (Map.Entry<String, i.e> entry : map.entrySet()) {
                    String key = entry.getKey();
                    i.e value = entry.getValue();
                    if (value != null) {
                        c.a aVar = new c.a();
                        aVar.a(value.b());
                        aVar.b(System.currentTimeMillis() / 1000);
                        aVar.a(value.a());
                        this.EI.a(key, aVar);
                    } else if (this.EK == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                        this.EI.b(key);
                    }
                }
                break;
            default:
                f.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                break;
        }
        if (this.EJ.e() <= 0 || this.EL.f()) {
            return;
        }
        this.EL.b(true);
        f.a("preResolve has finished", new Object[0]);
    }
}
