package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ TbWebViewActivity ME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbWebViewActivity tbWebViewActivity) {
        this.ME = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.ME.mWebView != null) {
                this.ME.mWebView.destroy();
                this.ME.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
