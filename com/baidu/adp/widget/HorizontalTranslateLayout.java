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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int JM;
    private float JO;
    private float JP;
    private int JQ;
    private final int JR;
    private boolean JS;
    private boolean JT;
    private TrackDirection JU;
    private int JV;
    private final Rect JW;
    private final Rect JX;
    private final Paint JY;
    private int JZ;
    private int Ka;
    private int Kb;
    private boolean Kc;
    private final a Kd;
    private final b Ke;
    private final g Kf;
    private d Kg;
    private f Kh;
    private final List<e> Ki;
    private c Kj;

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
        void aC(int i);
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
        void mS();

        void mT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mU();

        void mV();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.JW = new Rect();
        this.JX = new Rect();
        this.Ki = new ArrayList();
        this.Kd = new a();
        this.Ke = new b();
        this.Kf = new g();
        this.JV = 10004;
        Resources resources = getResources();
        this.JY = new Paint();
        this.JY.setColor(-1);
        this.JR = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.JO = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.JP = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.JO != -1.0f && this.JP != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.JU = TrackDirection.horizontal;
            } else if (this.JP != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.JU = TrackDirection.right;
            } else if (this.JO != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.JU = TrackDirection.left;
            } else {
                this.JU = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.JO != -1.0f) {
                    this.JS = true;
                } else if ("right".equals(str) && this.JP != -1.0f) {
                    this.JT = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.JY.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.JQ = (int) ((this.JO - this.JM) * (-f2));
            } else if (f2 > 0.0f) {
                this.JQ = (int) ((this.JM - this.JP) * f2);
            } else if (f2 == 0.0f) {
                this.JQ = 0;
                this.JV = 10004;
            } else if (f2 == -1.0f) {
                this.JO -= getMeasuredWidth();
                this.JV = 10000;
            } else if (f2 == 1.0f) {
                this.JO = getMeasuredWidth() - this.JP;
                this.JV = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.JO;
    }

    public int getRightOffset() {
        return (int) this.JP;
    }

    public void setLeftTapBack(boolean z) {
        this.JS = z;
    }

    public void setRightTapBack(boolean z) {
        this.JT = z;
    }

    public int getState() {
        return this.JV;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Kg = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Kh = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Kj = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.JQ, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.JQ);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.JY);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.JQ;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.JU == TrackDirection.none) {
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
                    this.Kd.removeMessages(-100);
                    this.Kd.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Kd.removeMessages(-101);
                    this.Kd.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.JQ, 0.0f);
                    return o(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i2 >= this.Ka - this.JR && i2 <= this.Ka + this.JR && (i < this.JZ - this.JR || i > this.JZ + this.JR) && this.Kf.aD(i - this.JZ);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Kc = false;
                    if (this.Kf.Kv) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Kf.mW();
                        this.Kf.mX();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Kf.Kv) {
                        if (!this.Kc) {
                            if (x > this.JZ) {
                                this.Kb = this.JZ + this.JR;
                                this.Kc = true;
                            } else {
                                this.Kb = this.JZ - this.JR;
                                this.Kc = true;
                            }
                        }
                        this.Kf.aE(this.Kb - x);
                        this.Kb = x;
                        this.Kf.Ku.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.JW);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.JX);
        switch (action) {
            case 0:
                if ((this.JV != 10000 || !this.JW.contains(x, y)) && (this.JV != 10001 || !this.JX.contains(x, y))) {
                    return false;
                }
                if (!this.Kf.Kv) {
                    this.Kb = x;
                    this.Kf.aD(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Kf.Kv) {
                    this.Kf.mW();
                    this.Kf.mX();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Kf.Kv) {
            this.Kf.aE(this.Kb - x);
            this.Kb = x;
            this.Kf.Ku.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.JO != -1.0f) {
                this.JW.set(i, i2, (int) (i + this.JO), i4);
            }
            if (this.JP != -1.0f) {
                this.JX.set((int) (i3 - this.JP), i2, i3, i4);
            }
        }
        if (!this.Ke.Kt && !this.Kf.Kv) {
            mL();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.JO) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.JP) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.JM = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL() {
        switch (this.JV) {
            case 10000:
                this.JQ = (int) (this.JO - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.JQ = (int) (getMeasuredWidth() - this.JP);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.JQ = 0;
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
            if (HorizontalTranslateLayout.this.Ke.Kt) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Ke.mP();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Ke.mO();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Ke.mN();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Ke.mM();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Kw = (int) ((200.0f * f) + 0.5f);
            this.Kx = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aD(int i) {
            switch (HorizontalTranslateLayout.this.JU) {
                case left:
                    if (HorizontalTranslateLayout.this.JV != 10004 && HorizontalTranslateLayout.this.JV != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.JV != 10004 && HorizontalTranslateLayout.this.JV != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Kj != null) {
                        HorizontalTranslateLayout.this.Kj.aC(i);
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
                int i2 = HorizontalTranslateLayout.this.JQ - i;
                switch (HorizontalTranslateLayout.this.JU) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.JO - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.JQ -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JP && i2 > 0) {
                            HorizontalTranslateLayout.this.JQ -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.JO - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JP) {
                            HorizontalTranslateLayout.this.JQ -= i;
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
        public void mX() {
            float max;
            this.Ku.computeCurrentVelocity(this.Kw);
            float xVelocity = this.Ku.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Kx);
            } else {
                max = Math.max(xVelocity, this.Kx);
            }
            switch (HorizontalTranslateLayout.this.JU) {
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
            this.Ku.recycle();
            this.Ku = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.JQ;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.JO - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Ke.G(f);
                } else {
                    HorizontalTranslateLayout.this.Ke.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JP) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Ke.F(f);
                } else {
                    HorizontalTranslateLayout.this.Ke.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Ke.G(f);
            } else {
                HorizontalTranslateLayout.this.Ke.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Ke.F(f);
            } else {
                HorizontalTranslateLayout.this.Ke.H(f);
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
            this.Km = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kn = ((((float) (uptimeMillis - this.Kr)) / 1000.0f) * this.Ko) + this.Kn;
            this.Kr = uptimeMillis;
            this.Ks += 16;
        }

        void mM() {
            compute();
            if (this.Kn <= this.Kp) {
                d dVar = HorizontalTranslateLayout.this.Kg;
                if (dVar != null) {
                    dVar.mR();
                }
                this.Kt = false;
                HorizontalTranslateLayout.this.JV = 10000;
                HorizontalTranslateLayout.this.mL();
                return;
            }
            HorizontalTranslateLayout.this.JQ = (int) (com.baidu.adp.widget.d.a(this.Kp, this.Kn, false) + this.Kq);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Kd.sendEmptyMessageAtTime(-100, this.Ks);
        }

        void mN() {
            compute();
            if (this.Kn >= this.Kp) {
                f fVar = HorizontalTranslateLayout.this.Kh;
                if (fVar != null) {
                    fVar.mV();
                }
                this.Kt = false;
                HorizontalTranslateLayout.this.JV = 10001;
                HorizontalTranslateLayout.this.mL();
                return;
            }
            HorizontalTranslateLayout.this.JQ = (int) (com.baidu.adp.widget.d.a(this.Kp, this.Kn, false) + this.Kq);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Kd.sendEmptyMessageAtTime(-101, this.Ks);
        }

        void mO() {
            compute();
            if (this.Kn >= this.Kp) {
                for (e eVar : HorizontalTranslateLayout.this.Ki) {
                    if (eVar != null) {
                        eVar.mT();
                    }
                }
                this.Kt = false;
                HorizontalTranslateLayout.this.JV = 10004;
                HorizontalTranslateLayout.this.mL();
                return;
            }
            HorizontalTranslateLayout.this.JQ = (int) (com.baidu.adp.widget.d.a(this.Kp, this.Kn, false) + this.Kq);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Kd.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ks);
        }

        void mP() {
            compute();
            if (this.Kn <= this.Kp) {
                for (e eVar : HorizontalTranslateLayout.this.Ki) {
                    if (eVar != null) {
                        eVar.mT();
                    }
                }
                this.Kt = false;
                HorizontalTranslateLayout.this.JV = 10004;
                HorizontalTranslateLayout.this.mL();
                return;
            }
            HorizontalTranslateLayout.this.JQ = (int) (com.baidu.adp.widget.d.a(this.Kp, this.Kn, false) + this.Kq);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Kd.sendEmptyMessageAtTime(-105, this.Ks);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Ki) {
                if (eVar != null) {
                    eVar.mS();
                }
            }
            this.Kt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kr = uptimeMillis;
            this.Ks = uptimeMillis + 16;
            this.Ko = f;
            this.Kn = 0.0f;
            this.Kp = 0 - HorizontalTranslateLayout.this.JQ;
            this.Kq = HorizontalTranslateLayout.this.JQ;
            HorizontalTranslateLayout.this.Kd.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Kp);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Kd.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ks);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Ki) {
                if (eVar != null) {
                    eVar.mS();
                }
            }
            this.Kt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kr = uptimeMillis;
            this.Ks = uptimeMillis + 16;
            this.Ko = f;
            this.Kn = 0.0f;
            this.Kp = 0 - HorizontalTranslateLayout.this.JQ;
            this.Kq = HorizontalTranslateLayout.this.JQ;
            BdLog.d("Animator@animateBottomOpen " + this.Kp);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Kd.removeMessages(-105);
            HorizontalTranslateLayout.this.Kd.sendEmptyMessageAtTime(-105, this.Ks);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Kg;
            if (dVar != null) {
                dVar.mQ();
            }
            this.Kt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kr = uptimeMillis;
            this.Ks = uptimeMillis + 16;
            this.Ko = f;
            this.Kn = 0.0f;
            this.Kp = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.JO) - HorizontalTranslateLayout.this.JQ;
            this.Kq = HorizontalTranslateLayout.this.JQ;
            BdLog.d("Animator@animateTop " + this.Kp);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Kd.removeMessages(-100);
            HorizontalTranslateLayout.this.Kd.sendEmptyMessageAtTime(-100, this.Ks);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Kh;
            if (fVar != null) {
                fVar.mU();
            }
            this.Kt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kr = uptimeMillis;
            this.Ks = uptimeMillis + 16;
            this.Ko = f;
            this.Kn = 0.0f;
            this.Kp = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JP) - HorizontalTranslateLayout.this.JQ;
            this.Kq = HorizontalTranslateLayout.this.JQ;
            BdLog.d("Animator@animateBottom " + this.Kp);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Kd.removeMessages(-101);
            HorizontalTranslateLayout.this.Kd.sendEmptyMessageAtTime(-101, this.Ks);
        }
    }
}
