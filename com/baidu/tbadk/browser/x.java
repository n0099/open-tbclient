package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ WebTbActivity xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WebTbActivity webTbActivity) {
        this.xR = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.xR.xG.reload();
        } catch (Exception e) {
        }
    }
}
