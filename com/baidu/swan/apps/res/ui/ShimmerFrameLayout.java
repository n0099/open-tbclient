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
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode DST_IN_PORTER_DUFF_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private a ckh;
    private b cki;
    private Paint mAlphaPaint;
    private boolean mAnimationStarted;
    protected ValueAnimator mAnimator;
    private boolean mAutoStart;
    private int mDuration;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    protected Bitmap mMaskBitmap;
    private int mMaskOffsetX;
    private int mMaskOffsetY;
    private Paint mMaskPaint;
    private Bitmap mRenderMaskBitmap;
    private Bitmap mRenderUnmaskBitmap;
    private int mRepeatCount;
    private int mRepeatDelay;
    private int mRepeatMode;

    /* loaded from: classes11.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes11.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        public MaskAngle ckm;
        public MaskShape ckn;
        public float dropoff;
        public int fixedHeight;
        public int fixedWidth;
        public float intensity;
        public float relativeHeight;
        public float relativeWidth;
        public float tilt;

        private a() {
        }

        public int maskWidth(int i) {
            return this.fixedWidth > 0 ? this.fixedWidth : (int) (i * this.relativeWidth);
        }

        public int maskHeight(int i) {
            return this.fixedHeight > 0 ? this.fixedHeight : (int) (i * this.relativeHeight);
        }

        public int[] getGradientColors() {
            switch (this.ckn) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] getGradientPositions() {
            switch (this.ckn) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.intensity, 1.0f), Math.min(this.intensity + this.dropoff, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f), Math.max((1.0f - this.intensity) / 2.0f, 0.0f), Math.min((this.intensity + 1.0f) / 2.0f, 1.0f), Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f)};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
        this.ckh = new a();
        this.mAlphaPaint = new Paint();
        this.mMaskPaint = new Paint();
        this.mMaskPaint.setAntiAlias(true);
        this.mMaskPaint.setDither(true);
        this.mMaskPaint.setFilterBitmap(true);
        this.mMaskPaint.setXfermode(DST_IN_PORTER_DUFF_XFERMODE);
        useDefaults();
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
                            this.ckh.ckm = MaskAngle.CW_90;
                            break;
                        case 180:
                            this.ckh.ckm = MaskAngle.CW_180;
                            break;
                        case 270:
                            this.ckh.ckm = MaskAngle.CW_270;
                            break;
                        default:
                            this.ckh.ckm = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shimmer_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shimmer_shape, 0)) {
                        case 1:
                            this.ckh.ckn = MaskShape.RADIAL;
                            break;
                        default:
                            this.ckh.ckn = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.ckh.dropoff = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.ckh.fixedWidth = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.ckh.fixedHeight = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.ckh.intensity = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.ckh.relativeWidth = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.ckh.relativeHeight = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.ckh.tilt = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void useDefaults() {
        setDuration(FeatureCodes.FACE);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.ckh.ckm = MaskAngle.CW_0;
        this.ckh.ckn = MaskShape.LINEAR;
        this.ckh.dropoff = 0.5f;
        this.ckh.fixedWidth = 0;
        this.ckh.fixedHeight = 0;
        this.ckh.intensity = 0.0f;
        this.ckh.relativeWidth = 1.0f;
        this.ckh.relativeHeight = 1.0f;
        this.ckh.tilt = 340.0f;
        this.cki = new b();
        setBaseAlpha(1.0f);
        resetAll();
    }

    public void setAutoStart(boolean z) {
        this.mAutoStart = z;
        resetAll();
    }

    public float getBaseAlpha() {
        return this.mAlphaPaint.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.mAlphaPaint.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        resetAll();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        resetAll();
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        resetAll();
    }

    public int getRepeatDelay() {
        return this.mRepeatDelay;
    }

    public void setRepeatDelay(int i) {
        this.mRepeatDelay = i;
        resetAll();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        resetAll();
    }

    public MaskShape getMaskShape() {
        return this.ckh.ckn;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.ckh.ckn = maskShape;
        resetAll();
    }

    public MaskAngle getAngle() {
        return this.ckh.ckm;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.ckh.ckm = maskAngle;
        resetAll();
    }

    public float getDropoff() {
        return this.ckh.dropoff;
    }

    public void setDropoff(float f) {
        this.ckh.dropoff = f;
        resetAll();
    }

    public int getFixedWidth() {
        return this.ckh.fixedWidth;
    }

    public void setFixedWidth(int i) {
        this.ckh.fixedWidth = i;
        resetAll();
    }

    public int getFixedHeight() {
        return this.ckh.fixedHeight;
    }

    public void setFixedHeight(int i) {
        this.ckh.fixedHeight = i;
        resetAll();
    }

    public float getIntensity() {
        return this.ckh.intensity;
    }

    public void setIntensity(float f) {
        this.ckh.intensity = f;
        resetAll();
    }

    public float getRelativeWidth() {
        return this.ckh.relativeWidth;
    }

    public void setRelativeWidth(int i) {
        this.ckh.relativeWidth = i;
        resetAll();
    }

    public float getRelativeHeight() {
        return this.ckh.relativeHeight;
    }

    public void setRelativeHeight(int i) {
        this.ckh.relativeHeight = i;
        resetAll();
    }

    public float getTilt() {
        return this.ckh.tilt;
    }

    public void setTilt(float f) {
        this.ckh.tilt = f;
        resetAll();
    }

    public void startShimmerAnimation() {
        if (!this.mAnimationStarted) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.mAnimationStarted = true;
        }
    }

    public void stopShimmerAnimation() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.mAnimationStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.mMaskOffsetX != i) {
            this.mMaskOffsetX = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.mMaskOffsetY != i) {
            this.mMaskOffsetY = i;
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
                boolean z = ShimmerFrameLayout.this.mAnimationStarted;
                ShimmerFrameLayout.this.resetAll();
                if (ShimmerFrameLayout.this.mAutoStart || z) {
                    ShimmerFrameLayout.this.startShimmerAnimation();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stopShimmerAnimation();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.mAnimationStarted || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            dispatchDrawUsingBitmap(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean dispatchDrawUsingBitmap(Canvas canvas) {
        Bitmap tryObtainRenderUnmaskBitmap = tryObtainRenderUnmaskBitmap();
        Bitmap tryObtainRenderMaskBitmap = tryObtainRenderMaskBitmap();
        if (tryObtainRenderUnmaskBitmap == null || tryObtainRenderMaskBitmap == null) {
            return false;
        }
        drawUnmasked(new Canvas(tryObtainRenderUnmaskBitmap));
        canvas.drawBitmap(tryObtainRenderUnmaskBitmap, 0.0f, 0.0f, this.mAlphaPaint);
        drawMasked(new Canvas(tryObtainRenderMaskBitmap));
        canvas.drawBitmap(tryObtainRenderMaskBitmap, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap tryObtainRenderUnmaskBitmap() {
        if (this.mRenderUnmaskBitmap == null) {
            this.mRenderUnmaskBitmap = tryCreateRenderBitmap();
        }
        return this.mRenderUnmaskBitmap;
    }

    private Bitmap tryObtainRenderMaskBitmap() {
        if (this.mRenderMaskBitmap == null) {
            this.mRenderMaskBitmap = tryCreateRenderBitmap();
        }
        return this.mRenderMaskBitmap;
    }

    @SuppressLint({"SwanDebugLog"})
    private Bitmap tryCreateRenderBitmap() {
        int width = getWidth();
        int height = getHeight();
        try {
            return createBitmapAndGcIfNecessary(width, height);
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

    private void drawUnmasked(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void drawMasked(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.mMaskOffsetX, this.mMaskOffsetY, this.mMaskOffsetX + maskBitmap.getWidth(), this.mMaskOffsetY + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.mMaskOffsetX, this.mMaskOffsetY, this.mMaskPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAll() {
        stopShimmerAnimation();
        resetMaskBitmap();
        resetRenderedView();
    }

    private void resetMaskBitmap() {
        if (this.mMaskBitmap != null) {
            this.mMaskBitmap.recycle();
            this.mMaskBitmap = null;
        }
    }

    private void resetRenderedView() {
        if (this.mRenderUnmaskBitmap != null) {
            this.mRenderUnmaskBitmap.recycle();
            this.mRenderUnmaskBitmap = null;
        }
        if (this.mRenderMaskBitmap != null) {
            this.mRenderMaskBitmap.recycle();
            this.mRenderMaskBitmap = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.mMaskBitmap != null) {
            return this.mMaskBitmap;
        }
        int maskWidth = this.ckh.maskWidth(getWidth());
        int maskHeight = this.ckh.maskHeight(getHeight());
        this.mMaskBitmap = createBitmapAndGcIfNecessary(maskWidth, maskHeight);
        Canvas canvas = new Canvas(this.mMaskBitmap);
        switch (this.ckh.ckn) {
            case RADIAL:
                radialGradient = new RadialGradient(maskWidth / 2, maskHeight / 2, (float) (Math.max(maskWidth, maskHeight) / Math.sqrt(2.0d)), this.ckh.getGradientColors(), this.ckh.getGradientPositions(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.ckh.ckm) {
                    case CW_90:
                        i = maskHeight;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = maskWidth;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = maskHeight;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = maskWidth;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.ckh.getGradientColors(), this.ckh.getGradientPositions(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.ckh.tilt, maskWidth / 2, maskHeight / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(maskWidth, maskHeight))) / 2;
        canvas.drawRect(-sqrt, -sqrt, maskWidth + sqrt, sqrt + maskHeight, paint);
        return this.mMaskBitmap;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.ckk[this.ckh.ckn.ordinal()];
        switch (this.ckh.ckm) {
            case CW_90:
                this.cki.set(0, -height, 0, height);
                break;
            case CW_180:
                this.cki.set(width, 0, -width, 0);
                break;
            case CW_270:
                this.cki.set(0, height, 0, -height);
                break;
            default:
                this.cki.set(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.mRepeatDelay / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.mRepeatDelay);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.cki.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.cki.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.cki.toY) + (ShimmerFrameLayout.this.cki.fromY * (1.0f - max))));
            }
        });
        return this.mAnimator;
    }

    protected static Bitmap createBitmapAndGcIfNecessary(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
