package com.baidu.adp.base;

import android.view.View;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g ck;
    private View mView;

    public h(g gVar, View view) {
        this.ck = gVar;
        this.mView = null;
        this.mView = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.ck.mContext != null && this.ck.mContext.getPageActivity() != null && !this.ck.mContext.getPageActivity().isFinishing()) {
            this.ck.ShowSoftKeyPad(this.mView);
        }
    }
}
