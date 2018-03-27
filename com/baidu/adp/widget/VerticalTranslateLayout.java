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
    private final List<d> atB;
    private int atf;
    private int atg;
    private final int atk;
    private int ato;
    private final Paint atr;
    private int ats;
    private int att;
    private float avV;
    private float avW;
    private float avX;
    private float avY;
    private int avZ;
    private boolean awa;
    private boolean awb;
    private TrackDirection awc;
    private final Rect awd;
    private final Rect awe;
    private int awf;
    private boolean awg;
    private final a awh;
    private final b awi;
    private final g awj;
    private e awk;
    private c awl;
    private f awm;

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
        this.atr.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.avZ = (int) ((this.avV - this.atg) * (-f2));
            } else if (f2 > 0.0f) {
                this.avZ = (int) ((this.atg - this.avX) * f2);
            } else if (f2 == 0.0f) {
                this.avZ = 0;
                this.ato = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.avV -= this.atg;
                this.ato = 10000;
            } else if (f2 == 1.0f) {
                this.avV = this.atg - this.avX;
                this.ato = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.avV;
    }

    public int getBottomOffset() {
        return (int) this.avX;
    }

    public void setTopTapBack(boolean z) {
        this.awa = z;
    }

    public void setBottomTapBack(boolean z) {
        this.awb = z;
    }

    public int getState() {
        return this.ato;
    }

    public void setTopAnimationListener(e eVar) {
        this.awk = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.awl = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.awm = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.avZ);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.avZ);
        canvas.drawRect(0.0f, 0.0f, this.atf, this.atg, this.atr);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.avZ;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.awc == TrackDirection.none) {
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
                    this.awh.removeMessages(-100);
                    this.awh.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.awh.removeMessages(-101);
                    this.awh.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.avZ);
                    return ap(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i >= this.ats - this.atk && i <= this.ats + this.atk && (i2 < this.att - this.atk || i2 > this.att + this.atk) && this.awj.dB(i2 - this.att);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.awg = false;
                    if (this.awj.atO) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.awj.sc();
                        this.awj.sd();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.awj.atO) {
                        if (!this.awg) {
                            if (y > this.att) {
                                this.awf = this.att + this.atk;
                                this.awg = true;
                            } else {
                                this.awf = this.att - this.atk;
                                this.awg = true;
                            }
                        }
                        this.awj.dC(this.awf - y);
                        this.awf = y;
                        this.awj.atN.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.ato != 10000 || !this.awd.contains(x, y)) && (this.ato != 10001 || !this.awe.contains(x, y))) {
                    return false;
                }
                if (!this.awj.atO) {
                    this.awf = y;
                    this.awj.dB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.awj.atO) {
                    this.awj.sc();
                    this.awj.sd();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.awj.atO) {
            this.awj.dC(this.awf - y);
            this.awf = y;
            this.awj.atN.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.avV != -1.0f) {
                this.awd.set(i, i2, i3, (int) (i2 + this.avV));
            }
            if (this.avX != -1.0f) {
                this.awe.set(i, (int) (i4 - this.avX), i3, i4);
            }
        }
        if (!this.awi.atL && !this.awj.atO) {
            rR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.avW != -1.0f) {
            this.avV = i3 - this.avY;
        }
        if (this.avY != -1.0f) {
            this.avX = i3 - this.avW;
        }
        if (!$assertionsDisabled && i3 < this.avV) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.avX) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.atf = getMeasuredWidth();
        this.atg = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        switch (this.ato) {
            case 10000:
                this.avZ = (int) (this.avV - this.atg);
                invalidate();
                return;
            case 10001:
                this.avZ = (int) (this.atg - this.avX);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.avZ = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout awo;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.awo.awi.atL) {
                switch (message.what) {
                    case -105:
                        this.awo.awi.sO();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.awo.awi.sN();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.awo.awi.sM();
                        return;
                    case -100:
                        this.awo.awi.sL();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker atN;
        boolean atO;
        final int atP;
        final int atQ;
        final /* synthetic */ VerticalTranslateLayout awo;

        boolean dB(int i) {
            switch (this.awo.awc) {
                case top:
                    if (this.awo.ato != 10004 && this.awo.ato != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.awo.ato != 10004 && this.awo.ato != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.awo.awm != null) {
                        this.awo.awm.dL(i);
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
                int i2 = this.awo.avZ - i;
                switch (this.awo.awc) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.awo.avV - this.awo.atg && i2 < 0) {
                            this.awo.avZ -= i;
                            this.awo.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.awo.atg - this.awo.avX && i2 > 0) {
                            this.awo.avZ -= i;
                            this.awo.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.awo.avV - this.awo.atg && i2 <= this.awo.atg - this.awo.avX) {
                            this.awo.avZ -= i;
                            this.awo.invalidate();
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
            float yVelocity = this.atN.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.atQ);
            } else {
                max = Math.max(yVelocity, this.atQ);
            }
            switch (this.awo.awc) {
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
            this.atN.recycle();
            this.atN = null;
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.awo.avZ;
            if (i <= 0 && i >= this.awo.avV - this.awo.atg) {
                if (f < 0.0f) {
                    this.awo.awi.T(f);
                } else {
                    this.awo.awi.R(f);
                }
            } else if (i >= 0 && i <= this.awo.atg - this.awo.avX) {
                if (f < 0.0f) {
                    this.awo.awi.S(f);
                } else {
                    this.awo.awi.U(f);
                }
            }
        }

        private void W(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.awo.awi.T(f);
            } else {
                this.awo.awi.R(f);
            }
        }

        private void X(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.awo.awi.S(f);
            } else {
                this.awo.awi.U(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float atF;
        float atG;
        float atH;
        float atI;
        long atJ;
        long atK;
        boolean atL;
        final /* synthetic */ VerticalTranslateLayout awo;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atF = ((((float) (uptimeMillis - this.atJ)) / 1000.0f) * this.atG) + this.atF;
            this.atJ = uptimeMillis;
            this.atK += 16;
        }

        void sL() {
            compute();
            if (this.atF <= this.atH) {
                e eVar = this.awo.awk;
                if (eVar != null) {
                    eVar.sQ();
                }
                this.atL = false;
                this.awo.ato = 10000;
                this.awo.rR();
                return;
            }
            this.awo.avZ = (int) (com.baidu.adp.widget.a.c(this.atH, this.atF, false) + this.atI);
            this.awo.invalidate();
            this.awo.awh.sendEmptyMessageAtTime(-100, this.atK);
        }

        void sM() {
            compute();
            if (this.atF >= this.atH) {
                c cVar = this.awo.awl;
                if (cVar != null) {
                    cVar.sP();
                }
                this.atL = false;
                this.awo.ato = 10001;
                this.awo.rR();
                return;
            }
            this.awo.avZ = (int) (com.baidu.adp.widget.a.c(this.atH, this.atF, false) + this.atI);
            this.awo.invalidate();
            this.awo.awh.sendEmptyMessageAtTime(-101, this.atK);
        }

        void sN() {
            compute();
            if (this.atF >= this.atH) {
                for (d dVar : this.awo.atB) {
                    if (dVar != null) {
                        dVar.rZ();
                    }
                }
                this.atL = false;
                this.awo.ato = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.awo.rR();
                return;
            }
            this.awo.avZ = (int) (com.baidu.adp.widget.a.c(this.atH, this.atF, false) + this.atI);
            this.awo.invalidate();
            this.awo.awh.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atK);
        }

        void sO() {
            compute();
            if (this.atF <= this.atH) {
                for (d dVar : this.awo.atB) {
                    if (dVar != null) {
                        dVar.rZ();
                    }
                }
                this.atL = false;
                this.awo.ato = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.awo.rR();
                return;
            }
            this.awo.avZ = (int) (com.baidu.adp.widget.a.c(this.atH, this.atF, false) + this.atI);
            this.awo.invalidate();
            this.awo.awh.sendEmptyMessageAtTime(-105, this.atK);
        }

        void R(float f) {
            for (d dVar : this.awo.atB) {
                if (dVar != null) {
                    dVar.rY();
                }
            }
            this.atL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atJ = uptimeMillis;
            this.atK = uptimeMillis + 16;
            this.atG = f;
            this.atF = 0.0f;
            this.atH = 0 - this.awo.avZ;
            this.atI = this.awo.avZ;
            this.awo.awh.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atH);
            BdLog.d("Animator@animateTopOpen " + f);
            this.awo.awh.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atK);
        }

        void S(float f) {
            for (d dVar : this.awo.atB) {
                if (dVar != null) {
                    dVar.rY();
                }
            }
            this.atL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atJ = uptimeMillis;
            this.atK = uptimeMillis + 16;
            this.atG = f;
            this.atF = 0.0f;
            this.atH = 0 - this.awo.avZ;
            this.atI = this.awo.avZ;
            BdLog.d("Animator@animateBottomOpen " + this.atH);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.awo.awh.removeMessages(-105);
            this.awo.awh.sendEmptyMessageAtTime(-105, this.atK);
        }

        void T(float f) {
            e eVar = this.awo.awk;
            if (eVar != null) {
                eVar.rW();
            }
            this.atL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atJ = uptimeMillis;
            this.atK = uptimeMillis + 16;
            this.atG = f;
            this.atF = 0.0f;
            this.atH = ((-this.awo.atg) + this.awo.avV) - this.awo.avZ;
            this.atI = this.awo.avZ;
            BdLog.d("Animator@animateTop " + this.atH);
            BdLog.d("Animator@animateTop " + f);
            this.awo.awh.removeMessages(-100);
            this.awo.awh.sendEmptyMessageAtTime(-100, this.atK);
        }

        void U(float f) {
            c cVar = this.awo.awl;
            if (cVar != null) {
                cVar.sa();
            }
            this.atL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atJ = uptimeMillis;
            this.atK = uptimeMillis + 16;
            this.atG = f;
            this.atF = 0.0f;
            this.atH = (this.awo.atg - this.awo.avX) - this.awo.avZ;
            this.atI = this.awo.avZ;
            BdLog.d("Animator@animateBottom " + this.atH);
            BdLog.d("Animator@animateBottom " + f);
            this.awo.awh.removeMessages(-101);
            this.awo.awh.sendEmptyMessageAtTime(-101, this.atK);
        }
    }
}
