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
    private int Gb;
    private int Gc;
    private final int Gh;
    private int Gl;
    private final Paint Go;
    private int Gp;
    private int Gq;
    private final List<d> Gy;
    private float JC;
    private float JD;
    private float JE;
    private float JF;
    private int JG;
    private boolean JH;
    private boolean JI;
    private TrackDirection JJ;
    private final Rect JK;
    private final Rect JL;
    private int JM;
    private boolean JN;
    private final a JO;
    private final b JP;
    private final g JQ;
    private e JR;
    private c JS;
    private f JT;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (JV) with 'values()' method */
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

        void lZ();
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

        void ma();
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
        this.Go.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.JG = (int) ((this.JC - this.Gc) * (-f2));
            } else if (f2 > 0.0f) {
                this.JG = (int) ((this.Gc - this.JE) * f2);
            } else if (f2 == 0.0f) {
                this.JG = 0;
                this.Gl = 10004;
            } else if (f2 == -1.0f) {
                this.JC -= this.Gc;
                this.Gl = 10000;
            } else if (f2 == 1.0f) {
                this.JC = this.Gc - this.JE;
                this.Gl = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.JC;
    }

    public int getBottomOffset() {
        return (int) this.JE;
    }

    public void setTopTapBack(boolean z) {
        this.JH = z;
    }

    public void setBottomTapBack(boolean z) {
        this.JI = z;
    }

    public int getState() {
        return this.Gl;
    }

    public void setTopAnimationListener(e eVar) {
        this.JR = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.JS = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.JT = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.JG);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.JG);
        canvas.drawRect(0.0f, 0.0f, this.Gb, this.Gc, this.Go);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.JG;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.JJ == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Gl == 10004) {
            switch (action) {
                case 0:
                    this.Gp = x;
                    this.Gq = y;
                    this.JO.removeMessages(-100);
                    this.JO.removeMessages(-104);
                    this.JO.removeMessages(-101);
                    this.JO.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.JG);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Gp - this.Gh && i <= this.Gp + this.Gh && (i2 < this.Gq - this.Gh || i2 > this.Gq + this.Gh) && this.JQ.aF(i2 - this.Gq);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Gl == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.JN = false;
                    if (this.JQ.GK) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.JQ.kL();
                        this.JQ.kM();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JQ.GK) {
                        if (!this.JN) {
                            if (y > this.Gq) {
                                this.JM = this.Gq + this.Gh;
                                this.JN = true;
                            } else {
                                this.JM = this.Gq - this.Gh;
                                this.JN = true;
                            }
                        }
                        this.JQ.aG(this.JM - y);
                        this.JM = y;
                        this.JQ.GJ.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Gl != 10000 || !this.JK.contains(x, y)) && (this.Gl != 10001 || !this.JL.contains(x, y))) {
                    return false;
                }
                if (!this.JQ.GK) {
                    this.JM = y;
                    this.JQ.aF(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JQ.GK) {
                    this.JQ.kL();
                    this.JQ.kM();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JQ.GK) {
            this.JQ.aG(this.JM - y);
            this.JM = y;
            this.JQ.GJ.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.JC != -1.0f) {
                this.JK.set(i, i2, i3, (int) (i2 + this.JC));
            }
            if (this.JE != -1.0f) {
                this.JL.set(i, (int) (i4 - this.JE), i3, i4);
            }
        }
        if (!this.JP.GH && !this.JQ.GK) {
            kz();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.JD != -1.0f) {
            this.JC = i3 - this.JF;
        }
        if (this.JF != -1.0f) {
            this.JE = i3 - this.JD;
        }
        if (!$assertionsDisabled && i3 < this.JC) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.JE) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Gb = getMeasuredWidth();
        this.Gc = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz() {
        switch (this.Gl) {
            case 10000:
                this.JG = (int) (this.JC - this.Gc);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.JG = (int) (this.Gc - this.JE);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.JG = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout JU;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.JU.JP.GH) {
                switch (message.what) {
                    case -105:
                        this.JU.JP.lY();
                        return;
                    case -104:
                        this.JU.JP.lX();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.JU.JP.lW();
                        return;
                    case -100:
                        this.JU.JP.lV();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] JW;
        VelocityTracker GJ;
        boolean GK;
        final int GL;
        final int GM;
        final /* synthetic */ VerticalTranslateLayout JU;

        static /* synthetic */ int[] mb() {
            int[] iArr = JW;
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
                JW = iArr;
            }
            return iArr;
        }

        boolean aF(int i) {
            switch (mb()[this.JU.JJ.ordinal()]) {
                case 1:
                    if (this.JU.Gl != 10004 && this.JU.Gl != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.JU.Gl != 10004 && this.JU.Gl != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.JU.JT != null) {
                        this.JU.JT.aN(i);
                        break;
                    }
                    break;
            }
            this.GJ = VelocityTracker.obtain();
            this.GK = true;
            return true;
        }

        void kL() {
            this.GK = false;
        }

        void aG(int i) {
            if (this.GK) {
                int i2 = this.JU.JG - i;
                switch (mb()[this.JU.JJ.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.JU.JC - this.JU.Gc && i2 < 0) {
                            this.JU.JG -= i;
                            this.JU.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.JU.Gc - this.JU.JE && i2 > 0) {
                            this.JU.JG -= i;
                            this.JU.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.JU.JC - this.JU.Gc && i2 <= this.JU.Gc - this.JU.JE) {
                            this.JU.JG -= i;
                            this.JU.invalidate();
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
            this.GJ.computeCurrentVelocity(this.GL);
            float yVelocity = this.GJ.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.GM);
            } else {
                max = Math.max(yVelocity, this.GM);
            }
            switch (mb()[this.JU.JJ.ordinal()]) {
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
            this.GJ.recycle();
            this.GJ = null;
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.JU.JG;
            if (i <= 0 && i >= this.JU.JC - this.JU.Gc) {
                if (f < 0.0f) {
                    this.JU.JP.L(f);
                } else {
                    this.JU.JP.J(f);
                }
            } else if (i >= 0 && i <= this.JU.Gc - this.JU.JE) {
                if (f < 0.0f) {
                    this.JU.JP.K(f);
                } else {
                    this.JU.JP.M(f);
                }
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.JU.JP.L(f);
            } else {
                this.JU.JP.J(f);
            }
        }

        private void P(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.JU.JP.K(f);
            } else {
                this.JU.JP.M(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float GB;
        float GC;
        float GD;
        float GE;
        long GF;
        long GG;
        boolean GH;
        final /* synthetic */ VerticalTranslateLayout JU;

        private void kA() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GB = ((((float) (uptimeMillis - this.GF)) / 1000.0f) * this.GC) + this.GB;
            this.GF = uptimeMillis;
            this.GG += 16;
        }

        void lV() {
            kA();
            if (this.GB <= this.GD) {
                e eVar = this.JU.JR;
                if (eVar != null) {
                    eVar.ma();
                }
                this.GH = false;
                this.JU.Gl = 10000;
                this.JU.kz();
                return;
            }
            this.JU.JG = (int) (com.baidu.adp.widget.a.a(this.GD, this.GB, false) + this.GE);
            this.JU.invalidate();
            this.JU.JO.sendEmptyMessageAtTime(-100, this.GG);
        }

        void lW() {
            kA();
            if (this.GB >= this.GD) {
                c cVar = this.JU.JS;
                if (cVar != null) {
                    cVar.lZ();
                }
                this.GH = false;
                this.JU.Gl = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.JU.kz();
                return;
            }
            this.JU.JG = (int) (com.baidu.adp.widget.a.a(this.GD, this.GB, false) + this.GE);
            this.JU.invalidate();
            this.JU.JO.sendEmptyMessageAtTime(-101, this.GG);
        }

        void lX() {
            kA();
            if (this.GB >= this.GD) {
                for (d dVar : this.JU.Gy) {
                    if (dVar != null) {
                        dVar.kI();
                    }
                }
                this.GH = false;
                this.JU.Gl = 10004;
                this.JU.kz();
                return;
            }
            this.JU.JG = (int) (com.baidu.adp.widget.a.a(this.GD, this.GB, false) + this.GE);
            this.JU.invalidate();
            this.JU.JO.sendEmptyMessageAtTime(-104, this.GG);
        }

        void lY() {
            kA();
            if (this.GB <= this.GD) {
                for (d dVar : this.JU.Gy) {
                    if (dVar != null) {
                        dVar.kI();
                    }
                }
                this.GH = false;
                this.JU.Gl = 10004;
                this.JU.kz();
                return;
            }
            this.JU.JG = (int) (com.baidu.adp.widget.a.a(this.GD, this.GB, false) + this.GE);
            this.JU.invalidate();
            this.JU.JO.sendEmptyMessageAtTime(-105, this.GG);
        }

        void J(float f) {
            for (d dVar : this.JU.Gy) {
                if (dVar != null) {
                    dVar.kH();
                }
            }
            this.GH = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = uptimeMillis;
            this.GG = uptimeMillis + 16;
            this.GC = f;
            this.GB = 0.0f;
            this.GD = 0 - this.JU.JG;
            this.GE = this.JU.JG;
            this.JU.JO.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GD);
            BdLog.d("Animator@animateTopOpen " + f);
            this.JU.JO.sendEmptyMessageAtTime(-104, this.GG);
        }

        void K(float f) {
            for (d dVar : this.JU.Gy) {
                if (dVar != null) {
                    dVar.kH();
                }
            }
            this.GH = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = uptimeMillis;
            this.GG = uptimeMillis + 16;
            this.GC = f;
            this.GB = 0.0f;
            this.GD = 0 - this.JU.JG;
            this.GE = this.JU.JG;
            BdLog.d("Animator@animateBottomOpen " + this.GD);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.JU.JO.removeMessages(-105);
            this.JU.JO.sendEmptyMessageAtTime(-105, this.GG);
        }

        void L(float f) {
            e eVar = this.JU.JR;
            if (eVar != null) {
                eVar.kF();
            }
            this.GH = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = uptimeMillis;
            this.GG = uptimeMillis + 16;
            this.GC = f;
            this.GB = 0.0f;
            this.GD = ((-this.JU.Gc) + this.JU.JC) - this.JU.JG;
            this.GE = this.JU.JG;
            BdLog.d("Animator@animateTop " + this.GD);
            BdLog.d("Animator@animateTop " + f);
            this.JU.JO.removeMessages(-100);
            this.JU.JO.sendEmptyMessageAtTime(-100, this.GG);
        }

        void M(float f) {
            c cVar = this.JU.JS;
            if (cVar != null) {
                cVar.kJ();
            }
            this.GH = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = uptimeMillis;
            this.GG = uptimeMillis + 16;
            this.GC = f;
            this.GB = 0.0f;
            this.GD = (this.JU.Gc - this.JU.JE) - this.JU.JG;
            this.GE = this.JU.JG;
            BdLog.d("Animator@animateBottom " + this.GD);
            BdLog.d("Animator@animateBottom " + f);
            this.JU.JO.removeMessages(-101);
            this.JU.JO.sendEmptyMessageAtTime(-101, this.GG);
        }
    }
}
