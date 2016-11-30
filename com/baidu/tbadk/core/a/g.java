package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f OA;
    private final /* synthetic */ SapiWebView Oy;
    private final /* synthetic */ View Oz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.OA = fVar;
        this.Oz = view;
        this.Oy = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Oz.setVisibility(4);
        this.Oy.reload();
    }
}
