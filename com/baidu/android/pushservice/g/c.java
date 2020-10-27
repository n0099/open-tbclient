package com.baidu.android.pushservice.g;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f1087a;
    private short b;

    public c() {
        this.b = (short) 99;
    }

    public c(String str, short s) {
        this.b = (short) 99;
        this.f1087a = str;
        this.b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.b = s;
    }

    public void c(String str) {
        this.f1087a = str;
    }

    public short d() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f1087a)) {
            Thread.currentThread().setName(this.f1087a);
        }
        a();
    }
}
