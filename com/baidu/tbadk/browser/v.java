package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ TbWebViewActivity Qs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.Qs = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Qs.mWebView != null) {
                this.Qs.mWebView.destroy();
                this.Qs.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
