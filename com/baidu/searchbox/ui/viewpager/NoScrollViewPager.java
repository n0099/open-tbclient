package com.baidu.searchbox.ui.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes4.dex */
public class NoScrollViewPager extends ViewPager {
    public boolean mDebug;
    public boolean noScroll;

    public NoScrollViewPager(Context context) {
        super(context);
        this.noScroll = false;
        this.mDebug = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.noScroll) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            if (this.mDebug) {
                Log.e("NoScrollViewPager", e.getMessage());
            }
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.noScroll) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setNoScroll(boolean z) {
        this.noScroll = z;
    }

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.noScroll = false;
        this.mDebug = false;
    }
}
