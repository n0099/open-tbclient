package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class d extends DataSetObserver {
    final /* synthetic */ HorizontalListView aev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalListView horizontalListView) {
        this.aev = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.aev) {
            this.aev.aeo = true;
        }
        this.aev.invalidate();
        this.aev.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.aev.reset();
        this.aev.invalidate();
        this.aev.requestLayout();
    }
}
