package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class s {
    protected final WebView aci;
    protected final b acj;

    public abstract void a(t tVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public s(WebView webView, b bVar) {
        this.aci = webView;
        this.acj = bVar;
    }

    public final Context getContext() {
        return this.aci.getContext();
    }

    public final void a(w wVar) {
        a(wVar.nT(), wVar);
    }
}
