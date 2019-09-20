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
    private final a PA;
    private final b PD;
    private final g PE;
    private e PF;
    private c PG;
    private f PH;
    private float Po;
    private float Pp;
    private float Pq;
    private float Pr;
    private int Ps;
    private boolean Pt;
    private boolean Pu;
    private TrackDirection Pv;
    private final Rect Pw;
    private final Rect Px;
    private int Py;
    private boolean Pz;

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

        void oN();
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

        void oO();
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
        this.Pw = new Rect();
        this.Px = new Rect();
        this.Lu = new ArrayList();
        this.PA = new a();
        this.PD = new b();
        this.PE = new g();
        this.Lh = 10004;
        Resources resources = getResources();
        this.Lk = new Paint();
        this.Lk.setColor(-1);
        this.Ld = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Po = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Pq = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Pp = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Pr = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (oH() && oI() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Pv = TrackDirection.vertical;
            } else if (oI() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Pv = TrackDirection.bottom;
            } else if (oH() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Pv = TrackDirection.top;
            } else {
                this.Pv = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split("\\|");
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.Po != -1.0f) {
                    this.Pt = true;
                } else if ("bottom".equals(str) && this.Pq != -1.0f) {
                    this.Pu = true;
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
                this.Ps = (int) ((this.Po - this.KZ) * (-f2));
            } else if (f2 > 0.0f) {
                this.Ps = (int) ((this.KZ - this.Pq) * f2);
            } else if (f2 == 0.0f) {
                this.Ps = 0;
                this.Lh = 10004;
            } else if (f2 == -1.0f) {
                this.Po -= this.KZ;
                this.Lh = 10000;
            } else if (f2 == 1.0f) {
                this.Po = this.KZ - this.Pq;
                this.Lh = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Po;
    }

    public int getBottomOffset() {
        return (int) this.Pq;
    }

    public void setTopTapBack(boolean z) {
        this.Pt = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Pu = z;
    }

    public int getState() {
        return this.Lh;
    }

    public void setTopAnimationListener(e eVar) {
        this.PF = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.PG = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.PH = fVar;
    }

    private boolean oH() {
        return (this.Po == -1.0f && this.Pr == -1.0f) ? false : true;
    }

    private boolean oI() {
        return (this.Pq == -1.0f && this.Pp == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Ps);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Ps);
        canvas.drawRect(0.0f, 0.0f, this.KY, this.KZ, this.Lk);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Ps;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Pv == TrackDirection.none) {
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
                    this.PA.removeMessages(-100);
                    this.PA.removeMessages(-104);
                    this.PA.removeMessages(-101);
                    this.PA.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Ps);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.Ll - this.Ld && i <= this.Ll + this.Ld && (i2 < this.Lm - this.Ld || i2 > this.Lm + this.Ld) && this.PE.aE(i2 - this.Lm);
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
                    this.Pz = false;
                    if (this.PE.LI) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.PE.nF();
                        this.PE.nG();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.PE.LI) {
                        if (!this.Pz) {
                            if (y > this.Lm) {
                                this.Py = this.Lm + this.Ld;
                                this.Pz = true;
                            } else {
                                this.Py = this.Lm - this.Ld;
                                this.Pz = true;
                            }
                        }
                        this.PE.aF(this.Py - y);
                        this.Py = y;
                        this.PE.LH.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.Lh != 10000 || !this.Pw.contains(x, y)) && (this.Lh != 10001 || !this.Px.contains(x, y))) {
                    return false;
                }
                if (!this.PE.LI) {
                    this.Py = y;
                    this.PE.aE(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.PE.LI) {
                    this.PE.nF();
                    this.PE.nG();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.PE.LI) {
            this.PE.aF(this.Py - y);
            this.Py = y;
            this.PE.LH.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Po != -1.0f) {
                this.Pw.set(i, i2, i3, (int) (i2 + this.Po));
            }
            if (this.Pq != -1.0f) {
                this.Px.set(i, (int) (i4 - this.Pq), i3, i4);
            }
        }
        if (!this.PD.LG && !this.PE.LI) {
            nt();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Pp != -1.0f) {
            this.Po = i3 - this.Pr;
        }
        if (this.Pr != -1.0f) {
            this.Pq = i3 - this.Pp;
        }
        if (!$assertionsDisabled && i3 < this.Po) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Pq) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.KY = getMeasuredWidth();
        this.KZ = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt() {
        switch (this.Lh) {
            case 10000:
                this.Ps = (int) (this.Po - this.KZ);
                invalidate();
                return;
            case 10001:
                this.Ps = (int) (this.KZ - this.Pq);
                invalidate();
                return;
            case 10002:
            case 10003:
            default:
                return;
            case 10004:
                this.Ps = 0;
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
            if (VerticalTranslateLayout.this.PD.LG) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.PD.oM();
                        return;
                    case -104:
                        VerticalTranslateLayout.this.PD.oL();
                        return;
                    case SapiErrorCode.INVALID_ARG /* -103 */:
                    case -102:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.PD.oK();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.PD.oJ();
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
            switch (VerticalTranslateLayout.this.Pv) {
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
                    if (VerticalTranslateLayout.this.PH != null) {
                        VerticalTranslateLayout.this.PH.aU(i);
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
                int i2 = VerticalTranslateLayout.this.Ps - i;
                switch (VerticalTranslateLayout.this.Pv) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Po - VerticalTranslateLayout.this.KZ && i2 < 0) {
                            VerticalTranslateLayout.this.Ps -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.KZ - VerticalTranslateLayout.this.Pq && i2 > 0) {
                            VerticalTranslateLayout.this.Ps -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Po - VerticalTranslateLayout.this.KZ && i2 <= VerticalTranslateLayout.this.KZ - VerticalTranslateLayout.this.Pq) {
                            VerticalTranslateLayout.this.Ps -= i;
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
            switch (VerticalTranslateLayout.this.Pv) {
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
            int i = VerticalTranslateLayout.this.Ps;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Po - VerticalTranslateLayout.this.KZ) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.PD.R(f);
                } else {
                    VerticalTranslateLayout.this.PD.P(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.KZ - VerticalTranslateLayout.this.Pq) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.PD.Q(f);
                } else {
                    VerticalTranslateLayout.this.PD.S(f);
                }
            }
        }

        private void U(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.PD.R(f);
            } else {
                VerticalTranslateLayout.this.PD.P(f);
            }
        }

        private void V(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.PD.Q(f);
            } else {
                VerticalTranslateLayout.this.PD.S(f);
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

        void oJ() {
            nu();
            if (this.Lz <= this.LB) {
                e eVar = VerticalTranslateLayout.this.PF;
                if (eVar != null) {
                    eVar.oO();
                }
                this.LG = false;
                VerticalTranslateLayout.this.Lh = 10000;
                VerticalTranslateLayout.this.nt();
                return;
            }
            VerticalTranslateLayout.this.Ps = (int) (com.baidu.adp.widget.a.a(this.LB, this.Lz, false) + this.LC);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PA.sendEmptyMessageAtTime(-100, this.LE);
        }

        void oK() {
            nu();
            if (this.Lz >= this.LB) {
                c cVar = VerticalTranslateLayout.this.PG;
                if (cVar != null) {
                    cVar.oN();
                }
                this.LG = false;
                VerticalTranslateLayout.this.Lh = 10001;
                VerticalTranslateLayout.this.nt();
                return;
            }
            VerticalTranslateLayout.this.Ps = (int) (com.baidu.adp.widget.a.a(this.LB, this.Lz, false) + this.LC);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PA.sendEmptyMessageAtTime(-101, this.LE);
        }

        void oL() {
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
            VerticalTranslateLayout.this.Ps = (int) (com.baidu.adp.widget.a.a(this.LB, this.Lz, false) + this.LC);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PA.sendEmptyMessageAtTime(-104, this.LE);
        }

        void oM() {
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
            VerticalTranslateLayout.this.Ps = (int) (com.baidu.adp.widget.a.a(this.LB, this.Lz, false) + this.LC);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.PA.sendEmptyMessageAtTime(-105, this.LE);
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
            this.LB = 0 - VerticalTranslateLayout.this.Ps;
            this.LC = VerticalTranslateLayout.this.Ps;
            VerticalTranslateLayout.this.PA.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.LB);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.PA.sendEmptyMessageAtTime(-104, this.LE);
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
            this.LB = 0 - VerticalTranslateLayout.this.Ps;
            this.LC = VerticalTranslateLayout.this.Ps;
            BdLog.d("Animator@animateBottomOpen " + this.LB);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.PA.removeMessages(-105);
            VerticalTranslateLayout.this.PA.sendEmptyMessageAtTime(-105, this.LE);
        }

        void R(float f) {
            e eVar = VerticalTranslateLayout.this.PF;
            if (eVar != null) {
                eVar.nz();
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = ((-VerticalTranslateLayout.this.KZ) + VerticalTranslateLayout.this.Po) - VerticalTranslateLayout.this.Ps;
            this.LC = VerticalTranslateLayout.this.Ps;
            BdLog.d("Animator@animateTop " + this.LB);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.PA.removeMessages(-100);
            VerticalTranslateLayout.this.PA.sendEmptyMessageAtTime(-100, this.LE);
        }

        void S(float f) {
            c cVar = VerticalTranslateLayout.this.PG;
            if (cVar != null) {
                cVar.nD();
            }
            this.LG = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.LD = uptimeMillis;
            this.LE = uptimeMillis + 16;
            this.LA = f;
            this.Lz = 0.0f;
            this.LB = (VerticalTranslateLayout.this.KZ - VerticalTranslateLayout.this.Pq) - VerticalTranslateLayout.this.Ps;
            this.LC = VerticalTranslateLayout.this.Ps;
            BdLog.d("Animator@animateBottom " + this.LB);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.PA.removeMessages(-101);
            VerticalTranslateLayout.this.PA.sendEmptyMessageAtTime(-101, this.LE);
        }
    }
}
