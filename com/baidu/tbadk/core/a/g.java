package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Ux;
    private final /* synthetic */ View Uy;
    final /* synthetic */ f Uz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Uz = fVar;
        this.Uy = view;
        this.Ux = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Uy.setVisibility(4);
        this.Ux.reload();
    }
}
