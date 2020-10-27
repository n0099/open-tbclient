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
    private static final String[] dio = {"小", "中", "大", "特大"};
    private int diA;
    private int diB;
    private int diC;
    private int diD;
    private boolean diE;
    private int diF;
    private boolean diG;
    private c diH;
    private a diI;
    private b diJ;
    private int diK;
    private boolean diL;
    private int dip;
    private String[] diq;
    private float dit;
    private float diu;
    private int div;
    private float diw;
    private int dix;
    private int diy;
    private int diz;
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
        this.dip = 4;
        this.diq = dio;
        this.dit = 15.0f;
        this.diu = 3.0f;
        this.div = -7829368;
        this.diw = 30.0f;
        this.dix = -1;
        this.diy = -1;
        this.diz = 1711276032;
        this.diA = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.diB = -7829368;
        this.diC = 50;
        this.diD = 500;
        this.diE = false;
        this.diF = -3355444;
        this.diG = true;
        this.diK = -1;
        this.mCurrentIndex = 0;
        this.diL = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dip = 4;
        this.diq = dio;
        this.dit = 15.0f;
        this.diu = 3.0f;
        this.div = -7829368;
        this.diw = 30.0f;
        this.dix = -1;
        this.diy = -1;
        this.diz = 1711276032;
        this.diA = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.diB = -7829368;
        this.diC = 50;
        this.diD = 500;
        this.diE = false;
        this.diF = -3355444;
        this.diG = true;
        this.diK = -1;
        this.mCurrentIndex = 0;
        this.diL = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dip = 4;
        this.diq = dio;
        this.dit = 15.0f;
        this.diu = 3.0f;
        this.div = -7829368;
        this.diw = 30.0f;
        this.dix = -1;
        this.diy = -1;
        this.diz = 1711276032;
        this.diA = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.diB = -7829368;
        this.diC = 50;
        this.diD = 500;
        this.diE = false;
        this.diF = -3355444;
        this.diG = true;
        this.diK = -1;
        this.mCurrentIndex = 0;
        this.diL = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.dit = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.diu = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.div = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.diw = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.dix = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.diy = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.diz = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.diA = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.diB = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.diC = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.diD = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.mCurrentIndex = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.diG = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.diE = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.diF = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.diI = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.diH = new c(getXCoordinate() + (this.diI.aDR() * this.mCurrentIndex), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.diD;
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
        return (int) ((this.diw * 2.0f) + this.diC + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.diI.draw(canvas);
        this.diH.draw(canvas);
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
                return G(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean p(float f, float f2) {
        if (!this.diH.aDT() && this.diH.t(f, f2)) {
            aDN();
            return true;
        }
        this.diK = r(f, f2);
        return true;
    }

    private boolean G(float f) {
        if (this.diH.aDT()) {
            H(f);
            return true;
        }
        return true;
    }

    private boolean q(float f, float f2) {
        if (this.diH.aDT()) {
            aDO();
            return true;
        } else if (this.diK == r(f, f2) && this.diK != -1) {
            s(this.diH.getX(), getXCoordinate() + (this.diK * this.diI.aDR()));
            this.mCurrentIndex = this.diK;
            if (this.diJ != null) {
                this.diJ.a(this, this.mCurrentIndex);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int r(float f, float f2) {
        for (int i = 0; i < this.dip; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.diI.aDR() * ((float) i)))) < this.diH.aDS() && Math.abs(f2 - getYCoordinate()) < this.diH.aDS() * 2.0f;
    }

    private void aDN() {
        this.diH.aDU();
        invalidate();
    }

    private void H(float f) {
        if (f >= this.diI.aDP() && f <= this.diI.aDQ()) {
            this.diH.setX(f);
            invalidate();
        }
    }

    private void aDO() {
        int b2 = this.diI.b(this.diH);
        if (this.mCurrentIndex != b2) {
            this.mCurrentIndex = b2;
            if (this.diJ != null) {
                this.diJ.a(this, this.mCurrentIndex);
            }
        }
        float x = this.diH.getX();
        float a2 = this.diI.a(this.diH);
        if (this.diG) {
            s(x, a2);
        } else {
            this.diH.setX(a2);
            invalidate();
        }
        this.diH.release();
    }

    private void s(float f, float f2) {
        stopAnimation();
        this.mAnimator = ValueAnimator.ofFloat(f, f2);
        this.mAnimator.setDuration(80L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.diH.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public SliderBar a(b bVar) {
        this.diJ = bVar;
        return this;
    }

    public SliderBar jC(int i) {
        if (i < 0 || i >= this.dip) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            if (this.diH != null && this.diI != null) {
                this.diH.setX(getXCoordinate() + (this.diI.aDR() * this.mCurrentIndex));
                invalidate();
            }
            if (this.diJ != null) {
                this.diJ.a(this, this.mCurrentIndex);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.diw;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.diw;
    }

    private float getFontHeight() {
        if (this.diq == null || this.diq.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.diq[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.diw)) - getPaddingLeft()) - getPaddingRight();
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
        private final float diN;
        private final float diO;
        private int diP;
        private float diQ;
        private float diR;
        private Paint diS = new Paint();
        private Paint diT;
        private final float dic;
        private Paint mTextPaint;

        a(float f, float f2, float f3) {
            this.diR = 7.5f;
            this.dic = f;
            this.diN = f + f3;
            this.diO = f2;
            this.diP = SliderBar.this.dip - 1;
            this.diQ = f3 / this.diP;
            this.diR = SliderBar.this.dit / 2.0f;
            this.diS.setColor(SliderBar.this.div);
            this.diS.setStrokeWidth(SliderBar.this.diu);
            this.diS.setAntiAlias(true);
            this.mTextPaint = new Paint();
            this.mTextPaint.setColor(SliderBar.this.mTextColor);
            this.mTextPaint.setTextSize(SliderBar.this.mTextSize);
            this.mTextPaint.setAntiAlias(true);
            this.diT = new Paint();
            this.diT.setColor(SliderBar.this.diB);
            this.diT.setTextSize(SliderBar.this.mTextSize);
            this.diT.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            o(canvas);
            if (SliderBar.this.diL) {
                p(canvas);
            }
        }

        private void o(Canvas canvas) {
            canvas.drawLine(this.dic, this.diO, this.diN, this.diO, this.diS);
        }

        private void p(Canvas canvas) {
            for (int i = 0; i <= this.diP; i++) {
                float f = this.dic + (this.diQ * i);
                canvas.drawCircle(f, this.diO, this.diR, this.diS);
                if (SliderBar.this.diq != null && SliderBar.this.diq.length > 0) {
                    String str = SliderBar.this.diq[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.mCurrentIndex) {
                            Paint.FontMetrics fontMetrics = this.diT.getFontMetrics();
                            canvas.drawText(str, f - (rx(str) / 2.0f), ((this.diO - SliderBar.this.diw) - SliderBar.this.diC) - (fontMetrics.bottom - fontMetrics.descent), this.diT);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
                            canvas.drawText(str, f - (rx(str) / 2.0f), ((this.diO - SliderBar.this.diw) - SliderBar.this.diC) - (fontMetrics2.bottom - fontMetrics2.descent), this.mTextPaint);
                        }
                    }
                }
            }
        }

        float aDP() {
            return this.dic;
        }

        float aDQ() {
            return this.diN;
        }

        float aDR() {
            return this.diQ;
        }

        float a(c cVar) {
            return this.dic + (this.diQ * b(cVar));
        }

        int b(c cVar) {
            return I(cVar.getX());
        }

        int I(float f) {
            return (int) (((f - this.dic) + (this.diQ / 2.0f)) / this.diQ);
        }

        float rx(String str) {
            return this.mTextPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c {
        private final float diU;
        private boolean diV;
        private Paint diW = new Paint();
        private Paint diX;
        private Paint diY;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.diU = (int) Math.max(50.0f, SliderBar.this.diw * 2.0f);
            this.diW.setColor(SliderBar.this.dix);
            this.diW.setAntiAlias(true);
            this.diX = new Paint();
            this.diX.setColor(SliderBar.this.diy);
            this.diX.setAntiAlias(true);
            this.diY = new Paint();
            this.diY.setStyle(Paint.Style.STROKE);
            this.diY.setColor(SliderBar.this.diz);
            this.diY.setAntiAlias(true);
            this.diY.setStrokeWidth(SliderBar.this.diA);
            if (SliderBar.this.diE) {
                SliderBar.this.setLayerType(1, this.diW);
                SliderBar.this.setLayerType(1, this.diX);
                this.diW.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.diF);
                this.diX.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.diF);
            }
        }

        void draw(Canvas canvas) {
            if (this.diV) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.diw, this.diX);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.diw, this.diW);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.diw, this.diY);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aDS() {
            return this.diU;
        }

        boolean aDT() {
            return this.diV;
        }

        void aDU() {
            this.diV = true;
        }

        void release() {
            this.diV = false;
        }

        boolean t(float f, float f2) {
            return Math.abs(f - this.mX) <= this.diU && Math.abs(f2 - this.mY) <= this.diU;
        }
    }
}
