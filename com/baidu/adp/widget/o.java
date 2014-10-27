package com.baidu.adp.widget;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends DataSetObserver {
    final /* synthetic */ PinnedHeaderListView vR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PinnedHeaderListView pinnedHeaderListView) {
        this.vR = pinnedHeaderListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.vR.requestLayout();
        this.vR.invalidate();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.vR.vL = -1;
        this.vR.requestLayout();
        this.vR.invalidate();
    }
}
