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
import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int HF;
    private float HI;
    private float HJ;
    private int HK;
    private final int HL;
    private boolean HM;
    private boolean HN;
    private TrackDirection HO;
    private int HP;
    private final Rect HQ;
    private final Rect HR;
    private final Paint HS;
    private int HT;
    private int HU;
    private int HV;
    private boolean HW;
    private final a HX;
    private final b HY;
    private final g HZ;
    private d Ia;
    private f Ib;
    private final List<e> Ic;
    private c Id;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void aG(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kL();

        void kM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kN();

        void kO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void kP();

        void kQ();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.HS.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.HK = (int) ((this.HI - this.HF) * (-f2));
            } else if (f2 > 0.0f) {
                this.HK = (int) ((this.HF - this.HJ) * f2);
            } else if (f2 == 0.0f) {
                this.HK = 0;
                this.HP = 10004;
            } else if (f2 == -1.0f) {
                this.HI -= getMeasuredWidth();
                this.HP = 10000;
            } else if (f2 == 1.0f) {
                this.HI = getMeasuredWidth() - this.HJ;
                this.HP = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.HI;
    }

    public int getRightOffset() {
        return (int) this.HJ;
    }

    public void setLeftTapBack(boolean z) {
        this.HM = z;
    }

    public void setRightTapBack(boolean z) {
        this.HN = z;
    }

    public int getState() {
        return this.HP;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Ia = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Ib = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Id = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.HK, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.HK);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.HS);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.HK;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HO == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.HP == 10004) {
            switch (action) {
                case 0:
                    this.HT = x;
                    this.HU = y;
                    this.HX.removeMessages(-100);
                    this.HX.removeMessages(-104);
                    this.HX.removeMessages(-101);
                    this.HX.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.HK, 0.0f);
                    return r(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean r(int i, int i2) {
        return i2 >= this.HU - this.HL && i2 <= this.HU + this.HL && (i < this.HT - this.HL || i > this.HT + this.HL) && this.HZ.aH(i - this.HT);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.HP == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.HW = false;
                    if (this.HZ.Ip) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.HZ.kR();
                        this.HZ.kS();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.HZ.Ip) {
                        if (!this.HW) {
                            if (x > this.HT) {
                                this.HV = this.HT + this.HL;
                                this.HW = true;
                            } else {
                                this.HV = this.HT - this.HL;
                                this.HW = true;
                            }
                        }
                        this.HZ.aI(this.HV - x);
                        this.HV = x;
                        this.HZ.Io.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.HQ);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.HR);
        switch (action) {
            case 0:
                if ((this.HP != 10000 || !this.HQ.contains(x, y)) && (this.HP != 10001 || !this.HR.contains(x, y))) {
                    return false;
                }
                if (!this.HZ.Ip) {
                    this.HV = x;
                    this.HZ.aH(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.HZ.Ip) {
                    this.HZ.kR();
                    this.HZ.kS();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.HZ.Ip) {
            this.HZ.aI(this.HV - x);
            this.HV = x;
            this.HZ.Io.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.HI != -1.0f) {
                this.HQ.set(i, i2, (int) (i + this.HI), i4);
            }
            if (this.HJ != -1.0f) {
                this.HR.set((int) (i3 - this.HJ), i2, i3, i4);
            }
        }
        if (!this.HY.Im && !this.HZ.Ip) {
            kF();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.HI) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.HJ) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.HF = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kF() {
        switch (this.HP) {
            case 10000:
                this.HK = (int) (this.HI - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.HK = (int) (getMeasuredWidth() - this.HJ);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.HK = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout If;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.If.HY.Im) {
                switch (message.what) {
                    case -105:
                        this.If.HY.kK();
                        return;
                    case -104:
                        this.If.HY.kJ();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.If.HY.kI();
                        return;
                    case -100:
                        this.If.HY.kH();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout If;
        VelocityTracker Io;
        boolean Ip;
        final int Iq;
        final int Ir;

        boolean aH(int i) {
            switch (this.If.HO) {
                case left:
                    if (this.If.HP != 10004 && this.If.HP != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.If.HP != 10004 && this.If.HP != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.If.Id != null) {
                        this.If.Id.aG(i);
                        break;
                    }
                    break;
            }
            this.Io = VelocityTracker.obtain();
            this.Ip = true;
            return true;
        }

        void kR() {
            this.Ip = false;
        }

        void aI(int i) {
            if (this.Ip) {
                int i2 = this.If.HK - i;
                switch (this.If.HO) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.If.HI - this.If.getMeasuredWidth() && i2 < 0) {
                            this.If.HK -= i;
                            this.If.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.If.getMeasuredWidth() - this.If.HJ && i2 > 0) {
                            this.If.HK -= i;
                            this.If.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.If.HI - this.If.getMeasuredWidth() && i2 <= this.If.getMeasuredWidth() - this.If.HJ) {
                            this.If.HK -= i;
                            this.If.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kS() {
            float max;
            this.Io.computeCurrentVelocity(this.Iq);
            float xVelocity = this.Io.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Ir);
            } else {
                max = Math.max(xVelocity, this.Ir);
            }
            switch (this.If.HO) {
                case left:
                    D(max);
                    break;
                case right:
                    E(max);
                    break;
                case horizontal:
                    C(max);
                    break;
            }
            this.Io.recycle();
            this.Io = null;
        }

        private void C(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.If.HK;
            if (i <= 0 && i >= this.If.HI - this.If.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.If.HY.A(f);
                } else {
                    this.If.HY.y(f);
                }
            } else if (i >= 0 && i <= this.If.getMeasuredWidth() - this.If.HJ) {
                if (f < 0.0f) {
                    this.If.HY.z(f);
                } else {
                    this.If.HY.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.If.HY.A(f);
            } else {
                this.If.HY.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.If.HY.z(f);
            } else {
                this.If.HY.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout If;
        float Ig;
        float Ih;
        float Ii;
        float Ij;
        long Ik;
        long Il;
        boolean Im;

        private void kG() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ig = ((((float) (uptimeMillis - this.Ik)) / 1000.0f) * this.Ih) + this.Ig;
            this.Ik = uptimeMillis;
            this.Il += 16;
        }

        void kH() {
            kG();
            if (this.Ig <= this.Ii) {
                d dVar = this.If.Ia;
                if (dVar != null) {
                    dVar.kM();
                }
                this.Im = false;
                this.If.HP = 10000;
                this.If.kF();
                return;
            }
            this.If.HK = (int) (com.baidu.adp.widget.e.a(this.Ii, this.Ig, false) + this.Ij);
            this.If.invalidate();
            this.If.HX.sendEmptyMessageAtTime(-100, this.Il);
        }

        void kI() {
            kG();
            if (this.Ig >= this.Ii) {
                f fVar = this.If.Ib;
                if (fVar != null) {
                    fVar.kQ();
                }
                this.Im = false;
                this.If.HP = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.If.kF();
                return;
            }
            this.If.HK = (int) (com.baidu.adp.widget.e.a(this.Ii, this.Ig, false) + this.Ij);
            this.If.invalidate();
            this.If.HX.sendEmptyMessageAtTime(-101, this.Il);
        }

        void kJ() {
            kG();
            if (this.Ig >= this.Ii) {
                for (e eVar : this.If.Ic) {
                    if (eVar != null) {
                        eVar.kO();
                    }
                }
                this.Im = false;
                this.If.HP = 10004;
                this.If.kF();
                return;
            }
            this.If.HK = (int) (com.baidu.adp.widget.e.a(this.Ii, this.Ig, false) + this.Ij);
            this.If.invalidate();
            this.If.HX.sendEmptyMessageAtTime(-104, this.Il);
        }

        void kK() {
            kG();
            if (this.Ig <= this.Ii) {
                for (e eVar : this.If.Ic) {
                    if (eVar != null) {
                        eVar.kO();
                    }
                }
                this.Im = false;
                this.If.HP = 10004;
                this.If.kF();
                return;
            }
            this.If.HK = (int) (com.baidu.adp.widget.e.a(this.Ii, this.Ig, false) + this.Ij);
            this.If.invalidate();
            this.If.HX.sendEmptyMessageAtTime(-105, this.Il);
        }

        void y(float f) {
            for (e eVar : this.If.Ic) {
                if (eVar != null) {
                    eVar.kN();
                }
            }
            this.Im = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ik = uptimeMillis;
            this.Il = uptimeMillis + 16;
            this.Ih = f;
            this.Ig = 0.0f;
            this.Ii = 0 - this.If.HK;
            this.Ij = this.If.HK;
            this.If.HX.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Ii);
            BdLog.d("Animator@animateTopOpen " + f);
            this.If.HX.sendEmptyMessageAtTime(-104, this.Il);
        }

        void z(float f) {
            for (e eVar : this.If.Ic) {
                if (eVar != null) {
                    eVar.kN();
                }
            }
            this.Im = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ik = uptimeMillis;
            this.Il = uptimeMillis + 16;
            this.Ih = f;
            this.Ig = 0.0f;
            this.Ii = 0 - this.If.HK;
            this.Ij = this.If.HK;
            BdLog.d("Animator@animateBottomOpen " + this.Ii);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.If.HX.removeMessages(-105);
            this.If.HX.sendEmptyMessageAtTime(-105, this.Il);
        }

        void A(float f) {
            d dVar = this.If.Ia;
            if (dVar != null) {
                dVar.kL();
            }
            this.Im = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ik = uptimeMillis;
            this.Il = uptimeMillis + 16;
            this.Ih = f;
            this.Ig = 0.0f;
            this.Ii = ((-this.If.getMeasuredWidth()) + this.If.HI) - this.If.HK;
            this.Ij = this.If.HK;
            BdLog.d("Animator@animateTop " + this.Ii);
            BdLog.d("Animator@animateTop " + f);
            this.If.HX.removeMessages(-100);
            this.If.HX.sendEmptyMessageAtTime(-100, this.Il);
        }

        void B(float f) {
            f fVar = this.If.Ib;
            if (fVar != null) {
                fVar.kP();
            }
            this.Im = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ik = uptimeMillis;
            this.Il = uptimeMillis + 16;
            this.Ih = f;
            this.Ig = 0.0f;
            this.Ii = (this.If.getMeasuredWidth() - this.If.HJ) - this.If.HK;
            this.Ij = this.If.HK;
            BdLog.d("Animator@animateBottom " + this.Ii);
            BdLog.d("Animator@animateBottom " + f);
            this.If.HX.removeMessages(-101);
            this.If.HX.sendEmptyMessageAtTime(-101, this.Il);
        }
    }
}
