package com.baidu.tbadk.core.a;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ SapiWebView Sw;
    private final /* synthetic */ View Sx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SapiWebView sapiWebView, View view) {
        this.Sw = sapiWebView;
        this.Sx = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Sw.post(new g(this, this.Sx, this.Sw));
    }
}
