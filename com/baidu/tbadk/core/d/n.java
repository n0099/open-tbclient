package com.baidu.tbadk.core.d;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class n {
    protected final WebView WQ;
    protected final b WR;

    public abstract void a(o oVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public n(WebView webView, b bVar) {
        this.WQ = webView;
        this.WR = bVar;
    }

    public final Context getContext() {
        return this.WQ.getContext();
    }

    public final void a(p pVar) {
        a(pVar.nN(), pVar);
    }
}
