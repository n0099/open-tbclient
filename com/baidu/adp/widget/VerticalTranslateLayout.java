package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled;
    private int GA;
    private int GB;
    private final int GG;
    private int GK;
    private final Paint GN;
    private int GO;
    private int GP;
    private final List<d> GX;
    private float Kb;
    private float Kc;
    private float Kd;
    private float Ke;
    private int Kf;
    private boolean Kg;
    private boolean Kh;
    private TrackDirection Ki;
    private final Rect Kj;
    private final Rect Kk;
    private int Kl;
    private boolean Km;
    private final a Kn;
    private final b Ko;
    private final g Kp;
    private e Kq;
    private c Kr;
    private f Ks;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none;

        /* JADX DEBUG: Replace access to removed values field (Ku) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static TrackDirection[] valuesCustom() {
            TrackDirection[] valuesCustom = values();
            int length = valuesCustom.length;
            TrackDirection[] trackDirectionArr = new TrackDirection[length];
            System.arraycopy(valuesCustom, 0, trackDirectionArr, 0, length);
            return trackDirectionArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void kF();

        void lV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        void kD();

        void kE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void kB();

        void lW();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void aO(int i);
    }

    static {
        $assertionsDisabled = !VerticalTranslateLayout.class.desiredAssertionStatus();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.GN.setColor(i);
        invalidate();
    }

    public void setProportion(float f2) {
        if (f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.Kf = (int) ((this.Kb - this.GB) * (-f2));
            } else if (f2 > 0.0f) {
                this.Kf = (int) ((this.GB - this.Kd) * f2);
            } else if (f2 == 0.0f) {
                this.Kf = 0;
                this.GK = 10004;
            } else if (f2 == -1.0f) {
                this.Kb -= this.GB;
                this.GK = 10000;
            } else if (f2 == 1.0f) {
                this.Kb = this.GB - this.Kd;
                this.GK = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
            }
            invalidate();
        }
    }

    public int getTopOffset() {
        return (int) this.Kb;
    }

    public int getBottomOffset() {
        return (int) this.Kd;
    }

    public void setTopTapBack(boolean z) {
        this.Kg = z;
    }

    public void setBottomTapBack(boolean z) {
        this.Kh = z;
    }

    public int getState() {
        return this.GK;
    }

    public void setTopAnimationListener(e eVar) {
        this.Kq = eVar;
    }

    public void setBottomAnimationListener(c cVar) {
        this.Kr = cVar;
    }

    public void setVerticalTrackListener(f fVar) {
        this.Ks = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.Kf);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.Kf);
        canvas.drawRect(0.0f, 0.0f, this.GA, this.GB, this.GN);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getTopTranslate() {
        return this.Kf;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Ki == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.GK == 10004) {
            switch (action) {
                case 0:
                    this.GO = x;
                    this.GP = y;
                    this.Kn.removeMessages(-100);
                    this.Kn.removeMessages(-104);
                    this.Kn.removeMessages(-101);
                    this.Kn.removeMessages(-105);
                    return false;
                case 1:
                default:
                    return false;
                case 2:
                    BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                    motionEvent.offsetLocation(0.0f, -this.Kf);
                    return q(x, y);
            }
        }
        BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
        return true;
    }

    private boolean q(int i, int i2) {
        return i >= this.GO - this.GG && i <= this.GO + this.GG && (i2 < this.GP - this.GG || i2 > this.GP + this.GG) && this.Kp.aG(i2 - this.GP);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (this.GK == 10004) {
            switch (action) {
                case 1:
                case 3:
                    BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                    this.Km = false;
                    if (this.Kp.Hj) {
                        BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                        this.Kp.kH();
                        this.Kp.kI();
                        return true;
                    }
                    return true;
                case 2:
                    if (this.Kp.Hj) {
                        if (!this.Km) {
                            if (y > this.GP) {
                                this.Kl = this.GP + this.GG;
                                this.Km = true;
                            } else {
                                this.Kl = this.GP - this.GG;
                                this.Km = true;
                            }
                        }
                        this.Kp.aH(this.Kl - y);
                        this.Kl = y;
                        this.Kp.Hi.addMovement(motionEvent);
                        return true;
                    }
                    return true;
                default:
                    return false;
            }
        }
        switch (action) {
            case 0:
                if ((this.GK != 10000 || !this.Kj.contains(x, y)) && (this.GK != 10001 || !this.Kk.contains(x, y))) {
                    return false;
                }
                if (!this.Kp.Hj) {
                    this.Kl = y;
                    this.Kp.aG(y);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.Kp.Hj) {
                    this.Kp.kH();
                    this.Kp.kI();
                    return true;
                }
                return true;
            case 2:
                break;
            default:
                return true;
        }
        if (this.Kp.Hj) {
            this.Kp.aH(this.Kl - y);
            this.Kl = y;
            this.Kp.Hi.addMovement(motionEvent);
            return true;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.Kb != -1.0f) {
                this.Kj.set(i, i2, i3, (int) (i2 + this.Kb));
            }
            if (this.Kd != -1.0f) {
                this.Kk.set(i, (int) (i4 - this.Kd), i3, i4);
            }
        }
        if (!this.Ko.Hg && !this.Kp.Hj) {
            kv();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 1073741823 & i2;
        if (this.Kc != -1.0f) {
            this.Kb = i3 - this.Ke;
        }
        if (this.Ke != -1.0f) {
            this.Kd = i3 - this.Kc;
        }
        if (!$assertionsDisabled && i3 < this.Kb) {
            throw new AssertionError("top offset should not be larger than the view's width");
        }
        if (!$assertionsDisabled && i3 < this.Kd) {
            throw new AssertionError("bottom offset should not be larger than the view's width");
        }
        this.GA = getMeasuredWidth();
        this.GB = getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv() {
        switch (this.GK) {
            case 10000:
                this.Kf = (int) (this.Kb - this.GB);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                this.Kf = (int) (this.GB - this.Kd);
                invalidate();
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
            default:
                return;
            case 10004:
                this.Kf = 0;
                invalidate();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
        final /* synthetic */ VerticalTranslateLayout Kt;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.Kt.Ko.Hg) {
                switch (message.what) {
                    case -105:
                        this.Kt.Ko.lU();
                        return;
                    case -104:
                        this.Kt.Ko.lT();
                        return;
                    case -103:
                    case -102:
                    default:
                        return;
                    case -101:
                        this.Kt.Ko.lS();
                        return;
                    case -100:
                        this.Kt.Ko.lR();
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g {
        private static /* synthetic */ int[] Kv;
        VelocityTracker Hi;
        boolean Hj;
        final int Hk;
        final int Hl;
        final /* synthetic */ VerticalTranslateLayout Kt;

        static /* synthetic */ int[] lX() {
            int[] iArr = Kv;
            if (iArr == null) {
                iArr = new int[TrackDirection.valuesCustom().length];
                try {
                    iArr[TrackDirection.bottom.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[TrackDirection.none.ordinal()] = 4;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[TrackDirection.top.ordinal()] = 1;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[TrackDirection.vertical.ordinal()] = 3;
                } catch (NoSuchFieldError e4) {
                }
                Kv = iArr;
            }
            return iArr;
        }

        boolean aG(int i) {
            switch (lX()[this.Kt.Ki.ordinal()]) {
                case 1:
                    if (this.Kt.GK != 10004 && this.Kt.GK != 10000) {
                        return false;
                    }
                    break;
                case 2:
                    if (this.Kt.GK != 10004 && this.Kt.GK != 10001) {
                        return false;
                    }
                    break;
                case 3:
                    if (this.Kt.Ks != null) {
                        this.Kt.Ks.aO(i);
                        break;
                    }
                    break;
            }
            this.Hi = VelocityTracker.obtain();
            this.Hj = true;
            return true;
        }

        void kH() {
            this.Hj = false;
        }

        void aH(int i) {
            if (this.Hj) {
                int i2 = this.Kt.Kf - i;
                switch (lX()[this.Kt.Ki.ordinal()]) {
                    case 1:
                        BdLog.d("VerticalTranslateLayout@move top");
                        if (i2 > this.Kt.Kb - this.Kt.GB && i2 < 0) {
                            this.Kt.Kf -= i;
                            this.Kt.invalidate();
                            return;
                        }
                        return;
                    case 2:
                        BdLog.d("VerticalTranslateLayout@move bottom");
                        if (i2 < this.Kt.GB - this.Kt.Kd && i2 > 0) {
                            this.Kt.Kf -= i;
                            this.Kt.invalidate();
                            return;
                        }
                        return;
                    case 3:
                        BdLog.d("VerticalTranslateLayout@move vertical");
                        if (i2 >= this.Kt.Kb - this.Kt.GB && i2 <= this.Kt.GB - this.Kt.Kd) {
                            this.Kt.Kf -= i;
                            this.Kt.invalidate();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kI() {
            float max;
            this.Hi.computeCurrentVelocity(this.Hk);
            float yVelocity = this.Hi.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.Hl);
            } else {
                max = Math.max(yVelocity, this.Hl);
            }
            switch (lX()[this.Kt.Ki.ordinal()]) {
                case 1:
                    O(max);
                    break;
                case 2:
                    P(max);
                    break;
                case 3:
                    N(max);
                    break;
            }
            this.Hi.recycle();
            this.Hi = null;
        }

        private void N(float f) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i = this.Kt.Kf;
            if (i <= 0 && i >= this.Kt.Kb - this.Kt.GB) {
                if (f < 0.0f) {
                    this.Kt.Ko.L(f);
                } else {
                    this.Kt.Ko.J(f);
                }
            } else if (i >= 0 && i <= this.Kt.GB - this.Kt.Kd) {
                if (f < 0.0f) {
                    this.Kt.Ko.K(f);
                } else {
                    this.Kt.Ko.M(f);
                }
            }
        }

        private void O(float f) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f < 0.0f) {
                this.Kt.Ko.L(f);
            } else {
                this.Kt.Ko.J(f);
            }
        }

        private void P(float f) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f < 0.0f) {
                this.Kt.Ko.K(f);
            } else {
                this.Kt.Ko.M(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        float Ha;
        float Hb;
        float Hc;
        float Hd;
        long He;
        long Hf;
        boolean Hg;
        final /* synthetic */ VerticalTranslateLayout Kt;

        private void kw() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.Ha = ((((float) (uptimeMillis - this.He)) / 1000.0f) * this.Hb) + this.Ha;
            this.He = uptimeMillis;
            this.Hf += 16;
        }

        void lR() {
            kw();
            if (this.Ha <= this.Hc) {
                e eVar = this.Kt.Kq;
                if (eVar != null) {
                    eVar.lW();
                }
                this.Hg = false;
                this.Kt.GK = 10000;
                this.Kt.kv();
                return;
            }
            this.Kt.Kf = (int) (com.baidu.adp.widget.a.a(this.Hc, this.Ha, false) + this.Hd);
            this.Kt.invalidate();
            this.Kt.Kn.sendEmptyMessageAtTime(-100, this.Hf);
        }

        void lS() {
            kw();
            if (this.Ha >= this.Hc) {
                c cVar = this.Kt.Kr;
                if (cVar != null) {
                    cVar.lV();
                }
                this.Hg = false;
                this.Kt.GK = IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND;
                this.Kt.kv();
                return;
            }
            this.Kt.Kf = (int) (com.baidu.adp.widget.a.a(this.Hc, this.Ha, false) + this.Hd);
            this.Kt.invalidate();
            this.Kt.Kn.sendEmptyMessageAtTime(-101, this.Hf);
        }

        void lT() {
            kw();
            if (this.Ha >= this.Hc) {
                for (d dVar : this.Kt.GX) {
                    if (dVar != null) {
                        dVar.kE();
                    }
                }
                this.Hg = false;
                this.Kt.GK = 10004;
                this.Kt.kv();
                return;
            }
            this.Kt.Kf = (int) (com.baidu.adp.widget.a.a(this.Hc, this.Ha, false) + this.Hd);
            this.Kt.invalidate();
            this.Kt.Kn.sendEmptyMessageAtTime(-104, this.Hf);
        }

        void lU() {
            kw();
            if (this.Ha <= this.Hc) {
                for (d dVar : this.Kt.GX) {
                    if (dVar != null) {
                        dVar.kE();
                    }
                }
                this.Hg = false;
                this.Kt.GK = 10004;
                this.Kt.kv();
                return;
            }
            this.Kt.Kf = (int) (com.baidu.adp.widget.a.a(this.Hc, this.Ha, false) + this.Hd);
            this.Kt.invalidate();
            this.Kt.Kn.sendEmptyMessageAtTime(-105, this.Hf);
        }

        void J(float f) {
            for (d dVar : this.Kt.GX) {
                if (dVar != null) {
                    dVar.kD();
                }
            }
            this.Hg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.He = uptimeMillis;
            this.Hf = uptimeMillis + 16;
            this.Hb = f;
            this.Ha = 0.0f;
            this.Hc = 0 - this.Kt.Kf;
            this.Hd = this.Kt.Kf;
            this.Kt.Kn.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.Hc);
            BdLog.d("Animator@animateTopOpen " + f);
            this.Kt.Kn.sendEmptyMessageAtTime(-104, this.Hf);
        }

        void K(float f) {
            for (d dVar : this.Kt.GX) {
                if (dVar != null) {
                    dVar.kD();
                }
            }
            this.Hg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.He = uptimeMillis;
            this.Hf = uptimeMillis + 16;
            this.Hb = f;
            this.Ha = 0.0f;
            this.Hc = 0 - this.Kt.Kf;
            this.Hd = this.Kt.Kf;
            BdLog.d("Animator@animateBottomOpen " + this.Hc);
            BdLog.d("Animator@animateBottomOpen " + f);
            this.Kt.Kn.removeMessages(-105);
            this.Kt.Kn.sendEmptyMessageAtTime(-105, this.Hf);
        }

        void L(float f) {
            e eVar = this.Kt.Kq;
            if (eVar != null) {
                eVar.kB();
            }
            this.Hg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.He = uptimeMillis;
            this.Hf = uptimeMillis + 16;
            this.Hb = f;
            this.Ha = 0.0f;
            this.Hc = ((-this.Kt.GB) + this.Kt.Kb) - this.Kt.Kf;
            this.Hd = this.Kt.Kf;
            BdLog.d("Animator@animateTop " + this.Hc);
            BdLog.d("Animator@animateTop " + f);
            this.Kt.Kn.removeMessages(-100);
            this.Kt.Kn.sendEmptyMessageAtTime(-100, this.Hf);
        }

        void M(float f) {
            c cVar = this.Kt.Kr;
            if (cVar != null) {
                cVar.kF();
            }
            this.Hg = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.He = uptimeMillis;
            this.Hf = uptimeMillis + 16;
            this.Hb = f;
            this.Ha = 0.0f;
            this.Hc = (this.Kt.GB - this.Kt.Kd) - this.Kt.Kf;
            this.Hd = this.Kt.Kf;
            BdLog.d("Animator@animateBottom " + this.Hc);
            BdLog.d("Animator@animateBottom " + f);
            this.Kt.Kn.removeMessages(-101);
            this.Kt.Kn.sendEmptyMessageAtTime(-101, this.Hf);
        }
    }
}
