package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y Rp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.Rp = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.Rp.QY;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.Rp.QY;
            baseWebViewActivity2.finish();
        }
    }
}
