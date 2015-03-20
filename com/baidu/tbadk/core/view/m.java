package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class m extends DataSetObserver {
    final /* synthetic */ HorizontalListView Yj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(HorizontalListView horizontalListView) {
        this.Yj = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.Yj) {
            this.Yj.Yd = true;
        }
        this.Yj.invalidate();
        this.Yj.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.Yj.reset();
        this.Yj.invalidate();
        this.Yj.requestLayout();
    }
}
