package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ WebTbActivity xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WebTbActivity webTbActivity) {
        this.xR = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.xR.xG.canGoBack()) {
            this.xR.xG.goBack();
        }
    }
}
