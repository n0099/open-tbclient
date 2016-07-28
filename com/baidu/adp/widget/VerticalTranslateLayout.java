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
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final g BA;
    private e BB;
    private c BC;
    private f BD;
    private float Bm;
    private float Bn;
    private float Bo;
    private float Bp;
    private int Bq;
    private boolean Br;
    private boolean Bs;
    private TrackDirection Bt;
    private final Rect Bu;
    private final Rect Bv;
    private int Bw;
    private boolean Bx;
    private final a By;
    private final b Bz;
    private final List<d> xH;
    private int xk;
    private int xl;
    private final int xq;
    private int xu;
    private final Paint xx;
    private int xy;
    private int xz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (BF) with 'values()' method */
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
        void iS();

        void kl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void iQ();

        void iR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void iO();

        void km();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aB(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.xx.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Bq = (int) ((this.Bm - this.xl) * (-f2));
            } else if (f2 > 0.0f) {
                this.Bq = (int) ((this.xl - this.Bo) * f2);
            } else if (f2 == 0.0f) {
                this.Bq = 0;
                this.xu = 10004;
            } else if (f2 == -1.0f) {
                this.Bm -= this.xl;
                this.xu = 10000;
            } else if (f2 == 1.0f) {
                this.Bm = this.xl - this.Bo;
                this.xu = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Bm;
    }

    public int getBottomOffset() {
        return (int) this.Bo;
    }

    public void setTopTapBack(boolean z) {
        this.Br = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Bs = z;
    }

    public int getState() {
        return this.xu;
    }

    public void setTopAnimationListener(e eVar) {
        this.BB = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.BC = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.BD = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Bq);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.Bq);
        canvas.drawRect(0.0f, 0.0f, this.xk, this.xl, this.xx);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Bq;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Bt == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.xu == 10004) {
            switch (action) {
                case 0:
                    this.xy = x;
                    this.xz = y;
                    this.By.removeMessages(-100);
                    this.By.removeMessages(-104);
                    this.By.removeMessages(-101);
                    this.By.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Bq);
                    return h(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i >= this.xy - this.xq && i <= this.xy + this.xq && (i2 < this.xz - this.xq || i2 > this.xz + this.xq) && this.BA.as(i2 - this.xz);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.xu == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.Bx = false;
                    if (this.BA.xT) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.BA.iU();
                        this.BA.iV();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.BA.xT) {
                        if (!this.Bx) {
                            if (y > this.xz) {
                                this.Bw = this.xz + this.xq;
                                this.Bx = true;
                            } else {
                                this.Bw = this.xz - this.xq;
                                this.Bx = true;
                            }
                        }
                        this.BA.at(this.Bw - y);
                        this.Bw = y;
                        this.BA.xS.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.xu != 10000 || !this.Bu.contains(x, y)) && (this.xu != 10001 || !this.Bv.contains(x, y))) {
                    return false;
                }
                if (!this.BA.xT) {
                    this.Bw = y;
                    this.BA.as(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.BA.xT) {
                    this.BA.iU();
                    this.BA.iV();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.BA.xT) {
            this.BA.at(this.Bw - y);
            this.Bw = y;
            this.BA.xS.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Bm != -1.0f) {
                this.Bu.set(i, i2, i3, (int) (i2 + this.Bm));
            }
            if (this.Bo != -1.0f) {
                this.Bv.set(i, (int) (i4 - this.Bo), i3, i4);
            }
        }
        if (!this.Bz.xQ && !this.BA.xT) {
            iI();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Bn != -1.0f) {
            this.Bm = i3 - this.Bp;
        }
        if (this.Bp != -1.0f) {
            this.Bo = i3 - this.Bn;
        }
        if (!$assertionsDisabled && i3 < this.Bm) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Bo) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.xk = getMeasuredWidth();
        this.xl = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iI() {
        switch (this.xu) {
            case 10000:
                this.Bq = (int) (this.Bm - this.xl);
                invalidate();
                return;
            case 10001:
                this.Bq = (int) (this.xl - this.Bo);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Bq = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout BE;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.BE.Bz.xQ) {
                switch (message.what) {
                    case -105:
                        this.BE.Bz.kk();
                        return;
                    case -104:
                        this.BE.Bz.kj();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.BE.Bz.ki();
                        return;
                    case -100:
                        this.BE.Bz.kh();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] BG;
        final /* synthetic */ VerticalTranslateLayout BE;
        VelocityTracker xS;
        boolean xT;
        final int xU;
        final int xV;

        static /* synthetic */ int[] kn() {
            int[] iArr = BG;
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
                BG = iArr;
            }
            return iArr;
        }

        boolean as(int i) {
            switch (kn()[this.BE.Bt.ordinal()]) {
                case 1:
                    if (this.BE.xu != 10004 && this.BE.xu != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.BE.xu != 10004 && this.BE.xu != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.BE.BD != null) {
                        this.BE.BD.aB(i);
                        break;
                    }
                    break;
            }
            this.xS = VelocityTracker.obtain();
            this.xT = true;
            return true;
        }

        void iU() {
            this.xT = false;
        }

        void at(int i) {
            if (this.xT) {
                int i2 = this.BE.Bq - i;
                switch (kn()[this.BE.Bt.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.BE.Bm - this.BE.xl && i2 < 0) {
                            this.BE.Bq -= i;
                            this.BE.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.BE.xl - this.BE.Bo && i2 > 0) {
                            this.BE.Bq -= i;
                            this.BE.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.BE.Bm - this.BE.xl && i2 <= this.BE.xl - this.BE.Bo) {
                            this.BE.Bq -= i;
                            this.BE.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iV() {
            float max;
            this.xS.computeCurrentVelocity(this.xU);
            float yVelocity = this.xS.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.xV);
            } else {
                max = Math.max(yVelocity, this.xV);
            }
            switch (kn()[this.BE.Bt.ordinal()]) {
                case 1:
                    B(max);
                    break;
                case 2:
                    C(max);
                    break;
                case 3:
                    A(max);
                    break;
            }
            this.xS.recycle();
            this.xS = null;
        }

        private void A(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.BE.Bq;
            if (i <= 0 && i >= this.BE.Bm - this.BE.xl) {
                if (f < 0.0f) {
                    this.BE.Bz.y(f);
                } else {
                    this.BE.Bz.w(f);
                }
            } else if (i >= 0 && i <= this.BE.xl - this.BE.Bo) {
                if (f < 0.0f) {
                    this.BE.Bz.x(f);
                } else {
                    this.BE.Bz.z(f);
                }
            }
        }

        private void B(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.BE.Bz.y(f);
            } else {
                this.BE.Bz.w(f);
            }
        }

        private void C(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.BE.Bz.x(f);
            } else {
                this.BE.Bz.z(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ VerticalTranslateLayout BE;
        float xK;
        float xL;
        float xM;
        float xN;
        long xO;
        long xP;
        boolean xQ;

        private void iJ() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xK = ((((float) (uptimeMillis - this.xO)) / 1000.0f) * this.xL) + this.xK;
            this.xO = uptimeMillis;
            this.xP += 16;
        }

        void kh() {
            iJ();
            if (this.xK <= this.xM) {
                e eVar = this.BE.BB;
                if (eVar != null) {
                    eVar.km();
                }
                this.xQ = false;
                this.BE.xu = 10000;
                this.BE.iI();
                return;
            }
            this.BE.Bq = (int) (com.baidu.adp.widget.a.a(this.xM, this.xK, false) + this.xN);
            this.BE.invalidate();
            this.BE.By.sendEmptyMessageAtTime(-100, this.xP);
        }

        void ki() {
            iJ();
            if (this.xK >= this.xM) {
                c cVar = this.BE.BC;
                if (cVar != null) {
                    cVar.kl();
                }
                this.xQ = false;
                this.BE.xu = 10001;
                this.BE.iI();
                return;
            }
            this.BE.Bq = (int) (com.baidu.adp.widget.a.a(this.xM, this.xK, false) + this.xN);
            this.BE.invalidate();
            this.BE.By.sendEmptyMessageAtTime(-101, this.xP);
        }

        void kj() {
            iJ();
            if (this.xK >= this.xM) {
                for (d dVar : this.BE.xH) {
                    if (dVar != null) {
                        dVar.iR();
                    }
                }
                this.xQ = false;
                this.BE.xu = 10004;
                this.BE.iI();
                return;
            }
            this.BE.Bq = (int) (com.baidu.adp.widget.a.a(this.xM, this.xK, false) + this.xN);
            this.BE.invalidate();
            this.BE.By.sendEmptyMessageAtTime(-104, this.xP);
        }

        void kk() {
            iJ();
            if (this.xK <= this.xM) {
                for (d dVar : this.BE.xH) {
                    if (dVar != null) {
                        dVar.iR();
                    }
                }
                this.xQ = false;
                this.BE.xu = 10004;
                this.BE.iI();
                return;
            }
            this.BE.Bq = (int) (com.baidu.adp.widget.a.a(this.xM, this.xK, false) + this.xN);
            this.BE.invalidate();
            this.BE.By.sendEmptyMessageAtTime(-105, this.xP);
        }

        void w(float f) {
            for (d dVar : this.BE.xH) {
                if (dVar != null) {
                    dVar.iQ();
                }
            }
            this.xQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xO = uptimeMillis;
            this.xP = uptimeMillis + 16;
            this.xL = f;
            this.xK = 0.0f;
            this.xM = 0 - this.BE.Bq;
            this.xN = this.BE.Bq;
            this.BE.By.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.xM);
            Log.d("Animator", "@animateTopOpen " + f);
            this.BE.By.sendEmptyMessageAtTime(-104, this.xP);
        }

        void x(float f) {
            for (d dVar : this.BE.xH) {
                if (dVar != null) {
                    dVar.iQ();
                }
            }
            this.xQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xO = uptimeMillis;
            this.xP = uptimeMillis + 16;
            this.xL = f;
            this.xK = 0.0f;
            this.xM = 0 - this.BE.Bq;
            this.xN = this.BE.Bq;
            Log.d("Animator", "@animateBottomOpen " + this.xM);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.BE.By.removeMessages(-105);
            this.BE.By.sendEmptyMessageAtTime(-105, this.xP);
        }

        void y(float f) {
            e eVar = this.BE.BB;
            if (eVar != null) {
                eVar.iO();
            }
            this.xQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xO = uptimeMillis;
            this.xP = uptimeMillis + 16;
            this.xL = f;
            this.xK = 0.0f;
            this.xM = ((-this.BE.xl) + this.BE.Bm) - this.BE.Bq;
            this.xN = this.BE.Bq;
            Log.d("Animator", "@animateTop " + this.xM);
            Log.d("Animator", "@animateTop " + f);
            this.BE.By.removeMessages(-100);
            this.BE.By.sendEmptyMessageAtTime(-100, this.xP);
        }

        void z(float f) {
            c cVar = this.BE.BC;
            if (cVar != null) {
                cVar.iS();
            }
            this.xQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xO = uptimeMillis;
            this.xP = uptimeMillis + 16;
            this.xL = f;
            this.xK = 0.0f;
            this.xM = (this.BE.xl - this.BE.Bo) - this.BE.Bq;
            this.xN = this.BE.Bq;
            Log.d("Animator", "@animateBottom " + this.xM);
            Log.d("Animator", "@animateBottom " + f);
            this.BE.By.removeMessages(-101);
            this.BE.By.sendEmptyMessageAtTime(-101, this.xP);
        }
    }
}
