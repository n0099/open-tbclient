package com.baidu.android.pushservice.d;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class j extends com.baidu.android.pushservice.g.c {

    /* renamed from: a  reason: collision with root package name */
    private Context f1273a;

    /* renamed from: b  reason: collision with root package name */
    private a f1274b;
    private String c;

    /* loaded from: classes14.dex */
    public interface a {
        void a(int i, String[] strArr);
    }

    public j(Context context, String str, a aVar) {
        this.f1273a = context;
        this.c = str;
        this.f1274b = aVar;
        c("PushService-PushService-HTTPDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.g.c
    public void a() {
        b();
    }

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x0080: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r0 I:??[OBJECT, ARRAY]), block:B:22:0x007f */
    protected void b() {
        Throwable th;
        Closeable closeable;
        InputStream inputStream;
        Closeable closeable2;
        try {
            try {
                com.baidu.android.pushservice.e.a a2 = com.baidu.android.pushservice.e.b.a(this.f1273a, "https://httpsdns.baidu.com/?dn=" + this.c, "GET", (HashMap<String, String>) null);
                int b2 = a2.b();
                inputStream = a2.a();
                try {
                    if (b2 == 200) {
                        String a3 = com.baidu.android.pushservice.i.m.a(this.f1273a, inputStream);
                        this.f1274b.a(0, TextUtils.isEmpty(a3) ? null : a3.split(" "));
                    } else {
                        com.baidu.android.pushservice.i.m.a(this.f1273a, inputStream);
                        this.f1274b.a(-1, null);
                    }
                    com.baidu.android.pushservice.e.b.a(this.f1273a, inputStream);
                } catch (Exception e) {
                    this.f1274b.a(-1, null);
                    com.baidu.android.pushservice.e.b.a(this.f1273a, inputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = closeable2;
                com.baidu.android.pushservice.e.b.a(this.f1273a, closeable);
                throw th;
            }
        } catch (Exception e2) {
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            com.baidu.android.pushservice.e.b.a(this.f1273a, closeable);
            throw th;
        }
    }
}
