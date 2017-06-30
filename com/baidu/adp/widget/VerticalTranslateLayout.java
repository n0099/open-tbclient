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
        none;

        /* JADX DEBUG: Replace access to removed values field (Jc) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TrackDirection[] valuesCustom() {
            TrackDirection[] valuesCustom = values();
            int length = valuesCustom.length;
            TrackDirection[] trackDirectionArr = new TrackDirection[length];
            System.arraycopy(valuesCustom, 0, trackDirectionArr, 0, length);
            return trackDirectionArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void kH();

        void lx();
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

        void ly();
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
                    if (this.IX.GN) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.IX.kJ();
                        this.IX.kK();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.IX.GN) {
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
                        this.IX.GM.addMovement(motionEvent);
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
                if (!this.IX.GN) {
                    this.IS = y;
                    this.IX.aF(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.IX.GN) {
                    this.IX.kJ();
                    this.IX.kK();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.IX.GN) {
            this.IX.aG(this.IS - y);
            this.IS = y;
            this.IX.GM.addMovement(motionEvent);
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
        if (!this.IW.GK && !this.IX.GN) {
            kx();
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
    public void kx() {
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
        final /* synthetic */ VerticalTranslateLayout Jb;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Jb.IW.GK) {
                switch (message.what) {
                    case -105:
                        this.Jb.IW.lw();
                        return;
                    case -104:
                        this.Jb.IW.lv();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Jb.IW.lu();
                        return;
                    case -100:
                        this.Jb.IW.lt();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Jd;
        VelocityTracker GM;
        boolean GN;
        final int GO;
        final int GP;
        final /* synthetic */ VerticalTranslateLayout Jb;

        static /* synthetic */ int[] lz() {
            int[] iArr = Jd;
            if (iArr == null) {
                iArr = new int[TrackDirection.valuesCustom().length];
                try {
                    iArr[TrackDirection.bottom.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[TrackDirection.none.ordinal()] = 4;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[TrackDirection.top.ordinal()] = 1;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[TrackDirection.vertical.ordinal()] = 3;
                } catch (NoSuchFieldError e4) {
                }
                Jd = iArr;
            }
            return iArr;
        }

        boolean aF(int i) {
            switch (lz()[this.Jb.IP.ordinal()]) {
                case 1:
                    if (this.Jb.Go != 10004 && this.Jb.Go != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Jb.Go != 10004 && this.Jb.Go != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Jb.Ja != null) {
                        this.Jb.Ja.aL(i);
                        break;
                    }
                    break;
            }
            this.GM = VelocityTracker.obtain();
            this.GN = true;
            return true;
        }

        void kJ() {
            this.GN = false;
        }

        void aG(int i) {
            if (this.GN) {
                int i2 = this.Jb.IM - i;
                switch (lz()[this.Jb.IP.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Jb.II - this.Jb.Gf && i2 < 0) {
                            this.Jb.IM -= i;
                            this.Jb.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Jb.Gf - this.Jb.IK && i2 > 0) {
                            this.Jb.IM -= i;
                            this.Jb.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Jb.II - this.Jb.Gf && i2 <= this.Jb.Gf - this.Jb.IK) {
                            this.Jb.IM -= i;
                            this.Jb.invalidate();
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
            this.GM.computeCurrentVelocity(this.GO);
            float yVelocity = this.GM.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.GP);
            } else {
                max = Math.max(yVelocity, this.GP);
            }
            switch (lz()[this.Jb.IP.ordinal()]) {
                case 1:
                    N(max);
                    break;
                case 2:
                    O(max);
                    break;
                case 3:
                    M(max);
                    break;
            }
            this.GM.recycle();
            this.GM = null;
        }

        private void M(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.Jb.IM;
            if (i <= 0 && i >= this.Jb.II - this.Jb.Gf) {
                if (f < 0.0f) {
                    this.Jb.IW.K(f);
                } else {
                    this.Jb.IW.I(f);
                }
            } else if (i >= 0 && i <= this.Jb.Gf - this.Jb.IK) {
                if (f < 0.0f) {
                    this.Jb.IW.J(f);
                } else {
                    this.Jb.IW.L(f);
                }
            }
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Jb.IW.K(f);
            } else {
                this.Jb.IW.I(f);
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Jb.IW.J(f);
            } else {
                this.Jb.IW.L(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float GE;
        float GF;
        float GG;
        float GH;
        long GI;
        long GJ;
        boolean GK;
        final /* synthetic */ VerticalTranslateLayout Jb;

        private void ky() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GE = ((((float) (uptimeMillis - this.GI)) / 1000.0f) * this.GF) + this.GE;
            this.GI = uptimeMillis;
            this.GJ += 16;
        }

        void lt() {
            ky();
            if (this.GE <= this.GG) {
                e eVar = this.Jb.IY;
                if (eVar != null) {
                    eVar.ly();
                }
                this.GK = false;
                this.Jb.Go = 10000;
                this.Jb.kx();
                return;
            }
            this.Jb.IM = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jb.invalidate();
            this.Jb.IU.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void lu() {
            ky();
            if (this.GE >= this.GG) {
                c cVar = this.Jb.IZ;
                if (cVar != null) {
                    cVar.lx();
                }
                this.GK = false;
                this.Jb.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Jb.kx();
                return;
            }
            this.Jb.IM = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jb.invalidate();
            this.Jb.IU.sendEmptyMessageAtTime(-101, this.GJ);
        }

        void lv() {
            ky();
            if (this.GE >= this.GG) {
                for (d dVar : this.Jb.GB) {
                    if (dVar != null) {
                        dVar.kG();
                    }
                }
                this.GK = false;
                this.Jb.Go = 10004;
                this.Jb.kx();
                return;
            }
            this.Jb.IM = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jb.invalidate();
            this.Jb.IU.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void lw() {
            ky();
            if (this.GE <= this.GG) {
                for (d dVar : this.Jb.GB) {
                    if (dVar != null) {
                        dVar.kG();
                    }
                }
                this.GK = false;
                this.Jb.Go = 10004;
                this.Jb.kx();
                return;
            }
            this.Jb.IM = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jb.invalidate();
            this.Jb.IU.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void I(float f) {
            for (d dVar : this.Jb.GB) {
                if (dVar != null) {
                    dVar.kF();
                }
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = 0 - this.Jb.IM;
            this.GH = this.Jb.IM;
            this.Jb.IU.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GG);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Jb.IU.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void J(float f) {
            for (d dVar : this.Jb.GB) {
                if (dVar != null) {
                    dVar.kF();
                }
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = 0 - this.Jb.IM;
            this.GH = this.Jb.IM;
            BdLog.d("Animator@animateBottomOpen " + this.GG);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Jb.IU.removeMessages(-105);
            this.Jb.IU.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void K(float f) {
            e eVar = this.Jb.IY;
            if (eVar != null) {
                eVar.kD();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = ((-this.Jb.Gf) + this.Jb.II) - this.Jb.IM;
            this.GH = this.Jb.IM;
            BdLog.d("Animator@animateTop " + this.GG);
            BdLog.d("Animator@animateTop " + f);
            this.Jb.IU.removeMessages(-100);
            this.Jb.IU.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void L(float f) {
            c cVar = this.Jb.IZ;
            if (cVar != null) {
                cVar.kH();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = (this.Jb.Gf - this.Jb.IK) - this.Jb.IM;
            this.GH = this.Jb.IM;
            BdLog.d("Animator@animateBottom " + this.GG);
            BdLog.d("Animator@animateBottom " + f);
            this.Jb.IU.removeMessages(-101);
            this.Jb.IU.sendEmptyMessageAtTime(-101, this.GJ);
        }
    }
}
