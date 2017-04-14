package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ TbWebViewActivity Rm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.Rm = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Rm.mWebView != null) {
                this.Rm.mWebView.destroy();
                this.Rm.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
