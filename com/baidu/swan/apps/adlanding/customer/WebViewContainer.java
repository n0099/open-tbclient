package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import d.a.l0.a.v2.n0;
/* loaded from: classes2.dex */
public class WebViewContainer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f10394e;

    /* renamed from: f  reason: collision with root package name */
    public float f10395f;

    /* renamed from: g  reason: collision with root package name */
    public float f10396g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f10397h;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f10398i;
    public int j;
    public int k;
    public c l;
    public b m;
    public boolean n;
    public boolean o;
    public a p;
    public int q;
    public boolean r;
    public boolean s;
    public float t;
    public int u;
    public int v;
    public d.a.l0.a.p.e.c w;

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public static class d extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public final WebViewContainer f10399e;

        public d(WebViewContainer webViewContainer) {
            this.f10399e = webViewContainer;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.f10399e.f10396g = motionEvent.getRawY();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WebViewContainer webViewContainer;
            if (Math.abs(f3) <= Math.abs(f2) || (webViewContainer = this.f10399e) == null || webViewContainer.w.getWebViewScrollY() > 10) {
                return false;
            }
            if (f3 > 0.0f) {
                this.f10399e.o = true;
                return this.f10399e.j > this.f10399e.u;
            }
            this.f10399e.o = false;
            return (this.f10399e.r && this.f10399e.s && this.f10399e.j < this.f10399e.k) || this.f10399e.j < this.f10399e.k;
        }
    }

    public WebViewContainer(Context context) {
        super(context);
        this.j = 0;
        this.k = 0;
        this.q = 2000;
        this.r = false;
        this.t = 1.0f;
        this.u = 0;
        l(context);
    }

    @Override // android.view.View
    public void computeScroll() {
        b bVar;
        if (this.f10394e.computeScrollOffset()) {
            int i2 = i(this.f10394e.getCurrY());
            if (this.n) {
                scrollTo(0, i2);
            } else {
                scrollBy(0, i2);
            }
            this.f10396g -= i2;
            invalidate();
        }
        if (!this.n || (bVar = this.m) == null) {
            return;
        }
        bVar.a();
        this.n = false;
    }

    public int getMinTopMargin() {
        return this.u;
    }

    public int getTopMargin() {
        return this.j;
    }

    public float getYVelocity() {
        return this.v;
    }

    public final int i(int i2) {
        if (this.n) {
            this.j = this.k - i2;
            return i2;
        }
        int i3 = this.j;
        int i4 = i3 - i2;
        int i5 = this.u;
        if (i4 < i5) {
            int i6 = i3 - i5;
            this.j = i5;
            return i6;
        }
        int i7 = this.k;
        if (i4 > i7) {
            int i8 = i3 - i7;
            this.j = i7;
            return i8;
        }
        this.j = i3 - i2;
        return i2;
    }

    public final boolean j(int i2) {
        OverScroller overScroller = this.f10394e;
        if (overScroller == null || this.j < this.k) {
            return false;
        }
        overScroller.fling(0, (int) this.f10396g, 0, i2, 0, 0, AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, 10000);
        invalidate();
        return true;
    }

    public final void k() {
        c cVar;
        this.f10398i.computeCurrentVelocity(1000);
        int yVelocity = (int) this.f10398i.getYVelocity();
        this.v = yVelocity;
        if (this.o) {
            float f2 = this.t;
            if (f2 > 0.0f) {
                this.v = (int) (yVelocity * f2);
            }
        }
        if (Math.abs(this.v) > this.q && ((this.v > 0 && this.j < this.k) || (this.v < 0 && this.j >= this.u))) {
            a aVar = this.p;
            r0 = aVar != null ? aVar.a(this.o) : false;
            if (!r0) {
                j(-this.v);
            }
        }
        if (!r0 && (cVar = this.l) != null) {
            cVar.a(this.o);
        }
        this.f10398i.recycle();
        this.f10398i = null;
    }

    public final void l(Context context) {
        this.f10394e = new OverScroller(context);
        this.f10397h = new GestureDetector(context, new d(this));
        setMotionEventSplittingEnabled(false);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = this.j > ((int) motionEvent.getY());
        this.s = z;
        if ((!z || this.r) && this.f10397h.onTouchEvent(motionEvent)) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.n = false;
        int y = (int) motionEvent.getY();
        if (this.j <= y || this.r) {
            super.onTouchEvent(motionEvent);
            if (this.f10398i == null) {
                this.f10398i = VelocityTracker.obtain();
            }
            this.f10398i.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    k();
                } else if (action != 2) {
                    if (action == 3 && this.r) {
                        k();
                    }
                } else {
                    float rawY = motionEvent.getRawY();
                    this.f10395f = rawY;
                    int i2 = i((int) (this.f10396g - rawY));
                    scrollBy(0, i2);
                    this.f10396g -= i2;
                }
            } else if (!this.f10394e.isFinished()) {
                this.f10394e.abortAnimation();
            }
            return this.j <= y;
        }
        return false;
    }

    public void setAutoScroll2TopListener(b bVar) {
        this.m = bVar;
    }

    public void setInterceptFlingListener(a aVar) {
        this.p = aVar;
    }

    public void setInternalWebView(d.a.l0.a.p.e.c cVar) {
        this.w = cVar;
    }

    public void setMinFlingVelocity(int i2) {
        this.q = n0.g(i2);
    }

    public void setOnUpListener(c cVar) {
        this.l = cVar;
    }

    public void setTopLimit(int i2) {
        this.k = i2;
    }

    public void setTopMargin(int i2) {
        this.j = i2;
    }

    public void setUpYVelocityRatio(float f2) {
        this.t = f2;
    }

    public WebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 0;
        this.k = 0;
        this.q = 2000;
        this.r = false;
        this.t = 1.0f;
        this.u = 0;
        l(context);
    }

    public WebViewContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = 0;
        this.k = 0;
        this.q = 2000;
        this.r = false;
        this.t = 1.0f;
        this.u = 0;
        l(context);
    }
}
