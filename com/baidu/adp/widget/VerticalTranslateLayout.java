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
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int MG;
    private int MH;
    private final int MM;
    private int MQ;
    private final Paint MT;
    private int MU;
    private int MV;
    private final List<d> Nd;
    private float Qd;
    private float Qe;
    private float Qf;
    private float Qg;
    private int Qh;
    private boolean Qi;
    private boolean Qj;
    private TrackDirection Qk;
    private final Rect Ql;
    private final Rect Qm;
    private int Qn;
    private boolean Qo;
    private final a Qp;
    private final b Qq;
    private final g Qr;
    private e Qs;
    private c Qt;
    private f Qu;

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
        void oj();

        void pa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void oh();

        void oi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void oe();

        void pb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void bp(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Ql = new Rect();
        this.Qm = new Rect();
        this.Nd = new ArrayList();
        this.Qp = new a();
        this.Qq = new b();
        this.Qr = new g();
        this.MQ = 10004;
        Resources resources = getResources();
        this.MT = new Paint();
        this.MT.setColor(-1);
        this.MM = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Qd = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Qf = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Qe = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Qg = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (oU() && oV() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Qk = TrackDirection.vertical;
            } else if (oV() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Qk = TrackDirection.bottom;
            } else if (oU() && AiAppsNaViewModel.POSITION_KEY_TOP.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Qk = TrackDirection.top;
            } else {
                this.Qk = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if (AiAppsNaViewModel.POSITION_KEY_TOP.equals(str) && this.Qd != -1.0f) {
                    this.Qi = true;
                } else if ("bottom".equals(str) && this.Qf != -1.0f) {
                    this.Qj = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.MT.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
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
                this.Qh = (int) ((this.Qd - this.MH) * (-f2));
            } else if (f2 > 0.0f) {
                this.Qh = (int) ((this.MH - this.Qf) * f2);
            } else if (f2 == 0.0f) {
                this.Qh = 0;
                this.MQ = 10004;
            } else if (f2 == -1.0f) {
                this.Qd -= this.MH;
                this.MQ = 10000;
            } else if (f2 == 1.0f) {
                this.Qd = this.MH - this.Qf;
                this.MQ = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Qd;
    }

    public int getBottomOffset() {
        return (int) this.Qf;
    }

    public void setTopTapBack(boolean z) {
        this.Qi = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Qj = z;
    }

    public int getState() {
        return this.MQ;
    }

    public void setTopAnimationListener(e eVar) {
        this.Qs = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Qt = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Qu = fVar;
    }

    private boolean oU() {
        return (this.Qd == -1.0f && this.Qg == -1.0f) ? false : true;
    }

    private boolean oV() {
        return (this.Qf == -1.0f && this.Qe == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Qh);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Qh);
        canvas.drawRect(0.0f, 0.0f, this.MG, this.MH, this.MT);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Qh;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Qk == TrackDirection.none) {
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
                    this.Qp.removeMessages(-100);
                    this.Qp.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Qp.removeMessages(-101);
                    this.Qp.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Qh);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.MU - this.MM && i <= this.MU + this.MM && (i2 < this.MV - this.MM || i2 > this.MV + this.MM) && this.Qr.bc(i2 - this.MV);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Qo = false;
                    if (this.Qr.Nq) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Qr.ol();
                        this.Qr.om();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Qr.Nq) {
                        if (!this.Qo) {
                            if (y > this.MV) {
                                this.Qn = this.MV + this.MM;
                                this.Qo = true;
                            } else {
                                this.Qn = this.MV - this.MM;
                                this.Qo = true;
                            }
                        }
                        this.Qr.bd(this.Qn - y);
                        this.Qn = y;
                        this.Qr.Np.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.MQ != 10000 || !this.Ql.contains(x, y)) && (this.MQ != 10001 || !this.Qm.contains(x, y))) {
                    return false;
                }
                if (!this.Qr.Nq) {
                    this.Qn = y;
                    this.Qr.bc(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Qr.Nq) {
                    this.Qr.ol();
                    this.Qr.om();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Qr.Nq) {
            this.Qr.bd(this.Qn - y);
            this.Qn = y;
            this.Qr.Np.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Qd != -1.0f) {
                this.Ql.set(i, i2, i3, (int) (i2 + this.Qd));
            }
            if (this.Qf != -1.0f) {
                this.Qm.set(i, (int) (i4 - this.Qf), i3, i4);
            }
        }
        if (!this.Qq.No && !this.Qr.Nq) {
            nZ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Qe != -1.0f) {
            this.Qd = i3 - this.Qg;
        }
        if (this.Qg != -1.0f) {
            this.Qf = i3 - this.Qe;
        }
        if (!$assertionsDisabled && i3 < this.Qd) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Qf) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.MG = getMeasuredWidth();
        this.MH = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ() {
        switch (this.MQ) {
            case 10000:
                this.Qh = (int) (this.Qd - this.MH);
                invalidate();
                return;
            case 10001:
                this.Qh = (int) (this.MH - this.Qf);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Qh = 0;
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
            if (VerticalTranslateLayout.this.Qq.No) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Qq.oZ();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Qq.oY();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Qq.oX();
                        return;
                    case -100:
                        VerticalTranslateLayout.this.Qq.oW();
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
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Nr = (int) ((200.0f * f) + 0.5f);
            this.Ns = (int) ((f * 500.0f) + 0.5f);
        }

        boolean bc(int i) {
            switch (VerticalTranslateLayout.this.Qk) {
                case top:
                    if (VerticalTranslateLayout.this.MQ != 10004 && VerticalTranslateLayout.this.MQ != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.MQ != 10004 && VerticalTranslateLayout.this.MQ != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Qu != null) {
                        VerticalTranslateLayout.this.Qu.bp(i);
                        break;
                    }
                    break;
            }
            this.Np = VelocityTracker.obtain();
            this.Nq = true;
            return true;
        }

        void ol() {
            this.Nq = false;
        }

        void bd(int i) {
            if (this.Nq) {
                int i2 = VerticalTranslateLayout.this.Qh - i;
                switch (VerticalTranslateLayout.this.Qk) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Qd - VerticalTranslateLayout.this.MH && i2 < 0) {
                            VerticalTranslateLayout.this.Qh -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.MH - VerticalTranslateLayout.this.Qf && i2 > 0) {
                            VerticalTranslateLayout.this.Qh -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Qd - VerticalTranslateLayout.this.MH && i2 <= VerticalTranslateLayout.this.MH - VerticalTranslateLayout.this.Qf) {
                            VerticalTranslateLayout.this.Qh -= i;
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
        public void om() {
            float max;
            this.Np.computeCurrentVelocity(this.Nr);
            float yVelocity = this.Np.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ns);
            } else {
                max = Math.max(yVelocity, this.Ns);
            }
            switch (VerticalTranslateLayout.this.Qk) {
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
            this.Np.recycle();
            this.Np = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Qh;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Qd - VerticalTranslateLayout.this.MH) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Qq.R(f);
                } else {
                    VerticalTranslateLayout.this.Qq.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.MH - VerticalTranslateLayout.this.Qf) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Qq.Q(f);
                } else {
                    VerticalTranslateLayout.this.Qq.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Qq.R(f);
            } else {
                VerticalTranslateLayout.this.Qq.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Qq.Q(f);
            } else {
                VerticalTranslateLayout.this.Qq.S(f);
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
            this.Nh = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ni = ((((float) (uptimeMillis - this.Nm)) / 1000.0f) * this.Nj) + this.Ni;
            this.Nm = uptimeMillis;
            this.Nn += 16;
        }

        void oW() {
            compute();
            if (this.Ni <= this.Nk) {
                e eVar = VerticalTranslateLayout.this.Qs;
                if (eVar != null) {
                    eVar.pb();
                }
                this.No = false;
                VerticalTranslateLayout.this.MQ = 10000;
                VerticalTranslateLayout.this.nZ();
                return;
            }
            VerticalTranslateLayout.this.Qh = (int) (com.baidu.adp.widget.a.a(this.Nk, this.Ni, false) + this.Nl);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qp.sendEmptyMessageAtTime(-100, this.Nn);
        }

        void oX() {
            compute();
            if (this.Ni >= this.Nk) {
                c cVar = VerticalTranslateLayout.this.Qt;
                if (cVar != null) {
                    cVar.pa();
                }
                this.No = false;
                VerticalTranslateLayout.this.MQ = 10001;
                VerticalTranslateLayout.this.nZ();
                return;
            }
            VerticalTranslateLayout.this.Qh = (int) (com.baidu.adp.widget.a.a(this.Nk, this.Ni, false) + this.Nl);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qp.sendEmptyMessageAtTime(-101, this.Nn);
        }

        void oY() {
            compute();
            if (this.Ni >= this.Nk) {
                for (d dVar : VerticalTranslateLayout.this.Nd) {
                    if (dVar != null) {
                        dVar.oi();
                    }
                }
                this.No = false;
                VerticalTranslateLayout.this.MQ = 10004;
                VerticalTranslateLayout.this.nZ();
                return;
            }
            VerticalTranslateLayout.this.Qh = (int) (com.baidu.adp.widget.a.a(this.Nk, this.Ni, false) + this.Nl);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qp.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nn);
        }

        void oZ() {
            compute();
            if (this.Ni <= this.Nk) {
                for (d dVar : VerticalTranslateLayout.this.Nd) {
                    if (dVar != null) {
                        dVar.oi();
                    }
                }
                this.No = false;
                VerticalTranslateLayout.this.MQ = 10004;
                VerticalTranslateLayout.this.nZ();
                return;
            }
            VerticalTranslateLayout.this.Qh = (int) (com.baidu.adp.widget.a.a(this.Nk, this.Ni, false) + this.Nl);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qp.sendEmptyMessageAtTime(-105, this.Nn);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Nd) {
                if (dVar != null) {
                    dVar.oh();
                }
            }
            this.No = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nm = uptimeMillis;
            this.Nn = uptimeMillis + 16;
            this.Nj = f;
            this.Ni = 0.0f;
            this.Nk = 0 - VerticalTranslateLayout.this.Qh;
            this.Nl = VerticalTranslateLayout.this.Qh;
            VerticalTranslateLayout.this.Qp.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Nk);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Qp.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nn);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Nd) {
                if (dVar != null) {
                    dVar.oh();
                }
            }
            this.No = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nm = uptimeMillis;
            this.Nn = uptimeMillis + 16;
            this.Nj = f;
            this.Ni = 0.0f;
            this.Nk = 0 - VerticalTranslateLayout.this.Qh;
            this.Nl = VerticalTranslateLayout.this.Qh;
            BdLog.d("Animator@animateBottomOpen " + this.Nk);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Qp.removeMessages(-105);
            VerticalTranslateLayout.this.Qp.sendEmptyMessageAtTime(-105, this.Nn);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.Qs;
            if (eVar != null) {
                eVar.oe();
            }
            this.No = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nm = uptimeMillis;
            this.Nn = uptimeMillis + 16;
            this.Nj = f;
            this.Ni = 0.0f;
            this.Nk = ((-VerticalTranslateLayout.this.MH) + VerticalTranslateLayout.this.Qd) - VerticalTranslateLayout.this.Qh;
            this.Nl = VerticalTranslateLayout.this.Qh;
            BdLog.d("Animator@animateTop " + this.Nk);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Qp.removeMessages(-100);
            VerticalTranslateLayout.this.Qp.sendEmptyMessageAtTime(-100, this.Nn);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.Qt;
            if (cVar != null) {
                cVar.oj();
            }
            this.No = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nm = uptimeMillis;
            this.Nn = uptimeMillis + 16;
            this.Nj = f;
            this.Ni = 0.0f;
            this.Nk = (VerticalTranslateLayout.this.MH - VerticalTranslateLayout.this.Qf) - VerticalTranslateLayout.this.Qh;
            this.Nl = VerticalTranslateLayout.this.Qh;
            BdLog.d("Animator@animateBottom " + this.Nk);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Qp.removeMessages(-101);
            VerticalTranslateLayout.this.Qp.sendEmptyMessageAtTime(-101, this.Nn);
        }
    }
}
