package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Sw;
    private final /* synthetic */ View Sx;
    final /* synthetic */ f Sy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Sy = fVar;
        this.Sx = view;
        this.Sw = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Sx.setVisibility(4);
        this.Sw.reload();
    }
}
