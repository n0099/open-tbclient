package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ HorizontalListView YY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(HorizontalListView horizontalListView) {
        this.YY = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.YY.requestLayout();
    }
}
