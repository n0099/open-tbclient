package com.baidu.pass.biometrics.face.liveness.view.face;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.baidu.pass.biometrics.R;
/* loaded from: classes2.dex */
public class CircleProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f9203a;

    /* renamed from: b  reason: collision with root package name */
    public float f9204b;

    /* renamed from: c  reason: collision with root package name */
    public int f9205c;

    /* renamed from: d  reason: collision with root package name */
    public int f9206d;

    /* renamed from: e  reason: collision with root package name */
    public float f9207e;

    /* renamed from: f  reason: collision with root package name */
    public float f9208f;

    /* renamed from: g  reason: collision with root package name */
    public int f9209g;

    /* renamed from: h  reason: collision with root package name */
    public int f9210h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9211i;
    public Shader j;
    public int[] k;
    public float l;
    public float m;
    public int n;
    public float o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public b x;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircleProgressView.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(float f2, float f3);
    }

    public CircleProgressView(Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pass_liveness_CircleProgressView);
        DisplayMetrics displayMetrics = getDisplayMetrics();
        this.f9204b = TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.m = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvStrokeWidth) {
                this.f9204b = obtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvNormalColor) {
                this.f9209g = obtainStyledAttributes.getColor(index, -3618616);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvProgressColor) {
                this.f9210h = obtainStyledAttributes.getColor(index, -11539796);
                this.f9211i = false;
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvStartAngle) {
                this.f9205c = obtainStyledAttributes.getInt(index, 270);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvSweepAngle) {
                this.f9206d = obtainStyledAttributes.getInt(index, 360);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvMax) {
                this.q = obtainStyledAttributes.getInt(index, 100);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvProgress) {
                this.r = obtainStyledAttributes.getInt(index, 0);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvDuration) {
                this.s = obtainStyledAttributes.getInt(index, 500);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvShowTick) {
                this.u = obtainStyledAttributes.getBoolean(index, this.u);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvCirclePadding) {
                this.m = obtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 10.0f, displayMetrics));
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvTickSplitAngle) {
                this.n = obtainStyledAttributes.getInt(index, this.n);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvBlockAngle) {
                this.o = obtainStyledAttributes.getFloat(index, this.o);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvTurn) {
                this.v = obtainStyledAttributes.getBoolean(index, this.v);
            } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvCapRound) {
                this.w = obtainStyledAttributes.getBoolean(index, this.w);
            }
        }
        obtainStyledAttributes.recycle();
        this.t = (int) ((this.r * 100.0f) / this.q);
        this.f9203a = new Paint();
        this.p = (int) ((this.f9206d * 1.0f) / (this.n + this.o));
    }

    private int b(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i3, size) : i3;
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    private float getRatio() {
        return (this.r * 1.0f) / this.q;
    }

    public float getCircleCenterX() {
        return this.f9207e;
    }

    public float getCircleCenterY() {
        return this.f9208f;
    }

    public int getMax() {
        return this.q;
    }

    public int getProgress() {
        return this.r;
    }

    public int getProgressPercent() {
        return this.t;
    }

    public float getRadius() {
        return this.l;
    }

    public int getStartAngle() {
        return this.f9205c;
    }

    public int getSweepAngle() {
        return this.f9206d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int applyDimension = (int) TypedValue.applyDimension(1, 200.0f, getDisplayMetrics());
        int b2 = b(i2, applyDimension);
        int b3 = b(i3, applyDimension);
        this.f9207e = ((getPaddingLeft() + b2) - getPaddingRight()) / 2.0f;
        this.f9208f = ((getPaddingTop() + b3) - getPaddingBottom()) / 2.0f;
        this.l = (((b2 - Math.max(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom())) - this.f9204b) / 2.0f) - this.m;
        float f2 = this.f9207e;
        this.j = new SweepGradient(f2, f2, this.k, (float[]) null);
        setMeasuredDimension(b2, b3);
    }

    public void setCapRound(boolean z) {
        this.w = z;
        invalidate();
    }

    public void setIsShader(Shader shader) {
        this.f9211i = true;
        this.j = shader;
        invalidate();
    }

    public void setMax(int i2) {
        this.q = i2;
        invalidate();
    }

    public void setNormalColor(int i2) {
        this.f9209g = i2;
        invalidate();
    }

    public void setOnChangeListener(b bVar) {
        this.x = bVar;
    }

    public void setProgress(int i2) {
        this.r = i2;
        this.t = (int) ((i2 * 100.0f) / this.q);
        invalidate();
        b bVar = this.x;
        if (bVar != null) {
            bVar.a(this.r, this.q);
        }
    }

    public void setProgressColor(int... iArr) {
        float f2 = this.f9207e;
        setIsShader(new SweepGradient(f2, f2, iArr, (float[]) null));
    }

    public void setProgressColorResource(int i2) {
        setProgressColor(getResources().getColor(i2));
    }

    public void setShowTick(boolean z) {
        this.u = z;
        invalidate();
    }

    public void setTurn(boolean z) {
        this.v = z;
        invalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9205c = 270;
        this.f9206d = 360;
        this.f9209g = -2039584;
        this.f9210h = -11637006;
        this.f9211i = true;
        this.k = new int[]{-6311429, -8941322, -8941322, -11637006, -3615745, -6311429};
        this.n = 2;
        this.o = 0.5f;
        this.q = 100;
        this.r = 0;
        this.s = 1500;
        this.u = true;
        this.v = false;
        this.w = true;
        a(context, attributeSet);
    }

    public void setProgressColor(int i2) {
        this.f9211i = false;
        this.f9210h = i2;
        invalidate();
    }

    public void b(int i2) {
        a(this.r, i2, this.s);
    }

    private void a(Canvas canvas) {
        Shader shader;
        Shader shader2;
        Shader shader3;
        this.f9203a.reset();
        this.f9203a.setAntiAlias(true);
        this.f9203a.setStyle(Paint.Style.STROKE);
        this.f9203a.setStrokeWidth(this.f9204b);
        if (this.u) {
            float f2 = this.l;
            float f3 = f2 * 2.0f;
            float f4 = this.f9207e - f2;
            float f5 = this.f9208f - f2;
            RectF rectF = new RectF(f4, f5, f4 + f3, f3 + f5);
            int i2 = (int) ((this.t / 100.0f) * this.p);
            int i3 = 0;
            if (this.v) {
                while (i3 < this.p) {
                    this.f9203a.setShader(null);
                    this.f9203a.setColor(this.f9209g);
                    float f6 = this.o;
                    canvas.drawArc(rectF, (i3 * (this.n + f6)) + this.f9205c, f6, false, this.f9203a);
                    i3++;
                }
                for (int i4 = i2; i4 < i2 + i2; i4++) {
                    if (this.f9211i && (shader3 = this.j) != null) {
                        this.f9203a.setShader(shader3);
                    } else {
                        this.f9203a.setColor(this.f9210h);
                    }
                    float f7 = this.o;
                    canvas.drawArc(rectF, (i4 * (this.n + f7)) + this.f9205c, f7, false, this.f9203a);
                }
            } else {
                while (i3 < this.p) {
                    if (i3 < i2) {
                        if (this.f9211i && (shader2 = this.j) != null) {
                            this.f9203a.setShader(shader2);
                        } else {
                            this.f9203a.setColor(this.f9210h);
                        }
                        float f8 = this.o;
                        canvas.drawArc(rectF, (i3 * (this.n + f8)) + this.f9205c, f8, false, this.f9203a);
                    } else if (this.f9209g != 0) {
                        this.f9203a.setShader(null);
                        this.f9203a.setColor(this.f9209g);
                        float f9 = this.o;
                        canvas.drawArc(rectF, (i3 * (this.n + f9)) + this.f9205c, f9, false, this.f9203a);
                    }
                    i3++;
                }
            }
        }
        this.f9203a.setShader(null);
        if (this.w) {
            this.f9203a.setStrokeCap(Paint.Cap.ROUND);
        }
        float f10 = (this.l - this.m) - this.f9204b;
        float f11 = 2.0f * f10;
        float f12 = this.f9207e - f10;
        float f13 = this.f9208f - f10;
        RectF rectF2 = new RectF(f12, f13, f12 + f11, f11 + f13);
        int i5 = this.f9209g;
        if (i5 != 0) {
            this.f9203a.setColor(i5);
            canvas.drawArc(rectF2, this.f9205c, this.f9206d, false, this.f9203a);
        }
        if (this.f9211i && (shader = this.j) != null) {
            this.f9203a.setShader(shader);
        } else {
            this.f9203a.setColor(this.f9210h);
        }
        if (this.v) {
            canvas.drawArc(rectF2, this.f9205c + (this.f9206d * getRatio()), this.f9206d * getRatio(), false, this.f9203a);
        } else {
            canvas.drawArc(rectF2, this.f9205c, this.f9206d * getRatio(), false, this.f9203a);
        }
    }

    public void a(int i2) {
        a(i2, this.s);
    }

    public void a(int i2, int i3) {
        a(0, i2, i3);
    }

    public void a(int i2, int i3, int i4) {
        a(i2, i3, i4, null);
    }

    public void a(int i2, int i3, int i4, Animator.AnimatorListener animatorListener) {
        this.s = i4;
        this.r = i2;
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setDuration(i4);
        ofInt.addUpdateListener(new a());
        if (animatorListener != null) {
            ofInt.removeAllUpdateListeners();
            ofInt.addListener(animatorListener);
        }
        ofInt.start();
    }
}
