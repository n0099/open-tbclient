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
    private float AK;
    private float AM;
    private float AN;
    private float AO;
    private int AP;
    private boolean AQ;
    private boolean AR;
    private TrackDirection AT;
    private final Rect AU;
    private final Rect AV;
    private int AW;
    private boolean AX;
    private final a AY;
    private final b AZ;
    private final g Ba;
    private e Bb;
    private c Bc;
    private f Bd;
    private int wJ;
    private int wK;
    private final int wP;
    private int wT;
    private final Paint wW;
    private int wX;
    private int wY;
    private final List<d> xg;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (Bf) with 'values()' method */
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
        void iT();

        void kp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void iR();

        void iS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void iP();

        void kq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void ay(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.wW.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.AP = (int) ((this.AK - this.wK) * (-f2));
            } else if (f2 > 0.0f) {
                this.AP = (int) ((this.wK - this.AN) * f2);
            } else if (f2 == 0.0f) {
                this.AP = 0;
                this.wT = 10004;
            } else if (f2 == -1.0f) {
                this.AK -= this.wK;
                this.wT = 10000;
            } else if (f2 == 1.0f) {
                this.AK = this.wK - this.AN;
                this.wT = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.AK;
    }

    public int getBottomOffset() {
        return (int) this.AN;
    }

    public void setTopTapBack(boolean z) {
        this.AQ = z;
    }

    public void setBottomTapBack(boolean z) {
        this.AR = z;
    }

    public int getState() {
        return this.wT;
    }

    public void setTopAnimationListener(e eVar) {
        this.Bb = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Bc = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Bd = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.AP);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.AP);
        canvas.drawRect(0.0f, 0.0f, this.wJ, this.wK, this.wW);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.AP;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.AT == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.wT == 10004) {
            switch (action) {
                case 0:
                    this.wX = x;
                    this.wY = y;
                    this.AY.removeMessages(-100);
                    this.AY.removeMessages(-104);
                    this.AY.removeMessages(-101);
                    this.AY.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.AP);
                    return h(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i >= this.wX - this.wP && i <= this.wX + this.wP && (i2 < this.wY - this.wP || i2 > this.wY + this.wP) && this.Ba.ap(i2 - this.wY);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.wT == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.AX = false;
                    if (this.Ba.xs) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.Ba.iV();
                        this.Ba.iW();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Ba.xs) {
                        if (!this.AX) {
                            if (y > this.wY) {
                                this.AW = this.wY + this.wP;
                                this.AX = true;
                            } else {
                                this.AW = this.wY - this.wP;
                                this.AX = true;
                            }
                        }
                        this.Ba.aq(this.AW - y);
                        this.AW = y;
                        this.Ba.xr.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.wT != 10000 || !this.AU.contains(x, y)) && (this.wT != 10001 || !this.AV.contains(x, y))) {
                    return false;
                }
                if (!this.Ba.xs) {
                    this.AW = y;
                    this.Ba.ap(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Ba.xs) {
                    this.Ba.iV();
                    this.Ba.iW();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Ba.xs) {
            this.Ba.aq(this.AW - y);
            this.AW = y;
            this.Ba.xr.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.AK != -1.0f) {
                this.AU.set(i, i2, i3, (int) (i2 + this.AK));
            }
            if (this.AN != -1.0f) {
                this.AV.set(i, (int) (i4 - this.AN), i3, i4);
            }
        }
        if (!this.AZ.xp && !this.Ba.xs) {
            iJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.AM != -1.0f) {
            this.AK = i3 - this.AO;
        }
        if (this.AO != -1.0f) {
            this.AN = i3 - this.AM;
        }
        if (!$assertionsDisabled && i3 < this.AK) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.AN) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.wJ = getMeasuredWidth();
        this.wK = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ() {
        switch (this.wT) {
            case 10000:
                this.AP = (int) (this.AK - this.wK);
                invalidate();
                return;
            case 10001:
                this.AP = (int) (this.wK - this.AN);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.AP = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Be;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Be.AZ.xp) {
                switch (message.what) {
                    case -105:
                        this.Be.AZ.ko();
                        return;
                    case -104:
                        this.Be.AZ.kn();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Be.AZ.km();
                        return;
                    case -100:
                        this.Be.AZ.kl();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Bg;
        final /* synthetic */ VerticalTranslateLayout Be;
        VelocityTracker xr;
        boolean xs;
        final int xt;
        final int xu;

        static /* synthetic */ int[] kr() {
            int[] iArr = Bg;
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
                Bg = iArr;
            }
            return iArr;
        }

        boolean ap(int i) {
            switch (kr()[this.Be.AT.ordinal()]) {
                case 1:
                    if (this.Be.wT != 10004 && this.Be.wT != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Be.wT != 10004 && this.Be.wT != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Be.Bd != null) {
                        this.Be.Bd.ay(i);
                        break;
                    }
                    break;
            }
            this.xr = VelocityTracker.obtain();
            this.xs = true;
            return true;
        }

        void iV() {
            this.xs = false;
        }

        void aq(int i) {
            if (this.xs) {
                int i2 = this.Be.AP - i;
                switch (kr()[this.Be.AT.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.Be.AK - this.Be.wK && i2 < 0) {
                            this.Be.AP -= i;
                            this.Be.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.Be.wK - this.Be.AN && i2 > 0) {
                            this.Be.AP -= i;
                            this.Be.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.Be.AK - this.Be.wK && i2 <= this.Be.wK - this.Be.AN) {
                            this.Be.AP -= i;
                            this.Be.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iW() {
            float max;
            this.xr.computeCurrentVelocity(this.xt);
            float yVelocity = this.xr.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.xu);
            } else {
                max = Math.max(yVelocity, this.xu);
            }
            switch (kr()[this.Be.AT.ordinal()]) {
                case 1:
                    r(max);
                    break;
                case 2:
                    s(max);
                    break;
                case 3:
                    q(max);
                    break;
            }
            this.xr.recycle();
            this.xr = null;
        }

        private void q(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.Be.AP;
            if (i <= 0 && i >= this.Be.AK - this.Be.wK) {
                if (f < 0.0f) {
                    this.Be.AZ.o(f);
                } else {
                    this.Be.AZ.m(f);
                }
            } else if (i >= 0 && i <= this.Be.wK - this.Be.AN) {
                if (f < 0.0f) {
                    this.Be.AZ.n(f);
                } else {
                    this.Be.AZ.p(f);
                }
            }
        }

        private void r(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.Be.AZ.o(f);
            } else {
                this.Be.AZ.m(f);
            }
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.Be.AZ.n(f);
            } else {
                this.Be.AZ.p(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ VerticalTranslateLayout Be;
        float xj;
        float xk;
        float xl;
        float xm;
        long xn;
        long xo;
        boolean xp;

        private void iK() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xj = ((((float) (uptimeMillis - this.xn)) / 1000.0f) * this.xk) + this.xj;
            this.xn = uptimeMillis;
            this.xo += 16;
        }

        void kl() {
            iK();
            if (this.xj <= this.xl) {
                e eVar = this.Be.Bb;
                if (eVar != null) {
                    eVar.kq();
                }
                this.xp = false;
                this.Be.wT = 10000;
                this.Be.iJ();
                return;
            }
            this.Be.AP = (int) (com.baidu.adp.widget.a.a(this.xl, this.xj, false) + this.xm);
            this.Be.invalidate();
            this.Be.AY.sendEmptyMessageAtTime(-100, this.xo);
        }

        void km() {
            iK();
            if (this.xj >= this.xl) {
                c cVar = this.Be.Bc;
                if (cVar != null) {
                    cVar.kp();
                }
                this.xp = false;
                this.Be.wT = 10001;
                this.Be.iJ();
                return;
            }
            this.Be.AP = (int) (com.baidu.adp.widget.a.a(this.xl, this.xj, false) + this.xm);
            this.Be.invalidate();
            this.Be.AY.sendEmptyMessageAtTime(-101, this.xo);
        }

        void kn() {
            iK();
            if (this.xj >= this.xl) {
                for (d dVar : this.Be.xg) {
                    if (dVar != null) {
                        dVar.iS();
                    }
                }
                this.xp = false;
                this.Be.wT = 10004;
                this.Be.iJ();
                return;
            }
            this.Be.AP = (int) (com.baidu.adp.widget.a.a(this.xl, this.xj, false) + this.xm);
            this.Be.invalidate();
            this.Be.AY.sendEmptyMessageAtTime(-104, this.xo);
        }

        void ko() {
            iK();
            if (this.xj <= this.xl) {
                for (d dVar : this.Be.xg) {
                    if (dVar != null) {
                        dVar.iS();
                    }
                }
                this.xp = false;
                this.Be.wT = 10004;
                this.Be.iJ();
                return;
            }
            this.Be.AP = (int) (com.baidu.adp.widget.a.a(this.xl, this.xj, false) + this.xm);
            this.Be.invalidate();
            this.Be.AY.sendEmptyMessageAtTime(-105, this.xo);
        }

        void m(float f) {
            for (d dVar : this.Be.xg) {
                if (dVar != null) {
                    dVar.iR();
                }
            }
            this.xp = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xn = uptimeMillis;
            this.xo = uptimeMillis + 16;
            this.xk = f;
            this.xj = 0.0f;
            this.xl = 0 - this.Be.AP;
            this.xm = this.Be.AP;
            this.Be.AY.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.xl);
            Log.d("Animator", "@animateTopOpen " + f);
            this.Be.AY.sendEmptyMessageAtTime(-104, this.xo);
        }

        void n(float f) {
            for (d dVar : this.Be.xg) {
                if (dVar != null) {
                    dVar.iR();
                }
            }
            this.xp = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xn = uptimeMillis;
            this.xo = uptimeMillis + 16;
            this.xk = f;
            this.xj = 0.0f;
            this.xl = 0 - this.Be.AP;
            this.xm = this.Be.AP;
            Log.d("Animator", "@animateBottomOpen " + this.xl);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.Be.AY.removeMessages(-105);
            this.Be.AY.sendEmptyMessageAtTime(-105, this.xo);
        }

        void o(float f) {
            e eVar = this.Be.Bb;
            if (eVar != null) {
                eVar.iP();
            }
            this.xp = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xn = uptimeMillis;
            this.xo = uptimeMillis + 16;
            this.xk = f;
            this.xj = 0.0f;
            this.xl = ((-this.Be.wK) + this.Be.AK) - this.Be.AP;
            this.xm = this.Be.AP;
            Log.d("Animator", "@animateTop " + this.xl);
            Log.d("Animator", "@animateTop " + f);
            this.Be.AY.removeMessages(-100);
            this.Be.AY.sendEmptyMessageAtTime(-100, this.xo);
        }

        void p(float f) {
            c cVar = this.Be.Bc;
            if (cVar != null) {
                cVar.iT();
            }
            this.xp = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xn = uptimeMillis;
            this.xo = uptimeMillis + 16;
            this.xk = f;
            this.xj = 0.0f;
            this.xl = (this.Be.wK - this.Be.AN) - this.Be.AP;
            this.xm = this.Be.AP;
            Log.d("Animator", "@animateBottom " + this.xl);
            Log.d("Animator", "@animateBottom " + f);
            this.Be.AY.removeMessages(-101);
            this.Be.AY.sendEmptyMessageAtTime(-101, this.xo);
        }
    }
}
