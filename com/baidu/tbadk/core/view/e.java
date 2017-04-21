package com.baidu.tbadk.core.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class e extends DataSetObserver {
    final /* synthetic */ HorizontalListView ajy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.ajy = horizontalListView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        synchronized (this.ajy) {
            this.ajy.ajr = true;
        }
        this.ajy.invalidate();
        this.ajy.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.ajy.reset();
        this.ajy.invalidate();
        this.ajy.requestLayout();
    }
}
