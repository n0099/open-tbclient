package com.baidu.tbadk.core.tabHost;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final int TN;
    final /* synthetic */ FragmentTabWidget TO;

    private d(FragmentTabWidget fragmentTabWidget, int i) {
        this.TO = fragmentTabWidget;
        this.TN = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(FragmentTabWidget fragmentTabWidget, int i, d dVar) {
        this(fragmentTabWidget, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentTabWidget.a(this.TO).c(this.TN, true);
    }
}
