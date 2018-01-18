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
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Paint atB;
    private int atC;
    private int atD;
    private final List<d> atL;
    private int atp;
    private int atq;
    private final int atu;
    private int aty;
    private float awf;
    private float awg;
    private float awh;
    private float awi;
    private int awj;
    private boolean awk;
    private boolean awl;
    private TrackDirection awm;
    private final Rect awn;
    private final Rect awo;
    private int awp;
    private boolean awq;
    private final a awr;
    private final b aws;
    private final g awt;
    private e awu;
    private c awv;
    private f aww;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void sQ();

        void sb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void rZ();

        void sa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void rX();

        void sR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void dL(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.atB.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.awj = (int) ((this.awf - this.atq) * (-f2));
            } else if (f2 > 0.0f) {
                this.awj = (int) ((this.atq - this.awh) * f2);
            } else if (f2 == 0.0f) {
                this.awj = 0;
                this.aty = 10004;
            } else if (f2 == -1.0f) {
                this.awf -= this.atq;
                this.aty = 10000;
            } else if (f2 == 1.0f) {
                this.awf = this.atq - this.awh;
                this.aty = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.awf;
    }

    public int getBottomOffset() {
        return (int) this.awh;
    }

    public void setTopTapBack(boolean z) {
        this.awk = z;
    }

    public void setBottomTapBack(boolean z) {
        this.awl = z;
    }

    public int getState() {
        return this.aty;
    }

    public void setTopAnimationListener(e eVar) {
        this.awu = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.awv = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.aww = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.awj);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.awj);
        canvas.drawRect(0.0f, 0.0f, this.atp, this.atq, this.atB);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.awj;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.awm == TrackDirection.none) {
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
                    this.awr.removeMessages(-100);
                    this.awr.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.awr.removeMessages(-101);
                    this.awr.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.awj);
                    return ap(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i >= this.atC - this.atu && i <= this.atC + this.atu && (i2 < this.atD - this.atu || i2 > this.atD + this.atu) && this.awt.dB(i2 - this.atD);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.awq = false;
                    if (this.awt.atY) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.awt.sd();
                        this.awt.se();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.awt.atY) {
                        if (!this.awq) {
                            if (y > this.atD) {
                                this.awp = this.atD + this.atu;
                                this.awq = true;
                            } else {
                                this.awp = this.atD - this.atu;
                                this.awq = true;
                            }
                        }
                        this.awt.dC(this.awp - y);
                        this.awp = y;
                        this.awt.atX.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.aty != 10000 || !this.awn.contains(x, y)) && (this.aty != 10001 || !this.awo.contains(x, y))) {
                    return false;
                }
                if (!this.awt.atY) {
                    this.awp = y;
                    this.awt.dB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.awt.atY) {
                    this.awt.sd();
                    this.awt.se();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.awt.atY) {
            this.awt.dC(this.awp - y);
            this.awp = y;
            this.awt.atX.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.awf != -1.0f) {
                this.awn.set(i, i2, i3, (int) (i2 + this.awf));
            }
            if (this.awh != -1.0f) {
                this.awo.set(i, (int) (i4 - this.awh), i3, i4);
            }
        }
        if (!this.aws.atV && !this.awt.atY) {
            rS();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.awg != -1.0f) {
            this.awf = i3 - this.awi;
        }
        if (this.awi != -1.0f) {
            this.awh = i3 - this.awg;
        }
        if (!$assertionsDisabled && i3 < this.awf) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.awh) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.atp = getMeasuredWidth();
        this.atq = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS() {
        switch (this.aty) {
            case 10000:
                this.awj = (int) (this.awf - this.atq);
                invalidate();
                return;
            case 10001:
                this.awj = (int) (this.atq - this.awh);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.awj = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout awy;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.awy.aws.atV) {
                switch (message.what) {
                    case -105:
                        this.awy.aws.sP();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.awy.aws.sO();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.awy.aws.sN();
                        return;
                    case -100:
                        this.awy.aws.sM();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker atX;
        boolean atY;
        final int atZ;
        final int aua;
        final /* synthetic */ VerticalTranslateLayout awy;

        boolean dB(int i) {
            switch (this.awy.awm) {
                case top:
                    if (this.awy.aty != 10004 && this.awy.aty != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.awy.aty != 10004 && this.awy.aty != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.awy.aww != null) {
                        this.awy.aww.dL(i);
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
                int i2 = this.awy.awj - i;
                switch (this.awy.awm) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.awy.awf - this.awy.atq && i2 < 0) {
                            this.awy.awj -= i;
                            this.awy.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.awy.atq - this.awy.awh && i2 > 0) {
                            this.awy.awj -= i;
                            this.awy.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.awy.awf - this.awy.atq && i2 <= this.awy.atq - this.awy.awh) {
                            this.awy.awj -= i;
                            this.awy.invalidate();
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
            float yVelocity = this.atX.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.aua);
            } else {
                max = Math.max(yVelocity, this.aua);
            }
            switch (this.awy.awm) {
                case top:
                    S(max);
                    break;
                case bottom:
                    T(max);
                    break;
                case vertical:
                    R(max);
                    break;
            }
            this.atX.recycle();
            this.atX = null;
        }

        private void R(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.awy.awj;
            if (i <= 0 && i >= this.awy.awf - this.awy.atq) {
                if (f < 0.0f) {
                    this.awy.aws.P(f);
                } else {
                    this.awy.aws.N(f);
                }
            } else if (i >= 0 && i <= this.awy.atq - this.awy.awh) {
                if (f < 0.0f) {
                    this.awy.aws.O(f);
                } else {
                    this.awy.aws.Q(f);
                }
            }
        }

        private void S(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.awy.aws.P(f);
            } else {
                this.awy.aws.N(f);
            }
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.awy.aws.O(f);
            } else {
                this.awy.aws.Q(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float atP;
        float atQ;
        float atR;
        float atS;
        long atT;
        long atU;
        boolean atV;
        final /* synthetic */ VerticalTranslateLayout awy;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atP = ((((float) (uptimeMillis - this.atT)) / 1000.0f) * this.atQ) + this.atP;
            this.atT = uptimeMillis;
            this.atU += 16;
        }

        void sM() {
            compute();
            if (this.atP <= this.atR) {
                e eVar = this.awy.awu;
                if (eVar != null) {
                    eVar.sR();
                }
                this.atV = false;
                this.awy.aty = 10000;
                this.awy.rS();
                return;
            }
            this.awy.awj = (int) (com.baidu.adp.widget.a.c(this.atR, this.atP, false) + this.atS);
            this.awy.invalidate();
            this.awy.awr.sendEmptyMessageAtTime(-100, this.atU);
        }

        void sN() {
            compute();
            if (this.atP >= this.atR) {
                c cVar = this.awy.awv;
                if (cVar != null) {
                    cVar.sQ();
                }
                this.atV = false;
                this.awy.aty = 10001;
                this.awy.rS();
                return;
            }
            this.awy.awj = (int) (com.baidu.adp.widget.a.c(this.atR, this.atP, false) + this.atS);
            this.awy.invalidate();
            this.awy.awr.sendEmptyMessageAtTime(-101, this.atU);
        }

        void sO() {
            compute();
            if (this.atP >= this.atR) {
                for (d dVar : this.awy.atL) {
                    if (dVar != null) {
                        dVar.sa();
                    }
                }
                this.atV = false;
                this.awy.aty = 10004;
                this.awy.rS();
                return;
            }
            this.awy.awj = (int) (com.baidu.adp.widget.a.c(this.atR, this.atP, false) + this.atS);
            this.awy.invalidate();
            this.awy.awr.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atU);
        }

        void sP() {
            compute();
            if (this.atP <= this.atR) {
                for (d dVar : this.awy.atL) {
                    if (dVar != null) {
                        dVar.sa();
                    }
                }
                this.atV = false;
                this.awy.aty = 10004;
                this.awy.rS();
                return;
            }
            this.awy.awj = (int) (com.baidu.adp.widget.a.c(this.atR, this.atP, false) + this.atS);
            this.awy.invalidate();
            this.awy.awr.sendEmptyMessageAtTime(-105, this.atU);
        }

        void N(float f) {
            for (d dVar : this.awy.atL) {
                if (dVar != null) {
                    dVar.rZ();
                }
            }
            this.atV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atT = uptimeMillis;
            this.atU = uptimeMillis + 16;
            this.atQ = f;
            this.atP = 0.0f;
            this.atR = 0 - this.awy.awj;
            this.atS = this.awy.awj;
            this.awy.awr.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atR);
            BdLog.d("Animator@animateTopOpen " + f);
            this.awy.awr.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atU);
        }

        void O(float f) {
            for (d dVar : this.awy.atL) {
                if (dVar != null) {
                    dVar.rZ();
                }
            }
            this.atV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atT = uptimeMillis;
            this.atU = uptimeMillis + 16;
            this.atQ = f;
            this.atP = 0.0f;
            this.atR = 0 - this.awy.awj;
            this.atS = this.awy.awj;
            BdLog.d("Animator@animateBottomOpen " + this.atR);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.awy.awr.removeMessages(-105);
            this.awy.awr.sendEmptyMessageAtTime(-105, this.atU);
        }

        void P(float f) {
            e eVar = this.awy.awu;
            if (eVar != null) {
                eVar.rX();
            }
            this.atV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atT = uptimeMillis;
            this.atU = uptimeMillis + 16;
            this.atQ = f;
            this.atP = 0.0f;
            this.atR = ((-this.awy.atq) + this.awy.awf) - this.awy.awj;
            this.atS = this.awy.awj;
            BdLog.d("Animator@animateTop " + this.atR);
            BdLog.d("Animator@animateTop " + f);
            this.awy.awr.removeMessages(-100);
            this.awy.awr.sendEmptyMessageAtTime(-100, this.atU);
        }

        void Q(float f) {
            c cVar = this.awy.awv;
            if (cVar != null) {
                cVar.sb();
            }
            this.atV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atT = uptimeMillis;
            this.atU = uptimeMillis + 16;
            this.atQ = f;
            this.atP = 0.0f;
            this.atR = (this.awy.atq - this.awy.awh) - this.awy.awj;
            this.atS = this.awy.awj;
            BdLog.d("Animator@animateBottom " + this.atR);
            BdLog.d("Animator@animateBottom " + f);
            this.awy.awr.removeMessages(-101);
            this.awy.awr.sendEmptyMessageAtTime(-101, this.atU);
        }
    }
}
