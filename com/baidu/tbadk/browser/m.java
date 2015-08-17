package com.baidu.tbadk.browser;

import java.util.TimerTask;
/* loaded from: classes.dex */
class m extends TimerTask {
    final /* synthetic */ TbWebViewActivity Su;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbWebViewActivity tbWebViewActivity) {
        this.Su = tbWebViewActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.Su.mWebView != null) {
            this.Su.mWebView.destroy();
            this.Su.mWebView = null;
        }
    }
}
