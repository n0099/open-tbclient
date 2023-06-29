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
import com.baidu.tieba.ls1;
/* loaded from: classes4.dex */
public class ShimmerFrameLayout extends FrameLayout {
    public static final PorterDuffXfermode r = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public Paint a;
    public Paint b;
    public d c;
    public e d;
    public Bitmap e;
    public Bitmap f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public ViewTreeObserver.OnGlobalLayoutListener o;
    public ValueAnimator p;
    public Bitmap q;

    /* loaded from: classes4.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes4.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z = ShimmerFrameLayout.this.n;
            ShimmerFrameLayout.this.l();
            if (ShimmerFrameLayout.this.g || z) {
                ShimmerFrameLayout.this.o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
            float f = 1.0f - max;
            shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.d.a * f) + (ShimmerFrameLayout.this.d.c * max)));
            ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
            shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.d.b * f) + (ShimmerFrameLayout.this.d.d * max)));
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[MaskAngle.values().length];
            b = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            a = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[MaskShape.WHITE_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public MaskAngle a;
        public float b;
        public float c;
        public int d;
        public int e;
        public float f;
        public float g;
        public float h;
        public MaskShape i;

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        public int c(int i) {
            int i2 = this.e;
            if (i2 <= 0) {
                return (int) (i * this.h);
            }
            return i2;
        }

        public int d(int i) {
            int i2 = this.d;
            if (i2 <= 0) {
                return (int) (i * this.g);
            }
            return i2;
        }

        public int[] a() {
            int i = c.a[this.i.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    return new int[]{0, -16777216, -16777216, 0};
                }
                return new int[]{-16777216, 0, 0, -16777216};
            }
            return new int[]{-16777216, -16777216, 0};
        }

        public float[] b() {
            return c.a[this.i.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.f) - this.c) / 2.0f, 0.0f), Math.max((1.0f - this.f) / 2.0f, 0.0f), Math.min((this.f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f + 1.0f) + this.c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f, 1.0f), Math.min(this.f + this.c, 1.0f)};
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public int a;
        public int b;
        public int c;
        public int d;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public void a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new a();
    }

    public MaskAngle getAngle() {
        return this.c.a;
    }

    public float getBaseAlpha() {
        return this.a.getAlpha() / 255.0f;
    }

    public float getDropoff() {
        return this.c.c;
    }

    public int getDuration() {
        return this.h;
    }

    public int getFixedHeight() {
        return this.c.e;
    }

    public int getFixedWidth() {
        return this.c.d;
    }

    public float getIntensity() {
        return this.c.f;
    }

    public MaskShape getMaskShape() {
        return this.c.i;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public float getRelativeHeight() {
        return this.c.h;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public float getRelativeWidth() {
        return this.c.g;
    }

    public int getRepeatCount() {
        return this.i;
    }

    public int getRepeatDelay() {
        return this.j;
    }

    public int getRepeatMode() {
        return this.k;
    }

    public float getTilt() {
        return this.c.b;
    }

    public final void l() {
        p();
        m();
        n();
    }

    public final void m() {
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            bitmap.recycle();
            this.q = null;
        }
    }

    public final void n() {
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f = null;
        }
        Bitmap bitmap2 = this.e;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.e = null;
        }
    }

    public void o() {
        if (this.n) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
        this.n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.o == null) {
            this.o = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.o);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        p();
        if (this.o != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.o);
            this.o = null;
        }
        super.onDetachedFromWindow();
    }

    public void p() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.p.removeAllUpdateListeners();
            this.p.cancel();
        }
        this.p = null;
        this.n = false;
    }

    public final Bitmap r() {
        if (this.e == null) {
            this.e = q();
        }
        return this.e;
    }

    public final Bitmap s() {
        if (this.f == null) {
            this.f = q();
        }
        return this.f;
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.l == i) {
            return;
        }
        this.l = i;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.m == i) {
            return;
        }
        this.m = i;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.n && getWidth() > 0 && getHeight() > 0) {
            i(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    public final boolean i(Canvas canvas) {
        Bitmap s = s();
        Bitmap r2 = r();
        if (s != null && r2 != null) {
            k(new Canvas(s));
            canvas.drawBitmap(s, 0.0f, 0.0f, this.a);
            j(new Canvas(r2));
            canvas.drawBitmap(r2, 0.0f, 0.0f, (Paint) null);
            return true;
        }
        return false;
    }

    public final void j(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap == null) {
            return;
        }
        int i = this.l;
        canvas.clipRect(i, this.m, maskBitmap.getWidth() + i, this.m + maskBitmap.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(maskBitmap, this.l, this.m, this.b);
    }

    public final void k(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    public void setAngle(MaskAngle maskAngle) {
        this.c.a = maskAngle;
        l();
    }

    public void setAutoStart(boolean z) {
        this.g = z;
        l();
    }

    public void setBaseAlpha(float f) {
        this.a.setAlpha((int) (g(0.0f, 1.0f, f) * 255.0f));
        l();
    }

    public void setDropoff(float f) {
        this.c.c = f;
        l();
    }

    public void setDuration(int i) {
        this.h = i;
        l();
    }

    public void setFixedHeight(int i) {
        this.c.e = i;
        l();
    }

    public void setFixedWidth(int i) {
        this.c.d = i;
        l();
    }

    public void setIntensity(float f) {
        this.c.f = f;
        l();
    }

    public void setMaskShape(MaskShape maskShape) {
        this.c.i = maskShape;
        l();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setRelativeHeight(int i) {
        this.c.h = i;
        l();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setRelativeWidth(int i) {
        this.c.g = i;
        l();
    }

    public void setRepeatCount(int i) {
        this.i = i;
        l();
    }

    public void setRepeatDelay(int i) {
        this.j = i;
        l();
    }

    public void setRepeatMode(int i) {
        this.k = i;
        l();
    }

    public void setTilt(float f) {
        this.c.b = f;
        l();
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static Bitmap h(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.c = new d(null);
        this.a = new Paint();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setFilterBitmap(true);
        this.b.setXfermode(r);
        t();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ls1.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(1)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(1, false));
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(2, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(4)) {
                    setDuration(obtainStyledAttributes.getInt(4, 0));
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    setRepeatCount(obtainStyledAttributes.getInt(10, 0));
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(11, 0));
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    setRepeatMode(obtainStyledAttributes.getInt(12, 0));
                }
                if (obtainStyledAttributes.hasValue(0)) {
                    int i2 = obtainStyledAttributes.getInt(0, 0);
                    if (i2 != 90) {
                        if (i2 != 180) {
                            if (i2 != 270) {
                                this.c.a = MaskAngle.CW_0;
                            } else {
                                this.c.a = MaskAngle.CW_270;
                            }
                        } else {
                            this.c.a = MaskAngle.CW_180;
                        }
                    } else {
                        this.c.a = MaskAngle.CW_90;
                    }
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    if (obtainStyledAttributes.getInt(14, 0) != 1) {
                        this.c.i = MaskShape.LINEAR;
                    } else {
                        this.c.i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    this.c.c = obtainStyledAttributes.getFloat(3, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    this.c.d = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    this.c.e = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.c.f = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.c.g = obtainStyledAttributes.getFloat(9, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.c.h = obtainStyledAttributes.getFloat(8, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(15)) {
                    this.c.b = obtainStyledAttributes.getFloat(15, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public static float g(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int sqrt;
        int i;
        int i2;
        int i3;
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            return bitmap;
        }
        int d2 = this.c.d(getWidth());
        int c2 = this.c.c(getHeight());
        this.q = h(d2, c2);
        Canvas canvas = new Canvas(this.q);
        if (c.a[this.c.i.ordinal()] != 2) {
            int i4 = c.b[this.c.a.ordinal()];
            int i5 = 0;
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        i3 = d2;
                        i2 = 0;
                        i = 0;
                    } else {
                        i2 = c2;
                    }
                } else {
                    i5 = d2;
                    i2 = 0;
                }
                i3 = 0;
                i = 0;
            } else {
                i = c2;
                i2 = 0;
                i3 = 0;
            }
            radialGradient = new LinearGradient(i5, i2, i3, i, this.c.a(), this.c.b(), Shader.TileMode.REPEAT);
        } else {
            radialGradient = new RadialGradient(d2 / 2, c2 / 2, (float) (Math.max(d2, c2) / Math.sqrt(2.0d)), this.c.a(), this.c.b(), Shader.TileMode.REPEAT);
        }
        canvas.rotate(this.c.b, d2 / 2, c2 / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        float f = -(((int) (Math.sqrt(2.0d) * Math.max(d2, c2))) / 2);
        canvas.drawRect(f, f, d2 + sqrt, c2 + sqrt, paint);
        return this.q;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = c.a[this.c.i.ordinal()];
        int i2 = c.b[this.c.a.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    this.d.a(-width, 0, width, 0);
                } else {
                    this.d.a(0, height, 0, -height);
                }
            } else {
                this.d.a(width, 0, -width, 0);
            }
        } else {
            this.d.a(0, -height, 0, height);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.j / this.h) + 1.0f);
        this.p = ofFloat;
        ofFloat.setDuration(this.h + this.j);
        this.p.setRepeatCount(this.i);
        this.p.setRepeatMode(this.k);
        this.p.addUpdateListener(new b());
        return this.p;
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
            Log.d(com.baidu.searchbox.ui.ShimmerFrameLayout.TAG, sb.toString());
            return null;
        }
    }

    public void t() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        d dVar = this.c;
        dVar.a = MaskAngle.CW_0;
        dVar.i = MaskShape.LINEAR;
        dVar.c = 0.5f;
        dVar.d = 0;
        dVar.e = 0;
        dVar.f = 0.0f;
        dVar.g = 1.0f;
        dVar.h = 1.0f;
        dVar.b = 340.0f;
        this.d = new e(null);
        setBaseAlpha(1.0f);
        l();
    }
}
