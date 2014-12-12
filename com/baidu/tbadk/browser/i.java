package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity Bj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbWebViewActivity tbWebViewActivity) {
        this.Bj = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Bj.mWebView != null && this.Bj.mWebView.canGoBack()) {
            this.Bj.mWebView.goBack();
        }
    }
}
