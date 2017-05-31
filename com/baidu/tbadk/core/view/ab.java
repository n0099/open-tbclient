package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    private final /* synthetic */ int aaj;
    final /* synthetic */ PagerSlidingTabStrip akM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.akM = pagerSlidingTabStrip;
        this.aaj = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.akM.aku.setCurrentItem(this.aaj);
        this.akM.wg();
    }
}
