package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.Constants;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final List<e> atA;
    private c atB;
    private int ate;
    private float atg;
    private float ath;
    private int ati;
    private final int atj;
    private boolean atk;
    private boolean atl;
    private TrackDirection atm;
    private int atn;
    private final Rect ato;
    private final Rect atp;
    private final Paint atq;
    private int atr;
    private int ats;
    private int att;
    private boolean atu;
    private final a atv;
    private final b atw;
    private final g atx;
    private d aty;
    private f atz;

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
        void dA(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void rW();

        void rX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void rY();

        void rZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void sa();

        void sb();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.atq.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.ati = (int) ((this.atg - this.ate) * (-f2));
            } else if (f2 > 0.0f) {
                this.ati = (int) ((this.ate - this.ath) * f2);
            } else if (f2 == 0.0f) {
                this.ati = 0;
                this.atn = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.atg -= getMeasuredWidth();
                this.atn = 10000;
            } else if (f2 == 1.0f) {
                this.atg = getMeasuredWidth() - this.ath;
                this.atn = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.atg;
    }

    public int getRightOffset() {
        return (int) this.ath;
    }

    public void setLeftTapBack(boolean z) {
        this.atk = z;
    }

    public void setRightTapBack(boolean z) {
        this.atl = z;
    }

    public int getState() {
        return this.atn;
    }

    public void setLeftAnimationListener(d dVar) {
        this.aty = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.atz = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.atB = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.ati, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.ati);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.atq);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.ati;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.atm == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.atn == 10004) {
            switch (action) {
                case 0:
                    this.atr = x;
                    this.ats = y;
                    this.atv.removeMessages(-100);
                    this.atv.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.atv.removeMessages(-101);
                    this.atv.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.ati, 0.0f);
                    return ap(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i2 >= this.ats - this.atj && i2 <= this.ats + this.atj && (i < this.atr - this.atj || i > this.atr + this.atj) && this.atx.dB(i - this.atr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.atn == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.atu = false;
                    if (this.atx.atN) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.atx.sc();
                        this.atx.sd();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.atx.atN) {
                        if (!this.atu) {
                            if (x > this.atr) {
                                this.att = this.atr + this.atj;
                                this.atu = true;
                            } else {
                                this.att = this.atr - this.atj;
                                this.atu = true;
                            }
                        }
                        this.atx.dC(this.att - x);
                        this.att = x;
                        this.atx.atM.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.ato);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.atp);
        switch (action) {
            case 0:
                if ((this.atn != 10000 || !this.ato.contains(x, y)) && (this.atn != 10001 || !this.atp.contains(x, y))) {
                    return false;
                }
                if (!this.atx.atN) {
                    this.att = x;
                    this.atx.dB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.atx.atN) {
                    this.atx.sc();
                    this.atx.sd();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.atx.atN) {
            this.atx.dC(this.att - x);
            this.att = x;
            this.atx.atM.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.atg != -1.0f) {
                this.ato.set(i, i2, (int) (i + this.atg), i4);
            }
            if (this.ath != -1.0f) {
                this.atp.set((int) (i3 - this.ath), i2, i3, i4);
            }
        }
        if (!this.atw.atK && !this.atx.atN) {
            rR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.atg) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.ath) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.ate = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        switch (this.atn) {
            case 10000:
                this.ati = (int) (this.atg - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.ati = (int) (getMeasuredWidth() - this.ath);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.ati = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout atD;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.atD.atw.atK) {
                switch (message.what) {
                    case -105:
                        this.atD.atw.rV();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.atD.atw.rU();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.atD.atw.rT();
                        return;
                    case -100:
                        this.atD.atw.rS();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout atD;
        VelocityTracker atM;
        boolean atN;
        final int atO;
        final int atP;

        boolean dB(int i) {
            switch (this.atD.atm) {
                case left:
                    if (this.atD.atn != 10004 && this.atD.atn != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.atD.atn != 10004 && this.atD.atn != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.atD.atB != null) {
                        this.atD.atB.dA(i);
                        break;
                    }
                    break;
            }
            this.atM = VelocityTracker.obtain();
            this.atN = true;
            return true;
        }

        void sc() {
            this.atN = false;
        }

        void dC(int i) {
            if (this.atN) {
                int i2 = this.atD.ati - i;
                switch (this.atD.atm) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.atD.atg - this.atD.getMeasuredWidth() && i2 < 0) {
                            this.atD.ati -= i;
                            this.atD.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.atD.getMeasuredWidth() - this.atD.ath && i2 > 0) {
                            this.atD.ati -= i;
                            this.atD.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.atD.atg - this.atD.getMeasuredWidth() && i2 <= this.atD.getMeasuredWidth() - this.atD.ath) {
                            this.atD.ati -= i;
                            this.atD.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sd() {
            float max;
            this.atM.computeCurrentVelocity(this.atO);
            float xVelocity = this.atM.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.atP);
            } else {
                max = Math.max(xVelocity, this.atP);
            }
            switch (this.atD.atm) {
                case left:
                    M(max);
                    break;
                case right:
                    N(max);
                    break;
                case horizontal:
                    L(max);
                    break;
            }
            this.atM.recycle();
            this.atM = null;
        }

        private void L(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.atD.ati;
            if (i <= 0 && i >= this.atD.atg - this.atD.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.atD.atw.J(f);
                } else {
                    this.atD.atw.H(f);
                }
            } else if (i >= 0 && i <= this.atD.getMeasuredWidth() - this.atD.ath) {
                if (f < 0.0f) {
                    this.atD.atw.I(f);
                } else {
                    this.atD.atw.K(f);
                }
            }
        }

        private void M(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.atD.atw.J(f);
            } else {
                this.atD.atw.H(f);
            }
        }

        private void N(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.atD.atw.I(f);
            } else {
                this.atD.atw.K(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout atD;
        float atE;
        float atF;
        float atG;
        float atH;
        long atI;
        long atJ;
        boolean atK;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atE = ((((float) (uptimeMillis - this.atI)) / 1000.0f) * this.atF) + this.atE;
            this.atI = uptimeMillis;
            this.atJ += 16;
        }

        void rS() {
            compute();
            if (this.atE <= this.atG) {
                d dVar = this.atD.aty;
                if (dVar != null) {
                    dVar.rX();
                }
                this.atK = false;
                this.atD.atn = 10000;
                this.atD.rR();
                return;
            }
            this.atD.ati = (int) (com.baidu.adp.widget.e.c(this.atG, this.atE, false) + this.atH);
            this.atD.invalidate();
            this.atD.atv.sendEmptyMessageAtTime(-100, this.atJ);
        }

        void rT() {
            compute();
            if (this.atE >= this.atG) {
                f fVar = this.atD.atz;
                if (fVar != null) {
                    fVar.sb();
                }
                this.atK = false;
                this.atD.atn = 10001;
                this.atD.rR();
                return;
            }
            this.atD.ati = (int) (com.baidu.adp.widget.e.c(this.atG, this.atE, false) + this.atH);
            this.atD.invalidate();
            this.atD.atv.sendEmptyMessageAtTime(-101, this.atJ);
        }

        void rU() {
            compute();
            if (this.atE >= this.atG) {
                for (e eVar : this.atD.atA) {
                    if (eVar != null) {
                        eVar.rZ();
                    }
                }
                this.atK = false;
                this.atD.atn = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.atD.rR();
                return;
            }
            this.atD.ati = (int) (com.baidu.adp.widget.e.c(this.atG, this.atE, false) + this.atH);
            this.atD.invalidate();
            this.atD.atv.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atJ);
        }

        void rV() {
            compute();
            if (this.atE <= this.atG) {
                for (e eVar : this.atD.atA) {
                    if (eVar != null) {
                        eVar.rZ();
                    }
                }
                this.atK = false;
                this.atD.atn = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.atD.rR();
                return;
            }
            this.atD.ati = (int) (com.baidu.adp.widget.e.c(this.atG, this.atE, false) + this.atH);
            this.atD.invalidate();
            this.atD.atv.sendEmptyMessageAtTime(-105, this.atJ);
        }

        void H(float f) {
            for (e eVar : this.atD.atA) {
                if (eVar != null) {
                    eVar.rY();
                }
            }
            this.atK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atI = uptimeMillis;
            this.atJ = uptimeMillis + 16;
            this.atF = f;
            this.atE = 0.0f;
            this.atG = 0 - this.atD.ati;
            this.atH = this.atD.ati;
            this.atD.atv.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atG);
            BdLog.d("Animator@animateTopOpen " + f);
            this.atD.atv.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atJ);
        }

        void I(float f) {
            for (e eVar : this.atD.atA) {
                if (eVar != null) {
                    eVar.rY();
                }
            }
            this.atK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atI = uptimeMillis;
            this.atJ = uptimeMillis + 16;
            this.atF = f;
            this.atE = 0.0f;
            this.atG = 0 - this.atD.ati;
            this.atH = this.atD.ati;
            BdLog.d("Animator@animateBottomOpen " + this.atG);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.atD.atv.removeMessages(-105);
            this.atD.atv.sendEmptyMessageAtTime(-105, this.atJ);
        }

        void J(float f) {
            d dVar = this.atD.aty;
            if (dVar != null) {
                dVar.rW();
            }
            this.atK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atI = uptimeMillis;
            this.atJ = uptimeMillis + 16;
            this.atF = f;
            this.atE = 0.0f;
            this.atG = ((-this.atD.getMeasuredWidth()) + this.atD.atg) - this.atD.ati;
            this.atH = this.atD.ati;
            BdLog.d("Animator@animateTop " + this.atG);
            BdLog.d("Animator@animateTop " + f);
            this.atD.atv.removeMessages(-100);
            this.atD.atv.sendEmptyMessageAtTime(-100, this.atJ);
        }

        void K(float f) {
            f fVar = this.atD.atz;
            if (fVar != null) {
                fVar.sa();
            }
            this.atK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atI = uptimeMillis;
            this.atJ = uptimeMillis + 16;
            this.atF = f;
            this.atE = 0.0f;
            this.atG = (this.atD.getMeasuredWidth() - this.atD.ath) - this.atD.ati;
            this.atH = this.atD.ati;
            BdLog.d("Animator@animateBottom " + this.atG);
            BdLog.d("Animator@animateBottom " + f);
            this.atD.atv.removeMessages(-101);
            this.atD.atv.sendEmptyMessageAtTime(-101, this.atJ);
        }
    }
}
