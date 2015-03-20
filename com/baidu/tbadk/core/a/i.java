package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class i implements Runnable {
    private final /* synthetic */ SapiWebView OE;
    private final /* synthetic */ View OF;
    final /* synthetic */ h OG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, View view, SapiWebView sapiWebView) {
        this.OG = hVar;
        this.OF = view;
        this.OE = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.OF.setVisibility(4);
        this.OE.reload();
    }
}
