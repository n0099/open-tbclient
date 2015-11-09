package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView TG;
    private final /* synthetic */ View TH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.TG = sapiWebView;
        this.TH = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.TG.post(new g(this, this.TH, this.TG));
    }
}
