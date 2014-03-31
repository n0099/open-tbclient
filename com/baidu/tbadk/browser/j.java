package com.baidu.tbadk.browser;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
final class j implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        baseWebView = this.a.f;
        if (baseWebView.canGoBack()) {
            baseWebView2 = this.a.f;
            baseWebView2.goBack();
        }
    }
}
