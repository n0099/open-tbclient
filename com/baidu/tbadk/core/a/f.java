package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Se;
    private final /* synthetic */ View Sf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Se = sapiWebView;
        this.Sf = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Se.post(new g(this, this.Sf, this.Se));
    }
}
