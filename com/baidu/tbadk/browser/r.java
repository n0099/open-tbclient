package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q NA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.NA = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.NA.Nt;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.NA.Nt;
            baseWebViewActivity2.finish();
        }
    }
}
