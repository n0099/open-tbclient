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
    private final Rect atB;
    private final Paint atC;
    private int atD;
    private int atE;
    private int atF;
    private boolean atG;
    private final a atH;
    private final b atI;
    private final g atJ;
    private d atK;
    private f atL;
    private final List<e> atM;
    private c atN;
    private int atq;
    private float ats;
    private float att;
    private int atu;
    private final int atv;
    private boolean atw;
    private boolean atx;
    private TrackDirection aty;
    private int atz;

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
        this.atC.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.atu = (int) ((this.ats - this.atq) * (-f2));
            } else if (f2 > 0.0f) {
                this.atu = (int) ((this.atq - this.att) * f2);
            } else if (f2 == 0.0f) {
                this.atu = 0;
                this.atz = 10004;
            } else if (f2 == -1.0f) {
                this.ats -= getMeasuredWidth();
                this.atz = 10000;
            } else if (f2 == 1.0f) {
                this.ats = getMeasuredWidth() - this.att;
                this.atz = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.ats;
    }

    public int getRightOffset() {
        return (int) this.att;
    }

    public void setLeftTapBack(boolean z) {
        this.atw = z;
    }

    public void setRightTapBack(boolean z) {
        this.atx = z;
    }

    public int getState() {
        return this.atz;
    }

    public void setLeftAnimationListener(d dVar) {
        this.atK = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.atL = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.atN = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.atu, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.atu);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.atC);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.atu;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aty == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.atz == 10004) {
            switch (action) {
                case 0:
                    this.atD = x;
                    this.atE = y;
                    this.atH.removeMessages(-100);
                    this.atH.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.atH.removeMessages(-101);
                    this.atH.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.atu, 0.0f);
                    return ap(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i2 >= this.atE - this.atv && i2 <= this.atE + this.atv && (i < this.atD - this.atv || i > this.atD + this.atv) && this.atJ.dB(i - this.atD);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.atz == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.atG = false;
                    if (this.atJ.atZ) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.atJ.sd();
                        this.atJ.se();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.atJ.atZ) {
                        if (!this.atG) {
                            if (x > this.atD) {
                                this.atF = this.atD + this.atv;
                                this.atG = true;
                            } else {
                                this.atF = this.atD - this.atv;
                                this.atG = true;
                            }
                        }
                        this.atJ.dC(this.atF - x);
                        this.atF = x;
                        this.atJ.atY.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.atA);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.atB);
        switch (action) {
            case 0:
                if ((this.atz != 10000 || !this.atA.contains(x, y)) && (this.atz != 10001 || !this.atB.contains(x, y))) {
                    return false;
                }
                if (!this.atJ.atZ) {
                    this.atF = x;
                    this.atJ.dB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.atJ.atZ) {
                    this.atJ.sd();
                    this.atJ.se();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.atJ.atZ) {
            this.atJ.dC(this.atF - x);
            this.atF = x;
            this.atJ.atY.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.ats != -1.0f) {
                this.atA.set(i, i2, (int) (i + this.ats), i4);
            }
            if (this.att != -1.0f) {
                this.atB.set((int) (i3 - this.att), i2, i3, i4);
            }
        }
        if (!this.atI.atW && !this.atJ.atZ) {
            rS();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.ats) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.att) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.atq = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS() {
        switch (this.atz) {
            case 10000:
                this.atu = (int) (this.ats - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.atu = (int) (getMeasuredWidth() - this.att);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.atu = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout atP;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.atP.atI.atW) {
                switch (message.what) {
                    case -105:
                        this.atP.atI.rW();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.atP.atI.rV();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.atP.atI.rU();
                        return;
                    case -100:
                        this.atP.atI.rT();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout atP;
        VelocityTracker atY;
        boolean atZ;
        final int aua;
        final int aub;

        boolean dB(int i) {
            switch (this.atP.aty) {
                case left:
                    if (this.atP.atz != 10004 && this.atP.atz != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.atP.atz != 10004 && this.atP.atz != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.atP.atN != null) {
                        this.atP.atN.dA(i);
                        break;
                    }
                    break;
            }
            this.atY = VelocityTracker.obtain();
            this.atZ = true;
            return true;
        }

        void sd() {
            this.atZ = false;
        }

        void dC(int i) {
            if (this.atZ) {
                int i2 = this.atP.atu - i;
                switch (this.atP.aty) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.atP.ats - this.atP.getMeasuredWidth() && i2 < 0) {
                            this.atP.atu -= i;
                            this.atP.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.atP.getMeasuredWidth() - this.atP.att && i2 > 0) {
                            this.atP.atu -= i;
                            this.atP.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.atP.ats - this.atP.getMeasuredWidth() && i2 <= this.atP.getMeasuredWidth() - this.atP.att) {
                            this.atP.atu -= i;
                            this.atP.invalidate();
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
            this.atY.computeCurrentVelocity(this.aua);
            float xVelocity = this.atY.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.aub);
            } else {
                max = Math.max(xVelocity, this.aub);
            }
            switch (this.atP.aty) {
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
            this.atY.recycle();
            this.atY = null;
        }

        private void H(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.atP.atu;
            if (i <= 0 && i >= this.atP.ats - this.atP.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.atP.atI.F(f);
                } else {
                    this.atP.atI.D(f);
                }
            } else if (i >= 0 && i <= this.atP.getMeasuredWidth() - this.atP.att) {
                if (f < 0.0f) {
                    this.atP.atI.E(f);
                } else {
                    this.atP.atI.G(f);
                }
            }
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.atP.atI.F(f);
            } else {
                this.atP.atI.D(f);
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.atP.atI.E(f);
            } else {
                this.atP.atI.G(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout atP;
        float atQ;
        float atR;
        float atS;
        float atT;
        long atU;
        long atV;
        boolean atW;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atQ = ((((float) (uptimeMillis - this.atU)) / 1000.0f) * this.atR) + this.atQ;
            this.atU = uptimeMillis;
            this.atV += 16;
        }

        void rT() {
            compute();
            if (this.atQ <= this.atS) {
                d dVar = this.atP.atK;
                if (dVar != null) {
                    dVar.rY();
                }
                this.atW = false;
                this.atP.atz = 10000;
                this.atP.rS();
                return;
            }
            this.atP.atu = (int) (com.baidu.adp.widget.e.c(this.atS, this.atQ, false) + this.atT);
            this.atP.invalidate();
            this.atP.atH.sendEmptyMessageAtTime(-100, this.atV);
        }

        void rU() {
            compute();
            if (this.atQ >= this.atS) {
                f fVar = this.atP.atL;
                if (fVar != null) {
                    fVar.sc();
                }
                this.atW = false;
                this.atP.atz = 10001;
                this.atP.rS();
                return;
            }
            this.atP.atu = (int) (com.baidu.adp.widget.e.c(this.atS, this.atQ, false) + this.atT);
            this.atP.invalidate();
            this.atP.atH.sendEmptyMessageAtTime(-101, this.atV);
        }

        void rV() {
            compute();
            if (this.atQ >= this.atS) {
                for (e eVar : this.atP.atM) {
                    if (eVar != null) {
                        eVar.sa();
                    }
                }
                this.atW = false;
                this.atP.atz = 10004;
                this.atP.rS();
                return;
            }
            this.atP.atu = (int) (com.baidu.adp.widget.e.c(this.atS, this.atQ, false) + this.atT);
            this.atP.invalidate();
            this.atP.atH.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atV);
        }

        void rW() {
            compute();
            if (this.atQ <= this.atS) {
                for (e eVar : this.atP.atM) {
                    if (eVar != null) {
                        eVar.sa();
                    }
                }
                this.atW = false;
                this.atP.atz = 10004;
                this.atP.rS();
                return;
            }
            this.atP.atu = (int) (com.baidu.adp.widget.e.c(this.atS, this.atQ, false) + this.atT);
            this.atP.invalidate();
            this.atP.atH.sendEmptyMessageAtTime(-105, this.atV);
        }

        void D(float f) {
            for (e eVar : this.atP.atM) {
                if (eVar != null) {
                    eVar.rZ();
                }
            }
            this.atW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atU = uptimeMillis;
            this.atV = uptimeMillis + 16;
            this.atR = f;
            this.atQ = 0.0f;
            this.atS = 0 - this.atP.atu;
            this.atT = this.atP.atu;
            this.atP.atH.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atS);
            BdLog.d("Animator@animateTopOpen " + f);
            this.atP.atH.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atV);
        }

        void E(float f) {
            for (e eVar : this.atP.atM) {
                if (eVar != null) {
                    eVar.rZ();
                }
            }
            this.atW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atU = uptimeMillis;
            this.atV = uptimeMillis + 16;
            this.atR = f;
            this.atQ = 0.0f;
            this.atS = 0 - this.atP.atu;
            this.atT = this.atP.atu;
            BdLog.d("Animator@animateBottomOpen " + this.atS);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.atP.atH.removeMessages(-105);
            this.atP.atH.sendEmptyMessageAtTime(-105, this.atV);
        }

        void F(float f) {
            d dVar = this.atP.atK;
            if (dVar != null) {
                dVar.rX();
            }
            this.atW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atU = uptimeMillis;
            this.atV = uptimeMillis + 16;
            this.atR = f;
            this.atQ = 0.0f;
            this.atS = ((-this.atP.getMeasuredWidth()) + this.atP.ats) - this.atP.atu;
            this.atT = this.atP.atu;
            BdLog.d("Animator@animateTop " + this.atS);
            BdLog.d("Animator@animateTop " + f);
            this.atP.atH.removeMessages(-100);
            this.atP.atH.sendEmptyMessageAtTime(-100, this.atV);
        }

        void G(float f) {
            f fVar = this.atP.atL;
            if (fVar != null) {
                fVar.sb();
            }
            this.atW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atU = uptimeMillis;
            this.atV = uptimeMillis + 16;
            this.atR = f;
            this.atQ = 0.0f;
            this.atS = (this.atP.getMeasuredWidth() - this.atP.att) - this.atP.atu;
            this.atT = this.atP.atu;
            BdLog.d("Animator@animateBottom " + this.atS);
            BdLog.d("Animator@animateBottom " + f);
            this.atP.atH.removeMessages(-101);
            this.atP.atH.sendEmptyMessageAtTime(-101, this.atV);
        }
    }
}
