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
    public int f2264e;

    /* renamed from: f  reason: collision with root package name */
    public float f2265f;

    /* renamed from: g  reason: collision with root package name */
    public float f2266g;

    /* renamed from: h  reason: collision with root package name */
    public int f2267h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2268i;
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
        public static final /* synthetic */ int[] f2269a;

        static {
            int[] iArr = new int[TrackDirection.values().length];
            f2269a = iArr;
            try {
                iArr[TrackDirection.left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2269a[TrackDirection.right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2269a[TrackDirection.horizontal.ordinal()] = 3;
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
            if (HorizontalTranslateLayout.this.t.f2277g) {
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
        public float f2271a;

        /* renamed from: b  reason: collision with root package name */
        public float f2272b;

        /* renamed from: c  reason: collision with root package name */
        public float f2273c;

        /* renamed from: d  reason: collision with root package name */
        public float f2274d;

        /* renamed from: e  reason: collision with root package name */
        public long f2275e;

        /* renamed from: f  reason: collision with root package name */
        public long f2276f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2277g;

        public c() {
            float f2 = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f2) {
            e eVar = HorizontalTranslateLayout.this.v;
            if (eVar != null) {
                eVar.a();
            }
            this.f2277g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2275e = uptimeMillis;
            this.f2276f = uptimeMillis + 16;
            this.f2272b = f2;
            this.f2271a = 0.0f;
            this.f2273c = ((-HorizontalTranslateLayout.this.getMeasuredWidth()) + HorizontalTranslateLayout.this.f2265f) - HorizontalTranslateLayout.this.f2267h;
            this.f2274d = HorizontalTranslateLayout.this.f2267h;
            BdLog.d("Animator@animateTop " + this.f2273c);
            BdLog.d("Animator@animateTop " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(-100);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-100, this.f2276f);
        }

        public void b(float f2) {
            for (f fVar : HorizontalTranslateLayout.this.x) {
                if (fVar != null) {
                    fVar.a();
                }
            }
            this.f2277g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2275e = uptimeMillis;
            this.f2276f = uptimeMillis + 16;
            this.f2272b = f2;
            this.f2271a = 0.0f;
            this.f2273c = 0 - HorizontalTranslateLayout.this.f2267h;
            this.f2274d = HorizontalTranslateLayout.this.f2267h;
            HorizontalTranslateLayout.this.s.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.f2273c);
            BdLog.d("Animator@animateTopOpen " + f2);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-104, this.f2276f);
        }

        public void c(float f2) {
            g gVar = HorizontalTranslateLayout.this.w;
            if (gVar != null) {
                gVar.a();
            }
            this.f2277g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2275e = uptimeMillis;
            this.f2276f = uptimeMillis + 16;
            this.f2272b = f2;
            this.f2271a = 0.0f;
            this.f2273c = (HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2266g) - HorizontalTranslateLayout.this.f2267h;
            this.f2274d = HorizontalTranslateLayout.this.f2267h;
            BdLog.d("Animator@animateBottom " + this.f2273c);
            BdLog.d("Animator@animateBottom " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(-101);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-101, this.f2276f);
        }

        public void d(float f2) {
            for (f fVar : HorizontalTranslateLayout.this.x) {
                if (fVar != null) {
                    fVar.a();
                }
            }
            this.f2277g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2275e = uptimeMillis;
            this.f2276f = uptimeMillis + 16;
            this.f2272b = f2;
            this.f2271a = 0.0f;
            this.f2273c = 0 - HorizontalTranslateLayout.this.f2267h;
            this.f2274d = HorizontalTranslateLayout.this.f2267h;
            BdLog.d("Animator@animateBottomOpen " + this.f2273c);
            BdLog.d("Animator@animateBottomOpen " + f2);
            HorizontalTranslateLayout.this.s.removeMessages(-105);
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-105, this.f2276f);
        }

        public final void e() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2271a += this.f2272b * (((float) (uptimeMillis - this.f2275e)) / 1000.0f);
            this.f2275e = uptimeMillis;
            this.f2276f += 16;
        }

        public void f() {
            e();
            float f2 = this.f2271a;
            float f3 = this.f2273c;
            if (f2 <= f3) {
                e eVar = HorizontalTranslateLayout.this.v;
                if (eVar != null) {
                    eVar.b();
                }
                this.f2277g = false;
                HorizontalTranslateLayout.this.k = 10000;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2267h = (int) (d.a.c.j.h.a(f3, f2, false) + this.f2274d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-100, this.f2276f);
        }

        public void g() {
            e();
            float f2 = this.f2271a;
            float f3 = this.f2273c;
            if (f2 >= f3) {
                for (f fVar : HorizontalTranslateLayout.this.x) {
                    if (fVar != null) {
                        fVar.b();
                    }
                }
                this.f2277g = false;
                HorizontalTranslateLayout.this.k = 10004;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2267h = (int) (d.a.c.j.h.a(f3, f2, false) + this.f2274d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-104, this.f2276f);
        }

        public void h() {
            e();
            float f2 = this.f2271a;
            float f3 = this.f2273c;
            if (f2 >= f3) {
                g gVar = HorizontalTranslateLayout.this.w;
                if (gVar != null) {
                    gVar.b();
                }
                this.f2277g = false;
                HorizontalTranslateLayout.this.k = 10001;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2267h = (int) (d.a.c.j.h.a(f3, f2, false) + this.f2274d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-101, this.f2276f);
        }

        public void i() {
            e();
            float f2 = this.f2271a;
            float f3 = this.f2273c;
            if (f2 <= f3) {
                for (f fVar : HorizontalTranslateLayout.this.x) {
                    if (fVar != null) {
                        fVar.b();
                    }
                }
                this.f2277g = false;
                HorizontalTranslateLayout.this.k = 10004;
                HorizontalTranslateLayout.this.p();
                return;
            }
            HorizontalTranslateLayout.this.f2267h = (int) (d.a.c.j.h.a(f3, f2, false) + this.f2274d);
            HorizontalTranslateLayout.this.invalidate();
            HorizontalTranslateLayout.this.s.sendEmptyMessageAtTime(-105, this.f2276f);
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
        public VelocityTracker f2279a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2280b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2281c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2282d;

        public h() {
            float f2 = HorizontalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.f2281c = (int) ((200.0f * f2) + 0.5f);
            this.f2282d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b() {
            float max;
            this.f2279a.computeCurrentVelocity(this.f2281c);
            float xVelocity = this.f2279a.getXVelocity();
            BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
            if (xVelocity < 0.0f) {
                max = Math.min(xVelocity, -this.f2282d);
            } else {
                max = Math.max(xVelocity, this.f2282d);
            }
            int i2 = a.f2269a[HorizontalTranslateLayout.this.j.ordinal()];
            if (i2 == 1) {
                d(max);
            } else if (i2 == 2) {
                g(max);
            } else if (i2 == 3) {
                c(max);
            }
            this.f2279a.recycle();
            this.f2279a = null;
        }

        public final void c(float f2) {
            BdLog.d("HorizontalTranslateLayout@horizontalFling");
            int i2 = HorizontalTranslateLayout.this.f2267h;
            if (i2 <= 0 && i2 >= HorizontalTranslateLayout.this.f2265f - HorizontalTranslateLayout.this.getMeasuredWidth()) {
                if (f2 < 0.0f) {
                    HorizontalTranslateLayout.this.t.a(f2);
                } else {
                    HorizontalTranslateLayout.this.t.b(f2);
                }
            } else if (i2 < 0 || i2 > HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2266g) {
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
            if (this.f2280b) {
                int i3 = HorizontalTranslateLayout.this.f2267h - i2;
                int i4 = a.f2269a[HorizontalTranslateLayout.this.j.ordinal()];
                if (i4 == 1) {
                    BdLog.d("HorizontalTranslateLayout@move left");
                    if (i3 <= HorizontalTranslateLayout.this.f2265f - HorizontalTranslateLayout.this.getMeasuredWidth() || i3 >= 0) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2267h -= i2;
                    HorizontalTranslateLayout.this.invalidate();
                } else if (i4 == 2) {
                    BdLog.d("HorizontalTranslateLayout@move right");
                    if (i3 >= HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2266g || i3 <= 0) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2267h -= i2;
                    HorizontalTranslateLayout.this.invalidate();
                } else if (i4 != 3) {
                } else {
                    BdLog.d("HorizontalTranslateLayout@move horizontal");
                    float f2 = i3;
                    if (f2 < HorizontalTranslateLayout.this.f2265f - HorizontalTranslateLayout.this.getMeasuredWidth() || f2 > HorizontalTranslateLayout.this.getMeasuredWidth() - HorizontalTranslateLayout.this.f2266g) {
                        return;
                    }
                    HorizontalTranslateLayout.this.f2267h -= i2;
                    HorizontalTranslateLayout.this.invalidate();
                }
            }
        }

        public boolean f(int i2) {
            int i3 = a.f2269a[HorizontalTranslateLayout.this.j.ordinal()];
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
            this.f2279a = VelocityTracker.obtain();
            this.f2280b = true;
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
            this.f2280b = false;
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
        this.f2268i = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        o(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f2267h, 0.0f);
        BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.f2267h);
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.n);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getLeftOffset() {
        return (int) this.f2265f;
    }

    public int getLeftTranslate() {
        return this.f2267h;
    }

    public int getRightOffset() {
        return (int) this.f2266g;
    }

    public int getState() {
        return this.k;
    }

    public final void o(AttributeSet attributeSet) {
        String[] split;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
        this.f2265f = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
        this.f2266g = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (this.f2265f != -1.0f && this.f2266g != -1.0f && "horizontal".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                this.j = TrackDirection.horizontal;
            } else if (this.f2266g != -1.0f && "right".equals(string)) {
                BdLog.d("HorizontalTranslateLayout@parseTrack right");
                this.j = TrackDirection.right;
            } else if (this.f2265f != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
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
                if ((!CustomDialogData.POS_LEFT.equals(str) || this.f2265f == -1.0f) && (!"right".equals(str) || this.f2266g == -1.0f)) {
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
            motionEvent.offsetLocation(-this.f2267h, 0.0f);
            return q(x, y);
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            float f2 = this.f2265f;
            if (f2 != -1.0f) {
                this.l.set(i2, i3, (int) (i2 + f2), i5);
            }
            float f3 = this.f2266g;
            if (f3 != -1.0f) {
                this.m.set((int) (i4 - f3), i3, i4, i5);
            }
        }
        if (this.t.f2277g || this.u.f2280b) {
            return;
        }
        p();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f2264e = getMeasuredWidth();
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
                } else if (this.u.f2280b) {
                    if (!this.r) {
                        int i2 = this.o;
                        if (x > i2) {
                            this.q = i2 + this.f2268i;
                            this.r = true;
                        } else {
                            this.q = i2 - this.f2268i;
                            this.r = true;
                        }
                    }
                    this.u.e(this.q - x);
                    this.q = x;
                    this.u.f2279a.addMovement(motionEvent);
                }
            }
            BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
            this.r = false;
            if (this.u.f2280b) {
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
            if (hVar.f2280b) {
                hVar.h();
                this.u.b();
            }
        } else if ((this.k != 10000 || !this.l.contains(x, y)) && (this.k != 10001 || !this.m.contains(x, y))) {
            return false;
        } else {
            h hVar2 = this.u;
            if (!hVar2.f2280b) {
                this.q = x;
                hVar2.f(x);
            }
        }
        h hVar3 = this.u;
        if (hVar3.f2280b) {
            hVar3.e(this.q - x);
            this.q = x;
            this.u.f2279a.addMovement(motionEvent);
        }
        return true;
    }

    public final void p() {
        int i2 = this.k;
        if (i2 == 10000) {
            this.f2267h = (int) (this.f2265f - getMeasuredWidth());
            invalidate();
        } else if (i2 == 10001) {
            this.f2267h = (int) (getMeasuredWidth() - this.f2266g);
            invalidate();
        } else if (i2 != 10004) {
        } else {
            this.f2267h = 0;
            invalidate();
        }
    }

    public final boolean q(int i2, int i3) {
        int i4 = this.p;
        int i5 = this.f2268i;
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
            this.f2267h = (int) ((this.f2265f - this.f2264e) * (-f2));
        } else {
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 > 0) {
                this.f2267h = (int) ((this.f2264e - this.f2266g) * f2);
            } else if (i3 == 0) {
                this.f2267h = 0;
                this.k = 10004;
            } else if (f2 == -1.0f) {
                this.f2265f -= getMeasuredWidth();
                this.k = 10000;
            } else if (i2 == 0) {
                this.f2265f = getMeasuredWidth() - this.f2266g;
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
