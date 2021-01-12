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
import androidx.core.view.ViewCompat;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.swan.apps.a;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes8.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode dup = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap amo;
    private int bav;
    private boolean duA;
    protected ValueAnimator duB;
    private Paint duq;
    private Paint dur;
    private a dus;
    private b dut;
    private Bitmap duu;
    private Bitmap duv;
    private boolean duw;
    private int dux;
    private int duy;
    private int duz;
    private int mDuration;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private int mRepeatMode;

    /* loaded from: classes8.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes8.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        public MaskAngle duF;
        public float duG;
        public float duH;
        public int duI;
        public int duJ;
        public float duK;
        public float duL;
        public float duM;
        public MaskShape duN;

        private a() {
        }

        public int ix(int i) {
            return this.duI > 0 ? this.duI : (int) (i * this.duL);
        }

        public int iy(int i) {
            return this.duJ > 0 ? this.duJ : (int) (i * this.duM);
        }

        public int[] aGC() {
            switch (this.duN) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] aGD() {
            switch (this.duN) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.duK, 1.0f), Math.min(this.duK + this.duH, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.duK) - this.duH) / 2.0f, 0.0f), Math.max((1.0f - this.duK) / 2.0f, 0.0f), Math.min((this.duK + 1.0f) / 2.0f, 1.0f), Math.min(((this.duK + 1.0f) + this.duH) / 2.0f, 1.0f)};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        public int fromX;
        public int fromY;
        public int toX;
        public int toY;

        private b() {
        }

        public void q(int i, int i2, int i3, int i4) {
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.dus = new a();
        this.duq = new Paint();
        this.dur = new Paint();
        this.dur.setAntiAlias(true);
        this.dur.setDither(true);
        this.dur.setFilterBitmap(true);
        this.dur.setXfermode(dup);
        aGt();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_auto_start)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(a.j.ShimmerFrameLayout_auto_start, false));
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_base_alpha)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_base_alpha, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_duration)) {
                    setDuration(obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_duration, 0));
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_repeat_count)) {
                    setRepeatCount(obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_repeat_count, 0));
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_repeat_delay)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_repeat_delay, 0));
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_repeat_mode)) {
                    setRepeatMode(obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_repeat_mode, 0));
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_angle)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_angle, 0)) {
                        case 90:
                            this.dus.duF = MaskAngle.CW_90;
                            break;
                        case 180:
                            this.dus.duF = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.dus.duF = MaskAngle.CW_270;
                            break;
                        default:
                            this.dus.duF = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shimmer_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shimmer_shape, 0)) {
                        case 1:
                            this.dus.duN = MaskShape.RADIAL;
                            break;
                        default:
                            this.dus.duN = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.dus.duH = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.dus.duI = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.dus.duJ = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.dus.duK = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.dus.duL = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.dus.duM = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.dus.duG = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void aGt() {
        setDuration(FeatureCodes.FACE);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.dus.duF = MaskAngle.CW_0;
        this.dus.duN = MaskShape.LINEAR;
        this.dus.duH = 0.5f;
        this.dus.duI = 0;
        this.dus.duJ = 0;
        this.dus.duK = 0.0f;
        this.dus.duL = 1.0f;
        this.dus.duM = 1.0f;
        this.dus.duG = 340.0f;
        this.dut = new b();
        setBaseAlpha(1.0f);
        aGz();
    }

    public void setAutoStart(boolean z) {
        this.duw = z;
        aGz();
    }

    public float getBaseAlpha() {
        return this.duq.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.duq.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        aGz();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        aGz();
    }

    public int getRepeatCount() {
        return this.bav;
    }

    public void setRepeatCount(int i) {
        this.bav = i;
        aGz();
    }

    public int getRepeatDelay() {
        return this.dux;
    }

    public void setRepeatDelay(int i) {
        this.dux = i;
        aGz();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        aGz();
    }

    public MaskShape getMaskShape() {
        return this.dus.duN;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.dus.duN = maskShape;
        aGz();
    }

    public MaskAngle getAngle() {
        return this.dus.duF;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.dus.duF = maskAngle;
        aGz();
    }

    public float getDropoff() {
        return this.dus.duH;
    }

    public void setDropoff(float f) {
        this.dus.duH = f;
        aGz();
    }

    public int getFixedWidth() {
        return this.dus.duI;
    }

    public void setFixedWidth(int i) {
        this.dus.duI = i;
        aGz();
    }

    public int getFixedHeight() {
        return this.dus.duJ;
    }

    public void setFixedHeight(int i) {
        this.dus.duJ = i;
        aGz();
    }

    public float getIntensity() {
        return this.dus.duK;
    }

    public void setIntensity(float f) {
        this.dus.duK = f;
        aGz();
    }

    public float getRelativeWidth() {
        return this.dus.duL;
    }

    public void setRelativeWidth(int i) {
        this.dus.duL = i;
        aGz();
    }

    public float getRelativeHeight() {
        return this.dus.duM;
    }

    public void setRelativeHeight(int i) {
        this.dus.duM = i;
        aGz();
    }

    public float getTilt() {
        return this.dus.duG;
    }

    public void setTilt(float f) {
        this.dus.duG = f;
        aGz();
    }

    public void aGu() {
        if (!this.duA) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.duA = true;
        }
    }

    public void aGv() {
        if (this.duB != null) {
            this.duB.end();
            this.duB.removeAllUpdateListeners();
            this.duB.cancel();
        }
        this.duB = null;
        this.duA = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.duy != i) {
            this.duy = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.duz != i) {
            this.duz = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mGlobalLayoutListener == null) {
            this.mGlobalLayoutListener = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                boolean z = ShimmerFrameLayout.this.duA;
                ShimmerFrameLayout.this.aGz();
                if (ShimmerFrameLayout.this.duw || z) {
                    ShimmerFrameLayout.this.aGu();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        aGv();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.duA || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            s(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean s(Canvas canvas) {
        Bitmap aGw = aGw();
        Bitmap aGx = aGx();
        if (aGw == null || aGx == null) {
            return false;
        }
        t(new Canvas(aGw));
        canvas.drawBitmap(aGw, 0.0f, 0.0f, this.duq);
        u(new Canvas(aGx));
        canvas.drawBitmap(aGx, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap aGw() {
        if (this.duv == null) {
            this.duv = aGy();
        }
        return this.duv;
    }

    private Bitmap aGx() {
        if (this.duu == null) {
            this.duu = aGy();
        }
        return this.duu;
    }

    @SuppressLint({"SwanDebugLog"})
    private Bitmap aGy() {
        int width = getWidth();
        int height = getHeight();
        try {
            return an(width, height);
        } catch (OutOfMemoryError e) {
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

    private void t(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void u(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.duy, this.duz, this.duy + maskBitmap.getWidth(), this.duz + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.duy, this.duz, this.dur);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGz() {
        aGv();
        aGA();
        aGB();
    }

    private void aGA() {
        if (this.amo != null) {
            this.amo.recycle();
            this.amo = null;
        }
    }

    private void aGB() {
        if (this.duv != null) {
            this.duv.recycle();
            this.duv = null;
        }
        if (this.duu != null) {
            this.duu.recycle();
            this.duu = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.amo != null) {
            return this.amo;
        }
        int ix = this.dus.ix(getWidth());
        int iy = this.dus.iy(getHeight());
        this.amo = an(ix, iy);
        Canvas canvas = new Canvas(this.amo);
        switch (this.dus.duN) {
            case RADIAL:
                radialGradient = new RadialGradient(ix / 2, iy / 2, (float) (Math.max(ix, iy) / Math.sqrt(2.0d)), this.dus.aGC(), this.dus.aGD(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.dus.duF) {
                    case CW_90:
                        i = iy;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = ix;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = iy;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = ix;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.dus.aGC(), this.dus.aGD(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.dus.duG, ix / 2, iy / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(ix, iy))) / 2;
        canvas.drawRect(-sqrt, -sqrt, ix + sqrt, sqrt + iy, paint);
        return this.amo;
    }

    private Animator getShimmerAnimation() {
        if (this.duB != null) {
            return this.duB;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.duD[this.dus.duN.ordinal()];
        switch (this.dus.duF) {
            case CW_90:
                this.dut.q(0, -height, 0, height);
                break;
            case CW_180:
                this.dut.q(width, 0, -width, 0);
                break;
            case CW_270:
                this.dut.q(0, height, 0, -height);
                break;
            default:
                this.dut.q(-width, 0, width, 0);
                break;
        }
        this.duB = ValueAnimator.ofFloat(0.0f, 1.0f + (this.dux / this.mDuration));
        this.duB.setDuration(this.mDuration + this.dux);
        this.duB.setRepeatCount(this.bav);
        this.duB.setRepeatMode(this.mRepeatMode);
        this.duB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.dut.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.dut.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.dut.toY) + (ShimmerFrameLayout.this.dut.fromY * (1.0f - max))));
            }
        });
        return this.duB;
    }

    protected static Bitmap an(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
