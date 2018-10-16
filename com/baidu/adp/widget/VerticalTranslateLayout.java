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
    private int MD;
    private int ME;
    private final int MI;
    private int MN;
    private final Paint MQ;
    private int MR;
    private int MS;
    private final List<d> Na;
    private float Qb;
    private float Qc;
    private float Qd;
    private float Qe;
    private int Qf;
    private boolean Qg;
    private boolean Qh;
    private TrackDirection Qi;
    private final Rect Qj;
    private final Rect Qk;
    private int Ql;
    private boolean Qm;
    private final a Qn;
    private final b Qo;
    private final g Qp;
    private e Qq;
    private c Qr;
    private f Qs;

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
        void ol();

        void pc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void oj();

        void ok();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void oh();

        void pd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void ba(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Qj = new Rect();
        this.Qk = new Rect();
        this.Na = new ArrayList();
        this.Qn = new a();
        this.Qo = new b();
        this.Qp = new g();
        this.MN = 10004;
        Resources resources = getResources();
        this.MQ = new Paint();
        this.MQ.setColor(-1);
        this.MI = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Qb = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Qd = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Qc = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Qe = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (oW() && oX() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Qi = TrackDirection.vertical;
            } else if (oX() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Qi = TrackDirection.bottom;
            } else if (oW() && AiAppsNaViewModel.POSITION_KEY_TOP.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Qi = TrackDirection.top;
            } else {
                this.Qi = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if (AiAppsNaViewModel.POSITION_KEY_TOP.equals(str) && this.Qb != -1.0f) {
                    this.Qg = true;
                } else if ("bottom".equals(str) && this.Qd != -1.0f) {
                    this.Qh = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.MQ.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.MQ.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Qf = (int) ((this.Qb - this.ME) * (-f2));
            } else if (f2 > 0.0f) {
                this.Qf = (int) ((this.ME - this.Qd) * f2);
            } else if (f2 == 0.0f) {
                this.Qf = 0;
                this.MN = 10004;
            } else if (f2 == -1.0f) {
                this.Qb -= this.ME;
                this.MN = 10000;
            } else if (f2 == 1.0f) {
                this.Qb = this.ME - this.Qd;
                this.MN = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Qb;
    }

    public int getBottomOffset() {
        return (int) this.Qd;
    }

    public void setTopTapBack(boolean z) {
        this.Qg = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Qh = z;
    }

    public int getState() {
        return this.MN;
    }

    public void setTopAnimationListener(e eVar) {
        this.Qq = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Qr = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Qs = fVar;
    }

    private boolean oW() {
        return (this.Qb == -1.0f && this.Qe == -1.0f) ? false : true;
    }

    private boolean oX() {
        return (this.Qd == -1.0f && this.Qc == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Qf);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Qf);
        canvas.drawRect(0.0f, 0.0f, this.MD, this.ME, this.MQ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Qf;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Qi == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.MN == 10004) {
            switch (action) {
                case 0:
                    this.MR = x;
                    this.MS = y;
                    this.Qn.removeMessages(-100);
                    this.Qn.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Qn.removeMessages(-101);
                    this.Qn.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Qf);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.MR - this.MI && i <= this.MR + this.MI && (i2 < this.MS - this.MI || i2 > this.MS + this.MI) && this.Qp.aL(i2 - this.MS);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.MN == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Qm = false;
                    if (this.Qp.Nn) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Qp.on();
                        this.Qp.oo();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Qp.Nn) {
                        if (!this.Qm) {
                            if (y > this.MS) {
                                this.Ql = this.MS + this.MI;
                                this.Qm = true;
                            } else {
                                this.Ql = this.MS - this.MI;
                                this.Qm = true;
                            }
                        }
                        this.Qp.aM(this.Ql - y);
                        this.Ql = y;
                        this.Qp.Nm.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.MN != 10000 || !this.Qj.contains(x, y)) && (this.MN != 10001 || !this.Qk.contains(x, y))) {
                    return false;
                }
                if (!this.Qp.Nn) {
                    this.Ql = y;
                    this.Qp.aL(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Qp.Nn) {
                    this.Qp.on();
                    this.Qp.oo();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Qp.Nn) {
            this.Qp.aM(this.Ql - y);
            this.Ql = y;
            this.Qp.Nm.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Qb != -1.0f) {
                this.Qj.set(i, i2, i3, (int) (i2 + this.Qb));
            }
            if (this.Qd != -1.0f) {
                this.Qk.set(i, (int) (i4 - this.Qd), i3, i4);
            }
        }
        if (!this.Qo.Nl && !this.Qp.Nn) {
            ob();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Qc != -1.0f) {
            this.Qb = i3 - this.Qe;
        }
        if (this.Qe != -1.0f) {
            this.Qd = i3 - this.Qc;
        }
        if (!$assertionsDisabled && i3 < this.Qb) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Qd) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.MD = getMeasuredWidth();
        this.ME = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob() {
        switch (this.MN) {
            case 10000:
                this.Qf = (int) (this.Qb - this.ME);
                invalidate();
                return;
            case 10001:
                this.Qf = (int) (this.ME - this.Qd);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Qf = 0;
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
            if (VerticalTranslateLayout.this.Qo.Nl) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Qo.pb();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Qo.pa();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Qo.oZ();
                        return;
                    case -100:
                        VerticalTranslateLayout.this.Qo.oY();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Nm;
        boolean Nn;
        final int No;
        final int Np;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.No = (int) ((200.0f * f) + 0.5f);
            this.Np = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aL(int i) {
            switch (VerticalTranslateLayout.this.Qi) {
                case top:
                    if (VerticalTranslateLayout.this.MN != 10004 && VerticalTranslateLayout.this.MN != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.MN != 10004 && VerticalTranslateLayout.this.MN != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Qs != null) {
                        VerticalTranslateLayout.this.Qs.ba(i);
                        break;
                    }
                    break;
            }
            this.Nm = VelocityTracker.obtain();
            this.Nn = true;
            return true;
        }

        void on() {
            this.Nn = false;
        }

        void aM(int i) {
            if (this.Nn) {
                int i2 = VerticalTranslateLayout.this.Qf - i;
                switch (VerticalTranslateLayout.this.Qi) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Qb - VerticalTranslateLayout.this.ME && i2 < 0) {
                            VerticalTranslateLayout.this.Qf -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.ME - VerticalTranslateLayout.this.Qd && i2 > 0) {
                            VerticalTranslateLayout.this.Qf -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Qb - VerticalTranslateLayout.this.ME && i2 <= VerticalTranslateLayout.this.ME - VerticalTranslateLayout.this.Qd) {
                            VerticalTranslateLayout.this.Qf -= i;
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
        public void oo() {
            float max;
            this.Nm.computeCurrentVelocity(this.No);
            float yVelocity = this.Nm.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Np);
            } else {
                max = Math.max(yVelocity, this.Np);
            }
            switch (VerticalTranslateLayout.this.Qi) {
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
            this.Nm.recycle();
            this.Nm = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Qf;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Qb - VerticalTranslateLayout.this.ME) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Qo.R(f);
                } else {
                    VerticalTranslateLayout.this.Qo.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.ME - VerticalTranslateLayout.this.Qd) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Qo.Q(f);
                } else {
                    VerticalTranslateLayout.this.Qo.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Qo.R(f);
            } else {
                VerticalTranslateLayout.this.Qo.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Qo.Q(f);
            } else {
                VerticalTranslateLayout.this.Qo.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Ne;
        float Nf;
        float Ng;
        float Nh;
        float Ni;
        long Nj;
        long Nk;
        boolean Nl;

        b() {
            this.Ne = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nf = ((((float) (uptimeMillis - this.Nj)) / 1000.0f) * this.Ng) + this.Nf;
            this.Nj = uptimeMillis;
            this.Nk += 16;
        }

        void oY() {
            compute();
            if (this.Nf <= this.Nh) {
                e eVar = VerticalTranslateLayout.this.Qq;
                if (eVar != null) {
                    eVar.pd();
                }
                this.Nl = false;
                VerticalTranslateLayout.this.MN = 10000;
                VerticalTranslateLayout.this.ob();
                return;
            }
            VerticalTranslateLayout.this.Qf = (int) (com.baidu.adp.widget.a.a(this.Nh, this.Nf, false) + this.Ni);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qn.sendEmptyMessageAtTime(-100, this.Nk);
        }

        void oZ() {
            compute();
            if (this.Nf >= this.Nh) {
                c cVar = VerticalTranslateLayout.this.Qr;
                if (cVar != null) {
                    cVar.pc();
                }
                this.Nl = false;
                VerticalTranslateLayout.this.MN = 10001;
                VerticalTranslateLayout.this.ob();
                return;
            }
            VerticalTranslateLayout.this.Qf = (int) (com.baidu.adp.widget.a.a(this.Nh, this.Nf, false) + this.Ni);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qn.sendEmptyMessageAtTime(-101, this.Nk);
        }

        void pa() {
            compute();
            if (this.Nf >= this.Nh) {
                for (d dVar : VerticalTranslateLayout.this.Na) {
                    if (dVar != null) {
                        dVar.ok();
                    }
                }
                this.Nl = false;
                VerticalTranslateLayout.this.MN = 10004;
                VerticalTranslateLayout.this.ob();
                return;
            }
            VerticalTranslateLayout.this.Qf = (int) (com.baidu.adp.widget.a.a(this.Nh, this.Nf, false) + this.Ni);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qn.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nk);
        }

        void pb() {
            compute();
            if (this.Nf <= this.Nh) {
                for (d dVar : VerticalTranslateLayout.this.Na) {
                    if (dVar != null) {
                        dVar.ok();
                    }
                }
                this.Nl = false;
                VerticalTranslateLayout.this.MN = 10004;
                VerticalTranslateLayout.this.ob();
                return;
            }
            VerticalTranslateLayout.this.Qf = (int) (com.baidu.adp.widget.a.a(this.Nh, this.Nf, false) + this.Ni);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qn.sendEmptyMessageAtTime(-105, this.Nk);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Na) {
                if (dVar != null) {
                    dVar.oj();
                }
            }
            this.Nl = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nj = uptimeMillis;
            this.Nk = uptimeMillis + 16;
            this.Ng = f;
            this.Nf = 0.0f;
            this.Nh = 0 - VerticalTranslateLayout.this.Qf;
            this.Ni = VerticalTranslateLayout.this.Qf;
            VerticalTranslateLayout.this.Qn.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Nh);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Qn.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nk);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Na) {
                if (dVar != null) {
                    dVar.oj();
                }
            }
            this.Nl = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nj = uptimeMillis;
            this.Nk = uptimeMillis + 16;
            this.Ng = f;
            this.Nf = 0.0f;
            this.Nh = 0 - VerticalTranslateLayout.this.Qf;
            this.Ni = VerticalTranslateLayout.this.Qf;
            BdLog.d("Animator@animateBottomOpen " + this.Nh);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Qn.removeMessages(-105);
            VerticalTranslateLayout.this.Qn.sendEmptyMessageAtTime(-105, this.Nk);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.Qq;
            if (eVar != null) {
                eVar.oh();
            }
            this.Nl = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nj = uptimeMillis;
            this.Nk = uptimeMillis + 16;
            this.Ng = f;
            this.Nf = 0.0f;
            this.Nh = ((-VerticalTranslateLayout.this.ME) + VerticalTranslateLayout.this.Qb) - VerticalTranslateLayout.this.Qf;
            this.Ni = VerticalTranslateLayout.this.Qf;
            BdLog.d("Animator@animateTop " + this.Nh);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Qn.removeMessages(-100);
            VerticalTranslateLayout.this.Qn.sendEmptyMessageAtTime(-100, this.Nk);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.Qr;
            if (cVar != null) {
                cVar.ol();
            }
            this.Nl = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nj = uptimeMillis;
            this.Nk = uptimeMillis + 16;
            this.Ng = f;
            this.Nf = 0.0f;
            this.Nh = (VerticalTranslateLayout.this.ME - VerticalTranslateLayout.this.Qd) - VerticalTranslateLayout.this.Qf;
            this.Ni = VerticalTranslateLayout.this.Qf;
            BdLog.d("Animator@animateBottom " + this.Nh);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Qn.removeMessages(-101);
            VerticalTranslateLayout.this.Qn.sendEmptyMessageAtTime(-101, this.Nk);
        }
    }
}
