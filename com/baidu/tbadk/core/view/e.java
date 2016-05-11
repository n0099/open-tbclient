package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView aaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.aaN = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.aaN) {
            this.aaN.aaG = true;
        }
        this.aaN.invalidate();
        this.aaN.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.aaN.reset();
        this.aaN.invalidate();
        this.aaN.requestLayout();
    }
}
