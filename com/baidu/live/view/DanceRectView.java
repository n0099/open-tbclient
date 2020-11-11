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
/* loaded from: classes4.dex */
public class DanceRectView extends View {
    private RectF[] bLP;
    private a[] bLQ;
    private float bLR;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.bLQ != null && this.mValueAnimator != null) {
            WH();
            this.mValueAnimator.start();
        }
    }

    public void WE() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bLR = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.bLP[i5].set(paddingLeft2, this.bLR * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bLP != null && this.bLQ != null) {
            for (int i = 0; i < 4; i++) {
                this.bLP[i].top = getPaddingTop() + (this.bLR * this.bLQ[i].bLV);
                canvas.drawRoundRect(this.bLP[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        sw();
        WF();
        WG();
        WI();
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.DanceRectView);
        this.mColor = obtainStyledAttributes.getColor(a.j.DanceRectView_sdk_drv_color, -1);
        this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(a.j.DanceRectView_sdk_drv_radius, 0);
        obtainStyledAttributes.recycle();
    }

    private void sw() {
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mColor);
    }

    private void WF() {
        this.bLP = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.bLP[i] = new RectF();
        }
    }

    private void WG() {
        this.bLQ = new a[4];
        for (int i = 0; i < 4; i++) {
            this.bLQ[i] = new a();
            this.bLQ[i].bLT = 0.25f;
        }
        WH();
    }

    private void WH() {
        int i = 0;
        while (i < 4) {
            this.bLQ[i].bLW = i != 0;
            a aVar = this.bLQ[i];
            float f = (i * 1.0f) / 4.0f;
            this.bLQ[i].bLV = f;
            aVar.bLU = f;
            i++;
        }
    }

    private void WI() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.bLQ) {
                    aVar.WJ();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.bLQ) {
                    aVar.WK();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.bLQ) {
                    aVar.E(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        float bLT;
        float bLU;
        float bLV;
        boolean bLW;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void WJ() {
            if (this.bLV <= 0.0f) {
                this.bLV = 0.0f;
                this.bLU = 0.0f;
                this.bLW = false;
            } else if (this.bLV >= 1.0f - this.bLT) {
                float f = 1.0f - this.bLT;
                this.bLV = f;
                this.bLU = f;
                this.bLW = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.bLT) {
                if (this.bLW) {
                    float f3 = this.bLU - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.bLU + f;
                    if (f2 > 1.0f - this.bLT) {
                        f2 = 1.0f - this.bLT;
                    }
                }
                this.bLV = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void WK() {
            if (this.bLW) {
                this.bLV = this.bLU - this.bLT;
            } else {
                this.bLV = this.bLU + this.bLT;
            }
            this.bLU = this.bLV;
            WJ();
        }
    }
}
