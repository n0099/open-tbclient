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
    private int MQ;
    private int MR;
    private final int MV;
    private int MZ;
    private final Paint Nc;
    private int Nd;
    private int Ne;
    private final List<d> Nm;
    private final g QA;
    private e QB;
    private c QC;
    private f QD;
    private float Qm;
    private float Qn;
    private float Qo;
    private float Qp;
    private int Qq;
    private boolean Qr;
    private boolean Qs;
    private TrackDirection Qt;
    private final Rect Qu;
    private final Rect Qv;
    private int Qw;
    private boolean Qx;
    private final a Qy;
    private final b Qz;

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
        void om();

        void pd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void ok();

        void ol();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void oi();

        void pe();
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
        this.Qu = new Rect();
        this.Qv = new Rect();
        this.Nm = new ArrayList();
        this.Qy = new a();
        this.Qz = new b();
        this.QA = new g();
        this.MZ = 10004;
        Resources resources = getResources();
        this.Nc = new Paint();
        this.Nc.setColor(-1);
        this.MV = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Qm = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Qo = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Qn = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Qp = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (oX() && oY() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Qt = TrackDirection.vertical;
            } else if (oY() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Qt = TrackDirection.bottom;
            } else if (oX() && AiAppsNaViewModel.POSITION_KEY_TOP.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Qt = TrackDirection.top;
            } else {
                this.Qt = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if (AiAppsNaViewModel.POSITION_KEY_TOP.equals(str) && this.Qm != -1.0f) {
                    this.Qr = true;
                } else if ("bottom".equals(str) && this.Qo != -1.0f) {
                    this.Qs = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Nc.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
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
                this.Qq = (int) ((this.Qm - this.MR) * (-f2));
            } else if (f2 > 0.0f) {
                this.Qq = (int) ((this.MR - this.Qo) * f2);
            } else if (f2 == 0.0f) {
                this.Qq = 0;
                this.MZ = 10004;
            } else if (f2 == -1.0f) {
                this.Qm -= this.MR;
                this.MZ = 10000;
            } else if (f2 == 1.0f) {
                this.Qm = this.MR - this.Qo;
                this.MZ = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Qm;
    }

    public int getBottomOffset() {
        return (int) this.Qo;
    }

    public void setTopTapBack(boolean z) {
        this.Qr = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Qs = z;
    }

    public int getState() {
        return this.MZ;
    }

    public void setTopAnimationListener(e eVar) {
        this.QB = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.QC = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.QD = fVar;
    }

    private boolean oX() {
        return (this.Qm == -1.0f && this.Qp == -1.0f) ? false : true;
    }

    private boolean oY() {
        return (this.Qo == -1.0f && this.Qn == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Qq);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Qq);
        canvas.drawRect(0.0f, 0.0f, this.MQ, this.MR, this.Nc);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Qq;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Qt == TrackDirection.none) {
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
                    this.Qy.removeMessages(-100);
                    this.Qy.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Qy.removeMessages(-101);
                    this.Qy.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Qq);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Nd - this.MV && i <= this.Nd + this.MV && (i2 < this.Ne - this.MV || i2 > this.Ne + this.MV) && this.QA.bc(i2 - this.Ne);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Qx = false;
                    if (this.QA.Nz) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.QA.oo();
                        this.QA.op();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.QA.Nz) {
                        if (!this.Qx) {
                            if (y > this.Ne) {
                                this.Qw = this.Ne + this.MV;
                                this.Qx = true;
                            } else {
                                this.Qw = this.Ne - this.MV;
                                this.Qx = true;
                            }
                        }
                        this.QA.bd(this.Qw - y);
                        this.Qw = y;
                        this.QA.Ny.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.MZ != 10000 || !this.Qu.contains(x, y)) && (this.MZ != 10001 || !this.Qv.contains(x, y))) {
                    return false;
                }
                if (!this.QA.Nz) {
                    this.Qw = y;
                    this.QA.bc(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.QA.Nz) {
                    this.QA.oo();
                    this.QA.op();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.QA.Nz) {
            this.QA.bd(this.Qw - y);
            this.Qw = y;
            this.QA.Ny.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Qm != -1.0f) {
                this.Qu.set(i, i2, i3, (int) (i2 + this.Qm));
            }
            if (this.Qo != -1.0f) {
                this.Qv.set(i, (int) (i4 - this.Qo), i3, i4);
            }
        }
        if (!this.Qz.Nx && !this.QA.Nz) {
            oc();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Qn != -1.0f) {
            this.Qm = i3 - this.Qp;
        }
        if (this.Qp != -1.0f) {
            this.Qo = i3 - this.Qn;
        }
        if (!$assertionsDisabled && i3 < this.Qm) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Qo) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.MQ = getMeasuredWidth();
        this.MR = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc() {
        switch (this.MZ) {
            case 10000:
                this.Qq = (int) (this.Qm - this.MR);
                invalidate();
                return;
            case 10001:
                this.Qq = (int) (this.MR - this.Qo);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Qq = 0;
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
            if (VerticalTranslateLayout.this.Qz.Nx) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Qz.pc();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Qz.pb();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Qz.pa();
                        return;
                    case -100:
                        VerticalTranslateLayout.this.Qz.oZ();
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
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.NB = (int) ((200.0f * f) + 0.5f);
            this.NC = (int) ((f * 500.0f) + 0.5f);
        }

        boolean bc(int i) {
            switch (VerticalTranslateLayout.this.Qt) {
                case top:
                    if (VerticalTranslateLayout.this.MZ != 10004 && VerticalTranslateLayout.this.MZ != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.MZ != 10004 && VerticalTranslateLayout.this.MZ != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.QD != null) {
                        VerticalTranslateLayout.this.QD.bp(i);
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
                int i2 = VerticalTranslateLayout.this.Qq - i;
                switch (VerticalTranslateLayout.this.Qt) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Qm - VerticalTranslateLayout.this.MR && i2 < 0) {
                            VerticalTranslateLayout.this.Qq -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.MR - VerticalTranslateLayout.this.Qo && i2 > 0) {
                            VerticalTranslateLayout.this.Qq -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Qm - VerticalTranslateLayout.this.MR && i2 <= VerticalTranslateLayout.this.MR - VerticalTranslateLayout.this.Qo) {
                            VerticalTranslateLayout.this.Qq -= i;
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
        public void op() {
            float max;
            this.Ny.computeCurrentVelocity(this.NB);
            float yVelocity = this.Ny.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.NC);
            } else {
                max = Math.max(yVelocity, this.NC);
            }
            switch (VerticalTranslateLayout.this.Qt) {
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
            this.Ny.recycle();
            this.Ny = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Qq;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Qm - VerticalTranslateLayout.this.MR) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Qz.R(f);
                } else {
                    VerticalTranslateLayout.this.Qz.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.MR - VerticalTranslateLayout.this.Qo) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Qz.Q(f);
                } else {
                    VerticalTranslateLayout.this.Qz.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Qz.R(f);
            } else {
                VerticalTranslateLayout.this.Qz.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Qz.Q(f);
            } else {
                VerticalTranslateLayout.this.Qz.S(f);
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
            this.Nq = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nr = ((((float) (uptimeMillis - this.Nv)) / 1000.0f) * this.Ns) + this.Nr;
            this.Nv = uptimeMillis;
            this.Nw += 16;
        }

        void oZ() {
            compute();
            if (this.Nr <= this.Nt) {
                e eVar = VerticalTranslateLayout.this.QB;
                if (eVar != null) {
                    eVar.pe();
                }
                this.Nx = false;
                VerticalTranslateLayout.this.MZ = 10000;
                VerticalTranslateLayout.this.oc();
                return;
            }
            VerticalTranslateLayout.this.Qq = (int) (com.baidu.adp.widget.a.a(this.Nt, this.Nr, false) + this.Nu);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qy.sendEmptyMessageAtTime(-100, this.Nw);
        }

        void pa() {
            compute();
            if (this.Nr >= this.Nt) {
                c cVar = VerticalTranslateLayout.this.QC;
                if (cVar != null) {
                    cVar.pd();
                }
                this.Nx = false;
                VerticalTranslateLayout.this.MZ = 10001;
                VerticalTranslateLayout.this.oc();
                return;
            }
            VerticalTranslateLayout.this.Qq = (int) (com.baidu.adp.widget.a.a(this.Nt, this.Nr, false) + this.Nu);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qy.sendEmptyMessageAtTime(-101, this.Nw);
        }

        void pb() {
            compute();
            if (this.Nr >= this.Nt) {
                for (d dVar : VerticalTranslateLayout.this.Nm) {
                    if (dVar != null) {
                        dVar.ol();
                    }
                }
                this.Nx = false;
                VerticalTranslateLayout.this.MZ = 10004;
                VerticalTranslateLayout.this.oc();
                return;
            }
            VerticalTranslateLayout.this.Qq = (int) (com.baidu.adp.widget.a.a(this.Nt, this.Nr, false) + this.Nu);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qy.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nw);
        }

        void pc() {
            compute();
            if (this.Nr <= this.Nt) {
                for (d dVar : VerticalTranslateLayout.this.Nm) {
                    if (dVar != null) {
                        dVar.ol();
                    }
                }
                this.Nx = false;
                VerticalTranslateLayout.this.MZ = 10004;
                VerticalTranslateLayout.this.oc();
                return;
            }
            VerticalTranslateLayout.this.Qq = (int) (com.baidu.adp.widget.a.a(this.Nt, this.Nr, false) + this.Nu);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Qy.sendEmptyMessageAtTime(-105, this.Nw);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Nm) {
                if (dVar != null) {
                    dVar.ok();
                }
            }
            this.Nx = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nv = uptimeMillis;
            this.Nw = uptimeMillis + 16;
            this.Ns = f;
            this.Nr = 0.0f;
            this.Nt = 0 - VerticalTranslateLayout.this.Qq;
            this.Nu = VerticalTranslateLayout.this.Qq;
            VerticalTranslateLayout.this.Qy.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Nt);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Qy.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nw);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Nm) {
                if (dVar != null) {
                    dVar.ok();
                }
            }
            this.Nx = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nv = uptimeMillis;
            this.Nw = uptimeMillis + 16;
            this.Ns = f;
            this.Nr = 0.0f;
            this.Nt = 0 - VerticalTranslateLayout.this.Qq;
            this.Nu = VerticalTranslateLayout.this.Qq;
            BdLog.d("Animator@animateBottomOpen " + this.Nt);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Qy.removeMessages(-105);
            VerticalTranslateLayout.this.Qy.sendEmptyMessageAtTime(-105, this.Nw);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.QB;
            if (eVar != null) {
                eVar.oi();
            }
            this.Nx = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nv = uptimeMillis;
            this.Nw = uptimeMillis + 16;
            this.Ns = f;
            this.Nr = 0.0f;
            this.Nt = ((-VerticalTranslateLayout.this.MR) + VerticalTranslateLayout.this.Qm) - VerticalTranslateLayout.this.Qq;
            this.Nu = VerticalTranslateLayout.this.Qq;
            BdLog.d("Animator@animateTop " + this.Nt);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Qy.removeMessages(-100);
            VerticalTranslateLayout.this.Qy.sendEmptyMessageAtTime(-100, this.Nw);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.QC;
            if (cVar != null) {
                cVar.om();
            }
            this.Nx = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nv = uptimeMillis;
            this.Nw = uptimeMillis + 16;
            this.Ns = f;
            this.Nr = 0.0f;
            this.Nt = (VerticalTranslateLayout.this.MR - VerticalTranslateLayout.this.Qo) - VerticalTranslateLayout.this.Qq;
            this.Nu = VerticalTranslateLayout.this.Qq;
            BdLog.d("Animator@animateBottom " + this.Nt);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Qy.removeMessages(-101);
            VerticalTranslateLayout.this.Qy.sendEmptyMessageAtTime(-101, this.Nw);
        }
    }
}
