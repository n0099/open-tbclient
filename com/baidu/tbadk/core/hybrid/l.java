package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class l {
    protected final WebView dRu;
    protected final b dRv;

    public abstract void a(m mVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public l(WebView webView, b bVar) {
        this.dRu = webView;
        this.dRv = bVar;
    }

    public final Context getContext() {
        return this.dRu.getContext();
    }

    public final void a(n nVar) {
        a(nVar.aPb(), nVar);
    }
}
