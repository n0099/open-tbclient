package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView TX;
    private final /* synthetic */ View TY;
    final /* synthetic */ f TZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.TZ = fVar;
        this.TY = view;
        this.TX = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.TY.setVisibility(4);
        this.TX.reload();
    }
}
