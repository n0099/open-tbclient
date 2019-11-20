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
    private static final PorterDuffXfermode bdi = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap Io;
    private int aba;
    private Paint bdj;
    private Paint bdk;
    private a bdl;
    private b bdm;
    private Bitmap bdn;
    private Bitmap bdo;
    private boolean bdp;
    private int bdq;
    private int bdr;
    private int bds;
    private boolean bdt;
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
        public int bdA;
        public int bdB;
        public float bdC;
        public float bdD;
        public float bdE;
        public MaskShape bdF;
        public MaskAngle bdx;
        public float bdy;
        public float bdz;

        private a() {
        }

        public int dS(int i) {
            return this.bdA > 0 ? this.bdA : (int) (i * this.bdD);
        }

        public int dT(int i) {
            return this.bdB > 0 ? this.bdB : (int) (i * this.bdE);
        }

        public int[] Pj() {
            switch (this.bdF) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] Pk() {
            switch (this.bdF) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.bdC, 1.0f), Math.min(this.bdC + this.bdz, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.bdC) - this.bdz) / 2.0f, 0.0f), Math.max((1.0f - this.bdC) / 2.0f, 0.0f), Math.min((this.bdC + 1.0f) / 2.0f, 1.0f), Math.min(((this.bdC + 1.0f) + this.bdz) / 2.0f, 1.0f)};
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
        this.bdl = new a();
        this.bdj = new Paint();
        this.bdk = new Paint();
        this.bdk.setAntiAlias(true);
        this.bdk.setDither(true);
        this.bdk.setFilterBitmap(true);
        this.bdk.setXfermode(bdi);
        Pa();
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
                            this.bdl.bdx = MaskAngle.CW_90;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
                            this.bdl.bdx = MaskAngle.CW_180;
                            break;
                        case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                            this.bdl.bdx = MaskAngle.CW_270;
                            break;
                        default:
                            this.bdl.bdx = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shape, 0)) {
                        case 1:
                            this.bdl.bdF = MaskShape.RADIAL;
                            break;
                        default:
                            this.bdl.bdF = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.bdl.bdz = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.bdl.bdA = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.bdl.bdB = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.bdl.bdC = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.bdl.bdD = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.bdl.bdE = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.bdl.bdy = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void Pa() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.bdl.bdx = MaskAngle.CW_0;
        this.bdl.bdF = MaskShape.LINEAR;
        this.bdl.bdz = 0.5f;
        this.bdl.bdA = 0;
        this.bdl.bdB = 0;
        this.bdl.bdC = 0.0f;
        this.bdl.bdD = 1.0f;
        this.bdl.bdE = 1.0f;
        this.bdl.bdy = 340.0f;
        this.bdm = new b();
        setBaseAlpha(1.0f);
        Pg();
    }

    public void setAutoStart(boolean z) {
        this.bdp = z;
        Pg();
    }

    public float getBaseAlpha() {
        return this.bdj.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.bdj.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
        Pg();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void setDuration(int i) {
        this.mDuration = i;
        Pg();
    }

    public int getRepeatCount() {
        return this.aba;
    }

    public void setRepeatCount(int i) {
        this.aba = i;
        Pg();
    }

    public int getRepeatDelay() {
        return this.bdq;
    }

    public void setRepeatDelay(int i) {
        this.bdq = i;
        Pg();
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
        Pg();
    }

    public MaskShape getMaskShape() {
        return this.bdl.bdF;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.bdl.bdF = maskShape;
        Pg();
    }

    public MaskAngle getAngle() {
        return this.bdl.bdx;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.bdl.bdx = maskAngle;
        Pg();
    }

    public float getDropoff() {
        return this.bdl.bdz;
    }

    public void setDropoff(float f) {
        this.bdl.bdz = f;
        Pg();
    }

    public int getFixedWidth() {
        return this.bdl.bdA;
    }

    public void setFixedWidth(int i) {
        this.bdl.bdA = i;
        Pg();
    }

    public int getFixedHeight() {
        return this.bdl.bdB;
    }

    public void setFixedHeight(int i) {
        this.bdl.bdB = i;
        Pg();
    }

    public float getIntensity() {
        return this.bdl.bdC;
    }

    public void setIntensity(float f) {
        this.bdl.bdC = f;
        Pg();
    }

    public float getRelativeWidth() {
        return this.bdl.bdD;
    }

    public void setRelativeWidth(int i) {
        this.bdl.bdD = i;
        Pg();
    }

    public float getRelativeHeight() {
        return this.bdl.bdE;
    }

    public void setRelativeHeight(int i) {
        this.bdl.bdE = i;
        Pg();
    }

    public float getTilt() {
        return this.bdl.bdy;
    }

    public void setTilt(float f) {
        this.bdl.bdy = f;
        Pg();
    }

    public void Pb() {
        if (!this.bdt) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.bdt = true;
        }
    }

    public void Pc() {
        if (this.mAnimator != null) {
            this.mAnimator.end();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
        }
        this.mAnimator = null;
        this.bdt = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.bdr != i) {
            this.bdr = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.bds != i) {
            this.bds = i;
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
                boolean z = ShimmerFrameLayout.this.bdt;
                ShimmerFrameLayout.this.Pg();
                if (ShimmerFrameLayout.this.bdp || z) {
                    ShimmerFrameLayout.this.Pb();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Pc();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.bdt || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            n(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean n(Canvas canvas) {
        Bitmap Pd = Pd();
        Bitmap Pe = Pe();
        if (Pd == null || Pe == null) {
            return false;
        }
        o(new Canvas(Pd));
        canvas.drawBitmap(Pd, 0.0f, 0.0f, this.bdj);
        p(new Canvas(Pe));
        canvas.drawBitmap(Pe, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap Pd() {
        if (this.bdo == null) {
            this.bdo = Pf();
        }
        return this.bdo;
    }

    private Bitmap Pe() {
        if (this.bdn == null) {
            this.bdn = Pf();
        }
        return this.bdn;
    }

    private Bitmap Pf() {
        int width = getWidth();
        int height = getHeight();
        try {
            return I(width, height);
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
            canvas.clipRect(this.bdr, this.bds, this.bdr + maskBitmap.getWidth(), this.bds + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.bdr, this.bds, this.bdk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pg() {
        Pc();
        Ph();
        Pi();
    }

    private void Ph() {
        if (this.Io != null) {
            this.Io.recycle();
            this.Io = null;
        }
    }

    private void Pi() {
        if (this.bdo != null) {
            this.bdo.recycle();
            this.bdo = null;
        }
        if (this.bdn != null) {
            this.bdn.recycle();
            this.bdn = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.Io != null) {
            return this.Io;
        }
        int dS = this.bdl.dS(getWidth());
        int dT = this.bdl.dT(getHeight());
        this.Io = I(dS, dT);
        Canvas canvas = new Canvas(this.Io);
        switch (this.bdl.bdF) {
            case RADIAL:
                radialGradient = new RadialGradient(dS / 2, dT / 2, (float) (Math.max(dS, dT) / Math.sqrt(2.0d)), this.bdl.Pj(), this.bdl.Pk(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.bdl.bdx) {
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
                radialGradient = new LinearGradient(i4, i3, i2, i, this.bdl.Pj(), this.bdl.Pk(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.bdl.bdy, dS / 2, dT / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(dS, dT))) / 2;
        canvas.drawRect(-sqrt, -sqrt, dS + sqrt, sqrt + dT, paint);
        return this.Io;
    }

    private Animator getShimmerAnimation() {
        if (this.mAnimator != null) {
            return this.mAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.bdv[this.bdl.bdF.ordinal()];
        switch (this.bdl.bdx) {
            case CW_90:
                this.bdm.j(0, -height, 0, height);
                break;
            case CW_180:
                this.bdm.j(width, 0, -width, 0);
                break;
            case CW_270:
                this.bdm.j(0, height, 0, -height);
                break;
            default:
                this.bdm.j(-width, 0, width, 0);
                break;
        }
        this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f + (this.bdq / this.mDuration));
        this.mAnimator.setDuration(this.mDuration + this.bdq);
        this.mAnimator.setRepeatCount(this.aba);
        this.mAnimator.setRepeatMode(this.mRepeatMode);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.bdm.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.bdm.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.bdm.toY) + (ShimmerFrameLayout.this.bdm.fromY * (1.0f - max))));
            }
        });
        return this.mAnimator;
    }

    protected static Bitmap I(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
