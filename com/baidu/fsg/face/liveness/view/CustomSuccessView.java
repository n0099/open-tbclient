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
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class CustomSuccessView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f6067a;

    /* renamed from: b  reason: collision with root package name */
    public float f6068b;

    /* renamed from: c  reason: collision with root package name */
    public float f6069c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f6070d;

    /* renamed from: e  reason: collision with root package name */
    public PathMeasure f6071e;

    /* renamed from: f  reason: collision with root package name */
    public Path f6072f;

    /* renamed from: g  reason: collision with root package name */
    public Path f6073g;

    /* renamed from: h  reason: collision with root package name */
    public Path f6074h;
    public Path i;
    public Path j;
    public ValueAnimator k;
    public float l;
    public float m;

    public CustomSuccessView(Context context) {
        this(context, null);
    }

    private void c() {
    }

    private void d() {
        this.m = 0.0f;
        this.l = 0.0f;
        this.f6072f.reset();
        this.f6073g.reset();
        this.i.reset();
        this.j.reset();
        this.f6074h.reset();
    }

    private void e() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.k = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.fsg.face.liveness.view.CustomSuccessView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomSuccessView.this.l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CustomSuccessView.this.invalidate();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.fsg.face.liveness.view.CustomSuccessView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomSuccessView.this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CustomSuccessView.this.invalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.k).after(ofFloat2);
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    public void loadSuccess() {
        d();
        e();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getPaddingLeft(), getPaddingTop());
        this.f6070d.setColor(this.f6067a);
        RectF rectF = new RectF();
        rectF.left = (getWidth() / 2) - this.f6069c;
        rectF.top = (getWidth() / 2) - this.f6069c;
        rectF.right = (getWidth() / 2) + this.f6069c;
        float f2 = this.f6069c;
        rectF.bottom = (getWidth() / 2) + f2;
        float f3 = (f2 * 2.0f) / 76.0f;
        this.f6074h.moveTo(rectF.left + (23.0f * f3), rectF.top + (30.0f * f3));
        this.f6074h.lineTo(rectF.left + (38.0f * f3), rectF.top + (45.0f * f3));
        this.f6074h.lineTo(rectF.left + (68.0f * f3), rectF.top + (f3 * 17.0f));
        this.f6071e.setPath(this.f6074h, false);
        PathMeasure pathMeasure = this.f6071e;
        pathMeasure.getSegment(0.0f, this.m * pathMeasure.getLength(), this.f6073g, true);
        canvas.drawPath(this.f6073g, this.f6070d);
        if (this.m == 1.0f) {
            this.f6072f.rLineTo(0.0f, 0.0f);
            this.f6072f.addArc(rectF, -36.0f, -320.0f);
            this.f6071e.setPath(this.f6072f, false);
            PathMeasure pathMeasure2 = this.f6071e;
            pathMeasure2.getSegment(0.0f, this.l * pathMeasure2.getLength(), this.f6073g, true);
            canvas.drawPath(this.f6073g, this.f6070d);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = (int) ((this.f6069c * 2.0f) + this.f6068b + getPaddingLeft() + getPaddingRight());
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            size2 = (int) ((this.f6069c * 2.0f) + this.f6068b + getPaddingTop() + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }

    public CustomSuccessView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        Paint paint = new Paint();
        this.f6070d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f6070d.setDither(true);
        this.f6070d.setAntiAlias(true);
        this.f6070d.setStrokeWidth(this.f6068b);
        this.f6070d.setStrokeCap(Paint.Cap.ROUND);
    }

    private void b() {
        this.f6072f = new Path();
        this.f6071e = new PathMeasure();
        this.f6073g = new Path();
        this.f6074h = new Path();
        this.i = new Path();
        this.j = new Path();
    }

    public CustomSuccessView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CustomSuccessView, i, 0);
        this.f6067a = obtainStyledAttributes.getColor(R.styleable.CustomSuccessView_load_success_color, ContextCompat.getColor(context, R.color.rim_base_white));
        this.f6068b = obtainStyledAttributes.getDimension(R.styleable.CustomSuccessView_progress_width, 2.0f);
        this.f6069c = obtainStyledAttributes.getDimension(R.styleable.CustomSuccessView_progress_radius, 35.0f);
        obtainStyledAttributes.recycle();
        a();
        b();
        c();
    }
}
