package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Oy;
    private final /* synthetic */ View Oz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Oy = sapiWebView;
        this.Oz = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Oy.post(new g(this, this.Oz, this.Oy));
    }
}
