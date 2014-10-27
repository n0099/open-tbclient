package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ SapiWebView yZ;
    private final /* synthetic */ View za;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SapiWebView sapiWebView, View view) {
        this.yZ = sapiWebView;
        this.za = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.yZ.post(new m(this, this.za, this.yZ));
    }
}
