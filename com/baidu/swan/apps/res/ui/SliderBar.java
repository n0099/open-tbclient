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
    private static final String[] cLJ = {"小", "中", "大", "特大"};
    private int cLK;
    private String[] cLL;
    private float cLM;
    private float cLN;
    private int cLO;
    private float cLP;
    private int cLQ;
    private int cLR;
    private int cLS;
    private int cLT;
    private int cLU;
    private int cLV;
    private int cLW;
    private boolean cLX;
    private int cLY;
    private boolean cLZ;
    private c cMa;
    private a cMb;
    private b cMc;
    private int cMd;
    private boolean cMe;
    private ValueAnimator mAnimator;
    private int mCurrentIndex;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.cLK = 4;
        this.cLL = cLJ;
        this.cLM = 15.0f;
        this.cLN = 3.0f;
        this.cLO = -7829368;
        this.cLP = 30.0f;
        this.cLQ = -1;
        this.cLR = -1;
        this.cLS = 1711276032;
        this.cLT = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cLU = -7829368;
        this.cLV = 50;
        this.cLW = 500;
        this.cLX = false;
        this.cLY = -3355444;
        this.cLZ = true;
        this.cMd = -1;
        this.mCurrentIndex = 0;
        this.cMe = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLK = 4;
        this.cLL = cLJ;
        this.cLM = 15.0f;
        this.cLN = 3.0f;
        this.cLO = -7829368;
        this.cLP = 30.0f;
        this.cLQ = -1;
        this.cLR = -1;
        this.cLS = 1711276032;
        this.cLT = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cLU = -7829368;
        this.cLV = 50;
        this.cLW = 500;
        this.cLX = false;
        this.cLY = -3355444;
        this.cLZ = true;
        this.cMd = -1;
        this.mCurrentIndex = 0;
        this.cMe = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLK = 4;
        this.cLL = cLJ;
        this.cLM = 15.0f;
        this.cLN = 3.0f;
        this.cLO = -7829368;
        this.cLP = 30.0f;
        this.cLQ = -1;
        this.cLR = -1;
        this.cLS = 1711276032;
        this.cLT = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cLU = -7829368;
        this.cLV = 50;
        this.cLW = 500;
        this.cLX = false;
        this.cLY = -3355444;
        this.cLZ = true;
        this.cMd = -1;
        this.mCurrentIndex = 0;
        this.cMe = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.cLM = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.cLN = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.cLO = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.cLP = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.cLQ = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.cLR = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.cLS = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.cLT = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.cLU = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.cLV = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.cLW = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.mCurrentIndex = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.cLZ = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.cLX = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.cLY = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.cMb = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.cMa = new c(getXCoordinate() + (this.cMb.ayF() * this.mCurrentIndex), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.cLW;
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
        return (int) ((this.cLP * 2.0f) + this.cLV + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cMb.draw(canvas);
        this.cMa.draw(canvas);
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
                return o(motionEvent.getX(), motionEvent.getY());
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                return p(motionEvent.getX(), motionEvent.getY());
            case 2:
                getParent().requestDisallowInterceptTouchEvent(true);
                return C(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean o(float f, float f2) {
        if (!this.cMa.ayH() && this.cMa.s(f, f2)) {
            ayB();
            return true;
        }
        this.cMd = q(f, f2);
        return true;
    }

    private boolean C(float f) {
        if (this.cMa.ayH()) {
            D(f);
            return true;
        }
        return true;
    }

    private boolean p(float f, float f2) {
        if (this.cMa.ayH()) {
            ayC();
            return true;
        } else if (this.cMd == q(f, f2) && this.cMd != -1) {
            r(this.cMa.getX(), getXCoordinate() + (this.cMd * this.cMb.ayF()));
            this.mCurrentIndex = this.cMd;
            if (this.cMc != null) {
                this.cMc.a(this, this.mCurrentIndex);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int q(float f, float f2) {
        for (int i = 0; i < this.cLK; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.cMb.ayF() * ((float) i)))) < this.cMa.ayG() && Math.abs(f2 - getYCoordinate()) < this.cMa.ayG() * 2.0f;
    }

    private void ayB() {
        this.cMa.ayI();
        invalidate();
    }

    private void D(float f) {
        if (f >= this.cMb.ayD() && f <= this.cMb.ayE()) {
            this.cMa.setX(f);
            invalidate();
        }
    }

    private void ayC() {
        int b2 = this.cMb.b(this.cMa);
        if (this.mCurrentIndex != b2) {
            this.mCurrentIndex = b2;
            if (this.cMc != null) {
                this.cMc.a(this, this.mCurrentIndex);
            }
        }
        float x = this.cMa.getX();
        float a2 = this.cMb.a(this.cMa);
        if (this.cLZ) {
            r(x, a2);
        } else {
            this.cMa.setX(a2);
            invalidate();
        }
        this.cMa.release();
    }

    private void r(float f, float f2) {
        stopAnimation();
        this.mAnimator = ValueAnimator.ofFloat(f, f2);
        this.mAnimator.setDuration(80L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.cMa.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public SliderBar a(b bVar) {
        this.cMc = bVar;
        return this;
    }

    public SliderBar iK(int i) {
        if (i < 0 || i >= this.cLK) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            if (this.cMa != null && this.cMb != null) {
                this.cMa.setX(getXCoordinate() + (this.cMb.ayF() * this.mCurrentIndex));
                invalidate();
            }
            if (this.cMc != null) {
                this.cMc.a(this, this.mCurrentIndex);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.cLP;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.cLP;
    }

    private float getFontHeight() {
        if (this.cLL == null || this.cLL.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.cLL[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.cLP)) - getPaddingLeft()) - getPaddingRight();
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
    /* loaded from: classes8.dex */
    public class a {
        private final float cLy;
        private final float cMg;
        private final float cMh;
        private int cMi;
        private float cMj;
        private float cMk;
        private Paint cMl = new Paint();
        private Paint cMm;
        private Paint mTextPaint;

        a(float f, float f2, float f3) {
            this.cMk = 7.5f;
            this.cLy = f;
            this.cMg = f + f3;
            this.cMh = f2;
            this.cMi = SliderBar.this.cLK - 1;
            this.cMj = f3 / this.cMi;
            this.cMk = SliderBar.this.cLM / 2.0f;
            this.cMl.setColor(SliderBar.this.cLO);
            this.cMl.setStrokeWidth(SliderBar.this.cLN);
            this.cMl.setAntiAlias(true);
            this.mTextPaint = new Paint();
            this.mTextPaint.setColor(SliderBar.this.mTextColor);
            this.mTextPaint.setTextSize(SliderBar.this.mTextSize);
            this.mTextPaint.setAntiAlias(true);
            this.cMm = new Paint();
            this.cMm.setColor(SliderBar.this.cLU);
            this.cMm.setTextSize(SliderBar.this.mTextSize);
            this.cMm.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            o(canvas);
            if (SliderBar.this.cMe) {
                p(canvas);
            }
        }

        private void o(Canvas canvas) {
            canvas.drawLine(this.cLy, this.cMh, this.cMg, this.cMh, this.cMl);
        }

        private void p(Canvas canvas) {
            for (int i = 0; i <= this.cMi; i++) {
                float f = this.cLy + (this.cMj * i);
                canvas.drawCircle(f, this.cMh, this.cMk, this.cMl);
                if (SliderBar.this.cLL != null && SliderBar.this.cLL.length > 0) {
                    String str = SliderBar.this.cLL[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.mCurrentIndex) {
                            Paint.FontMetrics fontMetrics = this.cMm.getFontMetrics();
                            canvas.drawText(str, f - (pZ(str) / 2.0f), ((this.cMh - SliderBar.this.cLP) - SliderBar.this.cLV) - (fontMetrics.bottom - fontMetrics.descent), this.cMm);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
                            canvas.drawText(str, f - (pZ(str) / 2.0f), ((this.cMh - SliderBar.this.cLP) - SliderBar.this.cLV) - (fontMetrics2.bottom - fontMetrics2.descent), this.mTextPaint);
                        }
                    }
                }
            }
        }

        float ayD() {
            return this.cLy;
        }

        float ayE() {
            return this.cMg;
        }

        float ayF() {
            return this.cMj;
        }

        float a(c cVar) {
            return this.cLy + (this.cMj * b(cVar));
        }

        int b(c cVar) {
            return E(cVar.getX());
        }

        int E(float f) {
            return (int) (((f - this.cLy) + (this.cMj / 2.0f)) / this.cMj);
        }

        float pZ(String str) {
            return this.mTextPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        private final float cMn;
        private boolean cMo;
        private Paint cMp = new Paint();
        private Paint cMq;
        private Paint cMr;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.cMn = (int) Math.max(50.0f, SliderBar.this.cLP * 2.0f);
            this.cMp.setColor(SliderBar.this.cLQ);
            this.cMp.setAntiAlias(true);
            this.cMq = new Paint();
            this.cMq.setColor(SliderBar.this.cLR);
            this.cMq.setAntiAlias(true);
            this.cMr = new Paint();
            this.cMr.setStyle(Paint.Style.STROKE);
            this.cMr.setColor(SliderBar.this.cLS);
            this.cMr.setAntiAlias(true);
            this.cMr.setStrokeWidth(SliderBar.this.cLT);
            if (SliderBar.this.cLX) {
                SliderBar.this.setLayerType(1, this.cMp);
                SliderBar.this.setLayerType(1, this.cMq);
                this.cMp.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.cLY);
                this.cMq.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.cLY);
            }
        }

        void draw(Canvas canvas) {
            if (this.cMo) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.cLP, this.cMq);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.cLP, this.cMp);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.cLP, this.cMr);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float ayG() {
            return this.cMn;
        }

        boolean ayH() {
            return this.cMo;
        }

        void ayI() {
            this.cMo = true;
        }

        void release() {
            this.cMo = false;
        }

        boolean s(float f, float f2) {
            return Math.abs(f - this.mX) <= this.cMn && Math.abs(f2 - this.mY) <= this.cMn;
        }
    }
}
