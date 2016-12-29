package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView aeJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.aeJ = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.aeJ) {
            this.aeJ.aeC = true;
        }
        this.aeJ.invalidate();
        this.aeJ.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.aeJ.reset();
        this.aeJ.invalidate();
        this.aeJ.requestLayout();
    }
}
