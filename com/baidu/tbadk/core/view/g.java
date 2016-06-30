package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HorizontalListView abg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalListView horizontalListView) {
        this.abg = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abg.requestLayout();
    }
}
