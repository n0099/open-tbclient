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
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int FA;
    private int FB;
    private int FC;
    private boolean FD;
    private final a FE;
    private final b FF;
    private final g FG;
    private d FH;
    private f FI;
    private final List<e> FJ;
    private c FK;
    private int Fn;
    private float Fp;
    private float Fq;
    private int Fr;
    private final int Fs;
    private boolean Ft;
    private boolean Fu;
    private TrackDirection Fv;
    private int Fw;
    private final Rect Fx;
    private final Rect Fy;
    private final Paint Fz;

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
        void aH(int i);
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
        this.Fz.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Fr = (int) ((this.Fp - this.Fn) * (-f2));
            } else if (f2 > 0.0f) {
                this.Fr = (int) ((this.Fn - this.Fq) * f2);
            } else if (f2 == 0.0f) {
                this.Fr = 0;
                this.Fw = 10004;
            } else if (f2 == -1.0f) {
                this.Fp -= getMeasuredWidth();
                this.Fw = 10000;
            } else if (f2 == 1.0f) {
                this.Fp = getMeasuredWidth() - this.Fq;
                this.Fw = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Fp;
    }

    public int getRightOffset() {
        return (int) this.Fq;
    }

    public void setLeftTapBack(boolean z) {
        this.Ft = z;
    }

    public void setRightTapBack(boolean z) {
        this.Fu = z;
    }

    public int getState() {
        return this.Fw;
    }

    public void setLeftAnimationListener(d dVar) {
        this.FH = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.FI = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.FK = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Fr, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.Fr);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Fz);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Fr;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Fv == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Fw == 10004) {
            switch (action) {
                case 0:
                    this.FA = x;
                    this.FB = y;
                    this.FE.removeMessages(-100);
                    this.FE.removeMessages(-104);
                    this.FE.removeMessages(-101);
                    this.FE.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Fr, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.FB - this.Fs && i2 <= this.FB + this.Fs && (i < this.FA - this.Fs || i > this.FA + this.Fs) && this.FG.aI(i - this.FA);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Fw == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.FD = false;
                    if (this.FG.FW) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.FG.kF();
                        this.FG.kG();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FG.FW) {
                        if (!this.FD) {
                            if (x > this.FA) {
                                this.FC = this.FA + this.Fs;
                                this.FD = true;
                            } else {
                                this.FC = this.FA - this.Fs;
                                this.FD = true;
                            }
                        }
                        this.FG.aJ(this.FC - x);
                        this.FC = x;
                        this.FG.FV.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Fx);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Fy);
        switch (action) {
            case 0:
                if ((this.Fw != 10000 || !this.Fx.contains(x, y)) && (this.Fw != 10001 || !this.Fy.contains(x, y))) {
                    return false;
                }
                if (!this.FG.FW) {
                    this.FC = x;
                    this.FG.aI(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FG.FW) {
                    this.FG.kF();
                    this.FG.kG();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FG.FW) {
            this.FG.aJ(this.FC - x);
            this.FC = x;
            this.FG.FV.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Fp != -1.0f) {
                this.Fx.set(i, i2, (int) (i + this.Fp), i4);
            }
            if (this.Fq != -1.0f) {
                this.Fy.set((int) (i3 - this.Fq), i2, i3, i4);
            }
        }
        if (!this.FF.FT && !this.FG.FW) {
            kt();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Fp) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Fq) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fn = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        switch (this.Fw) {
            case 10000:
                this.Fr = (int) (this.Fp - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Fr = (int) (getMeasuredWidth() - this.Fq);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Fr = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout FM;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.FM.FF.FT) {
                switch (message.what) {
                    case -105:
                        this.FM.FF.ky();
                        return;
                    case -104:
                        this.FM.FF.kx();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.FM.FF.kw();
                        return;
                    case -100:
                        this.FM.FF.kv();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout FM;
        VelocityTracker FV;
        boolean FW;
        final int FX;
        final int FY;

        boolean aI(int i) {
            switch (this.FM.Fv) {
                case left:
                    if (this.FM.Fw != 10004 && this.FM.Fw != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.FM.Fw != 10004 && this.FM.Fw != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.FM.FK != null) {
                        this.FM.FK.aH(i);
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

        void aJ(int i) {
            if (this.FW) {
                int i2 = this.FM.Fr - i;
                switch (this.FM.Fv) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.FM.Fp - this.FM.getMeasuredWidth() && i2 < 0) {
                            this.FM.Fr -= i;
                            this.FM.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.FM.getMeasuredWidth() - this.FM.Fq && i2 > 0) {
                            this.FM.Fr -= i;
                            this.FM.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.FM.Fp - this.FM.getMeasuredWidth() && i2 <= this.FM.getMeasuredWidth() - this.FM.Fq) {
                            this.FM.Fr -= i;
                            this.FM.invalidate();
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
            switch (this.FM.Fv) {
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
            int i = this.FM.Fr;
            if (i <= 0 && i >= this.FM.Fp - this.FM.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.FM.FF.p(f);
                } else {
                    this.FM.FF.n(f);
                }
            } else if (i >= 0 && i <= this.FM.getMeasuredWidth() - this.FM.Fq) {
                if (f < 0.0f) {
                    this.FM.FF.o(f);
                } else {
                    this.FM.FF.q(f);
                }
            }
        }

        private void s(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.FM.FF.p(f);
            } else {
                this.FM.FF.n(f);
            }
        }

        private void t(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.FM.FF.o(f);
            } else {
                this.FM.FF.q(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout FM;
        float FN;
        float FO;
        float FP;
        float FQ;
        long FR;
        long FS;
        boolean FT;

        private void ku() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FN = ((((float) (uptimeMillis - this.FR)) / 1000.0f) * this.FO) + this.FN;
            this.FR = uptimeMillis;
            this.FS += 16;
        }

        void kv() {
            ku();
            if (this.FN <= this.FP) {
                d dVar = this.FM.FH;
                if (dVar != null) {
                    dVar.kA();
                }
                this.FT = false;
                this.FM.Fw = 10000;
                this.FM.kt();
                return;
            }
            this.FM.Fr = (int) (com.baidu.adp.widget.e.a(this.FP, this.FN, false) + this.FQ);
            this.FM.invalidate();
            this.FM.FE.sendEmptyMessageAtTime(-100, this.FS);
        }

        void kw() {
            ku();
            if (this.FN >= this.FP) {
                f fVar = this.FM.FI;
                if (fVar != null) {
                    fVar.kE();
                }
                this.FT = false;
                this.FM.Fw = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.FM.kt();
                return;
            }
            this.FM.Fr = (int) (com.baidu.adp.widget.e.a(this.FP, this.FN, false) + this.FQ);
            this.FM.invalidate();
            this.FM.FE.sendEmptyMessageAtTime(-101, this.FS);
        }

        void kx() {
            ku();
            if (this.FN >= this.FP) {
                for (e eVar : this.FM.FJ) {
                    if (eVar != null) {
                        eVar.kC();
                    }
                }
                this.FT = false;
                this.FM.Fw = 10004;
                this.FM.kt();
                return;
            }
            this.FM.Fr = (int) (com.baidu.adp.widget.e.a(this.FP, this.FN, false) + this.FQ);
            this.FM.invalidate();
            this.FM.FE.sendEmptyMessageAtTime(-104, this.FS);
        }

        void ky() {
            ku();
            if (this.FN <= this.FP) {
                for (e eVar : this.FM.FJ) {
                    if (eVar != null) {
                        eVar.kC();
                    }
                }
                this.FT = false;
                this.FM.Fw = 10004;
                this.FM.kt();
                return;
            }
            this.FM.Fr = (int) (com.baidu.adp.widget.e.a(this.FP, this.FN, false) + this.FQ);
            this.FM.invalidate();
            this.FM.FE.sendEmptyMessageAtTime(-105, this.FS);
        }

        void n(float f) {
            for (e eVar : this.FM.FJ) {
                if (eVar != null) {
                    eVar.kB();
                }
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FS = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = 0 - this.FM.Fr;
            this.FQ = this.FM.Fr;
            this.FM.FE.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.FP);
            BdLog.d("Animator@animateTopOpen " + f);
            this.FM.FE.sendEmptyMessageAtTime(-104, this.FS);
        }

        void o(float f) {
            for (e eVar : this.FM.FJ) {
                if (eVar != null) {
                    eVar.kB();
                }
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FS = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = 0 - this.FM.Fr;
            this.FQ = this.FM.Fr;
            BdLog.d("Animator@animateBottomOpen " + this.FP);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.FM.FE.removeMessages(-105);
            this.FM.FE.sendEmptyMessageAtTime(-105, this.FS);
        }

        void p(float f) {
            d dVar = this.FM.FH;
            if (dVar != null) {
                dVar.kz();
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FS = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = ((-this.FM.getMeasuredWidth()) + this.FM.Fp) - this.FM.Fr;
            this.FQ = this.FM.Fr;
            BdLog.d("Animator@animateTop " + this.FP);
            BdLog.d("Animator@animateTop " + f);
            this.FM.FE.removeMessages(-100);
            this.FM.FE.sendEmptyMessageAtTime(-100, this.FS);
        }

        void q(float f) {
            f fVar = this.FM.FI;
            if (fVar != null) {
                fVar.kD();
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FS = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = (this.FM.getMeasuredWidth() - this.FM.Fq) - this.FM.Fr;
            this.FQ = this.FM.Fr;
            BdLog.d("Animator@animateBottom " + this.FP);
            BdLog.d("Animator@animateBottom " + f);
            this.FM.FE.removeMessages(-101);
            this.FM.FE.sendEmptyMessageAtTime(-101, this.FS);
        }
    }
}
