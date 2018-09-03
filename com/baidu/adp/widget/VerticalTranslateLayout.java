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
    private int JM;
    private int JN;
    private final int JR;
    private int JV;
    private final Paint JY;
    private int JZ;
    private int Ka;
    private final List<d> Ki;
    private float Ng;
    private float Nh;
    private float Ni;
    private float Nj;
    private int Nk;
    private boolean Nl;
    private boolean Nm;
    private TrackDirection Nn;
    private final Rect No;
    private final Rect Np;
    private int Nq;
    private boolean Nr;
    private final a Ns;
    private final b Nt;
    private final g Nu;
    private e Nv;
    private c Nw;
    private f Nx;

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
        void mU();

        void nO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mS();

        void mT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mQ();

        void nP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aQ(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.No = new Rect();
        this.Np = new Rect();
        this.Ki = new ArrayList();
        this.Ns = new a();
        this.Nt = new b();
        this.Nu = new g();
        this.JV = 10004;
        Resources resources = getResources();
        this.JY = new Paint();
        this.JY.setColor(-1);
        this.JR = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Ng = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Ni = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Nh = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Nj = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (nI() && nJ() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Nn = TrackDirection.vertical;
            } else if (nJ() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Nn = TrackDirection.bottom;
            } else if (nI() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Nn = TrackDirection.top;
            } else {
                this.Nn = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.Ng != -1.0f) {
                    this.Nl = true;
                } else if ("bottom".equals(str) && this.Ni != -1.0f) {
                    this.Nm = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.JY.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.JY.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Nk = (int) ((this.Ng - this.JN) * (-f2));
            } else if (f2 > 0.0f) {
                this.Nk = (int) ((this.JN - this.Ni) * f2);
            } else if (f2 == 0.0f) {
                this.Nk = 0;
                this.JV = 10004;
            } else if (f2 == -1.0f) {
                this.Ng -= this.JN;
                this.JV = 10000;
            } else if (f2 == 1.0f) {
                this.Ng = this.JN - this.Ni;
                this.JV = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Ng;
    }

    public int getBottomOffset() {
        return (int) this.Ni;
    }

    public void setTopTapBack(boolean z) {
        this.Nl = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Nm = z;
    }

    public int getState() {
        return this.JV;
    }

    public void setTopAnimationListener(e eVar) {
        this.Nv = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Nw = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Nx = fVar;
    }

    private boolean nI() {
        return (this.Ng == -1.0f && this.Nj == -1.0f) ? false : true;
    }

    private boolean nJ() {
        return (this.Ni == -1.0f && this.Nh == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Nk);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Nk);
        canvas.drawRect(0.0f, 0.0f, this.JM, this.JN, this.JY);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Nk;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Nn == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.JV == 10004) {
            switch (action) {
                case 0:
                    this.JZ = x;
                    this.Ka = y;
                    this.Ns.removeMessages(-100);
                    this.Ns.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Ns.removeMessages(-101);
                    this.Ns.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Nk);
                    return o(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i >= this.JZ - this.JR && i <= this.JZ + this.JR && (i2 < this.Ka - this.JR || i2 > this.Ka + this.JR) && this.Nu.aD(i2 - this.Ka);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.JV == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Nr = false;
                    if (this.Nu.Kv) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Nu.mW();
                        this.Nu.mX();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Nu.Kv) {
                        if (!this.Nr) {
                            if (y > this.Ka) {
                                this.Nq = this.Ka + this.JR;
                                this.Nr = true;
                            } else {
                                this.Nq = this.Ka - this.JR;
                                this.Nr = true;
                            }
                        }
                        this.Nu.aE(this.Nq - y);
                        this.Nq = y;
                        this.Nu.Ku.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.JV != 10000 || !this.No.contains(x, y)) && (this.JV != 10001 || !this.Np.contains(x, y))) {
                    return false;
                }
                if (!this.Nu.Kv) {
                    this.Nq = y;
                    this.Nu.aD(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Nu.Kv) {
                    this.Nu.mW();
                    this.Nu.mX();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Nu.Kv) {
            this.Nu.aE(this.Nq - y);
            this.Nq = y;
            this.Nu.Ku.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ng != -1.0f) {
                this.No.set(i, i2, i3, (int) (i2 + this.Ng));
            }
            if (this.Ni != -1.0f) {
                this.Np.set(i, (int) (i4 - this.Ni), i3, i4);
            }
        }
        if (!this.Nt.Kt && !this.Nu.Kv) {
            mL();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Nh != -1.0f) {
            this.Ng = i3 - this.Nj;
        }
        if (this.Nj != -1.0f) {
            this.Ni = i3 - this.Nh;
        }
        if (!$assertionsDisabled && i3 < this.Ng) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Ni) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.JM = getMeasuredWidth();
        this.JN = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL() {
        switch (this.JV) {
            case 10000:
                this.Nk = (int) (this.Ng - this.JN);
                invalidate();
                return;
            case 10001:
                this.Nk = (int) (this.JN - this.Ni);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Nk = 0;
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
            if (VerticalTranslateLayout.this.Nt.Kt) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Nt.nN();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Nt.nM();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Nt.nL();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.Nt.nK();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Ku;
        boolean Kv;
        final int Kw;
        final int Kx;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Kw = (int) ((200.0f * f) + 0.5f);
            this.Kx = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aD(int i) {
            switch (VerticalTranslateLayout.this.Nn) {
                case top:
                    if (VerticalTranslateLayout.this.JV != 10004 && VerticalTranslateLayout.this.JV != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.JV != 10004 && VerticalTranslateLayout.this.JV != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Nx != null) {
                        VerticalTranslateLayout.this.Nx.aQ(i);
                        break;
                    }
                    break;
            }
            this.Ku = VelocityTracker.obtain();
            this.Kv = true;
            return true;
        }

        void mW() {
            this.Kv = false;
        }

        void aE(int i) {
            if (this.Kv) {
                int i2 = VerticalTranslateLayout.this.Nk - i;
                switch (VerticalTranslateLayout.this.Nn) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Ng - VerticalTranslateLayout.this.JN && i2 < 0) {
                            VerticalTranslateLayout.this.Nk -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.JN - VerticalTranslateLayout.this.Ni && i2 > 0) {
                            VerticalTranslateLayout.this.Nk -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Ng - VerticalTranslateLayout.this.JN && i2 <= VerticalTranslateLayout.this.JN - VerticalTranslateLayout.this.Ni) {
                            VerticalTranslateLayout.this.Nk -= i;
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
        public void mX() {
            float max;
            this.Ku.computeCurrentVelocity(this.Kw);
            float yVelocity = this.Ku.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Kx);
            } else {
                max = Math.max(yVelocity, this.Kx);
            }
            switch (VerticalTranslateLayout.this.Nn) {
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
            this.Ku.recycle();
            this.Ku = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Nk;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Ng - VerticalTranslateLayout.this.JN) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Nt.R(f);
                } else {
                    VerticalTranslateLayout.this.Nt.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.JN - VerticalTranslateLayout.this.Ni) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Nt.Q(f);
                } else {
                    VerticalTranslateLayout.this.Nt.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Nt.R(f);
            } else {
                VerticalTranslateLayout.this.Nt.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Nt.Q(f);
            } else {
                VerticalTranslateLayout.this.Nt.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Km;
        float Kn;
        float Ko;
        float Kp;
        float Kq;
        long Kr;
        long Ks;
        boolean Kt;

        b() {
            this.Km = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kn = ((((float) (uptimeMillis - this.Kr)) / 1000.0f) * this.Ko) + this.Kn;
            this.Kr = uptimeMillis;
            this.Ks += 16;
        }

        void nK() {
            compute();
            if (this.Kn <= this.Kp) {
                e eVar = VerticalTranslateLayout.this.Nv;
                if (eVar != null) {
                    eVar.nP();
                }
                this.Kt = false;
                VerticalTranslateLayout.this.JV = 10000;
                VerticalTranslateLayout.this.mL();
                return;
            }
            VerticalTranslateLayout.this.Nk = (int) (com.baidu.adp.widget.a.a(this.Kp, this.Kn, false) + this.Kq);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-100, this.Ks);
        }

        void nL() {
            compute();
            if (this.Kn >= this.Kp) {
                c cVar = VerticalTranslateLayout.this.Nw;
                if (cVar != null) {
                    cVar.nO();
                }
                this.Kt = false;
                VerticalTranslateLayout.this.JV = 10001;
                VerticalTranslateLayout.this.mL();
                return;
            }
            VerticalTranslateLayout.this.Nk = (int) (com.baidu.adp.widget.a.a(this.Kp, this.Kn, false) + this.Kq);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-101, this.Ks);
        }

        void nM() {
            compute();
            if (this.Kn >= this.Kp) {
                for (d dVar : VerticalTranslateLayout.this.Ki) {
                    if (dVar != null) {
                        dVar.mT();
                    }
                }
                this.Kt = false;
                VerticalTranslateLayout.this.JV = 10004;
                VerticalTranslateLayout.this.mL();
                return;
            }
            VerticalTranslateLayout.this.Nk = (int) (com.baidu.adp.widget.a.a(this.Kp, this.Kn, false) + this.Kq);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Ns.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ks);
        }

        void nN() {
            compute();
            if (this.Kn <= this.Kp) {
                for (d dVar : VerticalTranslateLayout.this.Ki) {
                    if (dVar != null) {
                        dVar.mT();
                    }
                }
                this.Kt = false;
                VerticalTranslateLayout.this.JV = 10004;
                VerticalTranslateLayout.this.mL();
                return;
            }
            VerticalTranslateLayout.this.Nk = (int) (com.baidu.adp.widget.a.a(this.Kp, this.Kn, false) + this.Kq);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-105, this.Ks);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Ki) {
                if (dVar != null) {
                    dVar.mS();
                }
            }
            this.Kt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kr = uptimeMillis;
            this.Ks = uptimeMillis + 16;
            this.Ko = f;
            this.Kn = 0.0f;
            this.Kp = 0 - VerticalTranslateLayout.this.Nk;
            this.Kq = VerticalTranslateLayout.this.Nk;
            VerticalTranslateLayout.this.Ns.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Kp);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Ns.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ks);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Ki) {
                if (dVar != null) {
                    dVar.mS();
                }
            }
            this.Kt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kr = uptimeMillis;
            this.Ks = uptimeMillis + 16;
            this.Ko = f;
            this.Kn = 0.0f;
            this.Kp = 0 - VerticalTranslateLayout.this.Nk;
            this.Kq = VerticalTranslateLayout.this.Nk;
            BdLog.d("Animator@animateBottomOpen " + this.Kp);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Ns.removeMessages(-105);
            VerticalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-105, this.Ks);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.Nv;
            if (eVar != null) {
                eVar.mQ();
            }
            this.Kt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kr = uptimeMillis;
            this.Ks = uptimeMillis + 16;
            this.Ko = f;
            this.Kn = 0.0f;
            this.Kp = ((-VerticalTranslateLayout.this.JN) + VerticalTranslateLayout.this.Ng) - VerticalTranslateLayout.this.Nk;
            this.Kq = VerticalTranslateLayout.this.Nk;
            BdLog.d("Animator@animateTop " + this.Kp);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Ns.removeMessages(-100);
            VerticalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-100, this.Ks);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.Nw;
            if (cVar != null) {
                cVar.mU();
            }
            this.Kt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kr = uptimeMillis;
            this.Ks = uptimeMillis + 16;
            this.Ko = f;
            this.Kn = 0.0f;
            this.Kp = (VerticalTranslateLayout.this.JN - VerticalTranslateLayout.this.Ni) - VerticalTranslateLayout.this.Nk;
            this.Kq = VerticalTranslateLayout.this.Nk;
            BdLog.d("Animator@animateBottom " + this.Kp);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Ns.removeMessages(-101);
            VerticalTranslateLayout.this.Ns.sendEmptyMessageAtTime(-101, this.Ks);
        }
    }
}
