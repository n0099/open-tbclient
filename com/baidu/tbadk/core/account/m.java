package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ SapiWebView yZ;
    private final /* synthetic */ View za;
    final /* synthetic */ l zb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, View view, SapiWebView sapiWebView) {
        this.zb = lVar;
        this.za = view;
        this.yZ = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.za.setVisibility(4);
        this.yZ.reload();
    }
}
