package com.baidu.android.pushservice.h;

import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f3152a;

    /* renamed from: b  reason: collision with root package name */
    public short f3153b;

    public c() {
        this.f3153b = (short) 99;
    }

    public c(String str, short s) {
        this.f3153b = (short) 99;
        this.f3152a = str;
        this.f3153b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f3153b = s;
    }

    public void c(String str) {
        this.f3152a = str;
    }

    public short d() {
        return this.f3153b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f3152a)) {
            Thread.currentThread().setName(this.f3152a);
        }
        a();
    }
}
