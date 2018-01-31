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
    private TrackDirection atA;
    private int atB;
    private final Rect atC;
    private final Rect atD;
    private final Paint atE;
    private int atF;
    private int atG;
    private int atH;
    private boolean atI;
    private final a atJ;
    private final b atK;
    private final g atL;
    private d atM;
    private f atN;
    private final List<e> atO;
    private c atP;
    private int ats;
    private float atu;
    private float atv;
    private int atw;
    private final int atx;
    private boolean aty;
    private boolean atz;

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
        void rY();

        void rZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void sa();

        void sb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void sc();

        void sd();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.atE.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.atw = (int) ((this.atu - this.ats) * (-f2));
            } else if (f2 > 0.0f) {
                this.atw = (int) ((this.ats - this.atv) * f2);
            } else if (f2 == 0.0f) {
                this.atw = 0;
                this.atB = 10004;
            } else if (f2 == -1.0f) {
                this.atu -= getMeasuredWidth();
                this.atB = 10000;
            } else if (f2 == 1.0f) {
                this.atu = getMeasuredWidth() - this.atv;
                this.atB = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.atu;
    }

    public int getRightOffset() {
        return (int) this.atv;
    }

    public void setLeftTapBack(boolean z) {
        this.aty = z;
    }

    public void setRightTapBack(boolean z) {
        this.atz = z;
    }

    public int getState() {
        return this.atB;
    }

    public void setLeftAnimationListener(d dVar) {
        this.atM = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.atN = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.atP = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.atw, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.atw);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.atE);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.atw;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.atA == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.atB == 10004) {
            switch (action) {
                case 0:
                    this.atF = x;
                    this.atG = y;
                    this.atJ.removeMessages(-100);
                    this.atJ.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.atJ.removeMessages(-101);
                    this.atJ.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.atw, 0.0f);
                    return ap(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i2 >= this.atG - this.atx && i2 <= this.atG + this.atx && (i < this.atF - this.atx || i > this.atF + this.atx) && this.atL.dB(i - this.atF);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.atB == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.atI = false;
                    if (this.atL.aub) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.atL.se();
                        this.atL.sf();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.atL.aub) {
                        if (!this.atI) {
                            if (x > this.atF) {
                                this.atH = this.atF + this.atx;
                                this.atI = true;
                            } else {
                                this.atH = this.atF - this.atx;
                                this.atI = true;
                            }
                        }
                        this.atL.dC(this.atH - x);
                        this.atH = x;
                        this.atL.aua.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.atC);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.atD);
        switch (action) {
            case 0:
                if ((this.atB != 10000 || !this.atC.contains(x, y)) && (this.atB != 10001 || !this.atD.contains(x, y))) {
                    return false;
                }
                if (!this.atL.aub) {
                    this.atH = x;
                    this.atL.dB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.atL.aub) {
                    this.atL.se();
                    this.atL.sf();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.atL.aub) {
            this.atL.dC(this.atH - x);
            this.atH = x;
            this.atL.aua.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.atu != -1.0f) {
                this.atC.set(i, i2, (int) (i + this.atu), i4);
            }
            if (this.atv != -1.0f) {
                this.atD.set((int) (i3 - this.atv), i2, i3, i4);
            }
        }
        if (!this.atK.atY && !this.atL.aub) {
            rT();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.atu) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.atv) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.ats = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT() {
        switch (this.atB) {
            case 10000:
                this.atw = (int) (this.atu - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.atw = (int) (getMeasuredWidth() - this.atv);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.atw = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout atR;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.atR.atK.atY) {
                switch (message.what) {
                    case -105:
                        this.atR.atK.rX();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.atR.atK.rW();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.atR.atK.rV();
                        return;
                    case -100:
                        this.atR.atK.rU();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout atR;
        VelocityTracker aua;
        boolean aub;
        final int auc;
        final int aud;

        boolean dB(int i) {
            switch (this.atR.atA) {
                case left:
                    if (this.atR.atB != 10004 && this.atR.atB != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.atR.atB != 10004 && this.atR.atB != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.atR.atP != null) {
                        this.atR.atP.dA(i);
                        break;
                    }
                    break;
            }
            this.aua = VelocityTracker.obtain();
            this.aub = true;
            return true;
        }

        void se() {
            this.aub = false;
        }

        void dC(int i) {
            if (this.aub) {
                int i2 = this.atR.atw - i;
                switch (this.atR.atA) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.atR.atu - this.atR.getMeasuredWidth() && i2 < 0) {
                            this.atR.atw -= i;
                            this.atR.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.atR.getMeasuredWidth() - this.atR.atv && i2 > 0) {
                            this.atR.atw -= i;
                            this.atR.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.atR.atu - this.atR.getMeasuredWidth() && i2 <= this.atR.getMeasuredWidth() - this.atR.atv) {
                            this.atR.atw -= i;
                            this.atR.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sf() {
            float max;
            this.aua.computeCurrentVelocity(this.auc);
            float xVelocity = this.aua.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.aud);
            } else {
                max = Math.max(xVelocity, this.aud);
            }
            switch (this.atR.atA) {
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
            this.aua.recycle();
            this.aua = null;
        }

        private void H(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.atR.atw;
            if (i <= 0 && i >= this.atR.atu - this.atR.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.atR.atK.F(f);
                } else {
                    this.atR.atK.D(f);
                }
            } else if (i >= 0 && i <= this.atR.getMeasuredWidth() - this.atR.atv) {
                if (f < 0.0f) {
                    this.atR.atK.E(f);
                } else {
                    this.atR.atK.G(f);
                }
            }
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.atR.atK.F(f);
            } else {
                this.atR.atK.D(f);
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.atR.atK.E(f);
            } else {
                this.atR.atK.G(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout atR;
        float atS;
        float atT;
        float atU;
        float atV;
        long atW;
        long atX;
        boolean atY;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atS = ((((float) (uptimeMillis - this.atW)) / 1000.0f) * this.atT) + this.atS;
            this.atW = uptimeMillis;
            this.atX += 16;
        }

        void rU() {
            compute();
            if (this.atS <= this.atU) {
                d dVar = this.atR.atM;
                if (dVar != null) {
                    dVar.rZ();
                }
                this.atY = false;
                this.atR.atB = 10000;
                this.atR.rT();
                return;
            }
            this.atR.atw = (int) (com.baidu.adp.widget.e.c(this.atU, this.atS, false) + this.atV);
            this.atR.invalidate();
            this.atR.atJ.sendEmptyMessageAtTime(-100, this.atX);
        }

        void rV() {
            compute();
            if (this.atS >= this.atU) {
                f fVar = this.atR.atN;
                if (fVar != null) {
                    fVar.sd();
                }
                this.atY = false;
                this.atR.atB = 10001;
                this.atR.rT();
                return;
            }
            this.atR.atw = (int) (com.baidu.adp.widget.e.c(this.atU, this.atS, false) + this.atV);
            this.atR.invalidate();
            this.atR.atJ.sendEmptyMessageAtTime(-101, this.atX);
        }

        void rW() {
            compute();
            if (this.atS >= this.atU) {
                for (e eVar : this.atR.atO) {
                    if (eVar != null) {
                        eVar.sb();
                    }
                }
                this.atY = false;
                this.atR.atB = 10004;
                this.atR.rT();
                return;
            }
            this.atR.atw = (int) (com.baidu.adp.widget.e.c(this.atU, this.atS, false) + this.atV);
            this.atR.invalidate();
            this.atR.atJ.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atX);
        }

        void rX() {
            compute();
            if (this.atS <= this.atU) {
                for (e eVar : this.atR.atO) {
                    if (eVar != null) {
                        eVar.sb();
                    }
                }
                this.atY = false;
                this.atR.atB = 10004;
                this.atR.rT();
                return;
            }
            this.atR.atw = (int) (com.baidu.adp.widget.e.c(this.atU, this.atS, false) + this.atV);
            this.atR.invalidate();
            this.atR.atJ.sendEmptyMessageAtTime(-105, this.atX);
        }

        void D(float f) {
            for (e eVar : this.atR.atO) {
                if (eVar != null) {
                    eVar.sa();
                }
            }
            this.atY = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atW = uptimeMillis;
            this.atX = uptimeMillis + 16;
            this.atT = f;
            this.atS = 0.0f;
            this.atU = 0 - this.atR.atw;
            this.atV = this.atR.atw;
            this.atR.atJ.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atU);
            BdLog.d("Animator@animateTopOpen " + f);
            this.atR.atJ.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atX);
        }

        void E(float f) {
            for (e eVar : this.atR.atO) {
                if (eVar != null) {
                    eVar.sa();
                }
            }
            this.atY = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atW = uptimeMillis;
            this.atX = uptimeMillis + 16;
            this.atT = f;
            this.atS = 0.0f;
            this.atU = 0 - this.atR.atw;
            this.atV = this.atR.atw;
            BdLog.d("Animator@animateBottomOpen " + this.atU);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.atR.atJ.removeMessages(-105);
            this.atR.atJ.sendEmptyMessageAtTime(-105, this.atX);
        }

        void F(float f) {
            d dVar = this.atR.atM;
            if (dVar != null) {
                dVar.rY();
            }
            this.atY = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atW = uptimeMillis;
            this.atX = uptimeMillis + 16;
            this.atT = f;
            this.atS = 0.0f;
            this.atU = ((-this.atR.getMeasuredWidth()) + this.atR.atu) - this.atR.atw;
            this.atV = this.atR.atw;
            BdLog.d("Animator@animateTop " + this.atU);
            BdLog.d("Animator@animateTop " + f);
            this.atR.atJ.removeMessages(-100);
            this.atR.atJ.sendEmptyMessageAtTime(-100, this.atX);
        }

        void G(float f) {
            f fVar = this.atR.atN;
            if (fVar != null) {
                fVar.sc();
            }
            this.atY = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atW = uptimeMillis;
            this.atX = uptimeMillis + 16;
            this.atT = f;
            this.atS = 0.0f;
            this.atU = (this.atR.getMeasuredWidth() - this.atR.atv) - this.atR.atw;
            this.atV = this.atR.atw;
            BdLog.d("Animator@animateBottom " + this.atU);
            BdLog.d("Animator@animateBottom " + f);
            this.atR.atJ.removeMessages(-101);
            this.atR.atJ.sendEmptyMessageAtTime(-101, this.atX);
        }
    }
}
