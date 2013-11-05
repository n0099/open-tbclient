package com.baidu.adp.a;

import android.app.Activity;
import android.view.View;
/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f401a;
    private View b;

    public f(e eVar, View view) {
        this.f401a = eVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f401a.b != null && (this.f401a.b instanceof Activity) && !((Activity) this.f401a.b).isFinishing()) {
            this.f401a.b(this.b);
        }
    }
}
