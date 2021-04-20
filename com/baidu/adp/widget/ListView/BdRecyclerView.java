package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import d.b.c.j.e.d;
import d.b.c.j.e.o;
import d.b.c.j.e.p;
import d.b.c.j.e.q;
/* loaded from: classes.dex */
public class BdRecyclerView extends RecyclerView implements p<BdRecyclerView> {

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerAdapter f2367e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.a.i f2368f;

    /* renamed from: g  reason: collision with root package name */
    public i f2369g;

    /* renamed from: h  reason: collision with root package name */
    public j f2370h;
    public BdListView.m i;
    public BdListView.l j;
    public BdListView.p k;
    public BdListView.s l;
    public BdListView.o m;
    public long n;
    public d.b.c.j.e.b o;
    public d.b.c.j.e.b p;
    public View q;
    public boolean r;
    public boolean s;
    public Runnable t;
    public Runnable u;
    public Runnable v;
    public q w;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BdRecyclerView.this.m != null) {
                int firstVisiblePosition = BdRecyclerView.this.getFirstVisiblePosition();
                int lastVisiblePosition = BdRecyclerView.this.getLastVisiblePosition();
                int i = 0;
                int i2 = -1;
                if (BdRecyclerView.this.f2367e == null || BdRecyclerView.this.f2367e.p() == null || BdRecyclerView.this.f2367e.p().getItemCount() <= 0) {
                    i = -1;
                } else {
                    int o = firstVisiblePosition - BdRecyclerView.this.f2367e.o();
                    i2 = o < 0 ? 0 : o;
                    int o2 = lastVisiblePosition - BdRecyclerView.this.f2367e.o();
                    if (o2 >= BdRecyclerView.this.f2367e.p().getItemCount()) {
                        o2 = BdRecyclerView.this.f2367e.p().getItemCount() - 1;
                    }
                    if (o2 >= 0) {
                        i = o2;
                    }
                }
                BdRecyclerView.this.m.onScrollStop(i2, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
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
            int childCount = BdRecyclerView.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(BdRecyclerView.this.getChildAt(i));
            }
            BdRecyclerView.this.v.run();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.c.a.i c2;
            if (BdRecyclerView.this.f2368f != null) {
                c2 = BdRecyclerView.this.f2368f;
            } else {
                c2 = d.b.c.a.j.c(BdRecyclerView.this.getContext());
            }
            if (c2 != null) {
                c2.onPreLoad(BdRecyclerView.this.w);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements q {
        public d() {
        }

        @Override // d.b.c.j.e.q
        public void cancelRefresh() {
            BdRecyclerView bdRecyclerView = BdRecyclerView.this;
            bdRecyclerView.removeCallbacks(bdRecyclerView.u);
        }

        @Override // d.b.c.j.e.q
        public o getAdapter() {
            return BdRecyclerView.this.f2367e;
        }

        @Override // d.b.c.j.e.q
        public int getFirstVisiblePosition() {
            return BdRecyclerView.this.getFirstVisiblePosition();
        }

        @Override // d.b.c.j.e.q
        public int getLastVisiblePosition() {
            return BdRecyclerView.this.getLastVisiblePosition();
        }
    }

    /* loaded from: classes.dex */
    public class e implements d.a {
        public e() {
        }

        @Override // d.b.c.j.e.d.a
        public void onPreLoad() {
            BdRecyclerView bdRecyclerView = BdRecyclerView.this;
            bdRecyclerView.removeCallbacks(bdRecyclerView.v);
            BdRecyclerView bdRecyclerView2 = BdRecyclerView.this;
            bdRecyclerView2.postDelayed(bdRecyclerView2.v, 100L);
        }
    }

    /* loaded from: classes.dex */
    public class f implements i {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void c(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            int headerViewsCount = BdRecyclerView.this.getHeaderViewsCount();
            if (i < headerViewsCount) {
                if (BdRecyclerView.this.o == null || view != BdRecyclerView.this.o.b()) {
                    if (BdRecyclerView.this.i != null) {
                        BdRecyclerView.this.i.onClick(view);
                        return;
                    }
                    return;
                }
                BdRecyclerView.this.o.c();
                return;
            }
            int i2 = i - headerViewsCount;
            RecyclerView.Adapter p = BdRecyclerView.this.f2367e.p();
            if (p == null || i2 >= p.getItemCount()) {
                if (BdRecyclerView.this.p == null || view != BdRecyclerView.this.p.b()) {
                    if (BdRecyclerView.this.j != null) {
                        BdRecyclerView.this.j.onClick(view);
                        return;
                    }
                    return;
                }
                BdRecyclerView.this.p.c();
            } else if (BdRecyclerView.this.f2369g != null) {
                BdRecyclerView.this.f2369g.c(viewGroup, view, obj, i2, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements j {
        public g() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.j
        public boolean a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            int headerViewsCount = i - BdRecyclerView.this.getHeaderViewsCount();
            RecyclerView.Adapter p = BdRecyclerView.this.f2367e.p();
            if (p == null || headerViewsCount >= p.getItemCount() || BdRecyclerView.this.f2370h == null) {
                return false;
            }
            return BdRecyclerView.this.f2370h.a(viewGroup, view, obj, headerViewsCount, j);
        }
    }

    /* loaded from: classes.dex */
    public class h extends RecyclerView.OnScrollListener {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BdRecyclerView.this.k != null) {
                    BdRecyclerView.this.k.onScrollToBottom();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BdRecyclerView.this.l != null) {
                    BdRecyclerView.this.l.onScrollToTop();
                }
            }
        }

        public h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            d.b.c.a.i c2;
            if (BdRecyclerView.this.f2368f != null) {
                c2 = BdRecyclerView.this.f2368f;
            } else {
                c2 = d.b.c.a.j.c(BdRecyclerView.this.getContext());
            }
            if (c2 != null) {
                if (i == 2) {
                    BdRecyclerView bdRecyclerView = BdRecyclerView.this;
                    bdRecyclerView.removeCallbacks(bdRecyclerView.u);
                    c2.setIsScroll(true);
                } else if (c2.isScroll()) {
                    c2.setIsScroll(false);
                    BdRecyclerView bdRecyclerView2 = BdRecyclerView.this;
                    bdRecyclerView2.removeCallbacks(bdRecyclerView2.u);
                    BdRecyclerView bdRecyclerView3 = BdRecyclerView.this;
                    bdRecyclerView3.postDelayed(bdRecyclerView3.u, 100L);
                } else if (i == 0) {
                    BdRecyclerView bdRecyclerView4 = BdRecyclerView.this;
                    bdRecyclerView4.removeCallbacks(bdRecyclerView4.v);
                    BdRecyclerView bdRecyclerView5 = BdRecyclerView.this;
                    bdRecyclerView5.postDelayed(bdRecyclerView5.v, 100L);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = BdRecyclerView.this.canScrollVertically(1);
            boolean canScrollVertically2 = BdRecyclerView.this.canScrollVertically(-1);
            if (!canScrollVertically && canScrollVertically2 && Math.abs(i2) > 0) {
                if (BdRecyclerView.this.k != null) {
                    recyclerView.post(new a());
                }
            } else if (!canScrollVertically2 && canScrollVertically && Math.abs(i2) > 0 && BdRecyclerView.this.l != null) {
                recyclerView.post(new b());
            }
            if (BdRecyclerView.this.m == null || BdRecyclerView.this.n <= 0) {
                return;
            }
            BdRecyclerView.this.getHandler().removeCallbacks(BdRecyclerView.this.t);
            BdRecyclerView.this.getHandler().postDelayed(BdRecyclerView.this.t, BdRecyclerView.this.n);
        }
    }

    /* loaded from: classes.dex */
    public interface i<T> {
        void c(ViewGroup viewGroup, View view, T t, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface j<T> {
        boolean a(ViewGroup viewGroup, View view, T t, int i, long j);
    }

    public BdRecyclerView(Context context) {
        super(context);
        this.f2368f = null;
        this.f2369g = null;
        this.f2370h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = true;
        this.t = new a();
        this.u = new b();
        this.v = new c();
        this.w = new d();
        x();
    }

    public void A() {
        this.r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
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

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        if (this.s || i4 == 0) {
            return super.dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        if (this.s || i6 == 0) {
            return super.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
        }
        return false;
    }

    @Override // d.b.c.j.e.p
    public int getContentViewsCount() {
        if (getWrappedAdapter() != null) {
            return getWrappedAdapter().getItemCount();
        }
        return 0;
    }

    public int getFirstCompletelyVisiblePosition() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(iArr);
            return w(iArr);
        }
        return 0;
    }

    public int getFirstVisiblePosition() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
            return w(iArr);
        }
        return 0;
    }

    @Override // d.b.c.j.e.p
    public int getFooterViewsCount() {
        return this.f2367e.n();
    }

    @Override // d.b.c.j.e.p
    public int getHeaderViewsCount() {
        return this.f2367e.o();
    }

    public int getLastCompletelyVisiblePosition() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
            return v(iArr);
        }
        return 0;
    }

    public int getLastVisiblePosition() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
            return v(iArr);
        }
        return 0;
    }

    public o getListAdapter() {
        return (o) getAdapter();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.p
    public BdRecyclerView getListView() {
        return this;
    }

    public q getPreLoadHandle() {
        return this.w;
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        BdRecyclerAdapter bdRecyclerAdapter = this.f2367e;
        if (bdRecyclerAdapter != null) {
            return bdRecyclerAdapter.p();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.t);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void r(View view) {
        BdRecyclerAdapter bdRecyclerAdapter = this.f2367e;
        if (bdRecyclerAdapter == null) {
            return;
        }
        bdRecyclerAdapter.g(view);
    }

    @Override // d.b.c.j.e.p
    public boolean removeHeaderView(View view) {
        BdRecyclerAdapter bdRecyclerAdapter = this.f2367e;
        if (bdRecyclerAdapter == null) {
            return false;
        }
        return bdRecyclerAdapter.r(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.r) {
            super.requestLayout();
        }
    }

    public void s(View view) {
        this.f2367e.i(view, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(null);
        this.f2367e.s(adapter);
        super.setAdapter(this.f2367e);
    }

    public void setCanFling(boolean z) {
        this.s = z;
    }

    public void setFooterView(View view) {
        this.f2367e.u(view, null, true, true, -1);
    }

    public void setHeaderView(View view) {
        this.f2367e.v(view, null, true, true, -1);
    }

    public void setNextPage(d.b.c.j.e.b bVar) {
        d.b.c.j.e.b bVar2 = this.p;
        if (bVar2 == null || bVar2 != bVar) {
            d.b.c.j.e.b bVar3 = this.p;
            if (bVar3 != null && bVar3 != bVar) {
                y(bVar3.b());
                this.p = null;
            }
            if (bVar != null) {
                this.f2367e.h(bVar.b(), null, true, 0);
                this.p = bVar;
            }
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

    public void setOnFooterClickListener(BdListView.l lVar) {
        this.j = lVar;
    }

    public void setOnHeaderClickListener(BdListView.m mVar) {
        this.i = mVar;
    }

    public void setOnItemClickListener(i iVar) {
        this.f2369g = iVar;
    }

    public void setOnItemLongClickListener(j jVar) {
        this.f2370h = jVar;
    }

    public void setOnScrollStopDelayedListener(BdListView.o oVar, long j2) {
        this.m = oVar;
        this.n = j2;
    }

    public void setOnSrollToBottomListener(BdListView.p pVar) {
        this.k = pVar;
    }

    public void setOnSrollToTopListener(BdListView.s sVar) {
        this.l = sVar;
    }

    public void setPrePage(d.b.c.j.e.b bVar) {
        d.b.c.j.e.b bVar2 = this.o;
        if (bVar2 == null || bVar2 != bVar) {
            d.b.c.j.e.b bVar3 = this.o;
            if (bVar3 != null) {
                removeHeaderView(bVar3.b());
                this.o = null;
            }
            if (bVar != null) {
                s(bVar.b());
                this.o = bVar;
            }
        }
    }

    public void setScrollable(d.b.c.a.i iVar) {
        this.f2368f = iVar;
    }

    public void setSelection(int i2) {
        scrollToPosition(i2);
    }

    public void t(View view, int i2) {
        this.f2367e.i(view, i2);
    }

    public void u(View view, Object obj, boolean z) {
        this.f2367e.j(view, obj, z, true, -1);
    }

    public final int v(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i2 = iArr[0];
        for (int i3 : iArr) {
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2;
    }

    public final int w(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i2 = iArr[0];
        for (int i3 : iArr) {
            if (i3 < i2) {
                i2 = i3;
            }
        }
        return i2;
    }

    public final void x() {
        setFadingEdgeLength(0);
        BdRecyclerAdapter bdRecyclerAdapter = new BdRecyclerAdapter(getContext());
        this.f2367e = bdRecyclerAdapter;
        bdRecyclerAdapter.w(new e());
        this.f2367e.x(new f());
        this.f2367e.y(new g());
        addOnScrollListener(new h());
    }

    public boolean y(View view) {
        BdRecyclerAdapter bdRecyclerAdapter = this.f2367e;
        if (bdRecyclerAdapter == null) {
            return false;
        }
        return bdRecyclerAdapter.q(view);
    }

    public void z() {
        this.r = false;
    }

    public void setHeaderView(View view, boolean z) {
        this.f2367e.v(view, null, true, z, -1);
    }

    public void setNoData(View view) {
        View view2 = this.q;
        if (view2 != null) {
            removeHeaderView(view2);
            this.q = null;
        }
        if (view != null) {
            u(view, null, false);
            this.q = view;
        }
    }

    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2368f = null;
        this.f2369g = null;
        this.f2370h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = true;
        this.t = new a();
        this.u = new b();
        this.v = new c();
        this.w = new d();
        x();
    }

    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2368f = null;
        this.f2369g = null;
        this.f2370h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 100L;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = true;
        this.t = new a();
        this.u = new b();
        this.v = new c();
        this.w = new d();
        x();
    }
}
