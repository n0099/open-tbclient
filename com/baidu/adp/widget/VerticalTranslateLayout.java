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
    private float DC;
    private float DD;
    private float DE;
    private float DF;
    private int DG;
    private boolean DH;
    private boolean DI;
    private TrackDirection DJ;
    private final Rect DK;
    private final Rect DL;
    private int DM;
    private boolean DN;
    private final a DO;
    private final b DP;
    private final g DQ;
    private e DR;
    private c DS;
    private f DT;
    private final int zC;
    private int zG;
    private final Paint zJ;
    private int zK;
    private int zL;
    private final List<d> zT;
    private int zw;
    private int zx;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (DV) with 'values()' method */
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
        void jN();

        void lj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void jL();

        void jM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void jJ();

        void lk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aP(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.zJ.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.DG = (int) ((this.DC - this.zx) * (-f2));
            } else if (f2 > 0.0f) {
                this.DG = (int) ((this.zx - this.DE) * f2);
            } else if (f2 == 0.0f) {
                this.DG = 0;
                this.zG = 10004;
            } else if (f2 == -1.0f) {
                this.DC -= this.zx;
                this.zG = 10000;
            } else if (f2 == 1.0f) {
                this.DC = this.zx - this.DE;
                this.zG = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.DC;
    }

    public int getBottomOffset() {
        return (int) this.DE;
    }

    public void setTopTapBack(boolean z) {
        this.DH = z;
    }

    public void setBottomTapBack(boolean z) {
        this.DI = z;
    }

    public int getState() {
        return this.zG;
    }

    public void setTopAnimationListener(e eVar) {
        this.DR = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.DS = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.DT = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.DG);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.DG);
        canvas.drawRect(0.0f, 0.0f, this.zw, this.zx, this.zJ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.DG;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.DJ == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.zG == 10004) {
            switch (action) {
                case 0:
                    this.zK = x;
                    this.zL = y;
                    this.DO.removeMessages(-100);
                    this.DO.removeMessages(-104);
                    this.DO.removeMessages(-101);
                    this.DO.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.DG);
                    return j(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean j(int i, int i2) {
        return i >= this.zK - this.zC && i <= this.zK + this.zC && (i2 < this.zL - this.zC || i2 > this.zL + this.zC) && this.DQ.aG(i2 - this.zL);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.zG == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.DN = false;
                    if (this.DQ.Ag) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.DQ.jP();
                        this.DQ.jQ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.DQ.Ag) {
                        if (!this.DN) {
                            if (y > this.zL) {
                                this.DM = this.zL + this.zC;
                                this.DN = true;
                            } else {
                                this.DM = this.zL - this.zC;
                                this.DN = true;
                            }
                        }
                        this.DQ.aH(this.DM - y);
                        this.DM = y;
                        this.DQ.Af.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.zG != 10000 || !this.DK.contains(x, y)) && (this.zG != 10001 || !this.DL.contains(x, y))) {
                    return false;
                }
                if (!this.DQ.Ag) {
                    this.DM = y;
                    this.DQ.aG(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.DQ.Ag) {
                    this.DQ.jP();
                    this.DQ.jQ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.DQ.Ag) {
            this.DQ.aH(this.DM - y);
            this.DM = y;
            this.DQ.Af.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.DC != -1.0f) {
                this.DK.set(i, i2, i3, (int) (i2 + this.DC));
            }
            if (this.DE != -1.0f) {
                this.DL.set(i, (int) (i4 - this.DE), i3, i4);
            }
        }
        if (!this.DP.Ac && !this.DQ.Ag) {
            jD();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.DD != -1.0f) {
            this.DC = i3 - this.DF;
        }
        if (this.DF != -1.0f) {
            this.DE = i3 - this.DD;
        }
        if (!$assertionsDisabled && i3 < this.DC) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.DE) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.zw = getMeasuredWidth();
        this.zx = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jD() {
        switch (this.zG) {
            case 10000:
                this.DG = (int) (this.DC - this.zx);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.DG = (int) (this.zx - this.DE);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.DG = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout DU;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.DU.DP.Ac) {
                switch (message.what) {
                    case -105:
                        this.DU.DP.li();
                        return;
                    case -104:
                        this.DU.DP.lh();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.DU.DP.lg();
                        return;
                    case -100:
                        this.DU.DP.lf();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] DW;
        VelocityTracker Af;
        boolean Ag;
        final int Ah;
        final int Ai;
        final /* synthetic */ VerticalTranslateLayout DU;

        static /* synthetic */ int[] ll() {
            int[] iArr = DW;
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
                DW = iArr;
            }
            return iArr;
        }

        boolean aG(int i) {
            switch (ll()[this.DU.DJ.ordinal()]) {
                case 1:
                    if (this.DU.zG != 10004 && this.DU.zG != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.DU.zG != 10004 && this.DU.zG != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.DU.DT != null) {
                        this.DU.DT.aP(i);
                        break;
                    }
                    break;
            }
            this.Af = VelocityTracker.obtain();
            this.Ag = true;
            return true;
        }

        void jP() {
            this.Ag = false;
        }

        void aH(int i) {
            if (this.Ag) {
                int i2 = this.DU.DG - i;
                switch (ll()[this.DU.DJ.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.DU.DC - this.DU.zx && i2 < 0) {
                            this.DU.DG -= i;
                            this.DU.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.DU.zx - this.DU.DE && i2 > 0) {
                            this.DU.DG -= i;
                            this.DU.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.DU.DC - this.DU.zx && i2 <= this.DU.zx - this.DU.DE) {
                            this.DU.DG -= i;
                            this.DU.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jQ() {
            float max;
            this.Af.computeCurrentVelocity(this.Ah);
            float yVelocity = this.Af.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ai);
            } else {
                max = Math.max(yVelocity, this.Ai);
            }
            switch (ll()[this.DU.DJ.ordinal()]) {
                case 1:
                    N(max);
                    break;
                case 2:
                    O(max);
                    break;
                case 3:
                    M(max);
                    break;
            }
            this.Af.recycle();
            this.Af = null;
        }

        private void M(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.DU.DG;
            if (i <= 0 && i >= this.DU.DC - this.DU.zx) {
                if (f < 0.0f) {
                    this.DU.DP.K(f);
                } else {
                    this.DU.DP.I(f);
                }
            } else if (i >= 0 && i <= this.DU.zx - this.DU.DE) {
                if (f < 0.0f) {
                    this.DU.DP.J(f);
                } else {
                    this.DU.DP.L(f);
                }
            }
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.DU.DP.K(f);
            } else {
                this.DU.DP.I(f);
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.DU.DP.J(f);
            } else {
                this.DU.DP.L(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        long Aa;
        long Ab;
        boolean Ac;
        final /* synthetic */ VerticalTranslateLayout DU;
        float zW;
        float zX;
        float zY;
        float zZ;

        private void jE() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zW = ((((float) (uptimeMillis - this.Aa)) / 1000.0f) * this.zX) + this.zW;
            this.Aa = uptimeMillis;
            this.Ab += 16;
        }

        void lf() {
            jE();
            if (this.zW <= this.zY) {
                e eVar = this.DU.DR;
                if (eVar != null) {
                    eVar.lk();
                }
                this.Ac = false;
                this.DU.zG = 10000;
                this.DU.jD();
                return;
            }
            this.DU.DG = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DU.invalidate();
            this.DU.DO.sendEmptyMessageAtTime(-100, this.Ab);
        }

        void lg() {
            jE();
            if (this.zW >= this.zY) {
                c cVar = this.DU.DS;
                if (cVar != null) {
                    cVar.lj();
                }
                this.Ac = false;
                this.DU.zG = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.DU.jD();
                return;
            }
            this.DU.DG = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DU.invalidate();
            this.DU.DO.sendEmptyMessageAtTime(-101, this.Ab);
        }

        void lh() {
            jE();
            if (this.zW >= this.zY) {
                for (d dVar : this.DU.zT) {
                    if (dVar != null) {
                        dVar.jM();
                    }
                }
                this.Ac = false;
                this.DU.zG = 10004;
                this.DU.jD();
                return;
            }
            this.DU.DG = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DU.invalidate();
            this.DU.DO.sendEmptyMessageAtTime(-104, this.Ab);
        }

        void li() {
            jE();
            if (this.zW <= this.zY) {
                for (d dVar : this.DU.zT) {
                    if (dVar != null) {
                        dVar.jM();
                    }
                }
                this.Ac = false;
                this.DU.zG = 10004;
                this.DU.jD();
                return;
            }
            this.DU.DG = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DU.invalidate();
            this.DU.DO.sendEmptyMessageAtTime(-105, this.Ab);
        }

        void I(float f) {
            for (d dVar : this.DU.zT) {
                if (dVar != null) {
                    dVar.jL();
                }
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = 0 - this.DU.DG;
            this.zZ = this.DU.DG;
            this.DU.DO.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.zY);
            BdLog.d("Animator@animateTopOpen " + f);
            this.DU.DO.sendEmptyMessageAtTime(-104, this.Ab);
        }

        void J(float f) {
            for (d dVar : this.DU.zT) {
                if (dVar != null) {
                    dVar.jL();
                }
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = 0 - this.DU.DG;
            this.zZ = this.DU.DG;
            BdLog.d("Animator@animateBottomOpen " + this.zY);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.DU.DO.removeMessages(-105);
            this.DU.DO.sendEmptyMessageAtTime(-105, this.Ab);
        }

        void K(float f) {
            e eVar = this.DU.DR;
            if (eVar != null) {
                eVar.jJ();
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = ((-this.DU.zx) + this.DU.DC) - this.DU.DG;
            this.zZ = this.DU.DG;
            BdLog.d("Animator@animateTop " + this.zY);
            BdLog.d("Animator@animateTop " + f);
            this.DU.DO.removeMessages(-100);
            this.DU.DO.sendEmptyMessageAtTime(-100, this.Ab);
        }

        void L(float f) {
            c cVar = this.DU.DS;
            if (cVar != null) {
                cVar.jN();
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = (this.DU.zx - this.DU.DE) - this.DU.DG;
            this.zZ = this.DU.DG;
            BdLog.d("Animator@animateBottom " + this.zY);
            BdLog.d("Animator@animateBottom " + f);
            this.DU.DO.removeMessages(-101);
            this.DU.DO.sendEmptyMessageAtTime(-101, this.Ab);
        }
    }
}
