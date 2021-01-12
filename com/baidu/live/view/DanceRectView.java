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
    private RectF[] bPF;
    private a[] bPG;
    private float bPH;
    private int mColor;
    private Paint mPaint;
    private float mRadius;
    private ValueAnimator mValueAnimator;

    public DanceRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void startAnim() {
        if (this.bPG != null && this.mValueAnimator != null) {
            VQ();
            this.mValueAnimator.start();
        }
    }

    public void VN() {
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bPH = (i2 - getPaddingTop()) - getPaddingBottom();
        float paddingLeft = (((i - getPaddingLeft()) - getPaddingRight()) * 1.0f) / 7.0f;
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < 4; i5++) {
            this.bPF[i5].set(paddingLeft2, this.bPH * i5, paddingLeft2 + paddingLeft, i2 - getPaddingBottom());
            paddingLeft2 = (int) (paddingLeft2 + (2.0f * paddingLeft));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bPF != null && this.bPG != null) {
            for (int i = 0; i < 4; i++) {
                this.bPF[i].top = getPaddingTop() + (this.bPH * this.bPG[i].bPL);
                canvas.drawRoundRect(this.bPF[i], this.mRadius, this.mRadius, this.mPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        sa();
        VO();
        VP();
        VR();
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.DanceRectView);
        this.mColor = obtainStyledAttributes.getColor(a.j.DanceRectView_sdk_drv_color, -1);
        this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(a.j.DanceRectView_sdk_drv_radius, 0);
        obtainStyledAttributes.recycle();
    }

    private void sa() {
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mColor);
    }

    private void VO() {
        this.bPF = new RectF[4];
        for (int i = 0; i < 4; i++) {
            this.bPF[i] = new RectF();
        }
    }

    private void VP() {
        this.bPG = new a[4];
        for (int i = 0; i < 4; i++) {
            this.bPG[i] = new a();
            this.bPG[i].bPJ = 0.25f;
        }
        VQ();
    }

    private void VQ() {
        int i = 0;
        while (i < 4) {
            this.bPG[i].up = i != 0;
            a aVar = this.bPG[i];
            float f = (i * 1.0f) / 4.0f;
            this.bPG[i].bPL = f;
            aVar.bPK = f;
            i++;
        }
    }

    private void VR() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 0.25f);
        this.mValueAnimator.setDuration(150L);
        this.mValueAnimator.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.view.DanceRectView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                for (a aVar : DanceRectView.this.bPG) {
                    aVar.VS();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                for (a aVar : DanceRectView.this.bPG) {
                    aVar.VT();
                }
                DanceRectView.this.invalidate();
            }
        });
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.view.DanceRectView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (a aVar : DanceRectView.this.bPG) {
                    aVar.C(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                DanceRectView.this.invalidate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        float bPJ;
        float bPK;
        float bPL;
        boolean up;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void VS() {
            if (this.bPL <= 0.0f) {
                this.bPL = 0.0f;
                this.bPK = 0.0f;
                this.up = false;
            } else if (this.bPL >= 1.0f - this.bPJ) {
                float f = 1.0f - this.bPJ;
                this.bPL = f;
                this.bPK = f;
                this.up = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(float f) {
            float f2 = 0.0f;
            if (f != 0.0f && f != this.bPJ) {
                if (this.up) {
                    float f3 = this.bPK - f;
                    if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                } else {
                    f2 = this.bPK + f;
                    if (f2 > 1.0f - this.bPJ) {
                        f2 = 1.0f - this.bPJ;
                    }
                }
                this.bPL = f2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void VT() {
            if (this.up) {
                this.bPL = this.bPK - this.bPJ;
            } else {
                this.bPL = this.bPK + this.bPJ;
            }
            this.bPK = this.bPL;
            VS();
        }
    }
}
