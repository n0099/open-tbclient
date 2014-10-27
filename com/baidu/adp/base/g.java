package com.baidu.adp.base;

import android.app.Activity;
import android.view.View;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f az;
    private View mView;

    public g(f fVar, View view) {
        this.az = fVar;
        this.mView = null;
        this.mView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.az.mContext != null && (this.az.mContext instanceof Activity) && !((Activity) this.az.mContext).isFinishing()) {
            this.az.ShowSoftKeyPad(this.mView);
        }
    }
}
