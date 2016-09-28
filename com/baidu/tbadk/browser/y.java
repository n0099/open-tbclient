package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ x Na;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.Na = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.Na.MK;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.Na.MK;
            baseWebViewActivity2.finish();
        }
    }
}
