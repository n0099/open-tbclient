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
    private final List<d> GG;
    private int Gj;
    private int Gk;
    private final int Gp;
    private int Gt;
    private final Paint Gw;
    private int Gx;
    private int Gy;
    private final a KA;
    private final b KB;
    private final g KC;
    private e KD;
    private c KE;
    private f KF;
    private float Ko;
    private float Kp;
    private float Kq;
    private float Kr;
    private int Ks;
    private boolean Kt;
    private boolean Ku;
    private TrackDirection Kv;
    private final Rect Kw;
    private final Rect Kx;
    private int Ky;
    private boolean Kz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (KH) with 'values()' method */
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
        void mK();

        void og();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mI();

        void mJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mG();

        void oh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aL(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Gw.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Ks = (int) ((this.Ko - this.Gk) * (-f2));
            } else if (f2 > 0.0f) {
                this.Ks = (int) ((this.Gk - this.Kq) * f2);
            } else if (f2 == 0.0f) {
                this.Ks = 0;
                this.Gt = 10004;
            } else if (f2 == -1.0f) {
                this.Ko -= this.Gk;
                this.Gt = 10000;
            } else if (f2 == 1.0f) {
                this.Ko = this.Gk - this.Kq;
                this.Gt = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Ko;
    }

    public int getBottomOffset() {
        return (int) this.Kq;
    }

    public void setTopTapBack(boolean z) {
        this.Kt = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Ku = z;
    }

    public int getState() {
        return this.Gt;
    }

    public void setTopAnimationListener(e eVar) {
        this.KD = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.KE = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.KF = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Ks);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Ks);
        canvas.drawRect(0.0f, 0.0f, this.Gj, this.Gk, this.Gw);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Ks;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Kv == TrackDirection.none) {
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
                    this.KA.removeMessages(-100);
                    this.KA.removeMessages(-104);
                    this.KA.removeMessages(-101);
                    this.KA.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Ks);
                    return h(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i >= this.Gx - this.Gp && i <= this.Gx + this.Gp && (i2 < this.Gy - this.Gp || i2 > this.Gy + this.Gp) && this.KC.aC(i2 - this.Gy);
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
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.Kz = false;
                    if (this.KC.GT) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.KC.mM();
                        this.KC.mN();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.KC.GT) {
                        if (!this.Kz) {
                            if (y > this.Gy) {
                                this.Ky = this.Gy + this.Gp;
                                this.Kz = true;
                            } else {
                                this.Ky = this.Gy - this.Gp;
                                this.Kz = true;
                            }
                        }
                        this.KC.aD(this.Ky - y);
                        this.Ky = y;
                        this.KC.GS.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Gt != 10000 || !this.Kw.contains(x, y)) && (this.Gt != 10001 || !this.Kx.contains(x, y))) {
                    return false;
                }
                if (!this.KC.GT) {
                    this.Ky = y;
                    this.KC.aC(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.KC.GT) {
                    this.KC.mM();
                    this.KC.mN();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.KC.GT) {
            this.KC.aD(this.Ky - y);
            this.Ky = y;
            this.KC.GS.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ko != -1.0f) {
                this.Kw.set(i, i2, i3, (int) (i2 + this.Ko));
            }
            if (this.Kq != -1.0f) {
                this.Kx.set(i, (int) (i4 - this.Kq), i3, i4);
            }
        }
        if (!this.KB.GQ && !this.KC.GT) {
            mB();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Kp != -1.0f) {
            this.Ko = i3 - this.Kr;
        }
        if (this.Kr != -1.0f) {
            this.Kq = i3 - this.Kp;
        }
        if (!$assertionsDisabled && i3 < this.Ko) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Kq) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Gj = getMeasuredWidth();
        this.Gk = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB() {
        switch (this.Gt) {
            case 10000:
                this.Ks = (int) (this.Ko - this.Gk);
                invalidate();
                return;
            case 10001:
                this.Ks = (int) (this.Gk - this.Kq);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Ks = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout KG;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.KG.KB.GQ) {
                switch (message.what) {
                    case -105:
                        this.KG.KB.of();
                        return;
                    case -104:
                        this.KG.KB.oe();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.KG.KB.od();
                        return;
                    case -100:
                        this.KG.KB.oc();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] KI;
        VelocityTracker GS;
        boolean GT;
        final int GU;
        final int GV;
        final /* synthetic */ VerticalTranslateLayout KG;

        static /* synthetic */ int[] oi() {
            int[] iArr = KI;
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
                KI = iArr;
            }
            return iArr;
        }

        boolean aC(int i) {
            switch (oi()[this.KG.Kv.ordinal()]) {
                case 1:
                    if (this.KG.Gt != 10004 && this.KG.Gt != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.KG.Gt != 10004 && this.KG.Gt != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.KG.KF != null) {
                        this.KG.KF.aL(i);
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
                int i2 = this.KG.Ks - i;
                switch (oi()[this.KG.Kv.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.KG.Ko - this.KG.Gk && i2 < 0) {
                            this.KG.Ks -= i;
                            this.KG.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.KG.Gk - this.KG.Kq && i2 > 0) {
                            this.KG.Ks -= i;
                            this.KG.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.KG.Ko - this.KG.Gk && i2 <= this.KG.Gk - this.KG.Kq) {
                            this.KG.Ks -= i;
                            this.KG.invalidate();
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
            float yVelocity = this.GS.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.GV);
            } else {
                max = Math.max(yVelocity, this.GV);
            }
            switch (oi()[this.KG.Kv.ordinal()]) {
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
            this.GS.recycle();
            this.GS = null;
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.KG.Ks;
            if (i <= 0 && i >= this.KG.Ko - this.KG.Gk) {
                if (f < 0.0f) {
                    this.KG.KB.q(f);
                } else {
                    this.KG.KB.o(f);
                }
            } else if (i >= 0 && i <= this.KG.Gk - this.KG.Kq) {
                if (f < 0.0f) {
                    this.KG.KB.p(f);
                } else {
                    this.KG.KB.r(f);
                }
            }
        }

        private void t(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.KG.KB.q(f);
            } else {
                this.KG.KB.o(f);
            }
        }

        private void u(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.KG.KB.p(f);
            } else {
                this.KG.KB.r(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float GJ;
        float GK;
        float GL;
        float GM;
        long GN;
        long GP;
        boolean GQ;
        final /* synthetic */ VerticalTranslateLayout KG;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = ((((float) (uptimeMillis - this.GN)) / 1000.0f) * this.GK) + this.GJ;
            this.GN = uptimeMillis;
            this.GP += 16;
        }

        void oc() {
            compute();
            if (this.GJ <= this.GL) {
                e eVar = this.KG.KD;
                if (eVar != null) {
                    eVar.oh();
                }
                this.GQ = false;
                this.KG.Gt = 10000;
                this.KG.mB();
                return;
            }
            this.KG.Ks = (int) (com.baidu.adp.widget.a.a(this.GL, this.GJ, false) + this.GM);
            this.KG.invalidate();
            this.KG.KA.sendEmptyMessageAtTime(-100, this.GP);
        }

        void od() {
            compute();
            if (this.GJ >= this.GL) {
                c cVar = this.KG.KE;
                if (cVar != null) {
                    cVar.og();
                }
                this.GQ = false;
                this.KG.Gt = 10001;
                this.KG.mB();
                return;
            }
            this.KG.Ks = (int) (com.baidu.adp.widget.a.a(this.GL, this.GJ, false) + this.GM);
            this.KG.invalidate();
            this.KG.KA.sendEmptyMessageAtTime(-101, this.GP);
        }

        void oe() {
            compute();
            if (this.GJ >= this.GL) {
                for (d dVar : this.KG.GG) {
                    if (dVar != null) {
                        dVar.mJ();
                    }
                }
                this.GQ = false;
                this.KG.Gt = 10004;
                this.KG.mB();
                return;
            }
            this.KG.Ks = (int) (com.baidu.adp.widget.a.a(this.GL, this.GJ, false) + this.GM);
            this.KG.invalidate();
            this.KG.KA.sendEmptyMessageAtTime(-104, this.GP);
        }

        void of() {
            compute();
            if (this.GJ <= this.GL) {
                for (d dVar : this.KG.GG) {
                    if (dVar != null) {
                        dVar.mJ();
                    }
                }
                this.GQ = false;
                this.KG.Gt = 10004;
                this.KG.mB();
                return;
            }
            this.KG.Ks = (int) (com.baidu.adp.widget.a.a(this.GL, this.GJ, false) + this.GM);
            this.KG.invalidate();
            this.KG.KA.sendEmptyMessageAtTime(-105, this.GP);
        }

        void o(float f) {
            for (d dVar : this.KG.GG) {
                if (dVar != null) {
                    dVar.mI();
                }
            }
            this.GQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GN = uptimeMillis;
            this.GP = uptimeMillis + 16;
            this.GK = f;
            this.GJ = 0.0f;
            this.GL = 0 - this.KG.Ks;
            this.GM = this.KG.Ks;
            this.KG.KA.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.GL);
            Log.d("Animator", "@animateTopOpen " + f);
            this.KG.KA.sendEmptyMessageAtTime(-104, this.GP);
        }

        void p(float f) {
            for (d dVar : this.KG.GG) {
                if (dVar != null) {
                    dVar.mI();
                }
            }
            this.GQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GN = uptimeMillis;
            this.GP = uptimeMillis + 16;
            this.GK = f;
            this.GJ = 0.0f;
            this.GL = 0 - this.KG.Ks;
            this.GM = this.KG.Ks;
            Log.d("Animator", "@animateBottomOpen " + this.GL);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.KG.KA.removeMessages(-105);
            this.KG.KA.sendEmptyMessageAtTime(-105, this.GP);
        }

        void q(float f) {
            e eVar = this.KG.KD;
            if (eVar != null) {
                eVar.mG();
            }
            this.GQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GN = uptimeMillis;
            this.GP = uptimeMillis + 16;
            this.GK = f;
            this.GJ = 0.0f;
            this.GL = ((-this.KG.Gk) + this.KG.Ko) - this.KG.Ks;
            this.GM = this.KG.Ks;
            Log.d("Animator", "@animateTop " + this.GL);
            Log.d("Animator", "@animateTop " + f);
            this.KG.KA.removeMessages(-100);
            this.KG.KA.sendEmptyMessageAtTime(-100, this.GP);
        }

        void r(float f) {
            c cVar = this.KG.KE;
            if (cVar != null) {
                cVar.mK();
            }
            this.GQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GN = uptimeMillis;
            this.GP = uptimeMillis + 16;
            this.GK = f;
            this.GJ = 0.0f;
            this.GL = (this.KG.Gk - this.KG.Kq) - this.KG.Ks;
            this.GM = this.KG.Ks;
            Log.d("Animator", "@animateBottom " + this.GL);
            Log.d("Animator", "@animateBottom " + f);
            this.KG.KA.removeMessages(-101);
            this.KG.KA.sendEmptyMessageAtTime(-101, this.GP);
        }
    }
}
