package com.baidu.live.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class DanceRectView extends View {
    private RectF[] bUV;
    private a[] bUW;
    private float bUX;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.bUW != null && this.mValueAnimator != null) {
            XC();
            this.mValueAnimator.start();
        }
    }

    public void Xz() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bUX = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.bUV[i5].set(paddingLeft2, this.bUX * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bUV != null && this.bUW != null) {
            for (int i = 0; i < 4; i++) {
                this.bUV[i].top = getPaddingTop() + (this.bUX * this.bUW[i].bVb);
                canvas.drawRoundRect(this.bUV[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        rX();
        XA();
        XB();
        XD();
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.DanceRectView);
        this.mColor = obtainStyledAttributes.getColor(a.j.DanceRectView_sdk_drv_color, -1);
        this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(a.j.DanceRectView_sdk_drv_radius, 0);
        obtainStyledAttributes.recycle();
    }

    private void rX() {
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mColor);
    }

    private void XA() {
        this.bUV = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.bUV[i] = new RectF();
        }
    }

    private void XB() {
        this.bUW = new a[4];
        for (int i = 0; i < 4; i++) {
            this.bUW[i] = new a();
            this.bUW[i].bUZ = 0.25f;
        }
        XC();
    }

    private void XC() {
        int i = 0;
        while (i < 4) {
            this.bUW[i].up = i != 0;
            a aVar = this.bUW[i];
            float f = (i * 1.0f) / 4.0f;
            this.bUW[i].bVb = f;
            aVar.bVa = f;
            i++;
        }
    }

    private void XD() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.bUW) {
                    aVar.XE();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.bUW) {
                    aVar.XF();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.bUW) {
                    aVar.G(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        float bUZ;
        float bVa;
        float bVb;
        boolean up;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void XE() {
            if (this.bVb <= 0.0f) {
                this.bVb = 0.0f;
                this.bVa = 0.0f;
                this.up = false;
            } else if (this.bVb >= 1.0f - this.bUZ) {
                float f = 1.0f - this.bUZ;
                this.bVb = f;
                this.bVa = f;
                this.up = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.bUZ) {
                if (this.up) {
                    float f3 = this.bVa - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.bVa + f;
                    if (f2 > 1.0f - this.bUZ) {
                        f2 = 1.0f - this.bUZ;
                    }
                }
                this.bVb = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void XF() {
            if (this.up) {
                this.bVb = this.bVa - this.bUZ;
            } else {
                this.bVb = this.bVa + this.bUZ;
            }
            this.bVa = this.bVb;
            XE();
        }
    }
}
