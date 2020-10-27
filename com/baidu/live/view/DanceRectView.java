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
    private RectF[] bGk;
    private a[] bGl;
    private float bGm;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.bGl != null && this.mValueAnimator != null) {
            Uh();
            this.mValueAnimator.start();
        }
    }

    public void Ue() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bGm = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.bGk[i5].set(paddingLeft2, this.bGm * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bGk != null && this.bGl != null) {
            for (int i = 0; i < 4; i++) {
                this.bGk[i].top = getPaddingTop() + (this.bGm * this.bGl[i].bGq);
                canvas.drawRoundRect(this.bGk[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        sw();
        Uf();
        Ug();
        Ui();
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

    private void Uf() {
        this.bGk = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.bGk[i] = new RectF();
        }
    }

    private void Ug() {
        this.bGl = new a[4];
        for (int i = 0; i < 4; i++) {
            this.bGl[i] = new a();
            this.bGl[i].bGo = 0.25f;
        }
        Uh();
    }

    private void Uh() {
        int i = 0;
        while (i < 4) {
            this.bGl[i].bGr = i != 0;
            a aVar = this.bGl[i];
            float f = (i * 1.0f) / 4.0f;
            this.bGl[i].bGq = f;
            aVar.bGp = f;
            i++;
        }
    }

    private void Ui() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.bGl) {
                    aVar.Uj();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.bGl) {
                    aVar.Uk();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.bGl) {
                    aVar.D(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        float bGo;
        float bGp;
        float bGq;
        boolean bGr;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Uj() {
            if (this.bGq <= 0.0f) {
                this.bGq = 0.0f;
                this.bGp = 0.0f;
                this.bGr = false;
            } else if (this.bGq >= 1.0f - this.bGo) {
                float f = 1.0f - this.bGo;
                this.bGq = f;
                this.bGp = f;
                this.bGr = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.bGo) {
                if (this.bGr) {
                    float f3 = this.bGp - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.bGp + f;
                    if (f2 > 1.0f - this.bGo) {
                        f2 = 1.0f - this.bGo;
                    }
                }
                this.bGq = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Uk() {
            if (this.bGr) {
                this.bGq = this.bGp - this.bGo;
            } else {
                this.bGq = this.bGp + this.bGo;
            }
            this.bGp = this.bGq;
            Uj();
        }
    }
}
