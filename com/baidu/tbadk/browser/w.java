package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v PW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.PW = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.PW.PK;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.PW.PK;
            baseWebViewActivity2.finish();
        }
    }
}
