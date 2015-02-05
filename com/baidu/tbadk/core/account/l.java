package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ SapiWebView CY;
    private final /* synthetic */ View CZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SapiWebView sapiWebView, View view) {
        this.CY = sapiWebView;
        this.CZ = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.CY.post(new m(this, this.CZ, this.CY));
    }
}
