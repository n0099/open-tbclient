package com.baidu.live.view.slideshow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes11.dex */
public class SlideShowTwoPagerView extends ViewGroup {
    private View bVc;
    private View bVd;
    private float bVe;
    private int bVf;
    private Scroller bVg;
    private boolean bVh;
    private boolean bVi;
    private boolean bVj;
    private int bVk;
    protected boolean bVl;
    private a bVm;
    private int maxHeight;
    private int maxWidth;
    private boolean scrolling;
    private float startX;

    /* loaded from: classes11.dex */
    public interface a {
        void onPageSelected(int i);
    }

    public SlideShowTwoPagerView(Context context) {
        super(context);
        init();
    }

    public SlideShowTwoPagerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setOnPageChangeListener(a aVar) {
        this.bVm = aVar;
    }

    public void setChildView(View view, View view2) {
        this.bVc = view;
        this.bVd = view2;
        this.bVk = 0;
        removeAllViews();
        addView(view, 0);
    }

    public void XU() {
        if (!this.bVl && !this.scrolling && this.bVd != null) {
            this.bVj = true;
            this.scrolling = true;
            removeView(this.bVd);
            this.bVf = 1;
            addView(this.bVd, 0);
            this.bVg.startScroll(0, 0, this.maxWidth, 0, 0);
            invalidate();
        }
    }

    public void release() {
        this.bVm = null;
        removeAllViews();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.maxWidth = View.MeasureSpec.getSize(i);
        this.maxHeight = View.MeasureSpec.getSize(i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.maxHeight, 1073741824));
        }
        setMeasuredDimension(this.maxWidth, this.maxHeight);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.bVh) {
            setScrollX(0);
            this.bVh = false;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt == this.bVc) {
                childAt.layout(0, 0, this.maxWidth, this.maxHeight);
            } else if (childAt == this.bVd) {
                if (this.bVf > 0) {
                    childAt.layout(this.maxWidth, 0, this.maxWidth * 2, this.maxHeight);
                } else if (this.bVf < 0) {
                    childAt.layout(-this.maxWidth, 0, 0, this.maxHeight);
                } else {
                    removeView(childAt);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int abs;
        if (this.scrolling) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            requestDisallowInterceptTouchEvent(true);
            setScrollX(0);
            this.bVl = true;
        }
        float x = motionEvent.getX();
        float f = x - this.bVe;
        switch (motionEvent.getAction()) {
            case 0:
                this.startX = motionEvent.getX();
                this.bVe = motionEvent.getX();
                break;
            case 1:
                this.bVl = false;
                int i = -getScrollX();
                if (Math.abs(getScrollX()) > this.maxWidth / 4) {
                    this.bVi = true;
                    if (getScrollX() < 0) {
                        abs = -(this.maxWidth - Math.abs(getScrollX()));
                    } else {
                        abs = this.maxWidth - Math.abs(getScrollX());
                    }
                    i = abs;
                } else {
                    this.bVi = false;
                }
                this.bVg.startScroll(getScrollX(), 0, i, 0, 100);
                this.scrolling = true;
                invalidate();
                break;
            case 2:
                if (x - this.startX < 0.0f) {
                    if (this.startX - x >= this.maxWidth) {
                        f = -Math.abs(this.maxWidth - getScrollX());
                    }
                } else if (x - this.startX > 0.0f && x - this.startX >= this.maxWidth) {
                    f = this.maxWidth + getScrollX();
                }
                scrollBy((int) (-f), 0);
                this.bVe = x;
                break;
            case 3:
                this.bVl = false;
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            return Math.abs(motionEvent.getX() - this.startX) > ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.bVd != null) {
            if (i > 0) {
                if (this.bVf <= 0) {
                    removeView(this.bVd);
                    this.bVf = 1;
                    addView(this.bVd, 0);
                }
            } else if (i < 0) {
                if (this.bVf >= 0) {
                    removeView(this.bVd);
                    this.bVf = -1;
                    addView(this.bVd, 0);
                }
            } else {
                this.bVf = 0;
                removeView(this.bVd);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bVg.computeScrollOffset()) {
            this.scrolling = true;
            scrollTo(this.bVg.getCurrX(), this.bVg.getCurrY());
            invalidate();
        } else if (this.scrolling) {
            if (this.bVj) {
                this.bVi = true;
                this.bVj = false;
            }
            if (this.bVi) {
                View view = this.bVc;
                this.bVc = this.bVd;
                this.bVd = view;
                this.bVk = this.bVk == 0 ? 1 : 0;
            }
            this.bVi = false;
            this.scrolling = false;
            this.bVf = 0;
            this.bVh = true;
            removeView(this.bVd);
            if (this.bVm != null) {
                this.bVm.onPageSelected(this.bVk);
            }
        }
    }

    private void init() {
        this.bVg = new Scroller(getContext());
    }
}
