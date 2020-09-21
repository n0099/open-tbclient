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
    private RectF[] bwL;
    private a[] bwM;
    private float bwN;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.bwM != null && this.mValueAnimator != null) {
            Rp();
            this.mValueAnimator.start();
        }
    }

    public void Rm() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bwN = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.bwL[i5].set(paddingLeft2, this.bwN * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bwL != null && this.bwM != null) {
            for (int i = 0; i < 4; i++) {
                this.bwL[i].top = getPaddingTop() + (this.bwN * this.bwM[i].bwR);
                canvas.drawRoundRect(this.bwL[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        sw();
        Rn();
        Ro();
        Rq();
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.DanceRectView);
        this.mColor = obtainStyledAttributes.getColor(a.k.DanceRectView_sdk_drv_color, -1);
        this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(a.k.DanceRectView_sdk_drv_radius, 0);
        obtainStyledAttributes.recycle();
    }

    private void sw() {
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mColor);
    }

    private void Rn() {
        this.bwL = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.bwL[i] = new RectF();
        }
    }

    private void Ro() {
        this.bwM = new a[4];
        for (int i = 0; i < 4; i++) {
            this.bwM[i] = new a();
            this.bwM[i].bwP = 0.25f;
        }
        Rp();
    }

    private void Rp() {
        int i = 0;
        while (i < 4) {
            this.bwM[i].bwS = i != 0;
            a aVar = this.bwM[i];
            float f = (i * 1.0f) / 4.0f;
            this.bwM[i].bwR = f;
            aVar.bwQ = f;
            i++;
        }
    }

    private void Rq() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.bwM) {
                    aVar.Rr();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.bwM) {
                    aVar.Rs();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.bwM) {
                    aVar.v(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        float bwP;
        float bwQ;
        float bwR;
        boolean bwS;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Rr() {
            if (this.bwR <= 0.0f) {
                this.bwR = 0.0f;
                this.bwQ = 0.0f;
                this.bwS = false;
            } else if (this.bwR >= 1.0f - this.bwP) {
                float f = 1.0f - this.bwP;
                this.bwR = f;
                this.bwQ = f;
                this.bwS = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.bwP) {
                if (this.bwS) {
                    float f3 = this.bwQ - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.bwQ + f;
                    if (f2 > 1.0f - this.bwP) {
                        f2 = 1.0f - this.bwP;
                    }
                }
                this.bwR = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Rs() {
            if (this.bwS) {
                this.bwR = this.bwQ - this.bwP;
            } else {
                this.bwR = this.bwQ + this.bwP;
            }
            this.bwQ = this.bwR;
            Rr();
        }
    }
}
