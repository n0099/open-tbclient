package com.baidu.tbadk.browser;

import com.baidu.tbadk.browser.TbWebViewActivity;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ TbWebViewActivity.a Qp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TbWebViewActivity.a aVar) {
        this.Qp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = TbWebViewActivity.this;
        tbWebViewActivity.mView.of();
    }
}
