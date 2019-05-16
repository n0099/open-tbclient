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
    private int KM;
    private float KO;
    private float KP;
    private int KQ;
    private final int KR;
    private boolean KS;
    private boolean KT;
    private TrackDirection KU;
    private int KV;
    private final Rect KW;
    private final Rect KX;
    private final Paint KY;
    private int KZ;
    private int La;
    private int Lb;
    private boolean Lc;
    private final a Ld;
    private final b Le;
    private final g Lf;
    private d Lg;
    private f Lh;
    private final List<e> Li;
    private c Lj;

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
        this.KW = new Rect();
        this.KX = new Rect();
        this.Li = new ArrayList();
        this.Ld = new a();
        this.Le = new b();
        this.Lf = new g();
        this.KV = 10004;
        Resources resources = getResources();
        this.KY = new Paint();
        this.KY.setColor(-1);
        this.KR = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.KO = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.KP = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.KO != -1.0f && this.KP != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.KU = TrackDirection.horizontal;
            } else if (this.KP != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.KU = TrackDirection.right;
            } else if (this.KO != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.KU = TrackDirection.left;
            } else {
                this.KU = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.KO != -1.0f) {
                    this.KS = true;
                } else if ("right".equals(str) && this.KP != -1.0f) {
                    this.KT = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.KY.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.KQ = (int) ((this.KO - this.KM) * (-f2));
            } else if (f2 > 0.0f) {
                this.KQ = (int) ((this.KM - this.KP) * f2);
            } else if (f2 == 0.0f) {
                this.KQ = 0;
                this.KV = 10004;
            } else if (f2 == -1.0f) {
                this.KO -= getMeasuredWidth();
                this.KV = 10000;
            } else if (f2 == 1.0f) {
                this.KO = getMeasuredWidth() - this.KP;
                this.KV = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.KO;
    }

    public int getRightOffset() {
        return (int) this.KP;
    }

    public void setLeftTapBack(boolean z) {
        this.KS = z;
    }

    public void setRightTapBack(boolean z) {
        this.KT = z;
    }

    public int getState() {
        return this.KV;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Lg = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Lh = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Lj = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.KQ, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.KQ);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.KY);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.KQ;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.KU == TrackDirection.none) {
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
                    this.Ld.removeMessages(-100);
                    this.Ld.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Ld.removeMessages(-101);
                    this.Ld.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.KQ, 0.0f);
                    return o(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i2 >= this.La - this.KR && i2 <= this.La + this.KR && (i < this.KZ - this.KR || i > this.KZ + this.KR) && this.Lf.aE(i - this.KZ);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Lc = false;
                    if (this.Lf.Lv) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Lf.nn();
                        this.Lf.no();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Lf.Lv) {
                        if (!this.Lc) {
                            if (x > this.KZ) {
                                this.Lb = this.KZ + this.KR;
                                this.Lc = true;
                            } else {
                                this.Lb = this.KZ - this.KR;
                                this.Lc = true;
                            }
                        }
                        this.Lf.aF(this.Lb - x);
                        this.Lb = x;
                        this.Lf.Lu.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.KW);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.KX);
        switch (action) {
            case 0:
                if ((this.KV != 10000 || !this.KW.contains(x, y)) && (this.KV != 10001 || !this.KX.contains(x, y))) {
                    return false;
                }
                if (!this.Lf.Lv) {
                    this.Lb = x;
                    this.Lf.aE(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Lf.Lv) {
                    this.Lf.nn();
                    this.Lf.no();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Lf.Lv) {
            this.Lf.aF(this.Lb - x);
            this.Lb = x;
            this.Lf.Lu.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.KO != -1.0f) {
                this.KW.set(i, i2, (int) (i + this.KO), i4);
            }
            if (this.KP != -1.0f) {
                this.KX.set((int) (i3 - this.KP), i2, i3, i4);
            }
        }
        if (!this.Le.Lt && !this.Lf.Lv) {
            nc();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.KO) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.KP) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.KM = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc() {
        switch (this.KV) {
            case 10000:
                this.KQ = (int) (this.KO - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.KQ = (int) (getMeasuredWidth() - this.KP);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.KQ = 0;
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
            if (HorizontalTranslateLayout.this.Le.Lt) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Le.ng();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Le.nf();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Le.ne();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Le.nd();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Lw = (int) ((200.0f * f) + 0.5f);
            this.Lx = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aE(int i) {
            switch (HorizontalTranslateLayout.this.KU) {
                case left:
                    if (HorizontalTranslateLayout.this.KV != 10004 && HorizontalTranslateLayout.this.KV != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.KV != 10004 && HorizontalTranslateLayout.this.KV != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Lj != null) {
                        HorizontalTranslateLayout.this.Lj.aD(i);
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
                int i2 = HorizontalTranslateLayout.this.KQ - i;
                switch (HorizontalTranslateLayout.this.KU) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.KO - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.KQ -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.KP && i2 > 0) {
                            HorizontalTranslateLayout.this.KQ -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.KO - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.KP) {
                            HorizontalTranslateLayout.this.KQ -= i;
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
            this.Lu.computeCurrentVelocity(this.Lw);
            float xVelocity = this.Lu.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Lx);
            } else {
                max = Math.max(xVelocity, this.Lx);
            }
            switch (HorizontalTranslateLayout.this.KU) {
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
            this.Lu.recycle();
            this.Lu = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.KQ;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.KO - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Le.G(f);
                } else {
                    HorizontalTranslateLayout.this.Le.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.KP) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Le.F(f);
                } else {
                    HorizontalTranslateLayout.this.Le.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Le.G(f);
            } else {
                HorizontalTranslateLayout.this.Le.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Le.F(f);
            } else {
                HorizontalTranslateLayout.this.Le.H(f);
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
            this.Lm = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ln = ((((float) (uptimeMillis - this.Lr)) / 1000.0f) * this.Lo) + this.Ln;
            this.Lr = uptimeMillis;
            this.Ls += 16;
        }

        void nd() {
            compute();
            if (this.Ln <= this.Lp) {
                d dVar = HorizontalTranslateLayout.this.Lg;
                if (dVar != null) {
                    dVar.ni();
                }
                this.Lt = false;
                HorizontalTranslateLayout.this.KV = 10000;
                HorizontalTranslateLayout.this.nc();
                return;
            }
            HorizontalTranslateLayout.this.KQ = (int) (com.baidu.adp.widget.d.a(this.Lp, this.Ln, false) + this.Lq);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ld.sendEmptyMessageAtTime(-100, this.Ls);
        }

        void ne() {
            compute();
            if (this.Ln >= this.Lp) {
                f fVar = HorizontalTranslateLayout.this.Lh;
                if (fVar != null) {
                    fVar.nm();
                }
                this.Lt = false;
                HorizontalTranslateLayout.this.KV = 10001;
                HorizontalTranslateLayout.this.nc();
                return;
            }
            HorizontalTranslateLayout.this.KQ = (int) (com.baidu.adp.widget.d.a(this.Lp, this.Ln, false) + this.Lq);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ld.sendEmptyMessageAtTime(-101, this.Ls);
        }

        void nf() {
            compute();
            if (this.Ln >= this.Lp) {
                for (e eVar : HorizontalTranslateLayout.this.Li) {
                    if (eVar != null) {
                        eVar.nk();
                    }
                }
                this.Lt = false;
                HorizontalTranslateLayout.this.KV = 10004;
                HorizontalTranslateLayout.this.nc();
                return;
            }
            HorizontalTranslateLayout.this.KQ = (int) (com.baidu.adp.widget.d.a(this.Lp, this.Ln, false) + this.Lq);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ld.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ls);
        }

        void ng() {
            compute();
            if (this.Ln <= this.Lp) {
                for (e eVar : HorizontalTranslateLayout.this.Li) {
                    if (eVar != null) {
                        eVar.nk();
                    }
                }
                this.Lt = false;
                HorizontalTranslateLayout.this.KV = 10004;
                HorizontalTranslateLayout.this.nc();
                return;
            }
            HorizontalTranslateLayout.this.KQ = (int) (com.baidu.adp.widget.d.a(this.Lp, this.Ln, false) + this.Lq);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Ld.sendEmptyMessageAtTime(-105, this.Ls);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Li) {
                if (eVar != null) {
                    eVar.nj();
                }
            }
            this.Lt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lr = uptimeMillis;
            this.Ls = uptimeMillis + 16;
            this.Lo = f;
            this.Ln = 0.0f;
            this.Lp = 0 - HorizontalTranslateLayout.this.KQ;
            this.Lq = HorizontalTranslateLayout.this.KQ;
            HorizontalTranslateLayout.this.Ld.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Lp);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Ld.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ls);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Li) {
                if (eVar != null) {
                    eVar.nj();
                }
            }
            this.Lt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lr = uptimeMillis;
            this.Ls = uptimeMillis + 16;
            this.Lo = f;
            this.Ln = 0.0f;
            this.Lp = 0 - HorizontalTranslateLayout.this.KQ;
            this.Lq = HorizontalTranslateLayout.this.KQ;
            BdLog.d("Animator@animateBottomOpen " + this.Lp);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Ld.removeMessages(-105);
            HorizontalTranslateLayout.this.Ld.sendEmptyMessageAtTime(-105, this.Ls);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Lg;
            if (dVar != null) {
                dVar.nh();
            }
            this.Lt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lr = uptimeMillis;
            this.Ls = uptimeMillis + 16;
            this.Lo = f;
            this.Ln = 0.0f;
            this.Lp = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.KO) - HorizontalTranslateLayout.this.KQ;
            this.Lq = HorizontalTranslateLayout.this.KQ;
            BdLog.d("Animator@animateTop " + this.Lp);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Ld.removeMessages(-100);
            HorizontalTranslateLayout.this.Ld.sendEmptyMessageAtTime(-100, this.Ls);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Lh;
            if (fVar != null) {
                fVar.nl();
            }
            this.Lt = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lr = uptimeMillis;
            this.Ls = uptimeMillis + 16;
            this.Lo = f;
            this.Ln = 0.0f;
            this.Lp = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.KP) - HorizontalTranslateLayout.this.KQ;
            this.Lq = HorizontalTranslateLayout.this.KQ;
            BdLog.d("Animator@animateBottom " + this.Lp);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Ld.removeMessages(-101);
            HorizontalTranslateLayout.this.Ld.sendEmptyMessageAtTime(-101, this.Ls);
        }
    }
}
