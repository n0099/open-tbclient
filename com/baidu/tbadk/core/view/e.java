package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView aiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.aiV = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.aiV) {
            this.aiV.aiO = true;
        }
        this.aiV.invalidate();
        this.aiV.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.aiV.reset();
        this.aiV.invalidate();
        this.aiV.requestLayout();
    }
}
