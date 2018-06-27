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
    private int JP;
    private float JR;
    private float JS;
    private int JT;
    private final int JU;
    private boolean JV;
    private boolean JW;
    private TrackDirection JX;
    private int JY;
    private final Rect JZ;
    private final Rect Ka;
    private final Paint Kb;
    private int Kc;
    private int Kd;
    private int Ke;
    private boolean Kf;
    private final a Kg;
    private final b Kh;
    private final g Ki;
    private d Kj;
    private f Kk;
    private final List<e> Kl;
    private c Km;

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
        void aB(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void mO();

        void mP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void mQ();

        void mR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void mS();

        void mT();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.JZ = new Rect();
        this.Ka = new Rect();
        this.Kl = new ArrayList();
        this.Kg = new a();
        this.Kh = new b();
        this.Ki = new g();
        this.JY = 10004;
        Resources resources = getResources();
        this.Kb = new Paint();
        this.Kb.setColor(-1);
        this.JU = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.JR = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.JS = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.JR != -1.0f && this.JS != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.JX = TrackDirection.horizontal;
            } else if (this.JS != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.JX = TrackDirection.right;
            } else if (this.JR != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.JX = TrackDirection.left;
            } else {
                this.JX = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.JR != -1.0f) {
                    this.JV = true;
                } else if ("right".equals(str) && this.JS != -1.0f) {
                    this.JW = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Kb.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.JT = (int) ((this.JR - this.JP) * (-f2));
            } else if (f2 > 0.0f) {
                this.JT = (int) ((this.JP - this.JS) * f2);
            } else if (f2 == 0.0f) {
                this.JT = 0;
                this.JY = 10004;
            } else if (f2 == -1.0f) {
                this.JR -= getMeasuredWidth();
                this.JY = 10000;
            } else if (f2 == 1.0f) {
                this.JR = getMeasuredWidth() - this.JS;
                this.JY = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.JR;
    }

    public int getRightOffset() {
        return (int) this.JS;
    }

    public void setLeftTapBack(boolean z) {
        this.JV = z;
    }

    public void setRightTapBack(boolean z) {
        this.JW = z;
    }

    public int getState() {
        return this.JY;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Kj = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Kk = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Km = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.JT, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.JT);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Kb);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.JT;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.JX == TrackDirection.none) {
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
                    this.Kg.removeMessages(-100);
                    this.Kg.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Kg.removeMessages(-101);
                    this.Kg.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.JT, 0.0f);
                    return o(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i2 >= this.Kd - this.JU && i2 <= this.Kd + this.JU && (i < this.Kc - this.JU || i > this.Kc + this.JU) && this.Ki.aC(i - this.Kc);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Kf = false;
                    if (this.Ki.Ky) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Ki.mU();
                        this.Ki.mV();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Ki.Ky) {
                        if (!this.Kf) {
                            if (x > this.Kc) {
                                this.Ke = this.Kc + this.JU;
                                this.Kf = true;
                            } else {
                                this.Ke = this.Kc - this.JU;
                                this.Kf = true;
                            }
                        }
                        this.Ki.aD(this.Ke - x);
                        this.Ke = x;
                        this.Ki.Kx.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.JZ);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Ka);
        switch (action) {
            case 0:
                if ((this.JY != 10000 || !this.JZ.contains(x, y)) && (this.JY != 10001 || !this.Ka.contains(x, y))) {
                    return false;
                }
                if (!this.Ki.Ky) {
                    this.Ke = x;
                    this.Ki.aC(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Ki.Ky) {
                    this.Ki.mU();
                    this.Ki.mV();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Ki.Ky) {
            this.Ki.aD(this.Ke - x);
            this.Ke = x;
            this.Ki.Kx.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.JR != -1.0f) {
                this.JZ.set(i, i2, (int) (i + this.JR), i4);
            }
            if (this.JS != -1.0f) {
                this.Ka.set((int) (i3 - this.JS), i2, i3, i4);
            }
        }
        if (!this.Kh.Kw && !this.Ki.Ky) {
            mJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.JR) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.JS) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.JP = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        switch (this.JY) {
            case 10000:
                this.JT = (int) (this.JR - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.JT = (int) (getMeasuredWidth() - this.JS);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.JT = 0;
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
            if (HorizontalTranslateLayout.this.Kh.Kw) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Kh.mN();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Kh.mM();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Kh.mL();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Kh.mK();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Kz = (int) ((200.0f * f) + 0.5f);
            this.KA = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aC(int i) {
            switch (HorizontalTranslateLayout.this.JX) {
                case left:
                    if (HorizontalTranslateLayout.this.JY != 10004 && HorizontalTranslateLayout.this.JY != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.JY != 10004 && HorizontalTranslateLayout.this.JY != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Km != null) {
                        HorizontalTranslateLayout.this.Km.aB(i);
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
                int i2 = HorizontalTranslateLayout.this.JT - i;
                switch (HorizontalTranslateLayout.this.JX) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.JR - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.JT -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JS && i2 > 0) {
                            HorizontalTranslateLayout.this.JT -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.JR - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JS) {
                            HorizontalTranslateLayout.this.JT -= i;
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
        public void mV() {
            float max;
            this.Kx.computeCurrentVelocity(this.Kz);
            float xVelocity = this.Kx.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.KA);
            } else {
                max = Math.max(xVelocity, this.KA);
            }
            switch (HorizontalTranslateLayout.this.JX) {
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
            this.Kx.recycle();
            this.Kx = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.JT;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.JR - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Kh.G(f);
                } else {
                    HorizontalTranslateLayout.this.Kh.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JS) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Kh.F(f);
                } else {
                    HorizontalTranslateLayout.this.Kh.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Kh.G(f);
            } else {
                HorizontalTranslateLayout.this.Kh.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Kh.F(f);
            } else {
                HorizontalTranslateLayout.this.Kh.H(f);
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
            this.Kp = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Kq = ((((float) (uptimeMillis - this.Ku)) / 1000.0f) * this.Kr) + this.Kq;
            this.Ku = uptimeMillis;
            this.Kv += 16;
        }

        void mK() {
            compute();
            if (this.Kq <= this.Ks) {
                d dVar = HorizontalTranslateLayout.this.Kj;
                if (dVar != null) {
                    dVar.mP();
                }
                this.Kw = false;
                HorizontalTranslateLayout.this.JY = 10000;
                HorizontalTranslateLayout.this.mJ();
                return;
            }
            HorizontalTranslateLayout.this.JT = (int) (com.baidu.adp.widget.d.a(this.Ks, this.Kq, false) + this.Kt);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Kg.sendEmptyMessageAtTime(-100, this.Kv);
        }

        void mL() {
            compute();
            if (this.Kq >= this.Ks) {
                f fVar = HorizontalTranslateLayout.this.Kk;
                if (fVar != null) {
                    fVar.mT();
                }
                this.Kw = false;
                HorizontalTranslateLayout.this.JY = 10001;
                HorizontalTranslateLayout.this.mJ();
                return;
            }
            HorizontalTranslateLayout.this.JT = (int) (com.baidu.adp.widget.d.a(this.Ks, this.Kq, false) + this.Kt);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Kg.sendEmptyMessageAtTime(-101, this.Kv);
        }

        void mM() {
            compute();
            if (this.Kq >= this.Ks) {
                for (e eVar : HorizontalTranslateLayout.this.Kl) {
                    if (eVar != null) {
                        eVar.mR();
                    }
                }
                this.Kw = false;
                HorizontalTranslateLayout.this.JY = 10004;
                HorizontalTranslateLayout.this.mJ();
                return;
            }
            HorizontalTranslateLayout.this.JT = (int) (com.baidu.adp.widget.d.a(this.Ks, this.Kq, false) + this.Kt);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Kg.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Kv);
        }

        void mN() {
            compute();
            if (this.Kq <= this.Ks) {
                for (e eVar : HorizontalTranslateLayout.this.Kl) {
                    if (eVar != null) {
                        eVar.mR();
                    }
                }
                this.Kw = false;
                HorizontalTranslateLayout.this.JY = 10004;
                HorizontalTranslateLayout.this.mJ();
                return;
            }
            HorizontalTranslateLayout.this.JT = (int) (com.baidu.adp.widget.d.a(this.Ks, this.Kq, false) + this.Kt);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Kg.sendEmptyMessageAtTime(-105, this.Kv);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Kl) {
                if (eVar != null) {
                    eVar.mQ();
                }
            }
            this.Kw = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ku = uptimeMillis;
            this.Kv = uptimeMillis + 16;
            this.Kr = f;
            this.Kq = 0.0f;
            this.Ks = 0 - HorizontalTranslateLayout.this.JT;
            this.Kt = HorizontalTranslateLayout.this.JT;
            HorizontalTranslateLayout.this.Kg.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Ks);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Kg.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Kv);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Kl) {
                if (eVar != null) {
                    eVar.mQ();
                }
            }
            this.Kw = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ku = uptimeMillis;
            this.Kv = uptimeMillis + 16;
            this.Kr = f;
            this.Kq = 0.0f;
            this.Ks = 0 - HorizontalTranslateLayout.this.JT;
            this.Kt = HorizontalTranslateLayout.this.JT;
            BdLog.d("Animator@animateBottomOpen " + this.Ks);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Kg.removeMessages(-105);
            HorizontalTranslateLayout.this.Kg.sendEmptyMessageAtTime(-105, this.Kv);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Kj;
            if (dVar != null) {
                dVar.mO();
            }
            this.Kw = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ku = uptimeMillis;
            this.Kv = uptimeMillis + 16;
            this.Kr = f;
            this.Kq = 0.0f;
            this.Ks = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.JR) - HorizontalTranslateLayout.this.JT;
            this.Kt = HorizontalTranslateLayout.this.JT;
            BdLog.d("Animator@animateTop " + this.Ks);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Kg.removeMessages(-100);
            HorizontalTranslateLayout.this.Kg.sendEmptyMessageAtTime(-100, this.Kv);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Kk;
            if (fVar != null) {
                fVar.mS();
            }
            this.Kw = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ku = uptimeMillis;
            this.Kv = uptimeMillis + 16;
            this.Kr = f;
            this.Kq = 0.0f;
            this.Ks = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JS) - HorizontalTranslateLayout.this.JT;
            this.Kt = HorizontalTranslateLayout.this.JT;
            BdLog.d("Animator@animateBottom " + this.Ks);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Kg.removeMessages(-101);
            HorizontalTranslateLayout.this.Kg.sendEmptyMessageAtTime(-101, this.Kv);
        }
    }
}
