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
    private int FA;
    private int FB;
    private final List<d> FJ;
    private int Fn;
    private int Fo;
    private final int Fs;
    private int Fw;
    private final Paint Fz;
    private float HP;
    private float HQ;
    private float HR;
    private float HS;
    private int HT;
    private boolean HU;
    private boolean HV;
    private TrackDirection HW;
    private final Rect HX;
    private final Rect HY;
    private int HZ;
    private boolean Ia;
    private final a Ib;
    private final b Ic;
    private final g Id;
    private e Ie;
    private c If;
    private f Ig;

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
        void kD();

        void ls();
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
        void kz();

        void lt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aO(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Fz.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.HT = (int) ((this.HP - this.Fo) * (-f2));
            } else if (f2 > 0.0f) {
                this.HT = (int) ((this.Fo - this.HR) * f2);
            } else if (f2 == 0.0f) {
                this.HT = 0;
                this.Fw = 10004;
            } else if (f2 == -1.0f) {
                this.HP -= this.Fo;
                this.Fw = 10000;
            } else if (f2 == 1.0f) {
                this.HP = this.Fo - this.HR;
                this.Fw = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.HP;
    }

    public int getBottomOffset() {
        return (int) this.HR;
    }

    public void setTopTapBack(boolean z) {
        this.HU = z;
    }

    public void setBottomTapBack(boolean z) {
        this.HV = z;
    }

    public int getState() {
        return this.Fw;
    }

    public void setTopAnimationListener(e eVar) {
        this.Ie = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.If = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Ig = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.HT);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.HT);
        canvas.drawRect(0.0f, 0.0f, this.Fn, this.Fo, this.Fz);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.HT;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HW == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Fw == 10004) {
            switch (action) {
                case 0:
                    this.FA = x;
                    this.FB = y;
                    this.Ib.removeMessages(-100);
                    this.Ib.removeMessages(-104);
                    this.Ib.removeMessages(-101);
                    this.Ib.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.HT);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.FA - this.Fs && i <= this.FA + this.Fs && (i2 < this.FB - this.Fs || i2 > this.FB + this.Fs) && this.Id.aI(i2 - this.FB);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Fw == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Ia = false;
                    if (this.Id.FW) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Id.kF();
                        this.Id.kG();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Id.FW) {
                        if (!this.Ia) {
                            if (y > this.FB) {
                                this.HZ = this.FB + this.Fs;
                                this.Ia = true;
                            } else {
                                this.HZ = this.FB - this.Fs;
                                this.Ia = true;
                            }
                        }
                        this.Id.aJ(this.HZ - y);
                        this.HZ = y;
                        this.Id.FV.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Fw != 10000 || !this.HX.contains(x, y)) && (this.Fw != 10001 || !this.HY.contains(x, y))) {
                    return false;
                }
                if (!this.Id.FW) {
                    this.HZ = y;
                    this.Id.aI(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Id.FW) {
                    this.Id.kF();
                    this.Id.kG();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Id.FW) {
            this.Id.aJ(this.HZ - y);
            this.HZ = y;
            this.Id.FV.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.HP != -1.0f) {
                this.HX.set(i, i2, i3, (int) (i2 + this.HP));
            }
            if (this.HR != -1.0f) {
                this.HY.set(i, (int) (i4 - this.HR), i3, i4);
            }
        }
        if (!this.Ic.FT && !this.Id.FW) {
            kt();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.HQ != -1.0f) {
            this.HP = i3 - this.HS;
        }
        if (this.HS != -1.0f) {
            this.HR = i3 - this.HQ;
        }
        if (!$assertionsDisabled && i3 < this.HP) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.HR) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fn = getMeasuredWidth();
        this.Fo = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        switch (this.Fw) {
            case 10000:
                this.HT = (int) (this.HP - this.Fo);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.HT = (int) (this.Fo - this.HR);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.HT = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Ii;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Ii.Ic.FT) {
                switch (message.what) {
                    case -105:
                        this.Ii.Ic.lr();
                        return;
                    case -104:
                        this.Ii.Ic.lq();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Ii.Ic.lp();
                        return;
                    case -100:
                        this.Ii.Ic.lo();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker FV;
        boolean FW;
        final int FX;
        final int FY;
        final /* synthetic */ VerticalTranslateLayout Ii;

        boolean aI(int i) {
            switch (this.Ii.HW) {
                case top:
                    if (this.Ii.Fw != 10004 && this.Ii.Fw != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.Ii.Fw != 10004 && this.Ii.Fw != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.Ii.Ig != null) {
                        this.Ii.Ig.aO(i);
                        break;
                    }
                    break;
            }
            this.FV = VelocityTracker.obtain();
            this.FW = true;
            return true;
        }

        void kF() {
            this.FW = false;
        }

        void aJ(int i) {
            if (this.FW) {
                int i2 = this.Ii.HT - i;
                switch (this.Ii.HW) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Ii.HP - this.Ii.Fo && i2 < 0) {
                            this.Ii.HT -= i;
                            this.Ii.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Ii.Fo - this.Ii.HR && i2 > 0) {
                            this.Ii.HT -= i;
                            this.Ii.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Ii.HP - this.Ii.Fo && i2 <= this.Ii.Fo - this.Ii.HR) {
                            this.Ii.HT -= i;
                            this.Ii.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kG() {
            float max;
            this.FV.computeCurrentVelocity(this.FX);
            float yVelocity = this.FV.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.FY);
            } else {
                max = Math.max(yVelocity, this.FY);
            }
            switch (this.Ii.HW) {
                case top:
                    C(max);
                    break;
                case bottom:
                    D(max);
                    break;
                case vertical:
                    B(max);
                    break;
            }
            this.FV.recycle();
            this.FV = null;
        }

        private void B(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.Ii.HT;
            if (i <= 0 && i >= this.Ii.HP - this.Ii.Fo) {
                if (f < 0.0f) {
                    this.Ii.Ic.z(f);
                } else {
                    this.Ii.Ic.x(f);
                }
            } else if (i >= 0 && i <= this.Ii.Fo - this.Ii.HR) {
                if (f < 0.0f) {
                    this.Ii.Ic.y(f);
                } else {
                    this.Ii.Ic.A(f);
                }
            }
        }

        private void C(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Ii.Ic.z(f);
            } else {
                this.Ii.Ic.x(f);
            }
        }

        private void D(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Ii.Ic.y(f);
            } else {
                this.Ii.Ic.A(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float FN;
        float FO;
        float FP;
        float FQ;
        long FR;
        long FS;
        boolean FT;
        final /* synthetic */ VerticalTranslateLayout Ii;

        private void ku() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FN = ((((float) (uptimeMillis - this.FR)) / 1000.0f) * this.FO) + this.FN;
            this.FR = uptimeMillis;
            this.FS += 16;
        }

        void lo() {
            ku();
            if (this.FN <= this.FP) {
                e eVar = this.Ii.Ie;
                if (eVar != null) {
                    eVar.lt();
                }
                this.FT = false;
                this.Ii.Fw = 10000;
                this.Ii.kt();
                return;
            }
            this.Ii.HT = (int) (com.baidu.adp.widget.a.a(this.FP, this.FN, false) + this.FQ);
            this.Ii.invalidate();
            this.Ii.Ib.sendEmptyMessageAtTime(-100, this.FS);
        }

        void lp() {
            ku();
            if (this.FN >= this.FP) {
                c cVar = this.Ii.If;
                if (cVar != null) {
                    cVar.ls();
                }
                this.FT = false;
                this.Ii.Fw = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Ii.kt();
                return;
            }
            this.Ii.HT = (int) (com.baidu.adp.widget.a.a(this.FP, this.FN, false) + this.FQ);
            this.Ii.invalidate();
            this.Ii.Ib.sendEmptyMessageAtTime(-101, this.FS);
        }

        void lq() {
            ku();
            if (this.FN >= this.FP) {
                for (d dVar : this.Ii.FJ) {
                    if (dVar != null) {
                        dVar.kC();
                    }
                }
                this.FT = false;
                this.Ii.Fw = 10004;
                this.Ii.kt();
                return;
            }
            this.Ii.HT = (int) (com.baidu.adp.widget.a.a(this.FP, this.FN, false) + this.FQ);
            this.Ii.invalidate();
            this.Ii.Ib.sendEmptyMessageAtTime(-104, this.FS);
        }

        void lr() {
            ku();
            if (this.FN <= this.FP) {
                for (d dVar : this.Ii.FJ) {
                    if (dVar != null) {
                        dVar.kC();
                    }
                }
                this.FT = false;
                this.Ii.Fw = 10004;
                this.Ii.kt();
                return;
            }
            this.Ii.HT = (int) (com.baidu.adp.widget.a.a(this.FP, this.FN, false) + this.FQ);
            this.Ii.invalidate();
            this.Ii.Ib.sendEmptyMessageAtTime(-105, this.FS);
        }

        void x(float f) {
            for (d dVar : this.Ii.FJ) {
                if (dVar != null) {
                    dVar.kB();
                }
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FS = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = 0 - this.Ii.HT;
            this.FQ = this.Ii.HT;
            this.Ii.Ib.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.FP);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Ii.Ib.sendEmptyMessageAtTime(-104, this.FS);
        }

        void y(float f) {
            for (d dVar : this.Ii.FJ) {
                if (dVar != null) {
                    dVar.kB();
                }
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FS = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = 0 - this.Ii.HT;
            this.FQ = this.Ii.HT;
            BdLog.d("Animator@animateBottomOpen " + this.FP);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Ii.Ib.removeMessages(-105);
            this.Ii.Ib.sendEmptyMessageAtTime(-105, this.FS);
        }

        void z(float f) {
            e eVar = this.Ii.Ie;
            if (eVar != null) {
                eVar.kz();
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FS = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = ((-this.Ii.Fo) + this.Ii.HP) - this.Ii.HT;
            this.FQ = this.Ii.HT;
            BdLog.d("Animator@animateTop " + this.FP);
            BdLog.d("Animator@animateTop " + f);
            this.Ii.Ib.removeMessages(-100);
            this.Ii.Ib.sendEmptyMessageAtTime(-100, this.FS);
        }

        void A(float f) {
            c cVar = this.Ii.If;
            if (cVar != null) {
                cVar.kD();
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FS = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = (this.Ii.Fo - this.Ii.HR) - this.Ii.HT;
            this.FQ = this.Ii.HT;
            BdLog.d("Animator@animateBottom " + this.FP);
            BdLog.d("Animator@animateBottom " + f);
            this.Ii.Ib.removeMessages(-101);
            this.Ii.Ib.sendEmptyMessageAtTime(-101, this.FS);
        }
    }
}
