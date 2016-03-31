package com.baidu.tbadk.core.c;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class m {
    protected final WebView Yt;
    protected final a Yu;

    public abstract void a(n nVar);

    public abstract void a(String str, c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public m(WebView webView, a aVar) {
        this.Yt = webView;
        this.Yu = aVar;
    }

    public final Context getContext() {
        return this.Yt.getContext();
    }

    public final void a(o oVar) {
        a(oVar.pT(), oVar);
    }
}
