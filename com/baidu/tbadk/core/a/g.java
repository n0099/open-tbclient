package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class g implements Runnable {
    private final /* synthetic */ SapiWebView Rs;
    private final /* synthetic */ View Rt;
    final /* synthetic */ f Ru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, View view, SapiWebView sapiWebView) {
        this.Ru = fVar;
        this.Rt = view;
        this.Rs = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Rt.setVisibility(4);
        this.Rs.reload();
    }
}
