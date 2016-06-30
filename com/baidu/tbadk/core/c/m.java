package com.baidu.tbadk.core.c;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class m {
    protected final WebView TZ;
    protected final a Ua;

    public abstract void a(n nVar);

    public abstract void a(String str, c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public m(WebView webView, a aVar) {
        this.TZ = webView;
        this.Ua = aVar;
    }

    public final Context getContext() {
        return this.TZ.getContext();
    }

    public final void a(o oVar) {
        a(oVar.ne(), oVar);
    }
}
