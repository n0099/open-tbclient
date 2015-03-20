package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BaseWebViewActivity Nl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseWebViewActivity baseWebViewActivity) {
        this.Nl = baseWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.Nl.mView.hideNoDataView();
        this.Nl.refresh();
    }
}
