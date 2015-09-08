package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ HorizontalListView aeg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(HorizontalListView horizontalListView) {
        this.aeg = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeg.requestLayout();
    }
}
