package com.baidu.adp.widget;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends DataSetObserver {
    final /* synthetic */ PinnedHeaderListView xU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PinnedHeaderListView pinnedHeaderListView) {
        this.xU = pinnedHeaderListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.xU.requestLayout();
        this.xU.invalidate();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.xU.xO = -1;
        this.xU.requestLayout();
        this.xU.invalidate();
    }
}
