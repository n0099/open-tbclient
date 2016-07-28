package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Mg;
    private final /* synthetic */ View Mh;
    final /* synthetic */ f Mi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Mi = fVar;
        this.Mh = view;
        this.Mg = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Mh.setVisibility(4);
        this.Mg.reload();
    }
}
