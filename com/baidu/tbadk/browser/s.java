package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ WebTbActivity By;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(WebTbActivity webTbActivity) {
        this.By = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.By.mWebView.canGoBack()) {
            this.By.mWebView.goBack();
        }
    }
}
