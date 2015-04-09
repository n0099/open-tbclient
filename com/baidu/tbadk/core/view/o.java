package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ HorizontalListView Yl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(HorizontalListView horizontalListView) {
        this.Yl = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yl.requestLayout();
    }
}
