package com.baidu.tbadk.core.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ CarouselRecommendView LD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CarouselRecommendView carouselRecommendView) {
        this.LD = carouselRecommendView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int currentItem = this.LD.mPager.getCurrentItem();
        if (message.what == 0 && this.LD.mPager != null && this.LD.Lo != null && this.LD.Lz.size() > 1) {
            if (currentItem < 1) {
                this.LD.mPager.setCurrentItem(this.LD.Lo.getCount() - 2, false);
                this.LD.mPager.invalidate();
            } else if (currentItem > this.LD.Lo.getCount() - 2) {
                this.LD.mPager.setCurrentItem(1, false);
                this.LD.mPager.invalidate();
            } else {
                this.LD.mPager.setCurrentItem(currentItem + 1);
                this.LD.mPager.invalidate();
            }
        }
    }
}
