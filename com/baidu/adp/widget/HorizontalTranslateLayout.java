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
    private int atA;
    private int atB;
    private int atC;
    private boolean atD;
    private final a atE;
    private final b atF;
    private final g atG;
    private d atH;
    private f atI;
    private final List<e> atJ;
    private c atK;
    private int atn;
    private float atp;
    private float atq;
    private int atr;
    private final int ats;
    private boolean att;
    private boolean atu;
    private TrackDirection atv;
    private int atw;
    private final Rect atx;
    private final Rect aty;
    private final Paint atz;

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
        this.atz.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.atr = (int) ((this.atp - this.atn) * (-f2));
            } else if (f2 > 0.0f) {
                this.atr = (int) ((this.atn - this.atq) * f2);
            } else if (f2 == 0.0f) {
                this.atr = 0;
                this.atw = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.atp -= getMeasuredWidth();
                this.atw = 10000;
            } else if (f2 == 1.0f) {
                this.atp = getMeasuredWidth() - this.atq;
                this.atw = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.atp;
    }

    public int getRightOffset() {
        return (int) this.atq;
    }

    public void setLeftTapBack(boolean z) {
        this.att = z;
    }

    public void setRightTapBack(boolean z) {
        this.atu = z;
    }

    public int getState() {
        return this.atw;
    }

    public void setLeftAnimationListener(d dVar) {
        this.atH = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.atI = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.atK = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.atr, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.atr);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.atz);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.atr;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.atv == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.atw == 10004) {
            switch (action) {
                case 0:
                    this.atA = x;
                    this.atB = y;
                    this.atE.removeMessages(-100);
                    this.atE.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.atE.removeMessages(-101);
                    this.atE.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.atr, 0.0f);
                    return ap(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i2 >= this.atB - this.ats && i2 <= this.atB + this.ats && (i < this.atA - this.ats || i > this.atA + this.ats) && this.atG.dB(i - this.atA);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.atw == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.atD = false;
                    if (this.atG.atW) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.atG.sc();
                        this.atG.sd();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.atG.atW) {
                        if (!this.atD) {
                            if (x > this.atA) {
                                this.atC = this.atA + this.ats;
                                this.atD = true;
                            } else {
                                this.atC = this.atA - this.ats;
                                this.atD = true;
                            }
                        }
                        this.atG.dC(this.atC - x);
                        this.atC = x;
                        this.atG.atV.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.atx);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.aty);
        switch (action) {
            case 0:
                if ((this.atw != 10000 || !this.atx.contains(x, y)) && (this.atw != 10001 || !this.aty.contains(x, y))) {
                    return false;
                }
                if (!this.atG.atW) {
                    this.atC = x;
                    this.atG.dB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.atG.atW) {
                    this.atG.sc();
                    this.atG.sd();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.atG.atW) {
            this.atG.dC(this.atC - x);
            this.atC = x;
            this.atG.atV.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.atp != -1.0f) {
                this.atx.set(i, i2, (int) (i + this.atp), i4);
            }
            if (this.atq != -1.0f) {
                this.aty.set((int) (i3 - this.atq), i2, i3, i4);
            }
        }
        if (!this.atF.atT && !this.atG.atW) {
            rR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.atp) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.atq) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.atn = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        switch (this.atw) {
            case 10000:
                this.atr = (int) (this.atp - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.atr = (int) (getMeasuredWidth() - this.atq);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.atr = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout atM;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.atM.atF.atT) {
                switch (message.what) {
                    case -105:
                        this.atM.atF.rV();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.atM.atF.rU();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.atM.atF.rT();
                        return;
                    case -100:
                        this.atM.atF.rS();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout atM;
        VelocityTracker atV;
        boolean atW;
        final int atX;
        final int atY;

        boolean dB(int i) {
            switch (this.atM.atv) {
                case left:
                    if (this.atM.atw != 10004 && this.atM.atw != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.atM.atw != 10004 && this.atM.atw != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.atM.atK != null) {
                        this.atM.atK.dA(i);
                        break;
                    }
                    break;
            }
            this.atV = VelocityTracker.obtain();
            this.atW = true;
            return true;
        }

        void sc() {
            this.atW = false;
        }

        void dC(int i) {
            if (this.atW) {
                int i2 = this.atM.atr - i;
                switch (this.atM.atv) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.atM.atp - this.atM.getMeasuredWidth() && i2 < 0) {
                            this.atM.atr -= i;
                            this.atM.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.atM.getMeasuredWidth() - this.atM.atq && i2 > 0) {
                            this.atM.atr -= i;
                            this.atM.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.atM.atp - this.atM.getMeasuredWidth() && i2 <= this.atM.getMeasuredWidth() - this.atM.atq) {
                            this.atM.atr -= i;
                            this.atM.invalidate();
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
            this.atV.computeCurrentVelocity(this.atX);
            float xVelocity = this.atV.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.atY);
            } else {
                max = Math.max(xVelocity, this.atY);
            }
            switch (this.atM.atv) {
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
            this.atV.recycle();
            this.atV = null;
        }

        private void L(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.atM.atr;
            if (i <= 0 && i >= this.atM.atp - this.atM.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.atM.atF.J(f);
                } else {
                    this.atM.atF.H(f);
                }
            } else if (i >= 0 && i <= this.atM.getMeasuredWidth() - this.atM.atq) {
                if (f < 0.0f) {
                    this.atM.atF.I(f);
                } else {
                    this.atM.atF.K(f);
                }
            }
        }

        private void M(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.atM.atF.J(f);
            } else {
                this.atM.atF.H(f);
            }
        }

        private void N(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.atM.atF.I(f);
            } else {
                this.atM.atF.K(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout atM;
        float atN;
        float atO;
        float atP;
        float atQ;
        long atR;
        long atS;
        boolean atT;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atN = ((((float) (uptimeMillis - this.atR)) / 1000.0f) * this.atO) + this.atN;
            this.atR = uptimeMillis;
            this.atS += 16;
        }

        void rS() {
            compute();
            if (this.atN <= this.atP) {
                d dVar = this.atM.atH;
                if (dVar != null) {
                    dVar.rX();
                }
                this.atT = false;
                this.atM.atw = 10000;
                this.atM.rR();
                return;
            }
            this.atM.atr = (int) (com.baidu.adp.widget.e.c(this.atP, this.atN, false) + this.atQ);
            this.atM.invalidate();
            this.atM.atE.sendEmptyMessageAtTime(-100, this.atS);
        }

        void rT() {
            compute();
            if (this.atN >= this.atP) {
                f fVar = this.atM.atI;
                if (fVar != null) {
                    fVar.sb();
                }
                this.atT = false;
                this.atM.atw = 10001;
                this.atM.rR();
                return;
            }
            this.atM.atr = (int) (com.baidu.adp.widget.e.c(this.atP, this.atN, false) + this.atQ);
            this.atM.invalidate();
            this.atM.atE.sendEmptyMessageAtTime(-101, this.atS);
        }

        void rU() {
            compute();
            if (this.atN >= this.atP) {
                for (e eVar : this.atM.atJ) {
                    if (eVar != null) {
                        eVar.rZ();
                    }
                }
                this.atT = false;
                this.atM.atw = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.atM.rR();
                return;
            }
            this.atM.atr = (int) (com.baidu.adp.widget.e.c(this.atP, this.atN, false) + this.atQ);
            this.atM.invalidate();
            this.atM.atE.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atS);
        }

        void rV() {
            compute();
            if (this.atN <= this.atP) {
                for (e eVar : this.atM.atJ) {
                    if (eVar != null) {
                        eVar.rZ();
                    }
                }
                this.atT = false;
                this.atM.atw = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.atM.rR();
                return;
            }
            this.atM.atr = (int) (com.baidu.adp.widget.e.c(this.atP, this.atN, false) + this.atQ);
            this.atM.invalidate();
            this.atM.atE.sendEmptyMessageAtTime(-105, this.atS);
        }

        void H(float f) {
            for (e eVar : this.atM.atJ) {
                if (eVar != null) {
                    eVar.rY();
                }
            }
            this.atT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atR = uptimeMillis;
            this.atS = uptimeMillis + 16;
            this.atO = f;
            this.atN = 0.0f;
            this.atP = 0 - this.atM.atr;
            this.atQ = this.atM.atr;
            this.atM.atE.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atP);
            BdLog.d("Animator@animateTopOpen " + f);
            this.atM.atE.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atS);
        }

        void I(float f) {
            for (e eVar : this.atM.atJ) {
                if (eVar != null) {
                    eVar.rY();
                }
            }
            this.atT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atR = uptimeMillis;
            this.atS = uptimeMillis + 16;
            this.atO = f;
            this.atN = 0.0f;
            this.atP = 0 - this.atM.atr;
            this.atQ = this.atM.atr;
            BdLog.d("Animator@animateBottomOpen " + this.atP);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.atM.atE.removeMessages(-105);
            this.atM.atE.sendEmptyMessageAtTime(-105, this.atS);
        }

        void J(float f) {
            d dVar = this.atM.atH;
            if (dVar != null) {
                dVar.rW();
            }
            this.atT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atR = uptimeMillis;
            this.atS = uptimeMillis + 16;
            this.atO = f;
            this.atN = 0.0f;
            this.atP = ((-this.atM.getMeasuredWidth()) + this.atM.atp) - this.atM.atr;
            this.atQ = this.atM.atr;
            BdLog.d("Animator@animateTop " + this.atP);
            BdLog.d("Animator@animateTop " + f);
            this.atM.atE.removeMessages(-100);
            this.atM.atE.sendEmptyMessageAtTime(-100, this.atS);
        }

        void K(float f) {
            f fVar = this.atM.atI;
            if (fVar != null) {
                fVar.sa();
            }
            this.atT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atR = uptimeMillis;
            this.atS = uptimeMillis + 16;
            this.atO = f;
            this.atN = 0.0f;
            this.atP = (this.atM.getMeasuredWidth() - this.atM.atq) - this.atM.atr;
            this.atQ = this.atM.atr;
            BdLog.d("Animator@animateBottom " + this.atP);
            BdLog.d("Animator@animateBottom " + f);
            this.atM.atE.removeMessages(-101);
            this.atM.atE.sendEmptyMessageAtTime(-101, this.atS);
        }
    }
}
