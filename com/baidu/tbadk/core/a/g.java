package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Se;
    private final /* synthetic */ View Sf;
    final /* synthetic */ f Sg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Sg = fVar;
        this.Sf = view;
        this.Se = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Sf.setVisibility(4);
        this.Se.reload();
    }
}
