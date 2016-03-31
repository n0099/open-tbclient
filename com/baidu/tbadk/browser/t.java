package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ TbWebViewActivity PH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(TbWebViewActivity tbWebViewActivity) {
        this.PH = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.PH.mWebView != null) {
                this.PH.mWebView.destroy();
                this.PH.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
