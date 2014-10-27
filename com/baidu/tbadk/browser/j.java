package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity xA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbWebViewActivity tbWebViewActivity) {
        this.xA = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.xA.refresh();
    }
}
