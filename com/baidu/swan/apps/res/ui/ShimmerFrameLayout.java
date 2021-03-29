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
    public Paint f12476e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f12477f;

    /* renamed from: g  reason: collision with root package name */
    public d f12478g;

    /* renamed from: h  reason: collision with root package name */
    public e f12479h;
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
            shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.f12479h.f12492a * f2) + (ShimmerFrameLayout.this.f12479h.f12494c * max)));
            ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
            shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.f12479h.f12493b * f2) + (ShimmerFrameLayout.this.f12479h.f12495d * max)));
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12482a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f12483b;

        static {
            int[] iArr = new int[MaskAngle.values().length];
            f12483b = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12483b[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12483b[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12483b[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            f12482a = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12482a[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12482a[MaskShape.WHITE_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public MaskAngle f12484a;

        /* renamed from: b  reason: collision with root package name */
        public float f12485b;

        /* renamed from: c  reason: collision with root package name */
        public float f12486c;

        /* renamed from: d  reason: collision with root package name */
        public int f12487d;

        /* renamed from: e  reason: collision with root package name */
        public int f12488e;

        /* renamed from: f  reason: collision with root package name */
        public float f12489f;

        /* renamed from: g  reason: collision with root package name */
        public float f12490g;

        /* renamed from: h  reason: collision with root package name */
        public float f12491h;
        public MaskShape i;

        public d() {
        }

        public int[] a() {
            int i = c.f12482a[this.i.ordinal()];
            return i != 2 ? i != 3 ? new int[]{0, -16777216, -16777216, 0} : new int[]{-16777216, 0, 0, -16777216} : new int[]{-16777216, -16777216, 0};
        }

        public float[] b() {
            return c.f12482a[this.i.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.f12489f) - this.f12486c) / 2.0f, 0.0f), Math.max((1.0f - this.f12489f) / 2.0f, 0.0f), Math.min((this.f12489f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f12489f + 1.0f) + this.f12486c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f12489f, 1.0f), Math.min(this.f12489f + this.f12486c, 1.0f)};
        }

        public int c(int i) {
            int i2 = this.f12488e;
            return i2 > 0 ? i2 : (int) (i * this.f12491h);
        }

        public int d(int i) {
            int i2 = this.f12487d;
            return i2 > 0 ? i2 : (int) (i * this.f12490g);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f12492a;

        /* renamed from: b  reason: collision with root package name */
        public int f12493b;

        /* renamed from: c  reason: collision with root package name */
        public int f12494c;

        /* renamed from: d  reason: collision with root package name */
        public int f12495d;

        public e() {
        }

        public void a(int i, int i2, int i3, int i4) {
            this.f12492a = i;
            this.f12493b = i2;
            this.f12494c = i3;
            this.f12495d = i4;
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
        int d2 = this.f12478g.d(getWidth());
        int c2 = this.f12478g.c(getHeight());
        this.u = h(d2, c2);
        Canvas canvas = new Canvas(this.u);
        if (c.f12482a[this.f12478g.i.ordinal()] != 2) {
            int i4 = c.f12483b[this.f12478g.f12484a.ordinal()];
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
            radialGradient = new LinearGradient(i5, i2, i3, i, this.f12478g.a(), this.f12478g.b(), Shader.TileMode.REPEAT);
        } else {
            radialGradient = new RadialGradient(d2 / 2, c2 / 2, (float) (Math.max(d2, c2) / Math.sqrt(2.0d)), this.f12478g.a(), this.f12478g.b(), Shader.TileMode.REPEAT);
        }
        canvas.rotate(this.f12478g.f12485b, d2 / 2, c2 / 2);
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
        int i = c.f12482a[this.f12478g.i.ordinal()];
        int i2 = c.f12483b[this.f12478g.f12484a.ordinal()];
        if (i2 == 2) {
            this.f12479h.a(0, -height, 0, height);
        } else if (i2 == 3) {
            this.f12479h.a(width, 0, -width, 0);
        } else if (i2 != 4) {
            this.f12479h.a(-width, 0, width, 0);
        } else {
            this.f12479h.a(0, height, 0, -height);
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
        return this.f12478g.f12484a;
    }

    public float getBaseAlpha() {
        return this.f12476e.getAlpha() / 255.0f;
    }

    public float getDropoff() {
        return this.f12478g.f12486c;
    }

    public int getDuration() {
        return this.l;
    }

    public int getFixedHeight() {
        return this.f12478g.f12488e;
    }

    public int getFixedWidth() {
        return this.f12478g.f12487d;
    }

    public float getIntensity() {
        return this.f12478g.f12489f;
    }

    public MaskShape getMaskShape() {
        return this.f12478g.i;
    }

    public float getRelativeHeight() {
        return this.f12478g.f12491h;
    }

    public float getRelativeWidth() {
        return this.f12478g.f12490g;
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
        return this.f12478g.f12485b;
    }

    public final boolean i(Canvas canvas) {
        Bitmap s = s();
        Bitmap r = r();
        if (s == null || r == null) {
            return false;
        }
        k(new Canvas(s));
        canvas.drawBitmap(s, 0.0f, 0.0f, this.f12476e);
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
        canvas.drawBitmap(maskBitmap, this.p, this.q, this.f12477f);
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
        this.f12478g.f12484a = maskAngle;
        l();
    }

    public void setAutoStart(boolean z) {
        this.k = z;
        l();
    }

    public void setBaseAlpha(float f2) {
        this.f12476e.setAlpha((int) (g(0.0f, 1.0f, f2) * 255.0f));
        l();
    }

    public void setDropoff(float f2) {
        this.f12478g.f12486c = f2;
        l();
    }

    public void setDuration(int i) {
        this.l = i;
        l();
    }

    public void setFixedHeight(int i) {
        this.f12478g.f12488e = i;
        l();
    }

    public void setFixedWidth(int i) {
        this.f12478g.f12487d = i;
        l();
    }

    public void setIntensity(float f2) {
        this.f12478g.f12489f = f2;
        l();
    }

    public void setMaskShape(MaskShape maskShape) {
        this.f12478g.i = maskShape;
        l();
    }

    public void setRelativeHeight(int i) {
        this.f12478g.f12491h = i;
        l();
    }

    public void setRelativeWidth(int i) {
        this.f12478g.f12490g = i;
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
        this.f12478g.f12485b = f2;
        l();
    }

    public void t() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        d dVar = this.f12478g;
        dVar.f12484a = MaskAngle.CW_0;
        dVar.i = MaskShape.LINEAR;
        dVar.f12486c = 0.5f;
        dVar.f12487d = 0;
        dVar.f12488e = 0;
        dVar.f12489f = 0.0f;
        dVar.f12490g = 1.0f;
        dVar.f12491h = 1.0f;
        dVar.f12485b = 340.0f;
        this.f12479h = new e(null);
        setBaseAlpha(1.0f);
        l();
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.f12478g = new d(null);
        this.f12476e = new Paint();
        Paint paint = new Paint();
        this.f12477f = paint;
        paint.setAntiAlias(true);
        this.f12477f.setDither(true);
        this.f12477f.setFilterBitmap(true);
        this.f12477f.setXfermode(v);
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
                        this.f12478g.f12484a = MaskAngle.CW_90;
                    } else if (i2 == 180) {
                        this.f12478g.f12484a = MaskAngle.CW_180;
                    } else if (i2 != 270) {
                        this.f12478g.f12484a = MaskAngle.CW_0;
                    } else {
                        this.f12478g.f12484a = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_shimmer_shape)) {
                    if (obtainStyledAttributes.getInt(j.ShimmerFrameLayout_shimmer_shape, 0) != 1) {
                        this.f12478g.i = MaskShape.LINEAR;
                    } else {
                        this.f12478g.i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_dropoff)) {
                    this.f12478g.f12486c = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_fixed_width)) {
                    this.f12478g.f12487d = obtainStyledAttributes.getDimensionPixelSize(j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_fixed_height)) {
                    this.f12478g.f12488e = obtainStyledAttributes.getDimensionPixelSize(j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_intensity)) {
                    this.f12478g.f12489f = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_relative_width)) {
                    this.f12478g.f12490g = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_relative_height)) {
                    this.f12478g.f12491h = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(j.ShimmerFrameLayout_tilt)) {
                    this.f12478g.f12485b = obtainStyledAttributes.getFloat(j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }
}
