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
    private final List<d> GB;
    private int Ge;
    private int Gf;
    private final int Gk;
    private int Go;
    private final Paint Gr;
    private int Gs;
    private int Gt;
    private float II;
    private float IJ;
    private float IK;
    private float IL;
    private int IM;
    private boolean IN;
    private boolean IO;
    private TrackDirection IP;
    private final Rect IQ;
    private final Rect IR;
    private int IS;
    private boolean IT;
    private final a IU;
    private final b IW;
    private final g IX;
    private e IY;
    private c IZ;
    private f Ja;

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

        void lv();
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

        void lw();
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
        this.Gr.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.IM = (int) ((this.II - this.Gf) * (-f2));
            } else if (f2 > 0.0f) {
                this.IM = (int) ((this.Gf - this.IK) * f2);
            } else if (f2 == 0.0f) {
                this.IM = 0;
                this.Go = 10004;
            } else if (f2 == -1.0f) {
                this.II -= this.Gf;
                this.Go = 10000;
            } else if (f2 == 1.0f) {
                this.II = this.Gf - this.IK;
                this.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.II;
    }

    public int getBottomOffset() {
        return (int) this.IK;
    }

    public void setTopTapBack(boolean z) {
        this.IN = z;
    }

    public void setBottomTapBack(boolean z) {
        this.IO = z;
    }

    public int getState() {
        return this.Go;
    }

    public void setTopAnimationListener(e eVar) {
        this.IY = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.IZ = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Ja = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.IM);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.IM);
        canvas.drawRect(0.0f, 0.0f, this.Ge, this.Gf, this.Gr);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.IM;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.IP == TrackDirection.none) {
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
                    this.IU.removeMessages(-100);
                    this.IU.removeMessages(-104);
                    this.IU.removeMessages(-101);
                    this.IU.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.IM);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Gs - this.Gk && i <= this.Gs + this.Gk && (i2 < this.Gt - this.Gk || i2 > this.Gt + this.Gk) && this.IX.aF(i2 - this.Gt);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.IT = false;
                    if (this.IX.GO) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.IX.kI();
                        this.IX.kJ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.IX.GO) {
                        if (!this.IT) {
                            if (y > this.Gt) {
                                this.IS = this.Gt + this.Gk;
                                this.IT = true;
                            } else {
                                this.IS = this.Gt - this.Gk;
                                this.IT = true;
                            }
                        }
                        this.IX.aG(this.IS - y);
                        this.IS = y;
                        this.IX.GN.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Go != 10000 || !this.IQ.contains(x, y)) && (this.Go != 10001 || !this.IR.contains(x, y))) {
                    return false;
                }
                if (!this.IX.GO) {
                    this.IS = y;
                    this.IX.aF(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.IX.GO) {
                    this.IX.kI();
                    this.IX.kJ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.IX.GO) {
            this.IX.aG(this.IS - y);
            this.IS = y;
            this.IX.GN.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.II != -1.0f) {
                this.IQ.set(i, i2, i3, (int) (i2 + this.II));
            }
            if (this.IK != -1.0f) {
                this.IR.set(i, (int) (i4 - this.IK), i3, i4);
            }
        }
        if (!this.IW.GL && !this.IX.GO) {
            kw();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.IJ != -1.0f) {
            this.II = i3 - this.IL;
        }
        if (this.IL != -1.0f) {
            this.IK = i3 - this.IJ;
        }
        if (!$assertionsDisabled && i3 < this.II) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.IK) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Ge = getMeasuredWidth();
        this.Gf = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw() {
        switch (this.Go) {
            case 10000:
                this.IM = (int) (this.II - this.Gf);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.IM = (int) (this.Gf - this.IK);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.IM = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Jc;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Jc.IW.GL) {
                switch (message.what) {
                    case -105:
                        this.Jc.IW.lu();
                        return;
                    case -104:
                        this.Jc.IW.lt();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Jc.IW.ls();
                        return;
                    case -100:
                        this.Jc.IW.lr();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker GN;
        boolean GO;
        final int GP;
        final int GQ;
        final /* synthetic */ VerticalTranslateLayout Jc;

        boolean aF(int i) {
            switch (this.Jc.IP) {
                case top:
                    if (this.Jc.Go != 10004 && this.Jc.Go != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.Jc.Go != 10004 && this.Jc.Go != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.Jc.Ja != null) {
                        this.Jc.Ja.aL(i);
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
                int i2 = this.Jc.IM - i;
                switch (this.Jc.IP) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Jc.II - this.Jc.Gf && i2 < 0) {
                            this.Jc.IM -= i;
                            this.Jc.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Jc.Gf - this.Jc.IK && i2 > 0) {
                            this.Jc.IM -= i;
                            this.Jc.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Jc.II - this.Jc.Gf && i2 <= this.Jc.Gf - this.Jc.IK) {
                            this.Jc.IM -= i;
                            this.Jc.invalidate();
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
            float yVelocity = this.GN.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.GQ);
            } else {
                max = Math.max(yVelocity, this.GQ);
            }
            switch (this.Jc.IP) {
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
            this.GN.recycle();
            this.GN = null;
        }

        private void M(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.Jc.IM;
            if (i <= 0 && i >= this.Jc.II - this.Jc.Gf) {
                if (f < 0.0f) {
                    this.Jc.IW.K(f);
                } else {
                    this.Jc.IW.I(f);
                }
            } else if (i >= 0 && i <= this.Jc.Gf - this.Jc.IK) {
                if (f < 0.0f) {
                    this.Jc.IW.J(f);
                } else {
                    this.Jc.IW.L(f);
                }
            }
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Jc.IW.K(f);
            } else {
                this.Jc.IW.I(f);
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Jc.IW.J(f);
            } else {
                this.Jc.IW.L(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float GF;
        float GG;
        float GH;
        float GI;
        long GJ;
        long GK;
        boolean GL;
        final /* synthetic */ VerticalTranslateLayout Jc;

        private void kx() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = ((((float) (uptimeMillis - this.GJ)) / 1000.0f) * this.GG) + this.GF;
            this.GJ = uptimeMillis;
            this.GK += 16;
        }

        void lr() {
            kx();
            if (this.GF <= this.GH) {
                e eVar = this.Jc.IY;
                if (eVar != null) {
                    eVar.lw();
                }
                this.GL = false;
                this.Jc.Go = 10000;
                this.Jc.kw();
                return;
            }
            this.Jc.IM = (int) (com.baidu.adp.widget.a.a(this.GH, this.GF, false) + this.GI);
            this.Jc.invalidate();
            this.Jc.IU.sendEmptyMessageAtTime(-100, this.GK);
        }

        void ls() {
            kx();
            if (this.GF >= this.GH) {
                c cVar = this.Jc.IZ;
                if (cVar != null) {
                    cVar.lv();
                }
                this.GL = false;
                this.Jc.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Jc.kw();
                return;
            }
            this.Jc.IM = (int) (com.baidu.adp.widget.a.a(this.GH, this.GF, false) + this.GI);
            this.Jc.invalidate();
            this.Jc.IU.sendEmptyMessageAtTime(-101, this.GK);
        }

        void lt() {
            kx();
            if (this.GF >= this.GH) {
                for (d dVar : this.Jc.GB) {
                    if (dVar != null) {
                        dVar.kF();
                    }
                }
                this.GL = false;
                this.Jc.Go = 10004;
                this.Jc.kw();
                return;
            }
            this.Jc.IM = (int) (com.baidu.adp.widget.a.a(this.GH, this.GF, false) + this.GI);
            this.Jc.invalidate();
            this.Jc.IU.sendEmptyMessageAtTime(-104, this.GK);
        }

        void lu() {
            kx();
            if (this.GF <= this.GH) {
                for (d dVar : this.Jc.GB) {
                    if (dVar != null) {
                        dVar.kF();
                    }
                }
                this.GL = false;
                this.Jc.Go = 10004;
                this.Jc.kw();
                return;
            }
            this.Jc.IM = (int) (com.baidu.adp.widget.a.a(this.GH, this.GF, false) + this.GI);
            this.Jc.invalidate();
            this.Jc.IU.sendEmptyMessageAtTime(-105, this.GK);
        }

        void I(float f) {
            for (d dVar : this.Jc.GB) {
                if (dVar != null) {
                    dVar.kE();
                }
            }
            this.GL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = uptimeMillis;
            this.GK = uptimeMillis + 16;
            this.GG = f;
            this.GF = 0.0f;
            this.GH = 0 - this.Jc.IM;
            this.GI = this.Jc.IM;
            this.Jc.IU.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GH);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Jc.IU.sendEmptyMessageAtTime(-104, this.GK);
        }

        void J(float f) {
            for (d dVar : this.Jc.GB) {
                if (dVar != null) {
                    dVar.kE();
                }
            }
            this.GL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = uptimeMillis;
            this.GK = uptimeMillis + 16;
            this.GG = f;
            this.GF = 0.0f;
            this.GH = 0 - this.Jc.IM;
            this.GI = this.Jc.IM;
            BdLog.d("Animator@animateBottomOpen " + this.GH);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Jc.IU.removeMessages(-105);
            this.Jc.IU.sendEmptyMessageAtTime(-105, this.GK);
        }

        void K(float f) {
            e eVar = this.Jc.IY;
            if (eVar != null) {
                eVar.kC();
            }
            this.GL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = uptimeMillis;
            this.GK = uptimeMillis + 16;
            this.GG = f;
            this.GF = 0.0f;
            this.GH = ((-this.Jc.Gf) + this.Jc.II) - this.Jc.IM;
            this.GI = this.Jc.IM;
            BdLog.d("Animator@animateTop " + this.GH);
            BdLog.d("Animator@animateTop " + f);
            this.Jc.IU.removeMessages(-100);
            this.Jc.IU.sendEmptyMessageAtTime(-100, this.GK);
        }

        void L(float f) {
            c cVar = this.Jc.IZ;
            if (cVar != null) {
                cVar.kG();
            }
            this.GL = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GJ = uptimeMillis;
            this.GK = uptimeMillis + 16;
            this.GG = f;
            this.GF = 0.0f;
            this.GH = (this.Jc.Gf - this.Jc.IK) - this.Jc.IM;
            this.GI = this.Jc.IM;
            BdLog.d("Animator@animateBottom " + this.GH);
            BdLog.d("Animator@animateBottom " + f);
            this.Jc.IU.removeMessages(-101);
            this.Jc.IU.sendEmptyMessageAtTime(-101, this.GK);
        }
    }
}
