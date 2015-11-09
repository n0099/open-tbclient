package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o So;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.So = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.So.Sg;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.So.Sg;
            baseWebViewActivity2.finish();
        }
    }
}
