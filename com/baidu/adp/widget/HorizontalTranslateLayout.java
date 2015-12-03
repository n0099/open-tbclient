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
    private int FG;
    private float FJ;
    private float FK;
    private int FL;
    private final int FM;
    private boolean FN;
    private boolean FO;
    private TrackDirection FP;
    private int FQ;
    private final Rect FR;
    private final Rect FS;
    private final Paint FT;
    private int FU;
    private int FV;
    private int FW;
    private boolean FX;
    private final a FY;
    private final b FZ;
    private final g Ga;
    private d Gb;
    private f Gc;
    private final List<e> Gd;
    private c Ge;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (Gn) with 'values()' method */
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
        void aw(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mU();

        void mV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mW();

        void mX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mY();

        void mZ();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FT.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.FL = (int) ((this.FJ - this.FG) * (-f2));
            } else if (f2 > 0.0f) {
                this.FL = (int) ((this.FG - this.FK) * f2);
            } else if (f2 == 0.0f) {
                this.FL = 0;
                this.FQ = 10004;
            } else if (f2 == -1.0f) {
                this.FJ -= getMeasuredWidth();
                this.FQ = 10000;
            } else if (f2 == 1.0f) {
                this.FJ = getMeasuredWidth() - this.FK;
                this.FQ = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.FJ;
    }

    public int getRightOffset() {
        return (int) this.FK;
    }

    public void setLeftTapBack(boolean z) {
        this.FN = z;
    }

    public void setRightTapBack(boolean z) {
        this.FO = z;
    }

    public int getState() {
        return this.FQ;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Gb = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Gc = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Ge = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.FL, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.FL);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.FT);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.FL;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.FP == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.FQ == 10004) {
            switch (action) {
                case 0:
                    this.FU = x;
                    this.FV = y;
                    this.FY.removeMessages(-100);
                    this.FY.removeMessages(-104);
                    this.FY.removeMessages(-101);
                    this.FY.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.FL, 0.0f);
                    return h(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i2 >= this.FV - this.FM && i2 <= this.FV + this.FM && (i < this.FU - this.FM || i > this.FU + this.FM) && this.Ga.ax(i - this.FU);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.FQ == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.FX = false;
                    if (this.Ga.Gp) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.Ga.na();
                        this.Ga.nb();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Ga.Gp) {
                        if (!this.FX) {
                            if (x > this.FU) {
                                this.FW = this.FU + this.FM;
                                this.FX = true;
                            } else {
                                this.FW = this.FU - this.FM;
                                this.FX = true;
                            }
                        }
                        this.Ga.ay(this.FW - x);
                        this.FW = x;
                        this.Ga.Go.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.FR);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.FS);
        switch (action) {
            case 0:
                if ((this.FQ != 10000 || !this.FR.contains(x, y)) && (this.FQ != 10001 || !this.FS.contains(x, y))) {
                    return false;
                }
                if (!this.Ga.Gp) {
                    this.FW = x;
                    this.Ga.ax(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Ga.Gp) {
                    this.Ga.na();
                    this.Ga.nb();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Ga.Gp) {
            this.Ga.ay(this.FW - x);
            this.FW = x;
            this.Ga.Go.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.FJ != -1.0f) {
                this.FR.set(i, i2, (int) (i + this.FJ), i4);
            }
            if (this.FK != -1.0f) {
                this.FS.set((int) (i3 - this.FK), i2, i3, i4);
            }
        }
        if (!this.FZ.Gm && !this.Ga.Gp) {
            mO();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.FJ) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.FK) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.FG = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO() {
        switch (this.FQ) {
            case 10000:
                this.FL = (int) (this.FJ - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.FL = (int) (getMeasuredWidth() - this.FK);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.FL = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout Gf;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Gf.FZ.Gm) {
                switch (message.what) {
                    case -105:
                        this.Gf.FZ.mT();
                        return;
                    case -104:
                        this.Gf.FZ.mS();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Gf.FZ.mR();
                        return;
                    case -100:
                        this.Gf.FZ.mQ();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Gs;
        final /* synthetic */ HorizontalTranslateLayout Gf;
        VelocityTracker Go;
        boolean Gp;
        final int Gq;
        final int Gr;

        static /* synthetic */ int[] nc() {
            int[] iArr = Gs;
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
                Gs = iArr;
            }
            return iArr;
        }

        boolean ax(int i) {
            switch (nc()[this.Gf.FP.ordinal()]) {
                case 1:
                    if (this.Gf.FQ != 10004 && this.Gf.FQ != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Gf.FQ != 10004 && this.Gf.FQ != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Gf.Ge != null) {
                        this.Gf.Ge.aw(i);
                        break;
                    }
                    break;
            }
            this.Go = VelocityTracker.obtain();
            this.Gp = true;
            return true;
        }

        void na() {
            this.Gp = false;
        }

        void ay(int i) {
            if (this.Gp) {
                int i2 = this.Gf.FL - i;
                switch (nc()[this.Gf.FP.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.Gf.FJ - this.Gf.getMeasuredWidth() && i2 < 0) {
                            this.Gf.FL -= i;
                            this.Gf.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.Gf.getMeasuredWidth() - this.Gf.FK && i2 > 0) {
                            this.Gf.FL -= i;
                            this.Gf.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.Gf.FJ - this.Gf.getMeasuredWidth() && i2 <= this.Gf.getMeasuredWidth() - this.Gf.FK) {
                            this.Gf.FL -= i;
                            this.Gf.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void nb() {
            float max;
            this.Go.computeCurrentVelocity(this.Gq);
            float xVelocity = this.Go.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Gr);
            } else {
                max = Math.max(xVelocity, this.Gr);
            }
            switch (nc()[this.Gf.FP.ordinal()]) {
                case 1:
                    h(max);
                    break;
                case 2:
                    i(max);
                    break;
                case 3:
                    g(max);
                    break;
            }
            this.Go.recycle();
            this.Go = null;
        }

        private void g(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.Gf.FL;
            if (i <= 0 && i >= this.Gf.FJ - this.Gf.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.Gf.FZ.e(f);
                } else {
                    this.Gf.FZ.c(f);
                }
            } else if (i >= 0 && i <= this.Gf.getMeasuredWidth() - this.Gf.FK) {
                if (f < 0.0f) {
                    this.Gf.FZ.d(f);
                } else {
                    this.Gf.FZ.f(f);
                }
            }
        }

        private void h(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.Gf.FZ.e(f);
            } else {
                this.Gf.FZ.c(f);
            }
        }

        private void i(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.Gf.FZ.d(f);
            } else {
                this.Gf.FZ.f(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ HorizontalTranslateLayout Gf;
        float Gg;
        float Gh;
        float Gi;
        float Gj;
        long Gk;
        long Gl;
        boolean Gm;

        private void mP() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = ((((float) (uptimeMillis - this.Gk)) / 1000.0f) * this.Gh) + this.Gg;
            this.Gk = uptimeMillis;
            this.Gl += 16;
        }

        void mQ() {
            mP();
            if (this.Gg <= this.Gi) {
                d dVar = this.Gf.Gb;
                if (dVar != null) {
                    dVar.mV();
                }
                this.Gm = false;
                this.Gf.FQ = 10000;
                this.Gf.mO();
                return;
            }
            this.Gf.FL = (int) (com.baidu.adp.widget.g.a(this.Gi, this.Gg, false) + this.Gj);
            this.Gf.invalidate();
            this.Gf.FY.sendEmptyMessageAtTime(-100, this.Gl);
        }

        void mR() {
            mP();
            if (this.Gg >= this.Gi) {
                f fVar = this.Gf.Gc;
                if (fVar != null) {
                    fVar.mZ();
                }
                this.Gm = false;
                this.Gf.FQ = 10001;
                this.Gf.mO();
                return;
            }
            this.Gf.FL = (int) (com.baidu.adp.widget.g.a(this.Gi, this.Gg, false) + this.Gj);
            this.Gf.invalidate();
            this.Gf.FY.sendEmptyMessageAtTime(-101, this.Gl);
        }

        void mS() {
            mP();
            if (this.Gg >= this.Gi) {
                for (e eVar : this.Gf.Gd) {
                    if (eVar != null) {
                        eVar.mX();
                    }
                }
                this.Gm = false;
                this.Gf.FQ = 10004;
                this.Gf.mO();
                return;
            }
            this.Gf.FL = (int) (com.baidu.adp.widget.g.a(this.Gi, this.Gg, false) + this.Gj);
            this.Gf.invalidate();
            this.Gf.FY.sendEmptyMessageAtTime(-104, this.Gl);
        }

        void mT() {
            mP();
            if (this.Gg <= this.Gi) {
                for (e eVar : this.Gf.Gd) {
                    if (eVar != null) {
                        eVar.mX();
                    }
                }
                this.Gm = false;
                this.Gf.FQ = 10004;
                this.Gf.mO();
                return;
            }
            this.Gf.FL = (int) (com.baidu.adp.widget.g.a(this.Gi, this.Gg, false) + this.Gj);
            this.Gf.invalidate();
            this.Gf.FY.sendEmptyMessageAtTime(-105, this.Gl);
        }

        void c(float f) {
            for (e eVar : this.Gf.Gd) {
                if (eVar != null) {
                    eVar.mW();
                }
            }
            this.Gm = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gk = uptimeMillis;
            this.Gl = uptimeMillis + 16;
            this.Gh = f;
            this.Gg = 0.0f;
            this.Gi = 0 - this.Gf.FL;
            this.Gj = this.Gf.FL;
            this.Gf.FY.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.Gi);
            Log.d("Animator", "@animateTopOpen " + f);
            this.Gf.FY.sendEmptyMessageAtTime(-104, this.Gl);
        }

        void d(float f) {
            for (e eVar : this.Gf.Gd) {
                if (eVar != null) {
                    eVar.mW();
                }
            }
            this.Gm = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gk = uptimeMillis;
            this.Gl = uptimeMillis + 16;
            this.Gh = f;
            this.Gg = 0.0f;
            this.Gi = 0 - this.Gf.FL;
            this.Gj = this.Gf.FL;
            Log.d("Animator", "@animateBottomOpen " + this.Gi);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.Gf.FY.removeMessages(-105);
            this.Gf.FY.sendEmptyMessageAtTime(-105, this.Gl);
        }

        void e(float f) {
            d dVar = this.Gf.Gb;
            if (dVar != null) {
                dVar.mU();
            }
            this.Gm = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gk = uptimeMillis;
            this.Gl = uptimeMillis + 16;
            this.Gh = f;
            this.Gg = 0.0f;
            this.Gi = ((-this.Gf.getMeasuredWidth()) + this.Gf.FJ) - this.Gf.FL;
            this.Gj = this.Gf.FL;
            Log.d("Animator", "@animateTop " + this.Gi);
            Log.d("Animator", "@animateTop " + f);
            this.Gf.FY.removeMessages(-100);
            this.Gf.FY.sendEmptyMessageAtTime(-100, this.Gl);
        }

        void f(float f) {
            f fVar = this.Gf.Gc;
            if (fVar != null) {
                fVar.mY();
            }
            this.Gm = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gk = uptimeMillis;
            this.Gl = uptimeMillis + 16;
            this.Gh = f;
            this.Gg = 0.0f;
            this.Gi = (this.Gf.getMeasuredWidth() - this.Gf.FK) - this.Gf.FL;
            this.Gj = this.Gf.FL;
            Log.d("Animator", "@animateBottom " + this.Gi);
            Log.d("Animator", "@animateBottom " + f);
            this.Gf.FY.removeMessages(-101);
            this.Gf.FY.sendEmptyMessageAtTime(-101, this.Gl);
        }
    }
}
