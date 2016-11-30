package com.baidu.tbadk.core.c;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class n {
    protected final WebView Yh;
    protected final b Yi;

    public abstract void a(o oVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public n(WebView webView, b bVar) {
        this.Yh = webView;
        this.Yi = bVar;
    }

    public final Context getContext() {
        return this.Yh.getContext();
    }

    public final void a(p pVar) {
        a(pVar.nT(), pVar);
    }
}
