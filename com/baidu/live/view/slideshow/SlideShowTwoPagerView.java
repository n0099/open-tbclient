package com.baidu.live.view.slideshow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
/* loaded from: classes10.dex */
public class SlideShowTwoPagerView extends ViewGroup {
    private View bWC;
    private View bWD;
    private float bWE;
    private int bWF;
    private Scroller bWG;
    private boolean bWH;
    private boolean bWI;
    private boolean bWJ;
    private int bWK;
    protected boolean bWL;
    private a bWM;
    private int maxHeight;
    private int maxWidth;
    private boolean scrolling;
    private float startX;

    /* loaded from: classes10.dex */
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
        this.bWM = aVar;
    }

    public void setChildView(View view, View view2) {
        this.bWC = view;
        this.bWD = view2;
        this.bWK = 0;
        removeAllViews();
        addView(view, 0);
    }

    public void XX() {
        if (!this.bWL && !this.scrolling && this.bWD != null) {
            this.bWJ = true;
            this.scrolling = true;
            removeView(this.bWD);
            this.bWF = 1;
            addView(this.bWD, 0);
            this.bWG.startScroll(0, 0, this.maxWidth, 0, 0);
            invalidate();
        }
    }

    public void release() {
        this.bWM = null;
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
        if (this.bWH) {
            setScrollX(0);
            this.bWH = false;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt == this.bWC) {
                childAt.layout(0, 0, this.maxWidth, this.maxHeight);
            } else if (childAt == this.bWD) {
                if (this.bWF > 0) {
                    childAt.layout(this.maxWidth, 0, this.maxWidth * 2, this.maxHeight);
                } else if (this.bWF < 0) {
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
            this.bWL = true;
        }
        float x = motionEvent.getX();
        float f = x - this.bWE;
        switch (motionEvent.getAction()) {
            case 0:
                this.startX = motionEvent.getX();
                this.bWE = motionEvent.getX();
                break;
            case 1:
                this.bWL = false;
                int i = -getScrollX();
                if (Math.abs(getScrollX()) > this.maxWidth / 4) {
                    this.bWI = true;
                    if (getScrollX() < 0) {
                        abs = -(this.maxWidth - Math.abs(getScrollX()));
                    } else {
                        abs = this.maxWidth - Math.abs(getScrollX());
                    }
                    i = abs;
                } else {
                    this.bWI = false;
                }
                this.bWG.startScroll(getScrollX(), 0, i, 0, 100);
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
                this.bWE = x;
                break;
            case 3:
                this.bWL = false;
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
        if (this.bWD != null) {
            if (i > 0) {
                if (this.bWF <= 0) {
                    removeView(this.bWD);
                    this.bWF = 1;
                    addView(this.bWD, 0);
                }
            } else if (i < 0) {
                if (this.bWF >= 0) {
                    removeView(this.bWD);
                    this.bWF = -1;
                    addView(this.bWD, 0);
                }
            } else {
                this.bWF = 0;
                removeView(this.bWD);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bWG.computeScrollOffset()) {
            this.scrolling = true;
            scrollTo(this.bWG.getCurrX(), this.bWG.getCurrY());
            invalidate();
        } else if (this.scrolling) {
            if (this.bWJ) {
                this.bWI = true;
                this.bWJ = false;
            }
            if (this.bWI) {
                View view = this.bWC;
                this.bWC = this.bWD;
                this.bWD = view;
                this.bWK = this.bWK == 0 ? 1 : 0;
            }
            this.bWI = false;
            this.scrolling = false;
            this.bWF = 0;
            this.bWH = true;
            removeView(this.bWD);
            if (this.bWM != null) {
                this.bWM.onPageSelected(this.bWK);
            }
        }
    }

    private void init() {
        this.bWG = new Scroller(getContext());
    }
}
