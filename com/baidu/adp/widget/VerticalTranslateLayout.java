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
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.shell.SapiErrorCode;
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
    private float HO;
    private float HP;
    private float HQ;
    private float HR;
    private int HS;
    private boolean HT;
    private boolean HU;
    private TrackDirection HV;
    private final Rect HW;
    private final Rect HX;
    private int HY;
    private boolean HZ;
    private final a Ia;
    private final b Ib;
    private final g Ic;
    private e Id;
    private c Ie;
    private f If;

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
        void aN(int i);
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
                this.HS = (int) ((this.HO - this.Fo) * (-f2));
            } else if (f2 > 0.0f) {
                this.HS = (int) ((this.Fo - this.HQ) * f2);
            } else if (f2 == 0.0f) {
                this.HS = 0;
                this.Fw = 10004;
            } else if (f2 == -1.0f) {
                this.HO -= this.Fo;
                this.Fw = 10000;
            } else if (f2 == 1.0f) {
                this.HO = this.Fo - this.HQ;
                this.Fw = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.HO;
    }

    public int getBottomOffset() {
        return (int) this.HQ;
    }

    public void setTopTapBack(boolean z) {
        this.HT = z;
    }

    public void setBottomTapBack(boolean z) {
        this.HU = z;
    }

    public int getState() {
        return this.Fw;
    }

    public void setTopAnimationListener(e eVar) {
        this.Id = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Ie = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.If = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.HS);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.HS);
        canvas.drawRect(0.0f, 0.0f, this.Fn, this.Fo, this.Fz);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.HS;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HV == TrackDirection.none) {
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
                    this.Ia.removeMessages(-100);
                    this.Ia.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Ia.removeMessages(-101);
                    this.Ia.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.HS);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.FA - this.Fs && i <= this.FA + this.Fs && (i2 < this.FB - this.Fs || i2 > this.FB + this.Fs) && this.Ic.aH(i2 - this.FB);
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
                    this.HZ = false;
                    if (this.Ic.FX) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Ic.kF();
                        this.Ic.kG();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Ic.FX) {
                        if (!this.HZ) {
                            if (y > this.FB) {
                                this.HY = this.FB + this.Fs;
                                this.HZ = true;
                            } else {
                                this.HY = this.FB - this.Fs;
                                this.HZ = true;
                            }
                        }
                        this.Ic.aI(this.HY - y);
                        this.HY = y;
                        this.Ic.FW.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Fw != 10000 || !this.HW.contains(x, y)) && (this.Fw != 10001 || !this.HX.contains(x, y))) {
                    return false;
                }
                if (!this.Ic.FX) {
                    this.HY = y;
                    this.Ic.aH(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Ic.FX) {
                    this.Ic.kF();
                    this.Ic.kG();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Ic.FX) {
            this.Ic.aI(this.HY - y);
            this.HY = y;
            this.Ic.FW.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.HO != -1.0f) {
                this.HW.set(i, i2, i3, (int) (i2 + this.HO));
            }
            if (this.HQ != -1.0f) {
                this.HX.set(i, (int) (i4 - this.HQ), i3, i4);
            }
        }
        if (!this.Ib.FU && !this.Ic.FX) {
            kt();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.HP != -1.0f) {
            this.HO = i3 - this.HR;
        }
        if (this.HR != -1.0f) {
            this.HQ = i3 - this.HP;
        }
        if (!$assertionsDisabled && i3 < this.HO) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.HQ) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fn = getMeasuredWidth();
        this.Fo = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        switch (this.Fw) {
            case 10000:
                this.HS = (int) (this.HO - this.Fo);
                invalidate();
                return;
            case 10001:
                this.HS = (int) (this.Fo - this.HQ);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.HS = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Ih;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Ih.Ib.FU) {
                switch (message.what) {
                    case -105:
                        this.Ih.Ib.lr();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.Ih.Ib.lq();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.Ih.Ib.lp();
                        return;
                    case -100:
                        this.Ih.Ib.lo();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker FW;
        boolean FX;
        final int FY;
        final int FZ;
        final /* synthetic */ VerticalTranslateLayout Ih;

        boolean aH(int i) {
            switch (this.Ih.HV) {
                case top:
                    if (this.Ih.Fw != 10004 && this.Ih.Fw != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.Ih.Fw != 10004 && this.Ih.Fw != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.Ih.If != null) {
                        this.Ih.If.aN(i);
                        break;
                    }
                    break;
            }
            this.FW = VelocityTracker.obtain();
            this.FX = true;
            return true;
        }

        void kF() {
            this.FX = false;
        }

        void aI(int i) {
            if (this.FX) {
                int i2 = this.Ih.HS - i;
                switch (this.Ih.HV) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Ih.HO - this.Ih.Fo && i2 < 0) {
                            this.Ih.HS -= i;
                            this.Ih.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Ih.Fo - this.Ih.HQ && i2 > 0) {
                            this.Ih.HS -= i;
                            this.Ih.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Ih.HO - this.Ih.Fo && i2 <= this.Ih.Fo - this.Ih.HQ) {
                            this.Ih.HS -= i;
                            this.Ih.invalidate();
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
            this.FW.computeCurrentVelocity(this.FY);
            float yVelocity = this.FW.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.FZ);
            } else {
                max = Math.max(yVelocity, this.FZ);
            }
            switch (this.Ih.HV) {
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
            this.FW.recycle();
            this.FW = null;
        }

        private void B(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.Ih.HS;
            if (i <= 0 && i >= this.Ih.HO - this.Ih.Fo) {
                if (f < 0.0f) {
                    this.Ih.Ib.z(f);
                } else {
                    this.Ih.Ib.x(f);
                }
            } else if (i >= 0 && i <= this.Ih.Fo - this.Ih.HQ) {
                if (f < 0.0f) {
                    this.Ih.Ib.y(f);
                } else {
                    this.Ih.Ib.A(f);
                }
            }
        }

        private void C(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Ih.Ib.z(f);
            } else {
                this.Ih.Ib.x(f);
            }
        }

        private void D(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Ih.Ib.y(f);
            } else {
                this.Ih.Ib.A(f);
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
        long FT;
        boolean FU;
        final /* synthetic */ VerticalTranslateLayout Ih;

        private void ku() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FN = ((((float) (uptimeMillis - this.FR)) / 1000.0f) * this.FO) + this.FN;
            this.FR = uptimeMillis;
            this.FT += 16;
        }

        void lo() {
            ku();
            if (this.FN <= this.FP) {
                e eVar = this.Ih.Id;
                if (eVar != null) {
                    eVar.lt();
                }
                this.FU = false;
                this.Ih.Fw = 10000;
                this.Ih.kt();
                return;
            }
            this.Ih.HS = (int) (com.baidu.adp.widget.a.a(this.FP, this.FN, false) + this.FQ);
            this.Ih.invalidate();
            this.Ih.Ia.sendEmptyMessageAtTime(-100, this.FT);
        }

        void lp() {
            ku();
            if (this.FN >= this.FP) {
                c cVar = this.Ih.Ie;
                if (cVar != null) {
                    cVar.ls();
                }
                this.FU = false;
                this.Ih.Fw = 10001;
                this.Ih.kt();
                return;
            }
            this.Ih.HS = (int) (com.baidu.adp.widget.a.a(this.FP, this.FN, false) + this.FQ);
            this.Ih.invalidate();
            this.Ih.Ia.sendEmptyMessageAtTime(-101, this.FT);
        }

        void lq() {
            ku();
            if (this.FN >= this.FP) {
                for (d dVar : this.Ih.FJ) {
                    if (dVar != null) {
                        dVar.kC();
                    }
                }
                this.FU = false;
                this.Ih.Fw = 10004;
                this.Ih.kt();
                return;
            }
            this.Ih.HS = (int) (com.baidu.adp.widget.a.a(this.FP, this.FN, false) + this.FQ);
            this.Ih.invalidate();
            this.Ih.Ia.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.FT);
        }

        void lr() {
            ku();
            if (this.FN <= this.FP) {
                for (d dVar : this.Ih.FJ) {
                    if (dVar != null) {
                        dVar.kC();
                    }
                }
                this.FU = false;
                this.Ih.Fw = 10004;
                this.Ih.kt();
                return;
            }
            this.Ih.HS = (int) (com.baidu.adp.widget.a.a(this.FP, this.FN, false) + this.FQ);
            this.Ih.invalidate();
            this.Ih.Ia.sendEmptyMessageAtTime(-105, this.FT);
        }

        void x(float f) {
            for (d dVar : this.Ih.FJ) {
                if (dVar != null) {
                    dVar.kB();
                }
            }
            this.FU = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FT = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = 0 - this.Ih.HS;
            this.FQ = this.Ih.HS;
            this.Ih.Ia.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.FP);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Ih.Ia.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.FT);
        }

        void y(float f) {
            for (d dVar : this.Ih.FJ) {
                if (dVar != null) {
                    dVar.kB();
                }
            }
            this.FU = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FT = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = 0 - this.Ih.HS;
            this.FQ = this.Ih.HS;
            BdLog.d("Animator@animateBottomOpen " + this.FP);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Ih.Ia.removeMessages(-105);
            this.Ih.Ia.sendEmptyMessageAtTime(-105, this.FT);
        }

        void z(float f) {
            e eVar = this.Ih.Id;
            if (eVar != null) {
                eVar.kz();
            }
            this.FU = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FT = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = ((-this.Ih.Fo) + this.Ih.HO) - this.Ih.HS;
            this.FQ = this.Ih.HS;
            BdLog.d("Animator@animateTop " + this.FP);
            BdLog.d("Animator@animateTop " + f);
            this.Ih.Ia.removeMessages(-100);
            this.Ih.Ia.sendEmptyMessageAtTime(-100, this.FT);
        }

        void A(float f) {
            c cVar = this.Ih.Ie;
            if (cVar != null) {
                cVar.kD();
            }
            this.FU = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FR = uptimeMillis;
            this.FT = uptimeMillis + 16;
            this.FO = f;
            this.FN = 0.0f;
            this.FP = (this.Ih.Fo - this.Ih.HQ) - this.Ih.HS;
            this.FQ = this.Ih.HS;
            BdLog.d("Animator@animateBottom " + this.FP);
            BdLog.d("Animator@animateBottom " + f);
            this.Ih.Ia.removeMessages(-101);
            this.Ih.Ia.sendEmptyMessageAtTime(-101, this.FT);
        }
    }
}
