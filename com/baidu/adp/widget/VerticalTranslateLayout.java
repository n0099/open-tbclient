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
    private int FW;
    private int FX;
    private final int Gc;
    private int Gg;
    private final Paint Gj;
    private int Gk;
    private int Gl;
    private final List<d> Gt;
    private float JZ;
    private float Ka;
    private float Kb;
    private float Kc;
    private int Kd;
    private boolean Ke;
    private boolean Kf;
    private TrackDirection Kg;
    private final Rect Kh;
    private final Rect Ki;
    private int Kj;
    private boolean Kk;
    private final a Kl;
    private final b Km;
    private final g Kn;
    private e Ko;
    private c Kp;
    private f Kq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (Ks) with 'values()' method */
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
        void mw();

        void nM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mu();

        void mv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void ms();

        void nN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void ay(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Gj.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Kd = (int) ((this.JZ - this.FX) * (-f2));
            } else if (f2 > 0.0f) {
                this.Kd = (int) ((this.FX - this.Kb) * f2);
            } else if (f2 == 0.0f) {
                this.Kd = 0;
                this.Gg = 10004;
            } else if (f2 == -1.0f) {
                this.JZ -= this.FX;
                this.Gg = 10000;
            } else if (f2 == 1.0f) {
                this.JZ = this.FX - this.Kb;
                this.Gg = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.JZ;
    }

    public int getBottomOffset() {
        return (int) this.Kb;
    }

    public void setTopTapBack(boolean z) {
        this.Ke = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Kf = z;
    }

    public int getState() {
        return this.Gg;
    }

    public void setTopAnimationListener(e eVar) {
        this.Ko = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Kp = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Kq = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Kd);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Kd);
        canvas.drawRect(0.0f, 0.0f, this.FW, this.FX, this.Gj);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Kd;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Kg == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Gg == 10004) {
            switch (action) {
                case 0:
                    this.Gk = x;
                    this.Gl = y;
                    this.Kl.removeMessages(-100);
                    this.Kl.removeMessages(-104);
                    this.Kl.removeMessages(-101);
                    this.Kl.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Kd);
                    return g(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean g(int i, int i2) {
        return i >= this.Gk - this.Gc && i <= this.Gk + this.Gc && (i2 < this.Gl - this.Gc || i2 > this.Gl + this.Gc) && this.Kn.aq(i2 - this.Gl);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Gg == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.Kk = false;
                    if (this.Kn.GF) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.Kn.my();
                        this.Kn.mz();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Kn.GF) {
                        if (!this.Kk) {
                            if (y > this.Gl) {
                                this.Kj = this.Gl + this.Gc;
                                this.Kk = true;
                            } else {
                                this.Kj = this.Gl - this.Gc;
                                this.Kk = true;
                            }
                        }
                        this.Kn.ar(this.Kj - y);
                        this.Kj = y;
                        this.Kn.GE.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Gg != 10000 || !this.Kh.contains(x, y)) && (this.Gg != 10001 || !this.Ki.contains(x, y))) {
                    return false;
                }
                if (!this.Kn.GF) {
                    this.Kj = y;
                    this.Kn.aq(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Kn.GF) {
                    this.Kn.my();
                    this.Kn.mz();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Kn.GF) {
            this.Kn.ar(this.Kj - y);
            this.Kj = y;
            this.Kn.GE.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.JZ != -1.0f) {
                this.Kh.set(i, i2, i3, (int) (i2 + this.JZ));
            }
            if (this.Kb != -1.0f) {
                this.Ki.set(i, (int) (i4 - this.Kb), i3, i4);
            }
        }
        if (!this.Km.GC && !this.Kn.GF) {
            mm();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Ka != -1.0f) {
            this.JZ = i3 - this.Kc;
        }
        if (this.Kc != -1.0f) {
            this.Kb = i3 - this.Ka;
        }
        if (!$assertionsDisabled && i3 < this.JZ) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Kb) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.FW = getMeasuredWidth();
        this.FX = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm() {
        switch (this.Gg) {
            case 10000:
                this.Kd = (int) (this.JZ - this.FX);
                invalidate();
                return;
            case 10001:
                this.Kd = (int) (this.FX - this.Kb);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Kd = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Kr;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Kr.Km.GC) {
                switch (message.what) {
                    case -105:
                        this.Kr.Km.nL();
                        return;
                    case -104:
                        this.Kr.Km.nK();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Kr.Km.nJ();
                        return;
                    case -100:
                        this.Kr.Km.nI();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Kt;
        VelocityTracker GE;
        boolean GF;
        final int GG;
        final int GH;
        final /* synthetic */ VerticalTranslateLayout Kr;

        static /* synthetic */ int[] nO() {
            int[] iArr = Kt;
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
                Kt = iArr;
            }
            return iArr;
        }

        boolean aq(int i) {
            switch (nO()[this.Kr.Kg.ordinal()]) {
                case 1:
                    if (this.Kr.Gg != 10004 && this.Kr.Gg != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Kr.Gg != 10004 && this.Kr.Gg != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Kr.Kq != null) {
                        this.Kr.Kq.ay(i);
                        break;
                    }
                    break;
            }
            this.GE = VelocityTracker.obtain();
            this.GF = true;
            return true;
        }

        void my() {
            this.GF = false;
        }

        void ar(int i) {
            if (this.GF) {
                int i2 = this.Kr.Kd - i;
                switch (nO()[this.Kr.Kg.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.Kr.JZ - this.Kr.FX && i2 < 0) {
                            this.Kr.Kd -= i;
                            this.Kr.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.Kr.FX - this.Kr.Kb && i2 > 0) {
                            this.Kr.Kd -= i;
                            this.Kr.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.Kr.JZ - this.Kr.FX && i2 <= this.Kr.FX - this.Kr.Kb) {
                            this.Kr.Kd -= i;
                            this.Kr.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mz() {
            float max;
            this.GE.computeCurrentVelocity(this.GG);
            float yVelocity = this.GE.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.GH);
            } else {
                max = Math.max(yVelocity, this.GH);
            }
            switch (nO()[this.Kr.Kg.ordinal()]) {
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
            this.GE.recycle();
            this.GE = null;
        }

        private void q(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.Kr.Kd;
            if (i <= 0 && i >= this.Kr.JZ - this.Kr.FX) {
                if (f < 0.0f) {
                    this.Kr.Km.o(f);
                } else {
                    this.Kr.Km.m(f);
                }
            } else if (i >= 0 && i <= this.Kr.FX - this.Kr.Kb) {
                if (f < 0.0f) {
                    this.Kr.Km.n(f);
                } else {
                    this.Kr.Km.p(f);
                }
            }
        }

        private void r(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.Kr.Km.o(f);
            } else {
                this.Kr.Km.m(f);
            }
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.Kr.Km.n(f);
            } else {
                this.Kr.Km.p(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        long GA;
        long GB;
        boolean GC;
        float Gw;
        float Gx;
        float Gy;
        float Gz;
        final /* synthetic */ VerticalTranslateLayout Kr;

        private void mn() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gw = ((((float) (uptimeMillis - this.GA)) / 1000.0f) * this.Gx) + this.Gw;
            this.GA = uptimeMillis;
            this.GB += 16;
        }

        void nI() {
            mn();
            if (this.Gw <= this.Gy) {
                e eVar = this.Kr.Ko;
                if (eVar != null) {
                    eVar.nN();
                }
                this.GC = false;
                this.Kr.Gg = 10000;
                this.Kr.mm();
                return;
            }
            this.Kr.Kd = (int) (com.baidu.adp.widget.a.a(this.Gy, this.Gw, false) + this.Gz);
            this.Kr.invalidate();
            this.Kr.Kl.sendEmptyMessageAtTime(-100, this.GB);
        }

        void nJ() {
            mn();
            if (this.Gw >= this.Gy) {
                c cVar = this.Kr.Kp;
                if (cVar != null) {
                    cVar.nM();
                }
                this.GC = false;
                this.Kr.Gg = 10001;
                this.Kr.mm();
                return;
            }
            this.Kr.Kd = (int) (com.baidu.adp.widget.a.a(this.Gy, this.Gw, false) + this.Gz);
            this.Kr.invalidate();
            this.Kr.Kl.sendEmptyMessageAtTime(-101, this.GB);
        }

        void nK() {
            mn();
            if (this.Gw >= this.Gy) {
                for (d dVar : this.Kr.Gt) {
                    if (dVar != null) {
                        dVar.mv();
                    }
                }
                this.GC = false;
                this.Kr.Gg = 10004;
                this.Kr.mm();
                return;
            }
            this.Kr.Kd = (int) (com.baidu.adp.widget.a.a(this.Gy, this.Gw, false) + this.Gz);
            this.Kr.invalidate();
            this.Kr.Kl.sendEmptyMessageAtTime(-104, this.GB);
        }

        void nL() {
            mn();
            if (this.Gw <= this.Gy) {
                for (d dVar : this.Kr.Gt) {
                    if (dVar != null) {
                        dVar.mv();
                    }
                }
                this.GC = false;
                this.Kr.Gg = 10004;
                this.Kr.mm();
                return;
            }
            this.Kr.Kd = (int) (com.baidu.adp.widget.a.a(this.Gy, this.Gw, false) + this.Gz);
            this.Kr.invalidate();
            this.Kr.Kl.sendEmptyMessageAtTime(-105, this.GB);
        }

        void m(float f) {
            for (d dVar : this.Kr.Gt) {
                if (dVar != null) {
                    dVar.mu();
                }
            }
            this.GC = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GA = uptimeMillis;
            this.GB = uptimeMillis + 16;
            this.Gx = f;
            this.Gw = 0.0f;
            this.Gy = 0 - this.Kr.Kd;
            this.Gz = this.Kr.Kd;
            this.Kr.Kl.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.Gy);
            Log.d("Animator", "@animateTopOpen " + f);
            this.Kr.Kl.sendEmptyMessageAtTime(-104, this.GB);
        }

        void n(float f) {
            for (d dVar : this.Kr.Gt) {
                if (dVar != null) {
                    dVar.mu();
                }
            }
            this.GC = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GA = uptimeMillis;
            this.GB = uptimeMillis + 16;
            this.Gx = f;
            this.Gw = 0.0f;
            this.Gy = 0 - this.Kr.Kd;
            this.Gz = this.Kr.Kd;
            Log.d("Animator", "@animateBottomOpen " + this.Gy);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.Kr.Kl.removeMessages(-105);
            this.Kr.Kl.sendEmptyMessageAtTime(-105, this.GB);
        }

        void o(float f) {
            e eVar = this.Kr.Ko;
            if (eVar != null) {
                eVar.ms();
            }
            this.GC = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GA = uptimeMillis;
            this.GB = uptimeMillis + 16;
            this.Gx = f;
            this.Gw = 0.0f;
            this.Gy = ((-this.Kr.FX) + this.Kr.JZ) - this.Kr.Kd;
            this.Gz = this.Kr.Kd;
            Log.d("Animator", "@animateTop " + this.Gy);
            Log.d("Animator", "@animateTop " + f);
            this.Kr.Kl.removeMessages(-100);
            this.Kr.Kl.sendEmptyMessageAtTime(-100, this.GB);
        }

        void p(float f) {
            c cVar = this.Kr.Kp;
            if (cVar != null) {
                cVar.mw();
            }
            this.GC = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GA = uptimeMillis;
            this.GB = uptimeMillis + 16;
            this.Gx = f;
            this.Gw = 0.0f;
            this.Gy = (this.Kr.FX - this.Kr.Kb) - this.Kr.Kd;
            this.Gz = this.Kr.Kd;
            Log.d("Animator", "@animateBottom " + this.Gy);
            Log.d("Animator", "@animateBottom " + f);
            this.Kr.Kl.removeMessages(-101);
            this.Kr.Kl.sendEmptyMessageAtTime(-101, this.GB);
        }
    }
}
