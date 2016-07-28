package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView abR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.abR = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.abR) {
            this.abR.abK = true;
        }
        this.abR.invalidate();
        this.abR.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.abR.reset();
        this.abR.invalidate();
        this.abR.requestLayout();
    }
}
