package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView ajx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.ajx = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.ajx) {
            this.ajx.ajq = true;
        }
        this.ajx.invalidate();
        this.ajx.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.ajx.reset();
        this.ajx.invalidate();
        this.ajx.requestLayout();
    }
}
