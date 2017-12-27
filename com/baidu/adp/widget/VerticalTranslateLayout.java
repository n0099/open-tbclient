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
    private final Paint atC;
    private int atD;
    private int atE;
    private final List<d> atM;
    private int atq;
    private int atr;
    private final int atv;
    private int atz;
    private float awg;
    private float awh;
    private float awi;
    private float awj;
    private int awk;
    private boolean awl;
    private boolean awm;
    private TrackDirection awn;
    private final Rect awo;
    private final Rect awp;
    private int awq;
    private boolean awr;
    private final a aws;
    private final b awt;
    private final g awu;
    private e awv;
    private c aww;
    private f awx;

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
        this.atC.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.awk = (int) ((this.awg - this.atr) * (-f2));
            } else if (f2 > 0.0f) {
                this.awk = (int) ((this.atr - this.awi) * f2);
            } else if (f2 == 0.0f) {
                this.awk = 0;
                this.atz = 10004;
            } else if (f2 == -1.0f) {
                this.awg -= this.atr;
                this.atz = 10000;
            } else if (f2 == 1.0f) {
                this.awg = this.atr - this.awi;
                this.atz = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.awg;
    }

    public int getBottomOffset() {
        return (int) this.awi;
    }

    public void setTopTapBack(boolean z) {
        this.awl = z;
    }

    public void setBottomTapBack(boolean z) {
        this.awm = z;
    }

    public int getState() {
        return this.atz;
    }

    public void setTopAnimationListener(e eVar) {
        this.awv = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.aww = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.awx = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.awk);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.awk);
        canvas.drawRect(0.0f, 0.0f, this.atq, this.atr, this.atC);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.awk;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.awn == TrackDirection.none) {
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
                    this.aws.removeMessages(-100);
                    this.aws.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.aws.removeMessages(-101);
                    this.aws.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.awk);
                    return ap(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i >= this.atD - this.atv && i <= this.atD + this.atv && (i2 < this.atE - this.atv || i2 > this.atE + this.atv) && this.awu.dB(i2 - this.atE);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.awr = false;
                    if (this.awu.atZ) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.awu.sd();
                        this.awu.se();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.awu.atZ) {
                        if (!this.awr) {
                            if (y > this.atE) {
                                this.awq = this.atE + this.atv;
                                this.awr = true;
                            } else {
                                this.awq = this.atE - this.atv;
                                this.awr = true;
                            }
                        }
                        this.awu.dC(this.awq - y);
                        this.awq = y;
                        this.awu.atY.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.atz != 10000 || !this.awo.contains(x, y)) && (this.atz != 10001 || !this.awp.contains(x, y))) {
                    return false;
                }
                if (!this.awu.atZ) {
                    this.awq = y;
                    this.awu.dB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.awu.atZ) {
                    this.awu.sd();
                    this.awu.se();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.awu.atZ) {
            this.awu.dC(this.awq - y);
            this.awq = y;
            this.awu.atY.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.awg != -1.0f) {
                this.awo.set(i, i2, i3, (int) (i2 + this.awg));
            }
            if (this.awi != -1.0f) {
                this.awp.set(i, (int) (i4 - this.awi), i3, i4);
            }
        }
        if (!this.awt.atW && !this.awu.atZ) {
            rS();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.awh != -1.0f) {
            this.awg = i3 - this.awj;
        }
        if (this.awj != -1.0f) {
            this.awi = i3 - this.awh;
        }
        if (!$assertionsDisabled && i3 < this.awg) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.awi) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.atq = getMeasuredWidth();
        this.atr = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS() {
        switch (this.atz) {
            case 10000:
                this.awk = (int) (this.awg - this.atr);
                invalidate();
                return;
            case 10001:
                this.awk = (int) (this.atr - this.awi);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.awk = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout awz;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.awz.awt.atW) {
                switch (message.what) {
                    case -105:
                        this.awz.awt.sP();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.awz.awt.sO();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.awz.awt.sN();
                        return;
                    case -100:
                        this.awz.awt.sM();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker atY;
        boolean atZ;
        final int aua;
        final int aub;
        final /* synthetic */ VerticalTranslateLayout awz;

        boolean dB(int i) {
            switch (this.awz.awn) {
                case top:
                    if (this.awz.atz != 10004 && this.awz.atz != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.awz.atz != 10004 && this.awz.atz != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.awz.awx != null) {
                        this.awz.awx.dL(i);
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
                int i2 = this.awz.awk - i;
                switch (this.awz.awn) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.awz.awg - this.awz.atr && i2 < 0) {
                            this.awz.awk -= i;
                            this.awz.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.awz.atr - this.awz.awi && i2 > 0) {
                            this.awz.awk -= i;
                            this.awz.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.awz.awg - this.awz.atr && i2 <= this.awz.atr - this.awz.awi) {
                            this.awz.awk -= i;
                            this.awz.invalidate();
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
            float yVelocity = this.atY.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.aub);
            } else {
                max = Math.max(yVelocity, this.aub);
            }
            switch (this.awz.awn) {
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
            this.atY.recycle();
            this.atY = null;
        }

        private void R(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.awz.awk;
            if (i <= 0 && i >= this.awz.awg - this.awz.atr) {
                if (f < 0.0f) {
                    this.awz.awt.P(f);
                } else {
                    this.awz.awt.N(f);
                }
            } else if (i >= 0 && i <= this.awz.atr - this.awz.awi) {
                if (f < 0.0f) {
                    this.awz.awt.O(f);
                } else {
                    this.awz.awt.Q(f);
                }
            }
        }

        private void S(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.awz.awt.P(f);
            } else {
                this.awz.awt.N(f);
            }
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.awz.awt.O(f);
            } else {
                this.awz.awt.Q(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float atQ;
        float atR;
        float atS;
        float atT;
        long atU;
        long atV;
        boolean atW;
        final /* synthetic */ VerticalTranslateLayout awz;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atQ = ((((float) (uptimeMillis - this.atU)) / 1000.0f) * this.atR) + this.atQ;
            this.atU = uptimeMillis;
            this.atV += 16;
        }

        void sM() {
            compute();
            if (this.atQ <= this.atS) {
                e eVar = this.awz.awv;
                if (eVar != null) {
                    eVar.sR();
                }
                this.atW = false;
                this.awz.atz = 10000;
                this.awz.rS();
                return;
            }
            this.awz.awk = (int) (com.baidu.adp.widget.a.c(this.atS, this.atQ, false) + this.atT);
            this.awz.invalidate();
            this.awz.aws.sendEmptyMessageAtTime(-100, this.atV);
        }

        void sN() {
            compute();
            if (this.atQ >= this.atS) {
                c cVar = this.awz.aww;
                if (cVar != null) {
                    cVar.sQ();
                }
                this.atW = false;
                this.awz.atz = 10001;
                this.awz.rS();
                return;
            }
            this.awz.awk = (int) (com.baidu.adp.widget.a.c(this.atS, this.atQ, false) + this.atT);
            this.awz.invalidate();
            this.awz.aws.sendEmptyMessageAtTime(-101, this.atV);
        }

        void sO() {
            compute();
            if (this.atQ >= this.atS) {
                for (d dVar : this.awz.atM) {
                    if (dVar != null) {
                        dVar.sa();
                    }
                }
                this.atW = false;
                this.awz.atz = 10004;
                this.awz.rS();
                return;
            }
            this.awz.awk = (int) (com.baidu.adp.widget.a.c(this.atS, this.atQ, false) + this.atT);
            this.awz.invalidate();
            this.awz.aws.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atV);
        }

        void sP() {
            compute();
            if (this.atQ <= this.atS) {
                for (d dVar : this.awz.atM) {
                    if (dVar != null) {
                        dVar.sa();
                    }
                }
                this.atW = false;
                this.awz.atz = 10004;
                this.awz.rS();
                return;
            }
            this.awz.awk = (int) (com.baidu.adp.widget.a.c(this.atS, this.atQ, false) + this.atT);
            this.awz.invalidate();
            this.awz.aws.sendEmptyMessageAtTime(-105, this.atV);
        }

        void N(float f) {
            for (d dVar : this.awz.atM) {
                if (dVar != null) {
                    dVar.rZ();
                }
            }
            this.atW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atU = uptimeMillis;
            this.atV = uptimeMillis + 16;
            this.atR = f;
            this.atQ = 0.0f;
            this.atS = 0 - this.awz.awk;
            this.atT = this.awz.awk;
            this.awz.aws.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atS);
            BdLog.d("Animator@animateTopOpen " + f);
            this.awz.aws.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atV);
        }

        void O(float f) {
            for (d dVar : this.awz.atM) {
                if (dVar != null) {
                    dVar.rZ();
                }
            }
            this.atW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atU = uptimeMillis;
            this.atV = uptimeMillis + 16;
            this.atR = f;
            this.atQ = 0.0f;
            this.atS = 0 - this.awz.awk;
            this.atT = this.awz.awk;
            BdLog.d("Animator@animateBottomOpen " + this.atS);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.awz.aws.removeMessages(-105);
            this.awz.aws.sendEmptyMessageAtTime(-105, this.atV);
        }

        void P(float f) {
            e eVar = this.awz.awv;
            if (eVar != null) {
                eVar.rX();
            }
            this.atW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atU = uptimeMillis;
            this.atV = uptimeMillis + 16;
            this.atR = f;
            this.atQ = 0.0f;
            this.atS = ((-this.awz.atr) + this.awz.awg) - this.awz.awk;
            this.atT = this.awz.awk;
            BdLog.d("Animator@animateTop " + this.atS);
            BdLog.d("Animator@animateTop " + f);
            this.awz.aws.removeMessages(-100);
            this.awz.aws.sendEmptyMessageAtTime(-100, this.atV);
        }

        void Q(float f) {
            c cVar = this.awz.aww;
            if (cVar != null) {
                cVar.sb();
            }
            this.atW = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atU = uptimeMillis;
            this.atV = uptimeMillis + 16;
            this.atR = f;
            this.atQ = 0.0f;
            this.atS = (this.awz.atr - this.awz.awi) - this.awz.awk;
            this.atT = this.awz.awk;
            BdLog.d("Animator@animateBottom " + this.atS);
            BdLog.d("Animator@animateBottom " + f);
            this.awz.aws.removeMessages(-101);
            this.awz.aws.sendEmptyMessageAtTime(-101, this.atV);
        }
    }
}
