package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ TbWebViewActivity Kx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.Kx = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Kx.mWebView != null) {
                this.Kx.mWebView.destroy();
                this.Kx.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
