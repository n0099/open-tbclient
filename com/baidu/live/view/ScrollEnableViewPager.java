package com.baidu.live.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes2.dex */
public class ScrollEnableViewPager extends ViewPager {
    private boolean aBf;

    public ScrollEnableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOverScrollMode(2);
        this.aBf = true;
    }

    public void setScrollEnabled(boolean z) {
        this.aBf = z;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.aBf && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.aBf && super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager
    public void setCurrentItem(int i) {
        super.setCurrentItem(i, this.aBf);
    }
}
