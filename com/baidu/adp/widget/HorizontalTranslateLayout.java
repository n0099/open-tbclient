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
    private int DD;
    private float DF;
    private float DG;
    private int DH;
    private final int DI;
    private boolean DJ;
    private boolean DK;
    private TrackDirection DL;
    private int DM;
    private final Rect DN;
    private final Rect DO;
    private final Paint DQ;
    private int DR;
    private int DS;
    private int DT;
    private boolean DU;
    private final a DV;
    private final b DW;
    private final g DX;
    private d DY;
    private f DZ;
    private final List<e> Ea;
    private c Eb;

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
        void ka();

        void kb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kc();

        void kd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void ke();

        void kf();
    }

    static {
        $assertionsDisabled = !HorizontalTranslateLayout.class.desiredAssertionStatus();
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.DN = new Rect();
        this.DO = new Rect();
        this.Ea = new ArrayList();
        this.DV = new a();
        this.DW = new b();
        this.DX = new g();
        this.DM = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
        Resources resources = getResources();
        this.DQ = new Paint();
        this.DQ.setColor(-1);
        this.DI = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.DF = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.DG = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.DF != -1.0f && this.DG != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.DL = TrackDirection.horizontal;
            } else if (this.DG != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.DL = TrackDirection.right;
            } else if (this.DF != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.DL = TrackDirection.left;
            } else {
                this.DL = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if (CustomDialogData.POS_LEFT.equals(str) && this.DF != -1.0f) {
                    this.DJ = true;
                } else if ("right".equals(str) && this.DG != -1.0f) {
                    this.DK = true;
                } else {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.DQ.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.DQ.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.DH = (int) ((this.DF - this.DD) * (-f2));
            } else if (f2 > 0.0f) {
                this.DH = (int) ((this.DD - this.DG) * f2);
            } else if (f2 == 0.0f) {
                this.DH = 0;
                this.DM = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.DF -= getMeasuredWidth();
                this.DM = 10000;
            } else if (f2 == 1.0f) {
                this.DF = getMeasuredWidth() - this.DG;
                this.DM = 10001;
            }
            invalidate();
        }
    }

    public int getLeftOffset() {
        return (int) this.DF;
    }

    public int getRightOffset() {
        return (int) this.DG;
    }

    public void setLeftTapBack(boolean z) {
        this.DJ = z;
    }

    public void setRightTapBack(boolean z) {
        this.DK = z;
    }

    public int getState() {
        return this.DM;
    }

    public void setLeftAnimationListener(d dVar) {
        this.DY = dVar;
    }

    public void setRightAnimationListener(f fVar) {
        this.DZ = fVar;
    }

    public void setHorizontalTrackListener(c cVar) {
        this.Eb = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.DH, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.DH);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.DQ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftTranslate() {
        return this.DH;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.DL == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.DM == 10004) {
            switch (action) {
                case 0:
                    this.DR = x;
                    this.DS = y;
                    this.DV.removeMessages(-100);
                    this.DV.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.DV.removeMessages(-101);
                    this.DV.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(-this.DH, 0.0f);
                    return o(x, y);
            }
        }
        BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i2 >= this.DS - this.DI && i2 <= this.DS + this.DI && (i < this.DR - this.DI || i > this.DR + this.DI) && this.DX.aB(i - this.DR);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.DM == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                    this.DU = false;
                    if (this.DX.En) {
                        BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                        this.DX.kg();
                        this.DX.kh();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.DX.En) {
                        if (!this.DU) {
                            if (x > this.DR) {
                                this.DT = this.DR + this.DI;
                                this.DU = true;
                            } else {
                                this.DT = this.DR - this.DI;
                                this.DU = true;
                            }
                        }
                        this.DX.aC(this.DT - x);
                        this.DT = x;
                        this.DX.Em.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.DN);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.DO);
        switch (action) {
            case 0:
                if ((this.DM != 10000 || !this.DN.contains(x, y)) && (this.DM != 10001 || !this.DO.contains(x, y))) {
                    return false;
                }
                if (!this.DX.En) {
                    this.DT = x;
                    this.DX.aB(x);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.DX.En) {
                    this.DX.kg();
                    this.DX.kh();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.DX.En) {
            this.DX.aC(this.DT - x);
            this.DT = x;
            this.DX.Em.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.DF != -1.0f) {
                this.DN.set(i, i2, (int) (i + this.DF), i4);
            }
            if (this.DG != -1.0f) {
                this.DO.set((int) (i3 - this.DG), i2, i3, i4);
            }
        }
        if (!this.DW.El && !this.DX.En) {
            jV();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i;
        if (!$assertionsDisabled && i3 < this.DF) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.DG) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.DD = getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jV() {
        switch (this.DM) {
            case 10000:
                this.DH = (int) (this.DF - getMeasuredWidth());
                invalidate();
                return;
            case 10001:
                this.DH = (int) (getMeasuredWidth() - this.DG);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.DH = 0;
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
            if (HorizontalTranslateLayout.this.DW.El) {
                switch (message.what) {
                    case -105:
                        HorizontalTranslateLayout.this.DW.jZ();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        HorizontalTranslateLayout.this.DW.jY();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        HorizontalTranslateLayout.this.DW.jX();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        HorizontalTranslateLayout.this.DW.jW();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        VelocityTracker Em;
        boolean En;
        final int Eo;
        final int Ep;

        g() {
            float f = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Eo = (int) ((200.0f * f) + 0.5f);
            this.Ep = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aB(int i) {
            switch (HorizontalTranslateLayout.this.DL) {
                case left:
                    if (HorizontalTranslateLayout.this.DM != 10004 && HorizontalTranslateLayout.this.DM != 10000) {
                        return false;
                    }
                    break;
                case right:
                    if (HorizontalTranslateLayout.this.DM != 10004 && HorizontalTranslateLayout.this.DM != 10001) {
                        return false;
                    }
                    break;
                case horizontal:
                    if (HorizontalTranslateLayout.this.Eb != null) {
                        HorizontalTranslateLayout.this.Eb.aA(i);
                        break;
                    }
                    break;
            }
            this.Em = VelocityTracker.obtain();
            this.En = true;
            return true;
        }

        void kg() {
            this.En = false;
        }

        void aC(int i) {
            if (this.En) {
                int i2 = HorizontalTranslateLayout.this.DH - i;
                switch (HorizontalTranslateLayout.this.DL) {
                    case left:
                        BdLog.d("HorizontalTranslateLayout@move left");
                        if (i2 > HorizontalTranslateLayout.this.DF - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 < 0) {
                            HorizontalTranslateLayout.this.DH -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case right:
                        BdLog.d("HorizontalTranslateLayout@move right");
                        if (i2 < HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.DG && i2 > 0) {
                            HorizontalTranslateLayout.this.DH -= i;
                            HorizontalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case horizontal:
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        if (i2 >= HorizontalTranslateLayout.this.DF - HorizontalTranslateLayout.this.getMeasuredWidth() && i2 <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.DG) {
                            HorizontalTranslateLayout.this.DH -= i;
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
        public void kh() {
            float max;
            this.Em.computeCurrentVelocity(this.Eo);
            float xVelocity = this.Em.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.Ep);
            } else {
                max = Math.max(xVelocity, this.Ep);
            }
            switch (HorizontalTranslateLayout.this.DL) {
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
            this.Em.recycle();
            this.Em = null;
        }

        private void v(float f) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.DH;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.DF - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.DW.t(f);
                } else {
                    HorizontalTranslateLayout.this.DW.r(f);
                }
            } else if (i >= 0 && i <= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.DG) {
                if (f < 0.0f) {
                    HorizontalTranslateLayout.this.DW.s(f);
                } else {
                    HorizontalTranslateLayout.this.DW.u(f);
                }
            }
        }

        private void w(float f) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.DW.t(f);
            } else {
                HorizontalTranslateLayout.this.DW.r(f);
            }
        }

        private void A(float f) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f < 0.0f) {
                HorizontalTranslateLayout.this.DW.s(f);
            } else {
                HorizontalTranslateLayout.this.DW.u(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        final float Ee;
        float Ef;
        float Eg;
        float Eh;
        float Ei;
        long Ej;
        long Ek;
        boolean El;

        b() {
            this.Ee = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ef = ((((float) (uptimeMillis - this.Ej)) / 1000.0f) * this.Eg) + this.Ef;
            this.Ej = uptimeMillis;
            this.Ek += 16;
        }

        void jW() {
            compute();
            if (this.Ef <= this.Eh) {
                d dVar = HorizontalTranslateLayout.this.DY;
                if (dVar != null) {
                    dVar.kb();
                }
                this.El = false;
                HorizontalTranslateLayout.this.DM = 10000;
                HorizontalTranslateLayout.this.jV();
                return;
            }
            HorizontalTranslateLayout.this.DH = (int) (com.baidu.adp.widget.d.a(this.Eh, this.Ef, false) + this.Ei);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.DV.sendEmptyMessageAtTime(-100, this.Ek);
        }

        void jX() {
            compute();
            if (this.Ef >= this.Eh) {
                f fVar = HorizontalTranslateLayout.this.DZ;
                if (fVar != null) {
                    fVar.kf();
                }
                this.El = false;
                HorizontalTranslateLayout.this.DM = 10001;
                HorizontalTranslateLayout.this.jV();
                return;
            }
            HorizontalTranslateLayout.this.DH = (int) (com.baidu.adp.widget.d.a(this.Eh, this.Ef, false) + this.Ei);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.DV.sendEmptyMessageAtTime(-101, this.Ek);
        }

        void jY() {
            compute();
            if (this.Ef >= this.Eh) {
                for (e eVar : HorizontalTranslateLayout.this.Ea) {
                    if (eVar != null) {
                        eVar.kd();
                    }
                }
                this.El = false;
                HorizontalTranslateLayout.this.DM = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                HorizontalTranslateLayout.this.jV();
                return;
            }
            HorizontalTranslateLayout.this.DH = (int) (com.baidu.adp.widget.d.a(this.Eh, this.Ef, false) + this.Ei);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.DV.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ek);
        }

        void jZ() {
            compute();
            if (this.Ef <= this.Eh) {
                for (e eVar : HorizontalTranslateLayout.this.Ea) {
                    if (eVar != null) {
                        eVar.kd();
                    }
                }
                this.El = false;
                HorizontalTranslateLayout.this.DM = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                HorizontalTranslateLayout.this.jV();
                return;
            }
            HorizontalTranslateLayout.this.DH = (int) (com.baidu.adp.widget.d.a(this.Eh, this.Ef, false) + this.Ei);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.DV.sendEmptyMessageAtTime(-105, this.Ek);
        }

        void r(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Ea) {
                if (eVar != null) {
                    eVar.kc();
                }
            }
            this.El = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = uptimeMillis;
            this.Ek = uptimeMillis + 16;
            this.Eg = f;
            this.Ef = 0.0f;
            this.Eh = 0 - HorizontalTranslateLayout.this.DH;
            this.Ei = HorizontalTranslateLayout.this.DH;
            HorizontalTranslateLayout.this.DV.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Eh);
            BdLog.d("Animator@animateTopOpen " + f);
            HorizontalTranslateLayout.this.DV.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ek);
        }

        void s(float f) {
            for (e eVar : HorizontalTranslateLayout.this.Ea) {
                if (eVar != null) {
                    eVar.kc();
                }
            }
            this.El = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = uptimeMillis;
            this.Ek = uptimeMillis + 16;
            this.Eg = f;
            this.Ef = 0.0f;
            this.Eh = 0 - HorizontalTranslateLayout.this.DH;
            this.Ei = HorizontalTranslateLayout.this.DH;
            BdLog.d("Animator@animateBottomOpen " + this.Eh);
            BdLog.d("Animator@animateBottomOpen " + f);
            HorizontalTranslateLayout.this.DV.removeMessages(-105);
            HorizontalTranslateLayout.this.DV.sendEmptyMessageAtTime(-105, this.Ek);
        }

        void t(float f) {
            d dVar = HorizontalTranslateLayout.this.DY;
            if (dVar != null) {
                dVar.ka();
            }
            this.El = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = uptimeMillis;
            this.Ek = uptimeMillis + 16;
            this.Eg = f;
            this.Ef = 0.0f;
            this.Eh = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.DF) - HorizontalTranslateLayout.this.DH;
            this.Ei = HorizontalTranslateLayout.this.DH;
            BdLog.d("Animator@animateTop " + this.Eh);
            BdLog.d("Animator@animateTop " + f);
            HorizontalTranslateLayout.this.DV.removeMessages(-100);
            HorizontalTranslateLayout.this.DV.sendEmptyMessageAtTime(-100, this.Ek);
        }

        void u(float f) {
            f fVar = HorizontalTranslateLayout.this.DZ;
            if (fVar != null) {
                fVar.ke();
            }
            this.El = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = uptimeMillis;
            this.Ek = uptimeMillis + 16;
            this.Eg = f;
            this.Ef = 0.0f;
            this.Eh = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.DG) - HorizontalTranslateLayout.this.DH;
            this.Ei = HorizontalTranslateLayout.this.DH;
            BdLog.d("Animator@animateBottom " + this.Eh);
            BdLog.d("Animator@animateBottom " + f);
            HorizontalTranslateLayout.this.DV.removeMessages(-101);
            HorizontalTranslateLayout.this.DV.sendEmptyMessageAtTime(-101, this.Ek);
        }
    }
}
