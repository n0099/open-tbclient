package com.baidu.tbadk.browser;

import com.baidu.tbadk.browser.TbWebViewActivity;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ TbWebViewActivity.a MJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbWebViewActivity.a aVar) {
        this.MJ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = TbWebViewActivity.this;
        tbWebViewActivity.mView.of();
    }
}
