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
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int JN;
    private int JO;
    private final int JS;
    private int JW;
    private final Paint JZ;
    private int Ka;
    private int Kb;
    private final List<d> Kj;
    private float Nh;
    private float Ni;
    private float Nj;
    private float Nk;
    private int Nl;
    private boolean Nm;
    private boolean Nn;
    private TrackDirection No;
    private final Rect Np;
    private final Rect Nq;
    private int Nr;
    private boolean Ns;
    private final a Nt;
    private final b Nu;
    private final g Nv;
    private e Nw;
    private c Nx;
    private f Ny;

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
        this.Np = new Rect();
        this.Nq = new Rect();
        this.Kj = new ArrayList();
        this.Nt = new a();
        this.Nu = new b();
        this.Nv = new g();
        this.JW = ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE;
        Resources resources = getResources();
        this.JZ = new Paint();
        this.JZ.setColor(-1);
        this.JS = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Nh = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Nj = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Ni = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Nk = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (nI() && nJ() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.No = TrackDirection.vertical;
            } else if (nJ() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.No = TrackDirection.bottom;
            } else if (nI() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.No = TrackDirection.top;
            } else {
                this.No = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.Nh != -1.0f) {
                    this.Nm = true;
                } else if ("bottom".equals(str) && this.Nj != -1.0f) {
                    this.Nn = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.JZ.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.JZ.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Nl = (int) ((this.Nh - this.JO) * (-f2));
            } else if (f2 > 0.0f) {
                this.Nl = (int) ((this.JO - this.Nj) * f2);
            } else if (f2 == 0.0f) {
                this.Nl = 0;
                this.JW = ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.Nh -= this.JO;
                this.JW = 10000;
            } else if (f2 == 1.0f) {
                this.Nh = this.JO - this.Nj;
                this.JW = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Nh;
    }

    public int getBottomOffset() {
        return (int) this.Nj;
    }

    public void setTopTapBack(boolean z) {
        this.Nm = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Nn = z;
    }

    public int getState() {
        return this.JW;
    }

    public void setTopAnimationListener(e eVar) {
        this.Nw = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Nx = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Ny = fVar;
    }

    private boolean nI() {
        return (this.Nh == -1.0f && this.Nk == -1.0f) ? false : true;
    }

    private boolean nJ() {
        return (this.Nj == -1.0f && this.Ni == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Nl);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Nl);
        canvas.drawRect(0.0f, 0.0f, this.JN, this.JO, this.JZ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Nl;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.No == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.JW == 10004) {
            switch (action) {
                case 0:
                    this.Ka = x;
                    this.Kb = y;
                    this.Nt.removeMessages(-100);
                    this.Nt.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Nt.removeMessages(-101);
                    this.Nt.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Nl);
                    return o(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i >= this.Ka - this.JS && i <= this.Ka + this.JS && (i2 < this.Kb - this.JS || i2 > this.Kb + this.JS) && this.Nv.aC(i2 - this.Kb);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.JW == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Ns = false;
                    if (this.Nv.Kw) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Nv.mU();
                        this.Nv.mV();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Nv.Kw) {
                        if (!this.Ns) {
                            if (y > this.Kb) {
                                this.Nr = this.Kb + this.JS;
                                this.Ns = true;
                            } else {
                                this.Nr = this.Kb - this.JS;
                                this.Ns = true;
                            }
                        }
                        this.Nv.aD(this.Nr - y);
                        this.Nr = y;
                        this.Nv.Kv.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.JW != 10000 || !this.Np.contains(x, y)) && (this.JW != 10001 || !this.Nq.contains(x, y))) {
                    return false;
                }
                if (!this.Nv.Kw) {
                    this.Nr = y;
                    this.Nv.aC(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Nv.Kw) {
                    this.Nv.mU();
                    this.Nv.mV();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Nv.Kw) {
            this.Nv.aD(this.Nr - y);
            this.Nr = y;
            this.Nv.Kv.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Nh != -1.0f) {
                this.Np.set(i, i2, i3, (int) (i2 + this.Nh));
            }
            if (this.Nj != -1.0f) {
                this.Nq.set(i, (int) (i4 - this.Nj), i3, i4);
            }
        }
        if (!this.Nu.Ku && !this.Nv.Kw) {
            mJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Ni != -1.0f) {
            this.Nh = i3 - this.Nk;
        }
        if (this.Nk != -1.0f) {
            this.Nj = i3 - this.Ni;
        }
        if (!$assertionsDisabled && i3 < this.Nh) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Nj) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.JN = getMeasuredWidth();
        this.JO = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        switch (this.JW) {
            case 10000:
                this.Nl = (int) (this.Nh - this.JO);
                invalidate();
                return;
            case 10001:
                this.Nl = (int) (this.JO - this.Nj);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE /* 10004 */:
                this.Nl = 0;
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
            if (VerticalTranslateLayout.this.Nu.Ku) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Nu.nN();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Nu.nM();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Nu.nL();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.Nu.nK();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Kv;
        boolean Kw;
        final int Kx;
        final int Ky;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Kx = (int) ((200.0f * f) + 0.5f);
            this.Ky = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aC(int i) {
            switch (VerticalTranslateLayout.this.No) {
                case top:
                    if (VerticalTranslateLayout.this.JW != 10004 && VerticalTranslateLayout.this.JW != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.JW != 10004 && VerticalTranslateLayout.this.JW != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Ny != null) {
                        VerticalTranslateLayout.this.Ny.aP(i);
                        break;
                    }
                    break;
            }
            this.Kv = VelocityTracker.obtain();
            this.Kw = true;
            return true;
        }

        void mU() {
            this.Kw = false;
        }

        void aD(int i) {
            if (this.Kw) {
                int i2 = VerticalTranslateLayout.this.Nl - i;
                switch (VerticalTranslateLayout.this.No) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Nh - VerticalTranslateLayout.this.JO && i2 < 0) {
                            VerticalTranslateLayout.this.Nl -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.JO - VerticalTranslateLayout.this.Nj && i2 > 0) {
                            VerticalTranslateLayout.this.Nl -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Nh - VerticalTranslateLayout.this.JO && i2 <= VerticalTranslateLayout.this.JO - VerticalTranslateLayout.this.Nj) {
                            VerticalTranslateLayout.this.Nl -= i;
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
            this.Kv.computeCurrentVelocity(this.Kx);
            float yVelocity = this.Kv.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ky);
            } else {
                max = Math.max(yVelocity, this.Ky);
            }
            switch (VerticalTranslateLayout.this.No) {
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
            this.Kv.recycle();
            this.Kv = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Nl;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Nh - VerticalTranslateLayout.this.JO) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Nu.R(f);
                } else {
                    VerticalTranslateLayout.this.Nu.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.JO - VerticalTranslateLayout.this.Nj) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Nu.Q(f);
                } else {
                    VerticalTranslateLayout.this.Nu.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Nu.R(f);
            } else {
                VerticalTranslateLayout.this.Nu.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Nu.Q(f);
            } else {
                VerticalTranslateLayout.this.Nu.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Kn;
        float Ko;
        float Kp;
        float Kq;
        float Kr;
        long Ks;
        long Kt;
        boolean Ku;

        b() {
            this.Kn = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ko = ((((float) (uptimeMillis - this.Ks)) / 1000.0f) * this.Kp) + this.Ko;
            this.Ks = uptimeMillis;
            this.Kt += 16;
        }

        void nK() {
            compute();
            if (this.Ko <= this.Kq) {
                e eVar = VerticalTranslateLayout.this.Nw;
                if (eVar != null) {
                    eVar.nP();
                }
                this.Ku = false;
                VerticalTranslateLayout.this.JW = 10000;
                VerticalTranslateLayout.this.mJ();
                return;
            }
            VerticalTranslateLayout.this.Nl = (int) (com.baidu.adp.widget.a.a(this.Kq, this.Ko, false) + this.Kr);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-100, this.Kt);
        }

        void nL() {
            compute();
            if (this.Ko >= this.Kq) {
                c cVar = VerticalTranslateLayout.this.Nx;
                if (cVar != null) {
                    cVar.nO();
                }
                this.Ku = false;
                VerticalTranslateLayout.this.JW = 10001;
                VerticalTranslateLayout.this.mJ();
                return;
            }
            VerticalTranslateLayout.this.Nl = (int) (com.baidu.adp.widget.a.a(this.Kq, this.Ko, false) + this.Kr);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-101, this.Kt);
        }

        void nM() {
            compute();
            if (this.Ko >= this.Kq) {
                for (d dVar : VerticalTranslateLayout.this.Kj) {
                    if (dVar != null) {
                        dVar.mR();
                    }
                }
                this.Ku = false;
                VerticalTranslateLayout.this.JW = ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE;
                VerticalTranslateLayout.this.mJ();
                return;
            }
            VerticalTranslateLayout.this.Nl = (int) (com.baidu.adp.widget.a.a(this.Kq, this.Ko, false) + this.Kr);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Nt.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Kt);
        }

        void nN() {
            compute();
            if (this.Ko <= this.Kq) {
                for (d dVar : VerticalTranslateLayout.this.Kj) {
                    if (dVar != null) {
                        dVar.mR();
                    }
                }
                this.Ku = false;
                VerticalTranslateLayout.this.JW = ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE;
                VerticalTranslateLayout.this.mJ();
                return;
            }
            VerticalTranslateLayout.this.Nl = (int) (com.baidu.adp.widget.a.a(this.Kq, this.Ko, false) + this.Kr);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-105, this.Kt);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Kj) {
                if (dVar != null) {
                    dVar.mQ();
                }
            }
            this.Ku = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ks = uptimeMillis;
            this.Kt = uptimeMillis + 16;
            this.Kp = f;
            this.Ko = 0.0f;
            this.Kq = 0 - VerticalTranslateLayout.this.Nl;
            this.Kr = VerticalTranslateLayout.this.Nl;
            VerticalTranslateLayout.this.Nt.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Kq);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Nt.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Kt);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Kj) {
                if (dVar != null) {
                    dVar.mQ();
                }
            }
            this.Ku = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ks = uptimeMillis;
            this.Kt = uptimeMillis + 16;
            this.Kp = f;
            this.Ko = 0.0f;
            this.Kq = 0 - VerticalTranslateLayout.this.Nl;
            this.Kr = VerticalTranslateLayout.this.Nl;
            BdLog.d("Animator@animateBottomOpen " + this.Kq);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Nt.removeMessages(-105);
            VerticalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-105, this.Kt);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.Nw;
            if (eVar != null) {
                eVar.mO();
            }
            this.Ku = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ks = uptimeMillis;
            this.Kt = uptimeMillis + 16;
            this.Kp = f;
            this.Ko = 0.0f;
            this.Kq = ((-VerticalTranslateLayout.this.JO) + VerticalTranslateLayout.this.Nh) - VerticalTranslateLayout.this.Nl;
            this.Kr = VerticalTranslateLayout.this.Nl;
            BdLog.d("Animator@animateTop " + this.Kq);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Nt.removeMessages(-100);
            VerticalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-100, this.Kt);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.Nx;
            if (cVar != null) {
                cVar.mS();
            }
            this.Ku = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ks = uptimeMillis;
            this.Kt = uptimeMillis + 16;
            this.Kp = f;
            this.Ko = 0.0f;
            this.Kq = (VerticalTranslateLayout.this.JO - VerticalTranslateLayout.this.Nj) - VerticalTranslateLayout.this.Nl;
            this.Kr = VerticalTranslateLayout.this.Nl;
            BdLog.d("Animator@animateBottom " + this.Kq);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Nt.removeMessages(-101);
            VerticalTranslateLayout.this.Nt.sendEmptyMessageAtTime(-101, this.Kt);
        }
    }
}
