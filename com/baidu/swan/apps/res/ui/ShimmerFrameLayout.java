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
    private static final PorterDuffXfermode aKn = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap YS;
    private Paint aKo;
    private Paint aKp;
    private a aKq;
    private b aKr;
    private Bitmap aKs;
    private Bitmap aKt;
    private boolean aKu;
    private int aKv;
    private int aKw;
    private int aKx;
    private boolean aKy;
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
        public MaskAngle aKC;
        public float aKD;
        public float aKE;
        public int aKF;
        public int aKG;
        public float aKH;
        public float aKI;
        public float aKJ;
        public MaskShape aKK;

        private a() {
        }

        public int cX(int i) {
            return this.aKF > 0 ? this.aKF : (int) (i * this.aKI);
        }

        public int cY(int i) {
            return this.aKG > 0 ? this.aKG : (int) (i * this.aKJ);
        }

        public int[] Kp() {
            switch (this.aKK) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Kq() {
            switch (this.aKK) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.aKH, 1.0f), Math.min(this.aKH + this.aKE, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.aKH) - this.aKE) / 2.0f, 0.0f), Math.max((1.0f - this.aKH) / 2.0f, 0.0f), Math.min((this.aKH + 1.0f) / 2.0f, 1.0f), Math.min(((this.aKH + 1.0f) + this.aKE) / 2.0f, 1.0f)};
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

        public void i(int i, int i2, int i3, int i4) {
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
        this.aKq = new a();
        this.aKo = new Paint();
        this.aKp = new Paint();
        this.aKp.setAntiAlias(true);
        this.aKp.setDither(true);
        this.aKp.setFilterBitmap(true);
        this.aKp.setXfermode(aKn);
        Kg();
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
                            this.aKq.aKC = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.aKq.aKC = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.aKq.aKC = MaskAngle.CW_270;
                            break;
                        default:
                            this.aKq.aKC = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.aKq.aKK = MaskShape.RADIAL;
                            break;
                        default:
                            this.aKq.aKK = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.aKq.aKE = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.aKq.aKF = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.aKq.aKG = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.aKq.aKH = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.aKq.aKI = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.aKq.aKJ = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.aKq.aKD = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void Kg() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.aKq.aKC = MaskAngle.CW_0;
        this.aKq.aKK = MaskShape.LINEAR;
        this.aKq.aKE = 0.5f;
        this.aKq.aKF = 0;
        this.aKq.aKG = 0;
        this.aKq.aKH = 0.0f;
        this.aKq.aKI = 1.0f;
        this.aKq.aKJ = 1.0f;
        this.aKq.aKD = 340.0f;
        this.aKr = new b();
        setBaseAlpha(1.0f);
        Km();
    }

    public void setAutoStart(boolean z) {
        this.aKu = z;
        Km();
    }

    public float getBaseAlpha() {
        return this.aKo.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.aKo.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        Km();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        Km();
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        Km();
    }

    public int getRepeatDelay() {
        return this.aKv;
    }

    public void setRepeatDelay(int i) {
        this.aKv = i;
        Km();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        Km();
    }

    public MaskShape getMaskShape() {
        return this.aKq.aKK;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.aKq.aKK = maskShape;
        Km();
    }

    public MaskAngle getAngle() {
        return this.aKq.aKC;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.aKq.aKC = maskAngle;
        Km();
    }

    public float getDropoff() {
        return this.aKq.aKE;
    }

    public void setDropoff(float f) {
        this.aKq.aKE = f;
        Km();
    }

    public int getFixedWidth() {
        return this.aKq.aKF;
    }

    public void setFixedWidth(int i) {
        this.aKq.aKF = i;
        Km();
    }

    public int getFixedHeight() {
        return this.aKq.aKG;
    }

    public void setFixedHeight(int i) {
        this.aKq.aKG = i;
        Km();
    }

    public float getIntensity() {
        return this.aKq.aKH;
    }

    public void setIntensity(float f) {
        this.aKq.aKH = f;
        Km();
    }

    public float getRelativeWidth() {
        return this.aKq.aKI;
    }

    public void setRelativeWidth(int i) {
        this.aKq.aKI = i;
        Km();
    }

    public float getRelativeHeight() {
        return this.aKq.aKJ;
    }

    public void setRelativeHeight(int i) {
        this.aKq.aKJ = i;
        Km();
    }

    public float getTilt() {
        return this.aKq.aKD;
    }

    public void setTilt(float f) {
        this.aKq.aKD = f;
        Km();
    }

    public void Kh() {
        if (!this.aKy) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.aKy = true;
        }
    }

    public void Ki() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.aKy = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.aKw != i) {
            this.aKw = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.aKx != i) {
            this.aKx = i;
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
                boolean z = ShimmerFrameLayout.this.aKy;
                ShimmerFrameLayout.this.Km();
                if (ShimmerFrameLayout.this.aKu || z) {
                    ShimmerFrameLayout.this.Kh();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Ki();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.aKy || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            j(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean j(Canvas canvas) {
        Bitmap Kj = Kj();
        Bitmap Kk = Kk();
        if (Kj == null || Kk == null) {
            return false;
        }
        k(new Canvas(Kj));
        canvas.drawBitmap(Kj, 0.0f, 0.0f, this.aKo);
        l(new Canvas(Kk));
        canvas.drawBitmap(Kk, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap Kj() {
        if (this.aKt == null) {
            this.aKt = Kl();
        }
        return this.aKt;
    }

    private Bitmap Kk() {
        if (this.aKs == null) {
            this.aKs = Kl();
        }
        return this.aKs;
    }

    private Bitmap Kl() {
        int width = getWidth();
        int height = getHeight();
        try {
            return E(width, height);
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
            canvas.clipRect(this.aKw, this.aKx, this.aKw + maskBitmap.getWidth(), this.aKx + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.aKw, this.aKx, this.aKp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        Ki();
        Kn();
        Ko();
    }

    private void Kn() {
        if (this.YS != null) {
            this.YS.recycle();
            this.YS = null;
        }
    }

    private void Ko() {
        if (this.aKt != null) {
            this.aKt.recycle();
            this.aKt = null;
        }
        if (this.aKs != null) {
            this.aKs.recycle();
            this.aKs = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.YS != null) {
            return this.YS;
        }
        int cX = this.aKq.cX(getWidth());
        int cY = this.aKq.cY(getHeight());
        this.YS = E(cX, cY);
        Canvas canvas = new Canvas(this.YS);
        switch (this.aKq.aKK) {
            case RADIAL:
                radialGradient = new RadialGradient(cX / 2, cY / 2, (float) (Math.max(cX, cY) / Math.sqrt(2.0d)), this.aKq.Kp(), this.aKq.Kq(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.aKq.aKC) {
                    case CW_90:
                        i = cY;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = cX;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = cY;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = cX;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.aKq.Kp(), this.aKq.Kq(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.aKq.aKD, cX / 2, cY / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(cX, cY))) / 2;
        canvas.drawRect(-sqrt, -sqrt, cX + sqrt, sqrt + cY, paint);
        return this.YS;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.aKA[this.aKq.aKK.ordinal()];
        switch (this.aKq.aKC) {
            case CW_90:
                this.aKr.i(0, -height, 0, height);
                break;
            case CW_180:
                this.aKr.i(width, 0, -width, 0);
                break;
            case CW_270:
                this.aKr.i(0, height, 0, -height);
                break;
            default:
                this.aKr.i(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.aKv / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.aKv);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.aKr.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.aKr.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.aKr.toY) + (ShimmerFrameLayout.this.aKr.fromY * (1.0f - max))));
            }
        });
        return this.mAnimator;
    }

    protected static Bitmap E(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
