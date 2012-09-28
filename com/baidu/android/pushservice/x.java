package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class x {
    private static x a;
    private String b = null;
    private String c = null;
    private Thread d = null;

    private x() {
    }

    public static x a() {
        if (a == null) {
            a = new x();
        }
        return a;
    }

    public void a(Context context, boolean z) {
        if (this.d == null || !this.d.isAlive()) {
            com.baidu.android.pushservice.a.p pVar = new com.baidu.android.pushservice.a.p(context);
            if (!z) {
                pVar.a(0);
            }
            this.d = new Thread(pVar);
            this.d.start();
        }
    }

    public synchronized void a(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) ? false : true;
    }
}
