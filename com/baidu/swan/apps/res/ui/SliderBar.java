package com.baidu.swan.apps.res.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public class SliderBar extends View {
    private static final String[] dwW = {"小", "中", "大", "特大"};
    private int bLv;
    private ValueAnimator dwJ;
    private int dwX;
    private String[] dwY;
    private float dwZ;
    private float dxa;
    private int dxb;
    private float dxc;
    private int dxd;
    private int dxe;
    private int dxf;
    private int dxg;
    private int dxh;
    private int dxi;
    private boolean dxj;
    private int dxk;
    private boolean dxl;
    private c dxm;
    private a dxn;
    private b dxo;
    private int dxp;
    private boolean dxq;
    private int mDefaultWidth;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes9.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.dwX = 4;
        this.dwY = dwW;
        this.dwZ = 15.0f;
        this.dxa = 3.0f;
        this.dxb = -7829368;
        this.dxc = 30.0f;
        this.dxd = -1;
        this.dxe = -1;
        this.dxf = 1711276032;
        this.dxg = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dxh = -7829368;
        this.dxi = 50;
        this.mDefaultWidth = 500;
        this.dxj = false;
        this.dxk = -3355444;
        this.dxl = true;
        this.dxp = -1;
        this.bLv = 0;
        this.dxq = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dwX = 4;
        this.dwY = dwW;
        this.dwZ = 15.0f;
        this.dxa = 3.0f;
        this.dxb = -7829368;
        this.dxc = 30.0f;
        this.dxd = -1;
        this.dxe = -1;
        this.dxf = 1711276032;
        this.dxg = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dxh = -7829368;
        this.dxi = 50;
        this.mDefaultWidth = 500;
        this.dxj = false;
        this.dxk = -3355444;
        this.dxl = true;
        this.dxp = -1;
        this.bLv = 0;
        this.dxq = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dwX = 4;
        this.dwY = dwW;
        this.dwZ = 15.0f;
        this.dxa = 3.0f;
        this.dxb = -7829368;
        this.dxc = 30.0f;
        this.dxd = -1;
        this.dxe = -1;
        this.dxf = 1711276032;
        this.dxg = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dxh = -7829368;
        this.dxi = 50;
        this.mDefaultWidth = 500;
        this.dxj = false;
        this.dxk = -3355444;
        this.dxl = true;
        this.dxp = -1;
        this.bLv = 0;
        this.dxq = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.dwZ = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.dxa = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.dxb = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.dxc = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.dxd = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.dxe = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.dxf = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.dxg = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.dxh = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.dxi = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.mDefaultWidth = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.bLv = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.dxl = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.dxj = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.dxk = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.dxn = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.dxm = new c(getXCoordinate() + (this.dxn.aHb() * this.bLv), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.mDefaultWidth;
            size = mode == Integer.MIN_VALUE ? Math.min(size, i3) : i3;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            int minHeight = getMinHeight();
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(size2, minHeight) : minHeight;
        }
        setMeasuredDimension(size, size2);
    }

    private int getMinHeight() {
        return (int) ((this.dxc * 2.0f) + this.dxi + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.dxn.draw(canvas);
        this.dxm.draw(canvas);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            stopAnimation();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || isAnimationRunning()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                return q(motionEvent.getX(), motionEvent.getY());
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                return r(motionEvent.getX(), motionEvent.getY());
            case 2:
                getParent().requestDisallowInterceptTouchEvent(true);
                return I(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean q(float f, float f2) {
        if (!this.dxm.aHd() && this.dxm.u(f, f2)) {
            aGX();
            return true;
        }
        this.dxp = s(f, f2);
        return true;
    }

    private boolean I(float f) {
        if (this.dxm.aHd()) {
            J(f);
            return true;
        }
        return true;
    }

    private boolean r(float f, float f2) {
        if (this.dxm.aHd()) {
            aGY();
            return true;
        } else if (this.dxp == s(f, f2) && this.dxp != -1) {
            t(this.dxm.getX(), getXCoordinate() + (this.dxp * this.dxn.aHb()));
            this.bLv = this.dxp;
            if (this.dxo != null) {
                this.dxo.a(this, this.bLv);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int s(float f, float f2) {
        for (int i = 0; i < this.dwX; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.dxn.aHb() * ((float) i)))) < this.dxm.aHc() && Math.abs(f2 - getYCoordinate()) < this.dxm.aHc() * 2.0f;
    }

    private void aGX() {
        this.dxm.aHe();
        invalidate();
    }

    private void J(float f) {
        if (f >= this.dxn.aGZ() && f <= this.dxn.aHa()) {
            this.dxm.setX(f);
            invalidate();
        }
    }

    private void aGY() {
        int b2 = this.dxn.b(this.dxm);
        if (this.bLv != b2) {
            this.bLv = b2;
            if (this.dxo != null) {
                this.dxo.a(this, this.bLv);
            }
        }
        float x = this.dxm.getX();
        float a2 = this.dxn.a(this.dxm);
        if (this.dxl) {
            t(x, a2);
        } else {
            this.dxm.setX(a2);
            invalidate();
        }
        this.dxm.release();
    }

    private void t(float f, float f2) {
        stopAnimation();
        this.dwJ = ValueAnimator.ofFloat(f, f2);
        this.dwJ.setDuration(80L);
        this.dwJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.dxm.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.dwJ.start();
    }

    public SliderBar a(b bVar) {
        this.dxo = bVar;
        return this;
    }

    public SliderBar iC(int i) {
        if (i < 0 || i >= this.dwX) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.bLv != i) {
            this.bLv = i;
            if (this.dxm != null && this.dxn != null) {
                this.dxm.setX(getXCoordinate() + (this.dxn.aHb() * this.bLv));
                invalidate();
            }
            if (this.dxo != null) {
                this.dxo.a(this, this.bLv);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.bLv;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.dxc;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.dxc;
    }

    private float getFontHeight() {
        if (this.dwY == null || this.dwY.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.dwY[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.dxc)) - getPaddingLeft()) - getPaddingRight();
    }

    private boolean isAnimationRunning() {
        return this.dwJ != null && this.dwJ.isRunning();
    }

    private void stopAnimation() {
        if (this.dwJ != null) {
            this.dwJ.cancel();
            this.dwJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        private Paint bhF;
        private final float dwp;
        private final float dxs;
        private final float dxt;
        private int dxu;
        private float dxv;
        private float dxw;
        private Paint dxx = new Paint();
        private Paint dxy;

        a(float f, float f2, float f3) {
            this.dxw = 7.5f;
            this.dwp = f;
            this.dxs = f + f3;
            this.dxt = f2;
            this.dxu = SliderBar.this.dwX - 1;
            this.dxv = f3 / this.dxu;
            this.dxw = SliderBar.this.dwZ / 2.0f;
            this.dxx.setColor(SliderBar.this.dxb);
            this.dxx.setStrokeWidth(SliderBar.this.dxa);
            this.dxx.setAntiAlias(true);
            this.bhF = new Paint();
            this.bhF.setColor(SliderBar.this.mTextColor);
            this.bhF.setTextSize(SliderBar.this.mTextSize);
            this.bhF.setAntiAlias(true);
            this.dxy = new Paint();
            this.dxy.setColor(SliderBar.this.dxh);
            this.dxy.setTextSize(SliderBar.this.mTextSize);
            this.dxy.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            v(canvas);
            if (SliderBar.this.dxq) {
                w(canvas);
            }
        }

        private void v(Canvas canvas) {
            canvas.drawLine(this.dwp, this.dxt, this.dxs, this.dxt, this.dxx);
        }

        private void w(Canvas canvas) {
            for (int i = 0; i <= this.dxu; i++) {
                float f = this.dwp + (this.dxv * i);
                canvas.drawCircle(f, this.dxt, this.dxw, this.dxx);
                if (SliderBar.this.dwY != null && SliderBar.this.dwY.length > 0) {
                    String str = SliderBar.this.dwY[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.bLv) {
                            Paint.FontMetrics fontMetrics = this.dxy.getFontMetrics();
                            canvas.drawText(str, f - (rn(str) / 2.0f), ((this.dxt - SliderBar.this.dxc) - SliderBar.this.dxi) - (fontMetrics.bottom - fontMetrics.descent), this.dxy);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.bhF.getFontMetrics();
                            canvas.drawText(str, f - (rn(str) / 2.0f), ((this.dxt - SliderBar.this.dxc) - SliderBar.this.dxi) - (fontMetrics2.bottom - fontMetrics2.descent), this.bhF);
                        }
                    }
                }
            }
        }

        float aGZ() {
            return this.dwp;
        }

        float aHa() {
            return this.dxs;
        }

        float aHb() {
            return this.dxv;
        }

        float a(c cVar) {
            return this.dwp + (this.dxv * b(cVar));
        }

        int b(c cVar) {
            return K(cVar.getX());
        }

        int K(float f) {
            return (int) (((f - this.dwp) + (this.dxv / 2.0f)) / this.dxv);
        }

        float rn(String str) {
            return this.bhF.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c {
        private boolean dxA;
        private Paint dxB = new Paint();
        private Paint dxC;
        private Paint dxD;
        private final float dxz;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.dxz = (int) Math.max(50.0f, SliderBar.this.dxc * 2.0f);
            this.dxB.setColor(SliderBar.this.dxd);
            this.dxB.setAntiAlias(true);
            this.dxC = new Paint();
            this.dxC.setColor(SliderBar.this.dxe);
            this.dxC.setAntiAlias(true);
            this.dxD = new Paint();
            this.dxD.setStyle(Paint.Style.STROKE);
            this.dxD.setColor(SliderBar.this.dxf);
            this.dxD.setAntiAlias(true);
            this.dxD.setStrokeWidth(SliderBar.this.dxg);
            if (SliderBar.this.dxj) {
                SliderBar.this.setLayerType(1, this.dxB);
                SliderBar.this.setLayerType(1, this.dxC);
                this.dxB.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dxk);
                this.dxC.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dxk);
            }
        }

        void draw(Canvas canvas) {
            if (this.dxA) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dxc, this.dxC);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dxc, this.dxB);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.dxc, this.dxD);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aHc() {
            return this.dxz;
        }

        boolean aHd() {
            return this.dxA;
        }

        void aHe() {
            this.dxA = true;
        }

        void release() {
            this.dxA = false;
        }

        boolean u(float f, float f2) {
            return Math.abs(f - this.mX) <= this.dxz && Math.abs(f2 - this.mY) <= this.dxz;
        }
    }
}
