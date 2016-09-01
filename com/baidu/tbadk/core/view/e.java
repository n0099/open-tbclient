package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.aeH = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.aeH) {
            this.aeH.aeA = true;
        }
        this.aeH.invalidate();
        this.aeH.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.aeH.reset();
        this.aeH.invalidate();
        this.aeH.requestLayout();
    }
}
