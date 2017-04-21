package com.baidu.tbadk.browser;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ TbWebViewActivity Ro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.Ro = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.Ro.mWebView != null) {
                this.Ro.mWebView.destroy();
                this.Ro.mWebView = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
