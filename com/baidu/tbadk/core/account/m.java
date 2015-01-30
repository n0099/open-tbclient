package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ SapiWebView Db;
    private final /* synthetic */ View Dc;
    final /* synthetic */ l Dd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, View view, SapiWebView sapiWebView) {
        this.Dd = lVar;
        this.Dc = view;
        this.Db = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Dc.setVisibility(4);
        this.Db.reload();
    }
}
