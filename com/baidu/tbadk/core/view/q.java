package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class q extends DataSetObserver {
    final /* synthetic */ HorizontalListView Ne;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(HorizontalListView horizontalListView) {
        this.Ne = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.Ne) {
            this.Ne.Nb = true;
        }
        this.Ne.invalidate();
        this.Ne.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.Ne.reset();
        this.Ne.invalidate();
        this.Ne.requestLayout();
    }
}
