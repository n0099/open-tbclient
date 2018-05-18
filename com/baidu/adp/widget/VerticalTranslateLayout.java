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
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int DD;
    private int DE;
    private final int DI;
    private int DM;
    private final Paint DQ;
    private int DR;
    private int DS;
    private final List<d> Ea;
    private float Ha;
    private float Hb;
    private float Hc;
    private float Hd;
    private int He;
    private boolean Hf;
    private boolean Hg;
    private TrackDirection Hh;
    private final Rect Hi;
    private final Rect Hj;
    private int Hk;
    private boolean Hl;
    private final a Hm;
    private final b Hn;
    private final g Ho;
    private e Hp;
    private c Hq;
    private f Hr;

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
        void ke();

        void la();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kc();

        void kd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void ka();

        void lb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aO(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.Hi = new Rect();
        this.Hj = new Rect();
        this.Ea = new ArrayList();
        this.Hm = new a();
        this.Hn = new b();
        this.Ho = new g();
        this.DM = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
        Resources resources = getResources();
        this.DQ = new Paint();
        this.DQ.setColor(-1);
        this.DI = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.Ha = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Hc = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Hb = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Hd = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (kU() && kV() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Hh = TrackDirection.vertical;
            } else if (kV() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Hh = TrackDirection.bottom;
            } else if (kU() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Hh = TrackDirection.top;
            } else {
                this.Hh = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.Ha != -1.0f) {
                    this.Hf = true;
                } else if ("bottom".equals(str) && this.Hc != -1.0f) {
                    this.Hg = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.DQ.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
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
                this.He = (int) ((this.Ha - this.DE) * (-f2));
            } else if (f2 > 0.0f) {
                this.He = (int) ((this.DE - this.Hc) * f2);
            } else if (f2 == 0.0f) {
                this.He = 0;
                this.DM = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.Ha -= this.DE;
                this.DM = 10000;
            } else if (f2 == 1.0f) {
                this.Ha = this.DE - this.Hc;
                this.DM = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Ha;
    }

    public int getBottomOffset() {
        return (int) this.Hc;
    }

    public void setTopTapBack(boolean z) {
        this.Hf = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Hg = z;
    }

    public int getState() {
        return this.DM;
    }

    public void setTopAnimationListener(e eVar) {
        this.Hp = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Hq = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Hr = fVar;
    }

    private boolean kU() {
        return (this.Ha == -1.0f && this.Hd == -1.0f) ? false : true;
    }

    private boolean kV() {
        return (this.Hc == -1.0f && this.Hb == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.He);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.He);
        canvas.drawRect(0.0f, 0.0f, this.DD, this.DE, this.DQ);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.He;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Hh == TrackDirection.none) {
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
                    this.Hm.removeMessages(-100);
                    this.Hm.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Hm.removeMessages(-101);
                    this.Hm.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.He);
                    return o(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i >= this.DR - this.DI && i <= this.DR + this.DI && (i2 < this.DS - this.DI || i2 > this.DS + this.DI) && this.Ho.aB(i2 - this.DS);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Hl = false;
                    if (this.Ho.En) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Ho.kg();
                        this.Ho.kh();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Ho.En) {
                        if (!this.Hl) {
                            if (y > this.DS) {
                                this.Hk = this.DS + this.DI;
                                this.Hl = true;
                            } else {
                                this.Hk = this.DS - this.DI;
                                this.Hl = true;
                            }
                        }
                        this.Ho.aC(this.Hk - y);
                        this.Hk = y;
                        this.Ho.Em.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.DM != 10000 || !this.Hi.contains(x, y)) && (this.DM != 10001 || !this.Hj.contains(x, y))) {
                    return false;
                }
                if (!this.Ho.En) {
                    this.Hk = y;
                    this.Ho.aB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Ho.En) {
                    this.Ho.kg();
                    this.Ho.kh();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Ho.En) {
            this.Ho.aC(this.Hk - y);
            this.Hk = y;
            this.Ho.Em.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Ha != -1.0f) {
                this.Hi.set(i, i2, i3, (int) (i2 + this.Ha));
            }
            if (this.Hc != -1.0f) {
                this.Hj.set(i, (int) (i4 - this.Hc), i3, i4);
            }
        }
        if (!this.Hn.El && !this.Ho.En) {
            jV();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Hb != -1.0f) {
            this.Ha = i3 - this.Hd;
        }
        if (this.Hd != -1.0f) {
            this.Hc = i3 - this.Hb;
        }
        if (!$assertionsDisabled && i3 < this.Ha) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Hc) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.DD = getMeasuredWidth();
        this.DE = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jV() {
        switch (this.DM) {
            case 10000:
                this.He = (int) (this.Ha - this.DE);
                invalidate();
                return;
            case 10001:
                this.He = (int) (this.DE - this.Hc);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.He = 0;
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
            if (VerticalTranslateLayout.this.Hn.El) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Hn.kZ();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Hn.kY();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Hn.kX();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.Hn.kW();
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
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Eo = (int) ((200.0f * f) + 0.5f);
            this.Ep = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aB(int i) {
            switch (VerticalTranslateLayout.this.Hh) {
                case top:
                    if (VerticalTranslateLayout.this.DM != 10004 && VerticalTranslateLayout.this.DM != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.DM != 10004 && VerticalTranslateLayout.this.DM != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Hr != null) {
                        VerticalTranslateLayout.this.Hr.aO(i);
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
                int i2 = VerticalTranslateLayout.this.He - i;
                switch (VerticalTranslateLayout.this.Hh) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.Ha - VerticalTranslateLayout.this.DE && i2 < 0) {
                            VerticalTranslateLayout.this.He -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.DE - VerticalTranslateLayout.this.Hc && i2 > 0) {
                            VerticalTranslateLayout.this.He -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.Ha - VerticalTranslateLayout.this.DE && i2 <= VerticalTranslateLayout.this.DE - VerticalTranslateLayout.this.Hc) {
                            VerticalTranslateLayout.this.He -= i;
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
        public void kh() {
            float max;
            this.Em.computeCurrentVelocity(this.Eo);
            float yVelocity = this.Em.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Ep);
            } else {
                max = Math.max(yVelocity, this.Ep);
            }
            switch (VerticalTranslateLayout.this.Hh) {
                case top:
                    K(max);
                    break;
                case bottom:
                    L(max);
                    break;
                case vertical:
                    J(max);
                    break;
            }
            this.Em.recycle();
            this.Em = null;
        }

        private void J(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.He;
            if (i <= 0 && i >= VerticalTranslateLayout.this.Ha - VerticalTranslateLayout.this.DE) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Hn.H(f);
                } else {
                    VerticalTranslateLayout.this.Hn.F(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.DE - VerticalTranslateLayout.this.Hc) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Hn.G(f);
                } else {
                    VerticalTranslateLayout.this.Hn.I(f);
                }
            }
        }

        private void K(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Hn.H(f);
            } else {
                VerticalTranslateLayout.this.Hn.F(f);
            }
        }

        private void L(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Hn.G(f);
            } else {
                VerticalTranslateLayout.this.Hn.I(f);
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
            this.Ee = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ef = ((((float) (uptimeMillis - this.Ej)) / 1000.0f) * this.Eg) + this.Ef;
            this.Ej = uptimeMillis;
            this.Ek += 16;
        }

        void kW() {
            compute();
            if (this.Ef <= this.Eh) {
                e eVar = VerticalTranslateLayout.this.Hp;
                if (eVar != null) {
                    eVar.lb();
                }
                this.El = false;
                VerticalTranslateLayout.this.DM = 10000;
                VerticalTranslateLayout.this.jV();
                return;
            }
            VerticalTranslateLayout.this.He = (int) (com.baidu.adp.widget.a.a(this.Eh, this.Ef, false) + this.Ei);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Hm.sendEmptyMessageAtTime(-100, this.Ek);
        }

        void kX() {
            compute();
            if (this.Ef >= this.Eh) {
                c cVar = VerticalTranslateLayout.this.Hq;
                if (cVar != null) {
                    cVar.la();
                }
                this.El = false;
                VerticalTranslateLayout.this.DM = 10001;
                VerticalTranslateLayout.this.jV();
                return;
            }
            VerticalTranslateLayout.this.He = (int) (com.baidu.adp.widget.a.a(this.Eh, this.Ef, false) + this.Ei);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Hm.sendEmptyMessageAtTime(-101, this.Ek);
        }

        void kY() {
            compute();
            if (this.Ef >= this.Eh) {
                for (d dVar : VerticalTranslateLayout.this.Ea) {
                    if (dVar != null) {
                        dVar.kd();
                    }
                }
                this.El = false;
                VerticalTranslateLayout.this.DM = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                VerticalTranslateLayout.this.jV();
                return;
            }
            VerticalTranslateLayout.this.He = (int) (com.baidu.adp.widget.a.a(this.Eh, this.Ef, false) + this.Ei);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Hm.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ek);
        }

        void kZ() {
            compute();
            if (this.Ef <= this.Eh) {
                for (d dVar : VerticalTranslateLayout.this.Ea) {
                    if (dVar != null) {
                        dVar.kd();
                    }
                }
                this.El = false;
                VerticalTranslateLayout.this.DM = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                VerticalTranslateLayout.this.jV();
                return;
            }
            VerticalTranslateLayout.this.He = (int) (com.baidu.adp.widget.a.a(this.Eh, this.Ef, false) + this.Ei);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Hm.sendEmptyMessageAtTime(-105, this.Ek);
        }

        void F(float f) {
            for (d dVar : VerticalTranslateLayout.this.Ea) {
                if (dVar != null) {
                    dVar.kc();
                }
            }
            this.El = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = uptimeMillis;
            this.Ek = uptimeMillis + 16;
            this.Eg = f;
            this.Ef = 0.0f;
            this.Eh = 0 - VerticalTranslateLayout.this.He;
            this.Ei = VerticalTranslateLayout.this.He;
            VerticalTranslateLayout.this.Hm.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.Eh);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Hm.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Ek);
        }

        void G(float f) {
            for (d dVar : VerticalTranslateLayout.this.Ea) {
                if (dVar != null) {
                    dVar.kc();
                }
            }
            this.El = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = uptimeMillis;
            this.Ek = uptimeMillis + 16;
            this.Eg = f;
            this.Ef = 0.0f;
            this.Eh = 0 - VerticalTranslateLayout.this.He;
            this.Ei = VerticalTranslateLayout.this.He;
            BdLog.d("Animator@animateBottomOpen " + this.Eh);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Hm.removeMessages(-105);
            VerticalTranslateLayout.this.Hm.sendEmptyMessageAtTime(-105, this.Ek);
        }

        void H(float f) {
            e eVar = VerticalTranslateLayout.this.Hp;
            if (eVar != null) {
                eVar.ka();
            }
            this.El = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = uptimeMillis;
            this.Ek = uptimeMillis + 16;
            this.Eg = f;
            this.Ef = 0.0f;
            this.Eh = ((-VerticalTranslateLayout.this.DE) + VerticalTranslateLayout.this.Ha) - VerticalTranslateLayout.this.He;
            this.Ei = VerticalTranslateLayout.this.He;
            BdLog.d("Animator@animateTop " + this.Eh);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Hm.removeMessages(-100);
            VerticalTranslateLayout.this.Hm.sendEmptyMessageAtTime(-100, this.Ek);
        }

        void I(float f) {
            c cVar = VerticalTranslateLayout.this.Hq;
            if (cVar != null) {
                cVar.ke();
            }
            this.El = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = uptimeMillis;
            this.Ek = uptimeMillis + 16;
            this.Eg = f;
            this.Ef = 0.0f;
            this.Eh = (VerticalTranslateLayout.this.DE - VerticalTranslateLayout.this.Hc) - VerticalTranslateLayout.this.He;
            this.Ei = VerticalTranslateLayout.this.He;
            BdLog.d("Animator@animateBottom " + this.Eh);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Hm.removeMessages(-101);
            VerticalTranslateLayout.this.Hm.sendEmptyMessageAtTime(-101, this.Ek);
        }
    }
}
