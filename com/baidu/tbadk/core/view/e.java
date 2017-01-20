package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView adU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.adU = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.adU) {
            this.adU.adN = true;
        }
        this.adU.invalidate();
        this.adU.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.adU.reset();
        this.adU.invalidate();
        this.adU.requestLayout();
    }
}
