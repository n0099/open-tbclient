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
    private f GA;
    private final List<e> GB;
    private c GC;
    private int Ge;
    private float Gh;
    private float Gi;
    private int Gj;
    private final int Gk;
    private boolean Gl;
    private boolean Gm;
    private TrackDirection Gn;
    private int Go;
    private final Rect Gp;
    private final Rect Gq;
    private final Paint Gr;
    private int Gs;
    private int Gt;
    private int Gu;
    private boolean Gv;
    private final a Gw;
    private final b Gx;
    private final g Gy;
    private d Gz;

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
        this.Gr.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Gj = (int) ((this.Gh - this.Ge) * (-f2));
            } else if (f2 > 0.0f) {
                this.Gj = (int) ((this.Ge - this.Gi) * f2);
            } else if (f2 == 0.0f) {
                this.Gj = 0;
                this.Go = 10004;
            } else if (f2 == -1.0f) {
                this.Gh -= getMeasuredWidth();
                this.Go = 10000;
            } else if (f2 == 1.0f) {
                this.Gh = getMeasuredWidth() - this.Gi;
                this.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Gh;
    }

    public int getRightOffset() {
        return (int) this.Gi;
    }

    public void setLeftTapBack(boolean z) {
        this.Gl = z;
    }

    public void setRightTapBack(boolean z) {
        this.Gm = z;
    }

    public int getState() {
        return this.Go;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Gz = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.GA = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.GC = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Gj, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.Gj);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Gr);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Gj;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Gn == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Go == 10004) {
            switch (action) {
                case 0:
                    this.Gs = x;
                    this.Gt = y;
                    this.Gw.removeMessages(-100);
                    this.Gw.removeMessages(-104);
                    this.Gw.removeMessages(-101);
                    this.Gw.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Gj, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.Gt - this.Gk && i2 <= this.Gt + this.Gk && (i < this.Gs - this.Gk || i > this.Gs + this.Gk) && this.Gy.aF(i - this.Gs);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Go == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Gv = false;
                    if (this.Gy.GO) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Gy.kI();
                        this.Gy.kJ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Gy.GO) {
                        if (!this.Gv) {
                            if (x > this.Gs) {
                                this.Gu = this.Gs + this.Gk;
                                this.Gv = true;
                            } else {
                                this.Gu = this.Gs - this.Gk;
                                this.Gv = true;
                            }
                        }
                        this.Gy.aG(this.Gu - x);
                        this.Gu = x;
                        this.Gy.GN.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Gp);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Gq);
        switch (action) {
            case 0:
                if ((this.Go != 10000 || !this.Gp.contains(x, y)) && (this.Go != 10001 || !this.Gq.contains(x, y))) {
                    return false;
                }
                if (!this.Gy.GO) {
                    this.Gu = x;
                    this.Gy.aF(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Gy.GO) {
                    this.Gy.kI();
                    this.Gy.kJ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Gy.GO) {
            this.Gy.aG(this.Gu - x);
            this.Gu = x;
            this.Gy.GN.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Gh != -1.0f) {
                this.Gp.set(i, i2, (int) (i + this.Gh), i4);
            }
            if (this.Gi != -1.0f) {
                this.Gq.set((int) (i3 - this.Gi), i2, i3, i4);
            }
        }
        if (!this.Gx.GL && !this.Gy.GO) {
            kw();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Gh) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Gi) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Ge = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw() {
        switch (this.Go) {
            case 10000:
                this.Gj = (int) (this.Gh - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Gj = (int) (getMeasuredWidth() - this.Gi);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Gj = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout GE;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.GE.Gx.GL) {
                switch (message.what) {
                    case -105:
                        this.GE.Gx.kB();
                        return;
                    case -104:
                        this.GE.Gx.kA();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.GE.Gx.kz();
                        return;
                    case -100:
                        this.GE.Gx.ky();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout GE;
        VelocityTracker GN;
        boolean GO;
        final int GP;
        final int GQ;

        boolean aF(int i) {
            switch (this.GE.Gn) {
                case left:
                    if (this.GE.Go != 10004 && this.GE.Go != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.GE.Go != 10004 && this.GE.Go != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.GE.GC != null) {
                        this.GE.GC.aE(i);
                        break;
                    }
                    break;
            }
            this.GN = VelocityTracker.obtain();
            this.GO = true;
            return true;
        }

        void kI() {
            this.GO = false;
        }

        void aG(int i) {
            if (this.GO) {
                int i2 = this.GE.Gj - i;
                switch (this.GE.Gn) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.GE.Gh - this.GE.getMeasuredWidth() && i2 < 0) {
                            this.GE.Gj -= i;
                            this.GE.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.GE.getMeasuredWidth() - this.GE.Gi && i2 > 0) {
                            this.GE.Gj -= i;
                            this.GE.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.GE.Gh - this.GE.getMeasuredWidth() && i2 <= this.GE.getMeasuredWidth() - this.GE.Gi) {
                            this.GE.Gj -= i;
                            this.GE.invalidate();
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
            this.GN.computeCurrentVelocity(this.GP);
            float xVelocity = this.GN.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.GQ);
            } else {
                max = Math.max(xVelocity, this.GQ);
            }
            switch (this.GE.Gn) {
                case left:
                    D(max);
                    break;
                case right:
                    E(max);
                    break;
                case horizontal:
                    C(max);
                    break;
            }
            this.GN.recycle();
            this.GN = null;
        }

        private void C(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.GE.Gj;
            if (i <= 0 && i >= this.GE.Gh - this.GE.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.GE.Gx.A(f);
                } else {
                    this.GE.Gx.y(f);
                }
            } else if (i >= 0 && i <= this.GE.getMeasuredWidth() - this.GE.Gi) {
                if (f < 0.0f) {
                    this.GE.Gx.z(f);
                } else {
                    this.GE.Gx.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.GE.Gx.A(f);
            } else {
                this.GE.Gx.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.GE.Gx.z(f);
            } else {
                this.GE.Gx.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout GE;
        float GF;
        float GG;
        float GH;
        float GI;
        long GJ;
        long GK;
        boolean GL;

        private void kx() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = ((((float) (uptimeMillis - this.GJ)) / 1000.0f) * this.GG) + this.GF;
            this.GJ = uptimeMillis;
            this.GK += 16;
        }

        void ky() {
            kx();
            if (this.GF <= this.GH) {
                d dVar = this.GE.Gz;
                if (dVar != null) {
                    dVar.kD();
                }
                this.GL = false;
                this.GE.Go = 10000;
                this.GE.kw();
                return;
            }
            this.GE.Gj = (int) (com.baidu.adp.widget.e.a(this.GH, this.GF, false) + this.GI);
            this.GE.invalidate();
            this.GE.Gw.sendEmptyMessageAtTime(-100, this.GK);
        }

        void kz() {
            kx();
            if (this.GF >= this.GH) {
                f fVar = this.GE.GA;
                if (fVar != null) {
                    fVar.kH();
                }
                this.GL = false;
                this.GE.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.GE.kw();
                return;
            }
            this.GE.Gj = (int) (com.baidu.adp.widget.e.a(this.GH, this.GF, false) + this.GI);
            this.GE.invalidate();
            this.GE.Gw.sendEmptyMessageAtTime(-101, this.GK);
        }

        void kA() {
            kx();
            if (this.GF >= this.GH) {
                for (e eVar : this.GE.GB) {
                    if (eVar != null) {
                        eVar.kF();
                    }
                }
                this.GL = false;
                this.GE.Go = 10004;
                this.GE.kw();
                return;
            }
            this.GE.Gj = (int) (com.baidu.adp.widget.e.a(this.GH, this.GF, false) + this.GI);
            this.GE.invalidate();
            this.GE.Gw.sendEmptyMessageAtTime(-104, this.GK);
        }

        void kB() {
            kx();
            if (this.GF <= this.GH) {
                for (e eVar : this.GE.GB) {
                    if (eVar != null) {
                        eVar.kF();
                    }
                }
                this.GL = false;
                this.GE.Go = 10004;
                this.GE.kw();
                return;
            }
            this.GE.Gj = (int) (com.baidu.adp.widget.e.a(this.GH, this.GF, false) + this.GI);
            this.GE.invalidate();
            this.GE.Gw.sendEmptyMessageAtTime(-105, this.GK);
        }

        void y(float f) {
            for (e eVar : this.GE.GB) {
                if (eVar != null) {
                    eVar.kE();
                }
            }
            this.GL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = uptimeMillis;
            this.GK = uptimeMillis + 16;
            this.GG = f;
            this.GF = 0.0f;
            this.GH = 0 - this.GE.Gj;
            this.GI = this.GE.Gj;
            this.GE.Gw.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GH);
            BdLog.d("Animator@animateTopOpen " + f);
            this.GE.Gw.sendEmptyMessageAtTime(-104, this.GK);
        }

        void z(float f) {
            for (e eVar : this.GE.GB) {
                if (eVar != null) {
                    eVar.kE();
                }
            }
            this.GL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = uptimeMillis;
            this.GK = uptimeMillis + 16;
            this.GG = f;
            this.GF = 0.0f;
            this.GH = 0 - this.GE.Gj;
            this.GI = this.GE.Gj;
            BdLog.d("Animator@animateBottomOpen " + this.GH);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.GE.Gw.removeMessages(-105);
            this.GE.Gw.sendEmptyMessageAtTime(-105, this.GK);
        }

        void A(float f) {
            d dVar = this.GE.Gz;
            if (dVar != null) {
                dVar.kC();
            }
            this.GL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = uptimeMillis;
            this.GK = uptimeMillis + 16;
            this.GG = f;
            this.GF = 0.0f;
            this.GH = ((-this.GE.getMeasuredWidth()) + this.GE.Gh) - this.GE.Gj;
            this.GI = this.GE.Gj;
            BdLog.d("Animator@animateTop " + this.GH);
            BdLog.d("Animator@animateTop " + f);
            this.GE.Gw.removeMessages(-100);
            this.GE.Gw.sendEmptyMessageAtTime(-100, this.GK);
        }

        void B(float f) {
            f fVar = this.GE.GA;
            if (fVar != null) {
                fVar.kG();
            }
            this.GL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = uptimeMillis;
            this.GK = uptimeMillis + 16;
            this.GG = f;
            this.GF = 0.0f;
            this.GH = (this.GE.getMeasuredWidth() - this.GE.Gi) - this.GE.Gj;
            this.GI = this.GE.Gj;
            BdLog.d("Animator@animateBottom " + this.GH);
            BdLog.d("Animator@animateBottom " + f);
            this.GE.Gw.removeMessages(-101);
            this.GE.Gw.sendEmptyMessageAtTime(-101, this.GK);
        }
    }
}
