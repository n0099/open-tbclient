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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int KL;
    private float KN;
    private float KO;
    private int KP;
    private final int KQ;
    private boolean KR;
    private boolean KS;
    private TrackDirection KT;
    private int KU;
    private final Rect KV;
    private final Rect KW;
    private final Paint KX;
    private int KY;
    private int KZ;
    private int La;
    private boolean Lb;
    private final a Lc;
    private final b Ld;
    private final g Le;
    private d Lf;
    private f Lg;
    private final List<e> Lh;
    private c Li;

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
        void aD(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void nh();

        void ni();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void nj();

        void nk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void nl();

        void nm();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.KV = new Rect();
        this.KW = new Rect();
        this.Lh = new ArrayList();
        this.Lc = new a();
        this.Ld = new b();
        this.Le = new g();
        this.KU = 10004;
        Resources resources = getResources();
        this.KX = new Paint();
        this.KX.setColor(-1);
        this.KQ = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.KN = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.KO = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.KN != -1.0f && this.KO != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.KT = TrackDirection.horizontal;
            } else if (this.KO != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.KT = TrackDirection.right;
            } else if (this.KN != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.KT = TrackDirection.left;
            } else {
                this.KT = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.KN != -1.0f) {
                    this.KR = true;
                } else if ("right".equals(str) && this.KO != -1.0f) {
                    this.KS = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.KX.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.KP = (int) ((this.KN - this.KL) * (-f2));
            } else if (f2 > 0.0f) {
                this.KP = (int) ((this.KL - this.KO) * f2);
            } else if (f2 == 0.0f) {
                this.KP = 0;
                this.KU = 10004;
            } else if (f2 == -1.0f) {
                this.KN -= getMeasuredWidth();
                this.KU = 10000;
            } else if (f2 == 1.0f) {
                this.KN = getMeasuredWidth() - this.KO;
                this.KU = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.KN;
    }

    public int getRightOffset() {
        return (int) this.KO;
    }

    public void setLeftTapBack(boolean z) {
        this.KR = z;
    }

    public void setRightTapBack(boolean z) {
        this.KS = z;
    }

    public int getState() {
        return this.KU;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Lf = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Lg = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Li = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.KP, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.KP);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.KX);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.KP;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.KT == TrackDirection.none) {
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
                    this.Lc.removeMessages(-100);
                    this.Lc.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Lc.removeMessages(-101);
                    this.Lc.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.KP, 0.0f);
                    return o(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i2 >= this.KZ - this.KQ && i2 <= this.KZ + this.KQ && (i < this.KY - this.KQ || i > this.KY + this.KQ) && this.Le.aE(i - this.KY);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Lb = false;
                    if (this.Le.Lu) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Le.nn();
                        this.Le.no();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Le.Lu) {
                        if (!this.Lb) {
                            if (x > this.KY) {
                                this.La = this.KY + this.KQ;
                                this.Lb = true;
                            } else {
                                this.La = this.KY - this.KQ;
                                this.Lb = true;
                            }
                        }
                        this.Le.aF(this.La - x);
                        this.La = x;
                        this.Le.Lt.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.KV);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.KW);
        switch (action) {
            case 0:
                if ((this.KU != 10000 || !this.KV.contains(x, y)) && (this.KU != 10001 || !this.KW.contains(x, y))) {
                    return false;
                }
                if (!this.Le.Lu) {
                    this.La = x;
                    this.Le.aE(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Le.Lu) {
                    this.Le.nn();
                    this.Le.no();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Le.Lu) {
            this.Le.aF(this.La - x);
            this.La = x;
            this.Le.Lt.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.KN != -1.0f) {
                this.KV.set(i, i2, (int) (i + this.KN), i4);
            }
            if (this.KO != -1.0f) {
                this.KW.set((int) (i3 - this.KO), i2, i3, i4);
            }
        }
        if (!this.Ld.Ls && !this.Le.Lu) {
            nc();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.KN) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.KO) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.KL = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc() {
        switch (this.KU) {
            case 10000:
                this.KP = (int) (this.KN - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.KP = (int) (getMeasuredWidth() - this.KO);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.KP = 0;
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
            if (HorizontalTranslateLayout.this.Ld.Ls) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Ld.ng();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Ld.nf();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Ld.ne();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Ld.nd();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Lv = (int) ((200.0f * f) + 0.5f);
            this.Lw = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aE(int i) {
            switch (HorizontalTranslateLayout.this.KT) {
                case left:
                    if (HorizontalTranslateLayout.this.KU != 10004 && HorizontalTranslateLayout.this.KU != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.KU != 10004 && HorizontalTranslateLayout.this.KU != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Li != null) {
                        HorizontalTranslateLayout.this.Li.aD(i);
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
                int i2 = HorizontalTranslateLayout.this.KP - i;
                switch (HorizontalTranslateLayout.this.KT) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.KN - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.KP -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.KO && i2 > 0) {
                            HorizontalTranslateLayout.this.KP -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.KN - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.KO) {
                            HorizontalTranslateLayout.this.KP -= i;
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
        public void no() {
            float max;
            this.Lt.computeCurrentVelocity(this.Lv);
            float xVelocity = this.Lt.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Lw);
            } else {
                max = Math.max(xVelocity, this.Lw);
            }
            switch (HorizontalTranslateLayout.this.KT) {
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
            this.Lt.recycle();
            this.Lt = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.KP;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.KN - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Ld.G(f);
                } else {
                    HorizontalTranslateLayout.this.Ld.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.KO) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Ld.F(f);
                } else {
                    HorizontalTranslateLayout.this.Ld.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Ld.G(f);
            } else {
                HorizontalTranslateLayout.this.Ld.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Ld.F(f);
            } else {
                HorizontalTranslateLayout.this.Ld.H(f);
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
            this.Ll = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lm = ((((float) (uptimeMillis - this.Lq)) / 1000.0f) * this.Ln) + this.Lm;
            this.Lq = uptimeMillis;
            this.Lr += 16;
        }

        void nd() {
            compute();
            if (this.Lm <= this.Lo) {
                d dVar = HorizontalTranslateLayout.this.Lf;
                if (dVar != null) {
                    dVar.ni();
                }
                this.Ls = false;
                HorizontalTranslateLayout.this.KU = 10000;
                HorizontalTranslateLayout.this.nc();
                return;
            }
            HorizontalTranslateLayout.this.KP = (int) (com.baidu.adp.widget.d.a(this.Lo, this.Lm, false) + this.Lp);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Lc.sendEmptyMessageAtTime(-100, this.Lr);
        }

        void ne() {
            compute();
            if (this.Lm >= this.Lo) {
                f fVar = HorizontalTranslateLayout.this.Lg;
                if (fVar != null) {
                    fVar.nm();
                }
                this.Ls = false;
                HorizontalTranslateLayout.this.KU = 10001;
                HorizontalTranslateLayout.this.nc();
                return;
            }
            HorizontalTranslateLayout.this.KP = (int) (com.baidu.adp.widget.d.a(this.Lo, this.Lm, false) + this.Lp);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Lc.sendEmptyMessageAtTime(-101, this.Lr);
        }

        void nf() {
            compute();
            if (this.Lm >= this.Lo) {
                for (e eVar : HorizontalTranslateLayout.this.Lh) {
                    if (eVar != null) {
                        eVar.nk();
                    }
                }
                this.Ls = false;
                HorizontalTranslateLayout.this.KU = 10004;
                HorizontalTranslateLayout.this.nc();
                return;
            }
            HorizontalTranslateLayout.this.KP = (int) (com.baidu.adp.widget.d.a(this.Lo, this.Lm, false) + this.Lp);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Lc.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Lr);
        }

        void ng() {
            compute();
            if (this.Lm <= this.Lo) {
                for (e eVar : HorizontalTranslateLayout.this.Lh) {
                    if (eVar != null) {
                        eVar.nk();
                    }
                }
                this.Ls = false;
                HorizontalTranslateLayout.this.KU = 10004;
                HorizontalTranslateLayout.this.nc();
                return;
            }
            HorizontalTranslateLayout.this.KP = (int) (com.baidu.adp.widget.d.a(this.Lo, this.Lm, false) + this.Lp);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Lc.sendEmptyMessageAtTime(-105, this.Lr);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Lh) {
                if (eVar != null) {
                    eVar.nj();
                }
            }
            this.Ls = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lq = uptimeMillis;
            this.Lr = uptimeMillis + 16;
            this.Ln = f;
            this.Lm = 0.0f;
            this.Lo = 0 - HorizontalTranslateLayout.this.KP;
            this.Lp = HorizontalTranslateLayout.this.KP;
            HorizontalTranslateLayout.this.Lc.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Lo);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Lc.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Lr);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Lh) {
                if (eVar != null) {
                    eVar.nj();
                }
            }
            this.Ls = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lq = uptimeMillis;
            this.Lr = uptimeMillis + 16;
            this.Ln = f;
            this.Lm = 0.0f;
            this.Lo = 0 - HorizontalTranslateLayout.this.KP;
            this.Lp = HorizontalTranslateLayout.this.KP;
            BdLog.d("Animator@animateBottomOpen " + this.Lo);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Lc.removeMessages(-105);
            HorizontalTranslateLayout.this.Lc.sendEmptyMessageAtTime(-105, this.Lr);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Lf;
            if (dVar != null) {
                dVar.nh();
            }
            this.Ls = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lq = uptimeMillis;
            this.Lr = uptimeMillis + 16;
            this.Ln = f;
            this.Lm = 0.0f;
            this.Lo = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.KN) - HorizontalTranslateLayout.this.KP;
            this.Lp = HorizontalTranslateLayout.this.KP;
            BdLog.d("Animator@animateTop " + this.Lo);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Lc.removeMessages(-100);
            HorizontalTranslateLayout.this.Lc.sendEmptyMessageAtTime(-100, this.Lr);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Lg;
            if (fVar != null) {
                fVar.nl();
            }
            this.Ls = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lq = uptimeMillis;
            this.Lr = uptimeMillis + 16;
            this.Ln = f;
            this.Lm = 0.0f;
            this.Lo = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.KO) - HorizontalTranslateLayout.this.KP;
            this.Lp = HorizontalTranslateLayout.this.KP;
            BdLog.d("Animator@animateBottom " + this.Lo);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Lc.removeMessages(-101);
            HorizontalTranslateLayout.this.Lc.sendEmptyMessageAtTime(-101, this.Lr);
        }
    }
}
