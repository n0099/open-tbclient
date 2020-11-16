package com.baidu.android.pushservice.g;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f1092a;
    private short b;

    public c() {
        this.b = (short) 99;
    }

    public c(String str, short s) {
        this.b = (short) 99;
        this.f1092a = str;
        this.b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.b = s;
    }

    public void c(String str) {
        this.f1092a = str;
    }

    public short d() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f1092a)) {
            Thread.currentThread().setName(this.f1092a);
        }
        a();
    }
}
