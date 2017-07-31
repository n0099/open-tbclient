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
    private int HD;
    private int HE;
    private final int HJ;
    private int HN;
    private final Paint HQ;
    private int HR;
    private int HS;
    private final List<d> Ia;
    private float Kh;
    private float Ki;
    private float Kj;
    private float Kk;
    private int Kl;
    private boolean Km;
    private boolean Kn;
    private TrackDirection Ko;
    private final Rect Kp;
    private final Rect Kq;
    private int Kr;
    private boolean Ks;
    private final a Kt;
    private final b Ku;
    private final g Kv;
    private e Kw;
    private c Kx;
    private f Ky;

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
        void kQ();

        void lF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kO();

        void kP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kM();

        void lG();
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
        this.HQ.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Kl = (int) ((this.Kh - this.HE) * (-f2));
            } else if (f2 > 0.0f) {
                this.Kl = (int) ((this.HE - this.Kj) * f2);
            } else if (f2 == 0.0f) {
                this.Kl = 0;
                this.HN = 10004;
            } else if (f2 == -1.0f) {
                this.Kh -= this.HE;
                this.HN = 10000;
            } else if (f2 == 1.0f) {
                this.Kh = this.HE - this.Kj;
                this.HN = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Kh;
    }

    public int getBottomOffset() {
        return (int) this.Kj;
    }

    public void setTopTapBack(boolean z) {
        this.Km = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Kn = z;
    }

    public int getState() {
        return this.HN;
    }

    public void setTopAnimationListener(e eVar) {
        this.Kw = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Kx = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Ky = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Kl);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Kl);
        canvas.drawRect(0.0f, 0.0f, this.HD, this.HE, this.HQ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Kl;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Ko == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.HN == 10004) {
            switch (action) {
                case 0:
                    this.HR = x;
                    this.HS = y;
                    this.Kt.removeMessages(-100);
                    this.Kt.removeMessages(-104);
                    this.Kt.removeMessages(-101);
                    this.Kt.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Kl);
                    return r(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean r(int i, int i2) {
        return i >= this.HR - this.HJ && i <= this.HR + this.HJ && (i2 < this.HS - this.HJ || i2 > this.HS + this.HJ) && this.Kv.aH(i2 - this.HS);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.HN == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Ks = false;
                    if (this.Kv.In) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Kv.kS();
                        this.Kv.kT();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Kv.In) {
                        if (!this.Ks) {
                            if (y > this.HS) {
                                this.Kr = this.HS + this.HJ;
                                this.Ks = true;
                            } else {
                                this.Kr = this.HS - this.HJ;
                                this.Ks = true;
                            }
                        }
                        this.Kv.aI(this.Kr - y);
                        this.Kr = y;
                        this.Kv.Im.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.HN != 10000 || !this.Kp.contains(x, y)) && (this.HN != 10001 || !this.Kq.contains(x, y))) {
                    return false;
                }
                if (!this.Kv.In) {
                    this.Kr = y;
                    this.Kv.aH(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Kv.In) {
                    this.Kv.kS();
                    this.Kv.kT();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Kv.In) {
            this.Kv.aI(this.Kr - y);
            this.Kr = y;
            this.Kv.Im.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Kh != -1.0f) {
                this.Kp.set(i, i2, i3, (int) (i2 + this.Kh));
            }
            if (this.Kj != -1.0f) {
                this.Kq.set(i, (int) (i4 - this.Kj), i3, i4);
            }
        }
        if (!this.Ku.Ik && !this.Kv.In) {
            kG();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Ki != -1.0f) {
            this.Kh = i3 - this.Kk;
        }
        if (this.Kk != -1.0f) {
            this.Kj = i3 - this.Ki;
        }
        if (!$assertionsDisabled && i3 < this.Kh) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Kj) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.HD = getMeasuredWidth();
        this.HE = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kG() {
        switch (this.HN) {
            case 10000:
                this.Kl = (int) (this.Kh - this.HE);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Kl = (int) (this.HE - this.Kj);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Kl = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout KA;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.KA.Ku.Ik) {
                switch (message.what) {
                    case -105:
                        this.KA.Ku.lE();
                        return;
                    case -104:
                        this.KA.Ku.lD();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.KA.Ku.lC();
                        return;
                    case -100:
                        this.KA.Ku.lB();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Im;
        boolean In;
        final int Io;
        final int Ip;
        final /* synthetic */ VerticalTranslateLayout KA;

        boolean aH(int i) {
            switch (this.KA.Ko) {
                case top:
                    if (this.KA.HN != 10004 && this.KA.HN != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.KA.HN != 10004 && this.KA.HN != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.KA.Ky != null) {
                        this.KA.Ky.aN(i);
                        break;
                    }
                    break;
            }
            this.Im = VelocityTracker.obtain();
            this.In = true;
            return true;
        }

        void kS() {
            this.In = false;
        }

        void aI(int i) {
            if (this.In) {
                int i2 = this.KA.Kl - i;
                switch (this.KA.Ko) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.KA.Kh - this.KA.HE && i2 < 0) {
                            this.KA.Kl -= i;
                            this.KA.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.KA.HE - this.KA.Kj && i2 > 0) {
                            this.KA.Kl -= i;
                            this.KA.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.KA.Kh - this.KA.HE && i2 <= this.KA.HE - this.KA.Kj) {
                            this.KA.Kl -= i;
                            this.KA.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kT() {
            float max;
            this.Im.computeCurrentVelocity(this.Io);
            float yVelocity = this.Im.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ip);
            } else {
                max = Math.max(yVelocity, this.Ip);
            }
            switch (this.KA.Ko) {
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
            this.Im.recycle();
            this.Im = null;
        }

        private void M(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.KA.Kl;
            if (i <= 0 && i >= this.KA.Kh - this.KA.HE) {
                if (f < 0.0f) {
                    this.KA.Ku.K(f);
                } else {
                    this.KA.Ku.I(f);
                }
            } else if (i >= 0 && i <= this.KA.HE - this.KA.Kj) {
                if (f < 0.0f) {
                    this.KA.Ku.J(f);
                } else {
                    this.KA.Ku.L(f);
                }
            }
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.KA.Ku.K(f);
            } else {
                this.KA.Ku.I(f);
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.KA.Ku.J(f);
            } else {
                this.KA.Ku.L(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float Ie;
        float If;
        float Ig;
        float Ih;
        long Ii;
        long Ij;
        boolean Ik;
        final /* synthetic */ VerticalTranslateLayout KA;

        private void kH() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ie = ((((float) (uptimeMillis - this.Ii)) / 1000.0f) * this.If) + this.Ie;
            this.Ii = uptimeMillis;
            this.Ij += 16;
        }

        void lB() {
            kH();
            if (this.Ie <= this.Ig) {
                e eVar = this.KA.Kw;
                if (eVar != null) {
                    eVar.lG();
                }
                this.Ik = false;
                this.KA.HN = 10000;
                this.KA.kG();
                return;
            }
            this.KA.Kl = (int) (com.baidu.adp.widget.a.a(this.Ig, this.Ie, false) + this.Ih);
            this.KA.invalidate();
            this.KA.Kt.sendEmptyMessageAtTime(-100, this.Ij);
        }

        void lC() {
            kH();
            if (this.Ie >= this.Ig) {
                c cVar = this.KA.Kx;
                if (cVar != null) {
                    cVar.lF();
                }
                this.Ik = false;
                this.KA.HN = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.KA.kG();
                return;
            }
            this.KA.Kl = (int) (com.baidu.adp.widget.a.a(this.Ig, this.Ie, false) + this.Ih);
            this.KA.invalidate();
            this.KA.Kt.sendEmptyMessageAtTime(-101, this.Ij);
        }

        void lD() {
            kH();
            if (this.Ie >= this.Ig) {
                for (d dVar : this.KA.Ia) {
                    if (dVar != null) {
                        dVar.kP();
                    }
                }
                this.Ik = false;
                this.KA.HN = 10004;
                this.KA.kG();
                return;
            }
            this.KA.Kl = (int) (com.baidu.adp.widget.a.a(this.Ig, this.Ie, false) + this.Ih);
            this.KA.invalidate();
            this.KA.Kt.sendEmptyMessageAtTime(-104, this.Ij);
        }

        void lE() {
            kH();
            if (this.Ie <= this.Ig) {
                for (d dVar : this.KA.Ia) {
                    if (dVar != null) {
                        dVar.kP();
                    }
                }
                this.Ik = false;
                this.KA.HN = 10004;
                this.KA.kG();
                return;
            }
            this.KA.Kl = (int) (com.baidu.adp.widget.a.a(this.Ig, this.Ie, false) + this.Ih);
            this.KA.invalidate();
            this.KA.Kt.sendEmptyMessageAtTime(-105, this.Ij);
        }

        void I(float f) {
            for (d dVar : this.KA.Ia) {
                if (dVar != null) {
                    dVar.kO();
                }
            }
            this.Ik = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ii = uptimeMillis;
            this.Ij = uptimeMillis + 16;
            this.If = f;
            this.Ie = 0.0f;
            this.Ig = 0 - this.KA.Kl;
            this.Ih = this.KA.Kl;
            this.KA.Kt.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Ig);
            BdLog.d("Animator@animateTopOpen " + f);
            this.KA.Kt.sendEmptyMessageAtTime(-104, this.Ij);
        }

        void J(float f) {
            for (d dVar : this.KA.Ia) {
                if (dVar != null) {
                    dVar.kO();
                }
            }
            this.Ik = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ii = uptimeMillis;
            this.Ij = uptimeMillis + 16;
            this.If = f;
            this.Ie = 0.0f;
            this.Ig = 0 - this.KA.Kl;
            this.Ih = this.KA.Kl;
            BdLog.d("Animator@animateBottomOpen " + this.Ig);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.KA.Kt.removeMessages(-105);
            this.KA.Kt.sendEmptyMessageAtTime(-105, this.Ij);
        }

        void K(float f) {
            e eVar = this.KA.Kw;
            if (eVar != null) {
                eVar.kM();
            }
            this.Ik = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ii = uptimeMillis;
            this.Ij = uptimeMillis + 16;
            this.If = f;
            this.Ie = 0.0f;
            this.Ig = ((-this.KA.HE) + this.KA.Kh) - this.KA.Kl;
            this.Ih = this.KA.Kl;
            BdLog.d("Animator@animateTop " + this.Ig);
            BdLog.d("Animator@animateTop " + f);
            this.KA.Kt.removeMessages(-100);
            this.KA.Kt.sendEmptyMessageAtTime(-100, this.Ij);
        }

        void L(float f) {
            c cVar = this.KA.Kx;
            if (cVar != null) {
                cVar.kQ();
            }
            this.Ik = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ii = uptimeMillis;
            this.Ij = uptimeMillis + 16;
            this.If = f;
            this.Ie = 0.0f;
            this.Ig = (this.KA.HE - this.KA.Kj) - this.KA.Kl;
            this.Ih = this.KA.Kl;
            BdLog.d("Animator@animateBottom " + this.Ig);
            BdLog.d("Animator@animateBottom " + f);
            this.KA.Kt.removeMessages(-101);
            this.KA.Kt.sendEmptyMessageAtTime(-101, this.Ij);
        }
    }
}
