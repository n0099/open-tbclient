package com.baidu.tbadk.browser;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ WebTbActivity By;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(WebTbActivity webTbActivity) {
        this.By = webTbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.By.url);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            try {
                this.By.mWebView.loadUrl(guessUrl);
            } catch (Exception e) {
            }
        }
    }
}
