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
    private e a;
    private AdapterView.OnItemClickListener b;
    private AdapterView.OnItemLongClickListener c;
    private AdapterView.OnItemSelectedListener d;
    private o e;
    private n f;
    private AbsListView.OnScrollListener g;
    private q h;
    private s i;
    private long j;
    private t k;
    private int l;
    private r m;
    private c n;
    private c o;
    private View p;
    private int q;
    private Runnable r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private p x;
    private Runnable y;
    private u z;

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
        this.r = new h(this);
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = new m(this);
        this.z = null;
        c();
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
        this.r = new h(this);
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = new m(this);
        this.z = null;
        c();
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
        this.r = new h(this);
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = new m(this);
        this.z = null;
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            com.baidu.adp.lib.g.e.a(e.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    private void c() {
        this.a = new e(getContext());
        super.setOnItemClickListener(new i(this));
        super.setOnScrollListener(new j(this));
    }

    public void setOnScrollToPullListener(s sVar) {
        this.i = sVar;
    }

    public void setOnSrollToTopListener(t tVar) {
        this.k = tVar;
    }

    public void setOnSrollToBottomListener(r rVar) {
        this.m = rVar;
    }

    public void a(q qVar, long j) {
        this.h = qVar;
        this.j = j;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.c = onItemLongClickListener;
        super.setOnItemLongClickListener(new k(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.d = onItemSelectedListener;
        super.setOnItemSelectedListener(new l(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.g = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.a;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.a instanceof e) {
            return this.a.b();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
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

    public void setPrePage(c cVar) {
        if (this.n != null) {
            removeHeaderView(this.n.b());
            this.n = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.b());
            this.n = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(c cVar) {
        if (this.o != null) {
            removeFooterView(this.o.b());
            this.o = null;
        }
        if (cVar != null) {
            this.a.b(cVar.b(), null, true, 0);
            this.o = cVar;
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
            com.baidu.adp.lib.g.e.b(BdListView.class.getSimpleName(), "onDetachedFromWindow", e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.u = z;
    }

    public void setOnkbdStateListener(p pVar) {
        this.x = pVar;
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
                    this.x.a(-1);
                }
            } else {
                this.v = this.v < i4 ? i4 : this.v;
            }
            if (this.s && this.v > i4 && i4 != this.w) {
                this.t = true;
                if (this.x != null) {
                    this.x.a(-3);
                }
                if (this.u && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.y, 1L);
                }
            }
            if (this.s && this.t && this.v == i4) {
                this.t = false;
                if (this.x != null) {
                    this.x.a(-2);
                }
            }
            this.w = i4;
        } catch (Throwable th) {
            com.baidu.adp.lib.g.e.a(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setPullRefresh(d dVar) {
        if (this.z != null) {
            removeHeaderView(this.z.a().i());
        }
        this.z = null;
        if (dVar != null) {
            this.z = new u(this, dVar);
            this.z.a(this.i);
        }
    }

    public void a() {
        if (this.z != null) {
            u.a(this.z);
        }
    }

    public void b() {
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
            com.baidu.adp.lib.g.e.a(e.getMessage());
            return false;
        }
    }
}
