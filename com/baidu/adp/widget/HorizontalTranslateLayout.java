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
    private int Gb;
    private float Ge;
    private float Gf;
    private int Gg;
    private final int Gh;
    private boolean Gi;
    private boolean Gj;
    private TrackDirection Gk;
    private int Gl;
    private final Rect Gm;
    private final Rect Gn;
    private final Paint Go;
    private int Gp;
    private int Gq;
    private int Gr;
    private boolean Gs;
    private final a Gt;
    private final b Gu;
    private final g Gv;
    private d Gw;
    private f Gx;
    private final List<e> Gy;
    private c Gz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (GI) with 'values()' method */
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
        void aE(int i);
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
        this.Go.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Gg = (int) ((this.Ge - this.Gb) * (-f2));
            } else if (f2 > 0.0f) {
                this.Gg = (int) ((this.Gb - this.Gf) * f2);
            } else if (f2 == 0.0f) {
                this.Gg = 0;
                this.Gl = 10004;
            } else if (f2 == -1.0f) {
                this.Ge -= getMeasuredWidth();
                this.Gl = 10000;
            } else if (f2 == 1.0f) {
                this.Ge = getMeasuredWidth() - this.Gf;
                this.Gl = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Ge;
    }

    public int getRightOffset() {
        return (int) this.Gf;
    }

    public void setLeftTapBack(boolean z) {
        this.Gi = z;
    }

    public void setRightTapBack(boolean z) {
        this.Gj = z;
    }

    public int getState() {
        return this.Gl;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Gw = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Gx = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Gz = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Gg, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.Gg);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Go);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Gg;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Gk == TrackDirection.none) {
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
                    this.Gt.removeMessages(-100);
                    this.Gt.removeMessages(-104);
                    this.Gt.removeMessages(-101);
                    this.Gt.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Gg, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.Gq - this.Gh && i2 <= this.Gq + this.Gh && (i < this.Gp - this.Gh || i > this.Gp + this.Gh) && this.Gv.aF(i - this.Gp);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Gs = false;
                    if (this.Gv.GK) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Gv.kL();
                        this.Gv.kM();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Gv.GK) {
                        if (!this.Gs) {
                            if (x > this.Gp) {
                                this.Gr = this.Gp + this.Gh;
                                this.Gs = true;
                            } else {
                                this.Gr = this.Gp - this.Gh;
                                this.Gs = true;
                            }
                        }
                        this.Gv.aG(this.Gr - x);
                        this.Gr = x;
                        this.Gv.GJ.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Gm);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Gn);
        switch (action) {
            case 0:
                if ((this.Gl != 10000 || !this.Gm.contains(x, y)) && (this.Gl != 10001 || !this.Gn.contains(x, y))) {
                    return false;
                }
                if (!this.Gv.GK) {
                    this.Gr = x;
                    this.Gv.aF(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Gv.GK) {
                    this.Gv.kL();
                    this.Gv.kM();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Gv.GK) {
            this.Gv.aG(this.Gr - x);
            this.Gr = x;
            this.Gv.GJ.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ge != -1.0f) {
                this.Gm.set(i, i2, (int) (i + this.Ge), i4);
            }
            if (this.Gf != -1.0f) {
                this.Gn.set((int) (i3 - this.Gf), i2, i3, i4);
            }
        }
        if (!this.Gu.GH && !this.Gv.GK) {
            kz();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Ge) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Gf) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Gb = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz() {
        switch (this.Gl) {
            case 10000:
                this.Gg = (int) (this.Ge - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Gg = (int) (getMeasuredWidth() - this.Gf);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Gg = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout GA;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.GA.Gu.GH) {
                switch (message.what) {
                    case -105:
                        this.GA.Gu.kE();
                        return;
                    case -104:
                        this.GA.Gu.kD();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.GA.Gu.kC();
                        return;
                    case -100:
                        this.GA.Gu.kB();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] GN;
        final /* synthetic */ HorizontalTranslateLayout GA;
        VelocityTracker GJ;
        boolean GK;
        final int GL;
        final int GM;

        static /* synthetic */ int[] kN() {
            int[] iArr = GN;
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
                GN = iArr;
            }
            return iArr;
        }

        boolean aF(int i) {
            switch (kN()[this.GA.Gk.ordinal()]) {
                case 1:
                    if (this.GA.Gl != 10004 && this.GA.Gl != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.GA.Gl != 10004 && this.GA.Gl != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.GA.Gz != null) {
                        this.GA.Gz.aE(i);
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
                int i2 = this.GA.Gg - i;
                switch (kN()[this.GA.Gk.ordinal()]) {
                    case 1:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.GA.Ge - this.GA.getMeasuredWidth() && i2 < 0) {
                            this.GA.Gg -= i;
                            this.GA.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.GA.getMeasuredWidth() - this.GA.Gf && i2 > 0) {
                            this.GA.Gg -= i;
                            this.GA.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.GA.Ge - this.GA.getMeasuredWidth() && i2 <= this.GA.getMeasuredWidth() - this.GA.Gf) {
                            this.GA.Gg -= i;
                            this.GA.invalidate();
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
            float xVelocity = this.GJ.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.GM);
            } else {
                max = Math.max(xVelocity, this.GM);
            }
            switch (kN()[this.GA.Gk.ordinal()]) {
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
            this.GJ.recycle();
            this.GJ = null;
        }

        private void C(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.GA.Gg;
            if (i <= 0 && i >= this.GA.Ge - this.GA.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.GA.Gu.A(f);
                } else {
                    this.GA.Gu.y(f);
                }
            } else if (i >= 0 && i <= this.GA.getMeasuredWidth() - this.GA.Gf) {
                if (f < 0.0f) {
                    this.GA.Gu.z(f);
                } else {
                    this.GA.Gu.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.GA.Gu.A(f);
            } else {
                this.GA.Gu.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.GA.Gu.z(f);
            } else {
                this.GA.Gu.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout GA;
        float GB;
        float GC;
        float GD;
        float GE;
        long GF;
        long GG;
        boolean GH;

        private void kA() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GB = ((((float) (uptimeMillis - this.GF)) / 1000.0f) * this.GC) + this.GB;
            this.GF = uptimeMillis;
            this.GG += 16;
        }

        void kB() {
            kA();
            if (this.GB <= this.GD) {
                d dVar = this.GA.Gw;
                if (dVar != null) {
                    dVar.kG();
                }
                this.GH = false;
                this.GA.Gl = 10000;
                this.GA.kz();
                return;
            }
            this.GA.Gg = (int) (com.baidu.adp.widget.g.a(this.GD, this.GB, false) + this.GE);
            this.GA.invalidate();
            this.GA.Gt.sendEmptyMessageAtTime(-100, this.GG);
        }

        void kC() {
            kA();
            if (this.GB >= this.GD) {
                f fVar = this.GA.Gx;
                if (fVar != null) {
                    fVar.kK();
                }
                this.GH = false;
                this.GA.Gl = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.GA.kz();
                return;
            }
            this.GA.Gg = (int) (com.baidu.adp.widget.g.a(this.GD, this.GB, false) + this.GE);
            this.GA.invalidate();
            this.GA.Gt.sendEmptyMessageAtTime(-101, this.GG);
        }

        void kD() {
            kA();
            if (this.GB >= this.GD) {
                for (e eVar : this.GA.Gy) {
                    if (eVar != null) {
                        eVar.kI();
                    }
                }
                this.GH = false;
                this.GA.Gl = 10004;
                this.GA.kz();
                return;
            }
            this.GA.Gg = (int) (com.baidu.adp.widget.g.a(this.GD, this.GB, false) + this.GE);
            this.GA.invalidate();
            this.GA.Gt.sendEmptyMessageAtTime(-104, this.GG);
        }

        void kE() {
            kA();
            if (this.GB <= this.GD) {
                for (e eVar : this.GA.Gy) {
                    if (eVar != null) {
                        eVar.kI();
                    }
                }
                this.GH = false;
                this.GA.Gl = 10004;
                this.GA.kz();
                return;
            }
            this.GA.Gg = (int) (com.baidu.adp.widget.g.a(this.GD, this.GB, false) + this.GE);
            this.GA.invalidate();
            this.GA.Gt.sendEmptyMessageAtTime(-105, this.GG);
        }

        void y(float f) {
            for (e eVar : this.GA.Gy) {
                if (eVar != null) {
                    eVar.kH();
                }
            }
            this.GH = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = uptimeMillis;
            this.GG = uptimeMillis + 16;
            this.GC = f;
            this.GB = 0.0f;
            this.GD = 0 - this.GA.Gg;
            this.GE = this.GA.Gg;
            this.GA.Gt.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.GD);
            BdLog.d("Animator@animateTopOpen " + f);
            this.GA.Gt.sendEmptyMessageAtTime(-104, this.GG);
        }

        void z(float f) {
            for (e eVar : this.GA.Gy) {
                if (eVar != null) {
                    eVar.kH();
                }
            }
            this.GH = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = uptimeMillis;
            this.GG = uptimeMillis + 16;
            this.GC = f;
            this.GB = 0.0f;
            this.GD = 0 - this.GA.Gg;
            this.GE = this.GA.Gg;
            BdLog.d("Animator@animateBottomOpen " + this.GD);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.GA.Gt.removeMessages(-105);
            this.GA.Gt.sendEmptyMessageAtTime(-105, this.GG);
        }

        void A(float f) {
            d dVar = this.GA.Gw;
            if (dVar != null) {
                dVar.kF();
            }
            this.GH = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = uptimeMillis;
            this.GG = uptimeMillis + 16;
            this.GC = f;
            this.GB = 0.0f;
            this.GD = ((-this.GA.getMeasuredWidth()) + this.GA.Ge) - this.GA.Gg;
            this.GE = this.GA.Gg;
            BdLog.d("Animator@animateTop " + this.GD);
            BdLog.d("Animator@animateTop " + f);
            this.GA.Gt.removeMessages(-100);
            this.GA.Gt.sendEmptyMessageAtTime(-100, this.GG);
        }

        void B(float f) {
            f fVar = this.GA.Gx;
            if (fVar != null) {
                fVar.kJ();
            }
            this.GH = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GF = uptimeMillis;
            this.GG = uptimeMillis + 16;
            this.GC = f;
            this.GB = 0.0f;
            this.GD = (this.GA.getMeasuredWidth() - this.GA.Gf) - this.GA.Gg;
            this.GE = this.GA.Gg;
            BdLog.d("Animator@animateBottom " + this.GD);
            BdLog.d("Animator@animateBottom " + f);
            this.GA.Gt.removeMessages(-101);
            this.GA.Gt.sendEmptyMessageAtTime(-101, this.GG);
        }
    }
}
