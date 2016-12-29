package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Ou;
    private final /* synthetic */ View Ov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Ou = sapiWebView;
        this.Ov = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Ou.post(new g(this, this.Ov, this.Ou));
    }
}
