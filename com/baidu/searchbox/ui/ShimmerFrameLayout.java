package com.baidu.searchbox.ui;

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
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class ShimmerFrameLayout extends FrameLayout {
    public static final PorterDuffXfermode DST_IN_PORTER_DUFF_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public static final String TAG = "ShimmerFrameLayout";
    public Paint mAlphaPaint;
    public boolean mAnimationStarted;
    public ValueAnimator mAnimator;
    public boolean mAutoStart;
    public int mDuration;
    public ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    public Mask mMask;
    public Bitmap mMaskBitmap;
    public int mMaskOffsetX;
    public int mMaskOffsetY;
    public Paint mMaskPaint;
    public MaskTranslation mMaskTranslation;
    public Bitmap mRenderMaskBitmap;
    public Bitmap mRenderUnmaskBitmap;
    public int mRepeatCount;
    public int mRepeatDelay;
    public int mRepeatMode;

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

    /* renamed from: com.baidu.searchbox.ui.ShimmerFrameLayout$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape;

        static {
            int[] iArr = new int[MaskAngle.values().length];
            $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle = iArr;
            try {
                iArr[MaskAngle.CW_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[MaskAngle.CW_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[MaskAngle.CW_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[MaskAngle.CW_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[MaskShape.values().length];
            $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape = iArr2;
            try {
                iArr2[MaskShape.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[MaskShape.RADIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[MaskShape.WHITE_LINEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Mask {
        public static final int BLACK = 0;
        public static final int WHITE = 1;
        public MaskAngle angle;
        public float dropoff;
        public int fixedHeight;
        public int fixedWidth;
        public float intensity;
        public float relativeHeight;
        public float relativeWidth;
        public MaskShape shape;
        public float tilt;

        public Mask() {
        }

        public int maskHeight(int i) {
            int i2 = this.fixedHeight;
            if (i2 <= 0) {
                return (int) (i * this.relativeHeight);
            }
            return i2;
        }

        public int maskWidth(int i) {
            int i2 = this.fixedWidth;
            if (i2 <= 0) {
                return (int) (i * this.relativeWidth);
            }
            return i2;
        }

        public int[] getGradientColors() {
            int i = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[this.shape.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    return new int[]{0, -16777216, -16777216, 0};
                }
                return new int[]{-16777216, 0, 0, -16777216};
            }
            return new int[]{-16777216, -16777216, 0};
        }

        public float[] getGradientPositions() {
            return AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[this.shape.ordinal()] != 2 ? new float[]{Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f), Math.max((1.0f - this.intensity) / 2.0f, 0.0f), Math.min((this.intensity + 1.0f) / 2.0f, 1.0f), Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.intensity, 1.0f), Math.min(this.intensity + this.dropoff, 1.0f)};
        }
    }

    /* loaded from: classes4.dex */
    public static class MaskTranslation {
        public int fromX;
        public int fromY;
        public int toX;
        public int toY;

        public MaskTranslation() {
        }

        public void set(int i, int i2, int i3, int i4) {
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.searchbox.ui.ShimmerFrameLayout.1
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

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAll() {
        stopShimmerAnimation();
        resetMaskBitmap();
        resetRenderedView();
    }

    private void resetMaskBitmap() {
        Bitmap bitmap = this.mMaskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mMaskBitmap = null;
        }
    }

    private void resetRenderedView() {
        Bitmap bitmap = this.mRenderUnmaskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mRenderUnmaskBitmap = null;
        }
        Bitmap bitmap2 = this.mRenderMaskBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.mRenderMaskBitmap = null;
        }
    }

    private Bitmap tryObtainRenderMaskBitmap() {
        if (this.mRenderMaskBitmap == null) {
            this.mRenderMaskBitmap = tryCreateRenderBitmap();
        }
        return this.mRenderMaskBitmap;
    }

    private Bitmap tryObtainRenderUnmaskBitmap() {
        if (this.mRenderUnmaskBitmap == null) {
            this.mRenderUnmaskBitmap = tryCreateRenderBitmap();
        }
        return this.mRenderUnmaskBitmap;
    }

    public MaskAngle getAngle() {
        return this.mMask.angle;
    }

    public float getBaseAlpha() {
        return this.mAlphaPaint.getAlpha() / 255.0f;
    }

    public float getDropoff() {
        return this.mMask.dropoff;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getFixedHeight() {
        return this.mMask.fixedHeight;
    }

    public int getFixedWidth() {
        return this.mMask.fixedWidth;
    }

    public float getIntensity() {
        return this.mMask.intensity;
    }

    public MaskShape getMaskShape() {
        return this.mMask.shape;
    }

    public float getRelativeHeight() {
        return this.mMask.relativeHeight;
    }

    public float getRelativeWidth() {
        return this.mMask.relativeWidth;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatDelay() {
        return this.mRepeatDelay;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public float getTilt() {
        return this.mMask.tilt;
    }

    public boolean isAnimationStarted() {
        return this.mAnimationStarted;
    }

    public boolean isAutoStart() {
        return this.mAutoStart;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mGlobalLayoutListener == null) {
            this.mGlobalLayoutListener = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stopShimmerAnimation();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    public void startShimmerAnimation() {
        if (this.mAnimationStarted) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
        this.mAnimationStarted = true;
    }

    public void stopShimmerAnimation() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.mAnimationStarted = false;
    }

    public ShimmerFrameLayout(Context context) {
        this(context, null, 0);
    }

    private boolean dispatchDrawUsingBitmap(Canvas canvas) {
        Bitmap tryObtainRenderUnmaskBitmap = tryObtainRenderUnmaskBitmap();
        Bitmap tryObtainRenderMaskBitmap = tryObtainRenderMaskBitmap();
        if (tryObtainRenderUnmaskBitmap != null && tryObtainRenderMaskBitmap != null) {
            drawUnmasked(new Canvas(tryObtainRenderUnmaskBitmap));
            canvas.drawBitmap(tryObtainRenderUnmaskBitmap, 0.0f, 0.0f, this.mAlphaPaint);
            drawMasked(new Canvas(tryObtainRenderMaskBitmap));
            canvas.drawBitmap(tryObtainRenderMaskBitmap, 0.0f, 0.0f, (Paint) null);
            return true;
        }
        return false;
    }

    private void drawMasked(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap == null) {
            return;
        }
        int i = this.mMaskOffsetX;
        canvas.clipRect(i, this.mMaskOffsetY, maskBitmap.getWidth() + i, this.mMaskOffsetY + maskBitmap.getHeight());
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(maskBitmap, this.mMaskOffsetX, this.mMaskOffsetY, this.mMaskPaint);
    }

    private void drawUnmasked(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.mMaskOffsetX == i) {
            return;
        }
        this.mMaskOffsetX = i;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.mMaskOffsetY == i) {
            return;
        }
        this.mMaskOffsetY = i;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.mAnimationStarted && getWidth() > 0 && getHeight() > 0) {
            dispatchDrawUsingBitmap(canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    public void setAngle(MaskAngle maskAngle) {
        this.mMask.angle = maskAngle;
        resetAll();
    }

    public void setAutoStart(boolean z) {
        this.mAutoStart = z;
        resetAll();
    }

    public void setBaseAlpha(float f) {
        this.mAlphaPaint.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        resetAll();
    }

    public void setDropoff(float f) {
        this.mMask.dropoff = f;
        resetAll();
    }

    public void setDuration(int i) {
        this.mDuration = i;
        resetAll();
    }

    public void setFixedHeight(int i) {
        this.mMask.fixedHeight = i;
        resetAll();
    }

    public void setFixedWidth(int i) {
        this.mMask.fixedWidth = i;
        resetAll();
    }

    public void setIntensity(float f) {
        this.mMask.intensity = f;
        resetAll();
    }

    public void setMaskShape(MaskShape maskShape) {
        this.mMask.shape = maskShape;
        resetAll();
    }

    public void setRelativeHeight(int i) {
        this.mMask.relativeHeight = i;
        resetAll();
    }

    public void setRelativeWidth(int i) {
        this.mMask.relativeWidth = i;
        resetAll();
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        resetAll();
    }

    public void setRepeatDelay(int i) {
        this.mRepeatDelay = i;
        resetAll();
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        resetAll();
    }

    public void setTilt(float f) {
        this.mMask.tilt = f;
        resetAll();
    }

    public void startShimmerAnimation(long j) {
        if (this.mAnimationStarted) {
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.start();
        ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(j);
        this.mAnimationStarted = true;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static Bitmap createBitmapAndGcIfNecessary(int i, int i2) {
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
        this.mMask = new Mask();
        this.mAlphaPaint = new Paint();
        Paint paint = new Paint();
        this.mMaskPaint = paint;
        paint.setAntiAlias(true);
        this.mMaskPaint.setDither(true);
        this.mMaskPaint.setFilterBitmap(true);
        this.mMaskPaint.setXfermode(DST_IN_PORTER_DUFF_XFERMODE);
        useDefaults();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.loading.R.styleable.ShimmerFrameLayout, 0, 0);
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
                                this.mMask.angle = MaskAngle.CW_0;
                            } else {
                                this.mMask.angle = MaskAngle.CW_270;
                            }
                        } else {
                            this.mMask.angle = MaskAngle.CW_180;
                        }
                    } else {
                        this.mMask.angle = MaskAngle.CW_90;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    if (obtainStyledAttributes.getInt(13, 0) != 1) {
                        this.mMask.shape = MaskShape.LINEAR;
                    } else {
                        this.mMask.shape = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    this.mMask.dropoff = obtainStyledAttributes.getFloat(3, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    this.mMask.fixedWidth = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    this.mMask.fixedHeight = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.mMask.intensity = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.mMask.relativeWidth = obtainStyledAttributes.getFloat(9, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.mMask.relativeHeight = obtainStyledAttributes.getFloat(8, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(15)) {
                    this.mMask.tilt = obtainStyledAttributes.getFloat(15, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int sqrt;
        int i;
        int i2;
        int i3;
        Bitmap bitmap = this.mMaskBitmap;
        if (bitmap != null) {
            return bitmap;
        }
        int maskWidth = this.mMask.maskWidth(getWidth());
        int maskHeight = this.mMask.maskHeight(getHeight());
        try {
            this.mMaskBitmap = createBitmapAndGcIfNecessary(maskWidth, maskHeight);
            Canvas canvas = new Canvas(this.mMaskBitmap);
            if (AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[this.mMask.shape.ordinal()] != 2) {
                int i4 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[this.mMask.angle.ordinal()];
                int i5 = 0;
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            i3 = maskWidth;
                            i2 = 0;
                            i = 0;
                        } else {
                            i2 = maskHeight;
                        }
                    } else {
                        i5 = maskWidth;
                        i2 = 0;
                    }
                    i3 = 0;
                    i = 0;
                } else {
                    i = maskHeight;
                    i2 = 0;
                    i3 = 0;
                }
                radialGradient = new LinearGradient(i5, i2, i3, i, this.mMask.getGradientColors(), this.mMask.getGradientPositions(), Shader.TileMode.REPEAT);
            } else {
                radialGradient = new RadialGradient(maskWidth / 2, maskHeight / 2, (float) (Math.max(maskWidth, maskHeight) / Math.sqrt(2.0d)), this.mMask.getGradientColors(), this.mMask.getGradientPositions(), Shader.TileMode.REPEAT);
            }
            canvas.rotate(this.mMask.tilt, maskWidth / 2, maskHeight / 2);
            Paint paint = new Paint();
            paint.setShader(radialGradient);
            float f = -(((int) (Math.sqrt(2.0d) * Math.max(maskWidth, maskHeight))) / 2);
            canvas.drawRect(f, f, maskWidth + sqrt, maskHeight + sqrt, paint);
            return this.mMaskBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskShape[this.mMask.shape.ordinal()];
        int i2 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$ShimmerFrameLayout$MaskAngle[this.mMask.angle.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    this.mMaskTranslation.set(-width, 0, width, 0);
                } else {
                    this.mMaskTranslation.set(0, height, 0, -height);
                }
            } else {
                this.mMaskTranslation.set(width, 0, -width, 0);
            }
        } else {
            this.mMaskTranslation.set(0, -height, 0, height);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.mRepeatDelay / this.mDuration) + 1.0f);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(this.mDuration + this.mRepeatDelay);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator2.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
                float f = 1.0f - max;
                shimmerFrameLayout.setMaskOffsetX((int) ((shimmerFrameLayout.mMaskTranslation.fromX * f) + (ShimmerFrameLayout.this.mMaskTranslation.toX * max)));
                ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
                shimmerFrameLayout2.setMaskOffsetY((int) ((shimmerFrameLayout2.mMaskTranslation.fromY * f) + (ShimmerFrameLayout.this.mMaskTranslation.toY * max)));
            }
        });
        return this.mAnimator;
    }

    private Bitmap tryCreateRenderBitmap() {
        int width = getWidth();
        int height = getHeight();
        try {
            return createBitmapAndGcIfNecessary(width, height);
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
            Log.d(TAG, sb.toString());
            return null;
        }
    }

    public void useDefaults() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        Mask mask = this.mMask;
        mask.angle = MaskAngle.CW_0;
        mask.shape = MaskShape.LINEAR;
        mask.dropoff = 0.5f;
        mask.fixedWidth = 0;
        mask.fixedHeight = 0;
        mask.intensity = 0.0f;
        mask.relativeWidth = 1.0f;
        mask.relativeHeight = 1.0f;
        mask.tilt = 340.0f;
        this.mMaskTranslation = new MaskTranslation();
        setBaseAlpha(1.0f);
        resetAll();
    }
}
