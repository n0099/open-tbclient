package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.j.e.e;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdListView extends ListView implements d.a.c.j.e.p<BdListView> {
    public Runnable A;
    public int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public n H;
    public Runnable I;
    public t J;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.j.e.e f2310e;

    /* renamed from: f  reason: collision with root package name */
    public AdapterView.OnItemClickListener f2311f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemLongClickListener f2312g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f2313h;

    /* renamed from: i  reason: collision with root package name */
    public m f2314i;
    public l j;
    public AbsListView.OnScrollListener k;
    public o l;
    public r m;
    public long n;
    public s o;
    public int p;
    public p q;
    public q r;
    public d.a.c.j.e.b s;
    public d.a.c.j.e.b t;
    public View u;
    public int v;
    public d.a.c.a.i w;
    public Runnable x;
    public final d.a.c.j.e.q y;
    public Runnable z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BdListView bdListView = BdListView.this;
            bdListView.setSelection(bdListView.getCount() - 1);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BdListView.this.J != null) {
                BdListView.this.J.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BdListView.this.l != null) {
                int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                int i2 = 0;
                int i3 = -1;
                if (BdListView.this.f2310e == null || BdListView.this.f2310e.getWrappedAdapter() == null || BdListView.this.f2310e.o() <= 0) {
                    i2 = -1;
                } else {
                    int n = firstVisiblePosition - BdListView.this.f2310e.n();
                    i3 = n < 0 ? 0 : n;
                    int n2 = lastVisiblePosition - BdListView.this.f2310e.n();
                    if (n2 >= BdListView.this.f2310e.o()) {
                        n2 = BdListView.this.f2310e.o() - 1;
                    }
                    if (n2 >= 0) {
                        i2 = n2;
                    }
                }
                BdListView.this.l.onScrollStop(i3, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements d.a.c.j.e.q {
        public d() {
        }

        @Override // d.a.c.j.e.q
        public void cancelRefresh() {
            BdListView bdListView = BdListView.this;
            bdListView.removeCallbacks(bdListView.z);
        }

        @Override // d.a.c.j.e.q
        public d.a.c.j.e.o getAdapter() {
            return BdListView.this.getAdapter2();
        }

        @Override // d.a.c.j.e.q
        public int getFirstVisiblePosition() {
            return BdListView.this.getFirstVisiblePosition();
        }

        @Override // d.a.c.j.e.q
        public int getLastVisiblePosition() {
            return BdListView.this.getLastVisiblePosition();
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        public final void a(View view) {
            if (view == null) {
                return;
            }
            if (view instanceof d.a.c.f.a.i) {
                ((d.a.c.f.a.i) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.a.i c2;
            int childCount = BdListView.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(BdListView.this.getChildAt(i2));
            }
            if (BdListView.this.w != null) {
                c2 = BdListView.this.w;
            } else {
                c2 = d.a.c.a.j.c(BdListView.this.getContext());
            }
            if (c2 != null) {
                c2.onPreLoad(BdListView.this.y);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.a.i c2;
            if (BdListView.this.w != null) {
                c2 = BdListView.this.w;
            } else {
                c2 = d.a.c.a.j.c(BdListView.this.getContext());
            }
            if (c2 != null) {
                c2.onPreLoad(BdListView.this.y);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements e.b {
        public g() {
        }

        @Override // d.a.c.j.e.e.b
        public void onPreLoad() {
            BdListView bdListView = BdListView.this;
            bdListView.removeCallbacks(bdListView.A);
            BdListView bdListView2 = BdListView.this;
            bdListView2.postDelayed(bdListView2.A, 100L);
        }
    }

    /* loaded from: classes.dex */
    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            int n = BdListView.this.f2310e.n();
            if (i2 < n) {
                if (BdListView.this.s == null || view != BdListView.this.s.b()) {
                    if (BdListView.this.f2314i != null) {
                        BdListView.this.f2314i.onClick(view);
                        return;
                    }
                    return;
                }
                BdListView.this.s.c();
                return;
            }
            int i3 = i2 - n;
            ListAdapter wrappedAdapter = BdListView.this.f2310e.getWrappedAdapter();
            if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                if (BdListView.this.t == null || view != BdListView.this.t.b()) {
                    if (BdListView.this.j != null) {
                        BdListView.this.j.onClick(view);
                        return;
                    }
                    return;
                }
                BdListView.this.t.c();
            } else if (BdListView.this.f2311f != null) {
                BdListView.this.f2311f.onItemClick(adapterView, view, i3, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements AbsListView.OnScrollListener {
        public i() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            BdListView.this.v = i2;
            if (BdListView.this.k != null) {
                BdListView.this.k.onScroll(absListView, i2, i3, i4);
            }
            if (BdListView.this.l == null || BdListView.this.n <= 0) {
                return;
            }
            BdListView.this.getHandler().removeCallbacks(BdListView.this.x);
            BdListView.this.getHandler().postDelayed(BdListView.this.x, BdListView.this.n);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            d.a.c.a.i c2;
            if (BdListView.this.w != null) {
                c2 = BdListView.this.w;
            } else {
                c2 = d.a.c.a.j.c(BdListView.this.getContext());
            }
            if (c2 != null) {
                if (i2 == 2) {
                    BdListView bdListView = BdListView.this;
                    bdListView.removeCallbacks(bdListView.z);
                    c2.setIsScroll(true);
                } else if (c2.isScroll()) {
                    c2.setIsScroll(false);
                    BdListView bdListView2 = BdListView.this;
                    bdListView2.removeCallbacks(bdListView2.z);
                    BdListView bdListView3 = BdListView.this;
                    bdListView3.postDelayed(bdListView3.z, 100L);
                } else if (i2 == 0) {
                    BdListView bdListView4 = BdListView.this;
                    bdListView4.removeCallbacks(bdListView4.A);
                    BdListView bdListView5 = BdListView.this;
                    bdListView5.postDelayed(bdListView5.A, 100L);
                }
            }
            if (BdListView.this.k != null) {
                BdListView.this.k.onScrollStateChanged(absListView, i2);
            }
            if (i2 == 0) {
                if (BdListView.this.q != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                    BdListView.this.q.onScrollToBottom();
                }
                if (BdListView.this.r != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                    BdListView.this.r.q(BdListView.this);
                }
                if (BdListView.this.o == null || absListView.getFirstVisiblePosition() > BdListView.this.p) {
                    return;
                }
                BdListView.this.o.onScrollToTop();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements AdapterView.OnItemLongClickListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            int n = BdListView.this.f2310e.n();
            if (i2 < n) {
                return true;
            }
            int i3 = i2 - n;
            ListAdapter wrappedAdapter = BdListView.this.f2310e.getWrappedAdapter();
            if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                return true;
            }
            if (BdListView.this.f2312g != null) {
                return BdListView.this.f2312g.onItemLongClick(adapterView, view, i3, j);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class k implements AdapterView.OnItemSelectedListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            int n = BdListView.this.f2310e.n();
            if (i2 < n) {
                return;
            }
            int i3 = i2 - n;
            ListAdapter wrappedAdapter = BdListView.this.f2310e.getWrappedAdapter();
            if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount() || BdListView.this.f2313h == null) {
                return;
            }
            BdListView.this.f2313h.onItemSelected(adapterView, view, i3, j);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            if (BdListView.this.f2313h != null) {
                BdListView.this.f2313h.onNothingSelected(adapterView);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        void onClick(View view);
    }

    /* loaded from: classes.dex */
    public interface m {
        void onClick(View view);
    }

    /* loaded from: classes.dex */
    public interface n {
        void a(int i2);
    }

    /* loaded from: classes.dex */
    public interface o {
        void onScrollStop(int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface p {
        void onScrollToBottom();
    }

    /* loaded from: classes.dex */
    public interface q {
        void q(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface r {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes.dex */
    public interface s {
        void onScrollToTop();
    }

    /* loaded from: classes.dex */
    public static class t {
        public static float k = 3.0f;

        /* renamed from: a  reason: collision with root package name */
        public d.a.c.j.e.c f2326a;

        /* renamed from: e  reason: collision with root package name */
        public BdListView f2330e;

        /* renamed from: h  reason: collision with root package name */
        public int f2333h;

        /* renamed from: i  reason: collision with root package name */
        public int f2334i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2327b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f2328c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2329d = 3;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f2331f = Boolean.FALSE;

        /* renamed from: g  reason: collision with root package name */
        public r f2332g = null;
        public int j = 800;

        /* loaded from: classes.dex */
        public class a implements d.a.c.j.f.a {
            public a() {
            }

            @Override // d.a.c.j.f.a
            public void onOver() {
                t.this.d();
            }
        }

        public t(BdListView bdListView, d.a.c.j.e.c cVar) {
            this.f2326a = null;
            this.f2330e = null;
            if (cVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView != null) {
                this.f2326a = cVar;
                this.f2330e = bdListView;
                View view = cVar.getView();
                view.setPadding(0, -this.f2326a.q(), 0, 0);
                view.invalidate();
                this.f2330e.y(view);
                this.f2333h = ((int) (bdListView.getResources().getDisplayMetrics().density * 86.0f)) * 2;
                return;
            }
            throw new InvalidParameterException("PullRefresh listView is null");
        }

        public static boolean i(float f2) {
            if (f2 > 0.0f) {
                k = f2;
                return true;
            }
            return false;
        }

        public final void c() {
            View view;
            d.a.c.j.e.c e2 = e();
            if (e2 == null || (view = e2.getView()) == null) {
                return;
            }
            d.a.c.j.e.f fVar = new d.a.c.j.e.f(view.getContext(), 0, -e2.q(), this.j);
            fVar.d(new a());
            fVar.e(e2.f40329i);
            fVar.f(view);
        }

        public void d() {
            this.f2329d = 3;
            d.a.c.j.e.c cVar = this.f2326a;
            cVar.D(0, -cVar.q(), 0, 0);
            this.f2326a.o(true);
            r rVar = this.f2332g;
            if (rVar != null) {
                rVar.onScrollToPull(false);
            }
        }

        public d.a.c.j.e.c e() {
            return this.f2326a;
        }

        public void f(MotionEvent motionEvent, int i2) {
            if (motionEvent.getAction() == 0 && e().r()) {
                this.f2327b = false;
                this.f2331f = Boolean.FALSE;
                if (i2 != 0 || 0 != 0 || this.f2330e.getChildAt(0) == null || this.f2330e.getChildAt(0).getTop() < 0) {
                    return;
                }
                this.f2327b = true;
                this.f2328c = (int) motionEvent.getY();
            }
        }

        public void g(MotionEvent motionEvent, int i2) {
            r rVar;
            if (e().r()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        int y = (int) motionEvent.getY();
                        if (!this.f2327b && i2 == 0 && this.f2330e.getChildAt(0) != null && this.f2330e.getChildAt(0).getTop() >= 0) {
                            this.f2327b = true;
                            this.f2328c = y;
                        }
                        int i3 = this.f2329d;
                        if (i3 != 2 && this.f2327b) {
                            if (i3 == 0) {
                                this.f2330e.setSelection(0);
                                if (((int) ((y - this.f2328c) / k)) < d.a.c.e.p.l.g(this.f2326a.p(), R.dimen.adp_list_view_pull_maxoffset) && y - this.f2328c > 0) {
                                    this.f2329d = 1;
                                    this.f2326a.x(this.f2331f.booleanValue());
                                    this.f2331f = Boolean.FALSE;
                                    r rVar2 = this.f2332g;
                                    if (rVar2 != null) {
                                        rVar2.onScrollToPull(true);
                                    }
                                } else if (y - this.f2328c <= 0) {
                                    this.f2329d = 3;
                                    d.a.c.j.e.c cVar = this.f2326a;
                                    cVar.D(0, -cVar.q(), 0, 0);
                                    this.f2326a.o(false);
                                    r rVar3 = this.f2332g;
                                    if (rVar3 != null) {
                                        rVar3.onScrollToPull(true);
                                    }
                                }
                            } else if (i3 == 1) {
                                this.f2330e.setSelection(0);
                                if (((int) ((y - this.f2328c) / k)) >= d.a.c.e.p.l.g(this.f2326a.p(), R.dimen.adp_list_view_pull_maxoffset)) {
                                    this.f2329d = 0;
                                    this.f2331f = Boolean.TRUE;
                                    this.f2326a.z();
                                    r rVar4 = this.f2332g;
                                    if (rVar4 != null) {
                                        rVar4.onScrollToPull(true);
                                    }
                                } else if (y - this.f2328c <= 0) {
                                    this.f2329d = 3;
                                    d.a.c.j.e.c cVar2 = this.f2326a;
                                    cVar2.D(0, -cVar2.q(), 0, 0);
                                    this.f2326a.o(false);
                                    r rVar5 = this.f2332g;
                                    if (rVar5 != null) {
                                        rVar5.onScrollToPull(true);
                                    }
                                }
                            } else if (i3 == 3) {
                                if (y - this.f2328c > 0) {
                                    this.f2329d = 1;
                                    this.f2326a.x(this.f2331f.booleanValue());
                                    this.f2331f = Boolean.FALSE;
                                    r rVar6 = this.f2332g;
                                    if (rVar6 != null) {
                                        rVar6.onScrollToPull(true);
                                    }
                                } else {
                                    r rVar7 = this.f2332g;
                                    if (rVar7 != null) {
                                        rVar7.onScrollToPull(false);
                                    }
                                }
                            }
                            int i4 = this.f2329d;
                            if (i4 == 1 || i4 == 0) {
                                d.a.c.j.e.c cVar3 = this.f2326a;
                                cVar3.D(0, ((int) ((y - this.f2328c) / k)) - cVar3.q(), 0, 0);
                                d.a.c.j.e.c cVar4 = this.f2326a;
                                if (cVar4 != null && y >= this.f2334i) {
                                    float f2 = ((y - this.f2328c) / k) / this.f2333h;
                                    cVar4.e(f2, f2);
                                }
                            }
                        }
                        this.f2334i = y;
                        return;
                    } else if (action != 3) {
                        return;
                    }
                }
                int i5 = this.f2329d;
                if (i5 != 2) {
                    if (i5 == 1) {
                        this.f2329d = 3;
                        d.a.c.j.e.c cVar5 = this.f2326a;
                        cVar5.D(0, -cVar5.q(), 0, 0);
                        this.f2326a.o(false);
                        r rVar8 = this.f2332g;
                        if (rVar8 != null) {
                            rVar8.onScrollToPull(true);
                        }
                    } else if (i5 != 0) {
                        if (i5 != 3 || (rVar = this.f2332g) == null) {
                            return;
                        }
                        rVar.onScrollToPull(false);
                    } else {
                        j(false);
                        r rVar9 = this.f2332g;
                        if (rVar9 != null) {
                            rVar9.onScrollToPull(true);
                        }
                    }
                }
            }
        }

        public void h(r rVar) {
            this.f2332g = rVar;
        }

        public void j(boolean z) {
            this.f2329d = 2;
            this.f2326a.D(0, 0, 0, 0);
            this.f2326a.y();
            this.f2326a.v(z);
        }
    }

    public BdListView(Context context) {
        super(context);
        this.f2310e = null;
        this.f2311f = null;
        this.f2312g = null;
        this.f2313h = null;
        this.f2314i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = null;
        this.x = new c();
        this.y = new d();
        this.z = new e();
        this.A = new f();
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = new a();
        this.J = null;
        B();
    }

    public static boolean D(float f2) {
        return t.i(f2);
    }

    private int getHeaderIndex() {
        if (this.s != null) {
            return this.f2310e.n() - 1;
        }
        return -1;
    }

    public void A(long j2) {
        t tVar = this.J;
        if (tVar != null && tVar.e() != null) {
            this.J.f2326a.u();
        }
        d.a.c.e.m.e.a().postDelayed(new b(), j2);
    }

    public final void B() {
        setFadingEdgeLength(0);
        d.a.c.j.e.e eVar = new d.a.c.j.e.e(getContext());
        this.f2310e = eVar;
        eVar.s(new g());
        super.setOnItemClickListener(new h());
        super.setOnScrollListener(new i());
    }

    public boolean C() {
        t tVar = this.J;
        return tVar == null || tVar.f2329d == 3;
    }

    public void E(int i2, int i3, int i4) {
        smoothScrollToPositionFromTop(i2, i3, i4);
    }

    public void F() {
        if (this.J != null) {
            setSelection(0);
            this.J.j(true);
        }
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.f2310e.f(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.f2310e.h(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e2) {
            BdLog.detailException(e2);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } catch (OutOfMemoryError unused) {
            BdBaseApplication.getInst().onAppMemoryLow();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    @Override // d.a.c.j.e.p
    public int getContentViewsCount() {
        if (getWrappedAdapter() != null) {
            return getWrappedAdapter().getCount();
        }
        return 0;
    }

    @Override // android.widget.ListView, d.a.c.j.e.p
    public int getFooterViewsCount() {
        return this.f2310e.k();
    }

    @Override // android.widget.ListView, d.a.c.j.e.p
    public int getHeaderViewsCount() {
        return this.f2310e.m();
    }

    public d.a.c.j.e.o getListAdapter() {
        return getAdapter2();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.p
    public BdListView getListView() {
        return this;
    }

    public d.a.c.j.e.q getPreLoadHandle() {
        return this.y;
    }

    public ListAdapter getWrappedAdapter() {
        d.a.c.j.e.e eVar = this.f2310e;
        if (eVar instanceof d.a.c.j.e.e) {
            return eVar.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (NullPointerException e2) {
            BdLog.detailException(e2);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.x);
            getHandler().removeCallbacks(this.I);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        t tVar = this.J;
        if (tVar != null) {
            tVar.f(motionEvent, this.v);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.C) {
                this.C = true;
                this.F = i5;
                n nVar = this.H;
                if (nVar != null) {
                    nVar.a(-1);
                }
            } else {
                int i6 = this.F;
                if (i6 < i5) {
                    i6 = i5;
                }
                this.F = i6;
            }
            if (this.C && this.F > i5 && i5 != this.G) {
                this.D = true;
                n nVar2 = this.H;
                if (nVar2 != null) {
                    nVar2.a(-3);
                }
                if (this.E && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.I, 1L);
                }
            }
            if (this.C && this.D && this.F == i5) {
                this.D = false;
                n nVar3 = this.H;
                if (nVar3 != null) {
                    nVar3.a(-2);
                }
            }
            this.G = i5;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.B <= 0) {
            super.onMeasure(i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int i4 = this.B;
        if (size > i4) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, mode);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        t tVar = this.J;
        if (tVar != null) {
            tVar.g(motionEvent, this.v);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.f2310e.p(view);
    }

    @Override // android.widget.ListView, d.a.c.j.e.p
    public boolean removeHeaderView(View view) {
        return this.f2310e.q(view);
    }

    public void setExOnSrollToBottomListener(q qVar) {
        this.r = qVar;
    }

    public void setKybdsScrollBottom(boolean z) {
        this.E = z;
    }

    public void setMaxHeight(int i2) {
        this.B = i2;
    }

    public void setNextPage(d.a.c.j.e.b bVar) {
        d.a.c.j.e.b bVar2 = this.t;
        if (bVar2 != null) {
            removeFooterView(bVar2.b());
            this.t = null;
        }
        if (bVar != null) {
            this.f2310e.f(bVar.b(), null, true, 0);
            this.t = bVar;
        }
    }

    public void setNoData(String str) {
        if (str != null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            setNoData(textView);
        }
    }

    public void setOnFooterClickListener(l lVar) {
        this.j = lVar;
    }

    public void setOnHeaderClickListener(m mVar) {
        this.f2314i = mVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2311f = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.f2312g = onItemLongClickListener;
        super.setOnItemLongClickListener(new j());
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.f2313h = onItemSelectedListener;
        super.setOnItemSelectedListener(new k());
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.k = onScrollListener;
    }

    public void setOnScrollStopDelayedListener(o oVar, long j2) {
        this.l = oVar;
        this.n = j2;
    }

    public void setOnScrollToPullListener(r rVar) {
        this.m = rVar;
    }

    public void setOnSrollToBottomListener(p pVar) {
        this.q = pVar;
    }

    public void setOnSrollToTopListener(s sVar) {
        this.o = sVar;
    }

    public void setOnkbdStateListener(n nVar) {
        this.H = nVar;
    }

    public void setPrePage(d.a.c.j.e.b bVar) {
        d.a.c.j.e.b bVar2 = this.s;
        if (bVar2 != null) {
            removeHeaderView(bVar2.b());
            this.s = null;
        }
        if (bVar != null) {
            addHeaderView(bVar.b());
            this.s = bVar;
        }
    }

    public void setPullRefresh(d.a.c.j.e.c cVar) {
        t tVar = this.J;
        if (tVar != null) {
            removeHeaderView(tVar.e().getView());
        }
        this.J = null;
        if (cVar != null) {
            t tVar2 = new t(this, cVar);
            this.J = tVar2;
            tVar2.h(this.m);
        }
    }

    public void setScrollable(d.a.c.a.i iVar) {
        this.w = iVar;
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void x(View view, int i2) {
        this.f2310e.g(view, i2);
    }

    public void y(View view) {
        this.f2310e.h(view, null, false, 0);
    }

    public void z() {
        t tVar = this.J;
        if (tVar != null) {
            if (tVar.e() != null) {
                this.J.f2326a.u();
            }
            this.J.c();
        }
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.f2310e.e(view);
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.f2310e.g(view, getHeaderIndex());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.f2310e.r(listAdapter);
        super.setAdapter((ListAdapter) this.f2310e);
    }

    public void setOnSrollToTopListener(s sVar, int i2) {
        this.o = sVar;
        int i3 = i2 - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        this.p = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'd.a.c.j.e.e' to match base method */
    @Override // android.widget.ListView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        return this.f2310e;
    }

    public void setNoData(View view) {
        View view2 = this.u;
        if (view2 != null) {
            removeHeaderView(view2);
            this.u = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.u = view;
        }
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2310e = null;
        this.f2311f = null;
        this.f2312g = null;
        this.f2313h = null;
        this.f2314i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = null;
        this.x = new c();
        this.y = new d();
        this.z = new e();
        this.A = new f();
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = new a();
        this.J = null;
        B();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2310e = null;
        this.f2311f = null;
        this.f2312g = null;
        this.f2313h = null;
        this.f2314i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = null;
        this.x = new c();
        this.y = new d();
        this.z = new e();
        this.A = new f();
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = new a();
        this.J = null;
        B();
    }
}
