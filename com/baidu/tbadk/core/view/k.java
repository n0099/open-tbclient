package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ HorizontalListView HN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(HorizontalListView horizontalListView) {
        this.HN = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.HN.requestLayout();
    }
}
