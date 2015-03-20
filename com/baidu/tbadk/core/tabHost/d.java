package com.baidu.tbadk.core.tabHost;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    private final int Tc;
    final /* synthetic */ FragmentTabWidget Td;

    private d(FragmentTabWidget fragmentTabWidget, int i) {
        this.Td = fragmentTabWidget;
        this.Tc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(FragmentTabWidget fragmentTabWidget, int i, d dVar) {
        this(fragmentTabWidget, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentTabWidget.a(this.Td).c(this.Tc, true);
    }
}
