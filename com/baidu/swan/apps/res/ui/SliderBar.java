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
/* loaded from: classes25.dex */
public class SliderBar extends View {
    private static final String[] dtE = {"小", "中", "大", "特大"};
    private int dtF;
    private String[] dtG;
    private float dtH;
    private float dtI;
    private int dtJ;
    private float dtK;
    private int dtL;
    private int dtM;
    private int dtN;
    private int dtO;
    private int dtP;
    private int dtQ;
    private int dtR;
    private boolean dtS;
    private int dtT;
    private boolean dtU;
    private c dtV;
    private a dtW;
    private b dtX;
    private int dtY;
    private boolean dtZ;
    private ValueAnimator mAnimator;
    private int mCurrentIndex;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes25.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.dtF = 4;
        this.dtG = dtE;
        this.dtH = 15.0f;
        this.dtI = 3.0f;
        this.dtJ = -7829368;
        this.dtK = 30.0f;
        this.dtL = -1;
        this.dtM = -1;
        this.dtN = 1711276032;
        this.dtO = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dtP = -7829368;
        this.dtQ = 50;
        this.dtR = 500;
        this.dtS = false;
        this.dtT = -3355444;
        this.dtU = true;
        this.dtY = -1;
        this.mCurrentIndex = 0;
        this.dtZ = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dtF = 4;
        this.dtG = dtE;
        this.dtH = 15.0f;
        this.dtI = 3.0f;
        this.dtJ = -7829368;
        this.dtK = 30.0f;
        this.dtL = -1;
        this.dtM = -1;
        this.dtN = 1711276032;
        this.dtO = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dtP = -7829368;
        this.dtQ = 50;
        this.dtR = 500;
        this.dtS = false;
        this.dtT = -3355444;
        this.dtU = true;
        this.dtY = -1;
        this.mCurrentIndex = 0;
        this.dtZ = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtF = 4;
        this.dtG = dtE;
        this.dtH = 15.0f;
        this.dtI = 3.0f;
        this.dtJ = -7829368;
        this.dtK = 30.0f;
        this.dtL = -1;
        this.dtM = -1;
        this.dtN = 1711276032;
        this.dtO = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dtP = -7829368;
        this.dtQ = 50;
        this.dtR = 500;
        this.dtS = false;
        this.dtT = -3355444;
        this.dtU = true;
        this.dtY = -1;
        this.mCurrentIndex = 0;
        this.dtZ = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.dtH = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.dtI = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.dtJ = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.dtK = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.dtL = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.dtM = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.dtN = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.dtO = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.dtP = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.dtQ = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.dtR = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.mCurrentIndex = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.dtU = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.dtS = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.dtT = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.dtW = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.dtV = new c(getXCoordinate() + (this.dtW.aIR() * this.mCurrentIndex), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.dtR;
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
        return (int) ((this.dtK * 2.0f) + this.dtQ + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.dtW.draw(canvas);
        this.dtV.draw(canvas);
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
                return H(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean p(float f, float f2) {
        if (!this.dtV.aIT() && this.dtV.t(f, f2)) {
            aIN();
            return true;
        }
        this.dtY = r(f, f2);
        return true;
    }

    private boolean H(float f) {
        if (this.dtV.aIT()) {
            I(f);
            return true;
        }
        return true;
    }

    private boolean q(float f, float f2) {
        if (this.dtV.aIT()) {
            aIO();
            return true;
        } else if (this.dtY == r(f, f2) && this.dtY != -1) {
            s(this.dtV.getX(), getXCoordinate() + (this.dtY * this.dtW.aIR()));
            this.mCurrentIndex = this.dtY;
            if (this.dtX != null) {
                this.dtX.a(this, this.mCurrentIndex);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int r(float f, float f2) {
        for (int i = 0; i < this.dtF; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.dtW.aIR() * ((float) i)))) < this.dtV.aIS() && Math.abs(f2 - getYCoordinate()) < this.dtV.aIS() * 2.0f;
    }

    private void aIN() {
        this.dtV.aIU();
        invalidate();
    }

    private void I(float f) {
        if (f >= this.dtW.aIP() && f <= this.dtW.aIQ()) {
            this.dtV.setX(f);
            invalidate();
        }
    }

    private void aIO() {
        int b2 = this.dtW.b(this.dtV);
        if (this.mCurrentIndex != b2) {
            this.mCurrentIndex = b2;
            if (this.dtX != null) {
                this.dtX.a(this, this.mCurrentIndex);
            }
        }
        float x = this.dtV.getX();
        float a2 = this.dtW.a(this.dtV);
        if (this.dtU) {
            s(x, a2);
        } else {
            this.dtV.setX(a2);
            invalidate();
        }
        this.dtV.release();
    }

    private void s(float f, float f2) {
        stopAnimation();
        this.mAnimator = ValueAnimator.ofFloat(f, f2);
        this.mAnimator.setDuration(80L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.dtV.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public SliderBar a(b bVar) {
        this.dtX = bVar;
        return this;
    }

    public SliderBar kg(int i) {
        if (i < 0 || i >= this.dtF) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            if (this.dtV != null && this.dtW != null) {
                this.dtV.setX(getXCoordinate() + (this.dtW.aIR() * this.mCurrentIndex));
                invalidate();
            }
            if (this.dtX != null) {
                this.dtX.a(this, this.mCurrentIndex);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.dtK;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.dtK;
    }

    private float getFontHeight() {
        if (this.dtG == null || this.dtG.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.dtG[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.dtK)) - getPaddingLeft()) - getPaddingRight();
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
    /* loaded from: classes25.dex */
    public class a {
        private final float dtt;
        private final float dub;
        private final float duc;
        private int dud;
        private float due;
        private float duf;
        private Paint dug = new Paint();
        private Paint duh;
        private Paint mTextPaint;

        a(float f, float f2, float f3) {
            this.duf = 7.5f;
            this.dtt = f;
            this.dub = f + f3;
            this.duc = f2;
            this.dud = SliderBar.this.dtF - 1;
            this.due = f3 / this.dud;
            this.duf = SliderBar.this.dtH / 2.0f;
            this.dug.setColor(SliderBar.this.dtJ);
            this.dug.setStrokeWidth(SliderBar.this.dtI);
            this.dug.setAntiAlias(true);
            this.mTextPaint = new Paint();
            this.mTextPaint.setColor(SliderBar.this.mTextColor);
            this.mTextPaint.setTextSize(SliderBar.this.mTextSize);
            this.mTextPaint.setAntiAlias(true);
            this.duh = new Paint();
            this.duh.setColor(SliderBar.this.dtP);
            this.duh.setTextSize(SliderBar.this.mTextSize);
            this.duh.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            o(canvas);
            if (SliderBar.this.dtZ) {
                p(canvas);
            }
        }

        private void o(Canvas canvas) {
            canvas.drawLine(this.dtt, this.duc, this.dub, this.duc, this.dug);
        }

        private void p(Canvas canvas) {
            for (int i = 0; i <= this.dud; i++) {
                float f = this.dtt + (this.due * i);
                canvas.drawCircle(f, this.duc, this.duf, this.dug);
                if (SliderBar.this.dtG != null && SliderBar.this.dtG.length > 0) {
                    String str = SliderBar.this.dtG[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.mCurrentIndex) {
                            Paint.FontMetrics fontMetrics = this.duh.getFontMetrics();
                            canvas.drawText(str, f - (sm(str) / 2.0f), ((this.duc - SliderBar.this.dtK) - SliderBar.this.dtQ) - (fontMetrics.bottom - fontMetrics.descent), this.duh);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
                            canvas.drawText(str, f - (sm(str) / 2.0f), ((this.duc - SliderBar.this.dtK) - SliderBar.this.dtQ) - (fontMetrics2.bottom - fontMetrics2.descent), this.mTextPaint);
                        }
                    }
                }
            }
        }

        float aIP() {
            return this.dtt;
        }

        float aIQ() {
            return this.dub;
        }

        float aIR() {
            return this.due;
        }

        float a(c cVar) {
            return this.dtt + (this.due * b(cVar));
        }

        int b(c cVar) {
            return J(cVar.getX());
        }

        int J(float f) {
            return (int) (((f - this.dtt) + (this.due / 2.0f)) / this.due);
        }

        float sm(String str) {
            return this.mTextPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class c {
        private final float dui;
        private boolean duj;
        private Paint duk = new Paint();
        private Paint dul;
        private Paint dum;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.dui = (int) Math.max(50.0f, SliderBar.this.dtK * 2.0f);
            this.duk.setColor(SliderBar.this.dtL);
            this.duk.setAntiAlias(true);
            this.dul = new Paint();
            this.dul.setColor(SliderBar.this.dtM);
            this.dul.setAntiAlias(true);
            this.dum = new Paint();
            this.dum.setStyle(Paint.Style.STROKE);
            this.dum.setColor(SliderBar.this.dtN);
            this.dum.setAntiAlias(true);
            this.dum.setStrokeWidth(SliderBar.this.dtO);
            if (SliderBar.this.dtS) {
                SliderBar.this.setLayerType(1, this.duk);
                SliderBar.this.setLayerType(1, this.dul);
                this.duk.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dtT);
                this.dul.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dtT);
            }
        }

        void draw(Canvas canvas) {
            if (this.duj) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dtK, this.dul);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dtK, this.duk);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.dtK, this.dum);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aIS() {
            return this.dui;
        }

        boolean aIT() {
            return this.duj;
        }

        void aIU() {
            this.duj = true;
        }

        void release() {
            this.duj = false;
        }

        boolean t(float f, float f2) {
            return Math.abs(f - this.mX) <= this.dui && Math.abs(f2 - this.mY) <= this.dui;
        }
    }
}
