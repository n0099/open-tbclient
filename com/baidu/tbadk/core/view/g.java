package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HorizontalListView aeJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalListView horizontalListView) {
        this.aeJ = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeJ.requestLayout();
    }
}
