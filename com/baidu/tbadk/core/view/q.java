package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class q extends DataSetObserver {
    final /* synthetic */ HorizontalListView MH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(HorizontalListView horizontalListView) {
        this.MH = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.MH) {
            this.MH.ME = true;
        }
        this.MH.invalidate();
        this.MH.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.MH.reset();
        this.MH.invalidate();
        this.MH.requestLayout();
    }
}
