package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView aiL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.aiL = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.aiL) {
            this.aiL.mDataChanged = true;
        }
        this.aiL.invalidate();
        this.aiL.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.aiL.reset();
        this.aiL.invalidate();
        this.aiL.requestLayout();
    }
}
