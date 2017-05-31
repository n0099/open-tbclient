package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip akM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.akM = pagerSlidingTabStrip;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        this.akM.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.akM.currentPosition = this.akM.aku.getCurrentItem();
        PagerSlidingTabStrip pagerSlidingTabStrip = this.akM;
        i = this.akM.currentPosition;
        pagerSlidingTabStrip.D(i, 0);
    }
}
