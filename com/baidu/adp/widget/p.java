package com.baidu.adp.widget;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends DataSetObserver {
    final /* synthetic */ PinnedHeaderListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PinnedHeaderListView pinnedHeaderListView) {
        this.a = pinnedHeaderListView;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.a.requestLayout();
        this.a.invalidate();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.a.h = -1;
        this.a.requestLayout();
        this.a.invalidate();
    }
}
