package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Ux;
    private final /* synthetic */ View Uy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Ux = sapiWebView;
        this.Uy = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Ux.post(new g(this, this.Uy, this.Ux));
    }
}
