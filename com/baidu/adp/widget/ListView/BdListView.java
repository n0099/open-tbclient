package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class BdListView extends ListView {
    private g a;
    private AdapterView.OnItemClickListener b;
    private AdapterView.OnItemLongClickListener c;
    private AdapterView.OnItemSelectedListener d;
    private q e;
    private p f;
    private AbsListView.OnScrollListener g;
    private s h;
    private u i;
    private long j;
    private v k;
    private int l;
    private t m;
    private e n;
    private e o;
    private View p;
    private int q;
    private Runnable r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private r x;
    private Runnable y;
    private w z;

    public BdListView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = new j(this);
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = new k(this);
        this.z = null;
        a();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = new j(this);
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = new k(this);
        this.z = null;
        a();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 100L;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = new j(this);
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = new k(this);
        this.z = null;
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    private void a() {
        this.a = new g(getContext());
        super.setOnItemClickListener(new l(this));
        super.setOnScrollListener(new m(this));
    }

    public void setOnScrollToPullListener(u uVar) {
        this.i = uVar;
    }

    public void setOnSrollToTopListener(v vVar) {
        this.k = vVar;
    }

    public void setOnSrollToBottomListener(t tVar) {
        this.m = tVar;
    }

    public final void a(s sVar, long j) {
        this.h = sVar;
        this.j = 300L;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.c = onItemLongClickListener;
        super.setOnItemLongClickListener(new n(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.d = onItemSelectedListener;
        super.setOnItemSelectedListener(new o(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.g = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.a;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.a instanceof g) {
            return this.a.b();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.a.a(listAdapter);
        super.setAdapter((ListAdapter) this.a);
    }

    public void setOnHeaderClickListener(q qVar) {
        this.e = qVar;
    }

    public void setOnFooterClickListener(p pVar) {
        this.f = pVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.a.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.a.a(view, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.a.e();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.a.f();
    }

    public final void a(View view) {
        this.a.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.a.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.a.c(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.a.a(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.a.b(view);
    }

    public void setNoData(String str) {
        if (this.p != null) {
            removeHeaderView(this.p);
            this.p = null;
        }
        if (str != null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            setNoData(textView);
        }
    }

    public void setNoData(View view) {
        addHeaderView(view, null, false);
    }

    public void setPrePage(e eVar) {
        if (this.n != null) {
            removeHeaderView(this.n.b());
            this.n = null;
        }
        if (eVar != null) {
            addHeaderView(eVar.b());
            this.n = eVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(e eVar) {
        if (this.o != null) {
            removeFooterView(this.o.b());
            this.o = null;
        }
        if (eVar != null) {
            this.a.b(eVar.b(), null, true, 0);
            this.o = eVar;
        }
    }

    private int getHeaderIndex() {
        if (this.n != null) {
            return this.a.c() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.r);
            getHandler().removeCallbacks(this.y);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(BdListView.class.getSimpleName(), "onDetachedFromWindow", e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.u = z;
    }

    public void setOnkbdStateListener(r rVar) {
        this.x = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (!this.s) {
                this.s = true;
                this.v = i4;
                if (this.x != null) {
                    r rVar = this.x;
                }
            } else {
                this.v = this.v < i4 ? i4 : this.v;
            }
            if (this.s && this.v > i4 && i4 != this.w) {
                this.t = true;
                if (this.x != null) {
                    r rVar2 = this.x;
                }
                if (this.u && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.y, 1L);
                }
            }
            if (this.s && this.t && this.v == i4) {
                this.t = false;
                if (this.x != null) {
                    r rVar3 = this.x;
                }
            }
            this.w = i4;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setPullRefresh(f fVar) {
        if (this.z != null) {
            removeHeaderView(this.z.a().h());
        }
        this.z = null;
        if (fVar != null) {
            this.z = new w(this, fVar);
            this.z.a(this.i);
        }
    }

    public final void b() {
        if (this.z != null) {
            w.a(this.z);
        }
    }

    public final void c() {
        if (this.z != null) {
            setSelection(0);
            this.z.a(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.z != null) {
            this.z.a(motionEvent, this.q);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.z != null) {
            this.z.b(motionEvent, this.q);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return false;
        }
    }
}
