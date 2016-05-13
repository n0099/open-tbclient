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
    private int wH;
    private float wK;
    private float wL;
    private int wM;
    private final int wN;
    private boolean wO;
    private boolean wP;
    private TrackDirection wQ;
    private int wR;
    private final Rect wS;
    private final Rect wT;
    private final Paint wU;
    private int wV;
    private int wW;
    private int wX;
    private boolean wY;
    private final a wZ;
    private final b xa;
    private final g xb;
    private d xc;
    private f xd;
    private final List<e> xe;
    private c xf;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (xo) with 'values()' method */
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
        void an(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void iM();

        void iN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void iO();

        void iP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void iQ();

        void iR();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.wU.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.wM = (int) ((this.wK - this.wH) * (-f2));
            } else if (f2 > 0.0f) {
                this.wM = (int) ((this.wH - this.wL) * f2);
            } else if (f2 == 0.0f) {
                this.wM = 0;
                this.wR = 10004;
            } else if (f2 == -1.0f) {
                this.wK -= getMeasuredWidth();
                this.wR = 10000;
            } else if (f2 == 1.0f) {
                this.wK = getMeasuredWidth() - this.wL;
                this.wR = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.wK;
    }

    public int getRightOffset() {
        return (int) this.wL;
    }

    public void setLeftTapBack(boolean z) {
        this.wO = z;
    }

    public void setRightTapBack(boolean z) {
        this.wP = z;
    }

    public int getState() {
        return this.wR;
    }

    public void setLeftAnimationListener(d dVar) {
        this.xc = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.xd = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.xf = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.wM, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.wM);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.wU);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.wM;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.wQ == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.wR == 10004) {
            switch (action) {
                case 0:
                    this.wV = x;
                    this.wW = y;
                    this.wZ.removeMessages(-100);
                    this.wZ.removeMessages(-104);
                    this.wZ.removeMessages(-101);
                    this.wZ.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.wM, 0.0f);
                    return h(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.wW - this.wN && i2 <= this.wW + this.wN && (i < this.wV - this.wN || i > this.wV + this.wN) && this.xb.ao(i - this.wV);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.wR == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.wY = false;
                    if (this.xb.xq) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.xb.iS();
                        this.xb.iT();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.xb.xq) {
                        if (!this.wY) {
                            if (x > this.wV) {
                                this.wX = this.wV + this.wN;
                                this.wY = true;
                            } else {
                                this.wX = this.wV - this.wN;
                                this.wY = true;
                            }
                        }
                        this.xb.ap(this.wX - x);
                        this.wX = x;
                        this.xb.xp.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.wS);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.wT);
        switch (action) {
            case 0:
                if ((this.wR != 10000 || !this.wS.contains(x, y)) && (this.wR != 10001 || !this.wT.contains(x, y))) {
                    return false;
                }
                if (!this.xb.xq) {
                    this.wX = x;
                    this.xb.ao(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.xb.xq) {
                    this.xb.iS();
                    this.xb.iT();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.xb.xq) {
            this.xb.ap(this.wX - x);
            this.wX = x;
            this.xb.xp.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.wK != -1.0f) {
                this.wS.set(i, i2, (int) (i + this.wK), i4);
            }
            if (this.wL != -1.0f) {
                this.wT.set((int) (i3 - this.wL), i2, i3, i4);
            }
        }
        if (!this.xa.xn && !this.xb.xq) {
            iG();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.wK) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.wL) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.wH = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iG() {
        switch (this.wR) {
            case 10000:
                this.wM = (int) (this.wK - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.wM = (int) (getMeasuredWidth() - this.wL);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.wM = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout xg;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.xg.xa.xn) {
                switch (message.what) {
                    case -105:
                        this.xg.xa.iL();
                        return;
                    case -104:
                        this.xg.xa.iK();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.xg.xa.iJ();
                        return;
                    case -100:
                        this.xg.xa.iI();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] xt;
        final /* synthetic */ HorizontalTranslateLayout xg;
        VelocityTracker xp;
        boolean xq;
        final int xr;
        final int xs;

        static /* synthetic */ int[] iU() {
            int[] iArr = xt;
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
                xt = iArr;
            }
            return iArr;
        }

        boolean ao(int i) {
            switch (iU()[this.xg.wQ.ordinal()]) {
                case 1:
                    if (this.xg.wR != 10004 && this.xg.wR != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.xg.wR != 10004 && this.xg.wR != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.xg.xf != null) {
                        this.xg.xf.an(i);
                        break;
                    }
                    break;
            }
            this.xp = VelocityTracker.obtain();
            this.xq = true;
            return true;
        }

        void iS() {
            this.xq = false;
        }

        void ap(int i) {
            if (this.xq) {
                int i2 = this.xg.wM - i;
                switch (iU()[this.xg.wQ.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.xg.wK - this.xg.getMeasuredWidth() && i2 < 0) {
                            this.xg.wM -= i;
                            this.xg.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.xg.getMeasuredWidth() - this.xg.wL && i2 > 0) {
                            this.xg.wM -= i;
                            this.xg.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.xg.wK - this.xg.getMeasuredWidth() && i2 <= this.xg.getMeasuredWidth() - this.xg.wL) {
                            this.xg.wM -= i;
                            this.xg.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iT() {
            float max;
            this.xp.computeCurrentVelocity(this.xr);
            float xVelocity = this.xp.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.xs);
            } else {
                max = Math.max(xVelocity, this.xs);
            }
            switch (iU()[this.xg.wQ.ordinal()]) {
                case 1:
                    h(max);
                    break;
                case 2:
                    i(max);
                    break;
                case 3:
                    g(max);
                    break;
            }
            this.xp.recycle();
            this.xp = null;
        }

        private void g(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.xg.wM;
            if (i <= 0 && i >= this.xg.wK - this.xg.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.xg.xa.e(f);
                } else {
                    this.xg.xa.c(f);
                }
            } else if (i >= 0 && i <= this.xg.getMeasuredWidth() - this.xg.wL) {
                if (f < 0.0f) {
                    this.xg.xa.d(f);
                } else {
                    this.xg.xa.f(f);
                }
            }
        }

        private void h(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.xg.xa.e(f);
            } else {
                this.xg.xa.c(f);
            }
        }

        private void i(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.xg.xa.d(f);
            } else {
                this.xg.xa.f(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout xg;
        float xh;
        float xi;
        float xj;
        float xk;
        long xl;
        long xm;
        boolean xn;

        private void iH() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xh = ((((float) (uptimeMillis - this.xl)) / 1000.0f) * this.xi) + this.xh;
            this.xl = uptimeMillis;
            this.xm += 16;
        }

        void iI() {
            iH();
            if (this.xh <= this.xj) {
                d dVar = this.xg.xc;
                if (dVar != null) {
                    dVar.iN();
                }
                this.xn = false;
                this.xg.wR = 10000;
                this.xg.iG();
                return;
            }
            this.xg.wM = (int) (com.baidu.adp.widget.g.a(this.xj, this.xh, false) + this.xk);
            this.xg.invalidate();
            this.xg.wZ.sendEmptyMessageAtTime(-100, this.xm);
        }

        void iJ() {
            iH();
            if (this.xh >= this.xj) {
                f fVar = this.xg.xd;
                if (fVar != null) {
                    fVar.iR();
                }
                this.xn = false;
                this.xg.wR = 10001;
                this.xg.iG();
                return;
            }
            this.xg.wM = (int) (com.baidu.adp.widget.g.a(this.xj, this.xh, false) + this.xk);
            this.xg.invalidate();
            this.xg.wZ.sendEmptyMessageAtTime(-101, this.xm);
        }

        void iK() {
            iH();
            if (this.xh >= this.xj) {
                for (e eVar : this.xg.xe) {
                    if (eVar != null) {
                        eVar.iP();
                    }
                }
                this.xn = false;
                this.xg.wR = 10004;
                this.xg.iG();
                return;
            }
            this.xg.wM = (int) (com.baidu.adp.widget.g.a(this.xj, this.xh, false) + this.xk);
            this.xg.invalidate();
            this.xg.wZ.sendEmptyMessageAtTime(-104, this.xm);
        }

        void iL() {
            iH();
            if (this.xh <= this.xj) {
                for (e eVar : this.xg.xe) {
                    if (eVar != null) {
                        eVar.iP();
                    }
                }
                this.xn = false;
                this.xg.wR = 10004;
                this.xg.iG();
                return;
            }
            this.xg.wM = (int) (com.baidu.adp.widget.g.a(this.xj, this.xh, false) + this.xk);
            this.xg.invalidate();
            this.xg.wZ.sendEmptyMessageAtTime(-105, this.xm);
        }

        void c(float f) {
            for (e eVar : this.xg.xe) {
                if (eVar != null) {
                    eVar.iO();
                }
            }
            this.xn = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xl = uptimeMillis;
            this.xm = uptimeMillis + 16;
            this.xi = f;
            this.xh = 0.0f;
            this.xj = 0 - this.xg.wM;
            this.xk = this.xg.wM;
            this.xg.wZ.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.xj);
            Log.d("Animator", "@animateTopOpen " + f);
            this.xg.wZ.sendEmptyMessageAtTime(-104, this.xm);
        }

        void d(float f) {
            for (e eVar : this.xg.xe) {
                if (eVar != null) {
                    eVar.iO();
                }
            }
            this.xn = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xl = uptimeMillis;
            this.xm = uptimeMillis + 16;
            this.xi = f;
            this.xh = 0.0f;
            this.xj = 0 - this.xg.wM;
            this.xk = this.xg.wM;
            Log.d("Animator", "@animateBottomOpen " + this.xj);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.xg.wZ.removeMessages(-105);
            this.xg.wZ.sendEmptyMessageAtTime(-105, this.xm);
        }

        void e(float f) {
            d dVar = this.xg.xc;
            if (dVar != null) {
                dVar.iM();
            }
            this.xn = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xl = uptimeMillis;
            this.xm = uptimeMillis + 16;
            this.xi = f;
            this.xh = 0.0f;
            this.xj = ((-this.xg.getMeasuredWidth()) + this.xg.wK) - this.xg.wM;
            this.xk = this.xg.wM;
            Log.d("Animator", "@animateTop " + this.xj);
            Log.d("Animator", "@animateTop " + f);
            this.xg.wZ.removeMessages(-100);
            this.xg.wZ.sendEmptyMessageAtTime(-100, this.xm);
        }

        void f(float f) {
            f fVar = this.xg.xd;
            if (fVar != null) {
                fVar.iQ();
            }
            this.xn = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xl = uptimeMillis;
            this.xm = uptimeMillis + 16;
            this.xi = f;
            this.xh = 0.0f;
            this.xj = (this.xg.getMeasuredWidth() - this.xg.wL) - this.xg.wM;
            this.xk = this.xg.wM;
            Log.d("Animator", "@animateBottom " + this.xj);
            Log.d("Animator", "@animateBottom " + f);
            this.xg.wZ.removeMessages(-101);
            this.xg.wZ.sendEmptyMessageAtTime(-101, this.xm);
        }
    }
}
