package com.baidu.android.pushservice.g;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public abstract class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f1306a;

    /* renamed from: b  reason: collision with root package name */
    private short f1307b;

    public c() {
        this.f1307b = (short) 99;
    }

    public c(String str, short s) {
        this.f1307b = (short) 99;
        this.f1306a = str;
        this.f1307b = s;
    }

    public abstract void a();

    public void a(short s) {
        this.f1307b = s;
    }

    public void c(String str) {
        this.f1306a = str;
    }

    public short d() {
        return this.f1307b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.f1306a)) {
            Thread.currentThread().setName(this.f1306a);
        }
        a();
    }
}
