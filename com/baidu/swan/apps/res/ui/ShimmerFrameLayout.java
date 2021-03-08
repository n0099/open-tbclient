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
/* loaded from: classes8.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private static final PorterDuffXfermode dxY = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    protected Bitmap anw;
    private int bfe;
    private Paint dxZ;
    private Paint dya;
    private a dyb;
    private b dyc;
    private Bitmap dyd;
    private Bitmap dye;
    private boolean dyf;
    private int dyg;
    private int dyh;
    private int dyi;
    private boolean dyj;
    protected ValueAnimator dyk;
    private int mDuration;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private int mRepeatMode;

    /* loaded from: classes8.dex */
    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    /* loaded from: classes8.dex */
    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        public MaskAngle dyo;
        public float dyp;
        public float dyq;
        public int dyr;
        public int dys;
        public float dyt;
        public float dyu;
        public float dyv;
        public MaskShape dyw;

        private a() {
        }

        public int iB(int i) {
            return this.dyr > 0 ? this.dyr : (int) (i * this.dyu);
        }

        public int iC(int i) {
            return this.dys > 0 ? this.dys : (int) (i * this.dyv);
        }

        public int[] aGY() {
            switch (this.dyw) {
                case RADIAL:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
                case WHITE_LINEAR:
                    return new int[]{ViewCompat.MEASURED_STATE_MASK, 0, 0, ViewCompat.MEASURED_STATE_MASK};
                default:
                    return new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0};
            }
        }

        public float[] aGZ() {
            switch (this.dyw) {
                case RADIAL:
                    return new float[]{0.0f, Math.min(this.dyt, 1.0f), Math.min(this.dyt + this.dyq, 1.0f)};
                default:
                    return new float[]{Math.max(((1.0f - this.dyt) - this.dyq) / 2.0f, 0.0f), Math.max((1.0f - this.dyt) / 2.0f, 0.0f), Math.min((this.dyt + 1.0f) / 2.0f, 1.0f), Math.min(((this.dyt + 1.0f) + this.dyq) / 2.0f, 1.0f)};
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
        this.dyb = new a();
        this.dxZ = new Paint();
        this.dya = new Paint();
        this.dya.setAntiAlias(true);
        this.dya.setDither(true);
        this.dya.setFilterBitmap(true);
        this.dya.setXfermode(dxY);
        aGQ();
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
                            this.dyb.dyo = MaskAngle.CW_90;
                            break;
                        case 180:
                            this.dyb.dyo = MaskAngle.CW_180;
                            break;
                        case 270:
                            this.dyb.dyo = MaskAngle.CW_270;
                            break;
                        default:
                            this.dyb.dyo = MaskAngle.CW_0;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_shimmer_shape)) {
                    switch (obtainStyledAttributes.getInt(a.j.ShimmerFrameLayout_shimmer_shape, 0)) {
                        case 1:
                            this.dyb.dyw = MaskShape.RADIAL;
                            break;
                        default:
                            this.dyb.dyw = MaskShape.LINEAR;
                            break;
                    }
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_dropoff)) {
                    this.dyb.dyq = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_dropoff, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_width)) {
                    this.dyb.dyr = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_width, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_fixed_height)) {
                    this.dyb.dys = obtainStyledAttributes.getDimensionPixelSize(a.j.ShimmerFrameLayout_fixed_height, 0);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_intensity)) {
                    this.dyb.dyt = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_intensity, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_width)) {
                    this.dyb.dyu = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_width, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_relative_height)) {
                    this.dyb.dyv = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_relative_height, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(a.j.ShimmerFrameLayout_tilt)) {
                    this.dyb.dyp = obtainStyledAttributes.getFloat(a.j.ShimmerFrameLayout_tilt, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void aGQ() {
        setDuration(FeatureCodes.FACE);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        this.dyb.dyo = MaskAngle.CW_0;
        this.dyb.dyw = MaskShape.LINEAR;
        this.dyb.dyq = 0.5f;
        this.dyb.dyr = 0;
        this.dyb.dys = 0;
        this.dyb.dyt = 0.0f;
        this.dyb.dyu = 1.0f;
        this.dyb.dyv = 1.0f;
        this.dyb.dyp = 340.0f;
        this.dyc = new b();
        setBaseAlpha(1.0f);
        resetAll();
    }

    public void setAutoStart(boolean z) {
        this.dyf = z;
        resetAll();
    }

    public float getBaseAlpha() {
        return this.dxZ.getAlpha() / 255.0f;
    }

    public void setBaseAlpha(float f) {
        this.dxZ.setAlpha((int) (clamp(0.0f, 1.0f, f) * 255.0f));
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
        return this.bfe;
    }

    public void setRepeatCount(int i) {
        this.bfe = i;
        resetAll();
    }

    public int getRepeatDelay() {
        return this.dyg;
    }

    public void setRepeatDelay(int i) {
        this.dyg = i;
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
        return this.dyb.dyw;
    }

    public void setMaskShape(MaskShape maskShape) {
        this.dyb.dyw = maskShape;
        resetAll();
    }

    public MaskAngle getAngle() {
        return this.dyb.dyo;
    }

    public void setAngle(MaskAngle maskAngle) {
        this.dyb.dyo = maskAngle;
        resetAll();
    }

    public float getDropoff() {
        return this.dyb.dyq;
    }

    public void setDropoff(float f) {
        this.dyb.dyq = f;
        resetAll();
    }

    public int getFixedWidth() {
        return this.dyb.dyr;
    }

    public void setFixedWidth(int i) {
        this.dyb.dyr = i;
        resetAll();
    }

    public int getFixedHeight() {
        return this.dyb.dys;
    }

    public void setFixedHeight(int i) {
        this.dyb.dys = i;
        resetAll();
    }

    public float getIntensity() {
        return this.dyb.dyt;
    }

    public void setIntensity(float f) {
        this.dyb.dyt = f;
        resetAll();
    }

    public float getRelativeWidth() {
        return this.dyb.dyu;
    }

    public void setRelativeWidth(int i) {
        this.dyb.dyu = i;
        resetAll();
    }

    public float getRelativeHeight() {
        return this.dyb.dyv;
    }

    public void setRelativeHeight(int i) {
        this.dyb.dyv = i;
        resetAll();
    }

    public float getTilt() {
        return this.dyb.dyp;
    }

    public void setTilt(float f) {
        this.dyb.dyp = f;
        resetAll();
    }

    public void aGR() {
        if (!this.dyj) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.dyj = true;
        }
    }

    public void aGS() {
        if (this.dyk != null) {
            this.dyk.end();
            this.dyk.removeAllUpdateListeners();
            this.dyk.cancel();
        }
        this.dyk = null;
        this.dyj = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        if (this.dyh != i) {
            this.dyh = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        if (this.dyi != i) {
            this.dyi = i;
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
                boolean z = ShimmerFrameLayout.this.dyj;
                ShimmerFrameLayout.this.resetAll();
                if (ShimmerFrameLayout.this.dyf || z) {
                    ShimmerFrameLayout.this.aGR();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        aGS();
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.dyj || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            s(canvas);
        }
    }

    private static float clamp(float f, float f2, float f3) {
        return Math.min(f2, Math.max(f, f3));
    }

    private boolean s(Canvas canvas) {
        Bitmap aGT = aGT();
        Bitmap aGU = aGU();
        if (aGT == null || aGU == null) {
            return false;
        }
        t(new Canvas(aGT));
        canvas.drawBitmap(aGT, 0.0f, 0.0f, this.dxZ);
        u(new Canvas(aGU));
        canvas.drawBitmap(aGU, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private Bitmap aGT() {
        if (this.dye == null) {
            this.dye = aGV();
        }
        return this.dye;
    }

    private Bitmap aGU() {
        if (this.dyd == null) {
            this.dyd = aGV();
        }
        return this.dyd;
    }

    @SuppressLint({"SwanDebugLog"})
    private Bitmap aGV() {
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
            canvas.clipRect(this.dyh, this.dyi, this.dyh + maskBitmap.getWidth(), this.dyi + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, this.dyh, this.dyi, this.dya);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAll() {
        aGS();
        aGW();
        aGX();
    }

    private void aGW() {
        if (this.anw != null) {
            this.anw.recycle();
            this.anw = null;
        }
    }

    private void aGX() {
        if (this.dye != null) {
            this.dye.recycle();
            this.dye = null;
        }
        if (this.dyd != null) {
            this.dyd.recycle();
            this.dyd = null;
        }
    }

    private Bitmap getMaskBitmap() {
        Shader radialGradient;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.anw != null) {
            return this.anw;
        }
        int iB = this.dyb.iB(getWidth());
        int iC = this.dyb.iC(getHeight());
        this.anw = ak(iB, iC);
        Canvas canvas = new Canvas(this.anw);
        switch (this.dyb.dyw) {
            case RADIAL:
                radialGradient = new RadialGradient(iB / 2, iC / 2, (float) (Math.max(iB, iC) / Math.sqrt(2.0d)), this.dyb.aGY(), this.dyb.aGZ(), Shader.TileMode.REPEAT);
                break;
            default:
                switch (this.dyb.dyo) {
                    case CW_90:
                        i = iC;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        break;
                    case CW_180:
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        i4 = iB;
                        break;
                    case CW_270:
                        i = 0;
                        i2 = 0;
                        i3 = iC;
                        i4 = 0;
                        break;
                    default:
                        i = 0;
                        i2 = iB;
                        i3 = 0;
                        i4 = 0;
                        break;
                }
                radialGradient = new LinearGradient(i4, i3, i2, i, this.dyb.aGY(), this.dyb.aGZ(), Shader.TileMode.REPEAT);
                break;
        }
        canvas.rotate(this.dyb.dyp, iB / 2, iC / 2);
        Paint paint = new Paint();
        paint.setShader(radialGradient);
        int sqrt = ((int) (Math.sqrt(2.0d) * Math.max(iB, iC))) / 2;
        canvas.drawRect(-sqrt, -sqrt, iB + sqrt, sqrt + iC, paint);
        return this.anw;
    }

    private Animator getShimmerAnimation() {
        if (this.dyk != null) {
            return this.dyk;
        }
        int width = getWidth();
        int height = getHeight();
        int i = AnonymousClass3.dym[this.dyb.dyw.ordinal()];
        switch (this.dyb.dyo) {
            case CW_90:
                this.dyc.q(0, -height, 0, height);
                break;
            case CW_180:
                this.dyc.q(width, 0, -width, 0);
                break;
            case CW_270:
                this.dyc.q(0, height, 0, -height);
                break;
            default:
                this.dyc.q(-width, 0, width, 0);
                break;
        }
        this.dyk = ValueAnimator.ofFloat(0.0f, 1.0f + (this.dyg / this.mDuration));
        this.dyk.setDuration(this.mDuration + this.dyg);
        this.dyk.setRepeatCount(this.bfe);
        this.dyk.setRepeatMode(this.mRepeatMode);
        this.dyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.ShimmerFrameLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                ShimmerFrameLayout.this.setMaskOffsetX((int) ((ShimmerFrameLayout.this.dyc.fromX * (1.0f - max)) + (ShimmerFrameLayout.this.dyc.toX * max)));
                ShimmerFrameLayout.this.setMaskOffsetY((int) ((max * ShimmerFrameLayout.this.dyc.toY) + (ShimmerFrameLayout.this.dyc.fromY * (1.0f - max))));
            }
        });
        return this.dyk;
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
