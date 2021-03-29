package com.baidu.android.pushservice.h;

import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f3075a;

    /* renamed from: b  reason: collision with root package name */
    public short f3076b;

    public c() {
        this.f3076b = (short) 99;
    }

    public c(String str, short s) {
        this.f3076b = (short) 99;
        this.f3075a = str;
        this.f3076b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f3076b = s;
    }

    public void c(String str) {
        this.f3075a = str;
    }

    public short d() {
        return this.f3076b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f3075a)) {
            Thread.currentThread().setName(this.f3075a);
        }
        a();
    }
}
