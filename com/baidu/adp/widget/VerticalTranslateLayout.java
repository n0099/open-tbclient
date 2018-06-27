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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int JP;
    private int JQ;
    private final int JU;
    private int JY;
    private final Paint Kb;
    private int Kc;
    private int Kd;
    private final List<d> Kl;
    private f NB;
    private float Nj;
    private float Nk;
    private float Nl;
    private float Nm;
    private int Nn;
    private boolean No;
    private boolean Np;
    private TrackDirection Nq;
    private final Rect Nr;
    private final Rect Ns;
    private int Nt;
    private boolean Nu;
    private final a Nv;
    private final b Nw;
    private final g Nx;
    private e Ny;
    private c Nz;

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
        void mS();

        void nO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mQ();

        void mR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mO();

        void nP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aP(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Nr = new Rect();
        this.Ns = new Rect();
        this.Kl = new ArrayList();
        this.Nv = new a();
        this.Nw = new b();
        this.Nx = new g();
        this.JY = 10004;
        Resources resources = getResources();
        this.Kb = new Paint();
        this.Kb.setColor(-1);
        this.JU = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Nj = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Nl = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Nk = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Nm = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (nI() && nJ() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Nq = TrackDirection.vertical;
            } else if (nJ() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Nq = TrackDirection.bottom;
            } else if (nI() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Nq = TrackDirection.top;
            } else {
                this.Nq = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.Nj != -1.0f) {
                    this.No = true;
                } else if ("bottom".equals(str) && this.Nl != -1.0f) {
                    this.Np = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Kb.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Kb.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Nn = (int) ((this.Nj - this.JQ) * (-f2));
            } else if (f2 > 0.0f) {
                this.Nn = (int) ((this.JQ - this.Nl) * f2);
            } else if (f2 == 0.0f) {
                this.Nn = 0;
                this.JY = 10004;
            } else if (f2 == -1.0f) {
                this.Nj -= this.JQ;
                this.JY = 10000;
            } else if (f2 == 1.0f) {
                this.Nj = this.JQ - this.Nl;
                this.JY = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Nj;
    }

    public int getBottomOffset() {
        return (int) this.Nl;
    }

    public void setTopTapBack(boolean z) {
        this.No = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Np = z;
    }

    public int getState() {
        return this.JY;
    }

    public void setTopAnimationListener(e eVar) {
        this.Ny = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Nz = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.NB = fVar;
    }

    private boolean nI() {
        return (this.Nj == -1.0f && this.Nm == -1.0f) ? false : true;
    }

    private boolean nJ() {
        return (this.Nl == -1.0f && this.Nk == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Nn);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Nn);
        canvas.drawRect(0.0f, 0.0f, this.JP, this.JQ, this.Kb);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Nn;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Nq == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.JY == 10004) {
            switch (action) {
                case 0:
                    this.Kc = x;
                    this.Kd = y;
                    this.Nv.removeMessages(-100);
                    this.Nv.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Nv.removeMessages(-101);
                    this.Nv.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Nn);
                    return o(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i >= this.Kc - this.JU && i <= this.Kc + this.JU && (i2 < this.Kd - this.JU || i2 > this.Kd + this.JU) && this.Nx.aC(i2 - this.Kd);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.JY == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Nu = false;
                    if (this.Nx.Ky) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Nx.mU();
                        this.Nx.mV();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Nx.Ky) {
                        if (!this.Nu) {
                            if (y > this.Kd) {
                                this.Nt = this.Kd + this.JU;
                                this.Nu = true;
                            } else {
                                this.Nt = this.Kd - this.JU;
                                this.Nu = true;
                            }
                        }
                        this.Nx.aD(this.Nt - y);
                        this.Nt = y;
                        this.Nx.Kx.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.JY != 10000 || !this.Nr.contains(x, y)) && (this.JY != 10001 || !this.Ns.contains(x, y))) {
                    return false;
                }
                if (!this.Nx.Ky) {
                    this.Nt = y;
                    this.Nx.aC(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Nx.Ky) {
                    this.Nx.mU();
                    this.Nx.mV();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Nx.Ky) {
            this.Nx.aD(this.Nt - y);
            this.Nt = y;
            this.Nx.Kx.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Nj != -1.0f) {
                this.Nr.set(i, i2, i3, (int) (i2 + this.Nj));
            }
            if (this.Nl != -1.0f) {
                this.Ns.set(i, (int) (i4 - this.Nl), i3, i4);
            }
        }
        if (!this.Nw.Kw && !this.Nx.Ky) {
            mJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Nk != -1.0f) {
            this.Nj = i3 - this.Nm;
        }
        if (this.Nm != -1.0f) {
            this.Nl = i3 - this.Nk;
        }
        if (!$assertionsDisabled && i3 < this.Nj) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Nl) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.JP = getMeasuredWidth();
        this.JQ = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        switch (this.JY) {
            case 10000:
                this.Nn = (int) (this.Nj - this.JQ);
                invalidate();
                return;
            case 10001:
                this.Nn = (int) (this.JQ - this.Nl);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Nn = 0;
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
            if (VerticalTranslateLayout.this.Nw.Kw) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Nw.nN();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Nw.nM();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Nw.nL();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.Nw.nK();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        final int KA;
        VelocityTracker Kx;
        boolean Ky;
        final int Kz;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Kz = (int) ((200.0f * f) + 0.5f);
            this.KA = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aC(int i) {
            switch (VerticalTranslateLayout.this.Nq) {
                case top:
                    if (VerticalTranslateLayout.this.JY != 10004 && VerticalTranslateLayout.this.JY != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.JY != 10004 && VerticalTranslateLayout.this.JY != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.NB != null) {
                        VerticalTranslateLayout.this.NB.aP(i);
                        break;
                    }
                    break;
            }
            this.Kx = VelocityTracker.obtain();
            this.Ky = true;
            return true;
        }

        void mU() {
            this.Ky = false;
        }

        void aD(int i) {
            if (this.Ky) {
                int i2 = VerticalTranslateLayout.this.Nn - i;
                switch (VerticalTranslateLayout.this.Nq) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Nj - VerticalTranslateLayout.this.JQ && i2 < 0) {
                            VerticalTranslateLayout.this.Nn -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.JQ - VerticalTranslateLayout.this.Nl && i2 > 0) {
                            VerticalTranslateLayout.this.Nn -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Nj - VerticalTranslateLayout.this.JQ && i2 <= VerticalTranslateLayout.this.JQ - VerticalTranslateLayout.this.Nl) {
                            VerticalTranslateLayout.this.Nn -= i;
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
        public void mV() {
            float max;
            this.Kx.computeCurrentVelocity(this.Kz);
            float yVelocity = this.Kx.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.KA);
            } else {
                max = Math.max(yVelocity, this.KA);
            }
            switch (VerticalTranslateLayout.this.Nq) {
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
            this.Kx.recycle();
            this.Kx = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Nn;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Nj - VerticalTranslateLayout.this.JQ) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Nw.R(f);
                } else {
                    VerticalTranslateLayout.this.Nw.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.JQ - VerticalTranslateLayout.this.Nl) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Nw.Q(f);
                } else {
                    VerticalTranslateLayout.this.Nw.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Nw.R(f);
            } else {
                VerticalTranslateLayout.this.Nw.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Nw.Q(f);
            } else {
                VerticalTranslateLayout.this.Nw.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Kp;
        float Kq;
        float Kr;
        float Ks;
        float Kt;
        long Ku;
        long Kv;
        boolean Kw;

        b() {
            this.Kp = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kq = ((((float) (uptimeMillis - this.Ku)) / 1000.0f) * this.Kr) + this.Kq;
            this.Ku = uptimeMillis;
            this.Kv += 16;
        }

        void nK() {
            compute();
            if (this.Kq <= this.Ks) {
                e eVar = VerticalTranslateLayout.this.Ny;
                if (eVar != null) {
                    eVar.nP();
                }
                this.Kw = false;
                VerticalTranslateLayout.this.JY = 10000;
                VerticalTranslateLayout.this.mJ();
                return;
            }
            VerticalTranslateLayout.this.Nn = (int) (com.baidu.adp.widget.a.a(this.Ks, this.Kq, false) + this.Kt);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Nv.sendEmptyMessageAtTime(-100, this.Kv);
        }

        void nL() {
            compute();
            if (this.Kq >= this.Ks) {
                c cVar = VerticalTranslateLayout.this.Nz;
                if (cVar != null) {
                    cVar.nO();
                }
                this.Kw = false;
                VerticalTranslateLayout.this.JY = 10001;
                VerticalTranslateLayout.this.mJ();
                return;
            }
            VerticalTranslateLayout.this.Nn = (int) (com.baidu.adp.widget.a.a(this.Ks, this.Kq, false) + this.Kt);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Nv.sendEmptyMessageAtTime(-101, this.Kv);
        }

        void nM() {
            compute();
            if (this.Kq >= this.Ks) {
                for (d dVar : VerticalTranslateLayout.this.Kl) {
                    if (dVar != null) {
                        dVar.mR();
                    }
                }
                this.Kw = false;
                VerticalTranslateLayout.this.JY = 10004;
                VerticalTranslateLayout.this.mJ();
                return;
            }
            VerticalTranslateLayout.this.Nn = (int) (com.baidu.adp.widget.a.a(this.Ks, this.Kq, false) + this.Kt);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Nv.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Kv);
        }

        void nN() {
            compute();
            if (this.Kq <= this.Ks) {
                for (d dVar : VerticalTranslateLayout.this.Kl) {
                    if (dVar != null) {
                        dVar.mR();
                    }
                }
                this.Kw = false;
                VerticalTranslateLayout.this.JY = 10004;
                VerticalTranslateLayout.this.mJ();
                return;
            }
            VerticalTranslateLayout.this.Nn = (int) (com.baidu.adp.widget.a.a(this.Ks, this.Kq, false) + this.Kt);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Nv.sendEmptyMessageAtTime(-105, this.Kv);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Kl) {
                if (dVar != null) {
                    dVar.mQ();
                }
            }
            this.Kw = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ku = uptimeMillis;
            this.Kv = uptimeMillis + 16;
            this.Kr = f;
            this.Kq = 0.0f;
            this.Ks = 0 - VerticalTranslateLayout.this.Nn;
            this.Kt = VerticalTranslateLayout.this.Nn;
            VerticalTranslateLayout.this.Nv.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Ks);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Nv.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Kv);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Kl) {
                if (dVar != null) {
                    dVar.mQ();
                }
            }
            this.Kw = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ku = uptimeMillis;
            this.Kv = uptimeMillis + 16;
            this.Kr = f;
            this.Kq = 0.0f;
            this.Ks = 0 - VerticalTranslateLayout.this.Nn;
            this.Kt = VerticalTranslateLayout.this.Nn;
            BdLog.d("Animator@animateBottomOpen " + this.Ks);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Nv.removeMessages(-105);
            VerticalTranslateLayout.this.Nv.sendEmptyMessageAtTime(-105, this.Kv);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.Ny;
            if (eVar != null) {
                eVar.mO();
            }
            this.Kw = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ku = uptimeMillis;
            this.Kv = uptimeMillis + 16;
            this.Kr = f;
            this.Kq = 0.0f;
            this.Ks = ((-VerticalTranslateLayout.this.JQ) + VerticalTranslateLayout.this.Nj) - VerticalTranslateLayout.this.Nn;
            this.Kt = VerticalTranslateLayout.this.Nn;
            BdLog.d("Animator@animateTop " + this.Ks);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Nv.removeMessages(-100);
            VerticalTranslateLayout.this.Nv.sendEmptyMessageAtTime(-100, this.Kv);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.Nz;
            if (cVar != null) {
                cVar.mS();
            }
            this.Kw = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ku = uptimeMillis;
            this.Kv = uptimeMillis + 16;
            this.Kr = f;
            this.Kq = 0.0f;
            this.Ks = (VerticalTranslateLayout.this.JQ - VerticalTranslateLayout.this.Nl) - VerticalTranslateLayout.this.Nn;
            this.Kt = VerticalTranslateLayout.this.Nn;
            BdLog.d("Animator@animateBottom " + this.Ks);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Nv.removeMessages(-101);
            VerticalTranslateLayout.this.Nv.sendEmptyMessageAtTime(-101, this.Kv);
        }
    }
}
