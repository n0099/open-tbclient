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
    private float IW;
    private float IX;
    private float IY;
    private float IZ;
    private int Ja;
    private boolean Jb;
    private boolean Jc;
    private TrackDirection Jd;
    private final Rect Je;
    private final Rect Jf;
    private int Jg;
    private boolean Jh;
    private final a Ji;
    private final b Jj;
    private final g Jk;
    private e Jl;
    private c Jm;
    private f Jn;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (Jp) with 'values()' method */
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

        void lH();
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

        void lI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aK(int i);
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
                this.Ja = (int) ((this.IW - this.Gf) * (-f2));
            } else if (f2 > 0.0f) {
                this.Ja = (int) ((this.Gf - this.IY) * f2);
            } else if (f2 == 0.0f) {
                this.Ja = 0;
                this.Go = 10004;
            } else if (f2 == -1.0f) {
                this.IW -= this.Gf;
                this.Go = 10000;
            } else if (f2 == 1.0f) {
                this.IW = this.Gf - this.IY;
                this.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.IW;
    }

    public int getBottomOffset() {
        return (int) this.IY;
    }

    public void setTopTapBack(boolean z) {
        this.Jb = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Jc = z;
    }

    public int getState() {
        return this.Go;
    }

    public void setTopAnimationListener(e eVar) {
        this.Jl = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Jm = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Jn = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Ja);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Ja);
        canvas.drawRect(0.0f, 0.0f, this.Ge, this.Gf, this.Gr);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Ja;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Jd == TrackDirection.none) {
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
                    this.Ji.removeMessages(-100);
                    this.Ji.removeMessages(-104);
                    this.Ji.removeMessages(-101);
                    this.Ji.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Ja);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Gs - this.Gk && i <= this.Gs + this.Gk && (i2 < this.Gt - this.Gk || i2 > this.Gt + this.Gk) && this.Jk.aE(i2 - this.Gt);
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
                    this.Jh = false;
                    if (this.Jk.GN) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Jk.kL();
                        this.Jk.kM();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Jk.GN) {
                        if (!this.Jh) {
                            if (y > this.Gt) {
                                this.Jg = this.Gt + this.Gk;
                                this.Jh = true;
                            } else {
                                this.Jg = this.Gt - this.Gk;
                                this.Jh = true;
                            }
                        }
                        this.Jk.aF(this.Jg - y);
                        this.Jg = y;
                        this.Jk.GM.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Go != 10000 || !this.Je.contains(x, y)) && (this.Go != 10001 || !this.Jf.contains(x, y))) {
                    return false;
                }
                if (!this.Jk.GN) {
                    this.Jg = y;
                    this.Jk.aE(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Jk.GN) {
                    this.Jk.kL();
                    this.Jk.kM();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Jk.GN) {
            this.Jk.aF(this.Jg - y);
            this.Jg = y;
            this.Jk.GM.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.IW != -1.0f) {
                this.Je.set(i, i2, i3, (int) (i2 + this.IW));
            }
            if (this.IY != -1.0f) {
                this.Jf.set(i, (int) (i4 - this.IY), i3, i4);
            }
        }
        if (!this.Jj.GK && !this.Jk.GN) {
            kz();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.IX != -1.0f) {
            this.IW = i3 - this.IZ;
        }
        if (this.IZ != -1.0f) {
            this.IY = i3 - this.IX;
        }
        if (!$assertionsDisabled && i3 < this.IW) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.IY) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Ge = getMeasuredWidth();
        this.Gf = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz() {
        switch (this.Go) {
            case 10000:
                this.Ja = (int) (this.IW - this.Gf);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Ja = (int) (this.Gf - this.IY);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Ja = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Jo;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Jo.Jj.GK) {
                switch (message.what) {
                    case -105:
                        this.Jo.Jj.lG();
                        return;
                    case -104:
                        this.Jo.Jj.lF();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Jo.Jj.lE();
                        return;
                    case -100:
                        this.Jo.Jj.lD();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Jq;
        VelocityTracker GM;
        boolean GN;
        final int GO;
        final int GP;
        final /* synthetic */ VerticalTranslateLayout Jo;

        static /* synthetic */ int[] lJ() {
            int[] iArr = Jq;
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
                Jq = iArr;
            }
            return iArr;
        }

        boolean aE(int i) {
            switch (lJ()[this.Jo.Jd.ordinal()]) {
                case 1:
                    if (this.Jo.Go != 10004 && this.Jo.Go != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Jo.Go != 10004 && this.Jo.Go != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Jo.Jn != null) {
                        this.Jo.Jn.aK(i);
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

        void aF(int i) {
            if (this.GN) {
                int i2 = this.Jo.Ja - i;
                switch (lJ()[this.Jo.Jd.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Jo.IW - this.Jo.Gf && i2 < 0) {
                            this.Jo.Ja -= i;
                            this.Jo.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Jo.Gf - this.Jo.IY && i2 > 0) {
                            this.Jo.Ja -= i;
                            this.Jo.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Jo.IW - this.Jo.Gf && i2 <= this.Jo.Gf - this.Jo.IY) {
                            this.Jo.Ja -= i;
                            this.Jo.invalidate();
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
            switch (lJ()[this.Jo.Jd.ordinal()]) {
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
            int i = this.Jo.Ja;
            if (i <= 0 && i >= this.Jo.IW - this.Jo.Gf) {
                if (f < 0.0f) {
                    this.Jo.Jj.L(f);
                } else {
                    this.Jo.Jj.J(f);
                }
            } else if (i >= 0 && i <= this.Jo.Gf - this.Jo.IY) {
                if (f < 0.0f) {
                    this.Jo.Jj.K(f);
                } else {
                    this.Jo.Jj.M(f);
                }
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Jo.Jj.L(f);
            } else {
                this.Jo.Jj.J(f);
            }
        }

        private void P(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Jo.Jj.K(f);
            } else {
                this.Jo.Jj.M(f);
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
        final /* synthetic */ VerticalTranslateLayout Jo;

        private void kA() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GE = ((((float) (uptimeMillis - this.GI)) / 1000.0f) * this.GF) + this.GE;
            this.GI = uptimeMillis;
            this.GJ += 16;
        }

        void lD() {
            kA();
            if (this.GE <= this.GG) {
                e eVar = this.Jo.Jl;
                if (eVar != null) {
                    eVar.lI();
                }
                this.GK = false;
                this.Jo.Go = 10000;
                this.Jo.kz();
                return;
            }
            this.Jo.Ja = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jo.invalidate();
            this.Jo.Ji.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void lE() {
            kA();
            if (this.GE >= this.GG) {
                c cVar = this.Jo.Jm;
                if (cVar != null) {
                    cVar.lH();
                }
                this.GK = false;
                this.Jo.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Jo.kz();
                return;
            }
            this.Jo.Ja = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jo.invalidate();
            this.Jo.Ji.sendEmptyMessageAtTime(-101, this.GJ);
        }

        void lF() {
            kA();
            if (this.GE >= this.GG) {
                for (d dVar : this.Jo.GB) {
                    if (dVar != null) {
                        dVar.kI();
                    }
                }
                this.GK = false;
                this.Jo.Go = 10004;
                this.Jo.kz();
                return;
            }
            this.Jo.Ja = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jo.invalidate();
            this.Jo.Ji.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void lG() {
            kA();
            if (this.GE <= this.GG) {
                for (d dVar : this.Jo.GB) {
                    if (dVar != null) {
                        dVar.kI();
                    }
                }
                this.GK = false;
                this.Jo.Go = 10004;
                this.Jo.kz();
                return;
            }
            this.Jo.Ja = (int) (com.baidu.adp.widget.a.a(this.GG, this.GE, false) + this.GH);
            this.Jo.invalidate();
            this.Jo.Ji.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void J(float f) {
            for (d dVar : this.Jo.GB) {
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
            this.GG = 0 - this.Jo.Ja;
            this.GH = this.Jo.Ja;
            this.Jo.Ji.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GG);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Jo.Ji.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void K(float f) {
            for (d dVar : this.Jo.GB) {
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
            this.GG = 0 - this.Jo.Ja;
            this.GH = this.Jo.Ja;
            BdLog.d("Animator@animateBottomOpen " + this.GG);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Jo.Ji.removeMessages(-105);
            this.Jo.Ji.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void L(float f) {
            e eVar = this.Jo.Jl;
            if (eVar != null) {
                eVar.kF();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = ((-this.Jo.Gf) + this.Jo.IW) - this.Jo.Ja;
            this.GH = this.Jo.Ja;
            BdLog.d("Animator@animateTop " + this.GG);
            BdLog.d("Animator@animateTop " + f);
            this.Jo.Ji.removeMessages(-100);
            this.Jo.Ji.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void M(float f) {
            c cVar = this.Jo.Jm;
            if (cVar != null) {
                cVar.kJ();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = (this.Jo.Gf - this.Jo.IY) - this.Jo.Ja;
            this.GH = this.Jo.Ja;
            BdLog.d("Animator@animateBottom " + this.GG);
            BdLog.d("Animator@animateBottom " + f);
            this.Jo.Ji.removeMessages(-101);
            this.Jo.Ji.sendEmptyMessageAtTime(-101, this.GJ);
        }
    }
}
