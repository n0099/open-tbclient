package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Td;
    private final /* synthetic */ View Te;
    final /* synthetic */ f Tf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Tf = fVar;
        this.Te = view;
        this.Td = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Te.setVisibility(4);
        this.Td.reload();
    }
}
