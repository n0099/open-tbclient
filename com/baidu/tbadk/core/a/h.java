package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private final /* synthetic */ SapiWebView OE;
    private final /* synthetic */ View OF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SapiWebView sapiWebView, View view) {
        this.OE = sapiWebView;
        this.OF = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.OE.post(new i(this, this.OF, this.OE));
    }
}
