package com.baidu.tbadk.core.c;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class n {
    protected final WebView UI;
    protected final b UJ;

    public abstract void a(o oVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public n(WebView webView, b bVar) {
        this.UI = webView;
        this.UJ = bVar;
    }

    public final Context getContext() {
        return this.UI.getContext();
    }

    public final void a(p pVar) {
        a(pVar.mU(), pVar);
    }
}
