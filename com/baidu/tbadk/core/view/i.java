package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class i extends DataSetObserver {
    final /* synthetic */ HorizontalListView HO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(HorizontalListView horizontalListView) {
        this.HO = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.HO) {
            this.HO.HL = true;
        }
        this.HO.invalidate();
        this.HO.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.HO.reset();
        this.HO.invalidate();
        this.HO.requestLayout();
    }
}
