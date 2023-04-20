package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.baidu.tieba.cu1;
import com.baidu.tieba.ml3;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
/* loaded from: classes3.dex */
public class WebViewContainer extends FrameLayout {
    public OverScroller a;
    public float b;
    public float c;
    public GestureDetector d;
    public VelocityTracker e;
    public int f;
    public int g;
    public c h;
    public b i;
    public boolean j;
    public boolean k;
    public a l;
    public int m;
    public boolean n;
    public boolean o;
    public float p;
    public int q;
    public int r;
    public cu1 s;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public static class d extends GestureDetector.SimpleOnGestureListener {
        public final WebViewContainer a;

        public d(WebViewContainer webViewContainer) {
            this.a = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.a.c = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            WebViewContainer webViewContainer;
            if (Math.abs(f2) <= Math.abs(f) || (webViewContainer = this.a) == null || webViewContainer.s.getWebViewScrollY() > 10) {
                return false;
            }
            if (f2 > 0.0f) {
                this.a.k = true;
                if (this.a.f <= this.a.q) {
                    return false;
                }
                return true;
            }
            this.a.k = false;
            if ((!this.a.n || !this.a.o || this.a.f >= this.a.g) && this.a.f >= this.a.g) {
                return false;
            }
            return true;
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.f = 0;
        this.g = 0;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        l(context);
    }

    public final int i(int i) {
        if (this.j) {
            this.f = this.g - i;
            return i;
        }
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

    public final boolean j(int i) {
        OverScroller overScroller = this.a;
        if (overScroller != null && this.f >= this.g) {
            overScroller.fling(0, (int) this.c, 0, i, 0, 0, ErrorCode.SERVER_ERROR, 10000);
            invalidate();
            return true;
        }
        return false;
    }

    public final void l(Context context) {
        this.a = new OverScroller(context);
        this.d = new GestureDetector(context, new d(this));
        setMotionEventSplittingEnabled(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f > ((int) motionEvent.getY())) {
            z = true;
        } else {
            z = false;
        }
        this.o = z;
        if ((z && !this.n) || !this.d.onTouchEvent(motionEvent)) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void setAutoScroll2TopListener(b bVar) {
        this.i = bVar;
    }

    public void setInterceptFlingListener(a aVar) {
        this.l = aVar;
    }

    public void setInternalWebView(cu1 cu1Var) {
        this.s = cu1Var;
    }

    public void setMinFlingVelocity(int i) {
        this.m = ml3.g(i);
    }

    public void setOnUpListener(c cVar) {
        this.h = cVar;
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
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        l(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        this.g = 0;
        this.m = 2000;
        this.n = false;
        this.p = 1.0f;
        this.q = 0;
        l(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        if (this.a.computeScrollOffset()) {
            int i = i(this.a.getCurrY());
            if (this.j) {
                scrollTo(0, i);
            } else {
                scrollBy(0, i);
            }
            this.c -= i;
            invalidate();
        }
        if (this.j && (bVar = this.i) != null) {
            bVar.a();
            this.j = false;
        }
    }

    public int getMinTopMargin() {
        return this.q;
    }

    public int getTopMargin() {
        return this.f;
    }

    public float getYVelocity() {
        return this.r;
    }

    public final void k() {
        c cVar;
        this.e.computeCurrentVelocity(1000);
        int yVelocity = (int) this.e.getYVelocity();
        this.r = yVelocity;
        if (this.k) {
            float f = this.p;
            if (f > 0.0f) {
                this.r = (int) (yVelocity * f);
            }
        }
        boolean z = false;
        if (Math.abs(this.r) > this.m && ((this.r > 0 && this.f < this.g) || (this.r < 0 && this.f >= this.q))) {
            a aVar = this.l;
            if (aVar != null) {
                z = aVar.a(this.k);
            }
            if (!z) {
                j(-this.r);
            }
        }
        if (!z && (cVar = this.h) != null) {
            cVar.a(this.k);
        }
        this.e.recycle();
        this.e = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.j = false;
        int y = (int) motionEvent.getY();
        if (this.f > y && !this.n) {
            return false;
        }
        super.onTouchEvent(motionEvent);
        if (this.e == null) {
            this.e = VelocityTracker.obtain();
        }
        this.e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3 && this.n) {
                        k();
                    }
                } else {
                    float rawY = motionEvent.getRawY();
                    this.b = rawY;
                    int i = i((int) (this.c - rawY));
                    scrollBy(0, i);
                    this.c -= i;
                }
            } else {
                k();
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
