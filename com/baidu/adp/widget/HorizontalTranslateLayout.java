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
    private int FW;
    private float FZ;
    private float Ga;
    private int Gb;
    private final int Gc;
    private boolean Gd;
    private boolean Ge;
    private TrackDirection Gf;
    private int Gg;
    private final Rect Gh;
    private final Rect Gi;
    private final Paint Gj;
    private int Gk;
    private int Gl;
    private int Gm;
    private boolean Gn;
    private final a Go;
    private final b Gp;
    private final g Gq;
    private d Gr;
    private f Gs;
    private final List<e> Gt;
    private c Gu;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none;

        /* JADX DEBUG: Replace access to removed values field (GD) with 'values()' method */
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
        void ap(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void ms();

        void mt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mu();

        void mv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mw();

        void mx();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Gj.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Gb = (int) ((this.FZ - this.FW) * (-f2));
            } else if (f2 > 0.0f) {
                this.Gb = (int) ((this.FW - this.Ga) * f2);
            } else if (f2 == 0.0f) {
                this.Gb = 0;
                this.Gg = 10004;
            } else if (f2 == -1.0f) {
                this.FZ -= getMeasuredWidth();
                this.Gg = 10000;
            } else if (f2 == 1.0f) {
                this.FZ = getMeasuredWidth() - this.Ga;
                this.Gg = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.FZ;
    }

    public int getRightOffset() {
        return (int) this.Ga;
    }

    public void setLeftTapBack(boolean z) {
        this.Gd = z;
    }

    public void setRightTapBack(boolean z) {
        this.Ge = z;
    }

    public int getState() {
        return this.Gg;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Gr = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Gs = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Gu = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Gb, 0.0f);
        Log.d("HorizontalTranslateLayout", "@dispatchDraw " + this.Gb);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Gj);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Gb;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Gf == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Gg == 10004) {
            switch (action) {
                case 0:
                    this.Gk = x;
                    this.Gl = y;
                    this.Go.removeMessages(-100);
                    this.Go.removeMessages(-104);
                    this.Go.removeMessages(-101);
                    this.Go.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Gb, 0.0f);
                    return g(x, y);
            }
        }
        Log.d("HorizontalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean g(int i, int i2) {
        return i2 >= this.Gl - this.Gc && i2 <= this.Gl + this.Gc && (i < this.Gk - this.Gc || i > this.Gk + this.Gc) && this.Gq.aq(i - this.Gk);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.Gg == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("HorizontalTranslateLayout", "@onTouchEvent up");
                    this.Gn = false;
                    if (this.Gq.GF) {
                        Log.d("HorizontalTranslateLayout", "@onTouchEvent tracking");
                        this.Gq.my();
                        this.Gq.mz();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Gq.GF) {
                        if (!this.Gn) {
                            if (x > this.Gk) {
                                this.Gm = this.Gk + this.Gc;
                                this.Gn = true;
                            } else {
                                this.Gm = this.Gk - this.Gc;
                                this.Gn = true;
                            }
                        }
                        this.Gq.ar(this.Gm - x);
                        this.Gm = x;
                        this.Gq.GE.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        Log.d("HorizontalTranslateLayout", String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        Log.d("HorizontalTranslateLayout", "left tap back frame = " + this.Gh);
        Log.d("HorizontalTranslateLayout", "right tap back frame = " + this.Gi);
        switch (action) {
            case 0:
                if ((this.Gg != 10000 || !this.Gh.contains(x, y)) && (this.Gg != 10001 || !this.Gi.contains(x, y))) {
                    return false;
                }
                if (!this.Gq.GF) {
                    this.Gm = x;
                    this.Gq.aq(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Gq.GF) {
                    this.Gq.my();
                    this.Gq.mz();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Gq.GF) {
            this.Gq.ar(this.Gm - x);
            this.Gm = x;
            this.Gq.GE.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.FZ != -1.0f) {
                this.Gh.set(i, i2, (int) (i + this.FZ), i4);
            }
            if (this.Ga != -1.0f) {
                this.Gi.set((int) (i3 - this.Ga), i2, i3, i4);
            }
        }
        if (!this.Gp.GC && !this.Gq.GF) {
            mm();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.FZ) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Ga) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.FW = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm() {
        switch (this.Gg) {
            case 10000:
                this.Gb = (int) (this.FZ - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Gb = (int) (getMeasuredWidth() - this.Ga);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Gb = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ HorizontalTranslateLayout Gv;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Gv.Gp.GC) {
                switch (message.what) {
                    case -105:
                        this.Gv.Gp.mr();
                        return;
                    case -104:
                        this.Gv.Gp.mq();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Gv.Gp.mp();
                        return;
                    case -100:
                        this.Gv.Gp.mo();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] GI;
        VelocityTracker GE;
        boolean GF;
        final int GG;
        final int GH;
        final /* synthetic */ HorizontalTranslateLayout Gv;

        static /* synthetic */ int[] mA() {
            int[] iArr = GI;
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
                GI = iArr;
            }
            return iArr;
        }

        boolean aq(int i) {
            switch (mA()[this.Gv.Gf.ordinal()]) {
                case 1:
                    if (this.Gv.Gg != 10004 && this.Gv.Gg != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Gv.Gg != 10004 && this.Gv.Gg != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Gv.Gu != null) {
                        this.Gv.Gu.ap(i);
                        break;
                    }
                    break;
            }
            this.GE = VelocityTracker.obtain();
            this.GF = true;
            return true;
        }

        void my() {
            this.GF = false;
        }

        void ar(int i) {
            if (this.GF) {
                int i2 = this.Gv.Gb - i;
                switch (mA()[this.Gv.Gf.ordinal()]) {
                    case 1:
                        Log.d("HorizontalTranslateLayout", "@move left");
                        if (i2 > this.Gv.FZ - this.Gv.getMeasuredWidth() && i2 < 0) {
                            this.Gv.Gb -= i;
                            this.Gv.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("HorizontalTranslateLayout", "@move right");
                        if (i2 < this.Gv.getMeasuredWidth() - this.Gv.Ga && i2 > 0) {
                            this.Gv.Gb -= i;
                            this.Gv.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("HorizontalTranslateLayout", "@move horizontal");
                        if (i2 >= this.Gv.FZ - this.Gv.getMeasuredWidth() && i2 <= this.Gv.getMeasuredWidth() - this.Gv.Ga) {
                            this.Gv.Gb -= i;
                            this.Gv.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mz() {
            float max;
            this.GE.computeCurrentVelocity(this.GG);
            float xVelocity = this.GE.getXVelocity();
            Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.GH);
            } else {
                max = Math.max(xVelocity, this.GH);
            }
            switch (mA()[this.Gv.Gf.ordinal()]) {
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
            this.GE.recycle();
            this.GE = null;
        }

        private void g(float f) {
            Log.d("HorizontalTranslateLayout", "@horizontalFling");
            int i = this.Gv.Gb;
            if (i <= 0 && i >= this.Gv.FZ - this.Gv.getMeasuredWidth()) {
                if (f < 0.0f) {
                    this.Gv.Gp.e(f);
                } else {
                    this.Gv.Gp.c(f);
                }
            } else if (i >= 0 && i <= this.Gv.getMeasuredWidth() - this.Gv.Ga) {
                if (f < 0.0f) {
                    this.Gv.Gp.d(f);
                } else {
                    this.Gv.Gp.f(f);
                }
            }
        }

        private void h(float f) {
            Log.d("HorizontalTranslateLayout", "@leftFling");
            if (f < 0.0f) {
                this.Gv.Gp.e(f);
            } else {
                this.Gv.Gp.c(f);
            }
        }

        private void i(float f) {
            Log.d("HorizontalTranslateLayout", "@rightFling");
            if (f < 0.0f) {
                this.Gv.Gp.d(f);
            } else {
                this.Gv.Gp.f(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        long GA;
        long GB;
        boolean GC;
        final /* synthetic */ HorizontalTranslateLayout Gv;
        float Gw;
        float Gx;
        float Gy;
        float Gz;

        private void mn() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gw = ((((float) (uptimeMillis - this.GA)) / 1000.0f) * this.Gx) + this.Gw;
            this.GA = uptimeMillis;
            this.GB += 16;
        }

        void mo() {
            mn();
            if (this.Gw <= this.Gy) {
                d dVar = this.Gv.Gr;
                if (dVar != null) {
                    dVar.mt();
                }
                this.GC = false;
                this.Gv.Gg = 10000;
                this.Gv.mm();
                return;
            }
            this.Gv.Gb = (int) (com.baidu.adp.widget.g.a(this.Gy, this.Gw, false) + this.Gz);
            this.Gv.invalidate();
            this.Gv.Go.sendEmptyMessageAtTime(-100, this.GB);
        }

        void mp() {
            mn();
            if (this.Gw >= this.Gy) {
                f fVar = this.Gv.Gs;
                if (fVar != null) {
                    fVar.mx();
                }
                this.GC = false;
                this.Gv.Gg = 10001;
                this.Gv.mm();
                return;
            }
            this.Gv.Gb = (int) (com.baidu.adp.widget.g.a(this.Gy, this.Gw, false) + this.Gz);
            this.Gv.invalidate();
            this.Gv.Go.sendEmptyMessageAtTime(-101, this.GB);
        }

        void mq() {
            mn();
            if (this.Gw >= this.Gy) {
                for (e eVar : this.Gv.Gt) {
                    if (eVar != null) {
                        eVar.mv();
                    }
                }
                this.GC = false;
                this.Gv.Gg = 10004;
                this.Gv.mm();
                return;
            }
            this.Gv.Gb = (int) (com.baidu.adp.widget.g.a(this.Gy, this.Gw, false) + this.Gz);
            this.Gv.invalidate();
            this.Gv.Go.sendEmptyMessageAtTime(-104, this.GB);
        }

        void mr() {
            mn();
            if (this.Gw <= this.Gy) {
                for (e eVar : this.Gv.Gt) {
                    if (eVar != null) {
                        eVar.mv();
                    }
                }
                this.GC = false;
                this.Gv.Gg = 10004;
                this.Gv.mm();
                return;
            }
            this.Gv.Gb = (int) (com.baidu.adp.widget.g.a(this.Gy, this.Gw, false) + this.Gz);
            this.Gv.invalidate();
            this.Gv.Go.sendEmptyMessageAtTime(-105, this.GB);
        }

        void c(float f) {
            for (e eVar : this.Gv.Gt) {
                if (eVar != null) {
                    eVar.mu();
                }
            }
            this.GC = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GA = uptimeMillis;
            this.GB = uptimeMillis + 16;
            this.Gx = f;
            this.Gw = 0.0f;
            this.Gy = 0 - this.Gv.Gb;
            this.Gz = this.Gv.Gb;
            this.Gv.Go.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.Gy);
            Log.d("Animator", "@animateTopOpen " + f);
            this.Gv.Go.sendEmptyMessageAtTime(-104, this.GB);
        }

        void d(float f) {
            for (e eVar : this.Gv.Gt) {
                if (eVar != null) {
                    eVar.mu();
                }
            }
            this.GC = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GA = uptimeMillis;
            this.GB = uptimeMillis + 16;
            this.Gx = f;
            this.Gw = 0.0f;
            this.Gy = 0 - this.Gv.Gb;
            this.Gz = this.Gv.Gb;
            Log.d("Animator", "@animateBottomOpen " + this.Gy);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.Gv.Go.removeMessages(-105);
            this.Gv.Go.sendEmptyMessageAtTime(-105, this.GB);
        }

        void e(float f) {
            d dVar = this.Gv.Gr;
            if (dVar != null) {
                dVar.ms();
            }
            this.GC = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GA = uptimeMillis;
            this.GB = uptimeMillis + 16;
            this.Gx = f;
            this.Gw = 0.0f;
            this.Gy = ((-this.Gv.getMeasuredWidth()) + this.Gv.FZ) - this.Gv.Gb;
            this.Gz = this.Gv.Gb;
            Log.d("Animator", "@animateTop " + this.Gy);
            Log.d("Animator", "@animateTop " + f);
            this.Gv.Go.removeMessages(-100);
            this.Gv.Go.sendEmptyMessageAtTime(-100, this.GB);
        }

        void f(float f) {
            f fVar = this.Gv.Gs;
            if (fVar != null) {
                fVar.mw();
            }
            this.GC = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.GA = uptimeMillis;
            this.GB = uptimeMillis + 16;
            this.Gx = f;
            this.Gw = 0.0f;
            this.Gy = (this.Gv.getMeasuredWidth() - this.Gv.Ga) - this.Gv.Gb;
            this.Gz = this.Gv.Gb;
            Log.d("Animator", "@animateBottom " + this.Gy);
            Log.d("Animator", "@animateBottom " + f);
            this.Gv.Go.removeMessages(-101);
            this.Gv.Go.sendEmptyMessageAtTime(-101, this.GB);
        }
    }
}
