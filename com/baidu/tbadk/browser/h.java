package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity Bj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbWebViewActivity tbWebViewActivity) {
        this.Bj = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Bj.showPopMenu();
    }
}
