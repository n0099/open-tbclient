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
    public GestureDetector A;
    public int B;
    public GestureDetector.OnGestureListener C;
    public ScaleGestureDetector.OnScaleGestureListener D;
    public boolean E;
    public boolean F;
    public boolean G;
    public b H;
    public c I;
    public ScaleGestureDetector z;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public boolean G(MotionEvent motionEvent) {
        return true;
    }

    public boolean J(MotionEvent motionEvent) {
        return true;
    }

    public boolean K(MotionEvent motionEvent) {
        return true;
    }

    /* loaded from: classes3.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return BdImageViewTouch.this.G(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            ScaleGestureDetector scaleGestureDetector;
            if (BdImageViewTouch.this.isLongClickable() && (scaleGestureDetector = BdImageViewTouch.this.z) != null && !scaleGestureDetector.isInProgress()) {
                BdImageViewTouch.this.setPressed(true);
                BdImageViewTouch.this.performLongClick();
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (BdImageViewTouch.this.I != null) {
                BdImageViewTouch.this.I.a();
            }
            return BdImageViewTouch.this.J(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return BdImageViewTouch.this.K(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            BdImageViewTouch bdImageViewTouch = BdImageViewTouch.this;
            if (bdImageViewTouch.E) {
                bdImageViewTouch.g = true;
                float scale = bdImageViewTouch.getScale();
                BdImageViewTouch bdImageViewTouch2 = BdImageViewTouch.this;
                BdImageViewTouch.this.C(Math.min(BdImageViewTouch.this.getMaxScale(), Math.max(bdImageViewTouch2.F(scale, bdImageViewTouch2.getMaxScale()), BdImageViewTouch.this.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
                BdImageViewTouch.this.invalidate();
            }
            if (BdImageViewTouch.this.H != null) {
                BdImageViewTouch.this.H.a();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!BdImageViewTouch.this.G || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            ScaleGestureDetector scaleGestureDetector = BdImageViewTouch.this.z;
            if ((scaleGestureDetector != null && scaleGestureDetector.isInProgress()) || BdImageViewTouch.this.getScale() == 1.0f) {
                return false;
            }
            return BdImageViewTouch.this.H(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!BdImageViewTouch.this.G || motionEvent == null || motionEvent2 == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            ScaleGestureDetector scaleGestureDetector = BdImageViewTouch.this.z;
            if (scaleGestureDetector != null && scaleGestureDetector.isInProgress()) {
                return false;
            }
            return BdImageViewTouch.this.I(motionEvent, motionEvent2, f, f2);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public boolean a = false;

        public d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
            float scale = BdImageViewTouch.this.getScale() * scaleGestureDetector.getScaleFactor();
            BdImageViewTouch bdImageViewTouch = BdImageViewTouch.this;
            if (bdImageViewTouch.F) {
                if (this.a && currentSpan != 0.0f) {
                    bdImageViewTouch.g = true;
                    BdImageViewTouch.this.B(Math.min(bdImageViewTouch.getMaxScale(), Math.max(scale, BdImageViewTouch.this.getMinScale() - 0.0f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    BdImageViewTouch.this.invalidate();
                    return true;
                } else if (!this.a) {
                    this.a = true;
                }
            }
            return true;
        }
    }

    public BdImageViewTouch(Context context) {
        super(context);
        this.E = true;
        this.F = true;
        this.G = true;
    }

    public boolean L(MotionEvent motionEvent) {
        if (getScale() < getMinScale()) {
            A(getMinScale(), 50.0f);
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ScaleGestureDetector scaleGestureDetector = this.z;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(motionEvent);
            if (!this.z.isInProgress()) {
                this.A.onTouchEvent(motionEvent);
            }
        }
        if ((motionEvent.getAction() & 255) != 1) {
            return true;
        }
        return L(motionEvent);
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void s(float f) {
        if (f < getMinScale()) {
            A(getMinScale(), 50.0f);
        }
    }

    public void setDoubleTapEnabled(boolean z) {
        this.E = z;
    }

    public void setDoubleTapListener(b bVar) {
        this.H = bVar;
    }

    public void setScaleEnabled(boolean z) {
        this.F = z;
    }

    public void setScrollEnabled(boolean z) {
        this.G = z;
    }

    public void setSingleTapListener(c cVar) {
        this.I = cVar;
    }

    public BdImageViewTouch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public float F(float f, float f2) {
        if (this.B == 1) {
            this.B = -1;
            return f2;
        }
        this.B = 1;
        return 1.0f;
    }

    public BdImageViewTouch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.E = true;
        this.F = true;
        this.G = true;
    }

    public boolean H(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(f) <= 800.0f && Math.abs(f2) <= 800.0f) {
            return false;
        }
        this.g = true;
        x(x / 2.0f, y / 2.0f, 300.0d);
        invalidate();
        return true;
    }

    public boolean I(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (getScale() == 1.0f) {
            return false;
        }
        this.g = true;
        w(-f, -f2);
        invalidate();
        return true;
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void d(Drawable drawable, Matrix matrix, float f, float f2) {
        super.d(drawable, matrix, f, f2);
        getMaxScale();
    }

    public boolean getDoubleTapEnabled() {
        return this.E;
    }

    public GestureDetector.OnGestureListener getGestureListener() {
        return new a();
    }

    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new d();
    }

    @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase
    public void n(Context context, AttributeSet attributeSet, int i) {
        super.n(context, attributeSet, i);
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.C = getGestureListener();
        this.A = new GestureDetector(getContext(), this.C, null);
        this.D = getScaleListener();
        this.z = new ScaleGestureDetector(getContext(), this.D);
        this.B = 1;
    }
}
