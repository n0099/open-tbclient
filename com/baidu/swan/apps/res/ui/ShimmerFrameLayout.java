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
import d.a.h0.a.j;
/* loaded from: classes3.dex */
public class ShimmerFrameLayout extends FrameLayout {
    public static final PorterDuffXfermode v = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    public Paint f11995e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f11996f;

    /* renamed from: g  reason: collision with root package name */
    public d f11997g;

    /* renamed from: h  reason: collision with root package name */
    public e f11998h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f11999i;
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
            shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.f11998h.f12013a * f2) + (ShimmerFrameLayout.this.f11998h.f12015c * max)));
            ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
            shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.f11998h.f12014b * f2) + (ShimmerFrameLayout.this.f11998h.f12016d * max)));
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12002a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f12003b;

        static {
            int[] iArr = new int[MaskAngle.values().length];
            f12003b = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12003b[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12003b[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12003b[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            f12002a = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12002a[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12002a[MaskShape.WHITE_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public MaskAngle f12004a;

        /* renamed from: b  reason: collision with root package name */
        public float f12005b;

        /* renamed from: c  reason: collision with root package name */
        public float f12006c;

        /* renamed from: d  reason: collision with root package name */
        public int f12007d;

        /* renamed from: e  reason: collision with root package name */
        public int f12008e;

        /* renamed from: f  reason: collision with root package name */
        public float f12009f;

        /* renamed from: g  reason: collision with root package name */
        public float f12010g;

        /* renamed from: h  reason: collision with root package name */
        public float f12011h;

        /* renamed from: i  reason: collision with root package name */
        public MaskShape f12012i;

        public d() {
        }

        public int[] a() {
            int i2 = c.f12002a[this.f12012i.ordinal()];
            return i2 != 2 ? i2 != 3 ? new int[]{0, -16777216, -16777216, 0} : new int[]{-16777216, 0, 0, -16777216} : new int[]{-16777216, -16777216, 0};
        }

        public float[] b() {
            return c.f12002a[this.f12012i.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.f12009f) - this.f12006c) / 2.0f, 0.0f), Math.max((1.0f - this.f12009f) / 2.0f, 0.0f), Math.min((this.f12009f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f12009f + 1.0f) + this.f12006c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f12009f, 1.0f), Math.min(this.f12009f + this.f12006c, 1.0f)};
        }

        public int c(int i2) {
            int i3 = this.f12008e;
            return i3 > 0 ? i3 : (int) (i2 * this.f12011h);
        }

        public int d(int i2) {
            int i3 = this.f12007d;
            return i3 > 0 ? i3 : (int) (i2 * this.f12010g);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f12013a;

        /* renamed from: b  reason: collision with root package name */
        public int f12014b;

        /* renamed from: c  reason: collision with root package name */
        public int f12015c;

        /* renamed from: d  reason: collision with root package name */
        public int f12016d;

        public e() {
        }

        public void a(int i2, int i3, int i4, int i5) {
            this.f12013a = i2;
            this.f12014b = i3;
            this.f12015c = i4;
            this.f12016d = i5;
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
        int i2;
        int i3;
        int i4;
        Bitmap bitmap = this.u;
        if (bitmap != null) {
            return bitmap;
        }
        int d2 = this.f11997g.d(getWidth());
        int c2 = this.f11997g.c(getHeight());
        this.u = h(d2, c2);
        Canvas canvas = new Canvas(this.u);
        if (c.f12002a[this.f11997g.f12012i.ordinal()] != 2) {
            int i5 = c.f12003b[this.f11997g.f12004a.ordinal()];
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
            radialGradient = new LinearGradient(i6, i3, i4, i2, this.f11997g.a(), this.f11997g.b(), Shader.TileMode.REPEAT);
        } else {
            radialGradient = new RadialGradient(d2 / 2, c2 / 2, (float) (Math.max(d2, c2) / Math.sqrt(2.0d)), this.f11997g.a(), this.f11997g.b(), Shader.TileMode.REPEAT);
        }
        canvas.rotate(this.f11997g.f12005b, d2 / 2, c2 / 2);
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
        int i2 = c.f12002a[this.f11997g.f12012i.ordinal()];
        int i3 = c.f12003b[this.f11997g.f12004a.ordinal()];
        if (i3 == 2) {
            this.f11998h.a(0, -height, 0, height);
        } else if (i3 == 3) {
            this.f11998h.a(width, 0, -width, 0);
        } else if (i3 != 4) {
            this.f11998h.a(-width, 0, width, 0);
        } else {
            this.f11998h.a(0, height, 0, -height);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.n / this.l) + 1.0f);
        this.t = ofFloat;
        ofFloat.setDuration(this.l + this.n);
        this.t.setRepeatCount(this.m);
        this.t.setRepeatMode(this.o);
        this.t.addUpdateListener(new b());
        return this.t;
    }

    public static Bitmap h(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i2) {
        if (this.p == i2) {
            return;
        }
        this.p = i2;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i2) {
        if (this.q == i2) {
            return;
        }
        this.q = i2;
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
        return this.f11997g.f12004a;
    }

    public float getBaseAlpha() {
        return this.f11995e.getAlpha() / 255.0f;
    }

    public float getDropoff() {
        return this.f11997g.f12006c;
    }

    public int getDuration() {
        return this.l;
    }

    public int getFixedHeight() {
        return this.f11997g.f12008e;
    }

    public int getFixedWidth() {
        return this.f11997g.f12007d;
    }

    public float getIntensity() {
        return this.f11997g.f12009f;
    }

    public MaskShape getMaskShape() {
        return this.f11997g.f12012i;
    }

    public float getRelativeHeight() {
        return this.f11997g.f12011h;
    }

    public float getRelativeWidth() {
        return this.f11997g.f12010g;
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
        return this.f11997g.f12005b;
    }

    public final boolean i(Canvas canvas) {
        Bitmap s = s();
        Bitmap r = r();
        if (s == null || r == null) {
            return false;
        }
        k(new Canvas(s));
        canvas.drawBitmap(s, 0.0f, 0.0f, this.f11995e);
        j(new Canvas(r));
        canvas.drawBitmap(r, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    public final void j(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap == null) {
            return;
        }
        int i2 = this.p;
        canvas.clipRect(i2, this.q, maskBitmap.getWidth() + i2, this.q + maskBitmap.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(maskBitmap, this.p, this.q, this.f11996f);
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
        Bitmap bitmap2 = this.f11999i;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f11999i = null;
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
        if (this.f11999i == null) {
            this.f11999i = q();
        }
        return this.f11999i;
    }

    public final Bitmap s() {
        if (this.j == null) {
            this.j = q();
        }
        return this.j;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.f11997g.f12004a = maskAngle;
        l();
    }

    public void setAutoStart(boolean z) {
        this.k = z;
        l();
    }

    public void setBaseAlpha(float f2) {
        this.f11995e.setAlpha((int) (g(0.0f, 1.0f, f2) * 255.0f));
        l();
    }

    public void setDropoff(float f2) {
        this.f11997g.f12006c = f2;
        l();
    }

    public void setDuration(int i2) {
        this.l = i2;
        l();
    }

    public void setFixedHeight(int i2) {
        this.f11997g.f12008e = i2;
        l();
    }

    public void setFixedWidth(int i2) {
        this.f11997g.f12007d = i2;
        l();
    }

    public void setIntensity(float f2) {
        this.f11997g.f12009f = f2;
        l();
    }

    public void setMaskShape(MaskShape maskShape) {
        this.f11997g.f12012i = maskShape;
        l();
    }

    public void setRelativeHeight(int i2) {
        this.f11997g.f12011h = i2;
        l();
    }

    public void setRelativeWidth(int i2) {
        this.f11997g.f12010g = i2;
        l();
    }

    public void setRepeatCount(int i2) {
        this.m = i2;
        l();
    }

    public void setRepeatDelay(int i2) {
        this.n = i2;
        l();
    }

    public void setRepeatMode(int i2) {
        this.o = i2;
        l();
    }

    public void setTilt(float f2) {
        this.f11997g.f12005b = f2;
        l();
    }

    public void t() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        d dVar = this.f11997g;
        dVar.f12004a = MaskAngle.CW_0;
        dVar.f12012i = MaskShape.LINEAR;
        dVar.f12006c = 0.5f;
        dVar.f12007d = 0;
        dVar.f12008e = 0;
        dVar.f12009f = 0.0f;
        dVar.f12010g = 1.0f;
        dVar.f12011h = 1.0f;
        dVar.f12005b = 340.0f;
        this.f11998h = new e(null);
        setBaseAlpha(1.0f);
        l();
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setWillNotDraw(false);
        this.f11997g = new d(null);
        this.f11995e = new Paint();
        Paint paint = new Paint();
        this.f11996f = paint;
        paint.setAntiAlias(true);
        this.f11996f.setDither(true);
        this.f11996f.setFilterBitmap(true);
        this.f11996f.setXfermode(v);
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
                    int i3 = obtainStyledAttributes.getInt(j.ShimmerFrameLayout_angle, 0);
                    if (i3 == 90) {
                        this.f11997g.f12004a = MaskAngle.CW_90;
                    } else if (i3 == 180) {
                        this.f11997g.f12004a = MaskAngle.CW_180;
                    } else if (i3 != 270) {
                        this.f11997g.f12004a = MaskAngle.CW_0;
                    } else {
                        this.f11997g.f12004a = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_shimmer_shape)) {
                    if (obtainStyledAttributes.getInt(j.ShimmerFrameLayout_shimmer_shape, 0) != 1) {
                        this.f11997g.f12012i = MaskShape.LINEAR;
                    } else {
                        this.f11997g.f12012i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_dropoff)) {
                    this.f11997g.f12006c = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_fixed_width)) {
                    this.f11997g.f12007d = obtainStyledAttributes.getDimensionPixelSize(j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_fixed_height)) {
                    this.f11997g.f12008e = obtainStyledAttributes.getDimensionPixelSize(j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_intensity)) {
                    this.f11997g.f12009f = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_relative_width)) {
                    this.f11997g.f12010g = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_relative_height)) {
                    this.f11997g.f12011h = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_tilt)) {
                    this.f11997g.f12005b = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
