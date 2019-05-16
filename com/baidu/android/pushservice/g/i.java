package com.baidu.android.pushservice.g;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class i {
    private static void a(Context context, com.baidu.android.pushservice.a.f fVar, h hVar, g gVar) {
        if (fVar != null) {
            gVar.b(fVar.c());
            gVar = com.baidu.android.pushservice.i.l.a(gVar, context, fVar.c());
            hVar.j = fVar.c();
        }
        try {
            m.a(context, hVar);
            m.a(context, gVar);
        } catch (Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, int i, byte[] bArr, int i2, int i3) {
        h hVar = new h();
        hVar.d = "010101";
        hVar.a = str2;
        hVar.e = System.currentTimeMillis();
        hVar.f = com.baidu.android.pushservice.g.a.b.b(context);
        hVar.b = new String(bArr).length();
        hVar.g = i2;
        hVar.c = i;
        hVar.h = str;
        g gVar = new g(str);
        com.baidu.android.pushservice.a.f d = com.baidu.android.pushservice.a.b.a(context).d(str);
        if (d != null) {
            gVar.b(d.c());
            if (!com.baidu.android.pushservice.i.l.D(context, d.c())) {
                gVar.c(g.b);
            } else if (com.baidu.android.pushservice.i.l.c()) {
                gVar.c(g.c);
            } else if (com.baidu.android.pushservice.i.l.a()) {
                gVar.c(g.d);
            } else if (com.baidu.android.pushservice.i.l.b()) {
                gVar.c(g.e);
            } else if (com.baidu.android.pushservice.i.l.d()) {
                gVar.c(g.f);
            } else {
                gVar.c(g.b);
            }
        } else {
            gVar.b("NP");
            gVar.c(i3);
        }
        a(context, d, hVar, gVar);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            h hVar = new h();
            String str4 = null;
            if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(str3)) {
                str4 = "010601";
            } else if ("com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(str3)) {
                str4 = "010602";
            } else if ("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(str3)) {
                str4 = "010603";
            }
            hVar.d = str4;
            hVar.a = str;
            hVar.e = System.currentTimeMillis();
            hVar.f = com.baidu.android.pushservice.g.a.b.b(context);
            hVar.c = com.baidu.android.pushservice.message.a.k.MSG_TYPE_PRIVATE_MESSAGE.a();
            hVar.h = str2;
            com.baidu.android.pushservice.a.f d = com.baidu.android.pushservice.a.b.a(context).d(str2);
            if (d != null) {
                a(context, d, hVar, new g(str2));
            }
        } catch (Exception e) {
        }
    }
}
