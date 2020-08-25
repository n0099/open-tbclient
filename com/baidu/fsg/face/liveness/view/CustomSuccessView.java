package com.baidu.fsg.face.liveness.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes11.dex */
public class CustomSuccessView extends View {
    private int a;
    private float b;
    private float c;
    private Paint d;
    private PathMeasure e;
    private Path f;
    private Path g;
    private Path h;
    private Path i;
    private Path j;
    private ValueAnimator k;
    private float l;
    private float m;

    public CustomSuccessView(Context context) {
        this(context, null);
    }

    public CustomSuccessView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomSuccessView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CustomSuccessView, i, 0);
        this.a = obtainStyledAttributes.getColor(R.styleable.CustomSuccessView_load_success_color, ContextCompat.getColor(context, R.color.rim_base_white));
        this.b = obtainStyledAttributes.getDimension(R.styleable.CustomSuccessView_progress_width, 2.0f);
        this.c = obtainStyledAttributes.getDimension(R.styleable.CustomSuccessView_progress_radius, 35.0f);
        obtainStyledAttributes.recycle();
        a();
        b();
        c();
    }

    private void a() {
        this.d = new Paint();
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setDither(true);
        this.d.setAntiAlias(true);
        this.d.setStrokeWidth(this.b);
        this.d.setStrokeCap(Paint.Cap.ROUND);
    }

    private void b() {
        this.f = new Path();
        this.e = new PathMeasure();
        this.g = new Path();
        this.h = new Path();
        this.i = new Path();
        this.j = new Path();
    }

    private void c() {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getPaddingLeft(), getPaddingTop());
        this.d.setColor(this.a);
        RectF rectF = new RectF();
        rectF.left = (getWidth() / 2) - this.c;
        rectF.top = (getWidth() / 2) - this.c;
        rectF.right = (getWidth() / 2) + this.c;
        rectF.bottom = (getWidth() / 2) + this.c;
        float f = this.c * 2.0f;
        this.h.moveTo(rectF.left + ((f / 76.0f) * 23.0f), rectF.top + ((f / 76.0f) * 30.0f));
        this.h.lineTo(rectF.left + ((f / 76.0f) * 38.0f), rectF.top + ((f / 76.0f) * 45.0f));
        this.h.lineTo(rectF.left + ((f / 76.0f) * 68.0f), ((f / 76.0f) * 17.0f) + rectF.top);
        this.e.setPath(this.h, false);
        this.e.getSegment(0.0f, this.m * this.e.getLength(), this.g, true);
        canvas.drawPath(this.g, this.d);
        if (this.m == 1.0f) {
            this.f.rLineTo(0.0f, 0.0f);
            this.f.addArc(rectF, -36.0f, -320.0f);
            this.e.setPath(this.f, false);
            this.e.getSegment(0.0f, this.l * this.e.getLength(), this.g, true);
            canvas.drawPath(this.g, this.d);
        }
    }

    private void d() {
        this.m = 0.0f;
        this.l = 0.0f;
        this.f.reset();
        this.g.reset();
        this.i.reset();
        this.j.reset();
        this.h.reset();
    }

    public void loadSuccess() {
        d();
        e();
    }

    private void e() {
        this.k = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.fsg.face.liveness.view.CustomSuccessView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomSuccessView.this.l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CustomSuccessView.this.invalidate();
            }
        });
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.fsg.face.liveness.view.CustomSuccessView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomSuccessView.this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CustomSuccessView.this.invalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.k).after(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = (int) ((this.c * 2.0f) + this.b + getPaddingLeft() + getPaddingRight());
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            size2 = (int) ((this.c * 2.0f) + this.b + getPaddingTop() + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }
}
