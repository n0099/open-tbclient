package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HorizontalListView aiL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalListView horizontalListView) {
        this.aiL = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aiL.requestLayout();
    }
}
