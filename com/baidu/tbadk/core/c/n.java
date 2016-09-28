package com.baidu.tbadk.core.c;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class n {
    protected final WebView XJ;
    protected final b XK;

    public abstract void a(o oVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public n(WebView webView, b bVar) {
        this.XJ = webView;
        this.XK = bVar;
    }

    public final Context getContext() {
        return this.XJ.getContext();
    }

    public final void a(p pVar) {
        a(pVar.nP(), pVar);
    }
}
