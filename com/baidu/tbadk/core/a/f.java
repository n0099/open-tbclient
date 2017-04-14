package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Tb;
    private final /* synthetic */ View Tc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Tb = sapiWebView;
        this.Tc = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Tb.post(new g(this, this.Tc, this.Tb));
    }
}
