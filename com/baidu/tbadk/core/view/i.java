package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class i extends DataSetObserver {
    final /* synthetic */ HorizontalListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(HorizontalListView horizontalListView) {
        this.a = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.a) {
            this.a.o = true;
        }
        this.a.invalidate();
        this.a.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.a.b();
        this.a.invalidate();
        this.a.requestLayout();
    }
}
