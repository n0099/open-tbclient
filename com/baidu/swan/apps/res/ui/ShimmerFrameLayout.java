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
    private static final PorterDuffXfermode aJP = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap YS;
    private Paint aJQ;
    private Paint aJR;
    private a aJS;
    private b aJT;
    private Bitmap aJU;
    private Bitmap aJV;
    private boolean aJW;
    private int aJX;
    private int aJY;
    private int aJZ;
    private boolean aKa;
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
        public MaskAngle aKe;
        public float aKf;
        public float aKg;
        public int aKh;
        public int aKi;
        public float aKj;
        public float aKk;
        public float aKl;
        public MaskShape aKm;

        private a() {
        }

        public int cW(int i) {
            return this.aKh > 0 ? this.aKh : (int) (i * this.aKk);
        }

        public int cX(int i) {
            return this.aKi > 0 ? this.aKi : (int) (i * this.aKl);
        }

        public int[] Kl() {
            switch (this.aKm) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Km() {
            switch (this.aKm) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.aKj, 1.0f), Math.min(this.aKj + this.aKg, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.aKj) - this.aKg) / 2.0f, 0.0f), Math.max((1.0f - this.aKj) / 2.0f, 0.0f), Math.min((this.aKj + 1.0f) / 2.0f, 1.0f), Math.min(((this.aKj + 1.0f) + this.aKg) / 2.0f, 1.0f)};
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

        public void f(int i, int i2, int i3, int i4) {
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
        this.aJS = new a();
        this.aJQ = new Paint();
        this.aJR = new Paint();
        this.aJR.setAntiAlias(true);
        this.aJR.setDither(true);
        this.aJR.setFilterBitmap(true);
        this.aJR.setXfermode(aJP);
        Kc();
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
                            this.aJS.aKe = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.aJS.aKe = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.aJS.aKe = MaskAngle.CW_270;
                            break;
                        default:
                            this.aJS.aKe = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.aJS.aKm = MaskShape.RADIAL;
                            break;
                        default:
                            this.aJS.aKm = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.aJS.aKg = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.aJS.aKh = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.aJS.aKi = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.aJS.aKj = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.aJS.aKk = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.aJS.aKl = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.aJS.aKf = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void Kc() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.aJS.aKe = MaskAngle.CW_0;
        this.aJS.aKm = MaskShape.LINEAR;
        this.aJS.aKg = 0.5f;
        this.aJS.aKh = 0;
        this.aJS.aKi = 0;
        this.aJS.aKj = 0.0f;
        this.aJS.aKk = 1.0f;
        this.aJS.aKl = 1.0f;
        this.aJS.aKf = 340.0f;
        this.aJT = new b();
        setBaseAlpha(1.0f);
        Ki();
    }

    public void setAutoStart(boolean z) {
        this.aJW = z;
        Ki();
    }

    public float getBaseAlpha() {
        return this.aJQ.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.aJQ.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        Ki();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        Ki();
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        Ki();
    }

    public int getRepeatDelay() {
        return this.aJX;
    }

    public void setRepeatDelay(int i) {
        this.aJX = i;
        Ki();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        Ki();
    }

    public MaskShape getMaskShape() {
        return this.aJS.aKm;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.aJS.aKm = maskShape;
        Ki();
    }

    public MaskAngle getAngle() {
        return this.aJS.aKe;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.aJS.aKe = maskAngle;
        Ki();
    }

    public float getDropoff() {
        return this.aJS.aKg;
    }

    public void setDropoff(float f) {
        this.aJS.aKg = f;
        Ki();
    }

    public int getFixedWidth() {
        return this.aJS.aKh;
    }

    public void setFixedWidth(int i) {
        this.aJS.aKh = i;
        Ki();
    }

    public int getFixedHeight() {
        return this.aJS.aKi;
    }

    public void setFixedHeight(int i) {
        this.aJS.aKi = i;
        Ki();
    }

    public float getIntensity() {
        return this.aJS.aKj;
    }

    public void setIntensity(float f) {
        this.aJS.aKj = f;
        Ki();
    }

    public float getRelativeWidth() {
        return this.aJS.aKk;
    }

    public void setRelativeWidth(int i) {
        this.aJS.aKk = i;
        Ki();
    }

    public float getRelativeHeight() {
        return this.aJS.aKl;
    }

    public void setRelativeHeight(int i) {
        this.aJS.aKl = i;
        Ki();
    }

    public float getTilt() {
        return this.aJS.aKf;
    }

    public void setTilt(float f) {
        this.aJS.aKf = f;
        Ki();
    }

    public void Kd() {
        if (!this.aKa) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.aKa = true;
        }
    }

    public void Ke() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.aKa = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.aJY != i) {
            this.aJY = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.aJZ != i) {
            this.aJZ = i;
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
                boolean z = ShimmerFrameLayout.this.aKa;
                ShimmerFrameLayout.this.Ki();
                if (ShimmerFrameLayout.this.aJW || z) {
                    ShimmerFrameLayout.this.Kd();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Ke();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.aKa || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            j(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean j(Canvas canvas) {
        Bitmap Kf = Kf();
        Bitmap Kg = Kg();
        if (Kf == null || Kg == null) {
            return false;
        }
        k(new Canvas(Kf));
        canvas.drawBitmap(Kf, 0.0f, 0.0f, this.aJQ);
        l(new Canvas(Kg));
        canvas.drawBitmap(Kg, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap Kf() {
        if (this.aJV == null) {
            this.aJV = Kh();
        }
        return this.aJV;
    }

    private Bitmap Kg() {
        if (this.aJU == null) {
            this.aJU = Kh();
        }
        return this.aJU;
    }

    private Bitmap Kh() {
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
            canvas.clipRect(this.aJY, this.aJZ, this.aJY + maskBitmap.getWidth(), this.aJZ + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.aJY, this.aJZ, this.aJR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki() {
        Ke();
        Kj();
        Kk();
    }

    private void Kj() {
        if (this.YS != null) {
            this.YS.recycle();
            this.YS = null;
        }
    }

    private void Kk() {
        if (this.aJV != null) {
            this.aJV.recycle();
            this.aJV = null;
        }
        if (this.aJU != null) {
            this.aJU.recycle();
            this.aJU = null;
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
        int cW = this.aJS.cW(getWidth());
        int cX = this.aJS.cX(getHeight());
        this.YS = E(cW, cX);
        Canvas canvas = new Canvas(this.YS);
        switch (this.aJS.aKm) {
            case RADIAL:
                radialGradient = new RadialGradient(cW / 2, cX / 2, (float) (Math.max(cW, cX) / Math.sqrt(2.0d)), this.aJS.Kl(), this.aJS.Km(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.aJS.aKe) {
                    case CW_90:
                        i = cX;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = cW;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = cX;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = cW;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.aJS.Kl(), this.aJS.Km(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.aJS.aKf, cW / 2, cX / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(cW, cX))) / 2;
        canvas.drawRect(-sqrt, -sqrt, cW + sqrt, sqrt + cX, paint);
        return this.YS;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.aKc[this.aJS.aKm.ordinal()];
        switch (this.aJS.aKe) {
            case CW_90:
                this.aJT.f(0, -height, 0, height);
                break;
            case CW_180:
                this.aJT.f(width, 0, -width, 0);
                break;
            case CW_270:
                this.aJT.f(0, height, 0, -height);
                break;
            default:
                this.aJT.f(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.aJX / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.aJX);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.aJT.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.aJT.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.aJT.toY) + (ShimmerFrameLayout.this.aJT.fromY * (1.0f - max))));
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
