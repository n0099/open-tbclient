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
/* loaded from: classes3.dex */
public class SliderBar extends View {
    private static final String[] cNJ = {"小", "中", "大", "特大"};
    private int cNK;
    private String[] cNL;
    private float cNM;
    private float cNN;
    private int cNO;
    private float cNP;
    private int cNQ;
    private int cNR;
    private int cNS;
    private int cNT;
    private int cNU;
    private int cNV;
    private int cNW;
    private boolean cNX;
    private int cNY;
    private boolean cNZ;
    private c cOa;
    private a cOb;
    private b cOc;
    private int cOd;
    private boolean cOe;
    private ValueAnimator mAnimator;
    private int mCurrentIndex;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes3.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.cNK = 4;
        this.cNL = cNJ;
        this.cNM = 15.0f;
        this.cNN = 3.0f;
        this.cNO = -7829368;
        this.cNP = 30.0f;
        this.cNQ = -1;
        this.cNR = -1;
        this.cNS = 1711276032;
        this.cNT = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cNU = -7829368;
        this.cNV = 50;
        this.cNW = 500;
        this.cNX = false;
        this.cNY = -3355444;
        this.cNZ = true;
        this.cOd = -1;
        this.mCurrentIndex = 0;
        this.cOe = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cNK = 4;
        this.cNL = cNJ;
        this.cNM = 15.0f;
        this.cNN = 3.0f;
        this.cNO = -7829368;
        this.cNP = 30.0f;
        this.cNQ = -1;
        this.cNR = -1;
        this.cNS = 1711276032;
        this.cNT = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cNU = -7829368;
        this.cNV = 50;
        this.cNW = 500;
        this.cNX = false;
        this.cNY = -3355444;
        this.cNZ = true;
        this.cOd = -1;
        this.mCurrentIndex = 0;
        this.cOe = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cNK = 4;
        this.cNL = cNJ;
        this.cNM = 15.0f;
        this.cNN = 3.0f;
        this.cNO = -7829368;
        this.cNP = 30.0f;
        this.cNQ = -1;
        this.cNR = -1;
        this.cNS = 1711276032;
        this.cNT = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cNU = -7829368;
        this.cNV = 50;
        this.cNW = 500;
        this.cNX = false;
        this.cNY = -3355444;
        this.cNZ = true;
        this.cOd = -1;
        this.mCurrentIndex = 0;
        this.cOe = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.cNM = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.cNN = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.cNO = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.cNP = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.cNQ = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.cNR = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.cNS = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.cNT = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.cNU = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.cNV = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.cNW = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.mCurrentIndex = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.cNZ = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.cNX = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.cNY = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.cOb = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.cOa = new c(getXCoordinate() + (this.cOb.azo() * this.mCurrentIndex), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.cNW;
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
        return (int) ((this.cNP * 2.0f) + this.cNV + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cOb.draw(canvas);
        this.cOa.draw(canvas);
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
                return p(motionEvent.getX(), motionEvent.getY());
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                return q(motionEvent.getX(), motionEvent.getY());
            case 2:
                getParent().requestDisallowInterceptTouchEvent(true);
                return C(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean p(float f, float f2) {
        if (!this.cOa.azq() && this.cOa.t(f, f2)) {
            azk();
            return true;
        }
        this.cOd = r(f, f2);
        return true;
    }

    private boolean C(float f) {
        if (this.cOa.azq()) {
            D(f);
            return true;
        }
        return true;
    }

    private boolean q(float f, float f2) {
        if (this.cOa.azq()) {
            azl();
            return true;
        } else if (this.cOd == r(f, f2) && this.cOd != -1) {
            s(this.cOa.getX(), getXCoordinate() + (this.cOd * this.cOb.azo()));
            this.mCurrentIndex = this.cOd;
            if (this.cOc != null) {
                this.cOc.a(this, this.mCurrentIndex);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int r(float f, float f2) {
        for (int i = 0; i < this.cNK; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.cOb.azo() * ((float) i)))) < this.cOa.azp() && Math.abs(f2 - getYCoordinate()) < this.cOa.azp() * 2.0f;
    }

    private void azk() {
        this.cOa.azr();
        invalidate();
    }

    private void D(float f) {
        if (f >= this.cOb.azm() && f <= this.cOb.azn()) {
            this.cOa.setX(f);
            invalidate();
        }
    }

    private void azl() {
        int b2 = this.cOb.b(this.cOa);
        if (this.mCurrentIndex != b2) {
            this.mCurrentIndex = b2;
            if (this.cOc != null) {
                this.cOc.a(this, this.mCurrentIndex);
            }
        }
        float x = this.cOa.getX();
        float a2 = this.cOb.a(this.cOa);
        if (this.cNZ) {
            s(x, a2);
        } else {
            this.cOa.setX(a2);
            invalidate();
        }
        this.cOa.release();
    }

    private void s(float f, float f2) {
        stopAnimation();
        this.mAnimator = ValueAnimator.ofFloat(f, f2);
        this.mAnimator.setDuration(80L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.cOa.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public SliderBar a(b bVar) {
        this.cOc = bVar;
        return this;
    }

    public SliderBar iU(int i) {
        if (i < 0 || i >= this.cNK) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            if (this.cOa != null && this.cOb != null) {
                this.cOa.setX(getXCoordinate() + (this.cOb.azo() * this.mCurrentIndex));
                invalidate();
            }
            if (this.cOc != null) {
                this.cOc.a(this, this.mCurrentIndex);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.cNP;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.cNP;
    }

    private float getFontHeight() {
        if (this.cNL == null || this.cNL.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.cNL[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.cNP)) - getPaddingLeft()) - getPaddingRight();
    }

    private boolean isAnimationRunning() {
        return this.mAnimator != null && this.mAnimator.isRunning();
    }

    private void stopAnimation() {
        if (this.mAnimator != null) {
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private final float cNy;
        private final float cOg;
        private final float cOh;
        private int cOi;
        private float cOj;
        private float cOk;
        private Paint cOl = new Paint();
        private Paint cOm;
        private Paint mTextPaint;

        a(float f, float f2, float f3) {
            this.cOk = 7.5f;
            this.cNy = f;
            this.cOg = f + f3;
            this.cOh = f2;
            this.cOi = SliderBar.this.cNK - 1;
            this.cOj = f3 / this.cOi;
            this.cOk = SliderBar.this.cNM / 2.0f;
            this.cOl.setColor(SliderBar.this.cNO);
            this.cOl.setStrokeWidth(SliderBar.this.cNN);
            this.cOl.setAntiAlias(true);
            this.mTextPaint = new Paint();
            this.mTextPaint.setColor(SliderBar.this.mTextColor);
            this.mTextPaint.setTextSize(SliderBar.this.mTextSize);
            this.mTextPaint.setAntiAlias(true);
            this.cOm = new Paint();
            this.cOm.setColor(SliderBar.this.cNU);
            this.cOm.setTextSize(SliderBar.this.mTextSize);
            this.cOm.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            o(canvas);
            if (SliderBar.this.cOe) {
                p(canvas);
            }
        }

        private void o(Canvas canvas) {
            canvas.drawLine(this.cNy, this.cOh, this.cOg, this.cOh, this.cOl);
        }

        private void p(Canvas canvas) {
            for (int i = 0; i <= this.cOi; i++) {
                float f = this.cNy + (this.cOj * i);
                canvas.drawCircle(f, this.cOh, this.cOk, this.cOl);
                if (SliderBar.this.cNL != null && SliderBar.this.cNL.length > 0) {
                    String str = SliderBar.this.cNL[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.mCurrentIndex) {
                            Paint.FontMetrics fontMetrics = this.cOm.getFontMetrics();
                            canvas.drawText(str, f - (qs(str) / 2.0f), ((this.cOh - SliderBar.this.cNP) - SliderBar.this.cNV) - (fontMetrics.bottom - fontMetrics.descent), this.cOm);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
                            canvas.drawText(str, f - (qs(str) / 2.0f), ((this.cOh - SliderBar.this.cNP) - SliderBar.this.cNV) - (fontMetrics2.bottom - fontMetrics2.descent), this.mTextPaint);
                        }
                    }
                }
            }
        }

        float azm() {
            return this.cNy;
        }

        float azn() {
            return this.cOg;
        }

        float azo() {
            return this.cOj;
        }

        float a(c cVar) {
            return this.cNy + (this.cOj * b(cVar));
        }

        int b(c cVar) {
            return E(cVar.getX());
        }

        int E(float f) {
            return (int) (((f - this.cNy) + (this.cOj / 2.0f)) / this.cOj);
        }

        float qs(String str) {
            return this.mTextPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        private final float cOn;
        private boolean cOo;
        private Paint cOp = new Paint();
        private Paint cOq;
        private Paint cOr;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.cOn = (int) Math.max(50.0f, SliderBar.this.cNP * 2.0f);
            this.cOp.setColor(SliderBar.this.cNQ);
            this.cOp.setAntiAlias(true);
            this.cOq = new Paint();
            this.cOq.setColor(SliderBar.this.cNR);
            this.cOq.setAntiAlias(true);
            this.cOr = new Paint();
            this.cOr.setStyle(Paint.Style.STROKE);
            this.cOr.setColor(SliderBar.this.cNS);
            this.cOr.setAntiAlias(true);
            this.cOr.setStrokeWidth(SliderBar.this.cNT);
            if (SliderBar.this.cNX) {
                SliderBar.this.setLayerType(1, this.cOp);
                SliderBar.this.setLayerType(1, this.cOq);
                this.cOp.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.cNY);
                this.cOq.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.cNY);
            }
        }

        void draw(Canvas canvas) {
            if (this.cOo) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.cNP, this.cOq);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.cNP, this.cOp);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.cNP, this.cOr);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float azp() {
            return this.cOn;
        }

        boolean azq() {
            return this.cOo;
        }

        void azr() {
            this.cOo = true;
        }

        void release() {
            this.cOo = false;
        }

        boolean t(float f, float f2) {
            return Math.abs(f - this.mX) <= this.cOn && Math.abs(f2 - this.mY) <= this.cOn;
        }
    }
}
