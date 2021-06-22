package com.baidu.adp.widget.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.R;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.a.c.k.i;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class RefresherView extends ViewGroup {
    public final c A;
    public d.a.c.k.k.b B;
    public d C;
    public i D;
    public IRefreshable$State E;

    /* renamed from: e  reason: collision with root package name */
    public final int f2514e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2515f;

    /* renamed from: g  reason: collision with root package name */
    public int f2516g;

    /* renamed from: h  reason: collision with root package name */
    public int f2517h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2518i;
    public final int j;
    public final int k;
    public View l;
    public View m;
    public View n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public final int[] s;
    public final int[] t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public final b z;

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f2519a;

        /* renamed from: b  reason: collision with root package name */
        public long f2520b;

        /* renamed from: c  reason: collision with root package name */
        public int f2521c;

        /* renamed from: d  reason: collision with root package name */
        public int f2522d;

        /* renamed from: e  reason: collision with root package name */
        public int f2523e;

        public b() {
        }

        public void a(int i2) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2519a = uptimeMillis;
            this.f2520b = uptimeMillis + 16;
            if (i2 == 1000) {
                this.f2523e = RefresherView.this.w - RefresherView.this.y;
                this.f2522d = 0;
                this.f2521c = Math.max(RefresherView.this.f2514e, (RefresherView.this.w - RefresherView.this.y) * 2);
                RefresherView.this.A.removeMessages(1000);
                RefresherView.this.A.sendEmptyMessageAtTime(1000, this.f2520b);
            } else if (i2 == 1001) {
                this.f2523e = RefresherView.this.f2516g;
                this.f2522d = 0;
                this.f2521c = RefresherView.this.f2515f;
                RefresherView.this.A.removeMessages(1001);
                RefresherView.this.A.sendEmptyMessageAtTime(1001, this.f2520b);
            }
            RefresherView.this.E = IRefreshable$State.animating;
            d.a.c.k.k.b bVar = RefresherView.this.B;
            if (bVar != null) {
                bVar.a(IRefreshable$State.animating);
            }
        }

        public void b() {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = (int) (this.f2522d + (this.f2521c * (((float) (uptimeMillis - this.f2519a)) / 1000.0f)));
            this.f2522d = i2;
            if (i2 >= this.f2523e) {
                RefresherView refresherView = RefresherView.this;
                refresherView.w = refresherView.y;
                RefresherView.this.E = IRefreshable$State.idle;
                d.a.c.k.k.b bVar = RefresherView.this.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.idle);
                }
                if (RefresherView.this.y == 0 && bVar != null) {
                    bVar.b();
                    RefresherView.this.p = false;
                }
            } else {
                RefresherView refresherView2 = RefresherView.this;
                int i3 = this.f2523e;
                refresherView2.w = (int) (refresherView2.y + (i3 * (1.0f - d.a.c.k.a.f42984a.getInterpolation(this.f2522d / i3))));
                this.f2519a = uptimeMillis;
                this.f2520b = uptimeMillis + 16;
                RefresherView.this.A.removeMessages(1000);
                RefresherView.this.A.sendEmptyMessageAtTime(1000, this.f2520b);
            }
            RefresherView.this.invalidate();
        }

        public void c() {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = (int) (this.f2522d + (this.f2521c * (((float) (uptimeMillis - this.f2519a)) / 1000.0f)));
            this.f2522d = i2;
            int i3 = this.f2523e;
            if (i2 >= i3) {
                RefresherView refresherView = RefresherView.this;
                refresherView.w = refresherView.f2516g;
                RefresherView.this.E = IRefreshable$State.idle;
                d.a.c.k.k.b bVar = RefresherView.this.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.idle);
                    RefresherView.this.W();
                }
            } else {
                RefresherView.this.w = d.a.c.k.a.a(i3, i2, false);
                this.f2519a = uptimeMillis;
                this.f2520b = uptimeMillis + 16;
                RefresherView.this.A.removeMessages(1001);
                RefresherView.this.A.sendEmptyMessageAtTime(1001, this.f2520b);
            }
            RefresherView.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1000) {
                RefresherView.this.z.b();
            } else if (i2 == 1001) {
                RefresherView.this.z.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final d.a.c.k.k.b f2526a;

        public d() {
            this.f2526a = RefresherView.this.B;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r2) {
            RefresherView.this.y = 0;
            RefresherView.this.D.c(1000);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.f2526a != null) {
                RefresherView refresherView = RefresherView.this;
                refresherView.y = refresherView.f2516g;
                this.f2526a.d();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.p = true;
            d.a.c.k.k.b bVar = this.f2526a;
            if (bVar != null) {
                bVar.c();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class e extends Handler implements i {

        /* renamed from: e  reason: collision with root package name */
        public final int f2528e;

        /* renamed from: f  reason: collision with root package name */
        public long f2529f;

        /* renamed from: g  reason: collision with root package name */
        public long f2530g;

        /* renamed from: h  reason: collision with root package name */
        public float f2531h;

        /* renamed from: i  reason: collision with root package name */
        public float f2532i;
        public int j;

        public e() {
            this.f2528e = (int) ((RefresherView.this.getResources().getDisplayMetrics().density * 75.0f) + 0.5d);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
            if (r0 != 3) goto L7;
         */
        @Override // d.a.c.k.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            if (action != 1) {
                if (action == 2) {
                    RefresherView refresherView = RefresherView.this;
                    refresherView.x = Math.max(0, Math.min((x - refresherView.r) - this.f2528e, RefresherView.this.f2517h * 2));
                    if (RefresherView.this.x <= RefresherView.this.f2516g || RefresherView.this.E != IRefreshable$State.pulling_no_refresh) {
                        if (RefresherView.this.x < RefresherView.this.f2516g && RefresherView.this.E == IRefreshable$State.pulling_refresh) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.a.c.k.k.b bVar = RefresherView.this.B;
                            if (bVar != null) {
                                bVar.a(IRefreshable$State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.E = IRefreshable$State.pulling_refresh;
                        d.a.c.k.k.b bVar2 = RefresherView.this.B;
                        if (bVar2 != null) {
                            bVar2.a(IRefreshable$State.pulling_refresh);
                        }
                    }
                    RefresherView.this.invalidate();
                }
                return true;
            }
            if (RefresherView.this.x <= RefresherView.this.f2516g) {
                RefresherView.this.y = 0;
            } else {
                RefresherView.this.W();
            }
            c(1000);
            return true;
        }

        @Override // d.a.c.k.j
        public void b(int i2, int i3) {
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i5 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            if (RefresherView.this.l != null) {
                RefresherView refresherView = RefresherView.this;
                refresherView.measureChild(refresherView.l, i4 + 1073741824, i5 + 1073741824);
            }
            if (RefresherView.this.n != null) {
                RefresherView refresherView2 = RefresherView.this;
                refresherView2.measureChild(refresherView2.n, i4 - 2147483648, i5 - 2147483648);
            }
            if (RefresherView.this.m != null) {
                RefresherView refresherView3 = RefresherView.this;
                refresherView3.measureChild(refresherView3.m, Integer.MIN_VALUE + i4, 1073741824 + i5);
            }
            RefresherView.this.setMeasuredDimension(i4, i5);
        }

        @Override // d.a.c.k.j
        public void c(int i2) {
            if (i2 == 1000) {
                f();
            } else if (i2 != 1001) {
            } else {
                g();
            }
        }

        @Override // d.a.c.k.i
        public void d(boolean z, int i2, int i3, int i4, int i5) {
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (RefresherView.this.l != null) {
                RefresherView.this.l.layout(0, 0, i6, i7);
            }
            if (RefresherView.this.n != null) {
                RefresherView.this.n.layout((i6 - RefresherView.this.n.getMeasuredWidth()) / 2, (i7 - RefresherView.this.n.getMeasuredHeight()) / 2, (i6 + RefresherView.this.n.getMeasuredWidth()) / 2, (RefresherView.this.n.getMeasuredHeight() + i7) / 2);
            }
            if (RefresherView.this.m != null) {
                RefresherView.this.m.layout(-RefresherView.this.m.getMeasuredWidth(), 0, 0, i7);
            }
            RefresherView refresherView = RefresherView.this;
            refresherView.getLocationOnScreen(refresherView.t);
            RefresherView refresherView2 = RefresherView.this;
            refresherView2.v = refresherView2.t[0];
        }

        @Override // d.a.c.k.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            RefresherView.super.dispatchTouchEvent(motionEvent);
            return true;
        }

        @Override // d.a.c.k.j
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.n != null) {
                RefresherView refresherView = RefresherView.this;
                refresherView.drawChild(canvas, refresherView.n, drawingTime);
            }
            canvas.save();
            canvas.translate(RefresherView.this.x >> 1, 0.0f);
            RefresherView refresherView2 = RefresherView.this;
            refresherView2.drawChild(canvas, refresherView2.l, drawingTime);
            if (RefresherView.this.x > 0) {
                RefresherView refresherView3 = RefresherView.this;
                refresherView3.drawChild(canvas, refresherView3.m, drawingTime);
            }
            canvas.restore();
        }

        @Override // d.a.c.k.j
        public boolean e(MotionEvent motionEvent) {
            View childAt;
            if (RefresherView.this.o && !RefresherView.this.p) {
                int action = motionEvent.getAction() & 255;
                int x = (int) motionEvent.getX();
                if (action == 0) {
                    RefresherView.this.r = x;
                    removeMessages(1000);
                    removeMessages(1001);
                } else if (action == 2) {
                    if (!(RefresherView.this.l instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.l).getChildAt(0)) == null) {
                        RefresherView.this.l.getLocationOnScreen(RefresherView.this.s);
                        if (RefresherView.this.s[0] == RefresherView.this.v && x > RefresherView.this.r + this.f2528e) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.a.c.k.k.b bVar = RefresherView.this.B;
                            if (bVar != null) {
                                bVar.a(IRefreshable$State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.s);
                        if (RefresherView.this.s[0] == RefresherView.this.v && x > RefresherView.this.r + this.f2528e) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.a.c.k.k.b bVar2 = RefresherView.this.B;
                            if (bVar2 != null) {
                                bVar2.a(IRefreshable$State.pulling_no_refresh);
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public final void f() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2530g = uptimeMillis;
            this.f2529f = uptimeMillis + 16;
            this.f2532i = RefresherView.this.x - RefresherView.this.y;
            this.f2531h = 0.0f;
            this.j = Math.max(RefresherView.this.f2514e, (RefresherView.this.x - RefresherView.this.y) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.f2529f);
        }

        public final void g() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2530g = uptimeMillis;
            this.f2529f = uptimeMillis + 16;
            this.f2532i = RefresherView.this.f2516g;
            this.f2531h = 0.0f;
            this.j = RefresherView.this.f2515f;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.f2529f);
        }

        public final void h() {
            long uptimeMillis = SystemClock.uptimeMillis();
            float f2 = this.f2531h + (this.j * (((float) (uptimeMillis - this.f2530g)) / 1000.0f));
            this.f2531h = f2;
            if (f2 >= this.f2532i) {
                RefresherView refresherView = RefresherView.this;
                refresherView.x = refresherView.y;
                RefresherView.this.E = IRefreshable$State.idle;
                d.a.c.k.k.b bVar = RefresherView.this.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.idle);
                }
                if (RefresherView.this.y == 0 && bVar != null) {
                    bVar.b();
                    RefresherView.this.p = false;
                }
            } else {
                RefresherView refresherView2 = RefresherView.this;
                float f3 = this.f2532i;
                refresherView2.x = (int) (refresherView2.y + (f3 * (1.0f - d.a.c.k.a.f42984a.getInterpolation(this.f2531h / f3))));
                this.f2530g = uptimeMillis;
                this.f2529f = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.f2529f);
            }
            RefresherView.this.invalidate();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1000) {
                h();
            } else if (i2 != 1001) {
            } else {
                i();
            }
        }

        public final void i() {
            long uptimeMillis = SystemClock.uptimeMillis();
            float f2 = this.f2531h + (this.j * (((float) (uptimeMillis - this.f2530g)) / 1000.0f));
            this.f2531h = f2;
            float f3 = this.f2532i;
            if (f2 >= f3) {
                RefresherView refresherView = RefresherView.this;
                refresherView.x = refresherView.f2516g;
                RefresherView.this.E = IRefreshable$State.idle;
                d.a.c.k.k.b bVar = RefresherView.this.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.idle);
                    RefresherView.this.W();
                }
            } else {
                RefresherView.this.x = d.a.c.k.a.a(f3, f2, false);
                this.f2530g = uptimeMillis;
                this.f2529f = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.f2529f);
            }
            RefresherView.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class f implements i {
        public f() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
            if (r0 != 3) goto L7;
         */
        @Override // d.a.c.k.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            if (action != 1) {
                if (action == 2) {
                    RefresherView refresherView = RefresherView.this;
                    refresherView.w = Math.max(0, Math.min(y - refresherView.q, RefresherView.this.f2517h * 2));
                    if (RefresherView.this.w <= RefresherView.this.f2516g || RefresherView.this.E != IRefreshable$State.pulling_no_refresh) {
                        if (RefresherView.this.w < RefresherView.this.f2516g && RefresherView.this.E == IRefreshable$State.pulling_refresh) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.a.c.k.k.b bVar = RefresherView.this.B;
                            if (bVar != null) {
                                bVar.a(IRefreshable$State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.E = IRefreshable$State.pulling_refresh;
                        d.a.c.k.k.b bVar2 = RefresherView.this.B;
                        if (bVar2 != null) {
                            bVar2.a(IRefreshable$State.pulling_refresh);
                        }
                    }
                    RefresherView.this.invalidate();
                }
                return true;
            }
            if (RefresherView.this.w <= RefresherView.this.f2516g) {
                RefresherView.this.y = 0;
            } else {
                RefresherView.this.W();
            }
            c(1000);
            return true;
        }

        @Override // d.a.c.k.j
        public void b(int i2, int i3) {
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i5 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            if (RefresherView.this.l != null) {
                RefresherView refresherView = RefresherView.this;
                refresherView.measureChild(refresherView.l, i4 + 1073741824, i5 + 1073741824);
            }
            if (RefresherView.this.n != null) {
                RefresherView refresherView2 = RefresherView.this;
                refresherView2.measureChild(refresherView2.n, i4 - 2147483648, i5 - 2147483648);
            }
            if (RefresherView.this.m != null) {
                RefresherView refresherView3 = RefresherView.this;
                refresherView3.measureChild(refresherView3.m, 1073741824 + i4, Integer.MIN_VALUE + i5);
            }
            RefresherView.this.setMeasuredDimension(i4, i5);
        }

        @Override // d.a.c.k.j
        public void c(int i2) {
            RefresherView.this.z.a(i2);
        }

        @Override // d.a.c.k.i
        public void d(boolean z, int i2, int i3, int i4, int i5) {
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (RefresherView.this.l != null) {
                RefresherView.this.l.layout(0, 0, i6, i7);
            }
            if (RefresherView.this.n != null) {
                RefresherView.this.n.layout((i6 - RefresherView.this.n.getMeasuredWidth()) / 2, (i7 - RefresherView.this.n.getMeasuredHeight()) / 2, (RefresherView.this.n.getMeasuredWidth() + i6) / 2, (i7 + RefresherView.this.n.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.m != null) {
                RefresherView.this.m.layout(0, -RefresherView.this.m.getMeasuredHeight(), i6, 0);
            }
            RefresherView refresherView = RefresherView.this;
            refresherView.getLocationOnScreen(refresherView.t);
            RefresherView refresherView2 = RefresherView.this;
            refresherView2.u = refresherView2.t[1];
        }

        @Override // d.a.c.k.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            RefresherView.super.dispatchTouchEvent(motionEvent);
            return true;
        }

        @Override // d.a.c.k.j
        public void draw(Canvas canvas) {
            long drawingTime = RefresherView.this.getDrawingTime();
            if (RefresherView.this.n != null) {
                RefresherView refresherView = RefresherView.this;
                refresherView.drawChild(canvas, refresherView.n, drawingTime);
            }
            canvas.save();
            canvas.translate(0.0f, RefresherView.this.w / 2);
            RefresherView refresherView2 = RefresherView.this;
            refresherView2.drawChild(canvas, refresherView2.l, drawingTime);
            if (RefresherView.this.w > 0) {
                RefresherView refresherView3 = RefresherView.this;
                refresherView3.drawChild(canvas, refresherView3.m, drawingTime);
            }
            canvas.restore();
        }

        @Override // d.a.c.k.j
        public boolean e(MotionEvent motionEvent) {
            View childAt;
            if (RefresherView.this.o && !RefresherView.this.p) {
                int action = motionEvent.getAction() & 255;
                int y = (int) motionEvent.getY();
                if (action == 0) {
                    RefresherView.this.q = y;
                    RefresherView.this.A.removeMessages(1000);
                } else if (action == 2) {
                    if (!(RefresherView.this.l instanceof ViewGroup) || (childAt = ((ViewGroup) RefresherView.this.l).getChildAt(0)) == null) {
                        RefresherView.this.l.getLocationOnScreen(RefresherView.this.s);
                        if (RefresherView.this.s[1] == RefresherView.this.u && y > RefresherView.this.q) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.a.c.k.k.b bVar = RefresherView.this.B;
                            if (bVar != null) {
                                bVar.a(IRefreshable$State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.s);
                        if (RefresherView.this.s[1] == RefresherView.this.u && y > RefresherView.this.q) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.a.c.k.k.b bVar2 = RefresherView.this.B;
                            if (bVar2 != null) {
                                bVar2.a(IRefreshable$State.pulling_no_refresh);
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public RefresherView(Context context) {
        this(context, null, 0);
    }

    public void W() {
        d dVar = this.C;
        if (dVar == null || dVar.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
            d dVar2 = new d();
            this.C = dVar2;
            dVar2.execute(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.D.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.D.dispatchTouchEvent(motionEvent);
    }

    public View getEmptyView() {
        return this.n;
    }

    public View getRefresherContent() {
        return this.l;
    }

    public View getRefresherHeader() {
        return this.m;
    }

    public IRefreshable$State getState() {
        return this.E;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.o;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int i2 = this.f2518i;
        if (i2 != -1) {
            View findViewById = findViewById(i2);
            this.l = findViewById;
            if (findViewById != null) {
                int i3 = this.j;
                if (i3 != -1) {
                    View findViewById2 = findViewById(i3);
                    this.m = findViewById2;
                    if (findViewById2 != null) {
                        int i4 = this.k;
                        if (i4 != -1) {
                            View findViewById3 = findViewById(i4);
                            this.n = findViewById3;
                            if (findViewById3 == null) {
                                throw new RuntimeException("empty view not found in the view tree by the empty view's id");
                            }
                            return;
                        }
                        throw new RuntimeException("empty view id is not set in xml, or call setEmptyView before add it to a view tree");
                    }
                    throw new RuntimeException("refresher header not found in the view tree by the header id.");
                }
                throw new RuntimeException("refresher head id is not set in xml, or call setRefresherHeader before add it to a view tree.");
            }
            throw new RuntimeException("refresher content not found in the view tree by the content id.");
        }
        throw new RuntimeException("refresher content id is not set in xml, or call setRefresherContent before add it to a view tree.");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.D.e(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.D.d(z, i2, i3, i4, i5);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.D.b(i2, i3);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.D.a(motionEvent);
    }

    public void setEmptyView(View view) {
        removeView(this.n);
        this.n = view;
        if (view != null) {
            addView(view);
        }
    }

    public void setEnable(boolean z) {
        this.o = (!z || this.l == null || this.m == null) ? false : true;
    }

    public void setOnRefreshListener(d.a.c.k.k.b bVar) {
        this.B = bVar;
    }

    public void setRefresherContent(ViewGroup viewGroup) {
        removeView(this.l);
        this.l = viewGroup;
        boolean z = false;
        if (viewGroup == null) {
            this.o = false;
            return;
        }
        addView(viewGroup);
        if (this.m != null && this.l != null) {
            z = true;
        }
        this.o = z;
    }

    public void setRefresherHeader(View view) {
        removeView(this.m);
        this.m = view;
        boolean z = false;
        if (view == null) {
            this.o = false;
            return;
        }
        addView(view);
        if (this.m != null && this.l != null) {
            z = true;
        }
        this.o = z;
    }

    public RefresherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefresherView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = true;
        this.s = new int[2];
        this.t = new int[2];
        this.E = IRefreshable$State.idle;
        this.z = new b();
        this.A = new c();
        float f2 = getResources().getDisplayMetrics().density;
        this.f2514e = (int) ((100.0f * f2) + 0.5f);
        this.f2515f = (int) ((500.0f * f2) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        this.f2516g = dimensionPixelOffset;
        if (dimensionPixelOffset == -1) {
            this.f2516g = (int) ((200.0f * f2) + 0.5f);
        }
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        this.f2517h = dimensionPixelOffset2;
        if (dimensionPixelOffset2 == -1) {
            this.f2517h = (int) ((f2 * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.D = new f();
        } else if (string.equals("side")) {
            this.D = new e();
        } else if (string.equals("top")) {
            this.D = new f();
        }
        this.f2518i = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.j = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.k = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }
}
