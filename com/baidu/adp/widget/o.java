package com.baidu.adp.widget;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends DataSetObserver {
    final /* synthetic */ PinnedHeaderListView xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PinnedHeaderListView pinnedHeaderListView) {
        this.xR = pinnedHeaderListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.xR.requestLayout();
        this.xR.invalidate();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.xR.xL = -1;
        this.xR.requestLayout();
        this.xR.invalidate();
    }
}
