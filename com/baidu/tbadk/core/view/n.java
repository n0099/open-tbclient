package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class n extends DataSetObserver {
    final /* synthetic */ HorizontalListView YY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(HorizontalListView horizontalListView) {
        this.YY = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.YY) {
            this.YY.YS = true;
        }
        this.YY.invalidate();
        this.YY.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.YY.reset();
        this.YY.invalidate();
        this.YY.requestLayout();
    }
}
