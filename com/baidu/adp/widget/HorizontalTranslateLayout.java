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
    private boolean GA;
    private final a GB;
    private final b GC;
    private final g GD;
    private d GE;
    private f GF;
    private final List<e> GG;
    private c GH;
    private int Gj;
    private float Gm;
    private float Gn;
    private int Go;
    private final int Gp;
    private boolean Gq;
    private boolean Gr;
    private TrackDirection Gs;
    private int Gt;
    private final Rect Gu;
    private final Rect Gv;
    private final Paint Gw;
    private int Gx;
    private int Gy;
    private int Gz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (GR) with 'values()' method */
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
        void aB(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mG();

        void mH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mI();

        void mJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mK();

        void mL();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Gw.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Go = (int) ((this.Gm - this.Gj) * (-f2));
            } else if (f2 > 0.0f) {
                this.Go = (int) ((this.Gj - this.Gn) * f2);
            } else if (f2 == 0.0f) {
                this.Go = 0;
                this.Gt = 10004;
            } else if (f2 == -1.0f) {
                this.Gm -= getMeasuredWidth();
                this.Gt = 10000;
            } else if (f2 == 1.0f) {
                this.Gm = getMeasuredWidth() - this.Gn;
                this.Gt = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Gm;
    }

    public int getRightOffset() {
        return (int) this.Gn;
    }

    public void setLeftTapBack(boolean z) {
        this.Gq = z;
    }

    public void setRightTapBack(boolean z) {
        this.Gr = z;
    }

    public int getState() {
        return this.Gt;
    }

    public void setLeftAnimationListener(d dVar) {
        this.GE = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.GF = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.GH = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Go, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.Go);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Gw);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Go;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Gs == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Gt == 10004) {
            switch (action) {
                case 0:
                    this.Gx = x;
                    this.Gy = y;
                    this.GB.removeMessages(-100);
                    this.GB.removeMessages(-104);
                    this.GB.removeMessages(-101);
                    this.GB.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Go, 0.0f);
                    return h(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.Gy - this.Gp && i2 <= this.Gy + this.Gp && (i < this.Gx - this.Gp || i > this.Gx + this.Gp) && this.GD.aC(i - this.Gx);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Gt == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.GA = false;
                    if (this.GD.GT) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.GD.mM();
                        this.GD.mN();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.GD.GT) {
                        if (!this.GA) {
                            if (x > this.Gx) {
                                this.Gz = this.Gx + this.Gp;
                                this.GA = true;
                            } else {
                                this.Gz = this.Gx - this.Gp;
                                this.GA = true;
                            }
                        }
                        this.GD.aD(this.Gz - x);
                        this.Gz = x;
                        this.GD.GS.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.Gu);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.Gv);
        switch (action) {
            case 0:
                if ((this.Gt != 10000 || !this.Gu.contains(x, y)) && (this.Gt != 10001 || !this.Gv.contains(x, y))) {
                    return false;
                }
                if (!this.GD.GT) {
                    this.Gz = x;
                    this.GD.aC(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.GD.GT) {
                    this.GD.mM();
                    this.GD.mN();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.GD.GT) {
            this.GD.aD(this.Gz - x);
            this.Gz = x;
            this.GD.GS.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Gm != -1.0f) {
                this.Gu.set(i, i2, (int) (i + this.Gm), i4);
            }
            if (this.Gn != -1.0f) {
                this.Gv.set((int) (i3 - this.Gn), i2, i3, i4);
            }
        }
        if (!this.GC.GQ && !this.GD.GT) {
            mB();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Gm) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Gn) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Gj = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB() {
        switch (this.Gt) {
            case 10000:
                this.Go = (int) (this.Gm - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Go = (int) (getMeasuredWidth() - this.Gn);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Go = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout GI;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.GI.GC.GQ) {
                switch (message.what) {
                    case -105:
                        this.GI.GC.mF();
                        return;
                    case -104:
                        this.GI.GC.mE();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.GI.GC.mD();
                        return;
                    case -100:
                        this.GI.GC.mC();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] GW;
        final /* synthetic */ HorizontalTranslateLayout GI;
        VelocityTracker GS;
        boolean GT;
        final int GU;
        final int GV;

        static /* synthetic */ int[] mO() {
            int[] iArr = GW;
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
                GW = iArr;
            }
            return iArr;
        }

        boolean aC(int i) {
            switch (mO()[this.GI.Gs.ordinal()]) {
                case 1:
                    if (this.GI.Gt != 10004 && this.GI.Gt != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.GI.Gt != 10004 && this.GI.Gt != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.GI.GH != null) {
                        this.GI.GH.aB(i);
                        break;
                    }
                    break;
            }
            this.GS = VelocityTracker.obtain();
            this.GT = true;
            return true;
        }

        void mM() {
            this.GT = false;
        }

        void aD(int i) {
            if (this.GT) {
                int i2 = this.GI.Go - i;
                switch (mO()[this.GI.Gs.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.GI.Gm - this.GI.getMeasuredWidth() && i2 < 0) {
                            this.GI.Go -= i;
                            this.GI.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.GI.getMeasuredWidth() - this.GI.Gn && i2 > 0) {
                            this.GI.Go -= i;
                            this.GI.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.GI.Gm - this.GI.getMeasuredWidth() && i2 <= this.GI.getMeasuredWidth() - this.GI.Gn) {
                            this.GI.Go -= i;
                            this.GI.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mN() {
            float max;
            this.GS.computeCurrentVelocity(this.GU);
            float xVelocity = this.GS.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.GV);
            } else {
                max = Math.max(xVelocity, this.GV);
            }
            switch (mO()[this.GI.Gs.ordinal()]) {
                case 1:
                    j(max);
                    break;
                case 2:
                    k(max);
                    break;
                case 3:
                    i(max);
                    break;
            }
            this.GS.recycle();
            this.GS = null;
        }

        private void i(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.GI.Go;
            if (i <= 0 && i >= this.GI.Gm - this.GI.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.GI.GC.e(f);
                } else {
                    this.GI.GC.c(f);
                }
            } else if (i >= 0 && i <= this.GI.getMeasuredWidth() - this.GI.Gn) {
                if (f < 0.0f) {
                    this.GI.GC.d(f);
                } else {
                    this.GI.GC.g(f);
                }
            }
        }

        private void j(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.GI.GC.e(f);
            } else {
                this.GI.GC.c(f);
            }
        }

        private void k(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.GI.GC.d(f);
            } else {
                this.GI.GC.g(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout GI;
        float GJ;
        float GK;
        float GL;
        float GM;
        long GN;
        long GP;
        boolean GQ;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = ((((float) (uptimeMillis - this.GN)) / 1000.0f) * this.GK) + this.GJ;
            this.GN = uptimeMillis;
            this.GP += 16;
        }

        void mC() {
            compute();
            if (this.GJ <= this.GL) {
                d dVar = this.GI.GE;
                if (dVar != null) {
                    dVar.mH();
                }
                this.GQ = false;
                this.GI.Gt = 10000;
                this.GI.mB();
                return;
            }
            this.GI.Go = (int) (com.baidu.adp.widget.g.a(this.GL, this.GJ, false) + this.GM);
            this.GI.invalidate();
            this.GI.GB.sendEmptyMessageAtTime(-100, this.GP);
        }

        void mD() {
            compute();
            if (this.GJ >= this.GL) {
                f fVar = this.GI.GF;
                if (fVar != null) {
                    fVar.mL();
                }
                this.GQ = false;
                this.GI.Gt = 10001;
                this.GI.mB();
                return;
            }
            this.GI.Go = (int) (com.baidu.adp.widget.g.a(this.GL, this.GJ, false) + this.GM);
            this.GI.invalidate();
            this.GI.GB.sendEmptyMessageAtTime(-101, this.GP);
        }

        void mE() {
            compute();
            if (this.GJ >= this.GL) {
                for (e eVar : this.GI.GG) {
                    if (eVar != null) {
                        eVar.mJ();
                    }
                }
                this.GQ = false;
                this.GI.Gt = 10004;
                this.GI.mB();
                return;
            }
            this.GI.Go = (int) (com.baidu.adp.widget.g.a(this.GL, this.GJ, false) + this.GM);
            this.GI.invalidate();
            this.GI.GB.sendEmptyMessageAtTime(-104, this.GP);
        }

        void mF() {
            compute();
            if (this.GJ <= this.GL) {
                for (e eVar : this.GI.GG) {
                    if (eVar != null) {
                        eVar.mJ();
                    }
                }
                this.GQ = false;
                this.GI.Gt = 10004;
                this.GI.mB();
                return;
            }
            this.GI.Go = (int) (com.baidu.adp.widget.g.a(this.GL, this.GJ, false) + this.GM);
            this.GI.invalidate();
            this.GI.GB.sendEmptyMessageAtTime(-105, this.GP);
        }

        void c(float f) {
            for (e eVar : this.GI.GG) {
                if (eVar != null) {
                    eVar.mI();
                }
            }
            this.GQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GN = uptimeMillis;
            this.GP = uptimeMillis + 16;
            this.GK = f;
            this.GJ = 0.0f;
            this.GL = 0 - this.GI.Go;
            this.GM = this.GI.Go;
            this.GI.GB.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.GL);
            Log.d("Animator", "@animateTopOpen " + f);
            this.GI.GB.sendEmptyMessageAtTime(-104, this.GP);
        }

        void d(float f) {
            for (e eVar : this.GI.GG) {
                if (eVar != null) {
                    eVar.mI();
                }
            }
            this.GQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GN = uptimeMillis;
            this.GP = uptimeMillis + 16;
            this.GK = f;
            this.GJ = 0.0f;
            this.GL = 0 - this.GI.Go;
            this.GM = this.GI.Go;
            Log.d("Animator", "@animateBottomOpen " + this.GL);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.GI.GB.removeMessages(-105);
            this.GI.GB.sendEmptyMessageAtTime(-105, this.GP);
        }

        void e(float f) {
            d dVar = this.GI.GE;
            if (dVar != null) {
                dVar.mG();
            }
            this.GQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GN = uptimeMillis;
            this.GP = uptimeMillis + 16;
            this.GK = f;
            this.GJ = 0.0f;
            this.GL = ((-this.GI.getMeasuredWidth()) + this.GI.Gm) - this.GI.Go;
            this.GM = this.GI.Go;
            Log.d("Animator", "@animateTop " + this.GL);
            Log.d("Animator", "@animateTop " + f);
            this.GI.GB.removeMessages(-100);
            this.GI.GB.sendEmptyMessageAtTime(-100, this.GP);
        }

        void g(float f) {
            f fVar = this.GI.GF;
            if (fVar != null) {
                fVar.mK();
            }
            this.GQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GN = uptimeMillis;
            this.GP = uptimeMillis + 16;
            this.GK = f;
            this.GJ = 0.0f;
            this.GL = (this.GI.getMeasuredWidth() - this.GI.Gn) - this.GI.Go;
            this.GM = this.GI.Go;
            Log.d("Animator", "@animateBottom " + this.GL);
            Log.d("Animator", "@animateBottom " + f);
            this.GI.GB.removeMessages(-101);
            this.GI.GB.sendEmptyMessageAtTime(-101, this.GP);
        }
    }
}
