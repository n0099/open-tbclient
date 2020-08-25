package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes2.dex */
public abstract class l {
    protected final WebView ehs;
    protected final b eht;

    public abstract void a(m mVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public l(WebView webView, b bVar) {
        this.ehs = webView;
        this.eht = bVar;
    }

    public final Context getContext() {
        return this.ehs.getContext();
    }

    public final void a(n nVar) {
        a(nVar.bbn(), nVar);
    }
}
