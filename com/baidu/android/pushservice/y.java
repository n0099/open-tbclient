package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static y f765a;
    private String b;
    private String c;
    private Thread d = null;
    private boolean e = false;

    private y() {
        this.b = null;
        this.c = null;
        this.c = PushSettings.b();
        this.b = PushSettings.a();
    }

    public static synchronized y a() {
        y yVar;
        synchronized (y.class) {
            if (f765a == null) {
                f765a = new y();
            }
            yVar = f765a;
        }
        return yVar;
    }

    public void a(Context context, boolean z) {
        if (this.d == null || !this.d.isAlive()) {
            com.baidu.android.pushservice.a.y yVar = new com.baidu.android.pushservice.a.y(context);
            if (!z) {
                yVar.a(0);
            }
            this.d = new Thread(yVar);
            this.d.start();
        }
    }

    public synchronized void a(String str, String str2) {
        this.b = str;
        this.c = str2;
        PushSettings.a(str);
        PushSettings.c(str2);
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) ? false : true;
    }
}
