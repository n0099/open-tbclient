package com.baidu.android.pushservice.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends com.baidu.android.pushservice.h.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f2953a;

    /* renamed from: b  reason: collision with root package name */
    public a f2954b;

    /* renamed from: c  reason: collision with root package name */
    public String f2955c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f2956d = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(List<String> list);
    }

    public g(Context context, String str, a aVar) {
        this.f2953a = context;
        this.f2955c = str;
        this.f2954b = aVar;
        c("PushService-PushService-SearchboxDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.h.c
    public void a() {
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f5, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        try {
            DnsHelper dnsHelper = new DnsHelper(this.f2953a);
            dnsHelper.setHttpDnsState(false, (HttpDNSStat) null, false, true);
            List ipListForceHttp = dnsHelper.getIpListForceHttp(this.f2955c);
            if (ipListForceHttp != null && ipListForceHttp.size() > 0) {
                int b2 = com.baidu.android.pushservice.j.i.b(this.f2953a, "key_vip_type", 3);
                if (b2 != 1) {
                    if (b2 == 2) {
                        String str = com.baidu.android.pushservice.j.m.d((String) ipListForceHttp.get(0)) ? null : (String) ipListForceHttp.get(0);
                        if (!TextUtils.isEmpty(str)) {
                            this.f2956d.add(str);
                        }
                        r1 = com.baidu.android.pushservice.j.m.d((String) ipListForceHttp.get(ipListForceHttp.size() - 1)) ? (String) ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                        if (!TextUtils.isEmpty(r1)) {
                        }
                    } else if (b2 != 4) {
                        String str2 = com.baidu.android.pushservice.j.m.d((String) ipListForceHttp.get(ipListForceHttp.size() - 1)) ? (String) ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                        if (!TextUtils.isEmpty(str2)) {
                            this.f2956d.add(str2);
                        }
                        if (!com.baidu.android.pushservice.j.m.d((String) ipListForceHttp.get(0))) {
                            r1 = (String) ipListForceHttp.get(0);
                        }
                    } else {
                        r1 = com.baidu.android.pushservice.j.m.d((String) ipListForceHttp.get(ipListForceHttp.size() - 1)) ? (String) ipListForceHttp.get(ipListForceHttp.size() - 1) : null;
                        if (!TextUtils.isEmpty(r1)) {
                        }
                    }
                } else if (!com.baidu.android.pushservice.j.m.d((String) ipListForceHttp.get(0))) {
                    r1 = (String) ipListForceHttp.get(0);
                }
                this.f2956d.add(r1);
            }
        } catch (Throwable unused) {
        }
        this.f2954b.a(this.f2956d);
    }
}
