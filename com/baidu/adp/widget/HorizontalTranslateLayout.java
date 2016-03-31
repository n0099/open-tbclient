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
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Rect GA;
    private final Rect GB;
    private final Paint GC;
    private int GD;
    private int GE;
    private int GF;
    private boolean GG;
    private final a GH;
    private final b GI;
    private final g GJ;
    private d GK;
    private f GL;
    private final List<e> GM;
    private c GN;
    private int Gp;
    private float Gs;
    private float Gt;
    private int Gu;
    private final int Gv;
    private boolean Gw;
    private boolean Gx;
    private TrackDirection Gy;
    private int Gz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (GW) with 'values()' method */
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
        void aA(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void my();

        void mz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mA();

        void mB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mC();

        void mD();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.GC.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Gu = (int) ((this.Gs - this.Gp) * (-f2));
            } else if (f2 > 0.0f) {
                this.Gu = (int) ((this.Gp - this.Gt) * f2);
            } else if (f2 == 0.0f) {
                this.Gu = 0;
                this.Gz = 10004;
            } else if (f2 == -1.0f) {
                this.Gs -= getMeasuredWidth();
                this.Gz = 10000;
            } else if (f2 == 1.0f) {
                this.Gs = getMeasuredWidth() - this.Gt;
                this.Gz = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Gs;
    }

    public int getRightOffset() {
        return (int) this.Gt;
    }

    public void setLeftTapBack(boolean z) {
        this.Gw = z;
    }

    public void setRightTapBack(boolean z) {
        this.Gx = z;
    }

    public int getState() {
        return this.Gz;
    }

    public void setLeftAnimationListener(d dVar) {
        this.GK = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.GL = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.GN = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Gu, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.Gu);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.GC);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Gu;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Gy == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Gz == 10004) {
            switch (action) {
                case 0:
                    this.GD = x;
                    this.GE = y;
                    this.GH.removeMessages(-100);
                    this.GH.removeMessages(-104);
                    this.GH.removeMessages(-101);
                    this.GH.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Gu, 0.0f);
                    return h(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.GE - this.Gv && i2 <= this.GE + this.Gv && (i < this.GD - this.Gv || i > this.GD + this.Gv) && this.GJ.aB(i - this.GD);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Gz == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.GG = false;
                    if (this.GJ.GY) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.GJ.mE();
                        this.GJ.mF();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.GJ.GY) {
                        if (!this.GG) {
                            if (x > this.GD) {
                                this.GF = this.GD + this.Gv;
                                this.GG = true;
                            } else {
                                this.GF = this.GD - this.Gv;
                                this.GG = true;
                            }
                        }
                        this.GJ.aC(this.GF - x);
                        this.GF = x;
                        this.GJ.GX.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.GA);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.GB);
        switch (action) {
            case 0:
                if ((this.Gz != 10000 || !this.GA.contains(x, y)) && (this.Gz != 10001 || !this.GB.contains(x, y))) {
                    return false;
                }
                if (!this.GJ.GY) {
                    this.GF = x;
                    this.GJ.aB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.GJ.GY) {
                    this.GJ.mE();
                    this.GJ.mF();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.GJ.GY) {
            this.GJ.aC(this.GF - x);
            this.GF = x;
            this.GJ.GX.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Gs != -1.0f) {
                this.GA.set(i, i2, (int) (i + this.Gs), i4);
            }
            if (this.Gt != -1.0f) {
                this.GB.set((int) (i3 - this.Gt), i2, i3, i4);
            }
        }
        if (!this.GI.GV && !this.GJ.GY) {
            ms();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Gs) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Gt) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Gp = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms() {
        switch (this.Gz) {
            case 10000:
                this.Gu = (int) (this.Gs - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Gu = (int) (getMeasuredWidth() - this.Gt);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Gu = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout GO;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.GO.GI.GV) {
                switch (message.what) {
                    case -105:
                        this.GO.GI.mx();
                        return;
                    case -104:
                        this.GO.GI.mw();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.GO.GI.mv();
                        return;
                    case -100:
                        this.GO.GI.mt();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Hb;
        final /* synthetic */ HorizontalTranslateLayout GO;
        VelocityTracker GX;
        boolean GY;
        final int GZ;
        final int Ha;

        static /* synthetic */ int[] mG() {
            int[] iArr = Hb;
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
                Hb = iArr;
            }
            return iArr;
        }

        boolean aB(int i) {
            switch (mG()[this.GO.Gy.ordinal()]) {
                case 1:
                    if (this.GO.Gz != 10004 && this.GO.Gz != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.GO.Gz != 10004 && this.GO.Gz != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.GO.GN != null) {
                        this.GO.GN.aA(i);
                        break;
                    }
                    break;
            }
            this.GX = VelocityTracker.obtain();
            this.GY = true;
            return true;
        }

        void mE() {
            this.GY = false;
        }

        void aC(int i) {
            if (this.GY) {
                int i2 = this.GO.Gu - i;
                switch (mG()[this.GO.Gy.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.GO.Gs - this.GO.getMeasuredWidth() && i2 < 0) {
                            this.GO.Gu -= i;
                            this.GO.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.GO.getMeasuredWidth() - this.GO.Gt && i2 > 0) {
                            this.GO.Gu -= i;
                            this.GO.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.GO.Gs - this.GO.getMeasuredWidth() && i2 <= this.GO.getMeasuredWidth() - this.GO.Gt) {
                            this.GO.Gu -= i;
                            this.GO.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mF() {
            float max;
            this.GX.computeCurrentVelocity(this.GZ);
            float xVelocity = this.GX.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Ha);
            } else {
                max = Math.max(xVelocity, this.Ha);
            }
            switch (mG()[this.GO.Gy.ordinal()]) {
                case 1:
                    j(max);
                    break;
                case 2:
                    k(max);
                    break;
                case 3:
                    i(max);
                    break;
            }
            this.GX.recycle();
            this.GX = null;
        }

        private void i(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.GO.Gu;
            if (i <= 0 && i >= this.GO.Gs - this.GO.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.GO.GI.e(f);
                } else {
                    this.GO.GI.c(f);
                }
            } else if (i >= 0 && i <= this.GO.getMeasuredWidth() - this.GO.Gt) {
                if (f < 0.0f) {
                    this.GO.GI.d(f);
                } else {
                    this.GO.GI.g(f);
                }
            }
        }

        private void j(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.GO.GI.e(f);
            } else {
                this.GO.GI.c(f);
            }
        }

        private void k(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.GO.GI.d(f);
            } else {
                this.GO.GI.g(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout GO;
        float GP;
        float GQ;
        float GR;
        float GS;
        long GT;
        long GU;
        boolean GV;

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GP = ((((float) (uptimeMillis - this.GT)) / 1000.0f) * this.GQ) + this.GP;
            this.GT = uptimeMillis;
            this.GU += 16;
        }

        void mt() {
            compute();
            if (this.GP <= this.GR) {
                d dVar = this.GO.GK;
                if (dVar != null) {
                    dVar.mz();
                }
                this.GV = false;
                this.GO.Gz = 10000;
                this.GO.ms();
                return;
            }
            this.GO.Gu = (int) (com.baidu.adp.widget.g.a(this.GR, this.GP, false) + this.GS);
            this.GO.invalidate();
            this.GO.GH.sendEmptyMessageAtTime(-100, this.GU);
        }

        void mv() {
            compute();
            if (this.GP >= this.GR) {
                f fVar = this.GO.GL;
                if (fVar != null) {
                    fVar.mD();
                }
                this.GV = false;
                this.GO.Gz = 10001;
                this.GO.ms();
                return;
            }
            this.GO.Gu = (int) (com.baidu.adp.widget.g.a(this.GR, this.GP, false) + this.GS);
            this.GO.invalidate();
            this.GO.GH.sendEmptyMessageAtTime(-101, this.GU);
        }

        void mw() {
            compute();
            if (this.GP >= this.GR) {
                for (e eVar : this.GO.GM) {
                    if (eVar != null) {
                        eVar.mB();
                    }
                }
                this.GV = false;
                this.GO.Gz = 10004;
                this.GO.ms();
                return;
            }
            this.GO.Gu = (int) (com.baidu.adp.widget.g.a(this.GR, this.GP, false) + this.GS);
            this.GO.invalidate();
            this.GO.GH.sendEmptyMessageAtTime(-104, this.GU);
        }

        void mx() {
            compute();
            if (this.GP <= this.GR) {
                for (e eVar : this.GO.GM) {
                    if (eVar != null) {
                        eVar.mB();
                    }
                }
                this.GV = false;
                this.GO.Gz = 10004;
                this.GO.ms();
                return;
            }
            this.GO.Gu = (int) (com.baidu.adp.widget.g.a(this.GR, this.GP, false) + this.GS);
            this.GO.invalidate();
            this.GO.GH.sendEmptyMessageAtTime(-105, this.GU);
        }

        void c(float f) {
            for (e eVar : this.GO.GM) {
                if (eVar != null) {
                    eVar.mA();
                }
            }
            this.GV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GT = uptimeMillis;
            this.GU = uptimeMillis + 16;
            this.GQ = f;
            this.GP = 0.0f;
            this.GR = 0 - this.GO.Gu;
            this.GS = this.GO.Gu;
            this.GO.GH.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.GR);
            Log.d("Animator", "@animateTopOpen " + f);
            this.GO.GH.sendEmptyMessageAtTime(-104, this.GU);
        }

        void d(float f) {
            for (e eVar : this.GO.GM) {
                if (eVar != null) {
                    eVar.mA();
                }
            }
            this.GV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GT = uptimeMillis;
            this.GU = uptimeMillis + 16;
            this.GQ = f;
            this.GP = 0.0f;
            this.GR = 0 - this.GO.Gu;
            this.GS = this.GO.Gu;
            Log.d("Animator", "@animateBottomOpen " + this.GR);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.GO.GH.removeMessages(-105);
            this.GO.GH.sendEmptyMessageAtTime(-105, this.GU);
        }

        void e(float f) {
            d dVar = this.GO.GK;
            if (dVar != null) {
                dVar.my();
            }
            this.GV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GT = uptimeMillis;
            this.GU = uptimeMillis + 16;
            this.GQ = f;
            this.GP = 0.0f;
            this.GR = ((-this.GO.getMeasuredWidth()) + this.GO.Gs) - this.GO.Gu;
            this.GS = this.GO.Gu;
            Log.d("Animator", "@animateTop " + this.GR);
            Log.d("Animator", "@animateTop " + f);
            this.GO.GH.removeMessages(-100);
            this.GO.GH.sendEmptyMessageAtTime(-100, this.GU);
        }

        void g(float f) {
            f fVar = this.GO.GL;
            if (fVar != null) {
                fVar.mC();
            }
            this.GV = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GT = uptimeMillis;
            this.GU = uptimeMillis + 16;
            this.GQ = f;
            this.GP = 0.0f;
            this.GR = (this.GO.getMeasuredWidth() - this.GO.Gt) - this.GO.Gu;
            this.GS = this.GO.Gu;
            Log.d("Animator", "@animateBottom " + this.GR);
            Log.d("Animator", "@animateBottom " + f);
            this.GO.GH.removeMessages(-101);
            this.GO.GH.sendEmptyMessageAtTime(-101, this.GU);
        }
    }
}
