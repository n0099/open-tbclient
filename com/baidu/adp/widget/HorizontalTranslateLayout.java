package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
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
    private int FA;
    private int FB;
    private boolean FC;
    private final a FD;
    private final b FE;
    private final g FF;
    private d FG;
    private f FH;
    private final List<e> FI;
    private c FJ;
    private int Fm;
    private float Fo;
    private float Fp;
    private int Fq;
    private final int Fr;
    private boolean Fs;
    private boolean Ft;
    private TrackDirection Fu;
    private int Fv;
    private final Rect Fw;
    private final Rect Fx;
    private final Paint Fy;
    private int Fz;

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
        void aG(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kA();

        void kz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kB();

        void kC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void kD();

        void kE();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Fy.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Fq = (int) ((this.Fo - this.Fm) * (-f2));
            } else if (f2 > 0.0f) {
                this.Fq = (int) ((this.Fm - this.Fp) * f2);
            } else if (f2 == 0.0f) {
                this.Fq = 0;
                this.Fv = 10004;
            } else if (f2 == -1.0f) {
                this.Fo -= getMeasuredWidth();
                this.Fv = 10000;
            } else if (f2 == 1.0f) {
                this.Fo = getMeasuredWidth() - this.Fp;
                this.Fv = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Fo;
    }

    public int getRightOffset() {
        return (int) this.Fp;
    }

    public void setLeftTapBack(boolean z) {
        this.Fs = z;
    }

    public void setRightTapBack(boolean z) {
        this.Ft = z;
    }

    public int getState() {
        return this.Fv;
    }

    public void setLeftAnimationListener(d dVar) {
        this.FG = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.FH = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.FJ = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Fq, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.Fq);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Fy);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Fq;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Fu == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Fv == 10004) {
            switch (action) {
                case 0:
                    this.Fz = x;
                    this.FA = y;
                    this.FD.removeMessages(-100);
                    this.FD.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.FD.removeMessages(-101);
                    this.FD.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Fq, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.FA - this.Fr && i2 <= this.FA + this.Fr && (i < this.Fz - this.Fr || i > this.Fz + this.Fr) && this.FF.aH(i - this.Fz);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Fv == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.FC = false;
                    if (this.FF.FW) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.FF.kF();
                        this.FF.kG();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FF.FW) {
                        if (!this.FC) {
                            if (x > this.Fz) {
                                this.FB = this.Fz + this.Fr;
                                this.FC = true;
                            } else {
                                this.FB = this.Fz - this.Fr;
                                this.FC = true;
                            }
                        }
                        this.FF.aI(this.FB - x);
                        this.FB = x;
                        this.FF.FV.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Fw);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Fx);
        switch (action) {
            case 0:
                if ((this.Fv != 10000 || !this.Fw.contains(x, y)) && (this.Fv != 10001 || !this.Fx.contains(x, y))) {
                    return false;
                }
                if (!this.FF.FW) {
                    this.FB = x;
                    this.FF.aH(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FF.FW) {
                    this.FF.kF();
                    this.FF.kG();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FF.FW) {
            this.FF.aI(this.FB - x);
            this.FB = x;
            this.FF.FV.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Fo != -1.0f) {
                this.Fw.set(i, i2, (int) (i + this.Fo), i4);
            }
            if (this.Fp != -1.0f) {
                this.Fx.set((int) (i3 - this.Fp), i2, i3, i4);
            }
        }
        if (!this.FE.FT && !this.FF.FW) {
            kt();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Fo) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Fp) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fm = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        switch (this.Fv) {
            case 10000:
                this.Fq = (int) (this.Fo - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Fq = (int) (getMeasuredWidth() - this.Fp);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Fq = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout FL;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.FL.FE.FT) {
                switch (message.what) {
                    case -105:
                        this.FL.FE.ky();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.FL.FE.kx();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.FL.FE.kw();
                        return;
                    case -100:
                        this.FL.FE.kv();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout FL;
        VelocityTracker FV;
        boolean FW;
        final int FX;
        final int FY;

        boolean aH(int i) {
            switch (this.FL.Fu) {
                case left:
                    if (this.FL.Fv != 10004 && this.FL.Fv != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.FL.Fv != 10004 && this.FL.Fv != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.FL.FJ != null) {
                        this.FL.FJ.aG(i);
                        break;
                    }
                    break;
            }
            this.FV = VelocityTracker.obtain();
            this.FW = true;
            return true;
        }

        void kF() {
            this.FW = false;
        }

        void aI(int i) {
            if (this.FW) {
                int i2 = this.FL.Fq - i;
                switch (this.FL.Fu) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.FL.Fo - this.FL.getMeasuredWidth() && i2 < 0) {
                            this.FL.Fq -= i;
                            this.FL.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.FL.getMeasuredWidth() - this.FL.Fp && i2 > 0) {
                            this.FL.Fq -= i;
                            this.FL.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.FL.Fo - this.FL.getMeasuredWidth() && i2 <= this.FL.getMeasuredWidth() - this.FL.Fp) {
                            this.FL.Fq -= i;
                            this.FL.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kG() {
            float max;
            this.FV.computeCurrentVelocity(this.FX);
            float xVelocity = this.FV.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.FY);
            } else {
                max = Math.max(xVelocity, this.FY);
            }
            switch (this.FL.Fu) {
                case left:
                    s(max);
                    break;
                case right:
                    t(max);
                    break;
                case horizontal:
                    r(max);
                    break;
            }
            this.FV.recycle();
            this.FV = null;
        }

        private void r(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.FL.Fq;
            if (i <= 0 && i >= this.FL.Fo - this.FL.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.FL.FE.p(f);
                } else {
                    this.FL.FE.n(f);
                }
            } else if (i >= 0 && i <= this.FL.getMeasuredWidth() - this.FL.Fp) {
                if (f < 0.0f) {
                    this.FL.FE.o(f);
                } else {
                    this.FL.FE.q(f);
                }
            }
        }

        private void s(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.FL.FE.p(f);
            } else {
                this.FL.FE.n(f);
            }
        }

        private void t(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.FL.FE.o(f);
            } else {
                this.FL.FE.q(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout FL;
        float FM;
        float FN;
        float FO;
        float FP;
        long FQ;
        long FR;
        boolean FT;

        private void ku() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FM = ((((float) (uptimeMillis - this.FQ)) / 1000.0f) * this.FN) + this.FM;
            this.FQ = uptimeMillis;
            this.FR += 16;
        }

        void kv() {
            ku();
            if (this.FM <= this.FO) {
                d dVar = this.FL.FG;
                if (dVar != null) {
                    dVar.kA();
                }
                this.FT = false;
                this.FL.Fv = 10000;
                this.FL.kt();
                return;
            }
            this.FL.Fq = (int) (com.baidu.adp.widget.e.a(this.FO, this.FM, false) + this.FP);
            this.FL.invalidate();
            this.FL.FD.sendEmptyMessageAtTime(-100, this.FR);
        }

        void kw() {
            ku();
            if (this.FM >= this.FO) {
                f fVar = this.FL.FH;
                if (fVar != null) {
                    fVar.kE();
                }
                this.FT = false;
                this.FL.Fv = 10001;
                this.FL.kt();
                return;
            }
            this.FL.Fq = (int) (com.baidu.adp.widget.e.a(this.FO, this.FM, false) + this.FP);
            this.FL.invalidate();
            this.FL.FD.sendEmptyMessageAtTime(-101, this.FR);
        }

        void kx() {
            ku();
            if (this.FM >= this.FO) {
                for (e eVar : this.FL.FI) {
                    if (eVar != null) {
                        eVar.kC();
                    }
                }
                this.FT = false;
                this.FL.Fv = 10004;
                this.FL.kt();
                return;
            }
            this.FL.Fq = (int) (com.baidu.adp.widget.e.a(this.FO, this.FM, false) + this.FP);
            this.FL.invalidate();
            this.FL.FD.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.FR);
        }

        void ky() {
            ku();
            if (this.FM <= this.FO) {
                for (e eVar : this.FL.FI) {
                    if (eVar != null) {
                        eVar.kC();
                    }
                }
                this.FT = false;
                this.FL.Fv = 10004;
                this.FL.kt();
                return;
            }
            this.FL.Fq = (int) (com.baidu.adp.widget.e.a(this.FO, this.FM, false) + this.FP);
            this.FL.invalidate();
            this.FL.FD.sendEmptyMessageAtTime(-105, this.FR);
        }

        void n(float f) {
            for (e eVar : this.FL.FI) {
                if (eVar != null) {
                    eVar.kB();
                }
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = uptimeMillis;
            this.FR = uptimeMillis + 16;
            this.FN = f;
            this.FM = 0.0f;
            this.FO = 0 - this.FL.Fq;
            this.FP = this.FL.Fq;
            this.FL.FD.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.FO);
            BdLog.d("Animator@animateTopOpen " + f);
            this.FL.FD.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.FR);
        }

        void o(float f) {
            for (e eVar : this.FL.FI) {
                if (eVar != null) {
                    eVar.kB();
                }
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = uptimeMillis;
            this.FR = uptimeMillis + 16;
            this.FN = f;
            this.FM = 0.0f;
            this.FO = 0 - this.FL.Fq;
            this.FP = this.FL.Fq;
            BdLog.d("Animator@animateBottomOpen " + this.FO);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.FL.FD.removeMessages(-105);
            this.FL.FD.sendEmptyMessageAtTime(-105, this.FR);
        }

        void p(float f) {
            d dVar = this.FL.FG;
            if (dVar != null) {
                dVar.kz();
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = uptimeMillis;
            this.FR = uptimeMillis + 16;
            this.FN = f;
            this.FM = 0.0f;
            this.FO = ((-this.FL.getMeasuredWidth()) + this.FL.Fo) - this.FL.Fq;
            this.FP = this.FL.Fq;
            BdLog.d("Animator@animateTop " + this.FO);
            BdLog.d("Animator@animateTop " + f);
            this.FL.FD.removeMessages(-100);
            this.FL.FD.sendEmptyMessageAtTime(-100, this.FR);
        }

        void q(float f) {
            f fVar = this.FL.FH;
            if (fVar != null) {
                fVar.kD();
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = uptimeMillis;
            this.FR = uptimeMillis + 16;
            this.FN = f;
            this.FM = 0.0f;
            this.FO = (this.FL.getMeasuredWidth() - this.FL.Fp) - this.FL.Fq;
            this.FP = this.FL.Fq;
            BdLog.d("Animator@animateBottom " + this.FO);
            BdLog.d("Animator@animateBottom " + f);
            this.FL.FD.removeMessages(-101);
            this.FL.FD.sendEmptyMessageAtTime(-101, this.FR);
        }
    }
}
