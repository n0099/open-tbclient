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
    private static final PorterDuffXfermode aHn = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Paint aHo;
    private Paint aHp;
    private a aHq;
    private b aHr;
    private Bitmap aHs;
    private Bitmap aHt;
    private boolean aHu;
    private int aHv;
    private int aHw;
    private int aHx;
    private boolean aHy;
    protected Bitmap aaF;
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
        public MaskAngle aHC;
        public float aHD;
        public float aHE;
        public int aHF;
        public int aHG;
        public float aHH;
        public float aHI;
        public float aHJ;
        public MaskShape aHK;

        private a() {
        }

        public int cO(int i) {
            return this.aHF > 0 ? this.aHF : (int) (i * this.aHI);
        }

        public int cP(int i) {
            return this.aHG > 0 ? this.aHG : (int) (i * this.aHJ);
        }

        public int[] Hi() {
            switch (this.aHK) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Hj() {
            switch (this.aHK) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.aHH, 1.0f), Math.min(this.aHH + this.aHE, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.aHH) - this.aHE) / 2.0f, 0.0f), Math.max((1.0f - this.aHH) / 2.0f, 0.0f), Math.min((this.aHH + 1.0f) / 2.0f, 1.0f), Math.min(((this.aHH + 1.0f) + this.aHE) / 2.0f, 1.0f)};
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
        this.aHq = new a();
        this.aHo = new Paint();
        this.aHp = new Paint();
        this.aHp.setAntiAlias(true);
        this.aHp.setDither(true);
        this.aHp.setFilterBitmap(true);
        this.aHp.setXfermode(aHn);
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
                            this.aHq.aHC = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.aHq.aHC = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.aHq.aHC = MaskAngle.CW_270;
                            break;
                        default:
                            this.aHq.aHC = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.aHq.aHK = MaskShape.RADIAL;
                            break;
                        default:
                            this.aHq.aHK = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.aHq.aHE = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.aHq.aHF = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.aHq.aHG = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.aHq.aHH = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.aHq.aHI = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.aHq.aHJ = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.aHq.aHD = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
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
        this.aHq.aHC = MaskAngle.CW_0;
        this.aHq.aHK = MaskShape.LINEAR;
        this.aHq.aHE = 0.5f;
        this.aHq.aHF = 0;
        this.aHq.aHG = 0;
        this.aHq.aHH = 0.0f;
        this.aHq.aHI = 1.0f;
        this.aHq.aHJ = 1.0f;
        this.aHq.aHD = 340.0f;
        this.aHr = new b();
        setBaseAlpha(1.0f);
        Hf();
    }

    public void setAutoStart(boolean z) {
        this.aHu = z;
        Hf();
    }

    public float getBaseAlpha() {
        return this.aHo.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.aHo.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
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
        return this.aHv;
    }

    public void setRepeatDelay(int i) {
        this.aHv = i;
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
        return this.aHq.aHK;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.aHq.aHK = maskShape;
        Hf();
    }

    public MaskAngle getAngle() {
        return this.aHq.aHC;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.aHq.aHC = maskAngle;
        Hf();
    }

    public float getDropoff() {
        return this.aHq.aHE;
    }

    public void setDropoff(float f) {
        this.aHq.aHE = f;
        Hf();
    }

    public int getFixedWidth() {
        return this.aHq.aHF;
    }

    public void setFixedWidth(int i) {
        this.aHq.aHF = i;
        Hf();
    }

    public int getFixedHeight() {
        return this.aHq.aHG;
    }

    public void setFixedHeight(int i) {
        this.aHq.aHG = i;
        Hf();
    }

    public float getIntensity() {
        return this.aHq.aHH;
    }

    public void setIntensity(float f) {
        this.aHq.aHH = f;
        Hf();
    }

    public float getRelativeWidth() {
        return this.aHq.aHI;
    }

    public void setRelativeWidth(int i) {
        this.aHq.aHI = i;
        Hf();
    }

    public float getRelativeHeight() {
        return this.aHq.aHJ;
    }

    public void setRelativeHeight(int i) {
        this.aHq.aHJ = i;
        Hf();
    }

    public float getTilt() {
        return this.aHq.aHD;
    }

    public void setTilt(float f) {
        this.aHq.aHD = f;
        Hf();
    }

    public void Ha() {
        if (!this.aHy) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.aHy = true;
        }
    }

    public void Hb() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.aHy = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.aHw != i) {
            this.aHw = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.aHx != i) {
            this.aHx = i;
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
                boolean z = ShimmerFrameLayout.this.aHy;
                ShimmerFrameLayout.this.Hf();
                if (ShimmerFrameLayout.this.aHu || z) {
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
        if (!this.aHy || getWidth() <= 0 || getHeight() <= 0) {
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
        canvas.drawBitmap(Hc, 0.0f, 0.0f, this.aHo);
        l(new Canvas(Hd));
        canvas.drawBitmap(Hd, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap Hc() {
        if (this.aHt == null) {
            this.aHt = He();
        }
        return this.aHt;
    }

    private Bitmap Hd() {
        if (this.aHs == null) {
            this.aHs = He();
        }
        return this.aHs;
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
            canvas.clipRect(this.aHw, this.aHx, this.aHw + maskBitmap.getWidth(), this.aHx + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.aHw, this.aHx, this.aHp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf() {
        Hb();
        Hg();
        Hh();
    }

    private void Hg() {
        if (this.aaF != null) {
            this.aaF.recycle();
            this.aaF = null;
        }
    }

    private void Hh() {
        if (this.aHt != null) {
            this.aHt.recycle();
            this.aHt = null;
        }
        if (this.aHs != null) {
            this.aHs.recycle();
            this.aHs = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.aaF != null) {
            return this.aaF;
        }
        int cO = this.aHq.cO(getWidth());
        int cP = this.aHq.cP(getHeight());
        this.aaF = D(cO, cP);
        Canvas canvas = new Canvas(this.aaF);
        switch (this.aHq.aHK) {
            case RADIAL:
                radialGradient = new RadialGradient(cO / 2, cP / 2, (float) (Math.max(cO, cP) / Math.sqrt(2.0d)), this.aHq.Hi(), this.aHq.Hj(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.aHq.aHC) {
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
                radialGradient = new LinearGradient(i4, i3, i2, i, this.aHq.Hi(), this.aHq.Hj(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.aHq.aHD, cO / 2, cP / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(cO, cP))) / 2;
        canvas.drawRect(-sqrt, -sqrt, cO + sqrt, sqrt + cP, paint);
        return this.aaF;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.aHA[this.aHq.aHK.ordinal()];
        switch (this.aHq.aHC) {
            case CW_90:
                this.aHr.set(0, -height, 0, height);
                break;
            case CW_180:
                this.aHr.set(width, 0, -width, 0);
                break;
            case CW_270:
                this.aHr.set(0, height, 0, -height);
                break;
            default:
                this.aHr.set(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.aHv / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.aHv);
        this.mAnimator.setRepeatCount(this.mRepeatCount);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.aHr.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.aHr.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.aHr.toY) + (ShimmerFrameLayout.this.aHr.fromY * (1.0f - max))));
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
