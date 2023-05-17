package com.baidu.searchbox.ui.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes4.dex */
public class ScrollViewPager extends ViewPager {
    public int startX;
    public int startY;

    public ScrollViewPager(Context context) {
        super(context);
    }

    public ScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                int scaledPagingTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
                int x = (int) (motionEvent.getX() - this.startX);
                if (Math.abs(x) > Math.abs((int) (motionEvent.getY() - this.startY)) && Math.abs(x) > scaledPagingTouchSlop) {
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
        } else {
            this.startX = (int) motionEvent.getX();
            this.startY = (int) motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
