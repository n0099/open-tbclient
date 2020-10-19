package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class l {
    protected final WebView evT;
    protected final b evU;

    public abstract void a(m mVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public l(WebView webView, b bVar) {
        this.evT = webView;
        this.evU = bVar;
    }

    public final Context getContext() {
        return this.evT.getContext();
    }

    public final void a(n nVar) {
        a(nVar.beP(), nVar);
    }
}
