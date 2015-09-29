package com.baidu.tbadk.browser;

import android.view.View;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ BaseWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebViewActivity baseWebViewActivity) {
        this.this$0 = baseWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.iM()) {
            this.this$0.showToast(i.h.neterror);
            return;
        }
        this.this$0.mView.hideNoDataView();
        this.this$0.refresh();
    }
}
