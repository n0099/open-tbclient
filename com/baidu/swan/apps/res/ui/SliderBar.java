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
    private static final String[] dyx = {"小", "中", "大", "特大"};
    private int bMV;
    private float dyA;
    private float dyB;
    private int dyC;
    private float dyD;
    private int dyE;
    private int dyF;
    private int dyG;
    private int dyH;
    private int dyI;
    private int dyJ;
    private boolean dyK;
    private int dyL;
    private boolean dyM;
    private c dyN;
    private a dyO;
    private b dyP;
    private int dyQ;
    private boolean dyR;
    private ValueAnimator dyk;
    private int dyy;
    private String[] dyz;
    private int mDefaultWidth;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes8.dex */
    public interface b {
        void a(SliderBar sliderBar, int i);
    }

    public SliderBar(Context context) {
        super(context);
        this.dyy = 4;
        this.dyz = dyx;
        this.dyA = 15.0f;
        this.dyB = 3.0f;
        this.dyC = -7829368;
        this.dyD = 30.0f;
        this.dyE = -1;
        this.dyF = -1;
        this.dyG = 1711276032;
        this.dyH = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dyI = -7829368;
        this.dyJ = 50;
        this.mDefaultWidth = 500;
        this.dyK = false;
        this.dyL = -3355444;
        this.dyM = true;
        this.dyQ = -1;
        this.bMV = 0;
        this.dyR = true;
    }

    public SliderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyy = 4;
        this.dyz = dyx;
        this.dyA = 15.0f;
        this.dyB = 3.0f;
        this.dyC = -7829368;
        this.dyD = 30.0f;
        this.dyE = -1;
        this.dyF = -1;
        this.dyG = 1711276032;
        this.dyH = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dyI = -7829368;
        this.dyJ = 50;
        this.mDefaultWidth = 500;
        this.dyK = false;
        this.dyL = -3355444;
        this.dyM = true;
        this.dyQ = -1;
        this.bMV = 0;
        this.dyR = true;
        init(attributeSet);
    }

    public SliderBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dyy = 4;
        this.dyz = dyx;
        this.dyA = 15.0f;
        this.dyB = 3.0f;
        this.dyC = -7829368;
        this.dyD = 30.0f;
        this.dyE = -1;
        this.dyF = -1;
        this.dyG = 1711276032;
        this.dyH = 3;
        this.mTextSize = 40;
        this.mTextColor = -7829368;
        this.dyI = -7829368;
        this.dyJ = 50;
        this.mDefaultWidth = 500;
        this.dyK = false;
        this.dyL = -3355444;
        this.dyM = true;
        this.dyQ = -1;
        this.bMV = 0;
        this.dyR = true;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.SliderBar);
        try {
            this.dyA = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_tickDiameter, 15.0f);
            this.dyB = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barLineWide, 3.0f);
            this.dyC = obtainStyledAttributes.getColor(a.j.SliderBar_barLineColor, -7829368);
            this.dyD = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbRadius, 30.0f);
            this.dyE = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorNormal, -1);
            this.dyF = obtainStyledAttributes.getColor(a.j.SliderBar_thumbColorPressed, -1);
            this.dyG = obtainStyledAttributes.getColor(a.j.SliderBar_thumbCircleColor, 1711276032);
            this.dyH = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_thumbCircleWide, 3.0f);
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextSize, 40.0f);
            this.mTextColor = obtainStyledAttributes.getColor(a.j.SliderBar_barTextColor, -7829368);
            this.dyI = obtainStyledAttributes.getColor(a.j.SliderBar_barChosenTextColor, -7829368);
            this.dyJ = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_barTextPadding, 50.0f);
            this.mDefaultWidth = (int) obtainStyledAttributes.getDimension(a.j.SliderBar_defaultWidth, 500.0f);
            this.bMV = obtainStyledAttributes.getInt(a.j.SliderBar_currentIndex, 0);
            this.dyM = obtainStyledAttributes.getBoolean(a.j.SliderBar_animation, true);
            this.dyK = obtainStyledAttributes.getBoolean(a.j.SliderBar_isShowShadow, false);
            this.dyL = obtainStyledAttributes.getColor(a.j.SliderBar_shadowColor, -3355444);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void init() {
        this.dyO = new a(getXCoordinate(), getYCoordinate(), getBarLineLength());
        this.dyN = new c(getXCoordinate() + (this.dyO.aHe() * this.bMV), getYCoordinate());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int i3 = this.mDefaultWidth;
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
        return (int) ((this.dyD * 2.0f) + this.dyJ + getFontHeight() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        init();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.dyO.draw(canvas);
        this.dyN.draw(canvas);
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
                return M(motionEvent.getX());
            default:
                return true;
        }
    }

    private boolean q(float f, float f2) {
        if (!this.dyN.aHg() && this.dyN.u(f, f2)) {
            aHa();
            return true;
        }
        this.dyQ = s(f, f2);
        return true;
    }

    private boolean M(float f) {
        if (this.dyN.aHg()) {
            N(f);
            return true;
        }
        return true;
    }

    private boolean r(float f, float f2) {
        if (this.dyN.aHg()) {
            aHb();
            return true;
        } else if (this.dyQ == s(f, f2) && this.dyQ != -1) {
            t(this.dyN.getX(), getXCoordinate() + (this.dyQ * this.dyO.aHe()));
            this.bMV = this.dyQ;
            if (this.dyP != null) {
                this.dyP.a(this, this.bMV);
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private int s(float f, float f2) {
        for (int i = 0; i < this.dyy; i++) {
            if (b(f, f2, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean b(float f, float f2, int i) {
        return Math.abs(f - (getXCoordinate() + (this.dyO.aHe() * ((float) i)))) < this.dyN.aHf() && Math.abs(f2 - getYCoordinate()) < this.dyN.aHf() * 2.0f;
    }

    private void aHa() {
        this.dyN.aHh();
        invalidate();
    }

    private void N(float f) {
        if (f >= this.dyO.aHc() && f <= this.dyO.aHd()) {
            this.dyN.setX(f);
            invalidate();
        }
    }

    private void aHb() {
        int b2 = this.dyO.b(this.dyN);
        if (this.bMV != b2) {
            this.bMV = b2;
            if (this.dyP != null) {
                this.dyP.a(this, this.bMV);
            }
        }
        float x = this.dyN.getX();
        float a2 = this.dyO.a(this.dyN);
        if (this.dyM) {
            t(x, a2);
        } else {
            this.dyN.setX(a2);
            invalidate();
        }
        this.dyN.release();
    }

    private void t(float f, float f2) {
        stopAnimation();
        this.dyk = ValueAnimator.ofFloat(f, f2);
        this.dyk.setDuration(80L);
        this.dyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.res.ui.SliderBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SliderBar.this.dyN.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SliderBar.this.invalidate();
            }
        });
        this.dyk.start();
    }

    public SliderBar a(b bVar) {
        this.dyP = bVar;
        return this;
    }

    public SliderBar iD(int i) {
        if (i < 0 || i >= this.dyy) {
            throw new IllegalArgumentException("A thumb index is out of bounds");
        }
        if (this.bMV != i) {
            this.bMV = i;
            if (this.dyN != null && this.dyO != null) {
                this.dyN.setX(getXCoordinate() + (this.dyO.aHe() * this.bMV));
                invalidate();
            }
            if (this.dyP != null) {
                this.dyP.a(this, this.bMV);
            }
        }
        return this;
    }

    public int getCurrentIndex() {
        return this.bMV;
    }

    private float getXCoordinate() {
        return getPaddingLeft() + this.dyD;
    }

    private float getYCoordinate() {
        return ((getHeight() - getPaddingBottom()) - ((getHeight() - getMinHeight()) / 2.0f)) - this.dyD;
    }

    private float getFontHeight() {
        if (this.dyz == null || this.dyz.length == 0) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(this.mTextSize);
        paint.measureText(this.dyz[0]);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    private float getBarLineLength() {
        return ((getWidth() - (2.0f * this.dyD)) - getPaddingLeft()) - getPaddingRight();
    }

    private boolean isAnimationRunning() {
        return this.dyk != null && this.dyk.isRunning();
    }

    private void stopAnimation() {
        if (this.dyk != null) {
            this.dyk.cancel();
            this.dyk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        private Paint bjh;
        private final float dxQ;
        private final float dyT;
        private final float dyU;
        private int dyV;
        private float dyW;
        private float dyX;
        private Paint dyY = new Paint();
        private Paint dyZ;

        a(float f, float f2, float f3) {
            this.dyX = 7.5f;
            this.dxQ = f;
            this.dyT = f + f3;
            this.dyU = f2;
            this.dyV = SliderBar.this.dyy - 1;
            this.dyW = f3 / this.dyV;
            this.dyX = SliderBar.this.dyA / 2.0f;
            this.dyY.setColor(SliderBar.this.dyC);
            this.dyY.setStrokeWidth(SliderBar.this.dyB);
            this.dyY.setAntiAlias(true);
            this.bjh = new Paint();
            this.bjh.setColor(SliderBar.this.mTextColor);
            this.bjh.setTextSize(SliderBar.this.mTextSize);
            this.bjh.setAntiAlias(true);
            this.dyZ = new Paint();
            this.dyZ.setColor(SliderBar.this.dyI);
            this.dyZ.setTextSize(SliderBar.this.mTextSize);
            this.dyZ.setAntiAlias(true);
        }

        void draw(Canvas canvas) {
            v(canvas);
            if (SliderBar.this.dyR) {
                w(canvas);
            }
        }

        private void v(Canvas canvas) {
            canvas.drawLine(this.dxQ, this.dyU, this.dyT, this.dyU, this.dyY);
        }

        private void w(Canvas canvas) {
            for (int i = 0; i <= this.dyV; i++) {
                float f = this.dxQ + (this.dyW * i);
                canvas.drawCircle(f, this.dyU, this.dyX, this.dyY);
                if (SliderBar.this.dyz != null && SliderBar.this.dyz.length > 0) {
                    String str = SliderBar.this.dyz[i];
                    if (!TextUtils.isEmpty(str)) {
                        if (i == SliderBar.this.bMV) {
                            Paint.FontMetrics fontMetrics = this.dyZ.getFontMetrics();
                            canvas.drawText(str, f - (ru(str) / 2.0f), ((this.dyU - SliderBar.this.dyD) - SliderBar.this.dyJ) - (fontMetrics.bottom - fontMetrics.descent), this.dyZ);
                        } else {
                            Paint.FontMetrics fontMetrics2 = this.bjh.getFontMetrics();
                            canvas.drawText(str, f - (ru(str) / 2.0f), ((this.dyU - SliderBar.this.dyD) - SliderBar.this.dyJ) - (fontMetrics2.bottom - fontMetrics2.descent), this.bjh);
                        }
                    }
                }
            }
        }

        float aHc() {
            return this.dxQ;
        }

        float aHd() {
            return this.dyT;
        }

        float aHe() {
            return this.dyW;
        }

        float a(c cVar) {
            return this.dxQ + (this.dyW * b(cVar));
        }

        int b(c cVar) {
            return O(cVar.getX());
        }

        int O(float f) {
            return (int) (((f - this.dxQ) + (this.dyW / 2.0f)) / this.dyW);
        }

        float ru(String str) {
            return this.bjh.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        private final float dza;
        private boolean dzb;
        private Paint dzc = new Paint();
        private Paint dzd;
        private Paint dze;
        private float mX;
        private final float mY;

        c(float f, float f2) {
            this.mX = f;
            this.mY = f2;
            this.dza = (int) Math.max(50.0f, SliderBar.this.dyD * 2.0f);
            this.dzc.setColor(SliderBar.this.dyE);
            this.dzc.setAntiAlias(true);
            this.dzd = new Paint();
            this.dzd.setColor(SliderBar.this.dyF);
            this.dzd.setAntiAlias(true);
            this.dze = new Paint();
            this.dze.setStyle(Paint.Style.STROKE);
            this.dze.setColor(SliderBar.this.dyG);
            this.dze.setAntiAlias(true);
            this.dze.setStrokeWidth(SliderBar.this.dyH);
            if (SliderBar.this.dyK) {
                SliderBar.this.setLayerType(1, this.dzc);
                SliderBar.this.setLayerType(1, this.dzd);
                this.dzc.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dyL);
                this.dzd.setShadowLayer(3.0f, 0.0f, 3.0f, SliderBar.this.dyL);
            }
        }

        void draw(Canvas canvas) {
            if (this.dzb) {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dyD, this.dzd);
            } else {
                canvas.drawCircle(this.mX, this.mY, SliderBar.this.dyD, this.dzc);
            }
            canvas.drawCircle(this.mX, this.mY, SliderBar.this.dyD, this.dze);
        }

        void setX(float f) {
            this.mX = f;
        }

        float getX() {
            return this.mX;
        }

        float aHf() {
            return this.dza;
        }

        boolean aHg() {
            return this.dzb;
        }

        void aHh() {
            this.dzb = true;
        }

        void release() {
            this.dzb = false;
        }

        boolean u(float f, float f2) {
            return Math.abs(f - this.mX) <= this.dza && Math.abs(f2 - this.mY) <= this.dza;
        }
    }
}
