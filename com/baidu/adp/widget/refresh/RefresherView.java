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
import d.b.b.j.i;
/* loaded from: classes.dex */
public class RefresherView extends ViewGroup {
    public final c A;
    public d.b.b.j.k.b B;
    public d C;
    public i D;
    public IRefreshable$State E;

    /* renamed from: e  reason: collision with root package name */
    public final int f2461e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2462f;

    /* renamed from: g  reason: collision with root package name */
    public int f2463g;

    /* renamed from: h  reason: collision with root package name */
    public int f2464h;
    public final int i;
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
        public long f2465a;

        /* renamed from: b  reason: collision with root package name */
        public long f2466b;

        /* renamed from: c  reason: collision with root package name */
        public int f2467c;

        /* renamed from: d  reason: collision with root package name */
        public int f2468d;

        /* renamed from: e  reason: collision with root package name */
        public int f2469e;

        public b() {
        }

        public void a(int i) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2465a = uptimeMillis;
            this.f2466b = uptimeMillis + 16;
            if (i == 1000) {
                this.f2469e = RefresherView.this.w - RefresherView.this.y;
                this.f2468d = 0;
                this.f2467c = Math.max(RefresherView.this.f2461e, (RefresherView.this.w - RefresherView.this.y) * 2);
                RefresherView.this.A.removeMessages(1000);
                RefresherView.this.A.sendEmptyMessageAtTime(1000, this.f2466b);
            } else if (i == 1001) {
                this.f2469e = RefresherView.this.f2463g;
                this.f2468d = 0;
                this.f2467c = RefresherView.this.f2462f;
                RefresherView.this.A.removeMessages(1001);
                RefresherView.this.A.sendEmptyMessageAtTime(1001, this.f2466b);
            }
            RefresherView.this.E = IRefreshable$State.animating;
            d.b.b.j.k.b bVar = RefresherView.this.B;
            if (bVar != null) {
                bVar.a(IRefreshable$State.animating);
            }
        }

        public void b() {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = (int) (this.f2468d + (this.f2467c * (((float) (uptimeMillis - this.f2465a)) / 1000.0f)));
            this.f2468d = i;
            if (i >= this.f2469e) {
                RefresherView refresherView = RefresherView.this;
                refresherView.w = refresherView.y;
                RefresherView.this.E = IRefreshable$State.idle;
                d.b.b.j.k.b bVar = RefresherView.this.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.idle);
                }
                if (RefresherView.this.y == 0 && bVar != null) {
                    bVar.c();
                    RefresherView.this.p = false;
                }
            } else {
                RefresherView refresherView2 = RefresherView.this;
                int i2 = this.f2469e;
                refresherView2.w = (int) (refresherView2.y + (i2 * (1.0f - d.b.b.j.a.f42331a.getInterpolation(this.f2468d / i2))));
                this.f2465a = uptimeMillis;
                this.f2466b = uptimeMillis + 16;
                RefresherView.this.A.removeMessages(1000);
                RefresherView.this.A.sendEmptyMessageAtTime(1000, this.f2466b);
            }
            RefresherView.this.invalidate();
        }

        public void c() {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = (int) (this.f2468d + (this.f2467c * (((float) (uptimeMillis - this.f2465a)) / 1000.0f)));
            this.f2468d = i;
            int i2 = this.f2469e;
            if (i >= i2) {
                RefresherView refresherView = RefresherView.this;
                refresherView.w = refresherView.f2463g;
                RefresherView.this.E = IRefreshable$State.idle;
                d.b.b.j.k.b bVar = RefresherView.this.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.idle);
                    RefresherView.this.W();
                }
            } else {
                RefresherView.this.w = d.b.b.j.a.a(i2, i, false);
                this.f2465a = uptimeMillis;
                this.f2466b = uptimeMillis + 16;
                RefresherView.this.A.removeMessages(1001);
                RefresherView.this.A.sendEmptyMessageAtTime(1001, this.f2466b);
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
            int i = message.what;
            if (i == 1000) {
                RefresherView.this.z.b();
            } else if (i == 1001) {
                RefresherView.this.z.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final d.b.b.j.k.b f2472a;

        public d() {
            this.f2472a = RefresherView.this.B;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r2) {
            RefresherView.this.y = 0;
            RefresherView.this.D.e(1000);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            if (this.f2472a != null) {
                RefresherView refresherView = RefresherView.this;
                refresherView.y = refresherView.f2463g;
                this.f2472a.b();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            RefresherView.this.p = true;
            d.b.b.j.k.b bVar = this.f2472a;
            if (bVar != null) {
                bVar.d();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class e extends Handler implements i {

        /* renamed from: e  reason: collision with root package name */
        public final int f2474e;

        /* renamed from: f  reason: collision with root package name */
        public long f2475f;

        /* renamed from: g  reason: collision with root package name */
        public long f2476g;

        /* renamed from: h  reason: collision with root package name */
        public float f2477h;
        public float i;
        public int j;

        public e() {
            double d2 = RefresherView.this.getResources().getDisplayMetrics().density * 75.0f;
            Double.isNaN(d2);
            this.f2474e = (int) (d2 + 0.5d);
        }

        @Override // d.b.b.j.i
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.l != null) {
                RefresherView.this.l.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.n != null) {
                RefresherView.this.n.layout((i5 - RefresherView.this.n.getMeasuredWidth()) / 2, (i6 - RefresherView.this.n.getMeasuredHeight()) / 2, (i5 + RefresherView.this.n.getMeasuredWidth()) / 2, (RefresherView.this.n.getMeasuredHeight() + i6) / 2);
            }
            if (RefresherView.this.m != null) {
                RefresherView.this.m.layout(-RefresherView.this.m.getMeasuredWidth(), 0, 0, i6);
            }
            RefresherView refresherView = RefresherView.this;
            refresherView.getLocationOnScreen(refresherView.t);
            RefresherView refresherView2 = RefresherView.this;
            refresherView2.v = refresherView2.t[0];
        }

        @Override // d.b.b.j.j
        public boolean b(MotionEvent motionEvent) {
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
                        if (RefresherView.this.s[0] == RefresherView.this.v && x > RefresherView.this.r + this.f2474e) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.b.b.j.k.b bVar = RefresherView.this.B;
                            if (bVar != null) {
                                bVar.a(IRefreshable$State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.s);
                        if (RefresherView.this.s[0] == RefresherView.this.v && x > RefresherView.this.r + this.f2474e) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.b.b.j.k.b bVar2 = RefresherView.this.B;
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

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
            if (r0 != 3) goto L7;
         */
        @Override // d.b.b.j.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean c(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            if (action != 1) {
                if (action == 2) {
                    RefresherView refresherView = RefresherView.this;
                    refresherView.x = Math.max(0, Math.min((x - refresherView.r) - this.f2474e, RefresherView.this.f2464h * 2));
                    if (RefresherView.this.x <= RefresherView.this.f2463g || RefresherView.this.E != IRefreshable$State.pulling_no_refresh) {
                        if (RefresherView.this.x < RefresherView.this.f2463g && RefresherView.this.E == IRefreshable$State.pulling_refresh) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.b.b.j.k.b bVar = RefresherView.this.B;
                            if (bVar != null) {
                                bVar.a(IRefreshable$State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.E = IRefreshable$State.pulling_refresh;
                        d.b.b.j.k.b bVar2 = RefresherView.this.B;
                        if (bVar2 != null) {
                            bVar2.a(IRefreshable$State.pulling_refresh);
                        }
                    }
                    RefresherView.this.invalidate();
                }
                return true;
            }
            if (RefresherView.this.x <= RefresherView.this.f2463g) {
                RefresherView.this.y = 0;
            } else {
                RefresherView.this.W();
            }
            e(1000);
            return true;
        }

        @Override // d.b.b.j.j
        public void d(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = i2 & 1073741823;
            if (RefresherView.this.l != null) {
                RefresherView refresherView = RefresherView.this;
                refresherView.measureChild(refresherView.l, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.n != null) {
                RefresherView refresherView2 = RefresherView.this;
                refresherView2.measureChild(refresherView2.n, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.m != null) {
                RefresherView refresherView3 = RefresherView.this;
                refresherView3.measureChild(refresherView3.m, Integer.MIN_VALUE + i3, 1073741824 + i4);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // d.b.b.j.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            RefresherView.super.dispatchTouchEvent(motionEvent);
            return true;
        }

        @Override // d.b.b.j.j
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

        @Override // d.b.b.j.j
        public void e(int i) {
            if (i == 1000) {
                f();
            } else if (i != 1001) {
            } else {
                g();
            }
        }

        public final void f() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2476g = uptimeMillis;
            this.f2475f = uptimeMillis + 16;
            this.i = RefresherView.this.x - RefresherView.this.y;
            this.f2477h = 0.0f;
            this.j = Math.max(RefresherView.this.f2461e, (RefresherView.this.x - RefresherView.this.y) * 2);
            removeMessages(1000);
            sendEmptyMessageAtTime(1000, this.f2475f);
        }

        public final void g() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f2476g = uptimeMillis;
            this.f2475f = uptimeMillis + 16;
            this.i = RefresherView.this.f2463g;
            this.f2477h = 0.0f;
            this.j = RefresherView.this.f2462f;
            removeMessages(1001);
            sendEmptyMessageAtTime(1001, this.f2475f);
        }

        public final void h() {
            long uptimeMillis = SystemClock.uptimeMillis();
            float f2 = this.f2477h + (this.j * (((float) (uptimeMillis - this.f2476g)) / 1000.0f));
            this.f2477h = f2;
            if (f2 >= this.i) {
                RefresherView refresherView = RefresherView.this;
                refresherView.x = refresherView.y;
                RefresherView.this.E = IRefreshable$State.idle;
                d.b.b.j.k.b bVar = RefresherView.this.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.idle);
                }
                if (RefresherView.this.y == 0 && bVar != null) {
                    bVar.c();
                    RefresherView.this.p = false;
                }
            } else {
                RefresherView refresherView2 = RefresherView.this;
                float f3 = this.i;
                refresherView2.x = (int) (refresherView2.y + (f3 * (1.0f - d.b.b.j.a.f42331a.getInterpolation(this.f2477h / f3))));
                this.f2476g = uptimeMillis;
                this.f2475f = uptimeMillis + 16;
                removeMessages(1000);
                sendEmptyMessageAtTime(1000, this.f2475f);
            }
            RefresherView.this.invalidate();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1000) {
                h();
            } else if (i != 1001) {
            } else {
                i();
            }
        }

        public final void i() {
            long uptimeMillis = SystemClock.uptimeMillis();
            float f2 = this.f2477h + (this.j * (((float) (uptimeMillis - this.f2476g)) / 1000.0f));
            this.f2477h = f2;
            float f3 = this.i;
            if (f2 >= f3) {
                RefresherView refresherView = RefresherView.this;
                refresherView.x = refresherView.f2463g;
                RefresherView.this.E = IRefreshable$State.idle;
                d.b.b.j.k.b bVar = RefresherView.this.B;
                if (bVar != null) {
                    bVar.a(IRefreshable$State.idle);
                    RefresherView.this.W();
                }
            } else {
                RefresherView.this.x = d.b.b.j.a.a(f3, f2, false);
                this.f2476g = uptimeMillis;
                this.f2475f = uptimeMillis + 16;
                removeMessages(1001);
                sendEmptyMessageAtTime(1001, this.f2475f);
            }
            RefresherView.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class f implements i {
        public f() {
        }

        @Override // d.b.b.j.i
        public void a(boolean z, int i, int i2, int i3, int i4) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (RefresherView.this.l != null) {
                RefresherView.this.l.layout(0, 0, i5, i6);
            }
            if (RefresherView.this.n != null) {
                RefresherView.this.n.layout((i5 - RefresherView.this.n.getMeasuredWidth()) / 2, (i6 - RefresherView.this.n.getMeasuredHeight()) / 2, (RefresherView.this.n.getMeasuredWidth() + i5) / 2, (i6 + RefresherView.this.n.getMeasuredHeight()) / 2);
            }
            if (RefresherView.this.m != null) {
                RefresherView.this.m.layout(0, -RefresherView.this.m.getMeasuredHeight(), i5, 0);
            }
            RefresherView refresherView = RefresherView.this;
            refresherView.getLocationOnScreen(refresherView.t);
            RefresherView refresherView2 = RefresherView.this;
            refresherView2.u = refresherView2.t[1];
        }

        @Override // d.b.b.j.j
        public boolean b(MotionEvent motionEvent) {
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
                            d.b.b.j.k.b bVar = RefresherView.this.B;
                            if (bVar != null) {
                                bVar.a(IRefreshable$State.pulling_no_refresh);
                            }
                            return true;
                        }
                    } else {
                        childAt.getLocationOnScreen(RefresherView.this.s);
                        if (RefresherView.this.s[1] == RefresherView.this.u && y > RefresherView.this.q) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.b.b.j.k.b bVar2 = RefresherView.this.B;
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

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
            if (r0 != 3) goto L7;
         */
        @Override // d.b.b.j.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean c(MotionEvent motionEvent) {
            int action = motionEvent.getAction() & 255;
            int y = (int) motionEvent.getY();
            if (action != 1) {
                if (action == 2) {
                    RefresherView refresherView = RefresherView.this;
                    refresherView.w = Math.max(0, Math.min(y - refresherView.q, RefresherView.this.f2464h * 2));
                    if (RefresherView.this.w <= RefresherView.this.f2463g || RefresherView.this.E != IRefreshable$State.pulling_no_refresh) {
                        if (RefresherView.this.w < RefresherView.this.f2463g && RefresherView.this.E == IRefreshable$State.pulling_refresh) {
                            RefresherView.this.E = IRefreshable$State.pulling_no_refresh;
                            d.b.b.j.k.b bVar = RefresherView.this.B;
                            if (bVar != null) {
                                bVar.a(IRefreshable$State.pulling_no_refresh);
                            }
                        }
                    } else {
                        RefresherView.this.E = IRefreshable$State.pulling_refresh;
                        d.b.b.j.k.b bVar2 = RefresherView.this.B;
                        if (bVar2 != null) {
                            bVar2.a(IRefreshable$State.pulling_refresh);
                        }
                    }
                    RefresherView.this.invalidate();
                }
                return true;
            }
            if (RefresherView.this.w <= RefresherView.this.f2463g) {
                RefresherView.this.y = 0;
            } else {
                RefresherView.this.W();
            }
            e(1000);
            return true;
        }

        @Override // d.b.b.j.j
        public void d(int i, int i2) {
            int i3 = i & 1073741823;
            int i4 = i2 & 1073741823;
            if (RefresherView.this.l != null) {
                RefresherView refresherView = RefresherView.this;
                refresherView.measureChild(refresherView.l, i3 + 1073741824, i4 + 1073741824);
            }
            if (RefresherView.this.n != null) {
                RefresherView refresherView2 = RefresherView.this;
                refresherView2.measureChild(refresherView2.n, i3 - 2147483648, i4 - 2147483648);
            }
            if (RefresherView.this.m != null) {
                RefresherView refresherView3 = RefresherView.this;
                refresherView3.measureChild(refresherView3.m, 1073741824 + i3, Integer.MIN_VALUE + i4);
            }
            RefresherView.this.setMeasuredDimension(i3, i4);
        }

        @Override // d.b.b.j.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            RefresherView.super.dispatchTouchEvent(motionEvent);
            return true;
        }

        @Override // d.b.b.j.j
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

        @Override // d.b.b.j.j
        public void e(int i) {
            RefresherView.this.z.a(i);
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
        int i = this.i;
        if (i != -1) {
            View findViewById = findViewById(i);
            this.l = findViewById;
            if (findViewById != null) {
                int i2 = this.j;
                if (i2 != -1) {
                    View findViewById2 = findViewById(i2);
                    this.m = findViewById2;
                    if (findViewById2 != null) {
                        int i3 = this.k;
                        if (i3 != -1) {
                            View findViewById3 = findViewById(i3);
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
        return this.D.b(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.D.a(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.D.d(i, i2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.D.c(motionEvent);
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

    public void setOnRefreshListener(d.b.b.j.k.b bVar) {
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

    public RefresherView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = true;
        this.s = new int[2];
        this.t = new int[2];
        this.E = IRefreshable$State.idle;
        this.z = new b();
        this.A = new c();
        float f2 = getResources().getDisplayMetrics().density;
        this.f2461e = (int) ((100.0f * f2) + 0.5f);
        this.f2462f = (int) ((500.0f * f2) + 0.5f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefresherView);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_threshold_height, -1);
        this.f2463g = dimensionPixelOffset;
        if (dimensionPixelOffset == -1) {
            this.f2463g = (int) ((200.0f * f2) + 0.5f);
        }
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RefresherView_max_height, -1);
        this.f2464h = dimensionPixelOffset2;
        if (dimensionPixelOffset2 == -1) {
            this.f2464h = (int) ((f2 * 400.0f) + 0.5f);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RefresherView_direction);
        if (string == null) {
            this.D = new f();
        } else if (string.equals("side")) {
            this.D = new e();
        } else if (string.equals("top")) {
            this.D = new f();
        }
        this.i = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_content, -1);
        this.j = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_refresher_head, -1);
        this.k = obtainStyledAttributes.getResourceId(R.styleable.RefresherView_empty_view, -1);
    }
}
