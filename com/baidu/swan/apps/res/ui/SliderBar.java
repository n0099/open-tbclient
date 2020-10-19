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
    private static final String[] cZM = {"小", "中", "大", "特大"};
    private int cZN;
    private String[] cZO;
    private float cZP;
    private float cZQ;
    private int cZR;
    private float cZS;
    private int cZT;
    private int cZU;
    private int cZV;
    private int cZW;
    private int cZX;
    private int cZY;
    private int cZZ;
    private boolean daa;
    private int dab;
    private boolean dac;
    private c dad;
    private a dae;
    private b daf;
    private int dag;
    private boolean dah;
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
        this.cZN = 4;
        this.cZO = cZM;
        this.cZP = 15.0f;
        this.cZQ = 3.0f;
        this.cZR = -7829368;
        this.cZS = 30.0f;
        this.cZT = -1;
        this.cZU = -1;
        this.cZV = 1711276032;
        this.cZW = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cZX = -7829368;
        this.cZY = 50;
        this.cZZ = 500;
        this.daa = false;
        this.dab = -3355444;
        this.dac = true;
        this.dag = -1;
        this.mCurrentIndex = 0;
        this.dah = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZN = 4;
        this.cZO = cZM;
        this.cZP = 15.0f;
        this.cZQ = 3.0f;
        this.cZR = -7829368;
        this.cZS = 30.0f;
        this.cZT = -1;
        this.cZU = -1;
        this.cZV = 1711276032;
        this.cZW = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cZX = -7829368;
        this.cZY = 50;
        this.cZZ = 500;
        this.daa = false;
        this.dab = -3355444;
        this.dac = true;
        this.dag = -1;
        this.mCurrentIndex = 0;
        this.dah = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZN = 4;
        this.cZO = cZM;
        this.cZP = 15.0f;
        this.cZQ = 3.0f;
        this.cZR = -7829368;
        this.cZS = 30.0f;
        this.cZT = -1;
        this.cZU = -1;
        this.cZV = 1711276032;
        this.cZW = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cZX = -7829368;
        this.cZY = 50;
        this.cZZ = 500;
        this.daa = false;
        this.dab = -3355444;
        this.dac = true;
        this.dag = -1;
        this.mCurrentIndex = 0;
        this.dah = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.cZP = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.cZQ = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.cZR = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.cZS = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.cZT = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.cZU = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.cZV = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.cZW = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.cZX = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.cZY = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.cZZ = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.mCurrentIndex = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.dac = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.daa = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.dab = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.dae = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.dad = new c(getXCoordinate() + (this.dae.aBX() * this.mCurrentIndex), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.cZZ;
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
        return (int) ((this.cZS * 2.0f) + this.cZY + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.dae.draw(canvas);
        this.dad.draw(canvas);
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
                return E(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean p(float f, float f2) {
        if (!this.dad.aBZ() && this.dad.t(f, f2)) {
            aBT();
            return true;
        }
        this.dag = r(f, f2);
        return true;
    }

    private boolean E(float f) {
        if (this.dad.aBZ()) {
            F(f);
            return true;
        }
        return true;
    }

    private boolean q(float f, float f2) {
        if (this.dad.aBZ()) {
            aBU();
            return true;
        } else if (this.dag == r(f, f2) && this.dag != -1) {
            s(this.dad.getX(), getXCoordinate() + (this.dag * this.dae.aBX()));
            this.mCurrentIndex = this.dag;
            if (this.daf != null) {
                this.daf.a(this, this.mCurrentIndex);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int r(float f, float f2) {
        for (int i = 0; i < this.cZN; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.dae.aBX() * ((float) i)))) < this.dad.aBY() && Math.abs(f2 - getYCoordinate()) < this.dad.aBY() * 2.0f;
    }

    private void aBT() {
        this.dad.aCa();
        invalidate();
    }

    private void F(float f) {
        if (f >= this.dae.aBV() && f <= this.dae.aBW()) {
            this.dad.setX(f);
            invalidate();
        }
    }

    private void aBU() {
        int b2 = this.dae.b(this.dad);
        if (this.mCurrentIndex != b2) {
            this.mCurrentIndex = b2;
            if (this.daf != null) {
                this.daf.a(this, this.mCurrentIndex);
            }
        }
        float x = this.dad.getX();
        float a2 = this.dae.a(this.dad);
        if (this.dac) {
            s(x, a2);
        } else {
            this.dad.setX(a2);
            invalidate();
        }
        this.dad.release();
    }

    private void s(float f, float f2) {
        stopAnimation();
        this.mAnimator = ValueAnimator.ofFloat(f, f2);
        this.mAnimator.setDuration(80L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.dad.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public SliderBar a(b bVar) {
        this.daf = bVar;
        return this;
    }

    public SliderBar jr(int i) {
        if (i < 0 || i >= this.cZN) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            if (this.dad != null && this.dae != null) {
                this.dad.setX(getXCoordinate() + (this.dae.aBX() * this.mCurrentIndex));
                invalidate();
            }
            if (this.daf != null) {
                this.daf.a(this, this.mCurrentIndex);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.cZS;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.cZS;
    }

    private float getFontHeight() {
        if (this.cZO == null || this.cZO.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.cZO[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.cZS)) - getPaddingLeft()) - getPaddingRight();
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
        private final float cZB;
        private final float daj;
        private final float dak;
        private int dal;
        private float dam;
        private float dan;
        private Paint dao = new Paint();
        private Paint dap;
        private Paint mTextPaint;

        a(float f, float f2, float f3) {
            this.dan = 7.5f;
            this.cZB = f;
            this.daj = f + f3;
            this.dak = f2;
            this.dal = SliderBar.this.cZN - 1;
            this.dam = f3 / this.dal;
            this.dan = SliderBar.this.cZP / 2.0f;
            this.dao.setColor(SliderBar.this.cZR);
            this.dao.setStrokeWidth(SliderBar.this.cZQ);
            this.dao.setAntiAlias(true);
            this.mTextPaint = new Paint();
            this.mTextPaint.setColor(SliderBar.this.mTextColor);
            this.mTextPaint.setTextSize(SliderBar.this.mTextSize);
            this.mTextPaint.setAntiAlias(true);
            this.dap = new Paint();
            this.dap.setColor(SliderBar.this.cZX);
            this.dap.setTextSize(SliderBar.this.mTextSize);
            this.dap.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            o(canvas);
            if (SliderBar.this.dah) {
                p(canvas);
            }
        }

        private void o(Canvas canvas) {
            canvas.drawLine(this.cZB, this.dak, this.daj, this.dak, this.dao);
        }

        private void p(Canvas canvas) {
            for (int i = 0; i <= this.dal; i++) {
                float f = this.cZB + (this.dam * i);
                canvas.drawCircle(f, this.dak, this.dan, this.dao);
                if (SliderBar.this.cZO != null && SliderBar.this.cZO.length > 0) {
                    String str = SliderBar.this.cZO[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.mCurrentIndex) {
                            Paint.FontMetrics fontMetrics = this.dap.getFontMetrics();
                            canvas.drawText(str, f - (re(str) / 2.0f), ((this.dak - SliderBar.this.cZS) - SliderBar.this.cZY) - (fontMetrics.bottom - fontMetrics.descent), this.dap);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
                            canvas.drawText(str, f - (re(str) / 2.0f), ((this.dak - SliderBar.this.cZS) - SliderBar.this.cZY) - (fontMetrics2.bottom - fontMetrics2.descent), this.mTextPaint);
                        }
                    }
                }
            }
        }

        float aBV() {
            return this.cZB;
        }

        float aBW() {
            return this.daj;
        }

        float aBX() {
            return this.dam;
        }

        float a(c cVar) {
            return this.cZB + (this.dam * b(cVar));
        }

        int b(c cVar) {
            return G(cVar.getX());
        }

        int G(float f) {
            return (int) (((f - this.cZB) + (this.dam / 2.0f)) / this.dam);
        }

        float re(String str) {
            return this.mTextPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c {
        private final float daq;
        private boolean dar;
        private Paint das = new Paint();
        private Paint dau;
        private Paint dav;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.daq = (int) Math.max(50.0f, SliderBar.this.cZS * 2.0f);
            this.das.setColor(SliderBar.this.cZT);
            this.das.setAntiAlias(true);
            this.dau = new Paint();
            this.dau.setColor(SliderBar.this.cZU);
            this.dau.setAntiAlias(true);
            this.dav = new Paint();
            this.dav.setStyle(Paint.Style.STROKE);
            this.dav.setColor(SliderBar.this.cZV);
            this.dav.setAntiAlias(true);
            this.dav.setStrokeWidth(SliderBar.this.cZW);
            if (SliderBar.this.daa) {
                SliderBar.this.setLayerType(1, this.das);
                SliderBar.this.setLayerType(1, this.dau);
                this.das.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dab);
                this.dau.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dab);
            }
        }

        void draw(Canvas canvas) {
            if (this.dar) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.cZS, this.dau);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.cZS, this.das);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.cZS, this.dav);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aBY() {
            return this.daq;
        }

        boolean aBZ() {
            return this.dar;
        }

        void aCa() {
            this.dar = true;
        }

        void release() {
            this.dar = false;
        }

        boolean t(float f, float f2) {
            return Math.abs(f - this.mX) <= this.daq && Math.abs(f2 - this.mY) <= this.daq;
        }
    }
}
