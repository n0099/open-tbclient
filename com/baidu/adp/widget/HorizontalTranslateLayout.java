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
import com.baidu.ar.util.Constants;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int DH;
    private float DJ;
    private float DK;
    private int DL;
    private final int DM;
    private boolean DN;
    private boolean DO;
    private TrackDirection DQ;
    private int DR;
    private final Rect DS;
    private final Rect DT;
    private final Paint DU;
    private int DV;
    private int DW;
    private int DX;
    private boolean DY;
    private final a DZ;
    private final b Ea;
    private final g Eb;
    private d Ec;
    private f Ed;
    private final List<e> Ee;
    private c Ef;

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
        void aA(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kb();

        void kc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kd();

        void ke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void kf();

        void kg();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.DS = new Rect();
        this.DT = new Rect();
        this.Ee = new ArrayList();
        this.DZ = new a();
        this.Ea = new b();
        this.Eb = new g();
        this.DR = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
        Resources resources = getResources();
        this.DU = new Paint();
        this.DU.setColor(-1);
        this.DM = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.DJ = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.DK = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.DJ != -1.0f && this.DK != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.DQ = TrackDirection.horizontal;
            } else if (this.DK != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.DQ = TrackDirection.right;
            } else if (this.DJ != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.DQ = TrackDirection.left;
            } else {
                this.DQ = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.DJ != -1.0f) {
                    this.DN = true;
                } else if ("right".equals(str) && this.DK != -1.0f) {
                    this.DO = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.DU.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.DU.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.DL = (int) ((this.DJ - this.DH) * (-f2));
            } else if (f2 > 0.0f) {
                this.DL = (int) ((this.DH - this.DK) * f2);
            } else if (f2 == 0.0f) {
                this.DL = 0;
                this.DR = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.DJ -= getMeasuredWidth();
                this.DR = 10000;
            } else if (f2 == 1.0f) {
                this.DJ = getMeasuredWidth() - this.DK;
                this.DR = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.DJ;
    }

    public int getRightOffset() {
        return (int) this.DK;
    }

    public void setLeftTapBack(boolean z) {
        this.DN = z;
    }

    public void setRightTapBack(boolean z) {
        this.DO = z;
    }

    public int getState() {
        return this.DR;
    }

    public void setLeftAnimationListener(d dVar) {
        this.Ec = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.Ed = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Ef = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.DL, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.DL);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.DU);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.DL;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.DQ == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.DR == 10004) {
            switch (action) {
                case 0:
                    this.DV = x;
                    this.DW = y;
                    this.DZ.removeMessages(-100);
                    this.DZ.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.DZ.removeMessages(-101);
                    this.DZ.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.DL, 0.0f);
                    return o(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i2 >= this.DW - this.DM && i2 <= this.DW + this.DM && (i < this.DV - this.DM || i > this.DV + this.DM) && this.Eb.aB(i - this.DV);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.DR == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.DY = false;
                    if (this.Eb.Er) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.Eb.kh();
                        this.Eb.ki();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Eb.Er) {
                        if (!this.DY) {
                            if (x > this.DV) {
                                this.DX = this.DV + this.DM;
                                this.DY = true;
                            } else {
                                this.DX = this.DV - this.DM;
                                this.DY = true;
                            }
                        }
                        this.Eb.aC(this.DX - x);
                        this.DX = x;
                        this.Eb.Eq.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.DS);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.DT);
        switch (action) {
            case 0:
                if ((this.DR != 10000 || !this.DS.contains(x, y)) && (this.DR != 10001 || !this.DT.contains(x, y))) {
                    return false;
                }
                if (!this.Eb.Er) {
                    this.DX = x;
                    this.Eb.aB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Eb.Er) {
                    this.Eb.kh();
                    this.Eb.ki();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Eb.Er) {
            this.Eb.aC(this.DX - x);
            this.DX = x;
            this.Eb.Eq.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.DJ != -1.0f) {
                this.DS.set(i, i2, (int) (i + this.DJ), i4);
            }
            if (this.DK != -1.0f) {
                this.DT.set((int) (i3 - this.DK), i2, i3, i4);
            }
        }
        if (!this.Ea.Ep && !this.Eb.Er) {
            jW();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.DJ) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.DK) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.DH = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW() {
        switch (this.DR) {
            case 10000:
                this.DL = (int) (this.DJ - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.DL = (int) (getMeasuredWidth() - this.DK);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.DL = 0;
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
            if (HorizontalTranslateLayout.this.Ea.Ep) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.Ea.ka();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.Ea.jZ();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.Ea.jY();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.Ea.jX();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Eq;
        boolean Er;
        final int Es;
        final int Et;

        g() {
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Es = (int) ((200.0f * f) + 0.5f);
            this.Et = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aB(int i) {
            switch (HorizontalTranslateLayout.this.DQ) {
                case left:
                    if (HorizontalTranslateLayout.this.DR != 10004 && HorizontalTranslateLayout.this.DR != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.DR != 10004 && HorizontalTranslateLayout.this.DR != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Ef != null) {
                        HorizontalTranslateLayout.this.Ef.aA(i);
                        break;
                    }
                    break;
            }
            this.Eq = VelocityTracker.obtain();
            this.Er = true;
            return true;
        }

        void kh() {
            this.Er = false;
        }

        void aC(int i) {
            if (this.Er) {
                int i2 = HorizontalTranslateLayout.this.DL - i;
                switch (HorizontalTranslateLayout.this.DQ) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.DJ - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.DL -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.DK && i2 > 0) {
                            HorizontalTranslateLayout.this.DL -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.DJ - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.DK) {
                            HorizontalTranslateLayout.this.DL -= i;
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
        public void ki() {
            float max;
            this.Eq.computeCurrentVelocity(this.Es);
            float xVelocity = this.Eq.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Et);
            } else {
                max = Math.max(xVelocity, this.Et);
            }
            switch (HorizontalTranslateLayout.this.DQ) {
                case left:
                    w(max);
                    break;
                case right:
                    A(max);
                    break;
                case horizontal:
                    v(max);
                    break;
            }
            this.Eq.recycle();
            this.Eq = null;
        }

        private void v(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.DL;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.DJ - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Ea.t(f);
                } else {
                    HorizontalTranslateLayout.this.Ea.r(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.DK) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.Ea.s(f);
                } else {
                    HorizontalTranslateLayout.this.Ea.u(f);
                }
            }
        }

        private void w(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Ea.t(f);
            } else {
                HorizontalTranslateLayout.this.Ea.r(f);
            }
        }

        private void A(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.Ea.s(f);
            } else {
                HorizontalTranslateLayout.this.Ea.u(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Ei;
        float Ej;
        float Ek;
        float El;
        float Em;
        long En;
        long Eo;
        boolean Ep;

        b() {
            this.Ei = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = ((((float) (uptimeMillis - this.En)) / 1000.0f) * this.Ek) + this.Ej;
            this.En = uptimeMillis;
            this.Eo += 16;
        }

        void jX() {
            compute();
            if (this.Ej <= this.El) {
                d dVar = HorizontalTranslateLayout.this.Ec;
                if (dVar != null) {
                    dVar.kc();
                }
                this.Ep = false;
                HorizontalTranslateLayout.this.DR = 10000;
                HorizontalTranslateLayout.this.jW();
                return;
            }
            HorizontalTranslateLayout.this.DL = (int) (com.baidu.adp.widget.d.a(this.El, this.Ej, false) + this.Em);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.DZ.sendEmptyMessageAtTime(-100, this.Eo);
        }

        void jY() {
            compute();
            if (this.Ej >= this.El) {
                f fVar = HorizontalTranslateLayout.this.Ed;
                if (fVar != null) {
                    fVar.kg();
                }
                this.Ep = false;
                HorizontalTranslateLayout.this.DR = 10001;
                HorizontalTranslateLayout.this.jW();
                return;
            }
            HorizontalTranslateLayout.this.DL = (int) (com.baidu.adp.widget.d.a(this.El, this.Ej, false) + this.Em);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.DZ.sendEmptyMessageAtTime(-101, this.Eo);
        }

        void jZ() {
            compute();
            if (this.Ej >= this.El) {
                for (e eVar : HorizontalTranslateLayout.this.Ee) {
                    if (eVar != null) {
                        eVar.ke();
                    }
                }
                this.Ep = false;
                HorizontalTranslateLayout.this.DR = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                HorizontalTranslateLayout.this.jW();
                return;
            }
            HorizontalTranslateLayout.this.DL = (int) (com.baidu.adp.widget.d.a(this.El, this.Ej, false) + this.Em);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.DZ.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Eo);
        }

        void ka() {
            compute();
            if (this.Ej <= this.El) {
                for (e eVar : HorizontalTranslateLayout.this.Ee) {
                    if (eVar != null) {
                        eVar.ke();
                    }
                }
                this.Ep = false;
                HorizontalTranslateLayout.this.DR = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                HorizontalTranslateLayout.this.jW();
                return;
            }
            HorizontalTranslateLayout.this.DL = (int) (com.baidu.adp.widget.d.a(this.El, this.Ej, false) + this.Em);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.DZ.sendEmptyMessageAtTime(-105, this.Eo);
        }

        void r(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Ee) {
                if (eVar != null) {
                    eVar.kd();
                }
            }
            this.Ep = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.En = uptimeMillis;
            this.Eo = uptimeMillis + 16;
            this.Ek = f;
            this.Ej = 0.0f;
            this.El = 0 - HorizontalTranslateLayout.this.DL;
            this.Em = HorizontalTranslateLayout.this.DL;
            HorizontalTranslateLayout.this.DZ.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.El);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.DZ.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Eo);
        }

        void s(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Ee) {
                if (eVar != null) {
                    eVar.kd();
                }
            }
            this.Ep = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.En = uptimeMillis;
            this.Eo = uptimeMillis + 16;
            this.Ek = f;
            this.Ej = 0.0f;
            this.El = 0 - HorizontalTranslateLayout.this.DL;
            this.Em = HorizontalTranslateLayout.this.DL;
            BdLog.d("Animator@animateBottomOpen " + this.El);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.DZ.removeMessages(-105);
            HorizontalTranslateLayout.this.DZ.sendEmptyMessageAtTime(-105, this.Eo);
        }

        void t(float f) {
            d dVar = HorizontalTranslateLayout.this.Ec;
            if (dVar != null) {
                dVar.kb();
            }
            this.Ep = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.En = uptimeMillis;
            this.Eo = uptimeMillis + 16;
            this.Ek = f;
            this.Ej = 0.0f;
            this.El = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.DJ) - HorizontalTranslateLayout.this.DL;
            this.Em = HorizontalTranslateLayout.this.DL;
            BdLog.d("Animator@animateTop " + this.El);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.DZ.removeMessages(-100);
            HorizontalTranslateLayout.this.DZ.sendEmptyMessageAtTime(-100, this.Eo);
        }

        void u(float f) {
            f fVar = HorizontalTranslateLayout.this.Ed;
            if (fVar != null) {
                fVar.kf();
            }
            this.Ep = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.En = uptimeMillis;
            this.Eo = uptimeMillis + 16;
            this.Ek = f;
            this.Ej = 0.0f;
            this.El = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.DK) - HorizontalTranslateLayout.this.DL;
            this.Em = HorizontalTranslateLayout.this.DL;
            BdLog.d("Animator@animateBottom " + this.El);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.DZ.removeMessages(-101);
            HorizontalTranslateLayout.this.DZ.sendEmptyMessageAtTime(-101, this.Eo);
        }
    }
}
