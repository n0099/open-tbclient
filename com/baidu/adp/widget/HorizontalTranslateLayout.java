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
    private int wJ;
    private float wM;
    private float wN;
    private int wO;
    private final int wP;
    private boolean wQ;
    private boolean wR;
    private TrackDirection wS;
    private int wT;
    private final Rect wU;
    private final Rect wV;
    private final Paint wW;
    private int wX;
    private int wY;
    private int wZ;
    private boolean xa;
    private final a xb;
    private final b xc;
    private final g xd;
    private d xe;
    private f xf;
    private final List<e> xg;
    private c xh;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (xq) with 'values()' method */
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
        void ao(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void iP();

        void iQ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void iR();

        void iS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void iT();

        void iU();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.wW.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.wO = (int) ((this.wM - this.wJ) * (-f2));
            } else if (f2 > 0.0f) {
                this.wO = (int) ((this.wJ - this.wN) * f2);
            } else if (f2 == 0.0f) {
                this.wO = 0;
                this.wT = 10004;
            } else if (f2 == -1.0f) {
                this.wM -= getMeasuredWidth();
                this.wT = 10000;
            } else if (f2 == 1.0f) {
                this.wM = getMeasuredWidth() - this.wN;
                this.wT = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.wM;
    }

    public int getRightOffset() {
        return (int) this.wN;
    }

    public void setLeftTapBack(boolean z) {
        this.wQ = z;
    }

    public void setRightTapBack(boolean z) {
        this.wR = z;
    }

    public int getState() {
        return this.wT;
    }

    public void setLeftAnimationListener(d dVar) {
        this.xe = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.xf = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.xh = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.wO, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.wO);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.wW);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.wO;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.wS == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.wT == 10004) {
            switch (action) {
                case 0:
                    this.wX = x;
                    this.wY = y;
                    this.xb.removeMessages(-100);
                    this.xb.removeMessages(-104);
                    this.xb.removeMessages(-101);
                    this.xb.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.wO, 0.0f);
                    return h(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.wY - this.wP && i2 <= this.wY + this.wP && (i < this.wX - this.wP || i > this.wX + this.wP) && this.xd.ap(i - this.wX);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.wT == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.xa = false;
                    if (this.xd.xs) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.xd.iV();
                        this.xd.iW();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.xd.xs) {
                        if (!this.xa) {
                            if (x > this.wX) {
                                this.wZ = this.wX + this.wP;
                                this.xa = true;
                            } else {
                                this.wZ = this.wX - this.wP;
                                this.xa = true;
                            }
                        }
                        this.xd.aq(this.wZ - x);
                        this.wZ = x;
                        this.xd.xr.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.wU);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.wV);
        switch (action) {
            case 0:
                if ((this.wT != 10000 || !this.wU.contains(x, y)) && (this.wT != 10001 || !this.wV.contains(x, y))) {
                    return false;
                }
                if (!this.xd.xs) {
                    this.wZ = x;
                    this.xd.ap(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.xd.xs) {
                    this.xd.iV();
                    this.xd.iW();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.xd.xs) {
            this.xd.aq(this.wZ - x);
            this.wZ = x;
            this.xd.xr.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.wM != -1.0f) {
                this.wU.set(i, i2, (int) (i + this.wM), i4);
            }
            if (this.wN != -1.0f) {
                this.wV.set((int) (i3 - this.wN), i2, i3, i4);
            }
        }
        if (!this.xc.xp && !this.xd.xs) {
            iJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.wM) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.wN) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.wJ = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ() {
        switch (this.wT) {
            case 10000:
                this.wO = (int) (this.wM - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.wO = (int) (getMeasuredWidth() - this.wN);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.wO = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout xi;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.xi.xc.xp) {
                switch (message.what) {
                    case -105:
                        this.xi.xc.iO();
                        return;
                    case -104:
                        this.xi.xc.iN();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.xi.xc.iM();
                        return;
                    case -100:
                        this.xi.xc.iL();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] xv;
        final /* synthetic */ HorizontalTranslateLayout xi;
        VelocityTracker xr;
        boolean xs;
        final int xt;
        final int xu;

        static /* synthetic */ int[] iX() {
            int[] iArr = xv;
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
                xv = iArr;
            }
            return iArr;
        }

        boolean ap(int i) {
            switch (iX()[this.xi.wS.ordinal()]) {
                case 1:
                    if (this.xi.wT != 10004 && this.xi.wT != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.xi.wT != 10004 && this.xi.wT != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.xi.xh != null) {
                        this.xi.xh.ao(i);
                        break;
                    }
                    break;
            }
            this.xr = VelocityTracker.obtain();
            this.xs = true;
            return true;
        }

        void iV() {
            this.xs = false;
        }

        void aq(int i) {
            if (this.xs) {
                int i2 = this.xi.wO - i;
                switch (iX()[this.xi.wS.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.xi.wM - this.xi.getMeasuredWidth() && i2 < 0) {
                            this.xi.wO -= i;
                            this.xi.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.xi.getMeasuredWidth() - this.xi.wN && i2 > 0) {
                            this.xi.wO -= i;
                            this.xi.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.xi.wM - this.xi.getMeasuredWidth() && i2 <= this.xi.getMeasuredWidth() - this.xi.wN) {
                            this.xi.wO -= i;
                            this.xi.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iW() {
            float max;
            this.xr.computeCurrentVelocity(this.xt);
            float xVelocity = this.xr.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.xu);
            } else {
                max = Math.max(xVelocity, this.xu);
            }
            switch (iX()[this.xi.wS.ordinal()]) {
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
            this.xr.recycle();
            this.xr = null;
        }

        private void g(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.xi.wO;
            if (i <= 0 && i >= this.xi.wM - this.xi.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.xi.xc.e(f);
                } else {
                    this.xi.xc.c(f);
                }
            } else if (i >= 0 && i <= this.xi.getMeasuredWidth() - this.xi.wN) {
                if (f < 0.0f) {
                    this.xi.xc.d(f);
                } else {
                    this.xi.xc.f(f);
                }
            }
        }

        private void h(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.xi.xc.e(f);
            } else {
                this.xi.xc.c(f);
            }
        }

        private void i(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.xi.xc.d(f);
            } else {
                this.xi.xc.f(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout xi;
        float xj;
        float xk;
        float xl;
        float xm;
        long xn;
        long xo;
        boolean xp;

        private void iK() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xj = ((((float) (uptimeMillis - this.xn)) / 1000.0f) * this.xk) + this.xj;
            this.xn = uptimeMillis;
            this.xo += 16;
        }

        void iL() {
            iK();
            if (this.xj <= this.xl) {
                d dVar = this.xi.xe;
                if (dVar != null) {
                    dVar.iQ();
                }
                this.xp = false;
                this.xi.wT = 10000;
                this.xi.iJ();
                return;
            }
            this.xi.wO = (int) (com.baidu.adp.widget.g.a(this.xl, this.xj, false) + this.xm);
            this.xi.invalidate();
            this.xi.xb.sendEmptyMessageAtTime(-100, this.xo);
        }

        void iM() {
            iK();
            if (this.xj >= this.xl) {
                f fVar = this.xi.xf;
                if (fVar != null) {
                    fVar.iU();
                }
                this.xp = false;
                this.xi.wT = 10001;
                this.xi.iJ();
                return;
            }
            this.xi.wO = (int) (com.baidu.adp.widget.g.a(this.xl, this.xj, false) + this.xm);
            this.xi.invalidate();
            this.xi.xb.sendEmptyMessageAtTime(-101, this.xo);
        }

        void iN() {
            iK();
            if (this.xj >= this.xl) {
                for (e eVar : this.xi.xg) {
                    if (eVar != null) {
                        eVar.iS();
                    }
                }
                this.xp = false;
                this.xi.wT = 10004;
                this.xi.iJ();
                return;
            }
            this.xi.wO = (int) (com.baidu.adp.widget.g.a(this.xl, this.xj, false) + this.xm);
            this.xi.invalidate();
            this.xi.xb.sendEmptyMessageAtTime(-104, this.xo);
        }

        void iO() {
            iK();
            if (this.xj <= this.xl) {
                for (e eVar : this.xi.xg) {
                    if (eVar != null) {
                        eVar.iS();
                    }
                }
                this.xp = false;
                this.xi.wT = 10004;
                this.xi.iJ();
                return;
            }
            this.xi.wO = (int) (com.baidu.adp.widget.g.a(this.xl, this.xj, false) + this.xm);
            this.xi.invalidate();
            this.xi.xb.sendEmptyMessageAtTime(-105, this.xo);
        }

        void c(float f) {
            for (e eVar : this.xi.xg) {
                if (eVar != null) {
                    eVar.iR();
                }
            }
            this.xp = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xn = uptimeMillis;
            this.xo = uptimeMillis + 16;
            this.xk = f;
            this.xj = 0.0f;
            this.xl = 0 - this.xi.wO;
            this.xm = this.xi.wO;
            this.xi.xb.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.xl);
            Log.d("Animator", "@animateTopOpen " + f);
            this.xi.xb.sendEmptyMessageAtTime(-104, this.xo);
        }

        void d(float f) {
            for (e eVar : this.xi.xg) {
                if (eVar != null) {
                    eVar.iR();
                }
            }
            this.xp = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xn = uptimeMillis;
            this.xo = uptimeMillis + 16;
            this.xk = f;
            this.xj = 0.0f;
            this.xl = 0 - this.xi.wO;
            this.xm = this.xi.wO;
            Log.d("Animator", "@animateBottomOpen " + this.xl);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.xi.xb.removeMessages(-105);
            this.xi.xb.sendEmptyMessageAtTime(-105, this.xo);
        }

        void e(float f) {
            d dVar = this.xi.xe;
            if (dVar != null) {
                dVar.iP();
            }
            this.xp = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xn = uptimeMillis;
            this.xo = uptimeMillis + 16;
            this.xk = f;
            this.xj = 0.0f;
            this.xl = ((-this.xi.getMeasuredWidth()) + this.xi.wM) - this.xi.wO;
            this.xm = this.xi.wO;
            Log.d("Animator", "@animateTop " + this.xl);
            Log.d("Animator", "@animateTop " + f);
            this.xi.xb.removeMessages(-100);
            this.xi.xb.sendEmptyMessageAtTime(-100, this.xo);
        }

        void f(float f) {
            f fVar = this.xi.xf;
            if (fVar != null) {
                fVar.iT();
            }
            this.xp = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xn = uptimeMillis;
            this.xo = uptimeMillis + 16;
            this.xk = f;
            this.xj = 0.0f;
            this.xl = (this.xi.getMeasuredWidth() - this.xi.wN) - this.xi.wO;
            this.xm = this.xi.wO;
            Log.d("Animator", "@animateBottom " + this.xl);
            Log.d("Animator", "@animateBottom " + f);
            this.xi.xb.removeMessages(-101);
            this.xi.xb.sendEmptyMessageAtTime(-101, this.xo);
        }
    }
}
