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
/* loaded from: classes9.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode dzb = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap anf;
    private int bfl;
    private Paint dzc;
    private Paint dzd;
    private a dze;
    private b dzf;
    private Bitmap dzg;
    private Bitmap dzh;
    private boolean dzi;
    private int dzj;
    private int dzk;
    private int dzl;
    private boolean dzm;
    protected ValueAnimator dzn;
    private int mDuration;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private int mRepeatMode;

    /* loaded from: classes9.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes9.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public MaskAngle dzr;
        public float dzs;
        public float dzt;
        public int dzu;
        public int dzv;
        public float dzw;
        public float dzx;
        public float dzy;
        public MaskShape dzz;

        private a() {
        }

        public int kd(int i) {
            return this.dzu > 0 ? this.dzu : (int) (i * this.dzx);
        }

        public int ke(int i) {
            return this.dzv > 0 ? this.dzv : (int) (i * this.dzy);
        }

        public int[] aKv() {
            switch (this.dzz) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] aKw() {
            switch (this.dzz) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.dzw, 1.0f), Math.min(this.dzw + this.dzt, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.dzw) - this.dzt) / 2.0f, 0.0f), Math.max((1.0f - this.dzw) / 2.0f, 0.0f), Math.min((this.dzw + 1.0f) / 2.0f, 1.0f), Math.min(((this.dzw + 1.0f) + this.dzt) / 2.0f, 1.0f)};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
        this.dze = new a();
        this.dzc = new Paint();
        this.dzd = new Paint();
        this.dzd.setAntiAlias(true);
        this.dzd.setDither(true);
        this.dzd.setFilterBitmap(true);
        this.dzd.setXfermode(dzb);
        aKm();
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
                            this.dze.dzr = MaskAngle.CW_90;
                            break;
                        case 180:
                            this.dze.dzr = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.dze.dzr = MaskAngle.CW_270;
                            break;
                        default:
                            this.dze.dzr = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shimmer_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shimmer_shape, 0)) {
                        case 1:
                            this.dze.dzz = MaskShape.RADIAL;
                            break;
                        default:
                            this.dze.dzz = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.dze.dzt = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.dze.dzu = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.dze.dzv = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.dze.dzw = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.dze.dzx = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.dze.dzy = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.dze.dzs = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void aKm() {
        setDuration(FeatureCodes.FACE);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.dze.dzr = MaskAngle.CW_0;
        this.dze.dzz = MaskShape.LINEAR;
        this.dze.dzt = 0.5f;
        this.dze.dzu = 0;
        this.dze.dzv = 0;
        this.dze.dzw = 0.0f;
        this.dze.dzx = 1.0f;
        this.dze.dzy = 1.0f;
        this.dze.dzs = 340.0f;
        this.dzf = new b();
        setBaseAlpha(1.0f);
        aKs();
    }

    public void setAutoStart(boolean z) {
        this.dzi = z;
        aKs();
    }

    public float getBaseAlpha() {
        return this.dzc.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.dzc.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        aKs();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        aKs();
    }

    public int getRepeatCount() {
        return this.bfl;
    }

    public void setRepeatCount(int i) {
        this.bfl = i;
        aKs();
    }

    public int getRepeatDelay() {
        return this.dzj;
    }

    public void setRepeatDelay(int i) {
        this.dzj = i;
        aKs();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        aKs();
    }

    public MaskShape getMaskShape() {
        return this.dze.dzz;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.dze.dzz = maskShape;
        aKs();
    }

    public MaskAngle getAngle() {
        return this.dze.dzr;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.dze.dzr = maskAngle;
        aKs();
    }

    public float getDropoff() {
        return this.dze.dzt;
    }

    public void setDropoff(float f) {
        this.dze.dzt = f;
        aKs();
    }

    public int getFixedWidth() {
        return this.dze.dzu;
    }

    public void setFixedWidth(int i) {
        this.dze.dzu = i;
        aKs();
    }

    public int getFixedHeight() {
        return this.dze.dzv;
    }

    public void setFixedHeight(int i) {
        this.dze.dzv = i;
        aKs();
    }

    public float getIntensity() {
        return this.dze.dzw;
    }

    public void setIntensity(float f) {
        this.dze.dzw = f;
        aKs();
    }

    public float getRelativeWidth() {
        return this.dze.dzx;
    }

    public void setRelativeWidth(int i) {
        this.dze.dzx = i;
        aKs();
    }

    public float getRelativeHeight() {
        return this.dze.dzy;
    }

    public void setRelativeHeight(int i) {
        this.dze.dzy = i;
        aKs();
    }

    public float getTilt() {
        return this.dze.dzs;
    }

    public void setTilt(float f) {
        this.dze.dzs = f;
        aKs();
    }

    public void aKn() {
        if (!this.dzm) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.dzm = true;
        }
    }

    public void aKo() {
        if (this.dzn != null) {
            this.dzn.end();
            this.dzn.removeAllUpdateListeners();
            this.dzn.cancel();
        }
        this.dzn = null;
        this.dzm = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.dzk != i) {
            this.dzk = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.dzl != i) {
            this.dzl = i;
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
                boolean z = ShimmerFrameLayout.this.dzm;
                ShimmerFrameLayout.this.aKs();
                if (ShimmerFrameLayout.this.dzi || z) {
                    ShimmerFrameLayout.this.aKn();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        aKo();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.dzm || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            s(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean s(Canvas canvas) {
        Bitmap aKp = aKp();
        Bitmap aKq = aKq();
        if (aKp == null || aKq == null) {
            return false;
        }
        t(new Canvas(aKp));
        canvas.drawBitmap(aKp, 0.0f, 0.0f, this.dzc);
        u(new Canvas(aKq));
        canvas.drawBitmap(aKq, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap aKp() {
        if (this.dzh == null) {
            this.dzh = aKr();
        }
        return this.dzh;
    }

    private Bitmap aKq() {
        if (this.dzg == null) {
            this.dzg = aKr();
        }
        return this.dzg;
    }

    @SuppressLint({"SwanDebugLog"})
    private Bitmap aKr() {
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
            canvas.clipRect(this.dzk, this.dzl, this.dzk + maskBitmap.getWidth(), this.dzl + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.dzk, this.dzl, this.dzd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKs() {
        aKo();
        aKt();
        aKu();
    }

    private void aKt() {
        if (this.anf != null) {
            this.anf.recycle();
            this.anf = null;
        }
    }

    private void aKu() {
        if (this.dzh != null) {
            this.dzh.recycle();
            this.dzh = null;
        }
        if (this.dzg != null) {
            this.dzg.recycle();
            this.dzg = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.anf != null) {
            return this.anf;
        }
        int kd = this.dze.kd(getWidth());
        int ke = this.dze.ke(getHeight());
        this.anf = an(kd, ke);
        Canvas canvas = new Canvas(this.anf);
        switch (this.dze.dzz) {
            case RADIAL:
                radialGradient = new RadialGradient(kd / 2, ke / 2, (float) (Math.max(kd, ke) / Math.sqrt(2.0d)), this.dze.aKv(), this.dze.aKw(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.dze.dzr) {
                    case CW_90:
                        i = ke;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = kd;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = ke;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = kd;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.dze.aKv(), this.dze.aKw(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.dze.dzs, kd / 2, ke / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(kd, ke))) / 2;
        canvas.drawRect(-sqrt, -sqrt, kd + sqrt, sqrt + ke, paint);
        return this.anf;
    }

    private Animator getShimmerAnimation() {
        if (this.dzn != null) {
            return this.dzn;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.dzp[this.dze.dzz.ordinal()];
        switch (this.dze.dzr) {
            case CW_90:
                this.dzf.q(0, -height, 0, height);
                break;
            case CW_180:
                this.dzf.q(width, 0, -width, 0);
                break;
            case CW_270:
                this.dzf.q(0, height, 0, -height);
                break;
            default:
                this.dzf.q(-width, 0, width, 0);
                break;
        }
        this.dzn = ValueAnimator.ofFloat(0.0f, 1.0f + (this.dzj / this.mDuration));
        this.dzn.setDuration(this.mDuration + this.dzj);
        this.dzn.setRepeatCount(this.bfl);
        this.dzn.setRepeatMode(this.mRepeatMode);
        this.dzn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.dzf.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.dzf.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.dzf.toY) + (ShimmerFrameLayout.this.dzf.fromY * (1.0f - max))));
            }
        });
        return this.dzn;
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
