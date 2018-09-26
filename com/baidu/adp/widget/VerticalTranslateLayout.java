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
    private final List<d> ME;
    private int Mi;
    private int Mj;
    private final int Mn;
    private int Mr;
    private final Paint Mu;
    private int Mv;
    private int Mw;
    private float PJ;
    private float PK;
    private float PM;
    private float PN;
    private int PO;
    private boolean PP;
    private boolean PQ;
    private TrackDirection PR;
    private final Rect PT;
    private final Rect PU;
    private int PV;
    private boolean PW;
    private final a PY;
    private final b PZ;
    private final g Qa;
    private e Qb;
    private c Qc;
    private f Qd;

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
        void oU();

        void oa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void nY();

        void nZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void nW();

        void oV();
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
        this.PT = new Rect();
        this.PU = new Rect();
        this.ME = new ArrayList();
        this.PY = new a();
        this.PZ = new b();
        this.Qa = new g();
        this.Mr = 10004;
        Resources resources = getResources();
        this.Mu = new Paint();
        this.Mu.setColor(-1);
        this.Mn = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.PJ = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.PM = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.PK = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.PN = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (oO() && oP() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.PR = TrackDirection.vertical;
            } else if (oP() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.PR = TrackDirection.bottom;
            } else if (oO() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.PR = TrackDirection.top;
            } else {
                this.PR = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.PJ != -1.0f) {
                    this.PP = true;
                } else if ("bottom".equals(str) && this.PM != -1.0f) {
                    this.PQ = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Mu.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Mu.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.PO = (int) ((this.PJ - this.Mj) * (-f2));
            } else if (f2 > 0.0f) {
                this.PO = (int) ((this.Mj - this.PM) * f2);
            } else if (f2 == 0.0f) {
                this.PO = 0;
                this.Mr = 10004;
            } else if (f2 == -1.0f) {
                this.PJ -= this.Mj;
                this.Mr = 10000;
            } else if (f2 == 1.0f) {
                this.PJ = this.Mj - this.PM;
                this.Mr = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.PJ;
    }

    public int getBottomOffset() {
        return (int) this.PM;
    }

    public void setTopTapBack(boolean z) {
        this.PP = z;
    }

    public void setBottomTapBack(boolean z) {
        this.PQ = z;
    }

    public int getState() {
        return this.Mr;
    }

    public void setTopAnimationListener(e eVar) {
        this.Qb = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Qc = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Qd = fVar;
    }

    private boolean oO() {
        return (this.PJ == -1.0f && this.PN == -1.0f) ? false : true;
    }

    private boolean oP() {
        return (this.PM == -1.0f && this.PK == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.PO);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.PO);
        canvas.drawRect(0.0f, 0.0f, this.Mi, this.Mj, this.Mu);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.PO;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.PR == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Mr == 10004) {
            switch (action) {
                case 0:
                    this.Mv = x;
                    this.Mw = y;
                    this.PY.removeMessages(-100);
                    this.PY.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.PY.removeMessages(-101);
                    this.PY.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.PO);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Mv - this.Mn && i <= this.Mv + this.Mn && (i2 < this.Mw - this.Mn || i2 > this.Mw + this.Mn) && this.Qa.aL(i2 - this.Mw);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.Mr == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.PW = false;
                    if (this.Qa.MS) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Qa.oc();
                        this.Qa.od();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Qa.MS) {
                        if (!this.PW) {
                            if (y > this.Mw) {
                                this.PV = this.Mw + this.Mn;
                                this.PW = true;
                            } else {
                                this.PV = this.Mw - this.Mn;
                                this.PW = true;
                            }
                        }
                        this.Qa.aM(this.PV - y);
                        this.PV = y;
                        this.Qa.MR.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Mr != 10000 || !this.PT.contains(x, y)) && (this.Mr != 10001 || !this.PU.contains(x, y))) {
                    return false;
                }
                if (!this.Qa.MS) {
                    this.PV = y;
                    this.Qa.aL(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Qa.MS) {
                    this.Qa.oc();
                    this.Qa.od();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Qa.MS) {
            this.Qa.aM(this.PV - y);
            this.PV = y;
            this.Qa.MR.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.PJ != -1.0f) {
                this.PT.set(i, i2, i3, (int) (i2 + this.PJ));
            }
            if (this.PM != -1.0f) {
                this.PU.set(i, (int) (i4 - this.PM), i3, i4);
            }
        }
        if (!this.PZ.MQ && !this.Qa.MS) {
            nR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.PK != -1.0f) {
            this.PJ = i3 - this.PN;
        }
        if (this.PN != -1.0f) {
            this.PM = i3 - this.PK;
        }
        if (!$assertionsDisabled && i3 < this.PJ) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.PM) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Mi = getMeasuredWidth();
        this.Mj = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nR() {
        switch (this.Mr) {
            case 10000:
                this.PO = (int) (this.PJ - this.Mj);
                invalidate();
                return;
            case 10001:
                this.PO = (int) (this.Mj - this.PM);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.PO = 0;
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
            if (VerticalTranslateLayout.this.PZ.MQ) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.PZ.oT();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.PZ.oS();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.PZ.oR();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.PZ.oQ();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker MR;
        boolean MS;
        final int MT;
        final int MU;

        g() {
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.MT = (int) ((200.0f * f) + 0.5f);
            this.MU = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aL(int i) {
            switch (VerticalTranslateLayout.this.PR) {
                case top:
                    if (VerticalTranslateLayout.this.Mr != 10004 && VerticalTranslateLayout.this.Mr != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.Mr != 10004 && VerticalTranslateLayout.this.Mr != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Qd != null) {
                        VerticalTranslateLayout.this.Qd.ba(i);
                        break;
                    }
                    break;
            }
            this.MR = VelocityTracker.obtain();
            this.MS = true;
            return true;
        }

        void oc() {
            this.MS = false;
        }

        void aM(int i) {
            if (this.MS) {
                int i2 = VerticalTranslateLayout.this.PO - i;
                switch (VerticalTranslateLayout.this.PR) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.PJ - VerticalTranslateLayout.this.Mj && i2 < 0) {
                            VerticalTranslateLayout.this.PO -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.Mj - VerticalTranslateLayout.this.PM && i2 > 0) {
                            VerticalTranslateLayout.this.PO -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.PJ - VerticalTranslateLayout.this.Mj && i2 <= VerticalTranslateLayout.this.Mj - VerticalTranslateLayout.this.PM) {
                            VerticalTranslateLayout.this.PO -= i;
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
        public void od() {
            float max;
            this.MR.computeCurrentVelocity(this.MT);
            float yVelocity = this.MR.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.MU);
            } else {
                max = Math.max(yVelocity, this.MU);
            }
            switch (VerticalTranslateLayout.this.PR) {
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
            this.MR.recycle();
            this.MR = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.PO;
            if (i <= 0 && i >= VerticalTranslateLayout.this.PJ - VerticalTranslateLayout.this.Mj) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.PZ.R(f);
                } else {
                    VerticalTranslateLayout.this.PZ.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.Mj - VerticalTranslateLayout.this.PM) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.PZ.Q(f);
                } else {
                    VerticalTranslateLayout.this.PZ.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.PZ.R(f);
            } else {
                VerticalTranslateLayout.this.PZ.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.PZ.Q(f);
            } else {
                VerticalTranslateLayout.this.PZ.S(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float MI;
        float MJ;
        float MK;
        float MM;
        float MN;
        long MO;
        long MP;
        boolean MQ;

        b() {
            this.MI = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MJ = ((((float) (uptimeMillis - this.MO)) / 1000.0f) * this.MK) + this.MJ;
            this.MO = uptimeMillis;
            this.MP += 16;
        }

        void oQ() {
            compute();
            if (this.MJ <= this.MM) {
                e eVar = VerticalTranslateLayout.this.Qb;
                if (eVar != null) {
                    eVar.oV();
                }
                this.MQ = false;
                VerticalTranslateLayout.this.Mr = 10000;
                VerticalTranslateLayout.this.nR();
                return;
            }
            VerticalTranslateLayout.this.PO = (int) (com.baidu.adp.widget.a.a(this.MM, this.MJ, false) + this.MN);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PY.sendEmptyMessageAtTime(-100, this.MP);
        }

        void oR() {
            compute();
            if (this.MJ >= this.MM) {
                c cVar = VerticalTranslateLayout.this.Qc;
                if (cVar != null) {
                    cVar.oU();
                }
                this.MQ = false;
                VerticalTranslateLayout.this.Mr = 10001;
                VerticalTranslateLayout.this.nR();
                return;
            }
            VerticalTranslateLayout.this.PO = (int) (com.baidu.adp.widget.a.a(this.MM, this.MJ, false) + this.MN);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PY.sendEmptyMessageAtTime(-101, this.MP);
        }

        void oS() {
            compute();
            if (this.MJ >= this.MM) {
                for (d dVar : VerticalTranslateLayout.this.ME) {
                    if (dVar != null) {
                        dVar.nZ();
                    }
                }
                this.MQ = false;
                VerticalTranslateLayout.this.Mr = 10004;
                VerticalTranslateLayout.this.nR();
                return;
            }
            VerticalTranslateLayout.this.PO = (int) (com.baidu.adp.widget.a.a(this.MM, this.MJ, false) + this.MN);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PY.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.MP);
        }

        void oT() {
            compute();
            if (this.MJ <= this.MM) {
                for (d dVar : VerticalTranslateLayout.this.ME) {
                    if (dVar != null) {
                        dVar.nZ();
                    }
                }
                this.MQ = false;
                VerticalTranslateLayout.this.Mr = 10004;
                VerticalTranslateLayout.this.nR();
                return;
            }
            VerticalTranslateLayout.this.PO = (int) (com.baidu.adp.widget.a.a(this.MM, this.MJ, false) + this.MN);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PY.sendEmptyMessageAtTime(-105, this.MP);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.ME) {
                if (dVar != null) {
                    dVar.nY();
                }
            }
            this.MQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MO = uptimeMillis;
            this.MP = uptimeMillis + 16;
            this.MK = f;
            this.MJ = 0.0f;
            this.MM = 0 - VerticalTranslateLayout.this.PO;
            this.MN = VerticalTranslateLayout.this.PO;
            VerticalTranslateLayout.this.PY.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.MM);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.PY.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.MP);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.ME) {
                if (dVar != null) {
                    dVar.nY();
                }
            }
            this.MQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MO = uptimeMillis;
            this.MP = uptimeMillis + 16;
            this.MK = f;
            this.MJ = 0.0f;
            this.MM = 0 - VerticalTranslateLayout.this.PO;
            this.MN = VerticalTranslateLayout.this.PO;
            BdLog.d("Animator@animateBottomOpen " + this.MM);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.PY.removeMessages(-105);
            VerticalTranslateLayout.this.PY.sendEmptyMessageAtTime(-105, this.MP);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.Qb;
            if (eVar != null) {
                eVar.nW();
            }
            this.MQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MO = uptimeMillis;
            this.MP = uptimeMillis + 16;
            this.MK = f;
            this.MJ = 0.0f;
            this.MM = ((-VerticalTranslateLayout.this.Mj) + VerticalTranslateLayout.this.PJ) - VerticalTranslateLayout.this.PO;
            this.MN = VerticalTranslateLayout.this.PO;
            BdLog.d("Animator@animateTop " + this.MM);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.PY.removeMessages(-100);
            VerticalTranslateLayout.this.PY.sendEmptyMessageAtTime(-100, this.MP);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.Qc;
            if (cVar != null) {
                cVar.oa();
            }
            this.MQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MO = uptimeMillis;
            this.MP = uptimeMillis + 16;
            this.MK = f;
            this.MJ = 0.0f;
            this.MM = (VerticalTranslateLayout.this.Mj - VerticalTranslateLayout.this.PM) - VerticalTranslateLayout.this.PO;
            this.MN = VerticalTranslateLayout.this.PO;
            BdLog.d("Animator@animateBottom " + this.MM);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.PY.removeMessages(-101);
            VerticalTranslateLayout.this.PY.sendEmptyMessageAtTime(-101, this.MP);
        }
    }
}
