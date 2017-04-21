package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ HorizontalListView ajy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalListView horizontalListView) {
        this.ajy = horizontalListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ajy.requestLayout();
    }
}
