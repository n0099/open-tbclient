package com.baidu.tbadk.core.d;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class n {
    protected final WebView acu;
    protected final b acv;

    public abstract void a(o oVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public n(WebView webView, b bVar) {
        this.acu = webView;
        this.acv = bVar;
    }

    public final Context getContext() {
        return this.acu.getContext();
    }

    public final void a(p pVar) {
        a(pVar.oy(), pVar);
    }
}
