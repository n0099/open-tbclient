package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class l {
    private static void a(Context context, com.baidu.android.pushservice.b.f fVar, k kVar, j jVar) {
        if (fVar != null) {
            jVar.b(fVar.c());
            jVar = com.baidu.android.pushservice.j.p.a(jVar, context, fVar.c());
            kVar.j = fVar.c();
        }
        try {
            q.a(context, kVar);
            q.a(context, jVar);
        } catch (Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, int i, byte[] bArr, int i2, int i3) {
        k kVar = new k();
        kVar.d = "010101";
        kVar.a = str2;
        kVar.e = System.currentTimeMillis();
        kVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        kVar.b = new String(bArr).length();
        kVar.g = i2;
        kVar.c = i;
        kVar.h = str;
        j jVar = new j(str);
        com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(context).d(str);
        if (d != null) {
            jVar.b(d.c());
            if (!com.baidu.android.pushservice.j.p.D(context, d.c())) {
                jVar.c(j.b);
            } else if (com.baidu.android.pushservice.j.p.c()) {
                jVar.c(j.c);
            } else if (com.baidu.android.pushservice.j.p.a()) {
                jVar.c(j.d);
            } else if (com.baidu.android.pushservice.j.p.b()) {
                jVar.c(j.e);
            } else {
                jVar.c(j.b);
            }
        } else {
            jVar.b("NP");
            jVar.c(i3);
        }
        a(context, d, kVar, jVar);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            k kVar = new k();
            String str4 = null;
            if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(str3)) {
                str4 = "010601";
            } else if ("com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(str3)) {
                str4 = "010602";
            } else if ("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(str3)) {
                str4 = "010603";
            }
            kVar.d = str4;
            kVar.a = str;
            kVar.e = System.currentTimeMillis();
            kVar.f = com.baidu.android.pushservice.h.a.b.b(context);
            kVar.c = com.baidu.android.pushservice.message.a.l.MSG_TYPE_PRIVATE_MESSAGE.a();
            kVar.h = str2;
            com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(context).d(str2);
            if (d != null) {
                a(context, d, kVar, new j(str2));
            }
        } catch (Exception e) {
        }
    }

    public static void b(Context context, String str, String str2, int i, byte[] bArr, int i2, int i3) {
        k kVar = new k();
        kVar.d = "019901";
        kVar.a = str2;
        kVar.e = System.currentTimeMillis();
        kVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        kVar.b = new String(bArr).length();
        kVar.g = i2;
        kVar.c = i;
        kVar.h = str;
        j jVar = new j(str);
        com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(context).d(str);
        if (d != null) {
            jVar.b(d.c());
            if (!com.baidu.android.pushservice.j.p.D(context, d.c())) {
                jVar.c(j.b);
            } else if (com.baidu.android.pushservice.j.p.c()) {
                jVar.c(j.c);
            } else if (com.baidu.android.pushservice.j.p.a()) {
                jVar.c(j.d);
            } else if (com.baidu.android.pushservice.j.p.b()) {
                jVar.c(j.e);
            } else {
                jVar.c(j.b);
            }
        } else {
            jVar.b("NP");
            jVar.c(i3);
        }
        a(context, d, kVar, jVar);
    }
}
