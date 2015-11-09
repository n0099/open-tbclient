package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView TG;
    private final /* synthetic */ View TH;
    final /* synthetic */ f TI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.TI = fVar;
        this.TH = view;
        this.TG = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.TH.setVisibility(4);
        this.TG.reload();
    }
}
