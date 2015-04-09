package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private final /* synthetic */ SapiWebView OG;
    private final /* synthetic */ View OH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SapiWebView sapiWebView, View view) {
        this.OG = sapiWebView;
        this.OH = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.OG.post(new i(this, this.OH, this.OG));
    }
}
