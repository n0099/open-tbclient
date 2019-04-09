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
    private static final PorterDuffXfermode aHo = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Paint aHp;
    private Paint aHq;
    private a aHr;
    private b aHs;
    private Bitmap aHt;
    private Bitmap aHu;
    private boolean aHv;
    private int aHw;
    private int aHx;
    private int aHy;
    private boolean aHz;
    protected Bitmap aaG;
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
        public MaskAngle aHD;
        public float aHE;
        public float aHF;
        public int aHG;
        public int aHH;
        public float aHI;
        public float aHJ;
        public float aHK;
        public MaskShape aHL;

        private a() {
        }

        public int cO(int i) {
            return this.aHG > 0 ? this.aHG : (int) (i * this.aHJ);
        }

        public int cP(int i) {
            return this.aHH > 0 ? this.aHH : (int) (i * this.aHK);
        }

        public int[] Hi() {
            switch (this.aHL) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Hj() {
            switch (this.aHL) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.aHI, 1.0f), Math.min(this.aHI + this.aHF, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.aHI) - this.aHF) / 2.0f, 0.0f), Math.max((1.0f - this.aHI) / 2.0f, 0.0f), Math.min((this.aHI + 1.0f) / 2.0f, 1.0f), Math.min(((this.aHI + 1.0f) + this.aHF) / 2.0f, 1.0f)};
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
        this.aHr = new a();
        this.aHp = new Paint();
        this.aHq = new Paint();
        this.aHq.setAntiAlias(true);
        this.aHq.setDither(true);
        this.aHq.setFilterBitmap(true);
        this.aHq.setXfermode(aHo);
        GZ();
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
                            this.aHr.aHD = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.aHr.aHD = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.aHr.aHD = MaskAngle.CW_270;
                            break;
                        default:
                            this.aHr.aHD = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.aHr.aHL = MaskShape.RADIAL;
                            break;
                        default:
                            this.aHr.aHL = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.aHr.aHF = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.aHr.aHG = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.aHr.aHH = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.aHr.aHI = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.aHr.aHJ = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.aHr.aHK = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.aHr.aHE = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void GZ() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.aHr.aHD = MaskAngle.CW_0;
        this.aHr.aHL = MaskShape.LINEAR;
        this.aHr.aHF = 0.5f;
        this.aHr.aHG = 0;
        this.aHr.aHH = 0;
        this.aHr.aHI = 0.0f;
        this.aHr.aHJ = 1.0f;
        this.aHr.aHK = 1.0f;
        this.aHr.aHE = 340.0f;
        this.aHs = new b();
        setBaseAlpha(1.0f);
        Hf();
    }

    public void setAutoStart(boolean z) {
        this.aHv = z;
        Hf();
    }

    public float getBaseAlpha() {
        return this.aHp.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.aHp.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        Hf();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        Hf();
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        Hf();
    }

    public int getRepeatDelay() {
        return this.aHw;
    }

    public void setRepeatDelay(int i) {
        this.aHw = i;
        Hf();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        Hf();
    }

    public MaskShape getMaskShape() {
        return this.aHr.aHL;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.aHr.aHL = maskShape;
        Hf();
    }

    public MaskAngle getAngle() {
        return this.aHr.aHD;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.aHr.aHD = maskAngle;
        Hf();
    }

    public float getDropoff() {
        return this.aHr.aHF;
    }

    public void setDropoff(float f) {
        this.aHr.aHF = f;
        Hf();
    }

    public int getFixedWidth() {
        return this.aHr.aHG;
    }

    public void setFixedWidth(int i) {
        this.aHr.aHG = i;
        Hf();
    }

    public int getFixedHeight() {
        return this.aHr.aHH;
    }

    public void setFixedHeight(int i) {
        this.aHr.aHH = i;
        Hf();
    }

    public float getIntensity() {
        return this.aHr.aHI;
    }

    public void setIntensity(float f) {
        this.aHr.aHI = f;
        Hf();
    }

    public float getRelativeWidth() {
        return this.aHr.aHJ;
    }

    public void setRelativeWidth(int i) {
        this.aHr.aHJ = i;
        Hf();
    }

    public float getRelativeHeight() {
        return this.aHr.aHK;
    }

    public void setRelativeHeight(int i) {
        this.aHr.aHK = i;
        Hf();
    }

    public float getTilt() {
        return this.aHr.aHE;
    }

    public void setTilt(float f) {
        this.aHr.aHE = f;
        Hf();
    }

    public void Ha() {
        if (!this.aHz) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.aHz = true;
        }
    }

    public void Hb() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.aHz = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.aHx != i) {
            this.aHx = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.aHy != i) {
            this.aHy = i;
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
                boolean z = ShimmerFrameLayout.this.aHz;
                ShimmerFrameLayout.this.Hf();
                if (ShimmerFrameLayout.this.aHv || z) {
                    ShimmerFrameLayout.this.Ha();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Hb();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.aHz || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            j(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean j(Canvas canvas) {
        Bitmap Hc = Hc();
        Bitmap Hd = Hd();
        if (Hc == null || Hd == null) {
            return false;
        }
        k(new Canvas(Hc));
        canvas.drawBitmap(Hc, 0.0f, 0.0f, this.aHp);
        l(new Canvas(Hd));
        canvas.drawBitmap(Hd, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap Hc() {
        if (this.aHu == null) {
            this.aHu = He();
        }
        return this.aHu;
    }

    private Bitmap Hd() {
        if (this.aHt == null) {
            this.aHt = He();
        }
        return this.aHt;
    }

    private Bitmap He() {
        int width = getWidth();
        int height = getHeight();
        try {
            return D(width, height);
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
            canvas.clipRect(this.aHx, this.aHy, this.aHx + maskBitmap.getWidth(), this.aHy + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.aHx, this.aHy, this.aHq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf() {
        Hb();
        Hg();
        Hh();
    }

    private void Hg() {
        if (this.aaG != null) {
            this.aaG.recycle();
            this.aaG = null;
        }
    }

    private void Hh() {
        if (this.aHu != null) {
            this.aHu.recycle();
            this.aHu = null;
        }
        if (this.aHt != null) {
            this.aHt.recycle();
            this.aHt = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.aaG != null) {
            return this.aaG;
        }
        int cO = this.aHr.cO(getWidth());
        int cP = this.aHr.cP(getHeight());
        this.aaG = D(cO, cP);
        Canvas canvas = new Canvas(this.aaG);
        switch (this.aHr.aHL) {
            case RADIAL:
                radialGradient = new RadialGradient(cO / 2, cP / 2, (float) (Math.max(cO, cP) / Math.sqrt(2.0d)), this.aHr.Hi(), this.aHr.Hj(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.aHr.aHD) {
                    case CW_90:
                        i = cP;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = cO;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = cP;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = cO;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.aHr.Hi(), this.aHr.Hj(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.aHr.aHE, cO / 2, cP / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(cO, cP))) / 2;
        canvas.drawRect(-sqrt, -sqrt, cO + sqrt, sqrt + cP, paint);
        return this.aaG;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.aHB[this.aHr.aHL.ordinal()];
        switch (this.aHr.aHD) {
            case CW_90:
                this.aHs.set(0, -height, 0, height);
                break;
            case CW_180:
                this.aHs.set(width, 0, -width, 0);
                break;
            case CW_270:
                this.aHs.set(0, height, 0, -height);
                break;
            default:
                this.aHs.set(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.aHw / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.aHw);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.aHs.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.aHs.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.aHs.toY) + (ShimmerFrameLayout.this.aHs.fromY * (1.0f - max))));
            }
        });
        return this.mAnimator;
    }

    protected static Bitmap D(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
