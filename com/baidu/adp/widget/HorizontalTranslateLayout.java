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
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int MD;
    private float MF;
    private float MG;
    private int MH;
    private final int MI;
    private boolean MJ;
    private boolean MK;
    private TrackDirection MM;
    private int MN;
    private final Rect MO;
    private final Rect MP;
    private final Paint MQ;
    private int MR;
    private int MS;
    private int MT;
    private boolean MU;
    private final a MV;
    private final b MW;
    private final g MX;
    private d MY;
    private f MZ;
    private final List<e> Na;
    private c Nb;

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
        void aK(int i);
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
        void oj();

        void ok();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void ol();

        void om();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.MO = new Rect();
        this.MP = new Rect();
        this.Na = new ArrayList();
        this.MV = new a();
        this.MW = new b();
        this.MX = new g();
        this.MN = 10004;
        Resources resources = getResources();
        this.MQ = new Paint();
        this.MQ.setColor(-1);
        this.MI = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.MF = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.MG = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.MF != -1.0f && this.MG != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.MM = TrackDirection.horizontal;
            } else if (this.MG != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.MM = TrackDirection.right;
            } else if (this.MF != -1.0f && "left".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.MM = TrackDirection.left;
            } else {
                this.MM = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if ("left".equals(str) && this.MF != -1.0f) {
                    this.MJ = true;
                } else if ("right".equals(str) && this.MG != -1.0f) {
                    this.MK = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.MQ.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.MH = (int) ((this.MF - this.MD) * (-f2));
            } else if (f2 > 0.0f) {
                this.MH = (int) ((this.MD - this.MG) * f2);
            } else if (f2 == 0.0f) {
                this.MH = 0;
                this.MN = 10004;
            } else if (f2 == -1.0f) {
                this.MF -= getMeasuredWidth();
                this.MN = 10000;
            } else if (f2 == 1.0f) {
                this.MF = getMeasuredWidth() - this.MG;
                this.MN = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.MF;
    }

    public int getRightOffset() {
        return (int) this.MG;
    }

    public void setLeftTapBack(boolean z) {
        this.MJ = z;
    }

    public void setRightTapBack(boolean z) {
        this.MK = z;
    }

    public int getState() {
        return this.MN;
    }

    public void setLeftAnimationListener(d dVar) {
        this.MY = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.MZ = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Nb = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.MH, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.MH);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.MQ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.MH;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.MM == TrackDirection.none) {
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
                    this.MV.removeMessages(-100);
                    this.MV.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.MV.removeMessages(-101);
                    this.MV.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.MH, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.MS - this.MI && i2 <= this.MS + this.MI && (i < this.MR - this.MI || i > this.MR + this.MI) && this.MX.aL(i - this.MR);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.MU = false;
                    if (this.MX.Nn) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.MX.on();
                        this.MX.oo();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.MX.Nn) {
                        if (!this.MU) {
                            if (x > this.MR) {
                                this.MT = this.MR + this.MI;
                                this.MU = true;
                            } else {
                                this.MT = this.MR - this.MI;
                                this.MU = true;
                            }
                        }
                        this.MX.aM(this.MT - x);
                        this.MT = x;
                        this.MX.Nm.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.MO);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.MP);
        switch (action) {
            case 0:
                if ((this.MN != 10000 || !this.MO.contains(x, y)) && (this.MN != 10001 || !this.MP.contains(x, y))) {
                    return false;
                }
                if (!this.MX.Nn) {
                    this.MT = x;
                    this.MX.aL(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.MX.Nn) {
                    this.MX.on();
                    this.MX.oo();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.MX.Nn) {
            this.MX.aM(this.MT - x);
            this.MT = x;
            this.MX.Nm.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.MF != -1.0f) {
                this.MO.set(i, i2, (int) (i + this.MF), i4);
            }
            if (this.MG != -1.0f) {
                this.MP.set((int) (i3 - this.MG), i2, i3, i4);
            }
        }
        if (!this.MW.Nl && !this.MX.Nn) {
            ob();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.MF) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.MG) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.MD = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob() {
        switch (this.MN) {
            case 10000:
                this.MH = (int) (this.MF - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.MH = (int) (getMeasuredWidth() - this.MG);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.MH = 0;
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
            if (HorizontalTranslateLayout.this.MW.Nl) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.MW.og();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.MW.oe();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.MW.od();
                        return;
                    case -100:
                        HorizontalTranslateLayout.this.MW.oc();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.No = (int) ((200.0f * f) + 0.5f);
            this.Np = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aL(int i) {
            switch (HorizontalTranslateLayout.this.MM) {
                case left:
                    if (HorizontalTranslateLayout.this.MN != 10004 && HorizontalTranslateLayout.this.MN != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.MN != 10004 && HorizontalTranslateLayout.this.MN != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Nb != null) {
                        HorizontalTranslateLayout.this.Nb.aK(i);
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
                int i2 = HorizontalTranslateLayout.this.MH - i;
                switch (HorizontalTranslateLayout.this.MM) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.MF - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.MH -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MG && i2 > 0) {
                            HorizontalTranslateLayout.this.MH -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.MF - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MG) {
                            HorizontalTranslateLayout.this.MH -= i;
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
        public void oo() {
            float max;
            this.Nm.computeCurrentVelocity(this.No);
            float xVelocity = this.Nm.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Np);
            } else {
                max = Math.max(xVelocity, this.Np);
            }
            switch (HorizontalTranslateLayout.this.MM) {
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
            this.Nm.recycle();
            this.Nm = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.MH;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.MF - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.MW.G(f);
                } else {
                    HorizontalTranslateLayout.this.MW.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MG) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.MW.F(f);
                } else {
                    HorizontalTranslateLayout.this.MW.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.MW.G(f);
            } else {
                HorizontalTranslateLayout.this.MW.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.MW.F(f);
            } else {
                HorizontalTranslateLayout.this.MW.H(f);
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
            this.Ne = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nf = ((((float) (uptimeMillis - this.Nj)) / 1000.0f) * this.Ng) + this.Nf;
            this.Nj = uptimeMillis;
            this.Nk += 16;
        }

        void oc() {
            compute();
            if (this.Nf <= this.Nh) {
                d dVar = HorizontalTranslateLayout.this.MY;
                if (dVar != null) {
                    dVar.oi();
                }
                this.Nl = false;
                HorizontalTranslateLayout.this.MN = 10000;
                HorizontalTranslateLayout.this.ob();
                return;
            }
            HorizontalTranslateLayout.this.MH = (int) (com.baidu.adp.widget.d.a(this.Nh, this.Nf, false) + this.Ni);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.MV.sendEmptyMessageAtTime(-100, this.Nk);
        }

        void od() {
            compute();
            if (this.Nf >= this.Nh) {
                f fVar = HorizontalTranslateLayout.this.MZ;
                if (fVar != null) {
                    fVar.om();
                }
                this.Nl = false;
                HorizontalTranslateLayout.this.MN = 10001;
                HorizontalTranslateLayout.this.ob();
                return;
            }
            HorizontalTranslateLayout.this.MH = (int) (com.baidu.adp.widget.d.a(this.Nh, this.Nf, false) + this.Ni);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.MV.sendEmptyMessageAtTime(-101, this.Nk);
        }

        void oe() {
            compute();
            if (this.Nf >= this.Nh) {
                for (e eVar : HorizontalTranslateLayout.this.Na) {
                    if (eVar != null) {
                        eVar.ok();
                    }
                }
                this.Nl = false;
                HorizontalTranslateLayout.this.MN = 10004;
                HorizontalTranslateLayout.this.ob();
                return;
            }
            HorizontalTranslateLayout.this.MH = (int) (com.baidu.adp.widget.d.a(this.Nh, this.Nf, false) + this.Ni);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.MV.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nk);
        }

        void og() {
            compute();
            if (this.Nf <= this.Nh) {
                for (e eVar : HorizontalTranslateLayout.this.Na) {
                    if (eVar != null) {
                        eVar.ok();
                    }
                }
                this.Nl = false;
                HorizontalTranslateLayout.this.MN = 10004;
                HorizontalTranslateLayout.this.ob();
                return;
            }
            HorizontalTranslateLayout.this.MH = (int) (com.baidu.adp.widget.d.a(this.Nh, this.Nf, false) + this.Ni);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.MV.sendEmptyMessageAtTime(-105, this.Nk);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Na) {
                if (eVar != null) {
                    eVar.oj();
                }
            }
            this.Nl = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nj = uptimeMillis;
            this.Nk = uptimeMillis + 16;
            this.Ng = f;
            this.Nf = 0.0f;
            this.Nh = 0 - HorizontalTranslateLayout.this.MH;
            this.Ni = HorizontalTranslateLayout.this.MH;
            HorizontalTranslateLayout.this.MV.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Nh);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.MV.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Nk);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Na) {
                if (eVar != null) {
                    eVar.oj();
                }
            }
            this.Nl = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nj = uptimeMillis;
            this.Nk = uptimeMillis + 16;
            this.Ng = f;
            this.Nf = 0.0f;
            this.Nh = 0 - HorizontalTranslateLayout.this.MH;
            this.Ni = HorizontalTranslateLayout.this.MH;
            BdLog.d("Animator@animateBottomOpen " + this.Nh);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.MV.removeMessages(-105);
            HorizontalTranslateLayout.this.MV.sendEmptyMessageAtTime(-105, this.Nk);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.MY;
            if (dVar != null) {
                dVar.oh();
            }
            this.Nl = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nj = uptimeMillis;
            this.Nk = uptimeMillis + 16;
            this.Ng = f;
            this.Nf = 0.0f;
            this.Nh = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.MF) - HorizontalTranslateLayout.this.MH;
            this.Ni = HorizontalTranslateLayout.this.MH;
            BdLog.d("Animator@animateTop " + this.Nh);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.MV.removeMessages(-100);
            HorizontalTranslateLayout.this.MV.sendEmptyMessageAtTime(-100, this.Nk);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.MZ;
            if (fVar != null) {
                fVar.ol();
            }
            this.Nl = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Nj = uptimeMillis;
            this.Nk = uptimeMillis + 16;
            this.Ng = f;
            this.Nf = 0.0f;
            this.Nh = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.MG) - HorizontalTranslateLayout.this.MH;
            this.Ni = HorizontalTranslateLayout.this.MH;
            BdLog.d("Animator@animateBottom " + this.Nh);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.MV.removeMessages(-101);
            HorizontalTranslateLayout.this.MV.sendEmptyMessageAtTime(-101, this.Nk);
        }
    }
}
