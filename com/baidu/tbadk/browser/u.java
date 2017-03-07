package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ TbWebViewActivity QU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbWebViewActivity tbWebViewActivity) {
        this.QU = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.QU.mWebView != null) {
                this.QU.mWebView.destroy();
                this.QU.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
