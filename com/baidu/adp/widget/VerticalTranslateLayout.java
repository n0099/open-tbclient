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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int KY;
    private int KZ;
    private final int Ld;
    private int Lh;
    private final Paint Lk;
    private int Ll;
    private int Lm;
    private final List<d> Lu;
    private boolean PA;
    private final a PD;
    private final b PE;
    private final g PF;
    private e PG;
    private c PH;
    private f PI;
    private float Pp;
    private float Pq;
    private float Pr;
    private float Ps;
    private int Pt;
    private boolean Pu;
    private boolean Pv;
    private TrackDirection Pw;
    private final Rect Px;
    private final Rect Py;
    private int Pz;

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
        void nD();

        void oM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void nB();

        void nC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void nz();

        void oN();
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
        this.Px = new Rect();
        this.Py = new Rect();
        this.Lu = new ArrayList();
        this.PD = new a();
        this.PE = new b();
        this.PF = new g();
        this.Lh = 10004;
        Resources resources = getResources();
        this.Lk = new Paint();
        this.Lk.setColor(-1);
        this.Ld = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Pp = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Pr = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Pq = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Ps = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (oG() && oH() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Pw = TrackDirection.vertical;
            } else if (oH() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Pw = TrackDirection.bottom;
            } else if (oG() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Pw = TrackDirection.top;
            } else {
                this.Pw = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.Pp != -1.0f) {
                    this.Pu = true;
                } else if ("bottom".equals(str) && this.Pr != -1.0f) {
                    this.Pv = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.Lk.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
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
                this.Pt = (int) ((this.Pp - this.KZ) * (-f2));
            } else if (f2 > 0.0f) {
                this.Pt = (int) ((this.KZ - this.Pr) * f2);
            } else if (f2 == 0.0f) {
                this.Pt = 0;
                this.Lh = 10004;
            } else if (f2 == -1.0f) {
                this.Pp -= this.KZ;
                this.Lh = 10000;
            } else if (f2 == 1.0f) {
                this.Pp = this.KZ - this.Pr;
                this.Lh = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Pp;
    }

    public int getBottomOffset() {
        return (int) this.Pr;
    }

    public void setTopTapBack(boolean z) {
        this.Pu = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Pv = z;
    }

    public int getState() {
        return this.Lh;
    }

    public void setTopAnimationListener(e eVar) {
        this.PG = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.PH = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.PI = fVar;
    }

    private boolean oG() {
        return (this.Pp == -1.0f && this.Ps == -1.0f) ? false : true;
    }

    private boolean oH() {
        return (this.Pr == -1.0f && this.Pq == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Pt);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Pt);
        canvas.drawRect(0.0f, 0.0f, this.KY, this.KZ, this.Lk);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Pt;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Pw == TrackDirection.none) {
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
                    this.PD.removeMessages(-100);
                    this.PD.removeMessages(-104);
                    this.PD.removeMessages(-101);
                    this.PD.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Pt);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Ll - this.Ld && i <= this.Ll + this.Ld && (i2 < this.Lm - this.Ld || i2 > this.Lm + this.Ld) && this.PF.aE(i2 - this.Lm);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.PA = false;
                    if (this.PF.LI) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.PF.nF();
                        this.PF.nG();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.PF.LI) {
                        if (!this.PA) {
                            if (y > this.Lm) {
                                this.Pz = this.Lm + this.Ld;
                                this.PA = true;
                            } else {
                                this.Pz = this.Lm - this.Ld;
                                this.PA = true;
                            }
                        }
                        this.PF.aF(this.Pz - y);
                        this.Pz = y;
                        this.PF.LH.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Lh != 10000 || !this.Px.contains(x, y)) && (this.Lh != 10001 || !this.Py.contains(x, y))) {
                    return false;
                }
                if (!this.PF.LI) {
                    this.Pz = y;
                    this.PF.aE(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.PF.LI) {
                    this.PF.nF();
                    this.PF.nG();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.PF.LI) {
            this.PF.aF(this.Pz - y);
            this.Pz = y;
            this.PF.LH.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Pp != -1.0f) {
                this.Px.set(i, i2, i3, (int) (i2 + this.Pp));
            }
            if (this.Pr != -1.0f) {
                this.Py.set(i, (int) (i4 - this.Pr), i3, i4);
            }
        }
        if (!this.PE.LG && !this.PF.LI) {
            nt();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Pq != -1.0f) {
            this.Pp = i3 - this.Ps;
        }
        if (this.Ps != -1.0f) {
            this.Pr = i3 - this.Pq;
        }
        if (!$assertionsDisabled && i3 < this.Pp) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Pr) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.KY = getMeasuredWidth();
        this.KZ = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt() {
        switch (this.Lh) {
            case 10000:
                this.Pt = (int) (this.Pp - this.KZ);
                invalidate();
                return;
            case 10001:
                this.Pt = (int) (this.KZ - this.Pr);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Pt = 0;
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
            if (VerticalTranslateLayout.this.PE.LG) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.PE.oL();
                        return;
                    case -104:
                        VerticalTranslateLayout.this.PE.oK();
                        return;
                    case SapiErrorCode.INVALID_ARG /* -103 */:
                    case -102:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.PE.oJ();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.PE.oI();
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
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.LJ = (int) ((200.0f * f) + 0.5f);
            this.LK = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aE(int i) {
            switch (VerticalTranslateLayout.this.Pw) {
                case top:
                    if (VerticalTranslateLayout.this.Lh != 10004 && VerticalTranslateLayout.this.Lh != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.Lh != 10004 && VerticalTranslateLayout.this.Lh != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.PI != null) {
                        VerticalTranslateLayout.this.PI.aU(i);
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
                int i2 = VerticalTranslateLayout.this.Pt - i;
                switch (VerticalTranslateLayout.this.Pw) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Pp - VerticalTranslateLayout.this.KZ && i2 < 0) {
                            VerticalTranslateLayout.this.Pt -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.KZ - VerticalTranslateLayout.this.Pr && i2 > 0) {
                            VerticalTranslateLayout.this.Pt -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Pp - VerticalTranslateLayout.this.KZ && i2 <= VerticalTranslateLayout.this.KZ - VerticalTranslateLayout.this.Pr) {
                            VerticalTranslateLayout.this.Pt -= i;
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
        public void nG() {
            float max;
            this.LH.computeCurrentVelocity(this.LJ);
            float yVelocity = this.LH.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.LK);
            } else {
                max = Math.max(yVelocity, this.LK);
            }
            switch (VerticalTranslateLayout.this.Pw) {
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
            this.LH.recycle();
            this.LH = null;
        }

        private void T(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Pt;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Pp - VerticalTranslateLayout.this.KZ) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.PE.R(f);
                } else {
                    VerticalTranslateLayout.this.PE.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.KZ - VerticalTranslateLayout.this.Pr) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.PE.Q(f);
                } else {
                    VerticalTranslateLayout.this.PE.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.PE.R(f);
            } else {
                VerticalTranslateLayout.this.PE.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.PE.Q(f);
            } else {
                VerticalTranslateLayout.this.PE.S(f);
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
            this.Ly = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void nu() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Lz = ((((float) (uptimeMillis - this.LD)) / 1000.0f) * this.LA) + this.Lz;
            this.LD = uptimeMillis;
            this.LE += 16;
        }

        void oI() {
            nu();
            if (this.Lz <= this.LB) {
                e eVar = VerticalTranslateLayout.this.PG;
                if (eVar != null) {
                    eVar.oN();
                }
                this.LG = false;
                VerticalTranslateLayout.this.Lh = 10000;
                VerticalTranslateLayout.this.nt();
                return;
            }
            VerticalTranslateLayout.this.Pt = (int) (com.baidu.adp.widget.a.a(this.LB, this.Lz, false) + this.LC);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PD.sendEmptyMessageAtTime(-100, this.LE);
        }

        void oJ() {
            nu();
            if (this.Lz >= this.LB) {
                c cVar = VerticalTranslateLayout.this.PH;
                if (cVar != null) {
                    cVar.oM();
                }
                this.LG = false;
                VerticalTranslateLayout.this.Lh = 10001;
                VerticalTranslateLayout.this.nt();
                return;
            }
            VerticalTranslateLayout.this.Pt = (int) (com.baidu.adp.widget.a.a(this.LB, this.Lz, false) + this.LC);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PD.sendEmptyMessageAtTime(-101, this.LE);
        }

        void oK() {
            nu();
            if (this.Lz >= this.LB) {
                for (d dVar : VerticalTranslateLayout.this.Lu) {
                    if (dVar != null) {
                        dVar.nC();
                    }
                }
                this.LG = false;
                VerticalTranslateLayout.this.Lh = 10004;
                VerticalTranslateLayout.this.nt();
                return;
            }
            VerticalTranslateLayout.this.Pt = (int) (com.baidu.adp.widget.a.a(this.LB, this.Lz, false) + this.LC);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PD.sendEmptyMessageAtTime(-104, this.LE);
        }

        void oL() {
            nu();
            if (this.Lz <= this.LB) {
                for (d dVar : VerticalTranslateLayout.this.Lu) {
                    if (dVar != null) {
                        dVar.nC();
                    }
                }
                this.LG = false;
                VerticalTranslateLayout.this.Lh = 10004;
                VerticalTranslateLayout.this.nt();
                return;
            }
            VerticalTranslateLayout.this.Pt = (int) (com.baidu.adp.widget.a.a(this.LB, this.Lz, false) + this.LC);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PD.sendEmptyMessageAtTime(-105, this.LE);
        }

        void P(float f) {
            for (d dVar : VerticalTranslateLayout.this.Lu) {
                if (dVar != null) {
                    dVar.nB();
                }
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = 0 - VerticalTranslateLayout.this.Pt;
            this.LC = VerticalTranslateLayout.this.Pt;
            VerticalTranslateLayout.this.PD.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.LB);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.PD.sendEmptyMessageAtTime(-104, this.LE);
        }

        void Q(float f) {
            for (d dVar : VerticalTranslateLayout.this.Lu) {
                if (dVar != null) {
                    dVar.nB();
                }
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = 0 - VerticalTranslateLayout.this.Pt;
            this.LC = VerticalTranslateLayout.this.Pt;
            BdLog.d("Animator@animateBottomOpen " + this.LB);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.PD.removeMessages(-105);
            VerticalTranslateLayout.this.PD.sendEmptyMessageAtTime(-105, this.LE);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.PG;
            if (eVar != null) {
                eVar.nz();
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = ((-VerticalTranslateLayout.this.KZ) + VerticalTranslateLayout.this.Pp) - VerticalTranslateLayout.this.Pt;
            this.LC = VerticalTranslateLayout.this.Pt;
            BdLog.d("Animator@animateTop " + this.LB);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.PD.removeMessages(-100);
            VerticalTranslateLayout.this.PD.sendEmptyMessageAtTime(-100, this.LE);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.PH;
            if (cVar != null) {
                cVar.nD();
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = (VerticalTranslateLayout.this.KZ - VerticalTranslateLayout.this.Pr) - VerticalTranslateLayout.this.Pt;
            this.LC = VerticalTranslateLayout.this.Pt;
            BdLog.d("Animator@animateBottom " + this.LB);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.PD.removeMessages(-101);
            VerticalTranslateLayout.this.PD.sendEmptyMessageAtTime(-101, this.LE);
        }
    }
}
