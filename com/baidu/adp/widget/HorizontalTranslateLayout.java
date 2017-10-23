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
    private int FC;
    private float FE;
    private float FF;
    private int FG;
    private final int FH;
    private boolean FI;
    private boolean FJ;
    private TrackDirection FK;
    private int FL;
    private final Rect FM;
    private final Rect FN;
    private final Paint FO;
    private int FP;
    private int FQ;
    private int FR;
    private boolean FS;
    private final a FT;
    private final b FU;
    private final g FV;
    private d FW;
    private f FX;
    private final List<e> FY;
    private c FZ;

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
        void kC();

        void kD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kE();

        void kF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void kG();

        void kH();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FO.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.FG = (int) ((this.FE - this.FC) * (-f2));
            } else if (f2 > 0.0f) {
                this.FG = (int) ((this.FC - this.FF) * f2);
            } else if (f2 == 0.0f) {
                this.FG = 0;
                this.FL = 10004;
            } else if (f2 == -1.0f) {
                this.FE -= getMeasuredWidth();
                this.FL = 10000;
            } else if (f2 == 1.0f) {
                this.FE = getMeasuredWidth() - this.FF;
                this.FL = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.FE;
    }

    public int getRightOffset() {
        return (int) this.FF;
    }

    public void setLeftTapBack(boolean z) {
        this.FI = z;
    }

    public void setRightTapBack(boolean z) {
        this.FJ = z;
    }

    public int getState() {
        return this.FL;
    }

    public void setLeftAnimationListener(d dVar) {
        this.FW = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.FX = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.FZ = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.FG, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.FG);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FO);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.FG;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.FK == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.FL == 10004) {
            switch (action) {
                case 0:
                    this.FP = x;
                    this.FQ = y;
                    this.FT.removeMessages(-100);
                    this.FT.removeMessages(-104);
                    this.FT.removeMessages(-101);
                    this.FT.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.FG, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.FQ - this.FH && i2 <= this.FQ + this.FH && (i < this.FP - this.FH || i > this.FP + this.FH) && this.FV.aI(i - this.FP);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.FL == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.FS = false;
                    if (this.FV.Gl) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.FV.kI();
                        this.FV.kJ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FV.Gl) {
                        if (!this.FS) {
                            if (x > this.FP) {
                                this.FR = this.FP + this.FH;
                                this.FS = true;
                            } else {
                                this.FR = this.FP - this.FH;
                                this.FS = true;
                            }
                        }
                        this.FV.aJ(this.FR - x);
                        this.FR = x;
                        this.FV.Gk.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.FM);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.FN);
        switch (action) {
            case 0:
                if ((this.FL != 10000 || !this.FM.contains(x, y)) && (this.FL != 10001 || !this.FN.contains(x, y))) {
                    return false;
                }
                if (!this.FV.Gl) {
                    this.FR = x;
                    this.FV.aI(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FV.Gl) {
                    this.FV.kI();
                    this.FV.kJ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FV.Gl) {
            this.FV.aJ(this.FR - x);
            this.FR = x;
            this.FV.Gk.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.FE != -1.0f) {
                this.FM.set(i, i2, (int) (i + this.FE), i4);
            }
            if (this.FF != -1.0f) {
                this.FN.set((int) (i3 - this.FF), i2, i3, i4);
            }
        }
        if (!this.FU.Gi && !this.FV.Gl) {
            kw();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.FE) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.FF) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.FC = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw() {
        switch (this.FL) {
            case 10000:
                this.FG = (int) (this.FE - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.FG = (int) (getMeasuredWidth() - this.FF);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.FG = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout Gb;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Gb.FU.Gi) {
                switch (message.what) {
                    case -105:
                        this.Gb.FU.kB();
                        return;
                    case -104:
                        this.Gb.FU.kA();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Gb.FU.kz();
                        return;
                    case -100:
                        this.Gb.FU.ky();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout Gb;
        VelocityTracker Gk;
        boolean Gl;
        final int Gm;
        final int Gn;

        boolean aI(int i) {
            switch (this.Gb.FK) {
                case left:
                    if (this.Gb.FL != 10004 && this.Gb.FL != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.Gb.FL != 10004 && this.Gb.FL != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.Gb.FZ != null) {
                        this.Gb.FZ.aH(i);
                        break;
                    }
                    break;
            }
            this.Gk = VelocityTracker.obtain();
            this.Gl = true;
            return true;
        }

        void kI() {
            this.Gl = false;
        }

        void aJ(int i) {
            if (this.Gl) {
                int i2 = this.Gb.FG - i;
                switch (this.Gb.FK) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.Gb.FE - this.Gb.getMeasuredWidth() && i2 < 0) {
                            this.Gb.FG -= i;
                            this.Gb.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.Gb.getMeasuredWidth() - this.Gb.FF && i2 > 0) {
                            this.Gb.FG -= i;
                            this.Gb.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.Gb.FE - this.Gb.getMeasuredWidth() && i2 <= this.Gb.getMeasuredWidth() - this.Gb.FF) {
                            this.Gb.FG -= i;
                            this.Gb.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kJ() {
            float max;
            this.Gk.computeCurrentVelocity(this.Gm);
            float xVelocity = this.Gk.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Gn);
            } else {
                max = Math.max(xVelocity, this.Gn);
            }
            switch (this.Gb.FK) {
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
            this.Gk.recycle();
            this.Gk = null;
        }

        private void r(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.Gb.FG;
            if (i <= 0 && i >= this.Gb.FE - this.Gb.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.Gb.FU.p(f);
                } else {
                    this.Gb.FU.n(f);
                }
            } else if (i >= 0 && i <= this.Gb.getMeasuredWidth() - this.Gb.FF) {
                if (f < 0.0f) {
                    this.Gb.FU.o(f);
                } else {
                    this.Gb.FU.q(f);
                }
            }
        }

        private void s(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.Gb.FU.p(f);
            } else {
                this.Gb.FU.n(f);
            }
        }

        private void t(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.Gb.FU.o(f);
            } else {
                this.Gb.FU.q(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout Gb;
        float Gc;
        float Gd;
        float Ge;
        float Gf;
        long Gg;
        long Gh;
        boolean Gi;

        private void kx() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gc = ((((float) (uptimeMillis - this.Gg)) / 1000.0f) * this.Gd) + this.Gc;
            this.Gg = uptimeMillis;
            this.Gh += 16;
        }

        void ky() {
            kx();
            if (this.Gc <= this.Ge) {
                d dVar = this.Gb.FW;
                if (dVar != null) {
                    dVar.kD();
                }
                this.Gi = false;
                this.Gb.FL = 10000;
                this.Gb.kw();
                return;
            }
            this.Gb.FG = (int) (com.baidu.adp.widget.e.a(this.Ge, this.Gc, false) + this.Gf);
            this.Gb.invalidate();
            this.Gb.FT.sendEmptyMessageAtTime(-100, this.Gh);
        }

        void kz() {
            kx();
            if (this.Gc >= this.Ge) {
                f fVar = this.Gb.FX;
                if (fVar != null) {
                    fVar.kH();
                }
                this.Gi = false;
                this.Gb.FL = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Gb.kw();
                return;
            }
            this.Gb.FG = (int) (com.baidu.adp.widget.e.a(this.Ge, this.Gc, false) + this.Gf);
            this.Gb.invalidate();
            this.Gb.FT.sendEmptyMessageAtTime(-101, this.Gh);
        }

        void kA() {
            kx();
            if (this.Gc >= this.Ge) {
                for (e eVar : this.Gb.FY) {
                    if (eVar != null) {
                        eVar.kF();
                    }
                }
                this.Gi = false;
                this.Gb.FL = 10004;
                this.Gb.kw();
                return;
            }
            this.Gb.FG = (int) (com.baidu.adp.widget.e.a(this.Ge, this.Gc, false) + this.Gf);
            this.Gb.invalidate();
            this.Gb.FT.sendEmptyMessageAtTime(-104, this.Gh);
        }

        void kB() {
            kx();
            if (this.Gc <= this.Ge) {
                for (e eVar : this.Gb.FY) {
                    if (eVar != null) {
                        eVar.kF();
                    }
                }
                this.Gi = false;
                this.Gb.FL = 10004;
                this.Gb.kw();
                return;
            }
            this.Gb.FG = (int) (com.baidu.adp.widget.e.a(this.Ge, this.Gc, false) + this.Gf);
            this.Gb.invalidate();
            this.Gb.FT.sendEmptyMessageAtTime(-105, this.Gh);
        }

        void n(float f) {
            for (e eVar : this.Gb.FY) {
                if (eVar != null) {
                    eVar.kE();
                }
            }
            this.Gi = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = uptimeMillis;
            this.Gh = uptimeMillis + 16;
            this.Gd = f;
            this.Gc = 0.0f;
            this.Ge = 0 - this.Gb.FG;
            this.Gf = this.Gb.FG;
            this.Gb.FT.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Ge);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Gb.FT.sendEmptyMessageAtTime(-104, this.Gh);
        }

        void o(float f) {
            for (e eVar : this.Gb.FY) {
                if (eVar != null) {
                    eVar.kE();
                }
            }
            this.Gi = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = uptimeMillis;
            this.Gh = uptimeMillis + 16;
            this.Gd = f;
            this.Gc = 0.0f;
            this.Ge = 0 - this.Gb.FG;
            this.Gf = this.Gb.FG;
            BdLog.d("Animator@animateBottomOpen " + this.Ge);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Gb.FT.removeMessages(-105);
            this.Gb.FT.sendEmptyMessageAtTime(-105, this.Gh);
        }

        void p(float f) {
            d dVar = this.Gb.FW;
            if (dVar != null) {
                dVar.kC();
            }
            this.Gi = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = uptimeMillis;
            this.Gh = uptimeMillis + 16;
            this.Gd = f;
            this.Gc = 0.0f;
            this.Ge = ((-this.Gb.getMeasuredWidth()) + this.Gb.FE) - this.Gb.FG;
            this.Gf = this.Gb.FG;
            BdLog.d("Animator@animateTop " + this.Ge);
            BdLog.d("Animator@animateTop " + f);
            this.Gb.FT.removeMessages(-100);
            this.Gb.FT.sendEmptyMessageAtTime(-100, this.Gh);
        }

        void q(float f) {
            f fVar = this.Gb.FX;
            if (fVar != null) {
                fVar.kG();
            }
            this.Gi = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = uptimeMillis;
            this.Gh = uptimeMillis + 16;
            this.Gd = f;
            this.Gc = 0.0f;
            this.Ge = (this.Gb.getMeasuredWidth() - this.Gb.FF) - this.Gb.FG;
            this.Gf = this.Gb.FG;
            BdLog.d("Animator@animateBottom " + this.Ge);
            BdLog.d("Animator@animateBottom " + f);
            this.Gb.FT.removeMessages(-101);
            this.Gb.FT.sendEmptyMessageAtTime(-101, this.Gh);
        }
    }
}
