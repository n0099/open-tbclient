package com.baidu.tbadk.browser;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String guessUrl = URLUtil.guessUrl(this.a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.a.a.loadUrl(guessUrl);
        }
    }
}
