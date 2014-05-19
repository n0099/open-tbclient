package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ SapiWebView a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SapiWebView sapiWebView, View view) {
        this.a = sapiWebView;
        this.b = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.post(new m(this, this.b, this.a));
    }
}
