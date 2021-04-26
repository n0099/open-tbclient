package com.baidu.pass.ecommerce.view.addressdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes2.dex */
public class AddrViewPager extends ViewPager {
    public float mBeforeX;
    public int mRealPagerNum;

    public AddrViewPager(@NonNull Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getCurrentItem() < this.mRealPagerNum - 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && motionEvent.getX() - this.mBeforeX < 0.0f) {
                return false;
            }
        } else {
            this.mBeforeX = motionEvent.getX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCurrentItem() < this.mRealPagerNum - 1) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 2) && motionEvent.getX() - this.mBeforeX < 0.0f) {
                return false;
            }
        } else {
            this.mBeforeX = motionEvent.getX();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i2) {
        super.setCurrentItem(i2, false);
    }

    public void setRealPagerNumber(int i2) {
        this.mRealPagerNum = i2;
    }

    public AddrViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
