package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView NF;
    private final /* synthetic */ View NG;
    final /* synthetic */ f NH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.NH = fVar;
        this.NG = view;
        this.NF = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.NG.setVisibility(4);
        this.NF.reload();
    }
}
