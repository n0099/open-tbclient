package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class i implements Runnable {
    private final /* synthetic */ SapiWebView Pd;
    private final /* synthetic */ View Pe;
    final /* synthetic */ h Pf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, View view, SapiWebView sapiWebView) {
        this.Pf = hVar;
        this.Pe = view;
        this.Pd = sapiWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Pe.setVisibility(4);
        this.Pd.reload();
    }
}
