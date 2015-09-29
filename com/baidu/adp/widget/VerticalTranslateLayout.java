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
    private final Paint FC;
    private int FD;
    private int FE;
    private final List<d> FM;
    private int Fp;
    private int Fq;
    private final int Fv;
    private int Fz;
    private int JA;
    private boolean JB;
    private final a JC;
    private final b JD;
    private final g JE;
    private e JF;
    private c JG;
    private f JH;
    private float Jq;
    private float Jr;
    private float Js;
    private float Jt;
    private int Ju;
    private boolean Jv;
    private boolean Jw;
    private TrackDirection Jx;
    private final Rect Jy;
    private final Rect Jz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (JJ) with 'values()' method */
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
        this.FC.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Ju = (int) ((this.Jq - this.Fq) * (-f2));
            } else if (f2 > 0.0f) {
                this.Ju = (int) ((this.Fq - this.Js) * f2);
            } else if (f2 == 0.0f) {
                this.Ju = 0;
                this.Fz = 10004;
            } else if (f2 == -1.0f) {
                this.Jq -= this.Fq;
                this.Fz = 10000;
            } else if (f2 == 1.0f) {
                this.Jq = this.Fq - this.Js;
                this.Fz = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Jq;
    }

    public int getBottomOffset() {
        return (int) this.Js;
    }

    public void setTopTapBack(boolean z) {
        this.Jv = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Jw = z;
    }

    public int getState() {
        return this.Fz;
    }

    public void setTopAnimationListener(e eVar) {
        this.JF = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.JG = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.JH = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Ju);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Ju);
        canvas.drawRect(0.0f, 0.0f, this.Fp, this.Fq, this.FC);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Ju;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Jx == TrackDirection.none) {
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
                    this.JC.removeMessages(-100);
                    this.JC.removeMessages(-104);
                    this.JC.removeMessages(-101);
                    this.JC.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Ju);
                    return h(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i >= this.FD - this.Fv && i <= this.FD + this.Fv && (i2 < this.FE - this.Fv || i2 > this.FE + this.Fv) && this.JE.aw(i2 - this.FE);
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
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.JB = false;
                    if (this.JE.FY) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.JE.mV();
                        this.JE.mW();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JE.FY) {
                        if (!this.JB) {
                            if (y > this.FE) {
                                this.JA = this.FE + this.Fv;
                                this.JB = true;
                            } else {
                                this.JA = this.FE - this.Fv;
                                this.JB = true;
                            }
                        }
                        this.JE.ax(this.JA - y);
                        this.JA = y;
                        this.JE.FX.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Fz != 10000 || !this.Jy.contains(x, y)) && (this.Fz != 10001 || !this.Jz.contains(x, y))) {
                    return false;
                }
                if (!this.JE.FY) {
                    this.JA = y;
                    this.JE.aw(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JE.FY) {
                    this.JE.mV();
                    this.JE.mW();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JE.FY) {
            this.JE.ax(this.JA - y);
            this.JA = y;
            this.JE.FX.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Jq != -1.0f) {
                this.Jy.set(i, i2, i3, (int) (i2 + this.Jq));
            }
            if (this.Js != -1.0f) {
                this.Jz.set(i, (int) (i4 - this.Js), i3, i4);
            }
        }
        if (!this.JD.FV && !this.JE.FY) {
            mJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Jr != -1.0f) {
            this.Jq = i3 - this.Jt;
        }
        if (this.Jt != -1.0f) {
            this.Js = i3 - this.Jr;
        }
        if (!$assertionsDisabled && i3 < this.Jq) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Js) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fp = getMeasuredWidth();
        this.Fq = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        switch (this.Fz) {
            case 10000:
                this.Ju = (int) (this.Jq - this.Fq);
                invalidate();
                return;
            case 10001:
                this.Ju = (int) (this.Fq - this.Js);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Ju = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout JI;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.JI.JD.FV) {
                switch (message.what) {
                    case -105:
                        this.JI.JD.og();
                        return;
                    case -104:
                        this.JI.JD.of();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.JI.JD.oe();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        this.JI.JD.od();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] JK;
        VelocityTracker FX;
        boolean FY;
        final int FZ;
        final int Ga;
        final /* synthetic */ VerticalTranslateLayout JI;

        static /* synthetic */ int[] oj() {
            int[] iArr = JK;
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
                JK = iArr;
            }
            return iArr;
        }

        boolean aw(int i) {
            switch (oj()[this.JI.Jx.ordinal()]) {
                case 1:
                    if (this.JI.Fz != 10004 && this.JI.Fz != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.JI.Fz != 10004 && this.JI.Fz != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.JI.JH != null) {
                        this.JI.JH.aE(i);
                        break;
                    }
                    break;
            }
            this.FX = VelocityTracker.obtain();
            this.FY = true;
            return true;
        }

        void mV() {
            this.FY = false;
        }

        void ax(int i) {
            if (this.FY) {
                int i2 = this.JI.Ju - i;
                switch (oj()[this.JI.Jx.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.JI.Jq - this.JI.Fq && i2 < 0) {
                            this.JI.Ju -= i;
                            this.JI.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.JI.Fq - this.JI.Js && i2 > 0) {
                            this.JI.Ju -= i;
                            this.JI.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.JI.Jq - this.JI.Fq && i2 <= this.JI.Fq - this.JI.Js) {
                            this.JI.Ju -= i;
                            this.JI.invalidate();
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
            this.FX.computeCurrentVelocity(this.FZ);
            float yVelocity = this.FX.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ga);
            } else {
                max = Math.max(yVelocity, this.Ga);
            }
            switch (oj()[this.JI.Jx.ordinal()]) {
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
            this.FX.recycle();
            this.FX = null;
        }

        private void q(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.JI.Ju;
            if (i <= 0 && i >= this.JI.Jq - this.JI.Fq) {
                if (f < 0.0f) {
                    this.JI.JD.o(f);
                } else {
                    this.JI.JD.m(f);
                }
            } else if (i >= 0 && i <= this.JI.Fq - this.JI.Js) {
                if (f < 0.0f) {
                    this.JI.JD.n(f);
                } else {
                    this.JI.JD.p(f);
                }
            }
        }

        private void r(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.JI.JD.o(f);
            } else {
                this.JI.JD.m(f);
            }
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.JI.JD.n(f);
            } else {
                this.JI.JD.p(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float FP;
        float FQ;
        float FR;
        float FS;
        long FT;
        long FU;
        boolean FV;
        final /* synthetic */ VerticalTranslateLayout JI;

        private void mK() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FP = ((((float) (uptimeMillis - this.FT)) / 1000.0f) * this.FQ) + this.FP;
            this.FT = uptimeMillis;
            this.FU += 16;
        }

        void od() {
            mK();
            if (this.FP <= this.FR) {
                e eVar = this.JI.JF;
                if (eVar != null) {
                    eVar.oi();
                }
                this.FV = false;
                this.JI.Fz = 10000;
                this.JI.mJ();
                return;
            }
            this.JI.Ju = (int) (com.baidu.adp.widget.a.a(this.FR, this.FP, false) + this.FS);
            this.JI.invalidate();
            this.JI.JC.sendEmptyMessageAtTime(-100, this.FU);
        }

        void oe() {
            mK();
            if (this.FP >= this.FR) {
                c cVar = this.JI.JG;
                if (cVar != null) {
                    cVar.oh();
                }
                this.FV = false;
                this.JI.Fz = 10001;
                this.JI.mJ();
                return;
            }
            this.JI.Ju = (int) (com.baidu.adp.widget.a.a(this.FR, this.FP, false) + this.FS);
            this.JI.invalidate();
            this.JI.JC.sendEmptyMessageAtTime(-101, this.FU);
        }

        void of() {
            mK();
            if (this.FP >= this.FR) {
                for (d dVar : this.JI.FM) {
                    if (dVar != null) {
                        dVar.mS();
                    }
                }
                this.FV = false;
                this.JI.Fz = 10004;
                this.JI.mJ();
                return;
            }
            this.JI.Ju = (int) (com.baidu.adp.widget.a.a(this.FR, this.FP, false) + this.FS);
            this.JI.invalidate();
            this.JI.JC.sendEmptyMessageAtTime(-104, this.FU);
        }

        void og() {
            mK();
            if (this.FP <= this.FR) {
                for (d dVar : this.JI.FM) {
                    if (dVar != null) {
                        dVar.mS();
                    }
                }
                this.FV = false;
                this.JI.Fz = 10004;
                this.JI.mJ();
                return;
            }
            this.JI.Ju = (int) (com.baidu.adp.widget.a.a(this.FR, this.FP, false) + this.FS);
            this.JI.invalidate();
            this.JI.JC.sendEmptyMessageAtTime(-105, this.FU);
        }

        void m(float f) {
            for (d dVar : this.JI.FM) {
                if (dVar != null) {
                    dVar.mR();
                }
            }
            this.FV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FT = uptimeMillis;
            this.FU = uptimeMillis + 16;
            this.FQ = f;
            this.FP = 0.0f;
            this.FR = 0 - this.JI.Ju;
            this.FS = this.JI.Ju;
            this.JI.JC.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.FR);
            Log.d("Animator", "@animateTopOpen " + f);
            this.JI.JC.sendEmptyMessageAtTime(-104, this.FU);
        }

        void n(float f) {
            for (d dVar : this.JI.FM) {
                if (dVar != null) {
                    dVar.mR();
                }
            }
            this.FV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FT = uptimeMillis;
            this.FU = uptimeMillis + 16;
            this.FQ = f;
            this.FP = 0.0f;
            this.FR = 0 - this.JI.Ju;
            this.FS = this.JI.Ju;
            Log.d("Animator", "@animateBottomOpen " + this.FR);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.JI.JC.removeMessages(-105);
            this.JI.JC.sendEmptyMessageAtTime(-105, this.FU);
        }

        void o(float f) {
            e eVar = this.JI.JF;
            if (eVar != null) {
                eVar.mP();
            }
            this.FV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FT = uptimeMillis;
            this.FU = uptimeMillis + 16;
            this.FQ = f;
            this.FP = 0.0f;
            this.FR = ((-this.JI.Fq) + this.JI.Jq) - this.JI.Ju;
            this.FS = this.JI.Ju;
            Log.d("Animator", "@animateTop " + this.FR);
            Log.d("Animator", "@animateTop " + f);
            this.JI.JC.removeMessages(-100);
            this.JI.JC.sendEmptyMessageAtTime(-100, this.FU);
        }

        void p(float f) {
            c cVar = this.JI.JG;
            if (cVar != null) {
                cVar.mT();
            }
            this.FV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FT = uptimeMillis;
            this.FU = uptimeMillis + 16;
            this.FQ = f;
            this.FP = 0.0f;
            this.FR = (this.JI.Fq - this.JI.Js) - this.JI.Ju;
            this.FS = this.JI.Ju;
            Log.d("Animator", "@animateBottom " + this.FR);
            Log.d("Animator", "@animateBottom " + f);
            this.JI.JC.removeMessages(-101);
            this.JI.JC.sendEmptyMessageAtTime(-101, this.FU);
        }
    }
}
