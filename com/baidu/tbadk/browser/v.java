package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ TbWebViewActivity Kw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.Kw = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Kw.mWebView != null) {
                this.Kw.mWebView.destroy();
                this.Kw.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
