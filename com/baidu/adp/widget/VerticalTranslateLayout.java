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
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final List<d> atA;
    private int ate;
    private int atf;
    private final int atj;
    private int atn;
    private final Paint atq;
    private int atr;
    private int ats;
    private float avU;
    private float avV;
    private float avW;
    private float avX;
    private int avY;
    private boolean avZ;
    private boolean awa;
    private TrackDirection awb;
    private final Rect awc;
    private final Rect awd;
    private int awe;
    private boolean awf;
    private final a awg;
    private final b awh;
    private final g awi;
    private e awj;
    private c awk;
    private f awl;

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
        void sP();

        void sa();
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
        void rW();

        void sQ();
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
        this.atq.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.avY = (int) ((this.avU - this.atf) * (-f2));
            } else if (f2 > 0.0f) {
                this.avY = (int) ((this.atf - this.avW) * f2);
            } else if (f2 == 0.0f) {
                this.avY = 0;
                this.atn = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.avU -= this.atf;
                this.atn = 10000;
            } else if (f2 == 1.0f) {
                this.avU = this.atf - this.avW;
                this.atn = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.avU;
    }

    public int getBottomOffset() {
        return (int) this.avW;
    }

    public void setTopTapBack(boolean z) {
        this.avZ = z;
    }

    public void setBottomTapBack(boolean z) {
        this.awa = z;
    }

    public int getState() {
        return this.atn;
    }

    public void setTopAnimationListener(e eVar) {
        this.awj = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.awk = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.awl = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.avY);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.avY);
        canvas.drawRect(0.0f, 0.0f, this.ate, this.atf, this.atq);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.avY;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.awb == TrackDirection.none) {
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
                    this.awg.removeMessages(-100);
                    this.awg.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.awg.removeMessages(-101);
                    this.awg.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.avY);
                    return ap(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i >= this.atr - this.atj && i <= this.atr + this.atj && (i2 < this.ats - this.atj || i2 > this.ats + this.atj) && this.awi.dB(i2 - this.ats);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.awf = false;
                    if (this.awi.atN) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.awi.sc();
                        this.awi.sd();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.awi.atN) {
                        if (!this.awf) {
                            if (y > this.ats) {
                                this.awe = this.ats + this.atj;
                                this.awf = true;
                            } else {
                                this.awe = this.ats - this.atj;
                                this.awf = true;
                            }
                        }
                        this.awi.dC(this.awe - y);
                        this.awe = y;
                        this.awi.atM.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.atn != 10000 || !this.awc.contains(x, y)) && (this.atn != 10001 || !this.awd.contains(x, y))) {
                    return false;
                }
                if (!this.awi.atN) {
                    this.awe = y;
                    this.awi.dB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.awi.atN) {
                    this.awi.sc();
                    this.awi.sd();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.awi.atN) {
            this.awi.dC(this.awe - y);
            this.awe = y;
            this.awi.atM.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.avU != -1.0f) {
                this.awc.set(i, i2, i3, (int) (i2 + this.avU));
            }
            if (this.avW != -1.0f) {
                this.awd.set(i, (int) (i4 - this.avW), i3, i4);
            }
        }
        if (!this.awh.atK && !this.awi.atN) {
            rR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.avV != -1.0f) {
            this.avU = i3 - this.avX;
        }
        if (this.avX != -1.0f) {
            this.avW = i3 - this.avV;
        }
        if (!$assertionsDisabled && i3 < this.avU) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.avW) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.ate = getMeasuredWidth();
        this.atf = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        switch (this.atn) {
            case 10000:
                this.avY = (int) (this.avU - this.atf);
                invalidate();
                return;
            case 10001:
                this.avY = (int) (this.atf - this.avW);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.avY = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout awn;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.awn.awh.atK) {
                switch (message.what) {
                    case -105:
                        this.awn.awh.sO();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.awn.awh.sN();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.awn.awh.sM();
                        return;
                    case -100:
                        this.awn.awh.sL();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker atM;
        boolean atN;
        final int atO;
        final int atP;
        final /* synthetic */ VerticalTranslateLayout awn;

        boolean dB(int i) {
            switch (this.awn.awb) {
                case top:
                    if (this.awn.atn != 10004 && this.awn.atn != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.awn.atn != 10004 && this.awn.atn != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.awn.awl != null) {
                        this.awn.awl.dL(i);
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
                int i2 = this.awn.avY - i;
                switch (this.awn.awb) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.awn.avU - this.awn.atf && i2 < 0) {
                            this.awn.avY -= i;
                            this.awn.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.awn.atf - this.awn.avW && i2 > 0) {
                            this.awn.avY -= i;
                            this.awn.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.awn.avU - this.awn.atf && i2 <= this.awn.atf - this.awn.avW) {
                            this.awn.avY -= i;
                            this.awn.invalidate();
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
            float yVelocity = this.atM.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.atP);
            } else {
                max = Math.max(yVelocity, this.atP);
            }
            switch (this.awn.awb) {
                case top:
                    W(max);
                    break;
                case bottom:
                    X(max);
                    break;
                case vertical:
                    V(max);
                    break;
            }
            this.atM.recycle();
            this.atM = null;
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.awn.avY;
            if (i <= 0 && i >= this.awn.avU - this.awn.atf) {
                if (f < 0.0f) {
                    this.awn.awh.T(f);
                } else {
                    this.awn.awh.R(f);
                }
            } else if (i >= 0 && i <= this.awn.atf - this.awn.avW) {
                if (f < 0.0f) {
                    this.awn.awh.S(f);
                } else {
                    this.awn.awh.U(f);
                }
            }
        }

        private void W(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.awn.awh.T(f);
            } else {
                this.awn.awh.R(f);
            }
        }

        private void X(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.awn.awh.S(f);
            } else {
                this.awn.awh.U(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float atE;
        float atF;
        float atG;
        float atH;
        long atI;
        long atJ;
        boolean atK;
        final /* synthetic */ VerticalTranslateLayout awn;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atE = ((((float) (uptimeMillis - this.atI)) / 1000.0f) * this.atF) + this.atE;
            this.atI = uptimeMillis;
            this.atJ += 16;
        }

        void sL() {
            compute();
            if (this.atE <= this.atG) {
                e eVar = this.awn.awj;
                if (eVar != null) {
                    eVar.sQ();
                }
                this.atK = false;
                this.awn.atn = 10000;
                this.awn.rR();
                return;
            }
            this.awn.avY = (int) (com.baidu.adp.widget.a.c(this.atG, this.atE, false) + this.atH);
            this.awn.invalidate();
            this.awn.awg.sendEmptyMessageAtTime(-100, this.atJ);
        }

        void sM() {
            compute();
            if (this.atE >= this.atG) {
                c cVar = this.awn.awk;
                if (cVar != null) {
                    cVar.sP();
                }
                this.atK = false;
                this.awn.atn = 10001;
                this.awn.rR();
                return;
            }
            this.awn.avY = (int) (com.baidu.adp.widget.a.c(this.atG, this.atE, false) + this.atH);
            this.awn.invalidate();
            this.awn.awg.sendEmptyMessageAtTime(-101, this.atJ);
        }

        void sN() {
            compute();
            if (this.atE >= this.atG) {
                for (d dVar : this.awn.atA) {
                    if (dVar != null) {
                        dVar.rZ();
                    }
                }
                this.atK = false;
                this.awn.atn = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.awn.rR();
                return;
            }
            this.awn.avY = (int) (com.baidu.adp.widget.a.c(this.atG, this.atE, false) + this.atH);
            this.awn.invalidate();
            this.awn.awg.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atJ);
        }

        void sO() {
            compute();
            if (this.atE <= this.atG) {
                for (d dVar : this.awn.atA) {
                    if (dVar != null) {
                        dVar.rZ();
                    }
                }
                this.atK = false;
                this.awn.atn = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.awn.rR();
                return;
            }
            this.awn.avY = (int) (com.baidu.adp.widget.a.c(this.atG, this.atE, false) + this.atH);
            this.awn.invalidate();
            this.awn.awg.sendEmptyMessageAtTime(-105, this.atJ);
        }

        void R(float f) {
            for (d dVar : this.awn.atA) {
                if (dVar != null) {
                    dVar.rY();
                }
            }
            this.atK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atI = uptimeMillis;
            this.atJ = uptimeMillis + 16;
            this.atF = f;
            this.atE = 0.0f;
            this.atG = 0 - this.awn.avY;
            this.atH = this.awn.avY;
            this.awn.awg.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atG);
            BdLog.d("Animator@animateTopOpen " + f);
            this.awn.awg.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atJ);
        }

        void S(float f) {
            for (d dVar : this.awn.atA) {
                if (dVar != null) {
                    dVar.rY();
                }
            }
            this.atK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atI = uptimeMillis;
            this.atJ = uptimeMillis + 16;
            this.atF = f;
            this.atE = 0.0f;
            this.atG = 0 - this.awn.avY;
            this.atH = this.awn.avY;
            BdLog.d("Animator@animateBottomOpen " + this.atG);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.awn.awg.removeMessages(-105);
            this.awn.awg.sendEmptyMessageAtTime(-105, this.atJ);
        }

        void T(float f) {
            e eVar = this.awn.awj;
            if (eVar != null) {
                eVar.rW();
            }
            this.atK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atI = uptimeMillis;
            this.atJ = uptimeMillis + 16;
            this.atF = f;
            this.atE = 0.0f;
            this.atG = ((-this.awn.atf) + this.awn.avU) - this.awn.avY;
            this.atH = this.awn.avY;
            BdLog.d("Animator@animateTop " + this.atG);
            BdLog.d("Animator@animateTop " + f);
            this.awn.awg.removeMessages(-100);
            this.awn.awg.sendEmptyMessageAtTime(-100, this.atJ);
        }

        void U(float f) {
            c cVar = this.awn.awk;
            if (cVar != null) {
                cVar.sa();
            }
            this.atK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atI = uptimeMillis;
            this.atJ = uptimeMillis + 16;
            this.atF = f;
            this.atE = 0.0f;
            this.atG = (this.awn.atf - this.awn.avW) - this.awn.avY;
            this.atH = this.awn.avY;
            BdLog.d("Animator@animateBottom " + this.atG);
            BdLog.d("Animator@animateBottom " + f);
            this.awn.awg.removeMessages(-101);
            this.awn.awg.sendEmptyMessageAtTime(-101, this.atJ);
        }
    }
}
