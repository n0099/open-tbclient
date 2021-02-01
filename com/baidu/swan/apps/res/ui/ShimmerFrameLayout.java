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
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode dwx = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap ame;
    private int bdB;
    private a dwA;
    private b dwB;
    private Bitmap dwC;
    private Bitmap dwD;
    private boolean dwE;
    private int dwF;
    private int dwG;
    private int dwH;
    private boolean dwI;
    protected ValueAnimator dwJ;
    private Paint dwy;
    private Paint dwz;
    private int mDuration;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private int mRepeatMode;

    /* loaded from: classes9.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes9.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public MaskAngle dwN;
        public float dwO;
        public float dwP;
        public int dwQ;
        public int dwR;
        public float dwS;
        public float dwT;
        public float dwU;
        public MaskShape dwV;

        private a() {
        }

        public int iA(int i) {
            return this.dwQ > 0 ? this.dwQ : (int) (i * this.dwT);
        }

        public int iB(int i) {
            return this.dwR > 0 ? this.dwR : (int) (i * this.dwU);
        }

        public int[] aGV() {
            switch (this.dwV) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] aGW() {
            switch (this.dwV) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.dwS, 1.0f), Math.min(this.dwS + this.dwP, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.dwS) - this.dwP) / 2.0f, 0.0f), Math.max((1.0f - this.dwS) / 2.0f, 0.0f), Math.min((this.dwS + 1.0f) / 2.0f, 1.0f), Math.min(((this.dwS + 1.0f) + this.dwP) / 2.0f, 1.0f)};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        public int fromX;
        public int fromY;
        public int toX;
        public int toY;

        private b() {
        }

        public void q(int i, int i2, int i3, int i4) {
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
        this.dwA = new a();
        this.dwy = new Paint();
        this.dwz = new Paint();
        this.dwz.setAntiAlias(true);
        this.dwz.setDither(true);
        this.dwz.setFilterBitmap(true);
        this.dwz.setXfermode(dwx);
        aGN();
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
                            this.dwA.dwN = MaskAngle.CW_90;
                            break;
                        case 180:
                            this.dwA.dwN = MaskAngle.CW_180;
                            break;
                        case 270:
                            this.dwA.dwN = MaskAngle.CW_270;
                            break;
                        default:
                            this.dwA.dwN = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shimmer_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shimmer_shape, 0)) {
                        case 1:
                            this.dwA.dwV = MaskShape.RADIAL;
                            break;
                        default:
                            this.dwA.dwV = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.dwA.dwP = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.dwA.dwQ = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.dwA.dwR = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.dwA.dwS = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.dwA.dwT = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.dwA.dwU = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.dwA.dwO = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void aGN() {
        setDuration(FeatureCodes.FACE);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.dwA.dwN = MaskAngle.CW_0;
        this.dwA.dwV = MaskShape.LINEAR;
        this.dwA.dwP = 0.5f;
        this.dwA.dwQ = 0;
        this.dwA.dwR = 0;
        this.dwA.dwS = 0.0f;
        this.dwA.dwT = 1.0f;
        this.dwA.dwU = 1.0f;
        this.dwA.dwO = 340.0f;
        this.dwB = new b();
        setBaseAlpha(1.0f);
        resetAll();
    }

    public void setAutoStart(boolean z) {
        this.dwE = z;
        resetAll();
    }

    public float getBaseAlpha() {
        return this.dwy.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.dwy.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
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
        return this.bdB;
    }

    public void setRepeatCount(int i) {
        this.bdB = i;
        resetAll();
    }

    public int getRepeatDelay() {
        return this.dwF;
    }

    public void setRepeatDelay(int i) {
        this.dwF = i;
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
        return this.dwA.dwV;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.dwA.dwV = maskShape;
        resetAll();
    }

    public MaskAngle getAngle() {
        return this.dwA.dwN;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.dwA.dwN = maskAngle;
        resetAll();
    }

    public float getDropoff() {
        return this.dwA.dwP;
    }

    public void setDropoff(float f) {
        this.dwA.dwP = f;
        resetAll();
    }

    public int getFixedWidth() {
        return this.dwA.dwQ;
    }

    public void setFixedWidth(int i) {
        this.dwA.dwQ = i;
        resetAll();
    }

    public int getFixedHeight() {
        return this.dwA.dwR;
    }

    public void setFixedHeight(int i) {
        this.dwA.dwR = i;
        resetAll();
    }

    public float getIntensity() {
        return this.dwA.dwS;
    }

    public void setIntensity(float f) {
        this.dwA.dwS = f;
        resetAll();
    }

    public float getRelativeWidth() {
        return this.dwA.dwT;
    }

    public void setRelativeWidth(int i) {
        this.dwA.dwT = i;
        resetAll();
    }

    public float getRelativeHeight() {
        return this.dwA.dwU;
    }

    public void setRelativeHeight(int i) {
        this.dwA.dwU = i;
        resetAll();
    }

    public float getTilt() {
        return this.dwA.dwO;
    }

    public void setTilt(float f) {
        this.dwA.dwO = f;
        resetAll();
    }

    public void aGO() {
        if (!this.dwI) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.dwI = true;
        }
    }

    public void aGP() {
        if (this.dwJ != null) {
            this.dwJ.end();
            this.dwJ.removeAllUpdateListeners();
            this.dwJ.cancel();
        }
        this.dwJ = null;
        this.dwI = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.dwG != i) {
            this.dwG = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.dwH != i) {
            this.dwH = i;
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
                boolean z = ShimmerFrameLayout.this.dwI;
                ShimmerFrameLayout.this.resetAll();
                if (ShimmerFrameLayout.this.dwE || z) {
                    ShimmerFrameLayout.this.aGO();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        aGP();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.dwI || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            s(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean s(Canvas canvas) {
        Bitmap aGQ = aGQ();
        Bitmap aGR = aGR();
        if (aGQ == null || aGR == null) {
            return false;
        }
        t(new Canvas(aGQ));
        canvas.drawBitmap(aGQ, 0.0f, 0.0f, this.dwy);
        u(new Canvas(aGR));
        canvas.drawBitmap(aGR, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap aGQ() {
        if (this.dwD == null) {
            this.dwD = aGS();
        }
        return this.dwD;
    }

    private Bitmap aGR() {
        if (this.dwC == null) {
            this.dwC = aGS();
        }
        return this.dwC;
    }

    @SuppressLint({"SwanDebugLog"})
    private Bitmap aGS() {
        int width = getWidth();
        int height = getHeight();
        try {
            return ak(width, height);
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

    private void t(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    private void u(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            canvas.clipRect(this.dwG, this.dwH, this.dwG + maskBitmap.getWidth(), this.dwH + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.dwG, this.dwH, this.dwz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAll() {
        aGP();
        aGT();
        aGU();
    }

    private void aGT() {
        if (this.ame != null) {
            this.ame.recycle();
            this.ame = null;
        }
    }

    private void aGU() {
        if (this.dwD != null) {
            this.dwD.recycle();
            this.dwD = null;
        }
        if (this.dwC != null) {
            this.dwC.recycle();
            this.dwC = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.ame != null) {
            return this.ame;
        }
        int iA = this.dwA.iA(getWidth());
        int iB = this.dwA.iB(getHeight());
        this.ame = ak(iA, iB);
        Canvas canvas = new Canvas(this.ame);
        switch (this.dwA.dwV) {
            case RADIAL:
                radialGradient = new RadialGradient(iA / 2, iB / 2, (float) (Math.max(iA, iB) / Math.sqrt(2.0d)), this.dwA.aGV(), this.dwA.aGW(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.dwA.dwN) {
                    case CW_90:
                        i = iB;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = iA;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = iB;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = iA;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.dwA.aGV(), this.dwA.aGW(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.dwA.dwO, iA / 2, iB / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(iA, iB))) / 2;
        canvas.drawRect(-sqrt, -sqrt, iA + sqrt, sqrt + iB, paint);
        return this.ame;
    }

    private Animator getShimmerAnimation() {
        if (this.dwJ != null) {
            return this.dwJ;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.dwL[this.dwA.dwV.ordinal()];
        switch (this.dwA.dwN) {
            case CW_90:
                this.dwB.q(0, -height, 0, height);
                break;
            case CW_180:
                this.dwB.q(width, 0, -width, 0);
                break;
            case CW_270:
                this.dwB.q(0, height, 0, -height);
                break;
            default:
                this.dwB.q(-width, 0, width, 0);
                break;
        }
        this.dwJ = ValueAnimator.ofFloat(0.0f, 1.0f + (this.dwF / this.mDuration));
        this.dwJ.setDuration(this.mDuration + this.dwF);
        this.dwJ.setRepeatCount(this.bdB);
        this.dwJ.setRepeatMode(this.mRepeatMode);
        this.dwJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.dwB.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.dwB.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.dwB.toY) + (ShimmerFrameLayout.this.dwB.fromY * (1.0f - max))));
            }
        });
        return this.dwJ;
    }

    protected static Bitmap ak(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            System.gc();
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }
}
