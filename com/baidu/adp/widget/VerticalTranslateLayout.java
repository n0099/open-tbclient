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
    private int HF;
    private int HG;
    private final int HL;
    private int HP;
    private final Paint HS;
    private int HT;
    private int HU;
    private final List<d> Ic;
    private f KA;
    private float Kj;
    private float Kk;
    private float Kl;
    private float Km;
    private int Kn;
    private boolean Ko;
    private boolean Kp;
    private TrackDirection Kq;
    private final Rect Kr;
    private final Rect Ks;
    private int Kt;
    private boolean Ku;
    private final a Kv;
    private final b Kw;
    private final g Kx;
    private e Ky;
    private c Kz;

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
        void kP();

        void lE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kN();

        void kO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kL();

        void lF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aN(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.HS.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Kn = (int) ((this.Kj - this.HG) * (-f2));
            } else if (f2 > 0.0f) {
                this.Kn = (int) ((this.HG - this.Kl) * f2);
            } else if (f2 == 0.0f) {
                this.Kn = 0;
                this.HP = 10004;
            } else if (f2 == -1.0f) {
                this.Kj -= this.HG;
                this.HP = 10000;
            } else if (f2 == 1.0f) {
                this.Kj = this.HG - this.Kl;
                this.HP = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Kj;
    }

    public int getBottomOffset() {
        return (int) this.Kl;
    }

    public void setTopTapBack(boolean z) {
        this.Ko = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Kp = z;
    }

    public int getState() {
        return this.HP;
    }

    public void setTopAnimationListener(e eVar) {
        this.Ky = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Kz = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.KA = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Kn);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Kn);
        canvas.drawRect(0.0f, 0.0f, this.HF, this.HG, this.HS);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Kn;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Kq == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.HP == 10004) {
            switch (action) {
                case 0:
                    this.HT = x;
                    this.HU = y;
                    this.Kv.removeMessages(-100);
                    this.Kv.removeMessages(-104);
                    this.Kv.removeMessages(-101);
                    this.Kv.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Kn);
                    return r(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean r(int i, int i2) {
        return i >= this.HT - this.HL && i <= this.HT + this.HL && (i2 < this.HU - this.HL || i2 > this.HU + this.HL) && this.Kx.aH(i2 - this.HU);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.HP == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Ku = false;
                    if (this.Kx.Ip) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Kx.kR();
                        this.Kx.kS();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Kx.Ip) {
                        if (!this.Ku) {
                            if (y > this.HU) {
                                this.Kt = this.HU + this.HL;
                                this.Ku = true;
                            } else {
                                this.Kt = this.HU - this.HL;
                                this.Ku = true;
                            }
                        }
                        this.Kx.aI(this.Kt - y);
                        this.Kt = y;
                        this.Kx.Io.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.HP != 10000 || !this.Kr.contains(x, y)) && (this.HP != 10001 || !this.Ks.contains(x, y))) {
                    return false;
                }
                if (!this.Kx.Ip) {
                    this.Kt = y;
                    this.Kx.aH(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Kx.Ip) {
                    this.Kx.kR();
                    this.Kx.kS();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Kx.Ip) {
            this.Kx.aI(this.Kt - y);
            this.Kt = y;
            this.Kx.Io.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Kj != -1.0f) {
                this.Kr.set(i, i2, i3, (int) (i2 + this.Kj));
            }
            if (this.Kl != -1.0f) {
                this.Ks.set(i, (int) (i4 - this.Kl), i3, i4);
            }
        }
        if (!this.Kw.Im && !this.Kx.Ip) {
            kF();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Kk != -1.0f) {
            this.Kj = i3 - this.Km;
        }
        if (this.Km != -1.0f) {
            this.Kl = i3 - this.Kk;
        }
        if (!$assertionsDisabled && i3 < this.Kj) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Kl) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.HF = getMeasuredWidth();
        this.HG = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kF() {
        switch (this.HP) {
            case 10000:
                this.Kn = (int) (this.Kj - this.HG);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Kn = (int) (this.HG - this.Kl);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Kn = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout KC;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.KC.Kw.Im) {
                switch (message.what) {
                    case -105:
                        this.KC.Kw.lD();
                        return;
                    case -104:
                        this.KC.Kw.lC();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.KC.Kw.lB();
                        return;
                    case -100:
                        this.KC.Kw.lA();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Io;
        boolean Ip;
        final int Iq;
        final int Ir;
        final /* synthetic */ VerticalTranslateLayout KC;

        boolean aH(int i) {
            switch (this.KC.Kq) {
                case top:
                    if (this.KC.HP != 10004 && this.KC.HP != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.KC.HP != 10004 && this.KC.HP != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.KC.KA != null) {
                        this.KC.KA.aN(i);
                        break;
                    }
                    break;
            }
            this.Io = VelocityTracker.obtain();
            this.Ip = true;
            return true;
        }

        void kR() {
            this.Ip = false;
        }

        void aI(int i) {
            if (this.Ip) {
                int i2 = this.KC.Kn - i;
                switch (this.KC.Kq) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.KC.Kj - this.KC.HG && i2 < 0) {
                            this.KC.Kn -= i;
                            this.KC.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.KC.HG - this.KC.Kl && i2 > 0) {
                            this.KC.Kn -= i;
                            this.KC.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.KC.Kj - this.KC.HG && i2 <= this.KC.HG - this.KC.Kl) {
                            this.KC.Kn -= i;
                            this.KC.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kS() {
            float max;
            this.Io.computeCurrentVelocity(this.Iq);
            float yVelocity = this.Io.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ir);
            } else {
                max = Math.max(yVelocity, this.Ir);
            }
            switch (this.KC.Kq) {
                case top:
                    N(max);
                    break;
                case bottom:
                    O(max);
                    break;
                case vertical:
                    M(max);
                    break;
            }
            this.Io.recycle();
            this.Io = null;
        }

        private void M(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.KC.Kn;
            if (i <= 0 && i >= this.KC.Kj - this.KC.HG) {
                if (f < 0.0f) {
                    this.KC.Kw.K(f);
                } else {
                    this.KC.Kw.I(f);
                }
            } else if (i >= 0 && i <= this.KC.HG - this.KC.Kl) {
                if (f < 0.0f) {
                    this.KC.Kw.J(f);
                } else {
                    this.KC.Kw.L(f);
                }
            }
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.KC.Kw.K(f);
            } else {
                this.KC.Kw.I(f);
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.KC.Kw.J(f);
            } else {
                this.KC.Kw.L(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float Ig;
        float Ih;
        float Ii;
        float Ij;
        long Ik;
        long Il;
        boolean Im;
        final /* synthetic */ VerticalTranslateLayout KC;

        private void kG() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ig = ((((float) (uptimeMillis - this.Ik)) / 1000.0f) * this.Ih) + this.Ig;
            this.Ik = uptimeMillis;
            this.Il += 16;
        }

        void lA() {
            kG();
            if (this.Ig <= this.Ii) {
                e eVar = this.KC.Ky;
                if (eVar != null) {
                    eVar.lF();
                }
                this.Im = false;
                this.KC.HP = 10000;
                this.KC.kF();
                return;
            }
            this.KC.Kn = (int) (com.baidu.adp.widget.a.a(this.Ii, this.Ig, false) + this.Ij);
            this.KC.invalidate();
            this.KC.Kv.sendEmptyMessageAtTime(-100, this.Il);
        }

        void lB() {
            kG();
            if (this.Ig >= this.Ii) {
                c cVar = this.KC.Kz;
                if (cVar != null) {
                    cVar.lE();
                }
                this.Im = false;
                this.KC.HP = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.KC.kF();
                return;
            }
            this.KC.Kn = (int) (com.baidu.adp.widget.a.a(this.Ii, this.Ig, false) + this.Ij);
            this.KC.invalidate();
            this.KC.Kv.sendEmptyMessageAtTime(-101, this.Il);
        }

        void lC() {
            kG();
            if (this.Ig >= this.Ii) {
                for (d dVar : this.KC.Ic) {
                    if (dVar != null) {
                        dVar.kO();
                    }
                }
                this.Im = false;
                this.KC.HP = 10004;
                this.KC.kF();
                return;
            }
            this.KC.Kn = (int) (com.baidu.adp.widget.a.a(this.Ii, this.Ig, false) + this.Ij);
            this.KC.invalidate();
            this.KC.Kv.sendEmptyMessageAtTime(-104, this.Il);
        }

        void lD() {
            kG();
            if (this.Ig <= this.Ii) {
                for (d dVar : this.KC.Ic) {
                    if (dVar != null) {
                        dVar.kO();
                    }
                }
                this.Im = false;
                this.KC.HP = 10004;
                this.KC.kF();
                return;
            }
            this.KC.Kn = (int) (com.baidu.adp.widget.a.a(this.Ii, this.Ig, false) + this.Ij);
            this.KC.invalidate();
            this.KC.Kv.sendEmptyMessageAtTime(-105, this.Il);
        }

        void I(float f) {
            for (d dVar : this.KC.Ic) {
                if (dVar != null) {
                    dVar.kN();
                }
            }
            this.Im = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ik = uptimeMillis;
            this.Il = uptimeMillis + 16;
            this.Ih = f;
            this.Ig = 0.0f;
            this.Ii = 0 - this.KC.Kn;
            this.Ij = this.KC.Kn;
            this.KC.Kv.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Ii);
            BdLog.d("Animator@animateTopOpen " + f);
            this.KC.Kv.sendEmptyMessageAtTime(-104, this.Il);
        }

        void J(float f) {
            for (d dVar : this.KC.Ic) {
                if (dVar != null) {
                    dVar.kN();
                }
            }
            this.Im = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ik = uptimeMillis;
            this.Il = uptimeMillis + 16;
            this.Ih = f;
            this.Ig = 0.0f;
            this.Ii = 0 - this.KC.Kn;
            this.Ij = this.KC.Kn;
            BdLog.d("Animator@animateBottomOpen " + this.Ii);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.KC.Kv.removeMessages(-105);
            this.KC.Kv.sendEmptyMessageAtTime(-105, this.Il);
        }

        void K(float f) {
            e eVar = this.KC.Ky;
            if (eVar != null) {
                eVar.kL();
            }
            this.Im = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ik = uptimeMillis;
            this.Il = uptimeMillis + 16;
            this.Ih = f;
            this.Ig = 0.0f;
            this.Ii = ((-this.KC.HG) + this.KC.Kj) - this.KC.Kn;
            this.Ij = this.KC.Kn;
            BdLog.d("Animator@animateTop " + this.Ii);
            BdLog.d("Animator@animateTop " + f);
            this.KC.Kv.removeMessages(-100);
            this.KC.Kv.sendEmptyMessageAtTime(-100, this.Il);
        }

        void L(float f) {
            c cVar = this.KC.Kz;
            if (cVar != null) {
                cVar.kP();
            }
            this.Im = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ik = uptimeMillis;
            this.Il = uptimeMillis + 16;
            this.Ih = f;
            this.Ig = 0.0f;
            this.Ii = (this.KC.HG - this.KC.Kl) - this.KC.Kn;
            this.Ij = this.KC.Kn;
            BdLog.d("Animator@animateBottom " + this.Ii);
            BdLog.d("Animator@animateBottom " + f);
            this.KC.Kv.removeMessages(-101);
            this.KC.Kv.sendEmptyMessageAtTime(-101, this.Il);
        }
    }
}
