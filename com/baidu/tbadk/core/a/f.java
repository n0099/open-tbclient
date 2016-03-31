package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Rs;
    private final /* synthetic */ View Rt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Rs = sapiWebView;
        this.Rt = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Rs.post(new g(this, this.Rt, this.Rs));
    }
}
