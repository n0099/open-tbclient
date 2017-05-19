package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ TbWebViewActivity QF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.QF = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.QF.mWebView != null) {
                this.QF.mWebView.destroy();
                this.QF.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
