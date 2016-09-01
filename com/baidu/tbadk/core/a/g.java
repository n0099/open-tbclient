package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Ou;
    private final /* synthetic */ View Ov;
    final /* synthetic */ f Ow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Ow = fVar;
        this.Ov = view;
        this.Ou = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ov.setVisibility(4);
        this.Ou.reload();
    }
}
