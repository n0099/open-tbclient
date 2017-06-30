package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView ajt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.ajt = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.ajt) {
            this.ajt.mDataChanged = true;
        }
        this.ajt.invalidate();
        this.ajt.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.ajt.reset();
        this.ajt.invalidate();
        this.ajt.requestLayout();
    }
}
