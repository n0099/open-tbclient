package com.baidu.tbadk.browser;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ WebTbActivity xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(WebTbActivity webTbActivity) {
        this.xR = webTbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.xR.url);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            try {
                this.xR.xG.loadUrl(guessUrl);
            } catch (Exception e) {
            }
        }
    }
}
