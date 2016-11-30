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
    private float DA;
    private float DC;
    private float DD;
    private float DE;
    private int DF;
    private boolean DG;
    private boolean DH;
    private TrackDirection DI;
    private final Rect DJ;
    private final Rect DK;
    private int DL;
    private boolean DM;
    private final a DN;
    private final b DO;
    private final g DP;
    private e DQ;
    private c DR;
    private f DS;
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

        /* JADX DEBUG: Replace access to removed values field (DU) with 'values()' method */
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
        void aO(int i);
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
                this.DF = (int) ((this.DA - this.zx) * (-f2));
            } else if (f2 > 0.0f) {
                this.DF = (int) ((this.zx - this.DD) * f2);
            } else if (f2 == 0.0f) {
                this.DF = 0;
                this.zG = 10004;
            } else if (f2 == -1.0f) {
                this.DA -= this.zx;
                this.zG = 10000;
            } else if (f2 == 1.0f) {
                this.DA = this.zx - this.DD;
                this.zG = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.DA;
    }

    public int getBottomOffset() {
        return (int) this.DD;
    }

    public void setTopTapBack(boolean z) {
        this.DG = z;
    }

    public void setBottomTapBack(boolean z) {
        this.DH = z;
    }

    public int getState() {
        return this.zG;
    }

    public void setTopAnimationListener(e eVar) {
        this.DQ = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.DR = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.DS = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.DF);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.DF);
        canvas.drawRect(0.0f, 0.0f, this.zw, this.zx, this.zJ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.DF;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.DI == TrackDirection.none) {
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
                    this.DN.removeMessages(-100);
                    this.DN.removeMessages(-104);
                    this.DN.removeMessages(-101);
                    this.DN.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.DF);
                    return j(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean j(int i, int i2) {
        return i >= this.zK - this.zC && i <= this.zK + this.zC && (i2 < this.zL - this.zC || i2 > this.zL + this.zC) && this.DP.aF(i2 - this.zL);
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
                    this.DM = false;
                    if (this.DP.Ag) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.DP.jP();
                        this.DP.jQ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.DP.Ag) {
                        if (!this.DM) {
                            if (y > this.zL) {
                                this.DL = this.zL + this.zC;
                                this.DM = true;
                            } else {
                                this.DL = this.zL - this.zC;
                                this.DM = true;
                            }
                        }
                        this.DP.aG(this.DL - y);
                        this.DL = y;
                        this.DP.Af.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.zG != 10000 || !this.DJ.contains(x, y)) && (this.zG != 10001 || !this.DK.contains(x, y))) {
                    return false;
                }
                if (!this.DP.Ag) {
                    this.DL = y;
                    this.DP.aF(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.DP.Ag) {
                    this.DP.jP();
                    this.DP.jQ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.DP.Ag) {
            this.DP.aG(this.DL - y);
            this.DL = y;
            this.DP.Af.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.DA != -1.0f) {
                this.DJ.set(i, i2, i3, (int) (i2 + this.DA));
            }
            if (this.DD != -1.0f) {
                this.DK.set(i, (int) (i4 - this.DD), i3, i4);
            }
        }
        if (!this.DO.Ac && !this.DP.Ag) {
            jD();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.DC != -1.0f) {
            this.DA = i3 - this.DE;
        }
        if (this.DE != -1.0f) {
            this.DD = i3 - this.DC;
        }
        if (!$assertionsDisabled && i3 < this.DA) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.DD) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.zw = getMeasuredWidth();
        this.zx = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jD() {
        switch (this.zG) {
            case 10000:
                this.DF = (int) (this.DA - this.zx);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.DF = (int) (this.zx - this.DD);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.DF = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout DT;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.DT.DO.Ac) {
                switch (message.what) {
                    case -105:
                        this.DT.DO.li();
                        return;
                    case -104:
                        this.DT.DO.lh();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.DT.DO.lg();
                        return;
                    case -100:
                        this.DT.DO.lf();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] DV;
        VelocityTracker Af;
        boolean Ag;
        final int Ah;
        final int Ai;
        final /* synthetic */ VerticalTranslateLayout DT;

        static /* synthetic */ int[] ll() {
            int[] iArr = DV;
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
                DV = iArr;
            }
            return iArr;
        }

        boolean aF(int i) {
            switch (ll()[this.DT.DI.ordinal()]) {
                case 1:
                    if (this.DT.zG != 10004 && this.DT.zG != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.DT.zG != 10004 && this.DT.zG != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.DT.DS != null) {
                        this.DT.DS.aO(i);
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

        void aG(int i) {
            if (this.Ag) {
                int i2 = this.DT.DF - i;
                switch (ll()[this.DT.DI.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.DT.DA - this.DT.zx && i2 < 0) {
                            this.DT.DF -= i;
                            this.DT.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.DT.zx - this.DT.DD && i2 > 0) {
                            this.DT.DF -= i;
                            this.DT.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.DT.DA - this.DT.zx && i2 <= this.DT.zx - this.DT.DD) {
                            this.DT.DF -= i;
                            this.DT.invalidate();
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
            switch (ll()[this.DT.DI.ordinal()]) {
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
            int i = this.DT.DF;
            if (i <= 0 && i >= this.DT.DA - this.DT.zx) {
                if (f < 0.0f) {
                    this.DT.DO.K(f);
                } else {
                    this.DT.DO.I(f);
                }
            } else if (i >= 0 && i <= this.DT.zx - this.DT.DD) {
                if (f < 0.0f) {
                    this.DT.DO.J(f);
                } else {
                    this.DT.DO.L(f);
                }
            }
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.DT.DO.K(f);
            } else {
                this.DT.DO.I(f);
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.DT.DO.J(f);
            } else {
                this.DT.DO.L(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        long Aa;
        long Ab;
        boolean Ac;
        final /* synthetic */ VerticalTranslateLayout DT;
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
                e eVar = this.DT.DQ;
                if (eVar != null) {
                    eVar.lk();
                }
                this.Ac = false;
                this.DT.zG = 10000;
                this.DT.jD();
                return;
            }
            this.DT.DF = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DT.invalidate();
            this.DT.DN.sendEmptyMessageAtTime(-100, this.Ab);
        }

        void lg() {
            jE();
            if (this.zW >= this.zY) {
                c cVar = this.DT.DR;
                if (cVar != null) {
                    cVar.lj();
                }
                this.Ac = false;
                this.DT.zG = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.DT.jD();
                return;
            }
            this.DT.DF = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DT.invalidate();
            this.DT.DN.sendEmptyMessageAtTime(-101, this.Ab);
        }

        void lh() {
            jE();
            if (this.zW >= this.zY) {
                for (d dVar : this.DT.zT) {
                    if (dVar != null) {
                        dVar.jM();
                    }
                }
                this.Ac = false;
                this.DT.zG = 10004;
                this.DT.jD();
                return;
            }
            this.DT.DF = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DT.invalidate();
            this.DT.DN.sendEmptyMessageAtTime(-104, this.Ab);
        }

        void li() {
            jE();
            if (this.zW <= this.zY) {
                for (d dVar : this.DT.zT) {
                    if (dVar != null) {
                        dVar.jM();
                    }
                }
                this.Ac = false;
                this.DT.zG = 10004;
                this.DT.jD();
                return;
            }
            this.DT.DF = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DT.invalidate();
            this.DT.DN.sendEmptyMessageAtTime(-105, this.Ab);
        }

        void I(float f) {
            for (d dVar : this.DT.zT) {
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
            this.zY = 0 - this.DT.DF;
            this.zZ = this.DT.DF;
            this.DT.DN.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.zY);
            BdLog.d("Animator@animateTopOpen " + f);
            this.DT.DN.sendEmptyMessageAtTime(-104, this.Ab);
        }

        void J(float f) {
            for (d dVar : this.DT.zT) {
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
            this.zY = 0 - this.DT.DF;
            this.zZ = this.DT.DF;
            BdLog.d("Animator@animateBottomOpen " + this.zY);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.DT.DN.removeMessages(-105);
            this.DT.DN.sendEmptyMessageAtTime(-105, this.Ab);
        }

        void K(float f) {
            e eVar = this.DT.DQ;
            if (eVar != null) {
                eVar.jJ();
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = ((-this.DT.zx) + this.DT.DA) - this.DT.DF;
            this.zZ = this.DT.DF;
            BdLog.d("Animator@animateTop " + this.zY);
            BdLog.d("Animator@animateTop " + f);
            this.DT.DN.removeMessages(-100);
            this.DT.DN.sendEmptyMessageAtTime(-100, this.Ab);
        }

        void L(float f) {
            c cVar = this.DT.DR;
            if (cVar != null) {
                cVar.jN();
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = (this.DT.zx - this.DT.DD) - this.DT.DF;
            this.zZ = this.DT.DF;
            BdLog.d("Animator@animateBottom " + this.zY);
            BdLog.d("Animator@animateBottom " + f);
            this.DT.DN.removeMessages(-101);
            this.DT.DN.sendEmptyMessageAtTime(-101, this.Ab);
        }
    }
}
