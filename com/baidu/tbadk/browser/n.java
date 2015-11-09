package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TbWebViewActivity Sf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.Sf = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Sf.mWebView != null) {
                this.Sf.mWebView.destroy();
                this.Sf.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
