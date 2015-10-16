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
    private int FA;
    private final Rect FB;
    private final Rect FC;
    private final Paint FD;
    private int FE;
    private int FF;
    private int FG;
    private boolean FH;
    private final a FI;
    private final b FJ;
    private final g FK;
    private d FL;
    private f FM;
    private final List<e> FN;
    private c FO;
    private int Fq;
    private float Ft;
    private float Fu;
    private int Fv;
    private final int Fw;
    private boolean Fx;
    private boolean Fy;
    private TrackDirection Fz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (FX) with 'values()' method */
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
        void mP();

        void mQ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mR();

        void mS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mT();

        void mU();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FD.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Fv = (int) ((this.Ft - this.Fq) * (-f2));
            } else if (f2 > 0.0f) {
                this.Fv = (int) ((this.Fq - this.Fu) * f2);
            } else if (f2 == 0.0f) {
                this.Fv = 0;
                this.FA = 10004;
            } else if (f2 == -1.0f) {
                this.Ft -= getMeasuredWidth();
                this.FA = 10000;
            } else if (f2 == 1.0f) {
                this.Ft = getMeasuredWidth() - this.Fu;
                this.FA = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Ft;
    }

    public int getRightOffset() {
        return (int) this.Fu;
    }

    public void setLeftTapBack(boolean z) {
        this.Fx = z;
    }

    public void setRightTapBack(boolean z) {
        this.Fy = z;
    }

    public int getState() {
        return this.FA;
    }

    public void setLeftAnimationListener(d dVar) {
        this.FL = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.FM = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.FO = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Fv, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.Fv);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FD);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Fv;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Fz == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.FA == 10004) {
            switch (action) {
                case 0:
                    this.FE = x;
                    this.FF = y;
                    this.FI.removeMessages(-100);
                    this.FI.removeMessages(-104);
                    this.FI.removeMessages(-101);
                    this.FI.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Fv, 0.0f);
                    return h(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.FF - this.Fw && i2 <= this.FF + this.Fw && (i < this.FE - this.Fw || i > this.FE + this.Fw) && this.FK.aw(i - this.FE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.FA == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.FH = false;
                    if (this.FK.FZ) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.FK.mV();
                        this.FK.mW();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FK.FZ) {
                        if (!this.FH) {
                            if (x > this.FE) {
                                this.FG = this.FE + this.Fw;
                                this.FH = true;
                            } else {
                                this.FG = this.FE - this.Fw;
                                this.FH = true;
                            }
                        }
                        this.FK.ax(this.FG - x);
                        this.FG = x;
                        this.FK.FY.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.FB);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.FC);
        switch (action) {
            case 0:
                if ((this.FA != 10000 || !this.FB.contains(x, y)) && (this.FA != 10001 || !this.FC.contains(x, y))) {
                    return false;
                }
                if (!this.FK.FZ) {
                    this.FG = x;
                    this.FK.aw(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FK.FZ) {
                    this.FK.mV();
                    this.FK.mW();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FK.FZ) {
            this.FK.ax(this.FG - x);
            this.FG = x;
            this.FK.FY.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ft != -1.0f) {
                this.FB.set(i, i2, (int) (i + this.Ft), i4);
            }
            if (this.Fu != -1.0f) {
                this.FC.set((int) (i3 - this.Fu), i2, i3, i4);
            }
        }
        if (!this.FJ.FW && !this.FK.FZ) {
            mJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Ft) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Fu) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fq = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        switch (this.FA) {
            case 10000:
                this.Fv = (int) (this.Ft - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Fv = (int) (getMeasuredWidth() - this.Fu);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Fv = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout FP;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.FP.FJ.FW) {
                switch (message.what) {
                    case -105:
                        this.FP.FJ.mO();
                        return;
                    case -104:
                        this.FP.FJ.mN();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.FP.FJ.mM();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        this.FP.FJ.mL();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Gc;
        final /* synthetic */ HorizontalTranslateLayout FP;
        VelocityTracker FY;
        boolean FZ;
        final int Ga;
        final int Gb;

        static /* synthetic */ int[] mX() {
            int[] iArr = Gc;
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
                Gc = iArr;
            }
            return iArr;
        }

        boolean aw(int i) {
            switch (mX()[this.FP.Fz.ordinal()]) {
                case 1:
                    if (this.FP.FA != 10004 && this.FP.FA != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.FP.FA != 10004 && this.FP.FA != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.FP.FO != null) {
                        this.FP.FO.av(i);
                        break;
                    }
                    break;
            }
            this.FY = VelocityTracker.obtain();
            this.FZ = true;
            return true;
        }

        void mV() {
            this.FZ = false;
        }

        void ax(int i) {
            if (this.FZ) {
                int i2 = this.FP.Fv - i;
                switch (mX()[this.FP.Fz.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.FP.Ft - this.FP.getMeasuredWidth() && i2 < 0) {
                            this.FP.Fv -= i;
                            this.FP.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.FP.getMeasuredWidth() - this.FP.Fu && i2 > 0) {
                            this.FP.Fv -= i;
                            this.FP.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.FP.Ft - this.FP.getMeasuredWidth() && i2 <= this.FP.getMeasuredWidth() - this.FP.Fu) {
                            this.FP.Fv -= i;
                            this.FP.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mW() {
            float max;
            this.FY.computeCurrentVelocity(this.Ga);
            float xVelocity = this.FY.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Gb);
            } else {
                max = Math.max(xVelocity, this.Gb);
            }
            switch (mX()[this.FP.Fz.ordinal()]) {
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
            this.FY.recycle();
            this.FY = null;
        }

        private void g(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.FP.Fv;
            if (i <= 0 && i >= this.FP.Ft - this.FP.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.FP.FJ.e(f);
                } else {
                    this.FP.FJ.c(f);
                }
            } else if (i >= 0 && i <= this.FP.getMeasuredWidth() - this.FP.Fu) {
                if (f < 0.0f) {
                    this.FP.FJ.d(f);
                } else {
                    this.FP.FJ.f(f);
                }
            }
        }

        private void h(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.FP.FJ.e(f);
            } else {
                this.FP.FJ.c(f);
            }
        }

        private void i(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.FP.FJ.d(f);
            } else {
                this.FP.FJ.f(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout FP;
        float FQ;
        float FR;
        float FS;
        float FT;
        long FU;
        long FV;
        boolean FW;

        private void mK() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = ((((float) (uptimeMillis - this.FU)) / 1000.0f) * this.FR) + this.FQ;
            this.FU = uptimeMillis;
            this.FV += 16;
        }

        void mL() {
            mK();
            if (this.FQ <= this.FS) {
                d dVar = this.FP.FL;
                if (dVar != null) {
                    dVar.mQ();
                }
                this.FW = false;
                this.FP.FA = 10000;
                this.FP.mJ();
                return;
            }
            this.FP.Fv = (int) (com.baidu.adp.widget.g.a(this.FS, this.FQ, false) + this.FT);
            this.FP.invalidate();
            this.FP.FI.sendEmptyMessageAtTime(-100, this.FV);
        }

        void mM() {
            mK();
            if (this.FQ >= this.FS) {
                f fVar = this.FP.FM;
                if (fVar != null) {
                    fVar.mU();
                }
                this.FW = false;
                this.FP.FA = 10001;
                this.FP.mJ();
                return;
            }
            this.FP.Fv = (int) (com.baidu.adp.widget.g.a(this.FS, this.FQ, false) + this.FT);
            this.FP.invalidate();
            this.FP.FI.sendEmptyMessageAtTime(-101, this.FV);
        }

        void mN() {
            mK();
            if (this.FQ >= this.FS) {
                for (e eVar : this.FP.FN) {
                    if (eVar != null) {
                        eVar.mS();
                    }
                }
                this.FW = false;
                this.FP.FA = 10004;
                this.FP.mJ();
                return;
            }
            this.FP.Fv = (int) (com.baidu.adp.widget.g.a(this.FS, this.FQ, false) + this.FT);
            this.FP.invalidate();
            this.FP.FI.sendEmptyMessageAtTime(-104, this.FV);
        }

        void mO() {
            mK();
            if (this.FQ <= this.FS) {
                for (e eVar : this.FP.FN) {
                    if (eVar != null) {
                        eVar.mS();
                    }
                }
                this.FW = false;
                this.FP.FA = 10004;
                this.FP.mJ();
                return;
            }
            this.FP.Fv = (int) (com.baidu.adp.widget.g.a(this.FS, this.FQ, false) + this.FT);
            this.FP.invalidate();
            this.FP.FI.sendEmptyMessageAtTime(-105, this.FV);
        }

        void c(float f) {
            for (e eVar : this.FP.FN) {
                if (eVar != null) {
                    eVar.mR();
                }
            }
            this.FW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FU = uptimeMillis;
            this.FV = uptimeMillis + 16;
            this.FR = f;
            this.FQ = 0.0f;
            this.FS = 0 - this.FP.Fv;
            this.FT = this.FP.Fv;
            this.FP.FI.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.FS);
            Log.d("Animator", "@animateTopOpen " + f);
            this.FP.FI.sendEmptyMessageAtTime(-104, this.FV);
        }

        void d(float f) {
            for (e eVar : this.FP.FN) {
                if (eVar != null) {
                    eVar.mR();
                }
            }
            this.FW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FU = uptimeMillis;
            this.FV = uptimeMillis + 16;
            this.FR = f;
            this.FQ = 0.0f;
            this.FS = 0 - this.FP.Fv;
            this.FT = this.FP.Fv;
            Log.d("Animator", "@animateBottomOpen " + this.FS);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.FP.FI.removeMessages(-105);
            this.FP.FI.sendEmptyMessageAtTime(-105, this.FV);
        }

        void e(float f) {
            d dVar = this.FP.FL;
            if (dVar != null) {
                dVar.mP();
            }
            this.FW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FU = uptimeMillis;
            this.FV = uptimeMillis + 16;
            this.FR = f;
            this.FQ = 0.0f;
            this.FS = ((-this.FP.getMeasuredWidth()) + this.FP.Ft) - this.FP.Fv;
            this.FT = this.FP.Fv;
            Log.d("Animator", "@animateTop " + this.FS);
            Log.d("Animator", "@animateTop " + f);
            this.FP.FI.removeMessages(-100);
            this.FP.FI.sendEmptyMessageAtTime(-100, this.FV);
        }

        void f(float f) {
            f fVar = this.FP.FM;
            if (fVar != null) {
                fVar.mT();
            }
            this.FW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FU = uptimeMillis;
            this.FV = uptimeMillis + 16;
            this.FR = f;
            this.FQ = 0.0f;
            this.FS = (this.FP.getMeasuredWidth() - this.FP.Fu) - this.FP.Fv;
            this.FT = this.FP.Fv;
            Log.d("Animator", "@animateBottom " + this.FS);
            Log.d("Animator", "@animateBottom " + f);
            this.FP.FI.removeMessages(-101);
            this.FP.FI.sendEmptyMessageAtTime(-101, this.FV);
        }
    }
}
