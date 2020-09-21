package com.baidu.android.pushservice.d;

import android.content.Context;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class j extends com.baidu.android.pushservice.g.c {
    private Context a;
    private a b;
    private String c;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String[] strArr);
    }

    public j(Context context, String str, a aVar) {
        this.a = context;
        this.c = str;
        this.b = aVar;
        c("PushService-PushService-HTTPDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.g.c
    public void a() {
        b();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.io.Closeable[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 0, insn: 0x007e: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r0 I:??[OBJECT, ARRAY]), block:B:21:0x007d */
    protected void b() {
        InputStream inputStream;
        String[] strArr;
        try {
            try {
                com.baidu.android.pushservice.e.a a2 = com.baidu.android.pushservice.e.b.a(this.a, "https://httpsdns.baidu.com/?dn=" + this.c, "GET", (HashMap<String, String>) null);
                int b = a2.b();
                inputStream = a2.a();
                try {
                    if (b == 200) {
                        String a3 = com.baidu.android.pushservice.i.m.a(this.a, inputStream);
                        this.b.a(0, TextUtils.isEmpty(a3) ? null : a3.split(" "));
                    } else {
                        com.baidu.android.pushservice.i.m.a(this.a, inputStream);
                        this.b.a(-1, null);
                    }
                    com.baidu.android.pushservice.e.b.a(this.a, inputStream);
                } catch (Exception e) {
                    this.b.a(-1, null);
                    com.baidu.android.pushservice.e.b.a(this.a, inputStream);
                }
            } catch (Throwable th) {
                r1 = strArr;
                th = th;
                com.baidu.android.pushservice.e.b.a(this.a, r1);
                throw th;
            }
        } catch (Exception e2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.android.pushservice.e.b.a(this.a, r1);
            throw th;
        }
    }
}
