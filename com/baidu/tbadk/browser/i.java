package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity Bg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbWebViewActivity tbWebViewActivity) {
        this.Bg = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Bg.mWebView != null && this.Bg.mWebView.canGoBack()) {
            this.Bg.mWebView.goBack();
        }
    }
}
