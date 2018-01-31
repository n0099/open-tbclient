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
    private int atB;
    private final Paint atE;
    private int atF;
    private int atG;
    private final List<d> atO;
    private int ats;
    private int att;
    private final int atx;
    private float awi;
    private float awj;
    private float awk;
    private float awl;
    private int awm;
    private boolean awn;
    private boolean awo;
    private TrackDirection awp;
    private final Rect awq;
    private final Rect awr;
    private int aws;
    private boolean awt;
    private final a awu;
    private final b awv;
    private final g aww;
    private e awx;
    private c awy;
    private f awz;

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
        void sR();

        void sc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void sa();

        void sb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void rY();

        void sS();
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
        this.atE.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.awm = (int) ((this.awi - this.att) * (-f2));
            } else if (f2 > 0.0f) {
                this.awm = (int) ((this.att - this.awk) * f2);
            } else if (f2 == 0.0f) {
                this.awm = 0;
                this.atB = 10004;
            } else if (f2 == -1.0f) {
                this.awi -= this.att;
                this.atB = 10000;
            } else if (f2 == 1.0f) {
                this.awi = this.att - this.awk;
                this.atB = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.awi;
    }

    public int getBottomOffset() {
        return (int) this.awk;
    }

    public void setTopTapBack(boolean z) {
        this.awn = z;
    }

    public void setBottomTapBack(boolean z) {
        this.awo = z;
    }

    public int getState() {
        return this.atB;
    }

    public void setTopAnimationListener(e eVar) {
        this.awx = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.awy = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.awz = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.awm);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.awm);
        canvas.drawRect(0.0f, 0.0f, this.ats, this.att, this.atE);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.awm;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.awp == TrackDirection.none) {
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
                    this.awu.removeMessages(-100);
                    this.awu.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.awu.removeMessages(-101);
                    this.awu.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.awm);
                    return ap(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i >= this.atF - this.atx && i <= this.atF + this.atx && (i2 < this.atG - this.atx || i2 > this.atG + this.atx) && this.aww.dB(i2 - this.atG);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.awt = false;
                    if (this.aww.aub) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.aww.se();
                        this.aww.sf();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.aww.aub) {
                        if (!this.awt) {
                            if (y > this.atG) {
                                this.aws = this.atG + this.atx;
                                this.awt = true;
                            } else {
                                this.aws = this.atG - this.atx;
                                this.awt = true;
                            }
                        }
                        this.aww.dC(this.aws - y);
                        this.aws = y;
                        this.aww.aua.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.atB != 10000 || !this.awq.contains(x, y)) && (this.atB != 10001 || !this.awr.contains(x, y))) {
                    return false;
                }
                if (!this.aww.aub) {
                    this.aws = y;
                    this.aww.dB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.aww.aub) {
                    this.aww.se();
                    this.aww.sf();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.aww.aub) {
            this.aww.dC(this.aws - y);
            this.aws = y;
            this.aww.aua.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.awi != -1.0f) {
                this.awq.set(i, i2, i3, (int) (i2 + this.awi));
            }
            if (this.awk != -1.0f) {
                this.awr.set(i, (int) (i4 - this.awk), i3, i4);
            }
        }
        if (!this.awv.atY && !this.aww.aub) {
            rT();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.awj != -1.0f) {
            this.awi = i3 - this.awl;
        }
        if (this.awl != -1.0f) {
            this.awk = i3 - this.awj;
        }
        if (!$assertionsDisabled && i3 < this.awi) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.awk) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.ats = getMeasuredWidth();
        this.att = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT() {
        switch (this.atB) {
            case 10000:
                this.awm = (int) (this.awi - this.att);
                invalidate();
                return;
            case 10001:
                this.awm = (int) (this.att - this.awk);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.awm = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout awB;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.awB.awv.atY) {
                switch (message.what) {
                    case -105:
                        this.awB.awv.sQ();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.awB.awv.sP();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.awB.awv.sO();
                        return;
                    case -100:
                        this.awB.awv.sN();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker aua;
        boolean aub;
        final int auc;
        final int aud;
        final /* synthetic */ VerticalTranslateLayout awB;

        boolean dB(int i) {
            switch (this.awB.awp) {
                case top:
                    if (this.awB.atB != 10004 && this.awB.atB != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.awB.atB != 10004 && this.awB.atB != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.awB.awz != null) {
                        this.awB.awz.dL(i);
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
                int i2 = this.awB.awm - i;
                switch (this.awB.awp) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.awB.awi - this.awB.att && i2 < 0) {
                            this.awB.awm -= i;
                            this.awB.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.awB.att - this.awB.awk && i2 > 0) {
                            this.awB.awm -= i;
                            this.awB.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.awB.awi - this.awB.att && i2 <= this.awB.att - this.awB.awk) {
                            this.awB.awm -= i;
                            this.awB.invalidate();
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
            float yVelocity = this.aua.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.aud);
            } else {
                max = Math.max(yVelocity, this.aud);
            }
            switch (this.awB.awp) {
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
            this.aua.recycle();
            this.aua = null;
        }

        private void R(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.awB.awm;
            if (i <= 0 && i >= this.awB.awi - this.awB.att) {
                if (f < 0.0f) {
                    this.awB.awv.P(f);
                } else {
                    this.awB.awv.N(f);
                }
            } else if (i >= 0 && i <= this.awB.att - this.awB.awk) {
                if (f < 0.0f) {
                    this.awB.awv.O(f);
                } else {
                    this.awB.awv.Q(f);
                }
            }
        }

        private void S(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.awB.awv.P(f);
            } else {
                this.awB.awv.N(f);
            }
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.awB.awv.O(f);
            } else {
                this.awB.awv.Q(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float atS;
        float atT;
        float atU;
        float atV;
        long atW;
        long atX;
        boolean atY;
        final /* synthetic */ VerticalTranslateLayout awB;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atS = ((((float) (uptimeMillis - this.atW)) / 1000.0f) * this.atT) + this.atS;
            this.atW = uptimeMillis;
            this.atX += 16;
        }

        void sN() {
            compute();
            if (this.atS <= this.atU) {
                e eVar = this.awB.awx;
                if (eVar != null) {
                    eVar.sS();
                }
                this.atY = false;
                this.awB.atB = 10000;
                this.awB.rT();
                return;
            }
            this.awB.awm = (int) (com.baidu.adp.widget.a.c(this.atU, this.atS, false) + this.atV);
            this.awB.invalidate();
            this.awB.awu.sendEmptyMessageAtTime(-100, this.atX);
        }

        void sO() {
            compute();
            if (this.atS >= this.atU) {
                c cVar = this.awB.awy;
                if (cVar != null) {
                    cVar.sR();
                }
                this.atY = false;
                this.awB.atB = 10001;
                this.awB.rT();
                return;
            }
            this.awB.awm = (int) (com.baidu.adp.widget.a.c(this.atU, this.atS, false) + this.atV);
            this.awB.invalidate();
            this.awB.awu.sendEmptyMessageAtTime(-101, this.atX);
        }

        void sP() {
            compute();
            if (this.atS >= this.atU) {
                for (d dVar : this.awB.atO) {
                    if (dVar != null) {
                        dVar.sb();
                    }
                }
                this.atY = false;
                this.awB.atB = 10004;
                this.awB.rT();
                return;
            }
            this.awB.awm = (int) (com.baidu.adp.widget.a.c(this.atU, this.atS, false) + this.atV);
            this.awB.invalidate();
            this.awB.awu.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atX);
        }

        void sQ() {
            compute();
            if (this.atS <= this.atU) {
                for (d dVar : this.awB.atO) {
                    if (dVar != null) {
                        dVar.sb();
                    }
                }
                this.atY = false;
                this.awB.atB = 10004;
                this.awB.rT();
                return;
            }
            this.awB.awm = (int) (com.baidu.adp.widget.a.c(this.atU, this.atS, false) + this.atV);
            this.awB.invalidate();
            this.awB.awu.sendEmptyMessageAtTime(-105, this.atX);
        }

        void N(float f) {
            for (d dVar : this.awB.atO) {
                if (dVar != null) {
                    dVar.sa();
                }
            }
            this.atY = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atW = uptimeMillis;
            this.atX = uptimeMillis + 16;
            this.atT = f;
            this.atS = 0.0f;
            this.atU = 0 - this.awB.awm;
            this.atV = this.awB.awm;
            this.awB.awu.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atU);
            BdLog.d("Animator@animateTopOpen " + f);
            this.awB.awu.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atX);
        }

        void O(float f) {
            for (d dVar : this.awB.atO) {
                if (dVar != null) {
                    dVar.sa();
                }
            }
            this.atY = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atW = uptimeMillis;
            this.atX = uptimeMillis + 16;
            this.atT = f;
            this.atS = 0.0f;
            this.atU = 0 - this.awB.awm;
            this.atV = this.awB.awm;
            BdLog.d("Animator@animateBottomOpen " + this.atU);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.awB.awu.removeMessages(-105);
            this.awB.awu.sendEmptyMessageAtTime(-105, this.atX);
        }

        void P(float f) {
            e eVar = this.awB.awx;
            if (eVar != null) {
                eVar.rY();
            }
            this.atY = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atW = uptimeMillis;
            this.atX = uptimeMillis + 16;
            this.atT = f;
            this.atS = 0.0f;
            this.atU = ((-this.awB.att) + this.awB.awi) - this.awB.awm;
            this.atV = this.awB.awm;
            BdLog.d("Animator@animateTop " + this.atU);
            BdLog.d("Animator@animateTop " + f);
            this.awB.awu.removeMessages(-100);
            this.awB.awu.sendEmptyMessageAtTime(-100, this.atX);
        }

        void Q(float f) {
            c cVar = this.awB.awy;
            if (cVar != null) {
                cVar.sc();
            }
            this.atY = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atW = uptimeMillis;
            this.atX = uptimeMillis + 16;
            this.atT = f;
            this.atS = 0.0f;
            this.atU = (this.awB.att - this.awB.awk) - this.awB.awm;
            this.atV = this.awB.awm;
            BdLog.d("Animator@animateBottom " + this.atU);
            BdLog.d("Animator@animateBottom " + f);
            this.awB.awu.removeMessages(-101);
            this.awB.awu.sendEmptyMessageAtTime(-101, this.atX);
        }
    }
}
