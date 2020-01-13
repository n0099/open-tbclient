package com.baidu.sapi2.utils;

import android.view.View;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ SapiWebView a;
    final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SapiWebView sapiWebView, View view) {
        this.a = sapiWebView;
        this.b = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.post(new i(this));
    }
}
