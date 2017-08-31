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
    private int FA;
    private final int FF;
    private int FJ;
    private final Paint FM;
    private int FN;
    private int FO;
    private final List<d> FW;
    private int Fz;
    private float Id;
    private float Ie;
    private float If;
    private float Ig;
    private int Ih;
    private boolean Ii;
    private boolean Ij;
    private TrackDirection Ik;
    private final Rect Il;
    private final Rect Im;
    private int In;
    private boolean Io;
    private final a Ip;
    private final b Iq;
    private final g Ir;
    private e Is;
    private c It;
    private f Iu;

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
        void kH();

        void lw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kF();

        void kG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kD();

        void lx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aL(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FM.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Ih = (int) ((this.Id - this.FA) * (-f2));
            } else if (f2 > 0.0f) {
                this.Ih = (int) ((this.FA - this.If) * f2);
            } else if (f2 == 0.0f) {
                this.Ih = 0;
                this.FJ = 10004;
            } else if (f2 == -1.0f) {
                this.Id -= this.FA;
                this.FJ = 10000;
            } else if (f2 == 1.0f) {
                this.Id = this.FA - this.If;
                this.FJ = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Id;
    }

    public int getBottomOffset() {
        return (int) this.If;
    }

    public void setTopTapBack(boolean z) {
        this.Ii = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Ij = z;
    }

    public int getState() {
        return this.FJ;
    }

    public void setTopAnimationListener(e eVar) {
        this.Is = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.It = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Iu = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Ih);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Ih);
        canvas.drawRect(0.0f, 0.0f, this.Fz, this.FA, this.FM);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Ih;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Ik == TrackDirection.none) {
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
                    this.Ip.removeMessages(-100);
                    this.Ip.removeMessages(-104);
                    this.Ip.removeMessages(-101);
                    this.Ip.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Ih);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.FN - this.FF && i <= this.FN + this.FF && (i2 < this.FO - this.FF || i2 > this.FO + this.FF) && this.Ir.aF(i2 - this.FO);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Io = false;
                    if (this.Ir.Gj) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Ir.kJ();
                        this.Ir.kK();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Ir.Gj) {
                        if (!this.Io) {
                            if (y > this.FO) {
                                this.In = this.FO + this.FF;
                                this.Io = true;
                            } else {
                                this.In = this.FO - this.FF;
                                this.Io = true;
                            }
                        }
                        this.Ir.aG(this.In - y);
                        this.In = y;
                        this.Ir.Gi.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.FJ != 10000 || !this.Il.contains(x, y)) && (this.FJ != 10001 || !this.Im.contains(x, y))) {
                    return false;
                }
                if (!this.Ir.Gj) {
                    this.In = y;
                    this.Ir.aF(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Ir.Gj) {
                    this.Ir.kJ();
                    this.Ir.kK();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Ir.Gj) {
            this.Ir.aG(this.In - y);
            this.In = y;
            this.Ir.Gi.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Id != -1.0f) {
                this.Il.set(i, i2, i3, (int) (i2 + this.Id));
            }
            if (this.If != -1.0f) {
                this.Im.set(i, (int) (i4 - this.If), i3, i4);
            }
        }
        if (!this.Iq.Gg && !this.Ir.Gj) {
            kx();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Ie != -1.0f) {
            this.Id = i3 - this.Ig;
        }
        if (this.Ig != -1.0f) {
            this.If = i3 - this.Ie;
        }
        if (!$assertionsDisabled && i3 < this.Id) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.If) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fz = getMeasuredWidth();
        this.FA = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx() {
        switch (this.FJ) {
            case 10000:
                this.Ih = (int) (this.Id - this.FA);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Ih = (int) (this.FA - this.If);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Ih = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Iw;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Iw.Iq.Gg) {
                switch (message.what) {
                    case -105:
                        this.Iw.Iq.lv();
                        return;
                    case -104:
                        this.Iw.Iq.lu();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Iw.Iq.lt();
                        return;
                    case -100:
                        this.Iw.Iq.ls();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Gi;
        boolean Gj;
        final int Gk;
        final int Gl;
        final /* synthetic */ VerticalTranslateLayout Iw;

        boolean aF(int i) {
            switch (this.Iw.Ik) {
                case top:
                    if (this.Iw.FJ != 10004 && this.Iw.FJ != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.Iw.FJ != 10004 && this.Iw.FJ != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.Iw.Iu != null) {
                        this.Iw.Iu.aL(i);
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
                int i2 = this.Iw.Ih - i;
                switch (this.Iw.Ik) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Iw.Id - this.Iw.FA && i2 < 0) {
                            this.Iw.Ih -= i;
                            this.Iw.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Iw.FA - this.Iw.If && i2 > 0) {
                            this.Iw.Ih -= i;
                            this.Iw.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Iw.Id - this.Iw.FA && i2 <= this.Iw.FA - this.Iw.If) {
                            this.Iw.Ih -= i;
                            this.Iw.invalidate();
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
            float yVelocity = this.Gi.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Gl);
            } else {
                max = Math.max(yVelocity, this.Gl);
            }
            switch (this.Iw.Ik) {
                case top:
                    C(max);
                    break;
                case bottom:
                    D(max);
                    break;
                case vertical:
                    B(max);
                    break;
            }
            this.Gi.recycle();
            this.Gi = null;
        }

        private void B(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.Iw.Ih;
            if (i <= 0 && i >= this.Iw.Id - this.Iw.FA) {
                if (f < 0.0f) {
                    this.Iw.Iq.z(f);
                } else {
                    this.Iw.Iq.x(f);
                }
            } else if (i >= 0 && i <= this.Iw.FA - this.Iw.If) {
                if (f < 0.0f) {
                    this.Iw.Iq.y(f);
                } else {
                    this.Iw.Iq.A(f);
                }
            }
        }

        private void C(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Iw.Iq.z(f);
            } else {
                this.Iw.Iq.x(f);
            }
        }

        private void D(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Iw.Iq.y(f);
            } else {
                this.Iw.Iq.A(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float Ga;
        float Gb;
        float Gc;
        float Gd;
        long Ge;
        long Gf;
        boolean Gg;
        final /* synthetic */ VerticalTranslateLayout Iw;

        private void ky() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ga = ((((float) (uptimeMillis - this.Ge)) / 1000.0f) * this.Gb) + this.Ga;
            this.Ge = uptimeMillis;
            this.Gf += 16;
        }

        void ls() {
            ky();
            if (this.Ga <= this.Gc) {
                e eVar = this.Iw.Is;
                if (eVar != null) {
                    eVar.lx();
                }
                this.Gg = false;
                this.Iw.FJ = 10000;
                this.Iw.kx();
                return;
            }
            this.Iw.Ih = (int) (com.baidu.adp.widget.a.a(this.Gc, this.Ga, false) + this.Gd);
            this.Iw.invalidate();
            this.Iw.Ip.sendEmptyMessageAtTime(-100, this.Gf);
        }

        void lt() {
            ky();
            if (this.Ga >= this.Gc) {
                c cVar = this.Iw.It;
                if (cVar != null) {
                    cVar.lw();
                }
                this.Gg = false;
                this.Iw.FJ = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Iw.kx();
                return;
            }
            this.Iw.Ih = (int) (com.baidu.adp.widget.a.a(this.Gc, this.Ga, false) + this.Gd);
            this.Iw.invalidate();
            this.Iw.Ip.sendEmptyMessageAtTime(-101, this.Gf);
        }

        void lu() {
            ky();
            if (this.Ga >= this.Gc) {
                for (d dVar : this.Iw.FW) {
                    if (dVar != null) {
                        dVar.kG();
                    }
                }
                this.Gg = false;
                this.Iw.FJ = 10004;
                this.Iw.kx();
                return;
            }
            this.Iw.Ih = (int) (com.baidu.adp.widget.a.a(this.Gc, this.Ga, false) + this.Gd);
            this.Iw.invalidate();
            this.Iw.Ip.sendEmptyMessageAtTime(-104, this.Gf);
        }

        void lv() {
            ky();
            if (this.Ga <= this.Gc) {
                for (d dVar : this.Iw.FW) {
                    if (dVar != null) {
                        dVar.kG();
                    }
                }
                this.Gg = false;
                this.Iw.FJ = 10004;
                this.Iw.kx();
                return;
            }
            this.Iw.Ih = (int) (com.baidu.adp.widget.a.a(this.Gc, this.Ga, false) + this.Gd);
            this.Iw.invalidate();
            this.Iw.Ip.sendEmptyMessageAtTime(-105, this.Gf);
        }

        void x(float f) {
            for (d dVar : this.Iw.FW) {
                if (dVar != null) {
                    dVar.kF();
                }
            }
            this.Gg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ge = uptimeMillis;
            this.Gf = uptimeMillis + 16;
            this.Gb = f;
            this.Ga = 0.0f;
            this.Gc = 0 - this.Iw.Ih;
            this.Gd = this.Iw.Ih;
            this.Iw.Ip.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Gc);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Iw.Ip.sendEmptyMessageAtTime(-104, this.Gf);
        }

        void y(float f) {
            for (d dVar : this.Iw.FW) {
                if (dVar != null) {
                    dVar.kF();
                }
            }
            this.Gg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ge = uptimeMillis;
            this.Gf = uptimeMillis + 16;
            this.Gb = f;
            this.Ga = 0.0f;
            this.Gc = 0 - this.Iw.Ih;
            this.Gd = this.Iw.Ih;
            BdLog.d("Animator@animateBottomOpen " + this.Gc);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Iw.Ip.removeMessages(-105);
            this.Iw.Ip.sendEmptyMessageAtTime(-105, this.Gf);
        }

        void z(float f) {
            e eVar = this.Iw.Is;
            if (eVar != null) {
                eVar.kD();
            }
            this.Gg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ge = uptimeMillis;
            this.Gf = uptimeMillis + 16;
            this.Gb = f;
            this.Ga = 0.0f;
            this.Gc = ((-this.Iw.FA) + this.Iw.Id) - this.Iw.Ih;
            this.Gd = this.Iw.Ih;
            BdLog.d("Animator@animateTop " + this.Gc);
            BdLog.d("Animator@animateTop " + f);
            this.Iw.Ip.removeMessages(-100);
            this.Iw.Ip.sendEmptyMessageAtTime(-100, this.Gf);
        }

        void A(float f) {
            c cVar = this.Iw.It;
            if (cVar != null) {
                cVar.kH();
            }
            this.Gg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ge = uptimeMillis;
            this.Gf = uptimeMillis + 16;
            this.Gb = f;
            this.Ga = 0.0f;
            this.Gc = (this.Iw.FA - this.Iw.If) - this.Iw.Ih;
            this.Gd = this.Iw.Ih;
            BdLog.d("Animator@animateBottom " + this.Gc);
            BdLog.d("Animator@animateBottom " + f);
            this.Iw.Ip.removeMessages(-101);
            this.Iw.Ip.sendEmptyMessageAtTime(-101, this.Gf);
        }
    }
}
