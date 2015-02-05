package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class q extends DataSetObserver {
    final /* synthetic */ HorizontalListView Nb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(HorizontalListView horizontalListView) {
        this.Nb = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.Nb) {
            this.Nb.MY = true;
        }
        this.Nb.invalidate();
        this.Nb.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.Nb.reset();
        this.Nb.invalidate();
        this.Nb.requestLayout();
    }
}
