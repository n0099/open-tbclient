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
/* loaded from: classes11.dex */
public class DanceRectView extends View {
    private RectF[] bTv;
    private a[] bTw;
    private float bTx;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.bTw != null && this.mValueAnimator != null) {
            Xz();
            this.mValueAnimator.start();
        }
    }

    public void Xw() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bTx = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.bTv[i5].set(paddingLeft2, this.bTx * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bTv != null && this.bTw != null) {
            for (int i = 0; i < 4; i++) {
                this.bTv[i].top = getPaddingTop() + (this.bTx * this.bTw[i].bTB);
                canvas.drawRoundRect(this.bTv[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        rX();
        Xx();
        Xy();
        XA();
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

    private void Xx() {
        this.bTv = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.bTv[i] = new RectF();
        }
    }

    private void Xy() {
        this.bTw = new a[4];
        for (int i = 0; i < 4; i++) {
            this.bTw[i] = new a();
            this.bTw[i].bTz = 0.25f;
        }
        Xz();
    }

    private void Xz() {
        int i = 0;
        while (i < 4) {
            this.bTw[i].up = i != 0;
            a aVar = this.bTw[i];
            float f = (i * 1.0f) / 4.0f;
            this.bTw[i].bTB = f;
            aVar.bTA = f;
            i++;
        }
    }

    private void XA() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.bTw) {
                    aVar.XB();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.bTw) {
                    aVar.XC();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.bTw) {
                    aVar.C(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        float bTA;
        float bTB;
        float bTz;
        boolean up;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void XB() {
            if (this.bTB <= 0.0f) {
                this.bTB = 0.0f;
                this.bTA = 0.0f;
                this.up = false;
            } else if (this.bTB >= 1.0f - this.bTz) {
                float f = 1.0f - this.bTz;
                this.bTB = f;
                this.bTA = f;
                this.up = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.bTz) {
                if (this.up) {
                    float f3 = this.bTA - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.bTA + f;
                    if (f2 > 1.0f - this.bTz) {
                        f2 = 1.0f - this.bTz;
                    }
                }
                this.bTB = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void XC() {
            if (this.up) {
                this.bTB = this.bTA - this.bTz;
            } else {
                this.bTB = this.bTA + this.bTz;
            }
            this.bTA = this.bTB;
            XB();
        }
    }
}
