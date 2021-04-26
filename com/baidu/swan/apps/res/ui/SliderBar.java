package com.baidu.swan.apps.res.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import d.a.h0.a.j;
/* loaded from: classes3.dex */
public class SliderBar extends View {
    public static final String[] D = {"小", "中", "大", "特大"};
    public int A;
    public int B;
    public boolean C;

    /* renamed from: e  reason: collision with root package name */
    public int f12017e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f12018f;

    /* renamed from: g  reason: collision with root package name */
    public float f12019g;

    /* renamed from: h  reason: collision with root package name */
    public float f12020h;

    /* renamed from: i  reason: collision with root package name */
    public int f12021i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public int u;
    public boolean v;
    public ValueAnimator w;
    public d x;
    public b y;
    public c z;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SliderBar.this.x.h(((Float) valueAnimator.getAnimatedValue()).floatValue());
            SliderBar.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public final float f12023a;

        /* renamed from: b  reason: collision with root package name */
        public final float f12024b;

        /* renamed from: c  reason: collision with root package name */
        public final float f12025c;

        /* renamed from: d  reason: collision with root package name */
        public int f12026d;

        /* renamed from: e  reason: collision with root package name */
        public float f12027e;

        /* renamed from: f  reason: collision with root package name */
        public float f12028f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f12029g;

        /* renamed from: h  reason: collision with root package name */
        public Paint f12030h;

        /* renamed from: i  reason: collision with root package name */
        public Paint f12031i;

        public b(float f2, float f3, float f4) {
            this.f12028f = 7.5f;
            this.f12023a = f2;
            this.f12024b = f2 + f4;
            this.f12025c = f3;
            int i2 = SliderBar.this.f12017e - 1;
            this.f12026d = i2;
            this.f12027e = f4 / i2;
            this.f12028f = SliderBar.this.f12019g / 2.0f;
            Paint paint = new Paint();
            this.f12029g = paint;
            paint.setColor(SliderBar.this.f12021i);
            this.f12029g.setStrokeWidth(SliderBar.this.f12020h);
            this.f12029g.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f12030h = paint2;
            paint2.setColor(SliderBar.this.p);
            this.f12030h.setTextSize(SliderBar.this.o);
            this.f12030h.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.f12031i = paint3;
            paint3.setColor(SliderBar.this.q);
            this.f12031i.setTextSize(SliderBar.this.o);
            this.f12031i.setAntiAlias(true);
        }

        public void a(Canvas canvas) {
            b(canvas);
            if (SliderBar.this.C) {
                c(canvas);
            }
        }

        public final void b(Canvas canvas) {
            float f2 = this.f12023a;
            float f3 = this.f12025c;
            canvas.drawLine(f2, f3, this.f12024b, f3, this.f12029g);
        }

        public final void c(Canvas canvas) {
            for (int i2 = 0; i2 <= this.f12026d; i2++) {
                float f2 = this.f12023a + (this.f12027e * i2);
                canvas.drawCircle(f2, this.f12025c, this.f12028f, this.f12029g);
                if (SliderBar.this.f12018f != null && SliderBar.this.f12018f.length > 0) {
                    String str = SliderBar.this.f12018f[i2];
                    if (!TextUtils.isEmpty(str)) {
                        if (i2 == SliderBar.this.B) {
                            Paint.FontMetrics fontMetrics = this.f12031i.getFontMetrics();
                            canvas.drawText(str, f2 - (i(str) / 2.0f), ((this.f12025c - SliderBar.this.j) - SliderBar.this.r) - (fontMetrics.bottom - fontMetrics.descent), this.f12031i);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.f12030h.getFontMetrics();
                            canvas.drawText(str, f2 - (i(str) / 2.0f), ((this.f12025c - SliderBar.this.j) - SliderBar.this.r) - (fontMetrics2.bottom - fontMetrics2.descent), this.f12030h);
                        }
                    }
                }
            }
        }

        public float d() {
            return this.f12024b;
        }

        public float e(d dVar) {
            return this.f12023a + (this.f12027e * g(dVar));
        }

        public int f(float f2) {
            float f3 = f2 - this.f12023a;
            float f4 = this.f12027e;
            return (int) ((f3 + (f4 / 2.0f)) / f4);
        }

        public int g(d dVar) {
            return f(dVar.c());
        }

        public float h() {
            return this.f12023a;
        }

        public float i(String str) {
            return this.f12030h.measureText(str);
        }

        public float j() {
            return this.f12027e;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(SliderBar sliderBar, int i2);
    }

    /* loaded from: classes3.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public final float f12032a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12033b;

        /* renamed from: c  reason: collision with root package name */
        public float f12034c;

        /* renamed from: d  reason: collision with root package name */
        public final float f12035d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f12036e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f12037f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f12038g;

        public d(float f2, float f3) {
            this.f12034c = f2;
            this.f12035d = f3;
            this.f12032a = (int) Math.max(50.0f, SliderBar.this.j * 2.0f);
            Paint paint = new Paint();
            this.f12036e = paint;
            paint.setColor(SliderBar.this.k);
            this.f12036e.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f12037f = paint2;
            paint2.setColor(SliderBar.this.l);
            this.f12037f.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.f12038g = paint3;
            paint3.setStyle(Paint.Style.STROKE);
            this.f12038g.setColor(SliderBar.this.m);
            this.f12038g.setAntiAlias(true);
            this.f12038g.setStrokeWidth(SliderBar.this.n);
            if (SliderBar.this.t) {
                SliderBar.this.setLayerType(1, this.f12036e);
                SliderBar.this.setLayerType(1, this.f12037f);
                this.f12036e.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.u);
                this.f12037f.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.u);
            }
        }

        public void a(Canvas canvas) {
            if (this.f12033b) {
                canvas.drawCircle(this.f12034c, this.f12035d, SliderBar.this.j, this.f12037f);
            } else {
                canvas.drawCircle(this.f12034c, this.f12035d, SliderBar.this.j, this.f12036e);
            }
            canvas.drawCircle(this.f12034c, this.f12035d, SliderBar.this.j, this.f12038g);
        }

        public float b() {
            return this.f12032a;
        }

        public float c() {
            return this.f12034c;
        }

        public boolean d(float f2, float f3) {
            return Math.abs(f2 - this.f12034c) <= this.f12032a && Math.abs(f3 - this.f12035d) <= this.f12032a;
        }

        public boolean e() {
            return this.f12033b;
        }

        public void f() {
            this.f12033b = true;
        }

        public void g() {
            this.f12033b = false;
        }

        public void h(float f2) {
            this.f12034c = f2;
        }
    }

    public SliderBar(Context context) {
        super(context);
        this.f12017e = 4;
        this.f12018f = D;
        this.f12019g = 15.0f;
        this.f12020h = 3.0f;
        this.f12021i = -7829368;
        this.j = 30.0f;
        this.k = -1;
        this.l = -1;
        this.m = 1711276032;
        this.n = 3;
        this.o = 40;
        this.p = -7829368;
        this.q = -7829368;
        this.r = 50;
        this.s = 500;
        this.t = false;
        this.u = -3355444;
        this.v = true;
        this.A = -1;
        this.B = 0;
        this.C = true;
    }

    private float getBarLineLength() {
        return ((getWidth() - (this.j * 2.0f)) - getPaddingLeft()) - getPaddingRight();
    }

    private float getFontHeight() {
        String[] strArr = this.f12018f;
        if (strArr == null || strArr.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.o);
        paint.measureText(this.f12018f[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private int getMinHeight() {
        return (int) ((this.j * 2.0f) + this.r + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.j;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.j;
    }

    public final boolean A(float f2) {
        if (this.x.e()) {
            y(f2);
            return true;
        }
        return true;
    }

    public final boolean B(float f2, float f3) {
        if (this.x.e()) {
            D();
            return true;
        } else if (this.A != t(f2, f3) || this.A == -1) {
            return true;
        } else {
            G(this.x.c(), getXCoordinate() + (this.A * this.y.j()));
            int i2 = this.A;
            this.B = i2;
            c cVar = this.z;
            if (cVar != null) {
                cVar.a(this, i2);
                return true;
            }
            return true;
        }
    }

    public final void C() {
        this.x.f();
        invalidate();
    }

    public final void D() {
        int g2 = this.y.g(this.x);
        if (this.B != g2) {
            this.B = g2;
            c cVar = this.z;
            if (cVar != null) {
                cVar.a(this, g2);
            }
        }
        float c2 = this.x.c();
        float e2 = this.y.e(this.x);
        if (this.v) {
            G(c2, e2);
        } else {
            this.x.h(e2);
            invalidate();
        }
        this.x.g();
    }

    public SliderBar E(c cVar) {
        this.z = cVar;
        return this;
    }

    public SliderBar F(int i2) {
        if (i2 >= 0 && i2 < this.f12017e) {
            if (this.B != i2) {
                this.B = i2;
                d dVar = this.x;
                if (dVar != null && this.y != null) {
                    dVar.h(getXCoordinate() + (this.y.j() * this.B));
                    invalidate();
                }
                c cVar = this.z;
                if (cVar != null) {
                    cVar.a(this, this.B);
                }
            }
            return this;
        }
        throw new IllegalArgumentException("A thumb index is out of bounds");
    }

    public final void G(float f2, float f3) {
        H();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        this.w = ofFloat;
        ofFloat.setDuration(80L);
        this.w.addUpdateListener(new a());
        this.w.start();
    }

    public final void H() {
        ValueAnimator valueAnimator = this.w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.w = null;
        }
    }

    public int getCurrentIndex() {
        return this.B;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.y.a(canvas);
        this.x.a(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            int i4 = this.s;
            size = mode == Integer.MIN_VALUE ? Math.min(size, i4) : i4;
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 != 1073741824) {
            int minHeight = getMinHeight();
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(size2, minHeight) : minHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        u();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || w()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return A(motionEvent.getX());
                } else if (action != 3) {
                    return true;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            return B(motionEvent.getX(), motionEvent.getY());
        }
        return z(motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 != 0) {
            H();
        }
    }

    public final int t(float f2, float f3) {
        for (int i2 = 0; i2 < this.f12017e; i2++) {
            if (x(f2, f3, i2)) {
                return i2;
            }
        }
        return -1;
    }

    public void u() {
        this.y = new b(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.x = new d(getXCoordinate() + (this.y.j() * this.B), getYCoordinate());
    }

    public void v(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.SliderBar);
        try {
            this.f12019g = (int) obtainStyledAttributes.getDimension(j.SliderBar_tickDiameter, 15.0f);
            this.f12020h = (int) obtainStyledAttributes.getDimension(j.SliderBar_barLineWide, 3.0f);
            this.f12021i = obtainStyledAttributes.getColor(j.SliderBar_barLineColor, -7829368);
            this.j = (int) obtainStyledAttributes.getDimension(j.SliderBar_thumbRadius, 30.0f);
            this.k = obtainStyledAttributes.getColor(j.SliderBar_thumbColorNormal, -1);
            this.l = obtainStyledAttributes.getColor(j.SliderBar_thumbColorPressed, -1);
            this.m = obtainStyledAttributes.getColor(j.SliderBar_thumbCircleColor, 1711276032);
            this.n = (int) obtainStyledAttributes.getDimension(j.SliderBar_thumbCircleWide, 3.0f);
            this.o = (int) obtainStyledAttributes.getDimension(j.SliderBar_barTextSize, 40.0f);
            this.p = obtainStyledAttributes.getColor(j.SliderBar_barTextColor, -7829368);
            this.q = obtainStyledAttributes.getColor(j.SliderBar_barChosenTextColor, -7829368);
            this.r = (int) obtainStyledAttributes.getDimension(j.SliderBar_barTextPadding, 50.0f);
            this.s = (int) obtainStyledAttributes.getDimension(j.SliderBar_defaultWidth, 500.0f);
            this.B = obtainStyledAttributes.getInt(j.SliderBar_currentIndex, 0);
            this.v = obtainStyledAttributes.getBoolean(j.SliderBar_animation, true);
            this.t = obtainStyledAttributes.getBoolean(j.SliderBar_isShowShadow, false);
            this.u = obtainStyledAttributes.getColor(j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final boolean w() {
        ValueAnimator valueAnimator = this.w;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public final boolean x(float f2, float f3, int i2) {
        return Math.abs(f2 - (getXCoordinate() + (this.y.j() * ((float) i2)))) < this.x.b() && Math.abs(f3 - getYCoordinate()) < this.x.b() * 2.0f;
    }

    public final void y(float f2) {
        if (f2 < this.y.h() || f2 > this.y.d()) {
            return;
        }
        this.x.h(f2);
        invalidate();
    }

    public final boolean z(float f2, float f3) {
        if (!this.x.e() && this.x.d(f2, f3)) {
            C();
            return true;
        }
        this.A = t(f2, f3);
        return true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12017e = 4;
        this.f12018f = D;
        this.f12019g = 15.0f;
        this.f12020h = 3.0f;
        this.f12021i = -7829368;
        this.j = 30.0f;
        this.k = -1;
        this.l = -1;
        this.m = 1711276032;
        this.n = 3;
        this.o = 40;
        this.p = -7829368;
        this.q = -7829368;
        this.r = 50;
        this.s = 500;
        this.t = false;
        this.u = -3355444;
        this.v = true;
        this.A = -1;
        this.B = 0;
        this.C = true;
        v(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12017e = 4;
        this.f12018f = D;
        this.f12019g = 15.0f;
        this.f12020h = 3.0f;
        this.f12021i = -7829368;
        this.j = 30.0f;
        this.k = -1;
        this.l = -1;
        this.m = 1711276032;
        this.n = 3;
        this.o = 40;
        this.p = -7829368;
        this.q = -7829368;
        this.r = 50;
        this.s = 500;
        this.t = false;
        this.u = -3355444;
        this.v = true;
        this.A = -1;
        this.B = 0;
        this.C = true;
        v(attributeSet);
    }
}
