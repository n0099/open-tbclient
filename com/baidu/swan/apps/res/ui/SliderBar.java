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
/* loaded from: classes10.dex */
public class SliderBar extends View {
    private static final String[] dok = {"小", "中", "大", "特大"};
    private int doA;
    private boolean doB;
    private c doC;
    private a doD;
    private b doE;
    private int doF;
    private boolean doG;
    private int dol;
    private String[] dom;
    private float don;
    private float doo;
    private int dop;
    private float doq;
    private int dor;
    private int dos;
    private int dou;
    private int dov;
    private int dow;
    private int dox;
    private int doy;
    private boolean doz;
    private ValueAnimator mAnimator;
    private int mCurrentIndex;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes10.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.dol = 4;
        this.dom = dok;
        this.don = 15.0f;
        this.doo = 3.0f;
        this.dop = -7829368;
        this.doq = 30.0f;
        this.dor = -1;
        this.dos = -1;
        this.dou = 1711276032;
        this.dov = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dow = -7829368;
        this.dox = 50;
        this.doy = 500;
        this.doz = false;
        this.doA = -3355444;
        this.doB = true;
        this.doF = -1;
        this.mCurrentIndex = 0;
        this.doG = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dol = 4;
        this.dom = dok;
        this.don = 15.0f;
        this.doo = 3.0f;
        this.dop = -7829368;
        this.doq = 30.0f;
        this.dor = -1;
        this.dos = -1;
        this.dou = 1711276032;
        this.dov = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dow = -7829368;
        this.dox = 50;
        this.doy = 500;
        this.doz = false;
        this.doA = -3355444;
        this.doB = true;
        this.doF = -1;
        this.mCurrentIndex = 0;
        this.doG = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dol = 4;
        this.dom = dok;
        this.don = 15.0f;
        this.doo = 3.0f;
        this.dop = -7829368;
        this.doq = 30.0f;
        this.dor = -1;
        this.dos = -1;
        this.dou = 1711276032;
        this.dov = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dow = -7829368;
        this.dox = 50;
        this.doy = 500;
        this.doz = false;
        this.doA = -3355444;
        this.doB = true;
        this.doF = -1;
        this.mCurrentIndex = 0;
        this.doG = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.don = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.doo = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.dop = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.doq = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.dor = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.dos = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.dou = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.dov = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.dow = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.dox = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.doy = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.mCurrentIndex = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.doB = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.doz = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.doA = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.doD = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.doC = new c(getXCoordinate() + (this.doD.aGr() * this.mCurrentIndex), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.doy;
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
        return (int) ((this.doq * 2.0f) + this.dox + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.doD.draw(canvas);
        this.doC.draw(canvas);
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
                return I(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean p(float f, float f2) {
        if (!this.doC.aGt() && this.doC.t(f, f2)) {
            aGn();
            return true;
        }
        this.doF = r(f, f2);
        return true;
    }

    private boolean I(float f) {
        if (this.doC.aGt()) {
            J(f);
            return true;
        }
        return true;
    }

    private boolean q(float f, float f2) {
        if (this.doC.aGt()) {
            aGo();
            return true;
        } else if (this.doF == r(f, f2) && this.doF != -1) {
            s(this.doC.getX(), getXCoordinate() + (this.doF * this.doD.aGr()));
            this.mCurrentIndex = this.doF;
            if (this.doE != null) {
                this.doE.a(this, this.mCurrentIndex);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int r(float f, float f2) {
        for (int i = 0; i < this.dol; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.doD.aGr() * ((float) i)))) < this.doC.aGs() && Math.abs(f2 - getYCoordinate()) < this.doC.aGs() * 2.0f;
    }

    private void aGn() {
        this.doC.aGu();
        invalidate();
    }

    private void J(float f) {
        if (f >= this.doD.aGp() && f <= this.doD.aGq()) {
            this.doC.setX(f);
            invalidate();
        }
    }

    private void aGo() {
        int b2 = this.doD.b(this.doC);
        if (this.mCurrentIndex != b2) {
            this.mCurrentIndex = b2;
            if (this.doE != null) {
                this.doE.a(this, this.mCurrentIndex);
            }
        }
        float x = this.doC.getX();
        float a2 = this.doD.a(this.doC);
        if (this.doB) {
            s(x, a2);
        } else {
            this.doC.setX(a2);
            invalidate();
        }
        this.doC.release();
    }

    private void s(float f, float f2) {
        stopAnimation();
        this.mAnimator = ValueAnimator.ofFloat(f, f2);
        this.mAnimator.setDuration(80L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.doC.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public SliderBar a(b bVar) {
        this.doE = bVar;
        return this;
    }

    public SliderBar jM(int i) {
        if (i < 0 || i >= this.dol) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            if (this.doC != null && this.doD != null) {
                this.doC.setX(getXCoordinate() + (this.doD.aGr() * this.mCurrentIndex));
                invalidate();
            }
            if (this.doE != null) {
                this.doE.a(this, this.mCurrentIndex);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.doq;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.doq;
    }

    private float getFontHeight() {
        if (this.dom == null || this.dom.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.dom[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.doq)) - getPaddingLeft()) - getPaddingRight();
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
    /* loaded from: classes10.dex */
    public class a {
        private final float dnY;
        private final float doI;
        private final float doJ;
        private int doK;
        private float doL;
        private float doM;
        private Paint doN = new Paint();
        private Paint doO;
        private Paint mTextPaint;

        a(float f, float f2, float f3) {
            this.doM = 7.5f;
            this.dnY = f;
            this.doI = f + f3;
            this.doJ = f2;
            this.doK = SliderBar.this.dol - 1;
            this.doL = f3 / this.doK;
            this.doM = SliderBar.this.don / 2.0f;
            this.doN.setColor(SliderBar.this.dop);
            this.doN.setStrokeWidth(SliderBar.this.doo);
            this.doN.setAntiAlias(true);
            this.mTextPaint = new Paint();
            this.mTextPaint.setColor(SliderBar.this.mTextColor);
            this.mTextPaint.setTextSize(SliderBar.this.mTextSize);
            this.mTextPaint.setAntiAlias(true);
            this.doO = new Paint();
            this.doO.setColor(SliderBar.this.dow);
            this.doO.setTextSize(SliderBar.this.mTextSize);
            this.doO.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            o(canvas);
            if (SliderBar.this.doG) {
                p(canvas);
            }
        }

        private void o(Canvas canvas) {
            canvas.drawLine(this.dnY, this.doJ, this.doI, this.doJ, this.doN);
        }

        private void p(Canvas canvas) {
            for (int i = 0; i <= this.doK; i++) {
                float f = this.dnY + (this.doL * i);
                canvas.drawCircle(f, this.doJ, this.doM, this.doN);
                if (SliderBar.this.dom != null && SliderBar.this.dom.length > 0) {
                    String str = SliderBar.this.dom[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.mCurrentIndex) {
                            Paint.FontMetrics fontMetrics = this.doO.getFontMetrics();
                            canvas.drawText(str, f - (rL(str) / 2.0f), ((this.doJ - SliderBar.this.doq) - SliderBar.this.dox) - (fontMetrics.bottom - fontMetrics.descent), this.doO);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
                            canvas.drawText(str, f - (rL(str) / 2.0f), ((this.doJ - SliderBar.this.doq) - SliderBar.this.dox) - (fontMetrics2.bottom - fontMetrics2.descent), this.mTextPaint);
                        }
                    }
                }
            }
        }

        float aGp() {
            return this.dnY;
        }

        float aGq() {
            return this.doI;
        }

        float aGr() {
            return this.doL;
        }

        float a(c cVar) {
            return this.dnY + (this.doL * b(cVar));
        }

        int b(c cVar) {
            return K(cVar.getX());
        }

        int K(float f) {
            return (int) (((f - this.dnY) + (this.doL / 2.0f)) / this.doL);
        }

        float rL(String str) {
            return this.mTextPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c {
        private final float doP;
        private boolean doQ;
        private Paint doR = new Paint();
        private Paint doS;
        private Paint doT;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.doP = (int) Math.max(50.0f, SliderBar.this.doq * 2.0f);
            this.doR.setColor(SliderBar.this.dor);
            this.doR.setAntiAlias(true);
            this.doS = new Paint();
            this.doS.setColor(SliderBar.this.dos);
            this.doS.setAntiAlias(true);
            this.doT = new Paint();
            this.doT.setStyle(Paint.Style.STROKE);
            this.doT.setColor(SliderBar.this.dou);
            this.doT.setAntiAlias(true);
            this.doT.setStrokeWidth(SliderBar.this.dov);
            if (SliderBar.this.doz) {
                SliderBar.this.setLayerType(1, this.doR);
                SliderBar.this.setLayerType(1, this.doS);
                this.doR.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.doA);
                this.doS.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.doA);
            }
        }

        void draw(Canvas canvas) {
            if (this.doQ) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.doq, this.doS);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.doq, this.doR);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.doq, this.doT);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aGs() {
            return this.doP;
        }

        boolean aGt() {
            return this.doQ;
        }

        void aGu() {
            this.doQ = true;
        }

        void release() {
            this.doQ = false;
        }

        boolean t(float f, float f2) {
            return Math.abs(f - this.mX) <= this.doP && Math.abs(f2 - this.mY) <= this.doP;
        }
    }
}
