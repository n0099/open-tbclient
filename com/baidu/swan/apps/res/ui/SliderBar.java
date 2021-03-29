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
import d.b.g0.a.j;
/* loaded from: classes2.dex */
public class SliderBar extends View {
    public static final String[] D = {"小", "中", "大", "特大"};
    public int A;
    public int B;
    public boolean C;

    /* renamed from: e  reason: collision with root package name */
    public int f12496e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f12497f;

    /* renamed from: g  reason: collision with root package name */
    public float f12498g;

    /* renamed from: h  reason: collision with root package name */
    public float f12499h;
    public int i;
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

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SliderBar.this.x.h(((Float) valueAnimator.getAnimatedValue()).floatValue());
            SliderBar.this.invalidate();
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public final float f12501a;

        /* renamed from: b  reason: collision with root package name */
        public final float f12502b;

        /* renamed from: c  reason: collision with root package name */
        public final float f12503c;

        /* renamed from: d  reason: collision with root package name */
        public int f12504d;

        /* renamed from: e  reason: collision with root package name */
        public float f12505e;

        /* renamed from: f  reason: collision with root package name */
        public float f12506f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f12507g;

        /* renamed from: h  reason: collision with root package name */
        public Paint f12508h;
        public Paint i;

        public b(float f2, float f3, float f4) {
            this.f12506f = 7.5f;
            this.f12501a = f2;
            this.f12502b = f2 + f4;
            this.f12503c = f3;
            int i = SliderBar.this.f12496e - 1;
            this.f12504d = i;
            this.f12505e = f4 / i;
            this.f12506f = SliderBar.this.f12498g / 2.0f;
            Paint paint = new Paint();
            this.f12507g = paint;
            paint.setColor(SliderBar.this.i);
            this.f12507g.setStrokeWidth(SliderBar.this.f12499h);
            this.f12507g.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f12508h = paint2;
            paint2.setColor(SliderBar.this.p);
            this.f12508h.setTextSize(SliderBar.this.o);
            this.f12508h.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.i = paint3;
            paint3.setColor(SliderBar.this.q);
            this.i.setTextSize(SliderBar.this.o);
            this.i.setAntiAlias(true);
        }

        public void a(Canvas canvas) {
            b(canvas);
            if (SliderBar.this.C) {
                c(canvas);
            }
        }

        public final void b(Canvas canvas) {
            float f2 = this.f12501a;
            float f3 = this.f12503c;
            canvas.drawLine(f2, f3, this.f12502b, f3, this.f12507g);
        }

        public final void c(Canvas canvas) {
            for (int i = 0; i <= this.f12504d; i++) {
                float f2 = this.f12501a + (this.f12505e * i);
                canvas.drawCircle(f2, this.f12503c, this.f12506f, this.f12507g);
                if (SliderBar.this.f12497f != null && SliderBar.this.f12497f.length > 0) {
                    String str = SliderBar.this.f12497f[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.B) {
                            Paint.FontMetrics fontMetrics = this.i.getFontMetrics();
                            canvas.drawText(str, f2 - (i(str) / 2.0f), ((this.f12503c - SliderBar.this.j) - SliderBar.this.r) - (fontMetrics.bottom - fontMetrics.descent), this.i);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.f12508h.getFontMetrics();
                            canvas.drawText(str, f2 - (i(str) / 2.0f), ((this.f12503c - SliderBar.this.j) - SliderBar.this.r) - (fontMetrics2.bottom - fontMetrics2.descent), this.f12508h);
                        }
                    }
                }
            }
        }

        public float d() {
            return this.f12502b;
        }

        public float e(d dVar) {
            return this.f12501a + (this.f12505e * g(dVar));
        }

        public int f(float f2) {
            float f3 = f2 - this.f12501a;
            float f4 = this.f12505e;
            return (int) ((f3 + (f4 / 2.0f)) / f4);
        }

        public int g(d dVar) {
            return f(dVar.c());
        }

        public float h() {
            return this.f12501a;
        }

        public float i(String str) {
            return this.f12508h.measureText(str);
        }

        public float j() {
            return this.f12505e;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(SliderBar sliderBar, int i);
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public final float f12509a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12510b;

        /* renamed from: c  reason: collision with root package name */
        public float f12511c;

        /* renamed from: d  reason: collision with root package name */
        public final float f12512d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f12513e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f12514f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f12515g;

        public d(float f2, float f3) {
            this.f12511c = f2;
            this.f12512d = f3;
            this.f12509a = (int) Math.max(50.0f, SliderBar.this.j * 2.0f);
            Paint paint = new Paint();
            this.f12513e = paint;
            paint.setColor(SliderBar.this.k);
            this.f12513e.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f12514f = paint2;
            paint2.setColor(SliderBar.this.l);
            this.f12514f.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.f12515g = paint3;
            paint3.setStyle(Paint.Style.STROKE);
            this.f12515g.setColor(SliderBar.this.m);
            this.f12515g.setAntiAlias(true);
            this.f12515g.setStrokeWidth(SliderBar.this.n);
            if (SliderBar.this.t) {
                SliderBar.this.setLayerType(1, this.f12513e);
                SliderBar.this.setLayerType(1, this.f12514f);
                this.f12513e.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.u);
                this.f12514f.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.u);
            }
        }

        public void a(Canvas canvas) {
            if (this.f12510b) {
                canvas.drawCircle(this.f12511c, this.f12512d, SliderBar.this.j, this.f12514f);
            } else {
                canvas.drawCircle(this.f12511c, this.f12512d, SliderBar.this.j, this.f12513e);
            }
            canvas.drawCircle(this.f12511c, this.f12512d, SliderBar.this.j, this.f12515g);
        }

        public float b() {
            return this.f12509a;
        }

        public float c() {
            return this.f12511c;
        }

        public boolean d(float f2, float f3) {
            return Math.abs(f2 - this.f12511c) <= this.f12509a && Math.abs(f3 - this.f12512d) <= this.f12509a;
        }

        public boolean e() {
            return this.f12510b;
        }

        public void f() {
            this.f12510b = true;
        }

        public void g() {
            this.f12510b = false;
        }

        public void h(float f2) {
            this.f12511c = f2;
        }
    }

    public SliderBar(Context context) {
        super(context);
        this.f12496e = 4;
        this.f12497f = D;
        this.f12498g = 15.0f;
        this.f12499h = 3.0f;
        this.i = -7829368;
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
        String[] strArr = this.f12497f;
        if (strArr == null || strArr.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.o);
        paint.measureText(this.f12497f[0]);
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
            int i = this.A;
            this.B = i;
            c cVar = this.z;
            if (cVar != null) {
                cVar.a(this, i);
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

    public SliderBar F(int i) {
        if (i >= 0 && i < this.f12496e) {
            if (this.B != i) {
                this.B = i;
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
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.s;
            size = mode == Integer.MIN_VALUE ? Math.min(size, i3) : i3;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            int minHeight = getMinHeight();
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(size2, minHeight) : minHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
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
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            H();
        }
    }

    public final int t(float f2, float f3) {
        for (int i = 0; i < this.f12496e; i++) {
            if (x(f2, f3, i)) {
                return i;
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
            this.f12498g = (int) obtainStyledAttributes.getDimension(j.SliderBar_tickDiameter, 15.0f);
            this.f12499h = (int) obtainStyledAttributes.getDimension(j.SliderBar_barLineWide, 3.0f);
            this.i = obtainStyledAttributes.getColor(j.SliderBar_barLineColor, -7829368);
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

    public final boolean x(float f2, float f3, int i) {
        return Math.abs(f2 - (getXCoordinate() + (this.y.j() * ((float) i)))) < this.x.b() && Math.abs(f3 - getYCoordinate()) < this.x.b() * 2.0f;
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
        this.f12496e = 4;
        this.f12497f = D;
        this.f12498g = 15.0f;
        this.f12499h = 3.0f;
        this.i = -7829368;
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

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12496e = 4;
        this.f12497f = D;
        this.f12498g = 15.0f;
        this.f12499h = 3.0f;
        this.i = -7829368;
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
