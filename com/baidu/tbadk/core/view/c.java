package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class c extends DataSetObserver {
    final /* synthetic */ HorizontalListView ads;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalListView horizontalListView) {
        this.ads = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.ads) {
            this.ads.adl = true;
        }
        this.ads.invalidate();
        this.ads.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.ads.reset();
        this.ads.invalidate();
        this.ads.requestLayout();
    }
}
