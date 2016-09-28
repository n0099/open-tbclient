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
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private float zA;
    private int zB;
    private final int zC;
    private boolean zD;
    private boolean zE;
    private TrackDirection zF;
    private int zG;
    private final Rect zH;
    private final Rect zI;
    private final Paint zJ;
    private int zK;
    private int zL;
    private int zM;
    private boolean zN;
    private final a zO;
    private final b zP;
    private final g zQ;
    private d zR;
    private f zS;
    private final List<e> zT;
    private c zU;
    private int zw;
    private float zz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (Ae) with 'values()' method */
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
        void aE(int i);
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
        void jL();

        void jM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void jN();

        void jO();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.zJ.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.zB = (int) ((this.zz - this.zw) * (-f2));
            } else if (f2 > 0.0f) {
                this.zB = (int) ((this.zw - this.zA) * f2);
            } else if (f2 == 0.0f) {
                this.zB = 0;
                this.zG = 10004;
            } else if (f2 == -1.0f) {
                this.zz -= getMeasuredWidth();
                this.zG = 10000;
            } else if (f2 == 1.0f) {
                this.zz = getMeasuredWidth() - this.zA;
                this.zG = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.zz;
    }

    public int getRightOffset() {
        return (int) this.zA;
    }

    public void setLeftTapBack(boolean z) {
        this.zD = z;
    }

    public void setRightTapBack(boolean z) {
        this.zE = z;
    }

    public int getState() {
        return this.zG;
    }

    public void setLeftAnimationListener(d dVar) {
        this.zR = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.zS = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.zU = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.zB, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.zB);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.zJ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.zB;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zF == TrackDirection.none) {
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
                    this.zO.removeMessages(-100);
                    this.zO.removeMessages(-104);
                    this.zO.removeMessages(-101);
                    this.zO.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.zB, 0.0f);
                    return j(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean j(int i, int i2) {
        return i2 >= this.zL - this.zC && i2 <= this.zL + this.zC && (i < this.zK - this.zC || i > this.zK + this.zC) && this.zQ.aF(i - this.zK);
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
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.zN = false;
                    if (this.zQ.Ag) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.zQ.jP();
                        this.zQ.jQ();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.zQ.Ag) {
                        if (!this.zN) {
                            if (x > this.zK) {
                                this.zM = this.zK + this.zC;
                                this.zN = true;
                            } else {
                                this.zM = this.zK - this.zC;
                                this.zN = true;
                            }
                        }
                        this.zQ.aG(this.zM - x);
                        this.zM = x;
                        this.zQ.Af.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.zH);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.zI);
        switch (action) {
            case 0:
                if ((this.zG != 10000 || !this.zH.contains(x, y)) && (this.zG != 10001 || !this.zI.contains(x, y))) {
                    return false;
                }
                if (!this.zQ.Ag) {
                    this.zM = x;
                    this.zQ.aF(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.zQ.Ag) {
                    this.zQ.jP();
                    this.zQ.jQ();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.zQ.Ag) {
            this.zQ.aG(this.zM - x);
            this.zM = x;
            this.zQ.Af.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.zz != -1.0f) {
                this.zH.set(i, i2, (int) (i + this.zz), i4);
            }
            if (this.zA != -1.0f) {
                this.zI.set((int) (i3 - this.zA), i2, i3, i4);
            }
        }
        if (!this.zP.Ac && !this.zQ.Ag) {
            jD();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.zz) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.zA) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.zw = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jD() {
        switch (this.zG) {
            case 10000:
                this.zB = (int) (this.zz - getMeasuredWidth());
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.zB = (int) (getMeasuredWidth() - this.zA);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.zB = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout zV;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.zV.zP.Ac) {
                switch (message.what) {
                    case -105:
                        this.zV.zP.jI();
                        return;
                    case -104:
                        this.zV.zP.jH();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.zV.zP.jG();
                        return;
                    case -100:
                        this.zV.zP.jF();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Aj;
        VelocityTracker Af;
        boolean Ag;
        final int Ah;
        final int Ai;
        final /* synthetic */ HorizontalTranslateLayout zV;

        static /* synthetic */ int[] jR() {
            int[] iArr = Aj;
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
                Aj = iArr;
            }
            return iArr;
        }

        boolean aF(int i) {
            switch (jR()[this.zV.zF.ordinal()]) {
                case 1:
                    if (this.zV.zG != 10004 && this.zV.zG != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.zV.zG != 10004 && this.zV.zG != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.zV.zU != null) {
                        this.zV.zU.aE(i);
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
                int i2 = this.zV.zB - i;
                switch (jR()[this.zV.zF.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.zV.zz - this.zV.getMeasuredWidth() && i2 < 0) {
                            this.zV.zB -= i;
                            this.zV.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.zV.getMeasuredWidth() - this.zV.zA && i2 > 0) {
                            this.zV.zB -= i;
                            this.zV.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.zV.zz - this.zV.getMeasuredWidth() && i2 <= this.zV.getMeasuredWidth() - this.zV.zA) {
                            this.zV.zB -= i;
                            this.zV.invalidate();
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
            float xVelocity = this.Af.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Ai);
            } else {
                max = Math.max(xVelocity, this.Ai);
            }
            switch (jR()[this.zV.zF.ordinal()]) {
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
            this.Af.recycle();
            this.Af = null;
        }

        private void C(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.zV.zB;
            if (i <= 0 && i >= this.zV.zz - this.zV.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.zV.zP.A(f);
                } else {
                    this.zV.zP.y(f);
                }
            } else if (i >= 0 && i <= this.zV.getMeasuredWidth() - this.zV.zA) {
                if (f < 0.0f) {
                    this.zV.zP.z(f);
                } else {
                    this.zV.zP.B(f);
                }
            }
        }

        private void D(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.zV.zP.A(f);
            } else {
                this.zV.zP.y(f);
            }
        }

        private void E(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.zV.zP.z(f);
            } else {
                this.zV.zP.B(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        long Aa;
        long Ab;
        boolean Ac;
        final /* synthetic */ HorizontalTranslateLayout zV;
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

        void jF() {
            jE();
            if (this.zW <= this.zY) {
                d dVar = this.zV.zR;
                if (dVar != null) {
                    dVar.jK();
                }
                this.Ac = false;
                this.zV.zG = 10000;
                this.zV.jD();
                return;
            }
            this.zV.zB = (int) (com.baidu.adp.widget.g.a(this.zY, this.zW, false) + this.zZ);
            this.zV.invalidate();
            this.zV.zO.sendEmptyMessageAtTime(-100, this.Ab);
        }

        void jG() {
            jE();
            if (this.zW >= this.zY) {
                f fVar = this.zV.zS;
                if (fVar != null) {
                    fVar.jO();
                }
                this.Ac = false;
                this.zV.zG = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.zV.jD();
                return;
            }
            this.zV.zB = (int) (com.baidu.adp.widget.g.a(this.zY, this.zW, false) + this.zZ);
            this.zV.invalidate();
            this.zV.zO.sendEmptyMessageAtTime(-101, this.Ab);
        }

        void jH() {
            jE();
            if (this.zW >= this.zY) {
                for (e eVar : this.zV.zT) {
                    if (eVar != null) {
                        eVar.jM();
                    }
                }
                this.Ac = false;
                this.zV.zG = 10004;
                this.zV.jD();
                return;
            }
            this.zV.zB = (int) (com.baidu.adp.widget.g.a(this.zY, this.zW, false) + this.zZ);
            this.zV.invalidate();
            this.zV.zO.sendEmptyMessageAtTime(-104, this.Ab);
        }

        void jI() {
            jE();
            if (this.zW <= this.zY) {
                for (e eVar : this.zV.zT) {
                    if (eVar != null) {
                        eVar.jM();
                    }
                }
                this.Ac = false;
                this.zV.zG = 10004;
                this.zV.jD();
                return;
            }
            this.zV.zB = (int) (com.baidu.adp.widget.g.a(this.zY, this.zW, false) + this.zZ);
            this.zV.invalidate();
            this.zV.zO.sendEmptyMessageAtTime(-105, this.Ab);
        }

        void y(float f) {
            for (e eVar : this.zV.zT) {
                if (eVar != null) {
                    eVar.jL();
                }
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = 0 - this.zV.zB;
            this.zZ = this.zV.zB;
            this.zV.zO.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.zY);
            Log.d("Animator", "@animateTopOpen " + f);
            this.zV.zO.sendEmptyMessageAtTime(-104, this.Ab);
        }

        void z(float f) {
            for (e eVar : this.zV.zT) {
                if (eVar != null) {
                    eVar.jL();
                }
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = 0 - this.zV.zB;
            this.zZ = this.zV.zB;
            Log.d("Animator", "@animateBottomOpen " + this.zY);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.zV.zO.removeMessages(-105);
            this.zV.zO.sendEmptyMessageAtTime(-105, this.Ab);
        }

        void A(float f) {
            d dVar = this.zV.zR;
            if (dVar != null) {
                dVar.jJ();
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = ((-this.zV.getMeasuredWidth()) + this.zV.zz) - this.zV.zB;
            this.zZ = this.zV.zB;
            Log.d("Animator", "@animateTop " + this.zY);
            Log.d("Animator", "@animateTop " + f);
            this.zV.zO.removeMessages(-100);
            this.zV.zO.sendEmptyMessageAtTime(-100, this.Ab);
        }

        void B(float f) {
            f fVar = this.zV.zS;
            if (fVar != null) {
                fVar.jN();
            }
            this.Ac = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Aa = uptimeMillis;
            this.Ab = uptimeMillis + 16;
            this.zX = f;
            this.zW = 0.0f;
            this.zY = (this.zV.getMeasuredWidth() - this.zV.zA) - this.zV.zB;
            this.zZ = this.zV.zB;
            Log.d("Animator", "@animateBottom " + this.zY);
            Log.d("Animator", "@animateBottom " + f);
            this.zV.zO.removeMessages(-101);
            this.zV.zO.sendEmptyMessageAtTime(-101, this.Ab);
        }
    }
}
