package com.baidu.tbadk.core.tabHost;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    private final int Ha;
    final /* synthetic */ FragmentTabWidget Hb;

    private e(FragmentTabWidget fragmentTabWidget, int i) {
        this.Hb = fragmentTabWidget;
        this.Ha = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(FragmentTabWidget fragmentTabWidget, int i, e eVar) {
        this(fragmentTabWidget, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentTabWidget.a(this.Hb).c(this.Ha, true);
    }
}
