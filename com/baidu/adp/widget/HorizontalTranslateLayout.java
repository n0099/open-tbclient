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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int JN;
    private float JP;
    private float JQ;
    private int JR;
    private final int JS;
    private boolean JT;
    private boolean JU;
    private TrackDirection JV;
    private int JW;
    private final Rect JX;
    private final Rect JY;
    private final Paint JZ;
    private int Ka;
    private int Kb;
    private int Kc;
    private boolean Kd;
    private final a Ke;
    private final b Kf;
    private final g Kg;
    private d Kh;
    private f Ki;
    private final List<e> Kj;
    private c Kk;

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
        this.JX = new Rect();
        this.JY = new Rect();
        this.Kj = new ArrayList();
        this.Ke = new a();
        this.Kf = new b();
        this.Kg = new g();
        this.JW = ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE;
        Resources resources = getResources();
        this.JZ = new Paint();
        this.JZ.setColor(-1);
        this.JS = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.JP = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.JQ = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.JP != -1.0f && this.JQ != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.JV = TrackDirection.horizontal;
            } else if (this.JQ != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.JV = TrackDirection.right;
            } else if (this.JP != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.JV = TrackDirection.left;
            } else {
                this.JV = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.JP != -1.0f) {
                    this.JT = true;
                } else if ("right".equals(str) && this.JQ != -1.0f) {
                    this.JU = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.JZ.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.JR = (int) ((this.JP - this.JN) * (-f2));
            } else if (f2 > 0.0f) {
                this.JR = (int) ((this.JN - this.JQ) * f2);
            } else if (f2 == 0.0f) {
                this.JR = 0;
                this.JW = ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.JP -= getMeasuredWidth();
                this.JW = 10000;
            } else if (f2 == 1.0f) {
                this.JP = getMeasuredWidth() - this.JQ;
                this.JW = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.JP;
    }

    public int getRightOffset() {
        return (int) this.JQ;
    }

    public void setLeftTapBack(boolean z) {
        this.JT = z;
    }

    public void setRightTapBack(boolean z) {
        this.JU = z;
    }

    public int getState() {
        return this.JW;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Kh = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Ki = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Kk = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.JR, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.JR);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.JZ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.JR;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.JV == TrackDirection.none) {
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
                    this.Ke.removeMessages(-100);
                    this.Ke.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Ke.removeMessages(-101);
                    this.Ke.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.JR, 0.0f);
                    return o(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i2 >= this.Kb - this.JS && i2 <= this.Kb + this.JS && (i < this.Ka - this.JS || i > this.Ka + this.JS) && this.Kg.aC(i - this.Ka);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Kd = false;
                    if (this.Kg.Kw) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Kg.mU();
                        this.Kg.mV();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Kg.Kw) {
                        if (!this.Kd) {
                            if (x > this.Ka) {
                                this.Kc = this.Ka + this.JS;
                                this.Kd = true;
                            } else {
                                this.Kc = this.Ka - this.JS;
                                this.Kd = true;
                            }
                        }
                        this.Kg.aD(this.Kc - x);
                        this.Kc = x;
                        this.Kg.Kv.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.JX);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.JY);
        switch (action) {
            case 0:
                if ((this.JW != 10000 || !this.JX.contains(x, y)) && (this.JW != 10001 || !this.JY.contains(x, y))) {
                    return false;
                }
                if (!this.Kg.Kw) {
                    this.Kc = x;
                    this.Kg.aC(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Kg.Kw) {
                    this.Kg.mU();
                    this.Kg.mV();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Kg.Kw) {
            this.Kg.aD(this.Kc - x);
            this.Kc = x;
            this.Kg.Kv.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.JP != -1.0f) {
                this.JX.set(i, i2, (int) (i + this.JP), i4);
            }
            if (this.JQ != -1.0f) {
                this.JY.set((int) (i3 - this.JQ), i2, i3, i4);
            }
        }
        if (!this.Kf.Ku && !this.Kg.Kw) {
            mJ();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.JP) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.JQ) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.JN = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ() {
        switch (this.JW) {
            case 10000:
                this.JR = (int) (this.JP - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.JR = (int) (getMeasuredWidth() - this.JQ);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE /* 10004 */:
                this.JR = 0;
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
            if (HorizontalTranslateLayout.this.Kf.Ku) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Kf.mN();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Kf.mM();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Kf.mL();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Kf.mK();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Kx = (int) ((200.0f * f) + 0.5f);
            this.Ky = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aC(int i) {
            switch (HorizontalTranslateLayout.this.JV) {
                case left:
                    if (HorizontalTranslateLayout.this.JW != 10004 && HorizontalTranslateLayout.this.JW != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.JW != 10004 && HorizontalTranslateLayout.this.JW != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Kk != null) {
                        HorizontalTranslateLayout.this.Kk.aB(i);
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
                int i2 = HorizontalTranslateLayout.this.JR - i;
                switch (HorizontalTranslateLayout.this.JV) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.JP - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.JR -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JQ && i2 > 0) {
                            HorizontalTranslateLayout.this.JR -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.JP - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JQ) {
                            HorizontalTranslateLayout.this.JR -= i;
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
            this.Kv.computeCurrentVelocity(this.Kx);
            float xVelocity = this.Kv.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Ky);
            } else {
                max = Math.max(xVelocity, this.Ky);
            }
            switch (HorizontalTranslateLayout.this.JV) {
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
            this.Kv.recycle();
            this.Kv = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.JR;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.JP - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Kf.G(f);
                } else {
                    HorizontalTranslateLayout.this.Kf.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JQ) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Kf.F(f);
                } else {
                    HorizontalTranslateLayout.this.Kf.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Kf.G(f);
            } else {
                HorizontalTranslateLayout.this.Kf.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Kf.F(f);
            } else {
                HorizontalTranslateLayout.this.Kf.H(f);
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
            this.Kn = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ko = ((((float) (uptimeMillis - this.Ks)) / 1000.0f) * this.Kp) + this.Ko;
            this.Ks = uptimeMillis;
            this.Kt += 16;
        }

        void mK() {
            compute();
            if (this.Ko <= this.Kq) {
                d dVar = HorizontalTranslateLayout.this.Kh;
                if (dVar != null) {
                    dVar.mP();
                }
                this.Ku = false;
                HorizontalTranslateLayout.this.JW = 10000;
                HorizontalTranslateLayout.this.mJ();
                return;
            }
            HorizontalTranslateLayout.this.JR = (int) (com.baidu.adp.widget.d.a(this.Kq, this.Ko, false) + this.Kr);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ke.sendEmptyMessageAtTime(-100, this.Kt);
        }

        void mL() {
            compute();
            if (this.Ko >= this.Kq) {
                f fVar = HorizontalTranslateLayout.this.Ki;
                if (fVar != null) {
                    fVar.mT();
                }
                this.Ku = false;
                HorizontalTranslateLayout.this.JW = 10001;
                HorizontalTranslateLayout.this.mJ();
                return;
            }
            HorizontalTranslateLayout.this.JR = (int) (com.baidu.adp.widget.d.a(this.Kq, this.Ko, false) + this.Kr);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ke.sendEmptyMessageAtTime(-101, this.Kt);
        }

        void mM() {
            compute();
            if (this.Ko >= this.Kq) {
                for (e eVar : HorizontalTranslateLayout.this.Kj) {
                    if (eVar != null) {
                        eVar.mR();
                    }
                }
                this.Ku = false;
                HorizontalTranslateLayout.this.JW = ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE;
                HorizontalTranslateLayout.this.mJ();
                return;
            }
            HorizontalTranslateLayout.this.JR = (int) (com.baidu.adp.widget.d.a(this.Kq, this.Ko, false) + this.Kr);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ke.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Kt);
        }

        void mN() {
            compute();
            if (this.Ko <= this.Kq) {
                for (e eVar : HorizontalTranslateLayout.this.Kj) {
                    if (eVar != null) {
                        eVar.mR();
                    }
                }
                this.Ku = false;
                HorizontalTranslateLayout.this.JW = ComponentMessageType.MSG_TYPE_SET_SHAKE_ENABLE;
                HorizontalTranslateLayout.this.mJ();
                return;
            }
            HorizontalTranslateLayout.this.JR = (int) (com.baidu.adp.widget.d.a(this.Kq, this.Ko, false) + this.Kr);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ke.sendEmptyMessageAtTime(-105, this.Kt);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Kj) {
                if (eVar != null) {
                    eVar.mQ();
                }
            }
            this.Ku = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ks = uptimeMillis;
            this.Kt = uptimeMillis + 16;
            this.Kp = f;
            this.Ko = 0.0f;
            this.Kq = 0 - HorizontalTranslateLayout.this.JR;
            this.Kr = HorizontalTranslateLayout.this.JR;
            HorizontalTranslateLayout.this.Ke.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Kq);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Ke.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Kt);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Kj) {
                if (eVar != null) {
                    eVar.mQ();
                }
            }
            this.Ku = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ks = uptimeMillis;
            this.Kt = uptimeMillis + 16;
            this.Kp = f;
            this.Ko = 0.0f;
            this.Kq = 0 - HorizontalTranslateLayout.this.JR;
            this.Kr = HorizontalTranslateLayout.this.JR;
            BdLog.d("Animator@animateBottomOpen " + this.Kq);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Ke.removeMessages(-105);
            HorizontalTranslateLayout.this.Ke.sendEmptyMessageAtTime(-105, this.Kt);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Kh;
            if (dVar != null) {
                dVar.mO();
            }
            this.Ku = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ks = uptimeMillis;
            this.Kt = uptimeMillis + 16;
            this.Kp = f;
            this.Ko = 0.0f;
            this.Kq = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.JP) - HorizontalTranslateLayout.this.JR;
            this.Kr = HorizontalTranslateLayout.this.JR;
            BdLog.d("Animator@animateTop " + this.Kq);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Ke.removeMessages(-100);
            HorizontalTranslateLayout.this.Ke.sendEmptyMessageAtTime(-100, this.Kt);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Ki;
            if (fVar != null) {
                fVar.mS();
            }
            this.Ku = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ks = uptimeMillis;
            this.Kt = uptimeMillis + 16;
            this.Kp = f;
            this.Ko = 0.0f;
            this.Kq = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.JQ) - HorizontalTranslateLayout.this.JR;
            this.Kr = HorizontalTranslateLayout.this.JR;
            BdLog.d("Animator@animateBottom " + this.Kq);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Ke.removeMessages(-101);
            HorizontalTranslateLayout.this.Ke.sendEmptyMessageAtTime(-101, this.Kt);
        }
    }
}
