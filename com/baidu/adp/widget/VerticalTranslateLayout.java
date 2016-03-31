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
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Paint GC;
    private int GD;
    private int GE;
    private final List<d> GM;
    private int Gp;
    private int Gq;
    private final int Gv;
    private int Gz;
    private boolean KA;
    private TrackDirection KB;
    private final Rect KC;
    private final Rect KD;
    private int KE;
    private boolean KF;
    private final a KG;
    private final b KH;
    private final g KI;
    private e KJ;
    private c KK;
    private f KL;
    private float Ku;
    private float Kv;
    private float Kw;
    private float Kx;
    private int Ky;
    private boolean Kz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (KN) with 'values()' method */
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
        void mC();

        void nZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mA();

        void mB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void my();

        void oa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aK(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.GC.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Ky = (int) ((this.Ku - this.Gq) * (-f2));
            } else if (f2 > 0.0f) {
                this.Ky = (int) ((this.Gq - this.Kw) * f2);
            } else if (f2 == 0.0f) {
                this.Ky = 0;
                this.Gz = 10004;
            } else if (f2 == -1.0f) {
                this.Ku -= this.Gq;
                this.Gz = 10000;
            } else if (f2 == 1.0f) {
                this.Ku = this.Gq - this.Kw;
                this.Gz = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Ku;
    }

    public int getBottomOffset() {
        return (int) this.Kw;
    }

    public void setTopTapBack(boolean z) {
        this.Kz = z;
    }

    public void setBottomTapBack(boolean z) {
        this.KA = z;
    }

    public int getState() {
        return this.Gz;
    }

    public void setTopAnimationListener(e eVar) {
        this.KJ = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.KK = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.KL = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Ky);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Ky);
        canvas.drawRect(0.0f, 0.0f, this.Gp, this.Gq, this.GC);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Ky;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.KB == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Gz == 10004) {
            switch (action) {
                case 0:
                    this.GD = x;
                    this.GE = y;
                    this.KG.removeMessages(-100);
                    this.KG.removeMessages(-104);
                    this.KG.removeMessages(-101);
                    this.KG.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Ky);
                    return h(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i >= this.GD - this.Gv && i <= this.GD + this.Gv && (i2 < this.GE - this.Gv || i2 > this.GE + this.Gv) && this.KI.aB(i2 - this.GE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Gz == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.KF = false;
                    if (this.KI.GY) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.KI.mE();
                        this.KI.mF();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.KI.GY) {
                        if (!this.KF) {
                            if (y > this.GE) {
                                this.KE = this.GE + this.Gv;
                                this.KF = true;
                            } else {
                                this.KE = this.GE - this.Gv;
                                this.KF = true;
                            }
                        }
                        this.KI.aC(this.KE - y);
                        this.KE = y;
                        this.KI.GX.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Gz != 10000 || !this.KC.contains(x, y)) && (this.Gz != 10001 || !this.KD.contains(x, y))) {
                    return false;
                }
                if (!this.KI.GY) {
                    this.KE = y;
                    this.KI.aB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.KI.GY) {
                    this.KI.mE();
                    this.KI.mF();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.KI.GY) {
            this.KI.aC(this.KE - y);
            this.KE = y;
            this.KI.GX.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ku != -1.0f) {
                this.KC.set(i, i2, i3, (int) (i2 + this.Ku));
            }
            if (this.Kw != -1.0f) {
                this.KD.set(i, (int) (i4 - this.Kw), i3, i4);
            }
        }
        if (!this.KH.GV && !this.KI.GY) {
            ms();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Kv != -1.0f) {
            this.Ku = i3 - this.Kx;
        }
        if (this.Kx != -1.0f) {
            this.Kw = i3 - this.Kv;
        }
        if (!$assertionsDisabled && i3 < this.Ku) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Kw) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Gp = getMeasuredWidth();
        this.Gq = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms() {
        switch (this.Gz) {
            case 10000:
                this.Ky = (int) (this.Ku - this.Gq);
                invalidate();
                return;
            case 10001:
                this.Ky = (int) (this.Gq - this.Kw);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Ky = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout KM;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.KM.KH.GV) {
                switch (message.what) {
                    case -105:
                        this.KM.KH.nY();
                        return;
                    case -104:
                        this.KM.KH.nX();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.KM.KH.nW();
                        return;
                    case -100:
                        this.KM.KH.nV();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] KO;
        VelocityTracker GX;
        boolean GY;
        final int GZ;
        final int Ha;
        final /* synthetic */ VerticalTranslateLayout KM;

        static /* synthetic */ int[] ob() {
            int[] iArr = KO;
            if (iArr == null) {
                iArr = new int[TrackDirection.valuesCustom().length];
                try {
                    iArr[TrackDirection.bottom.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[TrackDirection.none.ordinal()] = 4;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[TrackDirection.top.ordinal()] = 1;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[TrackDirection.vertical.ordinal()] = 3;
                } catch (NoSuchFieldError e4) {
                }
                KO = iArr;
            }
            return iArr;
        }

        boolean aB(int i) {
            switch (ob()[this.KM.KB.ordinal()]) {
                case 1:
                    if (this.KM.Gz != 10004 && this.KM.Gz != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.KM.Gz != 10004 && this.KM.Gz != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.KM.KL != null) {
                        this.KM.KL.aK(i);
                        break;
                    }
                    break;
            }
            this.GX = VelocityTracker.obtain();
            this.GY = true;
            return true;
        }

        void mE() {
            this.GY = false;
        }

        void aC(int i) {
            if (this.GY) {
                int i2 = this.KM.Ky - i;
                switch (ob()[this.KM.KB.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.KM.Ku - this.KM.Gq && i2 < 0) {
                            this.KM.Ky -= i;
                            this.KM.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.KM.Gq - this.KM.Kw && i2 > 0) {
                            this.KM.Ky -= i;
                            this.KM.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.KM.Ku - this.KM.Gq && i2 <= this.KM.Gq - this.KM.Kw) {
                            this.KM.Ky -= i;
                            this.KM.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mF() {
            float max;
            this.GX.computeCurrentVelocity(this.GZ);
            float yVelocity = this.GX.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ha);
            } else {
                max = Math.max(yVelocity, this.Ha);
            }
            switch (ob()[this.KM.KB.ordinal()]) {
                case 1:
                    t(max);
                    break;
                case 2:
                    u(max);
                    break;
                case 3:
                    s(max);
                    break;
            }
            this.GX.recycle();
            this.GX = null;
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.KM.Ky;
            if (i <= 0 && i >= this.KM.Ku - this.KM.Gq) {
                if (f < 0.0f) {
                    this.KM.KH.q(f);
                } else {
                    this.KM.KH.o(f);
                }
            } else if (i >= 0 && i <= this.KM.Gq - this.KM.Kw) {
                if (f < 0.0f) {
                    this.KM.KH.p(f);
                } else {
                    this.KM.KH.r(f);
                }
            }
        }

        private void t(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.KM.KH.q(f);
            } else {
                this.KM.KH.o(f);
            }
        }

        private void u(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.KM.KH.p(f);
            } else {
                this.KM.KH.r(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float GP;
        float GQ;
        float GR;
        float GS;
        long GT;
        long GU;
        boolean GV;
        final /* synthetic */ VerticalTranslateLayout KM;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GP = ((((float) (uptimeMillis - this.GT)) / 1000.0f) * this.GQ) + this.GP;
            this.GT = uptimeMillis;
            this.GU += 16;
        }

        void nV() {
            compute();
            if (this.GP <= this.GR) {
                e eVar = this.KM.KJ;
                if (eVar != null) {
                    eVar.oa();
                }
                this.GV = false;
                this.KM.Gz = 10000;
                this.KM.ms();
                return;
            }
            this.KM.Ky = (int) (com.baidu.adp.widget.a.a(this.GR, this.GP, false) + this.GS);
            this.KM.invalidate();
            this.KM.KG.sendEmptyMessageAtTime(-100, this.GU);
        }

        void nW() {
            compute();
            if (this.GP >= this.GR) {
                c cVar = this.KM.KK;
                if (cVar != null) {
                    cVar.nZ();
                }
                this.GV = false;
                this.KM.Gz = 10001;
                this.KM.ms();
                return;
            }
            this.KM.Ky = (int) (com.baidu.adp.widget.a.a(this.GR, this.GP, false) + this.GS);
            this.KM.invalidate();
            this.KM.KG.sendEmptyMessageAtTime(-101, this.GU);
        }

        void nX() {
            compute();
            if (this.GP >= this.GR) {
                for (d dVar : this.KM.GM) {
                    if (dVar != null) {
                        dVar.mB();
                    }
                }
                this.GV = false;
                this.KM.Gz = 10004;
                this.KM.ms();
                return;
            }
            this.KM.Ky = (int) (com.baidu.adp.widget.a.a(this.GR, this.GP, false) + this.GS);
            this.KM.invalidate();
            this.KM.KG.sendEmptyMessageAtTime(-104, this.GU);
        }

        void nY() {
            compute();
            if (this.GP <= this.GR) {
                for (d dVar : this.KM.GM) {
                    if (dVar != null) {
                        dVar.mB();
                    }
                }
                this.GV = false;
                this.KM.Gz = 10004;
                this.KM.ms();
                return;
            }
            this.KM.Ky = (int) (com.baidu.adp.widget.a.a(this.GR, this.GP, false) + this.GS);
            this.KM.invalidate();
            this.KM.KG.sendEmptyMessageAtTime(-105, this.GU);
        }

        void o(float f) {
            for (d dVar : this.KM.GM) {
                if (dVar != null) {
                    dVar.mA();
                }
            }
            this.GV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GT = uptimeMillis;
            this.GU = uptimeMillis + 16;
            this.GQ = f;
            this.GP = 0.0f;
            this.GR = 0 - this.KM.Ky;
            this.GS = this.KM.Ky;
            this.KM.KG.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.GR);
            Log.d("Animator", "@animateTopOpen " + f);
            this.KM.KG.sendEmptyMessageAtTime(-104, this.GU);
        }

        void p(float f) {
            for (d dVar : this.KM.GM) {
                if (dVar != null) {
                    dVar.mA();
                }
            }
            this.GV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GT = uptimeMillis;
            this.GU = uptimeMillis + 16;
            this.GQ = f;
            this.GP = 0.0f;
            this.GR = 0 - this.KM.Ky;
            this.GS = this.KM.Ky;
            Log.d("Animator", "@animateBottomOpen " + this.GR);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.KM.KG.removeMessages(-105);
            this.KM.KG.sendEmptyMessageAtTime(-105, this.GU);
        }

        void q(float f) {
            e eVar = this.KM.KJ;
            if (eVar != null) {
                eVar.my();
            }
            this.GV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GT = uptimeMillis;
            this.GU = uptimeMillis + 16;
            this.GQ = f;
            this.GP = 0.0f;
            this.GR = ((-this.KM.Gq) + this.KM.Ku) - this.KM.Ky;
            this.GS = this.KM.Ky;
            Log.d("Animator", "@animateTop " + this.GR);
            Log.d("Animator", "@animateTop " + f);
            this.KM.KG.removeMessages(-100);
            this.KM.KG.sendEmptyMessageAtTime(-100, this.GU);
        }

        void r(float f) {
            c cVar = this.KM.KK;
            if (cVar != null) {
                cVar.mC();
            }
            this.GV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GT = uptimeMillis;
            this.GU = uptimeMillis + 16;
            this.GQ = f;
            this.GP = 0.0f;
            this.GR = (this.KM.Gq - this.KM.Kw) - this.KM.Ky;
            this.GS = this.KM.Ky;
            Log.d("Animator", "@animateBottom " + this.GR);
            Log.d("Animator", "@animateBottom " + f);
            this.KM.KG.removeMessages(-101);
            this.KM.KG.sendEmptyMessageAtTime(-101, this.GU);
        }
    }
}
