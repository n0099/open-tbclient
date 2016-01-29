package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ TbWebViewActivity Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbWebViewActivity tbWebViewActivity) {
        this.Sl = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Sl.mWebView != null) {
                this.Sl.mWebView.destroy();
                this.Sl.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
