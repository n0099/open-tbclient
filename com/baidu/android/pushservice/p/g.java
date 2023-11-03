package com.baidu.android.pushservice.p;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.searchbox.dns.DnsHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.android.pushservice.z.c {
    public Context c;
    public a d;
    public String e;
    public List<String> f = new ArrayList();

    /* loaded from: classes.dex */
    public interface a {
        void a(List<String> list);
    }

    public g(Context context, String str, a aVar) {
        this.c = context;
        this.e = str;
        this.d = aVar;
        a("PushService-PushService-SearchboxDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.z.c
    public void a() {
        c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        try {
            DnsHelper dnsHelper = new DnsHelper(this.c);
            dnsHelper.setHttpDnsState(false, null, false, true);
            List<String> ipListForceHttp = dnsHelper.getIpListForceHttp(this.e);
            if (ipListForceHttp != null && ipListForceHttp.size() > 0) {
                int a2 = com.baidu.android.pushservice.a0.i.a(this.c, "key_vip_type", 3);
                if (a2 == 1) {
                    if (!Utility.f(ipListForceHttp.get(0))) {
                        r1 = ipListForceHttp.get(0);
                    }
                    if (!TextUtils.isEmpty(r1)) {
                    }
                } else if (a2 == 2) {
                    String str = Utility.f(ipListForceHttp.get(0)) ? null : ipListForceHttp.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        this.f.add(str);
                    }
                    r1 = Utility.f(ipListForceHttp.get(ipListForceHttp.size() - 1)) ? ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                    if (!TextUtils.isEmpty(r1)) {
                    }
                } else if (a2 != 4) {
                    String str2 = Utility.f(ipListForceHttp.get(ipListForceHttp.size() - 1)) ? ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                    if (!TextUtils.isEmpty(str2)) {
                        this.f.add(str2);
                    }
                    if (!Utility.f(ipListForceHttp.get(0))) {
                        r1 = ipListForceHttp.get(0);
                    }
                } else {
                    r1 = Utility.f(ipListForceHttp.get(ipListForceHttp.size() - 1)) ? ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                    if (!TextUtils.isEmpty(r1)) {
                    }
                }
                this.f.add(r1);
            }
        } catch (Throwable unused) {
        }
        this.d.a(this.f);
    }
}
