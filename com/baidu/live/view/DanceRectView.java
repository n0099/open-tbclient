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
/* loaded from: classes7.dex */
public class DanceRectView extends View {
    private RectF[] btp;
    private a[] btq;
    private float btr;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.btq != null && this.mValueAnimator != null) {
            QF();
            this.mValueAnimator.start();
        }
    }

    public void QC() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.btr = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.btp[i5].set(paddingLeft2, this.btr * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.btp != null && this.btq != null) {
            for (int i = 0; i < 4; i++) {
                this.btp[i].top = getPaddingTop() + (this.btr * this.btq[i].btv);
                canvas.drawRoundRect(this.btp[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        sr();
        QD();
        QE();
        QG();
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.DanceRectView);
        this.mColor = obtainStyledAttributes.getColor(a.k.DanceRectView_sdk_drv_color, -1);
        this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(a.k.DanceRectView_sdk_drv_radius, 0);
        obtainStyledAttributes.recycle();
    }

    private void sr() {
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mColor);
    }

    private void QD() {
        this.btp = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.btp[i] = new RectF();
        }
    }

    private void QE() {
        this.btq = new a[4];
        for (int i = 0; i < 4; i++) {
            this.btq[i] = new a();
            this.btq[i].btt = 0.25f;
        }
        QF();
    }

    private void QF() {
        int i = 0;
        while (i < 4) {
            this.btq[i].btw = i != 0;
            a aVar = this.btq[i];
            float f = (i * 1.0f) / 4.0f;
            this.btq[i].btv = f;
            aVar.btu = f;
            i++;
        }
    }

    private void QG() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.btq) {
                    aVar.QH();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.btq) {
                    aVar.QI();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.btq) {
                    aVar.v(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        float btt;
        float btu;
        float btv;
        boolean btw;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void QH() {
            if (this.btv <= 0.0f) {
                this.btv = 0.0f;
                this.btu = 0.0f;
                this.btw = false;
            } else if (this.btv >= 1.0f - this.btt) {
                float f = 1.0f - this.btt;
                this.btv = f;
                this.btu = f;
                this.btw = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.btt) {
                if (this.btw) {
                    float f3 = this.btu - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.btu + f;
                    if (f2 > 1.0f - this.btt) {
                        f2 = 1.0f - this.btt;
                    }
                }
                this.btv = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void QI() {
            if (this.btw) {
                this.btv = this.btu - this.btt;
            } else {
                this.btv = this.btu + this.btt;
            }
            this.btu = this.btv;
            QH();
        }
    }
}
