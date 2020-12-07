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
    private RectF[] bPm;
    private a[] bPn;
    private float bPo;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.bPn != null && this.mValueAnimator != null) {
            Yy();
            this.mValueAnimator.start();
        }
    }

    public void Yv() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bPo = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.bPm[i5].set(paddingLeft2, this.bPo * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bPm != null && this.bPn != null) {
            for (int i = 0; i < 4; i++) {
                this.bPm[i].top = getPaddingTop() + (this.bPo * this.bPn[i].bPs);
                canvas.drawRoundRect(this.bPm[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        sz();
        Yw();
        Yx();
        Yz();
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.DanceRectView);
        this.mColor = obtainStyledAttributes.getColor(a.j.DanceRectView_sdk_drv_color, -1);
        this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(a.j.DanceRectView_sdk_drv_radius, 0);
        obtainStyledAttributes.recycle();
    }

    private void sz() {
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mColor);
    }

    private void Yw() {
        this.bPm = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.bPm[i] = new RectF();
        }
    }

    private void Yx() {
        this.bPn = new a[4];
        for (int i = 0; i < 4; i++) {
            this.bPn[i] = new a();
            this.bPn[i].bPq = 0.25f;
        }
        Yy();
    }

    private void Yy() {
        int i = 0;
        while (i < 4) {
            this.bPn[i].up = i != 0;
            a aVar = this.bPn[i];
            float f = (i * 1.0f) / 4.0f;
            this.bPn[i].bPs = f;
            aVar.bPr = f;
            i++;
        }
    }

    private void Yz() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.bPn) {
                    aVar.YA();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.bPn) {
                    aVar.YB();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.bPn) {
                    aVar.C(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        float bPq;
        float bPr;
        float bPs;
        boolean up;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void YA() {
            if (this.bPs <= 0.0f) {
                this.bPs = 0.0f;
                this.bPr = 0.0f;
                this.up = false;
            } else if (this.bPs >= 1.0f - this.bPq) {
                float f = 1.0f - this.bPq;
                this.bPs = f;
                this.bPr = f;
                this.up = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.bPq) {
                if (this.up) {
                    float f3 = this.bPr - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.bPr + f;
                    if (f2 > 1.0f - this.bPq) {
                        f2 = 1.0f - this.bPq;
                    }
                }
                this.bPs = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void YB() {
            if (this.up) {
                this.bPs = this.bPr - this.bPq;
            } else {
                this.bPs = this.bPr + this.bPq;
            }
            this.bPr = this.bPs;
            YA();
        }
    }
}
