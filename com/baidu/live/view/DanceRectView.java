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
    private RectF[] bDo;
    private a[] bDp;
    private float bDq;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.bDp != null && this.mValueAnimator != null) {
            Ti();
            this.mValueAnimator.start();
        }
    }

    public void Tf() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bDq = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.bDo[i5].set(paddingLeft2, this.bDq * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bDo != null && this.bDp != null) {
            for (int i = 0; i < 4; i++) {
                this.bDo[i].top = getPaddingTop() + (this.bDq * this.bDp[i].bDu);
                canvas.drawRoundRect(this.bDo[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        sw();
        Tg();
        Th();
        Tj();
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

    private void Tg() {
        this.bDo = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.bDo[i] = new RectF();
        }
    }

    private void Th() {
        this.bDp = new a[4];
        for (int i = 0; i < 4; i++) {
            this.bDp[i] = new a();
            this.bDp[i].bDs = 0.25f;
        }
        Ti();
    }

    private void Ti() {
        int i = 0;
        while (i < 4) {
            this.bDp[i].bDv = i != 0;
            a aVar = this.bDp[i];
            float f = (i * 1.0f) / 4.0f;
            this.bDp[i].bDu = f;
            aVar.bDt = f;
            i++;
        }
    }

    private void Tj() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.bDp) {
                    aVar.Tk();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.bDp) {
                    aVar.Tl();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.bDp) {
                    aVar.B(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        float bDs;
        float bDt;
        float bDu;
        boolean bDv;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Tk() {
            if (this.bDu <= 0.0f) {
                this.bDu = 0.0f;
                this.bDt = 0.0f;
                this.bDv = false;
            } else if (this.bDu >= 1.0f - this.bDs) {
                float f = 1.0f - this.bDs;
                this.bDu = f;
                this.bDt = f;
                this.bDv = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.bDs) {
                if (this.bDv) {
                    float f3 = this.bDt - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.bDt + f;
                    if (f2 > 1.0f - this.bDs) {
                        f2 = 1.0f - this.bDs;
                    }
                }
                this.bDu = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Tl() {
            if (this.bDv) {
                this.bDu = this.bDt - this.bDs;
            } else {
                this.bDu = this.bDt + this.bDs;
            }
            this.bDt = this.bDu;
            Tk();
        }
    }
}
