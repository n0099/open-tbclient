package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ HorizontalListView Ne;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(HorizontalListView horizontalListView) {
        this.Ne = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ne.requestLayout();
    }
}
