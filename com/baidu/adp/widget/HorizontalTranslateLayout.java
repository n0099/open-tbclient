package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int xA;
    private boolean xB;
    private final a xC;
    private final b xD;
    private final g xE;
    private d xF;
    private f xG;
    private final List<e> xH;
    private c xI;
    private int xk;
    private float xn;
    private float xo;
    private int xp;
    private final int xq;
    private boolean xr;
    private boolean xs;
    private TrackDirection xt;
    private int xu;
    private final Rect xv;
    private final Rect xw;
    private final Paint xx;
    private int xy;
    private int xz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (xR) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TrackDirection[] valuesCustom() {
            TrackDirection[] valuesCustom = values();
            int length = valuesCustom.length;
            TrackDirection[] trackDirectionArr = new TrackDirection[length];
            System.arraycopy(valuesCustom, 0, trackDirectionArr, 0, length);
            return trackDirectionArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void ar(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void iO();

        void iP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void iQ();

        void iR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void iS();

        void iT();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.xx.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.xp = (int) ((this.xn - this.xk) * (-f2));
            } else if (f2 > 0.0f) {
                this.xp = (int) ((this.xk - this.xo) * f2);
            } else if (f2 == 0.0f) {
                this.xp = 0;
                this.xu = 10004;
            } else if (f2 == -1.0f) {
                this.xn -= getMeasuredWidth();
                this.xu = 10000;
            } else if (f2 == 1.0f) {
                this.xn = getMeasuredWidth() - this.xo;
                this.xu = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.xn;
    }

    public int getRightOffset() {
        return (int) this.xo;
    }

    public void setLeftTapBack(boolean z) {
        this.xr = z;
    }

    public void setRightTapBack(boolean z) {
        this.xs = z;
    }

    public int getState() {
        return this.xu;
    }

    public void setLeftAnimationListener(d dVar) {
        this.xF = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.xG = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.xI = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.xp, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.xp);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.xx);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.xp;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.xt == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.xu == 10004) {
            switch (action) {
                case 0:
                    this.xy = x;
                    this.xz = y;
                    this.xC.removeMessages(-100);
                    this.xC.removeMessages(-104);
                    this.xC.removeMessages(-101);
                    this.xC.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.xp, 0.0f);
                    return h(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.xz - this.xq && i2 <= this.xz + this.xq && (i < this.xy - this.xq || i > this.xy + this.xq) && this.xE.as(i - this.xy);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.xu == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.xB = false;
                    if (this.xE.xT) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.xE.iU();
                        this.xE.iV();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.xE.xT) {
                        if (!this.xB) {
                            if (x > this.xy) {
                                this.xA = this.xy + this.xq;
                                this.xB = true;
                            } else {
                                this.xA = this.xy - this.xq;
                                this.xB = true;
                            }
                        }
                        this.xE.at(this.xA - x);
                        this.xA = x;
                        this.xE.xS.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.xv);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.xw);
        switch (action) {
            case 0:
                if ((this.xu != 10000 || !this.xv.contains(x, y)) && (this.xu != 10001 || !this.xw.contains(x, y))) {
                    return false;
                }
                if (!this.xE.xT) {
                    this.xA = x;
                    this.xE.as(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.xE.xT) {
                    this.xE.iU();
                    this.xE.iV();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.xE.xT) {
            this.xE.at(this.xA - x);
            this.xA = x;
            this.xE.xS.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.xn != -1.0f) {
                this.xv.set(i, i2, (int) (i + this.xn), i4);
            }
            if (this.xo != -1.0f) {
                this.xw.set((int) (i3 - this.xo), i2, i3, i4);
            }
        }
        if (!this.xD.xQ && !this.xE.xT) {
            iI();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.xn) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.xo) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.xk = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI() {
        switch (this.xu) {
            case 10000:
                this.xp = (int) (this.xn - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.xp = (int) (getMeasuredWidth() - this.xo);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.xp = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout xJ;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.xJ.xD.xQ) {
                switch (message.what) {
                    case -105:
                        this.xJ.xD.iN();
                        return;
                    case -104:
                        this.xJ.xD.iM();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.xJ.xD.iL();
                        return;
                    case -100:
                        this.xJ.xD.iK();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] xW;
        final /* synthetic */ HorizontalTranslateLayout xJ;
        VelocityTracker xS;
        boolean xT;
        final int xU;
        final int xV;

        static /* synthetic */ int[] iW() {
            int[] iArr = xW;
            if (iArr == null) {
                iArr = new int[TrackDirection.valuesCustom().length];
                try {
                    iArr[TrackDirection.horizontal.ordinal()] = 3;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[TrackDirection.left.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[TrackDirection.none.ordinal()] = 4;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[TrackDirection.right.ordinal()] = 2;
                } catch (NoSuchFieldError e4) {
                }
                xW = iArr;
            }
            return iArr;
        }

        boolean as(int i) {
            switch (iW()[this.xJ.xt.ordinal()]) {
                case 1:
                    if (this.xJ.xu != 10004 && this.xJ.xu != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.xJ.xu != 10004 && this.xJ.xu != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.xJ.xI != null) {
                        this.xJ.xI.ar(i);
                        break;
                    }
                    break;
            }
            this.xS = VelocityTracker.obtain();
            this.xT = true;
            return true;
        }

        void iU() {
            this.xT = false;
        }

        void at(int i) {
            if (this.xT) {
                int i2 = this.xJ.xp - i;
                switch (iW()[this.xJ.xt.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.xJ.xn - this.xJ.getMeasuredWidth() && i2 < 0) {
                            this.xJ.xp -= i;
                            this.xJ.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.xJ.getMeasuredWidth() - this.xJ.xo && i2 > 0) {
                            this.xJ.xp -= i;
                            this.xJ.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.xJ.xn - this.xJ.getMeasuredWidth() && i2 <= this.xJ.getMeasuredWidth() - this.xJ.xo) {
                            this.xJ.xp -= i;
                            this.xJ.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iV() {
            float max;
            this.xS.computeCurrentVelocity(this.xU);
            float xVelocity = this.xS.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.xV);
            } else {
                max = Math.max(xVelocity, this.xV);
            }
            switch (iW()[this.xJ.xt.ordinal()]) {
                case 1:
                    r(max);
                    break;
                case 2:
                    s(max);
                    break;
                case 3:
                    q(max);
                    break;
            }
            this.xS.recycle();
            this.xS = null;
        }

        private void q(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.xJ.xp;
            if (i <= 0 && i >= this.xJ.xn - this.xJ.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.xJ.xD.o(f);
                } else {
                    this.xJ.xD.m(f);
                }
            } else if (i >= 0 && i <= this.xJ.getMeasuredWidth() - this.xJ.xo) {
                if (f < 0.0f) {
                    this.xJ.xD.n(f);
                } else {
                    this.xJ.xD.p(f);
                }
            }
        }

        private void r(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.xJ.xD.o(f);
            } else {
                this.xJ.xD.m(f);
            }
        }

        private void s(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.xJ.xD.n(f);
            } else {
                this.xJ.xD.p(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout xJ;
        float xK;
        float xL;
        float xM;
        float xN;
        long xO;
        long xP;
        boolean xQ;

        private void iJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xK = ((((float) (uptimeMillis - this.xO)) / 1000.0f) * this.xL) + this.xK;
            this.xO = uptimeMillis;
            this.xP += 16;
        }

        void iK() {
            iJ();
            if (this.xK <= this.xM) {
                d dVar = this.xJ.xF;
                if (dVar != null) {
                    dVar.iP();
                }
                this.xQ = false;
                this.xJ.xu = 10000;
                this.xJ.iI();
                return;
            }
            this.xJ.xp = (int) (com.baidu.adp.widget.g.a(this.xM, this.xK, false) + this.xN);
            this.xJ.invalidate();
            this.xJ.xC.sendEmptyMessageAtTime(-100, this.xP);
        }

        void iL() {
            iJ();
            if (this.xK >= this.xM) {
                f fVar = this.xJ.xG;
                if (fVar != null) {
                    fVar.iT();
                }
                this.xQ = false;
                this.xJ.xu = 10001;
                this.xJ.iI();
                return;
            }
            this.xJ.xp = (int) (com.baidu.adp.widget.g.a(this.xM, this.xK, false) + this.xN);
            this.xJ.invalidate();
            this.xJ.xC.sendEmptyMessageAtTime(-101, this.xP);
        }

        void iM() {
            iJ();
            if (this.xK >= this.xM) {
                for (e eVar : this.xJ.xH) {
                    if (eVar != null) {
                        eVar.iR();
                    }
                }
                this.xQ = false;
                this.xJ.xu = 10004;
                this.xJ.iI();
                return;
            }
            this.xJ.xp = (int) (com.baidu.adp.widget.g.a(this.xM, this.xK, false) + this.xN);
            this.xJ.invalidate();
            this.xJ.xC.sendEmptyMessageAtTime(-104, this.xP);
        }

        void iN() {
            iJ();
            if (this.xK <= this.xM) {
                for (e eVar : this.xJ.xH) {
                    if (eVar != null) {
                        eVar.iR();
                    }
                }
                this.xQ = false;
                this.xJ.xu = 10004;
                this.xJ.iI();
                return;
            }
            this.xJ.xp = (int) (com.baidu.adp.widget.g.a(this.xM, this.xK, false) + this.xN);
            this.xJ.invalidate();
            this.xJ.xC.sendEmptyMessageAtTime(-105, this.xP);
        }

        void m(float f) {
            for (e eVar : this.xJ.xH) {
                if (eVar != null) {
                    eVar.iQ();
                }
            }
            this.xQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xO = uptimeMillis;
            this.xP = uptimeMillis + 16;
            this.xL = f;
            this.xK = 0.0f;
            this.xM = 0 - this.xJ.xp;
            this.xN = this.xJ.xp;
            this.xJ.xC.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.xM);
            Log.d("Animator", "@animateTopOpen " + f);
            this.xJ.xC.sendEmptyMessageAtTime(-104, this.xP);
        }

        void n(float f) {
            for (e eVar : this.xJ.xH) {
                if (eVar != null) {
                    eVar.iQ();
                }
            }
            this.xQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xO = uptimeMillis;
            this.xP = uptimeMillis + 16;
            this.xL = f;
            this.xK = 0.0f;
            this.xM = 0 - this.xJ.xp;
            this.xN = this.xJ.xp;
            Log.d("Animator", "@animateBottomOpen " + this.xM);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.xJ.xC.removeMessages(-105);
            this.xJ.xC.sendEmptyMessageAtTime(-105, this.xP);
        }

        void o(float f) {
            d dVar = this.xJ.xF;
            if (dVar != null) {
                dVar.iO();
            }
            this.xQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xO = uptimeMillis;
            this.xP = uptimeMillis + 16;
            this.xL = f;
            this.xK = 0.0f;
            this.xM = ((-this.xJ.getMeasuredWidth()) + this.xJ.xn) - this.xJ.xp;
            this.xN = this.xJ.xp;
            Log.d("Animator", "@animateTop " + this.xM);
            Log.d("Animator", "@animateTop " + f);
            this.xJ.xC.removeMessages(-100);
            this.xJ.xC.sendEmptyMessageAtTime(-100, this.xP);
        }

        void p(float f) {
            f fVar = this.xJ.xG;
            if (fVar != null) {
                fVar.iS();
            }
            this.xQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xO = uptimeMillis;
            this.xP = uptimeMillis + 16;
            this.xL = f;
            this.xK = 0.0f;
            this.xM = (this.xJ.getMeasuredWidth() - this.xJ.xo) - this.xJ.xp;
            this.xN = this.xJ.xp;
            Log.d("Animator", "@animateBottom " + this.xM);
            Log.d("Animator", "@animateBottom " + f);
            this.xJ.xC.removeMessages(-101);
            this.xJ.xC.sendEmptyMessageAtTime(-101, this.xP);
        }
    }
}
