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
    private static final PorterDuffXfermode bdA = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap IR;
    private int abu;
    private Paint bdB;
    private Paint bdC;
    private a bdD;
    private b bdE;
    private Bitmap bdF;
    private Bitmap bdG;
    private boolean bdH;
    private int bdI;
    private int bdJ;
    private int bdK;
    private boolean bdL;
    protected ValueAnimator mAnimator;
    private int mDuration;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
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
        public MaskAngle bdP;
        public float bdQ;
        public float bdR;
        public int bdS;
        public int bdT;
        public float bdU;
        public float bdV;
        public float bdW;
        public MaskShape bdX;

        private a() {
        }

        public int dS(int i) {
            return this.bdS > 0 ? this.bdS : (int) (i * this.bdV);
        }

        public int dT(int i) {
            return this.bdT > 0 ? this.bdT : (int) (i * this.bdW);
        }

        public int[] Pi() {
            switch (this.bdX) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Pj() {
            switch (this.bdX) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.bdU, 1.0f), Math.min(this.bdU + this.bdR, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.bdU) - this.bdR) / 2.0f, 0.0f), Math.max((1.0f - this.bdU) / 2.0f, 0.0f), Math.min((this.bdU + 1.0f) / 2.0f, 1.0f), Math.min(((this.bdU + 1.0f) + this.bdR) / 2.0f, 1.0f)};
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

        public void j(int i, int i2, int i3, int i4) {
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
        this.bdD = new a();
        this.bdB = new Paint();
        this.bdC = new Paint();
        this.bdC.setAntiAlias(true);
        this.bdC.setDither(true);
        this.bdC.setFilterBitmap(true);
        this.bdC.setXfermode(bdA);
        OZ();
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
                            this.bdD.bdP = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.bdD.bdP = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.bdD.bdP = MaskAngle.CW_270;
                            break;
                        default:
                            this.bdD.bdP = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.bdD.bdX = MaskShape.RADIAL;
                            break;
                        default:
                            this.bdD.bdX = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.bdD.bdR = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.bdD.bdS = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.bdD.bdT = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.bdD.bdU = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.bdD.bdV = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.bdD.bdW = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.bdD.bdQ = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void OZ() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.bdD.bdP = MaskAngle.CW_0;
        this.bdD.bdX = MaskShape.LINEAR;
        this.bdD.bdR = 0.5f;
        this.bdD.bdS = 0;
        this.bdD.bdT = 0;
        this.bdD.bdU = 0.0f;
        this.bdD.bdV = 1.0f;
        this.bdD.bdW = 1.0f;
        this.bdD.bdQ = 340.0f;
        this.bdE = new b();
        setBaseAlpha(1.0f);
        Pf();
    }

    public void setAutoStart(boolean z) {
        this.bdH = z;
        Pf();
    }

    public float getBaseAlpha() {
        return this.bdB.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.bdB.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        Pf();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        Pf();
    }

    public int getRepeatCount() {
        return this.abu;
    }

    public void setRepeatCount(int i) {
        this.abu = i;
        Pf();
    }

    public int getRepeatDelay() {
        return this.bdI;
    }

    public void setRepeatDelay(int i) {
        this.bdI = i;
        Pf();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        Pf();
    }

    public MaskShape getMaskShape() {
        return this.bdD.bdX;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.bdD.bdX = maskShape;
        Pf();
    }

    public MaskAngle getAngle() {
        return this.bdD.bdP;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.bdD.bdP = maskAngle;
        Pf();
    }

    public float getDropoff() {
        return this.bdD.bdR;
    }

    public void setDropoff(float f) {
        this.bdD.bdR = f;
        Pf();
    }

    public int getFixedWidth() {
        return this.bdD.bdS;
    }

    public void setFixedWidth(int i) {
        this.bdD.bdS = i;
        Pf();
    }

    public int getFixedHeight() {
        return this.bdD.bdT;
    }

    public void setFixedHeight(int i) {
        this.bdD.bdT = i;
        Pf();
    }

    public float getIntensity() {
        return this.bdD.bdU;
    }

    public void setIntensity(float f) {
        this.bdD.bdU = f;
        Pf();
    }

    public float getRelativeWidth() {
        return this.bdD.bdV;
    }

    public void setRelativeWidth(int i) {
        this.bdD.bdV = i;
        Pf();
    }

    public float getRelativeHeight() {
        return this.bdD.bdW;
    }

    public void setRelativeHeight(int i) {
        this.bdD.bdW = i;
        Pf();
    }

    public float getTilt() {
        return this.bdD.bdQ;
    }

    public void setTilt(float f) {
        this.bdD.bdQ = f;
        Pf();
    }

    public void Pa() {
        if (!this.bdL) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.bdL = true;
        }
    }

    public void Pb() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.bdL = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.bdJ != i) {
            this.bdJ = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.bdK != i) {
            this.bdK = i;
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
                boolean z = ShimmerFrameLayout.this.bdL;
                ShimmerFrameLayout.this.Pf();
                if (ShimmerFrameLayout.this.bdH || z) {
                    ShimmerFrameLayout.this.Pa();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Pb();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.bdL || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            n(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean n(Canvas canvas) {
        Bitmap Pc = Pc();
        Bitmap Pd = Pd();
        if (Pc == null || Pd == null) {
            return false;
        }
        o(new Canvas(Pc));
        canvas.drawBitmap(Pc, 0.0f, 0.0f, this.bdB);
        p(new Canvas(Pd));
        canvas.drawBitmap(Pd, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap Pc() {
        if (this.bdG == null) {
            this.bdG = Pe();
        }
        return this.bdG;
    }

    private Bitmap Pd() {
        if (this.bdF == null) {
            this.bdF = Pe();
        }
        return this.bdF;
    }

    private Bitmap Pe() {
        int width = getWidth();
        int height = getHeight();
        try {
            return K(width, height);
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

    private void o(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void p(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.bdJ, this.bdK, this.bdJ + maskBitmap.getWidth(), this.bdK + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.bdJ, this.bdK, this.bdC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pf() {
        Pb();
        Pg();
        Ph();
    }

    private void Pg() {
        if (this.IR != null) {
            this.IR.recycle();
            this.IR = null;
        }
    }

    private void Ph() {
        if (this.bdG != null) {
            this.bdG.recycle();
            this.bdG = null;
        }
        if (this.bdF != null) {
            this.bdF.recycle();
            this.bdF = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.IR != null) {
            return this.IR;
        }
        int dS = this.bdD.dS(getWidth());
        int dT = this.bdD.dT(getHeight());
        this.IR = K(dS, dT);
        Canvas canvas = new Canvas(this.IR);
        switch (this.bdD.bdX) {
            case RADIAL:
                radialGradient = new RadialGradient(dS / 2, dT / 2, (float) (Math.max(dS, dT) / Math.sqrt(2.0d)), this.bdD.Pi(), this.bdD.Pj(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.bdD.bdP) {
                    case CW_90:
                        i = dT;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = dS;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = dT;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = dS;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.bdD.Pi(), this.bdD.Pj(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.bdD.bdQ, dS / 2, dT / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(dS, dT))) / 2;
        canvas.drawRect(-sqrt, -sqrt, dS + sqrt, sqrt + dT, paint);
        return this.IR;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.bdN[this.bdD.bdX.ordinal()];
        switch (this.bdD.bdP) {
            case CW_90:
                this.bdE.j(0, -height, 0, height);
                break;
            case CW_180:
                this.bdE.j(width, 0, -width, 0);
                break;
            case CW_270:
                this.bdE.j(0, height, 0, -height);
                break;
            default:
                this.bdE.j(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.bdI / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.bdI);
        this.mAnimator.setRepeatCount(this.abu);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.bdE.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.bdE.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.bdE.toY) + (ShimmerFrameLayout.this.bdE.fromY * (1.0f - max))));
            }
        });
        return this.mAnimator;
    }

    protected static Bitmap K(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
