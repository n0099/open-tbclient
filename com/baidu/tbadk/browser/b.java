package com.baidu.tbadk.browser;

import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BaseWebViewActivity Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseWebViewActivity baseWebViewActivity) {
        this.Sl = baseWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.iO()) {
            this.Sl.showToast(i.C0057i.neterror);
            return;
        }
        this.Sl.mView.hideNoDataView();
        this.Sl.refresh();
    }
}
