package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class i implements Runnable {
    private final /* synthetic */ SapiWebView OG;
    private final /* synthetic */ View OH;
    final /* synthetic */ h OI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, View view, SapiWebView sapiWebView) {
        this.OI = hVar;
        this.OH = view;
        this.OG = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.OH.setVisibility(4);
        this.OG.reload();
    }
}
