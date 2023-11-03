package com.baidu.android.pushservice.y;

import android.content.Context;
import com.baidu.android.pushservice.w.j;
import com.baidu.android.pushservice.w.k;
import com.baidu.android.pushservice.w.m.l;
import com.baidu.android.pushservice.y.e.i;
/* loaded from: classes.dex */
public class b {
    public static int b;
    public Context a;

    public b(Context context) {
        this.a = context;
    }

    public static void a(int i) {
        b = i;
    }

    public void a(i iVar) {
        k kVar = new k();
        try {
            kVar.a(iVar.a());
            kVar.c(iVar.h());
            kVar.e(iVar.g());
            kVar.d(b);
            j.a(this.a, kVar, iVar.e().toString("UTF-8"));
        } catch (Exception unused) {
        }
        byte[] byteArray = iVar.f().toByteArray();
        l a = l.a(kVar.q());
        if (a != l.MSG_TYPE_APP_PRIORITY && com.baidu.android.pushservice.m.d.a(this.a, kVar.g())) {
            String str = "Message ID(" + kVar.h() + ") received duplicated, ack success to server directly.";
            return;
        }
        com.baidu.android.pushservice.w.m.c a2 = new com.baidu.android.pushservice.w.m.k(this.a).a(a);
        int a3 = a2 != null ? a2.a(kVar, byteArray).a() : 2;
        if (a == l.MSG_TYPE_SINGLE_PRIVATE || a == l.MSG_TYPE_MULTI_PRIVATE || a == l.MSG_TYPE_PRIVATE_MESSAGE) {
            com.baidu.android.pushservice.m.d.a(this.a, kVar.a(), kVar.q(), kVar.g(), byteArray, kVar.k(), kVar.c(), a3, kVar.i());
        } else if (a != l.MSG_TYPE_APP_PRIORITY) {
            com.baidu.android.pushservice.m.d.a(this.a, kVar.a(), kVar.q(), kVar.g(), null, null, 0L, a3, kVar.i());
        }
    }
}
