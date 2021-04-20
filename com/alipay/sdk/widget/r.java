package com.alipay.sdk.widget;

import android.view.View;
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2075a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f2076b;

    public r(q qVar, View view) {
        this.f2076b = qVar;
        this.f2075a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2075a.setEnabled(true);
    }
}
