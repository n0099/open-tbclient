package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q Ny;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.Ny = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.Ny.Nr;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.Ny.Nr;
            baseWebViewActivity2.finish();
        }
    }
}
