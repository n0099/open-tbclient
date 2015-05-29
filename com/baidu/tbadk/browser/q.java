package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p NS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.NS = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.NS.NK;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.NS.NK;
            baseWebViewActivity2.finish();
        }
    }
}
