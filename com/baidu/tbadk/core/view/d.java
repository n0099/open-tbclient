package com.baidu.tbadk.core.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {
    final /* synthetic */ CarouselRecommendView LX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CarouselRecommendView carouselRecommendView) {
        this.LX = carouselRecommendView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.LX.mPager) {
            if (motionEvent.getAction() == 0) {
                this.LX.qw();
                return false;
            } else if (motionEvent.getAction() == 1) {
                this.LX.qv();
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
