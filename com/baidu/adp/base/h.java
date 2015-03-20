package com.baidu.adp.base;

import android.view.View;
/* loaded from: classes.dex */
class h implements Runnable {
    private View mView;
    final /* synthetic */ g nv;

    public h(g gVar, View view) {
        this.nv = gVar;
        this.mView = null;
        this.mView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.nv.mContext != null && this.nv.mContext.getPageActivity() != null && !this.nv.mContext.getPageActivity().isFinishing()) {
            this.nv.ShowSoftKeyPad(this.mView);
        }
    }
}
