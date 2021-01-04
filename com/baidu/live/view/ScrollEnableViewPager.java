package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes11.dex */
public class ScrollEnableViewPager extends ViewPager {
    private boolean bVe;

    public ScrollEnableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOverScrollMode(2);
        this.bVe = true;
    }

    public void setScrollEnabled(boolean z) {
        this.bVe = z;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.bVe && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.bVe && super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        super.setCurrentItem(i, this.bVe);
    }
}
