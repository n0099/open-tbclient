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
    private int FB;
    private final Paint FE;
    private int FF;
    private int FG;
    private final List<d> FO;
    private int Fr;
    private int Fs;
    private final int Fx;
    private final Rect JA;
    private final Rect JB;
    private int JC;
    private boolean JD;
    private final a JE;
    private final b JF;
    private final g JG;
    private e JH;
    private c JI;
    private f JJ;
    private float Js;
    private float Jt;
    private float Ju;
    private float Jv;
    private int Jw;
    private boolean Jx;
    private boolean Jy;
    private TrackDirection Jz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (JL) with 'values()' method */
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
        void mU();

        void oi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mS();

        void mT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mQ();

        void oj();
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
        this.FE.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Jw = (int) ((this.Js - this.Fs) * (-f2));
            } else if (f2 > 0.0f) {
                this.Jw = (int) ((this.Fs - this.Ju) * f2);
            } else if (f2 == 0.0f) {
                this.Jw = 0;
                this.FB = 10004;
            } else if (f2 == -1.0f) {
                this.Js -= this.Fs;
                this.FB = 10000;
            } else if (f2 == 1.0f) {
                this.Js = this.Fs - this.Ju;
                this.FB = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Js;
    }

    public int getBottomOffset() {
        return (int) this.Ju;
    }

    public void setTopTapBack(boolean z) {
        this.Jx = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Jy = z;
    }

    public int getState() {
        return this.FB;
    }

    public void setTopAnimationListener(e eVar) {
        this.JH = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.JI = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.JJ = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Jw);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Jw);
        canvas.drawRect(0.0f, 0.0f, this.Fr, this.Fs, this.FE);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Jw;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Jz == TrackDirection.none) {
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
                    this.JE.removeMessages(-100);
                    this.JE.removeMessages(-104);
                    this.JE.removeMessages(-101);
                    this.JE.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Jw);
                    return h(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i >= this.FF - this.Fx && i <= this.FF + this.Fx && (i2 < this.FG - this.Fx || i2 > this.FG + this.Fx) && this.JG.aw(i2 - this.FG);
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
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.JD = false;
                    if (this.JG.Ga) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.JG.mW();
                        this.JG.mX();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JG.Ga) {
                        if (!this.JD) {
                            if (y > this.FG) {
                                this.JC = this.FG + this.Fx;
                                this.JD = true;
                            } else {
                                this.JC = this.FG - this.Fx;
                                this.JD = true;
                            }
                        }
                        this.JG.ax(this.JC - y);
                        this.JC = y;
                        this.JG.FZ.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.FB != 10000 || !this.JA.contains(x, y)) && (this.FB != 10001 || !this.JB.contains(x, y))) {
                    return false;
                }
                if (!this.JG.Ga) {
                    this.JC = y;
                    this.JG.aw(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JG.Ga) {
                    this.JG.mW();
                    this.JG.mX();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JG.Ga) {
            this.JG.ax(this.JC - y);
            this.JC = y;
            this.JG.FZ.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Js != -1.0f) {
                this.JA.set(i, i2, i3, (int) (i2 + this.Js));
            }
            if (this.Ju != -1.0f) {
                this.JB.set(i, (int) (i4 - this.Ju), i3, i4);
            }
        }
        if (!this.JF.FX && !this.JG.Ga) {
            mK();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Jt != -1.0f) {
            this.Js = i3 - this.Jv;
        }
        if (this.Jv != -1.0f) {
            this.Ju = i3 - this.Jt;
        }
        if (!$assertionsDisabled && i3 < this.Js) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Ju) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fr = getMeasuredWidth();
        this.Fs = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mK() {
        switch (this.FB) {
            case 10000:
                this.Jw = (int) (this.Js - this.Fs);
                invalidate();
                return;
            case 10001:
                this.Jw = (int) (this.Fs - this.Ju);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Jw = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout JK;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.JK.JF.FX) {
                switch (message.what) {
                    case -105:
                        this.JK.JF.oh();
                        return;
                    case -104:
                        this.JK.JF.og();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.JK.JF.of();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        this.JK.JF.oe();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] JM;
        VelocityTracker FZ;
        boolean Ga;
        final int Gb;
        final int Gc;
        final /* synthetic */ VerticalTranslateLayout JK;

        static /* synthetic */ int[] ok() {
            int[] iArr = JM;
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
                JM = iArr;
            }
            return iArr;
        }

        boolean aw(int i) {
            switch (ok()[this.JK.Jz.ordinal()]) {
                case 1:
                    if (this.JK.FB != 10004 && this.JK.FB != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.JK.FB != 10004 && this.JK.FB != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.JK.JJ != null) {
                        this.JK.JJ.aE(i);
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
                int i2 = this.JK.Jw - i;
                switch (ok()[this.JK.Jz.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.JK.Js - this.JK.Fs && i2 < 0) {
                            this.JK.Jw -= i;
                            this.JK.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.JK.Fs - this.JK.Ju && i2 > 0) {
                            this.JK.Jw -= i;
                            this.JK.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.JK.Js - this.JK.Fs && i2 <= this.JK.Fs - this.JK.Ju) {
                            this.JK.Jw -= i;
                            this.JK.invalidate();
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
            float yVelocity = this.FZ.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Gc);
            } else {
                max = Math.max(yVelocity, this.Gc);
            }
            switch (ok()[this.JK.Jz.ordinal()]) {
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
            this.FZ.recycle();
            this.FZ = null;
        }

        private void q(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.JK.Jw;
            if (i <= 0 && i >= this.JK.Js - this.JK.Fs) {
                if (f < 0.0f) {
                    this.JK.JF.o(f);
                } else {
                    this.JK.JF.m(f);
                }
            } else if (i >= 0 && i <= this.JK.Fs - this.JK.Ju) {
                if (f < 0.0f) {
                    this.JK.JF.n(f);
                } else {
                    this.JK.JF.p(f);
                }
            }
        }

        private void r(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.JK.JF.o(f);
            } else {
                this.JK.JF.m(f);
            }
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.JK.JF.n(f);
            } else {
                this.JK.JF.p(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float FR;
        float FS;
        float FT;
        float FU;
        long FV;
        long FW;
        boolean FX;
        final /* synthetic */ VerticalTranslateLayout JK;

        private void mL() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = ((((float) (uptimeMillis - this.FV)) / 1000.0f) * this.FS) + this.FR;
            this.FV = uptimeMillis;
            this.FW += 16;
        }

        void oe() {
            mL();
            if (this.FR <= this.FT) {
                e eVar = this.JK.JH;
                if (eVar != null) {
                    eVar.oj();
                }
                this.FX = false;
                this.JK.FB = 10000;
                this.JK.mK();
                return;
            }
            this.JK.Jw = (int) (com.baidu.adp.widget.a.a(this.FT, this.FR, false) + this.FU);
            this.JK.invalidate();
            this.JK.JE.sendEmptyMessageAtTime(-100, this.FW);
        }

        void of() {
            mL();
            if (this.FR >= this.FT) {
                c cVar = this.JK.JI;
                if (cVar != null) {
                    cVar.oi();
                }
                this.FX = false;
                this.JK.FB = 10001;
                this.JK.mK();
                return;
            }
            this.JK.Jw = (int) (com.baidu.adp.widget.a.a(this.FT, this.FR, false) + this.FU);
            this.JK.invalidate();
            this.JK.JE.sendEmptyMessageAtTime(-101, this.FW);
        }

        void og() {
            mL();
            if (this.FR >= this.FT) {
                for (d dVar : this.JK.FO) {
                    if (dVar != null) {
                        dVar.mT();
                    }
                }
                this.FX = false;
                this.JK.FB = 10004;
                this.JK.mK();
                return;
            }
            this.JK.Jw = (int) (com.baidu.adp.widget.a.a(this.FT, this.FR, false) + this.FU);
            this.JK.invalidate();
            this.JK.JE.sendEmptyMessageAtTime(-104, this.FW);
        }

        void oh() {
            mL();
            if (this.FR <= this.FT) {
                for (d dVar : this.JK.FO) {
                    if (dVar != null) {
                        dVar.mT();
                    }
                }
                this.FX = false;
                this.JK.FB = 10004;
                this.JK.mK();
                return;
            }
            this.JK.Jw = (int) (com.baidu.adp.widget.a.a(this.FT, this.FR, false) + this.FU);
            this.JK.invalidate();
            this.JK.JE.sendEmptyMessageAtTime(-105, this.FW);
        }

        void m(float f) {
            for (d dVar : this.JK.FO) {
                if (dVar != null) {
                    dVar.mS();
                }
            }
            this.FX = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FV = uptimeMillis;
            this.FW = uptimeMillis + 16;
            this.FS = f;
            this.FR = 0.0f;
            this.FT = 0 - this.JK.Jw;
            this.FU = this.JK.Jw;
            this.JK.JE.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.FT);
            Log.d("Animator", "@animateTopOpen " + f);
            this.JK.JE.sendEmptyMessageAtTime(-104, this.FW);
        }

        void n(float f) {
            for (d dVar : this.JK.FO) {
                if (dVar != null) {
                    dVar.mS();
                }
            }
            this.FX = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FV = uptimeMillis;
            this.FW = uptimeMillis + 16;
            this.FS = f;
            this.FR = 0.0f;
            this.FT = 0 - this.JK.Jw;
            this.FU = this.JK.Jw;
            Log.d("Animator", "@animateBottomOpen " + this.FT);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.JK.JE.removeMessages(-105);
            this.JK.JE.sendEmptyMessageAtTime(-105, this.FW);
        }

        void o(float f) {
            e eVar = this.JK.JH;
            if (eVar != null) {
                eVar.mQ();
            }
            this.FX = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FV = uptimeMillis;
            this.FW = uptimeMillis + 16;
            this.FS = f;
            this.FR = 0.0f;
            this.FT = ((-this.JK.Fs) + this.JK.Js) - this.JK.Jw;
            this.FU = this.JK.Jw;
            Log.d("Animator", "@animateTop " + this.FT);
            Log.d("Animator", "@animateTop " + f);
            this.JK.JE.removeMessages(-100);
            this.JK.JE.sendEmptyMessageAtTime(-100, this.FW);
        }

        void p(float f) {
            c cVar = this.JK.JI;
            if (cVar != null) {
                cVar.mU();
            }
            this.FX = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FV = uptimeMillis;
            this.FW = uptimeMillis + 16;
            this.FS = f;
            this.FR = 0.0f;
            this.FT = (this.JK.Fs - this.JK.Ju) - this.JK.Jw;
            this.FU = this.JK.Jw;
            Log.d("Animator", "@animateBottom " + this.FT);
            Log.d("Animator", "@animateBottom " + f);
            this.JK.JE.removeMessages(-101);
            this.JK.JE.sendEmptyMessageAtTime(-101, this.FW);
        }
    }
}
