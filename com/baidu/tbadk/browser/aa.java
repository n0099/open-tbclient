package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ z Rb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.Rb = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.Rb.QJ;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.Rb.QJ;
            baseWebViewActivity2.finish();
        }
    }
}
