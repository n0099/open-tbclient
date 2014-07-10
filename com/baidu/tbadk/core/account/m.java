package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ l a;
    private final /* synthetic */ View b;
    private final /* synthetic */ SapiWebView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, View view, SapiWebView sapiWebView) {
        this.a = lVar;
        this.b = view;
        this.c = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.setVisibility(4);
        this.c.reload();
    }
}
