package com.baidu.android.pushservice.g;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f1313a;

    /* renamed from: b  reason: collision with root package name */
    private short f1314b;

    public c() {
        this.f1314b = (short) 99;
    }

    public c(String str, short s) {
        this.f1314b = (short) 99;
        this.f1313a = str;
        this.f1314b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f1314b = s;
    }

    public void c(String str) {
        this.f1313a = str;
    }

    public short d() {
        return this.f1314b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f1313a)) {
            Thread.currentThread().setName(this.f1313a);
        }
        a();
    }
}
