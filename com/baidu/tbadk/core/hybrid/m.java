package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class m {
    protected final WebView aRN;
    protected final b aRO;

    public abstract void a(n nVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public m(WebView webView, b bVar) {
        this.aRN = webView;
        this.aRO = bVar;
    }

    public final Context getContext() {
        return this.aRN.getContext();
    }

    public final void a(o oVar) {
        a(oVar.vK(), oVar);
    }
}
