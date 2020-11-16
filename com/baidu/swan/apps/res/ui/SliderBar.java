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
/* loaded from: classes7.dex */
public class SliderBar extends View {
    private static final String[] dmB = {"小", "中", "大", "特大"};
    private int dmC;
    private String[] dmD;
    private float dmE;
    private float dmF;
    private int dmG;
    private float dmH;
    private int dmI;
    private int dmJ;
    private int dmK;
    private int dmL;
    private int dmM;
    private int dmN;
    private int dmO;
    private boolean dmP;
    private int dmQ;
    private boolean dmR;
    private c dmS;
    private a dmT;
    private b dmU;
    private int dmV;
    private boolean dmW;
    private ValueAnimator mAnimator;
    private int mCurrentIndex;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes7.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.dmC = 4;
        this.dmD = dmB;
        this.dmE = 15.0f;
        this.dmF = 3.0f;
        this.dmG = -7829368;
        this.dmH = 30.0f;
        this.dmI = -1;
        this.dmJ = -1;
        this.dmK = 1711276032;
        this.dmL = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dmM = -7829368;
        this.dmN = 50;
        this.dmO = 500;
        this.dmP = false;
        this.dmQ = -3355444;
        this.dmR = true;
        this.dmV = -1;
        this.mCurrentIndex = 0;
        this.dmW = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmC = 4;
        this.dmD = dmB;
        this.dmE = 15.0f;
        this.dmF = 3.0f;
        this.dmG = -7829368;
        this.dmH = 30.0f;
        this.dmI = -1;
        this.dmJ = -1;
        this.dmK = 1711276032;
        this.dmL = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dmM = -7829368;
        this.dmN = 50;
        this.dmO = 500;
        this.dmP = false;
        this.dmQ = -3355444;
        this.dmR = true;
        this.dmV = -1;
        this.mCurrentIndex = 0;
        this.dmW = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dmC = 4;
        this.dmD = dmB;
        this.dmE = 15.0f;
        this.dmF = 3.0f;
        this.dmG = -7829368;
        this.dmH = 30.0f;
        this.dmI = -1;
        this.dmJ = -1;
        this.dmK = 1711276032;
        this.dmL = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dmM = -7829368;
        this.dmN = 50;
        this.dmO = 500;
        this.dmP = false;
        this.dmQ = -3355444;
        this.dmR = true;
        this.dmV = -1;
        this.mCurrentIndex = 0;
        this.dmW = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.dmE = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.dmF = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.dmG = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.dmH = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.dmI = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.dmJ = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.dmK = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.dmL = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.dmM = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.dmN = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.dmO = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.mCurrentIndex = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.dmR = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.dmP = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.dmQ = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.dmT = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.dmS = new c(getXCoordinate() + (this.dmT.aFJ() * this.mCurrentIndex), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.dmO;
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
        return (int) ((this.dmH * 2.0f) + this.dmN + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.dmT.draw(canvas);
        this.dmS.draw(canvas);
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
        if (!this.dmS.aFL() && this.dmS.t(f, f2)) {
            aFF();
            return true;
        }
        this.dmV = r(f, f2);
        return true;
    }

    private boolean H(float f) {
        if (this.dmS.aFL()) {
            I(f);
            return true;
        }
        return true;
    }

    private boolean q(float f, float f2) {
        if (this.dmS.aFL()) {
            aFG();
            return true;
        } else if (this.dmV == r(f, f2) && this.dmV != -1) {
            s(this.dmS.getX(), getXCoordinate() + (this.dmV * this.dmT.aFJ()));
            this.mCurrentIndex = this.dmV;
            if (this.dmU != null) {
                this.dmU.a(this, this.mCurrentIndex);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int r(float f, float f2) {
        for (int i = 0; i < this.dmC; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.dmT.aFJ() * ((float) i)))) < this.dmS.aFK() && Math.abs(f2 - getYCoordinate()) < this.dmS.aFK() * 2.0f;
    }

    private void aFF() {
        this.dmS.aFM();
        invalidate();
    }

    private void I(float f) {
        if (f >= this.dmT.aFH() && f <= this.dmT.aFI()) {
            this.dmS.setX(f);
            invalidate();
        }
    }

    private void aFG() {
        int b2 = this.dmT.b(this.dmS);
        if (this.mCurrentIndex != b2) {
            this.mCurrentIndex = b2;
            if (this.dmU != null) {
                this.dmU.a(this, this.mCurrentIndex);
            }
        }
        float x = this.dmS.getX();
        float a2 = this.dmT.a(this.dmS);
        if (this.dmR) {
            s(x, a2);
        } else {
            this.dmS.setX(a2);
            invalidate();
        }
        this.dmS.release();
    }

    private void s(float f, float f2) {
        stopAnimation();
        this.mAnimator = ValueAnimator.ofFloat(f, f2);
        this.mAnimator.setDuration(80L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.dmS.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public SliderBar a(b bVar) {
        this.dmU = bVar;
        return this;
    }

    public SliderBar jI(int i) {
        if (i < 0 || i >= this.dmC) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            if (this.dmS != null && this.dmT != null) {
                this.dmS.setX(getXCoordinate() + (this.dmT.aFJ() * this.mCurrentIndex));
                invalidate();
            }
            if (this.dmU != null) {
                this.dmU.a(this, this.mCurrentIndex);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.dmH;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.dmH;
    }

    private float getFontHeight() {
        if (this.dmD == null || this.dmD.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.dmD[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.dmH)) - getPaddingLeft()) - getPaddingRight();
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
    /* loaded from: classes7.dex */
    public class a {
        private final float dmY;
        private final float dmZ;
        private final float dmq;
        private int dna;
        private float dnb;
        private float dnc;
        private Paint dnd = new Paint();
        private Paint dne;
        private Paint mTextPaint;

        a(float f, float f2, float f3) {
            this.dnc = 7.5f;
            this.dmq = f;
            this.dmY = f + f3;
            this.dmZ = f2;
            this.dna = SliderBar.this.dmC - 1;
            this.dnb = f3 / this.dna;
            this.dnc = SliderBar.this.dmE / 2.0f;
            this.dnd.setColor(SliderBar.this.dmG);
            this.dnd.setStrokeWidth(SliderBar.this.dmF);
            this.dnd.setAntiAlias(true);
            this.mTextPaint = new Paint();
            this.mTextPaint.setColor(SliderBar.this.mTextColor);
            this.mTextPaint.setTextSize(SliderBar.this.mTextSize);
            this.mTextPaint.setAntiAlias(true);
            this.dne = new Paint();
            this.dne.setColor(SliderBar.this.dmM);
            this.dne.setTextSize(SliderBar.this.mTextSize);
            this.dne.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            o(canvas);
            if (SliderBar.this.dmW) {
                p(canvas);
            }
        }

        private void o(Canvas canvas) {
            canvas.drawLine(this.dmq, this.dmZ, this.dmY, this.dmZ, this.dnd);
        }

        private void p(Canvas canvas) {
            for (int i = 0; i <= this.dna; i++) {
                float f = this.dmq + (this.dnb * i);
                canvas.drawCircle(f, this.dmZ, this.dnc, this.dnd);
                if (SliderBar.this.dmD != null && SliderBar.this.dmD.length > 0) {
                    String str = SliderBar.this.dmD[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.mCurrentIndex) {
                            Paint.FontMetrics fontMetrics = this.dne.getFontMetrics();
                            canvas.drawText(str, f - (rF(str) / 2.0f), ((this.dmZ - SliderBar.this.dmH) - SliderBar.this.dmN) - (fontMetrics.bottom - fontMetrics.descent), this.dne);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
                            canvas.drawText(str, f - (rF(str) / 2.0f), ((this.dmZ - SliderBar.this.dmH) - SliderBar.this.dmN) - (fontMetrics2.bottom - fontMetrics2.descent), this.mTextPaint);
                        }
                    }
                }
            }
        }

        float aFH() {
            return this.dmq;
        }

        float aFI() {
            return this.dmY;
        }

        float aFJ() {
            return this.dnb;
        }

        float a(c cVar) {
            return this.dmq + (this.dnb * b(cVar));
        }

        int b(c cVar) {
            return J(cVar.getX());
        }

        int J(float f) {
            return (int) (((f - this.dmq) + (this.dnb / 2.0f)) / this.dnb);
        }

        float rF(String str) {
            return this.mTextPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c {
        private final float dnf;
        private boolean dng;
        private Paint dnh = new Paint();
        private Paint dni;
        private Paint dnj;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.dnf = (int) Math.max(50.0f, SliderBar.this.dmH * 2.0f);
            this.dnh.setColor(SliderBar.this.dmI);
            this.dnh.setAntiAlias(true);
            this.dni = new Paint();
            this.dni.setColor(SliderBar.this.dmJ);
            this.dni.setAntiAlias(true);
            this.dnj = new Paint();
            this.dnj.setStyle(Paint.Style.STROKE);
            this.dnj.setColor(SliderBar.this.dmK);
            this.dnj.setAntiAlias(true);
            this.dnj.setStrokeWidth(SliderBar.this.dmL);
            if (SliderBar.this.dmP) {
                SliderBar.this.setLayerType(1, this.dnh);
                SliderBar.this.setLayerType(1, this.dni);
                this.dnh.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dmQ);
                this.dni.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dmQ);
            }
        }

        void draw(Canvas canvas) {
            if (this.dng) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dmH, this.dni);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dmH, this.dnh);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.dmH, this.dnj);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aFK() {
            return this.dnf;
        }

        boolean aFL() {
            return this.dng;
        }

        void aFM() {
            this.dng = true;
        }

        void release() {
            this.dng = false;
        }

        boolean t(float f, float f2) {
            return Math.abs(f - this.mX) <= this.dnf && Math.abs(f2 - this.mY) <= this.dnf;
        }
    }
}
