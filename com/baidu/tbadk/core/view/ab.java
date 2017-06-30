package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    private final /* synthetic */ int aak;
    final /* synthetic */ PagerSlidingTabStrip alA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.alA = pagerSlidingTabStrip;
        this.aak = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.alA.alh.setCurrentItem(this.aak);
        this.alA.wy();
    }
}
