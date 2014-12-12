package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ SapiWebView CZ;
    private final /* synthetic */ View Da;
    final /* synthetic */ l Db;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, View view, SapiWebView sapiWebView) {
        this.Db = lVar;
        this.Da = view;
        this.CZ = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Da.setVisibility(4);
        this.CZ.reload();
    }
}
