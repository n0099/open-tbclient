package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView aeS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.aeS = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.aeS) {
            this.aeS.aeL = true;
        }
        this.aeS.invalidate();
        this.aeS.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.aeS.reset();
        this.aeS.invalidate();
        this.aeS.requestLayout();
    }
}
