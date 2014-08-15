package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.a.canGoForward()) {
            this.a.a.goForward();
        }
    }
}
