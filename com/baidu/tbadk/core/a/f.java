package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView TT;
    private final /* synthetic */ View TU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.TT = sapiWebView;
        this.TU = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.TT.post(new g(this, this.TU, this.TT));
    }
}
