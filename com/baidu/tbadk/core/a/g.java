package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView SJ;
    private final /* synthetic */ View SK;
    final /* synthetic */ f SL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.SL = fVar;
        this.SK = view;
        this.SJ = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.SK.setVisibility(4);
        this.SJ.reload();
    }
}
