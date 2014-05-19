package com.baidu.adp.base;

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
        if (this.a.mContext != null && (this.a.mContext instanceof Activity) && !((Activity) this.a.mContext).isFinishing()) {
            this.a.ShowSoftKeyPad(this.b);
        }
    }
}
