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
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int FB;
    private int FC;
    private final int FG;
    private int FK;
    private final Paint FN;
    private int FO;
    private int FP;
    private final List<d> FX;
    private boolean IA;
    private TrackDirection IB;
    private final Rect IC;
    private final Rect IE;
    private int IF;
    private boolean IG;
    private final a IH;
    private final b II;
    private final g IJ;
    private e IK;
    private c IL;
    private f IM;
    private float Iu;
    private float Iv;
    private float Iw;
    private float Ix;
    private int Iy;
    private boolean Iz;

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
        void kG();

        void ly();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kE();

        void kF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kC();

        void lz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aP(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FN.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Iy = (int) ((this.Iu - this.FC) * (-f2));
            } else if (f2 > 0.0f) {
                this.Iy = (int) ((this.FC - this.Iw) * f2);
            } else if (f2 == 0.0f) {
                this.Iy = 0;
                this.FK = 10004;
            } else if (f2 == -1.0f) {
                this.Iu -= this.FC;
                this.FK = 10000;
            } else if (f2 == 1.0f) {
                this.Iu = this.FC - this.Iw;
                this.FK = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Iu;
    }

    public int getBottomOffset() {
        return (int) this.Iw;
    }

    public void setTopTapBack(boolean z) {
        this.Iz = z;
    }

    public void setBottomTapBack(boolean z) {
        this.IA = z;
    }

    public int getState() {
        return this.FK;
    }

    public void setTopAnimationListener(e eVar) {
        this.IK = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.IL = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.IM = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Iy);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Iy);
        canvas.drawRect(0.0f, 0.0f, this.FB, this.FC, this.FN);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Iy;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.IB == TrackDirection.none) {
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
                    this.IH.removeMessages(-100);
                    this.IH.removeMessages(-104);
                    this.IH.removeMessages(-101);
                    this.IH.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Iy);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.FO - this.FG && i <= this.FO + this.FG && (i2 < this.FP - this.FG || i2 > this.FP + this.FG) && this.IJ.aI(i2 - this.FP);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.IG = false;
                    if (this.IJ.Gk) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.IJ.kI();
                        this.IJ.kJ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.IJ.Gk) {
                        if (!this.IG) {
                            if (y > this.FP) {
                                this.IF = this.FP + this.FG;
                                this.IG = true;
                            } else {
                                this.IF = this.FP - this.FG;
                                this.IG = true;
                            }
                        }
                        this.IJ.aJ(this.IF - y);
                        this.IF = y;
                        this.IJ.Gj.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.FK != 10000 || !this.IC.contains(x, y)) && (this.FK != 10001 || !this.IE.contains(x, y))) {
                    return false;
                }
                if (!this.IJ.Gk) {
                    this.IF = y;
                    this.IJ.aI(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.IJ.Gk) {
                    this.IJ.kI();
                    this.IJ.kJ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.IJ.Gk) {
            this.IJ.aJ(this.IF - y);
            this.IF = y;
            this.IJ.Gj.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Iu != -1.0f) {
                this.IC.set(i, i2, i3, (int) (i2 + this.Iu));
            }
            if (this.Iw != -1.0f) {
                this.IE.set(i, (int) (i4 - this.Iw), i3, i4);
            }
        }
        if (!this.II.Gh && !this.IJ.Gk) {
            kw();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Iv != -1.0f) {
            this.Iu = i3 - this.Ix;
        }
        if (this.Ix != -1.0f) {
            this.Iw = i3 - this.Iv;
        }
        if (!$assertionsDisabled && i3 < this.Iu) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Iw) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.FB = getMeasuredWidth();
        this.FC = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw() {
        switch (this.FK) {
            case 10000:
                this.Iy = (int) (this.Iu - this.FC);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Iy = (int) (this.FC - this.Iw);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Iy = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout IO;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.IO.II.Gh) {
                switch (message.what) {
                    case -105:
                        this.IO.II.lx();
                        return;
                    case -104:
                        this.IO.II.lw();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.IO.II.lv();
                        return;
                    case -100:
                        this.IO.II.lu();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Gj;
        boolean Gk;
        final int Gl;
        final int Gm;
        final /* synthetic */ VerticalTranslateLayout IO;

        boolean aI(int i) {
            switch (this.IO.IB) {
                case top:
                    if (this.IO.FK != 10004 && this.IO.FK != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.IO.FK != 10004 && this.IO.FK != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.IO.IM != null) {
                        this.IO.IM.aP(i);
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
                int i2 = this.IO.Iy - i;
                switch (this.IO.IB) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.IO.Iu - this.IO.FC && i2 < 0) {
                            this.IO.Iy -= i;
                            this.IO.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.IO.FC - this.IO.Iw && i2 > 0) {
                            this.IO.Iy -= i;
                            this.IO.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.IO.Iu - this.IO.FC && i2 <= this.IO.FC - this.IO.Iw) {
                            this.IO.Iy -= i;
                            this.IO.invalidate();
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
            float yVelocity = this.Gj.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Gm);
            } else {
                max = Math.max(yVelocity, this.Gm);
            }
            switch (this.IO.IB) {
                case top:
                    D(max);
                    break;
                case bottom:
                    E(max);
                    break;
                case vertical:
                    C(max);
                    break;
            }
            this.Gj.recycle();
            this.Gj = null;
        }

        private void C(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.IO.Iy;
            if (i <= 0 && i >= this.IO.Iu - this.IO.FC) {
                if (f < 0.0f) {
                    this.IO.II.A(f);
                } else {
                    this.IO.II.y(f);
                }
            } else if (i >= 0 && i <= this.IO.FC - this.IO.Iw) {
                if (f < 0.0f) {
                    this.IO.II.z(f);
                } else {
                    this.IO.II.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.IO.II.A(f);
            } else {
                this.IO.II.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.IO.II.z(f);
            } else {
                this.IO.II.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float Gb;
        float Gc;
        float Gd;
        float Ge;
        long Gf;
        long Gg;
        boolean Gh;
        final /* synthetic */ VerticalTranslateLayout IO;

        private void kx() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gb = ((((float) (uptimeMillis - this.Gf)) / 1000.0f) * this.Gc) + this.Gb;
            this.Gf = uptimeMillis;
            this.Gg += 16;
        }

        void lu() {
            kx();
            if (this.Gb <= this.Gd) {
                e eVar = this.IO.IK;
                if (eVar != null) {
                    eVar.lz();
                }
                this.Gh = false;
                this.IO.FK = 10000;
                this.IO.kw();
                return;
            }
            this.IO.Iy = (int) (com.baidu.adp.widget.a.a(this.Gd, this.Gb, false) + this.Ge);
            this.IO.invalidate();
            this.IO.IH.sendEmptyMessageAtTime(-100, this.Gg);
        }

        void lv() {
            kx();
            if (this.Gb >= this.Gd) {
                c cVar = this.IO.IL;
                if (cVar != null) {
                    cVar.ly();
                }
                this.Gh = false;
                this.IO.FK = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.IO.kw();
                return;
            }
            this.IO.Iy = (int) (com.baidu.adp.widget.a.a(this.Gd, this.Gb, false) + this.Ge);
            this.IO.invalidate();
            this.IO.IH.sendEmptyMessageAtTime(-101, this.Gg);
        }

        void lw() {
            kx();
            if (this.Gb >= this.Gd) {
                for (d dVar : this.IO.FX) {
                    if (dVar != null) {
                        dVar.kF();
                    }
                }
                this.Gh = false;
                this.IO.FK = 10004;
                this.IO.kw();
                return;
            }
            this.IO.Iy = (int) (com.baidu.adp.widget.a.a(this.Gd, this.Gb, false) + this.Ge);
            this.IO.invalidate();
            this.IO.IH.sendEmptyMessageAtTime(-104, this.Gg);
        }

        void lx() {
            kx();
            if (this.Gb <= this.Gd) {
                for (d dVar : this.IO.FX) {
                    if (dVar != null) {
                        dVar.kF();
                    }
                }
                this.Gh = false;
                this.IO.FK = 10004;
                this.IO.kw();
                return;
            }
            this.IO.Iy = (int) (com.baidu.adp.widget.a.a(this.Gd, this.Gb, false) + this.Ge);
            this.IO.invalidate();
            this.IO.IH.sendEmptyMessageAtTime(-105, this.Gg);
        }

        void y(float f) {
            for (d dVar : this.IO.FX) {
                if (dVar != null) {
                    dVar.kE();
                }
            }
            this.Gh = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gf = uptimeMillis;
            this.Gg = uptimeMillis + 16;
            this.Gc = f;
            this.Gb = 0.0f;
            this.Gd = 0 - this.IO.Iy;
            this.Ge = this.IO.Iy;
            this.IO.IH.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Gd);
            BdLog.d("Animator@animateTopOpen " + f);
            this.IO.IH.sendEmptyMessageAtTime(-104, this.Gg);
        }

        void z(float f) {
            for (d dVar : this.IO.FX) {
                if (dVar != null) {
                    dVar.kE();
                }
            }
            this.Gh = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gf = uptimeMillis;
            this.Gg = uptimeMillis + 16;
            this.Gc = f;
            this.Gb = 0.0f;
            this.Gd = 0 - this.IO.Iy;
            this.Ge = this.IO.Iy;
            BdLog.d("Animator@animateBottomOpen " + this.Gd);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.IO.IH.removeMessages(-105);
            this.IO.IH.sendEmptyMessageAtTime(-105, this.Gg);
        }

        void A(float f) {
            e eVar = this.IO.IK;
            if (eVar != null) {
                eVar.kC();
            }
            this.Gh = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gf = uptimeMillis;
            this.Gg = uptimeMillis + 16;
            this.Gc = f;
            this.Gb = 0.0f;
            this.Gd = ((-this.IO.FC) + this.IO.Iu) - this.IO.Iy;
            this.Ge = this.IO.Iy;
            BdLog.d("Animator@animateTop " + this.Gd);
            BdLog.d("Animator@animateTop " + f);
            this.IO.IH.removeMessages(-100);
            this.IO.IH.sendEmptyMessageAtTime(-100, this.Gg);
        }

        void B(float f) {
            c cVar = this.IO.IL;
            if (cVar != null) {
                cVar.kG();
            }
            this.Gh = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gf = uptimeMillis;
            this.Gg = uptimeMillis + 16;
            this.Gc = f;
            this.Gb = 0.0f;
            this.Gd = (this.IO.FC - this.IO.Iw) - this.IO.Iy;
            this.Ge = this.IO.Iy;
            BdLog.d("Animator@animateBottom " + this.Gd);
            BdLog.d("Animator@animateBottom " + f);
            this.IO.IH.removeMessages(-101);
            this.IO.IH.sendEmptyMessageAtTime(-101, this.Gg);
        }
    }
}
