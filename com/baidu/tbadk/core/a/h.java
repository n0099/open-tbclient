package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Pd;
    private final /* synthetic */ View Pe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SapiWebView sapiWebView, View view) {
        this.Pd = sapiWebView;
        this.Pe = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Pd.post(new i(this, this.Pe, this.Pd));
    }
}
