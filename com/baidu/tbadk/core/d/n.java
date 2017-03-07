package com.baidu.tbadk.core.d;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class n {
    protected final WebView ace;
    protected final b acf;

    public abstract void a(o oVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public n(WebView webView, b bVar) {
        this.ace = webView;
        this.acf = bVar;
    }

    public final Context getContext() {
        return this.ace.getContext();
    }

    public final void a(p pVar) {
        a(pVar.ob(), pVar);
    }
}
