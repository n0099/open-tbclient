package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView abg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.abg = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.abg) {
            this.abg.aaZ = true;
        }
        this.abg.invalidate();
        this.abg.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.abg.reset();
        this.abg.invalidate();
        this.abg.requestLayout();
    }
}
