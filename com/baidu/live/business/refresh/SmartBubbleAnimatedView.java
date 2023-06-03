package com.baidu.live.business.refresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class SmartBubbleAnimatedView extends View {
    public String a;
    public long b;
    public float c;
    public ValueAnimator d;
    public ValueAnimator e;
    public Paint f;
    public Paint g;
    public RectF h;
    public Rect i;
    public e j;
    public int k;
    public boolean l;

    /* loaded from: classes3.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
            layoutParams.height = SmartBubbleAnimatedView.this.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07077f);
            SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            SmartBubbleAnimatedView.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (SmartBubbleAnimatedView.this.l && (layoutParams instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                int i = layoutParams2.topMargin;
                if (i > 0) {
                    layoutParams2.topMargin = i - 5;
                }
                if (layoutParams2.topMargin < 0) {
                    layoutParams2.topMargin = 0;
                }
            }
            SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
            SmartBubbleAnimatedView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartBubbleAnimatedView.this.e();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = SmartBubbleAnimatedView.this.getLayoutParams();
            layoutParams.height = (int) (layoutParams.height * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            SmartBubbleAnimatedView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            SmartBubbleAnimatedView.this.setLayoutParams(layoutParams);
            SmartBubbleAnimatedView.this.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (SmartBubbleAnimatedView.this.j != null) {
                SmartBubbleAnimatedView.this.j.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SmartBubbleAnimatedView.this.j != null) {
                SmartBubbleAnimatedView.this.j.a();
            }
        }
    }

    public SmartBubbleAnimatedView(Context context) {
        super(context);
        this.b = 4000L;
        this.c = 0.0f;
        this.f = new Paint();
        this.g = new Paint();
        this.h = new RectF();
        this.i = new Rect();
        this.l = false;
        d();
    }

    public void setExtrusionRemind(boolean z) {
        this.l = z;
    }

    public void setOnBubbleAnimateListener(e eVar) {
        this.j = eVar;
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 4000L;
        this.c = 0.0f;
        this.f = new Paint();
        this.g = new Paint();
        this.h = new RectF();
        this.i = new Rect();
        this.l = false;
        d();
    }

    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 4000L;
        this.c = 0.0f;
        this.f = new Paint();
        this.g = new Paint();
        this.h = new RectF();
        this.i = new Rect();
        this.l = false;
        d();
    }

    public final void d() {
        this.f.setColor(-16711681);
        this.g.setColor(-7829368);
        this.g.setTextSize(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070780));
        this.k = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07077f);
    }

    public int getTipViewHeight() {
        return this.k;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.d.cancel();
        }
        ValueAnimator valueAnimator2 = this.e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.e.cancel();
        }
    }

    public void e() {
        if (this.l) {
            e eVar = this.j;
            if (eVar != null) {
                eVar.a();
                return;
            }
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.e = ofFloat;
        ofFloat.addUpdateListener(new c());
        this.e.addListener(new d());
        this.e.setDuration(300L);
        this.e.start();
    }

    public void f() {
        this.d = ValueAnimator.ofFloat(0.0f, 1.1f);
        if (this.l) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                setLayoutParams(layoutParams);
            }
        }
        this.d.addUpdateListener(new a());
        this.d.setDuration(400L);
        this.d.start();
        if (getHandler() != null) {
            getHandler().postDelayed(new b(), this.b);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float height = ((1.0f - this.c) * getHeight()) / 2.0f;
        float width = (getWidth() / 2) + ((this.c * getWidth()) / 2.0f);
        float height2 = (getHeight() / 2) + ((this.c * getHeight()) / 2.0f);
        this.h.set(((1.0f - this.c) * getWidth()) / 2.0f, height, width, height2);
        float f = (height2 - height) / 2.0f;
        canvas.drawRoundRect(this.h, f, f, this.f);
        Paint paint = this.g;
        String str = this.a;
        paint.getTextBounds(str, 0, str.length(), this.i);
        int width2 = this.i.width();
        int height3 = this.i.height();
        String str2 = this.a;
        canvas.drawText(str2, 0, str2.length(), (getWidth() - width2) / 2, getHeight() - ((getHeight() - height3) / 2), this.g);
    }
}
