package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView ajj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.ajj = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.ajj) {
            this.ajj.ajc = true;
        }
        this.ajj.invalidate();
        this.ajj.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.ajj.reset();
        this.ajj.invalidate();
        this.ajj.requestLayout();
    }
}
