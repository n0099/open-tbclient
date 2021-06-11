package com.baidu.swan.facade.picture.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class BdImageViewTouch extends BdImageViewTouchBase {
    public ScaleGestureDetector D;
    public GestureDetector E;
    public int F;
    public GestureDetector.OnGestureListener G;
    public ScaleGestureDetector.OnScaleGestureListener H;
    public boolean I;
    public boolean J;
    public boolean K;
    public b L;
    public c M;

    /* loaded from: classes3.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            BdImageViewTouch bdImageViewTouch = BdImageViewTouch.this;
            if (bdImageViewTouch.I) {
                bdImageViewTouch.k = true;
                float scale = bdImageViewTouch.getScale();
                BdImageViewTouch bdImageViewTouch2 = BdImageViewTouch.this;
                BdImageViewTouch.this.C(Math.min(BdImageViewTouch.this.getMaxScale(), Math.max(bdImageViewTouch2.F(scale, bdImageViewTouch2.getMaxScale()), BdImageViewTouch.this.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
                BdImageViewTouch.this.invalidate();
            }
            if (BdImageViewTouch.this.L != null) {
                BdImageViewTouch.this.L.a();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return BdImageViewTouch.this.G(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (BdImageViewTouch.this.K && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1) {
                ScaleGestureDetector scaleGestureDetector = BdImageViewTouch.this.D;
                if ((scaleGestureDetector == null || !scaleGestureDetector.isInProgress()) && BdImageViewTouch.this.getScale() != 1.0f) {
                    return BdImageViewTouch.this.H(motionEvent, motionEvent2, f2, f3);
                }
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            ScaleGestureDetector scaleGestureDetector;
            if (!BdImageViewTouch.this.isLongClickable() || (scaleGestureDetector = BdImageViewTouch.this.D) == null || scaleGestureDetector.isInProgress()) {
                return;
            }
            BdImageViewTouch.this.setPressed(true);
            BdImageViewTouch.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (BdImageViewTouch.this.K && motionEvent != null && motionEvent2 != null && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1) {
                ScaleGestureDetector scaleGestureDetector = BdImageViewTouch.this.D;
                if (scaleGestureDetector == null || !scaleGestureDetector.isInProgress()) {
                    return BdImageViewTouch.this.I(motionEvent, motionEvent2, f2, f3);
                }
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (BdImageViewTouch.this.M != null) {
                BdImageViewTouch.this.M.a();
            }
            return BdImageViewTouch.this.J(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return BdImageViewTouch.this.K(motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes3.dex */
    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f11536e = false;

        public d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
            float scale = BdImageViewTouch.this.getScale() * scaleGestureDetector.getScaleFactor();
            BdImageViewTouch bdImageViewTouch = BdImageViewTouch.this;
            if (bdImageViewTouch.J) {
                if (this.f11536e && currentSpan != 0.0f) {
                    bdImageViewTouch.k = true;
                    BdImageViewTouch.this.B(Math.min(bdImageViewTouch.getMaxScale(), Math.max(scale, BdImageViewTouch.this.getMinScale() - 0.0f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    BdImageViewTouch.this.invalidate();
                    return true;
                } else if (!this.f11536e) {
                    this.f11536e = true;
                }
            }
            return true;
        }
    }

    public BdImageViewTouch(Context context) {
        super(context);
        this.I = true;
        this.J = true;
        this.K = true;
    }

    public float F(float f2, float f3) {
        if (this.F == 1) {
            this.F = -1;
            return f3;
        }
        this.F = 1;
        return 1.0f;
    }

    public boolean G(MotionEvent motionEvent) {
        return true;
    }

    public boolean H(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(f2) > 800.0f || Math.abs(f3) > 800.0f) {
            this.k = true;
            x(x / 2.0f, y / 2.0f, 300.0d);
            invalidate();
            return true;
        }
        return false;
    }

    public boolean I(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (getScale() == 1.0f) {
            return false;
        }
        this.k = true;
        w(-f2, -f3);
        invalidate();
        return true;
    }

    public boolean J(MotionEvent motionEvent) {
        return true;
    }

    public boolean K(MotionEvent motionEvent) {
        return true;
    }

    public boolean L(MotionEvent motionEvent) {
        if (getScale() < getMinScale()) {
            A(getMinScale(), 50.0f);
            return true;
        }
        return true;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void d(Drawable drawable, Matrix matrix, float f2, float f3) {
        super.d(drawable, matrix, f2, f3);
        getMaxScale();
    }

    public boolean getDoubleTapEnabled() {
        return this.I;
    }

    public GestureDetector.OnGestureListener getGestureListener() {
        return new a();
    }

    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new d();
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void n(Context context, AttributeSet attributeSet, int i2) {
        super.n(context, attributeSet, i2);
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.G = getGestureListener();
        this.E = new GestureDetector(getContext(), this.G, null);
        this.H = getScaleListener();
        this.D = new ScaleGestureDetector(getContext(), this.H);
        this.F = 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ScaleGestureDetector scaleGestureDetector = this.D;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(motionEvent);
            if (!this.D.isInProgress()) {
                this.E.onTouchEvent(motionEvent);
            }
        }
        if ((motionEvent.getAction() & 255) == 1) {
            return L(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void s(float f2) {
        if (f2 < getMinScale()) {
            A(getMinScale(), 50.0f);
        }
    }

    public void setDoubleTapEnabled(boolean z) {
        this.I = z;
    }

    public void setDoubleTapListener(b bVar) {
        this.L = bVar;
    }

    public void setScaleEnabled(boolean z) {
        this.J = z;
    }

    public void setScrollEnabled(boolean z) {
        this.K = z;
    }

    public void setSingleTapListener(c cVar) {
        this.M = cVar;
    }

    public BdImageViewTouch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdImageViewTouch(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.I = true;
        this.J = true;
        this.K = true;
    }
}
