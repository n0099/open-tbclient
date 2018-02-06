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
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes3.dex */
public class RotateViewGroup extends ViewGroup {
    private int a;
    private boolean b;
    private boolean c;
    private final Matrix d;
    private final Rect e;
    private final RectF f;
    private final RectF g;
    private final float[] h;
    private final float[] i;
    private boolean j;

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int a;
        public boolean b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = RotateViewGroup.b(0);
            this.b = true;
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
        this.b = true;
        this.d = new Matrix();
        this.e = new Rect();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new float[2];
        this.i = new float[2];
        this.j = true;
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i) {
        if (i < 0) {
            i = (i % 360) + 360;
        }
        return Math.round(i / 90.0f) * 90;
    }

    public void a() {
        setAngle(-90);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.rotate(-this.a, getWidth() / 2.0f, getHeight() / 2.0f);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.h[0] = motionEvent.getX();
        this.h[1] = motionEvent.getY();
        this.d.mapPoints(this.i, this.h);
        motionEvent.setLocation(this.i[0], this.i[1]);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        motionEvent.setLocation(this.h[0], this.h[1]);
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

    public View getView() {
        return getChildAt(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.j || z) {
            RectF rectF = this.f;
            RectF rectF2 = this.g;
            rectF.set(0.0f, 0.0f, i3 - i, i4 - i2);
            this.d.setRotate(this.a, rectF.centerX(), rectF.centerY());
            this.d.mapRect(rectF2, rectF);
            rectF2.round(this.e);
            this.j = false;
        }
        View view = getView();
        if (view != null) {
            view.layout(this.e.left, this.e.top, this.e.right, this.e.bottom);
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
        this.b = layoutParams.b;
        if (this.c) {
            if (this.a != layoutParams.a) {
                layoutParams.a = this.a;
                this.j = true;
            }
        } else if (this.a != layoutParams.a) {
            this.a = layoutParams.a;
            this.j = true;
        }
        if (Math.abs(this.a % SubsamplingScaleImageView.ORIENTATION_180) == 90) {
            measureChild(view, i2, i);
            setMeasuredDimension(resolveSize(view.getMeasuredHeight(), i), resolveSize(view.getMeasuredWidth(), i2));
            return;
        }
        measureChild(view, i, i2);
        setMeasuredDimension(resolveSize(view.getMeasuredWidth(), i), resolveSize(view.getMeasuredHeight(), i2));
    }

    public void setAngle(int i) {
        this.a = b(i);
        this.c = true;
        requestLayout();
    }

    public void setRecycle(boolean z) {
        this.b = z;
    }
}
