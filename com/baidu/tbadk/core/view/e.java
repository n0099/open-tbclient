package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView afP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.afP = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.afP) {
            this.afP.afI = true;
        }
        this.afP.invalidate();
        this.afP.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.afP.reset();
        this.afP.invalidate();
        this.afP.requestLayout();
    }
}
