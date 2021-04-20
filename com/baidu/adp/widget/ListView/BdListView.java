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
import d.b.c.j.e.e;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdListView extends ListView implements d.b.c.j.e.p<BdListView> {
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
    public d.b.c.j.e.e f2332e;

    /* renamed from: f  reason: collision with root package name */
    public AdapterView.OnItemClickListener f2333f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemLongClickListener f2334g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f2335h;
    public m i;
    public l j;
    public AbsListView.OnScrollListener k;
    public o l;
    public r m;
    public long n;
    public s o;
    public int p;
    public p q;
    public q r;
    public d.b.c.j.e.b s;
    public d.b.c.j.e.b t;
    public View u;
    public int v;
    public d.b.c.a.i w;
    public Runnable x;
    public final d.b.c.j.e.q y;
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
                int i = 0;
                int i2 = -1;
                if (BdListView.this.f2332e == null || BdListView.this.f2332e.getWrappedAdapter() == null || BdListView.this.f2332e.o() <= 0) {
                    i = -1;
                } else {
                    int n = firstVisiblePosition - BdListView.this.f2332e.n();
                    i2 = n < 0 ? 0 : n;
                    int n2 = lastVisiblePosition - BdListView.this.f2332e.n();
                    if (n2 >= BdListView.this.f2332e.o()) {
                        n2 = BdListView.this.f2332e.o() - 1;
                    }
                    if (n2 >= 0) {
                        i = n2;
                    }
                }
                BdListView.this.l.onScrollStop(i2, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements d.b.c.j.e.q {
        public d() {
        }

        @Override // d.b.c.j.e.q
        public void cancelRefresh() {
            BdListView bdListView = BdListView.this;
            bdListView.removeCallbacks(bdListView.z);
        }

        @Override // d.b.c.j.e.q
        public d.b.c.j.e.o getAdapter() {
            return BdListView.this.getAdapter2();
        }

        @Override // d.b.c.j.e.q
        public int getFirstVisiblePosition() {
            return BdListView.this.getFirstVisiblePosition();
        }

        @Override // d.b.c.j.e.q
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
            if (view instanceof d.b.c.f.a.i) {
                ((d.b.c.f.a.i) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.c.a.i c2;
            int childCount = BdListView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(BdListView.this.getChildAt(i));
            }
            if (BdListView.this.w != null) {
                c2 = BdListView.this.w;
            } else {
                c2 = d.b.c.a.j.c(BdListView.this.getContext());
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
            d.b.c.a.i c2;
            if (BdListView.this.w != null) {
                c2 = BdListView.this.w;
            } else {
                c2 = d.b.c.a.j.c(BdListView.this.getContext());
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

        @Override // d.b.c.j.e.e.b
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int n = BdListView.this.f2332e.n();
            if (i < n) {
                if (BdListView.this.s == null || view != BdListView.this.s.b()) {
                    if (BdListView.this.i != null) {
                        BdListView.this.i.onClick(view);
                        return;
                    }
                    return;
                }
                BdListView.this.s.c();
                return;
            }
            int i2 = i - n;
            ListAdapter wrappedAdapter = BdListView.this.f2332e.getWrappedAdapter();
            if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
                if (BdListView.this.t == null || view != BdListView.this.t.b()) {
                    if (BdListView.this.j != null) {
                        BdListView.this.j.onClick(view);
                        return;
                    }
                    return;
                }
                BdListView.this.t.c();
            } else if (BdListView.this.f2333f != null) {
                BdListView.this.f2333f.onItemClick(adapterView, view, i2, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements AbsListView.OnScrollListener {
        public i() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            BdListView.this.v = i;
            if (BdListView.this.k != null) {
                BdListView.this.k.onScroll(absListView, i, i2, i3);
            }
            if (BdListView.this.l == null || BdListView.this.n <= 0) {
                return;
            }
            BdListView.this.getHandler().removeCallbacks(BdListView.this.x);
            BdListView.this.getHandler().postDelayed(BdListView.this.x, BdListView.this.n);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            d.b.c.a.i c2;
            if (BdListView.this.w != null) {
                c2 = BdListView.this.w;
            } else {
                c2 = d.b.c.a.j.c(BdListView.this.getContext());
            }
            if (c2 != null) {
                if (i == 2) {
                    BdListView bdListView = BdListView.this;
                    bdListView.removeCallbacks(bdListView.z);
                    c2.setIsScroll(true);
                } else if (c2.isScroll()) {
                    c2.setIsScroll(false);
                    BdListView bdListView2 = BdListView.this;
                    bdListView2.removeCallbacks(bdListView2.z);
                    BdListView bdListView3 = BdListView.this;
                    bdListView3.postDelayed(bdListView3.z, 100L);
                } else if (i == 0) {
                    BdListView bdListView4 = BdListView.this;
                    bdListView4.removeCallbacks(bdListView4.A);
                    BdListView bdListView5 = BdListView.this;
                    bdListView5.postDelayed(bdListView5.A, 100L);
                }
            }
            if (BdListView.this.k != null) {
                BdListView.this.k.onScrollStateChanged(absListView, i);
            }
            if (i == 0) {
                if (BdListView.this.q != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                    BdListView.this.q.onScrollToBottom();
                }
                if (BdListView.this.r != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                    BdListView.this.r.y(BdListView.this);
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
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            int n = BdListView.this.f2332e.n();
            if (i < n) {
                return true;
            }
            int i2 = i - n;
            ListAdapter wrappedAdapter = BdListView.this.f2332e.getWrappedAdapter();
            if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
                return true;
            }
            if (BdListView.this.f2334g != null) {
                return BdListView.this.f2334g.onItemLongClick(adapterView, view, i2, j);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class k implements AdapterView.OnItemSelectedListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int n = BdListView.this.f2332e.n();
            if (i < n) {
                return;
            }
            int i2 = i - n;
            ListAdapter wrappedAdapter = BdListView.this.f2332e.getWrappedAdapter();
            if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount() || BdListView.this.f2335h == null) {
                return;
            }
            BdListView.this.f2335h.onItemSelected(adapterView, view, i2, j);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            if (BdListView.this.f2335h != null) {
                BdListView.this.f2335h.onNothingSelected(adapterView);
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
        void a(int i);
    }

    /* loaded from: classes.dex */
    public interface o {
        void onScrollStop(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface p {
        void onScrollToBottom();
    }

    /* loaded from: classes.dex */
    public interface q {
        void y(BdListView bdListView);
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
        public d.b.c.j.e.c f2347a;

        /* renamed from: e  reason: collision with root package name */
        public BdListView f2351e;

        /* renamed from: h  reason: collision with root package name */
        public int f2354h;
        public int i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2348b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f2349c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2350d = 3;

        /* renamed from: f  reason: collision with root package name */
        public Boolean f2352f = Boolean.FALSE;

        /* renamed from: g  reason: collision with root package name */
        public r f2353g = null;
        public int j = 800;

        /* loaded from: classes.dex */
        public class a implements d.b.c.j.f.a {
            public a() {
            }

            @Override // d.b.c.j.f.a
            public void onOver() {
                t.this.d();
            }
        }

        public t(BdListView bdListView, d.b.c.j.e.c cVar) {
            this.f2347a = null;
            this.f2351e = null;
            if (cVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView != null) {
                this.f2347a = cVar;
                this.f2351e = bdListView;
                View view = cVar.getView();
                view.setPadding(0, -this.f2347a.q(), 0, 0);
                view.invalidate();
                this.f2351e.y(view);
                this.f2354h = ((int) (bdListView.getResources().getDisplayMetrics().density * 86.0f)) * 2;
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
            d.b.c.j.e.c e2 = e();
            if (e2 == null || (view = e2.getView()) == null) {
                return;
            }
            d.b.c.j.e.f fVar = new d.b.c.j.e.f(view.getContext(), 0, -e2.q(), this.j);
            fVar.d(new a());
            fVar.e(e2.i);
            fVar.f(view);
        }

        public void d() {
            this.f2350d = 3;
            d.b.c.j.e.c cVar = this.f2347a;
            cVar.D(0, -cVar.q(), 0, 0);
            this.f2347a.o(true);
            r rVar = this.f2353g;
            if (rVar != null) {
                rVar.onScrollToPull(false);
            }
        }

        public d.b.c.j.e.c e() {
            return this.f2347a;
        }

        public void f(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && e().r()) {
                this.f2348b = false;
                this.f2352f = Boolean.FALSE;
                if (i != 0 || 0 != 0 || this.f2351e.getChildAt(0) == null || this.f2351e.getChildAt(0).getTop() < 0) {
                    return;
                }
                this.f2348b = true;
                this.f2349c = (int) motionEvent.getY();
            }
        }

        public void g(MotionEvent motionEvent, int i) {
            r rVar;
            if (e().r()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        int y = (int) motionEvent.getY();
                        if (!this.f2348b && i == 0 && this.f2351e.getChildAt(0) != null && this.f2351e.getChildAt(0).getTop() >= 0) {
                            this.f2348b = true;
                            this.f2349c = y;
                        }
                        int i2 = this.f2350d;
                        if (i2 != 2 && this.f2348b) {
                            if (i2 == 0) {
                                this.f2351e.setSelection(0);
                                if (((int) ((y - this.f2349c) / k)) < d.b.c.e.p.l.g(this.f2347a.p(), R.dimen.adp_list_view_pull_maxoffset) && y - this.f2349c > 0) {
                                    this.f2350d = 1;
                                    this.f2347a.x(this.f2352f.booleanValue());
                                    this.f2352f = Boolean.FALSE;
                                    r rVar2 = this.f2353g;
                                    if (rVar2 != null) {
                                        rVar2.onScrollToPull(true);
                                    }
                                } else if (y - this.f2349c <= 0) {
                                    this.f2350d = 3;
                                    d.b.c.j.e.c cVar = this.f2347a;
                                    cVar.D(0, -cVar.q(), 0, 0);
                                    this.f2347a.o(false);
                                    r rVar3 = this.f2353g;
                                    if (rVar3 != null) {
                                        rVar3.onScrollToPull(true);
                                    }
                                }
                            } else if (i2 == 1) {
                                this.f2351e.setSelection(0);
                                if (((int) ((y - this.f2349c) / k)) >= d.b.c.e.p.l.g(this.f2347a.p(), R.dimen.adp_list_view_pull_maxoffset)) {
                                    this.f2350d = 0;
                                    this.f2352f = Boolean.TRUE;
                                    this.f2347a.z();
                                    r rVar4 = this.f2353g;
                                    if (rVar4 != null) {
                                        rVar4.onScrollToPull(true);
                                    }
                                } else if (y - this.f2349c <= 0) {
                                    this.f2350d = 3;
                                    d.b.c.j.e.c cVar2 = this.f2347a;
                                    cVar2.D(0, -cVar2.q(), 0, 0);
                                    this.f2347a.o(false);
                                    r rVar5 = this.f2353g;
                                    if (rVar5 != null) {
                                        rVar5.onScrollToPull(true);
                                    }
                                }
                            } else if (i2 == 3) {
                                if (y - this.f2349c > 0) {
                                    this.f2350d = 1;
                                    this.f2347a.x(this.f2352f.booleanValue());
                                    this.f2352f = Boolean.FALSE;
                                    r rVar6 = this.f2353g;
                                    if (rVar6 != null) {
                                        rVar6.onScrollToPull(true);
                                    }
                                } else {
                                    r rVar7 = this.f2353g;
                                    if (rVar7 != null) {
                                        rVar7.onScrollToPull(false);
                                    }
                                }
                            }
                            int i3 = this.f2350d;
                            if (i3 == 1 || i3 == 0) {
                                d.b.c.j.e.c cVar3 = this.f2347a;
                                cVar3.D(0, ((int) ((y - this.f2349c) / k)) - cVar3.q(), 0, 0);
                                d.b.c.j.e.c cVar4 = this.f2347a;
                                if (cVar4 != null && y >= this.i) {
                                    float f2 = ((y - this.f2349c) / k) / this.f2354h;
                                    cVar4.f(f2, f2);
                                }
                            }
                        }
                        this.i = y;
                        return;
                    } else if (action != 3) {
                        return;
                    }
                }
                int i4 = this.f2350d;
                if (i4 != 2) {
                    if (i4 == 1) {
                        this.f2350d = 3;
                        d.b.c.j.e.c cVar5 = this.f2347a;
                        cVar5.D(0, -cVar5.q(), 0, 0);
                        this.f2347a.o(false);
                        r rVar8 = this.f2353g;
                        if (rVar8 != null) {
                            rVar8.onScrollToPull(true);
                        }
                    } else if (i4 != 0) {
                        if (i4 != 3 || (rVar = this.f2353g) == null) {
                            return;
                        }
                        rVar.onScrollToPull(false);
                    } else {
                        j(false);
                        r rVar9 = this.f2353g;
                        if (rVar9 != null) {
                            rVar9.onScrollToPull(true);
                        }
                    }
                }
            }
        }

        public void h(r rVar) {
            this.f2353g = rVar;
        }

        public void j(boolean z) {
            this.f2350d = 2;
            this.f2347a.D(0, 0, 0, 0);
            this.f2347a.y();
            this.f2347a.v(z);
        }
    }

    public BdListView(Context context) {
        super(context);
        this.f2332e = null;
        this.f2333f = null;
        this.f2334g = null;
        this.f2335h = null;
        this.i = null;
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
            return this.f2332e.n() - 1;
        }
        return -1;
    }

    public void A(long j2) {
        t tVar = this.J;
        if (tVar != null && tVar.e() != null) {
            this.J.f2347a.u();
        }
        d.b.c.e.m.e.a().postDelayed(new b(), j2);
    }

    public final void B() {
        setFadingEdgeLength(0);
        d.b.c.j.e.e eVar = new d.b.c.j.e.e(getContext());
        this.f2332e = eVar;
        eVar.s(new g());
        super.setOnItemClickListener(new h());
        super.setOnScrollListener(new i());
    }

    public boolean C() {
        t tVar = this.J;
        return tVar == null || tVar.f2350d == 3;
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
        this.f2332e.f(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.f2332e.h(view, obj, z, getHeaderIndex());
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

    @Override // d.b.c.j.e.p
    public int getContentViewsCount() {
        if (getWrappedAdapter() != null) {
            return getWrappedAdapter().getCount();
        }
        return 0;
    }

    @Override // android.widget.ListView, d.b.c.j.e.p
    public int getFooterViewsCount() {
        return this.f2332e.k();
    }

    @Override // android.widget.ListView, d.b.c.j.e.p
    public int getHeaderViewsCount() {
        return this.f2332e.m();
    }

    public d.b.c.j.e.o getListAdapter() {
        return getAdapter2();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.p
    public BdListView getListView() {
        return this;
    }

    public d.b.c.j.e.q getPreLoadHandle() {
        return this.y;
    }

    public ListAdapter getWrappedAdapter() {
        d.b.c.j.e.e eVar = this.f2332e;
        if (eVar instanceof d.b.c.j.e.e) {
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
        return this.f2332e.p(view);
    }

    @Override // android.widget.ListView, d.b.c.j.e.p
    public boolean removeHeaderView(View view) {
        return this.f2332e.q(view);
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

    public void setNextPage(d.b.c.j.e.b bVar) {
        d.b.c.j.e.b bVar2 = this.t;
        if (bVar2 != null) {
            removeFooterView(bVar2.b());
            this.t = null;
        }
        if (bVar != null) {
            this.f2332e.f(bVar.b(), null, true, 0);
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
        this.i = mVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2333f = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.f2334g = onItemLongClickListener;
        super.setOnItemLongClickListener(new j());
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.f2335h = onItemSelectedListener;
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

    public void setPrePage(d.b.c.j.e.b bVar) {
        d.b.c.j.e.b bVar2 = this.s;
        if (bVar2 != null) {
            removeHeaderView(bVar2.b());
            this.s = null;
        }
        if (bVar != null) {
            addHeaderView(bVar.b());
            this.s = bVar;
        }
    }

    public void setPullRefresh(d.b.c.j.e.c cVar) {
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

    public void setScrollable(d.b.c.a.i iVar) {
        this.w = iVar;
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void x(View view, int i2) {
        this.f2332e.g(view, i2);
    }

    public void y(View view) {
        this.f2332e.h(view, null, false, 0);
    }

    public void z() {
        t tVar = this.J;
        if (tVar != null) {
            if (tVar.e() != null) {
                this.J.f2347a.u();
            }
            this.J.c();
        }
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.f2332e.e(view);
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.f2332e.g(view, getHeaderIndex());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.f2332e.r(listAdapter);
        super.setAdapter((ListAdapter) this.f2332e);
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
    /* JADX DEBUG: Return type fixed from 'd.b.c.j.e.e' to match base method */
    @Override // android.widget.ListView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        return this.f2332e;
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
        this.f2332e = null;
        this.f2333f = null;
        this.f2334g = null;
        this.f2335h = null;
        this.i = null;
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
        this.f2332e = null;
        this.f2333f = null;
        this.f2334g = null;
        this.f2335h = null;
        this.i = null;
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
