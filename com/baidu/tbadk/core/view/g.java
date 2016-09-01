package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HorizontalListView aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalListView horizontalListView) {
        this.aeH = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeH.requestLayout();
    }
}
