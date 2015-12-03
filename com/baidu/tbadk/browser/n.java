package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TbWebViewActivity Su;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.Su = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Su.mWebView != null) {
                this.Su.mWebView.destroy();
                this.Su.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
