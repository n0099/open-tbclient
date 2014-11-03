package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ WebTbActivity xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WebTbActivity webTbActivity) {
        this.xR = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.xR.xG.canGoForward()) {
            this.xR.xG.goForward();
        }
    }
}
