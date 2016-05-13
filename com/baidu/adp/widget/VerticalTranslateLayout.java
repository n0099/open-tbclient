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
    private float AL;
    private float AM;
    private float AN;
    private float AO;
    private int AP;
    private boolean AQ;
    private boolean AR;
    private TrackDirection AS;
    private final Rect AT;
    private final Rect AU;
    private int AV;
    private boolean AW;
    private final a AX;
    private final b AY;
    private final g AZ;
    private e Ba;
    private c Bb;
    private f Bc;
    private int wH;
    private int wI;
    private final int wN;
    private int wR;
    private final Paint wU;
    private int wV;
    private int wW;
    private final List<d> xe;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (Be) with 'values()' method */
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
        void iQ();

        void km();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void iO();

        void iP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void iM();

        void kn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void ax(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.wU.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.AP = (int) ((this.AL - this.wI) * (-f2));
            } else if (f2 > 0.0f) {
                this.AP = (int) ((this.wI - this.AN) * f2);
            } else if (f2 == 0.0f) {
                this.AP = 0;
                this.wR = 10004;
            } else if (f2 == -1.0f) {
                this.AL -= this.wI;
                this.wR = 10000;
            } else if (f2 == 1.0f) {
                this.AL = this.wI - this.AN;
                this.wR = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.AL;
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
        return this.wR;
    }

    public void setTopAnimationListener(e eVar) {
        this.Ba = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Bb = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Bc = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.AP);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.AP);
        canvas.drawRect(0.0f, 0.0f, this.wH, this.wI, this.wU);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.AP;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.AS == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.wR == 10004) {
            switch (action) {
                case 0:
                    this.wV = x;
                    this.wW = y;
                    this.AX.removeMessages(-100);
                    this.AX.removeMessages(-104);
                    this.AX.removeMessages(-101);
                    this.AX.removeMessages(-105);
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
        return i >= this.wV - this.wN && i <= this.wV + this.wN && (i2 < this.wW - this.wN || i2 > this.wW + this.wN) && this.AZ.ao(i2 - this.wW);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.wR == 10004) {
            switch (action) {
                case 1:
                case 3:
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.AW = false;
                    if (this.AZ.xq) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.AZ.iS();
                        this.AZ.iT();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.AZ.xq) {
                        if (!this.AW) {
                            if (y > this.wW) {
                                this.AV = this.wW + this.wN;
                                this.AW = true;
                            } else {
                                this.AV = this.wW - this.wN;
                                this.AW = true;
                            }
                        }
                        this.AZ.ap(this.AV - y);
                        this.AV = y;
                        this.AZ.xp.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.wR != 10000 || !this.AT.contains(x, y)) && (this.wR != 10001 || !this.AU.contains(x, y))) {
                    return false;
                }
                if (!this.AZ.xq) {
                    this.AV = y;
                    this.AZ.ao(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.AZ.xq) {
                    this.AZ.iS();
                    this.AZ.iT();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.AZ.xq) {
            this.AZ.ap(this.AV - y);
            this.AV = y;
            this.AZ.xp.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.AL != -1.0f) {
                this.AT.set(i, i2, i3, (int) (i2 + this.AL));
            }
            if (this.AN != -1.0f) {
                this.AU.set(i, (int) (i4 - this.AN), i3, i4);
            }
        }
        if (!this.AY.xn && !this.AZ.xq) {
            iG();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.AM != -1.0f) {
            this.AL = i3 - this.AO;
        }
        if (this.AO != -1.0f) {
            this.AN = i3 - this.AM;
        }
        if (!$assertionsDisabled && i3 < this.AL) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.AN) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.wH = getMeasuredWidth();
        this.wI = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iG() {
        switch (this.wR) {
            case 10000:
                this.AP = (int) (this.AL - this.wI);
                invalidate();
                return;
            case 10001:
                this.AP = (int) (this.wI - this.AN);
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
        final /* synthetic */ VerticalTranslateLayout Bd;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Bd.AY.xn) {
                switch (message.what) {
                    case -105:
                        this.Bd.AY.kl();
                        return;
                    case -104:
                        this.Bd.AY.kk();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Bd.AY.kj();
                        return;
                    case -100:
                        this.Bd.AY.ki();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Bf;
        final /* synthetic */ VerticalTranslateLayout Bd;
        VelocityTracker xp;
        boolean xq;
        final int xr;
        final int xs;

        static /* synthetic */ int[] ko() {
            int[] iArr = Bf;
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
                Bf = iArr;
            }
            return iArr;
        }

        boolean ao(int i) {
            switch (ko()[this.Bd.AS.ordinal()]) {
                case 1:
                    if (this.Bd.wR != 10004 && this.Bd.wR != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Bd.wR != 10004 && this.Bd.wR != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Bd.Bc != null) {
                        this.Bd.Bc.ax(i);
                        break;
                    }
                    break;
            }
            this.xp = VelocityTracker.obtain();
            this.xq = true;
            return true;
        }

        void iS() {
            this.xq = false;
        }

        void ap(int i) {
            if (this.xq) {
                int i2 = this.Bd.AP - i;
                switch (ko()[this.Bd.AS.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.Bd.AL - this.Bd.wI && i2 < 0) {
                            this.Bd.AP -= i;
                            this.Bd.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.Bd.wI - this.Bd.AN && i2 > 0) {
                            this.Bd.AP -= i;
                            this.Bd.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.Bd.AL - this.Bd.wI && i2 <= this.Bd.wI - this.Bd.AN) {
                            this.Bd.AP -= i;
                            this.Bd.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void iT() {
            float max;
            this.xp.computeCurrentVelocity(this.xr);
            float yVelocity = this.xp.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.xs);
            } else {
                max = Math.max(yVelocity, this.xs);
            }
            switch (ko()[this.Bd.AS.ordinal()]) {
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
            this.xp.recycle();
            this.xp = null;
        }

        private void q(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.Bd.AP;
            if (i <= 0 && i >= this.Bd.AL - this.Bd.wI) {
                if (f < 0.0f) {
                    this.Bd.AY.o(f);
                } else {
                    this.Bd.AY.m(f);
                }
            } else if (i >= 0 && i <= this.Bd.wI - this.Bd.AN) {
                if (f < 0.0f) {
                    this.Bd.AY.n(f);
                } else {
                    this.Bd.AY.p(f);
                }
            }
        }

        private void r(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.Bd.AY.o(f);
            } else {
                this.Bd.AY.m(f);
            }
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.Bd.AY.n(f);
            } else {
                this.Bd.AY.p(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final /* synthetic */ VerticalTranslateLayout Bd;
        float xh;
        float xi;
        float xj;
        float xk;
        long xl;
        long xm;
        boolean xn;

        private void iH() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xh = ((((float) (uptimeMillis - this.xl)) / 1000.0f) * this.xi) + this.xh;
            this.xl = uptimeMillis;
            this.xm += 16;
        }

        void ki() {
            iH();
            if (this.xh <= this.xj) {
                e eVar = this.Bd.Ba;
                if (eVar != null) {
                    eVar.kn();
                }
                this.xn = false;
                this.Bd.wR = 10000;
                this.Bd.iG();
                return;
            }
            this.Bd.AP = (int) (com.baidu.adp.widget.a.a(this.xj, this.xh, false) + this.xk);
            this.Bd.invalidate();
            this.Bd.AX.sendEmptyMessageAtTime(-100, this.xm);
        }

        void kj() {
            iH();
            if (this.xh >= this.xj) {
                c cVar = this.Bd.Bb;
                if (cVar != null) {
                    cVar.km();
                }
                this.xn = false;
                this.Bd.wR = 10001;
                this.Bd.iG();
                return;
            }
            this.Bd.AP = (int) (com.baidu.adp.widget.a.a(this.xj, this.xh, false) + this.xk);
            this.Bd.invalidate();
            this.Bd.AX.sendEmptyMessageAtTime(-101, this.xm);
        }

        void kk() {
            iH();
            if (this.xh >= this.xj) {
                for (d dVar : this.Bd.xe) {
                    if (dVar != null) {
                        dVar.iP();
                    }
                }
                this.xn = false;
                this.Bd.wR = 10004;
                this.Bd.iG();
                return;
            }
            this.Bd.AP = (int) (com.baidu.adp.widget.a.a(this.xj, this.xh, false) + this.xk);
            this.Bd.invalidate();
            this.Bd.AX.sendEmptyMessageAtTime(-104, this.xm);
        }

        void kl() {
            iH();
            if (this.xh <= this.xj) {
                for (d dVar : this.Bd.xe) {
                    if (dVar != null) {
                        dVar.iP();
                    }
                }
                this.xn = false;
                this.Bd.wR = 10004;
                this.Bd.iG();
                return;
            }
            this.Bd.AP = (int) (com.baidu.adp.widget.a.a(this.xj, this.xh, false) + this.xk);
            this.Bd.invalidate();
            this.Bd.AX.sendEmptyMessageAtTime(-105, this.xm);
        }

        void m(float f) {
            for (d dVar : this.Bd.xe) {
                if (dVar != null) {
                    dVar.iO();
                }
            }
            this.xn = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xl = uptimeMillis;
            this.xm = uptimeMillis + 16;
            this.xi = f;
            this.xh = 0.0f;
            this.xj = 0 - this.Bd.AP;
            this.xk = this.Bd.AP;
            this.Bd.AX.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.xj);
            Log.d("Animator", "@animateTopOpen " + f);
            this.Bd.AX.sendEmptyMessageAtTime(-104, this.xm);
        }

        void n(float f) {
            for (d dVar : this.Bd.xe) {
                if (dVar != null) {
                    dVar.iO();
                }
            }
            this.xn = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xl = uptimeMillis;
            this.xm = uptimeMillis + 16;
            this.xi = f;
            this.xh = 0.0f;
            this.xj = 0 - this.Bd.AP;
            this.xk = this.Bd.AP;
            Log.d("Animator", "@animateBottomOpen " + this.xj);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.Bd.AX.removeMessages(-105);
            this.Bd.AX.sendEmptyMessageAtTime(-105, this.xm);
        }

        void o(float f) {
            e eVar = this.Bd.Ba;
            if (eVar != null) {
                eVar.iM();
            }
            this.xn = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xl = uptimeMillis;
            this.xm = uptimeMillis + 16;
            this.xi = f;
            this.xh = 0.0f;
            this.xj = ((-this.Bd.wI) + this.Bd.AL) - this.Bd.AP;
            this.xk = this.Bd.AP;
            Log.d("Animator", "@animateTop " + this.xj);
            Log.d("Animator", "@animateTop " + f);
            this.Bd.AX.removeMessages(-100);
            this.Bd.AX.sendEmptyMessageAtTime(-100, this.xm);
        }

        void p(float f) {
            c cVar = this.Bd.Bb;
            if (cVar != null) {
                cVar.iQ();
            }
            this.xn = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.xl = uptimeMillis;
            this.xm = uptimeMillis + 16;
            this.xi = f;
            this.xh = 0.0f;
            this.xj = (this.Bd.wI - this.Bd.AN) - this.Bd.AP;
            this.xk = this.Bd.AP;
            Log.d("Animator", "@animateBottom " + this.xj);
            Log.d("Animator", "@animateBottom " + f);
            this.Bd.AX.removeMessages(-101);
            this.Bd.AX.sendEmptyMessageAtTime(-101, this.xm);
        }
    }
}
