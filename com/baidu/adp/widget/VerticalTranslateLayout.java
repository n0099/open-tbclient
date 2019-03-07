package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.utils.SapiGIDEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int Nb;
    private int Nc;
    private final int Ng;
    private int Nk;
    private final Paint Nn;
    private int No;
    private int Np;
    private final List<d> Nx;
    private final a RA;
    private final b RB;
    private final g RC;
    private e RD;
    private c RE;
    private f RF;
    private float Ro;
    private float Rp;
    private float Rq;
    private float Rr;
    private int Rs;
    private boolean Rt;
    private boolean Ru;
    private TrackDirection Rv;
    private final Rect Rw;
    private final Rect Rx;
    private int Ry;
    private boolean Rz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void or();

        void pw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void op();

        void oq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void on();

        void px();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void bc(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Rw = new Rect();
        this.Rx = new Rect();
        this.Nx = new ArrayList();
        this.RA = new a();
        this.RB = new b();
        this.RC = new g();
        this.Nk = SapiGIDEvent.BUSINESS_GET_GID;
        Resources resources = getResources();
        this.Nn = new Paint();
        this.Nn.setColor(-1);
        this.Ng = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Ro = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Rq = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Rp = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Rr = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (pq() && pr() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Rv = TrackDirection.vertical;
            } else if (pr() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Rv = TrackDirection.bottom;
            } else if (pq() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Rv = TrackDirection.top;
            } else {
                this.Rv = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.Ro != -1.0f) {
                    this.Rt = true;
                } else if ("bottom".equals(str) && this.Rq != -1.0f) {
                    this.Ru = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Nn.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Nn.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Rs = (int) ((this.Ro - this.Nc) * (-f2));
            } else if (f2 > 0.0f) {
                this.Rs = (int) ((this.Nc - this.Rq) * f2);
            } else if (f2 == 0.0f) {
                this.Rs = 0;
                this.Nk = SapiGIDEvent.BUSINESS_GET_GID;
            } else if (f2 == -1.0f) {
                this.Ro -= this.Nc;
                this.Nk = 10000;
            } else if (f2 == 1.0f) {
                this.Ro = this.Nc - this.Rq;
                this.Nk = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Ro;
    }

    public int getBottomOffset() {
        return (int) this.Rq;
    }

    public void setTopTapBack(boolean z) {
        this.Rt = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Ru = z;
    }

    public int getState() {
        return this.Nk;
    }

    public void setTopAnimationListener(e eVar) {
        this.RD = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.RE = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.RF = fVar;
    }

    private boolean pq() {
        return (this.Ro == -1.0f && this.Rr == -1.0f) ? false : true;
    }

    private boolean pr() {
        return (this.Rq == -1.0f && this.Rp == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Rs);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Rs);
        canvas.drawRect(0.0f, 0.0f, this.Nb, this.Nc, this.Nn);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Rs;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Rv == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Nk == 10004) {
            switch (action) {
                case 0:
                    this.No = x;
                    this.Np = y;
                    this.RA.removeMessages(-100);
                    this.RA.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.RA.removeMessages(-101);
                    this.RA.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Rs);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.No - this.Ng && i <= this.No + this.Ng && (i2 < this.Np - this.Ng || i2 > this.Np + this.Ng) && this.RC.aM(i2 - this.Np);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.Nk == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Rz = false;
                    if (this.RC.NL) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.RC.ot();
                        this.RC.ou();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.RC.NL) {
                        if (!this.Rz) {
                            if (y > this.Np) {
                                this.Ry = this.Np + this.Ng;
                                this.Rz = true;
                            } else {
                                this.Ry = this.Np - this.Ng;
                                this.Rz = true;
                            }
                        }
                        this.RC.aN(this.Ry - y);
                        this.Ry = y;
                        this.RC.NK.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Nk != 10000 || !this.Rw.contains(x, y)) && (this.Nk != 10001 || !this.Rx.contains(x, y))) {
                    return false;
                }
                if (!this.RC.NL) {
                    this.Ry = y;
                    this.RC.aM(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.RC.NL) {
                    this.RC.ot();
                    this.RC.ou();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.RC.NL) {
            this.RC.aN(this.Ry - y);
            this.Ry = y;
            this.RC.NK.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ro != -1.0f) {
                this.Rw.set(i, i2, i3, (int) (i2 + this.Ro));
            }
            if (this.Rq != -1.0f) {
                this.Rx.set(i, (int) (i4 - this.Rq), i3, i4);
            }
        }
        if (!this.RB.NJ && !this.RC.NL) {
            oi();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Rp != -1.0f) {
            this.Ro = i3 - this.Rr;
        }
        if (this.Rr != -1.0f) {
            this.Rq = i3 - this.Rp;
        }
        if (!$assertionsDisabled && i3 < this.Ro) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Rq) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Nb = getMeasuredWidth();
        this.Nc = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        switch (this.Nk) {
            case 10000:
                this.Rs = (int) (this.Ro - this.Nc);
                invalidate();
                return;
            case 10001:
                this.Rs = (int) (this.Nc - this.Rq);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case SapiGIDEvent.BUSINESS_GET_GID /* 10004 */:
                this.Rs = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (VerticalTranslateLayout.this.RB.NJ) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.RB.pv();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.RB.pu();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.RB.pt();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.RB.ps();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker NK;
        boolean NL;
        final int NM;
        final int NN;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.NM = (int) ((200.0f * f) + 0.5f);
            this.NN = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aM(int i) {
            switch (VerticalTranslateLayout.this.Rv) {
                case top:
                    if (VerticalTranslateLayout.this.Nk != 10004 && VerticalTranslateLayout.this.Nk != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.Nk != 10004 && VerticalTranslateLayout.this.Nk != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.RF != null) {
                        VerticalTranslateLayout.this.RF.bc(i);
                        break;
                    }
                    break;
            }
            this.NK = VelocityTracker.obtain();
            this.NL = true;
            return true;
        }

        void ot() {
            this.NL = false;
        }

        void aN(int i) {
            if (this.NL) {
                int i2 = VerticalTranslateLayout.this.Rs - i;
                switch (VerticalTranslateLayout.this.Rv) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Ro - VerticalTranslateLayout.this.Nc && i2 < 0) {
                            VerticalTranslateLayout.this.Rs -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.Nc - VerticalTranslateLayout.this.Rq && i2 > 0) {
                            VerticalTranslateLayout.this.Rs -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Ro - VerticalTranslateLayout.this.Nc && i2 <= VerticalTranslateLayout.this.Nc - VerticalTranslateLayout.this.Rq) {
                            VerticalTranslateLayout.this.Rs -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ou() {
            float max;
            this.NK.computeCurrentVelocity(this.NM);
            float yVelocity = this.NK.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.NN);
            } else {
                max = Math.max(yVelocity, this.NN);
            }
            switch (VerticalTranslateLayout.this.Rv) {
                case top:
                    U(max);
                    break;
                case bottom:
                    V(max);
                    break;
                case vertical:
                    T(max);
                    break;
            }
            this.NK.recycle();
            this.NK = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Rs;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Ro - VerticalTranslateLayout.this.Nc) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.RB.R(f);
                } else {
                    VerticalTranslateLayout.this.RB.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.Nc - VerticalTranslateLayout.this.Rq) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.RB.Q(f);
                } else {
                    VerticalTranslateLayout.this.RB.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.RB.R(f);
            } else {
                VerticalTranslateLayout.this.RB.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.RB.Q(f);
            } else {
                VerticalTranslateLayout.this.RB.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float NC;
        float ND;
        float NE;
        float NF;
        float NG;
        long NH;
        long NI;
        boolean NJ;

        b() {
            this.NC = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.ND = ((((float) (uptimeMillis - this.NH)) / 1000.0f) * this.NE) + this.ND;
            this.NH = uptimeMillis;
            this.NI += 16;
        }

        void ps() {
            compute();
            if (this.ND <= this.NF) {
                e eVar = VerticalTranslateLayout.this.RD;
                if (eVar != null) {
                    eVar.px();
                }
                this.NJ = false;
                VerticalTranslateLayout.this.Nk = 10000;
                VerticalTranslateLayout.this.oi();
                return;
            }
            VerticalTranslateLayout.this.Rs = (int) (com.baidu.adp.widget.a.a(this.NF, this.ND, false) + this.NG);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.RA.sendEmptyMessageAtTime(-100, this.NI);
        }

        void pt() {
            compute();
            if (this.ND >= this.NF) {
                c cVar = VerticalTranslateLayout.this.RE;
                if (cVar != null) {
                    cVar.pw();
                }
                this.NJ = false;
                VerticalTranslateLayout.this.Nk = 10001;
                VerticalTranslateLayout.this.oi();
                return;
            }
            VerticalTranslateLayout.this.Rs = (int) (com.baidu.adp.widget.a.a(this.NF, this.ND, false) + this.NG);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.RA.sendEmptyMessageAtTime(-101, this.NI);
        }

        void pu() {
            compute();
            if (this.ND >= this.NF) {
                for (d dVar : VerticalTranslateLayout.this.Nx) {
                    if (dVar != null) {
                        dVar.oq();
                    }
                }
                this.NJ = false;
                VerticalTranslateLayout.this.Nk = SapiGIDEvent.BUSINESS_GET_GID;
                VerticalTranslateLayout.this.oi();
                return;
            }
            VerticalTranslateLayout.this.Rs = (int) (com.baidu.adp.widget.a.a(this.NF, this.ND, false) + this.NG);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.RA.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.NI);
        }

        void pv() {
            compute();
            if (this.ND <= this.NF) {
                for (d dVar : VerticalTranslateLayout.this.Nx) {
                    if (dVar != null) {
                        dVar.oq();
                    }
                }
                this.NJ = false;
                VerticalTranslateLayout.this.Nk = SapiGIDEvent.BUSINESS_GET_GID;
                VerticalTranslateLayout.this.oi();
                return;
            }
            VerticalTranslateLayout.this.Rs = (int) (com.baidu.adp.widget.a.a(this.NF, this.ND, false) + this.NG);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.RA.sendEmptyMessageAtTime(-105, this.NI);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Nx) {
                if (dVar != null) {
                    dVar.op();
                }
            }
            this.NJ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NH = uptimeMillis;
            this.NI = uptimeMillis + 16;
            this.NE = f;
            this.ND = 0.0f;
            this.NF = 0 - VerticalTranslateLayout.this.Rs;
            this.NG = VerticalTranslateLayout.this.Rs;
            VerticalTranslateLayout.this.RA.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.NF);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.RA.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.NI);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Nx) {
                if (dVar != null) {
                    dVar.op();
                }
            }
            this.NJ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NH = uptimeMillis;
            this.NI = uptimeMillis + 16;
            this.NE = f;
            this.ND = 0.0f;
            this.NF = 0 - VerticalTranslateLayout.this.Rs;
            this.NG = VerticalTranslateLayout.this.Rs;
            BdLog.d("Animator@animateBottomOpen " + this.NF);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.RA.removeMessages(-105);
            VerticalTranslateLayout.this.RA.sendEmptyMessageAtTime(-105, this.NI);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.RD;
            if (eVar != null) {
                eVar.on();
            }
            this.NJ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NH = uptimeMillis;
            this.NI = uptimeMillis + 16;
            this.NE = f;
            this.ND = 0.0f;
            this.NF = ((-VerticalTranslateLayout.this.Nc) + VerticalTranslateLayout.this.Ro) - VerticalTranslateLayout.this.Rs;
            this.NG = VerticalTranslateLayout.this.Rs;
            BdLog.d("Animator@animateTop " + this.NF);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.RA.removeMessages(-100);
            VerticalTranslateLayout.this.RA.sendEmptyMessageAtTime(-100, this.NI);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.RE;
            if (cVar != null) {
                cVar.or();
            }
            this.NJ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NH = uptimeMillis;
            this.NI = uptimeMillis + 16;
            this.NE = f;
            this.ND = 0.0f;
            this.NF = (VerticalTranslateLayout.this.Nc - VerticalTranslateLayout.this.Rq) - VerticalTranslateLayout.this.Rs;
            this.NG = VerticalTranslateLayout.this.Rs;
            BdLog.d("Animator@animateBottom " + this.NF);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.RA.removeMessages(-101);
            VerticalTranslateLayout.this.RA.sendEmptyMessageAtTime(-101, this.NI);
        }
    }
}
