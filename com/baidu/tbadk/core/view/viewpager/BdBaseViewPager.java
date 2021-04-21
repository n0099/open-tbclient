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
    public boolean f13315e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13316f;

    /* renamed from: g  reason: collision with root package name */
    public float f13317g;

    /* renamed from: h  reason: collision with root package name */
    public float f13318h;
    public int i;

    /* loaded from: classes3.dex */
    public class a extends Scroller {

        /* renamed from: a  reason: collision with root package name */
        public int f13319a;

        public a(Context context) {
            super(context);
            this.f13319a = 1000;
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

        public void b(int i) {
            this.f13319a = i;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.f13319a);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.f13319a);
        }
    }

    public BdBaseViewPager(Context context) {
        super(context);
        this.f13315e = false;
        this.f13316f = false;
        this.i = -1;
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
        if (motionEvent.getPointerCount() > 1 && this.f13315e) {
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
        if (this.f13316f) {
            return false;
        }
        if (a(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f13317g = motionEvent.getX();
            this.f13318h = motionEvent.getY();
            this.i = motionEvent.getPointerId(0);
            if (getCurrentItem() != 0) {
                b(true);
            }
        } else if (action == 2) {
            int i = this.i;
            if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                float x = motionEvent.getX(findPointerIndex) - this.f13317g;
                float abs = Math.abs(x);
                float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f13318h);
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
        if (motionEvent.getPointerId(actionIndex) == this.i) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f13317g = motionEvent.getX(i);
            this.i = motionEvent.getPointerId(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f13316f) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.i;
                    if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                        float x = motionEvent.getX(findPointerIndex) - this.f13317g;
                        float abs = Math.abs(x);
                        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f13318h);
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
                        this.f13317g = motionEvent.getX(actionIndex);
                        this.i = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                        this.f13317g = motionEvent.getX(motionEvent.findPointerIndex(this.i));
                    }
                }
            }
            b(false);
        } else {
            this.f13317g = motionEvent.getX();
            this.f13318h = motionEvent.getY();
            this.i = motionEvent.getPointerId(0);
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
        this.f13315e = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setmDisallowSlip(boolean z) {
        this.f13316f = z;
    }

    public BdBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13315e = false;
        this.f13316f = false;
        this.i = -1;
        initViewPager();
    }
}
