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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int Nc;
    private float Ne;
    private float Nf;
    private int Ng;
    private final int Nh;
    private boolean Ni;
    private boolean Nj;
    private TrackDirection Nk;
    private int Nl;
    private final Rect Nm;
    private final Rect Nn;
    private final Paint No;
    private int Np;
    private int Nq;
    private int Nr;
    private boolean Ns;
    private final a Nt;
    private final b Nu;
    private final g Nv;
    private d Nw;
    private f Nx;
    private final List<e> Ny;
    private c Nz;

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
        this.Nm = new Rect();
        this.Nn = new Rect();
        this.Ny = new ArrayList();
        this.Nt = new a();
        this.Nu = new b();
        this.Nv = new g();
        this.Nl = 10004;
        Resources resources = getResources();
        this.No = new Paint();
        this.No.setColor(-1);
        this.Nh = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.Ne = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.Nf = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.Ne != -1.0f && this.Nf != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.Nk = TrackDirection.horizontal;
            } else if (this.Nf != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.Nk = TrackDirection.right;
            } else if (this.Ne != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.Nk = TrackDirection.left;
            } else {
                this.Nk = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.Ne != -1.0f) {
                    this.Ni = true;
                } else if ("right".equals(str) && this.Nf != -1.0f) {
                    this.Nj = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.No.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.Ng = (int) ((this.Ne - this.Nc) * (-f2));
            } else if (f2 > 0.0f) {
                this.Ng = (int) ((this.Nc - this.Nf) * f2);
            } else if (f2 == 0.0f) {
                this.Ng = 0;
                this.Nl = 10004;
            } else if (f2 == -1.0f) {
                this.Ne -= getMeasuredWidth();
                this.Nl = 10000;
            } else if (f2 == 1.0f) {
                this.Ne = getMeasuredWidth() - this.Nf;
                this.Nl = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Ne;
    }

    public int getRightOffset() {
        return (int) this.Nf;
    }

    public void setLeftTapBack(boolean z) {
        this.Ni = z;
    }

    public void setRightTapBack(boolean z) {
        this.Nj = z;
    }

    public int getState() {
        return this.Nl;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Nw = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Nx = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Nz = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Ng, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.Ng);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.No);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Ng;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Nk == TrackDirection.none) {
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
                    this.Nt.removeMessages(-100);
                    this.Nt.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Nt.removeMessages(-101);
                    this.Nt.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Ng, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.Nq - this.Nh && i2 <= this.Nq + this.Nh && (i < this.Np - this.Nh || i > this.Np + this.Nh) && this.Nv.aM(i - this.Np);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Ns = false;
                    if (this.Nv.NM) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Nv.ot();
                        this.Nv.ou();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Nv.NM) {
                        if (!this.Ns) {
                            if (x > this.Np) {
                                this.Nr = this.Np + this.Nh;
                                this.Ns = true;
                            } else {
                                this.Nr = this.Np - this.Nh;
                                this.Ns = true;
                            }
                        }
                        this.Nv.aN(this.Nr - x);
                        this.Nr = x;
                        this.Nv.NL.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Nm);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Nn);
        switch (action) {
            case 0:
                if ((this.Nl != 10000 || !this.Nm.contains(x, y)) && (this.Nl != 10001 || !this.Nn.contains(x, y))) {
                    return false;
                }
                if (!this.Nv.NM) {
                    this.Nr = x;
                    this.Nv.aM(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Nv.NM) {
                    this.Nv.ot();
                    this.Nv.ou();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Nv.NM) {
            this.Nv.aN(this.Nr - x);
            this.Nr = x;
            this.Nv.NL.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ne != -1.0f) {
                this.Nm.set(i, i2, (int) (i + this.Ne), i4);
            }
            if (this.Nf != -1.0f) {
                this.Nn.set((int) (i3 - this.Nf), i2, i3, i4);
            }
        }
        if (!this.Nu.NK && !this.Nv.NM) {
            oi();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Ne) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Nf) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Nc = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        switch (this.Nl) {
            case 10000:
                this.Ng = (int) (this.Ne - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Ng = (int) (getMeasuredWidth() - this.Nf);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Ng = 0;
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
            if (HorizontalTranslateLayout.this.Nu.NK) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Nu.om();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Nu.ol();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Nu.ok();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Nu.oj();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.NN = (int) ((200.0f * f) + 0.5f);
            this.NP = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aM(int i) {
            switch (HorizontalTranslateLayout.this.Nk) {
                case left:
                    if (HorizontalTranslateLayout.this.Nl != 10004 && HorizontalTranslateLayout.this.Nl != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.Nl != 10004 && HorizontalTranslateLayout.this.Nl != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Nz != null) {
                        HorizontalTranslateLayout.this.Nz.aL(i);
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

        void aN(int i) {
            if (this.NM) {
                int i2 = HorizontalTranslateLayout.this.Ng - i;
                switch (HorizontalTranslateLayout.this.Nk) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.Ne - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.Ng -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Nf && i2 > 0) {
                            HorizontalTranslateLayout.this.Ng -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.Ne - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Nf) {
                            HorizontalTranslateLayout.this.Ng -= i;
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
            this.NL.computeCurrentVelocity(this.NN);
            float xVelocity = this.NL.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.NP);
            } else {
                max = Math.max(xVelocity, this.NP);
            }
            switch (HorizontalTranslateLayout.this.Nk) {
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
            this.NL.recycle();
            this.NL = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.Ng;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.Ne - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Nu.G(f);
                } else {
                    HorizontalTranslateLayout.this.Nu.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Nf) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Nu.F(f);
                } else {
                    HorizontalTranslateLayout.this.Nu.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Nu.G(f);
            } else {
                HorizontalTranslateLayout.this.Nu.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Nu.F(f);
            } else {
                HorizontalTranslateLayout.this.Nu.H(f);
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
            this.ND = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NE = ((((float) (uptimeMillis - this.NI)) / 1000.0f) * this.NF) + this.NE;
            this.NI = uptimeMillis;
            this.NJ += 16;
        }

        void oj() {
            compute();
            if (this.NE <= this.NG) {
                d dVar = HorizontalTranslateLayout.this.Nw;
                if (dVar != null) {
                    dVar.oo();
                }
                this.NK = false;
                HorizontalTranslateLayout.this.Nl = 10000;
                HorizontalTranslateLayout.this.oi();
                return;
            }
            HorizontalTranslateLayout.this.Ng = (int) (com.baidu.adp.widget.d.a(this.NG, this.NE, false) + this.NH);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-100, this.NJ);
        }

        void ok() {
            compute();
            if (this.NE >= this.NG) {
                f fVar = HorizontalTranslateLayout.this.Nx;
                if (fVar != null) {
                    fVar.os();
                }
                this.NK = false;
                HorizontalTranslateLayout.this.Nl = 10001;
                HorizontalTranslateLayout.this.oi();
                return;
            }
            HorizontalTranslateLayout.this.Ng = (int) (com.baidu.adp.widget.d.a(this.NG, this.NE, false) + this.NH);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-101, this.NJ);
        }

        void ol() {
            compute();
            if (this.NE >= this.NG) {
                for (e eVar : HorizontalTranslateLayout.this.Ny) {
                    if (eVar != null) {
                        eVar.oq();
                    }
                }
                this.NK = false;
                HorizontalTranslateLayout.this.Nl = 10004;
                HorizontalTranslateLayout.this.oi();
                return;
            }
            HorizontalTranslateLayout.this.Ng = (int) (com.baidu.adp.widget.d.a(this.NG, this.NE, false) + this.NH);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Nt.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.NJ);
        }

        void om() {
            compute();
            if (this.NE <= this.NG) {
                for (e eVar : HorizontalTranslateLayout.this.Ny) {
                    if (eVar != null) {
                        eVar.oq();
                    }
                }
                this.NK = false;
                HorizontalTranslateLayout.this.Nl = 10004;
                HorizontalTranslateLayout.this.oi();
                return;
            }
            HorizontalTranslateLayout.this.Ng = (int) (com.baidu.adp.widget.d.a(this.NG, this.NE, false) + this.NH);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-105, this.NJ);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Ny) {
                if (eVar != null) {
                    eVar.op();
                }
            }
            this.NK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NI = uptimeMillis;
            this.NJ = uptimeMillis + 16;
            this.NF = f;
            this.NE = 0.0f;
            this.NG = 0 - HorizontalTranslateLayout.this.Ng;
            this.NH = HorizontalTranslateLayout.this.Ng;
            HorizontalTranslateLayout.this.Nt.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.NG);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Nt.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.NJ);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Ny) {
                if (eVar != null) {
                    eVar.op();
                }
            }
            this.NK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NI = uptimeMillis;
            this.NJ = uptimeMillis + 16;
            this.NF = f;
            this.NE = 0.0f;
            this.NG = 0 - HorizontalTranslateLayout.this.Ng;
            this.NH = HorizontalTranslateLayout.this.Ng;
            BdLog.d("Animator@animateBottomOpen " + this.NG);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Nt.removeMessages(-105);
            HorizontalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-105, this.NJ);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Nw;
            if (dVar != null) {
                dVar.on();
            }
            this.NK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NI = uptimeMillis;
            this.NJ = uptimeMillis + 16;
            this.NF = f;
            this.NE = 0.0f;
            this.NG = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.Ne) - HorizontalTranslateLayout.this.Ng;
            this.NH = HorizontalTranslateLayout.this.Ng;
            BdLog.d("Animator@animateTop " + this.NG);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Nt.removeMessages(-100);
            HorizontalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-100, this.NJ);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Nx;
            if (fVar != null) {
                fVar.or();
            }
            this.NK = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.NI = uptimeMillis;
            this.NJ = uptimeMillis + 16;
            this.NF = f;
            this.NE = 0.0f;
            this.NG = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Nf) - HorizontalTranslateLayout.this.Ng;
            this.NH = HorizontalTranslateLayout.this.Ng;
            BdLog.d("Animator@animateBottom " + this.NG);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Nt.removeMessages(-101);
            HorizontalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-101, this.NJ);
        }
    }
}
