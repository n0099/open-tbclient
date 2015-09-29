package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView TE;
    private final /* synthetic */ View TF;
    final /* synthetic */ f TG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.TG = fVar;
        this.TF = view;
        this.TE = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.TF.setVisibility(4);
        this.TE.reload();
    }
}
