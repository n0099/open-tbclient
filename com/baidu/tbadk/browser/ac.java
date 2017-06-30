package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ ab QH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.QH = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.QH.Qq;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.QH.Qq;
            baseWebViewActivity2.finish();
        }
    }
}
