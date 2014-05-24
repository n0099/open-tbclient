package com.baidu.adp.base;

import android.app.Activity;
import android.view.View;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ c a;
    private View b;

    public d(c cVar, View view) {
        this.a = cVar;
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
