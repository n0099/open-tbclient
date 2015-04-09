package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class m extends DataSetObserver {
    final /* synthetic */ HorizontalListView Yl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(HorizontalListView horizontalListView) {
        this.Yl = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.Yl) {
            this.Yl.Yf = true;
        }
        this.Yl.invalidate();
        this.Yl.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.Yl.reset();
        this.Yl.invalidate();
        this.Yl.requestLayout();
    }
}
