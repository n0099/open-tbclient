package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ TbWebViewActivity LR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbWebViewActivity tbWebViewActivity) {
        this.LR = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.LR.mWebView != null) {
                this.LR.mWebView.destroy();
                this.LR.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
