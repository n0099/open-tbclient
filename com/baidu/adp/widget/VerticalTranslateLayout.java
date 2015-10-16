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
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int FA;
    private final Paint FD;
    private int FE;
    private int FF;
    private final List<d> FN;
    private int Fq;
    private int Fr;
    private final int Fw;
    private final Rect JA;
    private int JB;
    private boolean JC;
    private final a JD;
    private final b JE;
    private final g JF;
    private e JG;
    private c JH;
    private f JI;
    private float Jr;
    private float Js;
    private float Jt;
    private float Ju;
    private int Jv;
    private boolean Jw;
    private boolean Jx;
    private TrackDirection Jy;
    private final Rect Jz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (JK) with 'values()' method */
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
        void mT();

        void oh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mR();

        void mS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mP();

        void oi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aE(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FD.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Jv = (int) ((this.Jr - this.Fr) * (-f2));
            } else if (f2 > 0.0f) {
                this.Jv = (int) ((this.Fr - this.Jt) * f2);
            } else if (f2 == 0.0f) {
                this.Jv = 0;
                this.FA = 10004;
            } else if (f2 == -1.0f) {
                this.Jr -= this.Fr;
                this.FA = 10000;
            } else if (f2 == 1.0f) {
                this.Jr = this.Fr - this.Jt;
                this.FA = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Jr;
    }

    public int getBottomOffset() {
        return (int) this.Jt;
    }

    public void setTopTapBack(boolean z) {
        this.Jw = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Jx = z;
    }

    public int getState() {
        return this.FA;
    }

    public void setTopAnimationListener(e eVar) {
        this.JG = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.JH = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.JI = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Jv);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Jv);
        canvas.drawRect(0.0f, 0.0f, this.Fq, this.Fr, this.FD);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Jv;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Jy == TrackDirection.none) {
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
                    this.JD.removeMessages(-100);
                    this.JD.removeMessages(-104);
                    this.JD.removeMessages(-101);
                    this.JD.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Jv);
                    return h(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i >= this.FE - this.Fw && i <= this.FE + this.Fw && (i2 < this.FF - this.Fw || i2 > this.FF + this.Fw) && this.JF.aw(i2 - this.FF);
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
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.JC = false;
                    if (this.JF.FZ) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.JF.mV();
                        this.JF.mW();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JF.FZ) {
                        if (!this.JC) {
                            if (y > this.FF) {
                                this.JB = this.FF + this.Fw;
                                this.JC = true;
                            } else {
                                this.JB = this.FF - this.Fw;
                                this.JC = true;
                            }
                        }
                        this.JF.ax(this.JB - y);
                        this.JB = y;
                        this.JF.FY.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.FA != 10000 || !this.Jz.contains(x, y)) && (this.FA != 10001 || !this.JA.contains(x, y))) {
                    return false;
                }
                if (!this.JF.FZ) {
                    this.JB = y;
                    this.JF.aw(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JF.FZ) {
                    this.JF.mV();
                    this.JF.mW();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JF.FZ) {
            this.JF.ax(this.JB - y);
            this.JB = y;
            this.JF.FY.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Jr != -1.0f) {
                this.Jz.set(i, i2, i3, (int) (i2 + this.Jr));
            }
            if (this.Jt != -1.0f) {
                this.JA.set(i, (int) (i4 - this.Jt), i3, i4);
            }
        }
        if (!this.JE.FW && !this.JF.FZ) {
            mJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Js != -1.0f) {
            this.Jr = i3 - this.Ju;
        }
        if (this.Ju != -1.0f) {
            this.Jt = i3 - this.Js;
        }
        if (!$assertionsDisabled && i3 < this.Jr) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Jt) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fq = getMeasuredWidth();
        this.Fr = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        switch (this.FA) {
            case 10000:
                this.Jv = (int) (this.Jr - this.Fr);
                invalidate();
                return;
            case 10001:
                this.Jv = (int) (this.Fr - this.Jt);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Jv = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout JJ;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.JJ.JE.FW) {
                switch (message.what) {
                    case -105:
                        this.JJ.JE.og();
                        return;
                    case -104:
                        this.JJ.JE.of();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.JJ.JE.oe();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        this.JJ.JE.od();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] JL;
        VelocityTracker FY;
        boolean FZ;
        final int Ga;
        final int Gb;
        final /* synthetic */ VerticalTranslateLayout JJ;

        static /* synthetic */ int[] oj() {
            int[] iArr = JL;
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
                JL = iArr;
            }
            return iArr;
        }

        boolean aw(int i) {
            switch (oj()[this.JJ.Jy.ordinal()]) {
                case 1:
                    if (this.JJ.FA != 10004 && this.JJ.FA != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.JJ.FA != 10004 && this.JJ.FA != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.JJ.JI != null) {
                        this.JJ.JI.aE(i);
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
                int i2 = this.JJ.Jv - i;
                switch (oj()[this.JJ.Jy.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.JJ.Jr - this.JJ.Fr && i2 < 0) {
                            this.JJ.Jv -= i;
                            this.JJ.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.JJ.Fr - this.JJ.Jt && i2 > 0) {
                            this.JJ.Jv -= i;
                            this.JJ.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.JJ.Jr - this.JJ.Fr && i2 <= this.JJ.Fr - this.JJ.Jt) {
                            this.JJ.Jv -= i;
                            this.JJ.invalidate();
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
            float yVelocity = this.FY.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Gb);
            } else {
                max = Math.max(yVelocity, this.Gb);
            }
            switch (oj()[this.JJ.Jy.ordinal()]) {
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
            this.FY.recycle();
            this.FY = null;
        }

        private void q(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.JJ.Jv;
            if (i <= 0 && i >= this.JJ.Jr - this.JJ.Fr) {
                if (f < 0.0f) {
                    this.JJ.JE.o(f);
                } else {
                    this.JJ.JE.m(f);
                }
            } else if (i >= 0 && i <= this.JJ.Fr - this.JJ.Jt) {
                if (f < 0.0f) {
                    this.JJ.JE.n(f);
                } else {
                    this.JJ.JE.p(f);
                }
            }
        }

        private void r(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.JJ.JE.o(f);
            } else {
                this.JJ.JE.m(f);
            }
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.JJ.JE.n(f);
            } else {
                this.JJ.JE.p(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float FQ;
        float FR;
        float FS;
        float FT;
        long FU;
        long FV;
        boolean FW;
        final /* synthetic */ VerticalTranslateLayout JJ;

        private void mK() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = ((((float) (uptimeMillis - this.FU)) / 1000.0f) * this.FR) + this.FQ;
            this.FU = uptimeMillis;
            this.FV += 16;
        }

        void od() {
            mK();
            if (this.FQ <= this.FS) {
                e eVar = this.JJ.JG;
                if (eVar != null) {
                    eVar.oi();
                }
                this.FW = false;
                this.JJ.FA = 10000;
                this.JJ.mJ();
                return;
            }
            this.JJ.Jv = (int) (com.baidu.adp.widget.a.a(this.FS, this.FQ, false) + this.FT);
            this.JJ.invalidate();
            this.JJ.JD.sendEmptyMessageAtTime(-100, this.FV);
        }

        void oe() {
            mK();
            if (this.FQ >= this.FS) {
                c cVar = this.JJ.JH;
                if (cVar != null) {
                    cVar.oh();
                }
                this.FW = false;
                this.JJ.FA = 10001;
                this.JJ.mJ();
                return;
            }
            this.JJ.Jv = (int) (com.baidu.adp.widget.a.a(this.FS, this.FQ, false) + this.FT);
            this.JJ.invalidate();
            this.JJ.JD.sendEmptyMessageAtTime(-101, this.FV);
        }

        void of() {
            mK();
            if (this.FQ >= this.FS) {
                for (d dVar : this.JJ.FN) {
                    if (dVar != null) {
                        dVar.mS();
                    }
                }
                this.FW = false;
                this.JJ.FA = 10004;
                this.JJ.mJ();
                return;
            }
            this.JJ.Jv = (int) (com.baidu.adp.widget.a.a(this.FS, this.FQ, false) + this.FT);
            this.JJ.invalidate();
            this.JJ.JD.sendEmptyMessageAtTime(-104, this.FV);
        }

        void og() {
            mK();
            if (this.FQ <= this.FS) {
                for (d dVar : this.JJ.FN) {
                    if (dVar != null) {
                        dVar.mS();
                    }
                }
                this.FW = false;
                this.JJ.FA = 10004;
                this.JJ.mJ();
                return;
            }
            this.JJ.Jv = (int) (com.baidu.adp.widget.a.a(this.FS, this.FQ, false) + this.FT);
            this.JJ.invalidate();
            this.JJ.JD.sendEmptyMessageAtTime(-105, this.FV);
        }

        void m(float f) {
            for (d dVar : this.JJ.FN) {
                if (dVar != null) {
                    dVar.mR();
                }
            }
            this.FW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FU = uptimeMillis;
            this.FV = uptimeMillis + 16;
            this.FR = f;
            this.FQ = 0.0f;
            this.FS = 0 - this.JJ.Jv;
            this.FT = this.JJ.Jv;
            this.JJ.JD.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.FS);
            Log.d("Animator", "@animateTopOpen " + f);
            this.JJ.JD.sendEmptyMessageAtTime(-104, this.FV);
        }

        void n(float f) {
            for (d dVar : this.JJ.FN) {
                if (dVar != null) {
                    dVar.mR();
                }
            }
            this.FW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FU = uptimeMillis;
            this.FV = uptimeMillis + 16;
            this.FR = f;
            this.FQ = 0.0f;
            this.FS = 0 - this.JJ.Jv;
            this.FT = this.JJ.Jv;
            Log.d("Animator", "@animateBottomOpen " + this.FS);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.JJ.JD.removeMessages(-105);
            this.JJ.JD.sendEmptyMessageAtTime(-105, this.FV);
        }

        void o(float f) {
            e eVar = this.JJ.JG;
            if (eVar != null) {
                eVar.mP();
            }
            this.FW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FU = uptimeMillis;
            this.FV = uptimeMillis + 16;
            this.FR = f;
            this.FQ = 0.0f;
            this.FS = ((-this.JJ.Fr) + this.JJ.Jr) - this.JJ.Jv;
            this.FT = this.JJ.Jv;
            Log.d("Animator", "@animateTop " + this.FS);
            Log.d("Animator", "@animateTop " + f);
            this.JJ.JD.removeMessages(-100);
            this.JJ.JD.sendEmptyMessageAtTime(-100, this.FV);
        }

        void p(float f) {
            c cVar = this.JJ.JH;
            if (cVar != null) {
                cVar.mT();
            }
            this.FW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FU = uptimeMillis;
            this.FV = uptimeMillis + 16;
            this.FR = f;
            this.FQ = 0.0f;
            this.FS = (this.JJ.Fr - this.JJ.Jt) - this.JJ.Jv;
            this.FT = this.JJ.Jv;
            Log.d("Animator", "@animateBottom " + this.FS);
            Log.d("Animator", "@animateBottom " + f);
            this.JJ.JD.removeMessages(-101);
            this.JJ.JD.sendEmptyMessageAtTime(-101, this.FV);
        }
    }
}
