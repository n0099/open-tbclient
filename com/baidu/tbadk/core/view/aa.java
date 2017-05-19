package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip akW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.akW = pagerSlidingTabStrip;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        this.akW.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.akW.currentPosition = this.akW.akE.getCurrentItem();
        PagerSlidingTabStrip pagerSlidingTabStrip = this.akW;
        i = this.akW.currentPosition;
        pagerSlidingTabStrip.E(i, 0);
    }
}
