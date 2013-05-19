package com.baidu.adp.widget.ListView;

import android.content.Context;
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
    private e a;
    private AdapterView.OnItemClickListener b;
    private AdapterView.OnItemLongClickListener c;
    private AdapterView.OnItemSelectedListener d;
    private o e;
    private n f;
    private AbsListView.OnScrollListener g;
    private q h;
    private long i;
    private s j;
    private r k;
    private c l;
    private c m;
    private View n;
    private int o;
    private Runnable p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private p v;
    private Runnable w;
    private t x;

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
        this.i = 100L;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = 0;
        this.p = new h(this);
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = 0;
        this.v = null;
        this.w = new i(this);
        this.x = null;
        b();
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
        this.i = 100L;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = 0;
        this.p = new h(this);
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = 0;
        this.v = null;
        this.w = new i(this);
        this.x = null;
        b();
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
        this.i = 100L;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = 0;
        this.p = new h(this);
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = 0;
        this.v = null;
        this.w = new i(this);
        this.x = null;
        b();
    }

    private void b() {
        this.a = new e(getContext());
        super.setOnItemClickListener(new j(this));
        super.setOnScrollListener(new k(this));
    }

    public void setOnSrollToTopListener(s sVar) {
        this.j = sVar;
    }

    public void setOnSrollToBottomListener(r rVar) {
        this.k = rVar;
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
        return this.a;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        this.a.a(listAdapter);
        super.setAdapter((ListAdapter) this.a);
    }

    public void setOnHeaderClickListener(o oVar) {
        this.e = oVar;
    }

    public void setOnFooterClickListener(n nVar) {
        this.f = nVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.a.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.a.a(view, getHeaderIndex());
    }

    public void a(View view) {
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
        if (this.n != null) {
            removeHeaderView(this.n);
            this.n = null;
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
        if (this.l != null) {
            removeHeaderView(this.l.b());
            this.l = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.b());
            this.l = cVar;
        }
    }

    public void setNextPage(c cVar) {
        if (this.m != null) {
            removeFooterView(this.m.b());
            this.m = null;
        }
        if (cVar != null) {
            this.a.b(cVar.b(), null, true, 0);
            this.m = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.l != null) {
            return this.a.c() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getHandler().removeCallbacks(this.p);
        getHandler().removeCallbacks(this.w);
    }

    public void setKybdsScrollBottom(boolean z) {
        this.s = z;
    }

    public void setOnkbdStateListener(p pVar) {
        this.v = pVar;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        super.onLayout(z, i, i2, i3, i4);
        if (!this.q) {
            this.q = true;
            this.t = i4;
            if (this.v != null) {
                this.v.a(-1);
            }
        } else {
            this.t = this.t < i4 ? i4 : this.t;
        }
        if (this.q && this.t > i4 && i4 != this.u) {
            this.r = true;
            if (this.v != null) {
                this.v.a(-3);
            }
            if (this.s && lastVisiblePosition >= getCount() - 1) {
                getHandler().postDelayed(this.w, 1L);
            }
        }
        if (this.q && this.r && this.t == i4) {
            this.r = false;
            if (this.v != null) {
                this.v.a(-2);
            }
        }
        this.u = i4;
    }

    public void setPullRefresh(d dVar) {
        if (this.x != null) {
            removeHeaderView(this.x.a().f());
        }
        this.x = null;
        if (dVar != null) {
            this.x = new t(this, dVar);
        }
    }

    public void a() {
        if (this.x != null) {
            this.x.b();
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.x != null) {
            this.x.a(motionEvent, this.o);
        }
        return super.onTouchEvent(motionEvent);
    }
}
