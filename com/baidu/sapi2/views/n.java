package com.baidu.sapi2.views;

import android.view.View;
/* loaded from: classes5.dex */
class n implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.dismiss();
    }
}
