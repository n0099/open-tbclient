package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView afq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.afq = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.afq) {
            this.afq.afj = true;
        }
        this.afq.invalidate();
        this.afq.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.afq.reset();
        this.afq.invalidate();
        this.afq.requestLayout();
    }
}
