package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView TW;
    private final /* synthetic */ View TX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.TW = sapiWebView;
        this.TX = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.TW.post(new g(this, this.TX, this.TW));
    }
}
