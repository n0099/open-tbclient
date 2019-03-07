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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int Nb;
    private float Nd;
    private float Ne;
    private int Nf;
    private final int Ng;
    private boolean Nh;
    private boolean Ni;
    private TrackDirection Nj;
    private int Nk;
    private final Rect Nl;
    private final Rect Nm;
    private final Paint Nn;
    private int No;
    private int Np;
    private int Nq;
    private boolean Nr;
    private final a Ns;
    private final b Nt;
    private final g Nu;
    private d Nv;
    private f Nw;
    private final List<e> Nx;
    private c Ny;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void aL(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void on();

        void oo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void op();

        void oq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void or();

        void os();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Nl = new Rect();
        this.Nm = new Rect();
        this.Nx = new ArrayList();
        this.Ns = new a();
        this.Nt = new b();
        this.Nu = new g();
        this.Nk = SapiGIDEvent.BUSINESS_GET_GID;
        Resources resources = getResources();
        this.Nn = new Paint();
        this.Nn.setColor(-1);
        this.Ng = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.Nd = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.Ne = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.Nd != -1.0f && this.Ne != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.Nj = TrackDirection.horizontal;
            } else if (this.Ne != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.Nj = TrackDirection.right;
            } else if (this.Nd != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.Nj = TrackDirection.left;
            } else {
                this.Nj = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.Nd != -1.0f) {
                    this.Nh = true;
                } else if ("right".equals(str) && this.Ne != -1.0f) {
                    this.Ni = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Nn.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.Nf = (int) ((this.Nd - this.Nb) * (-f2));
            } else if (f2 > 0.0f) {
                this.Nf = (int) ((this.Nb - this.Ne) * f2);
            } else if (f2 == 0.0f) {
                this.Nf = 0;
                this.Nk = SapiGIDEvent.BUSINESS_GET_GID;
            } else if (f2 == -1.0f) {
                this.Nd -= getMeasuredWidth();
                this.Nk = 10000;
            } else if (f2 == 1.0f) {
                this.Nd = getMeasuredWidth() - this.Ne;
                this.Nk = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Nd;
    }

    public int getRightOffset() {
        return (int) this.Ne;
    }

    public void setLeftTapBack(boolean z) {
        this.Nh = z;
    }

    public void setRightTapBack(boolean z) {
        this.Ni = z;
    }

    public int getState() {
        return this.Nk;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Nv = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Nw = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Ny = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Nf, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.Nf);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Nn);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Nf;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Nj == TrackDirection.none) {
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
                    this.Ns.removeMessages(-100);
                    this.Ns.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Ns.removeMessages(-101);
                    this.Ns.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Nf, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.Np - this.Ng && i2 <= this.Np + this.Ng && (i < this.No - this.Ng || i > this.No + this.Ng) && this.Nu.aM(i - this.No);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Nr = false;
                    if (this.Nu.NL) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Nu.ot();
                        this.Nu.ou();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Nu.NL) {
                        if (!this.Nr) {
                            if (x > this.No) {
                                this.Nq = this.No + this.Ng;
                                this.Nr = true;
                            } else {
                                this.Nq = this.No - this.Ng;
                                this.Nr = true;
                            }
                        }
                        this.Nu.aN(this.Nq - x);
                        this.Nq = x;
                        this.Nu.NK.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Nl);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Nm);
        switch (action) {
            case 0:
                if ((this.Nk != 10000 || !this.Nl.contains(x, y)) && (this.Nk != 10001 || !this.Nm.contains(x, y))) {
                    return false;
                }
                if (!this.Nu.NL) {
                    this.Nq = x;
                    this.Nu.aM(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Nu.NL) {
                    this.Nu.ot();
                    this.Nu.ou();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Nu.NL) {
            this.Nu.aN(this.Nq - x);
            this.Nq = x;
            this.Nu.NK.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Nd != -1.0f) {
                this.Nl.set(i, i2, (int) (i + this.Nd), i4);
            }
            if (this.Ne != -1.0f) {
                this.Nm.set((int) (i3 - this.Ne), i2, i3, i4);
            }
        }
        if (!this.Nt.NJ && !this.Nu.NL) {
            oi();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Nd) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Ne) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Nb = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        switch (this.Nk) {
            case 10000:
                this.Nf = (int) (this.Nd - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Nf = (int) (getMeasuredWidth() - this.Ne);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case SapiGIDEvent.BUSINESS_GET_GID /* 10004 */:
                this.Nf = 0;
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
            if (HorizontalTranslateLayout.this.Nt.NJ) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Nt.om();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Nt.ol();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Nt.ok();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Nt.oj();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.NM = (int) ((200.0f * f) + 0.5f);
            this.NN = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aM(int i) {
            switch (HorizontalTranslateLayout.this.Nj) {
                case left:
                    if (HorizontalTranslateLayout.this.Nk != 10004 && HorizontalTranslateLayout.this.Nk != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.Nk != 10004 && HorizontalTranslateLayout.this.Nk != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Ny != null) {
                        HorizontalTranslateLayout.this.Ny.aL(i);
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
                int i2 = HorizontalTranslateLayout.this.Nf - i;
                switch (HorizontalTranslateLayout.this.Nj) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.Nd - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.Nf -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Ne && i2 > 0) {
                            HorizontalTranslateLayout.this.Nf -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.Nd - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Ne) {
                            HorizontalTranslateLayout.this.Nf -= i;
                            HorizontalTranslateLayout.this.invalidate();
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
            float xVelocity = this.NK.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.NN);
            } else {
                max = Math.max(xVelocity, this.NN);
            }
            switch (HorizontalTranslateLayout.this.Nj) {
                case left:
                    J(max);
                    break;
                case right:
                    K(max);
                    break;
                case horizontal:
                    I(max);
                    break;
            }
            this.NK.recycle();
            this.NK = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.Nf;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.Nd - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Nt.G(f);
                } else {
                    HorizontalTranslateLayout.this.Nt.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Ne) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Nt.F(f);
                } else {
                    HorizontalTranslateLayout.this.Nt.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Nt.G(f);
            } else {
                HorizontalTranslateLayout.this.Nt.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Nt.F(f);
            } else {
                HorizontalTranslateLayout.this.Nt.H(f);
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
            this.NC = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.ND = ((((float) (uptimeMillis - this.NH)) / 1000.0f) * this.NE) + this.ND;
            this.NH = uptimeMillis;
            this.NI += 16;
        }

        void oj() {
            compute();
            if (this.ND <= this.NF) {
                d dVar = HorizontalTranslateLayout.this.Nv;
                if (dVar != null) {
                    dVar.oo();
                }
                this.NJ = false;
                HorizontalTranslateLayout.this.Nk = 10000;
                HorizontalTranslateLayout.this.oi();
                return;
            }
            HorizontalTranslateLayout.this.Nf = (int) (com.baidu.adp.widget.d.a(this.NF, this.ND, false) + this.NG);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-100, this.NI);
        }

        void ok() {
            compute();
            if (this.ND >= this.NF) {
                f fVar = HorizontalTranslateLayout.this.Nw;
                if (fVar != null) {
                    fVar.os();
                }
                this.NJ = false;
                HorizontalTranslateLayout.this.Nk = 10001;
                HorizontalTranslateLayout.this.oi();
                return;
            }
            HorizontalTranslateLayout.this.Nf = (int) (com.baidu.adp.widget.d.a(this.NF, this.ND, false) + this.NG);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-101, this.NI);
        }

        void ol() {
            compute();
            if (this.ND >= this.NF) {
                for (e eVar : HorizontalTranslateLayout.this.Nx) {
                    if (eVar != null) {
                        eVar.oq();
                    }
                }
                this.NJ = false;
                HorizontalTranslateLayout.this.Nk = SapiGIDEvent.BUSINESS_GET_GID;
                HorizontalTranslateLayout.this.oi();
                return;
            }
            HorizontalTranslateLayout.this.Nf = (int) (com.baidu.adp.widget.d.a(this.NF, this.ND, false) + this.NG);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ns.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.NI);
        }

        void om() {
            compute();
            if (this.ND <= this.NF) {
                for (e eVar : HorizontalTranslateLayout.this.Nx) {
                    if (eVar != null) {
                        eVar.oq();
                    }
                }
                this.NJ = false;
                HorizontalTranslateLayout.this.Nk = SapiGIDEvent.BUSINESS_GET_GID;
                HorizontalTranslateLayout.this.oi();
                return;
            }
            HorizontalTranslateLayout.this.Nf = (int) (com.baidu.adp.widget.d.a(this.NF, this.ND, false) + this.NG);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-105, this.NI);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Nx) {
                if (eVar != null) {
                    eVar.op();
                }
            }
            this.NJ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NH = uptimeMillis;
            this.NI = uptimeMillis + 16;
            this.NE = f;
            this.ND = 0.0f;
            this.NF = 0 - HorizontalTranslateLayout.this.Nf;
            this.NG = HorizontalTranslateLayout.this.Nf;
            HorizontalTranslateLayout.this.Ns.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.NF);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Ns.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.NI);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Nx) {
                if (eVar != null) {
                    eVar.op();
                }
            }
            this.NJ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NH = uptimeMillis;
            this.NI = uptimeMillis + 16;
            this.NE = f;
            this.ND = 0.0f;
            this.NF = 0 - HorizontalTranslateLayout.this.Nf;
            this.NG = HorizontalTranslateLayout.this.Nf;
            BdLog.d("Animator@animateBottomOpen " + this.NF);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Ns.removeMessages(-105);
            HorizontalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-105, this.NI);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Nv;
            if (dVar != null) {
                dVar.on();
            }
            this.NJ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NH = uptimeMillis;
            this.NI = uptimeMillis + 16;
            this.NE = f;
            this.ND = 0.0f;
            this.NF = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.Nd) - HorizontalTranslateLayout.this.Nf;
            this.NG = HorizontalTranslateLayout.this.Nf;
            BdLog.d("Animator@animateTop " + this.NF);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Ns.removeMessages(-100);
            HorizontalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-100, this.NI);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Nw;
            if (fVar != null) {
                fVar.or();
            }
            this.NJ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NH = uptimeMillis;
            this.NI = uptimeMillis + 16;
            this.NE = f;
            this.ND = 0.0f;
            this.NF = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Ne) - HorizontalTranslateLayout.this.Nf;
            this.NG = HorizontalTranslateLayout.this.Nf;
            BdLog.d("Animator@animateBottom " + this.NF);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Ns.removeMessages(-101);
            HorizontalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-101, this.NI);
        }
    }
}
