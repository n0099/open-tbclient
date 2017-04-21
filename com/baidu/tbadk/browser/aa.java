package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ z RJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.RJ = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.RJ.Rs;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.RJ.Rs;
            baseWebViewActivity2.finish();
        }
    }
}
