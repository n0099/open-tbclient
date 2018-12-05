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
    private int MG;
    private float MI;
    private float MJ;
    private int MK;
    private final int MM;
    private boolean MN;
    private boolean MO;
    private TrackDirection MP;
    private int MQ;
    private final Rect MR;
    private final Rect MS;
    private final Paint MT;
    private int MU;
    private int MV;
    private int MW;
    private boolean MX;
    private final a MY;
    private final b MZ;
    private final g Na;
    private d Nb;
    private f Nc;
    private final List<e> Nd;
    private c Ne;

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
        void od();

        void oe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void og();

        void oh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void oi();

        void oj();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.MR = new Rect();
        this.MS = new Rect();
        this.Nd = new ArrayList();
        this.MY = new a();
        this.MZ = new b();
        this.Na = new g();
        this.MQ = 10004;
        Resources resources = getResources();
        this.MT = new Paint();
        this.MT.setColor(-1);
        this.MM = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.MI = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.MJ = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.MI != -1.0f && this.MJ != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.MP = TrackDirection.horizontal;
            } else if (this.MJ != -1.0f && MarkerModel.SubBase.RIGHT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.MP = TrackDirection.right;
            } else if (this.MI != -1.0f && "left".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.MP = TrackDirection.left;
            } else {
                this.MP = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if ("left".equals(str) && this.MI != -1.0f) {
                    this.MN = true;
                } else if (MarkerModel.SubBase.RIGHT.equals(str) && this.MJ != -1.0f) {
                    this.MO = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.MT.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.MT.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.MK = (int) ((this.MI - this.MG) * (-f2));
            } else if (f2 > 0.0f) {
                this.MK = (int) ((this.MG - this.MJ) * f2);
            } else if (f2 == 0.0f) {
                this.MK = 0;
                this.MQ = 10004;
            } else if (f2 == -1.0f) {
                this.MI -= getMeasuredWidth();
                this.MQ = 10000;
            } else if (f2 == 1.0f) {
                this.MI = getMeasuredWidth() - this.MJ;
                this.MQ = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.MI;
    }

    public int getRightOffset() {
        return (int) this.MJ;
    }

    public void setLeftTapBack(boolean z) {
        this.MN = z;
    }

    public void setRightTapBack(boolean z) {
        this.MO = z;
    }

    public int getState() {
        return this.MQ;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Nb = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Nc = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Ne = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.MK, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.MK);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.MT);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.MK;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.MP == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.MQ == 10004) {
            switch (action) {
                case 0:
                    this.MU = x;
                    this.MV = y;
                    this.MY.removeMessages(-100);
                    this.MY.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.MY.removeMessages(-101);
                    this.MY.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.MK, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.MV - this.MM && i2 <= this.MV + this.MM && (i < this.MU - this.MM || i > this.MU + this.MM) && this.Na.bc(i - this.MU);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.MQ == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.MX = false;
                    if (this.Na.Nq) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Na.ok();
                        this.Na.ol();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Na.Nq) {
                        if (!this.MX) {
                            if (x > this.MU) {
                                this.MW = this.MU + this.MM;
                                this.MX = true;
                            } else {
                                this.MW = this.MU - this.MM;
                                this.MX = true;
                            }
                        }
                        this.Na.bd(this.MW - x);
                        this.MW = x;
                        this.Na.Np.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.MR);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.MS);
        switch (action) {
            case 0:
                if ((this.MQ != 10000 || !this.MR.contains(x, y)) && (this.MQ != 10001 || !this.MS.contains(x, y))) {
                    return false;
                }
                if (!this.Na.Nq) {
                    this.MW = x;
                    this.Na.bc(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Na.Nq) {
                    this.Na.ok();
                    this.Na.ol();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Na.Nq) {
            this.Na.bd(this.MW - x);
            this.MW = x;
            this.Na.Np.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.MI != -1.0f) {
                this.MR.set(i, i2, (int) (i + this.MI), i4);
            }
            if (this.MJ != -1.0f) {
                this.MS.set((int) (i3 - this.MJ), i2, i3, i4);
            }
        }
        if (!this.MZ.No && !this.Na.Nq) {
            nY();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.MI) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.MJ) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.MG = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nY() {
        switch (this.MQ) {
            case 10000:
                this.MK = (int) (this.MI - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.MK = (int) (getMeasuredWidth() - this.MJ);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.MK = 0;
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
            if (HorizontalTranslateLayout.this.MZ.No) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.MZ.oc();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.MZ.ob();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.MZ.oa();
                        return;
                    case -100:
                        HorizontalTranslateLayout.this.MZ.nZ();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Np;
        boolean Nq;
        final int Nr;
        final int Ns;

        g() {
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Nr = (int) ((200.0f * f) + 0.5f);
            this.Ns = (int) ((f * 500.0f) + 0.5f);
        }

        boolean bc(int i) {
            switch (HorizontalTranslateLayout.this.MP) {
                case left:
                    if (HorizontalTranslateLayout.this.MQ != 10004 && HorizontalTranslateLayout.this.MQ != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.MQ != 10004 && HorizontalTranslateLayout.this.MQ != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Ne != null) {
                        HorizontalTranslateLayout.this.Ne.bb(i);
                        break;
                    }
                    break;
            }
            this.Np = VelocityTracker.obtain();
            this.Nq = true;
            return true;
        }

        void ok() {
            this.Nq = false;
        }

        void bd(int i) {
            if (this.Nq) {
                int i2 = HorizontalTranslateLayout.this.MK - i;
                switch (HorizontalTranslateLayout.this.MP) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.MI - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.MK -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MJ && i2 > 0) {
                            HorizontalTranslateLayout.this.MK -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.MI - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MJ) {
                            HorizontalTranslateLayout.this.MK -= i;
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
        public void ol() {
            float max;
            this.Np.computeCurrentVelocity(this.Nr);
            float xVelocity = this.Np.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Ns);
            } else {
                max = Math.max(xVelocity, this.Ns);
            }
            switch (HorizontalTranslateLayout.this.MP) {
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
            this.Np.recycle();
            this.Np = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.MK;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.MI - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.MZ.G(f);
                } else {
                    HorizontalTranslateLayout.this.MZ.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MJ) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.MZ.F(f);
                } else {
                    HorizontalTranslateLayout.this.MZ.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.MZ.G(f);
            } else {
                HorizontalTranslateLayout.this.MZ.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.MZ.F(f);
            } else {
                HorizontalTranslateLayout.this.MZ.H(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Nh;
        float Ni;
        float Nj;
        float Nk;
        float Nl;
        long Nm;
        long Nn;
        boolean No;

        b() {
            this.Nh = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ni = ((((float) (uptimeMillis - this.Nm)) / 1000.0f) * this.Nj) + this.Ni;
            this.Nm = uptimeMillis;
            this.Nn += 16;
        }

        void nZ() {
            compute();
            if (this.Ni <= this.Nk) {
                d dVar = HorizontalTranslateLayout.this.Nb;
                if (dVar != null) {
                    dVar.oe();
                }
                this.No = false;
                HorizontalTranslateLayout.this.MQ = 10000;
                HorizontalTranslateLayout.this.nY();
                return;
            }
            HorizontalTranslateLayout.this.MK = (int) (com.baidu.adp.widget.d.a(this.Nk, this.Ni, false) + this.Nl);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.MY.sendEmptyMessageAtTime(-100, this.Nn);
        }

        void oa() {
            compute();
            if (this.Ni >= this.Nk) {
                f fVar = HorizontalTranslateLayout.this.Nc;
                if (fVar != null) {
                    fVar.oj();
                }
                this.No = false;
                HorizontalTranslateLayout.this.MQ = 10001;
                HorizontalTranslateLayout.this.nY();
                return;
            }
            HorizontalTranslateLayout.this.MK = (int) (com.baidu.adp.widget.d.a(this.Nk, this.Ni, false) + this.Nl);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.MY.sendEmptyMessageAtTime(-101, this.Nn);
        }

        void ob() {
            compute();
            if (this.Ni >= this.Nk) {
                for (e eVar : HorizontalTranslateLayout.this.Nd) {
                    if (eVar != null) {
                        eVar.oh();
                    }
                }
                this.No = false;
                HorizontalTranslateLayout.this.MQ = 10004;
                HorizontalTranslateLayout.this.nY();
                return;
            }
            HorizontalTranslateLayout.this.MK = (int) (com.baidu.adp.widget.d.a(this.Nk, this.Ni, false) + this.Nl);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.MY.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nn);
        }

        void oc() {
            compute();
            if (this.Ni <= this.Nk) {
                for (e eVar : HorizontalTranslateLayout.this.Nd) {
                    if (eVar != null) {
                        eVar.oh();
                    }
                }
                this.No = false;
                HorizontalTranslateLayout.this.MQ = 10004;
                HorizontalTranslateLayout.this.nY();
                return;
            }
            HorizontalTranslateLayout.this.MK = (int) (com.baidu.adp.widget.d.a(this.Nk, this.Ni, false) + this.Nl);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.MY.sendEmptyMessageAtTime(-105, this.Nn);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Nd) {
                if (eVar != null) {
                    eVar.og();
                }
            }
            this.No = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nm = uptimeMillis;
            this.Nn = uptimeMillis + 16;
            this.Nj = f;
            this.Ni = 0.0f;
            this.Nk = 0 - HorizontalTranslateLayout.this.MK;
            this.Nl = HorizontalTranslateLayout.this.MK;
            HorizontalTranslateLayout.this.MY.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Nk);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.MY.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nn);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Nd) {
                if (eVar != null) {
                    eVar.og();
                }
            }
            this.No = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nm = uptimeMillis;
            this.Nn = uptimeMillis + 16;
            this.Nj = f;
            this.Ni = 0.0f;
            this.Nk = 0 - HorizontalTranslateLayout.this.MK;
            this.Nl = HorizontalTranslateLayout.this.MK;
            BdLog.d("Animator@animateBottomOpen " + this.Nk);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.MY.removeMessages(-105);
            HorizontalTranslateLayout.this.MY.sendEmptyMessageAtTime(-105, this.Nn);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Nb;
            if (dVar != null) {
                dVar.od();
            }
            this.No = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nm = uptimeMillis;
            this.Nn = uptimeMillis + 16;
            this.Nj = f;
            this.Ni = 0.0f;
            this.Nk = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.MI) - HorizontalTranslateLayout.this.MK;
            this.Nl = HorizontalTranslateLayout.this.MK;
            BdLog.d("Animator@animateTop " + this.Nk);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.MY.removeMessages(-100);
            HorizontalTranslateLayout.this.MY.sendEmptyMessageAtTime(-100, this.Nn);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Nc;
            if (fVar != null) {
                fVar.oi();
            }
            this.No = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nm = uptimeMillis;
            this.Nn = uptimeMillis + 16;
            this.Nj = f;
            this.Ni = 0.0f;
            this.Nk = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MJ) - HorizontalTranslateLayout.this.MK;
            this.Nl = HorizontalTranslateLayout.this.MK;
            BdLog.d("Animator@animateBottom " + this.Nk);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.MY.removeMessages(-101);
            HorizontalTranslateLayout.this.MY.sendEmptyMessageAtTime(-101, this.Nn);
        }
    }
}
