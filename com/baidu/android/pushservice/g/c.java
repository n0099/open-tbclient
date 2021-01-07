package com.baidu.android.pushservice.g;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f1307a;

    /* renamed from: b  reason: collision with root package name */
    private short f1308b;

    public c() {
        this.f1308b = (short) 99;
    }

    public c(String str, short s) {
        this.f1308b = (short) 99;
        this.f1307a = str;
        this.f1308b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f1308b = s;
    }

    public void c(String str) {
        this.f1307a = str;
    }

    public short d() {
        return this.f1308b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f1307a)) {
            Thread.currentThread().setName(this.f1307a);
        }
        a();
    }
}
