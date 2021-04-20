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
/* loaded from: classes2.dex */
public class ShimmerFrameLayout extends FrameLayout {
    public static final PorterDuffXfermode v = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    public Paint f12137e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12138f;

    /* renamed from: g  reason: collision with root package name */
    public d f12139g;

    /* renamed from: h  reason: collision with root package name */
    public e f12140h;
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

    /* loaded from: classes2.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes2.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
            float f2 = 1.0f - max;
            shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.f12140h.f12153a * f2) + (ShimmerFrameLayout.this.f12140h.f12155c * max)));
            ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
            shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.f12140h.f12154b * f2) + (ShimmerFrameLayout.this.f12140h.f12156d * max)));
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12143a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f12144b;

        static {
            int[] iArr = new int[MaskAngle.values().length];
            f12144b = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12144b[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12144b[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12144b[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            f12143a = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12143a[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12143a[MaskShape.WHITE_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public MaskAngle f12145a;

        /* renamed from: b  reason: collision with root package name */
        public float f12146b;

        /* renamed from: c  reason: collision with root package name */
        public float f12147c;

        /* renamed from: d  reason: collision with root package name */
        public int f12148d;

        /* renamed from: e  reason: collision with root package name */
        public int f12149e;

        /* renamed from: f  reason: collision with root package name */
        public float f12150f;

        /* renamed from: g  reason: collision with root package name */
        public float f12151g;

        /* renamed from: h  reason: collision with root package name */
        public float f12152h;
        public MaskShape i;

        public d() {
        }

        public int[] a() {
            int i = c.f12143a[this.i.ordinal()];
            return i != 2 ? i != 3 ? new int[]{0, -16777216, -16777216, 0} : new int[]{-16777216, 0, 0, -16777216} : new int[]{-16777216, -16777216, 0};
        }

        public float[] b() {
            return c.f12143a[this.i.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.f12150f) - this.f12147c) / 2.0f, 0.0f), Math.max((1.0f - this.f12150f) / 2.0f, 0.0f), Math.min((this.f12150f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f12150f + 1.0f) + this.f12147c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f12150f, 1.0f), Math.min(this.f12150f + this.f12147c, 1.0f)};
        }

        public int c(int i) {
            int i2 = this.f12149e;
            return i2 > 0 ? i2 : (int) (i * this.f12152h);
        }

        public int d(int i) {
            int i2 = this.f12148d;
            return i2 > 0 ? i2 : (int) (i * this.f12151g);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f12153a;

        /* renamed from: b  reason: collision with root package name */
        public int f12154b;

        /* renamed from: c  reason: collision with root package name */
        public int f12155c;

        /* renamed from: d  reason: collision with root package name */
        public int f12156d;

        public e() {
        }

        public void a(int i, int i2, int i3, int i4) {
            this.f12153a = i;
            this.f12154b = i2;
            this.f12155c = i3;
            this.f12156d = i4;
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
        int sqrt;
        int i;
        int i2;
        int i3;
        Bitmap bitmap = this.u;
        if (bitmap != null) {
            return bitmap;
        }
        int d2 = this.f12139g.d(getWidth());
        int c2 = this.f12139g.c(getHeight());
        this.u = h(d2, c2);
        Canvas canvas = new Canvas(this.u);
        if (c.f12143a[this.f12139g.i.ordinal()] != 2) {
            int i4 = c.f12144b[this.f12139g.f12145a.ordinal()];
            int i5 = 0;
            if (i4 != 2) {
                if (i4 == 3) {
                    i5 = d2;
                    i2 = 0;
                } else if (i4 != 4) {
                    i3 = d2;
                    i2 = 0;
                    i = 0;
                } else {
                    i2 = c2;
                }
                i3 = 0;
                i = 0;
            } else {
                i = c2;
                i2 = 0;
                i3 = 0;
            }
            radialGradient = new LinearGradient(i5, i2, i3, i, this.f12139g.a(), this.f12139g.b(), Shader.TileMode.REPEAT);
        } else {
            radialGradient = new RadialGradient(d2 / 2, c2 / 2, (float) (Math.max(d2, c2) / Math.sqrt(2.0d)), this.f12139g.a(), this.f12139g.b(), Shader.TileMode.REPEAT);
        }
        canvas.rotate(this.f12139g.f12146b, d2 / 2, c2 / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        float f2 = -(((int) (Math.sqrt(2.0d) * Math.max(d2, c2))) / 2);
        canvas.drawRect(f2, f2, d2 + sqrt, c2 + sqrt, paint);
        return this.u;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = c.f12143a[this.f12139g.i.ordinal()];
        int i2 = c.f12144b[this.f12139g.f12145a.ordinal()];
        if (i2 == 2) {
            this.f12140h.a(0, -height, 0, height);
        } else if (i2 == 3) {
            this.f12140h.a(width, 0, -width, 0);
        } else if (i2 != 4) {
            this.f12140h.a(-width, 0, width, 0);
        } else {
            this.f12140h.a(0, height, 0, -height);
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
        return this.f12139g.f12145a;
    }

    public float getBaseAlpha() {
        return this.f12137e.getAlpha() / 255.0f;
    }

    public float getDropoff() {
        return this.f12139g.f12147c;
    }

    public int getDuration() {
        return this.l;
    }

    public int getFixedHeight() {
        return this.f12139g.f12149e;
    }

    public int getFixedWidth() {
        return this.f12139g.f12148d;
    }

    public float getIntensity() {
        return this.f12139g.f12150f;
    }

    public MaskShape getMaskShape() {
        return this.f12139g.i;
    }

    public float getRelativeHeight() {
        return this.f12139g.f12152h;
    }

    public float getRelativeWidth() {
        return this.f12139g.f12151g;
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
        return this.f12139g.f12146b;
    }

    public final boolean i(Canvas canvas) {
        Bitmap s = s();
        Bitmap r = r();
        if (s == null || r == null) {
            return false;
        }
        k(new Canvas(s));
        canvas.drawBitmap(s, 0.0f, 0.0f, this.f12137e);
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
        canvas.drawBitmap(maskBitmap, this.p, this.q, this.f12138f);
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
        this.f12139g.f12145a = maskAngle;
        l();
    }

    public void setAutoStart(boolean z) {
        this.k = z;
        l();
    }

    public void setBaseAlpha(float f2) {
        this.f12137e.setAlpha((int) (g(0.0f, 1.0f, f2) * 255.0f));
        l();
    }

    public void setDropoff(float f2) {
        this.f12139g.f12147c = f2;
        l();
    }

    public void setDuration(int i) {
        this.l = i;
        l();
    }

    public void setFixedHeight(int i) {
        this.f12139g.f12149e = i;
        l();
    }

    public void setFixedWidth(int i) {
        this.f12139g.f12148d = i;
        l();
    }

    public void setIntensity(float f2) {
        this.f12139g.f12150f = f2;
        l();
    }

    public void setMaskShape(MaskShape maskShape) {
        this.f12139g.i = maskShape;
        l();
    }

    public void setRelativeHeight(int i) {
        this.f12139g.f12152h = i;
        l();
    }

    public void setRelativeWidth(int i) {
        this.f12139g.f12151g = i;
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
        this.f12139g.f12146b = f2;
        l();
    }

    public void t() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        d dVar = this.f12139g;
        dVar.f12145a = MaskAngle.CW_0;
        dVar.i = MaskShape.LINEAR;
        dVar.f12147c = 0.5f;
        dVar.f12148d = 0;
        dVar.f12149e = 0;
        dVar.f12150f = 0.0f;
        dVar.f12151g = 1.0f;
        dVar.f12152h = 1.0f;
        dVar.f12146b = 340.0f;
        this.f12140h = new e(null);
        setBaseAlpha(1.0f);
        l();
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.f12139g = new d(null);
        this.f12137e = new Paint();
        Paint paint = new Paint();
        this.f12138f = paint;
        paint.setAntiAlias(true);
        this.f12138f.setDither(true);
        this.f12138f.setFilterBitmap(true);
        this.f12138f.setXfermode(v);
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
                        this.f12139g.f12145a = MaskAngle.CW_90;
                    } else if (i2 == 180) {
                        this.f12139g.f12145a = MaskAngle.CW_180;
                    } else if (i2 != 270) {
                        this.f12139g.f12145a = MaskAngle.CW_0;
                    } else {
                        this.f12139g.f12145a = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_shimmer_shape)) {
                    if (obtainStyledAttributes.getInt(j.ShimmerFrameLayout_shimmer_shape, 0) != 1) {
                        this.f12139g.i = MaskShape.LINEAR;
                    } else {
                        this.f12139g.i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_dropoff)) {
                    this.f12139g.f12147c = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_fixed_width)) {
                    this.f12139g.f12148d = obtainStyledAttributes.getDimensionPixelSize(j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_fixed_height)) {
                    this.f12139g.f12149e = obtainStyledAttributes.getDimensionPixelSize(j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_intensity)) {
                    this.f12139g.f12150f = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_relative_width)) {
                    this.f12139g.f12151g = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_relative_height)) {
                    this.f12139g.f12152h = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_tilt)) {
                    this.f12139g.f12146b = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
