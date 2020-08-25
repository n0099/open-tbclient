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
    private static final String[] cLF = {"小", "中", "大", "特大"};
    private int cLG;
    private String[] cLH;
    private float cLI;
    private float cLJ;
    private int cLK;
    private float cLL;
    private int cLM;
    private int cLN;
    private int cLO;
    private int cLP;
    private int cLQ;
    private int cLR;
    private int cLS;
    private boolean cLT;
    private int cLU;
    private boolean cLV;
    private c cLW;
    private a cLX;
    private b cLY;
    private int cLZ;
    private boolean cMa;
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
        this.cLG = 4;
        this.cLH = cLF;
        this.cLI = 15.0f;
        this.cLJ = 3.0f;
        this.cLK = -7829368;
        this.cLL = 30.0f;
        this.cLM = -1;
        this.cLN = -1;
        this.cLO = 1711276032;
        this.cLP = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cLQ = -7829368;
        this.cLR = 50;
        this.cLS = 500;
        this.cLT = false;
        this.cLU = -3355444;
        this.cLV = true;
        this.cLZ = -1;
        this.mCurrentIndex = 0;
        this.cMa = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLG = 4;
        this.cLH = cLF;
        this.cLI = 15.0f;
        this.cLJ = 3.0f;
        this.cLK = -7829368;
        this.cLL = 30.0f;
        this.cLM = -1;
        this.cLN = -1;
        this.cLO = 1711276032;
        this.cLP = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cLQ = -7829368;
        this.cLR = 50;
        this.cLS = 500;
        this.cLT = false;
        this.cLU = -3355444;
        this.cLV = true;
        this.cLZ = -1;
        this.mCurrentIndex = 0;
        this.cMa = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLG = 4;
        this.cLH = cLF;
        this.cLI = 15.0f;
        this.cLJ = 3.0f;
        this.cLK = -7829368;
        this.cLL = 30.0f;
        this.cLM = -1;
        this.cLN = -1;
        this.cLO = 1711276032;
        this.cLP = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.cLQ = -7829368;
        this.cLR = 50;
        this.cLS = 500;
        this.cLT = false;
        this.cLU = -3355444;
        this.cLV = true;
        this.cLZ = -1;
        this.mCurrentIndex = 0;
        this.cMa = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.cLI = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.cLJ = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.cLK = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.cLL = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.cLM = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.cLN = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.cLO = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.cLP = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.cLQ = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.cLR = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.cLS = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.mCurrentIndex = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.cLV = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.cLT = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.cLU = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.cLX = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.cLW = new c(getXCoordinate() + (this.cLX.ayF() * this.mCurrentIndex), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.cLS;
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
        return (int) ((this.cLL * 2.0f) + this.cLR + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cLX.draw(canvas);
        this.cLW.draw(canvas);
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
        if (!this.cLW.ayH() && this.cLW.s(f, f2)) {
            ayB();
            return true;
        }
        this.cLZ = q(f, f2);
        return true;
    }

    private boolean C(float f) {
        if (this.cLW.ayH()) {
            D(f);
            return true;
        }
        return true;
    }

    private boolean p(float f, float f2) {
        if (this.cLW.ayH()) {
            ayC();
            return true;
        } else if (this.cLZ == q(f, f2) && this.cLZ != -1) {
            r(this.cLW.getX(), getXCoordinate() + (this.cLZ * this.cLX.ayF()));
            this.mCurrentIndex = this.cLZ;
            if (this.cLY != null) {
                this.cLY.a(this, this.mCurrentIndex);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int q(float f, float f2) {
        for (int i = 0; i < this.cLG; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.cLX.ayF() * ((float) i)))) < this.cLW.ayG() && Math.abs(f2 - getYCoordinate()) < this.cLW.ayG() * 2.0f;
    }

    private void ayB() {
        this.cLW.ayI();
        invalidate();
    }

    private void D(float f) {
        if (f >= this.cLX.ayD() && f <= this.cLX.ayE()) {
            this.cLW.setX(f);
            invalidate();
        }
    }

    private void ayC() {
        int b2 = this.cLX.b(this.cLW);
        if (this.mCurrentIndex != b2) {
            this.mCurrentIndex = b2;
            if (this.cLY != null) {
                this.cLY.a(this, this.mCurrentIndex);
            }
        }
        float x = this.cLW.getX();
        float a2 = this.cLX.a(this.cLW);
        if (this.cLV) {
            r(x, a2);
        } else {
            this.cLW.setX(a2);
            invalidate();
        }
        this.cLW.release();
    }

    private void r(float f, float f2) {
        stopAnimation();
        this.mAnimator = ValueAnimator.ofFloat(f, f2);
        this.mAnimator.setDuration(80L);
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.cLW.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.mAnimator.start();
    }

    public SliderBar a(b bVar) {
        this.cLY = bVar;
        return this;
    }

    public SliderBar iK(int i) {
        if (i < 0 || i >= this.cLG) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            if (this.cLW != null && this.cLX != null) {
                this.cLW.setX(getXCoordinate() + (this.cLX.ayF() * this.mCurrentIndex));
                invalidate();
            }
            if (this.cLY != null) {
                this.cLY.a(this, this.mCurrentIndex);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.cLL;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.cLL;
    }

    private float getFontHeight() {
        if (this.cLH == null || this.cLH.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.cLH[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.cLL)) - getPaddingLeft()) - getPaddingRight();
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
        private final float cLu;
        private final float cMc;
        private final float cMd;
        private int cMe;
        private float cMf;
        private float cMg;
        private Paint cMh = new Paint();
        private Paint cMi;
        private Paint mTextPaint;

        a(float f, float f2, float f3) {
            this.cMg = 7.5f;
            this.cLu = f;
            this.cMc = f + f3;
            this.cMd = f2;
            this.cMe = SliderBar.this.cLG - 1;
            this.cMf = f3 / this.cMe;
            this.cMg = SliderBar.this.cLI / 2.0f;
            this.cMh.setColor(SliderBar.this.cLK);
            this.cMh.setStrokeWidth(SliderBar.this.cLJ);
            this.cMh.setAntiAlias(true);
            this.mTextPaint = new Paint();
            this.mTextPaint.setColor(SliderBar.this.mTextColor);
            this.mTextPaint.setTextSize(SliderBar.this.mTextSize);
            this.mTextPaint.setAntiAlias(true);
            this.cMi = new Paint();
            this.cMi.setColor(SliderBar.this.cLQ);
            this.cMi.setTextSize(SliderBar.this.mTextSize);
            this.cMi.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            o(canvas);
            if (SliderBar.this.cMa) {
                p(canvas);
            }
        }

        private void o(Canvas canvas) {
            canvas.drawLine(this.cLu, this.cMd, this.cMc, this.cMd, this.cMh);
        }

        private void p(Canvas canvas) {
            for (int i = 0; i <= this.cMe; i++) {
                float f = this.cLu + (this.cMf * i);
                canvas.drawCircle(f, this.cMd, this.cMg, this.cMh);
                if (SliderBar.this.cLH != null && SliderBar.this.cLH.length > 0) {
                    String str = SliderBar.this.cLH[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.mCurrentIndex) {
                            Paint.FontMetrics fontMetrics = this.cMi.getFontMetrics();
                            canvas.drawText(str, f - (pY(str) / 2.0f), ((this.cMd - SliderBar.this.cLL) - SliderBar.this.cLR) - (fontMetrics.bottom - fontMetrics.descent), this.cMi);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
                            canvas.drawText(str, f - (pY(str) / 2.0f), ((this.cMd - SliderBar.this.cLL) - SliderBar.this.cLR) - (fontMetrics2.bottom - fontMetrics2.descent), this.mTextPaint);
                        }
                    }
                }
            }
        }

        float ayD() {
            return this.cLu;
        }

        float ayE() {
            return this.cMc;
        }

        float ayF() {
            return this.cMf;
        }

        float a(c cVar) {
            return this.cLu + (this.cMf * b(cVar));
        }

        int b(c cVar) {
            return E(cVar.getX());
        }

        int E(float f) {
            return (int) (((f - this.cLu) + (this.cMf / 2.0f)) / this.cMf);
        }

        float pY(String str) {
            return this.mTextPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        private final float cMj;
        private boolean cMk;
        private Paint cMl = new Paint();
        private Paint cMm;
        private Paint cMn;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.cMj = (int) Math.max(50.0f, SliderBar.this.cLL * 2.0f);
            this.cMl.setColor(SliderBar.this.cLM);
            this.cMl.setAntiAlias(true);
            this.cMm = new Paint();
            this.cMm.setColor(SliderBar.this.cLN);
            this.cMm.setAntiAlias(true);
            this.cMn = new Paint();
            this.cMn.setStyle(Paint.Style.STROKE);
            this.cMn.setColor(SliderBar.this.cLO);
            this.cMn.setAntiAlias(true);
            this.cMn.setStrokeWidth(SliderBar.this.cLP);
            if (SliderBar.this.cLT) {
                SliderBar.this.setLayerType(1, this.cMl);
                SliderBar.this.setLayerType(1, this.cMm);
                this.cMl.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.cLU);
                this.cMm.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.cLU);
            }
        }

        void draw(Canvas canvas) {
            if (this.cMk) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.cLL, this.cMm);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.cLL, this.cMl);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.cLL, this.cMn);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float ayG() {
            return this.cMj;
        }

        boolean ayH() {
            return this.cMk;
        }

        void ayI() {
            this.cMk = true;
        }

        void release() {
            this.cMk = false;
        }

        boolean s(float f, float f2) {
            return Math.abs(f - this.mX) <= this.cMj && Math.abs(f2 - this.mY) <= this.cMj;
        }
    }
}
