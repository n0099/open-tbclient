package com.baidu.adp.widget;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends DataSetObserver {
    final /* synthetic */ PinnedHeaderListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PinnedHeaderListView pinnedHeaderListView) {
        this.a = pinnedHeaderListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.a.requestLayout();
        this.a.invalidate();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.a.h = -1;
        this.a.requestLayout();
        this.a.invalidate();
    }
}
