package com.baidu.tbadk.core.c;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class n {
    protected final WebView XB;
    protected final b XC;

    public abstract void a(o oVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public n(WebView webView, b bVar) {
        this.XB = webView;
        this.XC = bVar;
    }

    public final Context getContext() {
        return this.XB.getContext();
    }

    public final void a(p pVar) {
        a(pVar.nT(), pVar);
    }
}
