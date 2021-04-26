package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import com.alipay.sdk.util.n;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class AuthTask {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1734a = com.alipay.sdk.util.e.class;

    /* renamed from: b  reason: collision with root package name */
    public Activity f1735b;

    /* renamed from: c  reason: collision with root package name */
    public com.alipay.sdk.widget.a f1736c;

    public AuthTask(Activity activity) {
        this.f1735b = activity;
        com.alipay.sdk.sys.b.a().a(this.f1735b, com.alipay.sdk.data.c.b());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.f1736c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f1999c);
    }

    private void b() {
        com.alipay.sdk.widget.a aVar = this.f1736c;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.alipay.sdk.widget.a aVar = this.f1736c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public synchronized String auth(String str, boolean z) {
        String c2;
        Activity activity;
        if (z) {
            b();
        }
        com.alipay.sdk.sys.b.a().a(this.f1735b, com.alipay.sdk.data.c.b());
        c2 = j.c();
        i.a("");
        try {
            c2 = a(this.f1735b, str);
            com.alipay.sdk.data.a.g().a(this.f1735b);
            c();
            activity = this.f1735b;
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
            com.alipay.sdk.data.a.g().a(this.f1735b);
            c();
            activity = this.f1735b;
        }
        com.alipay.sdk.app.statistic.a.b(activity, str);
        return c2;
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        return l.a(auth(str, z));
    }

    private e.a a() {
        return new a(this);
    }

    private String a(Activity activity, String str) {
        String a2 = new com.alipay.sdk.sys.a(this.f1735b).a(str);
        List<a.C0015a> f2 = com.alipay.sdk.data.a.g().f();
        if (!com.alipay.sdk.data.a.g().q || f2 == null) {
            f2 = i.f1787a;
        }
        if (n.b(this.f1735b, f2)) {
            String a3 = new com.alipay.sdk.util.e(activity, a()).a(a2);
            if (!TextUtils.equals(a3, com.alipay.sdk.util.e.f1950a) && !TextUtils.equals(a3, com.alipay.sdk.util.e.f1951b)) {
                return TextUtils.isEmpty(a3) ? j.c() : a3;
            }
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.O, "");
            return b(activity, a2);
        }
        com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.P, "");
        return b(activity, a2);
    }

    private String b(Activity activity, String str) {
        k kVar;
        b();
        try {
            try {
                List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(new com.alipay.sdk.packet.impl.a().a(activity, str).c().optJSONObject("form").optJSONObject(com.alipay.sdk.cons.c.f1836d));
                c();
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    if (a2.get(i2).b() == com.alipay.sdk.protocol.a.WapPay) {
                        String a3 = a(a2.get(i2));
                        c();
                        return a3;
                    }
                }
                c();
                kVar = null;
            } catch (IOException e2) {
                k b2 = k.b(k.NETWORK_ERROR.a());
                com.alipay.sdk.app.statistic.a.a("net", e2);
                c();
                kVar = b2;
            }
            if (kVar == null) {
                kVar = k.b(k.FAILED.a());
            }
            return j.a(kVar.a(), kVar.b(), "");
        }
    }

    private String a(com.alipay.sdk.protocol.b bVar) {
        String[] c2 = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        Intent intent = new Intent(this.f1735b, H5AuthActivity.class);
        intent.putExtras(bundle);
        this.f1735b.startActivity(intent);
        synchronized (f1734a) {
            try {
                f1734a.wait();
            } catch (InterruptedException unused) {
                return j.c();
            }
        }
        String a2 = j.a();
        return TextUtils.isEmpty(a2) ? j.c() : a2;
    }
}
