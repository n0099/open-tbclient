package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o SA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.SA = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.SA.Ss;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.SA.Ss;
            baseWebViewActivity2.finish();
        }
    }
}
