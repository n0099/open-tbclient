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
    private final b MA;
    private final g MB;
    private d MC;
    private f MD;
    private final List<e> ME;
    private c MF;
    private int Mi;
    private float Mk;
    private float Ml;
    private int Mm;
    private final int Mn;
    private boolean Mo;
    private boolean Mp;
    private TrackDirection Mq;
    private int Mr;
    private final Rect Ms;
    private final Rect Mt;
    private final Paint Mu;
    private int Mv;
    private int Mw;
    private int Mx;
    private boolean My;
    private final a Mz;

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
        void nW();

        void nX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void nY();

        void nZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void oa();

        void ob();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Ms = new Rect();
        this.Mt = new Rect();
        this.ME = new ArrayList();
        this.Mz = new a();
        this.MA = new b();
        this.MB = new g();
        this.Mr = 10004;
        Resources resources = getResources();
        this.Mu = new Paint();
        this.Mu.setColor(-1);
        this.Mn = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.Mk = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.Ml = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.Mk != -1.0f && this.Ml != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.Mq = TrackDirection.horizontal;
            } else if (this.Ml != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.Mq = TrackDirection.right;
            } else if (this.Mk != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.Mq = TrackDirection.left;
            } else {
                this.Mq = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.Mk != -1.0f) {
                    this.Mo = true;
                } else if ("right".equals(str) && this.Ml != -1.0f) {
                    this.Mp = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Mu.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
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
                this.Mm = (int) ((this.Mk - this.Mi) * (-f2));
            } else if (f2 > 0.0f) {
                this.Mm = (int) ((this.Mi - this.Ml) * f2);
            } else if (f2 == 0.0f) {
                this.Mm = 0;
                this.Mr = 10004;
            } else if (f2 == -1.0f) {
                this.Mk -= getMeasuredWidth();
                this.Mr = 10000;
            } else if (f2 == 1.0f) {
                this.Mk = getMeasuredWidth() - this.Ml;
                this.Mr = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.Mk;
    }

    public int getRightOffset() {
        return (int) this.Ml;
    }

    public void setLeftTapBack(boolean z) {
        this.Mo = z;
    }

    public void setRightTapBack(boolean z) {
        this.Mp = z;
    }

    public int getState() {
        return this.Mr;
    }

    public void setLeftAnimationListener(d dVar) {
        this.MC = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.MD = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.MF = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Mm, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.Mm);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Mu);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Mm;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Mq == TrackDirection.none) {
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
                    this.Mz.removeMessages(-100);
                    this.Mz.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Mz.removeMessages(-101);
                    this.Mz.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Mm, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.Mw - this.Mn && i2 <= this.Mw + this.Mn && (i < this.Mv - this.Mn || i > this.Mv + this.Mn) && this.MB.aL(i - this.Mv);
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
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.My = false;
                    if (this.MB.MS) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.MB.oc();
                        this.MB.od();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.MB.MS) {
                        if (!this.My) {
                            if (x > this.Mv) {
                                this.Mx = this.Mv + this.Mn;
                                this.My = true;
                            } else {
                                this.Mx = this.Mv - this.Mn;
                                this.My = true;
                            }
                        }
                        this.MB.aM(this.Mx - x);
                        this.Mx = x;
                        this.MB.MR.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Ms);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Mt);
        switch (action) {
            case 0:
                if ((this.Mr != 10000 || !this.Ms.contains(x, y)) && (this.Mr != 10001 || !this.Mt.contains(x, y))) {
                    return false;
                }
                if (!this.MB.MS) {
                    this.Mx = x;
                    this.MB.aL(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.MB.MS) {
                    this.MB.oc();
                    this.MB.od();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.MB.MS) {
            this.MB.aM(this.Mx - x);
            this.Mx = x;
            this.MB.MR.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Mk != -1.0f) {
                this.Ms.set(i, i2, (int) (i + this.Mk), i4);
            }
            if (this.Ml != -1.0f) {
                this.Mt.set((int) (i3 - this.Ml), i2, i3, i4);
            }
        }
        if (!this.MA.MQ && !this.MB.MS) {
            nR();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.Mk) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Ml) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.Mi = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nR() {
        switch (this.Mr) {
            case 10000:
                this.Mm = (int) (this.Mk - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Mm = (int) (getMeasuredWidth() - this.Ml);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Mm = 0;
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
            if (HorizontalTranslateLayout.this.MA.MQ) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.MA.nV();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.MA.nU();
                        return;
                    case -103:
                    case FastRegResult.ERROR_CODE_SEND_SMS_FAILED /* -102 */:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.MA.nT();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.MA.nS();
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
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.MT = (int) ((200.0f * f) + 0.5f);
            this.MU = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aL(int i) {
            switch (HorizontalTranslateLayout.this.Mq) {
                case left:
                    if (HorizontalTranslateLayout.this.Mr != 10004 && HorizontalTranslateLayout.this.Mr != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.Mr != 10004 && HorizontalTranslateLayout.this.Mr != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.MF != null) {
                        HorizontalTranslateLayout.this.MF.aK(i);
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
                int i2 = HorizontalTranslateLayout.this.Mm - i;
                switch (HorizontalTranslateLayout.this.Mq) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.Mk - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.Mm -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Ml && i2 > 0) {
                            HorizontalTranslateLayout.this.Mm -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.Mk - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Ml) {
                            HorizontalTranslateLayout.this.Mm -= i;
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
        public void od() {
            float max;
            this.MR.computeCurrentVelocity(this.MT);
            float xVelocity = this.MR.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.MU);
            } else {
                max = Math.max(xVelocity, this.MU);
            }
            switch (HorizontalTranslateLayout.this.Mq) {
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
            this.MR.recycle();
            this.MR = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.Mm;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.Mk - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.MA.G(f);
                } else {
                    HorizontalTranslateLayout.this.MA.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Ml) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.MA.F(f);
                } else {
                    HorizontalTranslateLayout.this.MA.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.MA.G(f);
            } else {
                HorizontalTranslateLayout.this.MA.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.MA.F(f);
            } else {
                HorizontalTranslateLayout.this.MA.H(f);
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
            this.MI = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MJ = ((((float) (uptimeMillis - this.MO)) / 1000.0f) * this.MK) + this.MJ;
            this.MO = uptimeMillis;
            this.MP += 16;
        }

        void nS() {
            compute();
            if (this.MJ <= this.MM) {
                d dVar = HorizontalTranslateLayout.this.MC;
                if (dVar != null) {
                    dVar.nX();
                }
                this.MQ = false;
                HorizontalTranslateLayout.this.Mr = 10000;
                HorizontalTranslateLayout.this.nR();
                return;
            }
            HorizontalTranslateLayout.this.Mm = (int) (com.baidu.adp.widget.d.a(this.MM, this.MJ, false) + this.MN);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Mz.sendEmptyMessageAtTime(-100, this.MP);
        }

        void nT() {
            compute();
            if (this.MJ >= this.MM) {
                f fVar = HorizontalTranslateLayout.this.MD;
                if (fVar != null) {
                    fVar.ob();
                }
                this.MQ = false;
                HorizontalTranslateLayout.this.Mr = 10001;
                HorizontalTranslateLayout.this.nR();
                return;
            }
            HorizontalTranslateLayout.this.Mm = (int) (com.baidu.adp.widget.d.a(this.MM, this.MJ, false) + this.MN);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Mz.sendEmptyMessageAtTime(-101, this.MP);
        }

        void nU() {
            compute();
            if (this.MJ >= this.MM) {
                for (e eVar : HorizontalTranslateLayout.this.ME) {
                    if (eVar != null) {
                        eVar.nZ();
                    }
                }
                this.MQ = false;
                HorizontalTranslateLayout.this.Mr = 10004;
                HorizontalTranslateLayout.this.nR();
                return;
            }
            HorizontalTranslateLayout.this.Mm = (int) (com.baidu.adp.widget.d.a(this.MM, this.MJ, false) + this.MN);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Mz.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.MP);
        }

        void nV() {
            compute();
            if (this.MJ <= this.MM) {
                for (e eVar : HorizontalTranslateLayout.this.ME) {
                    if (eVar != null) {
                        eVar.nZ();
                    }
                }
                this.MQ = false;
                HorizontalTranslateLayout.this.Mr = 10004;
                HorizontalTranslateLayout.this.nR();
                return;
            }
            HorizontalTranslateLayout.this.Mm = (int) (com.baidu.adp.widget.d.a(this.MM, this.MJ, false) + this.MN);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Mz.sendEmptyMessageAtTime(-105, this.MP);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.ME) {
                if (eVar != null) {
                    eVar.nY();
                }
            }
            this.MQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MO = uptimeMillis;
            this.MP = uptimeMillis + 16;
            this.MK = f;
            this.MJ = 0.0f;
            this.MM = 0 - HorizontalTranslateLayout.this.Mm;
            this.MN = HorizontalTranslateLayout.this.Mm;
            HorizontalTranslateLayout.this.Mz.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.MM);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Mz.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.MP);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.ME) {
                if (eVar != null) {
                    eVar.nY();
                }
            }
            this.MQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MO = uptimeMillis;
            this.MP = uptimeMillis + 16;
            this.MK = f;
            this.MJ = 0.0f;
            this.MM = 0 - HorizontalTranslateLayout.this.Mm;
            this.MN = HorizontalTranslateLayout.this.Mm;
            BdLog.d("Animator@animateBottomOpen " + this.MM);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Mz.removeMessages(-105);
            HorizontalTranslateLayout.this.Mz.sendEmptyMessageAtTime(-105, this.MP);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.MC;
            if (dVar != null) {
                dVar.nW();
            }
            this.MQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MO = uptimeMillis;
            this.MP = uptimeMillis + 16;
            this.MK = f;
            this.MJ = 0.0f;
            this.MM = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.Mk) - HorizontalTranslateLayout.this.Mm;
            this.MN = HorizontalTranslateLayout.this.Mm;
            BdLog.d("Animator@animateTop " + this.MM);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Mz.removeMessages(-100);
            HorizontalTranslateLayout.this.Mz.sendEmptyMessageAtTime(-100, this.MP);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.MD;
            if (fVar != null) {
                fVar.oa();
            }
            this.MQ = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.MO = uptimeMillis;
            this.MP = uptimeMillis + 16;
            this.MK = f;
            this.MJ = 0.0f;
            this.MM = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Ml) - HorizontalTranslateLayout.this.Mm;
            this.MN = HorizontalTranslateLayout.this.Mm;
            BdLog.d("Animator@animateBottom " + this.MM);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Mz.removeMessages(-101);
            HorizontalTranslateLayout.this.Mz.sendEmptyMessageAtTime(-101, this.MP);
        }
    }
}
