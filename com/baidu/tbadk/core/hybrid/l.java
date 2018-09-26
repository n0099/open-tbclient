package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class l {
    protected final WebView apm;
    protected final b apn;

    public abstract void a(m mVar);

    public abstract void a(String str, d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public l(WebView webView, b bVar) {
        this.apm = webView;
        this.apn = bVar;
    }

    public final Context getContext() {
        return this.apm.getContext();
    }

    public final void a(n nVar) {
        a(nVar.tt(), nVar);
    }
}
