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
    private float IJ;
    private float IK;
    private float IL;
    private float IM;
    private int IN;
    private boolean IO;
    private boolean IP;
    private TrackDirection IQ;
    private final Rect IR;
    private final Rect IS;
    private int IT;
    private boolean IU;
    private final a IW;
    private final b IX;
    private final g IY;
    private e IZ;
    private c Ja;
    private f Jb;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (Jd) with 'values()' method */
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
        void kJ();

        void lz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kH();

        void kI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kF();

        void lA();
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
                this.IN = (int) ((this.IJ - this.Gf) * (-f2));
            } else if (f2 > 0.0f) {
                this.IN = (int) ((this.Gf - this.IL) * f2);
            } else if (f2 == 0.0f) {
                this.IN = 0;
                this.Go = 10004;
            } else if (f2 == -1.0f) {
                this.IJ -= this.Gf;
                this.Go = 10000;
            } else if (f2 == 1.0f) {
                this.IJ = this.Gf - this.IL;
                this.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.IJ;
    }

    public int getBottomOffset() {
        return (int) this.IL;
    }

    public void setTopTapBack(boolean z) {
        this.IO = z;
    }

    public void setBottomTapBack(boolean z) {
        this.IP = z;
    }

    public int getState() {
        return this.Go;
    }

    public void setTopAnimationListener(e eVar) {
        this.IZ = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Ja = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Jb = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.IN);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.IN);
        canvas.drawRect(0.0f, 0.0f, this.Ge, this.Gf, this.Gr);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.IN;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.IQ == TrackDirection.none) {
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
                    this.IW.removeMessages(-100);
                    this.IW.removeMessages(-104);
                    this.IW.removeMessages(-101);
                    this.IW.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.IN);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Gs - this.Gk && i <= this.Gs + this.Gk && (i2 < this.Gt - this.Gk || i2 > this.Gt + this.Gk) && this.IY.aF(i2 - this.Gt);
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
                    this.IU = false;
                    if (this.IY.GN) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.IY.kL();
                        this.IY.kM();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.IY.GN) {
                        if (!this.IU) {
                            if (y > this.Gt) {
                                this.IT = this.Gt + this.Gk;
                                this.IU = true;
                            } else {
                                this.IT = this.Gt - this.Gk;
                                this.IU = true;
                            }
                        }
                        this.IY.aG(this.IT - y);
                        this.IT = y;
                        this.IY.GM.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Go != 10000 || !this.IR.contains(x, y)) && (this.Go != 10001 || !this.IS.contains(x, y))) {
                    return false;
                }
                if (!this.IY.GN) {
                    this.IT = y;
                    this.IY.aF(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.IY.GN) {
                    this.IY.kL();
                    this.IY.kM();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.IY.GN) {
            this.IY.aG(this.IT - y);
            this.IT = y;
            this.IY.GM.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.IJ != -1.0f) {
                this.IR.set(i, i2, i3, (int) (i2 + this.IJ));
            }
            if (this.IL != -1.0f) {
                this.IS.set(i, (int) (i4 - this.IL), i3, i4);
            }
        }
        if (!this.IX.GK && !this.IY.GN) {
            kz();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.IK != -1.0f) {
            this.IJ = i3 - this.IM;
        }
        if (this.IM != -1.0f) {
            this.IL = i3 - this.IK;
        }
        if (!$assertionsDisabled && i3 < this.IJ) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.IL) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Ge = getMeasuredWidth();
        this.Gf = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz() {
        switch (this.Go) {
            case 10000:
                this.IN = (int) (this.IJ - this.Gf);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.IN = (int) (this.Gf - this.IL);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.IN = 0;
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
            if (this.Jc.IX.GK) {
                switch (message.what) {
                    case -105:
                        this.Jc.IX.ly();
                        return;
                    case -104:
                        this.Jc.IX.lx();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Jc.IX.lw();
                        return;
                    case -100:
                        this.Jc.IX.lv();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Je;
        VelocityTracker GM;
        boolean GN;
        final int GO;
        final int GP;
        final /* synthetic */ VerticalTranslateLayout Jc;

        static /* synthetic */ int[] lB() {
            int[] iArr = Je;
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
                Je = iArr;
            }
            return iArr;
        }

        boolean aF(int i) {
            switch (lB()[this.Jc.IQ.ordinal()]) {
                case 1:
                    if (this.Jc.Go != 10004 && this.Jc.Go != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Jc.Go != 10004 && this.Jc.Go != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Jc.Jb != null) {
                        this.Jc.Jb.aL(i);
                        break;
                    }
                    break;
            }
            this.GM = VelocityTracker.obtain();
            this.GN = true;
            return true;
        }

        void kL() {
            this.GN = false;
        }

        void aG(int i) {
            if (this.GN) {
                int i2 = this.Jc.IN - i;
                switch (lB()[this.Jc.IQ.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Jc.IJ - this.Jc.Gf && i2 < 0) {
                            this.Jc.IN -= i;
                            this.Jc.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Jc.Gf - this.Jc.IL && i2 > 0) {
                            this.Jc.IN -= i;
                            this.Jc.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Jc.IJ - this.Jc.Gf && i2 <= this.Jc.Gf - this.Jc.IL) {
                            this.Jc.IN -= i;
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
        public void kM() {
            float max;
            this.GM.computeCurrentVelocity(this.GO);
            float yVelocity = this.GM.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.GP);
            } else {
                max = Math.max(yVelocity, this.GP);
            }
            switch (lB()[this.Jc.IQ.ordinal()]) {
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
            int i = this.Jc.IN;
            if (i <= 0 && i >= this.Jc.IJ - this.Jc.Gf) {
                if (f < 0.0f) {
                    this.Jc.IX.K(f);
                } else {
                    this.Jc.IX.I(f);
                }
            } else if (i >= 0 && i <= this.Jc.Gf - this.Jc.IL) {
                if (f < 0.0f) {
                    this.Jc.IX.J(f);
                } else {
                    this.Jc.IX.L(f);
                }
            }
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Jc.IX.K(f);
            } else {
                this.Jc.IX.I(f);
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Jc.IX.J(f);
            } else {
                this.Jc.IX.L(f);
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
        final /* synthetic */ VerticalTranslateLayout Jc;

        private void kA() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GE = ((((float) (uptimeMillis - this.GI)) / 1000.0f) * this.GF) + this.GE;
            this.GI = uptimeMillis;
            this.GJ += 16;
        }

        void lv() {
            kA();
            if (this.GE <= this.GG) {
                e eVar = this.Jc.IZ;
                if (eVar != null) {
                    eVar.lA();
                }
                this.GK = false;
                this.Jc.Go = 10000;
                this.Jc.kz();
                return;
            }
            this.Jc.IN = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jc.invalidate();
            this.Jc.IW.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void lw() {
            kA();
            if (this.GE >= this.GG) {
                c cVar = this.Jc.Ja;
                if (cVar != null) {
                    cVar.lz();
                }
                this.GK = false;
                this.Jc.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Jc.kz();
                return;
            }
            this.Jc.IN = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jc.invalidate();
            this.Jc.IW.sendEmptyMessageAtTime(-101, this.GJ);
        }

        void lx() {
            kA();
            if (this.GE >= this.GG) {
                for (d dVar : this.Jc.GB) {
                    if (dVar != null) {
                        dVar.kI();
                    }
                }
                this.GK = false;
                this.Jc.Go = 10004;
                this.Jc.kz();
                return;
            }
            this.Jc.IN = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jc.invalidate();
            this.Jc.IW.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void ly() {
            kA();
            if (this.GE <= this.GG) {
                for (d dVar : this.Jc.GB) {
                    if (dVar != null) {
                        dVar.kI();
                    }
                }
                this.GK = false;
                this.Jc.Go = 10004;
                this.Jc.kz();
                return;
            }
            this.Jc.IN = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jc.invalidate();
            this.Jc.IW.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void I(float f) {
            for (d dVar : this.Jc.GB) {
                if (dVar != null) {
                    dVar.kH();
                }
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = 0 - this.Jc.IN;
            this.GH = this.Jc.IN;
            this.Jc.IW.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GG);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Jc.IW.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void J(float f) {
            for (d dVar : this.Jc.GB) {
                if (dVar != null) {
                    dVar.kH();
                }
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = 0 - this.Jc.IN;
            this.GH = this.Jc.IN;
            BdLog.d("Animator@animateBottomOpen " + this.GG);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Jc.IW.removeMessages(-105);
            this.Jc.IW.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void K(float f) {
            e eVar = this.Jc.IZ;
            if (eVar != null) {
                eVar.kF();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = ((-this.Jc.Gf) + this.Jc.IJ) - this.Jc.IN;
            this.GH = this.Jc.IN;
            BdLog.d("Animator@animateTop " + this.GG);
            BdLog.d("Animator@animateTop " + f);
            this.Jc.IW.removeMessages(-100);
            this.Jc.IW.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void L(float f) {
            c cVar = this.Jc.Ja;
            if (cVar != null) {
                cVar.kJ();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = (this.Jc.Gf - this.Jc.IL) - this.Jc.IN;
            this.GH = this.Jc.IN;
            BdLog.d("Animator@animateBottom " + this.GG);
            BdLog.d("Animator@animateBottom " + f);
            this.Jc.IW.removeMessages(-101);
            this.Jc.IW.sendEmptyMessageAtTime(-101, this.GJ);
        }
    }
}
