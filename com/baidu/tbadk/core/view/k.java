package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ HorizontalListView HO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(HorizontalListView horizontalListView) {
        this.HO = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.HO.requestLayout();
    }
}
