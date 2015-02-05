package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ WebTbActivity Bv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WebTbActivity webTbActivity) {
        this.Bv = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Bv.closeActivity();
    }
}
