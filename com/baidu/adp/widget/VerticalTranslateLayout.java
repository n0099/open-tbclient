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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int Nc;
    private int Nd;
    private final int Nh;
    private int Nl;
    private final Paint No;
    private int Np;
    private int Nq;
    private final List<d> Ny;
    private boolean RA;
    private final a RB;
    private final b RC;
    private final g RD;
    private e RE;
    private c RF;
    private f RG;
    private float Rp;
    private float Rq;
    private float Rr;
    private float Rs;
    private int Rt;
    private boolean Ru;
    private boolean Rv;
    private TrackDirection Rw;
    private final Rect Rx;
    private final Rect Ry;
    private int Rz;

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
        void bb(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Rx = new Rect();
        this.Ry = new Rect();
        this.Ny = new ArrayList();
        this.RB = new a();
        this.RC = new b();
        this.RD = new g();
        this.Nl = 10004;
        Resources resources = getResources();
        this.No = new Paint();
        this.No.setColor(-1);
        this.Nh = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Rp = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Rr = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Rq = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Rs = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (pq() && pr() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Rw = TrackDirection.vertical;
            } else if (pr() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Rw = TrackDirection.bottom;
            } else if (pq() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Rw = TrackDirection.top;
            } else {
                this.Rw = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.Rp != -1.0f) {
                    this.Ru = true;
                } else if ("bottom".equals(str) && this.Rr != -1.0f) {
                    this.Rv = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.No.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.No.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Rt = (int) ((this.Rp - this.Nd) * (-f2));
            } else if (f2 > 0.0f) {
                this.Rt = (int) ((this.Nd - this.Rr) * f2);
            } else if (f2 == 0.0f) {
                this.Rt = 0;
                this.Nl = 10004;
            } else if (f2 == -1.0f) {
                this.Rp -= this.Nd;
                this.Nl = 10000;
            } else if (f2 == 1.0f) {
                this.Rp = this.Nd - this.Rr;
                this.Nl = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Rp;
    }

    public int getBottomOffset() {
        return (int) this.Rr;
    }

    public void setTopTapBack(boolean z) {
        this.Ru = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Rv = z;
    }

    public int getState() {
        return this.Nl;
    }

    public void setTopAnimationListener(e eVar) {
        this.RE = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.RF = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.RG = fVar;
    }

    private boolean pq() {
        return (this.Rp == -1.0f && this.Rs == -1.0f) ? false : true;
    }

    private boolean pr() {
        return (this.Rr == -1.0f && this.Rq == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Rt);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Rt);
        canvas.drawRect(0.0f, 0.0f, this.Nc, this.Nd, this.No);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Rt;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Rw == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Nl == 10004) {
            switch (action) {
                case 0:
                    this.Np = x;
                    this.Nq = y;
                    this.RB.removeMessages(-100);
                    this.RB.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.RB.removeMessages(-101);
                    this.RB.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Rt);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Np - this.Nh && i <= this.Np + this.Nh && (i2 < this.Nq - this.Nh || i2 > this.Nq + this.Nh) && this.RD.aL(i2 - this.Nq);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.Nl == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.RA = false;
                    if (this.RD.NM) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.RD.ot();
                        this.RD.ou();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.RD.NM) {
                        if (!this.RA) {
                            if (y > this.Nq) {
                                this.Rz = this.Nq + this.Nh;
                                this.RA = true;
                            } else {
                                this.Rz = this.Nq - this.Nh;
                                this.RA = true;
                            }
                        }
                        this.RD.aM(this.Rz - y);
                        this.Rz = y;
                        this.RD.NL.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Nl != 10000 || !this.Rx.contains(x, y)) && (this.Nl != 10001 || !this.Ry.contains(x, y))) {
                    return false;
                }
                if (!this.RD.NM) {
                    this.Rz = y;
                    this.RD.aL(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.RD.NM) {
                    this.RD.ot();
                    this.RD.ou();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.RD.NM) {
            this.RD.aM(this.Rz - y);
            this.Rz = y;
            this.RD.NL.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Rp != -1.0f) {
                this.Rx.set(i, i2, i3, (int) (i2 + this.Rp));
            }
            if (this.Rr != -1.0f) {
                this.Ry.set(i, (int) (i4 - this.Rr), i3, i4);
            }
        }
        if (!this.RC.NK && !this.RD.NM) {
            oi();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Rq != -1.0f) {
            this.Rp = i3 - this.Rs;
        }
        if (this.Rs != -1.0f) {
            this.Rr = i3 - this.Rq;
        }
        if (!$assertionsDisabled && i3 < this.Rp) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Rr) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Nc = getMeasuredWidth();
        this.Nd = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        switch (this.Nl) {
            case 10000:
                this.Rt = (int) (this.Rp - this.Nd);
                invalidate();
                return;
            case 10001:
                this.Rt = (int) (this.Nd - this.Rr);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Rt = 0;
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
            if (VerticalTranslateLayout.this.RC.NK) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.RC.pv();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.RC.pu();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.RC.pt();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.RC.ps();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker NL;
        boolean NM;
        final int NN;
        final int NP;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.NN = (int) ((200.0f * f) + 0.5f);
            this.NP = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aL(int i) {
            switch (VerticalTranslateLayout.this.Rw) {
                case top:
                    if (VerticalTranslateLayout.this.Nl != 10004 && VerticalTranslateLayout.this.Nl != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.Nl != 10004 && VerticalTranslateLayout.this.Nl != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.RG != null) {
                        VerticalTranslateLayout.this.RG.bb(i);
                        break;
                    }
                    break;
            }
            this.NL = VelocityTracker.obtain();
            this.NM = true;
            return true;
        }

        void ot() {
            this.NM = false;
        }

        void aM(int i) {
            if (this.NM) {
                int i2 = VerticalTranslateLayout.this.Rt - i;
                switch (VerticalTranslateLayout.this.Rw) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Rp - VerticalTranslateLayout.this.Nd && i2 < 0) {
                            VerticalTranslateLayout.this.Rt -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.Nd - VerticalTranslateLayout.this.Rr && i2 > 0) {
                            VerticalTranslateLayout.this.Rt -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Rp - VerticalTranslateLayout.this.Nd && i2 <= VerticalTranslateLayout.this.Nd - VerticalTranslateLayout.this.Rr) {
                            VerticalTranslateLayout.this.Rt -= i;
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
            this.NL.computeCurrentVelocity(this.NN);
            float yVelocity = this.NL.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.NP);
            } else {
                max = Math.max(yVelocity, this.NP);
            }
            switch (VerticalTranslateLayout.this.Rw) {
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
            this.NL.recycle();
            this.NL = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Rt;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Rp - VerticalTranslateLayout.this.Nd) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.RC.R(f);
                } else {
                    VerticalTranslateLayout.this.RC.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.Nd - VerticalTranslateLayout.this.Rr) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.RC.Q(f);
                } else {
                    VerticalTranslateLayout.this.RC.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.RC.R(f);
            } else {
                VerticalTranslateLayout.this.RC.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.RC.Q(f);
            } else {
                VerticalTranslateLayout.this.RC.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float ND;
        float NE;
        float NF;
        float NG;
        float NH;
        long NI;
        long NJ;
        boolean NK;

        b() {
            this.ND = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NE = ((((float) (uptimeMillis - this.NI)) / 1000.0f) * this.NF) + this.NE;
            this.NI = uptimeMillis;
            this.NJ += 16;
        }

        void ps() {
            compute();
            if (this.NE <= this.NG) {
                e eVar = VerticalTranslateLayout.this.RE;
                if (eVar != null) {
                    eVar.px();
                }
                this.NK = false;
                VerticalTranslateLayout.this.Nl = 10000;
                VerticalTranslateLayout.this.oi();
                return;
            }
            VerticalTranslateLayout.this.Rt = (int) (com.baidu.adp.widget.a.a(this.NG, this.NE, false) + this.NH);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.RB.sendEmptyMessageAtTime(-100, this.NJ);
        }

        void pt() {
            compute();
            if (this.NE >= this.NG) {
                c cVar = VerticalTranslateLayout.this.RF;
                if (cVar != null) {
                    cVar.pw();
                }
                this.NK = false;
                VerticalTranslateLayout.this.Nl = 10001;
                VerticalTranslateLayout.this.oi();
                return;
            }
            VerticalTranslateLayout.this.Rt = (int) (com.baidu.adp.widget.a.a(this.NG, this.NE, false) + this.NH);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.RB.sendEmptyMessageAtTime(-101, this.NJ);
        }

        void pu() {
            compute();
            if (this.NE >= this.NG) {
                for (d dVar : VerticalTranslateLayout.this.Ny) {
                    if (dVar != null) {
                        dVar.oq();
                    }
                }
                this.NK = false;
                VerticalTranslateLayout.this.Nl = 10004;
                VerticalTranslateLayout.this.oi();
                return;
            }
            VerticalTranslateLayout.this.Rt = (int) (com.baidu.adp.widget.a.a(this.NG, this.NE, false) + this.NH);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.RB.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.NJ);
        }

        void pv() {
            compute();
            if (this.NE <= this.NG) {
                for (d dVar : VerticalTranslateLayout.this.Ny) {
                    if (dVar != null) {
                        dVar.oq();
                    }
                }
                this.NK = false;
                VerticalTranslateLayout.this.Nl = 10004;
                VerticalTranslateLayout.this.oi();
                return;
            }
            VerticalTranslateLayout.this.Rt = (int) (com.baidu.adp.widget.a.a(this.NG, this.NE, false) + this.NH);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.RB.sendEmptyMessageAtTime(-105, this.NJ);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Ny) {
                if (dVar != null) {
                    dVar.op();
                }
            }
            this.NK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NI = uptimeMillis;
            this.NJ = uptimeMillis + 16;
            this.NF = f;
            this.NE = 0.0f;
            this.NG = 0 - VerticalTranslateLayout.this.Rt;
            this.NH = VerticalTranslateLayout.this.Rt;
            VerticalTranslateLayout.this.RB.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.NG);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.RB.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.NJ);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Ny) {
                if (dVar != null) {
                    dVar.op();
                }
            }
            this.NK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NI = uptimeMillis;
            this.NJ = uptimeMillis + 16;
            this.NF = f;
            this.NE = 0.0f;
            this.NG = 0 - VerticalTranslateLayout.this.Rt;
            this.NH = VerticalTranslateLayout.this.Rt;
            BdLog.d("Animator@animateBottomOpen " + this.NG);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.RB.removeMessages(-105);
            VerticalTranslateLayout.this.RB.sendEmptyMessageAtTime(-105, this.NJ);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.RE;
            if (eVar != null) {
                eVar.on();
            }
            this.NK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NI = uptimeMillis;
            this.NJ = uptimeMillis + 16;
            this.NF = f;
            this.NE = 0.0f;
            this.NG = ((-VerticalTranslateLayout.this.Nd) + VerticalTranslateLayout.this.Rp) - VerticalTranslateLayout.this.Rt;
            this.NH = VerticalTranslateLayout.this.Rt;
            BdLog.d("Animator@animateTop " + this.NG);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.RB.removeMessages(-100);
            VerticalTranslateLayout.this.RB.sendEmptyMessageAtTime(-100, this.NJ);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.RF;
            if (cVar != null) {
                cVar.or();
            }
            this.NK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NI = uptimeMillis;
            this.NJ = uptimeMillis + 16;
            this.NF = f;
            this.NE = 0.0f;
            this.NG = (VerticalTranslateLayout.this.Nd - VerticalTranslateLayout.this.Rr) - VerticalTranslateLayout.this.Rt;
            this.NH = VerticalTranslateLayout.this.Rt;
            BdLog.d("Animator@animateBottom " + this.NG);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.RB.removeMessages(-101);
            VerticalTranslateLayout.this.RB.sendEmptyMessageAtTime(-101, this.NJ);
        }
    }
}
