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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int KM;
    private int KN;
    private final int KR;
    private int KV;
    private final Paint KY;
    private int KZ;
    private int La;
    private final List<d> Li;
    private float OZ;
    private float Pa;
    private float Pb;
    private float Pc;
    private int Pd;
    private boolean Pe;
    private boolean Pf;
    private TrackDirection Pg;
    private final Rect Ph;
    private final Rect Pi;
    private int Pj;
    private boolean Pk;
    private final a Pl;
    private final b Pm;
    private final g Pn;
    private e Po;
    private c Pp;
    private f Pq;

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
        void nl();

        void or();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void nj();

        void nk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void nh();

        void os();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aU(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Ph = new Rect();
        this.Pi = new Rect();
        this.Li = new ArrayList();
        this.Pl = new a();
        this.Pm = new b();
        this.Pn = new g();
        this.KV = 10004;
        Resources resources = getResources();
        this.KY = new Paint();
        this.KY.setColor(-1);
        this.KR = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.OZ = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Pb = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Pa = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Pc = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (ol() && om() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Pg = TrackDirection.vertical;
            } else if (om() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Pg = TrackDirection.bottom;
            } else if (ol() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Pg = TrackDirection.top;
            } else {
                this.Pg = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.OZ != -1.0f) {
                    this.Pe = true;
                } else if ("bottom".equals(str) && this.Pb != -1.0f) {
                    this.Pf = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.KY.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.KY.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Pd = (int) ((this.OZ - this.KN) * (-f2));
            } else if (f2 > 0.0f) {
                this.Pd = (int) ((this.KN - this.Pb) * f2);
            } else if (f2 == 0.0f) {
                this.Pd = 0;
                this.KV = 10004;
            } else if (f2 == -1.0f) {
                this.OZ -= this.KN;
                this.KV = 10000;
            } else if (f2 == 1.0f) {
                this.OZ = this.KN - this.Pb;
                this.KV = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.OZ;
    }

    public int getBottomOffset() {
        return (int) this.Pb;
    }

    public void setTopTapBack(boolean z) {
        this.Pe = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Pf = z;
    }

    public int getState() {
        return this.KV;
    }

    public void setTopAnimationListener(e eVar) {
        this.Po = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Pp = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Pq = fVar;
    }

    private boolean ol() {
        return (this.OZ == -1.0f && this.Pc == -1.0f) ? false : true;
    }

    private boolean om() {
        return (this.Pb == -1.0f && this.Pa == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Pd);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Pd);
        canvas.drawRect(0.0f, 0.0f, this.KM, this.KN, this.KY);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Pd;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Pg == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.KV == 10004) {
            switch (action) {
                case 0:
                    this.KZ = x;
                    this.La = y;
                    this.Pl.removeMessages(-100);
                    this.Pl.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Pl.removeMessages(-101);
                    this.Pl.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Pd);
                    return o(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i >= this.KZ - this.KR && i <= this.KZ + this.KR && (i2 < this.La - this.KR || i2 > this.La + this.KR) && this.Pn.aE(i2 - this.La);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.KV == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Pk = false;
                    if (this.Pn.Lv) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Pn.nn();
                        this.Pn.no();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Pn.Lv) {
                        if (!this.Pk) {
                            if (y > this.La) {
                                this.Pj = this.La + this.KR;
                                this.Pk = true;
                            } else {
                                this.Pj = this.La - this.KR;
                                this.Pk = true;
                            }
                        }
                        this.Pn.aF(this.Pj - y);
                        this.Pj = y;
                        this.Pn.Lu.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.KV != 10000 || !this.Ph.contains(x, y)) && (this.KV != 10001 || !this.Pi.contains(x, y))) {
                    return false;
                }
                if (!this.Pn.Lv) {
                    this.Pj = y;
                    this.Pn.aE(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Pn.Lv) {
                    this.Pn.nn();
                    this.Pn.no();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Pn.Lv) {
            this.Pn.aF(this.Pj - y);
            this.Pj = y;
            this.Pn.Lu.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.OZ != -1.0f) {
                this.Ph.set(i, i2, i3, (int) (i2 + this.OZ));
            }
            if (this.Pb != -1.0f) {
                this.Pi.set(i, (int) (i4 - this.Pb), i3, i4);
            }
        }
        if (!this.Pm.Lt && !this.Pn.Lv) {
            nc();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Pa != -1.0f) {
            this.OZ = i3 - this.Pc;
        }
        if (this.Pc != -1.0f) {
            this.Pb = i3 - this.Pa;
        }
        if (!$assertionsDisabled && i3 < this.OZ) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Pb) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.KM = getMeasuredWidth();
        this.KN = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc() {
        switch (this.KV) {
            case 10000:
                this.Pd = (int) (this.OZ - this.KN);
                invalidate();
                return;
            case 10001:
                this.Pd = (int) (this.KN - this.Pb);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Pd = 0;
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
            if (VerticalTranslateLayout.this.Pm.Lt) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Pm.oq();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Pm.op();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Pm.oo();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.Pm.on();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Lu;
        boolean Lv;
        final int Lw;
        final int Lx;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Lw = (int) ((200.0f * f) + 0.5f);
            this.Lx = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aE(int i) {
            switch (VerticalTranslateLayout.this.Pg) {
                case top:
                    if (VerticalTranslateLayout.this.KV != 10004 && VerticalTranslateLayout.this.KV != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.KV != 10004 && VerticalTranslateLayout.this.KV != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Pq != null) {
                        VerticalTranslateLayout.this.Pq.aU(i);
                        break;
                    }
                    break;
            }
            this.Lu = VelocityTracker.obtain();
            this.Lv = true;
            return true;
        }

        void nn() {
            this.Lv = false;
        }

        void aF(int i) {
            if (this.Lv) {
                int i2 = VerticalTranslateLayout.this.Pd - i;
                switch (VerticalTranslateLayout.this.Pg) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.OZ - VerticalTranslateLayout.this.KN && i2 < 0) {
                            VerticalTranslateLayout.this.Pd -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.KN - VerticalTranslateLayout.this.Pb && i2 > 0) {
                            VerticalTranslateLayout.this.Pd -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.OZ - VerticalTranslateLayout.this.KN && i2 <= VerticalTranslateLayout.this.KN - VerticalTranslateLayout.this.Pb) {
                            VerticalTranslateLayout.this.Pd -= i;
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
        public void no() {
            float max;
            this.Lu.computeCurrentVelocity(this.Lw);
            float yVelocity = this.Lu.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Lx);
            } else {
                max = Math.max(yVelocity, this.Lx);
            }
            switch (VerticalTranslateLayout.this.Pg) {
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
            this.Lu.recycle();
            this.Lu = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Pd;
            if (i <= 0 && i >= VerticalTranslateLayout.this.OZ - VerticalTranslateLayout.this.KN) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Pm.R(f);
                } else {
                    VerticalTranslateLayout.this.Pm.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.KN - VerticalTranslateLayout.this.Pb) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Pm.Q(f);
                } else {
                    VerticalTranslateLayout.this.Pm.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Pm.R(f);
            } else {
                VerticalTranslateLayout.this.Pm.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Pm.Q(f);
            } else {
                VerticalTranslateLayout.this.Pm.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Lm;
        float Ln;
        float Lo;
        float Lp;
        float Lq;
        long Lr;
        long Ls;
        boolean Lt;

        b() {
            this.Lm = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ln = ((((float) (uptimeMillis - this.Lr)) / 1000.0f) * this.Lo) + this.Ln;
            this.Lr = uptimeMillis;
            this.Ls += 16;
        }

        void on() {
            compute();
            if (this.Ln <= this.Lp) {
                e eVar = VerticalTranslateLayout.this.Po;
                if (eVar != null) {
                    eVar.os();
                }
                this.Lt = false;
                VerticalTranslateLayout.this.KV = 10000;
                VerticalTranslateLayout.this.nc();
                return;
            }
            VerticalTranslateLayout.this.Pd = (int) (com.baidu.adp.widget.a.a(this.Lp, this.Ln, false) + this.Lq);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Pl.sendEmptyMessageAtTime(-100, this.Ls);
        }

        void oo() {
            compute();
            if (this.Ln >= this.Lp) {
                c cVar = VerticalTranslateLayout.this.Pp;
                if (cVar != null) {
                    cVar.or();
                }
                this.Lt = false;
                VerticalTranslateLayout.this.KV = 10001;
                VerticalTranslateLayout.this.nc();
                return;
            }
            VerticalTranslateLayout.this.Pd = (int) (com.baidu.adp.widget.a.a(this.Lp, this.Ln, false) + this.Lq);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Pl.sendEmptyMessageAtTime(-101, this.Ls);
        }

        void op() {
            compute();
            if (this.Ln >= this.Lp) {
                for (d dVar : VerticalTranslateLayout.this.Li) {
                    if (dVar != null) {
                        dVar.nk();
                    }
                }
                this.Lt = false;
                VerticalTranslateLayout.this.KV = 10004;
                VerticalTranslateLayout.this.nc();
                return;
            }
            VerticalTranslateLayout.this.Pd = (int) (com.baidu.adp.widget.a.a(this.Lp, this.Ln, false) + this.Lq);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Pl.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ls);
        }

        void oq() {
            compute();
            if (this.Ln <= this.Lp) {
                for (d dVar : VerticalTranslateLayout.this.Li) {
                    if (dVar != null) {
                        dVar.nk();
                    }
                }
                this.Lt = false;
                VerticalTranslateLayout.this.KV = 10004;
                VerticalTranslateLayout.this.nc();
                return;
            }
            VerticalTranslateLayout.this.Pd = (int) (com.baidu.adp.widget.a.a(this.Lp, this.Ln, false) + this.Lq);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Pl.sendEmptyMessageAtTime(-105, this.Ls);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Li) {
                if (dVar != null) {
                    dVar.nj();
                }
            }
            this.Lt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lr = uptimeMillis;
            this.Ls = uptimeMillis + 16;
            this.Lo = f;
            this.Ln = 0.0f;
            this.Lp = 0 - VerticalTranslateLayout.this.Pd;
            this.Lq = VerticalTranslateLayout.this.Pd;
            VerticalTranslateLayout.this.Pl.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Lp);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Pl.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ls);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Li) {
                if (dVar != null) {
                    dVar.nj();
                }
            }
            this.Lt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lr = uptimeMillis;
            this.Ls = uptimeMillis + 16;
            this.Lo = f;
            this.Ln = 0.0f;
            this.Lp = 0 - VerticalTranslateLayout.this.Pd;
            this.Lq = VerticalTranslateLayout.this.Pd;
            BdLog.d("Animator@animateBottomOpen " + this.Lp);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Pl.removeMessages(-105);
            VerticalTranslateLayout.this.Pl.sendEmptyMessageAtTime(-105, this.Ls);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.Po;
            if (eVar != null) {
                eVar.nh();
            }
            this.Lt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lr = uptimeMillis;
            this.Ls = uptimeMillis + 16;
            this.Lo = f;
            this.Ln = 0.0f;
            this.Lp = ((-VerticalTranslateLayout.this.KN) + VerticalTranslateLayout.this.OZ) - VerticalTranslateLayout.this.Pd;
            this.Lq = VerticalTranslateLayout.this.Pd;
            BdLog.d("Animator@animateTop " + this.Lp);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Pl.removeMessages(-100);
            VerticalTranslateLayout.this.Pl.sendEmptyMessageAtTime(-100, this.Ls);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.Pp;
            if (cVar != null) {
                cVar.nl();
            }
            this.Lt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lr = uptimeMillis;
            this.Ls = uptimeMillis + 16;
            this.Lo = f;
            this.Ln = 0.0f;
            this.Lp = (VerticalTranslateLayout.this.KN - VerticalTranslateLayout.this.Pb) - VerticalTranslateLayout.this.Pd;
            this.Lq = VerticalTranslateLayout.this.Pd;
            BdLog.d("Animator@animateBottom " + this.Lp);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Pl.removeMessages(-101);
            VerticalTranslateLayout.this.Pl.sendEmptyMessageAtTime(-101, this.Ls);
        }
    }
}
