package com.baidu.android.pushservice.h;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f3074a;

    /* renamed from: b  reason: collision with root package name */
    public short f3075b;

    public c() {
        this.f3075b = (short) 99;
    }

    public c(String str, short s) {
        this.f3075b = (short) 99;
        this.f3074a = str;
        this.f3075b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f3075b = s;
    }

    public void c(String str) {
        this.f3074a = str;
    }

    public short d() {
        return this.f3075b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f3074a)) {
            Thread.currentThread().setName(this.f3074a);
        }
        a();
    }
}
