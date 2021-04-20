package com.alipay.sdk.app;

import android.app.Activity;
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1836a;

    public f(Activity activity) {
        this.f1836a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1836a.finish();
    }
}
