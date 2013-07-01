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

    /* renamed from: a  reason: collision with root package name */
    private e f199a;
    private AdapterView.OnItemClickListener b;
    private AdapterView.OnItemLongClickListener c;
    private AdapterView.OnItemSelectedListener d;
    private o e;
    private n f;
    private AbsListView.OnScrollListener g;
    private q h;
    private long i;
    private s j;
    private int k;
    private r l;
    private c m;
    private c n;
    private View o;
    private int p;
    private Runnable q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private p w;
    private Runnable x;
    private t y;

    public BdListView(Context context) {
        super(context);
        this.f199a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 100L;
        this.j = null;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = 0;
        this.q = new h(this);
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = null;
        this.x = new i(this);
        this.y = null;
        b();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f199a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 100L;
        this.j = null;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = 0;
        this.q = new h(this);
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = null;
        this.x = new i(this);
        this.y = null;
        b();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f199a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 100L;
        this.j = null;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = 0;
        this.q = new h(this);
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = null;
        this.x = new i(this);
        this.y = null;
        b();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            com.baidu.adp.lib.c.b.a(e.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    private void b() {
        this.f199a = new e(getContext());
        super.setOnItemClickListener(new j(this));
        super.setOnScrollListener(new k(this));
    }

    public void setOnSrollToTopListener(s sVar) {
        this.j = sVar;
    }

    public void setOnSrollToBottomListener(r rVar) {
        this.l = rVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.c = onItemLongClickListener;
        super.setOnItemLongClickListener(new l(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.d = onItemSelectedListener;
        super.setOnItemSelectedListener(new m(this));
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
        return this.f199a;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        this.f199a.a(listAdapter);
        super.setAdapter((ListAdapter) this.f199a);
    }

    public void setOnHeaderClickListener(o oVar) {
        this.e = oVar;
    }

    public void setOnFooterClickListener(n nVar) {
        this.f = nVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.f199a.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.f199a.a(view, getHeaderIndex());
    }

    public void a(View view) {
        this.f199a.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.f199a.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.f199a.c(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.f199a.a(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.f199a.b(view);
    }

    public void setNoData(String str) {
        if (this.o != null) {
            removeHeaderView(this.o);
            this.o = null;
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

    public void setPrePage(c cVar) {
        if (this.m != null) {
            removeHeaderView(this.m.b());
            this.m = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.b());
            this.m = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(c cVar) {
        if (this.n != null) {
            removeFooterView(this.n.b());
            this.n = null;
        }
        if (cVar != null) {
            this.f199a.b(cVar.b(), null, true, 0);
            this.n = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.m != null) {
            return this.f199a.c() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.q);
            getHandler().removeCallbacks(this.x);
        } catch (NullPointerException e) {
            com.baidu.adp.lib.c.b.b(BdListView.class.getSimpleName(), "onDetachedFromWindow", e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.t = z;
    }

    public void setOnkbdStateListener(p pVar) {
        this.w = pVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (!this.r) {
                this.r = true;
                this.u = i4;
                if (this.w != null) {
                    this.w.a(-1);
                }
            } else {
                this.u = this.u < i4 ? i4 : this.u;
            }
            if (this.r && this.u > i4 && i4 != this.v) {
                this.s = true;
                if (this.w != null) {
                    this.w.a(-3);
                }
                if (this.t && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.x, 1L);
                }
            }
            if (this.r && this.s && this.u == i4) {
                this.s = false;
                if (this.w != null) {
                    this.w.a(-2);
                }
            }
            this.v = i4;
        } catch (Throwable th) {
            com.baidu.adp.lib.c.b.a(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setPullRefresh(d dVar) {
        if (this.y != null) {
            removeHeaderView(this.y.a().f());
        }
        this.y = null;
        if (dVar != null) {
            this.y = new t(this, dVar);
        }
    }

    public void a() {
        if (this.y != null) {
            this.y.b();
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.y != null) {
            this.y.a(motionEvent, this.p);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.y != null) {
            this.y.b(motionEvent, this.p);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            com.baidu.adp.lib.c.b.a(e.getMessage());
            return false;
        }
    }
}
