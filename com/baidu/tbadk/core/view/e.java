package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView afd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.afd = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.afd) {
            this.afd.aeW = true;
        }
        this.afd.invalidate();
        this.afd.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.afd.reset();
        this.afd.invalidate();
        this.afd.requestLayout();
    }
}
