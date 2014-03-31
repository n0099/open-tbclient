package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a();
    }
}
