package com.baidu.tbadk.core.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnTouchListener {
    final /* synthetic */ CarouselRecommendView LU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CarouselRecommendView carouselRecommendView) {
        this.LU = carouselRecommendView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this.LU.mPager) {
            if (motionEvent.getAction() == 0) {
                this.LU.qp();
                return false;
            } else if (motionEvent.getAction() == 1) {
                this.LU.qo();
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
