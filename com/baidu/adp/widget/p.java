package com.baidu.adp.widget;

import com.baidu.adp.widget.ListView.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ad {
    final /* synthetic */ PinnedHeaderListView xU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PinnedHeaderListView pinnedHeaderListView) {
        this.xU = pinnedHeaderListView;
    }

    @Override // com.baidu.adp.widget.ListView.ad
    public void T(boolean z) {
        this.xU.xS = z;
    }
}
