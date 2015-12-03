package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView TX;
    private final /* synthetic */ View TY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.TX = sapiWebView;
        this.TY = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.TX.post(new g(this, this.TY, this.TX));
    }
}
