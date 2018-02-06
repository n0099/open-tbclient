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
    private int atA;
    private int atB;
    private final List<d> atJ;
    private int atn;
    private int ato;
    private final int ats;
    private int atw;
    private final Paint atz;
    private float awd;
    private float awe;
    private float awf;
    private float awg;
    private int awh;
    private boolean awi;
    private boolean awj;
    private TrackDirection awk;
    private final Rect awl;
    private final Rect awm;
    private int awn;
    private boolean awo;
    private final a awp;
    private final b awq;
    private final g awr;
    private e aws;
    private c awt;
    private f awu;

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
        this.atz.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.awh = (int) ((this.awd - this.ato) * (-f2));
            } else if (f2 > 0.0f) {
                this.awh = (int) ((this.ato - this.awf) * f2);
            } else if (f2 == 0.0f) {
                this.awh = 0;
                this.atw = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.awd -= this.ato;
                this.atw = 10000;
            } else if (f2 == 1.0f) {
                this.awd = this.ato - this.awf;
                this.atw = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.awd;
    }

    public int getBottomOffset() {
        return (int) this.awf;
    }

    public void setTopTapBack(boolean z) {
        this.awi = z;
    }

    public void setBottomTapBack(boolean z) {
        this.awj = z;
    }

    public int getState() {
        return this.atw;
    }

    public void setTopAnimationListener(e eVar) {
        this.aws = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.awt = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.awu = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.awh);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.awh);
        canvas.drawRect(0.0f, 0.0f, this.atn, this.ato, this.atz);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.awh;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.awk == TrackDirection.none) {
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
                    this.awp.removeMessages(-100);
                    this.awp.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.awp.removeMessages(-101);
                    this.awp.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.awh);
                    return ap(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean ap(int i, int i2) {
        return i >= this.atA - this.ats && i <= this.atA + this.ats && (i2 < this.atB - this.ats || i2 > this.atB + this.ats) && this.awr.dB(i2 - this.atB);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.awo = false;
                    if (this.awr.atW) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.awr.sc();
                        this.awr.sd();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.awr.atW) {
                        if (!this.awo) {
                            if (y > this.atB) {
                                this.awn = this.atB + this.ats;
                                this.awo = true;
                            } else {
                                this.awn = this.atB - this.ats;
                                this.awo = true;
                            }
                        }
                        this.awr.dC(this.awn - y);
                        this.awn = y;
                        this.awr.atV.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.atw != 10000 || !this.awl.contains(x, y)) && (this.atw != 10001 || !this.awm.contains(x, y))) {
                    return false;
                }
                if (!this.awr.atW) {
                    this.awn = y;
                    this.awr.dB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.awr.atW) {
                    this.awr.sc();
                    this.awr.sd();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.awr.atW) {
            this.awr.dC(this.awn - y);
            this.awn = y;
            this.awr.atV.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.awd != -1.0f) {
                this.awl.set(i, i2, i3, (int) (i2 + this.awd));
            }
            if (this.awf != -1.0f) {
                this.awm.set(i, (int) (i4 - this.awf), i3, i4);
            }
        }
        if (!this.awq.atT && !this.awr.atW) {
            rR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.awe != -1.0f) {
            this.awd = i3 - this.awg;
        }
        if (this.awg != -1.0f) {
            this.awf = i3 - this.awe;
        }
        if (!$assertionsDisabled && i3 < this.awd) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.awf) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.atn = getMeasuredWidth();
        this.ato = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        switch (this.atw) {
            case 10000:
                this.awh = (int) (this.awd - this.ato);
                invalidate();
                return;
            case 10001:
                this.awh = (int) (this.ato - this.awf);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.awh = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout aww;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.aww.awq.atT) {
                switch (message.what) {
                    case -105:
                        this.aww.awq.sO();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.aww.awq.sN();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.aww.awq.sM();
                        return;
                    case -100:
                        this.aww.awq.sL();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker atV;
        boolean atW;
        final int atX;
        final int atY;
        final /* synthetic */ VerticalTranslateLayout aww;

        boolean dB(int i) {
            switch (this.aww.awk) {
                case top:
                    if (this.aww.atw != 10004 && this.aww.atw != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.aww.atw != 10004 && this.aww.atw != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.aww.awu != null) {
                        this.aww.awu.dL(i);
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
                int i2 = this.aww.awh - i;
                switch (this.aww.awk) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.aww.awd - this.aww.ato && i2 < 0) {
                            this.aww.awh -= i;
                            this.aww.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.aww.ato - this.aww.awf && i2 > 0) {
                            this.aww.awh -= i;
                            this.aww.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.aww.awd - this.aww.ato && i2 <= this.aww.ato - this.aww.awf) {
                            this.aww.awh -= i;
                            this.aww.invalidate();
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
            float yVelocity = this.atV.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.atY);
            } else {
                max = Math.max(yVelocity, this.atY);
            }
            switch (this.aww.awk) {
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
            this.atV.recycle();
            this.atV = null;
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.aww.awh;
            if (i <= 0 && i >= this.aww.awd - this.aww.ato) {
                if (f < 0.0f) {
                    this.aww.awq.T(f);
                } else {
                    this.aww.awq.R(f);
                }
            } else if (i >= 0 && i <= this.aww.ato - this.aww.awf) {
                if (f < 0.0f) {
                    this.aww.awq.S(f);
                } else {
                    this.aww.awq.U(f);
                }
            }
        }

        private void W(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.aww.awq.T(f);
            } else {
                this.aww.awq.R(f);
            }
        }

        private void X(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.aww.awq.S(f);
            } else {
                this.aww.awq.U(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float atN;
        float atO;
        float atP;
        float atQ;
        long atR;
        long atS;
        boolean atT;
        final /* synthetic */ VerticalTranslateLayout aww;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atN = ((((float) (uptimeMillis - this.atR)) / 1000.0f) * this.atO) + this.atN;
            this.atR = uptimeMillis;
            this.atS += 16;
        }

        void sL() {
            compute();
            if (this.atN <= this.atP) {
                e eVar = this.aww.aws;
                if (eVar != null) {
                    eVar.sQ();
                }
                this.atT = false;
                this.aww.atw = 10000;
                this.aww.rR();
                return;
            }
            this.aww.awh = (int) (com.baidu.adp.widget.a.c(this.atP, this.atN, false) + this.atQ);
            this.aww.invalidate();
            this.aww.awp.sendEmptyMessageAtTime(-100, this.atS);
        }

        void sM() {
            compute();
            if (this.atN >= this.atP) {
                c cVar = this.aww.awt;
                if (cVar != null) {
                    cVar.sP();
                }
                this.atT = false;
                this.aww.atw = 10001;
                this.aww.rR();
                return;
            }
            this.aww.awh = (int) (com.baidu.adp.widget.a.c(this.atP, this.atN, false) + this.atQ);
            this.aww.invalidate();
            this.aww.awp.sendEmptyMessageAtTime(-101, this.atS);
        }

        void sN() {
            compute();
            if (this.atN >= this.atP) {
                for (d dVar : this.aww.atJ) {
                    if (dVar != null) {
                        dVar.rZ();
                    }
                }
                this.atT = false;
                this.aww.atw = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.aww.rR();
                return;
            }
            this.aww.awh = (int) (com.baidu.adp.widget.a.c(this.atP, this.atN, false) + this.atQ);
            this.aww.invalidate();
            this.aww.awp.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atS);
        }

        void sO() {
            compute();
            if (this.atN <= this.atP) {
                for (d dVar : this.aww.atJ) {
                    if (dVar != null) {
                        dVar.rZ();
                    }
                }
                this.atT = false;
                this.aww.atw = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                this.aww.rR();
                return;
            }
            this.aww.awh = (int) (com.baidu.adp.widget.a.c(this.atP, this.atN, false) + this.atQ);
            this.aww.invalidate();
            this.aww.awp.sendEmptyMessageAtTime(-105, this.atS);
        }

        void R(float f) {
            for (d dVar : this.aww.atJ) {
                if (dVar != null) {
                    dVar.rY();
                }
            }
            this.atT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atR = uptimeMillis;
            this.atS = uptimeMillis + 16;
            this.atO = f;
            this.atN = 0.0f;
            this.atP = 0 - this.aww.awh;
            this.atQ = this.aww.awh;
            this.aww.awp.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.atP);
            BdLog.d("Animator@animateTopOpen " + f);
            this.aww.awp.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.atS);
        }

        void S(float f) {
            for (d dVar : this.aww.atJ) {
                if (dVar != null) {
                    dVar.rY();
                }
            }
            this.atT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atR = uptimeMillis;
            this.atS = uptimeMillis + 16;
            this.atO = f;
            this.atN = 0.0f;
            this.atP = 0 - this.aww.awh;
            this.atQ = this.aww.awh;
            BdLog.d("Animator@animateBottomOpen " + this.atP);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.aww.awp.removeMessages(-105);
            this.aww.awp.sendEmptyMessageAtTime(-105, this.atS);
        }

        void T(float f) {
            e eVar = this.aww.aws;
            if (eVar != null) {
                eVar.rW();
            }
            this.atT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atR = uptimeMillis;
            this.atS = uptimeMillis + 16;
            this.atO = f;
            this.atN = 0.0f;
            this.atP = ((-this.aww.ato) + this.aww.awd) - this.aww.awh;
            this.atQ = this.aww.awh;
            BdLog.d("Animator@animateTop " + this.atP);
            BdLog.d("Animator@animateTop " + f);
            this.aww.awp.removeMessages(-100);
            this.aww.awp.sendEmptyMessageAtTime(-100, this.atS);
        }

        void U(float f) {
            c cVar = this.aww.awt;
            if (cVar != null) {
                cVar.sa();
            }
            this.atT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.atR = uptimeMillis;
            this.atS = uptimeMillis + 16;
            this.atO = f;
            this.atN = 0.0f;
            this.atP = (this.aww.ato - this.aww.awf) - this.aww.awh;
            this.atQ = this.aww.awh;
            BdLog.d("Animator@animateBottom " + this.atP);
            BdLog.d("Animator@animateBottom " + f);
            this.aww.awp.removeMessages(-101);
            this.aww.awp.sendEmptyMessageAtTime(-101, this.atS);
        }
    }
}
