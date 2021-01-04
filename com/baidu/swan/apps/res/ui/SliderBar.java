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
    private static final String[] dzA = {"小", "中", "大", "特大"};
    private int bMx;
    private int dzB;
    private String[] dzC;
    private float dzD;
    private float dzE;
    private int dzF;
    private float dzG;
    private int dzH;
    private int dzI;
    private int dzJ;
    private int dzK;
    private int dzL;
    private int dzM;
    private int dzN;
    private boolean dzO;
    private int dzP;
    private boolean dzQ;
    private c dzR;
    private a dzS;
    private b dzT;
    private int dzU;
    private boolean dzV;
    private ValueAnimator dzn;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes9.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.dzB = 4;
        this.dzC = dzA;
        this.dzD = 15.0f;
        this.dzE = 3.0f;
        this.dzF = -7829368;
        this.dzG = 30.0f;
        this.dzH = -1;
        this.dzI = -1;
        this.dzJ = 1711276032;
        this.dzK = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dzL = -7829368;
        this.dzM = 50;
        this.dzN = 500;
        this.dzO = false;
        this.dzP = -3355444;
        this.dzQ = true;
        this.dzU = -1;
        this.bMx = 0;
        this.dzV = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzB = 4;
        this.dzC = dzA;
        this.dzD = 15.0f;
        this.dzE = 3.0f;
        this.dzF = -7829368;
        this.dzG = 30.0f;
        this.dzH = -1;
        this.dzI = -1;
        this.dzJ = 1711276032;
        this.dzK = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dzL = -7829368;
        this.dzM = 50;
        this.dzN = 500;
        this.dzO = false;
        this.dzP = -3355444;
        this.dzQ = true;
        this.dzU = -1;
        this.bMx = 0;
        this.dzV = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dzB = 4;
        this.dzC = dzA;
        this.dzD = 15.0f;
        this.dzE = 3.0f;
        this.dzF = -7829368;
        this.dzG = 30.0f;
        this.dzH = -1;
        this.dzI = -1;
        this.dzJ = 1711276032;
        this.dzK = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dzL = -7829368;
        this.dzM = 50;
        this.dzN = 500;
        this.dzO = false;
        this.dzP = -3355444;
        this.dzQ = true;
        this.dzU = -1;
        this.bMx = 0;
        this.dzV = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.dzD = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.dzE = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.dzF = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.dzG = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.dzH = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.dzI = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.dzJ = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.dzK = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.dzL = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.dzM = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.dzN = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.bMx = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.dzQ = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.dzO = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.dzP = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.dzS = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.dzR = new c(getXCoordinate() + (this.dzS.aKB() * this.bMx), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.dzN;
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
        return (int) ((this.dzG * 2.0f) + this.dzM + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.dzS.draw(canvas);
        this.dzR.draw(canvas);
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
        if (!this.dzR.aKD() && this.dzR.t(f, f2)) {
            aKx();
            return true;
        }
        this.dzU = r(f, f2);
        return true;
    }

    private boolean H(float f) {
        if (this.dzR.aKD()) {
            I(f);
            return true;
        }
        return true;
    }

    private boolean q(float f, float f2) {
        if (this.dzR.aKD()) {
            aKy();
            return true;
        } else if (this.dzU == r(f, f2) && this.dzU != -1) {
            s(this.dzR.getX(), getXCoordinate() + (this.dzU * this.dzS.aKB()));
            this.bMx = this.dzU;
            if (this.dzT != null) {
                this.dzT.a(this, this.bMx);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int r(float f, float f2) {
        for (int i = 0; i < this.dzB; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.dzS.aKB() * ((float) i)))) < this.dzR.aKC() && Math.abs(f2 - getYCoordinate()) < this.dzR.aKC() * 2.0f;
    }

    private void aKx() {
        this.dzR.aKE();
        invalidate();
    }

    private void I(float f) {
        if (f >= this.dzS.aKz() && f <= this.dzS.aKA()) {
            this.dzR.setX(f);
            invalidate();
        }
    }

    private void aKy() {
        int b2 = this.dzS.b(this.dzR);
        if (this.bMx != b2) {
            this.bMx = b2;
            if (this.dzT != null) {
                this.dzT.a(this, this.bMx);
            }
        }
        float x = this.dzR.getX();
        float a2 = this.dzS.a(this.dzR);
        if (this.dzQ) {
            s(x, a2);
        } else {
            this.dzR.setX(a2);
            invalidate();
        }
        this.dzR.release();
    }

    private void s(float f, float f2) {
        stopAnimation();
        this.dzn = ValueAnimator.ofFloat(f, f2);
        this.dzn.setDuration(80L);
        this.dzn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.dzR.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.dzn.start();
    }

    public SliderBar a(b bVar) {
        this.dzT = bVar;
        return this;
    }

    public SliderBar kf(int i) {
        if (i < 0 || i >= this.dzB) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.bMx != i) {
            this.bMx = i;
            if (this.dzR != null && this.dzS != null) {
                this.dzR.setX(getXCoordinate() + (this.dzS.aKB() * this.bMx));
                invalidate();
            }
            if (this.dzT != null) {
                this.dzT.a(this, this.bMx);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.bMx;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.dzG;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.dzG;
    }

    private float getFontHeight() {
        if (this.dzC == null || this.dzC.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.dzC[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.dzG)) - getPaddingLeft()) - getPaddingRight();
    }

    private boolean isAnimationRunning() {
        return this.dzn != null && this.dzn.isRunning();
    }

    private void stopAnimation() {
        if (this.dzn != null) {
            this.dzn.cancel();
            this.dzn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        private Paint bjo;
        private float dAa;
        private float dAb;
        private Paint dAc = new Paint();
        private Paint dAd;
        private final float dyT;
        private final float dzX;
        private final float dzY;
        private int dzZ;

        a(float f, float f2, float f3) {
            this.dAb = 7.5f;
            this.dyT = f;
            this.dzX = f + f3;
            this.dzY = f2;
            this.dzZ = SliderBar.this.dzB - 1;
            this.dAa = f3 / this.dzZ;
            this.dAb = SliderBar.this.dzD / 2.0f;
            this.dAc.setColor(SliderBar.this.dzF);
            this.dAc.setStrokeWidth(SliderBar.this.dzE);
            this.dAc.setAntiAlias(true);
            this.bjo = new Paint();
            this.bjo.setColor(SliderBar.this.mTextColor);
            this.bjo.setTextSize(SliderBar.this.mTextSize);
            this.bjo.setAntiAlias(true);
            this.dAd = new Paint();
            this.dAd.setColor(SliderBar.this.dzL);
            this.dAd.setTextSize(SliderBar.this.mTextSize);
            this.dAd.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            v(canvas);
            if (SliderBar.this.dzV) {
                w(canvas);
            }
        }

        private void v(Canvas canvas) {
            canvas.drawLine(this.dyT, this.dzY, this.dzX, this.dzY, this.dAc);
        }

        private void w(Canvas canvas) {
            for (int i = 0; i <= this.dzZ; i++) {
                float f = this.dyT + (this.dAa * i);
                canvas.drawCircle(f, this.dzY, this.dAb, this.dAc);
                if (SliderBar.this.dzC != null && SliderBar.this.dzC.length > 0) {
                    String str = SliderBar.this.dzC[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.bMx) {
                            Paint.FontMetrics fontMetrics = this.dAd.getFontMetrics();
                            canvas.drawText(str, f - (sf(str) / 2.0f), ((this.dzY - SliderBar.this.dzG) - SliderBar.this.dzM) - (fontMetrics.bottom - fontMetrics.descent), this.dAd);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.bjo.getFontMetrics();
                            canvas.drawText(str, f - (sf(str) / 2.0f), ((this.dzY - SliderBar.this.dzG) - SliderBar.this.dzM) - (fontMetrics2.bottom - fontMetrics2.descent), this.bjo);
                        }
                    }
                }
            }
        }

        float aKz() {
            return this.dyT;
        }

        float aKA() {
            return this.dzX;
        }

        float aKB() {
            return this.dAa;
        }

        float a(c cVar) {
            return this.dyT + (this.dAa * b(cVar));
        }

        int b(c cVar) {
            return J(cVar.getX());
        }

        int J(float f) {
            return (int) (((f - this.dyT) + (this.dAa / 2.0f)) / this.dAa);
        }

        float sf(String str) {
            return this.bjo.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c {
        private final float dAe;
        private boolean dAf;
        private Paint dAg = new Paint();
        private Paint dAh;
        private Paint dAi;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.dAe = (int) Math.max(50.0f, SliderBar.this.dzG * 2.0f);
            this.dAg.setColor(SliderBar.this.dzH);
            this.dAg.setAntiAlias(true);
            this.dAh = new Paint();
            this.dAh.setColor(SliderBar.this.dzI);
            this.dAh.setAntiAlias(true);
            this.dAi = new Paint();
            this.dAi.setStyle(Paint.Style.STROKE);
            this.dAi.setColor(SliderBar.this.dzJ);
            this.dAi.setAntiAlias(true);
            this.dAi.setStrokeWidth(SliderBar.this.dzK);
            if (SliderBar.this.dzO) {
                SliderBar.this.setLayerType(1, this.dAg);
                SliderBar.this.setLayerType(1, this.dAh);
                this.dAg.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dzP);
                this.dAh.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dzP);
            }
        }

        void draw(Canvas canvas) {
            if (this.dAf) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dzG, this.dAh);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dzG, this.dAg);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.dzG, this.dAi);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aKC() {
            return this.dAe;
        }

        boolean aKD() {
            return this.dAf;
        }

        void aKE() {
            this.dAf = true;
        }

        void release() {
            this.dAf = false;
        }

        boolean t(float f, float f2) {
            return Math.abs(f - this.mX) <= this.dAe && Math.abs(f2 - this.mY) <= this.dAe;
        }
    }
}
