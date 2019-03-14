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
    private static final PorterDuffXfermode aHk = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Paint aHl;
    private Paint aHm;
    private a aHn;
    private b aHo;
    private Bitmap aHp;
    private Bitmap aHq;
    private boolean aHr;
    private int aHs;
    private int aHt;
    private int aHu;
    private boolean aHv;
    protected Bitmap aaE;
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
        public float aHB;
        public int aHC;
        public int aHD;
        public float aHE;
        public float aHF;
        public float aHG;
        public MaskShape aHH;
        public MaskAngle aHz;

        private a() {
        }

        public int cP(int i) {
            return this.aHC > 0 ? this.aHC : (int) (i * this.aHF);
        }

        public int cQ(int i) {
            return this.aHD > 0 ? this.aHD : (int) (i * this.aHG);
        }

        public int[] Hk() {
            switch (this.aHH) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Hl() {
            switch (this.aHH) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.aHE, 1.0f), Math.min(this.aHE + this.aHB, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.aHE) - this.aHB) / 2.0f, 0.0f), Math.max((1.0f - this.aHE) / 2.0f, 0.0f), Math.min((this.aHE + 1.0f) / 2.0f, 1.0f), Math.min(((this.aHE + 1.0f) + this.aHB) / 2.0f, 1.0f)};
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
        this.aHn = new a();
        this.aHl = new Paint();
        this.aHm = new Paint();
        this.aHm.setAntiAlias(true);
        this.aHm.setDither(true);
        this.aHm.setFilterBitmap(true);
        this.aHm.setXfermode(aHk);
        Hb();
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
                            this.aHn.aHz = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.aHn.aHz = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.aHn.aHz = MaskAngle.CW_270;
                            break;
                        default:
                            this.aHn.aHz = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.aHn.aHH = MaskShape.RADIAL;
                            break;
                        default:
                            this.aHn.aHH = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.aHn.aHB = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.aHn.aHC = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.aHn.aHD = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.aHn.aHE = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.aHn.aHF = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.aHn.aHG = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.aHn.aHA = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
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
        this.aHn.aHz = MaskAngle.CW_0;
        this.aHn.aHH = MaskShape.LINEAR;
        this.aHn.aHB = 0.5f;
        this.aHn.aHC = 0;
        this.aHn.aHD = 0;
        this.aHn.aHE = 0.0f;
        this.aHn.aHF = 1.0f;
        this.aHn.aHG = 1.0f;
        this.aHn.aHA = 340.0f;
        this.aHo = new b();
        setBaseAlpha(1.0f);
        Hh();
    }

    public void setAutoStart(boolean z) {
        this.aHr = z;
        Hh();
    }

    public float getBaseAlpha() {
        return this.aHl.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.aHl.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
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
        return this.aHs;
    }

    public void setRepeatDelay(int i) {
        this.aHs = i;
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
        return this.aHn.aHH;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.aHn.aHH = maskShape;
        Hh();
    }

    public MaskAngle getAngle() {
        return this.aHn.aHz;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.aHn.aHz = maskAngle;
        Hh();
    }

    public float getDropoff() {
        return this.aHn.aHB;
    }

    public void setDropoff(float f) {
        this.aHn.aHB = f;
        Hh();
    }

    public int getFixedWidth() {
        return this.aHn.aHC;
    }

    public void setFixedWidth(int i) {
        this.aHn.aHC = i;
        Hh();
    }

    public int getFixedHeight() {
        return this.aHn.aHD;
    }

    public void setFixedHeight(int i) {
        this.aHn.aHD = i;
        Hh();
    }

    public float getIntensity() {
        return this.aHn.aHE;
    }

    public void setIntensity(float f) {
        this.aHn.aHE = f;
        Hh();
    }

    public float getRelativeWidth() {
        return this.aHn.aHF;
    }

    public void setRelativeWidth(int i) {
        this.aHn.aHF = i;
        Hh();
    }

    public float getRelativeHeight() {
        return this.aHn.aHG;
    }

    public void setRelativeHeight(int i) {
        this.aHn.aHG = i;
        Hh();
    }

    public float getTilt() {
        return this.aHn.aHA;
    }

    public void setTilt(float f) {
        this.aHn.aHA = f;
        Hh();
    }

    public void Hc() {
        if (!this.aHv) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.aHv = true;
        }
    }

    public void Hd() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.aHv = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.aHt != i) {
            this.aHt = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.aHu != i) {
            this.aHu = i;
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
                boolean z = ShimmerFrameLayout.this.aHv;
                ShimmerFrameLayout.this.Hh();
                if (ShimmerFrameLayout.this.aHr || z) {
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
        if (!this.aHv || getWidth() <= 0 || getHeight() <= 0) {
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
        canvas.drawBitmap(He, 0.0f, 0.0f, this.aHl);
        l(new Canvas(Hf));
        canvas.drawBitmap(Hf, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap He() {
        if (this.aHq == null) {
            this.aHq = Hg();
        }
        return this.aHq;
    }

    private Bitmap Hf() {
        if (this.aHp == null) {
            this.aHp = Hg();
        }
        return this.aHp;
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
            canvas.clipRect(this.aHt, this.aHu, this.aHt + maskBitmap.getWidth(), this.aHu + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.aHt, this.aHu, this.aHm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        Hd();
        Hi();
        Hj();
    }

    private void Hi() {
        if (this.aaE != null) {
            this.aaE.recycle();
            this.aaE = null;
        }
    }

    private void Hj() {
        if (this.aHq != null) {
            this.aHq.recycle();
            this.aHq = null;
        }
        if (this.aHp != null) {
            this.aHp.recycle();
            this.aHp = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.aaE != null) {
            return this.aaE;
        }
        int cP = this.aHn.cP(getWidth());
        int cQ = this.aHn.cQ(getHeight());
        this.aaE = D(cP, cQ);
        Canvas canvas = new Canvas(this.aaE);
        switch (this.aHn.aHH) {
            case RADIAL:
                radialGradient = new RadialGradient(cP / 2, cQ / 2, (float) (Math.max(cP, cQ) / Math.sqrt(2.0d)), this.aHn.Hk(), this.aHn.Hl(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.aHn.aHz) {
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
                radialGradient = new LinearGradient(i4, i3, i2, i, this.aHn.Hk(), this.aHn.Hl(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.aHn.aHA, cP / 2, cQ / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(cP, cQ))) / 2;
        canvas.drawRect(-sqrt, -sqrt, cP + sqrt, sqrt + cQ, paint);
        return this.aaE;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.aHx[this.aHn.aHH.ordinal()];
        switch (this.aHn.aHz) {
            case CW_90:
                this.aHo.set(0, -height, 0, height);
                break;
            case CW_180:
                this.aHo.set(width, 0, -width, 0);
                break;
            case CW_270:
                this.aHo.set(0, height, 0, -height);
                break;
            default:
                this.aHo.set(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.aHs / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.aHs);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.aHo.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.aHo.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.aHo.toY) + (ShimmerFrameLayout.this.aHo.fromY * (1.0f - max))));
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
