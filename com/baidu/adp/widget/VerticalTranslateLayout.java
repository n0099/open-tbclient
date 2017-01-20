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
    private float CM;
    private float CN;
    private float CO;
    private float CP;
    private int CQ;
    private boolean CR;
    private boolean CS;
    private TrackDirection CT;
    private final Rect CU;
    private final Rect CV;
    private int CW;
    private boolean CX;
    private final a CY;
    private final b CZ;
    private final g Da;
    private e Db;
    private c Dc;
    private f Dd;
    private int zA;
    private int zB;
    private final List<d> zJ;
    private int zm;
    private int zn;
    private final int zs;
    private int zw;
    private final Paint zz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (Df) with 'values()' method */
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
        void jL();

        void lb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void jJ();

        void jK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void jH();

        void lc();
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
        this.zz.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.CQ = (int) ((this.CM - this.zn) * (-f2));
            } else if (f2 > 0.0f) {
                this.CQ = (int) ((this.zn - this.CO) * f2);
            } else if (f2 == 0.0f) {
                this.CQ = 0;
                this.zw = 10004;
            } else if (f2 == -1.0f) {
                this.CM -= this.zn;
                this.zw = 10000;
            } else if (f2 == 1.0f) {
                this.CM = this.zn - this.CO;
                this.zw = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.CM;
    }

    public int getBottomOffset() {
        return (int) this.CO;
    }

    public void setTopTapBack(boolean z) {
        this.CR = z;
    }

    public void setBottomTapBack(boolean z) {
        this.CS = z;
    }

    public int getState() {
        return this.zw;
    }

    public void setTopAnimationListener(e eVar) {
        this.Db = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Dc = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Dd = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.CQ);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.CQ);
        canvas.drawRect(0.0f, 0.0f, this.zm, this.zn, this.zz);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.CQ;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.CT == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.zw == 10004) {
            switch (action) {
                case 0:
                    this.zA = x;
                    this.zB = y;
                    this.CY.removeMessages(-100);
                    this.CY.removeMessages(-104);
                    this.CY.removeMessages(-101);
                    this.CY.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.CQ);
                    return j(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean j(int i, int i2) {
        return i >= this.zA - this.zs && i <= this.zA + this.zs && (i2 < this.zB - this.zs || i2 > this.zB + this.zs) && this.Da.aG(i2 - this.zB);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.zw == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.CX = false;
                    if (this.Da.zV) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Da.jN();
                        this.Da.jO();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Da.zV) {
                        if (!this.CX) {
                            if (y > this.zB) {
                                this.CW = this.zB + this.zs;
                                this.CX = true;
                            } else {
                                this.CW = this.zB - this.zs;
                                this.CX = true;
                            }
                        }
                        this.Da.aH(this.CW - y);
                        this.CW = y;
                        this.Da.zU.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.zw != 10000 || !this.CU.contains(x, y)) && (this.zw != 10001 || !this.CV.contains(x, y))) {
                    return false;
                }
                if (!this.Da.zV) {
                    this.CW = y;
                    this.Da.aG(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Da.zV) {
                    this.Da.jN();
                    this.Da.jO();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Da.zV) {
            this.Da.aH(this.CW - y);
            this.CW = y;
            this.Da.zU.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.CM != -1.0f) {
                this.CU.set(i, i2, i3, (int) (i2 + this.CM));
            }
            if (this.CO != -1.0f) {
                this.CV.set(i, (int) (i4 - this.CO), i3, i4);
            }
        }
        if (!this.CZ.zS && !this.Da.zV) {
            jB();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.CN != -1.0f) {
            this.CM = i3 - this.CP;
        }
        if (this.CP != -1.0f) {
            this.CO = i3 - this.CN;
        }
        if (!$assertionsDisabled && i3 < this.CM) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.CO) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.zm = getMeasuredWidth();
        this.zn = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jB() {
        switch (this.zw) {
            case 10000:
                this.CQ = (int) (this.CM - this.zn);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.CQ = (int) (this.zn - this.CO);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.CQ = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout De;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.De.CZ.zS) {
                switch (message.what) {
                    case -105:
                        this.De.CZ.la();
                        return;
                    case -104:
                        this.De.CZ.kZ();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.De.CZ.kY();
                        return;
                    case -100:
                        this.De.CZ.kX();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Dg;
        final /* synthetic */ VerticalTranslateLayout De;
        VelocityTracker zU;
        boolean zV;
        final int zW;
        final int zX;

        static /* synthetic */ int[] ld() {
            int[] iArr = Dg;
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
                Dg = iArr;
            }
            return iArr;
        }

        boolean aG(int i) {
            switch (ld()[this.De.CT.ordinal()]) {
                case 1:
                    if (this.De.zw != 10004 && this.De.zw != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.De.zw != 10004 && this.De.zw != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.De.Dd != null) {
                        this.De.Dd.aO(i);
                        break;
                    }
                    break;
            }
            this.zU = VelocityTracker.obtain();
            this.zV = true;
            return true;
        }

        void jN() {
            this.zV = false;
        }

        void aH(int i) {
            if (this.zV) {
                int i2 = this.De.CQ - i;
                switch (ld()[this.De.CT.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.De.CM - this.De.zn && i2 < 0) {
                            this.De.CQ -= i;
                            this.De.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.De.zn - this.De.CO && i2 > 0) {
                            this.De.CQ -= i;
                            this.De.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.De.CM - this.De.zn && i2 <= this.De.zn - this.De.CO) {
                            this.De.CQ -= i;
                            this.De.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jO() {
            float max;
            this.zU.computeCurrentVelocity(this.zW);
            float yVelocity = this.zU.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.zX);
            } else {
                max = Math.max(yVelocity, this.zX);
            }
            switch (ld()[this.De.CT.ordinal()]) {
                case 1:
                    O(max);
                    break;
                case 2:
                    P(max);
                    break;
                case 3:
                    N(max);
                    break;
            }
            this.zU.recycle();
            this.zU = null;
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.De.CQ;
            if (i <= 0 && i >= this.De.CM - this.De.zn) {
                if (f < 0.0f) {
                    this.De.CZ.L(f);
                } else {
                    this.De.CZ.J(f);
                }
            } else if (i >= 0 && i <= this.De.zn - this.De.CO) {
                if (f < 0.0f) {
                    this.De.CZ.K(f);
                } else {
                    this.De.CZ.M(f);
                }
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.De.CZ.L(f);
            } else {
                this.De.CZ.J(f);
            }
        }

        private void P(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.De.CZ.K(f);
            } else {
                this.De.CZ.M(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ VerticalTranslateLayout De;
        float zM;
        float zN;
        float zO;
        float zP;
        long zQ;
        long zR;
        boolean zS;

        private void jC() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zM = ((((float) (uptimeMillis - this.zQ)) / 1000.0f) * this.zN) + this.zM;
            this.zQ = uptimeMillis;
            this.zR += 16;
        }

        void kX() {
            jC();
            if (this.zM <= this.zO) {
                e eVar = this.De.Db;
                if (eVar != null) {
                    eVar.lc();
                }
                this.zS = false;
                this.De.zw = 10000;
                this.De.jB();
                return;
            }
            this.De.CQ = (int) (com.baidu.adp.widget.a.a(this.zO, this.zM, false) + this.zP);
            this.De.invalidate();
            this.De.CY.sendEmptyMessageAtTime(-100, this.zR);
        }

        void kY() {
            jC();
            if (this.zM >= this.zO) {
                c cVar = this.De.Dc;
                if (cVar != null) {
                    cVar.lb();
                }
                this.zS = false;
                this.De.zw = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.De.jB();
                return;
            }
            this.De.CQ = (int) (com.baidu.adp.widget.a.a(this.zO, this.zM, false) + this.zP);
            this.De.invalidate();
            this.De.CY.sendEmptyMessageAtTime(-101, this.zR);
        }

        void kZ() {
            jC();
            if (this.zM >= this.zO) {
                for (d dVar : this.De.zJ) {
                    if (dVar != null) {
                        dVar.jK();
                    }
                }
                this.zS = false;
                this.De.zw = 10004;
                this.De.jB();
                return;
            }
            this.De.CQ = (int) (com.baidu.adp.widget.a.a(this.zO, this.zM, false) + this.zP);
            this.De.invalidate();
            this.De.CY.sendEmptyMessageAtTime(-104, this.zR);
        }

        void la() {
            jC();
            if (this.zM <= this.zO) {
                for (d dVar : this.De.zJ) {
                    if (dVar != null) {
                        dVar.jK();
                    }
                }
                this.zS = false;
                this.De.zw = 10004;
                this.De.jB();
                return;
            }
            this.De.CQ = (int) (com.baidu.adp.widget.a.a(this.zO, this.zM, false) + this.zP);
            this.De.invalidate();
            this.De.CY.sendEmptyMessageAtTime(-105, this.zR);
        }

        void J(float f) {
            for (d dVar : this.De.zJ) {
                if (dVar != null) {
                    dVar.jJ();
                }
            }
            this.zS = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zQ = uptimeMillis;
            this.zR = uptimeMillis + 16;
            this.zN = f;
            this.zM = 0.0f;
            this.zO = 0 - this.De.CQ;
            this.zP = this.De.CQ;
            this.De.CY.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.zO);
            BdLog.d("Animator@animateTopOpen " + f);
            this.De.CY.sendEmptyMessageAtTime(-104, this.zR);
        }

        void K(float f) {
            for (d dVar : this.De.zJ) {
                if (dVar != null) {
                    dVar.jJ();
                }
            }
            this.zS = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zQ = uptimeMillis;
            this.zR = uptimeMillis + 16;
            this.zN = f;
            this.zM = 0.0f;
            this.zO = 0 - this.De.CQ;
            this.zP = this.De.CQ;
            BdLog.d("Animator@animateBottomOpen " + this.zO);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.De.CY.removeMessages(-105);
            this.De.CY.sendEmptyMessageAtTime(-105, this.zR);
        }

        void L(float f) {
            e eVar = this.De.Db;
            if (eVar != null) {
                eVar.jH();
            }
            this.zS = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zQ = uptimeMillis;
            this.zR = uptimeMillis + 16;
            this.zN = f;
            this.zM = 0.0f;
            this.zO = ((-this.De.zn) + this.De.CM) - this.De.CQ;
            this.zP = this.De.CQ;
            BdLog.d("Animator@animateTop " + this.zO);
            BdLog.d("Animator@animateTop " + f);
            this.De.CY.removeMessages(-100);
            this.De.CY.sendEmptyMessageAtTime(-100, this.zR);
        }

        void M(float f) {
            c cVar = this.De.Dc;
            if (cVar != null) {
                cVar.jL();
            }
            this.zS = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zQ = uptimeMillis;
            this.zR = uptimeMillis + 16;
            this.zN = f;
            this.zM = 0.0f;
            this.zO = (this.De.zn - this.De.CO) - this.De.CQ;
            this.zP = this.De.CQ;
            BdLog.d("Animator@animateBottom " + this.zO);
            BdLog.d("Animator@animateBottom " + f);
            this.De.CY.removeMessages(-101);
            this.De.CY.sendEmptyMessageAtTime(-101, this.zR);
        }
    }
}
