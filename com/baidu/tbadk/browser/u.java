package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ TbWebViewActivity MG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbWebViewActivity tbWebViewActivity) {
        this.MG = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.MG.mWebView != null) {
                this.MG.mWebView.destroy();
                this.MG.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
