package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TbWebViewActivity Se;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.Se = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Se.mWebView != null) {
                this.Se.mWebView.destroy();
                this.Se.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
