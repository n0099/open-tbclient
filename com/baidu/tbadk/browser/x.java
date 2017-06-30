package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ TbWebViewActivity Qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbWebViewActivity tbWebViewActivity) {
        this.Qm = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Qm.mWebView != null) {
                this.Qm.mWebView.destroy();
                this.Qm.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
