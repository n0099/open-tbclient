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
    private int FG;
    private int FH;
    private final int FM;
    private int FQ;
    private final Paint FT;
    private int FU;
    private int FV;
    private final List<d> Gd;
    private float JJ;
    private float JK;
    private float JL;
    private float JM;
    private int JN;
    private boolean JO;
    private boolean JP;
    private TrackDirection JQ;
    private final Rect JR;
    private final Rect JS;
    private int JT;
    private boolean JU;
    private final a JV;
    private final b JW;
    private final g JX;
    private e JY;
    private c JZ;
    private f Ka;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (Kc) with 'values()' method */
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
        void mY();

        void oo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mW();

        void mX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mU();

        void op();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aF(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.FT.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.JN = (int) ((this.JJ - this.FH) * (-f2));
            } else if (f2 > 0.0f) {
                this.JN = (int) ((this.FH - this.JL) * f2);
            } else if (f2 == 0.0f) {
                this.JN = 0;
                this.FQ = 10004;
            } else if (f2 == -1.0f) {
                this.JJ -= this.FH;
                this.FQ = 10000;
            } else if (f2 == 1.0f) {
                this.JJ = this.FH - this.JL;
                this.FQ = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.JJ;
    }

    public int getBottomOffset() {
        return (int) this.JL;
    }

    public void setTopTapBack(boolean z) {
        this.JO = z;
    }

    public void setBottomTapBack(boolean z) {
        this.JP = z;
    }

    public int getState() {
        return this.FQ;
    }

    public void setTopAnimationListener(e eVar) {
        this.JY = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.JZ = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Ka = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.JN);
        Log.d("VerticalTranslateLayout", "@dispatchDraw " + this.JN);
        canvas.drawRect(0.0f, 0.0f, this.FG, this.FH, this.FT);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.JN;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.JQ == TrackDirection.none) {
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
                    this.JV.removeMessages(-100);
                    this.JV.removeMessages(-104);
                    this.JV.removeMessages(-101);
                    this.JV.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    Log.d("VerticalTranslateLayout", "@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.JN);
                    return h(x, y);
            }
        }
        Log.d("VerticalTranslateLayout", "Intercepted to onTouch()");
        return true;
    }

    private boolean h(int i, int i2) {
        return i >= this.FU - this.FM && i <= this.FU + this.FM && (i2 < this.FV - this.FM || i2 > this.FV + this.FM) && this.JX.ax(i2 - this.FV);
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
                    Log.d("VerticalTranslateLayout", "@onTouchEvent up");
                    this.JU = false;
                    if (this.JX.Gp) {
                        Log.d("VerticalTranslateLayout", "@onTouchEvent tracking");
                        this.JX.na();
                        this.JX.nb();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.JX.Gp) {
                        if (!this.JU) {
                            if (y > this.FV) {
                                this.JT = this.FV + this.FM;
                                this.JU = true;
                            } else {
                                this.JT = this.FV - this.FM;
                                this.JU = true;
                            }
                        }
                        this.JX.ay(this.JT - y);
                        this.JT = y;
                        this.JX.Go.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.FQ != 10000 || !this.JR.contains(x, y)) && (this.FQ != 10001 || !this.JS.contains(x, y))) {
                    return false;
                }
                if (!this.JX.Gp) {
                    this.JT = y;
                    this.JX.ax(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.JX.Gp) {
                    this.JX.na();
                    this.JX.nb();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.JX.Gp) {
            this.JX.ay(this.JT - y);
            this.JT = y;
            this.JX.Go.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.JJ != -1.0f) {
                this.JR.set(i, i2, i3, (int) (i2 + this.JJ));
            }
            if (this.JL != -1.0f) {
                this.JS.set(i, (int) (i4 - this.JL), i3, i4);
            }
        }
        if (!this.JW.Gm && !this.JX.Gp) {
            mO();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.JK != -1.0f) {
            this.JJ = i3 - this.JM;
        }
        if (this.JM != -1.0f) {
            this.JL = i3 - this.JK;
        }
        if (!$assertionsDisabled && i3 < this.JJ) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.JL) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.FG = getMeasuredWidth();
        this.FH = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO() {
        switch (this.FQ) {
            case 10000:
                this.JN = (int) (this.JJ - this.FH);
                invalidate();
                return;
            case 10001:
                this.JN = (int) (this.FH - this.JL);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.JN = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Kb;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Kb.JW.Gm) {
                switch (message.what) {
                    case -105:
                        this.Kb.JW.on();
                        return;
                    case -104:
                        this.Kb.JW.om();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Kb.JW.ol();
                        return;
                    case -100:
                        this.Kb.JW.ok();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Kd;
        VelocityTracker Go;
        boolean Gp;
        final int Gq;
        final int Gr;
        final /* synthetic */ VerticalTranslateLayout Kb;

        static /* synthetic */ int[] oq() {
            int[] iArr = Kd;
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
                Kd = iArr;
            }
            return iArr;
        }

        boolean ax(int i) {
            switch (oq()[this.Kb.JQ.ordinal()]) {
                case 1:
                    if (this.Kb.FQ != 10004 && this.Kb.FQ != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Kb.FQ != 10004 && this.Kb.FQ != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Kb.Ka != null) {
                        this.Kb.Ka.aF(i);
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
                int i2 = this.Kb.JN - i;
                switch (oq()[this.Kb.JQ.ordinal()]) {
                    case 1:
                        Log.d("VerticalTranslateLayout", "@move top");
                        if (i2 > this.Kb.JJ - this.Kb.FH && i2 < 0) {
                            this.Kb.JN -= i;
                            this.Kb.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        Log.d("VerticalTranslateLayout", "@move bottom");
                        if (i2 < this.Kb.FH - this.Kb.JL && i2 > 0) {
                            this.Kb.JN -= i;
                            this.Kb.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        Log.d("VerticalTranslateLayout", "@move vertical");
                        if (i2 >= this.Kb.JJ - this.Kb.FH && i2 <= this.Kb.FH - this.Kb.JL) {
                            this.Kb.JN -= i;
                            this.Kb.invalidate();
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
            float yVelocity = this.Go.getYVelocity();
            Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Gr);
            } else {
                max = Math.max(yVelocity, this.Gr);
            }
            switch (oq()[this.Kb.JQ.ordinal()]) {
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
            this.Go.recycle();
            this.Go = null;
        }

        private void q(float f) {
            Log.d("VerticalTranslateLayout", "@verticalFling");
            int i = this.Kb.JN;
            if (i <= 0 && i >= this.Kb.JJ - this.Kb.FH) {
                if (f < 0.0f) {
                    this.Kb.JW.o(f);
                } else {
                    this.Kb.JW.m(f);
                }
            } else if (i >= 0 && i <= this.Kb.FH - this.Kb.JL) {
                if (f < 0.0f) {
                    this.Kb.JW.n(f);
                } else {
                    this.Kb.JW.p(f);
                }
            }
        }

        private void r(float f) {
            Log.d("VerticalTranslateLayout", "@topFling");
            if (f < 0.0f) {
                this.Kb.JW.o(f);
            } else {
                this.Kb.JW.m(f);
            }
        }

        private void s(float f) {
            Log.d("VerticalTranslateLayout", "@bottomFling");
            if (f < 0.0f) {
                this.Kb.JW.n(f);
            } else {
                this.Kb.JW.p(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float Gg;
        float Gh;
        float Gi;
        float Gj;
        long Gk;
        long Gl;
        boolean Gm;
        final /* synthetic */ VerticalTranslateLayout Kb;

        private void mP() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gg = ((((float) (uptimeMillis - this.Gk)) / 1000.0f) * this.Gh) + this.Gg;
            this.Gk = uptimeMillis;
            this.Gl += 16;
        }

        void ok() {
            mP();
            if (this.Gg <= this.Gi) {
                e eVar = this.Kb.JY;
                if (eVar != null) {
                    eVar.op();
                }
                this.Gm = false;
                this.Kb.FQ = 10000;
                this.Kb.mO();
                return;
            }
            this.Kb.JN = (int) (com.baidu.adp.widget.a.a(this.Gi, this.Gg, false) + this.Gj);
            this.Kb.invalidate();
            this.Kb.JV.sendEmptyMessageAtTime(-100, this.Gl);
        }

        void ol() {
            mP();
            if (this.Gg >= this.Gi) {
                c cVar = this.Kb.JZ;
                if (cVar != null) {
                    cVar.oo();
                }
                this.Gm = false;
                this.Kb.FQ = 10001;
                this.Kb.mO();
                return;
            }
            this.Kb.JN = (int) (com.baidu.adp.widget.a.a(this.Gi, this.Gg, false) + this.Gj);
            this.Kb.invalidate();
            this.Kb.JV.sendEmptyMessageAtTime(-101, this.Gl);
        }

        void om() {
            mP();
            if (this.Gg >= this.Gi) {
                for (d dVar : this.Kb.Gd) {
                    if (dVar != null) {
                        dVar.mX();
                    }
                }
                this.Gm = false;
                this.Kb.FQ = 10004;
                this.Kb.mO();
                return;
            }
            this.Kb.JN = (int) (com.baidu.adp.widget.a.a(this.Gi, this.Gg, false) + this.Gj);
            this.Kb.invalidate();
            this.Kb.JV.sendEmptyMessageAtTime(-104, this.Gl);
        }

        void on() {
            mP();
            if (this.Gg <= this.Gi) {
                for (d dVar : this.Kb.Gd) {
                    if (dVar != null) {
                        dVar.mX();
                    }
                }
                this.Gm = false;
                this.Kb.FQ = 10004;
                this.Kb.mO();
                return;
            }
            this.Kb.JN = (int) (com.baidu.adp.widget.a.a(this.Gi, this.Gg, false) + this.Gj);
            this.Kb.invalidate();
            this.Kb.JV.sendEmptyMessageAtTime(-105, this.Gl);
        }

        void m(float f) {
            for (d dVar : this.Kb.Gd) {
                if (dVar != null) {
                    dVar.mW();
                }
            }
            this.Gm = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gk = uptimeMillis;
            this.Gl = uptimeMillis + 16;
            this.Gh = f;
            this.Gg = 0.0f;
            this.Gi = 0 - this.Kb.JN;
            this.Gj = this.Kb.JN;
            this.Kb.JV.removeMessages(-104);
            Log.d("Animator", "@animateTopOpen " + this.Gi);
            Log.d("Animator", "@animateTopOpen " + f);
            this.Kb.JV.sendEmptyMessageAtTime(-104, this.Gl);
        }

        void n(float f) {
            for (d dVar : this.Kb.Gd) {
                if (dVar != null) {
                    dVar.mW();
                }
            }
            this.Gm = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gk = uptimeMillis;
            this.Gl = uptimeMillis + 16;
            this.Gh = f;
            this.Gg = 0.0f;
            this.Gi = 0 - this.Kb.JN;
            this.Gj = this.Kb.JN;
            Log.d("Animator", "@animateBottomOpen " + this.Gi);
            Log.d("Animator", "@animateBottomOpen " + f);
            this.Kb.JV.removeMessages(-105);
            this.Kb.JV.sendEmptyMessageAtTime(-105, this.Gl);
        }

        void o(float f) {
            e eVar = this.Kb.JY;
            if (eVar != null) {
                eVar.mU();
            }
            this.Gm = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gk = uptimeMillis;
            this.Gl = uptimeMillis + 16;
            this.Gh = f;
            this.Gg = 0.0f;
            this.Gi = ((-this.Kb.FH) + this.Kb.JJ) - this.Kb.JN;
            this.Gj = this.Kb.JN;
            Log.d("Animator", "@animateTop " + this.Gi);
            Log.d("Animator", "@animateTop " + f);
            this.Kb.JV.removeMessages(-100);
            this.Kb.JV.sendEmptyMessageAtTime(-100, this.Gl);
        }

        void p(float f) {
            c cVar = this.Kb.JZ;
            if (cVar != null) {
                cVar.mY();
            }
            this.Gm = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Gk = uptimeMillis;
            this.Gl = uptimeMillis + 16;
            this.Gh = f;
            this.Gg = 0.0f;
            this.Gi = (this.Kb.FH - this.Kb.JL) - this.Kb.JN;
            this.Gj = this.Kb.JN;
            Log.d("Animator", "@animateBottom " + this.Gi);
            Log.d("Animator", "@animateBottom " + f);
            this.Kb.JV.removeMessages(-101);
            this.Kb.JV.sendEmptyMessageAtTime(-101, this.Gl);
        }
    }
}
