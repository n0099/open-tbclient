package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ HorizontalListView ads;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HorizontalListView horizontalListView) {
        this.ads = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ads.requestLayout();
    }
}
