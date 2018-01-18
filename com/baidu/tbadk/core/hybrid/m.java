package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class m {
    protected final WebView aRK;
    protected final b aRL;

    public abstract void a(n nVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public m(WebView webView, b bVar) {
        this.aRK = webView;
        this.aRL = bVar;
    }

    public final Context getContext() {
        return this.aRK.getContext();
    }

    public final void a(o oVar) {
        a(oVar.vJ(), oVar);
    }
}
