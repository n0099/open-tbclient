package com.baidu.adp.base;

import android.app.Activity;
import android.view.View;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f a;
    private View b;

    public g(f fVar, View view) {
        this.a = fVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.mContext != null && (this.a.mContext instanceof Activity) && !((Activity) this.a.mContext).isFinishing()) {
            this.a.ShowSoftKeyPad(this.b);
        }
    }
}
