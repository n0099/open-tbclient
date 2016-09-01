package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ TbWebViewActivity MI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.MI = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.MI.mWebView != null) {
                this.MI.mWebView.destroy();
                this.MI.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
