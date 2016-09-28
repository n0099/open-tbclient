package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ TbWebViewActivity MH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.MH = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.MH.mWebView != null) {
                this.MH.mWebView.destroy();
                this.MH.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
