package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView TE;
    private final /* synthetic */ View TF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.TE = sapiWebView;
        this.TF = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.TE.post(new g(this, this.TF, this.TE));
    }
}
