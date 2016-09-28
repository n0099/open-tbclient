package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private float DA;
    private float DC;
    private int DD;
    private boolean DE;
    private boolean DF;
    private TrackDirection DG;
    private final Rect DH;
    private final Rect DI;
    private int DJ;
    private boolean DK;
    private final a DL;
    private final b DM;
    private final g DN;
    private e DO;
    private c DP;
    private f DQ;
    private float Dy;
    private float Dz;
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

        /* JADX DEBUG: Replace access to removed values field (DS) with 'values()' method */
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

        void lg();
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

        void lh();
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
                this.DD = (int) ((this.Dy - this.zx) * (-f2));
            } else if (f2 > 0.0f) {
                this.DD = (int) ((this.zx - this.DA) * f2);
            } else if (f2 == 0.0f) {
                this.DD = 0;
                this.zG = 10004;
            } else if (f2 == -1.0f) {
                this.Dy -= this.zx;
                this.zG = 10000;
            } else if (f2 == 1.0f) {
                this.Dy = this.zx - this.DA;
                this.zG = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Dy;
    }

    public int getBottomOffset() {
        return (int) this.DA;
    }

    public void setTopTapBack(boolean z) {
        this.DE = z;
    }

    public void setBottomTapBack(boolean z) {
        this.DF = z;
    }

    public int getState() {
        return this.zG;
    }

    public void setTopAnimationListener(e eVar) {
        this.DO = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.DP = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.DQ = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.DD);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.DD);
        canvas.drawRect(0.0f, 0.0f, this.zw, this.zx, this.zJ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.DD;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.DG == TrackDirection.none) {
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
                    this.DL.removeMessages(-100);
                    this.DL.removeMessages(-104);
                    this.DL.removeMessages(-101);
                    this.DL.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.DD);
                    return j(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean j(int i, int i2) {
        return i >= this.zK - this.zC && i <= this.zK + this.zC && (i2 < this.zL - this.zC || i2 > this.zL + this.zC) && this.DN.aF(i2 - this.zL);
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
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.DK = false;
                    if (this.DN.Ag) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.DN.jP();
                        this.DN.jQ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.DN.Ag) {
                        if (!this.DK) {
                            if (y > this.zL) {
                                this.DJ = this.zL + this.zC;
                                this.DK = true;
                            } else {
                                this.DJ = this.zL - this.zC;
                                this.DK = true;
                            }
                        }
                        this.DN.aG(this.DJ - y);
                        this.DJ = y;
                        this.DN.Af.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.zG != 10000 || !this.DH.contains(x, y)) && (this.zG != 10001 || !this.DI.contains(x, y))) {
                    return false;
                }
                if (!this.DN.Ag) {
                    this.DJ = y;
                    this.DN.aF(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.DN.Ag) {
                    this.DN.jP();
                    this.DN.jQ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.DN.Ag) {
            this.DN.aG(this.DJ - y);
            this.DJ = y;
            this.DN.Af.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Dy != -1.0f) {
                this.DH.set(i, i2, i3, (int) (i2 + this.Dy));
            }
            if (this.DA != -1.0f) {
                this.DI.set(i, (int) (i4 - this.DA), i3, i4);
            }
        }
        if (!this.DM.Ac && !this.DN.Ag) {
            jD();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Dz != -1.0f) {
            this.Dy = i3 - this.DC;
        }
        if (this.DC != -1.0f) {
            this.DA = i3 - this.Dz;
        }
        if (!$assertionsDisabled && i3 < this.Dy) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.DA) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.zw = getMeasuredWidth();
        this.zx = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jD() {
        switch (this.zG) {
            case 10000:
                this.DD = (int) (this.Dy - this.zx);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.DD = (int) (this.zx - this.DA);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.DD = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout DR;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.DR.DM.Ac) {
                switch (message.what) {
                    case -105:
                        this.DR.DM.lf();
                        return;
                    case -104:
                        this.DR.DM.le();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.DR.DM.ld();
                        return;
                    case -100:
                        this.DR.DM.lc();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] DT;
        VelocityTracker Af;
        boolean Ag;
        final int Ah;
        final int Ai;
        final /* synthetic */ VerticalTranslateLayout DR;

        static /* synthetic */ int[] li() {
            int[] iArr = DT;
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
                DT = iArr;
            }
            return iArr;
        }

        boolean aF(int i) {
            switch (li()[this.DR.DG.ordinal()]) {
                case 1:
                    if (this.DR.zG != 10004 && this.DR.zG != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.DR.zG != 10004 && this.DR.zG != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.DR.DQ != null) {
                        this.DR.DQ.aO(i);
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
                int i2 = this.DR.DD - i;
                switch (li()[this.DR.DG.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.DR.Dy - this.DR.zx && i2 < 0) {
                            this.DR.DD -= i;
                            this.DR.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.DR.zx - this.DR.DA && i2 > 0) {
                            this.DR.DD -= i;
                            this.DR.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.DR.Dy - this.DR.zx && i2 <= this.DR.zx - this.DR.DA) {
                            this.DR.DD -= i;
                            this.DR.invalidate();
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
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ai);
            } else {
                max = Math.max(yVelocity, this.Ai);
            }
            switch (li()[this.DR.DG.ordinal()]) {
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
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.DR.DD;
            if (i <= 0 && i >= this.DR.Dy - this.DR.zx) {
                if (f < 0.0f) {
                    this.DR.DM.K(f);
                } else {
                    this.DR.DM.I(f);
                }
            } else if (i >= 0 && i <= this.DR.zx - this.DR.DA) {
                if (f < 0.0f) {
                    this.DR.DM.J(f);
                } else {
                    this.DR.DM.L(f);
                }
            }
        }

        private void N(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.DR.DM.K(f);
            } else {
                this.DR.DM.I(f);
            }
        }

        private void O(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.DR.DM.J(f);
            } else {
                this.DR.DM.L(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        long Aa;
        long Ab;
        boolean Ac;
        final /* synthetic */ VerticalTranslateLayout DR;
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

        void lc() {
            jE();
            if (this.zW <= this.zY) {
                e eVar = this.DR.DO;
                if (eVar != null) {
                    eVar.lh();
                }
                this.Ac = false;
                this.DR.zG = 10000;
                this.DR.jD();
                return;
            }
            this.DR.DD = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DR.invalidate();
            this.DR.DL.sendEmptyMessageAtTime(-100, this.Ab);
        }

        void ld() {
            jE();
            if (this.zW >= this.zY) {
                c cVar = this.DR.DP;
                if (cVar != null) {
                    cVar.lg();
                }
                this.Ac = false;
                this.DR.zG = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.DR.jD();
                return;
            }
            this.DR.DD = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DR.invalidate();
            this.DR.DL.sendEmptyMessageAtTime(-101, this.Ab);
        }

        void le() {
            jE();
            if (this.zW >= this.zY) {
                for (d dVar : this.DR.zT) {
                    if (dVar != null) {
                        dVar.jM();
                    }
                }
                this.Ac = false;
                this.DR.zG = 10004;
                this.DR.jD();
                return;
            }
            this.DR.DD = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DR.invalidate();
            this.DR.DL.sendEmptyMessageAtTime(-104, this.Ab);
        }

        void lf() {
            jE();
            if (this.zW <= this.zY) {
                for (d dVar : this.DR.zT) {
                    if (dVar != null) {
                        dVar.jM();
                    }
                }
                this.Ac = false;
                this.DR.zG = 10004;
                this.DR.jD();
                return;
            }
            this.DR.DD = (int) (com.baidu.adp.widget.a.a(this.zY, this.zW, false) + this.zZ);
            this.DR.invalidate();
            this.DR.DL.sendEmptyMessageAtTime(-105, this.Ab);
        }

        void I(float f) {
            for (d dVar : this.DR.zT) {
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
            this.zY = 0 - this.DR.DD;
            this.zZ = this.DR.DD;
            this.DR.DL.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.zY);
            Log.d("Animator", "@animateTopOpen " + f);
            this.DR.DL.sendEmptyMessageAtTime(-104, this.Ab);
        }

        void J(float f) {
            for (d dVar : this.DR.zT) {
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
            this.zY = 0 - this.DR.DD;
            this.zZ = this.DR.DD;
            Log.d("Animator", "@animateBottomOpen " + this.zY);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.DR.DL.removeMessages(-105);
            this.DR.DL.sendEmptyMessageAtTime(-105, this.Ab);
        }

        void K(float f) {
            e eVar = this.DR.DO;
            if (eVar != null) {
                eVar.jJ();
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = ((-this.DR.zx) + this.DR.Dy) - this.DR.DD;
            this.zZ = this.DR.DD;
            Log.d("Animator", "@animateTop " + this.zY);
            Log.d("Animator", "@animateTop " + f);
            this.DR.DL.removeMessages(-100);
            this.DR.DL.sendEmptyMessageAtTime(-100, this.Ab);
        }

        void L(float f) {
            c cVar = this.DR.DP;
            if (cVar != null) {
                cVar.jN();
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = (this.DR.zx - this.DR.DA) - this.DR.DD;
            this.zZ = this.DR.DD;
            Log.d("Animator", "@animateBottom " + this.zY);
            Log.d("Animator", "@animateBottom " + f);
            this.DR.DL.removeMessages(-101);
            this.DR.DL.sendEmptyMessageAtTime(-101, this.Ab);
        }
    }
}
