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
    private int FB;
    private float FD;
    private float FE;
    private int FF;
    private final int FG;
    private boolean FH;
    private boolean FI;
    private TrackDirection FJ;
    private int FK;
    private final Rect FL;
    private final Rect FM;
    private final Paint FN;
    private int FO;
    private int FP;
    private int FQ;
    private boolean FR;
    private final a FS;
    private final b FT;
    private final g FU;
    private d FV;
    private f FW;
    private final List<e> FX;
    private c FY;

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
        this.FN.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.FF = (int) ((this.FD - this.FB) * (-f2));
            } else if (f2 > 0.0f) {
                this.FF = (int) ((this.FB - this.FE) * f2);
            } else if (f2 == 0.0f) {
                this.FF = 0;
                this.FK = 10004;
            } else if (f2 == -1.0f) {
                this.FD -= getMeasuredWidth();
                this.FK = 10000;
            } else if (f2 == 1.0f) {
                this.FD = getMeasuredWidth() - this.FE;
                this.FK = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.FD;
    }

    public int getRightOffset() {
        return (int) this.FE;
    }

    public void setLeftTapBack(boolean z) {
        this.FH = z;
    }

    public void setRightTapBack(boolean z) {
        this.FI = z;
    }

    public int getState() {
        return this.FK;
    }

    public void setLeftAnimationListener(d dVar) {
        this.FV = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.FW = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.FY = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.FF, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.FF);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FN);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.FF;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.FJ == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.FK == 10004) {
            switch (action) {
                case 0:
                    this.FO = x;
                    this.FP = y;
                    this.FS.removeMessages(-100);
                    this.FS.removeMessages(-104);
                    this.FS.removeMessages(-101);
                    this.FS.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.FF, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.FP - this.FG && i2 <= this.FP + this.FG && (i < this.FO - this.FG || i > this.FO + this.FG) && this.FU.aI(i - this.FO);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.FK == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.FR = false;
                    if (this.FU.Gk) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.FU.kI();
                        this.FU.kJ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.FU.Gk) {
                        if (!this.FR) {
                            if (x > this.FO) {
                                this.FQ = this.FO + this.FG;
                                this.FR = true;
                            } else {
                                this.FQ = this.FO - this.FG;
                                this.FR = true;
                            }
                        }
                        this.FU.aJ(this.FQ - x);
                        this.FQ = x;
                        this.FU.Gj.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.FL);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.FM);
        switch (action) {
            case 0:
                if ((this.FK != 10000 || !this.FL.contains(x, y)) && (this.FK != 10001 || !this.FM.contains(x, y))) {
                    return false;
                }
                if (!this.FU.Gk) {
                    this.FQ = x;
                    this.FU.aI(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.FU.Gk) {
                    this.FU.kI();
                    this.FU.kJ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.FU.Gk) {
            this.FU.aJ(this.FQ - x);
            this.FQ = x;
            this.FU.Gj.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.FD != -1.0f) {
                this.FL.set(i, i2, (int) (i + this.FD), i4);
            }
            if (this.FE != -1.0f) {
                this.FM.set((int) (i3 - this.FE), i2, i3, i4);
            }
        }
        if (!this.FT.Gh && !this.FU.Gk) {
            kw();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.FD) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.FE) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.FB = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw() {
        switch (this.FK) {
            case 10000:
                this.FF = (int) (this.FD - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.FF = (int) (getMeasuredWidth() - this.FE);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.FF = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout Ga;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Ga.FT.Gh) {
                switch (message.what) {
                    case -105:
                        this.Ga.FT.kB();
                        return;
                    case -104:
                        this.Ga.FT.kA();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Ga.FT.kz();
                        return;
                    case -100:
                        this.Ga.FT.ky();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout Ga;
        VelocityTracker Gj;
        boolean Gk;
        final int Gl;
        final int Gm;

        boolean aI(int i) {
            switch (this.Ga.FJ) {
                case left:
                    if (this.Ga.FK != 10004 && this.Ga.FK != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.Ga.FK != 10004 && this.Ga.FK != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.Ga.FY != null) {
                        this.Ga.FY.aH(i);
                        break;
                    }
                    break;
            }
            this.Gj = VelocityTracker.obtain();
            this.Gk = true;
            return true;
        }

        void kI() {
            this.Gk = false;
        }

        void aJ(int i) {
            if (this.Gk) {
                int i2 = this.Ga.FF - i;
                switch (this.Ga.FJ) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.Ga.FD - this.Ga.getMeasuredWidth() && i2 < 0) {
                            this.Ga.FF -= i;
                            this.Ga.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.Ga.getMeasuredWidth() - this.Ga.FE && i2 > 0) {
                            this.Ga.FF -= i;
                            this.Ga.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.Ga.FD - this.Ga.getMeasuredWidth() && i2 <= this.Ga.getMeasuredWidth() - this.Ga.FE) {
                            this.Ga.FF -= i;
                            this.Ga.invalidate();
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
            this.Gj.computeCurrentVelocity(this.Gl);
            float xVelocity = this.Gj.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Gm);
            } else {
                max = Math.max(xVelocity, this.Gm);
            }
            switch (this.Ga.FJ) {
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
            this.Gj.recycle();
            this.Gj = null;
        }

        private void r(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.Ga.FF;
            if (i <= 0 && i >= this.Ga.FD - this.Ga.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.Ga.FT.p(f);
                } else {
                    this.Ga.FT.n(f);
                }
            } else if (i >= 0 && i <= this.Ga.getMeasuredWidth() - this.Ga.FE) {
                if (f < 0.0f) {
                    this.Ga.FT.o(f);
                } else {
                    this.Ga.FT.q(f);
                }
            }
        }

        private void s(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.Ga.FT.p(f);
            } else {
                this.Ga.FT.n(f);
            }
        }

        private void t(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.Ga.FT.o(f);
            } else {
                this.Ga.FT.q(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout Ga;
        float Gb;
        float Gc;
        float Gd;
        float Ge;
        long Gf;
        long Gg;
        boolean Gh;

        private void kx() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gb = ((((float) (uptimeMillis - this.Gf)) / 1000.0f) * this.Gc) + this.Gb;
            this.Gf = uptimeMillis;
            this.Gg += 16;
        }

        void ky() {
            kx();
            if (this.Gb <= this.Gd) {
                d dVar = this.Ga.FV;
                if (dVar != null) {
                    dVar.kD();
                }
                this.Gh = false;
                this.Ga.FK = 10000;
                this.Ga.kw();
                return;
            }
            this.Ga.FF = (int) (com.baidu.adp.widget.e.a(this.Gd, this.Gb, false) + this.Ge);
            this.Ga.invalidate();
            this.Ga.FS.sendEmptyMessageAtTime(-100, this.Gg);
        }

        void kz() {
            kx();
            if (this.Gb >= this.Gd) {
                f fVar = this.Ga.FW;
                if (fVar != null) {
                    fVar.kH();
                }
                this.Gh = false;
                this.Ga.FK = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Ga.kw();
                return;
            }
            this.Ga.FF = (int) (com.baidu.adp.widget.e.a(this.Gd, this.Gb, false) + this.Ge);
            this.Ga.invalidate();
            this.Ga.FS.sendEmptyMessageAtTime(-101, this.Gg);
        }

        void kA() {
            kx();
            if (this.Gb >= this.Gd) {
                for (e eVar : this.Ga.FX) {
                    if (eVar != null) {
                        eVar.kF();
                    }
                }
                this.Gh = false;
                this.Ga.FK = 10004;
                this.Ga.kw();
                return;
            }
            this.Ga.FF = (int) (com.baidu.adp.widget.e.a(this.Gd, this.Gb, false) + this.Ge);
            this.Ga.invalidate();
            this.Ga.FS.sendEmptyMessageAtTime(-104, this.Gg);
        }

        void kB() {
            kx();
            if (this.Gb <= this.Gd) {
                for (e eVar : this.Ga.FX) {
                    if (eVar != null) {
                        eVar.kF();
                    }
                }
                this.Gh = false;
                this.Ga.FK = 10004;
                this.Ga.kw();
                return;
            }
            this.Ga.FF = (int) (com.baidu.adp.widget.e.a(this.Gd, this.Gb, false) + this.Ge);
            this.Ga.invalidate();
            this.Ga.FS.sendEmptyMessageAtTime(-105, this.Gg);
        }

        void n(float f) {
            for (e eVar : this.Ga.FX) {
                if (eVar != null) {
                    eVar.kE();
                }
            }
            this.Gh = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gf = uptimeMillis;
            this.Gg = uptimeMillis + 16;
            this.Gc = f;
            this.Gb = 0.0f;
            this.Gd = 0 - this.Ga.FF;
            this.Ge = this.Ga.FF;
            this.Ga.FS.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Gd);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Ga.FS.sendEmptyMessageAtTime(-104, this.Gg);
        }

        void o(float f) {
            for (e eVar : this.Ga.FX) {
                if (eVar != null) {
                    eVar.kE();
                }
            }
            this.Gh = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gf = uptimeMillis;
            this.Gg = uptimeMillis + 16;
            this.Gc = f;
            this.Gb = 0.0f;
            this.Gd = 0 - this.Ga.FF;
            this.Ge = this.Ga.FF;
            BdLog.d("Animator@animateBottomOpen " + this.Gd);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Ga.FS.removeMessages(-105);
            this.Ga.FS.sendEmptyMessageAtTime(-105, this.Gg);
        }

        void p(float f) {
            d dVar = this.Ga.FV;
            if (dVar != null) {
                dVar.kC();
            }
            this.Gh = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gf = uptimeMillis;
            this.Gg = uptimeMillis + 16;
            this.Gc = f;
            this.Gb = 0.0f;
            this.Gd = ((-this.Ga.getMeasuredWidth()) + this.Ga.FD) - this.Ga.FF;
            this.Ge = this.Ga.FF;
            BdLog.d("Animator@animateTop " + this.Gd);
            BdLog.d("Animator@animateTop " + f);
            this.Ga.FS.removeMessages(-100);
            this.Ga.FS.sendEmptyMessageAtTime(-100, this.Gg);
        }

        void q(float f) {
            f fVar = this.Ga.FW;
            if (fVar != null) {
                fVar.kG();
            }
            this.Gh = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gf = uptimeMillis;
            this.Gg = uptimeMillis + 16;
            this.Gc = f;
            this.Gb = 0.0f;
            this.Gd = (this.Ga.getMeasuredWidth() - this.Ga.FE) - this.Ga.FF;
            this.Ge = this.Ga.FF;
            BdLog.d("Animator@animateBottom " + this.Gd);
            BdLog.d("Animator@animateBottom " + f);
            this.Ga.FS.removeMessages(-101);
            this.Ga.FS.sendEmptyMessageAtTime(-101, this.Gg);
        }
    }
}
