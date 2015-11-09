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
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private TrackDirection FA;
    private int FB;
    private final Rect FC;
    private final Rect FD;
    private final Paint FE;
    private int FF;
    private int FG;
    private int FH;
    private boolean FI;
    private final a FJ;
    private final b FK;
    private final g FL;
    private d FM;
    private f FN;
    private final List<e> FO;
    private c FP;
    private int Fr;
    private float Fu;
    private float Fv;
    private int Fw;
    private final int Fx;
    private boolean Fy;
    private boolean Fz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (FY) with 'values()' method */
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
        void av(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mQ();

        void mR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mS();

        void mT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mU();

        void mV();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FE.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Fw = (int) ((this.Fu - this.Fr) * (-f2));
            } else if (f2 > 0.0f) {
                this.Fw = (int) ((this.Fr - this.Fv) * f2);
            } else if (f2 == 0.0f) {
                this.Fw = 0;
                this.FB = 10004;
            } else if (f2 == -1.0f) {
                this.Fu -= getMeasuredWidth();
                this.FB = 10000;
            } else if (f2 == 1.0f) {
                this.Fu = getMeasuredWidth() - this.Fv;
                this.FB = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Fu;
    }

    public int getRightOffset() {
        return (int) this.Fv;
    }

    public void setLeftTapBack(boolean z) {
        this.Fy = z;
    }

    public void setRightTapBack(boolean z) {
        this.Fz = z;
    }

    public int getState() {
        return this.FB;
    }

    public void setLeftAnimationListener(d dVar) {
        this.FM = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.FN = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.FP = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Fw, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.Fw);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FE);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Fw;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.FA == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.FB == 10004) {
            switch (action) {
                case 0:
                    this.FF = x;
                    this.FG = y;
                    this.FJ.removeMessages(-100);
                    this.FJ.removeMessages(-104);
                    this.FJ.removeMessages(-101);
                    this.FJ.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Fw, 0.0f);
                    return h(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.FG - this.Fx && i2 <= this.FG + this.Fx && (i < this.FF - this.Fx || i > this.FF + this.Fx) && this.FL.aw(i - this.FF);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.FB == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.FI = false;
                    if (this.FL.Ga) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.FL.mW();
                        this.FL.mX();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FL.Ga) {
                        if (!this.FI) {
                            if (x > this.FF) {
                                this.FH = this.FF + this.Fx;
                                this.FI = true;
                            } else {
                                this.FH = this.FF - this.Fx;
                                this.FI = true;
                            }
                        }
                        this.FL.ax(this.FH - x);
                        this.FH = x;
                        this.FL.FZ.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.FC);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.FD);
        switch (action) {
            case 0:
                if ((this.FB != 10000 || !this.FC.contains(x, y)) && (this.FB != 10001 || !this.FD.contains(x, y))) {
                    return false;
                }
                if (!this.FL.Ga) {
                    this.FH = x;
                    this.FL.aw(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FL.Ga) {
                    this.FL.mW();
                    this.FL.mX();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FL.Ga) {
            this.FL.ax(this.FH - x);
            this.FH = x;
            this.FL.FZ.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Fu != -1.0f) {
                this.FC.set(i, i2, (int) (i + this.Fu), i4);
            }
            if (this.Fv != -1.0f) {
                this.FD.set((int) (i3 - this.Fv), i2, i3, i4);
            }
        }
        if (!this.FK.FX && !this.FL.Ga) {
            mK();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Fu) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Fv) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fr = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mK() {
        switch (this.FB) {
            case 10000:
                this.Fw = (int) (this.Fu - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Fw = (int) (getMeasuredWidth() - this.Fv);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Fw = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout FQ;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.FQ.FK.FX) {
                switch (message.what) {
                    case -105:
                        this.FQ.FK.mP();
                        return;
                    case -104:
                        this.FQ.FK.mO();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.FQ.FK.mN();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        this.FQ.FK.mM();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Gd;
        final /* synthetic */ HorizontalTranslateLayout FQ;
        VelocityTracker FZ;
        boolean Ga;
        final int Gb;
        final int Gc;

        static /* synthetic */ int[] mY() {
            int[] iArr = Gd;
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
                Gd = iArr;
            }
            return iArr;
        }

        boolean aw(int i) {
            switch (mY()[this.FQ.FA.ordinal()]) {
                case 1:
                    if (this.FQ.FB != 10004 && this.FQ.FB != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.FQ.FB != 10004 && this.FQ.FB != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.FQ.FP != null) {
                        this.FQ.FP.av(i);
                        break;
                    }
                    break;
            }
            this.FZ = VelocityTracker.obtain();
            this.Ga = true;
            return true;
        }

        void mW() {
            this.Ga = false;
        }

        void ax(int i) {
            if (this.Ga) {
                int i2 = this.FQ.Fw - i;
                switch (mY()[this.FQ.FA.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.FQ.Fu - this.FQ.getMeasuredWidth() && i2 < 0) {
                            this.FQ.Fw -= i;
                            this.FQ.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.FQ.getMeasuredWidth() - this.FQ.Fv && i2 > 0) {
                            this.FQ.Fw -= i;
                            this.FQ.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.FQ.Fu - this.FQ.getMeasuredWidth() && i2 <= this.FQ.getMeasuredWidth() - this.FQ.Fv) {
                            this.FQ.Fw -= i;
                            this.FQ.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mX() {
            float max;
            this.FZ.computeCurrentVelocity(this.Gb);
            float xVelocity = this.FZ.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Gc);
            } else {
                max = Math.max(xVelocity, this.Gc);
            }
            switch (mY()[this.FQ.FA.ordinal()]) {
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
            this.FZ.recycle();
            this.FZ = null;
        }

        private void g(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.FQ.Fw;
            if (i <= 0 && i >= this.FQ.Fu - this.FQ.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.FQ.FK.e(f);
                } else {
                    this.FQ.FK.c(f);
                }
            } else if (i >= 0 && i <= this.FQ.getMeasuredWidth() - this.FQ.Fv) {
                if (f < 0.0f) {
                    this.FQ.FK.d(f);
                } else {
                    this.FQ.FK.f(f);
                }
            }
        }

        private void h(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.FQ.FK.e(f);
            } else {
                this.FQ.FK.c(f);
            }
        }

        private void i(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.FQ.FK.d(f);
            } else {
                this.FQ.FK.f(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout FQ;
        float FR;
        float FS;
        float FT;
        float FU;
        long FV;
        long FW;
        boolean FX;

        private void mL() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = ((((float) (uptimeMillis - this.FV)) / 1000.0f) * this.FS) + this.FR;
            this.FV = uptimeMillis;
            this.FW += 16;
        }

        void mM() {
            mL();
            if (this.FR <= this.FT) {
                d dVar = this.FQ.FM;
                if (dVar != null) {
                    dVar.mR();
                }
                this.FX = false;
                this.FQ.FB = 10000;
                this.FQ.mK();
                return;
            }
            this.FQ.Fw = (int) (com.baidu.adp.widget.g.a(this.FT, this.FR, false) + this.FU);
            this.FQ.invalidate();
            this.FQ.FJ.sendEmptyMessageAtTime(-100, this.FW);
        }

        void mN() {
            mL();
            if (this.FR >= this.FT) {
                f fVar = this.FQ.FN;
                if (fVar != null) {
                    fVar.mV();
                }
                this.FX = false;
                this.FQ.FB = 10001;
                this.FQ.mK();
                return;
            }
            this.FQ.Fw = (int) (com.baidu.adp.widget.g.a(this.FT, this.FR, false) + this.FU);
            this.FQ.invalidate();
            this.FQ.FJ.sendEmptyMessageAtTime(-101, this.FW);
        }

        void mO() {
            mL();
            if (this.FR >= this.FT) {
                for (e eVar : this.FQ.FO) {
                    if (eVar != null) {
                        eVar.mT();
                    }
                }
                this.FX = false;
                this.FQ.FB = 10004;
                this.FQ.mK();
                return;
            }
            this.FQ.Fw = (int) (com.baidu.adp.widget.g.a(this.FT, this.FR, false) + this.FU);
            this.FQ.invalidate();
            this.FQ.FJ.sendEmptyMessageAtTime(-104, this.FW);
        }

        void mP() {
            mL();
            if (this.FR <= this.FT) {
                for (e eVar : this.FQ.FO) {
                    if (eVar != null) {
                        eVar.mT();
                    }
                }
                this.FX = false;
                this.FQ.FB = 10004;
                this.FQ.mK();
                return;
            }
            this.FQ.Fw = (int) (com.baidu.adp.widget.g.a(this.FT, this.FR, false) + this.FU);
            this.FQ.invalidate();
            this.FQ.FJ.sendEmptyMessageAtTime(-105, this.FW);
        }

        void c(float f) {
            for (e eVar : this.FQ.FO) {
                if (eVar != null) {
                    eVar.mS();
                }
            }
            this.FX = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FV = uptimeMillis;
            this.FW = uptimeMillis + 16;
            this.FS = f;
            this.FR = 0.0f;
            this.FT = 0 - this.FQ.Fw;
            this.FU = this.FQ.Fw;
            this.FQ.FJ.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.FT);
            Log.d("Animator", "@animateTopOpen " + f);
            this.FQ.FJ.sendEmptyMessageAtTime(-104, this.FW);
        }

        void d(float f) {
            for (e eVar : this.FQ.FO) {
                if (eVar != null) {
                    eVar.mS();
                }
            }
            this.FX = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FV = uptimeMillis;
            this.FW = uptimeMillis + 16;
            this.FS = f;
            this.FR = 0.0f;
            this.FT = 0 - this.FQ.Fw;
            this.FU = this.FQ.Fw;
            Log.d("Animator", "@animateBottomOpen " + this.FT);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.FQ.FJ.removeMessages(-105);
            this.FQ.FJ.sendEmptyMessageAtTime(-105, this.FW);
        }

        void e(float f) {
            d dVar = this.FQ.FM;
            if (dVar != null) {
                dVar.mQ();
            }
            this.FX = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FV = uptimeMillis;
            this.FW = uptimeMillis + 16;
            this.FS = f;
            this.FR = 0.0f;
            this.FT = ((-this.FQ.getMeasuredWidth()) + this.FQ.Fu) - this.FQ.Fw;
            this.FU = this.FQ.Fw;
            Log.d("Animator", "@animateTop " + this.FT);
            Log.d("Animator", "@animateTop " + f);
            this.FQ.FJ.removeMessages(-100);
            this.FQ.FJ.sendEmptyMessageAtTime(-100, this.FW);
        }

        void f(float f) {
            f fVar = this.FQ.FN;
            if (fVar != null) {
                fVar.mU();
            }
            this.FX = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FV = uptimeMillis;
            this.FW = uptimeMillis + 16;
            this.FS = f;
            this.FR = 0.0f;
            this.FT = (this.FQ.getMeasuredWidth() - this.FQ.Fv) - this.FQ.Fw;
            this.FU = this.FQ.Fw;
            Log.d("Animator", "@animateBottom " + this.FT);
            Log.d("Animator", "@animateBottom " + f);
            this.FQ.FJ.removeMessages(-101);
            this.FQ.FJ.sendEmptyMessageAtTime(-101, this.FW);
        }
    }
}
