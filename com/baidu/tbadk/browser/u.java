package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.a.canGoBack()) {
            this.a.a.goBack();
        }
    }
}
