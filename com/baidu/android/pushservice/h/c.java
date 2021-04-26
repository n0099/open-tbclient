package com.baidu.android.pushservice.h;

import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f3129a;

    /* renamed from: b  reason: collision with root package name */
    public short f3130b;

    public c() {
        this.f3130b = (short) 99;
    }

    public c(String str, short s) {
        this.f3130b = (short) 99;
        this.f3129a = str;
        this.f3130b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f3130b = s;
    }

    public void c(String str) {
        this.f3129a = str;
    }

    public short d() {
        return this.f3130b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f3129a)) {
            Thread.currentThread().setName(this.f3129a);
        }
        a();
    }
}
