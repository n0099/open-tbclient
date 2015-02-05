package com.baidu.tbadk.browser;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ WebTbActivity Bv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(WebTbActivity webTbActivity) {
        this.Bv = webTbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.Bv.url);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            try {
                this.Bv.mWebView.loadUrl(guessUrl);
            } catch (Exception e) {
            }
        }
    }
}
