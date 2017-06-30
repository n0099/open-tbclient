package com.baidu.android.pushservice.i;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements Runnable {
    private String a;
    private short b;

    public c() {
        this.b = (short) 99;
    }

    public c(String str, short s) {
        this.b = (short) 99;
        this.a = str;
        this.b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.b = s;
    }

    public void c(String str) {
        this.a = str;
    }

    public short d() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.a)) {
            Thread.currentThread().setName(this.a);
        }
        com.baidu.android.pushservice.g.a.c("PushRunnable", "running: " + this.a);
        a();
    }
}
