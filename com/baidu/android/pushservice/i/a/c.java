package com.baidu.android.pushservice.i.a;

import android.content.Context;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.j.g;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f3323a;

    public static void a(final Context context) {
        if (context != null && d.g(context) && g.a(context) && PushSettings.m(context)) {
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("upload_push_track", (short) 90) { // from class: com.baidu.android.pushservice.i.a.c.1
                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    c.b(context, false);
                }
            });
        }
    }

    public static /* synthetic */ int b() {
        int i = f3323a;
        f3323a = i + 1;
        return i;
    }

    public static void b(Context context, a aVar) {
        aVar.a();
        e.a(context).f();
        f3323a = 0;
    }

    public static void b(final Context context, final boolean z) {
        final a aVar = new a();
        byte[] b2 = z ? aVar.b(context) : aVar.a(context);
        if (b2 == null || b2.length >= 307200) {
            b(context, aVar);
        } else {
            com.baidu.android.pushservice.i.b.a(context).a(null, b2, "", new com.baidu.android.pushservice.i.c() { // from class: com.baidu.android.pushservice.i.a.c.2
                @Override // com.baidu.android.pushservice.i.c
                public void a(int i, String str) {
                    if (z) {
                        return;
                    }
                    PushSettings.l(context);
                    if (i == 0) {
                        c.b(context, aVar);
                        int unused = c.f3323a = 0;
                        return;
                    }
                    int i2 = 1;
                    if (c.f3323a < 1) {
                        c.b(context, false);
                        c.b();
                        return;
                    }
                    int unused2 = c.f3323a = 0;
                    int n = PushSettings.n(context);
                    if (n >= 3) {
                        c.b(context, aVar);
                    } else {
                        i2 = 1 + n;
                    }
                    PushSettings.b(context, i2);
                }
            });
        }
    }
}
