package com.baidu.tbadk.browser;

import com.baidu.tbadk.browser.TbWebViewActivity;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ TbWebViewActivity.a Qv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TbWebViewActivity.a aVar) {
        this.Qv = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = TbWebViewActivity.this;
        tbWebViewActivity.mView.oj();
    }
}
