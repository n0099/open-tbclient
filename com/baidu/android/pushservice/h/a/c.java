package com.baidu.android.pushservice.h.a;

import android.content.Context;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.b.d;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.i.g;
/* loaded from: classes10.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f1133a = 0;

    public static void a(final Context context) {
        if (context != null && d.g(context) && g.a(context) && PushSettings.l(context)) {
            com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("upload_push_track", (short) 90) { // from class: com.baidu.android.pushservice.h.a.c.1
                @Override // com.baidu.android.pushservice.g.c
                public void a() {
                    c.b(context, false);
                }
            });
        }
    }

    static /* synthetic */ int b() {
        int i = f1133a;
        f1133a = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, a aVar) {
        aVar.a();
        e.a(context).f();
        f1133a = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final boolean z) {
        final a aVar = new a();
        byte[] b = z ? aVar.b(context) : aVar.a(context);
        if (b == null || b.length >= 307200) {
            b(context, aVar);
        } else {
            com.baidu.android.pushservice.h.b.a(context).a(null, b, "", new com.baidu.android.pushservice.h.c() { // from class: com.baidu.android.pushservice.h.a.c.2
                @Override // com.baidu.android.pushservice.h.c
                public void a(int i, String str) {
                    int i2 = 1;
                    if (z) {
                        return;
                    }
                    PushSettings.k(context);
                    if (i == 0) {
                        c.b(context, aVar);
                        int unused = c.f1133a = 0;
                    } else if (c.f1133a < 1) {
                        c.b(context, false);
                        c.b();
                    } else {
                        int unused2 = c.f1133a = 0;
                        int m = PushSettings.m(context);
                        if (m >= 3) {
                            c.b(context, aVar);
                        } else {
                            i2 = m + 1;
                        }
                        PushSettings.b(context, i2);
                    }
                }
            });
        }
    }
}
