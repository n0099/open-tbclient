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
import com.baidu.swan.apps.b;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode aHj = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Paint aHk;
    private Paint aHl;
    private a aHm;
    private b aHn;
    private Bitmap aHo;
    private Bitmap aHp;
    private boolean aHq;
    private int aHr;
    private int aHs;
    private int aHt;
    private boolean aHu;
    protected Bitmap aaD;
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
        public float aHA;
        public int aHB;
        public int aHC;
        public float aHD;
        public float aHE;
        public float aHF;
        public MaskShape aHG;
        public MaskAngle aHy;
        public float aHz;

        private a() {
        }

        public int cP(int i) {
            return this.aHB > 0 ? this.aHB : (int) (i * this.aHE);
        }

        public int cQ(int i) {
            return this.aHC > 0 ? this.aHC : (int) (i * this.aHF);
        }

        public int[] Hk() {
            switch (this.aHG) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Hl() {
            switch (this.aHG) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.aHD, 1.0f), Math.min(this.aHD + this.aHA, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.aHD) - this.aHA) / 2.0f, 0.0f), Math.max((1.0f - this.aHD) / 2.0f, 0.0f), Math.min((this.aHD + 1.0f) / 2.0f, 1.0f), Math.min(((this.aHD + 1.0f) + this.aHA) / 2.0f, 1.0f)};
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
        this.aHm = new a();
        this.aHk = new Paint();
        this.aHl = new Paint();
        this.aHl.setAntiAlias(true);
        this.aHl.setDither(true);
        this.aHl.setFilterBitmap(true);
        this.aHl.setXfermode(aHj);
        Hb();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.j.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_auto_start)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(b.j.ShimmerFrameLayout_auto_start, false));
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_base_alpha)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(b.j.ShimmerFrameLayout_base_alpha, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_duration)) {
                    setDuration(obtainStyledAttributes.getInt(b.j.ShimmerFrameLayout_duration, 0));
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_repeat_count)) {
                    setRepeatCount(obtainStyledAttributes.getInt(b.j.ShimmerFrameLayout_repeat_count, 0));
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_repeat_delay)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(b.j.ShimmerFrameLayout_repeat_delay, 0));
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_repeat_mode)) {
                    setRepeatMode(obtainStyledAttributes.getInt(b.j.ShimmerFrameLayout_repeat_mode, 0));
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_angle)) {
                    switch (obtainStyledAttributes.getInt(b.j.ShimmerFrameLayout_angle, 0)) {
                        case 90:
                            this.aHm.aHy = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.aHm.aHy = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.aHm.aHy = MaskAngle.CW_270;
                            break;
                        default:
                            this.aHm.aHy = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(b.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.aHm.aHG = MaskShape.RADIAL;
                            break;
                        default:
                            this.aHm.aHG = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_dropoff)) {
                    this.aHm.aHA = obtainStyledAttributes.getFloat(b.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_fixed_width)) {
                    this.aHm.aHB = obtainStyledAttributes.getDimensionPixelSize(b.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_fixed_height)) {
                    this.aHm.aHC = obtainStyledAttributes.getDimensionPixelSize(b.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_intensity)) {
                    this.aHm.aHD = obtainStyledAttributes.getFloat(b.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_relative_width)) {
                    this.aHm.aHE = obtainStyledAttributes.getFloat(b.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_relative_height)) {
                    this.aHm.aHF = obtainStyledAttributes.getFloat(b.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(b.j.ShimmerFrameLayout_tilt)) {
                    this.aHm.aHz = obtainStyledAttributes.getFloat(b.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void Hb() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.aHm.aHy = MaskAngle.CW_0;
        this.aHm.aHG = MaskShape.LINEAR;
        this.aHm.aHA = 0.5f;
        this.aHm.aHB = 0;
        this.aHm.aHC = 0;
        this.aHm.aHD = 0.0f;
        this.aHm.aHE = 1.0f;
        this.aHm.aHF = 1.0f;
        this.aHm.aHz = 340.0f;
        this.aHn = new b();
        setBaseAlpha(1.0f);
        Hh();
    }

    public void setAutoStart(boolean z) {
        this.aHq = z;
        Hh();
    }

    public float getBaseAlpha() {
        return this.aHk.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.aHk.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        Hh();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        Hh();
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        Hh();
    }

    public int getRepeatDelay() {
        return this.aHr;
    }

    public void setRepeatDelay(int i) {
        this.aHr = i;
        Hh();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        Hh();
    }

    public MaskShape getMaskShape() {
        return this.aHm.aHG;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.aHm.aHG = maskShape;
        Hh();
    }

    public MaskAngle getAngle() {
        return this.aHm.aHy;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.aHm.aHy = maskAngle;
        Hh();
    }

    public float getDropoff() {
        return this.aHm.aHA;
    }

    public void setDropoff(float f) {
        this.aHm.aHA = f;
        Hh();
    }

    public int getFixedWidth() {
        return this.aHm.aHB;
    }

    public void setFixedWidth(int i) {
        this.aHm.aHB = i;
        Hh();
    }

    public int getFixedHeight() {
        return this.aHm.aHC;
    }

    public void setFixedHeight(int i) {
        this.aHm.aHC = i;
        Hh();
    }

    public float getIntensity() {
        return this.aHm.aHD;
    }

    public void setIntensity(float f) {
        this.aHm.aHD = f;
        Hh();
    }

    public float getRelativeWidth() {
        return this.aHm.aHE;
    }

    public void setRelativeWidth(int i) {
        this.aHm.aHE = i;
        Hh();
    }

    public float getRelativeHeight() {
        return this.aHm.aHF;
    }

    public void setRelativeHeight(int i) {
        this.aHm.aHF = i;
        Hh();
    }

    public float getTilt() {
        return this.aHm.aHz;
    }

    public void setTilt(float f) {
        this.aHm.aHz = f;
        Hh();
    }

    public void Hc() {
        if (!this.aHu) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.aHu = true;
        }
    }

    public void Hd() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.aHu = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.aHs != i) {
            this.aHs = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.aHt != i) {
            this.aHt = i;
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
                boolean z = ShimmerFrameLayout.this.aHu;
                ShimmerFrameLayout.this.Hh();
                if (ShimmerFrameLayout.this.aHq || z) {
                    ShimmerFrameLayout.this.Hc();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Hd();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.aHu || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            j(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean j(Canvas canvas) {
        Bitmap He = He();
        Bitmap Hf = Hf();
        if (He == null || Hf == null) {
            return false;
        }
        k(new Canvas(He));
        canvas.drawBitmap(He, 0.0f, 0.0f, this.aHk);
        l(new Canvas(Hf));
        canvas.drawBitmap(Hf, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap He() {
        if (this.aHp == null) {
            this.aHp = Hg();
        }
        return this.aHp;
    }

    private Bitmap Hf() {
        if (this.aHo == null) {
            this.aHo = Hg();
        }
        return this.aHo;
    }

    private Bitmap Hg() {
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
            canvas.clipRect(this.aHs, this.aHt, this.aHs + maskBitmap.getWidth(), this.aHt + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.aHs, this.aHt, this.aHl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        Hd();
        Hi();
        Hj();
    }

    private void Hi() {
        if (this.aaD != null) {
            this.aaD.recycle();
            this.aaD = null;
        }
    }

    private void Hj() {
        if (this.aHp != null) {
            this.aHp.recycle();
            this.aHp = null;
        }
        if (this.aHo != null) {
            this.aHo.recycle();
            this.aHo = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.aaD != null) {
            return this.aaD;
        }
        int cP = this.aHm.cP(getWidth());
        int cQ = this.aHm.cQ(getHeight());
        this.aaD = D(cP, cQ);
        Canvas canvas = new Canvas(this.aaD);
        switch (this.aHm.aHG) {
            case RADIAL:
                radialGradient = new RadialGradient(cP / 2, cQ / 2, (float) (Math.max(cP, cQ) / Math.sqrt(2.0d)), this.aHm.Hk(), this.aHm.Hl(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.aHm.aHy) {
                    case CW_90:
                        i = cQ;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = cP;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = cQ;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = cP;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.aHm.Hk(), this.aHm.Hl(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.aHm.aHz, cP / 2, cQ / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(cP, cQ))) / 2;
        canvas.drawRect(-sqrt, -sqrt, cP + sqrt, sqrt + cQ, paint);
        return this.aaD;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.aHw[this.aHm.aHG.ordinal()];
        switch (this.aHm.aHy) {
            case CW_90:
                this.aHn.set(0, -height, 0, height);
                break;
            case CW_180:
                this.aHn.set(width, 0, -width, 0);
                break;
            case CW_270:
                this.aHn.set(0, height, 0, -height);
                break;
            default:
                this.aHn.set(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.aHr / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.aHr);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.aHn.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.aHn.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.aHn.toY) + (ShimmerFrameLayout.this.aHn.fromY * (1.0f - max))));
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
