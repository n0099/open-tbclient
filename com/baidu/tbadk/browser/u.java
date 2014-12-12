package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ WebTbActivity By;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WebTbActivity webTbActivity) {
        this.By = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.By.mWebView.reload();
        } catch (Exception e) {
        }
    }
}
