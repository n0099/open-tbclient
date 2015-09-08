package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TbWebViewActivity Sr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.Sr = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Sr.mWebView != null) {
                this.Sr.mWebView.destroy();
                this.Sr.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
