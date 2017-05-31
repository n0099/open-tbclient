package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Sj;
    private final /* synthetic */ View Sk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Sj = sapiWebView;
        this.Sk = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Sj.post(new g(this, this.Sk, this.Sj));
    }
}
