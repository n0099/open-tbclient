package com.baidu.tbadk.core.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {
    final /* synthetic */ CarouselRecommendView LD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CarouselRecommendView carouselRecommendView) {
        this.LD = carouselRecommendView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.LD.mPager) {
            if (motionEvent.getAction() == 0) {
                this.LD.ql();
                return false;
            } else if (motionEvent.getAction() == 1) {
                this.LD.qk();
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
