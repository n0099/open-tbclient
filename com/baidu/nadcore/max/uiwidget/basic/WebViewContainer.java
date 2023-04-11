package com.baidu.nadcore.max.uiwidget.basic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.baidu.tieba.a41;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
/* loaded from: classes2.dex */
public class WebViewContainer extends FrameLayout {
    public OverScroller a;
    public float b;
    public GestureDetector c;
    public VelocityTracker d;
    public c e;
    public int f;
    public int g;
    public int h;
    public d i;
    public b j;
    public boolean k;
    public a l;
    public int m;
    public boolean n;
    public boolean o;
    public float p;
    public int q;

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean a();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onScroll(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public static class e extends GestureDetector.SimpleOnGestureListener {
        public final WebViewContainer a;

        public e(WebViewContainer webViewContainer) {
            this.a = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.a.b = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            WebViewContainer webViewContainer;
            boolean z;
            if (Math.abs(f2) <= Math.abs(f) || (webViewContainer = this.a) == null) {
                return false;
            }
            if (f2 > 0.0f) {
                webViewContainer.k = true;
                if (this.a.f <= this.a.q) {
                    return false;
                }
                return true;
            }
            webViewContainer.k = false;
            if (this.a.n && this.a.o && this.a.f < this.a.g) {
                return true;
            }
            if (this.a.j != null) {
                z = this.a.j.a();
            } else {
                z = true;
            }
            if (this.a.f >= this.a.g || !z) {
                return false;
            }
            if (this.a.f <= this.a.q && this.a.h != 3) {
                return false;
            }
            return true;
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.f = 0;
        this.g = 0;
        this.h = 1;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        m(context);
    }

    public final int j(int i) {
        int i2 = this.f;
        int i3 = i2 - i;
        int i4 = this.q;
        if (i3 < i4) {
            int i5 = i2 - i4;
            this.f = i4;
            return i5;
        }
        int i6 = this.g;
        if (i3 > i6) {
            int i7 = i2 - i6;
            this.f = i6;
            return i7;
        }
        this.f = i2 - i;
        return i;
    }

    public final boolean k(int i) {
        OverScroller overScroller = this.a;
        if (overScroller != null && this.f >= this.g) {
            overScroller.fling(0, (int) this.b, 0, i, 0, 0, ErrorCode.SERVER_ERROR, 10000);
            invalidate();
            return true;
        }
        return false;
    }

    public final void m(Context context) {
        this.a = new OverScroller(context);
        this.c = new GestureDetector(context, new e(this));
        setMotionEventSplittingEnabled(false);
    }

    public void setHandleTopYMove(boolean z) {
        this.n = z;
    }

    public void setInterceptFlingListener(a aVar) {
        this.l = aVar;
    }

    public void setInterceptScrollLister(b bVar) {
        this.j = bVar;
    }

    public void setMinFlingVelocity(int i) {
        this.m = a41.c.a(getContext(), i);
    }

    public void setMinTopMargin(int i) {
        this.q = i;
    }

    public void setOnScrollChangeListener(c cVar) {
        this.e = cVar;
    }

    public void setOnUpListener(d dVar) {
        this.i = dVar;
    }

    public void setStyle(int i) {
        this.h = i;
    }

    public void setTopLimit(int i) {
        this.g = i;
    }

    public void setTopMargin(int i) {
        this.f = i;
    }

    public void setUpYVelocityRatio(float f) {
        this.p = f;
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.g = 0;
        this.h = 1;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        m(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        this.g = 0;
        this.h = 1;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        m(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.a.computeScrollOffset()) {
            int j = j(this.a.getCurrY());
            scrollBy(0, j);
            this.b -= j;
            invalidate();
        }
    }

    public int getMinTopMargin() {
        return this.q;
    }

    public int getTopMargin() {
        return this.f;
    }

    public final void l() {
        d dVar;
        this.d.computeCurrentVelocity(1000);
        int yVelocity = (int) this.d.getYVelocity();
        if (this.k) {
            float f = this.p;
            if (f > 0.0f) {
                yVelocity = (int) (yVelocity * f);
            }
        }
        boolean z = false;
        if (Math.abs(yVelocity) > this.m && ((yVelocity > 0 && this.f < this.g) || (yVelocity < 0 && this.f >= this.q))) {
            a aVar = this.l;
            if (aVar != null) {
                z = aVar.a(this.k);
            }
            if (!z) {
                k(-yVelocity);
            }
        }
        if (!z && (dVar = this.i) != null) {
            dVar.a(this.k);
        }
        this.d.recycle();
        this.d = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.h == 2) {
            return false;
        }
        if (this.f > ((int) motionEvent.getY())) {
            z = true;
        } else {
            z = false;
        }
        this.o = z;
        if ((z && !this.n) || !this.c.onTouchEvent(motionEvent)) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        boolean z;
        super.onScrollChanged(i, i2, i3, i4);
        if (this.e != null) {
            int i5 = i2 - i4;
            if (i5 > 0) {
                z = true;
            } else {
                z = false;
            }
            this.k = z;
            this.e.onScroll(i - i3, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.h == 2) {
            return false;
        }
        int y = (int) motionEvent.getY();
        if (this.f > y && !this.n) {
            return false;
        }
        super.onTouchEvent(motionEvent);
        if (this.d == null) {
            this.d = VelocityTracker.obtain();
        }
        this.d.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3 && this.n) {
                        l();
                    }
                } else {
                    int j = j((int) (this.b - motionEvent.getRawY()));
                    scrollBy(0, j);
                    this.b -= j;
                }
            } else {
                l();
            }
        } else if (!this.a.isFinished()) {
            this.a.abortAnimation();
        }
        if (this.f > y) {
            return false;
        }
        return true;
    }
}
