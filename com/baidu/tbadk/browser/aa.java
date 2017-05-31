package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ z QN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.QN = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.QN.Qw;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.QN.Qw;
            baseWebViewActivity2.finish();
        }
    }
}
