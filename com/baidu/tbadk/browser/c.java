package com.baidu.tbadk.browser;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ BaseWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebViewActivity baseWebViewActivity) {
        this.this$0 = baseWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.jf()) {
            this.this$0.showToast(t.j.neterror);
            return;
        }
        this.this$0.mView.hideNoDataView();
        this.this$0.refresh();
    }
}
