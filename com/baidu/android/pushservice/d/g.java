package com.baidu.android.pushservice.d;

import android.content.Context;
import com.baidu.searchbox.dns.DnsHelper;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends com.baidu.android.pushservice.g.c {
    private Context a;
    private a b;
    private String c;
    private List<String> d;

    /* loaded from: classes9.dex */
    public interface a {
        void a(List<String> list);
    }

    public g(Context context, String str, a aVar) {
        this.a = context;
        this.c = str;
        this.b = aVar;
        c("PushService-PushService-SearchboxDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.g.c
    public void a() {
        b();
    }

    protected void b() {
        try {
            this.d = new DnsHelper(this.a).getIpListForceHttp(this.c);
        } catch (Throwable th) {
        }
        this.b.a(this.d);
    }
}
