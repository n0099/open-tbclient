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
    private int FC;
    private int FD;
    private final int FH;
    private int FL;
    private final Paint FO;
    private int FP;
    private int FQ;
    private final List<d> FY;
    private boolean IA;
    private boolean IB;
    private TrackDirection IC;
    private final Rect IE;
    private final Rect IF;
    private int IG;
    private boolean IH;
    private final a II;
    private final b IJ;
    private final g IK;
    private e IL;
    private c IM;
    private f IN;
    private float Iv;
    private float Iw;
    private float Ix;
    private float Iy;
    private int Iz;

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
        this.FO.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Iz = (int) ((this.Iv - this.FD) * (-f2));
            } else if (f2 > 0.0f) {
                this.Iz = (int) ((this.FD - this.Ix) * f2);
            } else if (f2 == 0.0f) {
                this.Iz = 0;
                this.FL = 10004;
            } else if (f2 == -1.0f) {
                this.Iv -= this.FD;
                this.FL = 10000;
            } else if (f2 == 1.0f) {
                this.Iv = this.FD - this.Ix;
                this.FL = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Iv;
    }

    public int getBottomOffset() {
        return (int) this.Ix;
    }

    public void setTopTapBack(boolean z) {
        this.IA = z;
    }

    public void setBottomTapBack(boolean z) {
        this.IB = z;
    }

    public int getState() {
        return this.FL;
    }

    public void setTopAnimationListener(e eVar) {
        this.IL = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.IM = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.IN = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Iz);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Iz);
        canvas.drawRect(0.0f, 0.0f, this.FC, this.FD, this.FO);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Iz;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.IC == TrackDirection.none) {
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
                    this.II.removeMessages(-100);
                    this.II.removeMessages(-104);
                    this.II.removeMessages(-101);
                    this.II.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Iz);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.FP - this.FH && i <= this.FP + this.FH && (i2 < this.FQ - this.FH || i2 > this.FQ + this.FH) && this.IK.aI(i2 - this.FQ);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.IH = false;
                    if (this.IK.Gl) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.IK.kI();
                        this.IK.kJ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.IK.Gl) {
                        if (!this.IH) {
                            if (y > this.FQ) {
                                this.IG = this.FQ + this.FH;
                                this.IH = true;
                            } else {
                                this.IG = this.FQ - this.FH;
                                this.IH = true;
                            }
                        }
                        this.IK.aJ(this.IG - y);
                        this.IG = y;
                        this.IK.Gk.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.FL != 10000 || !this.IE.contains(x, y)) && (this.FL != 10001 || !this.IF.contains(x, y))) {
                    return false;
                }
                if (!this.IK.Gl) {
                    this.IG = y;
                    this.IK.aI(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.IK.Gl) {
                    this.IK.kI();
                    this.IK.kJ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.IK.Gl) {
            this.IK.aJ(this.IG - y);
            this.IG = y;
            this.IK.Gk.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Iv != -1.0f) {
                this.IE.set(i, i2, i3, (int) (i2 + this.Iv));
            }
            if (this.Ix != -1.0f) {
                this.IF.set(i, (int) (i4 - this.Ix), i3, i4);
            }
        }
        if (!this.IJ.Gi && !this.IK.Gl) {
            kw();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Iw != -1.0f) {
            this.Iv = i3 - this.Iy;
        }
        if (this.Iy != -1.0f) {
            this.Ix = i3 - this.Iw;
        }
        if (!$assertionsDisabled && i3 < this.Iv) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Ix) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.FC = getMeasuredWidth();
        this.FD = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw() {
        switch (this.FL) {
            case 10000:
                this.Iz = (int) (this.Iv - this.FD);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Iz = (int) (this.FD - this.Ix);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Iz = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout IP;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.IP.IJ.Gi) {
                switch (message.what) {
                    case -105:
                        this.IP.IJ.lx();
                        return;
                    case -104:
                        this.IP.IJ.lw();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.IP.IJ.lv();
                        return;
                    case -100:
                        this.IP.IJ.lu();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Gk;
        boolean Gl;
        final int Gm;
        final int Gn;
        final /* synthetic */ VerticalTranslateLayout IP;

        boolean aI(int i) {
            switch (this.IP.IC) {
                case top:
                    if (this.IP.FL != 10004 && this.IP.FL != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.IP.FL != 10004 && this.IP.FL != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.IP.IN != null) {
                        this.IP.IN.aP(i);
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
                int i2 = this.IP.Iz - i;
                switch (this.IP.IC) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.IP.Iv - this.IP.FD && i2 < 0) {
                            this.IP.Iz -= i;
                            this.IP.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.IP.FD - this.IP.Ix && i2 > 0) {
                            this.IP.Iz -= i;
                            this.IP.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.IP.Iv - this.IP.FD && i2 <= this.IP.FD - this.IP.Ix) {
                            this.IP.Iz -= i;
                            this.IP.invalidate();
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
            float yVelocity = this.Gk.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Gn);
            } else {
                max = Math.max(yVelocity, this.Gn);
            }
            switch (this.IP.IC) {
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
            this.Gk.recycle();
            this.Gk = null;
        }

        private void C(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.IP.Iz;
            if (i <= 0 && i >= this.IP.Iv - this.IP.FD) {
                if (f < 0.0f) {
                    this.IP.IJ.A(f);
                } else {
                    this.IP.IJ.y(f);
                }
            } else if (i >= 0 && i <= this.IP.FD - this.IP.Ix) {
                if (f < 0.0f) {
                    this.IP.IJ.z(f);
                } else {
                    this.IP.IJ.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.IP.IJ.A(f);
            } else {
                this.IP.IJ.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.IP.IJ.z(f);
            } else {
                this.IP.IJ.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float Gc;
        float Gd;
        float Ge;
        float Gf;
        long Gg;
        long Gh;
        boolean Gi;
        final /* synthetic */ VerticalTranslateLayout IP;

        private void kx() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gc = ((((float) (uptimeMillis - this.Gg)) / 1000.0f) * this.Gd) + this.Gc;
            this.Gg = uptimeMillis;
            this.Gh += 16;
        }

        void lu() {
            kx();
            if (this.Gc <= this.Ge) {
                e eVar = this.IP.IL;
                if (eVar != null) {
                    eVar.lz();
                }
                this.Gi = false;
                this.IP.FL = 10000;
                this.IP.kw();
                return;
            }
            this.IP.Iz = (int) (com.baidu.adp.widget.a.a(this.Ge, this.Gc, false) + this.Gf);
            this.IP.invalidate();
            this.IP.II.sendEmptyMessageAtTime(-100, this.Gh);
        }

        void lv() {
            kx();
            if (this.Gc >= this.Ge) {
                c cVar = this.IP.IM;
                if (cVar != null) {
                    cVar.ly();
                }
                this.Gi = false;
                this.IP.FL = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.IP.kw();
                return;
            }
            this.IP.Iz = (int) (com.baidu.adp.widget.a.a(this.Ge, this.Gc, false) + this.Gf);
            this.IP.invalidate();
            this.IP.II.sendEmptyMessageAtTime(-101, this.Gh);
        }

        void lw() {
            kx();
            if (this.Gc >= this.Ge) {
                for (d dVar : this.IP.FY) {
                    if (dVar != null) {
                        dVar.kF();
                    }
                }
                this.Gi = false;
                this.IP.FL = 10004;
                this.IP.kw();
                return;
            }
            this.IP.Iz = (int) (com.baidu.adp.widget.a.a(this.Ge, this.Gc, false) + this.Gf);
            this.IP.invalidate();
            this.IP.II.sendEmptyMessageAtTime(-104, this.Gh);
        }

        void lx() {
            kx();
            if (this.Gc <= this.Ge) {
                for (d dVar : this.IP.FY) {
                    if (dVar != null) {
                        dVar.kF();
                    }
                }
                this.Gi = false;
                this.IP.FL = 10004;
                this.IP.kw();
                return;
            }
            this.IP.Iz = (int) (com.baidu.adp.widget.a.a(this.Ge, this.Gc, false) + this.Gf);
            this.IP.invalidate();
            this.IP.II.sendEmptyMessageAtTime(-105, this.Gh);
        }

        void y(float f) {
            for (d dVar : this.IP.FY) {
                if (dVar != null) {
                    dVar.kE();
                }
            }
            this.Gi = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = uptimeMillis;
            this.Gh = uptimeMillis + 16;
            this.Gd = f;
            this.Gc = 0.0f;
            this.Ge = 0 - this.IP.Iz;
            this.Gf = this.IP.Iz;
            this.IP.II.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Ge);
            BdLog.d("Animator@animateTopOpen " + f);
            this.IP.II.sendEmptyMessageAtTime(-104, this.Gh);
        }

        void z(float f) {
            for (d dVar : this.IP.FY) {
                if (dVar != null) {
                    dVar.kE();
                }
            }
            this.Gi = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = uptimeMillis;
            this.Gh = uptimeMillis + 16;
            this.Gd = f;
            this.Gc = 0.0f;
            this.Ge = 0 - this.IP.Iz;
            this.Gf = this.IP.Iz;
            BdLog.d("Animator@animateBottomOpen " + this.Ge);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.IP.II.removeMessages(-105);
            this.IP.II.sendEmptyMessageAtTime(-105, this.Gh);
        }

        void A(float f) {
            e eVar = this.IP.IL;
            if (eVar != null) {
                eVar.kC();
            }
            this.Gi = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = uptimeMillis;
            this.Gh = uptimeMillis + 16;
            this.Gd = f;
            this.Gc = 0.0f;
            this.Ge = ((-this.IP.FD) + this.IP.Iv) - this.IP.Iz;
            this.Gf = this.IP.Iz;
            BdLog.d("Animator@animateTop " + this.Ge);
            BdLog.d("Animator@animateTop " + f);
            this.IP.II.removeMessages(-100);
            this.IP.II.sendEmptyMessageAtTime(-100, this.Gh);
        }

        void B(float f) {
            c cVar = this.IP.IM;
            if (cVar != null) {
                cVar.kG();
            }
            this.Gi = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = uptimeMillis;
            this.Gh = uptimeMillis + 16;
            this.Gd = f;
            this.Gc = 0.0f;
            this.Ge = (this.IP.FD - this.IP.Ix) - this.IP.Iz;
            this.Gf = this.IP.Iz;
            BdLog.d("Animator@animateBottom " + this.Ge);
            BdLog.d("Animator@animateBottom " + f);
            this.IP.II.removeMessages(-101);
            this.IP.II.sendEmptyMessageAtTime(-101, this.Gh);
        }
    }
}
