package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class k {
    private static void a(Context context, com.baidu.android.pushservice.b.f fVar, j jVar, i iVar) {
        if (fVar != null) {
            iVar.b(fVar.c());
            iVar = com.baidu.android.pushservice.j.m.a(iVar, context, fVar.c());
            jVar.j = fVar.c();
        }
        try {
            o.a(context, jVar);
            o.a(context, iVar);
        } catch (Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, int i, byte[] bArr, int i2, int i3) {
        j jVar = new j();
        jVar.d = "010101";
        jVar.a = str2;
        jVar.e = System.currentTimeMillis();
        jVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        jVar.b = new String(bArr).length();
        jVar.g = i2;
        jVar.c = i;
        jVar.h = str;
        i iVar = new i(str);
        com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(context).d(str);
        if (d != null) {
            iVar.b(d.c());
            if (!com.baidu.android.pushservice.j.m.D(context, d.c())) {
                iVar.c(i.b);
            } else if (com.baidu.android.pushservice.j.m.c()) {
                iVar.c(i.c);
            } else if (com.baidu.android.pushservice.j.m.a()) {
                iVar.c(i.d);
            } else if (com.baidu.android.pushservice.j.m.b()) {
                iVar.c(i.e);
            } else if (com.baidu.android.pushservice.j.m.d()) {
                iVar.c(i.f);
            } else {
                iVar.c(i.b);
            }
        } else {
            iVar.b("NP");
            iVar.c(i3);
        }
        a(context, d, jVar, iVar);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            j jVar = new j();
            String str4 = null;
            if ("com.baidu.android.pushservice.action.passthrough.notification.CLICK".equals(str3)) {
                str4 = "010601";
            } else if ("com.baidu.android.pushservice.action.passthrough.notification.DELETE".equals(str3)) {
                str4 = "010602";
            } else if ("com.baidu.android.pushservice.action.passthrough.notification.NOTIFIED".equals(str3)) {
                str4 = "010603";
            }
            jVar.d = str4;
            jVar.a = str;
            jVar.e = System.currentTimeMillis();
            jVar.f = com.baidu.android.pushservice.h.a.b.b(context);
            jVar.c = com.baidu.android.pushservice.message.a.l.MSG_TYPE_PRIVATE_MESSAGE.a();
            jVar.h = str2;
            com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(context).d(str2);
            if (d != null) {
                a(context, d, jVar, new i(str2));
            }
        } catch (Exception e) {
        }
    }

    public static void b(Context context, String str, String str2, int i, byte[] bArr, int i2, int i3) {
        j jVar = new j();
        jVar.d = "019901";
        jVar.a = str2;
        jVar.e = System.currentTimeMillis();
        jVar.f = com.baidu.android.pushservice.h.a.b.b(context);
        jVar.b = new String(bArr).length();
        jVar.g = i2;
        jVar.c = i;
        jVar.h = str;
        i iVar = new i(str);
        com.baidu.android.pushservice.b.f d = com.baidu.android.pushservice.b.b.a(context).d(str);
        if (d != null) {
            iVar.b(d.c());
            if (!com.baidu.android.pushservice.j.m.D(context, d.c())) {
                iVar.c(i.b);
            } else if (com.baidu.android.pushservice.j.m.c()) {
                iVar.c(i.c);
            } else if (com.baidu.android.pushservice.j.m.a()) {
                iVar.c(i.d);
            } else if (com.baidu.android.pushservice.j.m.b()) {
                iVar.c(i.e);
            } else if (com.baidu.android.pushservice.j.m.d()) {
                iVar.c(i.f);
            } else {
                iVar.c(i.b);
            }
        } else {
            iVar.b("NP");
            iVar.c(i3);
        }
        a(context, d, jVar, iVar);
    }
}
