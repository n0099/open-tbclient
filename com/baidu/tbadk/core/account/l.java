package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ SapiWebView CZ;
    private final /* synthetic */ View Da;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SapiWebView sapiWebView, View view) {
        this.CZ = sapiWebView;
        this.Da = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.CZ.post(new m(this, this.Da, this.CZ));
    }
}
