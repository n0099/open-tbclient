package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView afo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.afo = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.afo) {
            this.afo.afh = true;
        }
        this.afo.invalidate();
        this.afo.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.afo.reset();
        this.afo.invalidate();
        this.afo.requestLayout();
    }
}
