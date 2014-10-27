package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class i extends DataSetObserver {
    final /* synthetic */ HorizontalListView HN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(HorizontalListView horizontalListView) {
        this.HN = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.HN) {
            this.HN.HK = true;
        }
        this.HN.invalidate();
        this.HN.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.HN.reset();
        this.HN.invalidate();
        this.HN.requestLayout();
    }
}
