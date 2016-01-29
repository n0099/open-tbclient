package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView TW;
    private final /* synthetic */ View TX;
    final /* synthetic */ f TY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.TY = fVar;
        this.TX = view;
        this.TW = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.TX.setVisibility(4);
        this.TW.reload();
    }
}
