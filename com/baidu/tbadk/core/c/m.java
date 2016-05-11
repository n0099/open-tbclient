package com.baidu.tbadk.core.c;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class m {
    protected final WebView TH;
    protected final a TI;

    public abstract void a(n nVar);

    public abstract void a(String str, c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public m(WebView webView, a aVar) {
        this.TH = webView;
        this.TI = aVar;
    }

    public final Context getContext() {
        return this.TH.getContext();
    }

    public final void a(o oVar) {
        a(oVar.nj(), oVar);
    }
}
