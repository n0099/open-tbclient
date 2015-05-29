package com.baidu.tbadk.browser;

import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BaseWebViewActivity NB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseWebViewActivity baseWebViewActivity) {
        this.NB = baseWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.k.iX()) {
            this.NB.showToast(t.neterror);
            return;
        }
        this.NB.mView.hideNoDataView();
        this.NB.refresh();
    }
}
