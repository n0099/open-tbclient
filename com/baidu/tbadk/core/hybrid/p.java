package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class p {
    protected final WebView aeb;
    protected final b aec;

    public abstract void a(q qVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public p(WebView webView, b bVar) {
        this.aeb = webView;
        this.aec = bVar;
    }

    public final Context getContext() {
        return this.aeb.getContext();
    }

    public final void a(t tVar) {
        a(tVar.oh(), tVar);
    }
}
