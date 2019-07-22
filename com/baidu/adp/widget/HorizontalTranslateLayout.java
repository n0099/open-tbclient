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
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int KY;
    private float La;
    private float Lb;
    private int Lc;
    private final int Ld;
    private boolean Le;
    private boolean Lf;
    private TrackDirection Lg;
    private int Lh;
    private final Rect Li;
    private final Rect Lj;
    private final Paint Lk;
    private int Ll;
    private int Lm;
    private int Ln;
    private boolean Lo;
    private final a Lp;
    private final b Lq;
    private final g Lr;
    private d Ls;
    private f Lt;
    private final List<e> Lu;
    private c Lv;

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
        void nA();

        void nz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void nB();

        void nC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void nD();

        void nE();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Li = new Rect();
        this.Lj = new Rect();
        this.Lu = new ArrayList();
        this.Lp = new a();
        this.Lq = new b();
        this.Lr = new g();
        this.Lh = 10004;
        Resources resources = getResources();
        this.Lk = new Paint();
        this.Lk.setColor(-1);
        this.Ld = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.La = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.Lb = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.La != -1.0f && this.Lb != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.Lg = TrackDirection.horizontal;
            } else if (this.Lb != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.Lg = TrackDirection.right;
            } else if (this.La != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.Lg = TrackDirection.left;
            } else {
                this.Lg = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.La != -1.0f) {
                    this.Le = true;
                } else if ("right".equals(str) && this.Lb != -1.0f) {
                    this.Lf = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Lk.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Lk.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Lc = (int) ((this.La - this.KY) * (-f2));
            } else if (f2 > 0.0f) {
                this.Lc = (int) ((this.KY - this.Lb) * f2);
            } else if (f2 == 0.0f) {
                this.Lc = 0;
                this.Lh = 10004;
            } else if (f2 == -1.0f) {
                this.La -= getMeasuredWidth();
                this.Lh = 10000;
            } else if (f2 == 1.0f) {
                this.La = getMeasuredWidth() - this.Lb;
                this.Lh = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.La;
    }

    public int getRightOffset() {
        return (int) this.Lb;
    }

    public void setLeftTapBack(boolean z) {
        this.Le = z;
    }

    public void setRightTapBack(boolean z) {
        this.Lf = z;
    }

    public int getState() {
        return this.Lh;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Ls = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Lt = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Lv = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.Lc, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.Lc);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.Lk);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.Lc;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Lg == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.Lh == 10004) {
            switch (action) {
                case 0:
                    this.Ll = x;
                    this.Lm = y;
                    this.Lp.removeMessages(-100);
                    this.Lp.removeMessages(-104);
                    this.Lp.removeMessages(-101);
                    this.Lp.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.Lc, 0.0f);
                    return q(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i2 >= this.Lm - this.Ld && i2 <= this.Lm + this.Ld && (i < this.Ll - this.Ld || i > this.Ll + this.Ld) && this.Lr.aE(i - this.Ll);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.Lh == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.Lo = false;
                    if (this.Lr.LI) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Lr.nF();
                        this.Lr.nG();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Lr.LI) {
                        if (!this.Lo) {
                            if (x > this.Ll) {
                                this.Ln = this.Ll + this.Ld;
                                this.Lo = true;
                            } else {
                                this.Ln = this.Ll - this.Ld;
                                this.Lo = true;
                            }
                        }
                        this.Lr.aF(this.Ln - x);
                        this.Ln = x;
                        this.Lr.LH.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.Li);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.Lj);
        switch (action) {
            case 0:
                if ((this.Lh != 10000 || !this.Li.contains(x, y)) && (this.Lh != 10001 || !this.Lj.contains(x, y))) {
                    return false;
                }
                if (!this.Lr.LI) {
                    this.Ln = x;
                    this.Lr.aE(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Lr.LI) {
                    this.Lr.nF();
                    this.Lr.nG();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Lr.LI) {
            this.Lr.aF(this.Ln - x);
            this.Ln = x;
            this.Lr.LH.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.La != -1.0f) {
                this.Li.set(i, i2, (int) (i + this.La), i4);
            }
            if (this.Lb != -1.0f) {
                this.Lj.set((int) (i3 - this.Lb), i2, i3, i4);
            }
        }
        if (!this.Lq.LG && !this.Lr.LI) {
            nt();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.La) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Lb) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.KY = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt() {
        switch (this.Lh) {
            case 10000:
                this.Lc = (int) (this.La - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.Lc = (int) (getMeasuredWidth() - this.Lb);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Lc = 0;
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
            if (HorizontalTranslateLayout.this.Lq.LG) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Lq.ny();
                        return;
                    case -104:
                        HorizontalTranslateLayout.this.Lq.nx();
                        return;
                    case SapiErrorCode.INVALID_ARG /* -103 */:
                    case -102:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Lq.nw();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Lq.nv();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker LH;
        boolean LI;
        final int LJ;
        final int LK;

        g() {
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.LJ = (int) ((200.0f * f) + 0.5f);
            this.LK = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aE(int i) {
            switch (HorizontalTranslateLayout.this.Lg) {
                case left:
                    if (HorizontalTranslateLayout.this.Lh != 10004 && HorizontalTranslateLayout.this.Lh != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.Lh != 10004 && HorizontalTranslateLayout.this.Lh != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Lv != null) {
                        HorizontalTranslateLayout.this.Lv.aD(i);
                        break;
                    }
                    break;
            }
            this.LH = VelocityTracker.obtain();
            this.LI = true;
            return true;
        }

        void nF() {
            this.LI = false;
        }

        void aF(int i) {
            if (this.LI) {
                int i2 = HorizontalTranslateLayout.this.Lc - i;
                switch (HorizontalTranslateLayout.this.Lg) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.La - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.Lc -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Lb && i2 > 0) {
                            HorizontalTranslateLayout.this.Lc -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.La - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Lb) {
                            HorizontalTranslateLayout.this.Lc -= i;
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
        public void nG() {
            float max;
            this.LH.computeCurrentVelocity(this.LJ);
            float xVelocity = this.LH.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.LK);
            } else {
                max = Math.max(xVelocity, this.LK);
            }
            switch (HorizontalTranslateLayout.this.Lg) {
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
            this.LH.recycle();
            this.LH = null;
        }

        private void I(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.Lc;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.La - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Lq.G(f);
                } else {
                    HorizontalTranslateLayout.this.Lq.E(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Lb) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Lq.F(f);
                } else {
                    HorizontalTranslateLayout.this.Lq.H(f);
                }
            }
        }

        private void J(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Lq.G(f);
            } else {
                HorizontalTranslateLayout.this.Lq.E(f);
            }
        }

        private void K(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Lq.F(f);
            } else {
                HorizontalTranslateLayout.this.Lq.H(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float LA;
        float LB;
        float LC;
        long LD;
        long LE;
        boolean LG;
        final float Ly;
        float Lz;

        b() {
            this.Ly = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void nu() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lz = ((((float) (uptimeMillis - this.LD)) / 1000.0f) * this.LA) + this.Lz;
            this.LD = uptimeMillis;
            this.LE += 16;
        }

        void nv() {
            nu();
            if (this.Lz <= this.LB) {
                d dVar = HorizontalTranslateLayout.this.Ls;
                if (dVar != null) {
                    dVar.nA();
                }
                this.LG = false;
                HorizontalTranslateLayout.this.Lh = 10000;
                HorizontalTranslateLayout.this.nt();
                return;
            }
            HorizontalTranslateLayout.this.Lc = (int) (com.baidu.adp.widget.d.a(this.LB, this.Lz, false) + this.LC);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Lp.sendEmptyMessageAtTime(-100, this.LE);
        }

        void nw() {
            nu();
            if (this.Lz >= this.LB) {
                f fVar = HorizontalTranslateLayout.this.Lt;
                if (fVar != null) {
                    fVar.nE();
                }
                this.LG = false;
                HorizontalTranslateLayout.this.Lh = 10001;
                HorizontalTranslateLayout.this.nt();
                return;
            }
            HorizontalTranslateLayout.this.Lc = (int) (com.baidu.adp.widget.d.a(this.LB, this.Lz, false) + this.LC);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Lp.sendEmptyMessageAtTime(-101, this.LE);
        }

        void nx() {
            nu();
            if (this.Lz >= this.LB) {
                for (e eVar : HorizontalTranslateLayout.this.Lu) {
                    if (eVar != null) {
                        eVar.nC();
                    }
                }
                this.LG = false;
                HorizontalTranslateLayout.this.Lh = 10004;
                HorizontalTranslateLayout.this.nt();
                return;
            }
            HorizontalTranslateLayout.this.Lc = (int) (com.baidu.adp.widget.d.a(this.LB, this.Lz, false) + this.LC);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Lp.sendEmptyMessageAtTime(-104, this.LE);
        }

        void ny() {
            nu();
            if (this.Lz <= this.LB) {
                for (e eVar : HorizontalTranslateLayout.this.Lu) {
                    if (eVar != null) {
                        eVar.nC();
                    }
                }
                this.LG = false;
                HorizontalTranslateLayout.this.Lh = 10004;
                HorizontalTranslateLayout.this.nt();
                return;
            }
            HorizontalTranslateLayout.this.Lc = (int) (com.baidu.adp.widget.d.a(this.LB, this.Lz, false) + this.LC);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.Lp.sendEmptyMessageAtTime(-105, this.LE);
        }

        void E(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Lu) {
                if (eVar != null) {
                    eVar.nB();
                }
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = 0 - HorizontalTranslateLayout.this.Lc;
            this.LC = HorizontalTranslateLayout.this.Lc;
            HorizontalTranslateLayout.this.Lp.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.LB);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.Lp.sendEmptyMessageAtTime(-104, this.LE);
        }

        void F(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Lu) {
                if (eVar != null) {
                    eVar.nB();
                }
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = 0 - HorizontalTranslateLayout.this.Lc;
            this.LC = HorizontalTranslateLayout.this.Lc;
            BdLog.d("Animator@animateBottomOpen " + this.LB);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.Lp.removeMessages(-105);
            HorizontalTranslateLayout.this.Lp.sendEmptyMessageAtTime(-105, this.LE);
        }

        void G(float f) {
            d dVar = HorizontalTranslateLayout.this.Ls;
            if (dVar != null) {
                dVar.nz();
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.La) - HorizontalTranslateLayout.this.Lc;
            this.LC = HorizontalTranslateLayout.this.Lc;
            BdLog.d("Animator@animateTop " + this.LB);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.Lp.removeMessages(-100);
            HorizontalTranslateLayout.this.Lp.sendEmptyMessageAtTime(-100, this.LE);
        }

        void H(float f) {
            f fVar = HorizontalTranslateLayout.this.Lt;
            if (fVar != null) {
                fVar.nD();
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.Lb) - HorizontalTranslateLayout.this.Lc;
            this.LC = HorizontalTranslateLayout.this.Lc;
            BdLog.d("Animator@animateBottom " + this.LB);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.Lp.removeMessages(-101);
            HorizontalTranslateLayout.this.Lp.sendEmptyMessageAtTime(-101, this.LE);
        }
    }
}
