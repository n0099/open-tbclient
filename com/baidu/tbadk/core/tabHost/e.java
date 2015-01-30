package com.baidu.tbadk.core.tabHost;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final int Hd;
    final /* synthetic */ FragmentTabWidget He;

    private e(FragmentTabWidget fragmentTabWidget, int i) {
        this.He = fragmentTabWidget;
        this.Hd = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(FragmentTabWidget fragmentTabWidget, int i, e eVar) {
        this(fragmentTabWidget, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentTabWidget.a(this.He).c(this.Hd, true);
    }
}
