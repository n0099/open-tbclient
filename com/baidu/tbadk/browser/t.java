package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ WebTbActivity By;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(WebTbActivity webTbActivity) {
        this.By = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.By.mWebView.canGoForward()) {
            this.By.mWebView.goForward();
        }
    }
}
