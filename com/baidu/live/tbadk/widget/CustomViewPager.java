package com.baidu.live.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes11.dex */
public class CustomViewPager extends TbViewPager {
    public static final int IDLE = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = -1;
    private boolean isScrolling;
    private int lastValue;
    private int mDirection;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private boolean scrollable;

    public CustomViewPager(Context context) {
        super(context);
        this.scrollable = true;
        this.mDirection = 0;
        this.isScrolling = false;
        this.lastValue = -1;
        init();
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollable = true;
        this.mDirection = 0;
        this.isScrolling = false;
        this.lastValue = -1;
        init();
    }

    private void init() {
        super.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.live.tbadk.widget.CustomViewPager.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                CustomViewPager.this.isScrolling = i == 1;
                if (i == 2) {
                    CustomViewPager.this.mDirection = 0;
                }
                if (CustomViewPager.this.mOnPageChangeListener != null) {
                    CustomViewPager.this.mOnPageChangeListener.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (CustomViewPager.this.isScrolling) {
                    if (CustomViewPager.this.lastValue > i2) {
                        CustomViewPager.this.mDirection = -1;
                    } else if (CustomViewPager.this.lastValue < i2) {
                        CustomViewPager.this.mDirection = 1;
                    } else if (CustomViewPager.this.lastValue == i2) {
                        CustomViewPager.this.mDirection = 0;
                    }
                }
                CustomViewPager.this.lastValue = i2;
                if (CustomViewPager.this.mOnPageChangeListener != null) {
                    CustomViewPager.this.mOnPageChangeListener.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (CustomViewPager.this.mOnPageChangeListener != null) {
                    CustomViewPager.this.mOnPageChangeListener.onPageSelected(i);
                }
            }
        });
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public int getDirection() {
        return this.mDirection;
    }

    @Override // com.baidu.live.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.scrollable) {
            if (getCurrentItem() != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override // com.baidu.live.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.scrollable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
