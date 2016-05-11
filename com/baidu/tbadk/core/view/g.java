package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HorizontalListView aaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalListView horizontalListView) {
        this.aaN = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaN.requestLayout();
    }
}
