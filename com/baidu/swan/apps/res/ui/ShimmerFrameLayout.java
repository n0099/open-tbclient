package com.baidu.swan.apps.res.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import d.b.g0.a.j;
/* loaded from: classes3.dex */
public class ShimmerFrameLayout extends FrameLayout {
    public static final PorterDuffXfermode v = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    public Paint f12475e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12476f;

    /* renamed from: g  reason: collision with root package name */
    public d f12477g;

    /* renamed from: h  reason: collision with root package name */
    public e f12478h;
    public Bitmap i;
    public Bitmap j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public ViewTreeObserver.OnGlobalLayoutListener s;
    public ValueAnimator t;
    public Bitmap u;

    /* loaded from: classes3.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes3.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z = ShimmerFrameLayout.this.r;
            ShimmerFrameLayout.this.l();
            if (ShimmerFrameLayout.this.k || z) {
                ShimmerFrameLayout.this.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
            float f2 = 1.0f - max;
            shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.f12478h.f12491a * f2) + (ShimmerFrameLayout.this.f12478h.f12493c * max)));
            ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
            shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.f12478h.f12492b * f2) + (ShimmerFrameLayout.this.f12478h.f12494d * max)));
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12481a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f12482b;

        static {
            int[] iArr = new int[MaskAngle.values().length];
            f12482b = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12482b[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12482b[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12482b[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            f12481a = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12481a[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12481a[MaskShape.WHITE_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public MaskAngle f12483a;

        /* renamed from: b  reason: collision with root package name */
        public float f12484b;

        /* renamed from: c  reason: collision with root package name */
        public float f12485c;

        /* renamed from: d  reason: collision with root package name */
        public int f12486d;

        /* renamed from: e  reason: collision with root package name */
        public int f12487e;

        /* renamed from: f  reason: collision with root package name */
        public float f12488f;

        /* renamed from: g  reason: collision with root package name */
        public float f12489g;

        /* renamed from: h  reason: collision with root package name */
        public float f12490h;
        public MaskShape i;

        public d() {
        }

        public int[] a() {
            int i = c.f12481a[this.i.ordinal()];
            return i != 2 ? i != 3 ? new int[]{0, -16777216, -16777216, 0} : new int[]{-16777216, 0, 0, -16777216} : new int[]{-16777216, -16777216, 0};
        }

        public float[] b() {
            return c.f12481a[this.i.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.f12488f) - this.f12485c) / 2.0f, 0.0f), Math.max((1.0f - this.f12488f) / 2.0f, 0.0f), Math.min((this.f12488f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f12488f + 1.0f) + this.f12485c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f12488f, 1.0f), Math.min(this.f12488f + this.f12485c, 1.0f)};
        }

        public int c(int i) {
            int i2 = this.f12487e;
            return i2 > 0 ? i2 : (int) (i * this.f12490h);
        }

        public int d(int i) {
            int i2 = this.f12486d;
            return i2 > 0 ? i2 : (int) (i * this.f12489g);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f12491a;

        /* renamed from: b  reason: collision with root package name */
        public int f12492b;

        /* renamed from: c  reason: collision with root package name */
        public int f12493c;

        /* renamed from: d  reason: collision with root package name */
        public int f12494d;

        public e() {
        }

        public void a(int i, int i2, int i3, int i4) {
            this.f12491a = i;
            this.f12492b = i2;
            this.f12493c = i3;
            this.f12494d = i4;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    public static float g(float f2, float f3, float f4) {
        return Math.min(f3, Math.max(f2, f4));
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new a();
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        Bitmap bitmap = this.u;
        if (bitmap != null) {
            return bitmap;
        }
        int d2 = this.f12477g.d(getWidth());
        int c2 = this.f12477g.c(getHeight());
        this.u = h(d2, c2);
        Canvas canvas = new Canvas(this.u);
        if (c.f12481a[this.f12477g.i.ordinal()] != 2) {
            int i5 = c.f12482b[this.f12477g.f12483a.ordinal()];
            int i6 = 0;
            if (i5 != 2) {
                if (i5 == 3) {
                    i6 = d2;
                    i3 = 0;
                } else if (i5 != 4) {
                    i4 = d2;
                    i3 = 0;
                    i2 = 0;
                } else {
                    i3 = c2;
                }
                i4 = 0;
                i2 = 0;
            } else {
                i2 = c2;
                i3 = 0;
                i4 = 0;
            }
            radialGradient = new LinearGradient(i6, i3, i4, i2, this.f12477g.a(), this.f12477g.b(), Shader.TileMode.REPEAT);
        } else {
            double max = Math.max(d2, c2);
            double sqrt = Math.sqrt(2.0d);
            Double.isNaN(max);
            radialGradient = new RadialGradient(d2 / 2, c2 / 2, (float) (max / sqrt), this.f12477g.a(), this.f12477g.b(), Shader.TileMode.REPEAT);
        }
        canvas.rotate(this.f12477g.f12484b, d2 / 2, c2 / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        double sqrt2 = Math.sqrt(2.0d);
        double max2 = Math.max(d2, c2);
        Double.isNaN(max2);
        float f2 = -(((int) (sqrt2 * max2)) / 2);
        canvas.drawRect(f2, f2, d2 + i, c2 + i, paint);
        return this.u;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = c.f12481a[this.f12477g.i.ordinal()];
        int i2 = c.f12482b[this.f12477g.f12483a.ordinal()];
        if (i2 == 2) {
            this.f12478h.a(0, -height, 0, height);
        } else if (i2 == 3) {
            this.f12478h.a(width, 0, -width, 0);
        } else if (i2 != 4) {
            this.f12478h.a(-width, 0, width, 0);
        } else {
            this.f12478h.a(0, height, 0, -height);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.n / this.l) + 1.0f);
        this.t = ofFloat;
        ofFloat.setDuration(this.l + this.n);
        this.t.setRepeatCount(this.m);
        this.t.setRepeatMode(this.o);
        this.t.addUpdateListener(new b());
        return this.t;
    }

    public static Bitmap h(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.p == i) {
            return;
        }
        this.p = i;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.q == i) {
            return;
        }
        this.q = i;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.r && getWidth() > 0 && getHeight() > 0) {
            i(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    public MaskAngle getAngle() {
        return this.f12477g.f12483a;
    }

    public float getBaseAlpha() {
        return this.f12475e.getAlpha() / 255.0f;
    }

    public float getDropoff() {
        return this.f12477g.f12485c;
    }

    public int getDuration() {
        return this.l;
    }

    public int getFixedHeight() {
        return this.f12477g.f12487e;
    }

    public int getFixedWidth() {
        return this.f12477g.f12486d;
    }

    public float getIntensity() {
        return this.f12477g.f12488f;
    }

    public MaskShape getMaskShape() {
        return this.f12477g.i;
    }

    public float getRelativeHeight() {
        return this.f12477g.f12490h;
    }

    public float getRelativeWidth() {
        return this.f12477g.f12489g;
    }

    public int getRepeatCount() {
        return this.m;
    }

    public int getRepeatDelay() {
        return this.n;
    }

    public int getRepeatMode() {
        return this.o;
    }

    public float getTilt() {
        return this.f12477g.f12484b;
    }

    public final boolean i(Canvas canvas) {
        Bitmap s = s();
        Bitmap r = r();
        if (s == null || r == null) {
            return false;
        }
        k(new Canvas(s));
        canvas.drawBitmap(s, 0.0f, 0.0f, this.f12475e);
        j(new Canvas(r));
        canvas.drawBitmap(r, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    public final void j(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap == null) {
            return;
        }
        int i = this.p;
        canvas.clipRect(i, this.q, maskBitmap.getWidth() + i, this.q + maskBitmap.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(maskBitmap, this.p, this.q, this.f12476f);
    }

    public final void k(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    public final void l() {
        p();
        m();
        n();
    }

    public final void m() {
        Bitmap bitmap = this.u;
        if (bitmap != null) {
            bitmap.recycle();
            this.u = null;
        }
    }

    public final void n() {
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            bitmap.recycle();
            this.j = null;
        }
        Bitmap bitmap2 = this.i;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.i = null;
        }
    }

    public void o() {
        if (this.r) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
        this.r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.s == null) {
            this.s = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.s);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        p();
        if (this.s != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.s);
            this.s = null;
        }
        super.onDetachedFromWindow();
    }

    public void p() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.t.removeAllUpdateListeners();
            this.t.cancel();
        }
        this.t = null;
        this.r = false;
    }

    @SuppressLint({"SwanDebugLog"})
    public final Bitmap q() {
        int width = getWidth();
        int height = getHeight();
        try {
            return h(width, height);
        } catch (OutOfMemoryError unused) {
            StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            sb.append(" (width = ");
            sb.append(width);
            sb.append(", height = ");
            sb.append(height);
            sb.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            Log.d("ShimmerFrameLayout", sb.toString());
            return null;
        }
    }

    public final Bitmap r() {
        if (this.i == null) {
            this.i = q();
        }
        return this.i;
    }

    public final Bitmap s() {
        if (this.j == null) {
            this.j = q();
        }
        return this.j;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.f12477g.f12483a = maskAngle;
        l();
    }

    public void setAutoStart(boolean z) {
        this.k = z;
        l();
    }

    public void setBaseAlpha(float f2) {
        this.f12475e.setAlpha((int) (g(0.0f, 1.0f, f2) * 255.0f));
        l();
    }

    public void setDropoff(float f2) {
        this.f12477g.f12485c = f2;
        l();
    }

    public void setDuration(int i) {
        this.l = i;
        l();
    }

    public void setFixedHeight(int i) {
        this.f12477g.f12487e = i;
        l();
    }

    public void setFixedWidth(int i) {
        this.f12477g.f12486d = i;
        l();
    }

    public void setIntensity(float f2) {
        this.f12477g.f12488f = f2;
        l();
    }

    public void setMaskShape(MaskShape maskShape) {
        this.f12477g.i = maskShape;
        l();
    }

    public void setRelativeHeight(int i) {
        this.f12477g.f12490h = i;
        l();
    }

    public void setRelativeWidth(int i) {
        this.f12477g.f12489g = i;
        l();
    }

    public void setRepeatCount(int i) {
        this.m = i;
        l();
    }

    public void setRepeatDelay(int i) {
        this.n = i;
        l();
    }

    public void setRepeatMode(int i) {
        this.o = i;
        l();
    }

    public void setTilt(float f2) {
        this.f12477g.f12484b = f2;
        l();
    }

    public void t() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        d dVar = this.f12477g;
        dVar.f12483a = MaskAngle.CW_0;
        dVar.i = MaskShape.LINEAR;
        dVar.f12485c = 0.5f;
        dVar.f12486d = 0;
        dVar.f12487e = 0;
        dVar.f12488f = 0.0f;
        dVar.f12489g = 1.0f;
        dVar.f12490h = 1.0f;
        dVar.f12484b = 340.0f;
        this.f12478h = new e(null);
        setBaseAlpha(1.0f);
        l();
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.f12477g = new d(null);
        this.f12475e = new Paint();
        Paint paint = new Paint();
        this.f12476f = paint;
        paint.setAntiAlias(true);
        this.f12476f.setDither(true);
        this.f12476f.setFilterBitmap(true);
        this.f12476f.setXfermode(v);
        t();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_auto_start)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(j.ShimmerFrameLayout_auto_start, false));
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_base_alpha)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_base_alpha, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_duration)) {
                    setDuration(obtainStyledAttributes.getInt(j.ShimmerFrameLayout_duration, 0));
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_repeat_count)) {
                    setRepeatCount(obtainStyledAttributes.getInt(j.ShimmerFrameLayout_repeat_count, 0));
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_repeat_delay)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(j.ShimmerFrameLayout_repeat_delay, 0));
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_repeat_mode)) {
                    setRepeatMode(obtainStyledAttributes.getInt(j.ShimmerFrameLayout_repeat_mode, 0));
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_angle)) {
                    int i2 = obtainStyledAttributes.getInt(j.ShimmerFrameLayout_angle, 0);
                    if (i2 == 90) {
                        this.f12477g.f12483a = MaskAngle.CW_90;
                    } else if (i2 == 180) {
                        this.f12477g.f12483a = MaskAngle.CW_180;
                    } else if (i2 != 270) {
                        this.f12477g.f12483a = MaskAngle.CW_0;
                    } else {
                        this.f12477g.f12483a = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_shimmer_shape)) {
                    if (obtainStyledAttributes.getInt(j.ShimmerFrameLayout_shimmer_shape, 0) != 1) {
                        this.f12477g.i = MaskShape.LINEAR;
                    } else {
                        this.f12477g.i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_dropoff)) {
                    this.f12477g.f12485c = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_fixed_width)) {
                    this.f12477g.f12486d = obtainStyledAttributes.getDimensionPixelSize(j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_fixed_height)) {
                    this.f12477g.f12487e = obtainStyledAttributes.getDimensionPixelSize(j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_intensity)) {
                    this.f12477g.f12488f = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_relative_width)) {
                    this.f12477g.f12489g = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_relative_height)) {
                    this.f12477g.f12490h = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_tilt)) {
                    this.f12477g.f12484b = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
