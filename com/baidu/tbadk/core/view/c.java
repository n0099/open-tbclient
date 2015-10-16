package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class c extends DataSetObserver {
    final /* synthetic */ HorizontalListView adt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalListView horizontalListView) {
        this.adt = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.adt) {
            this.adt.adm = true;
        }
        this.adt.invalidate();
        this.adt.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.adt.reset();
        this.adt.invalidate();
        this.adt.requestLayout();
    }
}
