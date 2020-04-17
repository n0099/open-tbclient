package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class l {
    protected final WebView dwu;
    protected final b dwv;

    public abstract void a(m mVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public l(WebView webView, b bVar) {
        this.dwu = webView;
        this.dwv = bVar;
    }

    public final Context getContext() {
        return this.dwu.getContext();
    }

    public final void a(n nVar) {
        a(nVar.aHL(), nVar);
    }
}
