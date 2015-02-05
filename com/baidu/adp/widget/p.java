package com.baidu.adp.widget;

import com.baidu.adp.widget.ListView.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ad {
    final /* synthetic */ PinnedHeaderListView xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PinnedHeaderListView pinnedHeaderListView) {
        this.xR = pinnedHeaderListView;
    }

    @Override // com.baidu.adp.widget.ListView.ad
    public void T(boolean z) {
        this.xR.xP = z;
    }
}
