package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class c extends DataSetObserver {
    final /* synthetic */ HorizontalListView ady;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalListView horizontalListView) {
        this.ady = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.ady) {
            this.ady.adr = true;
        }
        this.ady.invalidate();
        this.ady.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.ady.reset();
        this.ady.invalidate();
        this.ady.requestLayout();
    }
}
