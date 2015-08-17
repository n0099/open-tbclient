package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ HorizontalListView adW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(HorizontalListView horizontalListView) {
        this.adW = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.adW.requestLayout();
    }
}
