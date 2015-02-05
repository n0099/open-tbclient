package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ WebTbActivity Bv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(WebTbActivity webTbActivity) {
        this.Bv = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Bv.mWebView.canGoBack()) {
            this.Bv.mWebView.goBack();
        }
    }
}
