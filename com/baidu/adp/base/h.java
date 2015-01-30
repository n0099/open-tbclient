package com.baidu.adp.base;

import android.view.View;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g cl;
    private View mView;

    public h(g gVar, View view) {
        this.cl = gVar;
        this.mView = null;
        this.mView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cl.mContext != null && this.cl.mContext.getPageActivity() != null && !this.cl.mContext.getPageActivity().isFinishing()) {
            this.cl.ShowSoftKeyPad(this.mView);
        }
    }
}
