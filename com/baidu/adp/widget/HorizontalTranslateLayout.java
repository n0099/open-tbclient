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
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int MQ;
    private float MS;
    private float MT;
    private int MU;
    private final int MV;
    private boolean MW;
    private boolean MX;
    private TrackDirection MY;
    private int MZ;
    private final Rect Na;
    private final Rect Nb;
    private final Paint Nc;
    private int Nd;
    private int Ne;
    private int Nf;
    private boolean Ng;
    private final a Nh;
    private final b Ni;
    private final g Nj;
    private d Nk;
    private f Nl;
    private final List<e> Nm;
    private c Nn;

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
        void bb(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void oi();

        void oj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void ok();

        void ol();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void om();

        void on();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Na = new Rect();
        this.Nb = new Rect();
        this.Nm = new ArrayList();
        this.Nh = new a();
        this.Ni = new b();
        this.Nj = new g();
        this.MZ = 10004;
        Resources resources = getResources();
        this.Nc = new Paint();
        this.Nc.setColor(-1);
        this.MV = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.MS = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.MT = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.MS != -1.0f && this.MT != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.MY = TrackDirection.horizontal;
            } else if (this.MT != -1.0f && MarkerModel.SubBase.RIGHT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.MY = TrackDirection.right;
            } else if (this.MS != -1.0f && "left".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.MY = TrackDirection.left;
            } else {
                this.MY = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if ("left".equals(str) && this.MS != -1.0f) {
                    this.MW = true;
                } else if (MarkerModel.SubBase.RIGHT.equals(str) && this.MT != -1.0f) {
                    this.MX = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Nc.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Nc.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.MU = (int) ((this.MS - this.MQ) * (-f2));
            } else if (f2 > 0.0f) {
                this.MU = (int) ((this.MQ - this.MT) * f2);
            } else if (f2 == 0.0f) {
                this.MU = 0;
                this.MZ = 10004;
            } else if (f2 == -1.0f) {
                this.MS -= getMeasuredWidth();
                this.MZ = 10000;
            } else if (f2 == 1.0f) {
                this.MS = getMeasuredWidth() - this.MT;
                this.MZ = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.MS;
    }

    public int getRightOffset() {
        return (int) this.MT;
    }

    public void setLeftTapBack(boolean z) {
        this.MW = z;
    }

    public void setRightTapBack(boolean z) {
        this.MX = z;
    }

    public int getState() {
        return this.MZ;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Nk = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Nl = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Nn = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.MU, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.MU);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Nc);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.MU;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.MY == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.MZ == 10004) {
            switch (action) {
                case 0:
                    this.Nd = x;
                    this.Ne = y;
                    this.Nh.removeMessages(-100);
                    this.Nh.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Nh.removeMessages(-101);
                    this.Nh.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.MU, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.Ne - this.MV && i2 <= this.Ne + this.MV && (i < this.Nd - this.MV || i > this.Nd + this.MV) && this.Nj.bc(i - this.Nd);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.MZ == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Ng = false;
                    if (this.Nj.Nz) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Nj.oo();
                        this.Nj.op();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Nj.Nz) {
                        if (!this.Ng) {
                            if (x > this.Nd) {
                                this.Nf = this.Nd + this.MV;
                                this.Ng = true;
                            } else {
                                this.Nf = this.Nd - this.MV;
                                this.Ng = true;
                            }
                        }
                        this.Nj.bd(this.Nf - x);
                        this.Nf = x;
                        this.Nj.Ny.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Na);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Nb);
        switch (action) {
            case 0:
                if ((this.MZ != 10000 || !this.Na.contains(x, y)) && (this.MZ != 10001 || !this.Nb.contains(x, y))) {
                    return false;
                }
                if (!this.Nj.Nz) {
                    this.Nf = x;
                    this.Nj.bc(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Nj.Nz) {
                    this.Nj.oo();
                    this.Nj.op();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Nj.Nz) {
            this.Nj.bd(this.Nf - x);
            this.Nf = x;
            this.Nj.Ny.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.MS != -1.0f) {
                this.Na.set(i, i2, (int) (i + this.MS), i4);
            }
            if (this.MT != -1.0f) {
                this.Nb.set((int) (i3 - this.MT), i2, i3, i4);
            }
        }
        if (!this.Ni.Nx && !this.Nj.Nz) {
            oc();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.MS) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.MT) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.MQ = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc() {
        switch (this.MZ) {
            case 10000:
                this.MU = (int) (this.MS - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.MU = (int) (getMeasuredWidth() - this.MT);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.MU = 0;
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
            if (HorizontalTranslateLayout.this.Ni.Nx) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Ni.oh();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Ni.og();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Ni.oe();
                        return;
                    case -100:
                        HorizontalTranslateLayout.this.Ni.od();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final int NB;
        final int NC;
        VelocityTracker Ny;
        boolean Nz;

        g() {
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.NB = (int) ((200.0f * f) + 0.5f);
            this.NC = (int) ((f * 500.0f) + 0.5f);
        }

        boolean bc(int i) {
            switch (HorizontalTranslateLayout.this.MY) {
                case left:
                    if (HorizontalTranslateLayout.this.MZ != 10004 && HorizontalTranslateLayout.this.MZ != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.MZ != 10004 && HorizontalTranslateLayout.this.MZ != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Nn != null) {
                        HorizontalTranslateLayout.this.Nn.bb(i);
                        break;
                    }
                    break;
            }
            this.Ny = VelocityTracker.obtain();
            this.Nz = true;
            return true;
        }

        void oo() {
            this.Nz = false;
        }

        void bd(int i) {
            if (this.Nz) {
                int i2 = HorizontalTranslateLayout.this.MU - i;
                switch (HorizontalTranslateLayout.this.MY) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.MS - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.MU -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MT && i2 > 0) {
                            HorizontalTranslateLayout.this.MU -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.MS - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MT) {
                            HorizontalTranslateLayout.this.MU -= i;
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
        public void op() {
            float max;
            this.Ny.computeCurrentVelocity(this.NB);
            float xVelocity = this.Ny.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.NC);
            } else {
                max = Math.max(xVelocity, this.NC);
            }
            switch (HorizontalTranslateLayout.this.MY) {
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
            this.Ny.recycle();
            this.Ny = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.MU;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.MS - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Ni.G(f);
                } else {
                    HorizontalTranslateLayout.this.Ni.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MT) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Ni.F(f);
                } else {
                    HorizontalTranslateLayout.this.Ni.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Ni.G(f);
            } else {
                HorizontalTranslateLayout.this.Ni.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Ni.F(f);
            } else {
                HorizontalTranslateLayout.this.Ni.H(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Nq;
        float Nr;
        float Ns;
        float Nt;
        float Nu;
        long Nv;
        long Nw;
        boolean Nx;

        b() {
            this.Nq = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nr = ((((float) (uptimeMillis - this.Nv)) / 1000.0f) * this.Ns) + this.Nr;
            this.Nv = uptimeMillis;
            this.Nw += 16;
        }

        void od() {
            compute();
            if (this.Nr <= this.Nt) {
                d dVar = HorizontalTranslateLayout.this.Nk;
                if (dVar != null) {
                    dVar.oj();
                }
                this.Nx = false;
                HorizontalTranslateLayout.this.MZ = 10000;
                HorizontalTranslateLayout.this.oc();
                return;
            }
            HorizontalTranslateLayout.this.MU = (int) (com.baidu.adp.widget.d.a(this.Nt, this.Nr, false) + this.Nu);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Nh.sendEmptyMessageAtTime(-100, this.Nw);
        }

        void oe() {
            compute();
            if (this.Nr >= this.Nt) {
                f fVar = HorizontalTranslateLayout.this.Nl;
                if (fVar != null) {
                    fVar.on();
                }
                this.Nx = false;
                HorizontalTranslateLayout.this.MZ = 10001;
                HorizontalTranslateLayout.this.oc();
                return;
            }
            HorizontalTranslateLayout.this.MU = (int) (com.baidu.adp.widget.d.a(this.Nt, this.Nr, false) + this.Nu);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Nh.sendEmptyMessageAtTime(-101, this.Nw);
        }

        void og() {
            compute();
            if (this.Nr >= this.Nt) {
                for (e eVar : HorizontalTranslateLayout.this.Nm) {
                    if (eVar != null) {
                        eVar.ol();
                    }
                }
                this.Nx = false;
                HorizontalTranslateLayout.this.MZ = 10004;
                HorizontalTranslateLayout.this.oc();
                return;
            }
            HorizontalTranslateLayout.this.MU = (int) (com.baidu.adp.widget.d.a(this.Nt, this.Nr, false) + this.Nu);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Nh.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nw);
        }

        void oh() {
            compute();
            if (this.Nr <= this.Nt) {
                for (e eVar : HorizontalTranslateLayout.this.Nm) {
                    if (eVar != null) {
                        eVar.ol();
                    }
                }
                this.Nx = false;
                HorizontalTranslateLayout.this.MZ = 10004;
                HorizontalTranslateLayout.this.oc();
                return;
            }
            HorizontalTranslateLayout.this.MU = (int) (com.baidu.adp.widget.d.a(this.Nt, this.Nr, false) + this.Nu);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Nh.sendEmptyMessageAtTime(-105, this.Nw);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Nm) {
                if (eVar != null) {
                    eVar.ok();
                }
            }
            this.Nx = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nv = uptimeMillis;
            this.Nw = uptimeMillis + 16;
            this.Ns = f;
            this.Nr = 0.0f;
            this.Nt = 0 - HorizontalTranslateLayout.this.MU;
            this.Nu = HorizontalTranslateLayout.this.MU;
            HorizontalTranslateLayout.this.Nh.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Nt);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Nh.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nw);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Nm) {
                if (eVar != null) {
                    eVar.ok();
                }
            }
            this.Nx = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nv = uptimeMillis;
            this.Nw = uptimeMillis + 16;
            this.Ns = f;
            this.Nr = 0.0f;
            this.Nt = 0 - HorizontalTranslateLayout.this.MU;
            this.Nu = HorizontalTranslateLayout.this.MU;
            BdLog.d("Animator@animateBottomOpen " + this.Nt);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Nh.removeMessages(-105);
            HorizontalTranslateLayout.this.Nh.sendEmptyMessageAtTime(-105, this.Nw);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Nk;
            if (dVar != null) {
                dVar.oi();
            }
            this.Nx = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nv = uptimeMillis;
            this.Nw = uptimeMillis + 16;
            this.Ns = f;
            this.Nr = 0.0f;
            this.Nt = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.MS) - HorizontalTranslateLayout.this.MU;
            this.Nu = HorizontalTranslateLayout.this.MU;
            BdLog.d("Animator@animateTop " + this.Nt);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Nh.removeMessages(-100);
            HorizontalTranslateLayout.this.Nh.sendEmptyMessageAtTime(-100, this.Nw);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Nl;
            if (fVar != null) {
                fVar.om();
            }
            this.Nx = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nv = uptimeMillis;
            this.Nw = uptimeMillis + 16;
            this.Ns = f;
            this.Nr = 0.0f;
            this.Nt = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MT) - HorizontalTranslateLayout.this.MU;
            this.Nu = HorizontalTranslateLayout.this.MU;
            BdLog.d("Animator@animateBottom " + this.Nt);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Nh.removeMessages(-101);
            HorizontalTranslateLayout.this.Nh.sendEmptyMessageAtTime(-101, this.Nw);
        }
    }
}
