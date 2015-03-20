package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ HorizontalListView Yj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(HorizontalListView horizontalListView) {
        this.Yj = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yj.requestLayout();
    }
}
