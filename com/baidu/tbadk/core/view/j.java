package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ HorizontalListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(HorizontalListView horizontalListView) {
        this.a = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.requestLayout();
    }
}
