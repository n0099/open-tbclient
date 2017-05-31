package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Sj;
    private final /* synthetic */ View Sk;
    final /* synthetic */ f Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Sl = fVar;
        this.Sk = view;
        this.Sj = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Sk.setVisibility(4);
        this.Sj.reload();
    }
}
