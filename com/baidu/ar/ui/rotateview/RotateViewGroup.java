package com.baidu.ar.ui.rotateview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.ar.rotate.Orientation;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes3.dex */
public class RotateViewGroup extends ViewGroup implements IRotateView {
    private int a;
    private boolean b;
    private final Matrix c;
    private final Rect d;
    private final RectF e;
    private final RectF f;
    private final float[] g;
    private final float[] h;
    private boolean i;

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = RotateViewUtils.a(0);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public RotateViewGroup(Context context) {
        this(context, null);
    }

    public RotateViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Matrix();
        this.d = new Rect();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new float[2];
        this.h = new float[2];
        this.i = true;
        setWillNotDraw(false);
    }

    private View getView() {
        return getChildAt(0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.a, getWidth() / 2.0f, getHeight() / 2.0f);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.g[0] = motionEvent.getX();
        this.g[1] = motionEvent.getY();
        this.c.mapPoints(this.h, this.g);
        motionEvent.setLocation(this.h[0], this.h[1]);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        motionEvent.setLocation(this.g[0], this.g[1]);
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public int getAngle() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.i || z) {
            RectF rectF = this.e;
            RectF rectF2 = this.f;
            rectF.set(0.0f, 0.0f, i3 - i, i4 - i2);
            float f = this.a;
            if (this.a == 270 || this.a == 90) {
                f = 360 - this.a;
            }
            this.c.setRotate(f, rectF.centerX(), rectF.centerY());
            this.c.mapRect(rectF2, rectF);
            rectF2.round(this.d);
            this.i = false;
        }
        View view = getView();
        if (view != null) {
            view.layout(this.d.left, this.d.top, this.d.right, this.d.bottom);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = getView();
        if (view == null) {
            super.onMeasure(i, i2);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.b) {
            if (this.a != layoutParams.a) {
                layoutParams.a = this.a;
                this.i = true;
            }
        } else if (this.a != layoutParams.a) {
            this.a = layoutParams.a;
            this.i = true;
        }
        if (Math.abs(this.a % SubsamplingScaleImageView.ORIENTATION_180) == 90) {
            measureChild(view, i2, i);
            setMeasuredDimension(View.resolveSize(view.getMeasuredHeight(), i), View.resolveSize(view.getMeasuredWidth(), i2));
            return;
        }
        measureChild(view, i, i2);
        setMeasuredDimension(View.resolveSize(view.getMeasuredWidth(), i), View.resolveSize(view.getMeasuredHeight(), i2));
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void requestOrientation(Orientation orientation) {
        RotateViewUtils.updateOrientation(this, orientation);
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void requestOrientation(Orientation orientation, boolean z) {
        RotateViewUtils.a(this, orientation, z);
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void setAngle(int i) {
        this.a = RotateViewUtils.a(i);
        this.b = true;
        requestLayout();
    }
}
