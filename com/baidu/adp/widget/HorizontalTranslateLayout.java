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
    private int HD;
    private float HG;
    private float HH;
    private int HI;
    private final int HJ;
    private boolean HK;
    private boolean HL;
    private TrackDirection HM;
    private int HN;
    private final Rect HO;
    private final Rect HP;
    private final Paint HQ;
    private int HR;
    private int HS;
    private int HT;
    private boolean HU;
    private final a HV;
    private final b HW;
    private final g HX;
    private d HY;
    private f HZ;
    private final List<e> Ia;
    private c Ib;

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
        void aG(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kM();

        void kN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kO();

        void kP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void kQ();

        void kR();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.HQ.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.HI = (int) ((this.HG - this.HD) * (-f2));
            } else if (f2 > 0.0f) {
                this.HI = (int) ((this.HD - this.HH) * f2);
            } else if (f2 == 0.0f) {
                this.HI = 0;
                this.HN = 10004;
            } else if (f2 == -1.0f) {
                this.HG -= getMeasuredWidth();
                this.HN = 10000;
            } else if (f2 == 1.0f) {
                this.HG = getMeasuredWidth() - this.HH;
                this.HN = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.HG;
    }

    public int getRightOffset() {
        return (int) this.HH;
    }

    public void setLeftTapBack(boolean z) {
        this.HK = z;
    }

    public void setRightTapBack(boolean z) {
        this.HL = z;
    }

    public int getState() {
        return this.HN;
    }

    public void setLeftAnimationListener(d dVar) {
        this.HY = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.HZ = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Ib = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.HI, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.HI);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.HQ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.HI;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HM == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.HN == 10004) {
            switch (action) {
                case 0:
                    this.HR = x;
                    this.HS = y;
                    this.HV.removeMessages(-100);
                    this.HV.removeMessages(-104);
                    this.HV.removeMessages(-101);
                    this.HV.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.HI, 0.0f);
                    return r(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean r(int i, int i2) {
        return i2 >= this.HS - this.HJ && i2 <= this.HS + this.HJ && (i < this.HR - this.HJ || i > this.HR + this.HJ) && this.HX.aH(i - this.HR);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.HN == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.HU = false;
                    if (this.HX.In) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.HX.kS();
                        this.HX.kT();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.HX.In) {
                        if (!this.HU) {
                            if (x > this.HR) {
                                this.HT = this.HR + this.HJ;
                                this.HU = true;
                            } else {
                                this.HT = this.HR - this.HJ;
                                this.HU = true;
                            }
                        }
                        this.HX.aI(this.HT - x);
                        this.HT = x;
                        this.HX.Im.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.HO);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.HP);
        switch (action) {
            case 0:
                if ((this.HN != 10000 || !this.HO.contains(x, y)) && (this.HN != 10001 || !this.HP.contains(x, y))) {
                    return false;
                }
                if (!this.HX.In) {
                    this.HT = x;
                    this.HX.aH(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.HX.In) {
                    this.HX.kS();
                    this.HX.kT();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.HX.In) {
            this.HX.aI(this.HT - x);
            this.HT = x;
            this.HX.Im.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.HG != -1.0f) {
                this.HO.set(i, i2, (int) (i + this.HG), i4);
            }
            if (this.HH != -1.0f) {
                this.HP.set((int) (i3 - this.HH), i2, i3, i4);
            }
        }
        if (!this.HW.Ik && !this.HX.In) {
            kG();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.HG) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.HH) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.HD = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kG() {
        switch (this.HN) {
            case 10000:
                this.HI = (int) (this.HG - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.HI = (int) (getMeasuredWidth() - this.HH);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.HI = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout Id;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Id.HW.Ik) {
                switch (message.what) {
                    case -105:
                        this.Id.HW.kL();
                        return;
                    case -104:
                        this.Id.HW.kK();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Id.HW.kJ();
                        return;
                    case -100:
                        this.Id.HW.kI();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final /* synthetic */ HorizontalTranslateLayout Id;
        VelocityTracker Im;
        boolean In;
        final int Io;
        final int Ip;

        boolean aH(int i) {
            switch (this.Id.HM) {
                case left:
                    if (this.Id.HN != 10004 && this.Id.HN != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (this.Id.HN != 10004 && this.Id.HN != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (this.Id.Ib != null) {
                        this.Id.Ib.aG(i);
                        break;
                    }
                    break;
            }
            this.Im = VelocityTracker.obtain();
            this.In = true;
            return true;
        }

        void kS() {
            this.In = false;
        }

        void aI(int i) {
            if (this.In) {
                int i2 = this.Id.HI - i;
                switch (this.Id.HM) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.Id.HG - this.Id.getMeasuredWidth() && i2 < 0) {
                            this.Id.HI -= i;
                            this.Id.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.Id.getMeasuredWidth() - this.Id.HH && i2 > 0) {
                            this.Id.HI -= i;
                            this.Id.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.Id.HG - this.Id.getMeasuredWidth() && i2 <= this.Id.getMeasuredWidth() - this.Id.HH) {
                            this.Id.HI -= i;
                            this.Id.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kT() {
            float max;
            this.Im.computeCurrentVelocity(this.Io);
            float xVelocity = this.Im.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Ip);
            } else {
                max = Math.max(xVelocity, this.Ip);
            }
            switch (this.Id.HM) {
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
            this.Im.recycle();
            this.Im = null;
        }

        private void C(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.Id.HI;
            if (i <= 0 && i >= this.Id.HG - this.Id.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.Id.HW.A(f);
                } else {
                    this.Id.HW.y(f);
                }
            } else if (i >= 0 && i <= this.Id.getMeasuredWidth() - this.Id.HH) {
                if (f < 0.0f) {
                    this.Id.HW.z(f);
                } else {
                    this.Id.HW.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.Id.HW.A(f);
            } else {
                this.Id.HW.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.Id.HW.z(f);
            } else {
                this.Id.HW.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout Id;
        float Ie;
        float If;
        float Ig;
        float Ih;
        long Ii;
        long Ij;
        boolean Ik;

        private void kH() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ie = ((((float) (uptimeMillis - this.Ii)) / 1000.0f) * this.If) + this.Ie;
            this.Ii = uptimeMillis;
            this.Ij += 16;
        }

        void kI() {
            kH();
            if (this.Ie <= this.Ig) {
                d dVar = this.Id.HY;
                if (dVar != null) {
                    dVar.kN();
                }
                this.Ik = false;
                this.Id.HN = 10000;
                this.Id.kG();
                return;
            }
            this.Id.HI = (int) (com.baidu.adp.widget.e.a(this.Ig, this.Ie, false) + this.Ih);
            this.Id.invalidate();
            this.Id.HV.sendEmptyMessageAtTime(-100, this.Ij);
        }

        void kJ() {
            kH();
            if (this.Ie >= this.Ig) {
                f fVar = this.Id.HZ;
                if (fVar != null) {
                    fVar.kR();
                }
                this.Ik = false;
                this.Id.HN = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Id.kG();
                return;
            }
            this.Id.HI = (int) (com.baidu.adp.widget.e.a(this.Ig, this.Ie, false) + this.Ih);
            this.Id.invalidate();
            this.Id.HV.sendEmptyMessageAtTime(-101, this.Ij);
        }

        void kK() {
            kH();
            if (this.Ie >= this.Ig) {
                for (e eVar : this.Id.Ia) {
                    if (eVar != null) {
                        eVar.kP();
                    }
                }
                this.Ik = false;
                this.Id.HN = 10004;
                this.Id.kG();
                return;
            }
            this.Id.HI = (int) (com.baidu.adp.widget.e.a(this.Ig, this.Ie, false) + this.Ih);
            this.Id.invalidate();
            this.Id.HV.sendEmptyMessageAtTime(-104, this.Ij);
        }

        void kL() {
            kH();
            if (this.Ie <= this.Ig) {
                for (e eVar : this.Id.Ia) {
                    if (eVar != null) {
                        eVar.kP();
                    }
                }
                this.Ik = false;
                this.Id.HN = 10004;
                this.Id.kG();
                return;
            }
            this.Id.HI = (int) (com.baidu.adp.widget.e.a(this.Ig, this.Ie, false) + this.Ih);
            this.Id.invalidate();
            this.Id.HV.sendEmptyMessageAtTime(-105, this.Ij);
        }

        void y(float f) {
            for (e eVar : this.Id.Ia) {
                if (eVar != null) {
                    eVar.kO();
                }
            }
            this.Ik = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ii = uptimeMillis;
            this.Ij = uptimeMillis + 16;
            this.If = f;
            this.Ie = 0.0f;
            this.Ig = 0 - this.Id.HI;
            this.Ih = this.Id.HI;
            this.Id.HV.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Ig);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Id.HV.sendEmptyMessageAtTime(-104, this.Ij);
        }

        void z(float f) {
            for (e eVar : this.Id.Ia) {
                if (eVar != null) {
                    eVar.kO();
                }
            }
            this.Ik = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ii = uptimeMillis;
            this.Ij = uptimeMillis + 16;
            this.If = f;
            this.Ie = 0.0f;
            this.Ig = 0 - this.Id.HI;
            this.Ih = this.Id.HI;
            BdLog.d("Animator@animateBottomOpen " + this.Ig);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Id.HV.removeMessages(-105);
            this.Id.HV.sendEmptyMessageAtTime(-105, this.Ij);
        }

        void A(float f) {
            d dVar = this.Id.HY;
            if (dVar != null) {
                dVar.kM();
            }
            this.Ik = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ii = uptimeMillis;
            this.Ij = uptimeMillis + 16;
            this.If = f;
            this.Ie = 0.0f;
            this.Ig = ((-this.Id.getMeasuredWidth()) + this.Id.HG) - this.Id.HI;
            this.Ih = this.Id.HI;
            BdLog.d("Animator@animateTop " + this.Ig);
            BdLog.d("Animator@animateTop " + f);
            this.Id.HV.removeMessages(-100);
            this.Id.HV.sendEmptyMessageAtTime(-100, this.Ij);
        }

        void B(float f) {
            f fVar = this.Id.HZ;
            if (fVar != null) {
                fVar.kQ();
            }
            this.Ik = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ii = uptimeMillis;
            this.Ij = uptimeMillis + 16;
            this.If = f;
            this.Ie = 0.0f;
            this.Ig = (this.Id.getMeasuredWidth() - this.Id.HH) - this.Id.HI;
            this.Ih = this.Id.HI;
            BdLog.d("Animator@animateBottom " + this.Ig);
            BdLog.d("Animator@animateBottom " + f);
            this.Id.HV.removeMessages(-101);
            this.Id.HV.sendEmptyMessageAtTime(-101, this.Ij);
        }
    }
}
