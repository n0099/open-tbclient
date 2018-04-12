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
    private int DH;
    private int DI;
    private final int DM;
    private int DR;
    private final Paint DU;
    private int DV;
    private int DW;
    private final List<d> Ee;
    private float He;
    private float Hf;
    private float Hg;
    private float Hh;
    private int Hi;
    private boolean Hj;
    private boolean Hk;
    private TrackDirection Hl;
    private final Rect Hm;
    private final Rect Hn;
    private int Ho;
    private boolean Hp;
    private final a Hq;
    private final b Hr;
    private final g Hs;
    private e Ht;
    private c Hu;
    private f Hv;

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
        void kf();

        void lb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kd();

        void ke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kb();

        void lc();
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
        this.Hm = new Rect();
        this.Hn = new Rect();
        this.Ee = new ArrayList();
        this.Hq = new a();
        this.Hr = new b();
        this.Hs = new g();
        this.DR = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
        Resources resources = getResources();
        this.DU = new Paint();
        this.DU.setColor(-1);
        this.DM = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        b(attributeSet);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.He = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.Hg = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.Hf = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.Hh = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (kV() && kW() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.Hl = TrackDirection.vertical;
            } else if (kW() && "bottom".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.Hl = TrackDirection.bottom;
            } else if (kV() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.Hl = TrackDirection.top;
            } else {
                this.Hl = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            String[] split = string2.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            for (String str : split) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ("top".equals(str) && this.He != -1.0f) {
                    this.Hj = true;
                } else if ("bottom".equals(str) && this.Hg != -1.0f) {
                    this.Hk = true;
                } else {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.DU.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
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
                this.Hi = (int) ((this.He - this.DI) * (-f2));
            } else if (f2 > 0.0f) {
                this.Hi = (int) ((this.DI - this.Hg) * f2);
            } else if (f2 == 0.0f) {
                this.Hi = 0;
                this.DR = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
            } else if (f2 == -1.0f) {
                this.He -= this.DI;
                this.DR = 10000;
            } else if (f2 == 1.0f) {
                this.He = this.DI - this.Hg;
                this.DR = 10001;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.He;
    }

    public int getBottomOffset() {
        return (int) this.Hg;
    }

    public void setTopTapBack(boolean z) {
        this.Hj = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Hk = z;
    }

    public int getState() {
        return this.DR;
    }

    public void setTopAnimationListener(e eVar) {
        this.Ht = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Hu = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Hv = fVar;
    }

    private boolean kV() {
        return (this.He == -1.0f && this.Hh == -1.0f) ? false : true;
    }

    private boolean kW() {
        return (this.Hg == -1.0f && this.Hf == -1.0f) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Hi);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Hi);
        canvas.drawRect(0.0f, 0.0f, this.DH, this.DI, this.DU);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Hi;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Hl == TrackDirection.none) {
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
                    this.Hq.removeMessages(-100);
                    this.Hq.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
                    this.Hq.removeMessages(-101);
                    this.Hq.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Hi);
                    return o(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean o(int i, int i2) {
        return i >= this.DV - this.DM && i <= this.DV + this.DM && (i2 < this.DW - this.DM || i2 > this.DW + this.DM) && this.Hs.aB(i2 - this.DW);
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
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Hp = false;
                    if (this.Hs.Er) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Hs.kh();
                        this.Hs.ki();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Hs.Er) {
                        if (!this.Hp) {
                            if (y > this.DW) {
                                this.Ho = this.DW + this.DM;
                                this.Hp = true;
                            } else {
                                this.Ho = this.DW - this.DM;
                                this.Hp = true;
                            }
                        }
                        this.Hs.aC(this.Ho - y);
                        this.Ho = y;
                        this.Hs.Eq.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.DR != 10000 || !this.Hm.contains(x, y)) && (this.DR != 10001 || !this.Hn.contains(x, y))) {
                    return false;
                }
                if (!this.Hs.Er) {
                    this.Ho = y;
                    this.Hs.aB(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Hs.Er) {
                    this.Hs.kh();
                    this.Hs.ki();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Hs.Er) {
            this.Hs.aC(this.Ho - y);
            this.Ho = y;
            this.Hs.Eq.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.He != -1.0f) {
                this.Hm.set(i, i2, i3, (int) (i2 + this.He));
            }
            if (this.Hg != -1.0f) {
                this.Hn.set(i, (int) (i4 - this.Hg), i3, i4);
            }
        }
        if (!this.Hr.Ep && !this.Hs.Er) {
            jW();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Hf != -1.0f) {
            this.He = i3 - this.Hh;
        }
        if (this.Hh != -1.0f) {
            this.Hg = i3 - this.Hf;
        }
        if (!$assertionsDisabled && i3 < this.He) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Hg) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.DH = getMeasuredWidth();
        this.DI = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW() {
        switch (this.DR) {
            case 10000:
                this.Hi = (int) (this.He - this.DI);
                invalidate();
                return;
            case 10001:
                this.Hi = (int) (this.DI - this.Hg);
                invalidate();
                return;
            case 10002:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE /* 10004 */:
                this.Hi = 0;
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
            if (VerticalTranslateLayout.this.Hr.Ep) {
                switch (message.what) {
                    case -105:
                        VerticalTranslateLayout.this.Hr.la();
                        return;
                    case SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED /* -104 */:
                        VerticalTranslateLayout.this.Hr.kZ();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        VerticalTranslateLayout.this.Hr.kY();
                        return;
                    case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                        VerticalTranslateLayout.this.Hr.kX();
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
            float f = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.Es = (int) ((200.0f * f) + 0.5f);
            this.Et = (int) ((f * 500.0f) + 0.5f);
        }

        boolean aB(int i) {
            switch (VerticalTranslateLayout.this.Hl) {
                case top:
                    if (VerticalTranslateLayout.this.DR != 10004 && VerticalTranslateLayout.this.DR != 10000) {
                        return false;
                    }
                    break;
                case bottom:
                    if (VerticalTranslateLayout.this.DR != 10004 && VerticalTranslateLayout.this.DR != 10001) {
                        return false;
                    }
                    break;
                case vertical:
                    if (VerticalTranslateLayout.this.Hv != null) {
                        VerticalTranslateLayout.this.Hv.aO(i);
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
                int i2 = VerticalTranslateLayout.this.Hi - i;
                switch (VerticalTranslateLayout.this.Hl) {
                    case top:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > VerticalTranslateLayout.this.He - VerticalTranslateLayout.this.DI && i2 < 0) {
                            VerticalTranslateLayout.this.Hi -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case bottom:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < VerticalTranslateLayout.this.DI - VerticalTranslateLayout.this.Hg && i2 > 0) {
                            VerticalTranslateLayout.this.Hi -= i;
                            VerticalTranslateLayout.this.invalidate();
                            return;
                        }
                        return;
                    case vertical:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= VerticalTranslateLayout.this.He - VerticalTranslateLayout.this.DI && i2 <= VerticalTranslateLayout.this.DI - VerticalTranslateLayout.this.Hg) {
                            VerticalTranslateLayout.this.Hi -= i;
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
        public void ki() {
            float max;
            this.Eq.computeCurrentVelocity(this.Es);
            float yVelocity = this.Eq.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Et);
            } else {
                max = Math.max(yVelocity, this.Et);
            }
            switch (VerticalTranslateLayout.this.Hl) {
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
            this.Eq.recycle();
            this.Eq = null;
        }

        private void J(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = VerticalTranslateLayout.this.Hi;
            if (i <= 0 && i >= VerticalTranslateLayout.this.He - VerticalTranslateLayout.this.DI) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Hr.H(f);
                } else {
                    VerticalTranslateLayout.this.Hr.F(f);
                }
            } else if (i >= 0 && i <= VerticalTranslateLayout.this.DI - VerticalTranslateLayout.this.Hg) {
                if (f < 0.0f) {
                    VerticalTranslateLayout.this.Hr.G(f);
                } else {
                    VerticalTranslateLayout.this.Hr.I(f);
                }
            }
        }

        private void K(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Hr.H(f);
            } else {
                VerticalTranslateLayout.this.Hr.F(f);
            }
        }

        private void L(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                VerticalTranslateLayout.this.Hr.G(f);
            } else {
                VerticalTranslateLayout.this.Hr.I(f);
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
            this.Ei = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        private void compute() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ej = ((((float) (uptimeMillis - this.En)) / 1000.0f) * this.Ek) + this.Ej;
            this.En = uptimeMillis;
            this.Eo += 16;
        }

        void kX() {
            compute();
            if (this.Ej <= this.El) {
                e eVar = VerticalTranslateLayout.this.Ht;
                if (eVar != null) {
                    eVar.lc();
                }
                this.Ep = false;
                VerticalTranslateLayout.this.DR = 10000;
                VerticalTranslateLayout.this.jW();
                return;
            }
            VerticalTranslateLayout.this.Hi = (int) (com.baidu.adp.widget.a.a(this.El, this.Ej, false) + this.Em);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Hq.sendEmptyMessageAtTime(-100, this.Eo);
        }

        void kY() {
            compute();
            if (this.Ej >= this.El) {
                c cVar = VerticalTranslateLayout.this.Hu;
                if (cVar != null) {
                    cVar.lb();
                }
                this.Ep = false;
                VerticalTranslateLayout.this.DR = 10001;
                VerticalTranslateLayout.this.jW();
                return;
            }
            VerticalTranslateLayout.this.Hi = (int) (com.baidu.adp.widget.a.a(this.El, this.Ej, false) + this.Em);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Hq.sendEmptyMessageAtTime(-101, this.Eo);
        }

        void kZ() {
            compute();
            if (this.Ej >= this.El) {
                for (d dVar : VerticalTranslateLayout.this.Ee) {
                    if (dVar != null) {
                        dVar.ke();
                    }
                }
                this.Ep = false;
                VerticalTranslateLayout.this.DR = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                VerticalTranslateLayout.this.jW();
                return;
            }
            VerticalTranslateLayout.this.Hi = (int) (com.baidu.adp.widget.a.a(this.El, this.Ej, false) + this.Em);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Hq.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Eo);
        }

        void la() {
            compute();
            if (this.Ej <= this.El) {
                for (d dVar : VerticalTranslateLayout.this.Ee) {
                    if (dVar != null) {
                        dVar.ke();
                    }
                }
                this.Ep = false;
                VerticalTranslateLayout.this.DR = Constants.MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE;
                VerticalTranslateLayout.this.jW();
                return;
            }
            VerticalTranslateLayout.this.Hi = (int) (com.baidu.adp.widget.a.a(this.El, this.Ej, false) + this.Em);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.Hq.sendEmptyMessageAtTime(-105, this.Eo);
        }

        void F(float f) {
            for (d dVar : VerticalTranslateLayout.this.Ee) {
                if (dVar != null) {
                    dVar.kd();
                }
            }
            this.Ep = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.En = uptimeMillis;
            this.Eo = uptimeMillis + 16;
            this.Ek = f;
            this.Ej = 0.0f;
            this.El = 0 - VerticalTranslateLayout.this.Hi;
            this.Em = VerticalTranslateLayout.this.Hi;
            VerticalTranslateLayout.this.Hq.removeMessages(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED);
            BdLog.d("Animator@animateTopOpen " + this.El);
            BdLog.d("Animator@animateTopOpen " + f);
            VerticalTranslateLayout.this.Hq.sendEmptyMessageAtTime(SapiErrorCode.ERROR_CODE_METHOD_DEPRECATED, this.Eo);
        }

        void G(float f) {
            for (d dVar : VerticalTranslateLayout.this.Ee) {
                if (dVar != null) {
                    dVar.kd();
                }
            }
            this.Ep = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.En = uptimeMillis;
            this.Eo = uptimeMillis + 16;
            this.Ek = f;
            this.Ej = 0.0f;
            this.El = 0 - VerticalTranslateLayout.this.Hi;
            this.Em = VerticalTranslateLayout.this.Hi;
            BdLog.d("Animator@animateBottomOpen " + this.El);
            BdLog.d("Animator@animateBottomOpen " + f);
            VerticalTranslateLayout.this.Hq.removeMessages(-105);
            VerticalTranslateLayout.this.Hq.sendEmptyMessageAtTime(-105, this.Eo);
        }

        void H(float f) {
            e eVar = VerticalTranslateLayout.this.Ht;
            if (eVar != null) {
                eVar.kb();
            }
            this.Ep = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.En = uptimeMillis;
            this.Eo = uptimeMillis + 16;
            this.Ek = f;
            this.Ej = 0.0f;
            this.El = ((-VerticalTranslateLayout.this.DI) + VerticalTranslateLayout.this.He) - VerticalTranslateLayout.this.Hi;
            this.Em = VerticalTranslateLayout.this.Hi;
            BdLog.d("Animator@animateTop " + this.El);
            BdLog.d("Animator@animateTop " + f);
            VerticalTranslateLayout.this.Hq.removeMessages(-100);
            VerticalTranslateLayout.this.Hq.sendEmptyMessageAtTime(-100, this.Eo);
        }

        void I(float f) {
            c cVar = VerticalTranslateLayout.this.Hu;
            if (cVar != null) {
                cVar.kf();
            }
            this.Ep = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.En = uptimeMillis;
            this.Eo = uptimeMillis + 16;
            this.Ek = f;
            this.Ej = 0.0f;
            this.El = (VerticalTranslateLayout.this.DI - VerticalTranslateLayout.this.Hg) - VerticalTranslateLayout.this.Hi;
            this.Em = VerticalTranslateLayout.this.Hi;
            BdLog.d("Animator@animateBottom " + this.El);
            BdLog.d("Animator@animateBottom " + f);
            VerticalTranslateLayout.this.Hq.removeMessages(-101);
            VerticalTranslateLayout.this.Hq.sendEmptyMessageAtTime(-101, this.Eo);
        }
    }
}
