package com.baidu.tbadk.browser;

import android.view.View;
/* loaded from: classes.dex */
final class v implements View.OnClickListener {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.closeActivity();
    }
}
