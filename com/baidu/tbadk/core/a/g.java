package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView TS;
    private final /* synthetic */ View TT;
    final /* synthetic */ f TU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.TU = fVar;
        this.TT = view;
        this.TS = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.TT.setVisibility(4);
        this.TS.reload();
    }
}
