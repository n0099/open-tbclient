package com.baidu.tbadk.core.d;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class n {
    protected final WebView abP;
    protected final b abQ;

    public abstract void a(o oVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public n(WebView webView, b bVar) {
        this.abP = webView;
        this.abQ = bVar;
    }

    public final Context getContext() {
        return this.abP.getContext();
    }

    public final void a(p pVar) {
        a(pVar.nX(), pVar);
    }
}
