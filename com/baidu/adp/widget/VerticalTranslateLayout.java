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
    private int KL;
    private int KM;
    private final int KQ;
    private int KU;
    private final Paint KX;
    private int KY;
    private int KZ;
    private final List<d> Lh;
    private float OY;
    private float OZ;
    private float Pa;
    private float Pb;
    private int Pc;
    private boolean Pd;
    private boolean Pe;
    private TrackDirection Pf;
    private final Rect Pg;
    private final Rect Ph;
    private int Pi;
    private boolean Pj;
    private final a Pk;
    private final b Pl;
    private final g Pm;
    private e Pn;
    private c Po;
    private f Pp;

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
        this.Pg = new Rect();
        this.Ph = new Rect();
        this.Lh = new ArrayList();
        this.Pk = new a();
        this.Pl = new b();
        this.Pm = new g();
        this.KU = 10004;
        Resources resources = getResources();
        this.KX = new Paint();
        this.KX.setColor(-1);
        this.KQ = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.OY = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Pa = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.OZ = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Pb = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (ol() && om() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Pf = TrackDirection.vertical;
            } else if (om() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Pf = TrackDirection.bottom;
            } else if (ol() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Pf = TrackDirection.top;
            } else {
                this.Pf = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.OY != -1.0f) {
                    this.Pd = true;
                } else if ("bottom".equals(str) && this.Pa != -1.0f) {
                    this.Pe = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.KX.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.KX.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Pc = (int) ((this.OY - this.KM) * (-f2));
            } else if (f2 > 0.0f) {
                this.Pc = (int) ((this.KM - this.Pa) * f2);
            } else if (f2 == 0.0f) {
                this.Pc = 0;
                this.KU = 10004;
            } else if (f2 == -1.0f) {
                this.OY -= this.KM;
                this.KU = 10000;
            } else if (f2 == 1.0f) {
                this.OY = this.KM - this.Pa;
                this.KU = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.OY;
    }

    public int getBottomOffset() {
        return (int) this.Pa;
    }

    public void setTopTapBack(boolean z) {
        this.Pd = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Pe = z;
    }

    public int getState() {
        return this.KU;
    }

    public void setTopAnimationListener(e eVar) {
        this.Pn = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Po = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Pp = fVar;
    }

    private boolean ol() {
        return (this.OY == -1.0f && this.Pb == -1.0f) ? false : true;
    }

    private boolean om() {
        return (this.Pa == -1.0f && this.OZ == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Pc);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Pc);
        canvas.drawRect(0.0f, 0.0f, this.KL, this.KM, this.KX);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Pc;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Pf == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.KU == 10004) {
            switch (action) {
                case 0:
                    this.KY = x;
                    this.KZ = y;
                    this.Pk.removeMessages(-100);
                    this.Pk.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Pk.removeMessages(-101);
                    this.Pk.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Pc);
                    return o(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i >= this.KY - this.KQ && i <= this.KY + this.KQ && (i2 < this.KZ - this.KQ || i2 > this.KZ + this.KQ) && this.Pm.aE(i2 - this.KZ);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.KU == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Pj = false;
                    if (this.Pm.Lu) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Pm.nn();
                        this.Pm.no();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Pm.Lu) {
                        if (!this.Pj) {
                            if (y > this.KZ) {
                                this.Pi = this.KZ + this.KQ;
                                this.Pj = true;
                            } else {
                                this.Pi = this.KZ - this.KQ;
                                this.Pj = true;
                            }
                        }
                        this.Pm.aF(this.Pi - y);
                        this.Pi = y;
                        this.Pm.Lt.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.KU != 10000 || !this.Pg.contains(x, y)) && (this.KU != 10001 || !this.Ph.contains(x, y))) {
                    return false;
                }
                if (!this.Pm.Lu) {
                    this.Pi = y;
                    this.Pm.aE(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Pm.Lu) {
                    this.Pm.nn();
                    this.Pm.no();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Pm.Lu) {
            this.Pm.aF(this.Pi - y);
            this.Pi = y;
            this.Pm.Lt.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.OY != -1.0f) {
                this.Pg.set(i, i2, i3, (int) (i2 + this.OY));
            }
            if (this.Pa != -1.0f) {
                this.Ph.set(i, (int) (i4 - this.Pa), i3, i4);
            }
        }
        if (!this.Pl.Ls && !this.Pm.Lu) {
            nc();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.OZ != -1.0f) {
            this.OY = i3 - this.Pb;
        }
        if (this.Pb != -1.0f) {
            this.Pa = i3 - this.OZ;
        }
        if (!$assertionsDisabled && i3 < this.OY) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Pa) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.KL = getMeasuredWidth();
        this.KM = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc() {
        switch (this.KU) {
            case 10000:
                this.Pc = (int) (this.OY - this.KM);
                invalidate();
                return;
            case 10001:
                this.Pc = (int) (this.KM - this.Pa);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Pc = 0;
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
            if (VerticalTranslateLayout.this.Pl.Ls) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Pl.oq();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Pl.op();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Pl.oo();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.Pl.on();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Lt;
        boolean Lu;
        final int Lv;
        final int Lw;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Lv = (int) ((200.0f * f) + 0.5f);
            this.Lw = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aE(int i) {
            switch (VerticalTranslateLayout.this.Pf) {
                case top:
                    if (VerticalTranslateLayout.this.KU != 10004 && VerticalTranslateLayout.this.KU != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.KU != 10004 && VerticalTranslateLayout.this.KU != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Pp != null) {
                        VerticalTranslateLayout.this.Pp.aU(i);
                        break;
                    }
                    break;
            }
            this.Lt = VelocityTracker.obtain();
            this.Lu = true;
            return true;
        }

        void nn() {
            this.Lu = false;
        }

        void aF(int i) {
            if (this.Lu) {
                int i2 = VerticalTranslateLayout.this.Pc - i;
                switch (VerticalTranslateLayout.this.Pf) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.OY - VerticalTranslateLayout.this.KM && i2 < 0) {
                            VerticalTranslateLayout.this.Pc -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.KM - VerticalTranslateLayout.this.Pa && i2 > 0) {
                            VerticalTranslateLayout.this.Pc -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.OY - VerticalTranslateLayout.this.KM && i2 <= VerticalTranslateLayout.this.KM - VerticalTranslateLayout.this.Pa) {
                            VerticalTranslateLayout.this.Pc -= i;
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
            this.Lt.computeCurrentVelocity(this.Lv);
            float yVelocity = this.Lt.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Lw);
            } else {
                max = Math.max(yVelocity, this.Lw);
            }
            switch (VerticalTranslateLayout.this.Pf) {
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
            this.Lt.recycle();
            this.Lt = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Pc;
            if (i <= 0 && i >= VerticalTranslateLayout.this.OY - VerticalTranslateLayout.this.KM) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Pl.R(f);
                } else {
                    VerticalTranslateLayout.this.Pl.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.KM - VerticalTranslateLayout.this.Pa) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Pl.Q(f);
                } else {
                    VerticalTranslateLayout.this.Pl.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Pl.R(f);
            } else {
                VerticalTranslateLayout.this.Pl.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Pl.Q(f);
            } else {
                VerticalTranslateLayout.this.Pl.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Ll;
        float Lm;
        float Ln;
        float Lo;
        float Lp;
        long Lq;
        long Lr;
        boolean Ls;

        b() {
            this.Ll = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lm = ((((float) (uptimeMillis - this.Lq)) / 1000.0f) * this.Ln) + this.Lm;
            this.Lq = uptimeMillis;
            this.Lr += 16;
        }

        void on() {
            compute();
            if (this.Lm <= this.Lo) {
                e eVar = VerticalTranslateLayout.this.Pn;
                if (eVar != null) {
                    eVar.os();
                }
                this.Ls = false;
                VerticalTranslateLayout.this.KU = 10000;
                VerticalTranslateLayout.this.nc();
                return;
            }
            VerticalTranslateLayout.this.Pc = (int) (com.baidu.adp.widget.a.a(this.Lo, this.Lm, false) + this.Lp);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Pk.sendEmptyMessageAtTime(-100, this.Lr);
        }

        void oo() {
            compute();
            if (this.Lm >= this.Lo) {
                c cVar = VerticalTranslateLayout.this.Po;
                if (cVar != null) {
                    cVar.or();
                }
                this.Ls = false;
                VerticalTranslateLayout.this.KU = 10001;
                VerticalTranslateLayout.this.nc();
                return;
            }
            VerticalTranslateLayout.this.Pc = (int) (com.baidu.adp.widget.a.a(this.Lo, this.Lm, false) + this.Lp);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Pk.sendEmptyMessageAtTime(-101, this.Lr);
        }

        void op() {
            compute();
            if (this.Lm >= this.Lo) {
                for (d dVar : VerticalTranslateLayout.this.Lh) {
                    if (dVar != null) {
                        dVar.nk();
                    }
                }
                this.Ls = false;
                VerticalTranslateLayout.this.KU = 10004;
                VerticalTranslateLayout.this.nc();
                return;
            }
            VerticalTranslateLayout.this.Pc = (int) (com.baidu.adp.widget.a.a(this.Lo, this.Lm, false) + this.Lp);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Pk.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Lr);
        }

        void oq() {
            compute();
            if (this.Lm <= this.Lo) {
                for (d dVar : VerticalTranslateLayout.this.Lh) {
                    if (dVar != null) {
                        dVar.nk();
                    }
                }
                this.Ls = false;
                VerticalTranslateLayout.this.KU = 10004;
                VerticalTranslateLayout.this.nc();
                return;
            }
            VerticalTranslateLayout.this.Pc = (int) (com.baidu.adp.widget.a.a(this.Lo, this.Lm, false) + this.Lp);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Pk.sendEmptyMessageAtTime(-105, this.Lr);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Lh) {
                if (dVar != null) {
                    dVar.nj();
                }
            }
            this.Ls = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lq = uptimeMillis;
            this.Lr = uptimeMillis + 16;
            this.Ln = f;
            this.Lm = 0.0f;
            this.Lo = 0 - VerticalTranslateLayout.this.Pc;
            this.Lp = VerticalTranslateLayout.this.Pc;
            VerticalTranslateLayout.this.Pk.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Lo);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Pk.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Lr);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Lh) {
                if (dVar != null) {
                    dVar.nj();
                }
            }
            this.Ls = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lq = uptimeMillis;
            this.Lr = uptimeMillis + 16;
            this.Ln = f;
            this.Lm = 0.0f;
            this.Lo = 0 - VerticalTranslateLayout.this.Pc;
            this.Lp = VerticalTranslateLayout.this.Pc;
            BdLog.d("Animator@animateBottomOpen " + this.Lo);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Pk.removeMessages(-105);
            VerticalTranslateLayout.this.Pk.sendEmptyMessageAtTime(-105, this.Lr);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.Pn;
            if (eVar != null) {
                eVar.nh();
            }
            this.Ls = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lq = uptimeMillis;
            this.Lr = uptimeMillis + 16;
            this.Ln = f;
            this.Lm = 0.0f;
            this.Lo = ((-VerticalTranslateLayout.this.KM) + VerticalTranslateLayout.this.OY) - VerticalTranslateLayout.this.Pc;
            this.Lp = VerticalTranslateLayout.this.Pc;
            BdLog.d("Animator@animateTop " + this.Lo);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Pk.removeMessages(-100);
            VerticalTranslateLayout.this.Pk.sendEmptyMessageAtTime(-100, this.Lr);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.Po;
            if (cVar != null) {
                cVar.nl();
            }
            this.Ls = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lq = uptimeMillis;
            this.Lr = uptimeMillis + 16;
            this.Ln = f;
            this.Lm = 0.0f;
            this.Lo = (VerticalTranslateLayout.this.KM - VerticalTranslateLayout.this.Pa) - VerticalTranslateLayout.this.Pc;
            this.Lp = VerticalTranslateLayout.this.Pc;
            BdLog.d("Animator@animateBottom " + this.Lo);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Pk.removeMessages(-101);
            VerticalTranslateLayout.this.Pk.sendEmptyMessageAtTime(-101, this.Lr);
        }
    }
}
