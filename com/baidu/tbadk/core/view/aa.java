package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip alA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.alA = pagerSlidingTabStrip;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        this.alA.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.alA.currentPosition = this.alA.alh.getCurrentItem();
        PagerSlidingTabStrip pagerSlidingTabStrip = this.alA;
        i = this.alA.currentPosition;
        pagerSlidingTabStrip.D(i, 0);
    }
}
