package com.baidu.tbadk.core.tabHost;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* loaded from: classes.dex */
class b implements FragmentTabWidget.c {
    final /* synthetic */ FragmentTabHost aau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FragmentTabHost fragmentTabHost) {
        this.aau = fragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.c
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i4 != i2) {
            this.aau.cw(i2);
        }
    }
}
