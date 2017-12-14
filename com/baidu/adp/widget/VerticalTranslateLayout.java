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
    private final List<d> FI;
    private int Fm;
    private int Fn;
    private final int Fr;
    private int Fv;
    private final Paint Fy;
    private int Fz;
    private float HN;
    private float HO;
    private float HP;
    private float HQ;
    private int HR;
    private boolean HS;
    private boolean HT;
    private TrackDirection HU;
    private final Rect HV;
    private final Rect HW;
    private int HX;
    private boolean HY;
    private final a HZ;
    private final b Ia;
    private final g Ib;
    private e Ic;
    private c Id;
    private f Ie;

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
        this.Fy.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.HR = (int) ((this.HN - this.Fn) * (-f2));
            } else if (f2 > 0.0f) {
                this.HR = (int) ((this.Fn - this.HP) * f2);
            } else if (f2 == 0.0f) {
                this.HR = 0;
                this.Fv = 10004;
            } else if (f2 == -1.0f) {
                this.HN -= this.Fn;
                this.Fv = 10000;
            } else if (f2 == 1.0f) {
                this.HN = this.Fn - this.HP;
                this.Fv = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.HN;
    }

    public int getBottomOffset() {
        return (int) this.HP;
    }

    public void setTopTapBack(boolean z) {
        this.HS = z;
    }

    public void setBottomTapBack(boolean z) {
        this.HT = z;
    }

    public int getState() {
        return this.Fv;
    }

    public void setTopAnimationListener(e eVar) {
        this.Ic = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Id = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Ie = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.HR);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.HR);
        canvas.drawRect(0.0f, 0.0f, this.Fm, this.Fn, this.Fy);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.HR;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.HU == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Fv == 10004) {
            switch (action) {
                case 0:
                    this.Fz = x;
                    this.FA = y;
                    this.HZ.removeMessages(-100);
                    this.HZ.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.HZ.removeMessages(-101);
                    this.HZ.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.HR);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Fz - this.Fr && i <= this.Fz + this.Fr && (i2 < this.FA - this.Fr || i2 > this.FA + this.Fr) && this.Ib.aH(i2 - this.FA);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Fv == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.HY = false;
                    if (this.Ib.FW) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Ib.kF();
                        this.Ib.kG();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Ib.FW) {
                        if (!this.HY) {
                            if (y > this.FA) {
                                this.HX = this.FA + this.Fr;
                                this.HY = true;
                            } else {
                                this.HX = this.FA - this.Fr;
                                this.HY = true;
                            }
                        }
                        this.Ib.aI(this.HX - y);
                        this.HX = y;
                        this.Ib.FV.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Fv != 10000 || !this.HV.contains(x, y)) && (this.Fv != 10001 || !this.HW.contains(x, y))) {
                    return false;
                }
                if (!this.Ib.FW) {
                    this.HX = y;
                    this.Ib.aH(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Ib.FW) {
                    this.Ib.kF();
                    this.Ib.kG();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Ib.FW) {
            this.Ib.aI(this.HX - y);
            this.HX = y;
            this.Ib.FV.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.HN != -1.0f) {
                this.HV.set(i, i2, i3, (int) (i2 + this.HN));
            }
            if (this.HP != -1.0f) {
                this.HW.set(i, (int) (i4 - this.HP), i3, i4);
            }
        }
        if (!this.Ia.FT && !this.Ib.FW) {
            kt();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.HO != -1.0f) {
            this.HN = i3 - this.HQ;
        }
        if (this.HQ != -1.0f) {
            this.HP = i3 - this.HO;
        }
        if (!$assertionsDisabled && i3 < this.HN) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.HP) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Fm = getMeasuredWidth();
        this.Fn = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt() {
        switch (this.Fv) {
            case 10000:
                this.HR = (int) (this.HN - this.Fn);
                invalidate();
                return;
            case 10001:
                this.HR = (int) (this.Fn - this.HP);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.HR = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Ig;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Ig.Ia.FT) {
                switch (message.what) {
                    case -105:
                        this.Ig.Ia.lr();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        this.Ig.Ia.lq();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        this.Ig.Ia.lp();
                        return;
                    case -100:
                        this.Ig.Ia.lo();
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
        final /* synthetic */ VerticalTranslateLayout Ig;

        boolean aH(int i) {
            switch (this.Ig.HU) {
                case top:
                    if (this.Ig.Fv != 10004 && this.Ig.Fv != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (this.Ig.Fv != 10004 && this.Ig.Fv != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (this.Ig.Ie != null) {
                        this.Ig.Ie.aN(i);
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

        void aI(int i) {
            if (this.FW) {
                int i2 = this.Ig.HR - i;
                switch (this.Ig.HU) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Ig.HN - this.Ig.Fn && i2 < 0) {
                            this.Ig.HR -= i;
                            this.Ig.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Ig.Fn - this.Ig.HP && i2 > 0) {
                            this.Ig.HR -= i;
                            this.Ig.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Ig.HN - this.Ig.Fn && i2 <= this.Ig.Fn - this.Ig.HP) {
                            this.Ig.HR -= i;
                            this.Ig.invalidate();
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
            switch (this.Ig.HU) {
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
            int i = this.Ig.HR;
            if (i <= 0 && i >= this.Ig.HN - this.Ig.Fn) {
                if (f < 0.0f) {
                    this.Ig.Ia.z(f);
                } else {
                    this.Ig.Ia.x(f);
                }
            } else if (i >= 0 && i <= this.Ig.Fn - this.Ig.HP) {
                if (f < 0.0f) {
                    this.Ig.Ia.y(f);
                } else {
                    this.Ig.Ia.A(f);
                }
            }
        }

        private void C(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Ig.Ia.z(f);
            } else {
                this.Ig.Ia.x(f);
            }
        }

        private void D(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Ig.Ia.y(f);
            } else {
                this.Ig.Ia.A(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float FM;
        float FN;
        float FO;
        float FP;
        long FQ;
        long FR;
        boolean FT;
        final /* synthetic */ VerticalTranslateLayout Ig;

        private void ku() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FM = ((((float) (uptimeMillis - this.FQ)) / 1000.0f) * this.FN) + this.FM;
            this.FQ = uptimeMillis;
            this.FR += 16;
        }

        void lo() {
            ku();
            if (this.FM <= this.FO) {
                e eVar = this.Ig.Ic;
                if (eVar != null) {
                    eVar.lt();
                }
                this.FT = false;
                this.Ig.Fv = 10000;
                this.Ig.kt();
                return;
            }
            this.Ig.HR = (int) (com.baidu.adp.widget.a.a(this.FO, this.FM, false) + this.FP);
            this.Ig.invalidate();
            this.Ig.HZ.sendEmptyMessageAtTime(-100, this.FR);
        }

        void lp() {
            ku();
            if (this.FM >= this.FO) {
                c cVar = this.Ig.Id;
                if (cVar != null) {
                    cVar.ls();
                }
                this.FT = false;
                this.Ig.Fv = 10001;
                this.Ig.kt();
                return;
            }
            this.Ig.HR = (int) (com.baidu.adp.widget.a.a(this.FO, this.FM, false) + this.FP);
            this.Ig.invalidate();
            this.Ig.HZ.sendEmptyMessageAtTime(-101, this.FR);
        }

        void lq() {
            ku();
            if (this.FM >= this.FO) {
                for (d dVar : this.Ig.FI) {
                    if (dVar != null) {
                        dVar.kC();
                    }
                }
                this.FT = false;
                this.Ig.Fv = 10004;
                this.Ig.kt();
                return;
            }
            this.Ig.HR = (int) (com.baidu.adp.widget.a.a(this.FO, this.FM, false) + this.FP);
            this.Ig.invalidate();
            this.Ig.HZ.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.FR);
        }

        void lr() {
            ku();
            if (this.FM <= this.FO) {
                for (d dVar : this.Ig.FI) {
                    if (dVar != null) {
                        dVar.kC();
                    }
                }
                this.FT = false;
                this.Ig.Fv = 10004;
                this.Ig.kt();
                return;
            }
            this.Ig.HR = (int) (com.baidu.adp.widget.a.a(this.FO, this.FM, false) + this.FP);
            this.Ig.invalidate();
            this.Ig.HZ.sendEmptyMessageAtTime(-105, this.FR);
        }

        void x(float f) {
            for (d dVar : this.Ig.FI) {
                if (dVar != null) {
                    dVar.kB();
                }
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = uptimeMillis;
            this.FR = uptimeMillis + 16;
            this.FN = f;
            this.FM = 0.0f;
            this.FO = 0 - this.Ig.HR;
            this.FP = this.Ig.HR;
            this.Ig.HZ.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.FO);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Ig.HZ.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.FR);
        }

        void y(float f) {
            for (d dVar : this.Ig.FI) {
                if (dVar != null) {
                    dVar.kB();
                }
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = uptimeMillis;
            this.FR = uptimeMillis + 16;
            this.FN = f;
            this.FM = 0.0f;
            this.FO = 0 - this.Ig.HR;
            this.FP = this.Ig.HR;
            BdLog.d("Animator@animateBottomOpen " + this.FO);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Ig.HZ.removeMessages(-105);
            this.Ig.HZ.sendEmptyMessageAtTime(-105, this.FR);
        }

        void z(float f) {
            e eVar = this.Ig.Ic;
            if (eVar != null) {
                eVar.kz();
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = uptimeMillis;
            this.FR = uptimeMillis + 16;
            this.FN = f;
            this.FM = 0.0f;
            this.FO = ((-this.Ig.Fn) + this.Ig.HN) - this.Ig.HR;
            this.FP = this.Ig.HR;
            BdLog.d("Animator@animateTop " + this.FO);
            BdLog.d("Animator@animateTop " + f);
            this.Ig.HZ.removeMessages(-100);
            this.Ig.HZ.sendEmptyMessageAtTime(-100, this.FR);
        }

        void A(float f) {
            c cVar = this.Ig.Id;
            if (cVar != null) {
                cVar.kD();
            }
            this.FT = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.FQ = uptimeMillis;
            this.FR = uptimeMillis + 16;
            this.FN = f;
            this.FM = 0.0f;
            this.FO = (this.Ig.Fn - this.Ig.HP) - this.Ig.HR;
            this.FP = this.Ig.HR;
            BdLog.d("Animator@animateBottom " + this.FO);
            BdLog.d("Animator@animateBottom " + f);
            this.Ig.HZ.removeMessages(-101);
            this.Ig.HZ.sendEmptyMessageAtTime(-101, this.FR);
        }
    }
}
