package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ HorizontalListView aev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HorizontalListView horizontalListView) {
        this.aev = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aev.requestLayout();
    }
}
