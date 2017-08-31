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
    private float FC;
    private float FD;
    private int FE;
    private final int FF;
    private boolean FG;
    private boolean FH;
    private TrackDirection FI;
    private int FJ;
    private final Rect FK;
    private final Rect FL;
    private final Paint FM;
    private int FN;
    private int FO;
    private int FP;
    private boolean FQ;
    private final a FR;
    private final b FS;
    private final g FT;
    private d FU;
    private f FV;
    private final List<e> FW;
    private c FX;
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
        void aE(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kD();

        void kE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kF();

        void kG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void kH();

        void kI();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FM.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.FE = (int) ((this.FC - this.Fz) * (-f2));
            } else if (f2 > 0.0f) {
                this.FE = (int) ((this.Fz - this.FD) * f2);
            } else if (f2 == 0.0f) {
                this.FE = 0;
                this.FJ = 10004;
            } else if (f2 == -1.0f) {
                this.FC -= getMeasuredWidth();
                this.FJ = 10000;
            } else if (f2 == 1.0f) {
                this.FC = getMeasuredWidth() - this.FD;
                this.FJ = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.FC;
    }

    public int getRightOffset() {
        return (int) this.FD;
    }

    public void setLeftTapBack(boolean z) {
        this.FG = z;
    }

    public void setRightTapBack(boolean z) {
        this.FH = z;
    }

    public int getState() {
        return this.FJ;
    }

    public void setLeftAnimationListener(d dVar) {
        this.FU = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.FV = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.FX = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.FE, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.FE);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FM);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.FE;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.FI == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.FJ == 10004) {
            switch (action) {
                case 0:
                    this.FN = x;
                    this.FO = y;
                    this.FR.removeMessages(-100);
                    this.FR.removeMessages(-104);
                    this.FR.removeMessages(-101);
                    this.FR.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.FE, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.FO - this.FF && i2 <= this.FO + this.FF && (i < this.FN - this.FF || i > this.FN + this.FF) && this.FT.aF(i - this.FN);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.FJ == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.FQ = false;
                    if (this.FT.Gj) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.FT.kJ();
                        this.FT.kK();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FT.Gj) {
                        if (!this.FQ) {
                            if (x > this.FN) {
                                this.FP = this.FN + this.FF;
                                this.FQ = true;
                            } else {
                                this.FP = this.FN - this.FF;
                                this.FQ = true;
                            }
                        }
                        this.FT.aG(this.FP - x);
                        this.FP = x;
                        this.FT.Gi.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.FK);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.FL);
        switch (action) {
            case 0:
                if ((this.FJ != 10000 || !this.FK.contains(x, y)) && (this.FJ != 10001 || !this.FL.contains(x, y))) {
                    return false;
                }
                if (!this.FT.Gj) {
                    this.FP = x;
                    this.FT.aF(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FT.Gj) {
                    this.FT.kJ();
                    this.FT.kK();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FT.Gj) {
            this.FT.aG(this.FP - x);
            this.FP = x;
            this.FT.Gi.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.FC != -1.0f) {
                this.FK.set(i, i2, (int) (i + this.FC), i4);
            }
            if (this.FD != -1.0f) {
                this.FL.set((int) (i3 - this.FD), i2, i3, i4);
            }
        }
        if (!this.FS.Gg && !this.FT.Gj) {
            kx();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.FC) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.FD) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fz = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx() {
        switch (this.FJ) {
            case 10000:
                this.FE = (int) (this.FC - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.FE = (int) (getMeasuredWidth() - this.FD);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.FE = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout FZ;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.FZ.FS.Gg) {
                switch (message.what) {
                    case -105:
                        this.FZ.FS.kC();
                        return;
                    case -104:
                        this.FZ.FS.kB();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.FZ.FS.kA();
                        return;
                    case -100:
                        this.FZ.FS.kz();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout FZ;
        VelocityTracker Gi;
        boolean Gj;
        final int Gk;
        final int Gl;

        boolean aF(int i) {
            switch (this.FZ.FI) {
                case left:
                    if (this.FZ.FJ != 10004 && this.FZ.FJ != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.FZ.FJ != 10004 && this.FZ.FJ != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.FZ.FX != null) {
                        this.FZ.FX.aE(i);
                        break;
                    }
                    break;
            }
            this.Gi = VelocityTracker.obtain();
            this.Gj = true;
            return true;
        }

        void kJ() {
            this.Gj = false;
        }

        void aG(int i) {
            if (this.Gj) {
                int i2 = this.FZ.FE - i;
                switch (this.FZ.FI) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.FZ.FC - this.FZ.getMeasuredWidth() && i2 < 0) {
                            this.FZ.FE -= i;
                            this.FZ.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.FZ.getMeasuredWidth() - this.FZ.FD && i2 > 0) {
                            this.FZ.FE -= i;
                            this.FZ.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.FZ.FC - this.FZ.getMeasuredWidth() && i2 <= this.FZ.getMeasuredWidth() - this.FZ.FD) {
                            this.FZ.FE -= i;
                            this.FZ.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kK() {
            float max;
            this.Gi.computeCurrentVelocity(this.Gk);
            float xVelocity = this.Gi.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Gl);
            } else {
                max = Math.max(xVelocity, this.Gl);
            }
            switch (this.FZ.FI) {
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
            this.Gi.recycle();
            this.Gi = null;
        }

        private void r(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.FZ.FE;
            if (i <= 0 && i >= this.FZ.FC - this.FZ.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.FZ.FS.p(f);
                } else {
                    this.FZ.FS.n(f);
                }
            } else if (i >= 0 && i <= this.FZ.getMeasuredWidth() - this.FZ.FD) {
                if (f < 0.0f) {
                    this.FZ.FS.o(f);
                } else {
                    this.FZ.FS.q(f);
                }
            }
        }

        private void s(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.FZ.FS.p(f);
            } else {
                this.FZ.FS.n(f);
            }
        }

        private void t(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.FZ.FS.o(f);
            } else {
                this.FZ.FS.q(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout FZ;
        float Ga;
        float Gb;
        float Gc;
        float Gd;
        long Ge;
        long Gf;
        boolean Gg;

        private void ky() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ga = ((((float) (uptimeMillis - this.Ge)) / 1000.0f) * this.Gb) + this.Ga;
            this.Ge = uptimeMillis;
            this.Gf += 16;
        }

        void kz() {
            ky();
            if (this.Ga <= this.Gc) {
                d dVar = this.FZ.FU;
                if (dVar != null) {
                    dVar.kE();
                }
                this.Gg = false;
                this.FZ.FJ = 10000;
                this.FZ.kx();
                return;
            }
            this.FZ.FE = (int) (com.baidu.adp.widget.e.a(this.Gc, this.Ga, false) + this.Gd);
            this.FZ.invalidate();
            this.FZ.FR.sendEmptyMessageAtTime(-100, this.Gf);
        }

        void kA() {
            ky();
            if (this.Ga >= this.Gc) {
                f fVar = this.FZ.FV;
                if (fVar != null) {
                    fVar.kI();
                }
                this.Gg = false;
                this.FZ.FJ = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.FZ.kx();
                return;
            }
            this.FZ.FE = (int) (com.baidu.adp.widget.e.a(this.Gc, this.Ga, false) + this.Gd);
            this.FZ.invalidate();
            this.FZ.FR.sendEmptyMessageAtTime(-101, this.Gf);
        }

        void kB() {
            ky();
            if (this.Ga >= this.Gc) {
                for (e eVar : this.FZ.FW) {
                    if (eVar != null) {
                        eVar.kG();
                    }
                }
                this.Gg = false;
                this.FZ.FJ = 10004;
                this.FZ.kx();
                return;
            }
            this.FZ.FE = (int) (com.baidu.adp.widget.e.a(this.Gc, this.Ga, false) + this.Gd);
            this.FZ.invalidate();
            this.FZ.FR.sendEmptyMessageAtTime(-104, this.Gf);
        }

        void kC() {
            ky();
            if (this.Ga <= this.Gc) {
                for (e eVar : this.FZ.FW) {
                    if (eVar != null) {
                        eVar.kG();
                    }
                }
                this.Gg = false;
                this.FZ.FJ = 10004;
                this.FZ.kx();
                return;
            }
            this.FZ.FE = (int) (com.baidu.adp.widget.e.a(this.Gc, this.Ga, false) + this.Gd);
            this.FZ.invalidate();
            this.FZ.FR.sendEmptyMessageAtTime(-105, this.Gf);
        }

        void n(float f) {
            for (e eVar : this.FZ.FW) {
                if (eVar != null) {
                    eVar.kF();
                }
            }
            this.Gg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ge = uptimeMillis;
            this.Gf = uptimeMillis + 16;
            this.Gb = f;
            this.Ga = 0.0f;
            this.Gc = 0 - this.FZ.FE;
            this.Gd = this.FZ.FE;
            this.FZ.FR.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Gc);
            BdLog.d("Animator@animateTopOpen " + f);
            this.FZ.FR.sendEmptyMessageAtTime(-104, this.Gf);
        }

        void o(float f) {
            for (e eVar : this.FZ.FW) {
                if (eVar != null) {
                    eVar.kF();
                }
            }
            this.Gg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ge = uptimeMillis;
            this.Gf = uptimeMillis + 16;
            this.Gb = f;
            this.Ga = 0.0f;
            this.Gc = 0 - this.FZ.FE;
            this.Gd = this.FZ.FE;
            BdLog.d("Animator@animateBottomOpen " + this.Gc);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.FZ.FR.removeMessages(-105);
            this.FZ.FR.sendEmptyMessageAtTime(-105, this.Gf);
        }

        void p(float f) {
            d dVar = this.FZ.FU;
            if (dVar != null) {
                dVar.kD();
            }
            this.Gg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ge = uptimeMillis;
            this.Gf = uptimeMillis + 16;
            this.Gb = f;
            this.Ga = 0.0f;
            this.Gc = ((-this.FZ.getMeasuredWidth()) + this.FZ.FC) - this.FZ.FE;
            this.Gd = this.FZ.FE;
            BdLog.d("Animator@animateTop " + this.Gc);
            BdLog.d("Animator@animateTop " + f);
            this.FZ.FR.removeMessages(-100);
            this.FZ.FR.sendEmptyMessageAtTime(-100, this.Gf);
        }

        void q(float f) {
            f fVar = this.FZ.FV;
            if (fVar != null) {
                fVar.kH();
            }
            this.Gg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ge = uptimeMillis;
            this.Gf = uptimeMillis + 16;
            this.Gb = f;
            this.Ga = 0.0f;
            this.Gc = (this.FZ.getMeasuredWidth() - this.FZ.FD) - this.FZ.FE;
            this.Gd = this.FZ.FE;
            BdLog.d("Animator@animateBottom " + this.Gc);
            BdLog.d("Animator@animateBottom " + f);
            this.FZ.FR.removeMessages(-101);
            this.FZ.FR.sendEmptyMessageAtTime(-101, this.Gf);
        }
    }
}
