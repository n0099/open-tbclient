package com.baidu.tbadk.core.account;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Db;
    private final /* synthetic */ View Dc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SapiWebView sapiWebView, View view) {
        this.Db = sapiWebView;
        this.Dc = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Db.post(new m(this, this.Dc, this.Db));
    }
}
