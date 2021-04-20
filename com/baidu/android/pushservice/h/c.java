package com.baidu.android.pushservice.h;

import android.text.TextUtils;
/* loaded from: classes.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f3110a;

    /* renamed from: b  reason: collision with root package name */
    public short f3111b;

    public c() {
        this.f3111b = (short) 99;
    }

    public c(String str, short s) {
        this.f3111b = (short) 99;
        this.f3110a = str;
        this.f3111b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f3111b = s;
    }

    public void c(String str) {
        this.f3110a = str;
    }

    public short d() {
        return this.f3111b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f3110a)) {
            Thread.currentThread().setName(this.f3110a);
        }
        a();
    }
}
