package com.baidu.tbadk.core.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ CarouselRecommendView LU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CarouselRecommendView carouselRecommendView) {
        this.LU = carouselRecommendView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int currentItem = this.LU.mPager.getCurrentItem();
        if (message.what == 0 && this.LU.mPager != null && this.LU.LG != null && this.LU.LR.size() > 1) {
            if (currentItem < 1) {
                this.LU.mPager.setCurrentItem(this.LU.LG.getCount() - 2, false);
                this.LU.mPager.invalidate();
            } else if (currentItem > this.LU.LG.getCount() - 2) {
                this.LU.mPager.setCurrentItem(1, false);
                this.LU.mPager.invalidate();
            } else {
                this.LU.mPager.setCurrentItem(currentItem + 1);
                this.LU.mPager.invalidate();
            }
        }
    }
}
