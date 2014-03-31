package com.baidu.adp.a;

import android.app.Activity;
import android.view.View;
/* loaded from: classes.dex */
final class g implements Runnable {
    final /* synthetic */ f a;
    private View b;

    public g(f fVar, View view) {
        this.a = fVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.b != null && (this.a.b instanceof Activity) && !((Activity) this.a.b).isFinishing()) {
            this.a.b(this.b);
        }
    }
}
