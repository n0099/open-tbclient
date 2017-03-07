package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView SJ;
    private final /* synthetic */ View SK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.SJ = sapiWebView;
        this.SK = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.SJ.post(new g(this, this.SK, this.SJ));
    }
}
