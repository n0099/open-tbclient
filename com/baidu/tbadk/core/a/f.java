package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Mg;
    private final /* synthetic */ View Mh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Mg = sapiWebView;
        this.Mh = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Mg.post(new g(this, this.Mh, this.Mg));
    }
}
