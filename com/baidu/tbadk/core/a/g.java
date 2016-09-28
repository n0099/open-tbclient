package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Ov;
    private final /* synthetic */ View Ow;
    final /* synthetic */ f Ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Ox = fVar;
        this.Ow = view;
        this.Ov = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ow.setVisibility(4);
        this.Ov.reload();
    }
}
