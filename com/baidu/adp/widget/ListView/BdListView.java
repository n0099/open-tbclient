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
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class BdListView extends ListView {
    private v A;
    private Runnable B;
    private aa C;
    private final int a;
    private g b;
    private AdapterView.OnItemClickListener c;
    private AdapterView.OnItemLongClickListener d;
    private AdapterView.OnItemSelectedListener e;
    private u f;
    private t g;
    private AbsListView.OnScrollListener h;
    private w i;
    private y j;
    private long k;
    private z l;
    private int m;
    private x n;
    private e o;
    private e p;
    private View q;
    private int r;
    private Runnable s;
    private Runnable t;
    private Runnable u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    public BdListView(Context context) {
        super(context);
        this.a = 100;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 100L;
        this.l = null;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = new k(this);
        this.t = new l(this);
        this.u = new m(this);
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = new n(this);
        this.C = null;
        a();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 100;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 100L;
        this.l = null;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = new k(this);
        this.t = new l(this);
        this.u = new m(this);
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = new n(this);
        this.C = null;
        a();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 100;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 100L;
        this.l = null;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = new k(this);
        this.t = new l(this);
        this.u = new m(this);
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = new n(this);
        this.C = null;
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            BdLog.e(e.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void c() {
        removeCallbacks(this.t);
    }

    private void a() {
        setFadingEdgeLength(0);
        this.b = new g(getContext());
        this.b.a(new o(this));
        super.setOnItemClickListener(new p(this));
        super.setOnScrollListener(new q(this));
    }

    public void setOnScrollToPullListener(y yVar) {
        this.j = yVar;
    }

    public void setOnSrollToTopListener(z zVar) {
        this.l = zVar;
    }

    public void setOnSrollToBottomListener(x xVar) {
        this.n = xVar;
    }

    public void a(w wVar, long j) {
        this.i = wVar;
        this.k = j;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.d = onItemLongClickListener;
        super.setOnItemLongClickListener(new r(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.e = onItemSelectedListener;
        super.setOnItemSelectedListener(new s(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.h = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.c = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.b;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.b instanceof g) {
            return this.b.b();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.b.a(listAdapter);
        super.setAdapter((ListAdapter) this.b);
    }

    public void setOnHeaderClickListener(u uVar) {
        this.f = uVar;
    }

    public void setOnFooterClickListener(t tVar) {
        this.g = tVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.b.a(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.b.a(view, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.b.e();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.b.f();
    }

    public void a(View view) {
        this.b.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.b.b(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.b.c(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.b.a(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.b.b(view);
    }

    public void setNoData(String str) {
        if (this.q != null) {
            removeHeaderView(this.q);
            this.q = null;
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
        if (this.o != null) {
            removeHeaderView(this.o.b());
            this.o = null;
        }
        if (eVar != null) {
            addHeaderView(eVar.b());
            this.o = eVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(e eVar) {
        if (this.p != null) {
            removeFooterView(this.p.b());
            this.p = null;
        }
        if (eVar != null) {
            this.b.b(eVar.b(), null, true, 0);
            this.p = eVar;
        }
    }

    private int getHeaderIndex() {
        if (this.o != null) {
            return this.b.c() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.s);
            getHandler().removeCallbacks(this.B);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.x = z;
    }

    public void setOnkbdStateListener(v vVar) {
        this.A = vVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (!this.v) {
                this.v = true;
                this.y = i4;
                if (this.A != null) {
                    this.A.a(-1);
                }
            } else {
                this.y = this.y < i4 ? i4 : this.y;
            }
            if (this.v && this.y > i4 && i4 != this.z) {
                this.w = true;
                if (this.A != null) {
                    this.A.a(-3);
                }
                if (this.x && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.B, 1L);
                }
            }
            if (this.v && this.w && this.y == i4) {
                this.w = false;
                if (this.A != null) {
                    this.A.a(-2);
                }
            }
            this.z = i4;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setPullRefresh(f fVar) {
        if (this.C != null) {
            removeHeaderView(this.C.a().i());
        }
        this.C = null;
        if (fVar != null) {
            this.C = new aa(this, fVar);
            this.C.a(this.j);
        }
    }

    public void d() {
        if (this.C != null) {
            aa.a(this.C);
        }
    }

    public void e() {
        if (this.C != null) {
            setSelection(0);
            this.C.a(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.C != null) {
            this.C.a(motionEvent, this.r);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.C != null) {
            this.C.b(motionEvent, this.r);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }
}
