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
/* loaded from: classes8.dex */
public class SliderBar extends View {
    private static final String[] duO = {"小", "中", "大", "特大"};
    private int bHL;
    private ValueAnimator duB;
    private int duP;
    private String[] duQ;
    private float duR;
    private float duS;
    private int duT;
    private float duU;
    private int duV;
    private int duW;
    private int duX;
    private int duY;
    private int duZ;
    private int dva;
    private int dvb;
    private boolean dvc;
    private int dvd;
    private boolean dve;
    private c dvf;
    private a dvg;
    private b dvh;
    private int dvi;
    private boolean dvj;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.duP = 4;
        this.duQ = duO;
        this.duR = 15.0f;
        this.duS = 3.0f;
        this.duT = -7829368;
        this.duU = 30.0f;
        this.duV = -1;
        this.duW = -1;
        this.duX = 1711276032;
        this.duY = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.duZ = -7829368;
        this.dva = 50;
        this.dvb = 500;
        this.dvc = false;
        this.dvd = -3355444;
        this.dve = true;
        this.dvi = -1;
        this.bHL = 0;
        this.dvj = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duP = 4;
        this.duQ = duO;
        this.duR = 15.0f;
        this.duS = 3.0f;
        this.duT = -7829368;
        this.duU = 30.0f;
        this.duV = -1;
        this.duW = -1;
        this.duX = 1711276032;
        this.duY = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.duZ = -7829368;
        this.dva = 50;
        this.dvb = 500;
        this.dvc = false;
        this.dvd = -3355444;
        this.dve = true;
        this.dvi = -1;
        this.bHL = 0;
        this.dvj = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duP = 4;
        this.duQ = duO;
        this.duR = 15.0f;
        this.duS = 3.0f;
        this.duT = -7829368;
        this.duU = 30.0f;
        this.duV = -1;
        this.duW = -1;
        this.duX = 1711276032;
        this.duY = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.duZ = -7829368;
        this.dva = 50;
        this.dvb = 500;
        this.dvc = false;
        this.dvd = -3355444;
        this.dve = true;
        this.dvi = -1;
        this.bHL = 0;
        this.dvj = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.duR = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.duS = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.duT = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.duU = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.duV = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.duW = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.duX = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.duY = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.duZ = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.dva = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.dvb = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.bHL = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.dve = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.dvc = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.dvd = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.dvg = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.dvf = new c(getXCoordinate() + (this.dvg.aGI() * this.bHL), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.dvb;
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
        return (int) ((this.duU * 2.0f) + this.dva + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.dvg.draw(canvas);
        this.dvf.draw(canvas);
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
                return H(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean q(float f, float f2) {
        if (!this.dvf.aGK() && this.dvf.u(f, f2)) {
            aGE();
            return true;
        }
        this.dvi = s(f, f2);
        return true;
    }

    private boolean H(float f) {
        if (this.dvf.aGK()) {
            I(f);
            return true;
        }
        return true;
    }

    private boolean r(float f, float f2) {
        if (this.dvf.aGK()) {
            aGF();
            return true;
        } else if (this.dvi == s(f, f2) && this.dvi != -1) {
            t(this.dvf.getX(), getXCoordinate() + (this.dvi * this.dvg.aGI()));
            this.bHL = this.dvi;
            if (this.dvh != null) {
                this.dvh.a(this, this.bHL);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int s(float f, float f2) {
        for (int i = 0; i < this.duP; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.dvg.aGI() * ((float) i)))) < this.dvf.aGJ() && Math.abs(f2 - getYCoordinate()) < this.dvf.aGJ() * 2.0f;
    }

    private void aGE() {
        this.dvf.aGL();
        invalidate();
    }

    private void I(float f) {
        if (f >= this.dvg.aGG() && f <= this.dvg.aGH()) {
            this.dvf.setX(f);
            invalidate();
        }
    }

    private void aGF() {
        int b2 = this.dvg.b(this.dvf);
        if (this.bHL != b2) {
            this.bHL = b2;
            if (this.dvh != null) {
                this.dvh.a(this, this.bHL);
            }
        }
        float x = this.dvf.getX();
        float a2 = this.dvg.a(this.dvf);
        if (this.dve) {
            t(x, a2);
        } else {
            this.dvf.setX(a2);
            invalidate();
        }
        this.dvf.release();
    }

    private void t(float f, float f2) {
        stopAnimation();
        this.duB = ValueAnimator.ofFloat(f, f2);
        this.duB.setDuration(80L);
        this.duB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.dvf.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.duB.start();
    }

    public SliderBar a(b bVar) {
        this.dvh = bVar;
        return this;
    }

    public SliderBar iz(int i) {
        if (i < 0 || i >= this.duP) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.bHL != i) {
            this.bHL = i;
            if (this.dvf != null && this.dvg != null) {
                this.dvf.setX(getXCoordinate() + (this.dvg.aGI() * this.bHL));
                invalidate();
            }
            if (this.dvh != null) {
                this.dvh.a(this, this.bHL);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.bHL;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.duU;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.duU;
    }

    private float getFontHeight() {
        if (this.duQ == null || this.duQ.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.duQ[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.duU)) - getPaddingLeft()) - getPaddingRight();
    }

    private boolean isAnimationRunning() {
        return this.duB != null && this.duB.isRunning();
    }

    private void stopAnimation() {
        if (this.duB != null) {
            this.duB.cancel();
            this.duB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        private Paint bex;
        private final float duh;
        private final float dvl;
        private final float dvm;
        private int dvn;
        private float dvo;
        private float dvp;
        private Paint dvq = new Paint();
        private Paint dvr;

        a(float f, float f2, float f3) {
            this.dvp = 7.5f;
            this.duh = f;
            this.dvl = f + f3;
            this.dvm = f2;
            this.dvn = SliderBar.this.duP - 1;
            this.dvo = f3 / this.dvn;
            this.dvp = SliderBar.this.duR / 2.0f;
            this.dvq.setColor(SliderBar.this.duT);
            this.dvq.setStrokeWidth(SliderBar.this.duS);
            this.dvq.setAntiAlias(true);
            this.bex = new Paint();
            this.bex.setColor(SliderBar.this.mTextColor);
            this.bex.setTextSize(SliderBar.this.mTextSize);
            this.bex.setAntiAlias(true);
            this.dvr = new Paint();
            this.dvr.setColor(SliderBar.this.duZ);
            this.dvr.setTextSize(SliderBar.this.mTextSize);
            this.dvr.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            v(canvas);
            if (SliderBar.this.dvj) {
                w(canvas);
            }
        }

        private void v(Canvas canvas) {
            canvas.drawLine(this.duh, this.dvm, this.dvl, this.dvm, this.dvq);
        }

        private void w(Canvas canvas) {
            for (int i = 0; i <= this.dvn; i++) {
                float f = this.duh + (this.dvo * i);
                canvas.drawCircle(f, this.dvm, this.dvp, this.dvq);
                if (SliderBar.this.duQ != null && SliderBar.this.duQ.length > 0) {
                    String str = SliderBar.this.duQ[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.bHL) {
                            Paint.FontMetrics fontMetrics = this.dvr.getFontMetrics();
                            canvas.drawText(str, f - (qU(str) / 2.0f), ((this.dvm - SliderBar.this.duU) - SliderBar.this.dva) - (fontMetrics.bottom - fontMetrics.descent), this.dvr);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.bex.getFontMetrics();
                            canvas.drawText(str, f - (qU(str) / 2.0f), ((this.dvm - SliderBar.this.duU) - SliderBar.this.dva) - (fontMetrics2.bottom - fontMetrics2.descent), this.bex);
                        }
                    }
                }
            }
        }

        float aGG() {
            return this.duh;
        }

        float aGH() {
            return this.dvl;
        }

        float aGI() {
            return this.dvo;
        }

        float a(c cVar) {
            return this.duh + (this.dvo * b(cVar));
        }

        int b(c cVar) {
            return J(cVar.getX());
        }

        int J(float f) {
            return (int) (((f - this.duh) + (this.dvo / 2.0f)) / this.dvo);
        }

        float qU(String str) {
            return this.bex.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        private final float dvs;
        private boolean dvt;
        private Paint dvu = new Paint();
        private Paint dvv;
        private Paint dvw;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.dvs = (int) Math.max(50.0f, SliderBar.this.duU * 2.0f);
            this.dvu.setColor(SliderBar.this.duV);
            this.dvu.setAntiAlias(true);
            this.dvv = new Paint();
            this.dvv.setColor(SliderBar.this.duW);
            this.dvv.setAntiAlias(true);
            this.dvw = new Paint();
            this.dvw.setStyle(Paint.Style.STROKE);
            this.dvw.setColor(SliderBar.this.duX);
            this.dvw.setAntiAlias(true);
            this.dvw.setStrokeWidth(SliderBar.this.duY);
            if (SliderBar.this.dvc) {
                SliderBar.this.setLayerType(1, this.dvu);
                SliderBar.this.setLayerType(1, this.dvv);
                this.dvu.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dvd);
                this.dvv.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dvd);
            }
        }

        void draw(Canvas canvas) {
            if (this.dvt) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.duU, this.dvv);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.duU, this.dvu);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.duU, this.dvw);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aGJ() {
            return this.dvs;
        }

        boolean aGK() {
            return this.dvt;
        }

        void aGL() {
            this.dvt = true;
        }

        void release() {
            this.dvt = false;
        }

        boolean u(float f, float f2) {
            return Math.abs(f - this.mX) <= this.dvs && Math.abs(f2 - this.mY) <= this.dvs;
        }
    }
}
