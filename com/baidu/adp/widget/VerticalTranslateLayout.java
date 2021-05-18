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
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    public final List<e> A;
    public g B;

    /* renamed from: e  reason: collision with root package name */
    public int f2398e;

    /* renamed from: f  reason: collision with root package name */
    public int f2399f;

    /* renamed from: g  reason: collision with root package name */
    public float f2400g;

    /* renamed from: h  reason: collision with root package name */
    public float f2401h;

    /* renamed from: i  reason: collision with root package name */
    public float f2402i;
    public float j;
    public int k;
    public final int l;
    public TrackDirection m;
    public int n;
    public final Rect o;
    public final Rect p;
    public final Paint q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public final b v;
    public final c w;
    public final h x;
    public f y;
    public d z;

    /* loaded from: classes.dex */
    public enum TrackDirection {
        top,
        bottom,
        vertical,
        none
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2403a;

        static {
            int[] iArr = new int[TrackDirection.values().length];
            f2403a = iArr;
            try {
                iArr[TrackDirection.top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2403a[TrackDirection.bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2403a[TrackDirection.vertical.ordinal()] = 3;
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
            if (VerticalTranslateLayout.this.w.f2411g) {
                int i2 = message.what;
                if (i2 == -105) {
                    VerticalTranslateLayout.this.w.g();
                } else if (i2 == -104) {
                    VerticalTranslateLayout.this.w.i();
                } else if (i2 == -101) {
                    VerticalTranslateLayout.this.w.f();
                } else if (i2 != -100) {
                } else {
                    VerticalTranslateLayout.this.w.h();
                }
            }
        }

        public /* synthetic */ b(VerticalTranslateLayout verticalTranslateLayout, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public float f2405a;

        /* renamed from: b  reason: collision with root package name */
        public float f2406b;

        /* renamed from: c  reason: collision with root package name */
        public float f2407c;

        /* renamed from: d  reason: collision with root package name */
        public float f2408d;

        /* renamed from: e  reason: collision with root package name */
        public long f2409e;

        /* renamed from: f  reason: collision with root package name */
        public long f2410f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2411g;

        public c() {
            float f2 = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f2) {
            d dVar = VerticalTranslateLayout.this.z;
            if (dVar != null) {
                dVar.a();
            }
            this.f2411g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2409e = uptimeMillis;
            this.f2410f = uptimeMillis + 16;
            this.f2406b = f2;
            this.f2405a = 0.0f;
            this.f2407c = (VerticalTranslateLayout.this.f2399f - VerticalTranslateLayout.this.f2402i) - VerticalTranslateLayout.this.k;
            this.f2408d = VerticalTranslateLayout.this.k;
            BdLog.d("Animator@animateBottom " + this.f2407c);
            BdLog.d("Animator@animateBottom " + f2);
            VerticalTranslateLayout.this.v.removeMessages(-101);
            VerticalTranslateLayout.this.v.sendEmptyMessageAtTime(-101, this.f2410f);
        }

        public void b(float f2) {
            for (e eVar : VerticalTranslateLayout.this.A) {
                if (eVar != null) {
                    eVar.a();
                }
            }
            this.f2411g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2409e = uptimeMillis;
            this.f2410f = uptimeMillis + 16;
            this.f2406b = f2;
            this.f2405a = 0.0f;
            this.f2407c = 0 - VerticalTranslateLayout.this.k;
            this.f2408d = VerticalTranslateLayout.this.k;
            BdLog.d("Animator@animateBottomOpen " + this.f2407c);
            BdLog.d("Animator@animateBottomOpen " + f2);
            VerticalTranslateLayout.this.v.removeMessages(-105);
            VerticalTranslateLayout.this.v.sendEmptyMessageAtTime(-105, this.f2410f);
        }

        public void c(float f2) {
            f fVar = VerticalTranslateLayout.this.y;
            if (fVar != null) {
                fVar.a();
            }
            this.f2411g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2409e = uptimeMillis;
            this.f2410f = uptimeMillis + 16;
            this.f2406b = f2;
            this.f2405a = 0.0f;
            this.f2407c = ((-VerticalTranslateLayout.this.f2399f) + VerticalTranslateLayout.this.f2400g) - VerticalTranslateLayout.this.k;
            this.f2408d = VerticalTranslateLayout.this.k;
            BdLog.d("Animator@animateTop " + this.f2407c);
            BdLog.d("Animator@animateTop " + f2);
            VerticalTranslateLayout.this.v.removeMessages(-100);
            VerticalTranslateLayout.this.v.sendEmptyMessageAtTime(-100, this.f2410f);
        }

        public void d(float f2) {
            for (e eVar : VerticalTranslateLayout.this.A) {
                if (eVar != null) {
                    eVar.a();
                }
            }
            this.f2411g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2409e = uptimeMillis;
            this.f2410f = uptimeMillis + 16;
            this.f2406b = f2;
            this.f2405a = 0.0f;
            this.f2407c = 0 - VerticalTranslateLayout.this.k;
            this.f2408d = VerticalTranslateLayout.this.k;
            VerticalTranslateLayout.this.v.removeMessages(-104);
            BdLog.d("Animator@animateTopOpen " + this.f2407c);
            BdLog.d("Animator@animateTopOpen " + f2);
            VerticalTranslateLayout.this.v.sendEmptyMessageAtTime(-104, this.f2410f);
        }

        public final void e() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2405a += this.f2406b * (((float) (uptimeMillis - this.f2409e)) / 1000.0f);
            this.f2409e = uptimeMillis;
            this.f2410f += 16;
        }

        public void f() {
            e();
            float f2 = this.f2405a;
            float f3 = this.f2407c;
            if (f2 >= f3) {
                d dVar = VerticalTranslateLayout.this.z;
                if (dVar != null) {
                    dVar.b();
                }
                this.f2411g = false;
                VerticalTranslateLayout.this.n = 10001;
                VerticalTranslateLayout.this.s();
                return;
            }
            VerticalTranslateLayout.this.k = (int) (d.a.c.j.a.a(f3, f2, false) + this.f2408d);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.v.sendEmptyMessageAtTime(-101, this.f2410f);
        }

        public void g() {
            e();
            float f2 = this.f2405a;
            float f3 = this.f2407c;
            if (f2 <= f3) {
                for (e eVar : VerticalTranslateLayout.this.A) {
                    if (eVar != null) {
                        eVar.b();
                    }
                }
                this.f2411g = false;
                VerticalTranslateLayout.this.n = 10004;
                VerticalTranslateLayout.this.s();
                return;
            }
            VerticalTranslateLayout.this.k = (int) (d.a.c.j.a.a(f3, f2, false) + this.f2408d);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.v.sendEmptyMessageAtTime(-105, this.f2410f);
        }

        public void h() {
            e();
            float f2 = this.f2405a;
            float f3 = this.f2407c;
            if (f2 <= f3) {
                f fVar = VerticalTranslateLayout.this.y;
                if (fVar != null) {
                    fVar.b();
                }
                this.f2411g = false;
                VerticalTranslateLayout.this.n = 10000;
                VerticalTranslateLayout.this.s();
                return;
            }
            VerticalTranslateLayout.this.k = (int) (d.a.c.j.a.a(f3, f2, false) + this.f2408d);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.v.sendEmptyMessageAtTime(-100, this.f2410f);
        }

        public void i() {
            e();
            float f2 = this.f2405a;
            float f3 = this.f2407c;
            if (f2 >= f3) {
                for (e eVar : VerticalTranslateLayout.this.A) {
                    if (eVar != null) {
                        eVar.b();
                    }
                }
                this.f2411g = false;
                VerticalTranslateLayout.this.n = 10004;
                VerticalTranslateLayout.this.s();
                return;
            }
            VerticalTranslateLayout.this.k = (int) (d.a.c.j.a.a(f3, f2, false) + this.f2408d);
            VerticalTranslateLayout.this.invalidate();
            VerticalTranslateLayout.this.v.sendEmptyMessageAtTime(-104, this.f2410f);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
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
        void a(int i2);
    }

    /* loaded from: classes.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public VelocityTracker f2413a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2414b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2415c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2416d;

        public h() {
            float f2 = VerticalTranslateLayout.this.getContext().getResources().getDisplayMetrics().density;
            this.f2415c = (int) ((200.0f * f2) + 0.5f);
            this.f2416d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b(float f2) {
            BdLog.d("VerticalTranslateLayout@bottomFling");
            if (f2 < 0.0f) {
                VerticalTranslateLayout.this.w.b(f2);
            } else {
                VerticalTranslateLayout.this.w.a(f2);
            }
        }

        public final void c() {
            float max;
            this.f2413a.computeCurrentVelocity(this.f2415c);
            float yVelocity = this.f2413a.getYVelocity();
            BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
            if (yVelocity < 0.0f) {
                max = Math.min(yVelocity, -this.f2416d);
            } else {
                max = Math.max(yVelocity, this.f2416d);
            }
            int i2 = a.f2403a[VerticalTranslateLayout.this.m.ordinal()];
            if (i2 == 1) {
                g(max);
            } else if (i2 == 2) {
                b(max);
            } else if (i2 == 3) {
                h(max);
            }
            this.f2413a.recycle();
            this.f2413a = null;
        }

        public void d(int i2) {
            if (this.f2414b) {
                int i3 = VerticalTranslateLayout.this.k - i2;
                int i4 = a.f2403a[VerticalTranslateLayout.this.m.ordinal()];
                if (i4 == 1) {
                    BdLog.d("VerticalTranslateLayout@move top");
                    if (i3 <= VerticalTranslateLayout.this.f2400g - VerticalTranslateLayout.this.f2399f || i3 >= 0) {
                        return;
                    }
                    VerticalTranslateLayout.this.k -= i2;
                    VerticalTranslateLayout.this.invalidate();
                } else if (i4 == 2) {
                    BdLog.d("VerticalTranslateLayout@move bottom");
                    if (i3 >= VerticalTranslateLayout.this.f2399f - VerticalTranslateLayout.this.f2402i || i3 <= 0) {
                        return;
                    }
                    VerticalTranslateLayout.this.k -= i2;
                    VerticalTranslateLayout.this.invalidate();
                } else if (i4 != 3) {
                } else {
                    BdLog.d("VerticalTranslateLayout@move vertical");
                    float f2 = i3;
                    if (f2 < VerticalTranslateLayout.this.f2400g - VerticalTranslateLayout.this.f2399f || f2 > VerticalTranslateLayout.this.f2399f - VerticalTranslateLayout.this.f2402i) {
                        return;
                    }
                    VerticalTranslateLayout.this.k -= i2;
                    VerticalTranslateLayout.this.invalidate();
                }
            }
        }

        public boolean e(int i2) {
            int i3 = a.f2403a[VerticalTranslateLayout.this.m.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && VerticalTranslateLayout.this.B != null) {
                        VerticalTranslateLayout.this.B.a(i2);
                    }
                } else if (VerticalTranslateLayout.this.n != 10004 && VerticalTranslateLayout.this.n != 10001) {
                    return false;
                }
            } else if (VerticalTranslateLayout.this.n != 10004 && VerticalTranslateLayout.this.n != 10000) {
                return false;
            }
            this.f2413a = VelocityTracker.obtain();
            this.f2414b = true;
            return true;
        }

        public void f() {
            this.f2414b = false;
        }

        public final void g(float f2) {
            BdLog.d("VerticalTranslateLayout@topFling");
            if (f2 < 0.0f) {
                VerticalTranslateLayout.this.w.c(f2);
            } else {
                VerticalTranslateLayout.this.w.d(f2);
            }
        }

        public final void h(float f2) {
            BdLog.d("VerticalTranslateLayout@verticalFling");
            int i2 = VerticalTranslateLayout.this.k;
            if (i2 <= 0 && i2 >= VerticalTranslateLayout.this.f2400g - VerticalTranslateLayout.this.f2399f) {
                if (f2 < 0.0f) {
                    VerticalTranslateLayout.this.w.c(f2);
                } else {
                    VerticalTranslateLayout.this.w.d(f2);
                }
            } else if (i2 < 0 || i2 > VerticalTranslateLayout.this.f2399f - VerticalTranslateLayout.this.f2402i) {
            } else {
                if (f2 < 0.0f) {
                    VerticalTranslateLayout.this.w.b(f2);
                } else {
                    VerticalTranslateLayout.this.w.a(f2);
                }
            }
        }
    }

    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.o = new Rect();
        this.p = new Rect();
        this.A = new ArrayList();
        this.v = new b(this, null);
        this.w = new c();
        this.x = new h();
        this.n = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.q = paint;
        paint.setColor(-1);
        this.l = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        r(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.k);
        BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.k);
        canvas.drawRect(0.0f, 0.0f, (float) this.f2398e, (float) this.f2399f, this.q);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getBottomOffset() {
        return (int) this.f2402i;
    }

    public int getState() {
        return this.n;
    }

    public int getTopOffset() {
        return (int) this.f2400g;
    }

    public int getTopTranslate() {
        return this.k;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.m == TrackDirection.none) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.n != 10004) {
            BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
            return true;
        }
        if (action == 0) {
            this.r = x;
            this.s = y;
            this.v.removeMessages(-100);
            this.v.removeMessages(-104);
            this.v.removeMessages(-101);
            this.v.removeMessages(-105);
        } else if (action == 2) {
            BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
            motionEvent.offsetLocation(0.0f, -this.k);
            return t(x, y);
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            float f2 = this.f2400g;
            if (f2 != -1.0f) {
                this.o.set(i2, i3, i4, (int) (i3 + f2));
            }
            float f3 = this.f2402i;
            if (f3 != -1.0f) {
                this.p.set(i2, (int) (i5 - f3), i4, i5);
            }
        }
        if (this.w.f2411g || this.x.f2414b) {
            return;
        }
        s();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = 1073741823 & i3;
        if (this.f2401h != -1.0f) {
            this.f2400g = i4 - this.j;
        }
        if (this.j != -1.0f) {
            this.f2402i = i4 - this.f2401h;
        }
        this.f2398e = getMeasuredWidth();
        this.f2399f = getMeasuredHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
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
        int i2 = this.n;
        if (i2 == 10004) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else if (this.x.f2414b) {
                    if (!this.u) {
                        int i3 = this.s;
                        if (y > i3) {
                            this.t = i3 + this.l;
                            this.u = true;
                        } else {
                            this.t = i3 - this.l;
                            this.u = true;
                        }
                    }
                    this.x.d(this.t - y);
                    this.t = y;
                    this.x.f2413a.addMovement(motionEvent);
                }
            }
            BdLog.d("VerticalTranslateLayout@onTouchEvent up");
            this.u = false;
            if (this.x.f2414b) {
                BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                this.x.f();
                this.x.c();
            }
            return true;
        }
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                }
            }
            h hVar = this.x;
            if (hVar.f2414b) {
                hVar.f();
                this.x.c();
            }
        } else if ((i2 != 10000 || !this.o.contains(x, y)) && (this.n != 10001 || !this.p.contains(x, y))) {
            return false;
        } else {
            h hVar2 = this.x;
            if (!hVar2.f2414b) {
                this.t = y;
                hVar2.e(y);
            }
        }
        h hVar3 = this.x;
        if (hVar3.f2414b) {
            hVar3.d(this.t - y);
            this.t = y;
            this.x.f2413a.addMovement(motionEvent);
        }
        return true;
    }

    public final boolean p() {
        return (this.f2402i == -1.0f && this.f2401h == -1.0f) ? false : true;
    }

    public final boolean q() {
        return (this.f2400g == -1.0f && this.j == -1.0f) ? false : true;
    }

    public final void r(AttributeSet attributeSet) {
        String[] split;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
        this.f2400g = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
        this.f2402i = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
        this.f2401h = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
        this.j = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
        String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
        if (string != null && string.length() > 0) {
            if (q() && p() && "vertical".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                this.m = TrackDirection.vertical;
            } else if (p() && TipsConfigItem.TipConfigData.BOTTOM.equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                this.m = TrackDirection.bottom;
            } else if (q() && "top".equals(string)) {
                BdLog.d("VerticalTranslateLayout@parseTrack top");
                this.m = TrackDirection.top;
            } else {
                this.m = TrackDirection.none;
                BdLog.d("VerticalTranslateLayout@parseTrack no direction");
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
        if (string2 != null && string2.length() > 0) {
            for (String str : string2.split("\\|")) {
                BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                if ((!"top".equals(str) || this.f2400g == -1.0f) && (!TipsConfigItem.TipConfigData.BOTTOM.equals(str) || this.f2402i == -1.0f)) {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                }
            }
        }
        this.q.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    public final void s() {
        int i2 = this.n;
        if (i2 == 10000) {
            this.k = (int) (this.f2400g - this.f2399f);
            invalidate();
        } else if (i2 == 10001) {
            this.k = (int) (this.f2399f - this.f2402i);
            invalidate();
        } else if (i2 != 10004) {
        } else {
            this.k = 0;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.q.setColor(i2);
        invalidate();
    }

    public void setBottomAnimationListener(d dVar) {
        this.z = dVar;
    }

    public void setBottomTapBack(boolean z) {
    }

    public void setProportion(float f2) {
        int i2;
        if (f2 < -1.0f || f2 > 1.0f) {
            return;
        }
        if (f2 < 0.0f) {
            this.k = (int) ((this.f2400g - this.f2399f) * (-f2));
        } else {
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 > 0) {
                this.k = (int) ((this.f2399f - this.f2402i) * f2);
            } else if (i3 == 0) {
                this.k = 0;
                this.n = 10004;
            } else if (f2 == -1.0f) {
                this.f2400g -= this.f2399f;
                this.n = 10000;
            } else if (i2 == 0) {
                this.f2400g = this.f2399f - this.f2402i;
                this.n = 10001;
            }
        }
        invalidate();
    }

    public void setTopAnimationListener(f fVar) {
        this.y = fVar;
    }

    public void setTopTapBack(boolean z) {
    }

    public void setVerticalTrackListener(g gVar) {
        this.B = gVar;
    }

    public final boolean t(int i2, int i3) {
        int i4 = this.r;
        int i5 = this.l;
        if (i2 >= i4 - i5 && i2 <= i4 + i5) {
            int i6 = this.s;
            if ((i3 < i6 - i5 || i3 > i6 + i5) && this.x.e(i3 - this.s)) {
                return true;
            }
        }
        return false;
    }
}
