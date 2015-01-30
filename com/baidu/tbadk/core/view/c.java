package com.baidu.tbadk.core.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ CarouselRecommendView LX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CarouselRecommendView carouselRecommendView) {
        this.LX = carouselRecommendView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int currentItem = this.LX.mPager.getCurrentItem();
        if (message.what == 0 && this.LX.mPager != null && this.LX.LJ != null && this.LX.LU.size() > 1) {
            if (currentItem < 1) {
                this.LX.mPager.setCurrentItem(this.LX.LJ.getCount() - 2, false);
                this.LX.mPager.invalidate();
            } else if (currentItem > this.LX.LJ.getCount() - 2) {
                this.LX.mPager.setCurrentItem(1, false);
                this.LX.mPager.invalidate();
            } else {
                this.LX.mPager.setCurrentItem(currentItem + 1);
                this.LX.mPager.invalidate();
            }
        }
    }
}
