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
    private int zA;
    private int zB;
    private int zC;
    private boolean zD;
    private final a zE;
    private final b zF;
    private final g zG;
    private d zH;
    private f zI;
    private final List<e> zJ;
    private c zK;
    private int zm;
    private float zp;
    private float zq;
    private int zr;
    private final int zs;
    private boolean zt;
    private boolean zu;
    private TrackDirection zv;
    private int zw;
    private final Rect zx;
    private final Rect zy;
    private final Paint zz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (zT) with 'values()' method */
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
        void jH();

        void jI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void jJ();

        void jK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void jL();

        void jM();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.zz.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.zr = (int) ((this.zp - this.zm) * (-f2));
            } else if (f2 > 0.0f) {
                this.zr = (int) ((this.zm - this.zq) * f2);
            } else if (f2 == 0.0f) {
                this.zr = 0;
                this.zw = 10004;
            } else if (f2 == -1.0f) {
                this.zp -= getMeasuredWidth();
                this.zw = 10000;
            } else if (f2 == 1.0f) {
                this.zp = getMeasuredWidth() - this.zq;
                this.zw = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.zp;
    }

    public int getRightOffset() {
        return (int) this.zq;
    }

    public void setLeftTapBack(boolean z) {
        this.zt = z;
    }

    public void setRightTapBack(boolean z) {
        this.zu = z;
    }

    public int getState() {
        return this.zw;
    }

    public void setLeftAnimationListener(d dVar) {
        this.zH = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.zI = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.zK = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.zr, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.zr);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.zz);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.zr;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zv == TrackDirection.none) {
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
                    this.zE.removeMessages(-100);
                    this.zE.removeMessages(-104);
                    this.zE.removeMessages(-101);
                    this.zE.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.zr, 0.0f);
                    return j(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean j(int i, int i2) {
        return i2 >= this.zB - this.zs && i2 <= this.zB + this.zs && (i < this.zA - this.zs || i > this.zA + this.zs) && this.zG.aG(i - this.zA);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.zD = false;
                    if (this.zG.zV) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.zG.jN();
                        this.zG.jO();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.zG.zV) {
                        if (!this.zD) {
                            if (x > this.zA) {
                                this.zC = this.zA + this.zs;
                                this.zD = true;
                            } else {
                                this.zC = this.zA - this.zs;
                                this.zD = true;
                            }
                        }
                        this.zG.aH(this.zC - x);
                        this.zC = x;
                        this.zG.zU.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.zx);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.zy);
        switch (action) {
            case 0:
                if ((this.zw != 10000 || !this.zx.contains(x, y)) && (this.zw != 10001 || !this.zy.contains(x, y))) {
                    return false;
                }
                if (!this.zG.zV) {
                    this.zC = x;
                    this.zG.aG(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.zG.zV) {
                    this.zG.jN();
                    this.zG.jO();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.zG.zV) {
            this.zG.aH(this.zC - x);
            this.zC = x;
            this.zG.zU.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.zp != -1.0f) {
                this.zx.set(i, i2, (int) (i + this.zp), i4);
            }
            if (this.zq != -1.0f) {
                this.zy.set((int) (i3 - this.zq), i2, i3, i4);
            }
        }
        if (!this.zF.zS && !this.zG.zV) {
            jB();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.zp) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.zq) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.zm = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jB() {
        switch (this.zw) {
            case 10000:
                this.zr = (int) (this.zp - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.zr = (int) (getMeasuredWidth() - this.zq);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.zr = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout zL;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.zL.zF.zS) {
                switch (message.what) {
                    case -105:
                        this.zL.zF.jG();
                        return;
                    case -104:
                        this.zL.zF.jF();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.zL.zF.jE();
                        return;
                    case -100:
                        this.zL.zF.jD();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] zY;
        final /* synthetic */ HorizontalTranslateLayout zL;
        VelocityTracker zU;
        boolean zV;
        final int zW;
        final int zX;

        static /* synthetic */ int[] jP() {
            int[] iArr = zY;
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
                zY = iArr;
            }
            return iArr;
        }

        boolean aG(int i) {
            switch (jP()[this.zL.zv.ordinal()]) {
                case 1:
                    if (this.zL.zw != 10004 && this.zL.zw != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.zL.zw != 10004 && this.zL.zw != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.zL.zK != null) {
                        this.zL.zK.aF(i);
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
                int i2 = this.zL.zr - i;
                switch (jP()[this.zL.zv.ordinal()]) {
                    case 1:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > this.zL.zp - this.zL.getMeasuredWidth() && i2 < 0) {
                            this.zL.zr -= i;
                            this.zL.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < this.zL.getMeasuredWidth() - this.zL.zq && i2 > 0) {
                            this.zL.zr -= i;
                            this.zL.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= this.zL.zp - this.zL.getMeasuredWidth() && i2 <= this.zL.getMeasuredWidth() - this.zL.zq) {
                            this.zL.zr -= i;
                            this.zL.invalidate();
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
            float xVelocity = this.zU.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.zX);
            } else {
                max = Math.max(xVelocity, this.zX);
            }
            switch (jP()[this.zL.zv.ordinal()]) {
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
            this.zU.recycle();
            this.zU = null;
        }

        private void C(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = this.zL.zr;
            if (i <= 0 && i >= this.zL.zp - this.zL.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.zL.zF.A(f);
                } else {
                    this.zL.zF.y(f);
                }
            } else if (i >= 0 && i <= this.zL.getMeasuredWidth() - this.zL.zq) {
                if (f < 0.0f) {
                    this.zL.zF.z(f);
                } else {
                    this.zL.zF.B(f);
                }
            }
        }

        private void D(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                this.zL.zF.A(f);
            } else {
                this.zL.zF.y(f);
            }
        }

        private void E(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                this.zL.zF.z(f);
            } else {
                this.zL.zF.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout zL;
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

        void jD() {
            jC();
            if (this.zM <= this.zO) {
                d dVar = this.zL.zH;
                if (dVar != null) {
                    dVar.jI();
                }
                this.zS = false;
                this.zL.zw = 10000;
                this.zL.jB();
                return;
            }
            this.zL.zr = (int) (com.baidu.adp.widget.g.a(this.zO, this.zM, false) + this.zP);
            this.zL.invalidate();
            this.zL.zE.sendEmptyMessageAtTime(-100, this.zR);
        }

        void jE() {
            jC();
            if (this.zM >= this.zO) {
                f fVar = this.zL.zI;
                if (fVar != null) {
                    fVar.jM();
                }
                this.zS = false;
                this.zL.zw = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.zL.jB();
                return;
            }
            this.zL.zr = (int) (com.baidu.adp.widget.g.a(this.zO, this.zM, false) + this.zP);
            this.zL.invalidate();
            this.zL.zE.sendEmptyMessageAtTime(-101, this.zR);
        }

        void jF() {
            jC();
            if (this.zM >= this.zO) {
                for (e eVar : this.zL.zJ) {
                    if (eVar != null) {
                        eVar.jK();
                    }
                }
                this.zS = false;
                this.zL.zw = 10004;
                this.zL.jB();
                return;
            }
            this.zL.zr = (int) (com.baidu.adp.widget.g.a(this.zO, this.zM, false) + this.zP);
            this.zL.invalidate();
            this.zL.zE.sendEmptyMessageAtTime(-104, this.zR);
        }

        void jG() {
            jC();
            if (this.zM <= this.zO) {
                for (e eVar : this.zL.zJ) {
                    if (eVar != null) {
                        eVar.jK();
                    }
                }
                this.zS = false;
                this.zL.zw = 10004;
                this.zL.jB();
                return;
            }
            this.zL.zr = (int) (com.baidu.adp.widget.g.a(this.zO, this.zM, false) + this.zP);
            this.zL.invalidate();
            this.zL.zE.sendEmptyMessageAtTime(-105, this.zR);
        }

        void y(float f) {
            for (e eVar : this.zL.zJ) {
                if (eVar != null) {
                    eVar.jJ();
                }
            }
            this.zS = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zQ = uptimeMillis;
            this.zR = uptimeMillis + 16;
            this.zN = f;
            this.zM = 0.0f;
            this.zO = 0 - this.zL.zr;
            this.zP = this.zL.zr;
            this.zL.zE.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.zO);
            BdLog.d("Animator@animateTopOpen " + f);
            this.zL.zE.sendEmptyMessageAtTime(-104, this.zR);
        }

        void z(float f) {
            for (e eVar : this.zL.zJ) {
                if (eVar != null) {
                    eVar.jJ();
                }
            }
            this.zS = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zQ = uptimeMillis;
            this.zR = uptimeMillis + 16;
            this.zN = f;
            this.zM = 0.0f;
            this.zO = 0 - this.zL.zr;
            this.zP = this.zL.zr;
            BdLog.d("Animator@animateBottomOpen " + this.zO);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.zL.zE.removeMessages(-105);
            this.zL.zE.sendEmptyMessageAtTime(-105, this.zR);
        }

        void A(float f) {
            d dVar = this.zL.zH;
            if (dVar != null) {
                dVar.jH();
            }
            this.zS = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zQ = uptimeMillis;
            this.zR = uptimeMillis + 16;
            this.zN = f;
            this.zM = 0.0f;
            this.zO = ((-this.zL.getMeasuredWidth()) + this.zL.zp) - this.zL.zr;
            this.zP = this.zL.zr;
            BdLog.d("Animator@animateTop " + this.zO);
            BdLog.d("Animator@animateTop " + f);
            this.zL.zE.removeMessages(-100);
            this.zL.zE.sendEmptyMessageAtTime(-100, this.zR);
        }

        void B(float f) {
            f fVar = this.zL.zI;
            if (fVar != null) {
                fVar.jL();
            }
            this.zS = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.zQ = uptimeMillis;
            this.zR = uptimeMillis + 16;
            this.zN = f;
            this.zM = 0.0f;
            this.zO = (this.zL.getMeasuredWidth() - this.zL.zq) - this.zL.zr;
            this.zP = this.zL.zr;
            BdLog.d("Animator@animateBottom " + this.zO);
            BdLog.d("Animator@animateBottom " + f);
            this.zL.zE.removeMessages(-101);
            this.zL.zE.sendEmptyMessageAtTime(-101, this.zR);
        }
    }
}
