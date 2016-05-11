package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Mi;
    private final /* synthetic */ View Mj;
    final /* synthetic */ f Mk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Mk = fVar;
        this.Mj = view;
        this.Mi = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Mj.setVisibility(4);
        this.Mi.reload();
    }
}
