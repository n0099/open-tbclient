package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class l {
    protected final WebView bOr;
    protected final b bOs;

    public abstract void a(m mVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public l(WebView webView, b bVar) {
        this.bOr = webView;
        this.bOs = bVar;
    }

    public final Context getContext() {
        return this.bOr.getContext();
    }

    public final void a(n nVar) {
        a(nVar.aam(), nVar);
    }
}
