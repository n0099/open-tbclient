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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f2269e;

    /* renamed from: f  reason: collision with root package name */
    public float f2270f;

    /* renamed from: g  reason: collision with root package name */
    public float f2271g;

    /* renamed from: h  reason: collision with root package name */
    public int f2272h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2273i;
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
        public static final /* synthetic */ int[] f2274a;

        static {
            int[] iArr = new int[TrackDirection.values().length];
            f2274a = iArr;
            try {
                iArr[TrackDirection.left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2274a[TrackDirection.right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2274a[TrackDirection.horizontal.ordinal()] = 3;
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
            if (HorizontalTranslateLayout.this.t.f2282g) {
                int i2 = message.what;
                if (i2 == -105) {
                    HorizontalTranslateLayout.this.t.i();
                } else if (i2 == -104) {
                    HorizontalTranslateLayout.this.t.g();
                } else if (i2 == -101) {
                    HorizontalTranslateLayout.this.t.h();
                } else if (i2 != -100) {
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
        public float f2276a;

        /* renamed from: b  reason: collision with root package name */
        public float f2277b;

        /* renamed from: c  reason: collision with root package name */
        public float f2278c;

        /* renamed from: d  reason: collision with root package name */
        public float f2279d;

        /* renamed from: e  reason: collision with root package name */
        public long f2280e;

        /* renamed from: f  reason: collision with root package name */
        public long f2281f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2282g;

        public c() {
            float f2 = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f2) {
            e eVar = HorizontalTranslateLayout.this.v;
            if (eVar != null) {
                eVar.a();
            }
            this.f2282g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2280e = uptimeMillis;
            this.f2281f = uptimeMillis + 16;
            this.f2277b = f2;
            this.f2276a = 0.0f;
            this.f2278c = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.f2270f) - HorizontalTranslateLayout.this.f2272h;
            this.f2279d = HorizontalTranslateLayout.this.f2272h;
            BdLog.d("Animator@animateTop " + this.f2278c);
            BdLog.d("Animator@animateTop " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(-100);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-100, this.f2281f);
        }

        public void b(float f2) {
            for (f fVar : HorizontalTranslateLayout.this.x) {
                if (fVar != null) {
                    fVar.a();
                }
            }
            this.f2282g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2280e = uptimeMillis;
            this.f2281f = uptimeMillis + 16;
            this.f2277b = f2;
            this.f2276a = 0.0f;
            this.f2278c = 0 - HorizontalTranslateLayout.this.f2272h;
            this.f2279d = HorizontalTranslateLayout.this.f2272h;
            HorizontalTranslateLayout.this.s.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.f2278c);
            BdLog.d("Animator@animateTopOpen " + f2);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-104, this.f2281f);
        }

        public void c(float f2) {
            g gVar = HorizontalTranslateLayout.this.w;
            if (gVar != null) {
                gVar.a();
            }
            this.f2282g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2280e = uptimeMillis;
            this.f2281f = uptimeMillis + 16;
            this.f2277b = f2;
            this.f2276a = 0.0f;
            this.f2278c = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2271g) - HorizontalTranslateLayout.this.f2272h;
            this.f2279d = HorizontalTranslateLayout.this.f2272h;
            BdLog.d("Animator@animateBottom " + this.f2278c);
            BdLog.d("Animator@animateBottom " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(-101);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-101, this.f2281f);
        }

        public void d(float f2) {
            for (f fVar : HorizontalTranslateLayout.this.x) {
                if (fVar != null) {
                    fVar.a();
                }
            }
            this.f2282g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2280e = uptimeMillis;
            this.f2281f = uptimeMillis + 16;
            this.f2277b = f2;
            this.f2276a = 0.0f;
            this.f2278c = 0 - HorizontalTranslateLayout.this.f2272h;
            this.f2279d = HorizontalTranslateLayout.this.f2272h;
            BdLog.d("Animator@animateBottomOpen " + this.f2278c);
            BdLog.d("Animator@animateBottomOpen " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(-105);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-105, this.f2281f);
        }

        public final void e() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2276a += this.f2277b * (((float) (uptimeMillis - this.f2280e)) / 1000.0f);
            this.f2280e = uptimeMillis;
            this.f2281f += 16;
        }

        public void f() {
            e();
            float f2 = this.f2276a;
            float f3 = this.f2278c;
            if (f2 <= f3) {
                e eVar = HorizontalTranslateLayout.this.v;
                if (eVar != null) {
                    eVar.b();
                }
                this.f2282g = false;
                HorizontalTranslateLayout.this.k = 10000;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2272h = (int) (d.a.c.j.h.a(f3, f2, false) + this.f2279d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-100, this.f2281f);
        }

        public void g() {
            e();
            float f2 = this.f2276a;
            float f3 = this.f2278c;
            if (f2 >= f3) {
                for (f fVar : HorizontalTranslateLayout.this.x) {
                    if (fVar != null) {
                        fVar.b();
                    }
                }
                this.f2282g = false;
                HorizontalTranslateLayout.this.k = 10004;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2272h = (int) (d.a.c.j.h.a(f3, f2, false) + this.f2279d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-104, this.f2281f);
        }

        public void h() {
            e();
            float f2 = this.f2276a;
            float f3 = this.f2278c;
            if (f2 >= f3) {
                g gVar = HorizontalTranslateLayout.this.w;
                if (gVar != null) {
                    gVar.b();
                }
                this.f2282g = false;
                HorizontalTranslateLayout.this.k = 10001;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2272h = (int) (d.a.c.j.h.a(f3, f2, false) + this.f2279d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-101, this.f2281f);
        }

        public void i() {
            e();
            float f2 = this.f2276a;
            float f3 = this.f2278c;
            if (f2 <= f3) {
                for (f fVar : HorizontalTranslateLayout.this.x) {
                    if (fVar != null) {
                        fVar.b();
                    }
                }
                this.f2282g = false;
                HorizontalTranslateLayout.this.k = 10004;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2272h = (int) (d.a.c.j.h.a(f3, f2, false) + this.f2279d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-105, this.f2281f);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i2);
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
        public VelocityTracker f2284a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2285b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2286c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2287d;

        public h() {
            float f2 = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.f2286c = (int) ((200.0f * f2) + 0.5f);
            this.f2287d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b() {
            float max;
            this.f2284a.computeCurrentVelocity(this.f2286c);
            float xVelocity = this.f2284a.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.f2287d);
            } else {
                max = Math.max(xVelocity, this.f2287d);
            }
            int i2 = a.f2274a[HorizontalTranslateLayout.this.j.ordinal()];
            if (i2 == 1) {
                d(max);
            } else if (i2 == 2) {
                g(max);
            } else if (i2 == 3) {
                c(max);
            }
            this.f2284a.recycle();
            this.f2284a = null;
        }

        public final void c(float f2) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i2 = HorizontalTranslateLayout.this.f2272h;
            if (i2 <= 0 && i2 >= HorizontalTranslateLayout.this.f2270f - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f2 < 0.0f) {
                    HorizontalTranslateLayout.this.t.a(f2);
                } else {
                    HorizontalTranslateLayout.this.t.b(f2);
                }
            } else if (i2 < 0 || i2 > HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2271g) {
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

        public void e(int i2) {
            if (this.f2285b) {
                int i3 = HorizontalTranslateLayout.this.f2272h - i2;
                int i4 = a.f2274a[HorizontalTranslateLayout.this.j.ordinal()];
                if (i4 == 1) {
                    BdLog.d("HorizontalTranslateLayout@move left");
                    if (i3 <= HorizontalTranslateLayout.this.f2270f - HorizontalTranslateLayout.this.getMeasuredWidth() || i3 >= 0) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2272h -= i2;
                    HorizontalTranslateLayout.this.invalidate();
                } else if (i4 == 2) {
                    BdLog.d("HorizontalTranslateLayout@move right");
                    if (i3 >= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2271g || i3 <= 0) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2272h -= i2;
                    HorizontalTranslateLayout.this.invalidate();
                } else if (i4 != 3) {
                } else {
                    BdLog.d("HorizontalTranslateLayout@move horizontal");
                    float f2 = i3;
                    if (f2 < HorizontalTranslateLayout.this.f2270f - HorizontalTranslateLayout.this.getMeasuredWidth() || f2 > HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2271g) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2272h -= i2;
                    HorizontalTranslateLayout.this.invalidate();
                }
            }
        }

        public boolean f(int i2) {
            int i3 = a.f2274a[HorizontalTranslateLayout.this.j.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && HorizontalTranslateLayout.this.y != null) {
                        HorizontalTranslateLayout.this.y.a(i2);
                    }
                } else if (HorizontalTranslateLayout.this.k != 10004 && HorizontalTranslateLayout.this.k != 10001) {
                    return false;
                }
            } else if (HorizontalTranslateLayout.this.k != 10004 && HorizontalTranslateLayout.this.k != 10000) {
                return false;
            }
            this.f2284a = VelocityTracker.obtain();
            this.f2285b = true;
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
            this.f2285b = false;
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
        this.f2273i = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        o(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f2272h, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.f2272h);
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.n);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftOffset() {
        return (int) this.f2270f;
    }

    public int getLeftTranslate() {
        return this.f2272h;
    }

    public int getRightOffset() {
        return (int) this.f2271g;
    }

    public int getState() {
        return this.k;
    }

    public final void o(AttributeSet attributeSet) {
        String[] split;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.f2270f = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.f2271g = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.f2270f != -1.0f && this.f2271g != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.j = TrackDirection.horizontal;
            } else if (this.f2271g != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.j = TrackDirection.right;
            } else if (this.f2270f != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
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
                if ((!CustomDialogData.POS_LEFT.equals(str) || this.f2270f == -1.0f) && (!"right".equals(str) || this.f2271g == -1.0f)) {
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
            this.s.removeMessages(-104);
            this.s.removeMessages(-101);
            this.s.removeMessages(-105);
        } else if (action == 2) {
            BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
            motionEvent.offsetLocation(-this.f2272h, 0.0f);
            return q(x, y);
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            float f2 = this.f2270f;
            if (f2 != -1.0f) {
                this.l.set(i2, i3, (int) (i2 + f2), i5);
            }
            float f3 = this.f2271g;
            if (f3 != -1.0f) {
                this.m.set((int) (i4 - f3), i3, i4, i5);
            }
        }
        if (this.t.f2282g || this.u.f2285b) {
            return;
        }
        p();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f2269e = getMeasuredWidth();
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
                } else if (this.u.f2285b) {
                    if (!this.r) {
                        int i2 = this.o;
                        if (x > i2) {
                            this.q = i2 + this.f2273i;
                            this.r = true;
                        } else {
                            this.q = i2 - this.f2273i;
                            this.r = true;
                        }
                    }
                    this.u.e(this.q - x);
                    this.q = x;
                    this.u.f2284a.addMovement(motionEvent);
                }
            }
            BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
            this.r = false;
            if (this.u.f2285b) {
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
            if (hVar.f2285b) {
                hVar.h();
                this.u.b();
            }
        } else if ((this.k != 10000 || !this.l.contains(x, y)) && (this.k != 10001 || !this.m.contains(x, y))) {
            return false;
        } else {
            h hVar2 = this.u;
            if (!hVar2.f2285b) {
                this.q = x;
                hVar2.f(x);
            }
        }
        h hVar3 = this.u;
        if (hVar3.f2285b) {
            hVar3.e(this.q - x);
            this.q = x;
            this.u.f2284a.addMovement(motionEvent);
        }
        return true;
    }

    public final void p() {
        int i2 = this.k;
        if (i2 == 10000) {
            this.f2272h = (int) (this.f2270f - getMeasuredWidth());
            invalidate();
        } else if (i2 == 10001) {
            this.f2272h = (int) (getMeasuredWidth() - this.f2271g);
            invalidate();
        } else if (i2 != 10004) {
        } else {
            this.f2272h = 0;
            invalidate();
        }
    }

    public final boolean q(int i2, int i3) {
        int i4 = this.p;
        int i5 = this.f2273i;
        if (i3 >= i4 - i5 && i3 <= i4 + i5) {
            int i6 = this.o;
            if ((i2 < i6 - i5 || i2 > i6 + i5) && this.u.f(i2 - this.o)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.n.setColor(i2);
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
        int i2;
        if (f2 < -1.0f || f2 > 1.0f) {
            return;
        }
        if (f2 < 0.0f) {
            this.f2272h = (int) ((this.f2270f - this.f2269e) * (-f2));
        } else {
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 > 0) {
                this.f2272h = (int) ((this.f2269e - this.f2271g) * f2);
            } else if (i3 == 0) {
                this.f2272h = 0;
                this.k = 10004;
            } else if (f2 == -1.0f) {
                this.f2270f -= getMeasuredWidth();
                this.k = 10000;
            } else if (i2 == 0) {
                this.f2270f = getMeasuredWidth() - this.f2271g;
                this.k = 10001;
            }
        }
        invalidate();
    }

    public void setRightAnimationListener(g gVar) {
        this.w = gVar;
    }

    public void setRightTapBack(boolean z) {
    }
}
