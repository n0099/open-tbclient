package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView TT;
    private final /* synthetic */ View TU;
    final /* synthetic */ f TV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.TV = fVar;
        this.TU = view;
        this.TT = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.TU.setVisibility(4);
        this.TT.reload();
    }
}
