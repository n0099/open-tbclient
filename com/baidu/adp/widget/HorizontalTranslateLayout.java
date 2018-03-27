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
    private f atA;
    private final List<e> atB;
    private c atC;
    private int atf;
    private float ath;
    private float ati;
    private int atj;
    private final int atk;
    private boolean atl;
    private boolean atm;
    private TrackDirection atn;
    private int ato;
    private final Rect atp;
    private final Rect atq;
    private final Paint atr;
    private int ats;
    private int att;
    private int atu;
    private boolean atv;
    private final a atw;
    private final b atx;
    private final g aty;
    private d atz;

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
        this.atr.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.atj = (int) ((this.ath - this.atf) * (-f2));
            } else if (f2 > 0.0f) {
                this.atj = (int) ((this.atf - this.ati) * f2);
            } else if (f2 == 0.0f) {
                this.atj = 0;
                this.ato = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.ath -= getMeasuredWidth();
                this.ato = 10000;
            } else if (f2 == 1.0f) {
                this.ath = getMeasuredWidth() - this.ati;
                this.ato = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.ath;
    }

    public int getRightOffset() {
        return (int) this.ati;
    }

    public void setLeftTapBack(boolean z) {
        this.atl = z;
    }

    public void setRightTapBack(boolean z) {
        this.atm = z;
    }

    public int getState() {
        return this.ato;
    }

    public void setLeftAnimationListener(d dVar) {
        this.atz = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.atA = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.atC = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.atj, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.atj);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.atr);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.atj;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.atn == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.ato == 10004) {
            switch (action) {
                case 0:
                    this.ats = x;
                    this.att = y;
                    this.atw.removeMessages(-100);
                    this.atw.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.atw.removeMessages(-101);
                    this.atw.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.atj, 0.0f);
                    return ap(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i2 >= this.att - this.atk && i2 <= this.att + this.atk && (i < this.ats - this.atk || i > this.ats + this.atk) && this.aty.dB(i - this.ats);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.ato == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.atv = false;
                    if (this.aty.atO) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.aty.sc();
                        this.aty.sd();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.aty.atO) {
                        if (!this.atv) {
                            if (x > this.ats) {
                                this.atu = this.ats + this.atk;
                                this.atv = true;
                            } else {
                                this.atu = this.ats - this.atk;
                                this.atv = true;
                            }
                        }
                        this.aty.dC(this.atu - x);
                        this.atu = x;
                        this.aty.atN.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.atp);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.atq);
        switch (action) {
            case 0:
                if ((this.ato != 10000 || !this.atp.contains(x, y)) && (this.ato != 10001 || !this.atq.contains(x, y))) {
                    return false;
                }
                if (!this.aty.atO) {
                    this.atu = x;
                    this.aty.dB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.aty.atO) {
                    this.aty.sc();
                    this.aty.sd();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.aty.atO) {
            this.aty.dC(this.atu - x);
            this.atu = x;
            this.aty.atN.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.ath != -1.0f) {
                this.atp.set(i, i2, (int) (i + this.ath), i4);
            }
            if (this.ati != -1.0f) {
                this.atq.set((int) (i3 - this.ati), i2, i3, i4);
            }
        }
        if (!this.atx.atL && !this.aty.atO) {
            rR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.ath) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.ati) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.atf = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        switch (this.ato) {
            case 10000:
                this.atj = (int) (this.ath - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.atj = (int) (getMeasuredWidth() - this.ati);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.atj = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout atE;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.atE.atx.atL) {
                switch (message.what) {
                    case -105:
                        this.atE.atx.rV();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.atE.atx.rU();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.atE.atx.rT();
                        return;
                    case -100:
                        this.atE.atx.rS();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout atE;
        VelocityTracker atN;
        boolean atO;
        final int atP;
        final int atQ;

        boolean dB(int i) {
            switch (this.atE.atn) {
                case left:
                    if (this.atE.ato != 10004 && this.atE.ato != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.atE.ato != 10004 && this.atE.ato != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.atE.atC != null) {
                        this.atE.atC.dA(i);
                        break;
                    }
                    break;
            }
            this.atN = VelocityTracker.obtain();
            this.atO = true;
            return true;
        }

        void sc() {
            this.atO = false;
        }

        void dC(int i) {
            if (this.atO) {
                int i2 = this.atE.atj - i;
                switch (this.atE.atn) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.atE.ath - this.atE.getMeasuredWidth() && i2 < 0) {
                            this.atE.atj -= i;
                            this.atE.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.atE.getMeasuredWidth() - this.atE.ati && i2 > 0) {
                            this.atE.atj -= i;
                            this.atE.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.atE.ath - this.atE.getMeasuredWidth() && i2 <= this.atE.getMeasuredWidth() - this.atE.ati) {
                            this.atE.atj -= i;
                            this.atE.invalidate();
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
            this.atN.computeCurrentVelocity(this.atP);
            float xVelocity = this.atN.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.atQ);
            } else {
                max = Math.max(xVelocity, this.atQ);
            }
            switch (this.atE.atn) {
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
            this.atN.recycle();
            this.atN = null;
        }

        private void L(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.atE.atj;
            if (i <= 0 && i >= this.atE.ath - this.atE.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.atE.atx.J(f);
                } else {
                    this.atE.atx.H(f);
                }
            } else if (i >= 0 && i <= this.atE.getMeasuredWidth() - this.atE.ati) {
                if (f < 0.0f) {
                    this.atE.atx.I(f);
                } else {
                    this.atE.atx.K(f);
                }
            }
        }

        private void M(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.atE.atx.J(f);
            } else {
                this.atE.atx.H(f);
            }
        }

        private void N(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.atE.atx.I(f);
            } else {
                this.atE.atx.K(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout atE;
        float atF;
        float atG;
        float atH;
        float atI;
        long atJ;
        long atK;
        boolean atL;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atF = ((((float) (uptimeMillis - this.atJ)) / 1000.0f) * this.atG) + this.atF;
            this.atJ = uptimeMillis;
            this.atK += 16;
        }

        void rS() {
            compute();
            if (this.atF <= this.atH) {
                d dVar = this.atE.atz;
                if (dVar != null) {
                    dVar.rX();
                }
                this.atL = false;
                this.atE.ato = 10000;
                this.atE.rR();
                return;
            }
            this.atE.atj = (int) (com.baidu.adp.widget.e.c(this.atH, this.atF, false) + this.atI);
            this.atE.invalidate();
            this.atE.atw.sendEmptyMessageAtTime(-100, this.atK);
        }

        void rT() {
            compute();
            if (this.atF >= this.atH) {
                f fVar = this.atE.atA;
                if (fVar != null) {
                    fVar.sb();
                }
                this.atL = false;
                this.atE.ato = 10001;
                this.atE.rR();
                return;
            }
            this.atE.atj = (int) (com.baidu.adp.widget.e.c(this.atH, this.atF, false) + this.atI);
            this.atE.invalidate();
            this.atE.atw.sendEmptyMessageAtTime(-101, this.atK);
        }

        void rU() {
            compute();
            if (this.atF >= this.atH) {
                for (e eVar : this.atE.atB) {
                    if (eVar != null) {
                        eVar.rZ();
                    }
                }
                this.atL = false;
                this.atE.ato = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.atE.rR();
                return;
            }
            this.atE.atj = (int) (com.baidu.adp.widget.e.c(this.atH, this.atF, false) + this.atI);
            this.atE.invalidate();
            this.atE.atw.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atK);
        }

        void rV() {
            compute();
            if (this.atF <= this.atH) {
                for (e eVar : this.atE.atB) {
                    if (eVar != null) {
                        eVar.rZ();
                    }
                }
                this.atL = false;
                this.atE.ato = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.atE.rR();
                return;
            }
            this.atE.atj = (int) (com.baidu.adp.widget.e.c(this.atH, this.atF, false) + this.atI);
            this.atE.invalidate();
            this.atE.atw.sendEmptyMessageAtTime(-105, this.atK);
        }

        void H(float f) {
            for (e eVar : this.atE.atB) {
                if (eVar != null) {
                    eVar.rY();
                }
            }
            this.atL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atJ = uptimeMillis;
            this.atK = uptimeMillis + 16;
            this.atG = f;
            this.atF = 0.0f;
            this.atH = 0 - this.atE.atj;
            this.atI = this.atE.atj;
            this.atE.atw.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atH);
            BdLog.d("Animator@animateTopOpen " + f);
            this.atE.atw.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atK);
        }

        void I(float f) {
            for (e eVar : this.atE.atB) {
                if (eVar != null) {
                    eVar.rY();
                }
            }
            this.atL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atJ = uptimeMillis;
            this.atK = uptimeMillis + 16;
            this.atG = f;
            this.atF = 0.0f;
            this.atH = 0 - this.atE.atj;
            this.atI = this.atE.atj;
            BdLog.d("Animator@animateBottomOpen " + this.atH);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.atE.atw.removeMessages(-105);
            this.atE.atw.sendEmptyMessageAtTime(-105, this.atK);
        }

        void J(float f) {
            d dVar = this.atE.atz;
            if (dVar != null) {
                dVar.rW();
            }
            this.atL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atJ = uptimeMillis;
            this.atK = uptimeMillis + 16;
            this.atG = f;
            this.atF = 0.0f;
            this.atH = ((-this.atE.getMeasuredWidth()) + this.atE.ath) - this.atE.atj;
            this.atI = this.atE.atj;
            BdLog.d("Animator@animateTop " + this.atH);
            BdLog.d("Animator@animateTop " + f);
            this.atE.atw.removeMessages(-100);
            this.atE.atw.sendEmptyMessageAtTime(-100, this.atK);
        }

        void K(float f) {
            f fVar = this.atE.atA;
            if (fVar != null) {
                fVar.sa();
            }
            this.atL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atJ = uptimeMillis;
            this.atK = uptimeMillis + 16;
            this.atG = f;
            this.atF = 0.0f;
            this.atH = (this.atE.getMeasuredWidth() - this.atE.ati) - this.atE.atj;
            this.atI = this.atE.atj;
            BdLog.d("Animator@animateBottom " + this.atH);
            BdLog.d("Animator@animateBottom " + f);
            this.atE.atw.removeMessages(-101);
            this.atE.atw.sendEmptyMessageAtTime(-101, this.atK);
        }
    }
}
