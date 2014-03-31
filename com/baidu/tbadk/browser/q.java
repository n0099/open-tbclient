package com.baidu.tbadk.browser;

import android.webkit.URLUtil;
/* loaded from: classes.dex */
final class q implements Runnable {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String guessUrl = URLUtil.guessUrl(this.a.c);
        if (URLUtil.isNetworkUrl(guessUrl)) {
            this.a.a.loadUrl(guessUrl);
        }
    }
}
