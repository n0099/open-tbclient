package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Rect FA;
    private final Rect FB;
    private final Paint FC;
    private int FD;
    private int FE;
    private int FF;
    private boolean FG;
    private final a FH;
    private final b FI;
    private final g FJ;
    private d FK;
    private f FL;
    private final List<e> FM;
    private c FN;
    private int Fp;
    private float Fs;
    private float Ft;
    private int Fu;
    private final int Fv;
    private boolean Fw;
    private boolean Fx;
    private TrackDirection Fy;
    private int Fz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (FW) with 'values()' method */
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
        void mO();

        void mP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mQ();

        void mR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mS();

        void mT();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FC.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Fu = (int) ((this.Fs - this.Fp) * (-f2));
            } else if (f2 > 0.0f) {
                this.Fu = (int) ((this.Fp - this.Ft) * f2);
            } else if (f2 == 0.0f) {
                this.Fu = 0;
                this.Fz = 10004;
            } else if (f2 == -1.0f) {
                this.Fs -= getMeasuredWidth();
                this.Fz = 10000;
            } else if (f2 == 1.0f) {
                this.Fs = getMeasuredWidth() - this.Ft;
                this.Fz = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Fs;
    }

    public int getRightOffset() {
        return (int) this.Ft;
    }

    public void setLeftTapBack(boolean z) {
        this.Fw = z;
    }

    public void setRightTapBack(boolean z) {
        this.Fx = z;
    }

    public int getState() {
        return this.Fz;
    }

    public void setLeftAnimationListener(d dVar) {
        this.FK = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.FL = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.FN = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Fu, 0.0f);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FC);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Fu;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Fy == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Fz == 10004) {
            switch (action) {
                case 0:
                    this.FD = x;
                    this.FE = y;
                    this.FH.removeMessages(-100);
                    this.FH.removeMessages(-104);
                    this.FH.removeMessages(-101);
                    this.FH.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    motionEvent.offsetLocation(-this.Fu, 0.0f);
                    return h(x, y);
            }
        }
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.FE - this.Fv && i2 <= this.FE + this.Fv && (i < this.FD - this.Fv || i > this.FD + this.Fv) && this.FJ.aw(i - this.FD);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Fz == 10004) {
            switch (action) {
                case 1:
                case 3:
                    this.FG = false;
                    if (this.FJ.FY) {
                        this.FJ.mU();
                        this.FJ.mV();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FJ.FY) {
                        if (!this.FG) {
                            if (x > this.FD) {
                                this.FF = this.FD + this.Fv;
                                this.FG = true;
                            } else {
                                this.FF = this.FD - this.Fv;
                                this.FG = true;
                            }
                        }
                        this.FJ.ax(this.FF - x);
                        this.FF = x;
                        this.FJ.FX.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Fz != 10000 || !this.FA.contains(x, y)) && (this.Fz != 10001 || !this.FB.contains(x, y))) {
                    return false;
                }
                if (!this.FJ.FY) {
                    this.FF = x;
                    this.FJ.aw(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FJ.FY) {
                    this.FJ.mU();
                    this.FJ.mV();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FJ.FY) {
            this.FJ.ax(this.FF - x);
            this.FF = x;
            this.FJ.FX.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Fs != -1.0f) {
                this.FA.set(i, i2, (int) (i + this.Fs), i4);
            }
            if (this.Ft != -1.0f) {
                this.FB.set((int) (i3 - this.Ft), i2, i3, i4);
            }
        }
        if (!this.FI.FV && !this.FJ.FY) {
            mI();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Fs) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Ft) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fp = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI() {
        switch (this.Fz) {
            case 10000:
                this.Fu = (int) (this.Fs - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Fu = (int) (getMeasuredWidth() - this.Ft);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Fu = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout FO;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.FO.FI.FV) {
                switch (message.what) {
                    case -105:
                        this.FO.FI.mN();
                        return;
                    case -104:
                        this.FO.FI.mM();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.FO.FI.mL();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        this.FO.FI.mK();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Gb;
        final /* synthetic */ HorizontalTranslateLayout FO;
        VelocityTracker FX;
        boolean FY;
        final int FZ;
        final int Ga;

        static /* synthetic */ int[] mW() {
            int[] iArr = Gb;
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
                Gb = iArr;
            }
            return iArr;
        }

        boolean aw(int i) {
            switch (mW()[this.FO.Fy.ordinal()]) {
                case 1:
                    if (this.FO.Fz != 10004 && this.FO.Fz != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.FO.Fz != 10004 && this.FO.Fz != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.FO.FN != null) {
                        this.FO.FN.av(i);
                        break;
                    }
                    break;
            }
            this.FX = VelocityTracker.obtain();
            this.FY = true;
            return true;
        }

        void mU() {
            this.FY = false;
        }

        void ax(int i) {
            if (this.FY) {
                int i2 = this.FO.Fu - i;
                switch (mW()[this.FO.Fy.ordinal()]) {
                    case 1:
                        if (i2 > this.FO.Fs - this.FO.getMeasuredWidth() && i2 < 0) {
                            this.FO.Fu -= i;
                            this.FO.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        if (i2 < this.FO.getMeasuredWidth() - this.FO.Ft && i2 > 0) {
                            this.FO.Fu -= i;
                            this.FO.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        if (i2 >= this.FO.Fs - this.FO.getMeasuredWidth() && i2 <= this.FO.getMeasuredWidth() - this.FO.Ft) {
                            this.FO.Fu -= i;
                            this.FO.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mV() {
            float max;
            this.FX.computeCurrentVelocity(this.FZ);
            float xVelocity = this.FX.getXVelocity();
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Ga);
            } else {
                max = Math.max(xVelocity, this.Ga);
            }
            switch (mW()[this.FO.Fy.ordinal()]) {
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
            this.FX.recycle();
            this.FX = null;
        }

        private void g(float f) {
            int i = this.FO.Fu;
            if (i <= 0 && i >= this.FO.Fs - this.FO.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.FO.FI.e(f);
                } else {
                    this.FO.FI.c(f);
                }
            } else if (i >= 0 && i <= this.FO.getMeasuredWidth() - this.FO.Ft) {
                if (f < 0.0f) {
                    this.FO.FI.d(f);
                } else {
                    this.FO.FI.f(f);
                }
            }
        }

        private void h(float f) {
            if (f < 0.0f) {
                this.FO.FI.e(f);
            } else {
                this.FO.FI.c(f);
            }
        }

        private void i(float f) {
            if (f < 0.0f) {
                this.FO.FI.d(f);
            } else {
                this.FO.FI.f(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout FO;
        float FP;
        float FQ;
        float FR;
        float FS;
        long FT;
        long FU;
        boolean FV;

        private void mJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FP = ((((float) (uptimeMillis - this.FT)) / 1000.0f) * this.FQ) + this.FP;
            this.FT = uptimeMillis;
            this.FU += 16;
        }

        void mK() {
            mJ();
            if (this.FP <= this.FR) {
                d dVar = this.FO.FK;
                if (dVar != null) {
                    dVar.mP();
                }
                this.FV = false;
                this.FO.Fz = 10000;
                this.FO.mI();
                return;
            }
            this.FO.Fu = (int) (com.baidu.adp.widget.g.a(this.FR, this.FP, false) + this.FS);
            this.FO.invalidate();
            this.FO.FH.sendEmptyMessageAtTime(-100, this.FU);
        }

        void mL() {
            mJ();
            if (this.FP >= this.FR) {
                f fVar = this.FO.FL;
                if (fVar != null) {
                    fVar.mT();
                }
                this.FV = false;
                this.FO.Fz = 10001;
                this.FO.mI();
                return;
            }
            this.FO.Fu = (int) (com.baidu.adp.widget.g.a(this.FR, this.FP, false) + this.FS);
            this.FO.invalidate();
            this.FO.FH.sendEmptyMessageAtTime(-101, this.FU);
        }

        void mM() {
            mJ();
            if (this.FP >= this.FR) {
                for (e eVar : this.FO.FM) {
                    if (eVar != null) {
                        eVar.mR();
                    }
                }
                this.FV = false;
                this.FO.Fz = 10004;
                this.FO.mI();
                return;
            }
            this.FO.Fu = (int) (com.baidu.adp.widget.g.a(this.FR, this.FP, false) + this.FS);
            this.FO.invalidate();
            this.FO.FH.sendEmptyMessageAtTime(-104, this.FU);
        }

        void mN() {
            mJ();
            if (this.FP <= this.FR) {
                for (e eVar : this.FO.FM) {
                    if (eVar != null) {
                        eVar.mR();
                    }
                }
                this.FV = false;
                this.FO.Fz = 10004;
                this.FO.mI();
                return;
            }
            this.FO.Fu = (int) (com.baidu.adp.widget.g.a(this.FR, this.FP, false) + this.FS);
            this.FO.invalidate();
            this.FO.FH.sendEmptyMessageAtTime(-105, this.FU);
        }

        void c(float f) {
            for (e eVar : this.FO.FM) {
                if (eVar != null) {
                    eVar.mQ();
                }
            }
            this.FV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FT = uptimeMillis;
            this.FU = uptimeMillis + 16;
            this.FQ = f;
            this.FP = 0.0f;
            this.FR = 0 - this.FO.Fu;
            this.FS = this.FO.Fu;
            this.FO.FH.removeMessages(-104);
            this.FO.FH.sendEmptyMessageAtTime(-104, this.FU);
        }

        void d(float f) {
            for (e eVar : this.FO.FM) {
                if (eVar != null) {
                    eVar.mQ();
                }
            }
            this.FV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FT = uptimeMillis;
            this.FU = uptimeMillis + 16;
            this.FQ = f;
            this.FP = 0.0f;
            this.FR = 0 - this.FO.Fu;
            this.FS = this.FO.Fu;
            this.FO.FH.removeMessages(-105);
            this.FO.FH.sendEmptyMessageAtTime(-105, this.FU);
        }

        void e(float f) {
            d dVar = this.FO.FK;
            if (dVar != null) {
                dVar.mO();
            }
            this.FV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FT = uptimeMillis;
            this.FU = uptimeMillis + 16;
            this.FQ = f;
            this.FP = 0.0f;
            this.FR = ((-this.FO.getMeasuredWidth()) + this.FO.Fs) - this.FO.Fu;
            this.FS = this.FO.Fu;
            this.FO.FH.removeMessages(-100);
            this.FO.FH.sendEmptyMessageAtTime(-100, this.FU);
        }

        void f(float f) {
            f fVar = this.FO.FL;
            if (fVar != null) {
                fVar.mS();
            }
            this.FV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FT = uptimeMillis;
            this.FU = uptimeMillis + 16;
            this.FQ = f;
            this.FP = 0.0f;
            this.FR = (this.FO.getMeasuredWidth() - this.FO.Ft) - this.FO.Fu;
            this.FS = this.FO.Fu;
            this.FO.FH.removeMessages(-101);
            this.FO.FH.sendEmptyMessageAtTime(-101, this.FU);
        }
    }
}
