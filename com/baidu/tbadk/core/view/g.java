package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HorizontalListView ajx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalListView horizontalListView) {
        this.ajx = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ajx.requestLayout();
    }
}
