package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class k extends DataSetObserver {
    final /* synthetic */ HorizontalListView aeg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(HorizontalListView horizontalListView) {
        this.aeg = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.aeg) {
            this.aeg.aea = true;
        }
        this.aeg.invalidate();
        this.aeg.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.aeg.reset();
        this.aeg.invalidate();
        this.aeg.requestLayout();
    }
}
