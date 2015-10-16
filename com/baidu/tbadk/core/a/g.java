package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView TF;
    private final /* synthetic */ View TG;
    final /* synthetic */ f TH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.TH = fVar;
        this.TG = view;
        this.TF = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.TG.setVisibility(4);
        this.TF.reload();
    }
}
