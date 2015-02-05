package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity Bg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbWebViewActivity tbWebViewActivity) {
        this.Bg = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Bg.showPopMenu();
    }
}
