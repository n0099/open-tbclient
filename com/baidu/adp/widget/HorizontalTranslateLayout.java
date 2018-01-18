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
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Rect atA;
    private final Paint atB;
    private int atC;
    private int atD;
    private int atE;
    private boolean atF;
    private final a atG;
    private final b atH;
    private final g atI;
    private d atJ;
    private f atK;
    private final List<e> atL;
    private c atM;
    private int atp;
    private float atr;
    private float ats;
    private int att;
    private final int atu;
    private boolean atv;
    private boolean atw;
    private TrackDirection atx;
    private int aty;
    private final Rect atz;

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
        void rX();

        void rY();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void rZ();

        void sa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void sb();

        void sc();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.atB.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.att = (int) ((this.atr - this.atp) * (-f2));
            } else if (f2 > 0.0f) {
                this.att = (int) ((this.atp - this.ats) * f2);
            } else if (f2 == 0.0f) {
                this.att = 0;
                this.aty = 10004;
            } else if (f2 == -1.0f) {
                this.atr -= getMeasuredWidth();
                this.aty = 10000;
            } else if (f2 == 1.0f) {
                this.atr = getMeasuredWidth() - this.ats;
                this.aty = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.atr;
    }

    public int getRightOffset() {
        return (int) this.ats;
    }

    public void setLeftTapBack(boolean z) {
        this.atv = z;
    }

    public void setRightTapBack(boolean z) {
        this.atw = z;
    }

    public int getState() {
        return this.aty;
    }

    public void setLeftAnimationListener(d dVar) {
        this.atJ = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.atK = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.atM = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.att, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.att);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.atB);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.att;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.atx == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.aty == 10004) {
            switch (action) {
                case 0:
                    this.atC = x;
                    this.atD = y;
                    this.atG.removeMessages(-100);
                    this.atG.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.atG.removeMessages(-101);
                    this.atG.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.att, 0.0f);
                    return ap(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i2 >= this.atD - this.atu && i2 <= this.atD + this.atu && (i < this.atC - this.atu || i > this.atC + this.atu) && this.atI.dB(i - this.atC);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.aty == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.atF = false;
                    if (this.atI.atY) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.atI.sd();
                        this.atI.se();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.atI.atY) {
                        if (!this.atF) {
                            if (x > this.atC) {
                                this.atE = this.atC + this.atu;
                                this.atF = true;
                            } else {
                                this.atE = this.atC - this.atu;
                                this.atF = true;
                            }
                        }
                        this.atI.dC(this.atE - x);
                        this.atE = x;
                        this.atI.atX.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.atz);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.atA);
        switch (action) {
            case 0:
                if ((this.aty != 10000 || !this.atz.contains(x, y)) && (this.aty != 10001 || !this.atA.contains(x, y))) {
                    return false;
                }
                if (!this.atI.atY) {
                    this.atE = x;
                    this.atI.dB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.atI.atY) {
                    this.atI.sd();
                    this.atI.se();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.atI.atY) {
            this.atI.dC(this.atE - x);
            this.atE = x;
            this.atI.atX.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.atr != -1.0f) {
                this.atz.set(i, i2, (int) (i + this.atr), i4);
            }
            if (this.ats != -1.0f) {
                this.atA.set((int) (i3 - this.ats), i2, i3, i4);
            }
        }
        if (!this.atH.atV && !this.atI.atY) {
            rS();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.atr) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.ats) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.atp = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS() {
        switch (this.aty) {
            case 10000:
                this.att = (int) (this.atr - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.att = (int) (getMeasuredWidth() - this.ats);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.att = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout atO;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.atO.atH.atV) {
                switch (message.what) {
                    case -105:
                        this.atO.atH.rW();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.atO.atH.rV();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.atO.atH.rU();
                        return;
                    case -100:
                        this.atO.atH.rT();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout atO;
        VelocityTracker atX;
        boolean atY;
        final int atZ;
        final int aua;

        boolean dB(int i) {
            switch (this.atO.atx) {
                case left:
                    if (this.atO.aty != 10004 && this.atO.aty != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.atO.aty != 10004 && this.atO.aty != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.atO.atM != null) {
                        this.atO.atM.dA(i);
                        break;
                    }
                    break;
            }
            this.atX = VelocityTracker.obtain();
            this.atY = true;
            return true;
        }

        void sd() {
            this.atY = false;
        }

        void dC(int i) {
            if (this.atY) {
                int i2 = this.atO.att - i;
                switch (this.atO.atx) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.atO.atr - this.atO.getMeasuredWidth() && i2 < 0) {
                            this.atO.att -= i;
                            this.atO.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.atO.getMeasuredWidth() - this.atO.ats && i2 > 0) {
                            this.atO.att -= i;
                            this.atO.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.atO.atr - this.atO.getMeasuredWidth() && i2 <= this.atO.getMeasuredWidth() - this.atO.ats) {
                            this.atO.att -= i;
                            this.atO.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void se() {
            float max;
            this.atX.computeCurrentVelocity(this.atZ);
            float xVelocity = this.atX.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.aua);
            } else {
                max = Math.max(xVelocity, this.aua);
            }
            switch (this.atO.atx) {
                case left:
                    I(max);
                    break;
                case right:
                    J(max);
                    break;
                case horizontal:
                    H(max);
                    break;
            }
            this.atX.recycle();
            this.atX = null;
        }

        private void H(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.atO.att;
            if (i <= 0 && i >= this.atO.atr - this.atO.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.atO.atH.F(f);
                } else {
                    this.atO.atH.D(f);
                }
            } else if (i >= 0 && i <= this.atO.getMeasuredWidth() - this.atO.ats) {
                if (f < 0.0f) {
                    this.atO.atH.E(f);
                } else {
                    this.atO.atH.G(f);
                }
            }
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.atO.atH.F(f);
            } else {
                this.atO.atH.D(f);
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.atO.atH.E(f);
            } else {
                this.atO.atH.G(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout atO;
        float atP;
        float atQ;
        float atR;
        float atS;
        long atT;
        long atU;
        boolean atV;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atP = ((((float) (uptimeMillis - this.atT)) / 1000.0f) * this.atQ) + this.atP;
            this.atT = uptimeMillis;
            this.atU += 16;
        }

        void rT() {
            compute();
            if (this.atP <= this.atR) {
                d dVar = this.atO.atJ;
                if (dVar != null) {
                    dVar.rY();
                }
                this.atV = false;
                this.atO.aty = 10000;
                this.atO.rS();
                return;
            }
            this.atO.att = (int) (com.baidu.adp.widget.e.c(this.atR, this.atP, false) + this.atS);
            this.atO.invalidate();
            this.atO.atG.sendEmptyMessageAtTime(-100, this.atU);
        }

        void rU() {
            compute();
            if (this.atP >= this.atR) {
                f fVar = this.atO.atK;
                if (fVar != null) {
                    fVar.sc();
                }
                this.atV = false;
                this.atO.aty = 10001;
                this.atO.rS();
                return;
            }
            this.atO.att = (int) (com.baidu.adp.widget.e.c(this.atR, this.atP, false) + this.atS);
            this.atO.invalidate();
            this.atO.atG.sendEmptyMessageAtTime(-101, this.atU);
        }

        void rV() {
            compute();
            if (this.atP >= this.atR) {
                for (e eVar : this.atO.atL) {
                    if (eVar != null) {
                        eVar.sa();
                    }
                }
                this.atV = false;
                this.atO.aty = 10004;
                this.atO.rS();
                return;
            }
            this.atO.att = (int) (com.baidu.adp.widget.e.c(this.atR, this.atP, false) + this.atS);
            this.atO.invalidate();
            this.atO.atG.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atU);
        }

        void rW() {
            compute();
            if (this.atP <= this.atR) {
                for (e eVar : this.atO.atL) {
                    if (eVar != null) {
                        eVar.sa();
                    }
                }
                this.atV = false;
                this.atO.aty = 10004;
                this.atO.rS();
                return;
            }
            this.atO.att = (int) (com.baidu.adp.widget.e.c(this.atR, this.atP, false) + this.atS);
            this.atO.invalidate();
            this.atO.atG.sendEmptyMessageAtTime(-105, this.atU);
        }

        void D(float f) {
            for (e eVar : this.atO.atL) {
                if (eVar != null) {
                    eVar.rZ();
                }
            }
            this.atV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atT = uptimeMillis;
            this.atU = uptimeMillis + 16;
            this.atQ = f;
            this.atP = 0.0f;
            this.atR = 0 - this.atO.att;
            this.atS = this.atO.att;
            this.atO.atG.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atR);
            BdLog.d("Animator@animateTopOpen " + f);
            this.atO.atG.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atU);
        }

        void E(float f) {
            for (e eVar : this.atO.atL) {
                if (eVar != null) {
                    eVar.rZ();
                }
            }
            this.atV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atT = uptimeMillis;
            this.atU = uptimeMillis + 16;
            this.atQ = f;
            this.atP = 0.0f;
            this.atR = 0 - this.atO.att;
            this.atS = this.atO.att;
            BdLog.d("Animator@animateBottomOpen " + this.atR);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.atO.atG.removeMessages(-105);
            this.atO.atG.sendEmptyMessageAtTime(-105, this.atU);
        }

        void F(float f) {
            d dVar = this.atO.atJ;
            if (dVar != null) {
                dVar.rX();
            }
            this.atV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atT = uptimeMillis;
            this.atU = uptimeMillis + 16;
            this.atQ = f;
            this.atP = 0.0f;
            this.atR = ((-this.atO.getMeasuredWidth()) + this.atO.atr) - this.atO.att;
            this.atS = this.atO.att;
            BdLog.d("Animator@animateTop " + this.atR);
            BdLog.d("Animator@animateTop " + f);
            this.atO.atG.removeMessages(-100);
            this.atO.atG.sendEmptyMessageAtTime(-100, this.atU);
        }

        void G(float f) {
            f fVar = this.atO.atK;
            if (fVar != null) {
                fVar.sb();
            }
            this.atV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atT = uptimeMillis;
            this.atU = uptimeMillis + 16;
            this.atQ = f;
            this.atP = 0.0f;
            this.atR = (this.atO.getMeasuredWidth() - this.atO.ats) - this.atO.att;
            this.atS = this.atO.att;
            BdLog.d("Animator@animateBottom " + this.atR);
            BdLog.d("Animator@animateBottom " + f);
            this.atO.atG.removeMessages(-101);
            this.atO.atG.sendEmptyMessageAtTime(-101, this.atU);
        }
    }
}
