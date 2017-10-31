package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class m {
    protected final WebView adh;
    protected final b adi;

    public abstract void a(n nVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public m(WebView webView, b bVar) {
        this.adh = webView;
        this.adi = bVar;
    }

    public final Context getContext() {
        return this.adh.getContext();
    }

    public final void a(o oVar) {
        a(oVar.oc(), oVar);
    }
}
