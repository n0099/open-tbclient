package com.baidu.tbadk.browser;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        BaseWebView baseWebView3;
        baseWebView = this.a.f;
        if (baseWebView != null) {
            baseWebView2 = this.a.f;
            if (baseWebView2.canGoBack()) {
                baseWebView3 = this.a.f;
                baseWebView3.goBack();
            }
        }
    }
}
