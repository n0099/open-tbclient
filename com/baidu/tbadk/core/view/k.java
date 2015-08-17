package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class k extends DataSetObserver {
    final /* synthetic */ HorizontalListView adW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(HorizontalListView horizontalListView) {
        this.adW = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.adW) {
            this.adW.adQ = true;
        }
        this.adW.invalidate();
        this.adW.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.adW.reset();
        this.adW.invalidate();
        this.adW.requestLayout();
    }
}
