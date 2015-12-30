package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TbWebViewActivity SS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.SS = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.SS.mWebView != null) {
                this.SS.mWebView.destroy();
                this.SS.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
