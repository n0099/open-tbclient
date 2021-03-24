package com.alipay.sdk.util;

import android.app.Activity;
/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f2005a;

    public o(Activity activity) {
        this.f2005a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2005a.finish();
    }
}
