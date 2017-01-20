package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView NF;
    private final /* synthetic */ View NG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.NF = sapiWebView;
        this.NG = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.NF.post(new g(this, this.NG, this.NF));
    }
}
