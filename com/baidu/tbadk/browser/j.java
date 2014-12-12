package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity Bj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbWebViewActivity tbWebViewActivity) {
        this.Bj = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Bj.refresh();
    }
}
