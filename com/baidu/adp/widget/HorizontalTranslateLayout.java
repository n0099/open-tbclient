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
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f2255e;

    /* renamed from: f  reason: collision with root package name */
    public float f2256f;

    /* renamed from: g  reason: collision with root package name */
    public float f2257g;

    /* renamed from: h  reason: collision with root package name */
    public int f2258h;
    public final int i;
    public TrackDirection j;
    public int k;
    public final Rect l;
    public final Rect m;
    public final Paint n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public final b s;
    public final c t;
    public final h u;
    public e v;
    public g w;
    public final List<f> x;
    public d y;

    /* loaded from: classes.dex */
    public enum TrackDirection {
        left,
        right,
        horizontal,
        none
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2259a;

        static {
            int[] iArr = new int[TrackDirection.values().length];
            f2259a = iArr;
            try {
                iArr[TrackDirection.left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2259a[TrackDirection.right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2259a[TrackDirection.horizontal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (HorizontalTranslateLayout.this.t.f2267g) {
                int i = message.what;
                if (i == -105) {
                    HorizontalTranslateLayout.this.t.i();
                } else if (i == -104) {
                    HorizontalTranslateLayout.this.t.g();
                } else if (i == -101) {
                    HorizontalTranslateLayout.this.t.h();
                } else if (i != -100) {
                } else {
                    HorizontalTranslateLayout.this.t.f();
                }
            }
        }

        public /* synthetic */ b(HorizontalTranslateLayout horizontalTranslateLayout, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public float f2261a;

        /* renamed from: b  reason: collision with root package name */
        public float f2262b;

        /* renamed from: c  reason: collision with root package name */
        public float f2263c;

        /* renamed from: d  reason: collision with root package name */
        public float f2264d;

        /* renamed from: e  reason: collision with root package name */
        public long f2265e;

        /* renamed from: f  reason: collision with root package name */
        public long f2266f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2267g;

        public c() {
            float f2 = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f2) {
            e eVar = HorizontalTranslateLayout.this.v;
            if (eVar != null) {
                eVar.a();
            }
            this.f2267g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2265e = uptimeMillis;
            this.f2266f = uptimeMillis + 16;
            this.f2262b = f2;
            this.f2261a = 0.0f;
            this.f2263c = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.f2256f) - HorizontalTranslateLayout.this.f2258h;
            this.f2264d = HorizontalTranslateLayout.this.f2258h;
            BdLog.d("Animator@animateTop " + this.f2263c);
            BdLog.d("Animator@animateTop " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(-100);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-100, this.f2266f);
        }

        public void b(float f2) {
            for (f fVar : HorizontalTranslateLayout.this.x) {
                if (fVar != null) {
                    fVar.a();
                }
            }
            this.f2267g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2265e = uptimeMillis;
            this.f2266f = uptimeMillis + 16;
            this.f2262b = f2;
            this.f2261a = 0.0f;
            this.f2263c = 0 - HorizontalTranslateLayout.this.f2258h;
            this.f2264d = HorizontalTranslateLayout.this.f2258h;
            HorizontalTranslateLayout.this.s.removeMessages(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
            BdLog.d("Animator@animateTopOpen " + this.f2263c);
            BdLog.d("Animator@animateTopOpen " + f2);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS, this.f2266f);
        }

        public void c(float f2) {
            g gVar = HorizontalTranslateLayout.this.w;
            if (gVar != null) {
                gVar.a();
            }
            this.f2267g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2265e = uptimeMillis;
            this.f2266f = uptimeMillis + 16;
            this.f2262b = f2;
            this.f2261a = 0.0f;
            this.f2263c = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2257g) - HorizontalTranslateLayout.this.f2258h;
            this.f2264d = HorizontalTranslateLayout.this.f2258h;
            BdLog.d("Animator@animateBottom " + this.f2263c);
            BdLog.d("Animator@animateBottom " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(-101);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-101, this.f2266f);
        }

        public void d(float f2) {
            for (f fVar : HorizontalTranslateLayout.this.x) {
                if (fVar != null) {
                    fVar.a();
                }
            }
            this.f2267g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2265e = uptimeMillis;
            this.f2266f = uptimeMillis + 16;
            this.f2262b = f2;
            this.f2261a = 0.0f;
            this.f2263c = 0 - HorizontalTranslateLayout.this.f2258h;
            this.f2264d = HorizontalTranslateLayout.this.f2258h;
            BdLog.d("Animator@animateBottomOpen " + this.f2263c);
            BdLog.d("Animator@animateBottomOpen " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, this.f2266f);
        }

        public final void e() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2261a += this.f2262b * (((float) (uptimeMillis - this.f2265e)) / 1000.0f);
            this.f2265e = uptimeMillis;
            this.f2266f += 16;
        }

        public void f() {
            e();
            float f2 = this.f2261a;
            float f3 = this.f2263c;
            if (f2 <= f3) {
                e eVar = HorizontalTranslateLayout.this.v;
                if (eVar != null) {
                    eVar.b();
                }
                this.f2267g = false;
                HorizontalTranslateLayout.this.k = 10000;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2258h = (int) (d.b.b.j.h.a(f3, f2, false) + this.f2264d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-100, this.f2266f);
        }

        public void g() {
            e();
            float f2 = this.f2261a;
            float f3 = this.f2263c;
            if (f2 >= f3) {
                for (f fVar : HorizontalTranslateLayout.this.x) {
                    if (fVar != null) {
                        fVar.b();
                    }
                }
                this.f2267g = false;
                HorizontalTranslateLayout.this.k = 10004;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2258h = (int) (d.b.b.j.h.a(f3, f2, false) + this.f2264d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS, this.f2266f);
        }

        public void h() {
            e();
            float f2 = this.f2261a;
            float f3 = this.f2263c;
            if (f2 >= f3) {
                g gVar = HorizontalTranslateLayout.this.w;
                if (gVar != null) {
                    gVar.b();
                }
                this.f2267g = false;
                HorizontalTranslateLayout.this.k = 10001;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2258h = (int) (d.b.b.j.h.a(f3, f2, false) + this.f2264d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-101, this.f2266f);
        }

        public void i() {
            e();
            float f2 = this.f2261a;
            float f3 = this.f2263c;
            if (f2 <= f3) {
                for (f fVar : HorizontalTranslateLayout.this.x) {
                    if (fVar != null) {
                        fVar.b();
                    }
                }
                this.f2267g = false;
                HorizontalTranslateLayout.this.k = 10004;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2258h = (int) (d.b.b.j.h.a(f3, f2, false) + this.f2264d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, this.f2266f);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface g {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public VelocityTracker f2269a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2270b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2271c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2272d;

        public h() {
            float f2 = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.f2271c = (int) ((200.0f * f2) + 0.5f);
            this.f2272d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b() {
            float max;
            this.f2269a.computeCurrentVelocity(this.f2271c);
            float xVelocity = this.f2269a.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.f2272d);
            } else {
                max = Math.max(xVelocity, this.f2272d);
            }
            int i = a.f2259a[HorizontalTranslateLayout.this.j.ordinal()];
            if (i == 1) {
                d(max);
            } else if (i == 2) {
                g(max);
            } else if (i == 3) {
                c(max);
            }
            this.f2269a.recycle();
            this.f2269a = null;
        }

        public final void c(float f2) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i = HorizontalTranslateLayout.this.f2258h;
            if (i <= 0 && i >= HorizontalTranslateLayout.this.f2256f - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f2 < 0.0f) {
                    HorizontalTranslateLayout.this.t.a(f2);
                } else {
                    HorizontalTranslateLayout.this.t.b(f2);
                }
            } else if (i < 0 || i > HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2257g) {
            } else {
                if (f2 < 0.0f) {
                    HorizontalTranslateLayout.this.t.d(f2);
                } else {
                    HorizontalTranslateLayout.this.t.c(f2);
                }
            }
        }

        public final void d(float f2) {
            BdLog.d("HorizontalTranslateLayout@leftFling");
            if (f2 < 0.0f) {
                HorizontalTranslateLayout.this.t.a(f2);
            } else {
                HorizontalTranslateLayout.this.t.b(f2);
            }
        }

        public void e(int i) {
            if (this.f2270b) {
                int i2 = HorizontalTranslateLayout.this.f2258h - i;
                int i3 = a.f2259a[HorizontalTranslateLayout.this.j.ordinal()];
                if (i3 == 1) {
                    BdLog.d("HorizontalTranslateLayout@move left");
                    if (i2 <= HorizontalTranslateLayout.this.f2256f - HorizontalTranslateLayout.this.getMeasuredWidth() || i2 >= 0) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2258h -= i;
                    HorizontalTranslateLayout.this.invalidate();
                } else if (i3 == 2) {
                    BdLog.d("HorizontalTranslateLayout@move right");
                    if (i2 >= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2257g || i2 <= 0) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2258h -= i;
                    HorizontalTranslateLayout.this.invalidate();
                } else if (i3 != 3) {
                } else {
                    BdLog.d("HorizontalTranslateLayout@move horizontal");
                    float f2 = i2;
                    if (f2 < HorizontalTranslateLayout.this.f2256f - HorizontalTranslateLayout.this.getMeasuredWidth() || f2 > HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2257g) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2258h -= i;
                    HorizontalTranslateLayout.this.invalidate();
                }
            }
        }

        public boolean f(int i) {
            int i2 = a.f2259a[HorizontalTranslateLayout.this.j.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 && HorizontalTranslateLayout.this.y != null) {
                        HorizontalTranslateLayout.this.y.a(i);
                    }
                } else if (HorizontalTranslateLayout.this.k != 10004 && HorizontalTranslateLayout.this.k != 10001) {
                    return false;
                }
            } else if (HorizontalTranslateLayout.this.k != 10004 && HorizontalTranslateLayout.this.k != 10000) {
                return false;
            }
            this.f2269a = VelocityTracker.obtain();
            this.f2270b = true;
            return true;
        }

        public final void g(float f2) {
            BdLog.d("HorizontalTranslateLayout@rightFling");
            if (f2 < 0.0f) {
                HorizontalTranslateLayout.this.t.d(f2);
            } else {
                HorizontalTranslateLayout.this.t.c(f2);
            }
        }

        public void h() {
            this.f2270b = false;
        }
    }

    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.l = new Rect();
        this.m = new Rect();
        this.x = new ArrayList();
        this.s = new b(this, null);
        this.t = new c();
        this.u = new h();
        this.k = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.n = paint;
        paint.setColor(-1);
        double d2 = resources.getDisplayMetrics().density * 35.0f;
        Double.isNaN(d2);
        this.i = (int) (d2 + 0.5d);
        o(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f2258h, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.f2258h);
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.n);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftOffset() {
        return (int) this.f2256f;
    }

    public int getLeftTranslate() {
        return this.f2258h;
    }

    public int getRightOffset() {
        return (int) this.f2257g;
    }

    public int getState() {
        return this.k;
    }

    public final void o(AttributeSet attributeSet) {
        String[] split;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.f2256f = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.f2257g = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.f2256f != -1.0f && this.f2257g != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.j = TrackDirection.horizontal;
            } else if (this.f2257g != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.j = TrackDirection.right;
            } else if (this.f2256f != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack left");
                this.j = TrackDirection.left;
            } else {
                this.j = TrackDirection.none;
                BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            for (String str : string2.split("\\|")) {
                BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                if ((!CustomDialogData.POS_LEFT.equals(str) || this.f2256f == -1.0f) && (!"right".equals(str) || this.f2257g == -1.0f)) {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.n.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.j == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.k != 10004) {
            BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
            return true;
        }
        if (action == 0) {
            this.o = x;
            this.p = y;
            this.s.removeMessages(-100);
            this.s.removeMessages(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
            this.s.removeMessages(-101);
            this.s.removeMessages(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL);
        } else if (action == 2) {
            BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
            motionEvent.offsetLocation(-this.f2258h, 0.0f);
            return q(x, y);
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            float f2 = this.f2256f;
            if (f2 != -1.0f) {
                this.l.set(i, i2, (int) (i + f2), i4);
            }
            float f3 = this.f2257g;
            if (f3 != -1.0f) {
                this.m.set((int) (i3 - f3), i2, i3, i4);
            }
        }
        if (this.t.f2267g || this.u.f2270b) {
            return;
        }
        p();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f2255e = getMeasuredWidth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c8, code lost:
        if (r2 != 3) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (this.k == 10004) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else if (this.u.f2270b) {
                    if (!this.r) {
                        int i = this.o;
                        if (x > i) {
                            this.q = i + this.i;
                            this.r = true;
                        } else {
                            this.q = i - this.i;
                            this.r = true;
                        }
                    }
                    this.u.e(this.q - x);
                    this.q = x;
                    this.u.f2269a.addMovement(motionEvent);
                }
            }
            BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
            this.r = false;
            if (this.u.f2270b) {
                BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                this.u.h();
                this.u.b();
            }
            return true;
        }
        BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
        BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.l);
        BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.m);
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            h hVar = this.u;
            if (hVar.f2270b) {
                hVar.h();
                this.u.b();
            }
        } else if ((this.k != 10000 || !this.l.contains(x, y)) && (this.k != 10001 || !this.m.contains(x, y))) {
            return false;
        } else {
            h hVar2 = this.u;
            if (!hVar2.f2270b) {
                this.q = x;
                hVar2.f(x);
            }
        }
        h hVar3 = this.u;
        if (hVar3.f2270b) {
            hVar3.e(this.q - x);
            this.q = x;
            this.u.f2269a.addMovement(motionEvent);
        }
        return true;
    }

    public final void p() {
        int i = this.k;
        if (i == 10000) {
            this.f2258h = (int) (this.f2256f - getMeasuredWidth());
            invalidate();
        } else if (i == 10001) {
            this.f2258h = (int) (getMeasuredWidth() - this.f2257g);
            invalidate();
        } else if (i != 10004) {
        } else {
            this.f2258h = 0;
            invalidate();
        }
    }

    public final boolean q(int i, int i2) {
        int i3 = this.p;
        int i4 = this.i;
        if (i2 >= i3 - i4 && i2 <= i3 + i4) {
            int i5 = this.o;
            if ((i < i5 - i4 || i > i5 + i4) && this.u.f(i - this.o)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.n.setColor(i);
        invalidate();
    }

    public void setHorizontalTrackListener(d dVar) {
        this.y = dVar;
    }

    public void setLeftAnimationListener(e eVar) {
        this.v = eVar;
    }

    public void setLeftTapBack(boolean z) {
    }

    public void setProportion(float f2) {
        if (f2 < -1.0f || f2 > 1.0f) {
            return;
        }
        if (f2 < 0.0f) {
            this.f2258h = (int) ((this.f2256f - this.f2255e) * (-f2));
        } else if (f2 > 0.0f) {
            this.f2258h = (int) ((this.f2255e - this.f2257g) * f2);
        } else if (f2 == 0.0f) {
            this.f2258h = 0;
            this.k = 10004;
        } else if (f2 == -1.0f) {
            this.f2256f -= getMeasuredWidth();
            this.k = 10000;
        } else if (f2 == 1.0f) {
            this.f2256f = getMeasuredWidth() - this.f2257g;
            this.k = 10001;
        }
        invalidate();
    }

    public void setRightAnimationListener(g gVar) {
        this.w = gVar;
    }

    public void setRightTapBack(boolean z) {
    }
}
