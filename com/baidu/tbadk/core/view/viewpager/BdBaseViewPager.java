package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class BdBaseViewPager extends ViewPager {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12667e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12668f;

    /* renamed from: g  reason: collision with root package name */
    public float f12669g;

    /* renamed from: h  reason: collision with root package name */
    public float f12670h;

    /* renamed from: i  reason: collision with root package name */
    public int f12671i;

    /* loaded from: classes3.dex */
    public class a extends Scroller {

        /* renamed from: a  reason: collision with root package name */
        public int f12672a;

        public a(Context context) {
            super(context);
            this.f12672a = 1000;
        }

        public void a(ViewPager viewPager) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(viewPager, this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void b(int i2) {
            this.f12672a = i2;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            super.startScroll(i2, i3, i4, i5, this.f12672a);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5) {
            super.startScroll(i2, i3, i4, i5, this.f12672a);
        }
    }

    public BdBaseViewPager(Context context) {
        super(context);
        this.f12667e = false;
        this.f12668f = false;
        this.f12671i = -1;
        initViewPager();
    }

    private void initViewPager() {
        ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    }

    public final boolean a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void b(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.f12667e) {
            requestDisallowInterceptTouchEvent(false);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            requestDisallowInterceptTouchEvent(true);
            return dispatchTouchEvent;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public int getScrollState() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScrollState");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(this)).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f12668f) {
            return false;
        }
        if (a(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f12669g = motionEvent.getX();
            this.f12670h = motionEvent.getY();
            this.f12671i = motionEvent.getPointerId(0);
            if (getCurrentItem() != 0) {
                b(true);
            }
        } else if (action == 2) {
            int i2 = this.f12671i;
            if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                float x = motionEvent.getX(findPointerIndex) - this.f12669g;
                float abs = Math.abs(x);
                float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f12670h);
                if (x > 0.0f && abs > abs2 && getCurrentItem() == 0 && getScrollState() == 0) {
                    b(false);
                    return false;
                } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                    b(true);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.f12671i) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f12669g = motionEvent.getX(i2);
            this.f12671i = motionEvent.getPointerId(i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f12668f) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = this.f12671i;
                    if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                        float x = motionEvent.getX(findPointerIndex) - this.f12669g;
                        float abs = Math.abs(x);
                        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f12670h);
                        if (x > 0.0f && abs > abs2 && getCurrentItem() == 0 && getScrollState() == 0) {
                            b(false);
                            return false;
                        } else if (abs > 0.0f && abs > abs2 && getCurrentItem() != 0) {
                            b(true);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        this.f12669g = motionEvent.getX(actionIndex);
                        this.f12671i = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                        this.f12669g = motionEvent.getX(motionEvent.findPointerIndex(this.f12671i));
                    }
                }
            }
            b(false);
        } else {
            this.f12669g = motionEvent.getX();
            this.f12670h = motionEvent.getY();
            this.f12671i = motionEvent.getPointerId(0);
            if (getCurrentItem() != 0) {
                b(true);
            }
        }
        if (a(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.f12667e = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setmDisallowSlip(boolean z) {
        this.f12668f = z;
    }

    public BdBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12667e = false;
        this.f12668f = false;
        this.f12671i = -1;
        initViewPager();
    }
}
