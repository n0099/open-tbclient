package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TbWebViewActivity Sd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.Sd = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Sd.mWebView != null) {
                this.Sd.mWebView.destroy();
                this.Sd.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
