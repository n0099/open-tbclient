package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ SapiWebView CY;
    private final /* synthetic */ View CZ;
    final /* synthetic */ l Da;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, View view, SapiWebView sapiWebView) {
        this.Da = lVar;
        this.CZ = view;
        this.CY = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.CZ.setVisibility(4);
        this.CY.reload();
    }
}
