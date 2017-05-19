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
        none;

        /* JADX DEBUG: Replace access to removed values field (GL) with 'values()' method */
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
        void aD(int i);
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
        void kH();

        void kI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void kJ();

        void kK();
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
        return i2 >= this.Gt - this.Gk && i2 <= this.Gt + this.Gk && (i < this.Gs - this.Gk || i > this.Gs + this.Gk) && this.Gy.aE(i - this.Gs);
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
                    if (this.Gy.GN) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Gy.kL();
                        this.Gy.kM();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Gy.GN) {
                        if (!this.Gv) {
                            if (x > this.Gs) {
                                this.Gu = this.Gs + this.Gk;
                                this.Gv = true;
                            } else {
                                this.Gu = this.Gs - this.Gk;
                                this.Gv = true;
                            }
                        }
                        this.Gy.aF(this.Gu - x);
                        this.Gu = x;
                        this.Gy.GM.addMovement(motionEvent);
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
                if (!this.Gy.GN) {
                    this.Gu = x;
                    this.Gy.aE(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Gy.GN) {
                    this.Gy.kL();
                    this.Gy.kM();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Gy.GN) {
            this.Gy.aF(this.Gu - x);
            this.Gu = x;
            this.Gy.GM.addMovement(motionEvent);
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
        if (!this.Gx.GK && !this.Gy.GN) {
            kz();
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
    public void kz() {
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
        final /* synthetic */ HorizontalTranslateLayout GD;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.GD.Gx.GK) {
                switch (message.what) {
                    case -105:
                        this.GD.Gx.kE();
                        return;
                    case -104:
                        this.GD.Gx.kD();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.GD.Gx.kC();
                        return;
                    case -100:
                        this.GD.Gx.kB();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] GQ;
        final /* synthetic */ HorizontalTranslateLayout GD;
        VelocityTracker GM;
        boolean GN;
        final int GO;
        final int GP;

        static /* synthetic */ int[] kN() {
            int[] iArr = GQ;
            if (iArr == null) {
                iArr = new int[TrackDirection.valuesCustom().length];
                try {
                    iArr[TrackDirection.horizontal.ordinal()] = 3;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[TrackDirection.left.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[TrackDirection.none.ordinal()] = 4;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[TrackDirection.right.ordinal()] = 2;
                } catch (NoSuchFieldError e4) {
                }
                GQ = iArr;
            }
            return iArr;
        }

        boolean aE(int i) {
            switch (kN()[this.GD.Gn.ordinal()]) {
                case 1:
                    if (this.GD.Go != 10004 && this.GD.Go != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.GD.Go != 10004 && this.GD.Go != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.GD.GC != null) {
                        this.GD.GC.aD(i);
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
                int i2 = this.GD.Gj - i;
                switch (kN()[this.GD.Gn.ordinal()]) {
                    case 1:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.GD.Gh - this.GD.getMeasuredWidth() && i2 < 0) {
                            this.GD.Gj -= i;
                            this.GD.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.GD.getMeasuredWidth() - this.GD.Gi && i2 > 0) {
                            this.GD.Gj -= i;
                            this.GD.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.GD.Gh - this.GD.getMeasuredWidth() && i2 <= this.GD.getMeasuredWidth() - this.GD.Gi) {
                            this.GD.Gj -= i;
                            this.GD.invalidate();
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
            float xVelocity = this.GM.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.GP);
            } else {
                max = Math.max(xVelocity, this.GP);
            }
            switch (kN()[this.GD.Gn.ordinal()]) {
                case 1:
                    D(max);
                    break;
                case 2:
                    E(max);
                    break;
                case 3:
                    C(max);
                    break;
            }
            this.GM.recycle();
            this.GM = null;
        }

        private void C(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.GD.Gj;
            if (i <= 0 && i >= this.GD.Gh - this.GD.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.GD.Gx.A(f);
                } else {
                    this.GD.Gx.y(f);
                }
            } else if (i >= 0 && i <= this.GD.getMeasuredWidth() - this.GD.Gi) {
                if (f < 0.0f) {
                    this.GD.Gx.z(f);
                } else {
                    this.GD.Gx.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.GD.Gx.A(f);
            } else {
                this.GD.Gx.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.GD.Gx.z(f);
            } else {
                this.GD.Gx.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout GD;
        float GE;
        float GF;
        float GG;
        float GH;
        long GI;
        long GJ;
        boolean GK;

        private void kA() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GE = ((((float) (uptimeMillis - this.GI)) / 1000.0f) * this.GF) + this.GE;
            this.GI = uptimeMillis;
            this.GJ += 16;
        }

        void kB() {
            kA();
            if (this.GE <= this.GG) {
                d dVar = this.GD.Gz;
                if (dVar != null) {
                    dVar.kG();
                }
                this.GK = false;
                this.GD.Go = 10000;
                this.GD.kz();
                return;
            }
            this.GD.Gj = (int) (com.baidu.adp.widget.g.a(this.GG, this.GE, false) + this.GH);
            this.GD.invalidate();
            this.GD.Gw.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void kC() {
            kA();
            if (this.GE >= this.GG) {
                f fVar = this.GD.GA;
                if (fVar != null) {
                    fVar.kK();
                }
                this.GK = false;
                this.GD.Go = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.GD.kz();
                return;
            }
            this.GD.Gj = (int) (com.baidu.adp.widget.g.a(this.GG, this.GE, false) + this.GH);
            this.GD.invalidate();
            this.GD.Gw.sendEmptyMessageAtTime(-101, this.GJ);
        }

        void kD() {
            kA();
            if (this.GE >= this.GG) {
                for (e eVar : this.GD.GB) {
                    if (eVar != null) {
                        eVar.kI();
                    }
                }
                this.GK = false;
                this.GD.Go = 10004;
                this.GD.kz();
                return;
            }
            this.GD.Gj = (int) (com.baidu.adp.widget.g.a(this.GG, this.GE, false) + this.GH);
            this.GD.invalidate();
            this.GD.Gw.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void kE() {
            kA();
            if (this.GE <= this.GG) {
                for (e eVar : this.GD.GB) {
                    if (eVar != null) {
                        eVar.kI();
                    }
                }
                this.GK = false;
                this.GD.Go = 10004;
                this.GD.kz();
                return;
            }
            this.GD.Gj = (int) (com.baidu.adp.widget.g.a(this.GG, this.GE, false) + this.GH);
            this.GD.invalidate();
            this.GD.Gw.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void y(float f) {
            for (e eVar : this.GD.GB) {
                if (eVar != null) {
                    eVar.kH();
                }
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = 0 - this.GD.Gj;
            this.GH = this.GD.Gj;
            this.GD.Gw.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GG);
            BdLog.d("Animator@animateTopOpen " + f);
            this.GD.Gw.sendEmptyMessageAtTime(-104, this.GJ);
        }

        void z(float f) {
            for (e eVar : this.GD.GB) {
                if (eVar != null) {
                    eVar.kH();
                }
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = 0 - this.GD.Gj;
            this.GH = this.GD.Gj;
            BdLog.d("Animator@animateBottomOpen " + this.GG);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.GD.Gw.removeMessages(-105);
            this.GD.Gw.sendEmptyMessageAtTime(-105, this.GJ);
        }

        void A(float f) {
            d dVar = this.GD.Gz;
            if (dVar != null) {
                dVar.kF();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = ((-this.GD.getMeasuredWidth()) + this.GD.Gh) - this.GD.Gj;
            this.GH = this.GD.Gj;
            BdLog.d("Animator@animateTop " + this.GG);
            BdLog.d("Animator@animateTop " + f);
            this.GD.Gw.removeMessages(-100);
            this.GD.Gw.sendEmptyMessageAtTime(-100, this.GJ);
        }

        void B(float f) {
            f fVar = this.GD.GA;
            if (fVar != null) {
                fVar.kJ();
            }
            this.GK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GI = uptimeMillis;
            this.GJ = uptimeMillis + 16;
            this.GF = f;
            this.GE = 0.0f;
            this.GG = (this.GD.getMeasuredWidth() - this.GD.Gi) - this.GD.Gj;
            this.GH = this.GD.Gj;
            BdLog.d("Animator@animateBottom " + this.GG);
            BdLog.d("Animator@animateBottom " + f);
            this.GD.Gw.removeMessages(-101);
            this.GD.Gw.sendEmptyMessageAtTime(-101, this.GJ);
        }
    }
}
