package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView TF;
    private final /* synthetic */ View TG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.TF = sapiWebView;
        this.TG = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.TF.post(new g(this, this.TG, this.TF));
    }
}
