package com.baidu.android.pushservice.h;

import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f3130a;

    /* renamed from: b  reason: collision with root package name */
    public short f3131b;

    public c() {
        this.f3131b = (short) 99;
    }

    public c(String str, short s) {
        this.f3131b = (short) 99;
        this.f3130a = str;
        this.f3131b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f3131b = s;
    }

    public void c(String str) {
        this.f3130a = str;
    }

    public short d() {
        return this.f3131b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f3130a)) {
            Thread.currentThread().setName(this.f3130a);
        }
        a();
    }
}
