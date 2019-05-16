package com.baidu.swan.apps.res.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode aJh = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap Yy;
    private Paint aJi;
    private Paint aJj;
    private a aJk;
    private b aJl;
    private Bitmap aJm;
    private Bitmap aJn;
    private boolean aJo;
    private int aJp;
    private int aJq;
    private int aJr;
    private boolean aJs;
    protected ValueAnimator mAnimator;
    private int mDuration;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private int mRepeatCount;
    private int mRepeatMode;

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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        public int aJA;
        public float aJB;
        public float aJC;
        public float aJD;
        public MaskShape aJE;
        public MaskAngle aJw;
        public float aJx;
        public float aJy;
        public int aJz;

        private a() {
        }

        public int cT(int i) {
            return this.aJz > 0 ? this.aJz : (int) (i * this.aJC);
        }

        public int cU(int i) {
            return this.aJA > 0 ? this.aJA : (int) (i * this.aJD);
        }

        public int[] Jy() {
            switch (this.aJE) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Jz() {
            switch (this.aJE) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.aJB, 1.0f), Math.min(this.aJB + this.aJy, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.aJB) - this.aJy) / 2.0f, 0.0f), Math.max((1.0f - this.aJB) / 2.0f, 0.0f), Math.min((this.aJB + 1.0f) / 2.0f, 1.0f), Math.min(((this.aJB + 1.0f) + this.aJy) / 2.0f, 1.0f)};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        public int fromX;
        public int fromY;
        public int toX;
        public int toY;

        private b() {
        }

        public void set(int i, int i2, int i3, int i4) {
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
        this.aJk = new a();
        this.aJi = new Paint();
        this.aJj = new Paint();
        this.aJj.setAntiAlias(true);
        this.aJj.setDither(true);
        this.aJj.setFilterBitmap(true);
        this.aJj.setXfermode(aJh);
        Jp();
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
                            this.aJk.aJw = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.aJk.aJw = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.aJk.aJw = MaskAngle.CW_270;
                            break;
                        default:
                            this.aJk.aJw = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.aJk.aJE = MaskShape.RADIAL;
                            break;
                        default:
                            this.aJk.aJE = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.aJk.aJy = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.aJk.aJz = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.aJk.aJA = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.aJk.aJB = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.aJk.aJC = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.aJk.aJD = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.aJk.aJx = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void Jp() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.aJk.aJw = MaskAngle.CW_0;
        this.aJk.aJE = MaskShape.LINEAR;
        this.aJk.aJy = 0.5f;
        this.aJk.aJz = 0;
        this.aJk.aJA = 0;
        this.aJk.aJB = 0.0f;
        this.aJk.aJC = 1.0f;
        this.aJk.aJD = 1.0f;
        this.aJk.aJx = 340.0f;
        this.aJl = new b();
        setBaseAlpha(1.0f);
        Jv();
    }

    public void setAutoStart(boolean z) {
        this.aJo = z;
        Jv();
    }

    public float getBaseAlpha() {
        return this.aJi.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.aJi.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        Jv();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        Jv();
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        Jv();
    }

    public int getRepeatDelay() {
        return this.aJp;
    }

    public void setRepeatDelay(int i) {
        this.aJp = i;
        Jv();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        Jv();
    }

    public MaskShape getMaskShape() {
        return this.aJk.aJE;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.aJk.aJE = maskShape;
        Jv();
    }

    public MaskAngle getAngle() {
        return this.aJk.aJw;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.aJk.aJw = maskAngle;
        Jv();
    }

    public float getDropoff() {
        return this.aJk.aJy;
    }

    public void setDropoff(float f) {
        this.aJk.aJy = f;
        Jv();
    }

    public int getFixedWidth() {
        return this.aJk.aJz;
    }

    public void setFixedWidth(int i) {
        this.aJk.aJz = i;
        Jv();
    }

    public int getFixedHeight() {
        return this.aJk.aJA;
    }

    public void setFixedHeight(int i) {
        this.aJk.aJA = i;
        Jv();
    }

    public float getIntensity() {
        return this.aJk.aJB;
    }

    public void setIntensity(float f) {
        this.aJk.aJB = f;
        Jv();
    }

    public float getRelativeWidth() {
        return this.aJk.aJC;
    }

    public void setRelativeWidth(int i) {
        this.aJk.aJC = i;
        Jv();
    }

    public float getRelativeHeight() {
        return this.aJk.aJD;
    }

    public void setRelativeHeight(int i) {
        this.aJk.aJD = i;
        Jv();
    }

    public float getTilt() {
        return this.aJk.aJx;
    }

    public void setTilt(float f) {
        this.aJk.aJx = f;
        Jv();
    }

    public void Jq() {
        if (!this.aJs) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.aJs = true;
        }
    }

    public void Jr() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.aJs = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.aJq != i) {
            this.aJq = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.aJr != i) {
            this.aJr = i;
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
                boolean z = ShimmerFrameLayout.this.aJs;
                ShimmerFrameLayout.this.Jv();
                if (ShimmerFrameLayout.this.aJo || z) {
                    ShimmerFrameLayout.this.Jq();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Jr();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.aJs || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            j(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean j(Canvas canvas) {
        Bitmap Js = Js();
        Bitmap Jt = Jt();
        if (Js == null || Jt == null) {
            return false;
        }
        k(new Canvas(Js));
        canvas.drawBitmap(Js, 0.0f, 0.0f, this.aJi);
        l(new Canvas(Jt));
        canvas.drawBitmap(Jt, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap Js() {
        if (this.aJn == null) {
            this.aJn = Ju();
        }
        return this.aJn;
    }

    private Bitmap Jt() {
        if (this.aJm == null) {
            this.aJm = Ju();
        }
        return this.aJm;
    }

    private Bitmap Ju() {
        int width = getWidth();
        int height = getHeight();
        try {
            return B(width, height);
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

    private void k(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void l(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.aJq, this.aJr, this.aJq + maskBitmap.getWidth(), this.aJr + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.aJq, this.aJr, this.aJj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jv() {
        Jr();
        Jw();
        Jx();
    }

    private void Jw() {
        if (this.Yy != null) {
            this.Yy.recycle();
            this.Yy = null;
        }
    }

    private void Jx() {
        if (this.aJn != null) {
            this.aJn.recycle();
            this.aJn = null;
        }
        if (this.aJm != null) {
            this.aJm.recycle();
            this.aJm = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.Yy != null) {
            return this.Yy;
        }
        int cT = this.aJk.cT(getWidth());
        int cU = this.aJk.cU(getHeight());
        this.Yy = B(cT, cU);
        Canvas canvas = new Canvas(this.Yy);
        switch (this.aJk.aJE) {
            case RADIAL:
                radialGradient = new RadialGradient(cT / 2, cU / 2, (float) (Math.max(cT, cU) / Math.sqrt(2.0d)), this.aJk.Jy(), this.aJk.Jz(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.aJk.aJw) {
                    case CW_90:
                        i = cU;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = cT;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = cU;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = cT;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.aJk.Jy(), this.aJk.Jz(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.aJk.aJx, cT / 2, cU / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(cT, cU))) / 2;
        canvas.drawRect(-sqrt, -sqrt, cT + sqrt, sqrt + cU, paint);
        return this.Yy;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.aJu[this.aJk.aJE.ordinal()];
        switch (this.aJk.aJw) {
            case CW_90:
                this.aJl.set(0, -height, 0, height);
                break;
            case CW_180:
                this.aJl.set(width, 0, -width, 0);
                break;
            case CW_270:
                this.aJl.set(0, height, 0, -height);
                break;
            default:
                this.aJl.set(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.aJp / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.aJp);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.aJl.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.aJl.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.aJl.toY) + (ShimmerFrameLayout.this.aJl.fromY * (1.0f - max))));
            }
        });
        return this.mAnimator;
    }

    protected static Bitmap B(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
