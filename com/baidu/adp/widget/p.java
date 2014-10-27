package com.baidu.adp.widget;

import com.baidu.adp.widget.ListView.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ac {
    final /* synthetic */ PinnedHeaderListView vR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PinnedHeaderListView pinnedHeaderListView) {
        this.vR = pinnedHeaderListView;
    }

    @Override // com.baidu.adp.widget.ListView.ac
    public void I(boolean z) {
        this.vR.vP = z;
    }
}
