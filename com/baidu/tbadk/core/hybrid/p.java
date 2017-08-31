package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class p {
    protected final WebView adi;
    protected final b adj;

    public abstract void a(q qVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public p(WebView webView, b bVar) {
        this.adi = webView;
        this.adj = bVar;
    }

    public final Context getContext() {
        return this.adi.getContext();
    }

    public final void a(t tVar) {
        a(tVar.oc(), tVar);
    }
}
