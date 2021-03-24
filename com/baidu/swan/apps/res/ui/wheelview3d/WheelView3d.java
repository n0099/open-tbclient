package com.baidu.swan.apps.res.ui.wheelview3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.tbadk.core.util.StringHelper;
import d.b.g0.a.j;
import d.b.g0.a.q1.a.f.a.c;
import d.b.g0.a.q1.a.f.c.b;
import d.b.g0.a.r1.e;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class WheelView3d extends View {
    public static final int[] e0 = {-1, 452984831};
    public int A;
    public float B;
    public boolean C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public long R;
    public int S;
    public int T;
    public int U;
    public int V;
    public float W;
    public Drawable a0;
    public Drawable b0;
    public Paint c0;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public DividerType f12589e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12590f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f12591g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f12592h;
    public b i;
    public boolean j;
    public boolean k;
    public ScheduledExecutorService l;
    public ScheduledFuture<?> m;
    public Paint n;
    public Paint o;
    public Paint p;
    public c q;
    public String r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public Typeface x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes3.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = WheelView3d.this.i;
            WheelView3d wheelView3d = WheelView3d.this;
            bVar.a(wheelView3d, wheelView3d.getCurrentItem());
        }
    }

    public WheelView3d(Context context) {
        this(context, null);
    }

    public void b() {
        ScheduledFuture<?> scheduledFuture = this.m;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.m.cancel(true);
        this.m = null;
    }

    public final void c(Drawable drawable, Canvas canvas, int i, int i2) {
        drawable.setBounds(0, i, this.N, i2);
        drawable.draw(canvas);
    }

    public final String d(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof d.b.g0.a.q1.a.f.b.a) {
            return ((d.b.g0.a.q1.a.f.b.a) obj).a();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    public final int e(int i) {
        if (i < 0) {
            return e(i + this.q.a());
        }
        return i > this.q.a() + (-1) ? e(i - this.q.a()) : i;
    }

    public int f(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil(fArr[i2]);
        }
        return i;
    }

    public final void g(Context context) {
        this.f12590f = context;
        this.f12591g = new d.b.g0.a.q1.a.f.d.b(this);
        GestureDetector gestureDetector = new GestureDetector(context, new d.b.g0.a.q1.a.f.c.a(this));
        this.f12592h = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.C = true;
        this.G = 0.0f;
        this.H = -1;
        this.a0 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, e0);
        this.b0 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, e0);
        h();
    }

    public final c getAdapter() {
        return this.q;
    }

    public float getCenterContentOffset() {
        return this.W;
    }

    public final int getCurrentItem() {
        int i;
        c cVar = this.q;
        if (cVar == null) {
            return 0;
        }
        if (this.C && ((i = this.I) < 0 || i >= cVar.a())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.I) - this.q.a()), this.q.a() - 1));
        }
        return Math.max(0, Math.min(this.I, this.q.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f12591g;
    }

    public int getInitPosition() {
        return this.H;
    }

    public float getItemHeight() {
        return this.w;
    }

    public int getItemsCount() {
        c cVar = this.q;
        if (cVar != null) {
            return cVar.a();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.G;
    }

    public final void h() {
        Paint paint = new Paint();
        this.n = paint;
        paint.setColor(this.y);
        this.n.setAntiAlias(true);
        this.n.setTypeface(this.x);
        this.n.setTextSize(this.s);
        Paint paint2 = new Paint();
        this.o = paint2;
        paint2.setColor(this.z);
        this.o.setAntiAlias(true);
        this.o.setTextScaleX(1.1f);
        this.o.setTypeface(this.x);
        this.o.setTextSize(this.s);
        Paint paint3 = new Paint();
        this.p = paint3;
        paint3.setColor(this.A);
        this.p.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.c0 = paint4;
        paint4.setColor(BDEmotionBagVerticalLayout.COLOR_EMOTION_BAG);
        setLayerType(1, null);
    }

    public boolean i() {
        return this.C;
    }

    public final void j() {
        float f2 = this.B;
        if (f2 < 1.0f) {
            this.B = 1.0f;
        } else if (f2 > 4.0f) {
            this.B = 4.0f;
        }
    }

    public final void k() {
        Rect rect = new Rect();
        for (int i = 0; i < this.q.a(); i++) {
            String d2 = d(this.q.getItem(i));
            this.o.getTextBounds(d2, 0, d2.length(), rect);
            int width = rect.width();
            if (width > this.t) {
                this.t = width;
            }
            this.o.getTextBounds("星期", 0, 2, rect);
            this.u = rect.height() + 2;
        }
        this.w = this.B * this.u;
    }

    public final void l(String str) {
        String str2;
        Rect rect = new Rect();
        this.o.getTextBounds(str, 0, str.length(), rect);
        int i = this.T;
        if (i == 3) {
            this.U = this.d0;
        } else if (i == 5) {
            this.U = ((this.N - rect.width()) - ((int) this.W)) - this.d0;
        } else if (i != 17) {
        } else {
            if (!this.j && (str2 = this.r) != null && !str2.equals("") && this.k) {
                double width = (this.N - rect.width()) - this.d0;
                Double.isNaN(width);
                this.U = (int) (width * 0.25d);
                return;
            }
            double width2 = (this.N - rect.width()) - this.d0;
            Double.isNaN(width2);
            this.U = (int) (width2 * 0.5d);
        }
    }

    public final void m(String str) {
        String str2;
        Rect rect = new Rect();
        this.n.getTextBounds(str, 0, str.length(), rect);
        int i = this.T;
        if (i == 3) {
            this.V = this.d0;
        } else if (i == 5) {
            this.V = ((this.N - rect.width()) - ((int) this.W)) - this.d0;
        } else if (i != 17) {
        } else {
            if (!this.j && (str2 = this.r) != null && !str2.equals("") && this.k) {
                double width = (this.N - rect.width()) - this.d0;
                Double.isNaN(width);
                this.V = (int) (width * 0.25d);
                return;
            }
            double width2 = (this.N - rect.width()) - this.d0;
            Double.isNaN(width2);
            this.V = (int) (width2 * 0.5d);
        }
    }

    public final void n() {
        if (this.i != null) {
            postDelayed(new a(), 200L);
        }
    }

    public final String o(String str) {
        float[] fArr = {0.0f};
        Rect rect = new Rect();
        this.o.getTextBounds(str, 0, str.length(), rect);
        if (rect.width() > this.N) {
            int breakText = this.o.breakText(str, 0, str.length(), true, this.N, fArr);
            return str.substring(0, breakText - 2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        if (this.q == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.H), this.q.a() - 1);
        this.H = min;
        Object[] objArr = new Object[this.L];
        int i2 = (int) (this.G / this.w);
        this.K = i2;
        try {
            this.J = min + (i2 % this.q.a());
        } catch (ArithmeticException unused) {
            if (e.x) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
        }
        if (!this.C) {
            if (this.J < 0) {
                this.J = 0;
            }
            if (this.J > this.q.a() - 1) {
                this.J = this.q.a() - 1;
            }
        } else {
            if (this.J < 0) {
                this.J = this.q.a() + this.J;
            }
            if (this.J > this.q.a() - 1) {
                this.J -= this.q.a();
            }
        }
        float f2 = this.G % this.w;
        int i3 = 0;
        while (true) {
            int i4 = this.L;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.J - ((i4 / 2) - i3);
            if (this.C) {
                objArr[i3] = this.q.getItem(e(i5));
            } else if (i5 < 0) {
                objArr[i3] = "";
            } else if (i5 > this.q.a() - 1) {
                objArr[i3] = "";
            } else {
                objArr[i3] = this.q.getItem(i5);
            }
            i3++;
        }
        if (this.f12589e == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.r)) {
                i = (this.N - this.t) / 2;
            } else {
                i = (this.N - this.t) / 4;
            }
            float f3 = i - 12;
            float f4 = f3 <= 0.0f ? 10.0f : f3;
            float f5 = this.N - f4;
            float f6 = this.D;
            float f7 = f4;
            canvas.drawLine(f7, f6, f5, f6, this.p);
            float f8 = this.E;
            canvas.drawLine(f7, f8, f5, f8, this.p);
        } else {
            float f9 = this.D;
            canvas.drawLine(0.0f, f9, this.N, f9, this.p);
            float f10 = this.E;
            canvas.drawLine(0.0f, f10, this.N, f10, this.p);
        }
        canvas.drawRect(0.0f, this.D, this.N, this.E, this.c0);
        if (!TextUtils.isEmpty(this.r) && this.k) {
            canvas.drawText(this.r, (this.N - f(this.o, this.r)) - this.W, this.F, this.o);
        }
        for (int i6 = 0; i6 < this.L; i6++) {
            canvas.save();
            double d2 = ((this.w * i6) - f2) / this.O;
            Double.isNaN(d2);
            float f11 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f11 < 90.0f && f11 > -90.0f) {
                float pow = (float) Math.pow(Math.abs(f11) / 90.0f, 2.2d);
                String o = o((!this.k && !TextUtils.isEmpty(this.r) && !TextUtils.isEmpty(d(objArr[i6]))) ? d(objArr[i6]) + this.r : d(objArr[i6]));
                l(o);
                m(o);
                double d3 = this.O;
                double cos = Math.cos(d2);
                double d4 = this.O;
                Double.isNaN(d4);
                Double.isNaN(d3);
                double d5 = d3 - (cos * d4);
                double sin = Math.sin(d2);
                double d6 = this.u;
                Double.isNaN(d6);
                float f12 = (float) (d5 - ((sin * d6) / 2.0d));
                canvas.translate(0.0f, f12);
                float f13 = this.D;
                if (f12 <= f13 && this.u + f12 >= f13) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.N, this.D - f12);
                    canvas.drawText(o, this.V, this.u, this.n);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.D - f12, this.N, (int) this.w);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(o, this.U, this.u - this.W, this.o);
                    canvas.restore();
                } else {
                    float f14 = this.E;
                    if (f12 <= f14 && this.u + f12 >= f14) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.N, this.E - f12);
                        canvas.drawText(o, this.U, this.u - this.W, this.o);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.E - f12, this.N, (int) this.w);
                        canvas.drawText(o, this.V, this.u, this.n);
                        canvas.restore();
                    } else {
                        if (f12 >= this.D) {
                            int i7 = this.u;
                            if (i7 + f12 <= this.E) {
                                canvas.drawText(o, this.U, i7 - this.W, this.o);
                                this.I = this.J - ((this.L / 2) - i6);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.N, (int) this.w);
                        Paint paint = this.n;
                        int i8 = this.v;
                        paint.setTextSkewX((i8 == 0 ? 0 : i8 > 0 ? 1 : -1) * (f11 <= 0.0f ? 1 : -1) * 0.0f * pow);
                        this.n.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(o, this.V + (this.v * pow), this.u, this.n);
                        canvas.restore();
                        canvas.restore();
                        this.o.setTextSize(this.s);
                    }
                }
                canvas.restore();
                this.o.setTextSize(this.s);
            } else {
                canvas.restore();
            }
        }
        c(this.a0, canvas, 0, (int) this.D);
        c(this.b0, canvas, (int) this.E, this.M);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.S = i;
        p();
        setMeasuredDimension(this.N, this.M);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        double d2;
        boolean onTouchEvent = this.f12592h.onTouchEvent(motionEvent);
        float f2 = (-this.H) * this.w;
        float a2 = ((this.q.a() - 1) - this.H) * this.w;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.R = System.currentTimeMillis();
            b();
            this.Q = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.Q - motionEvent.getRawY();
            this.Q = motionEvent.getRawY();
            float f3 = this.G + rawY;
            this.G = f3;
            if (!this.C && ((f3 - (this.w * 0.25f) < f2 && rawY < 0.0f) || (this.G + (this.w * 0.25f) > a2 && rawY > 0.0f))) {
                this.G -= rawY;
                z = true;
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i = this.O;
            double acos = Math.acos((i - y) / i);
            double d3 = this.O;
            Double.isNaN(d3);
            double d4 = acos * d3;
            float f4 = this.w;
            double d5 = f4 / 2.0f;
            Double.isNaN(d5);
            double d6 = d4 + d5;
            Double.isNaN(f4);
            this.P = (int) (((((int) (d6 / d2)) - (this.L / 2)) * f4) - (((this.G % f4) + f4) % f4));
            if (System.currentTimeMillis() - this.R > 120) {
                r(ACTION.DAGGLE);
            } else {
                r(ACTION.CLICK);
            }
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void p() {
        if (this.q == null) {
            return;
        }
        k();
        int i = (int) (this.w * (this.L - 1));
        double d2 = i * 2;
        Double.isNaN(d2);
        this.M = (int) (d2 / 3.141592653589793d);
        double d3 = i;
        Double.isNaN(d3);
        this.O = (int) (d3 / 3.141592653589793d);
        this.N = View.MeasureSpec.getSize(this.S);
        int i2 = this.M;
        float f2 = this.w;
        this.D = (i2 - f2) / 2.0f;
        float f3 = (i2 + f2) / 2.0f;
        this.E = f3;
        this.F = (f3 - ((f2 - this.u) / 2.0f)) - this.W;
        if (this.H == -1) {
            if (this.C) {
                this.H = (this.q.a() + 1) / 2;
            } else {
                this.H = 0;
            }
        }
        this.J = this.H;
    }

    public final void q(float f2) {
        b();
        this.m = this.l.scheduleWithFixedDelay(new d.b.g0.a.q1.a.f.d.a(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void r(ACTION action) {
        b();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f2 = this.G;
            float f3 = this.w;
            int i = (int) (((f2 % f3) + f3) % f3);
            this.P = i;
            if (i > f3 / 2.0f) {
                this.P = (int) (f3 - i);
            } else {
                this.P = -i;
            }
        }
        this.m = this.l.scheduleWithFixedDelay(new d.b.g0.a.q1.a.f.d.c(this, this.P), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(c cVar) {
        this.q = cVar;
        p();
        invalidate();
    }

    public final void setCenterTextSize(int i) {
        float f2 = i;
        if (f2 > 0.0f) {
            this.s = i;
            this.o.setTextSize(f2);
        }
    }

    public final void setCurrentItem(int i) {
        this.I = i;
        this.H = i;
        this.G = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.C = z;
    }

    public void setDividerColor(int i) {
        this.A = i;
        this.p.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.f12589e = dividerType;
    }

    public void setGravity(int i) {
        this.T = i;
    }

    public void setGravityOffset(int i) {
        this.d0 = i;
    }

    public void setIsOptions(boolean z) {
        this.j = z;
    }

    public void setLabel(String str) {
        this.r = str;
    }

    public void setLineSpacingMultiplier(float f2) {
        if (f2 != 0.0f) {
            this.B = f2;
            j();
        }
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.i = bVar;
    }

    public final void setOuterTextSize(int i) {
        float f2 = i;
        if (f2 > 0.0f) {
            this.n.setTextSize(f2);
        }
    }

    public void setTextColorCenter(int i) {
        this.z = i;
        this.o.setColor(i);
    }

    public void setTextColorOut(int i) {
        this.y = i;
        this.n.setColor(i);
    }

    public void setTextXOffset(int i) {
        this.v = i;
        if (i != 0) {
            this.o.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f2) {
        this.G = f2;
    }

    public final void setTypeface(Typeface typeface) {
        this.x = typeface;
        this.n.setTypeface(typeface);
        this.o.setTypeface(this.x);
    }

    public void setVisibleItem(int i) {
        this.L = i;
    }

    public WheelView3d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = true;
        this.l = Executors.newSingleThreadScheduledExecutor();
        this.x = Typeface.SANS_SERIF;
        this.B = 1.6f;
        this.L = 5;
        this.P = 0;
        this.Q = 0.0f;
        this.R = 0L;
        this.T = 17;
        this.U = 0;
        this.V = 0;
        this.d0 = 0;
        this.s = 20;
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.W = 2.4f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.W = 3.6f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.W = 4.5f;
        } else if (2.0f <= f2 && f2 < 3.0f) {
            this.W = 6.0f;
        } else if (f2 >= 3.0f) {
            this.W = f2 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.pickerview, 0, 0);
            this.T = obtainStyledAttributes.getInt(j.pickerview_wheelview_gravity, 17);
            this.y = obtainStyledAttributes.getColor(j.pickerview_wheelview_textColorOut, -5723992);
            this.z = obtainStyledAttributes.getColor(j.pickerview_wheelview_textColorCenter, -14013910);
            this.A = obtainStyledAttributes.getColor(j.pickerview_wheelview_dividerColor, -2763307);
            this.s = obtainStyledAttributes.getDimensionPixelOffset(j.pickerview_wheelview_textSize, this.s);
            this.B = obtainStyledAttributes.getFloat(j.pickerview_wheelview_lineSpacingMultiplier, this.B);
            obtainStyledAttributes.recycle();
        }
        j();
        g(context);
    }
}
