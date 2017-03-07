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
    private int GA;
    private float GD;
    private float GE;
    private int GF;
    private final int GG;
    private boolean GH;
    private boolean GI;
    private TrackDirection GJ;
    private int GK;
    private final Rect GL;
    private final Rect GM;
    private final Paint GN;
    private int GO;
    private int GP;
    private int GQ;
    private boolean GR;
    private final a GS;
    private final b GT;
    private final g GU;
    private d GV;
    private f GW;
    private final List<e> GX;
    private c GY;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (Hh) with 'values()' method */
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
        void aF(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kB();

        void kC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kD();

        void kE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void kF();

        void kG();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.GN.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.GF = (int) ((this.GD - this.GA) * (-f2));
            } else if (f2 > 0.0f) {
                this.GF = (int) ((this.GA - this.GE) * f2);
            } else if (f2 == 0.0f) {
                this.GF = 0;
                this.GK = 10004;
            } else if (f2 == -1.0f) {
                this.GD -= getMeasuredWidth();
                this.GK = 10000;
            } else if (f2 == 1.0f) {
                this.GD = getMeasuredWidth() - this.GE;
                this.GK = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.GD;
    }

    public int getRightOffset() {
        return (int) this.GE;
    }

    public void setLeftTapBack(boolean z) {
        this.GH = z;
    }

    public void setRightTapBack(boolean z) {
        this.GI = z;
    }

    public int getState() {
        return this.GK;
    }

    public void setLeftAnimationListener(d dVar) {
        this.GV = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.GW = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.GY = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.GF, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.GF);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.GN);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.GF;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.GJ == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.GK == 10004) {
            switch (action) {
                case 0:
                    this.GO = x;
                    this.GP = y;
                    this.GS.removeMessages(-100);
                    this.GS.removeMessages(-104);
                    this.GS.removeMessages(-101);
                    this.GS.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.GF, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.GP - this.GG && i2 <= this.GP + this.GG && (i < this.GO - this.GG || i > this.GO + this.GG) && this.GU.aG(i - this.GO);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.GK == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.GR = false;
                    if (this.GU.Hj) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.GU.kH();
                        this.GU.kI();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.GU.Hj) {
                        if (!this.GR) {
                            if (x > this.GO) {
                                this.GQ = this.GO + this.GG;
                                this.GR = true;
                            } else {
                                this.GQ = this.GO - this.GG;
                                this.GR = true;
                            }
                        }
                        this.GU.aH(this.GQ - x);
                        this.GQ = x;
                        this.GU.Hi.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.GL);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.GM);
        switch (action) {
            case 0:
                if ((this.GK != 10000 || !this.GL.contains(x, y)) && (this.GK != 10001 || !this.GM.contains(x, y))) {
                    return false;
                }
                if (!this.GU.Hj) {
                    this.GQ = x;
                    this.GU.aG(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.GU.Hj) {
                    this.GU.kH();
                    this.GU.kI();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.GU.Hj) {
            this.GU.aH(this.GQ - x);
            this.GQ = x;
            this.GU.Hi.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.GD != -1.0f) {
                this.GL.set(i, i2, (int) (i + this.GD), i4);
            }
            if (this.GE != -1.0f) {
                this.GM.set((int) (i3 - this.GE), i2, i3, i4);
            }
        }
        if (!this.GT.Hg && !this.GU.Hj) {
            kv();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.GD) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.GE) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.GA = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv() {
        switch (this.GK) {
            case 10000:
                this.GF = (int) (this.GD - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.GF = (int) (getMeasuredWidth() - this.GE);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.GF = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout GZ;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.GZ.GT.Hg) {
                switch (message.what) {
                    case -105:
                        this.GZ.GT.kA();
                        return;
                    case -104:
                        this.GZ.GT.kz();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.GZ.GT.ky();
                        return;
                    case -100:
                        this.GZ.GT.kx();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Hm;
        final /* synthetic */ HorizontalTranslateLayout GZ;
        VelocityTracker Hi;
        boolean Hj;
        final int Hk;
        final int Hl;

        static /* synthetic */ int[] kJ() {
            int[] iArr = Hm;
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
                Hm = iArr;
            }
            return iArr;
        }

        boolean aG(int i) {
            switch (kJ()[this.GZ.GJ.ordinal()]) {
                case 1:
                    if (this.GZ.GK != 10004 && this.GZ.GK != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.GZ.GK != 10004 && this.GZ.GK != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.GZ.GY != null) {
                        this.GZ.GY.aF(i);
                        break;
                    }
                    break;
            }
            this.Hi = VelocityTracker.obtain();
            this.Hj = true;
            return true;
        }

        void kH() {
            this.Hj = false;
        }

        void aH(int i) {
            if (this.Hj) {
                int i2 = this.GZ.GF - i;
                switch (kJ()[this.GZ.GJ.ordinal()]) {
                    case 1:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.GZ.GD - this.GZ.getMeasuredWidth() && i2 < 0) {
                            this.GZ.GF -= i;
                            this.GZ.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.GZ.getMeasuredWidth() - this.GZ.GE && i2 > 0) {
                            this.GZ.GF -= i;
                            this.GZ.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.GZ.GD - this.GZ.getMeasuredWidth() && i2 <= this.GZ.getMeasuredWidth() - this.GZ.GE) {
                            this.GZ.GF -= i;
                            this.GZ.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kI() {
            float max;
            this.Hi.computeCurrentVelocity(this.Hk);
            float xVelocity = this.Hi.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Hl);
            } else {
                max = Math.max(xVelocity, this.Hl);
            }
            switch (kJ()[this.GZ.GJ.ordinal()]) {
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
            this.Hi.recycle();
            this.Hi = null;
        }

        private void C(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.GZ.GF;
            if (i <= 0 && i >= this.GZ.GD - this.GZ.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.GZ.GT.A(f);
                } else {
                    this.GZ.GT.y(f);
                }
            } else if (i >= 0 && i <= this.GZ.getMeasuredWidth() - this.GZ.GE) {
                if (f < 0.0f) {
                    this.GZ.GT.z(f);
                } else {
                    this.GZ.GT.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.GZ.GT.A(f);
            } else {
                this.GZ.GT.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.GZ.GT.z(f);
            } else {
                this.GZ.GT.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout GZ;
        float Ha;
        float Hb;
        float Hc;
        float Hd;
        long He;
        long Hf;
        boolean Hg;

        private void kw() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ha = ((((float) (uptimeMillis - this.He)) / 1000.0f) * this.Hb) + this.Ha;
            this.He = uptimeMillis;
            this.Hf += 16;
        }

        void kx() {
            kw();
            if (this.Ha <= this.Hc) {
                d dVar = this.GZ.GV;
                if (dVar != null) {
                    dVar.kC();
                }
                this.Hg = false;
                this.GZ.GK = 10000;
                this.GZ.kv();
                return;
            }
            this.GZ.GF = (int) (com.baidu.adp.widget.g.a(this.Hc, this.Ha, false) + this.Hd);
            this.GZ.invalidate();
            this.GZ.GS.sendEmptyMessageAtTime(-100, this.Hf);
        }

        void ky() {
            kw();
            if (this.Ha >= this.Hc) {
                f fVar = this.GZ.GW;
                if (fVar != null) {
                    fVar.kG();
                }
                this.Hg = false;
                this.GZ.GK = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.GZ.kv();
                return;
            }
            this.GZ.GF = (int) (com.baidu.adp.widget.g.a(this.Hc, this.Ha, false) + this.Hd);
            this.GZ.invalidate();
            this.GZ.GS.sendEmptyMessageAtTime(-101, this.Hf);
        }

        void kz() {
            kw();
            if (this.Ha >= this.Hc) {
                for (e eVar : this.GZ.GX) {
                    if (eVar != null) {
                        eVar.kE();
                    }
                }
                this.Hg = false;
                this.GZ.GK = 10004;
                this.GZ.kv();
                return;
            }
            this.GZ.GF = (int) (com.baidu.adp.widget.g.a(this.Hc, this.Ha, false) + this.Hd);
            this.GZ.invalidate();
            this.GZ.GS.sendEmptyMessageAtTime(-104, this.Hf);
        }

        void kA() {
            kw();
            if (this.Ha <= this.Hc) {
                for (e eVar : this.GZ.GX) {
                    if (eVar != null) {
                        eVar.kE();
                    }
                }
                this.Hg = false;
                this.GZ.GK = 10004;
                this.GZ.kv();
                return;
            }
            this.GZ.GF = (int) (com.baidu.adp.widget.g.a(this.Hc, this.Ha, false) + this.Hd);
            this.GZ.invalidate();
            this.GZ.GS.sendEmptyMessageAtTime(-105, this.Hf);
        }

        void y(float f) {
            for (e eVar : this.GZ.GX) {
                if (eVar != null) {
                    eVar.kD();
                }
            }
            this.Hg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.He = uptimeMillis;
            this.Hf = uptimeMillis + 16;
            this.Hb = f;
            this.Ha = 0.0f;
            this.Hc = 0 - this.GZ.GF;
            this.Hd = this.GZ.GF;
            this.GZ.GS.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Hc);
            BdLog.d("Animator@animateTopOpen " + f);
            this.GZ.GS.sendEmptyMessageAtTime(-104, this.Hf);
        }

        void z(float f) {
            for (e eVar : this.GZ.GX) {
                if (eVar != null) {
                    eVar.kD();
                }
            }
            this.Hg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.He = uptimeMillis;
            this.Hf = uptimeMillis + 16;
            this.Hb = f;
            this.Ha = 0.0f;
            this.Hc = 0 - this.GZ.GF;
            this.Hd = this.GZ.GF;
            BdLog.d("Animator@animateBottomOpen " + this.Hc);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.GZ.GS.removeMessages(-105);
            this.GZ.GS.sendEmptyMessageAtTime(-105, this.Hf);
        }

        void A(float f) {
            d dVar = this.GZ.GV;
            if (dVar != null) {
                dVar.kB();
            }
            this.Hg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.He = uptimeMillis;
            this.Hf = uptimeMillis + 16;
            this.Hb = f;
            this.Ha = 0.0f;
            this.Hc = ((-this.GZ.getMeasuredWidth()) + this.GZ.GD) - this.GZ.GF;
            this.Hd = this.GZ.GF;
            BdLog.d("Animator@animateTop " + this.Hc);
            BdLog.d("Animator@animateTop " + f);
            this.GZ.GS.removeMessages(-100);
            this.GZ.GS.sendEmptyMessageAtTime(-100, this.Hf);
        }

        void B(float f) {
            f fVar = this.GZ.GW;
            if (fVar != null) {
                fVar.kF();
            }
            this.Hg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.He = uptimeMillis;
            this.Hf = uptimeMillis + 16;
            this.Hb = f;
            this.Ha = 0.0f;
            this.Hc = (this.GZ.getMeasuredWidth() - this.GZ.GE) - this.GZ.GF;
            this.Hd = this.GZ.GF;
            BdLog.d("Animator@animateBottom " + this.Hc);
            BdLog.d("Animator@animateBottom " + f);
            this.GZ.GS.removeMessages(-101);
            this.GZ.GS.sendEmptyMessageAtTime(-101, this.Hf);
        }
    }
}
