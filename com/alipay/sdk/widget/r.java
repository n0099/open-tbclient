package com.alipay.sdk.widget;

import android.view.View;
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2035a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f2036b;

    public r(q qVar, View view) {
        this.f2036b = qVar;
        this.f2035a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2035a.setEnabled(true);
    }
}
