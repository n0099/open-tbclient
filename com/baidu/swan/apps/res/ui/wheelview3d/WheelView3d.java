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
import d.a.i0.a.a2.e;
import d.a.i0.a.j;
import d.a.i0.a.z1.a.e.a.c;
import d.a.i0.a.z1.a.e.c.b;
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
    public DividerType f11316e;

    /* renamed from: f  reason: collision with root package name */
    public Context f11317f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f11318g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f11319h;

    /* renamed from: i  reason: collision with root package name */
    public b f11320i;
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
            b bVar = WheelView3d.this.f11320i;
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

    public final void c(Drawable drawable, Canvas canvas, int i2, int i3) {
        drawable.setBounds(0, i2, this.N, i3);
        drawable.draw(canvas);
    }

    public final String d(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof d.a.i0.a.z1.a.e.b.a) {
            return ((d.a.i0.a.z1.a.e.b.a) obj).a();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    public final int e(int i2) {
        if (i2 < 0) {
            return e(i2 + this.q.a());
        }
        return i2 > this.q.a() + (-1) ? e(i2 - this.q.a()) : i2;
    }

    public int f(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += (int) Math.ceil(fArr[i3]);
        }
        return i2;
    }

    public final void g(Context context) {
        this.f11317f = context;
        this.f11318g = new d.a.i0.a.z1.a.e.d.b(this);
        GestureDetector gestureDetector = new GestureDetector(context, new d.a.i0.a.z1.a.e.c.a(this));
        this.f11319h = gestureDetector;
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
        int i2;
        c cVar = this.q;
        if (cVar == null) {
            return 0;
        }
        if (this.C && ((i2 = this.I) < 0 || i2 >= cVar.a())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.I) - this.q.a()), this.q.a() - 1));
        }
        return Math.max(0, Math.min(this.I, this.q.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f11318g;
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
        for (int i2 = 0; i2 < this.q.a(); i2++) {
            String d2 = d(this.q.getItem(i2));
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
        int i2 = this.T;
        if (i2 == 3) {
            this.U = this.d0;
        } else if (i2 == 5) {
            this.U = ((this.N - rect.width()) - ((int) this.W)) - this.d0;
        } else if (i2 != 17) {
        } else {
            if (!this.j && (str2 = this.r) != null && !str2.equals("") && this.k) {
                this.U = (int) (((this.N - rect.width()) - this.d0) * 0.25d);
            } else {
                this.U = (int) (((this.N - rect.width()) - this.d0) * 0.5d);
            }
        }
    }

    public final void m(String str) {
        String str2;
        Rect rect = new Rect();
        this.n.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.T;
        if (i2 == 3) {
            this.V = this.d0;
        } else if (i2 == 5) {
            this.V = ((this.N - rect.width()) - ((int) this.W)) - this.d0;
        } else if (i2 != 17) {
        } else {
            if (!this.j && (str2 = this.r) != null && !str2.equals("") && this.k) {
                this.V = (int) (((this.N - rect.width()) - this.d0) * 0.25d);
            } else {
                this.V = (int) (((this.N - rect.width()) - this.d0) * 0.5d);
            }
        }
    }

    public final void n() {
        if (this.f11320i != null) {
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
        int i2;
        if (this.q == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.H), this.q.a() - 1);
        this.H = min;
        Object[] objArr = new Object[this.L];
        int i3 = (int) (this.G / this.w);
        this.K = i3;
        try {
            this.J = min + (i3 % this.q.a());
        } catch (ArithmeticException unused) {
            if (e.y) {
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
        int i4 = 0;
        while (true) {
            int i5 = this.L;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.J - ((i5 / 2) - i4);
            if (this.C) {
                objArr[i4] = this.q.getItem(e(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.q.a() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.q.getItem(i6);
            }
            i4++;
        }
        if (this.f11316e == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.r)) {
                i2 = (this.N - this.t) / 2;
            } else {
                i2 = (this.N - this.t) / 4;
            }
            float f3 = i2 - 12;
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
        for (int i7 = 0; i7 < this.L; i7++) {
            canvas.save();
            double d2 = ((this.w * i7) - f2) / this.O;
            float f11 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f11 < 90.0f && f11 > -90.0f) {
                float pow = (float) Math.pow(Math.abs(f11) / 90.0f, 2.2d);
                String o = o((!this.k && !TextUtils.isEmpty(this.r) && !TextUtils.isEmpty(d(objArr[i7]))) ? d(objArr[i7]) + this.r : d(objArr[i7]));
                l(o);
                m(o);
                float cos = (float) ((this.O - (Math.cos(d2) * this.O)) - ((Math.sin(d2) * this.u) / 2.0d));
                canvas.translate(0.0f, cos);
                float f12 = this.D;
                if (cos <= f12 && this.u + cos >= f12) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.N, this.D - cos);
                    canvas.drawText(o, this.V, this.u, this.n);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.D - cos, this.N, (int) this.w);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(o, this.U, this.u - this.W, this.o);
                    canvas.restore();
                } else {
                    float f13 = this.E;
                    if (cos <= f13 && this.u + cos >= f13) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.N, this.E - cos);
                        canvas.drawText(o, this.U, this.u - this.W, this.o);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.E - cos, this.N, (int) this.w);
                        canvas.drawText(o, this.V, this.u, this.n);
                        canvas.restore();
                    } else {
                        if (cos >= this.D) {
                            int i8 = this.u;
                            if (i8 + cos <= this.E) {
                                canvas.drawText(o, this.U, i8 - this.W, this.o);
                                this.I = this.J - ((this.L / 2) - i7);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.N, (int) this.w);
                        Paint paint = this.n;
                        int i9 = this.v;
                        paint.setTextSkewX((i9 == 0 ? 0 : i9 > 0 ? 1 : -1) * (f11 <= 0.0f ? 1 : -1) * 0.0f * pow);
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
    public void onMeasure(int i2, int i3) {
        this.S = i2;
        p();
        setMeasuredDimension(this.N, this.M);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f11319h.onTouchEvent(motionEvent);
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
            int i2 = this.O;
            float f4 = this.w;
            this.P = (int) (((((int) (((Math.acos((i2 - y) / i2) * this.O) + (f4 / 2.0f)) / f4)) - (this.L / 2)) * f4) - (((this.G % f4) + f4) % f4));
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
        int i2 = (int) (this.w * (this.L - 1));
        this.M = (int) ((i2 * 2) / 3.141592653589793d);
        this.O = (int) (i2 / 3.141592653589793d);
        this.N = View.MeasureSpec.getSize(this.S);
        int i3 = this.M;
        float f2 = this.w;
        this.D = (i3 - f2) / 2.0f;
        float f3 = (i3 + f2) / 2.0f;
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
        this.m = this.l.scheduleWithFixedDelay(new d.a.i0.a.z1.a.e.d.a(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void r(ACTION action) {
        b();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f2 = this.G;
            float f3 = this.w;
            int i2 = (int) (((f2 % f3) + f3) % f3);
            this.P = i2;
            if (i2 > f3 / 2.0f) {
                this.P = (int) (f3 - i2);
            } else {
                this.P = -i2;
            }
        }
        this.m = this.l.scheduleWithFixedDelay(new d.a.i0.a.z1.a.e.d.c(this, this.P), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(c cVar) {
        this.q = cVar;
        p();
        invalidate();
    }

    public final void setCenterTextSize(int i2) {
        float f2 = i2;
        if (f2 > 0.0f) {
            this.s = i2;
            this.o.setTextSize(f2);
        }
    }

    public final void setCurrentItem(int i2) {
        this.I = i2;
        this.H = i2;
        this.G = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.C = z;
    }

    public void setDividerColor(int i2) {
        this.A = i2;
        this.p.setColor(i2);
    }

    public void setDividerType(DividerType dividerType) {
        this.f11316e = dividerType;
    }

    public void setGravity(int i2) {
        this.T = i2;
    }

    public void setGravityOffset(int i2) {
        this.d0 = i2;
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
        this.f11320i = bVar;
    }

    public final void setOuterTextSize(int i2) {
        float f2 = i2;
        if (f2 > 0.0f) {
            this.n.setTextSize(f2);
        }
    }

    public void setTextColorCenter(int i2) {
        this.z = i2;
        this.o.setColor(i2);
    }

    public void setTextColorOut(int i2) {
        this.y = i2;
        this.n.setColor(i2);
    }

    public void setTextXOffset(int i2) {
        this.v = i2;
        if (i2 != 0) {
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

    public void setVisibleItem(int i2) {
        this.L = i2;
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
        } else {
            int i2 = (1.0f > f2 ? 1 : (1.0f == f2 ? 0 : -1));
            if (i2 <= 0 && f2 < 2.0f) {
                this.W = 3.6f;
            } else if (i2 <= 0 && f2 < 2.0f) {
                this.W = 4.5f;
            } else if (2.0f <= f2 && f2 < 3.0f) {
                this.W = 6.0f;
            } else if (f2 >= 3.0f) {
                this.W = f2 * 2.5f;
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.swan_pickerview, 0, 0);
            this.T = obtainStyledAttributes.getInt(j.swan_pickerview_swan_wheelview_gravity, 17);
            this.y = obtainStyledAttributes.getColor(j.swan_pickerview_wheelview_textColorOut, -5723992);
            this.z = obtainStyledAttributes.getColor(j.swan_pickerview_wheelview_textColorCenter, -14013910);
            this.A = obtainStyledAttributes.getColor(j.swan_pickerview_wheelview_dividerColor, -2763307);
            this.s = obtainStyledAttributes.getDimensionPixelOffset(j.swan_pickerview_wheelview_textSize, this.s);
            this.B = obtainStyledAttributes.getFloat(j.swan_pickerview_wheelview_lineSpacingMultiplier, this.B);
            obtainStyledAttributes.recycle();
        }
        j();
        g(context);
    }
}
