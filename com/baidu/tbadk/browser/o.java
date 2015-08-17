package com.baidu.tbadk.browser;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n SD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.SD = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebViewActivity baseWebViewActivity;
        BaseWebViewActivity baseWebViewActivity2;
        baseWebViewActivity = this.SD.Sv;
        if (baseWebViewActivity != null) {
            baseWebViewActivity2 = this.SD.Sv;
            baseWebViewActivity2.finish();
        }
    }
}
