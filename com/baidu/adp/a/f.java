package com.baidu.adp.a;

import android.app.Activity;
import android.view.View;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e a;
    private View b;

    public f(e eVar, View view) {
        this.a = eVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.b != null && (this.a.b instanceof Activity) && !((Activity) this.a.b).isFinishing()) {
            this.a.b(this.b);
        }
    }
}
