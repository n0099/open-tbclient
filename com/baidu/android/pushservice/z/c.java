package com.baidu.android.pushservice.z;

import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class c implements Runnable {
    public String a;
    public short b;

    public c() {
        this.b = (short) 99;
    }

    public c(String str, short s) {
        this.b = (short) 99;
        this.a = str;
        this.b = s;
    }

    public abstract void a();

    public void a(String str) {
        this.a = str;
    }

    public void a(short s) {
        this.b = s;
    }

    public short b() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.a)) {
            Thread.currentThread().setName(this.a);
        }
        a();
    }
}
