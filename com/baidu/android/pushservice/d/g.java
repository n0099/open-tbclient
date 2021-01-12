package com.baidu.android.pushservice.d;

import android.content.Context;
import com.baidu.searchbox.dns.DnsHelper;
import java.util.List;
/* loaded from: classes14.dex */
public class g extends com.baidu.android.pushservice.g.c {

    /* renamed from: a  reason: collision with root package name */
    private Context f1269a;

    /* renamed from: b  reason: collision with root package name */
    private a f1270b;
    private String c;
    private List<String> d;

    /* loaded from: classes14.dex */
    public interface a {
        void a(List<String> list);
    }

    public g(Context context, String str, a aVar) {
        this.f1269a = context;
        this.c = str;
        this.f1270b = aVar;
        c("PushService-PushService-SearchboxDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.g.c
    public void a() {
        b();
    }

    protected void b() {
        try {
            this.d = new DnsHelper(this.f1269a).getIpListForceHttp(this.c);
        } catch (Throwable th) {
        }
        this.f1270b.a(this.d);
    }
}
