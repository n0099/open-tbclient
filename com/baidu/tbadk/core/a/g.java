package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Tb;
    private final /* synthetic */ View Tc;
    final /* synthetic */ f Td;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Td = fVar;
        this.Tc = view;
        this.Tb = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Tc.setVisibility(4);
        this.Tb.reload();
    }
}
