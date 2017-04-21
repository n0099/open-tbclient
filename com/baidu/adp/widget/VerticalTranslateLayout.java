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
    private float JE;
    private float JF;
    private float JG;
    private float JH;
    private int JI;
    private boolean JJ;
    private boolean JK;
    private TrackDirection JL;
    private final Rect JM;
    private final Rect JN;
    private int JO;
    private boolean JP;
    private final a JQ;
    private final b JR;
    private final g JS;
    private e JT;
    private c JU;
    private f JV;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (JX) with 'values()' method */
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
        void kK();

        void ma();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kI();

        void kJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kG();

        void mb();
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
        this.Gr.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.JI = (int) ((this.JE - this.Gf) * (-f2));
            } else if (f2 > 0.0f) {
                this.JI = (int) ((this.Gf - this.JG) * f2);
            } else if (f2 == 0.0f) {
                this.JI = 0;
                this.Go = 10004;
            } else if (f2 == -1.0f) {
                this.JE -= this.Gf;
                this.Go = 10000;
            } else if (f2 == 1.0f) {
                this.JE = this.Gf - this.JG;
                this.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.JE;
    }

    public int getBottomOffset() {
        return (int) this.JG;
    }

    public void setTopTapBack(boolean z) {
        this.JJ = z;
    }

    public void setBottomTapBack(boolean z) {
        this.JK = z;
    }

    public int getState() {
        return this.Go;
    }

    public void setTopAnimationListener(e eVar) {
        this.JT = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.JU = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.JV = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.JI);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.JI);
        canvas.drawRect(0.0f, 0.0f, this.Ge, this.Gf, this.Gr);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.JI;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.JL == TrackDirection.none) {
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
                    this.JQ.removeMessages(-100);
                    this.JQ.removeMessages(-104);
                    this.JQ.removeMessages(-101);
                    this.JQ.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.JI);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Gs - this.Gk && i <= this.Gs + this.Gk && (i2 < this.Gt - this.Gk || i2 > this.Gt + this.Gk) && this.JS.aF(i2 - this.Gt);
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
                    this.JP = false;
                    if (this.JS.GN) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.JS.kM();
                        this.JS.kN();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JS.GN) {
                        if (!this.JP) {
                            if (y > this.Gt) {
                                this.JO = this.Gt + this.Gk;
                                this.JP = true;
                            } else {
                                this.JO = this.Gt - this.Gk;
                                this.JP = true;
                            }
                        }
                        this.JS.aG(this.JO - y);
                        this.JO = y;
                        this.JS.GM.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Go != 10000 || !this.JM.contains(x, y)) && (this.Go != 10001 || !this.JN.contains(x, y))) {
                    return false;
                }
                if (!this.JS.GN) {
                    this.JO = y;
                    this.JS.aF(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JS.GN) {
                    this.JS.kM();
                    this.JS.kN();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JS.GN) {
            this.JS.aG(this.JO - y);
            this.JO = y;
            this.JS.GM.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.JE != -1.0f) {
                this.JM.set(i, i2, i3, (int) (i2 + this.JE));
            }
            if (this.JG != -1.0f) {
                this.JN.set(i, (int) (i4 - this.JG), i3, i4);
            }
        }
        if (!this.JR.GK && !this.JS.GN) {
            kA();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.JF != -1.0f) {
            this.JE = i3 - this.JH;
        }
        if (this.JH != -1.0f) {
            this.JG = i3 - this.JF;
        }
        if (!$assertionsDisabled && i3 < this.JE) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.JG) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Ge = getMeasuredWidth();
        this.Gf = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kA() {
        switch (this.Go) {
            case 10000:
                this.JI = (int) (this.JE - this.Gf);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.JI = (int) (this.Gf - this.JG);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.JI = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout JW;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.JW.JR.GK) {
                switch (message.what) {
                    case -105:
                        this.JW.JR.lZ();
                        return;
                    case -104:
                        this.JW.JR.lY();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.JW.JR.lX();
                        return;
                    case -100:
                        this.JW.JR.lW();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] JY;
        VelocityTracker GM;
        boolean GN;
        final int GO;
        final int GP;
        final /* synthetic */ VerticalTranslateLayout JW;

        static /* synthetic */ int[] mc() {
            int[] iArr = JY;
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
                JY = iArr;
            }
            return iArr;
        }

        boolean aF(int i) {
            switch (mc()[this.JW.JL.ordinal()]) {
                case 1:
                    if (this.JW.Go != 10004 && this.JW.Go != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.JW.Go != 10004 && this.JW.Go != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.JW.JV != null) {
                        this.JW.JV.aN(i);
                        break;
                    }
                    break;
            }
            this.GM = VelocityTracker.obtain();
            this.GN = true;
            return true;
        }

        void kM() {
            this.GN = false;
        }

        void aG(int i) {
            if (this.GN) {
                int i2 = this.JW.JI - i;
                switch (mc()[this.JW.JL.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.JW.JE - this.JW.Gf && i2 < 0) {
                            this.JW.JI -= i;
                            this.JW.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.JW.Gf - this.JW.JG && i2 > 0) {
                            this.JW.JI -= i;
                            this.JW.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.JW.JE - this.JW.Gf && i2 <= this.JW.Gf - this.JW.JG) {
                            this.JW.JI -= i;
                            this.JW.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kN() {
            float max;
            this.GM.computeCurrentVelocity(this.GO);
            float yVelocity = this.GM.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.GP);
            } else {
                max = Math.max(yVelocity, this.GP);
            }
            switch (mc()[this.JW.JL.ordinal()]) {
                case 1:
                    O(max);
                    break;
                case 2:
                    P(max);
                    break;
                case 3:
                    N(max);
                    break;
            }
            this.GM.recycle();
            this.GM = null;
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.JW.JI;
            if (i <= 0 && i >= this.JW.JE - this.JW.Gf) {
                if (f < 0.0f) {
                    this.JW.JR.L(f);
                } else {
                    this.JW.JR.J(f);
                }
            } else if (i >= 0 && i <= this.JW.Gf - this.JW.JG) {
                if (f < 0.0f) {
                    this.JW.JR.K(f);
                } else {
                    this.JW.JR.M(f);
                }
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.JW.JR.L(f);
            } else {
                this.JW.JR.J(f);
            }
        }

        private void P(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.JW.JR.K(f);
            } else {
                this.JW.JR.M(f);
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
        final /* synthetic */ VerticalTranslateLayout JW;

        private void kB() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GE = ((((float) (uptimeMillis - this.GI)) / 1000.0f) * this.GF) + this.GE;
            this.GI = uptimeMillis;
            this.GJ += 16;
        }

        void lW() {
            kB();
            if (this.GE <= this.GG) {
                e eVar = this.JW.JT;
                if (eVar != null) {
                    eVar.mb();
                }
                this.GK = false;
                this.JW.Go = 10000;
                this.JW.kA();
                return;
            }
            this.JW.JI = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.JW.invalidate();
            this.JW.JQ.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void lX() {
            kB();
            if (this.GE >= this.GG) {
                c cVar = this.JW.JU;
                if (cVar != null) {
                    cVar.ma();
                }
                this.GK = false;
                this.JW.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.JW.kA();
                return;
            }
            this.JW.JI = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.JW.invalidate();
            this.JW.JQ.sendEmptyMessageAtTime(-101, this.GJ);
        }

        void lY() {
            kB();
            if (this.GE >= this.GG) {
                for (d dVar : this.JW.GB) {
                    if (dVar != null) {
                        dVar.kJ();
                    }
                }
                this.GK = false;
                this.JW.Go = 10004;
                this.JW.kA();
                return;
            }
            this.JW.JI = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.JW.invalidate();
            this.JW.JQ.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void lZ() {
            kB();
            if (this.GE <= this.GG) {
                for (d dVar : this.JW.GB) {
                    if (dVar != null) {
                        dVar.kJ();
                    }
                }
                this.GK = false;
                this.JW.Go = 10004;
                this.JW.kA();
                return;
            }
            this.JW.JI = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.JW.invalidate();
            this.JW.JQ.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void J(float f) {
            for (d dVar : this.JW.GB) {
                if (dVar != null) {
                    dVar.kI();
                }
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = 0 - this.JW.JI;
            this.GH = this.JW.JI;
            this.JW.JQ.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GG);
            BdLog.d("Animator@animateTopOpen " + f);
            this.JW.JQ.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void K(float f) {
            for (d dVar : this.JW.GB) {
                if (dVar != null) {
                    dVar.kI();
                }
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = 0 - this.JW.JI;
            this.GH = this.JW.JI;
            BdLog.d("Animator@animateBottomOpen " + this.GG);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.JW.JQ.removeMessages(-105);
            this.JW.JQ.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void L(float f) {
            e eVar = this.JW.JT;
            if (eVar != null) {
                eVar.kG();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = ((-this.JW.Gf) + this.JW.JE) - this.JW.JI;
            this.GH = this.JW.JI;
            BdLog.d("Animator@animateTop " + this.GG);
            BdLog.d("Animator@animateTop " + f);
            this.JW.JQ.removeMessages(-100);
            this.JW.JQ.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void M(float f) {
            c cVar = this.JW.JU;
            if (cVar != null) {
                cVar.kK();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = (this.JW.Gf - this.JW.JG) - this.JW.JI;
            this.GH = this.JW.JI;
            BdLog.d("Animator@animateBottom " + this.GG);
            BdLog.d("Animator@animateBottom " + f);
            this.JW.JQ.removeMessages(-101);
            this.JW.JQ.sendEmptyMessageAtTime(-101, this.GJ);
        }
    }
}
